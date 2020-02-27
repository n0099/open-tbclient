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
    private int iIe;
    private String iIf;
    private boolean iYJ;
    private boolean iYK;
    private Runnable iYN;
    private ObjectAnimator iYO;
    private ObjectAnimator iYP;
    private int iYi;
    private View iYt;
    private VideoPbFragment iZW;
    private final int jaA;
    private final int jaB;
    private final int jaC;
    private final int jaD;
    private final int jaE;
    private final int jaF;
    private PbVideoFullscreenAttentionLayout jaG;
    private PbNextVideoLayout jaH;
    private ImageView jaI;
    private ImageView jaJ;
    private int jaK;
    private boolean jaL;
    private boolean jaM;
    private ObjectAnimator jaN;
    private e jaO;
    private Runnable jaP;
    private Runnable jaQ;
    private Runnable jaR;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.jaA = 16384;
        this.jaB = 32768;
        this.jaC = 65536;
        this.jaD = 131072;
        this.jaE = 5000;
        this.jaF = 1500;
        this.jaK = -1;
        this.iIe = 0;
        this.jaP = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jxZ.setVisibility(8);
            }
        };
        this.jaQ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jaG.ctY()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.Pi ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.jaM = true;
                    a.this.jaN.setFloatValues(-l.getDimens(context2, i));
                    a.this.jaN.removeAllListeners();
                    a.this.jaN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.ctV();
                            com.baidu.adp.lib.f.e.gx().postDelayed(a.this.jaR, 5000L);
                        }
                    });
                    a.this.jaN.start();
                }
            }
        };
        this.jaR = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jaN.setFloatValues(l.getDimens(a.this.mContext, a.this.Pi ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.jaN.removeAllListeners();
                a.this.jaN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.jaG.setVisibility(8);
                    }
                });
                a.this.jaN.start();
            }
        };
        this.iYN = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iYK && (a.this.mContext instanceof Activity)) {
                    a.this.ctW();
                }
            }
        };
        ctQ();
        if (context instanceof PbActivity) {
            this.jaO = (e) y.b((PbActivity) context).l(e.class);
            this.iYJ = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        rQ(true);
        this.jyg = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jaG = (PbVideoFullscreenAttentionLayout) this.jyc.findViewById(R.id.video_fullscreen_attention);
        this.jaH = (PbNextVideoLayout) this.jyc.findViewById(R.id.video_next_layout);
        this.jaI = (ImageView) this.jyc.findViewById(R.id.video_pre);
        this.jaJ = (ImageView) this.jyc.findViewById(R.id.video_next);
        SvgManager.aGA().a(this.jaI, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aGA().a(this.jaJ, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.OY.aSQ();
        this.OY.setDrawCorner(false);
        this.jaG.setOnClickEvent(this);
        this.jaI.setOnClickListener(this);
        this.jaJ.setOnClickListener(this);
        this.jaH.setOnClickListener(this);
        this.iYi = l.getEquipmentWidth(this.mContext) / 10;
        this.jxW.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void ctL() {
        this.jts.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void qZ(boolean z) {
        this.jaH.setIsCountDownValid(z);
    }

    public void aQ(bj bjVar) {
        if (bjVar == null || bjVar.aCD() == null || aq.isEmpty(bjVar.aCD().video_url)) {
            if (this.jxM == this.jxG || this.jxM == this.STATE_PAUSE) {
                this.jxM &= -65537;
                zy(this.jxM);
            }
            this.jxG &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jxM == this.jxG || this.jxM == this.STATE_PAUSE) {
            this.jxM |= 65536;
            zy(this.jxM);
        }
        this.jxG |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aR(bj bjVar) {
        if (bjVar == null || bjVar.aCD() == null || aq.isEmpty(bjVar.aCD().video_url)) {
            if (this.jxM == this.jxG || this.jxM == this.STATE_PAUSE || this.jxM == this.jxI) {
                this.jxM &= -32769;
                this.jxM &= -131073;
                zy(this.jxM);
            }
            this.jxG &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jxI &= -131073;
            return;
        }
        if (this.jxM == this.jxG || this.jxM == this.STATE_PAUSE) {
            this.jxM |= 32768;
            zy(this.jxM);
        }
        if (this.jxM == this.jxI) {
            this.jxM |= 131072;
            zy(this.jxM);
        }
        this.jxG |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jxI |= 131072;
        this.jaH.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.Pj = bjVar.getTid();
            yVar.ema = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.iIe = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.iIe == 0) {
                        this.iIe = intent.getIntExtra("key_start_from", 0);
                    }
                    this.iIf = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.iIf)) {
                        yVar.cOQ = this.iIf;
                    }
                    yVar.jwG = Integer.toString(this.iIe);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jwG = this.source;
                }
            }
            if (bjVar.aCD() != null) {
                yVar.jwI = bjVar.aCD().video_md5;
                yVar.jwK = String.valueOf(bjVar.aCD().is_vertical);
            }
            c(yVar);
            this.jaM = false;
            this.jaH.setIsCountDownValid(true);
            if (this.iDM && bjVar.aCD() != null) {
                if (this.Pi != (bjVar.aCD().is_vertical.intValue() == 1)) {
                    czF();
                }
            }
            super.setData(bjVar);
            rQ(!this.Pi);
            if (bjVar.aCm() != null) {
                bjVar.aCm().setIsLike(bjVar.aCm().hadConcerned());
            }
            this.jaG.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctM() {
        super.ctM();
        if (this.iDM) {
            ctS();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.jaG.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iDM || motionEvent.getX() > ((float) this.iYi);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ctN() {
        return false;
    }

    public void ctO() {
        this.jaL = false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean ctP() {
        return !this.jaL && this.jxV.ctZ();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctQ() {
        this.STATE_STOP &= -33;
        this.jxE &= -33;
        this.jxF &= -33;
        this.jxG &= -33;
        this.STATE_PAUSE &= -33;
        this.jxH &= -33;
        this.jxI &= -33;
        this.jxJ &= -33;
        this.jxK &= -33;
        this.STATE_STOP |= 1024;
        this.jxE |= 1024;
        this.jxF &= -1025;
        this.jxG |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jxH |= 1024;
        this.jxI |= 1024;
        this.jxJ |= 1024;
        this.jxK &= -1025;
        this.jxE |= 16384;
        this.jxH |= 16384;
        this.jxI &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctR() {
        int i = 0;
        this.jxV.ah(this.Pi, this.iDM);
        this.jxW.ah(this.Pi, this.iDM);
        if (this.jxU instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jxU).ah(this.Pi, this.iDM);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jxT.getLayoutParams();
        int dimens = (this.iDM && this.Pi) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iDM && !this.Pi) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jaI.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jaJ.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iDM || this.Pi) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.jaH.ah(this.Pi, this.iDM);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zy(int i) {
        if (i != this.STATE_PAUSE && i != this.jxH && i != this.jxG && i != this.jxE) {
            ctV();
            if (this.jaG != null) {
                this.jaG.setVisibility(8);
            }
        }
        if (this.jxM != this.jxK && i == this.jxK) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaP);
            if ((this.jxM & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jxM & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jxK = i;
        }
        super.zy(i);
        if (!this.iDM) {
            this.jxX.setVisibility(8);
            this.jxY.setVisibility(8);
            if (this.jaO != null) {
                this.jaO.qW((i & 1024) > 0);
            }
        }
        if (this.jxU instanceof PbVideoMediaController) {
            this.jxU.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jxU).setBottomBarShow((i & 16384) > 0);
        }
        if (this.jaI != null) {
            this.jaI.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.jaJ != null) {
            this.jaJ.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.jaH != null) {
            boolean z = (131072 & i) > 0;
            this.jaH.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(zW("c13600"));
            }
        }
        if (!this.iDM && !this.iYJ && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.iYK) {
                    if (this.iZW == null || !this.iZW.csY()) {
                        csV();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.iYK = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iYN);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.iYN, 3000L);
                }
            } else if (this.iYK || (this.iZW != null && this.iZW.csY())) {
                ctW();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ra(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.iDM);
        }
        super.ra(z);
        ctV();
        if (this.iDM) {
            ctS();
        } else {
            this.jaG.setVisibility(8);
        }
    }

    private void ctS() {
        if (!this.jaM && !this.jaG.ctY()) {
            this.jaG.setTranslationX(0.0f);
            this.jaG.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jaG.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.Pi ? R.dimen.tbds248 : R.dimen.tbds428);
            this.jaN = ObjectAnimator.ofFloat(this.jaG, "translationX", 0.0f);
            this.jaN.setDuration(500);
            ctV();
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jaQ, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean ctT() {
        if (this.jxM == this.jxK) {
            return false;
        }
        this.jxZ.setVisibility(0);
        this.jxZ.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaP);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jaP, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean ctU() {
        if (this.jxM == this.jxK) {
            return false;
        }
        this.jxZ.setVisibility(0);
        this.jxZ.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaP);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jaP, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                this.jaL = true;
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                ctV();
                com.baidu.adp.lib.f.e.gx().post(this.jaR);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.jaO != null) {
                    this.jaO.qX(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.jaO != null) {
                    this.jaO.cto();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jxI &= -131073;
                this.jxM &= -131073;
                this.jaH.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        ctV();
        this.jaG.setVisibility(8);
        if (!this.iYJ) {
            ctW();
        }
        if (z) {
            this.jaK = this.jxM;
            if (this.jxM == this.STATE_PAUSE || ((this.jxM == this.jxH && !this.jts.isPlaying()) || this.jxM == this.jxI)) {
                this.jaK |= 1;
            }
            stopPlay();
            return true;
        } else if (this.jaK == -1) {
            startPlay();
            return true;
        } else if (this.jaK == this.jxE || this.jaK == this.jxG) {
            startPlay();
            return true;
        } else {
            this.jxU.setCurrentDuration(x.czq().Hd(this.mVideoUrl), false);
            zy(this.jaK);
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).clz() != null) {
            cy.cy(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).clz().coq()).cy("obj_id", ((PbActivity) this.mContext).clz().cor()).cy("obj_source", ((PbActivity) this.mContext).clz().cop());
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
            TiebaStatic.log(zW("c13601").X("obj_type", this.jaH.jax ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctV() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaQ);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctW() {
        csW();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.iYK = false;
        if (this.iZW != null) {
            this.iZW.qS(false);
        }
    }

    private void csV() {
        if (this.iYO == null) {
            this.iYO = ObjectAnimator.ofFloat(this.iYt, "alpha", 0.0f, 1.0f);
            this.iYO.setDuration(200L);
        }
        this.iYO.start();
    }

    private void csW() {
        if (this.iYP == null) {
            this.iYP = ObjectAnimator.ofFloat(this.iYt, "alpha", 1.0f, 0.0f);
            this.iYP.setDuration(200L);
        }
        this.iYP.start();
    }

    public void onDestroy() {
        ctV();
        rQ(false);
    }

    public boolean bik() {
        return this.Pi;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.iZW = videoPbFragment;
    }

    public void cH(View view) {
        this.mRootView = view;
    }

    public void cI(View view) {
        this.iYt = view;
    }

    public boolean csY() {
        return this.iYK;
    }

    public void qS(boolean z) {
        this.iYK = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctX() {
        com.baidu.tieba.play.y czr = this.jyf.cza().czr();
        czr.mLocate = "pb";
        com.baidu.tieba.play.l.a(czr.jwI, "", "2", czr);
    }
}
