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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private Resources fXC;
    private h gAg;
    private MediaPlayer gNO;
    private a gOv;
    private String gRA;
    private boolean gRB;
    private HorizontalListView gRm;
    private com.baidu.tieba.video.editvideo.a.c gRq;
    private LinearLayout gRr;
    private ImageView gRs;
    private TextView gRt;
    private boolean gRu;
    private String gRv;
    private int gRw;
    private int gRx;
    private int gRy;
    private boolean gRz;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.gRu = true;
        this.gRw = 1;
        this.gOv = aVar;
        this.gAg = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.fXC = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gRm = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gRq = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.gRm.setAdapter((ListAdapter) this.gRq);
        this.gRm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.gRq.bAZ() != i || i == d.this.gRw) {
                    d.this.gRx = i;
                    d.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0082d.cp_bg_line_d);
    }

    public boolean bBS() {
        return this.gNO != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.gRq.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ac("obj_id", musicData.id);
            akVar.r("obj_locate", i + 1);
            akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.gRq.vi(i);
                    bjf();
                    this.gOv.bBK();
                    return;
                case 2:
                    this.gRw = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cn(String str, String str2) {
        this.gRz = false;
        this.gRx = this.gRw;
        this.gRA = str2;
        aI(str, this.gRw);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gRA = musicData.id;
            this.gOv.bAY();
            String ua = com.baidu.tieba.video.editvideo.model.a.bBs().ua(musicData.resource);
            if (TextUtils.isEmpty(ua)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.gNY.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBs().a(musicData.id, musicData.resource, new a.InterfaceC0133a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                        public void cm(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gNY.setVisibility(4);
                            d.this.aI(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                        public void tR(String str) {
                            aVar.gNY.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gAg != null) {
                                d.this.gAg.S(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                        public void bAF() {
                            aVar.gNY.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBs().a(musicData.id, musicData.resource, new a.InterfaceC0133a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void cm(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aI(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void tR(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gAg != null) {
                            d.this.gAg.S(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void bAF() {
                    }
                });
                return;
            }
            aI(ua, i);
        }
    }

    public void bBK() {
        this.gRz = false;
        if (this.gNO != null && this.gNO.isPlaying()) {
            this.gNO.pause();
        }
        if (this.gNO != null) {
            this.gNO.start();
            this.gNO.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, final int i) {
        this.gRy = i;
        if (this.gRx == this.gRy && !this.gRz) {
            if (this.gNO == null) {
                this.gNO = new MediaPlayer();
                this.gNO.setAudioStreamType(3);
            }
            try {
                this.gRv = str;
                this.gNO.reset();
                this.gNO.setDataSource(str);
                this.gNO.prepare();
                this.gNO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.gRq.vi(i);
                        d.this.gNO.setLooping(true);
                        d.this.gNO.start();
                        d.this.gOv.bBK();
                    }
                });
                this.gNO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gAg != null) {
                            d.this.gAg.S(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aJ(str, i);
                if (this.gAg != null) {
                    this.gAg.S(208, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    private void aJ(String str, int i) {
        this.gRv = null;
        bjf();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBs().bBt();
        }
        a(i, this.gRm.getChildCount() > i ? this.gRm.getChildAt(i) : null, (MusicData) this.gRq.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gRq.setData(list);
        if (this.gRq != null) {
            this.gRy = this.gRq.bAZ();
            this.gRx = this.gRy;
        }
    }

    public String bBQ() {
        return this.gRv;
    }

    public String bBR() {
        return this.gRA;
    }

    public void bI(View view) {
        this.gRr = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.gRs = (ImageView) view.findViewById(d.g.video_voice_img);
        this.gRt = (TextView) view.findViewById(d.g.video_voice_text);
        this.gRr.setVisibility(8);
        this.gRr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.gRu = !d.this.gRu;
                if (d.this.gRu) {
                    d.this.gRs.setSelected(false);
                    d.this.gRt.setText(d.this.fXC.getString(d.j.video_voice_open));
                } else {
                    d.this.gRs.setSelected(true);
                    d.this.gRt.setText(d.this.fXC.getString(d.j.video_voice_close));
                }
                d.this.gOv.setMute(!d.this.gRu);
                d.this.bBK();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", d.this.gRu ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gRu) {
            this.gRs.setSelected(false);
            this.gRt.setText(this.fXC.getString(d.j.video_voice_open));
            return;
        }
        this.gRs.setSelected(true);
        this.gRt.setText(this.fXC.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nD(boolean z) {
        if (z) {
            this.gRr.setVisibility(0);
            if (this.gRB && this.gNO == null && !TextUtils.isEmpty(this.gRv)) {
                aI(this.gRv, this.gRy);
                this.gRB = false;
                if (this.gRy > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.gRm.setSelection(d.this.gRy);
                            d.this.gRm.dh(d.this.gRx * l.f(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            bBK();
            return;
        }
        this.gRr.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gRz = true;
        if (this.gNO != null && this.gNO.isPlaying()) {
            this.gNO.pause();
        }
    }

    public void onResume() {
        this.gRz = false;
        if (this.gNO != null && this.gOv.mCurrentTabIndex == 2) {
            this.gNO.start();
            this.gNO.seekTo(0);
        }
    }

    private void bjf() {
        if (this.gNO != null) {
            if (this.gNO.isPlaying()) {
                this.gNO.stop();
            }
            this.gNO.release();
            this.gNO = null;
        }
        this.gRv = null;
        this.gRA = null;
    }

    public void ad(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gRB = true;
            this.gRA = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gRv = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gRq != null) {
                this.gRq.tX(this.gRA);
                this.gRy = this.gRq.bAZ();
                this.gRw = this.gRy;
                this.gRx = this.gRy;
            }
        }
    }
}
