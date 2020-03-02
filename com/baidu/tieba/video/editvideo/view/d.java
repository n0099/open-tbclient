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
    private h khN;
    private MediaPlayer kvJ;
    private a kwo;
    private HorizontalListView kyT;
    private com.baidu.tieba.video.editvideo.a.c kyX;
    private LinearLayout kyY;
    private ImageView kyZ;
    private TextView kza;
    private boolean kzb;
    private String kzc;
    private int kzd;
    private int kze;
    private int kzf;
    private boolean kzg;
    private String kzh;
    private boolean kzi;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kzb = true;
        this.kzd = 1;
        this.kwo = aVar;
        this.khN = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kyT = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kyX = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kyT.setAdapter((ListAdapter) this.kyX);
        this.kyT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kyX.cPK() != i || i == d.this.kzd) {
                    d.this.kze = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cQv() {
        return !TextUtils.isEmpty(this.kzh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kyX.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.cy("obj_id", musicData.id);
            anVar.X("obj_locate", i + 1);
            anVar.X("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.kyX.Dy(i);
                    aWC();
                    this.kwo.replay();
                    return;
                case 2:
                    this.kzd = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eK(String str, String str2) {
        this.kzg = false;
        this.kze = this.kzd;
        this.kzh = str2;
        bx(str, this.kzd);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kzh = musicData.id;
            this.kwo.cPI();
            String Ka = com.baidu.tieba.video.editvideo.model.a.cPY().Ka(musicData.resource);
            if (TextUtils.isEmpty(Ka)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.kvS.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cPY().a(musicData.id, musicData.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void eJ(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.kvS.setVisibility(4);
                            d.this.bx(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void JT(String str) {
                            aVar.kvS.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.khN != null) {
                                d.this.khN.aR(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void cPq() {
                            aVar.kvS.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cPY().a(musicData.id, musicData.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void eJ(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bx(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void JT(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.khN != null) {
                            d.this.khN.aR(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void cPq() {
                    }
                });
                return;
            }
            bx(Ka, i);
        }
    }

    public void replay() {
        this.kzg = false;
        if (this.kvJ != null && this.kvJ.isPlaying()) {
            this.kvJ.pause();
        }
        if (this.kvJ != null) {
            this.kvJ.start();
            this.kvJ.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, final int i) {
        this.kzf = i;
        if (this.kze == this.kzf && !this.kzg) {
            if (this.kvJ == null) {
                this.kvJ = new MediaPlayer();
                this.kvJ.setAudioStreamType(3);
            }
            try {
                this.kzc = str;
                this.kvJ.reset();
                this.kvJ.setDataSource(str);
                this.kvJ.prepare();
                this.kvJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kyX.Dy(i);
                        d.this.kvJ.setLooping(true);
                        d.this.kvJ.start();
                        d.this.kwo.replay();
                    }
                });
                this.kvJ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.khN != null) {
                            d.this.khN.aR(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                by(str, i);
                if (this.khN != null) {
                    this.khN.aR(208, com.baidu.tieba.k.a.q(e));
                }
            }
        }
    }

    private void by(String str, int i) {
        this.kzc = null;
        aWC();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cPY().cPZ();
        }
        a(i, this.kyT.getChildCount() > i ? this.kyT.getChildAt(i) : null, (MusicData) this.kyX.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kyX.setData(list);
        if (this.kyX != null) {
            this.kzf = this.kyX.cPK();
            this.kze = this.kzf;
        }
    }

    public String cQt() {
        return this.kzc;
    }

    public String cQu() {
        return this.kzh;
    }

    public void cW(View view) {
        this.kyY = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kyZ = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kza = (TextView) view.findViewById(R.id.video_voice_text);
        this.kyY.setVisibility(8);
        this.kyY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kzb = !d.this.kzb;
                if (d.this.kzb) {
                    d.this.kyZ.setSelected(false);
                    d.this.kza.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kyZ.setSelected(true);
                    d.this.kza.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.kwo.setMute(!d.this.kzb);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.X("obj_type", d.this.kzb ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kzb) {
            this.kyZ.setSelected(false);
            this.kza.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kyZ.setSelected(true);
        this.kza.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void to(boolean z) {
        if (z) {
            this.kyY.setVisibility(0);
            if (this.kzi && this.kvJ == null && !TextUtils.isEmpty(this.kzc)) {
                bx(this.kzc, this.kzf);
                this.kzi = false;
                if (this.kzf > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kyT.setSelection(d.this.kzf);
                            d.this.kyT.scrollTo(d.this.kze * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kyY.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kzg = true;
        if (this.kvJ != null && this.kvJ.isPlaying()) {
            this.kvJ.pause();
        }
    }

    public void onResume() {
        this.kzg = false;
        if (this.kvJ != null && this.kwo.mCurrentTabIndex == 2) {
            this.kvJ.start();
            this.kvJ.seekTo(0);
        }
    }

    private void aWC() {
        if (this.kvJ != null) {
            if (this.kvJ.isPlaying()) {
                this.kvJ.stop();
            }
            this.kvJ.release();
            this.kvJ = null;
        }
        this.kzc = null;
        this.kzh = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kzi = true;
            this.kzh = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kzc = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kyX != null) {
                this.kyX.JY(this.kzh);
                this.kzf = this.kyX.cPK();
                this.kzd = this.kzf;
                this.kze = this.kzf;
            }
        }
    }
}
