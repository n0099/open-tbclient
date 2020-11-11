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
/* loaded from: classes22.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int lLM;
    private View lLY;
    private boolean lMp;
    private boolean lMq;
    private Runnable lMs;
    private ObjectAnimator lMt;
    private ObjectAnimator lMu;
    private VideoPbFragment lNO;
    private final int lOA;
    private final int lOB;
    private final int lOC;
    private final int lOD;
    private final int lOE;
    private final int lOF;
    private PbVideoFullscreenAttentionLayout lOG;
    private PbNextVideoLayout lOH;
    private ImageView lOI;
    private ImageView lOJ;
    private int lOK;
    private boolean lOL;
    private ObjectAnimator lOM;
    private e lON;
    private Runnable lOO;
    private Runnable lOP;
    private Runnable lOQ;
    private int lut;
    private String luu;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.lOA = 16384;
        this.lOB = 32768;
        this.lOC = 65536;
        this.lOD = 131072;
        this.lOE = 5000;
        this.lOF = 1500;
        this.lOK = -1;
        this.lut = 0;
        this.lOO = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mlB.setVisibility(8);
            }
        };
        this.lOP = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.lOG.dsp()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.alS ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.lOL = true;
                    a.this.lOM.setFloatValues(-l.getDimens(context2, i));
                    a.this.lOM.removeAllListeners();
                    a.this.lOM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dsn();
                            com.baidu.adp.lib.f.e.mY().postDelayed(a.this.lOQ, 5000L);
                        }
                    });
                    a.this.lOM.start();
                }
            }
        };
        this.lOQ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.lOM.setFloatValues(l.getDimens(a.this.mContext, a.this.alS ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.lOM.removeAllListeners();
                a.this.lOM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.lOG.setVisibility(8);
                    }
                });
                a.this.lOM.start();
            }
        };
        this.lMs = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.lMq && (a.this.mContext instanceof Activity)) {
                    a.this.aGR();
                }
            }
        };
        dsi();
        if (context instanceof PbActivity) {
            this.lON = (e) y.b((PbActivity) context).l(e.class);
            this.lMp = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        wt(true);
        this.mlJ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lOG = (PbVideoFullscreenAttentionLayout) this.mlE.findViewById(R.id.video_fullscreen_attention);
        this.lOH = (PbNextVideoLayout) this.mlE.findViewById(R.id.video_next_layout);
        this.lOI = (ImageView) this.mlE.findViewById(R.id.video_pre);
        this.lOJ = (ImageView) this.mlE.findViewById(R.id.video_next);
        SvgManager.brn().a(this.lOI, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.brn().a(this.lOJ, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.alJ.bEy();
        this.alJ.setDrawCorner(false);
        this.lOG.setOnClickEvent(this);
        this.lOI.setOnClickListener(this);
        this.lOJ.setOnClickListener(this);
        this.lOH.setOnClickListener(this);
        this.lLM = l.getEquipmentWidth(this.mContext) / 10;
        this.mly.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dsf() {
        this.gjd.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void vB(boolean z) {
        this.lOH.setIsCountDownValid(z);
    }

    public void aS(bw bwVar) {
        if (bwVar == null || bwVar.bmS() == null || at.isEmpty(bwVar.bmS().video_url)) {
            if (this.mlo == this.mlh || this.mlo == this.mli) {
                this.mlo &= -65537;
                GD(this.mlo);
            }
            this.mlh &= -65537;
            this.mli &= -65537;
            return;
        }
        if (this.mlo == this.mlh || this.mlo == this.mli) {
            this.mlo |= 65536;
            GD(this.mlo);
        }
        this.mlh |= 65536;
        this.mli |= 65536;
    }

    public void aT(bw bwVar) {
        if (bwVar == null || bwVar.bmS() == null || at.isEmpty(bwVar.bmS().video_url)) {
            if (this.mlo == this.mlh || this.mlo == this.mli || this.mlo == this.mlk) {
                this.mlo &= -32769;
                this.mlo &= -131073;
                GD(this.mlo);
            }
            this.mlh &= -32769;
            this.mli &= -32769;
            this.mlk &= -131073;
            return;
        }
        if (this.mlo == this.mlh || this.mlo == this.mli) {
            this.mlo |= 32768;
            GD(this.mlo);
        }
        if (this.mlo == this.mlk) {
            this.mlo |= 131072;
            GD(this.mlo);
        }
        this.mlh |= 32768;
        this.mli |= 32768;
        this.mlk |= 131072;
        this.lOH.setDate(bwVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.baijiahaoData = bwVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.alT = bwVar.getTid();
            oVar.fyR = Long.toString(bwVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bwVar.isBjh()) {
                    this.lut = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lut == 0) {
                        this.lut = intent.getIntExtra("key_start_from", 0);
                    }
                    this.luu = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.luu)) {
                        oVar.eAX = this.luu;
                    }
                    oVar.mjT = Integer.toString(this.lut);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mjT = this.source;
                }
            }
            if (bwVar.bmS() != null) {
                oVar.mjW = bwVar.bmS().video_md5;
                oVar.mjY = String.valueOf(bwVar.bmS().is_vertical);
            }
            b(oVar);
            this.lOL = false;
            if (com.baidu.tbadk.a.d.bhX()) {
                this.lOH.setIsCountDownValid(false);
            } else {
                this.lOH.setIsCountDownValid(true);
            }
            if (this.lpy && bwVar.bmS() != null) {
                if (this.alS != (bwVar.bmS().is_vertical.intValue() == 1)) {
                    dxL();
                }
            }
            super.setData(bwVar);
            wt(!this.alS);
            if (bwVar.bmA() != null) {
                bwVar.bmA().setIsLike(bwVar.bmA().hadConcerned());
            }
            this.lOG.setData(bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsg() {
        super.dsg();
        if (this.lpy) {
            dsk();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.lOG.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lpy || motionEvent.getX() > ((float) this.lLM);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dsh() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsi() {
        this.mle &= -33;
        this.mlf &= -33;
        this.mlg &= -33;
        this.mlh &= -33;
        this.mli &= -33;
        this.mlj &= -33;
        this.mlk &= -33;
        this.mll &= -33;
        this.mlm &= -33;
        this.mle |= 1024;
        this.mlf |= 1024;
        this.mlg &= -1025;
        this.mlh |= 1024;
        this.mli |= 1024;
        this.mlj |= 1024;
        this.mlk |= 1024;
        this.mll |= 1024;
        this.mlm &= -1025;
        this.mlf |= 16384;
        this.mlj |= 16384;
        this.mlk &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsj() {
        int i = 0;
        this.mlx.av(this.alS, this.lpy);
        this.mly.av(this.alS, this.lpy);
        if (this.mlw instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mlw).av(this.alS, this.lpy);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mlv.getLayoutParams();
        int dimens = (this.lpy && this.alS) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lpy && !this.alS) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lOI.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lOJ.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lpy || this.alS) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.lOH.av(this.alS, this.lpy);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void GD(int i) {
        if (i != this.mli && i != this.mlj && i != this.mlh && i != this.mlf) {
            dsn();
            if (this.lOG != null) {
                this.lOG.setVisibility(8);
            }
        }
        if (this.mlo != this.mlm && i == this.mlm) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lOO);
            if ((this.mlo & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mlo & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mlm = i;
        }
        super.GD(i);
        if (!this.lpy) {
            this.mlz.setVisibility(8);
            this.mlA.setVisibility(8);
            if (this.lON != null) {
                this.lON.vy((i & 1024) > 0);
            }
        }
        if (this.lON != null) {
            this.lON.vy((i & 128) > 0);
        }
        if (this.mlw instanceof PbVideoMediaController) {
            this.mlw.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mlw).setBottomBarShow((i & 16384) > 0);
        }
        if (this.lOI != null) {
            this.lOI.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.lOJ != null) {
            this.lOJ.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.lOH != null) {
            boolean z = (131072 & i) > 0;
            this.lOH.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Jd("c13600"));
            }
        }
        if (!this.lpy && !this.lMp && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.lMq) {
                    if (this.lNO == null || !this.lNO.drj()) {
                        drg();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.lMq = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lMs);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.lMs, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.lMq || (this.lNO != null && this.lNO.drj())) {
                aGR();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vC(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lpy);
        }
        super.vC(z);
        dsn();
        if (this.lpy) {
            dsk();
        } else {
            this.lOG.setVisibility(8);
        }
    }

    private void dsk() {
        if (!this.lOL && !this.lOG.dsp()) {
            this.lOG.setTranslationX(0.0f);
            this.lOG.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.lOG.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.alS ? R.dimen.tbds248 : R.dimen.tbds428);
            this.lOM = ObjectAnimator.ofFloat(this.lOG, "translationX", 0.0f);
            this.lOM.setDuration(500);
            dsn();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.lOP, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dsl() {
        if (this.mlo == this.mlm) {
            return false;
        }
        this.mlB.setVisibility(0);
        this.mlB.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lOO);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lOO, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dsm() {
        if (this.mlo == this.mlm) {
            return false;
        }
        this.mlB.setVisibility(0);
        this.mlB.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lOO);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lOO, 1500L);
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
                dsn();
                com.baidu.adp.lib.f.e.mY().post(this.lOQ);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.lON != null) {
                    this.lON.vz(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.lON != null) {
                    this.lON.drz();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mlk &= -131073;
                this.mlo &= -131073;
                this.lOH.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean re(boolean z) {
        dsn();
        this.lOG.setVisibility(8);
        if (!this.lMp) {
            aGR();
        }
        if (z) {
            this.lOK = this.mlo;
            if (this.mlo == this.mli || ((this.mlo == this.mlj && !this.gjd.isPlaying()) || this.mlo == this.mlk)) {
                this.lOK |= 1;
            }
            stopPlay();
            return true;
        } else if (this.lOK == -1) {
            startPlay();
            return true;
        } else if (this.lOK == this.mlf || this.lOK == this.mlh || this.lOK == this.mlg) {
            startPlay();
            return true;
        } else {
            this.mlw.setCurrentDuration(n.dxh().QK(this.mVideoUrl), false);
            GD(this.lOK);
            return true;
        }
    }

    private aq Jd(String str) {
        aq dR = new aq(str).dR("tid", this.alT).w("fid", this.mFid).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dR.dR("obj_param4", this.baijiahaoData.oriUgcNid);
            dR.dR("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dR.al("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dR.al("obj_param5", 3);
            }
        } else {
            dR.al("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).djz() != null) {
            dR.dR("ab_tag", ((PbActivity) this.mContext).djz().dms()).dR("obj_id", ((PbActivity) this.mContext).djz().dmt()).dR("obj_source", ((PbActivity) this.mContext).djz().dmr());
        }
        return dR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void GE(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Jd("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Jd("c13601").al("obj_type", this.lOH.lOx ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsn() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lOP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lOQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGR() {
        drh();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.lMq = false;
        if (this.lNO != null) {
            this.lNO.vu(false);
        }
    }

    private void drg() {
        if (this.lMt == null) {
            this.lMt = ObjectAnimator.ofFloat(this.lLY, "alpha", 0.0f, 1.0f);
            this.lMt.setDuration(200L);
        }
        this.lMt.start();
    }

    private void drh() {
        if (this.lMu == null) {
            this.lMu = ObjectAnimator.ofFloat(this.lLY, "alpha", 1.0f, 0.0f);
            this.lMu.setDuration(200L);
        }
        this.lMu.start();
    }

    public void onDestroy() {
        dsn();
        wt(false);
    }

    public boolean bXc() {
        return this.alS;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.lNO = videoPbFragment;
    }

    public void dw(View view) {
        this.mRootView = view;
    }

    public void dx(View view) {
        this.lLY = view;
    }

    public boolean drj() {
        return this.lMq;
    }

    public void vu(boolean z) {
        this.lMq = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dso() {
        if (this.mlH != null) {
            o dxi = this.mlH.dxi();
            dxi.mLocate = "pb";
            h.a(dxi.mjW, "", "2", dxi, this.gjd.getPcdnState());
        }
    }
}
