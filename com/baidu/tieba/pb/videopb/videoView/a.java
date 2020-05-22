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
    private int jLc;
    private String jLd;
    private int kbU;
    private ObjectAnimator kcA;
    private ObjectAnimator kcB;
    private View kcf;
    private boolean kcw;
    private boolean kcx;
    private Runnable kcz;
    private VideoPbFragment kdJ;
    private ImageView keA;
    private int keB;
    private boolean keC;
    private ObjectAnimator keD;
    private e keE;
    private Runnable keF;
    private Runnable keG;
    private Runnable keH;
    private final int keq;
    private final int ker;
    private final int kes;
    private final int ket;
    private final int keu;
    private final int kev;
    private PbVideoFullscreenAttentionLayout kew;
    private PbNextVideoLayout kex;
    private ImageView kez;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.keq = 16384;
        this.ker = 32768;
        this.kes = 65536;
        this.ket = 131072;
        this.keu = 5000;
        this.kev = 1500;
        this.keB = -1;
        this.jLc = 0;
        this.keF = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.kBP.setVisibility(8);
            }
        };
        this.keG = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kew.cLW()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.air ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.keC = true;
                    a.this.keD.setFloatValues(-l.getDimens(context2, i));
                    a.this.keD.removeAllListeners();
                    a.this.keD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cLU();
                            com.baidu.adp.lib.f.e.ld().postDelayed(a.this.keH, 5000L);
                        }
                    });
                    a.this.keD.start();
                }
            }
        };
        this.keH = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.keD.setFloatValues(l.getDimens(a.this.mContext, a.this.air ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.keD.removeAllListeners();
                a.this.keD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kew.setVisibility(8);
                    }
                });
                a.this.keD.start();
            }
        };
        this.kcz = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kcx && (a.this.mContext instanceof Activity)) {
                    a.this.aod();
                }
            }
        };
        cLP();
        if (context instanceof PbActivity) {
            this.keE = (e) y.b((PbActivity) context).l(e.class);
            this.kcw = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        ty(true);
        this.kBW = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kew = (PbVideoFullscreenAttentionLayout) this.kBS.findViewById(R.id.video_fullscreen_attention);
        this.kex = (PbNextVideoLayout) this.kBS.findViewById(R.id.video_next_layout);
        this.kez = (ImageView) this.kBS.findViewById(R.id.video_pre);
        this.keA = (ImageView) this.kBS.findViewById(R.id.video_next);
        SvgManager.aUV().a(this.kez, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aUV().a(this.keA, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.aii.bhq();
        this.aii.setDrawCorner(false);
        this.kew.setOnClickEvent(this);
        this.kez.setOnClickListener(this);
        this.keA.setOnClickListener(this);
        this.kex.setOnClickListener(this);
        this.kbU = l.getEquipmentWidth(this.mContext) / 10;
        this.kBM.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cLM() {
        this.kwT.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void sH(boolean z) {
        this.kex.setIsCountDownValid(z);
    }

    public void aS(bk bkVar) {
        if (bkVar == null || bkVar.aQQ() == null || aq.isEmpty(bkVar.aQQ().video_url)) {
            if (this.kBC == this.kBv || this.kBC == this.kBw) {
                this.kBC &= -65537;
                AS(this.kBC);
            }
            this.kBv &= -65537;
            this.kBw &= -65537;
            return;
        }
        if (this.kBC == this.kBv || this.kBC == this.kBw) {
            this.kBC |= 65536;
            AS(this.kBC);
        }
        this.kBv |= 65536;
        this.kBw |= 65536;
    }

    public void aT(bk bkVar) {
        if (bkVar == null || bkVar.aQQ() == null || aq.isEmpty(bkVar.aQQ().video_url)) {
            if (this.kBC == this.kBv || this.kBC == this.kBw || this.kBC == this.kBy) {
                this.kBC &= -32769;
                this.kBC &= -131073;
                AS(this.kBC);
            }
            this.kBv &= -32769;
            this.kBw &= -32769;
            this.kBy &= -131073;
            return;
        }
        if (this.kBC == this.kBv || this.kBC == this.kBw) {
            this.kBC |= 32768;
            AS(this.kBC);
        }
        if (this.kBC == this.kBy) {
            this.kBC |= 131072;
            AS(this.kBC);
        }
        this.kBv |= 32768;
        this.kBw |= 32768;
        this.kBy |= 131072;
        this.kex.setDate(bkVar);
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
                    this.jLc = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.jLc == 0) {
                        this.jLc = intent.getIntExtra("key_start_from", 0);
                    }
                    this.jLd = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.jLd)) {
                        yVar.dCp = this.jLd;
                    }
                    yVar.kAn = Integer.toString(this.jLc);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.kAn = this.source;
                }
            }
            if (bkVar.aQQ() != null) {
                yVar.kAq = bkVar.aQQ().video_md5;
                yVar.kAs = String.valueOf(bkVar.aQQ().is_vertical);
            }
            c(yVar);
            this.keC = false;
            this.kex.setIsCountDownValid(true);
            if (this.jGv && bkVar.aQQ() != null) {
                if (this.air != (bkVar.aQQ().is_vertical.intValue() == 1)) {
                    cRK();
                }
            }
            super.setData(bkVar);
            ty(!this.air);
            if (bkVar.aQx() != null) {
                bkVar.aQx().setIsLike(bkVar.aQx().hadConcerned());
            }
            this.kew.setData(bkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLN() {
        super.cLN();
        if (this.jGv) {
            cLR();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kew.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean J(MotionEvent motionEvent) {
        return this.jGv || motionEvent.getX() > ((float) this.kbU);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cLO() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLP() {
        this.kBs &= -33;
        this.kBt &= -33;
        this.kBu &= -33;
        this.kBv &= -33;
        this.kBw &= -33;
        this.kBx &= -33;
        this.kBy &= -33;
        this.kBz &= -33;
        this.kBA &= -33;
        this.kBs |= 1024;
        this.kBt |= 1024;
        this.kBu &= -1025;
        this.kBv |= 1024;
        this.kBw |= 1024;
        this.kBx |= 1024;
        this.kBy |= 1024;
        this.kBz |= 1024;
        this.kBA &= -1025;
        this.kBt |= 16384;
        this.kBx |= 16384;
        this.kBy &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLQ() {
        int i = 0;
        this.kBL.al(this.air, this.jGv);
        this.kBM.al(this.air, this.jGv);
        if (this.kBK instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.kBK).al(this.air, this.jGv);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kBJ.getLayoutParams();
        int dimens = (this.jGv && this.air) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.jGv && !this.air) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kez.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.keA.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.jGv || this.air) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kex.al(this.air, this.jGv);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void AS(int i) {
        if (i != this.kBw && i != this.kBx && i != this.kBv && i != this.kBt) {
            cLU();
            if (this.kew != null) {
                this.kew.setVisibility(8);
            }
        }
        if (this.kBC != this.kBA && i == this.kBA) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.keF);
            if ((this.kBC & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.kBC & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.kBA = i;
        }
        super.AS(i);
        if (!this.jGv) {
            this.kBN.setVisibility(8);
            this.kBO.setVisibility(8);
            if (this.keE != null) {
                this.keE.sE((i & 1024) > 0);
            }
        }
        if (this.kBK instanceof PbVideoMediaController) {
            this.kBK.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.kBK).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kez != null) {
            this.kez.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.keA != null) {
            this.keA.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kex != null) {
            boolean z = (131072 & i) > 0;
            this.kex.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Dr("c13600"));
            }
        }
        if (!this.jGv && !this.kcw && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kcx) {
                    if (this.kdJ == null || !this.kdJ.cKX()) {
                        cKU();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kcx = true;
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kcz);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.kcz, 3000L);
                }
            } else if (this.kcx || (this.kdJ != null && this.kdJ.cKX())) {
                aod();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void sI(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.jGv);
        }
        super.sI(z);
        cLU();
        if (this.jGv) {
            cLR();
        } else {
            this.kew.setVisibility(8);
        }
    }

    private void cLR() {
        if (!this.keC && !this.kew.cLW()) {
            this.kew.setTranslationX(0.0f);
            this.kew.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kew.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.air ? R.dimen.tbds248 : R.dimen.tbds428);
            this.keD = ObjectAnimator.ofFloat(this.kew, "translationX", 0.0f);
            this.keD.setDuration(500);
            cLU();
            com.baidu.adp.lib.f.e.ld().postDelayed(this.keG, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cLS() {
        if (this.kBC == this.kBA) {
            return false;
        }
        this.kBP.setVisibility(0);
        this.kBP.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.keF);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.keF, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cLT() {
        if (this.kBC == this.kBA) {
            return false;
        }
        this.kBP.setVisibility(0);
        this.kBP.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.keF);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.keF, 1500L);
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
                cLU();
                com.baidu.adp.lib.f.e.ld().post(this.keH);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.keE != null) {
                    this.keE.sF(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.keE != null) {
                    this.keE.cLn();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.kBy &= -131073;
                this.kBC &= -131073;
                this.kex.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean or(boolean z) {
        cLU();
        this.kew.setVisibility(8);
        if (!this.kcw) {
            aod();
        }
        if (z) {
            this.keB = this.kBC;
            if (this.kBC == this.kBw || ((this.kBC == this.kBx && !this.kwT.isPlaying()) || this.kBC == this.kBy)) {
                this.keB |= 1;
            }
            stopPlay();
            return true;
        } else if (this.keB == -1) {
            startPlay();
            return true;
        } else if (this.keB == this.kBt || this.keB == this.kBv || this.keB == this.kBu) {
            startPlay();
            return true;
        } else {
            this.kBK.setCurrentDuration(x.cRo().KA(this.mVideoUrl), false);
            AS(this.keB);
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cDy() != null) {
            dh.dh("ab_tag", ((PbActivity) this.mContext).cDy().cGo()).dh("obj_id", ((PbActivity) this.mContext).cDy().cGp()).dh("obj_source", ((PbActivity) this.mContext).cDy().cGn());
        }
        return dh;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void AT(int i) {
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
            TiebaStatic.log(Dr("c13601").ag("obj_type", this.kex.ken ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLU() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.keG);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.keH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aod() {
        cKV();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kcx = false;
        if (this.kdJ != null) {
            this.kdJ.sA(false);
        }
    }

    private void cKU() {
        if (this.kcA == null) {
            this.kcA = ObjectAnimator.ofFloat(this.kcf, "alpha", 0.0f, 1.0f);
            this.kcA.setDuration(200L);
        }
        this.kcA.start();
    }

    private void cKV() {
        if (this.kcB == null) {
            this.kcB = ObjectAnimator.ofFloat(this.kcf, "alpha", 1.0f, 0.0f);
            this.kcB.setDuration(200L);
        }
        this.kcB.start();
    }

    public void onDestroy() {
        cLU();
        ty(false);
    }

    public boolean bxC() {
        return this.air;
    }

    public void ac(VideoPbFragment videoPbFragment) {
        this.kdJ = videoPbFragment;
    }

    public void cQ(View view) {
        this.mRootView = view;
    }

    public void cR(View view) {
        this.kcf = view;
    }

    public boolean cKX() {
        return this.kcx;
    }

    public void sA(boolean z) {
        this.kcx = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLV() {
        com.baidu.tieba.play.y cRp = this.kBV.cQY().cRp();
        cRp.mLocate = "pb";
        com.baidu.tieba.play.l.a(cRp.kAq, "", "2", cRp);
    }
}
