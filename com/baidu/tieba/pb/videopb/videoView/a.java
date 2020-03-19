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
    private int iJT;
    private String iJU;
    private int iZX;
    private Runnable jaB;
    private ObjectAnimator jaC;
    private ObjectAnimator jaD;
    private View jai;
    private boolean jay;
    private boolean jaz;
    private VideoPbFragment jbK;
    private ObjectAnimator jcA;
    private e jcB;
    private Runnable jcC;
    private Runnable jcD;
    private Runnable jcE;
    private final int jco;
    private final int jcp;
    private final int jcq;
    private final int jcr;
    private final int jcs;
    private final int jct;
    private PbVideoFullscreenAttentionLayout jcu;
    private PbNextVideoLayout jcv;
    private ImageView jcw;
    private ImageView jcx;
    private int jcy;
    private boolean jcz;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.jco = 16384;
        this.jcp = 32768;
        this.jcq = 65536;
        this.jcr = 131072;
        this.jcs = 5000;
        this.jct = 1500;
        this.jcy = -1;
        this.iJT = 0;
        this.jcC = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jzM.setVisibility(8);
            }
        };
        this.jcD = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jcu.cuu()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.Pj ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.jcz = true;
                    a.this.jcA.setFloatValues(-l.getDimens(context2, i));
                    a.this.jcA.removeAllListeners();
                    a.this.jcA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cur();
                            com.baidu.adp.lib.f.e.gx().postDelayed(a.this.jcE, 5000L);
                        }
                    });
                    a.this.jcA.start();
                }
            }
        };
        this.jcE = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jcA.setFloatValues(l.getDimens(a.this.mContext, a.this.Pj ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.jcA.removeAllListeners();
                a.this.jcA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.jcu.setVisibility(8);
                    }
                });
                a.this.jcA.start();
            }
        };
        this.jaB = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jaz && (a.this.mContext instanceof Activity)) {
                    a.this.cus();
                }
            }
        };
        cum();
        if (context instanceof PbActivity) {
            this.jcB = (e) y.b((PbActivity) context).l(e.class);
            this.jay = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        rW(true);
        this.jzT = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jcu = (PbVideoFullscreenAttentionLayout) this.jzP.findViewById(R.id.video_fullscreen_attention);
        this.jcv = (PbNextVideoLayout) this.jzP.findViewById(R.id.video_next_layout);
        this.jcw = (ImageView) this.jzP.findViewById(R.id.video_pre);
        this.jcx = (ImageView) this.jzP.findViewById(R.id.video_next);
        SvgManager.aGG().a(this.jcw, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aGG().a(this.jcx, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.OZ.aSX();
        this.OZ.setDrawCorner(false);
        this.jcu.setOnClickEvent(this);
        this.jcw.setOnClickListener(this);
        this.jcx.setOnClickListener(this);
        this.jcv.setOnClickListener(this);
        this.iZX = l.getEquipmentWidth(this.mContext) / 10;
        this.jzJ.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cuj() {
        this.jvf.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void rf(boolean z) {
        this.jcv.setIsCountDownValid(z);
    }

    public void aR(bj bjVar) {
        if (bjVar == null || bjVar.aCI() == null || aq.isEmpty(bjVar.aCI().video_url)) {
            if (this.jzz == this.jzt || this.jzz == this.STATE_PAUSE) {
                this.jzz &= -65537;
                zG(this.jzz);
            }
            this.jzt &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jzz == this.jzt || this.jzz == this.STATE_PAUSE) {
            this.jzz |= 65536;
            zG(this.jzz);
        }
        this.jzt |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aS(bj bjVar) {
        if (bjVar == null || bjVar.aCI() == null || aq.isEmpty(bjVar.aCI().video_url)) {
            if (this.jzz == this.jzt || this.jzz == this.STATE_PAUSE || this.jzz == this.jzv) {
                this.jzz &= -32769;
                this.jzz &= -131073;
                zG(this.jzz);
            }
            this.jzt &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jzv &= -131073;
            return;
        }
        if (this.jzz == this.jzt || this.jzz == this.STATE_PAUSE) {
            this.jzz |= 32768;
            zG(this.jzz);
        }
        if (this.jzz == this.jzv) {
            this.jzz |= 131072;
            zG(this.jzz);
        }
        this.jzt |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jzv |= 131072;
        this.jcv.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.Pk = bjVar.getTid();
            yVar.emF = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.iJT = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.iJT == 0) {
                        this.iJT = intent.getIntExtra("key_start_from", 0);
                    }
                    this.iJU = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.iJU)) {
                        yVar.cPf = this.iJU;
                    }
                    yVar.jyt = Integer.toString(this.iJT);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jyt = this.source;
                }
            }
            if (bjVar.aCI() != null) {
                yVar.jyv = bjVar.aCI().video_md5;
                yVar.jyx = String.valueOf(bjVar.aCI().is_vertical);
            }
            c(yVar);
            this.jcz = false;
            this.jcv.setIsCountDownValid(true);
            if (this.iFB && bjVar.aCI() != null) {
                if (this.Pj != (bjVar.aCI().is_vertical.intValue() == 1)) {
                    cAc();
                }
            }
            super.setData(bjVar);
            rW(!this.Pj);
            if (bjVar.aCr() != null) {
                bjVar.aCr().setIsLike(bjVar.aCr().hadConcerned());
            }
            this.jcu.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cuk() {
        super.cuk();
        if (this.iFB) {
            cuo();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.jcu.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iFB || motionEvent.getX() > ((float) this.iZX);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cul() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cum() {
        this.STATE_STOP &= -33;
        this.jzr &= -33;
        this.jzs &= -33;
        this.jzt &= -33;
        this.STATE_PAUSE &= -33;
        this.jzu &= -33;
        this.jzv &= -33;
        this.jzw &= -33;
        this.jzx &= -33;
        this.STATE_STOP |= 1024;
        this.jzr |= 1024;
        this.jzs &= -1025;
        this.jzt |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jzu |= 1024;
        this.jzv |= 1024;
        this.jzw |= 1024;
        this.jzx &= -1025;
        this.jzr |= 16384;
        this.jzu |= 16384;
        this.jzv &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cun() {
        int i = 0;
        this.jzI.ah(this.Pj, this.iFB);
        this.jzJ.ah(this.Pj, this.iFB);
        if (this.jzH instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jzH).ah(this.Pj, this.iFB);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jzG.getLayoutParams();
        int dimens = (this.iFB && this.Pj) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iFB && !this.Pj) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jcw.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.jcx.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iFB || this.Pj) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.jcv.ah(this.Pj, this.iFB);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zG(int i) {
        if (i != this.STATE_PAUSE && i != this.jzu && i != this.jzt && i != this.jzr) {
            cur();
            if (this.jcu != null) {
                this.jcu.setVisibility(8);
            }
        }
        if (this.jzz != this.jzx && i == this.jzx) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcC);
            if ((this.jzz & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jzz & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jzx = i;
        }
        super.zG(i);
        if (!this.iFB) {
            this.jzK.setVisibility(8);
            this.jzL.setVisibility(8);
            if (this.jcB != null) {
                this.jcB.rc((i & 1024) > 0);
            }
        }
        if (this.jzH instanceof PbVideoMediaController) {
            this.jzH.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jzH).setBottomBarShow((i & 16384) > 0);
        }
        if (this.jcw != null) {
            this.jcw.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.jcx != null) {
            this.jcx.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.jcv != null) {
            boolean z = (131072 & i) > 0;
            this.jcv.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(zZ("c13600"));
            }
        }
        if (!this.iFB && !this.jay && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.jaz) {
                    if (this.jbK == null || !this.jbK.ctw()) {
                        ctt();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.jaz = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jaB);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.jaB, 3000L);
                }
            } else if (this.jaz || (this.jbK != null && this.jbK.ctw())) {
                cus();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void rg(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.iFB);
        }
        super.rg(z);
        cur();
        if (this.iFB) {
            cuo();
        } else {
            this.jcu.setVisibility(8);
        }
    }

    private void cuo() {
        if (!this.jcz && !this.jcu.cuu()) {
            this.jcu.setTranslationX(0.0f);
            this.jcu.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jcu.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.Pj ? R.dimen.tbds248 : R.dimen.tbds428);
            this.jcA = ObjectAnimator.ofFloat(this.jcu, "translationX", 0.0f);
            this.jcA.setDuration(500);
            cur();
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jcD, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cup() {
        if (this.jzz == this.jzx) {
            return false;
        }
        this.jzM.setVisibility(0);
        this.jzM.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcC);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jcC, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cuq() {
        if (this.jzz == this.jzx) {
            return false;
        }
        this.jzM.setVisibility(0);
        this.jzM.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcC);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jcC, 1500L);
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
                cur();
                com.baidu.adp.lib.f.e.gx().post(this.jcE);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.jcB != null) {
                    this.jcB.rd(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.jcB != null) {
                    this.jcB.ctM();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jzv &= -131073;
                this.jzz &= -131073;
                this.jcv.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mR(boolean z) {
        cur();
        this.jcu.setVisibility(8);
        if (!this.jay) {
            cus();
        }
        if (z) {
            this.jcy = this.jzz;
            if (this.jzz == this.STATE_PAUSE || ((this.jzz == this.jzu && !this.jvf.isPlaying()) || this.jzz == this.jzv)) {
                this.jcy |= 1;
            }
            stopPlay();
            return true;
        } else if (this.jcy == -1) {
            startPlay();
            return true;
        } else if (this.jcy == this.jzr || this.jcy == this.jzt) {
            startPlay();
            return true;
        } else {
            this.jzH.setCurrentDuration(x.czM().He(this.mVideoUrl), false);
            zG(this.jcy);
            return true;
        }
    }

    private an zZ(String str) {
        an cx = new an(str).cx("tid", this.Pk).s("fid", this.mFid).cx("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            cx.cx("obj_param4", this.baijiahaoData.oriUgcNid);
            cx.cx("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                cx.X("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                cx.X("obj_param5", 3);
            }
        } else {
            cx.X("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).clX() != null) {
            cx.cx(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).clX().coO()).cx("obj_id", ((PbActivity) this.mContext).clX().coP()).cx("obj_source", ((PbActivity) this.mContext).clX().coN());
        }
        return cx;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void zH(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new an("c13598"));
            } else {
                TiebaStatic.log(new an("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(zZ("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(zZ("c13601").X("obj_type", this.jcv.jcl ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cur() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcD);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cus() {
        ctu();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.jaz = false;
        if (this.jbK != null) {
            this.jbK.qY(false);
        }
    }

    private void ctt() {
        if (this.jaC == null) {
            this.jaC = ObjectAnimator.ofFloat(this.jai, "alpha", 0.0f, 1.0f);
            this.jaC.setDuration(200L);
        }
        this.jaC.start();
    }

    private void ctu() {
        if (this.jaD == null) {
            this.jaD = ObjectAnimator.ofFloat(this.jai, "alpha", 1.0f, 0.0f);
            this.jaD.setDuration(200L);
        }
        this.jaD.start();
    }

    public void onDestroy() {
        cur();
        rW(false);
    }

    public boolean bis() {
        return this.Pj;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.jbK = videoPbFragment;
    }

    public void cH(View view) {
        this.mRootView = view;
    }

    public void cI(View view) {
        this.jai = view;
    }

    public boolean ctw() {
        return this.jaz;
    }

    public void qY(boolean z) {
        this.jaz = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cut() {
        com.baidu.tieba.play.y czN = this.jzS.czw().czN();
        czN.mLocate = "pb";
        com.baidu.tieba.play.l.a(czN.jyv, "", "2", czN);
    }
}
