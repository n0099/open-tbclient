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
/* loaded from: classes8.dex */
public class o {
    private TbImageView anK;
    private TbPageContext<?> eWx;
    private TbCyberVideoView gBU;
    private c lcO;
    private View lfj;
    private ImageView lfm;
    private a lgh;
    private View lhD;
    ImmersiveVideoCardEx.a lhE;
    private n lhG;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    int page;
    private boolean lhF = false;
    private boolean iyz = false;
    private TbImageView.b lhH = new TbImageView.b() { // from class: com.baidu.tieba.lego.card.view.o.1
        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onComplete(String str, boolean z) {
            if (z && o.this.anK != null) {
                o.this.anK.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onCancel() {
        }
    };
    private SeekBar.OnSeekBarChangeListener gjA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.lego.card.view.o.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                o.this.lcO.dcM();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!o.this.lcO.dcI() && o.this.lcO.dcA() != null) {
                o.this.lcO.Ef(o.this.lcO.dcA().getSeekPosition());
                o.this.lcO.Gg(o.this.mVideoUrl);
            }
        }
    };
    private VideoControllerView.b lhI = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.o.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void td(int i) {
            if (!o.this.dcq()) {
                o.this.lcO.Ee(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.o.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.dcq() && view.getId() == o.this.lhD.getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(o.this.eWx.getPageActivity(), o.this.eWx.getString(R.string.neterror));
                }
                if (o.this.lgh != null && o.this.gBU.isPlaying()) {
                    o.this.lgh.dcr();
                }
            }
        }
    };
    private c.b lfs = new c.b() { // from class: com.baidu.tieba.lego.card.view.o.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rj() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rk() {
            o.this.lgh.dcm();
        }
    };
    private CyberPlayerManager.OnPreparedListener eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.o.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (o.this.gBU != null) {
                o.this.lgh.dcr();
                if (o.this.lhG == null || o.this.lhG.dcQ() == null || !o.this.lhG.dcQ().equals(o.this.mVideoUrl) || o.this.lhG.dcR() <= 0) {
                    if (o.this.lhG != null && o.this.lhG.NP(o.this.mVideoUrl) > 0) {
                        o.this.gBU.seekTo(o.this.lhG.NP(o.this.mVideoUrl));
                        return;
                    }
                    return;
                }
                o.this.gBU.seekTo(o.this.lhG.dcR());
                o.this.lhG.NO(null);
                o.this.lhG.Ei(0);
            }
        }
    };
    private VideoControllerView.a lhJ = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.o.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLP() {
            if (!o.this.dcq() && o.this.lgh != null && o.this.lfj != null) {
                if (o.this.gBU.isPlaying()) {
                    o.this.lgh.dcr();
                }
                if (o.this.lfj.getAlpha() != 1.0f) {
                    o.this.lfj.setAlpha(1.0f);
                }
                o.this.lfj.clearAnimation();
            }
        }
    };
    private a.InterfaceC0783a leV = new a.InterfaceC0783a() { // from class: com.baidu.tieba.lego.card.view.o.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0783a
        public void dct() {
            if (o.this.lcO.dcI()) {
                o.this.lcO.dcK();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0783a
        public void dcu() {
            if (o.this.lcO.dcI()) {
                o.this.lcO.dcK();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0783a
        public void dcv() {
            if (o.this.lcO.dcI()) {
                o.this.lcO.dcJ();
            }
        }
    };

    public o(TbPageContext<?> tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.lhD = view;
        this.lhD.setOnClickListener(this.mOnClickListener);
        this.lcO = d.B(tbPageContext);
        this.lcO.a(this);
        this.gBU = this.lcO.getVideoView();
        this.anK = (TbImageView) this.lhD.findViewById(R.id.video_thumbnail);
        this.anK.setEvent(this.lhH);
        this.lfm = (ImageView) this.lhD.findViewById(R.id.img_play);
        this.lfj = this.lcO.dcB();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eWx.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.eWx.getPageActivity());
        this.lhG = d.A(this.eWx);
    }

    public void tL(boolean z) {
        if (this.lcO != null) {
            this.lcO.tL(z);
        }
    }

    public void tJ(boolean z) {
        if (this.lcO != null) {
            this.lcO.tJ(z);
        }
    }

    public View getView() {
        return this.lhD;
    }

    public void d(a aVar) {
        this.lgh = aVar;
        if (this.lgh != null) {
            this.lgh.a(this.leV);
        }
    }

    private void dcV() {
        if (this.lcO != null && this.gBU != null && this.lhE != null) {
            this.lcO.stopPlay();
            this.lcO.dr(this.lhD);
            if (this.lcO.dcG()) {
                this.lcO.dcE();
            }
            this.lcO.dcA().setOnProgressUpdatedListener(this.lhI);
            this.lcO.dcA().setOnDragingListener(this.lhJ);
            this.lcO.dcA().setOnSeekBarChangeListener(this.gjA);
            this.lcO.a(this.eCb);
            this.lcO.setThumbnail(this.lhE.thumbUrl);
            this.lcO.hh(this.lhE.cFB);
            this.lcO.setVideoUrl(this.mVideoUrl);
            this.lcO.a(this.lfs);
            this.lcO.cSR();
            this.lcO.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.iyz) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.c.c.lex) {
                this.iyz = true;
                if (!dcq()) {
                    dcV();
                    if (v.dNc() && this.lcO != null) {
                        this.lcO.Gg(this.mVideoUrl);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!dcq()) {
            if (this.iyz && this.lcO != null && this.lhD.equals(this.lcO.dcF())) {
                this.lcO.stopPlay();
                if (this.lcO.dcG()) {
                    this.lcO.hide();
                }
            }
            this.iyz = false;
            this.lhF = false;
        }
    }

    public boolean isPlayStarted() {
        return this.iyz;
    }

    public void fK(String str, String str2) {
        if (this.lcO != null) {
            this.lcO.fJ(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.lhE = aVar;
        this.page = i;
        if (!dcq() && aVar != null) {
            if (this.mVideoUrl == null || !this.mVideoUrl.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.mVideoUrl = aVar.videoUrl;
                this.anK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.anK.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.leg;
                int i3 = aVar.leh;
                ViewGroup.LayoutParams layoutParams = this.lhD.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.lei) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.lhD.setLayoutParams(layoutParams);
                    this.lcO.dcD();
                } else if (layoutParams != null && aVar.lei) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.lhD.setLayoutParams(layoutParams);
                    this.lcO.dcC();
                }
                this.lcO.clearAnimation();
            }
        }
    }

    public boolean isPlaying() {
        return !this.lhF;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (dcq()) {
            return 0;
        }
        return this.gBU.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dcq() {
        return this.lhD == null || this.gBU == null || this.anK == null || this.lfm == null || this.lfj == null || this.lgh == null;
    }
}
