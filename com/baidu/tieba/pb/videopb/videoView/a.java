package com.baidu.tieba.pb.videopb.videoView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.operableVideoView.d;
/* loaded from: classes2.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int lSf;
    private String lSg;
    private View mRootView;
    private int mjR;
    private View mkd;
    private boolean mku;
    private boolean mkv;
    private Runnable mkx;
    private ObjectAnimator mky;
    private ObjectAnimator mkz;
    private VideoPbFragment mlS;
    private final int mmF;
    private final int mmG;
    private final int mmH;
    private final int mmI;
    private final int mmJ;
    private final int mmK;
    private PbVideoFullscreenAttentionLayout mmL;
    private PbNextVideoLayout mmM;
    private ImageView mmN;
    private ImageView mmO;
    private int mmP;
    private boolean mmQ;
    private ObjectAnimator mmR;
    private VideoPbViewModel mmS;
    private Runnable mmT;
    private Runnable mmU;
    private Runnable mmV;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mmF = 16384;
        this.mmG = 32768;
        this.mmH = 65536;
        this.mmI = 131072;
        this.mmJ = 5000;
        this.mmK = 1500;
        this.mmP = -1;
        this.lSf = 0;
        this.mmT = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mJS.setVisibility(8);
            }
        };
        this.mmU = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mmL.dvt()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.amB ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.mmQ = true;
                    a.this.mmR.setFloatValues(-l.getDimens(context2, i));
                    a.this.mmR.removeAllListeners();
                    a.this.mmR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dvr();
                            e.mA().postDelayed(a.this.mmV, 5000L);
                        }
                    });
                    a.this.mmR.start();
                }
            }
        };
        this.mmV = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.mmR.setFloatValues(l.getDimens(a.this.mContext, a.this.amB ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.mmR.removeAllListeners();
                a.this.mmR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mmL.setVisibility(8);
                    }
                });
                a.this.mmR.start();
            }
        };
        this.mkx = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mkv && (a.this.mContext instanceof Activity)) {
                    a.this.aHK();
                }
            }
        };
        dvm();
        if (context instanceof PbActivity) {
            this.mmS = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            this.mku = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xp(true);
        this.mKa = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mmL = (PbVideoFullscreenAttentionLayout) this.mJV.findViewById(R.id.video_fullscreen_attention);
        this.mmM = (PbNextVideoLayout) this.mJV.findViewById(R.id.video_next_layout);
        this.mmN = (ImageView) this.mJV.findViewById(R.id.video_pre);
        this.mmO = (ImageView) this.mJV.findViewById(R.id.video_next);
        SvgManager.bsR().a(this.mmN, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bsR().a(this.mmO, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.ams.bGo();
        this.ams.setDrawCorner(false);
        this.mmL.setOnClickEvent(this);
        this.mmN.setOnClickListener(this);
        this.mmO.setOnClickListener(this);
        this.mmM.setOnClickListener(this);
        this.mjR = l.getEquipmentWidth(this.mContext) / 10;
        this.mJP.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gzX.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void ww(boolean z) {
        this.mmM.setIsCountDownValid(z);
    }

    public void aW(cb cbVar) {
        if (cbVar == null || cbVar.boh() == null || au.isEmpty(cbVar.boh().video_url)) {
            if (this.mViewState == this.mJA || this.mViewState == this.mJB) {
                this.mViewState &= -65537;
                Gy(this.mViewState);
            }
            this.mJA &= -65537;
            this.mJB &= -65537;
            return;
        }
        if (this.mViewState == this.mJA || this.mViewState == this.mJB) {
            this.mViewState |= 65536;
            Gy(this.mViewState);
        }
        this.mJA |= 65536;
        this.mJB |= 65536;
    }

    public void aX(cb cbVar) {
        if (cbVar == null || cbVar.boh() == null || au.isEmpty(cbVar.boh().video_url)) {
            if (this.mViewState == this.mJA || this.mViewState == this.mJB || this.mViewState == this.mJD) {
                this.mViewState &= -32769;
                this.mViewState &= -131073;
                Gy(this.mViewState);
            }
            this.mJA &= -32769;
            this.mJB &= -32769;
            this.mJD &= -131073;
            return;
        }
        if (this.mViewState == this.mJA || this.mViewState == this.mJB) {
            this.mViewState |= 32768;
            Gy(this.mViewState);
        }
        if (this.mViewState == this.mJD) {
            this.mViewState |= 131072;
            Gy(this.mViewState);
        }
        this.mJA |= 32768;
        this.mJB |= 32768;
        this.mJD |= 131072;
        this.mmM.setDate(cbVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        if (cbVar != null) {
            this.baijiahaoData = cbVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.amC = cbVar.getTid();
            oVar.fNd = Long.toString(cbVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (cbVar.isBjh()) {
                    this.lSf = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lSf == 0) {
                        this.lSf = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lSg = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lSg)) {
                        oVar.eNE = this.lSg;
                    }
                    oVar.mIg = Integer.toString(this.lSf);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mIg = this.source;
                }
            }
            if (cbVar.boh() != null) {
                oVar.mIj = cbVar.boh().video_md5;
                oVar.mIl = String.valueOf(cbVar.boh().is_vertical);
            }
            b(oVar);
            this.mmQ = false;
            if (com.baidu.tbadk.a.d.bja()) {
                this.mmM.setIsCountDownValid(false);
            } else {
                this.mmM.setIsCountDownValid(true);
            }
            if (this.lMN && cbVar.boh() != null) {
                if (this.amB != (cbVar.boh().is_vertical.intValue() == 1)) {
                    dAL();
                }
            }
            super.setData(cbVar);
            xp(!this.amB);
            if (cbVar.bnQ() != null) {
                cbVar.bnQ().setIsLike(cbVar.bnQ().hadConcerned());
            }
            this.mmL.setData(cbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvk() {
        super.dvk();
        if (this.lMN) {
            dvo();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mmL.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lMN || motionEvent.getX() > ((float) this.mjR);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dvl() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvm() {
        this.mJx &= -33;
        this.mJy &= -33;
        this.mJz &= -33;
        this.mJA &= -33;
        this.mJB &= -33;
        this.mJC &= -33;
        this.mJD &= -33;
        this.mJE &= -33;
        this.mJF &= -33;
        this.mJx |= 1024;
        this.mJy |= 1024;
        this.mJz &= -1025;
        this.mJA |= 1024;
        this.mJB |= 1024;
        this.mJC |= 1024;
        this.mJD |= 1024;
        this.mJE |= 1024;
        this.mJF &= -1025;
        this.mJy |= 16384;
        this.mJC |= 16384;
        this.mJD &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvn() {
        int i = 0;
        this.mJO.au(this.amB, this.lMN);
        this.mJP.au(this.amB, this.lMN);
        if (this.mJN instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mJN).au(this.amB, this.lMN);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mJM.getLayoutParams();
        int dimens = (this.lMN && this.amB) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lMN && !this.amB) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mmN.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mmO.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lMN || this.amB) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mmM.au(this.amB, this.lMN);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gy(int i) {
        if (i != this.mJB && i != this.mJC && i != this.mJA && i != this.mJy) {
            dvr();
            if (this.mmL != null) {
                this.mmL.setVisibility(8);
            }
        }
        if (this.mViewState != this.mJF && i == this.mJF) {
            e.mA().removeCallbacks(this.mmT);
            if ((this.mViewState & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mViewState & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mJF = i;
        }
        super.Gy(i);
        if (!this.lMN) {
            this.mJQ.setVisibility(8);
            this.mJR.setVisibility(8);
            if (this.mmS != null) {
                this.mmS.ws((i & 1024) > 0);
            }
        }
        if (this.mmS != null) {
            this.mmS.ws((i & 128) > 0);
        }
        if (this.mJN instanceof PbVideoMediaController) {
            this.mJN.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mJN).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mmN != null) {
            this.mmN.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mmO != null) {
            this.mmO.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mmM != null) {
            boolean z = (131072 & i) > 0;
            this.mmM.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(IR("c13600"));
            }
        }
        if (!this.lMN && !this.mku && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.mkv) {
                    if (this.mlS == null || !this.mlS.dun()) {
                        duk();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.mkv = true;
                    e.mA().removeCallbacks(this.mkx);
                    e.mA().postDelayed(this.mkx, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.mkv || (this.mlS != null && this.mlS.dun())) {
                aHK();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wx(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lMN);
        }
        super.wx(z);
        dvr();
        if (this.lMN) {
            dvo();
        } else {
            this.mmL.setVisibility(8);
        }
    }

    private void dvo() {
        if (!this.mmQ && !this.mmL.dvt()) {
            this.mmL.setTranslationX(0.0f);
            this.mmL.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mmL.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.amB ? R.dimen.tbds248 : R.dimen.tbds428);
            this.mmR = ObjectAnimator.ofFloat(this.mmL, "translationX", 0.0f);
            this.mmR.setDuration(500);
            dvr();
            e.mA().postDelayed(this.mmU, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dvp() {
        if (this.mViewState == this.mJF) {
            return false;
        }
        this.mJS.setVisibility(0);
        this.mJS.c(this.mContext, true, 10);
        e.mA().removeCallbacks(this.mmT);
        e.mA().postDelayed(this.mmT, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dvq() {
        if (this.mViewState == this.mJF) {
            return false;
        }
        this.mJS.setVisibility(0);
        this.mJS.c(this.mContext, false, 10);
        e.mA().removeCallbacks(this.mmT);
        e.mA().postDelayed(this.mmT, 1500L);
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
                dvr();
                e.mA().post(this.mmV);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mmS != null) {
                    this.mmS.wt(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ar("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mmS != null) {
                    this.mmS.duC();
                }
                TiebaStatic.log(new ar("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mJD &= -131073;
                this.mViewState &= -131073;
                this.mmM.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        dvr();
        this.mmL.setVisibility(8);
        if (!this.mku) {
            aHK();
        }
        if (z) {
            this.mmP = this.mViewState;
            if (this.mViewState == this.mJB || ((this.mViewState == this.mJC && !this.gzX.isPlaying()) || this.mViewState == this.mJD)) {
                this.mmP |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mmP == -1) {
            startPlay();
            return true;
        } else if (this.mmP == this.mJy || this.mmP == this.mJA || this.mmP == this.mJz) {
            startPlay();
            return true;
        } else {
            this.mJN.setCurrentDuration(n.dAg().QD(this.mVideoUrl), false);
            Gy(this.mmP);
            return true;
        }
    }

    private ar IR(String str) {
        ar dR = new ar(str).dR("tid", this.amC).v("fid", this.mFid).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dR.dR("obj_param4", this.baijiahaoData.oriUgcNid);
            dR.dR("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dR.ap("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dR.ap("obj_param5", 3);
            }
        } else {
            dR.ap("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dmq() != null) {
            dR.dR("ab_tag", ((PbActivity) this.mContext).dmq().dpp()).dR("obj_id", ((PbActivity) this.mContext).dmq().dpq()).dR("obj_source", ((PbActivity) this.mContext).dmq().dpo());
        }
        return dR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Gz(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ar("c13598"));
            } else {
                TiebaStatic.log(new ar("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(IR("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ar("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ar("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(IR("c13601").ap("obj_type", this.mmM.mmC ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvr() {
        e.mA().removeCallbacks(this.mmU);
        e.mA().removeCallbacks(this.mmV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHK() {
        dul();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.mkv = false;
        if (this.mlS != null) {
            this.mlS.wo(false);
        }
    }

    private void duk() {
        if (this.mky == null) {
            this.mky = ObjectAnimator.ofFloat(this.mkd, "alpha", 0.0f, 1.0f);
            this.mky.setDuration(200L);
        }
        this.mky.start();
    }

    private void dul() {
        if (this.mkz == null) {
            this.mkz = ObjectAnimator.ofFloat(this.mkd, "alpha", 1.0f, 0.0f);
            this.mkz.setDuration(200L);
        }
        this.mkz.start();
    }

    public void onDestroy() {
        dvr();
        xp(false);
    }

    public boolean isVertical() {
        return this.amB;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mlS = videoPbFragment;
    }

    public void dT(View view) {
        this.mRootView = view;
    }

    public void dU(View view) {
        this.mkd = view;
    }

    public boolean dun() {
        return this.mkv;
    }

    public void wo(boolean z) {
        this.mkv = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvs() {
        if (this.mJY != null) {
            o dAh = this.mJY.dAh();
            dAh.mLocate = "pb";
            h.a(dAh.mIj, "", "2", dAh, this.gzX.getPcdnState());
        }
    }
}
