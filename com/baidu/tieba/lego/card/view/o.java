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
    private TbImageView amC;
    private TbPageContext<?> eSJ;
    private TbCyberVideoView gxn;
    private c kSu;
    private View kUO;
    private ImageView kUR;
    private a kVN;
    private View kXj;
    ImmersiveVideoCardEx.a kXk;
    private n kXm;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    int page;
    private boolean kXl = false;
    private boolean iqY = false;
    private TbImageView.b kXn = new TbImageView.b() { // from class: com.baidu.tieba.lego.card.view.o.1
        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onComplete(String str, boolean z) {
            if (z && o.this.amC != null) {
                o.this.amC.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void onCancel() {
        }
    };
    private SeekBar.OnSeekBarChangeListener gft = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.lego.card.view.o.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                o.this.kSu.day();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!o.this.kSu.dau() && o.this.kSu.dam() != null) {
                o.this.kSu.DK(o.this.kSu.dam().getSeekPosition());
                o.this.kSu.Fy(o.this.mVideoUrl);
            }
        }
    };
    private VideoControllerView.b kXo = new VideoControllerView.b() { // from class: com.baidu.tieba.lego.card.view.o.3
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void sW(int i) {
            if (!o.this.dac()) {
                o.this.kSu.DJ(i);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.o.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.dac() && view.getId() == o.this.kXj.getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(o.this.eSJ.getPageActivity(), o.this.eSJ.getString(R.string.neterror));
                }
                if (o.this.kVN != null && o.this.gxn.isPlaying()) {
                    o.this.kVN.dad();
                }
            }
        }
    };
    private c.b kUX = new c.b() { // from class: com.baidu.tieba.lego.card.view.o.5
        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rl() {
        }

        @Override // com.baidu.tieba.lego.card.view.c.b
        public void rm() {
            o.this.kVN.cZY();
        }
    };
    private CyberPlayerManager.OnPreparedListener eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.o.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (o.this.gxn != null) {
                o.this.kVN.dad();
                if (o.this.kXm == null || o.this.kXm.daC() == null || !o.this.kXm.daC().equals(o.this.mVideoUrl) || o.this.kXm.daD() <= 0) {
                    if (o.this.kXm != null && o.this.kXm.MU(o.this.mVideoUrl) > 0) {
                        o.this.gxn.seekTo(o.this.kXm.MU(o.this.mVideoUrl));
                        return;
                    }
                    return;
                }
                o.this.gxn.seekTo(o.this.kXm.daD());
                o.this.kXm.MT(null);
                o.this.kXm.DN(0);
            }
        }
    };
    private VideoControllerView.a kXp = new VideoControllerView.a() { // from class: com.baidu.tieba.lego.card.view.o.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLk() {
            if (!o.this.dac() && o.this.kVN != null && o.this.kUO != null) {
                if (o.this.gxn.isPlaying()) {
                    o.this.kVN.dad();
                }
                if (o.this.kUO.getAlpha() != 1.0f) {
                    o.this.kUO.setAlpha(1.0f);
                }
                o.this.kUO.clearAnimation();
            }
        }
    };
    private a.InterfaceC0774a kUA = new a.InterfaceC0774a() { // from class: com.baidu.tieba.lego.card.view.o.8
        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0774a
        public void daf() {
            if (o.this.kSu.dau()) {
                o.this.kSu.daw();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0774a
        public void dag() {
            if (o.this.kSu.dau()) {
                o.this.kSu.daw();
            }
        }

        @Override // com.baidu.tieba.lego.card.view.a.InterfaceC0774a
        public void dah() {
            if (o.this.kSu.dau()) {
                o.this.kSu.dav();
            }
        }
    };

    public o(TbPageContext<?> tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.kXj = view;
        this.kXj.setOnClickListener(this.mOnClickListener);
        this.kSu = d.z(tbPageContext);
        this.kSu.a(this);
        this.gxn = this.kSu.getVideoView();
        this.amC = (TbImageView) this.kXj.findViewById(R.id.video_thumbnail);
        this.amC.setEvent(this.kXn);
        this.kUR = (ImageView) this.kXj.findViewById(R.id.img_play);
        this.kUO = this.kSu.dan();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eSJ.getPageActivity());
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.eSJ.getPageActivity());
        this.kXm = d.y(this.eSJ);
    }

    public void ty(boolean z) {
        if (this.kSu != null) {
            this.kSu.ty(z);
        }
    }

    public void tw(boolean z) {
        if (this.kSu != null) {
            this.kSu.tw(z);
        }
    }

    public View getView() {
        return this.kXj;
    }

    public void d(a aVar) {
        this.kVN = aVar;
        if (this.kVN != null) {
            this.kVN.a(this.kUA);
        }
    }

    private void daH() {
        if (this.kSu != null && this.gxn != null && this.kXk != null) {
            this.kSu.stopPlay();
            this.kSu.dt(this.kXj);
            if (this.kSu.das()) {
                this.kSu.daq();
            }
            this.kSu.dam().setOnProgressUpdatedListener(this.kXo);
            this.kSu.dam().setOnDragingListener(this.kXp);
            this.kSu.dam().setOnSeekBarChangeListener(this.gft);
            this.kSu.a(this.eyt);
            this.kSu.setThumbnail(this.kXk.thumbUrl);
            this.kSu.hc(this.kXk.cBF);
            this.kSu.setVideoUrl(this.mVideoUrl);
            this.kSu.a(this.kUX);
            this.kSu.cQE();
            this.kSu.show();
        }
    }

    public int getPage() {
        return this.page;
    }

    public void startPlay() {
        if (!this.iqY) {
            if (this.page <= 0 || this.page == com.baidu.tieba.lego.card.c.c.kUc) {
                this.iqY = true;
                if (!dac()) {
                    daH();
                    if (v.dKB() && this.kSu != null) {
                        this.kSu.Fy(this.mVideoUrl);
                    }
                }
            }
        }
    }

    public void stopPlay() {
        if (!dac()) {
            if (this.iqY && this.kSu != null && this.kXj.equals(this.kSu.dar())) {
                this.kSu.stopPlay();
                if (this.kSu.das()) {
                    this.kSu.hide();
                }
            }
            this.iqY = false;
            this.kXl = false;
        }
    }

    public boolean isPlayStarted() {
        return this.iqY;
    }

    public void fK(String str, String str2) {
        if (this.kSu != null) {
            this.kSu.fJ(str, str2);
        }
    }

    public void a(ImmersiveVideoCardEx.a aVar, int i) {
        this.kXk = aVar;
        this.page = i;
        if (!dac() && aVar != null) {
            if (this.mVideoUrl == null || !this.mVideoUrl.equalsIgnoreCase(aVar.videoUrl)) {
                stopPlay();
                this.mVideoUrl = aVar.videoUrl;
                this.amC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.amC.startLoad(aVar.thumbUrl, 17, false);
                int i2 = aVar.kTM;
                int i3 = aVar.kTN;
                ViewGroup.LayoutParams layoutParams = this.kXj.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.kTO) {
                    if (i2 > i3) {
                        layoutParams.height = (i3 * (this.mScreenWidth * 1)) / i2;
                    } else {
                        layoutParams.height = this.mScreenWidth;
                    }
                    this.kXj.setLayoutParams(layoutParams);
                    this.kSu.dap();
                } else if (layoutParams != null && aVar.kTO) {
                    layoutParams.width = this.mScreenWidth;
                    layoutParams.height = this.mScreenHeight;
                    this.kXj.setLayoutParams(layoutParams);
                    this.kSu.dao();
                }
                this.kSu.clearAnimation();
            }
        }
    }

    public boolean isPlaying() {
        return !this.kXl;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (dac()) {
            return 0;
        }
        return this.gxn.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dac() {
        return this.kXj == null || this.gxn == null || this.amC == null || this.kUR == null || this.kUO == null || this.kVN == null;
    }
}
