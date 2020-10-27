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
    private int lFQ;
    private View lGc;
    private boolean lGt;
    private boolean lGu;
    private Runnable lGw;
    private ObjectAnimator lGx;
    private ObjectAnimator lGy;
    private VideoPbFragment lHS;
    private final int lIE;
    private final int lIF;
    private final int lIG;
    private final int lIH;
    private final int lII;
    private final int lIJ;
    private PbVideoFullscreenAttentionLayout lIK;
    private PbNextVideoLayout lIL;
    private ImageView lIM;
    private ImageView lIN;
    private int lIO;
    private boolean lIP;
    private ObjectAnimator lIQ;
    private e lIR;
    private Runnable lIS;
    private Runnable lIT;
    private Runnable lIU;
    private int lov;
    private String lox;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.lIE = 16384;
        this.lIF = 32768;
        this.lIG = 65536;
        this.lIH = 131072;
        this.lII = 5000;
        this.lIJ = 1500;
        this.lIO = -1;
        this.lov = 0;
        this.lIS = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mfD.setVisibility(8);
            }
        };
        this.lIT = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.lIK.dpN()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.alS ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.lIP = true;
                    a.this.lIQ.setFloatValues(-l.getDimens(context2, i));
                    a.this.lIQ.removeAllListeners();
                    a.this.lIQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dpL();
                            com.baidu.adp.lib.f.e.mY().postDelayed(a.this.lIU, 5000L);
                        }
                    });
                    a.this.lIQ.start();
                }
            }
        };
        this.lIU = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.lIQ.setFloatValues(l.getDimens(a.this.mContext, a.this.alS ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.lIQ.removeAllListeners();
                a.this.lIQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.lIK.setVisibility(8);
                    }
                });
                a.this.lIQ.start();
            }
        };
        this.lGw = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.lGu && (a.this.mContext instanceof Activity)) {
                    a.this.aEr();
                }
            }
        };
        dpG();
        if (context instanceof PbActivity) {
            this.lIR = (e) y.b((PbActivity) context).l(e.class);
            this.lGt = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        wk(true);
        this.mfL = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lIK = (PbVideoFullscreenAttentionLayout) this.mfG.findViewById(R.id.video_fullscreen_attention);
        this.lIL = (PbNextVideoLayout) this.mfG.findViewById(R.id.video_next_layout);
        this.lIM = (ImageView) this.mfG.findViewById(R.id.video_pre);
        this.lIN = (ImageView) this.mfG.findViewById(R.id.video_next);
        SvgManager.boN().a(this.lIM, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.boN().a(this.lIN, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.alJ.bBZ();
        this.alJ.setDrawCorner(false);
        this.lIK.setOnClickEvent(this);
        this.lIM.setOnClickListener(this);
        this.lIN.setOnClickListener(this);
        this.lIL.setOnClickListener(this);
        this.lFQ = l.getEquipmentWidth(this.mContext) / 10;
        this.mfA.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dpD() {
        this.gdn.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void vs(boolean z) {
        this.lIL.setIsCountDownValid(z);
    }

    public void aS(bw bwVar) {
        if (bwVar == null || bwVar.bks() == null || at.isEmpty(bwVar.bks().video_url)) {
            if (this.mfq == this.mfj || this.mfq == this.mfk) {
                this.mfq &= -65537;
                Gq(this.mfq);
            }
            this.mfj &= -65537;
            this.mfk &= -65537;
            return;
        }
        if (this.mfq == this.mfj || this.mfq == this.mfk) {
            this.mfq |= 65536;
            Gq(this.mfq);
        }
        this.mfj |= 65536;
        this.mfk |= 65536;
    }

    public void aT(bw bwVar) {
        if (bwVar == null || bwVar.bks() == null || at.isEmpty(bwVar.bks().video_url)) {
            if (this.mfq == this.mfj || this.mfq == this.mfk || this.mfq == this.mfm) {
                this.mfq &= -32769;
                this.mfq &= -131073;
                Gq(this.mfq);
            }
            this.mfj &= -32769;
            this.mfk &= -32769;
            this.mfm &= -131073;
            return;
        }
        if (this.mfq == this.mfj || this.mfq == this.mfk) {
            this.mfq |= 32768;
            Gq(this.mfq);
        }
        if (this.mfq == this.mfm) {
            this.mfq |= 131072;
            Gq(this.mfq);
        }
        this.mfj |= 32768;
        this.mfk |= 32768;
        this.mfm |= 131072;
        this.lIL.setDate(bwVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.baijiahaoData = bwVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.alT = bwVar.getTid();
            oVar.fsZ = Long.toString(bwVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bwVar.isBjh()) {
                    this.lov = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lov == 0) {
                        this.lov = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lox = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lox)) {
                        oVar.eve = this.lox;
                    }
                    oVar.mdU = Integer.toString(this.lov);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mdU = this.source;
                }
            }
            if (bwVar.bks() != null) {
                oVar.mdX = bwVar.bks().video_md5;
                oVar.mdZ = String.valueOf(bwVar.bks().is_vertical);
            }
            b(oVar);
            this.lIP = false;
            if (com.baidu.tbadk.a.d.bfx()) {
                this.lIL.setIsCountDownValid(false);
            } else {
                this.lIL.setIsCountDownValid(true);
            }
            if (this.ljx && bwVar.bks() != null) {
                if (this.alS != (bwVar.bks().is_vertical.intValue() == 1)) {
                    dvj();
                }
            }
            super.setData(bwVar);
            wk(!this.alS);
            if (bwVar.bka() != null) {
                bwVar.bka().setIsLike(bwVar.bka().hadConcerned());
            }
            this.lIK.setData(bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpE() {
        super.dpE();
        if (this.ljx) {
            dpI();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.lIK.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.ljx || motionEvent.getX() > ((float) this.lFQ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dpF() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpG() {
        this.mfg &= -33;
        this.mfh &= -33;
        this.mfi &= -33;
        this.mfj &= -33;
        this.mfk &= -33;
        this.mfl &= -33;
        this.mfm &= -33;
        this.mfn &= -33;
        this.mfo &= -33;
        this.mfg |= 1024;
        this.mfh |= 1024;
        this.mfi &= -1025;
        this.mfj |= 1024;
        this.mfk |= 1024;
        this.mfl |= 1024;
        this.mfm |= 1024;
        this.mfn |= 1024;
        this.mfo &= -1025;
        this.mfh |= 16384;
        this.mfl |= 16384;
        this.mfm &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpH() {
        int i = 0;
        this.mfz.av(this.alS, this.ljx);
        this.mfA.av(this.alS, this.ljx);
        if (this.mfy instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mfy).av(this.alS, this.ljx);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mfx.getLayoutParams();
        int dimens = (this.ljx && this.alS) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.ljx && !this.alS) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lIM.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lIN.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.ljx || this.alS) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.lIL.av(this.alS, this.ljx);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gq(int i) {
        if (i != this.mfk && i != this.mfl && i != this.mfj && i != this.mfh) {
            dpL();
            if (this.lIK != null) {
                this.lIK.setVisibility(8);
            }
        }
        if (this.mfq != this.mfo && i == this.mfo) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIS);
            if ((this.mfq & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mfq & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mfo = i;
        }
        super.Gq(i);
        if (!this.ljx) {
            this.mfB.setVisibility(8);
            this.mfC.setVisibility(8);
            if (this.lIR != null) {
                this.lIR.vp((i & 1024) > 0);
            }
        }
        if (this.lIR != null) {
            this.lIR.vp((i & 128) > 0);
        }
        if (this.mfy instanceof PbVideoMediaController) {
            this.mfy.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mfy).setBottomBarShow((i & 16384) > 0);
        }
        if (this.lIM != null) {
            this.lIM.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.lIN != null) {
            this.lIN.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.lIL != null) {
            boolean z = (131072 & i) > 0;
            this.lIL.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(IM("c13600"));
            }
        }
        if (!this.ljx && !this.lGt && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.lGu) {
                    if (this.lHS == null || !this.lHS.doH()) {
                        doE();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.lGu = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lGw);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.lGw, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.lGu || (this.lHS != null && this.lHS.doH())) {
                aEr();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vt(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.ljx);
        }
        super.vt(z);
        dpL();
        if (this.ljx) {
            dpI();
        } else {
            this.lIK.setVisibility(8);
        }
    }

    private void dpI() {
        if (!this.lIP && !this.lIK.dpN()) {
            this.lIK.setTranslationX(0.0f);
            this.lIK.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.lIK.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.alS ? R.dimen.tbds248 : R.dimen.tbds428);
            this.lIQ = ObjectAnimator.ofFloat(this.lIK, "translationX", 0.0f);
            this.lIQ.setDuration(500);
            dpL();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.lIT, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dpJ() {
        if (this.mfq == this.mfo) {
            return false;
        }
        this.mfD.setVisibility(0);
        this.mfD.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIS);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lIS, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dpK() {
        if (this.mfq == this.mfo) {
            return false;
        }
        this.mfD.setVisibility(0);
        this.mfD.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIS);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lIS, 1500L);
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
                dpL();
                com.baidu.adp.lib.f.e.mY().post(this.lIU);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.lIR != null) {
                    this.lIR.vq(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.lIR != null) {
                    this.lIR.doX();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mfm &= -131073;
                this.mfq &= -131073;
                this.lIL.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean qV(boolean z) {
        dpL();
        this.lIK.setVisibility(8);
        if (!this.lGt) {
            aEr();
        }
        if (z) {
            this.lIO = this.mfq;
            if (this.mfq == this.mfk || ((this.mfq == this.mfl && !this.gdn.isPlaying()) || this.mfq == this.mfm)) {
                this.lIO |= 1;
            }
            stopPlay();
            return true;
        } else if (this.lIO == -1) {
            startPlay();
            return true;
        } else if (this.lIO == this.mfh || this.lIO == this.mfj || this.lIO == this.mfi) {
            startPlay();
            return true;
        } else {
            this.mfy.setCurrentDuration(n.duF().Qt(this.mVideoUrl), false);
            Gq(this.lIO);
            return true;
        }
    }

    private aq IM(String str) {
        aq dR = new aq(str).dR("tid", this.alT).w("fid", this.mFid).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dR.dR("obj_param4", this.baijiahaoData.oriUgcNid);
            dR.dR("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dR.aj("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dR.aj("obj_param5", 3);
            }
        } else {
            dR.aj("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dgX() != null) {
            dR.dR("ab_tag", ((PbActivity) this.mContext).dgX().djQ()).dR("obj_id", ((PbActivity) this.mContext).dgX().djR()).dR("obj_source", ((PbActivity) this.mContext).dgX().djP());
        }
        return dR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Gr(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(IM("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(IM("c13601").aj("obj_type", this.lIL.lIB ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpL() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIT);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEr() {
        doF();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.lGu = false;
        if (this.lHS != null) {
            this.lHS.vl(false);
        }
    }

    private void doE() {
        if (this.lGx == null) {
            this.lGx = ObjectAnimator.ofFloat(this.lGc, "alpha", 0.0f, 1.0f);
            this.lGx.setDuration(200L);
        }
        this.lGx.start();
    }

    private void doF() {
        if (this.lGy == null) {
            this.lGy = ObjectAnimator.ofFloat(this.lGc, "alpha", 1.0f, 0.0f);
            this.lGy.setDuration(200L);
        }
        this.lGy.start();
    }

    public void onDestroy() {
        dpL();
        wk(false);
    }

    public boolean bUC() {
        return this.alS;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.lHS = videoPbFragment;
    }

    public void dr(View view) {
        this.mRootView = view;
    }

    public void ds(View view) {
        this.lGc = view;
    }

    public boolean doH() {
        return this.lGu;
    }

    public void vl(boolean z) {
        this.lGu = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpM() {
        if (this.mfJ != null) {
            o duG = this.mfJ.duG();
            duG.mLocate = "pb";
            h.a(duG.mdX, "", "2", duG, this.gdn.getPcdnState());
        }
    }
}
