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
    private boolean jKG;
    private boolean jKH;
    private Runnable jKJ;
    private ObjectAnimator jKK;
    private ObjectAnimator jKL;
    private int jKf;
    private View jKq;
    private VideoPbFragment jLS;
    private final int jMA;
    private final int jMB;
    private PbVideoFullscreenAttentionLayout jMC;
    private PbNextVideoLayout jMD;
    private ImageView jME;
    private ImageView jMF;
    private int jMG;
    private boolean jMH;
    private ObjectAnimator jMI;
    private e jMJ;
    private Runnable jMK;
    private Runnable jML;
    private Runnable jMM;
    private final int jMw;
    private final int jMx;
    private final int jMy;
    private final int jMz;
    private int jua;
    private String jub;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.jMw = 16384;
        this.jMx = 32768;
        this.jMy = 65536;
        this.jMz = 131072;
        this.jMA = 5000;
        this.jMB = 1500;
        this.jMG = -1;
        this.jua = 0;
        this.jMK = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.kjQ.setVisibility(8);
            }
        };
        this.jML = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jMC.cFa()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.ahK ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.jMH = true;
                    a.this.jMI.setFloatValues(-l.getDimens(context2, i));
                    a.this.jMI.removeAllListeners();
                    a.this.jMI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cEX();
                            com.baidu.adp.lib.f.e.lb().postDelayed(a.this.jMM, 5000L);
                        }
                    });
                    a.this.jMI.start();
                }
            }
        };
        this.jMM = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jMI.setFloatValues(l.getDimens(a.this.mContext, a.this.ahK ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.jMI.removeAllListeners();
                a.this.jMI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.jMC.setVisibility(8);
                    }
                });
                a.this.jMI.start();
            }
        };
        this.jKJ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jKH && (a.this.mContext instanceof Activity)) {
                    a.this.cEY();
                }
            }
        };
        cES();
        if (context instanceof PbActivity) {
            this.jMJ = (e) y.b((PbActivity) context).l(e.class);
            this.jKG = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        ta(true);
        this.kjX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jMC = (PbVideoFullscreenAttentionLayout) this.kjT.findViewById(R.id.video_fullscreen_attention);
        this.jMD = (PbNextVideoLayout) this.kjT.findViewById(R.id.video_next_layout);
        this.jME = (ImageView) this.kjT.findViewById(R.id.video_pre);
        this.jMF = (ImageView) this.kjT.findViewById(R.id.video_next);
        SvgManager.aOU().a(this.jME, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aOU().a(this.jMF, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ahB.bbh();
        this.ahB.setDrawCorner(false);
        this.jMC.setOnClickEvent(this);
        this.jME.setOnClickListener(this);
        this.jMF.setOnClickListener(this);
        this.jMD.setOnClickListener(this);
        this.jKf = l.getEquipmentWidth(this.mContext) / 10;
        this.kjN.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cEP() {
        this.keZ.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void sj(boolean z) {
        this.jMD.setIsCountDownValid(z);
    }

    public void aS(bj bjVar) {
        if (bjVar == null || bjVar.aKV() == null || aq.isEmpty(bjVar.aKV().video_url)) {
            if (this.kjD == this.kjw || this.kjD == this.kjx) {
                this.kjD &= -65537;
                Ah(this.kjD);
            }
            this.kjw &= -65537;
            this.kjx &= -65537;
            return;
        }
        if (this.kjD == this.kjw || this.kjD == this.kjx) {
            this.kjD |= 65536;
            Ah(this.kjD);
        }
        this.kjw |= 65536;
        this.kjx |= 65536;
    }

    public void aT(bj bjVar) {
        if (bjVar == null || bjVar.aKV() == null || aq.isEmpty(bjVar.aKV().video_url)) {
            if (this.kjD == this.kjw || this.kjD == this.kjx || this.kjD == this.kjz) {
                this.kjD &= -32769;
                this.kjD &= -131073;
                Ah(this.kjD);
            }
            this.kjw &= -32769;
            this.kjx &= -32769;
            this.kjz &= -131073;
            return;
        }
        if (this.kjD == this.kjw || this.kjD == this.kjx) {
            this.kjD |= 32768;
            Ah(this.kjD);
        }
        if (this.kjD == this.kjz) {
            this.kjD |= 131072;
            Ah(this.kjD);
        }
        this.kjw |= 32768;
        this.kjx |= 32768;
        this.kjz |= 131072;
        this.jMD.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.ahL = bjVar.getTid();
            yVar.eQf = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.jua = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.jua == 0) {
                        this.jua = intent.getIntExtra("key_start_from", 0);
                    }
                    this.jub = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.jub)) {
                        yVar.dol = this.jub;
                    }
                    yVar.kip = Integer.toString(this.jua);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.kip = this.source;
                }
            }
            if (bjVar.aKV() != null) {
                yVar.kis = bjVar.aKV().video_md5;
                yVar.kiu = String.valueOf(bjVar.aKV().is_vertical);
            }
            c(yVar);
            this.jMH = false;
            this.jMD.setIsCountDownValid(true);
            if (this.jpI && bjVar.aKV() != null) {
                if (this.ahK != (bjVar.aKV().is_vertical.intValue() == 1)) {
                    cKM();
                }
            }
            super.setData(bjVar);
            ta(!this.ahK);
            if (bjVar.aKE() != null) {
                bjVar.aKE().setIsLike(bjVar.aKE().hadConcerned());
            }
            this.jMC.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEQ() {
        super.cEQ();
        if (this.jpI) {
            cEU();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.jMC.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.jpI || motionEvent.getX() > ((float) this.jKf);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cER() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cES() {
        this.kjt &= -33;
        this.kju &= -33;
        this.kjv &= -33;
        this.kjw &= -33;
        this.kjx &= -33;
        this.kjy &= -33;
        this.kjz &= -33;
        this.kjA &= -33;
        this.kjB &= -33;
        this.kjt |= 1024;
        this.kju |= 1024;
        this.kjv &= -1025;
        this.kjw |= 1024;
        this.kjx |= 1024;
        this.kjy |= 1024;
        this.kjz |= 1024;
        this.kjA |= 1024;
        this.kjB &= -1025;
        this.kju |= 16384;
        this.kjy |= 16384;
        this.kjz &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cET() {
        int i = 0;
        this.kjM.ai(this.ahK, this.jpI);
        this.kjN.ai(this.ahK, this.jpI);
        if (this.kjL instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.kjL).ai(this.ahK, this.jpI);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kjK.getLayoutParams();
        int dimens = (this.jpI && this.ahK) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.jpI && !this.ahK) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jME.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jMF.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.jpI || this.ahK) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.jMD.ai(this.ahK, this.jpI);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Ah(int i) {
        if (i != this.kjx && i != this.kjy && i != this.kjw && i != this.kju) {
            cEX();
            if (this.jMC != null) {
                this.jMC.setVisibility(8);
            }
        }
        if (this.kjD != this.kjB && i == this.kjB) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMK);
            if ((this.kjD & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.kjD & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.kjB = i;
        }
        super.Ah(i);
        if (!this.jpI) {
            this.kjO.setVisibility(8);
            this.kjP.setVisibility(8);
            if (this.jMJ != null) {
                this.jMJ.sg((i & 1024) > 0);
            }
        }
        if (this.kjL instanceof PbVideoMediaController) {
            this.kjL.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.kjL).setBottomBarShow((i & 16384) > 0);
        }
        if (this.jME != null) {
            this.jME.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.jMF != null) {
            this.jMF.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.jMD != null) {
            boolean z = (131072 & i) > 0;
            this.jMD.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(BF("c13600"));
            }
        }
        if (!this.jpI && !this.jKG && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.jKH) {
                    if (this.jLS == null || !this.jLS.cEc()) {
                        cDZ();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.jKH = true;
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jKJ);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.jKJ, 3000L);
                }
            } else if (this.jKH || (this.jLS != null && this.jLS.cEc())) {
                cEY();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void sk(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.jpI);
        }
        super.sk(z);
        cEX();
        if (this.jpI) {
            cEU();
        } else {
            this.jMC.setVisibility(8);
        }
    }

    private void cEU() {
        if (!this.jMH && !this.jMC.cFa()) {
            this.jMC.setTranslationX(0.0f);
            this.jMC.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jMC.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.ahK ? R.dimen.tbds248 : R.dimen.tbds428);
            this.jMI = ObjectAnimator.ofFloat(this.jMC, "translationX", 0.0f);
            this.jMI.setDuration(500);
            cEX();
            com.baidu.adp.lib.f.e.lb().postDelayed(this.jML, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cEV() {
        if (this.kjD == this.kjB) {
            return false;
        }
        this.kjQ.setVisibility(0);
        this.kjQ.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMK);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.jMK, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cEW() {
        if (this.kjD == this.kjB) {
            return false;
        }
        this.kjQ.setVisibility(0);
        this.kjQ.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMK);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.jMK, 1500L);
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
                cEX();
                com.baidu.adp.lib.f.e.lb().post(this.jMM);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.jMJ != null) {
                    this.jMJ.sh(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.jMJ != null) {
                    this.jMJ.cEs();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.kjz &= -131073;
                this.kjD &= -131073;
                this.jMD.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean nV(boolean z) {
        cEX();
        this.jMC.setVisibility(8);
        if (!this.jKG) {
            cEY();
        }
        if (z) {
            this.jMG = this.kjD;
            if (this.kjD == this.kjx || ((this.kjD == this.kjy && !this.keZ.isPlaying()) || this.kjD == this.kjz)) {
                this.jMG |= 1;
            }
            stopPlay();
            return true;
        } else if (this.jMG == -1) {
            startPlay();
            return true;
        } else if (this.jMG == this.kju || this.jMG == this.kjw || this.jMG == this.kjv) {
            startPlay();
            return true;
        } else {
            this.kjL.setCurrentDuration(x.cKr().IL(this.mVideoUrl), false);
            Ah(this.jMG);
            return true;
        }
    }

    private an BF(String str) {
        an cI = new an(str).cI("tid", this.ahL).t("fid", this.mFid).cI("uid", TbadkCoreApplication.getCurrentAccount());
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cwD() != null) {
            cI.cI(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).cwD().czu()).cI("obj_id", ((PbActivity) this.mContext).cwD().czv()).cI("obj_source", ((PbActivity) this.mContext).cwD().czt());
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
            TiebaStatic.log(BF("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(BF("c13601").af("obj_type", this.jMD.jMt ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEX() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jML);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jMM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEY() {
        cEa();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.jKH = false;
        if (this.jLS != null) {
            this.jLS.sc(false);
        }
    }

    private void cDZ() {
        if (this.jKK == null) {
            this.jKK = ObjectAnimator.ofFloat(this.jKq, "alpha", 0.0f, 1.0f);
            this.jKK.setDuration(200L);
        }
        this.jKK.start();
    }

    private void cEa() {
        if (this.jKL == null) {
            this.jKL = ObjectAnimator.ofFloat(this.jKq, "alpha", 1.0f, 0.0f);
            this.jKL.setDuration(200L);
        }
        this.jKL.start();
    }

    public void onDestroy() {
        cEX();
        ta(false);
    }

    public boolean brK() {
        return this.ahK;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.jLS = videoPbFragment;
    }

    public void cP(View view) {
        this.mRootView = view;
    }

    public void cQ(View view) {
        this.jKq = view;
    }

    public boolean cEc() {
        return this.jKH;
    }

    public void sc(boolean z) {
        this.jKH = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEZ() {
        com.baidu.tieba.play.y cKs = this.kjW.cKb().cKs();
        cKs.mLocate = "pb";
        com.baidu.tieba.play.l.a(cKs.kis, "", "2", cKs);
    }
}
