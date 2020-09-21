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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private int kMH;
    private String kMI;
    private boolean leE;
    private boolean leF;
    private Runnable leH;
    private ObjectAnimator leI;
    private ObjectAnimator leJ;
    private int lea;
    private View lem;
    private final int lgP;
    private final int lgQ;
    private final int lgR;
    private final int lgS;
    private final int lgT;
    private final int lgU;
    private PbVideoFullscreenAttentionLayout lgV;
    private PbNextVideoLayout lgW;
    private ImageView lgX;
    private ImageView lgY;
    private int lgZ;
    private VideoPbFragment lgd;
    private boolean lha;
    private ObjectAnimator lhb;
    private e lhc;
    private Runnable lhd;
    private Runnable lhe;
    private Runnable lhf;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.lgP = 16384;
        this.lgQ = 32768;
        this.lgR = 65536;
        this.lgS = 131072;
        this.lgT = 5000;
        this.lgU = 1500;
        this.lgZ = -1;
        this.kMH = 0;
        this.lhd = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.lDP.setVisibility(8);
            }
        };
        this.lhe = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.lgV.diW()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.alz ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.lha = true;
                    a.this.lhb.setFloatValues(-l.getDimens(context2, i));
                    a.this.lhb.removeAllListeners();
                    a.this.lhb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.diU();
                            com.baidu.adp.lib.f.e.mX().postDelayed(a.this.lhf, 5000L);
                        }
                    });
                    a.this.lhb.start();
                }
            }
        };
        this.lhf = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.lhb.setFloatValues(l.getDimens(a.this.mContext, a.this.alz ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.lhb.removeAllListeners();
                a.this.lhb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.lgV.setVisibility(8);
                    }
                });
                a.this.lhb.start();
            }
        };
        this.leH = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.leF && (a.this.mContext instanceof Activity)) {
                    a.this.azO();
                }
            }
        };
        diP();
        if (context instanceof PbActivity) {
            this.lhc = (e) y.b((PbActivity) context).l(e.class);
            this.leE = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        vm(true);
        this.lDX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lgV = (PbVideoFullscreenAttentionLayout) this.lDS.findViewById(R.id.video_fullscreen_attention);
        this.lgW = (PbNextVideoLayout) this.lDS.findViewById(R.id.video_next_layout);
        this.lgX = (ImageView) this.lDS.findViewById(R.id.video_pre);
        this.lgY = (ImageView) this.lDS.findViewById(R.id.video_next);
        SvgManager.bkl().a(this.lgX, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.bkl().a(this.lgY, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.alq.bxw();
        this.alq.setDrawCorner(false);
        this.lgV.setOnClickEvent(this);
        this.lgX.setOnClickListener(this);
        this.lgY.setOnClickListener(this);
        this.lgW.setOnClickListener(this);
        this.lea = l.getEquipmentWidth(this.mContext) / 10;
        this.lDM.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void diM() {
        this.fHb.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void uu(boolean z) {
        this.lgW.setIsCountDownValid(z);
    }

    public void aS(bw bwVar) {
        if (bwVar == null || bwVar.bfQ() == null || at.isEmpty(bwVar.bfQ().video_url)) {
            if (this.lDC == this.lDv || this.lDC == this.lDw) {
                this.lDC &= -65537;
                Fr(this.lDC);
            }
            this.lDv &= -65537;
            this.lDw &= -65537;
            return;
        }
        if (this.lDC == this.lDv || this.lDC == this.lDw) {
            this.lDC |= 65536;
            Fr(this.lDC);
        }
        this.lDv |= 65536;
        this.lDw |= 65536;
    }

    public void aT(bw bwVar) {
        if (bwVar == null || bwVar.bfQ() == null || at.isEmpty(bwVar.bfQ().video_url)) {
            if (this.lDC == this.lDv || this.lDC == this.lDw || this.lDC == this.lDy) {
                this.lDC &= -32769;
                this.lDC &= -131073;
                Fr(this.lDC);
            }
            this.lDv &= -32769;
            this.lDw &= -32769;
            this.lDy &= -131073;
            return;
        }
        if (this.lDC == this.lDv || this.lDC == this.lDw) {
            this.lDC |= 32768;
            Fr(this.lDC);
        }
        if (this.lDC == this.lDy) {
            this.lDC |= 131072;
            Fr(this.lDC);
        }
        this.lDv |= 32768;
        this.lDw |= 32768;
        this.lDy |= 131072;
        this.lgW.setDate(bwVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.baijiahaoData = bwVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.alA = bwVar.getTid();
            oVar.eYo = Long.toString(bwVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bwVar.isBjh()) {
                    this.kMH = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.kMH == 0) {
                        this.kMH = intent.getIntExtra("key_start_from", 0);
                    }
                    this.kMI = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.kMI)) {
                        oVar.eaC = this.kMI;
                    }
                    oVar.lCh = Integer.toString(this.kMH);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.lCh = this.source;
                }
            }
            if (bwVar.bfQ() != null) {
                oVar.lCk = bwVar.bfQ().video_md5;
                oVar.lCm = String.valueOf(bwVar.bfQ().is_vertical);
            }
            b(oVar);
            this.lha = false;
            if (com.baidu.tbadk.a.d.baW()) {
                this.lgW.setIsCountDownValid(false);
            } else {
                this.lgW.setIsCountDownValid(true);
            }
            if (this.kHN && bwVar.bfQ() != null) {
                if (this.alz != (bwVar.bfQ().is_vertical.intValue() == 1)) {
                    dor();
                }
            }
            super.setData(bwVar);
            vm(!this.alz);
            if (bwVar.bfy() != null) {
                bwVar.bfy().setIsLike(bwVar.bfy().hadConcerned());
            }
            this.lgV.setData(bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diN() {
        super.diN();
        if (this.kHN) {
            diR();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.lgV.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kHN || motionEvent.getX() > ((float) this.lea);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean diO() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diP() {
        this.lDs &= -33;
        this.lDt &= -33;
        this.lDu &= -33;
        this.lDv &= -33;
        this.lDw &= -33;
        this.lDx &= -33;
        this.lDy &= -33;
        this.lDz &= -33;
        this.lDA &= -33;
        this.lDs |= 1024;
        this.lDt |= 1024;
        this.lDu &= -1025;
        this.lDv |= 1024;
        this.lDw |= 1024;
        this.lDx |= 1024;
        this.lDy |= 1024;
        this.lDz |= 1024;
        this.lDA &= -1025;
        this.lDt |= 16384;
        this.lDx |= 16384;
        this.lDy &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diQ() {
        int i = 0;
        this.lDL.at(this.alz, this.kHN);
        this.lDM.at(this.alz, this.kHN);
        if (this.lDK instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.lDK).at(this.alz, this.kHN);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lDJ.getLayoutParams();
        int dimens = (this.kHN && this.alz) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kHN && !this.alz) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lgX.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lgY.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kHN || this.alz) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.lgW.at(this.alz, this.kHN);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Fr(int i) {
        if (i != this.lDw && i != this.lDx && i != this.lDv && i != this.lDt) {
            diU();
            if (this.lgV != null) {
                this.lgV.setVisibility(8);
            }
        }
        if (this.lDC != this.lDA && i == this.lDA) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lhd);
            if ((this.lDC & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.lDC & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.lDA = i;
        }
        super.Fr(i);
        if (!this.kHN) {
            this.lDN.setVisibility(8);
            this.lDO.setVisibility(8);
            if (this.lhc != null) {
                this.lhc.ur((i & 1024) > 0);
            }
        }
        if (this.lhc != null) {
            this.lhc.ur((i & 128) > 0);
        }
        if (this.lDK instanceof PbVideoMediaController) {
            this.lDK.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.lDK).setBottomBarShow((i & 16384) > 0);
        }
        if (this.lgX != null) {
            this.lgX.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.lgY != null) {
            this.lgY.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.lgW != null) {
            boolean z = (131072 & i) > 0;
            this.lgW.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(HA("c13600"));
            }
        }
        if (!this.kHN && !this.leE && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.leF) {
                    if (this.lgd == null || !this.lgd.dhQ()) {
                        dhN();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.leF = true;
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(this.leH);
                    com.baidu.adp.lib.f.e.mX().postDelayed(this.leH, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.leF || (this.lgd != null && this.lgd.dhQ())) {
                azO();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void uv(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kHN);
        }
        super.uv(z);
        diU();
        if (this.kHN) {
            diR();
        } else {
            this.lgV.setVisibility(8);
        }
    }

    private void diR() {
        if (!this.lha && !this.lgV.diW()) {
            this.lgV.setTranslationX(0.0f);
            this.lgV.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.lgV.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.alz ? R.dimen.tbds248 : R.dimen.tbds428);
            this.lhb = ObjectAnimator.ofFloat(this.lgV, "translationX", 0.0f);
            this.lhb.setDuration(500);
            diU();
            com.baidu.adp.lib.f.e.mX().postDelayed(this.lhe, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean diS() {
        if (this.lDC == this.lDA) {
            return false;
        }
        this.lDP.setVisibility(0);
        this.lDP.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lhd);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.lhd, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean diT() {
        if (this.lDC == this.lDA) {
            return false;
        }
        this.lDP.setVisibility(0);
        this.lDP.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lhd);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.lhd, 1500L);
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
                diU();
                com.baidu.adp.lib.f.e.mX().post(this.lhf);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.lhc != null) {
                    this.lhc.us(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.lhc != null) {
                    this.lhc.dig();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.lDy &= -131073;
                this.lDC &= -131073;
                this.lgW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean pX(boolean z) {
        diU();
        this.lgV.setVisibility(8);
        if (!this.leE) {
            azO();
        }
        if (z) {
            this.lgZ = this.lDC;
            if (this.lDC == this.lDw || ((this.lDC == this.lDx && !this.fHb.isPlaying()) || this.lDC == this.lDy)) {
                this.lgZ |= 1;
            }
            stopPlay();
            return true;
        } else if (this.lgZ == -1) {
            startPlay();
            return true;
        } else if (this.lgZ == this.lDt || this.lgZ == this.lDv || this.lgZ == this.lDu) {
            startPlay();
            return true;
        } else {
            this.lDK.setCurrentDuration(n.dnN().Pg(this.mVideoUrl), false);
            Fr(this.lgZ);
            return true;
        }
    }

    private aq HA(String str) {
        aq dF = new aq(str).dF("tid", this.alA).u("fid", this.mFid).dF("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dF.dF("obj_param4", this.baijiahaoData.oriUgcNid);
            dF.dF("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dF.ai("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dF.ai("obj_param5", 3);
            }
        } else {
            dF.ai("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dah() != null) {
            dF.dF("ab_tag", ((PbActivity) this.mContext).dah().dda()).dF("obj_id", ((PbActivity) this.mContext).dah().ddb()).dF("obj_source", ((PbActivity) this.mContext).dah().dcZ());
        }
        return dF;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Fs(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(HA("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(HA("c13601").ai("obj_type", this.lgW.lgM ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diU() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lhe);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lhf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azO() {
        dhO();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.leF = false;
        if (this.lgd != null) {
            this.lgd.un(false);
        }
    }

    private void dhN() {
        if (this.leI == null) {
            this.leI = ObjectAnimator.ofFloat(this.lem, "alpha", 0.0f, 1.0f);
            this.leI.setDuration(200L);
        }
        this.leI.start();
    }

    private void dhO() {
        if (this.leJ == null) {
            this.leJ = ObjectAnimator.ofFloat(this.lem, "alpha", 1.0f, 0.0f);
            this.leJ.setDuration(200L);
        }
        this.leJ.start();
    }

    public void onDestroy() {
        diU();
        vm(false);
    }

    public boolean bOo() {
        return this.alz;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.lgd = videoPbFragment;
    }

    public void dj(View view) {
        this.mRootView = view;
    }

    public void dk(View view) {
        this.lem = view;
    }

    public boolean dhQ() {
        return this.leF;
    }

    public void un(boolean z) {
        this.leF = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diV() {
        if (this.lDV != null) {
            o dnO = this.lDV.dnO();
            dnO.mLocate = "pb";
            h.a(dnO.lCk, "", "2", dnO, this.fHb.getPcdnState());
        }
    }
}
