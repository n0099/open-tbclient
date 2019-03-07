package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.lego.card.view.a;
import com.baidu.tieba.lego.card.view.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.q;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class m {
    private String bNk;
    private QuickVideoView dbg;
    private n dbi;
    private c gFI;
    private View gIf;
    private ImageView gIi;
    private TbImageView gIj;
    private a gJf;
    private View gKD;
    ImmersiveVideoCardEx.a gKE;
    private l gKG;
    private TbPageContext<?> mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    int page;
    private boolean gKF = false;
    private boolean ehU = false;
    private TbImageView.a gKH = new TbImageView.a() { // from class: com.baidu.tieba.lego.card.view.m.1
        @Override // com.baidu.tbadk.widget.TbImageView.a
        public void L(String str, boolean z) {
            if (z && m.this.gIj != null) {
                m.this.gIj.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.a
        public void onCancel() {
        }
    };
    private SeekBar.OnSeekBarChangeListener cNV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.lego.card.view.m.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                m.this.gFI.bAP();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!m.this.gFI.bAL() && m.this.gFI.bAC() != null) {
                m.this.gFI.setStartPosition(m.this.gFI.bAC().getSeekPosition());
                m.this.gFI.startPlay(m.this.bNk);
            }
        }
    };
    private VideoControllerView.b gKI = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.m.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void lz(int i) {
            if (!m.this.bAr()) {
                m.this.gFI.uX(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.m.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!m.this.bAr() && view.getId() == m.this.gKD.getId()) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.S(m.this.mContext.getPageActivity(), m.this.mContext.getString(d.j.neterror));
                }
                if (m.this.gJf != null && m.this.dbg.isPlaying()) {
                    m.this.gJf.bAs();
                }
            }
        }
    };
    private c.b gIq = new c.b() { // from class: com.baidu.tieba.lego.card.view.m.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void qj() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void qk() {
            m.this.gJf.bAm();
        }
    };
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.lego.card.view.m.6
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            if (gVar != null) {
                m.this.gJf.bAs();
                if (m.this.gKG == null || m.this.gKG.bAS() == null || !m.this.gKG.bAS().equals(m.this.bNk) || m.this.gKG.bAT() <= 0) {
                    if (m.this.gKG != null && m.this.gKG.yd(m.this.bNk) > 0) {
                        gVar.seekTo(m.this.gKG.yd(m.this.bNk));
                        return;
                    }
                    return;
                }
                gVar.seekTo(m.this.gKG.bAT());
                m.this.gKG.yc(null);
                m.this.gKG.va(0);
            }
        }
    };
    private VideoControllerView.a gKJ = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.m.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void awL() {
            if (!m.this.bAr() && m.this.gJf != null && m.this.gIf != null) {
                if (m.this.dbg.isPlaying()) {
                    m.this.gJf.bAs();
                }
                if (m.this.gIf.getAlpha() != 1.0f) {
                    m.this.gIf.setAlpha(1.0f);
                }
                m.this.gIf.clearAnimation();
            }
        }
    };
    private a.InterfaceC0269a gHQ = new a.InterfaceC0269a() { // from class: com.baidu.tieba.lego.card.view.m.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0269a
        public void bAu() {
            if (m.this.gFI.bAL()) {
                m.this.gFI.bAN();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0269a
        public void bAv() {
            if (m.this.gFI.bAL()) {
                m.this.gFI.bAN();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0269a
        public void bAw() {
            if (m.this.gFI.bAL()) {
                m.this.gFI.bAM();
            }
        }
    };

    public m(TbPageContext<?> tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gKD = view;
        this.gKD.setOnClickListener(this.mOnClickListener);
        this.gFI = d.t(tbPageContext);
        this.gFI.a(this);
        this.dbg = this.gFI.getVideoView();
        this.dbi = new n(this.mContext.getPageActivity());
        this.gIj = (TbImageView) this.gKD.findViewById(d.g.video_thumbnail);
        this.gIj.setEvent(this.gKH);
        this.gIj.setDefaultErrorResource(0);
        this.gIi = (ImageView) this.gKD.findViewById(d.g.img_play);
        this.gIf = this.gFI.bAD();
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gKG = d.s(this.mContext);
    }

    public void lb(boolean z) {
        if (this.gFI != null) {
            this.gFI.lb(z);
        }
    }

    public void ma(boolean z) {
        if (this.gFI != null) {
            this.gFI.ma(z);
        }
    }

    public View getView() {
        return this.gKD;
    }

    public void d(a aVar) {
        this.gJf = aVar;
        if (this.gJf != null) {
            this.gJf.a(this.gHQ);
        }
    }

    private void bAX() {
        if (this.gFI != null && this.dbg != null && this.gKE != null) {
            this.gFI.stopPlay();
            this.gFI.bZ(this.gKD);
            if (this.gFI.bAI()) {
                this.gFI.bAG();
            }
            this.dbg.setBusiness(this.dbi);
            this.gFI.bAC().setOnProgressUpdatedListener(this.gKI);
            this.gFI.bAC().setOnDragingListener(this.gKJ);
            this.gFI.bAC().setOnSeekBarChangeListener(this.cNV);
            this.gFI.a(this.cJJ);
            this.gFI.setThumbnail(this.gKE.thumbUrl);
            this.gFI.dq(this.gKE.cDi);
            this.gFI.setVideoUrl(this.bNk);
            this.gFI.a(this.gIq);
            this.gFI.bnQ();
            this.gFI.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.ehU) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.d.b.gHs) {
                this.ehU = true;
                if (!bAr()) {
                    bAX();
                    if (q.cdE() && this.gFI != null) {
                        this.gFI.startPlay(this.bNk);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!bAr()) {
            if (this.ehU && this.gFI != null && this.gKD.equals(this.gFI.bAH())) {
                this.gFI.stopPlay();
                if (this.gFI.bAI()) {
                    this.gFI.hide();
                }
            }
            this.ehU = false;
            this.gKF = false;
        }
    }

    public boolean isPlayStarted() {
        return this.ehU;
    }

    public void dn(String str, String str2) {
        if (this.gFI != null) {
            this.gFI.dm(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.gKE = aVar;
        this.page = i;
        if (!bAr() && aVar != null) {
            if (this.bNk == null || !this.bNk.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.bNk = aVar.videoUrl;
                this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.gIj.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.gHd;
                int i3 = aVar.gHe;
                ViewGroup.LayoutParams layoutParams = this.gKD.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.gHf) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.gKD.setLayoutParams(layoutParams);
                    this.gFI.bAF();
                } else if (layoutParams != null && aVar.gHf) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.gKD.setLayoutParams(layoutParams);
                    this.gFI.bAE();
                }
                this.gFI.clearAnimation();
                if (this.dbi != null && this.dbi.bTw() != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    if (aVar.gHf) {
                        builder.video_width = Integer.valueOf(this.mScreenWidth);
                        builder.video_height = Integer.valueOf(this.mScreenHeight);
                    } else {
                        builder.video_width = Integer.valueOf(aVar.videoWidth);
                        builder.video_height = Integer.valueOf(aVar.videoHeight);
                    }
                    builder.video_url = aVar.videoUrl;
                    builder.video_md5 = aVar.gHc;
                    builder.video_length = Integer.valueOf(aVar.eot);
                    builder.thumbnail_width = Integer.valueOf(aVar.gHd);
                    builder.thumbnail_height = Integer.valueOf(aVar.gHe);
                    builder.play_count = Integer.valueOf(aVar.cDi);
                    builder.video_duration = Integer.valueOf(aVar.videoDuration);
                    this.dbi.bTw().g(builder.build(false));
                }
            }
        }
    }

    public boolean isPlaying() {
        return !this.gKF;
    }

    public String getPlayUrl() {
        return this.bNk;
    }

    public int getCurrentPosition() {
        if (bAr()) {
            return 0;
        }
        return this.dbg.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAr() {
        return this.gKD == null || this.dbg == null || this.gIj == null || this.gIi == null || this.gIf == null || this.gJf == null;
    }
}
