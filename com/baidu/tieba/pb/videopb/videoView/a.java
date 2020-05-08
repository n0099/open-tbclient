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
    private boolean jKK;
    private boolean jKL;
    private Runnable jKN;
    private ObjectAnimator jKO;
    private ObjectAnimator jKP;
    private int jKj;
    private View jKu;
    private VideoPbFragment jLW;
    private final int jMA;
    private final int jMB;
    private final int jMC;
    private final int jMD;
    private final int jME;
    private final int jMF;
    private PbVideoFullscreenAttentionLayout jMG;
    private PbNextVideoLayout jMH;
    private ImageView jMI;
    private ImageView jMJ;
    private int jMK;
    private boolean jML;
    private ObjectAnimator jMM;
    private e jMN;
    private Runnable jMO;
    private Runnable jMP;
    private Runnable jMQ;
    private int jue;
    private String juf;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.jMA = 16384;
        this.jMB = 32768;
        this.jMC = 65536;
        this.jMD = 131072;
        this.jME = 5000;
        this.jMF = 1500;
        this.jMK = -1;
        this.jue = 0;
        this.jMO = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.kjU.setVisibility(8);
            }
        };
        this.jMP = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jMG.cEX()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.ahN ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.jML = true;
                    a.this.jMM.setFloatValues(-l.getDimens(context2, i));
                    a.this.jMM.removeAllListeners();
                    a.this.jMM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cEU();
                            com.baidu.adp.lib.f.e.lb().postDelayed(a.this.jMQ, 5000L);
                        }
                    });
                    a.this.jMM.start();
                }
            }
        };
        this.jMQ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jMM.setFloatValues(l.getDimens(a.this.mContext, a.this.ahN ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.jMM.removeAllListeners();
                a.this.jMM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.jMG.setVisibility(8);
                    }
                });
                a.this.jMM.start();
            }
        };
        this.jKN = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jKL && (a.this.mContext instanceof Activity)) {
                    a.this.cEV();
                }
            }
        };
        cEP();
        if (context instanceof PbActivity) {
            this.jMN = (e) y.b((PbActivity) context).l(e.class);
            this.jKK = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        ta(true);
        this.kkb = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jMG = (PbVideoFullscreenAttentionLayout) this.kjX.findViewById(R.id.video_fullscreen_attention);
        this.jMH = (PbNextVideoLayout) this.kjX.findViewById(R.id.video_next_layout);
        this.jMI = (ImageView) this.kjX.findViewById(R.id.video_pre);
        this.jMJ = (ImageView) this.kjX.findViewById(R.id.video_next);
        SvgManager.aOR().a(this.jMI, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aOR().a(this.jMJ, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ahE.bbf();
        this.ahE.setDrawCorner(false);
        this.jMG.setOnClickEvent(this);
        this.jMI.setOnClickListener(this);
        this.jMJ.setOnClickListener(this);
        this.jMH.setOnClickListener(this);
        this.jKj = l.getEquipmentWidth(this.mContext) / 10;
        this.kjR.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cEM() {
        this.kfd.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void sj(boolean z) {
        this.jMH.setIsCountDownValid(z);
    }

    public void aS(bj bjVar) {
        if (bjVar == null || bjVar.aKT() == null || aq.isEmpty(bjVar.aKT().video_url)) {
            if (this.kjH == this.kjA || this.kjH == this.kjB) {
                this.kjH &= -65537;
                Ah(this.kjH);
            }
            this.kjA &= -65537;
            this.kjB &= -65537;
            return;
        }
        if (this.kjH == this.kjA || this.kjH == this.kjB) {
            this.kjH |= 65536;
            Ah(this.kjH);
        }
        this.kjA |= 65536;
        this.kjB |= 65536;
    }

    public void aT(bj bjVar) {
        if (bjVar == null || bjVar.aKT() == null || aq.isEmpty(bjVar.aKT().video_url)) {
            if (this.kjH == this.kjA || this.kjH == this.kjB || this.kjH == this.kjD) {
                this.kjH &= -32769;
                this.kjH &= -131073;
                Ah(this.kjH);
            }
            this.kjA &= -32769;
            this.kjB &= -32769;
            this.kjD &= -131073;
            return;
        }
        if (this.kjH == this.kjA || this.kjH == this.kjB) {
            this.kjH |= 32768;
            Ah(this.kjH);
        }
        if (this.kjH == this.kjD) {
            this.kjH |= 131072;
            Ah(this.kjH);
        }
        this.kjA |= 32768;
        this.kjB |= 32768;
        this.kjD |= 131072;
        this.jMH.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.ahO = bjVar.getTid();
            yVar.eQk = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.jue = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.jue == 0) {
                        this.jue = intent.getIntExtra("key_start_from", 0);
                    }
                    this.juf = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.juf)) {
                        yVar.dop = this.juf;
                    }
                    yVar.kit = Integer.toString(this.jue);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.kit = this.source;
                }
            }
            if (bjVar.aKT() != null) {
                yVar.kiw = bjVar.aKT().video_md5;
                yVar.kiy = String.valueOf(bjVar.aKT().is_vertical);
            }
            c(yVar);
            this.jML = false;
            this.jMH.setIsCountDownValid(true);
            if (this.jpM && bjVar.aKT() != null) {
                if (this.ahN != (bjVar.aKT().is_vertical.intValue() == 1)) {
                    cKJ();
                }
            }
            super.setData(bjVar);
            ta(!this.ahN);
            if (bjVar.aKC() != null) {
                bjVar.aKC().setIsLike(bjVar.aKC().hadConcerned());
            }
            this.jMG.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEN() {
        super.cEN();
        if (this.jpM) {
            cER();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.jMG.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.jpM || motionEvent.getX() > ((float) this.jKj);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cEO() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEP() {
        this.kjx &= -33;
        this.kjy &= -33;
        this.kjz &= -33;
        this.kjA &= -33;
        this.kjB &= -33;
        this.kjC &= -33;
        this.kjD &= -33;
        this.kjE &= -33;
        this.kjF &= -33;
        this.kjx |= 1024;
        this.kjy |= 1024;
        this.kjz &= -1025;
        this.kjA |= 1024;
        this.kjB |= 1024;
        this.kjC |= 1024;
        this.kjD |= 1024;
        this.kjE |= 1024;
        this.kjF &= -1025;
        this.kjy |= 16384;
        this.kjC |= 16384;
        this.kjD &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEQ() {
        int i = 0;
        this.kjQ.ai(this.ahN, this.jpM);
        this.kjR.ai(this.ahN, this.jpM);
        if (this.kjP instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.kjP).ai(this.ahN, this.jpM);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kjO.getLayoutParams();
        int dimens = (this.jpM && this.ahN) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.jpM && !this.ahN) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jMI.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jMJ.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.jpM || this.ahN) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.jMH.ai(this.ahN, this.jpM);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Ah(int i) {
        if (i != this.kjB && i != this.kjC && i != this.kjA && i != this.kjy) {
            cEU();
            if (this.jMG != null) {
                this.jMG.setVisibility(8);
            }
        }
        if (this.kjH != this.kjF && i == this.kjF) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMO);
            if ((this.kjH & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.kjH & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.kjF = i;
        }
        super.Ah(i);
        if (!this.jpM) {
            this.kjS.setVisibility(8);
            this.kjT.setVisibility(8);
            if (this.jMN != null) {
                this.jMN.sg((i & 1024) > 0);
            }
        }
        if (this.kjP instanceof PbVideoMediaController) {
            this.kjP.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.kjP).setBottomBarShow((i & 16384) > 0);
        }
        if (this.jMI != null) {
            this.jMI.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.jMJ != null) {
            this.jMJ.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.jMH != null) {
            boolean z = (131072 & i) > 0;
            this.jMH.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(BI("c13600"));
            }
        }
        if (!this.jpM && !this.jKK && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.jKL) {
                    if (this.jLW == null || !this.jLW.cDZ()) {
                        cDW();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.jKL = true;
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jKN);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.jKN, 3000L);
                }
            } else if (this.jKL || (this.jLW != null && this.jLW.cDZ())) {
                cEV();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void sk(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.jpM);
        }
        super.sk(z);
        cEU();
        if (this.jpM) {
            cER();
        } else {
            this.jMG.setVisibility(8);
        }
    }

    private void cER() {
        if (!this.jML && !this.jMG.cEX()) {
            this.jMG.setTranslationX(0.0f);
            this.jMG.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jMG.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.ahN ? R.dimen.tbds248 : R.dimen.tbds428);
            this.jMM = ObjectAnimator.ofFloat(this.jMG, "translationX", 0.0f);
            this.jMM.setDuration(500);
            cEU();
            com.baidu.adp.lib.f.e.lb().postDelayed(this.jMP, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cES() {
        if (this.kjH == this.kjF) {
            return false;
        }
        this.kjU.setVisibility(0);
        this.kjU.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMO);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.jMO, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cET() {
        if (this.kjH == this.kjF) {
            return false;
        }
        this.kjU.setVisibility(0);
        this.kjU.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMO);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.jMO, 1500L);
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
                cEU();
                com.baidu.adp.lib.f.e.lb().post(this.jMQ);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.jMN != null) {
                    this.jMN.sh(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.jMN != null) {
                    this.jMN.cEp();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.kjD &= -131073;
                this.kjH &= -131073;
                this.jMH.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean nV(boolean z) {
        cEU();
        this.jMG.setVisibility(8);
        if (!this.jKK) {
            cEV();
        }
        if (z) {
            this.jMK = this.kjH;
            if (this.kjH == this.kjB || ((this.kjH == this.kjC && !this.kfd.isPlaying()) || this.kjH == this.kjD)) {
                this.jMK |= 1;
            }
            stopPlay();
            return true;
        } else if (this.jMK == -1) {
            startPlay();
            return true;
        } else if (this.jMK == this.kjy || this.jMK == this.kjA || this.jMK == this.kjz) {
            startPlay();
            return true;
        } else {
            this.kjP.setCurrentDuration(x.cKo().IO(this.mVideoUrl), false);
            Ah(this.jMK);
            return true;
        }
    }

    private an BI(String str) {
        an cI = new an(str).cI("tid", this.ahO).t("fid", this.mFid).cI("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            cI.cI("obj_param4", this.baijiahaoData.oriUgcNid);
            cI.cI("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                cI.af("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                cI.af("obj_param5", 3);
            }
        } else {
            cI.af("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cwA() != null) {
            cI.cI(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).cwA().czr()).cI("obj_id", ((PbActivity) this.mContext).cwA().czs()).cI("obj_source", ((PbActivity) this.mContext).cwA().czq());
        }
        return cI;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Ai(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new an("c13598"));
            } else {
                TiebaStatic.log(new an("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(BI("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(BI("c13601").af("obj_type", this.jMH.jMx ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEU() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMP);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEV() {
        cDX();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.jKL = false;
        if (this.jLW != null) {
            this.jLW.sc(false);
        }
    }

    private void cDW() {
        if (this.jKO == null) {
            this.jKO = ObjectAnimator.ofFloat(this.jKu, "alpha", 0.0f, 1.0f);
            this.jKO.setDuration(200L);
        }
        this.jKO.start();
    }

    private void cDX() {
        if (this.jKP == null) {
            this.jKP = ObjectAnimator.ofFloat(this.jKu, "alpha", 1.0f, 0.0f);
            this.jKP.setDuration(200L);
        }
        this.jKP.start();
    }

    public void onDestroy() {
        cEU();
        ta(false);
    }

    public boolean brI() {
        return this.ahN;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.jLW = videoPbFragment;
    }

    public void cP(View view) {
        this.mRootView = view;
    }

    public void cQ(View view) {
        this.jKu = view;
    }

    public boolean cDZ() {
        return this.jKL;
    }

    public void sc(boolean z) {
        this.jKL = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEW() {
        com.baidu.tieba.play.y cKp = this.kka.cJY().cKp();
        cKp.mLocate = "pb";
        com.baidu.tieba.play.l.a(cKp.kiw, "", "2", cKp);
    }
}
