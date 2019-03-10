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
    private c gFJ;
    private View gIg;
    private ImageView gIj;
    private TbImageView gIk;
    private a gJg;
    private View gKE;
    ImmersiveVideoCardEx.a gKF;
    private l gKH;
    private TbPageContext<?> mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    int page;
    private boolean gKG = false;
    private boolean ehU = false;
    private TbImageView.a gKI = new TbImageView.a() { // from class: com.baidu.tieba.lego.card.view.m.1
        @Override // com.baidu.tbadk.widget.TbImageView.a
        public void L(String str, boolean z) {
            if (z && m.this.gIk != null) {
                m.this.gIk.setDefaultBgResource(0);
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
                m.this.gFJ.bAQ();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!m.this.gFJ.bAM() && m.this.gFJ.bAD() != null) {
                m.this.gFJ.setStartPosition(m.this.gFJ.bAD().getSeekPosition());
                m.this.gFJ.startPlay(m.this.bNk);
            }
        }
    };
    private VideoControllerView.b gKJ = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.m.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void lz(int i) {
            if (!m.this.bAs()) {
                m.this.gFJ.uX(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.m.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!m.this.bAs() && view.getId() == m.this.gKE.getId()) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.S(m.this.mContext.getPageActivity(), m.this.mContext.getString(d.j.neterror));
                }
                if (m.this.gJg != null && m.this.dbg.isPlaying()) {
                    m.this.gJg.bAt();
                }
            }
        }
    };
    private c.b gIr = new c.b() { // from class: com.baidu.tieba.lego.card.view.m.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void qj() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void qk() {
            m.this.gJg.bAn();
        }
    };
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.lego.card.view.m.6
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            if (gVar != null) {
                m.this.gJg.bAt();
                if (m.this.gKH == null || m.this.gKH.bAT() == null || !m.this.gKH.bAT().equals(m.this.bNk) || m.this.gKH.bAU() <= 0) {
                    if (m.this.gKH != null && m.this.gKH.ye(m.this.bNk) > 0) {
                        gVar.seekTo(m.this.gKH.ye(m.this.bNk));
                        return;
                    }
                    return;
                }
                gVar.seekTo(m.this.gKH.bAU());
                m.this.gKH.yd(null);
                m.this.gKH.va(0);
            }
        }
    };
    private VideoControllerView.a gKK = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.m.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void awM() {
            if (!m.this.bAs() && m.this.gJg != null && m.this.gIg != null) {
                if (m.this.dbg.isPlaying()) {
                    m.this.gJg.bAt();
                }
                if (m.this.gIg.getAlpha() != 1.0f) {
                    m.this.gIg.setAlpha(1.0f);
                }
                m.this.gIg.clearAnimation();
            }
        }
    };
    private a.InterfaceC0269a gHR = new a.InterfaceC0269a() { // from class: com.baidu.tieba.lego.card.view.m.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0269a
        public void bAv() {
            if (m.this.gFJ.bAM()) {
                m.this.gFJ.bAO();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0269a
        public void bAw() {
            if (m.this.gFJ.bAM()) {
                m.this.gFJ.bAO();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0269a
        public void bAx() {
            if (m.this.gFJ.bAM()) {
                m.this.gFJ.bAN();
            }
        }
    };

    public m(TbPageContext<?> tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.gKE = view;
        this.gKE.setOnClickListener(this.mOnClickListener);
        this.gFJ = d.t(tbPageContext);
        this.gFJ.a(this);
        this.dbg = this.gFJ.getVideoView();
        this.dbi = new n(this.mContext.getPageActivity());
        this.gIk = (TbImageView) this.gKE.findViewById(d.g.video_thumbnail);
        this.gIk.setEvent(this.gKI);
        this.gIk.setDefaultErrorResource(0);
        this.gIj = (ImageView) this.gKE.findViewById(d.g.img_play);
        this.gIg = this.gFJ.bAE();
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gKH = d.s(this.mContext);
    }

    public void lb(boolean z) {
        if (this.gFJ != null) {
            this.gFJ.lb(z);
        }
    }

    public void ma(boolean z) {
        if (this.gFJ != null) {
            this.gFJ.ma(z);
        }
    }

    public View getView() {
        return this.gKE;
    }

    public void d(a aVar) {
        this.gJg = aVar;
        if (this.gJg != null) {
            this.gJg.a(this.gHR);
        }
    }

    private void bAY() {
        if (this.gFJ != null && this.dbg != null && this.gKF != null) {
            this.gFJ.stopPlay();
            this.gFJ.bZ(this.gKE);
            if (this.gFJ.bAJ()) {
                this.gFJ.bAH();
            }
            this.dbg.setBusiness(this.dbi);
            this.gFJ.bAD().setOnProgressUpdatedListener(this.gKJ);
            this.gFJ.bAD().setOnDragingListener(this.gKK);
            this.gFJ.bAD().setOnSeekBarChangeListener(this.cNV);
            this.gFJ.a(this.cJJ);
            this.gFJ.setThumbnail(this.gKF.thumbUrl);
            this.gFJ.dq(this.gKF.cDi);
            this.gFJ.setVideoUrl(this.bNk);
            this.gFJ.a(this.gIr);
            this.gFJ.bnR();
            this.gFJ.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.ehU) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.d.b.gHt) {
                this.ehU = true;
                if (!bAs()) {
                    bAY();
                    if (q.cdF() && this.gFJ != null) {
                        this.gFJ.startPlay(this.bNk);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!bAs()) {
            if (this.ehU && this.gFJ != null && this.gKE.equals(this.gFJ.bAI())) {
                this.gFJ.stopPlay();
                if (this.gFJ.bAJ()) {
                    this.gFJ.hide();
                }
            }
            this.ehU = false;
            this.gKG = false;
        }
    }

    public boolean isPlayStarted() {
        return this.ehU;
    }

    public void dn(String str, String str2) {
        if (this.gFJ != null) {
            this.gFJ.dm(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.gKF = aVar;
        this.page = i;
        if (!bAs() && aVar != null) {
            if (this.bNk == null || !this.bNk.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.bNk = aVar.videoUrl;
                this.gIk.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.gIk.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.gHe;
                int i3 = aVar.gHf;
                ViewGroup.LayoutParams layoutParams = this.gKE.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.gHg) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.gKE.setLayoutParams(layoutParams);
                    this.gFJ.bAG();
                } else if (layoutParams != null && aVar.gHg) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.gKE.setLayoutParams(layoutParams);
                    this.gFJ.bAF();
                }
                this.gFJ.clearAnimation();
                if (this.dbi != null && this.dbi.bTx() != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    if (aVar.gHg) {
                        builder.video_width = Integer.valueOf(this.mScreenWidth);
                        builder.video_height = Integer.valueOf(this.mScreenHeight);
                    } else {
                        builder.video_width = Integer.valueOf(aVar.videoWidth);
                        builder.video_height = Integer.valueOf(aVar.videoHeight);
                    }
                    builder.video_url = aVar.videoUrl;
                    builder.video_md5 = aVar.gHd;
                    builder.video_length = Integer.valueOf(aVar.eot);
                    builder.thumbnail_width = Integer.valueOf(aVar.gHe);
                    builder.thumbnail_height = Integer.valueOf(aVar.gHf);
                    builder.play_count = Integer.valueOf(aVar.cDi);
                    builder.video_duration = Integer.valueOf(aVar.videoDuration);
                    this.dbi.bTx().g(builder.build(false));
                }
            }
        }
    }

    public boolean isPlaying() {
        return !this.gKG;
    }

    public String getPlayUrl() {
        return this.bNk;
    }

    public int getCurrentPosition() {
        if (bAs()) {
            return 0;
        }
        return this.dbg.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAs() {
        return this.gKE == null || this.dbg == null || this.gIk == null || this.gIj == null || this.gIg == null || this.gJg == null;
    }
}
