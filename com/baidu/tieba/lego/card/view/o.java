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
    private TbImageView ant;
    private TbPageContext<?> eXu;
    private TbCyberVideoView gBU;
    private c kWZ;
    private View kZt;
    private ImageView kZw;
    private a las;
    private View lbP;
    ImmersiveVideoCardEx.a lbQ;
    private n lbS;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    int page;
    private boolean lbR = false;
    private boolean ivF = false;
    private TbImageView.b lbT = new TbImageView.b() { // from class: com.baidu.tieba.lego.card.view.o.1
        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onComplete(String str, boolean z) {
            if (z && o.this.ant != null) {
                o.this.ant.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onCancel() {
        }
    };
    private SeekBar.OnSeekBarChangeListener gkb = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.lego.card.view.o.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                o.this.kWZ.deq();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!o.this.kWZ.dem() && o.this.kWZ.dee() != null) {
                o.this.kWZ.Fq(o.this.kWZ.dee().getSeekPosition());
                o.this.kWZ.GJ(o.this.mVideoUrl);
            }
        }
    };
    private VideoControllerView.b lbU = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.o.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void uC(int i) {
            if (!o.this.ddU()) {
                o.this.kWZ.Fp(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.o.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.ddU() && view.getId() == o.this.lbP.getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(o.this.eXu.getPageActivity(), o.this.eXu.getString(R.string.neterror));
                }
                if (o.this.las != null && o.this.gBU.isPlaying()) {
                    o.this.las.ddV();
                }
            }
        }
    };
    private c.b kZC = new c.b() { // from class: com.baidu.tieba.lego.card.view.o.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rl() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rm() {
            o.this.las.ddQ();
        }
    };
    private CyberPlayerManager.OnPreparedListener eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.o.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (o.this.gBU != null) {
                o.this.las.ddV();
                if (o.this.lbS == null || o.this.lbS.deu() == null || !o.this.lbS.deu().equals(o.this.mVideoUrl) || o.this.lbS.dev() <= 0) {
                    if (o.this.lbS != null && o.this.lbS.Ob(o.this.mVideoUrl) > 0) {
                        o.this.gBU.seekTo(o.this.lbS.Ob(o.this.mVideoUrl));
                        return;
                    }
                    return;
                }
                o.this.gBU.seekTo(o.this.lbS.dev());
                o.this.lbS.Oa(null);
                o.this.lbS.Ft(0);
            }
        }
    };
    private VideoControllerView.a lbV = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.o.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bPc() {
            if (!o.this.ddU() && o.this.las != null && o.this.kZt != null) {
                if (o.this.gBU.isPlaying()) {
                    o.this.las.ddV();
                }
                if (o.this.kZt.getAlpha() != 1.0f) {
                    o.this.kZt.setAlpha(1.0f);
                }
                o.this.kZt.clearAnimation();
            }
        }
    };
    private a.InterfaceC0791a kZf = new a.InterfaceC0791a() { // from class: com.baidu.tieba.lego.card.view.o.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0791a
        public void ddX() {
            if (o.this.kWZ.dem()) {
                o.this.kWZ.deo();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0791a
        public void ddY() {
            if (o.this.kWZ.dem()) {
                o.this.kWZ.deo();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0791a
        public void ddZ() {
            if (o.this.kWZ.dem()) {
                o.this.kWZ.den();
            }
        }
    };

    public o(TbPageContext<?> tbPageContext, View view) {
        this.eXu = tbPageContext;
        this.lbP = view;
        this.lbP.setOnClickListener(this.mOnClickListener);
        this.kWZ = d.z(tbPageContext);
        this.kWZ.a(this);
        this.gBU = this.kWZ.getVideoView();
        this.ant = (TbImageView) this.lbP.findViewById(R.id.video_thumbnail);
        this.ant.setEvent(this.lbT);
        this.kZw = (ImageView) this.lbP.findViewById(R.id.img_play);
        this.kZt = this.kWZ.def();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eXu.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.eXu.getPageActivity());
        this.lbS = d.y(this.eXu);
    }

    public void tC(boolean z) {
        if (this.kWZ != null) {
            this.kWZ.tC(z);
        }
    }

    public void tA(boolean z) {
        if (this.kWZ != null) {
            this.kWZ.tA(z);
        }
    }

    public View getView() {
        return this.lbP;
    }

    public void d(a aVar) {
        this.las = aVar;
        if (this.las != null) {
            this.las.a(this.kZf);
        }
    }

    private void dez() {
        if (this.kWZ != null && this.gBU != null && this.lbQ != null) {
            this.kWZ.stopPlay();
            this.kWZ.dt(this.lbP);
            if (this.kWZ.dek()) {
                this.kWZ.dei();
            }
            this.kWZ.dee().setOnProgressUpdatedListener(this.lbU);
            this.kWZ.dee().setOnDragingListener(this.lbV);
            this.kWZ.dee().setOnSeekBarChangeListener(this.gkb);
            this.kWZ.a(this.eDf);
            this.kWZ.setThumbnail(this.lbQ.thumbUrl);
            this.kWZ.hc(this.lbQ.cGr);
            this.kWZ.setVideoUrl(this.mVideoUrl);
            this.kWZ.a(this.kZC);
            this.kWZ.cUw();
            this.kWZ.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.ivF) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.c.c.kYH) {
                this.ivF = true;
                if (!ddU()) {
                    dez();
                    if (v.dOt() && this.kWZ != null) {
                        this.kWZ.GJ(this.mVideoUrl);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!ddU()) {
            if (this.ivF && this.kWZ != null && this.lbP.equals(this.kWZ.dej())) {
                this.kWZ.stopPlay();
                if (this.kWZ.dek()) {
                    this.kWZ.hide();
                }
            }
            this.ivF = false;
            this.lbR = false;
        }
    }

    public boolean isPlayStarted() {
        return this.ivF;
    }

    public void fL(String str, String str2) {
        if (this.kWZ != null) {
            this.kWZ.fK(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.lbQ = aVar;
        this.page = i;
        if (!ddU() && aVar != null) {
            if (this.mVideoUrl == null || !this.mVideoUrl.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.mVideoUrl = aVar.videoUrl;
                this.ant.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.ant.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.kYr;
                int i3 = aVar.kYs;
                ViewGroup.LayoutParams layoutParams = this.lbP.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.kYt) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.lbP.setLayoutParams(layoutParams);
                    this.kWZ.deh();
                } else if (layoutParams != null && aVar.kYt) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.lbP.setLayoutParams(layoutParams);
                    this.kWZ.deg();
                }
                this.kWZ.clearAnimation();
            }
        }
    }

    public boolean isPlaying() {
        return !this.lbR;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (ddU()) {
            return 0;
        }
        return this.gBU.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddU() {
        return this.lbP == null || this.gBU == null || this.ant == null || this.kZw == null || this.kZt == null || this.las == null;
    }
}
