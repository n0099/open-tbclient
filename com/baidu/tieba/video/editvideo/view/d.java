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
    private h khL;
    private MediaPlayer kvH;
    private a kwm;
    private HorizontalListView kyR;
    private com.baidu.tieba.video.editvideo.a.c kyV;
    private LinearLayout kyW;
    private ImageView kyX;
    private TextView kyY;
    private boolean kyZ;
    private String kza;
    private int kzb;
    private int kzc;
    private int kzd;
    private boolean kze;
    private String kzf;
    private boolean kzg;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kyZ = true;
        this.kzb = 1;
        this.kwm = aVar;
        this.khL = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kyR = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kyV = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kyR.setAdapter((ListAdapter) this.kyV);
        this.kyR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kyV.cPI() != i || i == d.this.kzb) {
                    d.this.kzc = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cQt() {
        return !TextUtils.isEmpty(this.kzf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kyV.getItem(i);
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
                    this.kyV.Dy(i);
                    aWA();
                    this.kwm.replay();
                    return;
                case 2:
                    this.kzb = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eK(String str, String str2) {
        this.kze = false;
        this.kzc = this.kzb;
        this.kzf = str2;
        bx(str, this.kzb);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kzf = musicData.id;
            this.kwm.cPG();
            String Ka = com.baidu.tieba.video.editvideo.model.a.cPW().Ka(musicData.resource);
            if (TextUtils.isEmpty(Ka)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.kvQ.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cPW().a(musicData.id, musicData.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void eJ(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.kvQ.setVisibility(4);
                            d.this.bx(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void JT(String str) {
                            aVar.kvQ.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.khL != null) {
                                d.this.khL.aR(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void cPo() {
                            aVar.kvQ.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cPW().a(musicData.id, musicData.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
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
                        if (d.this.khL != null) {
                            d.this.khL.aR(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void cPo() {
                    }
                });
                return;
            }
            bx(Ka, i);
        }
    }

    public void replay() {
        this.kze = false;
        if (this.kvH != null && this.kvH.isPlaying()) {
            this.kvH.pause();
        }
        if (this.kvH != null) {
            this.kvH.start();
            this.kvH.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, final int i) {
        this.kzd = i;
        if (this.kzc == this.kzd && !this.kze) {
            if (this.kvH == null) {
                this.kvH = new MediaPlayer();
                this.kvH.setAudioStreamType(3);
            }
            try {
                this.kza = str;
                this.kvH.reset();
                this.kvH.setDataSource(str);
                this.kvH.prepare();
                this.kvH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kyV.Dy(i);
                        d.this.kvH.setLooping(true);
                        d.this.kvH.start();
                        d.this.kwm.replay();
                    }
                });
                this.kvH.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.khL != null) {
                            d.this.khL.aR(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                by(str, i);
                if (this.khL != null) {
                    this.khL.aR(208, com.baidu.tieba.k.a.q(e));
                }
            }
        }
    }

    private void by(String str, int i) {
        this.kza = null;
        aWA();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cPW().cPX();
        }
        a(i, this.kyR.getChildCount() > i ? this.kyR.getChildAt(i) : null, (MusicData) this.kyV.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kyV.setData(list);
        if (this.kyV != null) {
            this.kzd = this.kyV.cPI();
            this.kzc = this.kzd;
        }
    }

    public String cQr() {
        return this.kza;
    }

    public String cQs() {
        return this.kzf;
    }

    public void cW(View view) {
        this.kyW = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kyX = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kyY = (TextView) view.findViewById(R.id.video_voice_text);
        this.kyW.setVisibility(8);
        this.kyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kyZ = !d.this.kyZ;
                if (d.this.kyZ) {
                    d.this.kyX.setSelected(false);
                    d.this.kyY.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kyX.setSelected(true);
                    d.this.kyY.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.kwm.setMute(!d.this.kyZ);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.X("obj_type", d.this.kyZ ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kyZ) {
            this.kyX.setSelected(false);
            this.kyY.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kyX.setSelected(true);
        this.kyY.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void to(boolean z) {
        if (z) {
            this.kyW.setVisibility(0);
            if (this.kzg && this.kvH == null && !TextUtils.isEmpty(this.kza)) {
                bx(this.kza, this.kzd);
                this.kzg = false;
                if (this.kzd > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kyR.setSelection(d.this.kzd);
                            d.this.kyR.scrollTo(d.this.kzc * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kyW.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kze = true;
        if (this.kvH != null && this.kvH.isPlaying()) {
            this.kvH.pause();
        }
    }

    public void onResume() {
        this.kze = false;
        if (this.kvH != null && this.kwm.mCurrentTabIndex == 2) {
            this.kvH.start();
            this.kvH.seekTo(0);
        }
    }

    private void aWA() {
        if (this.kvH != null) {
            if (this.kvH.isPlaying()) {
                this.kvH.stop();
            }
            this.kvH.release();
            this.kvH = null;
        }
        this.kza = null;
        this.kzf = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kzg = true;
            this.kzf = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kza = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kyV != null) {
                this.kyV.JY(this.kzf);
                this.kzd = this.kyV.cPI();
                this.kzb = this.kzd;
                this.kzc = this.kzd;
            }
        }
    }
}
