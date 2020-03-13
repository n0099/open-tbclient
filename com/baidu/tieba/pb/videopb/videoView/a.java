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
    private int iIs;
    private String iIt;
    private View iYH;
    private boolean iYX;
    private boolean iYY;
    private int iYw;
    private Runnable iZb;
    private ObjectAnimator iZc;
    private ObjectAnimator iZd;
    private final int jaO;
    private final int jaP;
    private final int jaQ;
    private final int jaR;
    private final int jaS;
    private final int jaT;
    private PbVideoFullscreenAttentionLayout jaU;
    private PbNextVideoLayout jaV;
    private ImageView jaW;
    private ImageView jaX;
    private int jaY;
    private boolean jaZ;
    private VideoPbFragment jak;
    private boolean jba;
    private ObjectAnimator jbb;
    private e jbc;
    private Runnable jbd;
    private Runnable jbe;
    private Runnable jbf;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.jaO = 16384;
        this.jaP = 32768;
        this.jaQ = 65536;
        this.jaR = 131072;
        this.jaS = 5000;
        this.jaT = 1500;
        this.jaY = -1;
        this.iIs = 0;
        this.jbd = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jyn.setVisibility(8);
            }
        };
        this.jbe = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jaU.cub()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.Pi ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.jba = true;
                    a.this.jbb.setFloatValues(-l.getDimens(context2, i));
                    a.this.jbb.removeAllListeners();
                    a.this.jbb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.ctY();
                            com.baidu.adp.lib.f.e.gx().postDelayed(a.this.jbf, 5000L);
                        }
                    });
                    a.this.jbb.start();
                }
            }
        };
        this.jbf = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jbb.setFloatValues(l.getDimens(a.this.mContext, a.this.Pi ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.jbb.removeAllListeners();
                a.this.jbb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.jaU.setVisibility(8);
                    }
                });
                a.this.jbb.start();
            }
        };
        this.iZb = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iYY && (a.this.mContext instanceof Activity)) {
                    a.this.ctZ();
                }
            }
        };
        ctT();
        if (context instanceof PbActivity) {
            this.jbc = (e) y.b((PbActivity) context).l(e.class);
            this.iYX = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        rQ(true);
        this.jyu = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jaU = (PbVideoFullscreenAttentionLayout) this.jyq.findViewById(R.id.video_fullscreen_attention);
        this.jaV = (PbNextVideoLayout) this.jyq.findViewById(R.id.video_next_layout);
        this.jaW = (ImageView) this.jyq.findViewById(R.id.video_pre);
        this.jaX = (ImageView) this.jyq.findViewById(R.id.video_next);
        SvgManager.aGC().a(this.jaW, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aGC().a(this.jaX, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.OY.aST();
        this.OY.setDrawCorner(false);
        this.jaU.setOnClickEvent(this);
        this.jaW.setOnClickListener(this);
        this.jaX.setOnClickListener(this);
        this.jaV.setOnClickListener(this);
        this.iYw = l.getEquipmentWidth(this.mContext) / 10;
        this.jyk.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void ctO() {
        this.jtG.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void qZ(boolean z) {
        this.jaV.setIsCountDownValid(z);
    }

    public void aQ(bj bjVar) {
        if (bjVar == null || bjVar.aCF() == null || aq.isEmpty(bjVar.aCF().video_url)) {
            if (this.jya == this.jxU || this.jya == this.STATE_PAUSE) {
                this.jya &= -65537;
                zy(this.jya);
            }
            this.jxU &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jya == this.jxU || this.jya == this.STATE_PAUSE) {
            this.jya |= 65536;
            zy(this.jya);
        }
        this.jxU |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aR(bj bjVar) {
        if (bjVar == null || bjVar.aCF() == null || aq.isEmpty(bjVar.aCF().video_url)) {
            if (this.jya == this.jxU || this.jya == this.STATE_PAUSE || this.jya == this.jxW) {
                this.jya &= -32769;
                this.jya &= -131073;
                zy(this.jya);
            }
            this.jxU &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jxW &= -131073;
            return;
        }
        if (this.jya == this.jxU || this.jya == this.STATE_PAUSE) {
            this.jya |= 32768;
            zy(this.jya);
        }
        if (this.jya == this.jxW) {
            this.jya |= 131072;
            zy(this.jya);
        }
        this.jxU |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jxW |= 131072;
        this.jaV.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.Pj = bjVar.getTid();
            yVar.emo = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.iIs = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.iIs == 0) {
                        this.iIs = intent.getIntExtra("key_start_from", 0);
                    }
                    this.iIt = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.iIt)) {
                        yVar.cOS = this.iIt;
                    }
                    yVar.jwU = Integer.toString(this.iIs);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jwU = this.source;
                }
            }
            if (bjVar.aCF() != null) {
                yVar.jwW = bjVar.aCF().video_md5;
                yVar.jwY = String.valueOf(bjVar.aCF().is_vertical);
            }
            c(yVar);
            this.jba = false;
            this.jaV.setIsCountDownValid(true);
            if (this.iEa && bjVar.aCF() != null) {
                if (this.Pi != (bjVar.aCF().is_vertical.intValue() == 1)) {
                    czI();
                }
            }
            super.setData(bjVar);
            rQ(!this.Pi);
            if (bjVar.aCo() != null) {
                bjVar.aCo().setIsLike(bjVar.aCo().hadConcerned());
            }
            this.jaU.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctP() {
        super.ctP();
        if (this.iEa) {
            ctV();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.jaU.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iEa || motionEvent.getX() > ((float) this.iYw);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ctQ() {
        return false;
    }

    public void ctR() {
        this.jaZ = false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean ctS() {
        return !this.jaZ && this.jyj.cuc();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctT() {
        this.STATE_STOP &= -33;
        this.jxS &= -33;
        this.jxT &= -33;
        this.jxU &= -33;
        this.STATE_PAUSE &= -33;
        this.jxV &= -33;
        this.jxW &= -33;
        this.jxX &= -33;
        this.jxY &= -33;
        this.STATE_STOP |= 1024;
        this.jxS |= 1024;
        this.jxT &= -1025;
        this.jxU |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jxV |= 1024;
        this.jxW |= 1024;
        this.jxX |= 1024;
        this.jxY &= -1025;
        this.jxS |= 16384;
        this.jxV |= 16384;
        this.jxW &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctU() {
        int i = 0;
        this.jyj.ah(this.Pi, this.iEa);
        this.jyk.ah(this.Pi, this.iEa);
        if (this.jyi instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jyi).ah(this.Pi, this.iEa);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jyh.getLayoutParams();
        int dimens = (this.iEa && this.Pi) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iEa && !this.Pi) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jaW.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jaX.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iEa || this.Pi) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.jaV.ah(this.Pi, this.iEa);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zy(int i) {
        if (i != this.STATE_PAUSE && i != this.jxV && i != this.jxU && i != this.jxS) {
            ctY();
            if (this.jaU != null) {
                this.jaU.setVisibility(8);
            }
        }
        if (this.jya != this.jxY && i == this.jxY) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbd);
            if ((this.jya & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jya & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jxY = i;
        }
        super.zy(i);
        if (!this.iEa) {
            this.jyl.setVisibility(8);
            this.jym.setVisibility(8);
            if (this.jbc != null) {
                this.jbc.qW((i & 1024) > 0);
            }
        }
        if (this.jyi instanceof PbVideoMediaController) {
            this.jyi.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jyi).setBottomBarShow((i & 16384) > 0);
        }
        if (this.jaW != null) {
            this.jaW.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.jaX != null) {
            this.jaX.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.jaV != null) {
            boolean z = (131072 & i) > 0;
            this.jaV.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(zX("c13600"));
            }
        }
        if (!this.iEa && !this.iYX && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.iYY) {
                    if (this.jak == null || !this.jak.ctb()) {
                        csY();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.iYY = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZb);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.iZb, 3000L);
                }
            } else if (this.iYY || (this.jak != null && this.jak.ctb())) {
                ctZ();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ra(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.iEa);
        }
        super.ra(z);
        ctY();
        if (this.iEa) {
            ctV();
        } else {
            this.jaU.setVisibility(8);
        }
    }

    private void ctV() {
        if (!this.jba && !this.jaU.cub()) {
            this.jaU.setTranslationX(0.0f);
            this.jaU.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jaU.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.Pi ? R.dimen.tbds248 : R.dimen.tbds428);
            this.jbb = ObjectAnimator.ofFloat(this.jaU, "translationX", 0.0f);
            this.jbb.setDuration(500);
            ctY();
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jbe, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean ctW() {
        if (this.jya == this.jxY) {
            return false;
        }
        this.jyn.setVisibility(0);
        this.jyn.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbd);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jbd, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean ctX() {
        if (this.jya == this.jxY) {
            return false;
        }
        this.jyn.setVisibility(0);
        this.jyn.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbd);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jbd, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                this.jaZ = true;
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                ctY();
                com.baidu.adp.lib.f.e.gx().post(this.jbf);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.jbc != null) {
                    this.jbc.qX(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.jbc != null) {
                    this.jbc.ctr();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jxW &= -131073;
                this.jya &= -131073;
                this.jaV.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        ctY();
        this.jaU.setVisibility(8);
        if (!this.iYX) {
            ctZ();
        }
        if (z) {
            this.jaY = this.jya;
            if (this.jya == this.STATE_PAUSE || ((this.jya == this.jxV && !this.jtG.isPlaying()) || this.jya == this.jxW)) {
                this.jaY |= 1;
            }
            stopPlay();
            return true;
        } else if (this.jaY == -1) {
            startPlay();
            return true;
        } else if (this.jaY == this.jxS || this.jaY == this.jxU) {
            startPlay();
            return true;
        } else {
            this.jyi.setCurrentDuration(x.czt().He(this.mVideoUrl), false);
            zy(this.jaY);
            return true;
        }
    }

    private an zX(String str) {
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).clC() != null) {
            cy.cy(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).clC().cot()).cy("obj_id", ((PbActivity) this.mContext).clC().cou()).cy("obj_source", ((PbActivity) this.mContext).clC().cos());
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
            TiebaStatic.log(zX("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(zX("c13601").X("obj_type", this.jaV.jaL ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctY() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbe);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctZ() {
        csZ();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.iYY = false;
        if (this.jak != null) {
            this.jak.qS(false);
        }
    }

    private void csY() {
        if (this.iZc == null) {
            this.iZc = ObjectAnimator.ofFloat(this.iYH, "alpha", 0.0f, 1.0f);
            this.iZc.setDuration(200L);
        }
        this.iZc.start();
    }

    private void csZ() {
        if (this.iZd == null) {
            this.iZd = ObjectAnimator.ofFloat(this.iYH, "alpha", 1.0f, 0.0f);
            this.iZd.setDuration(200L);
        }
        this.iZd.start();
    }

    public void onDestroy() {
        ctY();
        rQ(false);
    }

    public boolean bin() {
        return this.Pi;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.jak = videoPbFragment;
    }

    public void cH(View view) {
        this.mRootView = view;
    }

    public void cI(View view) {
        this.iYH = view;
    }

    public boolean ctb() {
        return this.iYY;
    }

    public void qS(boolean z) {
        this.iYY = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cua() {
        com.baidu.tieba.play.y czu = this.jyt.czd().czu();
        czu.mLocate = "pb";
        com.baidu.tieba.play.l.a(czu.jwW, "", "2", czu);
    }
}
