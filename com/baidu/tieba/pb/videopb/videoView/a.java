package com.baidu.tieba.pb.videopb.videoView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.arch.lifecycle.y;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.operableVideoView.d;
/* loaded from: classes21.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private boolean lMH;
    private boolean lMI;
    private Runnable lMK;
    private ObjectAnimator lML;
    private ObjectAnimator lMM;
    private int lMe;
    private View lMq;
    private final int lOQ;
    private final int lOR;
    private final int lOS;
    private final int lOT;
    private final int lOU;
    private final int lOV;
    private PbVideoFullscreenAttentionLayout lOW;
    private PbNextVideoLayout lOX;
    private ImageView lOY;
    private ImageView lOZ;
    private VideoPbFragment lOe;
    private int lPa;
    private boolean lPb;
    private ObjectAnimator lPc;
    private e lPd;
    private Runnable lPe;
    private Runnable lPf;
    private Runnable lPg;
    private int luJ;
    private String luK;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.lOQ = 16384;
        this.lOR = 32768;
        this.lOS = 65536;
        this.lOT = 131072;
        this.lOU = 5000;
        this.lOV = 1500;
        this.lPa = -1;
        this.luJ = 0;
        this.lPe = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mlV.setVisibility(8);
            }
        };
        this.lPf = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.lOW.drP()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.alY ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.lPb = true;
                    a.this.lPc.setFloatValues(-l.getDimens(context2, i));
                    a.this.lPc.removeAllListeners();
                    a.this.lPc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.drN();
                            com.baidu.adp.lib.f.e.mY().postDelayed(a.this.lPg, 5000L);
                        }
                    });
                    a.this.lPc.start();
                }
            }
        };
        this.lPg = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.lPc.setFloatValues(l.getDimens(a.this.mContext, a.this.alY ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.lPc.removeAllListeners();
                a.this.lPc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.lOW.setVisibility(8);
                    }
                });
                a.this.lPc.start();
            }
        };
        this.lMK = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.lMI && (a.this.mContext instanceof Activity)) {
                    a.this.aGj();
                }
            }
        };
        drI();
        if (context instanceof PbActivity) {
            this.lPd = (e) y.b((PbActivity) context).l(e.class);
            this.lMH = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        ww(true);
        this.mmd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lOW = (PbVideoFullscreenAttentionLayout) this.mlY.findViewById(R.id.video_fullscreen_attention);
        this.lOX = (PbNextVideoLayout) this.mlY.findViewById(R.id.video_next_layout);
        this.lOY = (ImageView) this.mlY.findViewById(R.id.video_pre);
        this.lOZ = (ImageView) this.mlY.findViewById(R.id.video_next);
        SvgManager.bqB().a(this.lOY, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bqB().a(this.lOZ, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.alP.bDR();
        this.alP.setDrawCorner(false);
        this.lOW.setOnClickEvent(this);
        this.lOY.setOnClickListener(this);
        this.lOZ.setOnClickListener(this);
        this.lOX.setOnClickListener(this);
        this.lMe = l.getEquipmentWidth(this.mContext) / 10;
        this.mlS.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void drF() {
        this.giK.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void vE(boolean z) {
        this.lOX.setIsCountDownValid(z);
    }

    public void aU(bx bxVar) {
        if (bxVar == null || bxVar.blU() == null || au.isEmpty(bxVar.blU().video_url)) {
            if (this.mlI == this.mlB || this.mlI == this.mlC) {
                this.mlI &= -65537;
                Hb(this.mlI);
            }
            this.mlB &= -65537;
            this.mlC &= -65537;
            return;
        }
        if (this.mlI == this.mlB || this.mlI == this.mlC) {
            this.mlI |= 65536;
            Hb(this.mlI);
        }
        this.mlB |= 65536;
        this.mlC |= 65536;
    }

    public void aV(bx bxVar) {
        if (bxVar == null || bxVar.blU() == null || au.isEmpty(bxVar.blU().video_url)) {
            if (this.mlI == this.mlB || this.mlI == this.mlC || this.mlI == this.mlE) {
                this.mlI &= -32769;
                this.mlI &= -131073;
                Hb(this.mlI);
            }
            this.mlB &= -32769;
            this.mlC &= -32769;
            this.mlE &= -131073;
            return;
        }
        if (this.mlI == this.mlB || this.mlI == this.mlC) {
            this.mlI |= 32768;
            Hb(this.mlI);
        }
        if (this.mlI == this.mlE) {
            this.mlI |= 131072;
            Hb(this.mlI);
        }
        this.mlB |= 32768;
        this.mlC |= 32768;
        this.mlE |= 131072;
        this.lOX.setDate(bxVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bx bxVar) {
        if (bxVar != null) {
            this.baijiahaoData = bxVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.alZ = bxVar.getTid();
            oVar.fyg = Long.toString(bxVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bxVar.isBjh()) {
                    this.luJ = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.luJ == 0) {
                        this.luJ = intent.getIntExtra("key_start_from", 0);
                    }
                    this.luK = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.luK)) {
                        oVar.ezo = this.luK;
                    }
                    oVar.mkm = Integer.toString(this.luJ);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mkm = this.source;
                }
            }
            if (bxVar.blU() != null) {
                oVar.mkp = bxVar.blU().video_md5;
                oVar.mkr = String.valueOf(bxVar.blU().is_vertical);
            }
            b(oVar);
            this.lPb = false;
            if (com.baidu.tbadk.a.d.bhp()) {
                this.lOX.setIsCountDownValid(false);
            } else {
                this.lOX.setIsCountDownValid(true);
            }
            if (this.lpN && bxVar.blU() != null) {
                if (this.alY != (bxVar.blU().is_vertical.intValue() == 1)) {
                    dxl();
                }
            }
            super.setData(bxVar);
            ww(!this.alY);
            if (bxVar.blC() != null) {
                bxVar.blC().setIsLike(bxVar.blC().hadConcerned());
            }
            this.lOW.setData(bxVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drG() {
        super.drG();
        if (this.lpN) {
            drK();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.lOW.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lpN || motionEvent.getX() > ((float) this.lMe);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean drH() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drI() {
        this.mly &= -33;
        this.mlz &= -33;
        this.mlA &= -33;
        this.mlB &= -33;
        this.mlC &= -33;
        this.mlD &= -33;
        this.mlE &= -33;
        this.mlF &= -33;
        this.mlG &= -33;
        this.mly |= 1024;
        this.mlz |= 1024;
        this.mlA &= -1025;
        this.mlB |= 1024;
        this.mlC |= 1024;
        this.mlD |= 1024;
        this.mlE |= 1024;
        this.mlF |= 1024;
        this.mlG &= -1025;
        this.mlz |= 16384;
        this.mlD |= 16384;
        this.mlE &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drJ() {
        int i = 0;
        this.mlR.as(this.alY, this.lpN);
        this.mlS.as(this.alY, this.lpN);
        if (this.mlQ instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mlQ).as(this.alY, this.lpN);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mlP.getLayoutParams();
        int dimens = (this.lpN && this.alY) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lpN && !this.alY) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lOY.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lOZ.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lpN || this.alY) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.lOX.as(this.alY, this.lpN);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Hb(int i) {
        if (i != this.mlC && i != this.mlD && i != this.mlB && i != this.mlz) {
            drN();
            if (this.lOW != null) {
                this.lOW.setVisibility(8);
            }
        }
        if (this.mlI != this.mlG && i == this.mlG) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lPe);
            if ((this.mlI & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mlI & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mlG = i;
        }
        super.Hb(i);
        if (!this.lpN) {
            this.mlT.setVisibility(8);
            this.mlU.setVisibility(8);
            if (this.lPd != null) {
                this.lPd.vB((i & 1024) > 0);
            }
        }
        if (this.lPd != null) {
            this.lPd.vB((i & 128) > 0);
        }
        if (this.mlQ instanceof PbVideoMediaController) {
            this.mlQ.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mlQ).setBottomBarShow((i & 16384) > 0);
        }
        if (this.lOY != null) {
            this.lOY.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.lOZ != null) {
            this.lOZ.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.lOX != null) {
            boolean z = (131072 & i) > 0;
            this.lOX.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(IE("c13600"));
            }
        }
        if (!this.lpN && !this.lMH && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.lMI) {
                    if (this.lOe == null || !this.lOe.dqJ()) {
                        dqG();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.lMI = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lMK);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.lMK, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.lMI || (this.lOe != null && this.lOe.dqJ())) {
                aGj();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vF(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lpN);
        }
        super.vF(z);
        drN();
        if (this.lpN) {
            drK();
        } else {
            this.lOW.setVisibility(8);
        }
    }

    private void drK() {
        if (!this.lPb && !this.lOW.drP()) {
            this.lOW.setTranslationX(0.0f);
            this.lOW.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.lOW.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.alY ? R.dimen.tbds248 : R.dimen.tbds428);
            this.lPc = ObjectAnimator.ofFloat(this.lOW, "translationX", 0.0f);
            this.lPc.setDuration(500);
            drN();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.lPf, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean drL() {
        if (this.mlI == this.mlG) {
            return false;
        }
        this.mlV.setVisibility(0);
        this.mlV.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lPe);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lPe, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean drM() {
        if (this.mlI == this.mlG) {
            return false;
        }
        this.mlV.setVisibility(0);
        this.mlV.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lPe);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lPe, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                TbSingleton.getInstance().setHasAgreeToPlay(true);
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                drN();
                com.baidu.adp.lib.f.e.mY().post(this.lPg);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.lPd != null) {
                    this.lPd.vC(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ar("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.lPd != null) {
                    this.lPd.dqZ();
                }
                TiebaStatic.log(new ar("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mlE &= -131073;
                this.mlI &= -131073;
                this.lOX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean rh(boolean z) {
        drN();
        this.lOW.setVisibility(8);
        if (!this.lMH) {
            aGj();
        }
        if (z) {
            this.lPa = this.mlI;
            if (this.mlI == this.mlC || ((this.mlI == this.mlD && !this.giK.isPlaying()) || this.mlI == this.mlE)) {
                this.lPa |= 1;
            }
            stopPlay();
            return true;
        } else if (this.lPa == -1) {
            startPlay();
            return true;
        } else if (this.lPa == this.mlz || this.lPa == this.mlB || this.lPa == this.mlA) {
            startPlay();
            return true;
        } else {
            this.mlQ.setCurrentDuration(n.dwH().Qf(this.mVideoUrl), false);
            Hb(this.lPa);
            return true;
        }
    }

    private ar IE(String str) {
        ar dR = new ar(str).dR("tid", this.alZ).w("fid", this.mFid).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dR.dR("obj_param4", this.baijiahaoData.oriUgcNid);
            dR.dR("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dR.ak("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dR.ak("obj_param5", 3);
            }
        } else {
            dR.ak("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).diV() != null) {
            dR.dR("ab_tag", ((PbActivity) this.mContext).diV().dlP()).dR("obj_id", ((PbActivity) this.mContext).diV().dlQ()).dR("obj_source", ((PbActivity) this.mContext).diV().dlO());
        }
        return dR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Hc(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ar("c13598"));
            } else {
                TiebaStatic.log(new ar("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(IE("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ar("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ar("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(IE("c13601").ak("obj_type", this.lOX.lON ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drN() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lPf);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lPg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGj() {
        dqH();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.lMI = false;
        if (this.lOe != null) {
            this.lOe.vx(false);
        }
    }

    private void dqG() {
        if (this.lML == null) {
            this.lML = ObjectAnimator.ofFloat(this.lMq, "alpha", 0.0f, 1.0f);
            this.lML.setDuration(200L);
        }
        this.lML.start();
    }

    private void dqH() {
        if (this.lMM == null) {
            this.lMM = ObjectAnimator.ofFloat(this.lMq, "alpha", 1.0f, 0.0f);
            this.lMM.setDuration(200L);
        }
        this.lMM.start();
    }

    public void onDestroy() {
        drN();
        ww(false);
    }

    public boolean bWv() {
        return this.alY;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.lOe = videoPbFragment;
    }

    public void dA(View view) {
        this.mRootView = view;
    }

    public void dB(View view) {
        this.lMq = view;
    }

    public boolean dqJ() {
        return this.lMI;
    }

    public void vx(boolean z) {
        this.lMI = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drO() {
        if (this.mmb != null) {
            o dwI = this.mmb.dwI();
            dwI.mLocate = "pb";
            h.a(dwI.mkp, "", "2", dwI, this.giK.getPcdnState());
        }
    }
}
