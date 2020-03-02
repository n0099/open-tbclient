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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.play.operableVideoView.d;
import com.baidu.tieba.play.x;
/* loaded from: classes9.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int iIg;
    private String iIh;
    private boolean iYL;
    private boolean iYM;
    private Runnable iYP;
    private ObjectAnimator iYQ;
    private ObjectAnimator iYR;
    private int iYk;
    private View iYv;
    private VideoPbFragment iZY;
    private final int jaC;
    private final int jaD;
    private final int jaE;
    private final int jaF;
    private final int jaG;
    private final int jaH;
    private PbVideoFullscreenAttentionLayout jaI;
    private PbNextVideoLayout jaJ;
    private ImageView jaK;
    private ImageView jaL;
    private int jaM;
    private boolean jaN;
    private boolean jaO;
    private ObjectAnimator jaP;
    private e jaQ;
    private Runnable jaR;
    private Runnable jaS;
    private Runnable jaT;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.jaC = 16384;
        this.jaD = 32768;
        this.jaE = 65536;
        this.jaF = 131072;
        this.jaG = 5000;
        this.jaH = 1500;
        this.jaM = -1;
        this.iIg = 0;
        this.jaR = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jyb.setVisibility(8);
            }
        };
        this.jaS = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jaI.cua()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.Pi ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.jaO = true;
                    a.this.jaP.setFloatValues(-l.getDimens(context2, i));
                    a.this.jaP.removeAllListeners();
                    a.this.jaP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.ctX();
                            com.baidu.adp.lib.f.e.gx().postDelayed(a.this.jaT, 5000L);
                        }
                    });
                    a.this.jaP.start();
                }
            }
        };
        this.jaT = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jaP.setFloatValues(l.getDimens(a.this.mContext, a.this.Pi ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.jaP.removeAllListeners();
                a.this.jaP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.jaI.setVisibility(8);
                    }
                });
                a.this.jaP.start();
            }
        };
        this.iYP = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iYM && (a.this.mContext instanceof Activity)) {
                    a.this.ctY();
                }
            }
        };
        ctS();
        if (context instanceof PbActivity) {
            this.jaQ = (e) y.b((PbActivity) context).l(e.class);
            this.iYL = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        rQ(true);
        this.jyi = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jaI = (PbVideoFullscreenAttentionLayout) this.jye.findViewById(R.id.video_fullscreen_attention);
        this.jaJ = (PbNextVideoLayout) this.jye.findViewById(R.id.video_next_layout);
        this.jaK = (ImageView) this.jye.findViewById(R.id.video_pre);
        this.jaL = (ImageView) this.jye.findViewById(R.id.video_next);
        SvgManager.aGC().a(this.jaK, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aGC().a(this.jaL, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.OY.aSS();
        this.OY.setDrawCorner(false);
        this.jaI.setOnClickEvent(this);
        this.jaK.setOnClickListener(this);
        this.jaL.setOnClickListener(this);
        this.jaJ.setOnClickListener(this);
        this.iYk = l.getEquipmentWidth(this.mContext) / 10;
        this.jxY.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void ctN() {
        this.jtu.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void qZ(boolean z) {
        this.jaJ.setIsCountDownValid(z);
    }

    public void aQ(bj bjVar) {
        if (bjVar == null || bjVar.aCF() == null || aq.isEmpty(bjVar.aCF().video_url)) {
            if (this.jxO == this.jxI || this.jxO == this.STATE_PAUSE) {
                this.jxO &= -65537;
                zy(this.jxO);
            }
            this.jxI &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jxO == this.jxI || this.jxO == this.STATE_PAUSE) {
            this.jxO |= 65536;
            zy(this.jxO);
        }
        this.jxI |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aR(bj bjVar) {
        if (bjVar == null || bjVar.aCF() == null || aq.isEmpty(bjVar.aCF().video_url)) {
            if (this.jxO == this.jxI || this.jxO == this.STATE_PAUSE || this.jxO == this.jxK) {
                this.jxO &= -32769;
                this.jxO &= -131073;
                zy(this.jxO);
            }
            this.jxI &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jxK &= -131073;
            return;
        }
        if (this.jxO == this.jxI || this.jxO == this.STATE_PAUSE) {
            this.jxO |= 32768;
            zy(this.jxO);
        }
        if (this.jxO == this.jxK) {
            this.jxO |= 131072;
            zy(this.jxO);
        }
        this.jxI |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jxK |= 131072;
        this.jaJ.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.Pj = bjVar.getTid();
            yVar.emb = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.iIg = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.iIg == 0) {
                        this.iIg = intent.getIntExtra("key_start_from", 0);
                    }
                    this.iIh = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.iIh)) {
                        yVar.cOR = this.iIh;
                    }
                    yVar.jwI = Integer.toString(this.iIg);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jwI = this.source;
                }
            }
            if (bjVar.aCF() != null) {
                yVar.jwK = bjVar.aCF().video_md5;
                yVar.jwM = String.valueOf(bjVar.aCF().is_vertical);
            }
            c(yVar);
            this.jaO = false;
            this.jaJ.setIsCountDownValid(true);
            if (this.iDO && bjVar.aCF() != null) {
                if (this.Pi != (bjVar.aCF().is_vertical.intValue() == 1)) {
                    czH();
                }
            }
            super.setData(bjVar);
            rQ(!this.Pi);
            if (bjVar.aCo() != null) {
                bjVar.aCo().setIsLike(bjVar.aCo().hadConcerned());
            }
            this.jaI.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctO() {
        super.ctO();
        if (this.iDO) {
            ctU();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.jaI.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iDO || motionEvent.getX() > ((float) this.iYk);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ctP() {
        return false;
    }

    public void ctQ() {
        this.jaN = false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean ctR() {
        return !this.jaN && this.jxX.cub();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctS() {
        this.STATE_STOP &= -33;
        this.jxG &= -33;
        this.jxH &= -33;
        this.jxI &= -33;
        this.STATE_PAUSE &= -33;
        this.jxJ &= -33;
        this.jxK &= -33;
        this.jxL &= -33;
        this.jxM &= -33;
        this.STATE_STOP |= 1024;
        this.jxG |= 1024;
        this.jxH &= -1025;
        this.jxI |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jxJ |= 1024;
        this.jxK |= 1024;
        this.jxL |= 1024;
        this.jxM &= -1025;
        this.jxG |= 16384;
        this.jxJ |= 16384;
        this.jxK &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctT() {
        int i = 0;
        this.jxX.ah(this.Pi, this.iDO);
        this.jxY.ah(this.Pi, this.iDO);
        if (this.jxW instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jxW).ah(this.Pi, this.iDO);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jxV.getLayoutParams();
        int dimens = (this.iDO && this.Pi) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iDO && !this.Pi) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jaK.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jaL.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iDO || this.Pi) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.jaJ.ah(this.Pi, this.iDO);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zy(int i) {
        if (i != this.STATE_PAUSE && i != this.jxJ && i != this.jxI && i != this.jxG) {
            ctX();
            if (this.jaI != null) {
                this.jaI.setVisibility(8);
            }
        }
        if (this.jxO != this.jxM && i == this.jxM) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaR);
            if ((this.jxO & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jxO & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jxM = i;
        }
        super.zy(i);
        if (!this.iDO) {
            this.jxZ.setVisibility(8);
            this.jya.setVisibility(8);
            if (this.jaQ != null) {
                this.jaQ.qW((i & 1024) > 0);
            }
        }
        if (this.jxW instanceof PbVideoMediaController) {
            this.jxW.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jxW).setBottomBarShow((i & 16384) > 0);
        }
        if (this.jaK != null) {
            this.jaK.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.jaL != null) {
            this.jaL.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.jaJ != null) {
            boolean z = (131072 & i) > 0;
            this.jaJ.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(zW("c13600"));
            }
        }
        if (!this.iDO && !this.iYL && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.iYM) {
                    if (this.iZY == null || !this.iZY.cta()) {
                        csX();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.iYM = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iYP);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.iYP, 3000L);
                }
            } else if (this.iYM || (this.iZY != null && this.iZY.cta())) {
                ctY();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ra(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.iDO);
        }
        super.ra(z);
        ctX();
        if (this.iDO) {
            ctU();
        } else {
            this.jaI.setVisibility(8);
        }
    }

    private void ctU() {
        if (!this.jaO && !this.jaI.cua()) {
            this.jaI.setTranslationX(0.0f);
            this.jaI.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jaI.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.Pi ? R.dimen.tbds248 : R.dimen.tbds428);
            this.jaP = ObjectAnimator.ofFloat(this.jaI, "translationX", 0.0f);
            this.jaP.setDuration(500);
            ctX();
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jaS, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean ctV() {
        if (this.jxO == this.jxM) {
            return false;
        }
        this.jyb.setVisibility(0);
        this.jyb.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaR);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jaR, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean ctW() {
        if (this.jxO == this.jxM) {
            return false;
        }
        this.jyb.setVisibility(0);
        this.jyb.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaR);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jaR, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                this.jaN = true;
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                ctX();
                com.baidu.adp.lib.f.e.gx().post(this.jaT);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.jaQ != null) {
                    this.jaQ.qX(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.jaQ != null) {
                    this.jaQ.ctq();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jxK &= -131073;
                this.jxO &= -131073;
                this.jaJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        ctX();
        this.jaI.setVisibility(8);
        if (!this.iYL) {
            ctY();
        }
        if (z) {
            this.jaM = this.jxO;
            if (this.jxO == this.STATE_PAUSE || ((this.jxO == this.jxJ && !this.jtu.isPlaying()) || this.jxO == this.jxK)) {
                this.jaM |= 1;
            }
            stopPlay();
            return true;
        } else if (this.jaM == -1) {
            startPlay();
            return true;
        } else if (this.jaM == this.jxG || this.jaM == this.jxI) {
            startPlay();
            return true;
        } else {
            this.jxW.setCurrentDuration(x.czs().Hd(this.mVideoUrl), false);
            zy(this.jaM);
            return true;
        }
    }

    private an zW(String str) {
        an cy = new an(str).cy("tid", this.Pj).s("fid", this.mFid).cy("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            cy.cy("obj_param4", this.baijiahaoData.oriUgcNid);
            cy.cy("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                cy.X("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                cy.X("obj_param5", 3);
            }
        } else {
            cy.X("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).clB() != null) {
            cy.cy(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).clB().cos()).cy("obj_id", ((PbActivity) this.mContext).clB().cot()).cy("obj_source", ((PbActivity) this.mContext).clB().cor());
        }
        return cy;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void zz(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new an("c13598"));
            } else {
                TiebaStatic.log(new an("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(zW("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(zW("c13601").X("obj_type", this.jaJ.jaz ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctX() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaS);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctY() {
        csY();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.iYM = false;
        if (this.iZY != null) {
            this.iZY.qS(false);
        }
    }

    private void csX() {
        if (this.iYQ == null) {
            this.iYQ = ObjectAnimator.ofFloat(this.iYv, "alpha", 0.0f, 1.0f);
            this.iYQ.setDuration(200L);
        }
        this.iYQ.start();
    }

    private void csY() {
        if (this.iYR == null) {
            this.iYR = ObjectAnimator.ofFloat(this.iYv, "alpha", 1.0f, 0.0f);
            this.iYR.setDuration(200L);
        }
        this.iYR.start();
    }

    public void onDestroy() {
        ctX();
        rQ(false);
    }

    public boolean bim() {
        return this.Pi;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.iZY = videoPbFragment;
    }

    public void cH(View view) {
        this.mRootView = view;
    }

    public void cI(View view) {
        this.iYv = view;
    }

    public boolean cta() {
        return this.iYM;
    }

    public void qS(boolean z) {
        this.iYM = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctZ() {
        com.baidu.tieba.play.y czt = this.jyh.czc().czt();
        czt.mLocate = "pb";
        com.baidu.tieba.play.l.a(czt.jwK, "", "2", czt);
    }
}
