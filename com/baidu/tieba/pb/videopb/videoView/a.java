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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bk;
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
    private int jMi;
    private String jMj;
    private boolean kdC;
    private boolean kdD;
    private Runnable kdF;
    private ObjectAnimator kdG;
    private ObjectAnimator kdH;
    private int kda;
    private View kdl;
    private VideoPbFragment keQ;
    private final int kfA;
    private final int kfB;
    private final int kfC;
    private PbVideoFullscreenAttentionLayout kfD;
    private PbNextVideoLayout kfE;
    private ImageView kfF;
    private ImageView kfG;
    private int kfH;
    private boolean kfI;
    private ObjectAnimator kfJ;
    private e kfK;
    private Runnable kfL;
    private Runnable kfM;
    private Runnable kfN;
    private final int kfx;
    private final int kfy;
    private final int kfz;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.kfx = 16384;
        this.kfy = 32768;
        this.kfz = 65536;
        this.kfA = 131072;
        this.kfB = 5000;
        this.kfC = 1500;
        this.kfH = -1;
        this.jMi = 0;
        this.kfL = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.kCX.setVisibility(8);
            }
        };
        this.kfM = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kfD.cMm()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.air ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.kfI = true;
                    a.this.kfJ.setFloatValues(-l.getDimens(context2, i));
                    a.this.kfJ.removeAllListeners();
                    a.this.kfJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cMk();
                            com.baidu.adp.lib.f.e.ld().postDelayed(a.this.kfN, 5000L);
                        }
                    });
                    a.this.kfJ.start();
                }
            }
        };
        this.kfN = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.kfJ.setFloatValues(l.getDimens(a.this.mContext, a.this.air ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.kfJ.removeAllListeners();
                a.this.kfJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kfD.setVisibility(8);
                    }
                });
                a.this.kfJ.start();
            }
        };
        this.kdF = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kdD && (a.this.mContext instanceof Activity)) {
                    a.this.aod();
                }
            }
        };
        cMf();
        if (context instanceof PbActivity) {
            this.kfK = (e) y.b((PbActivity) context).l(e.class);
            this.kdC = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        ty(true);
        this.kDe = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kfD = (PbVideoFullscreenAttentionLayout) this.kDa.findViewById(R.id.video_fullscreen_attention);
        this.kfE = (PbNextVideoLayout) this.kDa.findViewById(R.id.video_next_layout);
        this.kfF = (ImageView) this.kDa.findViewById(R.id.video_pre);
        this.kfG = (ImageView) this.kDa.findViewById(R.id.video_next);
        SvgManager.aUW().a(this.kfF, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aUW().a(this.kfG, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.aii.bhs();
        this.aii.setDrawCorner(false);
        this.kfD.setOnClickEvent(this);
        this.kfF.setOnClickListener(this);
        this.kfG.setOnClickListener(this);
        this.kfE.setOnClickListener(this);
        this.kda = l.getEquipmentWidth(this.mContext) / 10;
        this.kCU.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cMc() {
        this.kxZ.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void sH(boolean z) {
        this.kfE.setIsCountDownValid(z);
    }

    public void aS(bk bkVar) {
        if (bkVar == null || bkVar.aQQ() == null || aq.isEmpty(bkVar.aQQ().video_url)) {
            if (this.kCK == this.kCD || this.kCK == this.kCE) {
                this.kCK &= -65537;
                AU(this.kCK);
            }
            this.kCD &= -65537;
            this.kCE &= -65537;
            return;
        }
        if (this.kCK == this.kCD || this.kCK == this.kCE) {
            this.kCK |= 65536;
            AU(this.kCK);
        }
        this.kCD |= 65536;
        this.kCE |= 65536;
    }

    public void aT(bk bkVar) {
        if (bkVar == null || bkVar.aQQ() == null || aq.isEmpty(bkVar.aQQ().video_url)) {
            if (this.kCK == this.kCD || this.kCK == this.kCE || this.kCK == this.kCG) {
                this.kCK &= -32769;
                this.kCK &= -131073;
                AU(this.kCK);
            }
            this.kCD &= -32769;
            this.kCE &= -32769;
            this.kCG &= -131073;
            return;
        }
        if (this.kCK == this.kCD || this.kCK == this.kCE) {
            this.kCK |= 32768;
            AU(this.kCK);
        }
        if (this.kCK == this.kCG) {
            this.kCK |= 131072;
            AU(this.kCK);
        }
        this.kCD |= 32768;
        this.kCE |= 32768;
        this.kCG |= 131072;
        this.kfE.setDate(bkVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        if (bkVar != null) {
            this.baijiahaoData = bkVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.ais = bkVar.getTid();
            yVar.evm = Long.toString(bkVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bkVar.isBjh()) {
                    this.jMi = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.jMi == 0) {
                        this.jMi = intent.getIntExtra("key_start_from", 0);
                    }
                    this.jMj = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.jMj)) {
                        yVar.dCp = this.jMj;
                    }
                    yVar.kBt = Integer.toString(this.jMi);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.kBt = this.source;
                }
            }
            if (bkVar.aQQ() != null) {
                yVar.kBw = bkVar.aQQ().video_md5;
                yVar.kBy = String.valueOf(bkVar.aQQ().is_vertical);
            }
            c(yVar);
            this.kfI = false;
            this.kfE.setIsCountDownValid(true);
            if (this.jHB && bkVar.aQQ() != null) {
                if (this.air != (bkVar.aQQ().is_vertical.intValue() == 1)) {
                    cSa();
                }
            }
            super.setData(bkVar);
            ty(!this.air);
            if (bkVar.aQx() != null) {
                bkVar.aQx().setIsLike(bkVar.aQx().hadConcerned());
            }
            this.kfD.setData(bkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMd() {
        super.cMd();
        if (this.jHB) {
            cMh();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kfD.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean J(MotionEvent motionEvent) {
        return this.jHB || motionEvent.getX() > ((float) this.kda);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cMe() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMf() {
        this.kCA &= -33;
        this.kCB &= -33;
        this.kCC &= -33;
        this.kCD &= -33;
        this.kCE &= -33;
        this.kCF &= -33;
        this.kCG &= -33;
        this.kCH &= -33;
        this.kCI &= -33;
        this.kCA |= 1024;
        this.kCB |= 1024;
        this.kCC &= -1025;
        this.kCD |= 1024;
        this.kCE |= 1024;
        this.kCF |= 1024;
        this.kCG |= 1024;
        this.kCH |= 1024;
        this.kCI &= -1025;
        this.kCB |= 16384;
        this.kCF |= 16384;
        this.kCG &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMg() {
        int i = 0;
        this.kCT.al(this.air, this.jHB);
        this.kCU.al(this.air, this.jHB);
        if (this.kCS instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.kCS).al(this.air, this.jHB);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCR.getLayoutParams();
        int dimens = (this.jHB && this.air) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.jHB && !this.air) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kfF.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kfG.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.jHB || this.air) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kfE.al(this.air, this.jHB);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void AU(int i) {
        if (i != this.kCE && i != this.kCF && i != this.kCD && i != this.kCB) {
            cMk();
            if (this.kfD != null) {
                this.kfD.setVisibility(8);
            }
        }
        if (this.kCK != this.kCI && i == this.kCI) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kfL);
            if ((this.kCK & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.kCK & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.kCI = i;
        }
        super.AU(i);
        if (!this.jHB) {
            this.kCV.setVisibility(8);
            this.kCW.setVisibility(8);
            if (this.kfK != null) {
                this.kfK.sE((i & 1024) > 0);
            }
        }
        if (this.kCS instanceof PbVideoMediaController) {
            this.kCS.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.kCS).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kfF != null) {
            this.kfF.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.kfG != null) {
            this.kfG.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kfE != null) {
            boolean z = (131072 & i) > 0;
            this.kfE.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Dr("c13600"));
            }
        }
        if (!this.jHB && !this.kdC && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kdD) {
                    if (this.keQ == null || !this.keQ.cLn()) {
                        cLk();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kdD = true;
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kdF);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.kdF, 3000L);
                }
            } else if (this.kdD || (this.keQ != null && this.keQ.cLn())) {
                aod();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void sI(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.jHB);
        }
        super.sI(z);
        cMk();
        if (this.jHB) {
            cMh();
        } else {
            this.kfD.setVisibility(8);
        }
    }

    private void cMh() {
        if (!this.kfI && !this.kfD.cMm()) {
            this.kfD.setTranslationX(0.0f);
            this.kfD.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kfD.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.air ? R.dimen.tbds248 : R.dimen.tbds428);
            this.kfJ = ObjectAnimator.ofFloat(this.kfD, "translationX", 0.0f);
            this.kfJ.setDuration(500);
            cMk();
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kfM, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cMi() {
        if (this.kCK == this.kCI) {
            return false;
        }
        this.kCX.setVisibility(0);
        this.kCX.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kfL);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kfL, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cMj() {
        if (this.kCK == this.kCI) {
            return false;
        }
        this.kCX.setVisibility(0);
        this.kCX.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kfL);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kfL, 1500L);
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
                cMk();
                com.baidu.adp.lib.f.e.ld().post(this.kfN);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.kfK != null) {
                    this.kfK.sF(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.kfK != null) {
                    this.kfK.cLD();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.kCG &= -131073;
                this.kCK &= -131073;
                this.kfE.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean or(boolean z) {
        cMk();
        this.kfD.setVisibility(8);
        if (!this.kdC) {
            aod();
        }
        if (z) {
            this.kfH = this.kCK;
            if (this.kCK == this.kCE || ((this.kCK == this.kCF && !this.kxZ.isPlaying()) || this.kCK == this.kCG)) {
                this.kfH |= 1;
            }
            stopPlay();
            return true;
        } else if (this.kfH == -1) {
            startPlay();
            return true;
        } else if (this.kfH == this.kCB || this.kfH == this.kCD || this.kfH == this.kCC) {
            startPlay();
            return true;
        } else {
            this.kCS.setCurrentDuration(x.cRE().KB(this.mVideoUrl), false);
            AU(this.kfH);
            return true;
        }
    }

    private an Dr(String str) {
        an dh = new an(str).dh("tid", this.ais).s("fid", this.mFid).dh("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dh.dh("obj_param4", this.baijiahaoData.oriUgcNid);
            dh.dh("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dh.ag("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dh.ag("obj_param5", 3);
            }
        } else {
            dh.ag("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cDO() != null) {
            dh.dh("ab_tag", ((PbActivity) this.mContext).cDO().cGE()).dh("obj_id", ((PbActivity) this.mContext).cDO().cGF()).dh("obj_source", ((PbActivity) this.mContext).cDO().cGD());
        }
        return dh;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void AV(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new an("c13598"));
            } else {
                TiebaStatic.log(new an("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Dr("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Dr("c13601").ag("obj_type", this.kfE.kfu ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMk() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kfM);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kfN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aod() {
        cLl();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kdD = false;
        if (this.keQ != null) {
            this.keQ.sA(false);
        }
    }

    private void cLk() {
        if (this.kdG == null) {
            this.kdG = ObjectAnimator.ofFloat(this.kdl, "alpha", 0.0f, 1.0f);
            this.kdG.setDuration(200L);
        }
        this.kdG.start();
    }

    private void cLl() {
        if (this.kdH == null) {
            this.kdH = ObjectAnimator.ofFloat(this.kdl, "alpha", 1.0f, 0.0f);
            this.kdH.setDuration(200L);
        }
        this.kdH.start();
    }

    public void onDestroy() {
        cMk();
        ty(false);
    }

    public boolean bxE() {
        return this.air;
    }

    public void ac(VideoPbFragment videoPbFragment) {
        this.keQ = videoPbFragment;
    }

    public void cQ(View view) {
        this.mRootView = view;
    }

    public void cR(View view) {
        this.kdl = view;
    }

    public boolean cLn() {
        return this.kdD;
    }

    public void sA(boolean z) {
        this.kdD = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMl() {
        com.baidu.tieba.play.y cRF = this.kDd.cRo().cRF();
        cRF.mLocate = "pb";
        com.baidu.tieba.play.l.a(cRF.kBw, "", "2", cRF, this.kxZ.getPcdnState());
    }
}
