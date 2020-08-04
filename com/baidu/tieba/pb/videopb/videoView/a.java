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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.operableVideoView.d;
/* loaded from: classes16.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int kFI;
    private View kFU;
    private boolean kGl;
    private boolean kGm;
    private Runnable kGo;
    private ObjectAnimator kGp;
    private ObjectAnimator kGq;
    private VideoPbFragment kHG;
    private boolean kIA;
    private ObjectAnimator kIB;
    private e kIC;
    private Runnable kID;
    private Runnable kIE;
    private Runnable kIF;
    private final int kIp;
    private final int kIq;
    private final int kIr;
    private final int kIs;
    private final int kIt;
    private final int kIu;
    private PbVideoFullscreenAttentionLayout kIv;
    private PbNextVideoLayout kIw;
    private ImageView kIx;
    private ImageView kIy;
    private int kIz;
    private int koK;
    private String koL;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.kIp = 16384;
        this.kIq = 32768;
        this.kIr = 65536;
        this.kIs = 131072;
        this.kIt = 5000;
        this.kIu = 1500;
        this.kIz = -1;
        this.koK = 0;
        this.kID = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.leu.setVisibility(8);
            }
        };
        this.kIE = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kIv.cUu()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.ajI ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.kIA = true;
                    a.this.kIB.setFloatValues(-l.getDimens(context2, i));
                    a.this.kIB.removeAllListeners();
                    a.this.kIB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cUs();
                            com.baidu.adp.lib.f.e.lt().postDelayed(a.this.kIF, 5000L);
                        }
                    });
                    a.this.kIB.start();
                }
            }
        };
        this.kIF = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.kIB.setFloatValues(l.getDimens(a.this.mContext, a.this.ajI ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.kIB.removeAllListeners();
                a.this.kIB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kIv.setVisibility(8);
                    }
                });
                a.this.kIB.start();
            }
        };
        this.kGo = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kGm && (a.this.mContext instanceof Activity)) {
                    a.this.aqT();
                }
            }
        };
        cUn();
        if (context instanceof PbActivity) {
            this.kIC = (e) y.b((PbActivity) context).l(e.class);
            this.kGl = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        uq(true);
        this.leC = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kIv = (PbVideoFullscreenAttentionLayout) this.lex.findViewById(R.id.video_fullscreen_attention);
        this.kIw = (PbNextVideoLayout) this.lex.findViewById(R.id.video_next_layout);
        this.kIx = (ImageView) this.lex.findViewById(R.id.video_pre);
        this.kIy = (ImageView) this.lex.findViewById(R.id.video_next);
        SvgManager.baR().a(this.kIx, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.baR().a(this.kIy, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ajz.bny();
        this.ajz.setDrawCorner(false);
        this.kIv.setOnClickEvent(this);
        this.kIx.setOnClickListener(this);
        this.kIy.setOnClickListener(this);
        this.kIw.setOnClickListener(this);
        this.kFI = l.getEquipmentWidth(this.mContext) / 10;
        this.ler.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cUk() {
        this.fsr.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void tB(boolean z) {
        this.kIw.setIsCountDownValid(z);
    }

    public void aQ(bv bvVar) {
        if (bvVar == null || bvVar.aWD() == null || as.isEmpty(bvVar.aWD().video_url)) {
            if (this.leg == this.ldZ || this.leg == this.lea) {
                this.leg &= -65537;
                Cw(this.leg);
            }
            this.ldZ &= -65537;
            this.lea &= -65537;
            return;
        }
        if (this.leg == this.ldZ || this.leg == this.lea) {
            this.leg |= 65536;
            Cw(this.leg);
        }
        this.ldZ |= 65536;
        this.lea |= 65536;
    }

    public void aR(bv bvVar) {
        if (bvVar == null || bvVar.aWD() == null || as.isEmpty(bvVar.aWD().video_url)) {
            if (this.leg == this.ldZ || this.leg == this.lea || this.leg == this.lec) {
                this.leg &= -32769;
                this.leg &= -131073;
                Cw(this.leg);
            }
            this.ldZ &= -32769;
            this.lea &= -32769;
            this.lec &= -131073;
            return;
        }
        if (this.leg == this.ldZ || this.leg == this.lea) {
            this.leg |= 32768;
            Cw(this.leg);
        }
        if (this.leg == this.lec) {
            this.leg |= 131072;
            Cw(this.leg);
        }
        this.ldZ |= 32768;
        this.lea |= 32768;
        this.lec |= 131072;
        this.kIw.setDate(bvVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        if (bvVar != null) {
            this.baijiahaoData = bvVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.ajJ = bvVar.getTid();
            oVar.eKO = Long.toString(bvVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bvVar.isBjh()) {
                    this.koK = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.koK == 0) {
                        this.koK = intent.getIntExtra("key_start_from", 0);
                    }
                    this.koL = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.koL)) {
                        oVar.dOV = this.koL;
                    }
                    oVar.lcL = Integer.toString(this.koK);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.lcL = this.source;
                }
            }
            if (bvVar.aWD() != null) {
                oVar.lcO = bvVar.aWD().video_md5;
                oVar.lcQ = String.valueOf(bvVar.aWD().is_vertical);
            }
            b(oVar);
            this.kIA = false;
            if (com.baidu.tbadk.a.d.aRQ()) {
                this.kIw.setIsCountDownValid(false);
            } else {
                this.kIw.setIsCountDownValid(true);
            }
            if (this.kjR && bvVar.aWD() != null) {
                if (this.ajI != (bvVar.aWD().is_vertical.intValue() == 1)) {
                    cZD();
                }
            }
            super.setData(bvVar);
            uq(!this.ajI);
            if (bvVar.aWl() != null) {
                bvVar.aWl().setIsLike(bvVar.aWl().hadConcerned());
            }
            this.kIv.setData(bvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUl() {
        super.cUl();
        if (this.kjR) {
            cUp();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kIv.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean J(MotionEvent motionEvent) {
        return this.kjR || motionEvent.getX() > ((float) this.kFI);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cUm() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUn() {
        this.ldW &= -33;
        this.ldX &= -33;
        this.ldY &= -33;
        this.ldZ &= -33;
        this.lea &= -33;
        this.leb &= -33;
        this.lec &= -33;
        this.led &= -33;
        this.lee &= -33;
        this.ldW |= 1024;
        this.ldX |= 1024;
        this.ldY &= -1025;
        this.ldZ |= 1024;
        this.lea |= 1024;
        this.leb |= 1024;
        this.lec |= 1024;
        this.led |= 1024;
        this.lee &= -1025;
        this.ldX |= 16384;
        this.leb |= 16384;
        this.lec &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUo() {
        int i = 0;
        this.leq.an(this.ajI, this.kjR);
        this.ler.an(this.ajI, this.kjR);
        if (this.lep instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.lep).an(this.ajI, this.kjR);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.leo.getLayoutParams();
        int dimens = (this.kjR && this.ajI) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kjR && !this.ajI) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kIx.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kIy.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kjR || this.ajI) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kIw.an(this.ajI, this.kjR);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Cw(int i) {
        if (i != this.lea && i != this.leb && i != this.ldZ && i != this.ldX) {
            cUs();
            if (this.kIv != null) {
                this.kIv.setVisibility(8);
            }
        }
        if (this.leg != this.lee && i == this.lee) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kID);
            if ((this.leg & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.leg & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.lee = i;
        }
        super.Cw(i);
        if (!this.kjR) {
            this.les.setVisibility(8);
            this.let.setVisibility(8);
            if (this.kIC != null) {
                this.kIC.ty((i & 1024) > 0);
            }
        }
        if (this.kIC != null) {
            this.kIC.ty((i & 128) > 0);
        }
        if (this.lep instanceof PbVideoMediaController) {
            this.lep.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.lep).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kIx != null) {
            this.kIx.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.kIy != null) {
            this.kIy.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kIw != null) {
            boolean z = (131072 & i) > 0;
            this.kIw.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(ED("c13600"));
            }
        }
        if (!this.kjR && !this.kGl && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kGm) {
                    if (this.kHG == null || !this.kHG.cTt()) {
                        cTq();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kGm = true;
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kGo);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.kGo, 3000L);
                }
            } else if (this.kGm || (this.kHG != null && this.kHG.cTt())) {
                aqT();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void tC(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kjR);
        }
        super.tC(z);
        cUs();
        if (this.kjR) {
            cUp();
        } else {
            this.kIv.setVisibility(8);
        }
    }

    private void cUp() {
        if (!this.kIA && !this.kIv.cUu()) {
            this.kIv.setTranslationX(0.0f);
            this.kIv.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kIv.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.ajI ? R.dimen.tbds248 : R.dimen.tbds428);
            this.kIB = ObjectAnimator.ofFloat(this.kIv, "translationX", 0.0f);
            this.kIB.setDuration(500);
            cUs();
            com.baidu.adp.lib.f.e.lt().postDelayed(this.kIE, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cUq() {
        if (this.leg == this.lee) {
            return false;
        }
        this.leu.setVisibility(0);
        this.leu.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kID);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kID, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cUr() {
        if (this.leg == this.lee) {
            return false;
        }
        this.leu.setVisibility(0);
        this.leu.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kID);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kID, 1500L);
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
                cUs();
                com.baidu.adp.lib.f.e.lt().post(this.kIF);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.kIC != null) {
                    this.kIC.tz(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ap("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.kIC != null) {
                    this.kIC.cTJ();
                }
                TiebaStatic.log(new ap("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.lec &= -131073;
                this.leg &= -131073;
                this.kIw.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean ph(boolean z) {
        cUs();
        this.kIv.setVisibility(8);
        if (!this.kGl) {
            aqT();
        }
        if (z) {
            this.kIz = this.leg;
            if (this.leg == this.lea || ((this.leg == this.leb && !this.fsr.isPlaying()) || this.leg == this.lec)) {
                this.kIz |= 1;
            }
            stopPlay();
            return true;
        } else if (this.kIz == -1) {
            startPlay();
            return true;
        } else if (this.kIz == this.ldX || this.kIz == this.ldZ || this.kIz == this.ldY) {
            startPlay();
            return true;
        } else {
            this.lep.setCurrentDuration(n.cZa().LL(this.mVideoUrl), false);
            Cw(this.kIz);
            return true;
        }
    }

    private ap ED(String str) {
        ap dn = new ap(str).dn("tid", this.ajJ).t("fid", this.mFid).dn("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dn.dn("obj_param4", this.baijiahaoData.oriUgcNid);
            dn.dn("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dn.ah("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dn.ah("obj_param5", 3);
            }
        } else {
            dn.ah("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cLP() != null) {
            dn.dn("ab_tag", ((PbActivity) this.mContext).cLP().cOG()).dn("obj_id", ((PbActivity) this.mContext).cLP().cOH()).dn("obj_source", ((PbActivity) this.mContext).cLP().cOF());
        }
        return dn;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Cx(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ap("c13598"));
            } else {
                TiebaStatic.log(new ap("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(ED("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ap("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ap("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(ED("c13601").ah("obj_type", this.kIw.kIm ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUs() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kIE);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kIF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqT() {
        cTr();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kGm = false;
        if (this.kHG != null) {
            this.kHG.tu(false);
        }
    }

    private void cTq() {
        if (this.kGp == null) {
            this.kGp = ObjectAnimator.ofFloat(this.kFU, "alpha", 0.0f, 1.0f);
            this.kGp.setDuration(200L);
        }
        this.kGp.start();
    }

    private void cTr() {
        if (this.kGq == null) {
            this.kGq = ObjectAnimator.ofFloat(this.kFU, "alpha", 1.0f, 0.0f);
            this.kGq.setDuration(200L);
        }
        this.kGq.start();
    }

    public void onDestroy() {
        cUs();
        uq(false);
    }

    public boolean bDD() {
        return this.ajI;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.kHG = videoPbFragment;
    }

    public void cX(View view) {
        this.mRootView = view;
    }

    public void cY(View view) {
        this.kFU = view;
    }

    public boolean cTt() {
        return this.kGm;
    }

    public void tu(boolean z) {
        this.kGm = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUt() {
        if (this.leA != null) {
            o cZb = this.leA.cZb();
            cZb.mLocate = "pb";
            h.a(cZb.lcO, "", "2", cZb, this.fsr.getPcdnState());
        }
    }
}
