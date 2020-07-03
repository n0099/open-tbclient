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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.play.operableVideoView.d;
import com.baidu.tieba.play.x;
/* loaded from: classes9.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int kfT;
    private String kfU;
    private int kwN;
    private View kwY;
    private boolean kxp;
    private boolean kxq;
    private Runnable kxs;
    private ObjectAnimator kxt;
    private ObjectAnimator kxu;
    private VideoPbFragment kyE;
    private Runnable kzA;
    private Runnable kzB;
    private final int kzl;
    private final int kzm;
    private final int kzn;
    private final int kzo;
    private final int kzp;
    private final int kzq;
    private PbVideoFullscreenAttentionLayout kzr;
    private PbNextVideoLayout kzs;
    private ImageView kzt;
    private ImageView kzu;
    private int kzv;
    private boolean kzw;
    private ObjectAnimator kzx;
    private e kzy;
    private Runnable kzz;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.kzl = 16384;
        this.kzm = 32768;
        this.kzn = 65536;
        this.kzo = 131072;
        this.kzp = 5000;
        this.kzq = 1500;
        this.kzv = -1;
        this.kfT = 0;
        this.kzz = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.kWT.setVisibility(8);
            }
        };
        this.kzA = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kzr.cQD()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.ajN ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.kzw = true;
                    a.this.kzx.setFloatValues(-l.getDimens(context2, i));
                    a.this.kzx.removeAllListeners();
                    a.this.kzx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cQB();
                            com.baidu.adp.lib.f.e.lt().postDelayed(a.this.kzB, 5000L);
                        }
                    });
                    a.this.kzx.start();
                }
            }
        };
        this.kzB = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.kzx.setFloatValues(l.getDimens(a.this.mContext, a.this.ajN ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.kzx.removeAllListeners();
                a.this.kzx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kzr.setVisibility(8);
                    }
                });
                a.this.kzx.start();
            }
        };
        this.kxs = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kxq && (a.this.mContext instanceof Activity)) {
                    a.this.apk();
                }
            }
        };
        cQw();
        if (context instanceof PbActivity) {
            this.kzy = (e) y.b((PbActivity) context).l(e.class);
            this.kxp = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        tM(true);
        this.kXa = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kzr = (PbVideoFullscreenAttentionLayout) this.kWW.findViewById(R.id.video_fullscreen_attention);
        this.kzs = (PbNextVideoLayout) this.kWW.findViewById(R.id.video_next_layout);
        this.kzt = (ImageView) this.kWW.findViewById(R.id.video_pre);
        this.kzu = (ImageView) this.kWW.findViewById(R.id.video_next);
        SvgManager.aWQ().a(this.kzt, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aWQ().a(this.kzu, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ajE.bjE();
        this.ajE.setDrawCorner(false);
        this.kzr.setOnClickEvent(this);
        this.kzt.setOnClickListener(this);
        this.kzu.setOnClickListener(this);
        this.kzs.setOnClickListener(this);
        this.kwN = l.getEquipmentWidth(this.mContext) / 10;
        this.kWQ.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cQt() {
        this.kRW.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void sV(boolean z) {
        this.kzs.setIsCountDownValid(z);
    }

    public void aT(bu buVar) {
        if (buVar == null || buVar.aSH() == null || ar.isEmpty(buVar.aSH().video_url)) {
            if (this.kWG == this.kWz || this.kWG == this.kWA) {
                this.kWG &= -65537;
                BW(this.kWG);
            }
            this.kWz &= -65537;
            this.kWA &= -65537;
            return;
        }
        if (this.kWG == this.kWz || this.kWG == this.kWA) {
            this.kWG |= 65536;
            BW(this.kWG);
        }
        this.kWz |= 65536;
        this.kWA |= 65536;
    }

    public void aU(bu buVar) {
        if (buVar == null || buVar.aSH() == null || ar.isEmpty(buVar.aSH().video_url)) {
            if (this.kWG == this.kWz || this.kWG == this.kWA || this.kWG == this.kWC) {
                this.kWG &= -32769;
                this.kWG &= -131073;
                BW(this.kWG);
            }
            this.kWz &= -32769;
            this.kWA &= -32769;
            this.kWC &= -131073;
            return;
        }
        if (this.kWG == this.kWz || this.kWG == this.kWA) {
            this.kWG |= 32768;
            BW(this.kWG);
        }
        if (this.kWG == this.kWC) {
            this.kWG |= 131072;
            BW(this.kWG);
        }
        this.kWz |= 32768;
        this.kWA |= 32768;
        this.kWC |= 131072;
        this.kzs.setDate(buVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bu buVar) {
        if (buVar != null) {
            this.baijiahaoData = buVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.ajO = buVar.getTid();
            yVar.eEs = Long.toString(buVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (buVar.isBjh()) {
                    this.kfT = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.kfT == 0) {
                        this.kfT = intent.getIntExtra("key_start_from", 0);
                    }
                    this.kfU = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.kfU)) {
                        yVar.dIK = this.kfU;
                    }
                    yVar.kVq = Integer.toString(this.kfT);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.kVq = this.source;
                }
            }
            if (buVar.aSH() != null) {
                yVar.kVt = buVar.aSH().video_md5;
                yVar.kVv = String.valueOf(buVar.aSH().is_vertical);
            }
            c(yVar);
            this.kzw = false;
            this.kzs.setIsCountDownValid(true);
            if (this.kbl && buVar.aSH() != null) {
                if (this.ajN != (buVar.aSH().is_vertical.intValue() == 1)) {
                    cWq();
                }
            }
            super.setData(buVar);
            tM(!this.ajN);
            if (buVar.aSp() != null) {
                buVar.aSp().setIsLike(buVar.aSp().hadConcerned());
            }
            this.kzr.setData(buVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQu() {
        super.cQu();
        if (this.kbl) {
            cQy();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kzr.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean J(MotionEvent motionEvent) {
        return this.kbl || motionEvent.getX() > ((float) this.kwN);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cQv() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQw() {
        this.kWw &= -33;
        this.kWx &= -33;
        this.kWy &= -33;
        this.kWz &= -33;
        this.kWA &= -33;
        this.kWB &= -33;
        this.kWC &= -33;
        this.kWD &= -33;
        this.kWE &= -33;
        this.kWw |= 1024;
        this.kWx |= 1024;
        this.kWy &= -1025;
        this.kWz |= 1024;
        this.kWA |= 1024;
        this.kWB |= 1024;
        this.kWC |= 1024;
        this.kWD |= 1024;
        this.kWE &= -1025;
        this.kWx |= 16384;
        this.kWB |= 16384;
        this.kWC &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQx() {
        int i = 0;
        this.kWP.am(this.ajN, this.kbl);
        this.kWQ.am(this.ajN, this.kbl);
        if (this.kWO instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.kWO).am(this.ajN, this.kbl);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kWN.getLayoutParams();
        int dimens = (this.kbl && this.ajN) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kbl && !this.ajN) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kzt.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kzu.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kbl || this.ajN) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kzs.am(this.ajN, this.kbl);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void BW(int i) {
        if (i != this.kWA && i != this.kWB && i != this.kWz && i != this.kWx) {
            cQB();
            if (this.kzr != null) {
                this.kzr.setVisibility(8);
            }
        }
        if (this.kWG != this.kWE && i == this.kWE) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kzz);
            if ((this.kWG & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.kWG & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.kWE = i;
        }
        super.BW(i);
        if (!this.kbl) {
            this.kWR.setVisibility(8);
            this.kWS.setVisibility(8);
            if (this.kzy != null) {
                this.kzy.sS((i & 1024) > 0);
            }
        }
        if (this.kWO instanceof PbVideoMediaController) {
            this.kWO.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.kWO).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kzt != null) {
            this.kzt.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.kzu != null) {
            this.kzu.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kzs != null) {
            boolean z = (131072 & i) > 0;
            this.kzs.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(DS("c13600"));
            }
        }
        if (!this.kbl && !this.kxp && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kxq) {
                    if (this.kyE == null || !this.kyE.cPE()) {
                        cPB();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kxq = true;
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kxs);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.kxs, 3000L);
                }
            } else if (this.kxq || (this.kyE != null && this.kyE.cPE())) {
                apk();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void sW(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kbl);
        }
        super.sW(z);
        cQB();
        if (this.kbl) {
            cQy();
        } else {
            this.kzr.setVisibility(8);
        }
    }

    private void cQy() {
        if (!this.kzw && !this.kzr.cQD()) {
            this.kzr.setTranslationX(0.0f);
            this.kzr.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kzr.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.ajN ? R.dimen.tbds248 : R.dimen.tbds428);
            this.kzx = ObjectAnimator.ofFloat(this.kzr, "translationX", 0.0f);
            this.kzx.setDuration(500);
            cQB();
            com.baidu.adp.lib.f.e.lt().postDelayed(this.kzA, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cQz() {
        if (this.kWG == this.kWE) {
            return false;
        }
        this.kWT.setVisibility(0);
        this.kWT.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kzz);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kzz, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cQA() {
        if (this.kWG == this.kWE) {
            return false;
        }
        this.kWT.setVisibility(0);
        this.kWT.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kzz);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kzz, 1500L);
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
                cQB();
                com.baidu.adp.lib.f.e.lt().post(this.kzB);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.kzy != null) {
                    this.kzy.sT(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ao("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.kzy != null) {
                    this.kzy.cPU();
                }
                TiebaStatic.log(new ao("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.kWC &= -131073;
                this.kWG &= -131073;
                this.kzs.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean oC(boolean z) {
        cQB();
        this.kzr.setVisibility(8);
        if (!this.kxp) {
            apk();
        }
        if (z) {
            this.kzv = this.kWG;
            if (this.kWG == this.kWA || ((this.kWG == this.kWB && !this.kRW.isPlaying()) || this.kWG == this.kWC)) {
                this.kzv |= 1;
            }
            stopPlay();
            return true;
        } else if (this.kzv == -1) {
            startPlay();
            return true;
        } else if (this.kzv == this.kWx || this.kzv == this.kWz || this.kzv == this.kWy) {
            startPlay();
            return true;
        } else {
            this.kWO.setCurrentDuration(x.cVV().Lc(this.mVideoUrl), false);
            BW(this.kzv);
            return true;
        }
    }

    private ao DS(String str) {
        ao dk = new ao(str).dk("tid", this.ajO).s("fid", this.mFid).dk("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dk.dk("obj_param4", this.baijiahaoData.oriUgcNid);
            dk.dk("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dk.ag("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dk.ag("obj_param5", 3);
            }
        } else {
            dk.ag("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cIe() != null) {
            dk.dk("ab_tag", ((PbActivity) this.mContext).cIe().cKU()).dk("obj_id", ((PbActivity) this.mContext).cIe().cKV()).dk("obj_source", ((PbActivity) this.mContext).cIe().cKT());
        }
        return dk;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void BX(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ao("c13598"));
            } else {
                TiebaStatic.log(new ao("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(DS("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ao("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ao("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(DS("c13601").ag("obj_type", this.kzs.kzi ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQB() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kzA);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kzB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apk() {
        cPC();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kxq = false;
        if (this.kyE != null) {
            this.kyE.sO(false);
        }
    }

    private void cPB() {
        if (this.kxt == null) {
            this.kxt = ObjectAnimator.ofFloat(this.kwY, "alpha", 0.0f, 1.0f);
            this.kxt.setDuration(200L);
        }
        this.kxt.start();
    }

    private void cPC() {
        if (this.kxu == null) {
            this.kxu = ObjectAnimator.ofFloat(this.kwY, "alpha", 1.0f, 0.0f);
            this.kxu.setDuration(200L);
        }
        this.kxu.start();
    }

    public void onDestroy() {
        cQB();
        tM(false);
    }

    public boolean bAr() {
        return this.ajN;
    }

    public void ad(VideoPbFragment videoPbFragment) {
        this.kyE = videoPbFragment;
    }

    public void cR(View view) {
        this.mRootView = view;
    }

    public void cS(View view) {
        this.kwY = view;
    }

    public boolean cPE() {
        return this.kxq;
    }

    public void sO(boolean z) {
        this.kxq = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQC() {
        com.baidu.tieba.play.y cVW = this.kWZ.cVF().cVW();
        cVW.mLocate = "pb";
        com.baidu.tieba.play.l.a(cVW.kVt, "", "2", cVW, this.kRW.getPcdnState());
    }
}
