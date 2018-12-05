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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private MediaPlayer hAK;
    private a hBp;
    private HorizontalListView hEg;
    private com.baidu.tieba.video.editvideo.a.c hEk;
    private LinearLayout hEl;
    private ImageView hEm;
    private TextView hEn;
    private boolean hEo;
    private String hEp;
    private int hEq;
    private int hEr;
    private int hEs;
    private boolean hEt;
    private String hEu;
    private boolean hEv;
    private h hms;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hEo = true;
        this.hEq = 1;
        this.hBp = aVar;
        this.hms = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hEg = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hEk = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hEg.setAdapter((ListAdapter) this.hEk);
        this.hEg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hEk.bIu() != i || i == d.this.hEq) {
                    d.this.hEr = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bJl() {
        return !TextUtils.isEmpty(this.hEu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hEk.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.x("obj_locate", i + 1);
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hEk.wt(i);
                    UJ();
                    this.hBp.replay();
                    return;
                case 2:
                    this.hEq = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cS(String str, String str2) {
        this.hEt = false;
        this.hEr = this.hEq;
        this.hEu = str2;
        aX(str, this.hEq);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hEu = musicData.id;
            this.hBp.bIt();
            String wH = com.baidu.tieba.video.editvideo.model.a.bIM().wH(musicData.resource);
            if (TextUtils.isEmpty(wH)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hAT.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bIM().a(musicData.id, musicData.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void cR(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hAT.setVisibility(4);
                            d.this.aX(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void wz(String str) {
                            aVar.hAT.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hms != null) {
                                d.this.hms.Z(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void bIa() {
                            aVar.hAT.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bIM().a(musicData.id, musicData.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void cR(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aX(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void wz(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hms != null) {
                            d.this.hms.Z(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void bIa() {
                    }
                });
                return;
            }
            aX(wH, i);
        }
    }

    public void replay() {
        this.hEt = false;
        if (this.hAK != null && this.hAK.isPlaying()) {
            this.hAK.pause();
        }
        if (this.hAK != null) {
            this.hAK.start();
            this.hAK.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, final int i) {
        this.hEs = i;
        if (this.hEr == this.hEs && !this.hEt) {
            if (this.hAK == null) {
                this.hAK = new MediaPlayer();
                this.hAK.setAudioStreamType(3);
            }
            try {
                this.hEp = str;
                this.hAK.reset();
                this.hAK.setDataSource(str);
                this.hAK.prepare();
                this.hAK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hEk.wt(i);
                        d.this.hAK.setLooping(true);
                        d.this.hAK.start();
                        d.this.hBp.replay();
                    }
                });
                this.hAK.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hms != null) {
                            d.this.hms.Z(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aY(str, i);
                if (this.hms != null) {
                    this.hms.Z(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aY(String str, int i) {
        this.hEp = null;
        UJ();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bIM().bIN();
        }
        a(i, this.hEg.getChildCount() > i ? this.hEg.getChildAt(i) : null, (MusicData) this.hEk.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hEk.setData(list);
        if (this.hEk != null) {
            this.hEs = this.hEk.bIu();
            this.hEr = this.hEs;
        }
    }

    public String bJj() {
        return this.hEp;
    }

    public String bJk() {
        return this.hEu;
    }

    public void bU(View view) {
        this.hEl = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hEm = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hEn = (TextView) view.findViewById(e.g.video_voice_text);
        this.hEl.setVisibility(8);
        this.hEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hEo = !d.this.hEo;
                if (d.this.hEo) {
                    d.this.hEm.setSelected(false);
                    d.this.hEn.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hEm.setSelected(true);
                    d.this.hEn.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hBp.setMute(!d.this.hEo);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.x("obj_type", d.this.hEo ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hEo) {
            this.hEm.setSelected(false);
            this.hEn.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hEm.setSelected(true);
        this.hEn.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nX(boolean z) {
        if (z) {
            this.hEl.setVisibility(0);
            if (this.hEv && this.hAK == null && !TextUtils.isEmpty(this.hEp)) {
                aX(this.hEp, this.hEs);
                this.hEv = false;
                if (this.hEs > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hEg.setSelection(d.this.hEs);
                            d.this.hEg.scrollTo(d.this.hEr * l.h(d.this.getPageContext().getContext(), e.C0210e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hEl.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hEt = true;
        if (this.hAK != null && this.hAK.isPlaying()) {
            this.hAK.pause();
        }
    }

    public void onResume() {
        this.hEt = false;
        if (this.hAK != null && this.hBp.mCurrentTabIndex == 2) {
            this.hAK.start();
            this.hAK.seekTo(0);
        }
    }

    private void UJ() {
        if (this.hAK != null) {
            if (this.hAK.isPlaying()) {
                this.hAK.stop();
            }
            this.hAK.release();
            this.hAK = null;
        }
        this.hEp = null;
        this.hEu = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hEv = true;
            this.hEu = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hEp = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hEk != null) {
                this.hEk.wF(this.hEu);
                this.hEs = this.hEk.bIu();
                this.hEq = this.hEs;
                this.hEr = this.hEs;
            }
        }
    }
}
