package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.lego.card.view.a;
import com.baidu.tieba.lego.card.view.c;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes9.dex */
public class o {
    private TbImageView ams;
    private TbPageContext<?> eUY;
    private TbCyberVideoView gAl;
    private c laL;
    private View ldg;
    private ImageView ldj;
    private a lee;
    private View lfB;
    ImmersiveVideoCardEx.a lfC;
    private n lfE;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    int page;
    private boolean lfD = false;
    private boolean iwQ = false;
    private TbImageView.b lfF = new TbImageView.b() { // from class: com.baidu.tieba.lego.card.view.o.1
        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onComplete(String str, boolean z) {
            if (z && o.this.ams != null) {
                o.this.ams.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onCancel() {
        }
    };
    private SeekBar.OnSeekBarChangeListener ghW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.lego.card.view.o.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                o.this.laL.dcD();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!o.this.laL.dcz() && o.this.laL.dcr() != null) {
                o.this.laL.Ec(o.this.laL.dcr().getSeekPosition());
                o.this.laL.FX(o.this.mVideoUrl);
            }
        }
    };
    private VideoControllerView.b lfG = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.o.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tb(int i) {
            if (!o.this.dch()) {
                o.this.laL.Eb(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.o.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.dch() && view.getId() == o.this.lfB.getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(o.this.eUY.getPageActivity(), o.this.eUY.getString(R.string.neterror));
                }
                if (o.this.lee != null && o.this.gAl.isPlaying()) {
                    o.this.lee.dci();
                }
            }
        }
    };
    private c.b ldp = new c.b() { // from class: com.baidu.tieba.lego.card.view.o.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rj() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rk() {
            o.this.lee.dcd();
        }
    };
    private CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.o.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (o.this.gAl != null) {
                o.this.lee.dci();
                if (o.this.lfE == null || o.this.lfE.dcH() == null || !o.this.lfE.dcH().equals(o.this.mVideoUrl) || o.this.lfE.dcI() <= 0) {
                    if (o.this.lfE != null && o.this.lfE.NJ(o.this.mVideoUrl) > 0) {
                        o.this.gAl.seekTo(o.this.lfE.NJ(o.this.mVideoUrl));
                        return;
                    }
                    return;
                }
                o.this.gAl.seekTo(o.this.lfE.dcI());
                o.this.lfE.NI(null);
                o.this.lfE.Ef(0);
            }
        }
    };
    private VideoControllerView.a lfH = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.o.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLL() {
            if (!o.this.dch() && o.this.lee != null && o.this.ldg != null) {
                if (o.this.gAl.isPlaying()) {
                    o.this.lee.dci();
                }
                if (o.this.ldg.getAlpha() != 1.0f) {
                    o.this.ldg.setAlpha(1.0f);
                }
                o.this.ldg.clearAnimation();
            }
        }
    };
    private a.InterfaceC0777a lcS = new a.InterfaceC0777a() { // from class: com.baidu.tieba.lego.card.view.o.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0777a
        public void dck() {
            if (o.this.laL.dcz()) {
                o.this.laL.dcB();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0777a
        public void dcl() {
            if (o.this.laL.dcz()) {
                o.this.laL.dcB();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0777a
        public void dcm() {
            if (o.this.laL.dcz()) {
                o.this.laL.dcA();
            }
        }
    };

    public o(TbPageContext<?> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.lfB = view;
        this.lfB.setOnClickListener(this.mOnClickListener);
        this.laL = d.B(tbPageContext);
        this.laL.a(this);
        this.gAl = this.laL.getVideoView();
        this.ams = (TbImageView) this.lfB.findViewById(R.id.video_thumbnail);
        this.ams.setEvent(this.lfF);
        this.ldj = (ImageView) this.lfB.findViewById(R.id.img_play);
        this.ldg = this.laL.dcs();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.eUY.getPageActivity());
        this.lfE = d.A(this.eUY);
    }

    public void tL(boolean z) {
        if (this.laL != null) {
            this.laL.tL(z);
        }
    }

    public void tJ(boolean z) {
        if (this.laL != null) {
            this.laL.tJ(z);
        }
    }

    public View getView() {
        return this.lfB;
    }

    public void d(a aVar) {
        this.lee = aVar;
        if (this.lee != null) {
            this.lee.a(this.lcS);
        }
    }

    private void dcM() {
        if (this.laL != null && this.gAl != null && this.lfC != null) {
            this.laL.stopPlay();
            this.laL.dr(this.lfB);
            if (this.laL.dcx()) {
                this.laL.dcv();
            }
            this.laL.dcr().setOnProgressUpdatedListener(this.lfG);
            this.laL.dcr().setOnDragingListener(this.lfH);
            this.laL.dcr().setOnSeekBarChangeListener(this.ghW);
            this.laL.a(this.eAA);
            this.laL.setThumbnail(this.lfC.thumbUrl);
            this.laL.hh(this.lfC.cEb);
            this.laL.setVideoUrl(this.mVideoUrl);
            this.laL.a(this.ldp);
            this.laL.cSK();
            this.laL.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.iwQ) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.c.c.lcu) {
                this.iwQ = true;
                if (!dch()) {
                    dcM();
                    if (v.dMU() && this.laL != null) {
                        this.laL.FX(this.mVideoUrl);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!dch()) {
            if (this.iwQ && this.laL != null && this.lfB.equals(this.laL.dcw())) {
                this.laL.stopPlay();
                if (this.laL.dcx()) {
                    this.laL.hide();
                }
            }
            this.iwQ = false;
            this.lfD = false;
        }
    }

    public boolean isPlayStarted() {
        return this.iwQ;
    }

    public void fK(String str, String str2) {
        if (this.laL != null) {
            this.laL.fJ(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.lfC = aVar;
        this.page = i;
        if (!dch() && aVar != null) {
            if (this.mVideoUrl == null || !this.mVideoUrl.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.mVideoUrl = aVar.videoUrl;
                this.ams.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.ams.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.lcd;
                int i3 = aVar.lce;
                ViewGroup.LayoutParams layoutParams = this.lfB.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.lcf) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.lfB.setLayoutParams(layoutParams);
                    this.laL.dcu();
                } else if (layoutParams != null && aVar.lcf) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.lfB.setLayoutParams(layoutParams);
                    this.laL.dct();
                }
                this.laL.clearAnimation();
            }
        }
    }

    public boolean isPlaying() {
        return !this.lfD;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (dch()) {
            return 0;
        }
        return this.gAl.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dch() {
        return this.lfB == null || this.gAl == null || this.ams == null || this.ldj == null || this.ldg == null || this.lee == null;
    }
}
