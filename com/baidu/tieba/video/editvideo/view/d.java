package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.base.c {
    private MediaPlayer lAD;
    private a lBj;
    private HorizontalListView lDT;
    private com.baidu.tieba.video.editvideo.a.c lDX;
    private LinearLayout lDY;
    private ImageView lDZ;
    private TextView lEa;
    private boolean lEb;
    private String lEc;
    private int lEd;
    private int lEe;
    private int lEf;
    private boolean lEg;
    private String lEh;
    private boolean lEi;
    private h lmg;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.lEb = true;
        this.lEd = 1;
        this.lBj = aVar;
        this.lmg = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lDT = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.lDX = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.lDT.setAdapter((ListAdapter) this.lDX);
        this.lDT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.lDX.din() != i || i == d.this.lEd) {
                    d.this.lEe = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean diZ() {
        return !TextUtils.isEmpty(this.lEh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.lDX.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.dh("obj_id", musicData.id);
            anVar.ag("obj_locate", i + 1);
            anVar.ag("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.lDX.EV(i);
                    aJz();
                    this.lBj.replay();
                    return;
                case 2:
                    this.lEd = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void fy(String str, String str2) {
        this.lEg = false;
        this.lEe = this.lEd;
        this.lEh = str2;
        bI(str, this.lEd);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.lEh = musicData.id;
            this.lBj.dil();
            String NB = com.baidu.tieba.video.editvideo.model.a.diC().NB(musicData.resource);
            if (TextUtils.isEmpty(NB)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.lAM.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.diC().a(musicData.id, musicData.resource, new a.InterfaceC0736a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                        public void fx(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.lAM.setVisibility(4);
                            d.this.bI(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                        public void Nt(String str) {
                            aVar.lAM.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.lmg != null) {
                                d.this.lmg.bl(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                        public void dhT() {
                            aVar.lAM.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.diC().a(musicData.id, musicData.resource, new a.InterfaceC0736a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                    public void fx(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bI(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                    public void Nt(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.lmg != null) {
                            d.this.lmg.bl(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                    public void dhT() {
                    }
                });
                return;
            }
            bI(NB, i);
        }
    }

    public void replay() {
        this.lEg = false;
        if (this.lAD != null && this.lAD.isPlaying()) {
            this.lAD.pause();
        }
        if (this.lAD != null) {
            this.lAD.start();
            this.lAD.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, final int i) {
        this.lEf = i;
        if (this.lEe == this.lEf && !this.lEg) {
            if (this.lAD == null) {
                this.lAD = new MediaPlayer();
                this.lAD.setAudioStreamType(3);
            }
            try {
                this.lEc = str;
                this.lAD.reset();
                this.lAD.setDataSource(str);
                this.lAD.prepare();
                this.lAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.lDX.EV(i);
                        d.this.lAD.setLooping(true);
                        d.this.lAD.start();
                        d.this.lBj.replay();
                    }
                });
                this.lAD.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.lmg != null) {
                            d.this.lmg.bl(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bJ(str, i);
                if (this.lmg != null) {
                    this.lmg.bl(208, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    private void bJ(String str, int i) {
        this.lEc = null;
        aJz();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.diC().diD();
        }
        a(i, this.lDT.getChildCount() > i ? this.lDT.getChildAt(i) : null, (MusicData) this.lDX.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.lDX.setData(list);
        if (this.lDX != null) {
            this.lEf = this.lDX.din();
            this.lEe = this.lEf;
        }
    }

    public String diX() {
        return this.lEc;
    }

    public String diY() {
        return this.lEh;
    }

    public void df(View view) {
        this.lDY = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.lDZ = (ImageView) view.findViewById(R.id.video_voice_img);
        this.lEa = (TextView) view.findViewById(R.id.video_voice_text);
        this.lDY.setVisibility(8);
        this.lDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.lEb = !d.this.lEb;
                if (d.this.lEb) {
                    d.this.lDZ.setSelected(false);
                    d.this.lEa.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.lDZ.setSelected(true);
                    d.this.lEa.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.lBj.setMute(!d.this.lEb);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.ag("obj_type", d.this.lEb ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.lEb) {
            this.lDZ.setSelected(false);
            this.lEa.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.lDZ.setSelected(true);
        this.lEa.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uT(boolean z) {
        if (z) {
            this.lDY.setVisibility(0);
            if (this.lEi && this.lAD == null && !TextUtils.isEmpty(this.lEc)) {
                bI(this.lEc, this.lEf);
                this.lEi = false;
                if (this.lEf > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lDT.setSelection(d.this.lEf);
                            d.this.lDT.scrollTo(d.this.lEe * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.lDY.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.lEg = true;
        if (this.lAD != null && this.lAD.isPlaying()) {
            this.lAD.pause();
        }
    }

    public void onResume() {
        this.lEg = false;
        if (this.lAD != null && this.lBj.mCurrentTabIndex == 2) {
            this.lAD.start();
            this.lAD.seekTo(0);
        }
    }

    private void aJz() {
        if (this.lAD != null) {
            if (this.lAD.isPlaying()) {
                this.lAD.stop();
            }
            this.lAD.release();
            this.lAD = null;
        }
        this.lEc = null;
        this.lEh = null;
    }

    public void ak(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.lEi = true;
            this.lEh = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.lEc = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.lDX != null) {
                this.lDX.Nz(this.lEh);
                this.lEf = this.lDX.din();
                this.lEd = this.lEf;
                this.lEe = this.lEf;
            }
        }
    }
}
