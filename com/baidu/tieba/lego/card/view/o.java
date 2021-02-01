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
    private TbCyberVideoView gzX;
    private c lax;
    private View lcS;
    private ImageView lcV;
    private a ldQ;
    private View lfn;
    ImmersiveVideoCardEx.a lfo;
    private n lfq;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    int page;
    private boolean lfp = false;
    private boolean iwC = false;
    private TbImageView.b lfr = new TbImageView.b() { // from class: com.baidu.tieba.lego.card.view.o.1
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
    private SeekBar.OnSeekBarChangeListener ghI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.lego.card.view.o.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                o.this.lax.dcw();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!o.this.lax.dcs() && o.this.lax.dck() != null) {
                o.this.lax.Ec(o.this.lax.dck().getSeekPosition());
                o.this.lax.FW(o.this.mVideoUrl);
            }
        }
    };
    private VideoControllerView.b lfs = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.o.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tb(int i) {
            if (!o.this.dca()) {
                o.this.lax.Eb(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.o.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.dca() && view.getId() == o.this.lfn.getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(o.this.eUY.getPageActivity(), o.this.eUY.getString(R.string.neterror));
                }
                if (o.this.ldQ != null && o.this.gzX.isPlaying()) {
                    o.this.ldQ.dcb();
                }
            }
        }
    };
    private c.b ldb = new c.b() { // from class: com.baidu.tieba.lego.card.view.o.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rj() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rk() {
            o.this.ldQ.dbW();
        }
    };
    private CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.o.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (o.this.gzX != null) {
                o.this.ldQ.dcb();
                if (o.this.lfq == null || o.this.lfq.dcA() == null || !o.this.lfq.dcA().equals(o.this.mVideoUrl) || o.this.lfq.dcB() <= 0) {
                    if (o.this.lfq != null && o.this.lfq.NI(o.this.mVideoUrl) > 0) {
                        o.this.gzX.seekTo(o.this.lfq.NI(o.this.mVideoUrl));
                        return;
                    }
                    return;
                }
                o.this.gzX.seekTo(o.this.lfq.dcB());
                o.this.lfq.NH(null);
                o.this.lfq.Ef(0);
            }
        }
    };
    private VideoControllerView.a lft = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.o.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLE() {
            if (!o.this.dca() && o.this.ldQ != null && o.this.lcS != null) {
                if (o.this.gzX.isPlaying()) {
                    o.this.ldQ.dcb();
                }
                if (o.this.lcS.getAlpha() != 1.0f) {
                    o.this.lcS.setAlpha(1.0f);
                }
                o.this.lcS.clearAnimation();
            }
        }
    };
    private a.InterfaceC0776a lcE = new a.InterfaceC0776a() { // from class: com.baidu.tieba.lego.card.view.o.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0776a
        public void dcd() {
            if (o.this.lax.dcs()) {
                o.this.lax.dcu();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0776a
        public void dce() {
            if (o.this.lax.dcs()) {
                o.this.lax.dcu();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0776a
        public void dcf() {
            if (o.this.lax.dcs()) {
                o.this.lax.dct();
            }
        }
    };

    public o(TbPageContext<?> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.lfn = view;
        this.lfn.setOnClickListener(this.mOnClickListener);
        this.lax = d.B(tbPageContext);
        this.lax.a(this);
        this.gzX = this.lax.getVideoView();
        this.ams = (TbImageView) this.lfn.findViewById(R.id.video_thumbnail);
        this.ams.setEvent(this.lfr);
        this.lcV = (ImageView) this.lfn.findViewById(R.id.img_play);
        this.lcS = this.lax.dcl();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.eUY.getPageActivity());
        this.lfq = d.A(this.eUY);
    }

    public void tL(boolean z) {
        if (this.lax != null) {
            this.lax.tL(z);
        }
    }

    public void tJ(boolean z) {
        if (this.lax != null) {
            this.lax.tJ(z);
        }
    }

    public View getView() {
        return this.lfn;
    }

    public void d(a aVar) {
        this.ldQ = aVar;
        if (this.ldQ != null) {
            this.ldQ.a(this.lcE);
        }
    }

    private void dcF() {
        if (this.lax != null && this.gzX != null && this.lfo != null) {
            this.lax.stopPlay();
            this.lax.dr(this.lfn);
            if (this.lax.dcq()) {
                this.lax.dco();
            }
            this.lax.dck().setOnProgressUpdatedListener(this.lfs);
            this.lax.dck().setOnDragingListener(this.lft);
            this.lax.dck().setOnSeekBarChangeListener(this.ghI);
            this.lax.a(this.eAA);
            this.lax.setThumbnail(this.lfo.thumbUrl);
            this.lax.hh(this.lfo.cEb);
            this.lax.setVideoUrl(this.mVideoUrl);
            this.lax.a(this.ldb);
            this.lax.cSD();
            this.lax.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.iwC) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.c.c.lcf) {
                this.iwC = true;
                if (!dca()) {
                    dcF();
                    if (v.dMM() && this.lax != null) {
                        this.lax.FW(this.mVideoUrl);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!dca()) {
            if (this.iwC && this.lax != null && this.lfn.equals(this.lax.dcp())) {
                this.lax.stopPlay();
                if (this.lax.dcq()) {
                    this.lax.hide();
                }
            }
            this.iwC = false;
            this.lfp = false;
        }
    }

    public boolean isPlayStarted() {
        return this.iwC;
    }

    public void fK(String str, String str2) {
        if (this.lax != null) {
            this.lax.fJ(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.lfo = aVar;
        this.page = i;
        if (!dca() && aVar != null) {
            if (this.mVideoUrl == null || !this.mVideoUrl.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.mVideoUrl = aVar.videoUrl;
                this.ams.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.ams.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.lbP;
                int i3 = aVar.lbQ;
                ViewGroup.LayoutParams layoutParams = this.lfn.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.lbR) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.lfn.setLayoutParams(layoutParams);
                    this.lax.dcn();
                } else if (layoutParams != null && aVar.lbR) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.lfn.setLayoutParams(layoutParams);
                    this.lax.dcm();
                }
                this.lax.clearAnimation();
            }
        }
    }

    public boolean isPlaying() {
        return !this.lfp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (dca()) {
            return 0;
        }
        return this.gzX.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dca() {
        return this.lfn == null || this.gzX == null || this.ams == null || this.lcV == null || this.lcS == null || this.ldQ == null;
    }
}
