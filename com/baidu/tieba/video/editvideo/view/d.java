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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private MediaPlayer gKL;
    private a gLr;
    private HorizontalListView gOi;
    private com.baidu.tieba.video.editvideo.a.c gOm;
    private LinearLayout gOn;
    private ImageView gOo;
    private TextView gOp;
    private boolean gOq;
    private String gOr;
    private int gOs;
    private int gOt;
    private int gOu;
    private boolean gOv;
    private String gOw;
    private boolean gOx;
    private h gxw;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.gOq = true;
        this.gOs = 1;
        this.gLr = aVar;
        this.gxw = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gOi = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gOm = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.gOi.setAdapter((ListAdapter) this.gOm);
        this.gOi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (d.this.gOm.bwv() != i || i == d.this.gOs) {
                    d.this.gOt = i;
                    d.this.h(i, view2);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
    }

    public boolean bxm() {
        return !TextUtils.isEmpty(this.gOw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view2) {
        MusicData musicData = (MusicData) this.gOm.getItem(i);
        if (musicData != null) {
            al alVar = new al("c12423");
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            alVar.r("obj_locate", i + 1);
            alVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(alVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view2, musicData);
                    return;
                case 1:
                    this.gOm.uo(i);
                    bgx();
                    this.gLr.replay();
                    return;
                case 2:
                    this.gOs = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cj(String str, String str2) {
        this.gOv = false;
        this.gOt = this.gOs;
        this.gOw = str2;
        aN(str, this.gOs);
    }

    private void a(final int i, View view2, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gOw = musicData.id;
            this.gLr.bwu();
            String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(musicData.resource);
            if (TextUtils.isEmpty(tU)) {
                if (view2 != null) {
                    final c.a aVar = (c.a) view2.getTag();
                    aVar.gKU.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bwN().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void ci(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gKU.setVisibility(4);
                            d.this.aN(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void tL(String str) {
                            aVar.gKU.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gxw != null) {
                                d.this.gxw.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void bwb() {
                            aVar.gKU.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bwN().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aN(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tL(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gxw != null) {
                            d.this.gxw.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bwb() {
                    }
                });
                return;
            }
            aN(tU, i);
        }
    }

    public void replay() {
        this.gOv = false;
        if (this.gKL != null && this.gKL.isPlaying()) {
            this.gKL.pause();
        }
        if (this.gKL != null) {
            this.gKL.start();
            this.gKL.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, final int i) {
        this.gOu = i;
        if (this.gOt == this.gOu && !this.gOv) {
            if (this.gKL == null) {
                this.gKL = new MediaPlayer();
                this.gKL.setAudioStreamType(3);
            }
            try {
                this.gOr = str;
                this.gKL.reset();
                this.gKL.setDataSource(str);
                this.gKL.prepare();
                this.gKL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.gOm.uo(i);
                        d.this.gKL.setLooping(true);
                        d.this.gKL.start();
                        d.this.gLr.replay();
                    }
                });
                this.gKL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gxw != null) {
                            d.this.gxw.ae(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aO(str, i);
                if (this.gxw != null) {
                    this.gxw.ae(208, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    private void aO(String str, int i) {
        this.gOr = null;
        bgx();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bwN().bwO();
        }
        a(i, this.gOi.getChildCount() > i ? this.gOi.getChildAt(i) : null, (MusicData) this.gOm.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gOm.setData(list);
        if (this.gOm != null) {
            this.gOu = this.gOm.bwv();
            this.gOt = this.gOu;
        }
    }

    public String bxk() {
        return this.gOr;
    }

    public String bxl() {
        return this.gOw;
    }

    public void by(View view2) {
        this.gOn = (LinearLayout) view2.findViewById(d.g.video_voice_layout);
        this.gOo = (ImageView) view2.findViewById(d.g.video_voice_img);
        this.gOp = (TextView) view2.findViewById(d.g.video_voice_text);
        this.gOn.setVisibility(8);
        this.gOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                d.this.gOq = !d.this.gOq;
                if (d.this.gOq) {
                    d.this.gOo.setSelected(false);
                    d.this.gOp.setText(d.this.mResources.getString(d.k.video_voice_open));
                } else {
                    d.this.gOo.setSelected(true);
                    d.this.gOp.setText(d.this.mResources.getString(d.k.video_voice_close));
                }
                d.this.gLr.setMute(!d.this.gOq);
                d.this.replay();
                al alVar = new al("c12423");
                alVar.r("obj_type", d.this.gOq ? 0 : 1);
                TiebaStatic.log(alVar);
            }
        });
        if (this.gOq) {
            this.gOo.setSelected(false);
            this.gOp.setText(this.mResources.getString(d.k.video_voice_open));
            return;
        }
        this.gOo.setSelected(true);
        this.gOp.setText(this.mResources.getString(d.k.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mS(boolean z) {
        if (z) {
            this.gOn.setVisibility(0);
            if (this.gOx && this.gKL == null && !TextUtils.isEmpty(this.gOr)) {
                aN(this.gOr, this.gOu);
                this.gOx = false;
                if (this.gOu > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.gOi.setSelection(d.this.gOu);
                            d.this.gOi.dg(d.this.gOt * l.e(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.gOn.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gOv = true;
        if (this.gKL != null && this.gKL.isPlaying()) {
            this.gKL.pause();
        }
    }

    public void onResume() {
        this.gOv = false;
        if (this.gKL != null && this.gLr.mCurrentTabIndex == 2) {
            this.gKL.start();
            this.gKL.seekTo(0);
        }
    }

    private void bgx() {
        if (this.gKL != null) {
            if (this.gKL.isPlaying()) {
                this.gKL.stop();
            }
            this.gKL.release();
            this.gKL = null;
        }
        this.gOr = null;
        this.gOw = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gOx = true;
            this.gOw = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gOr = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gOm != null) {
                this.gOm.tR(this.gOw);
                this.gOu = this.gOm.bwv();
                this.gOs = this.gOu;
                this.gOt = this.gOu;
            }
        }
    }
}
