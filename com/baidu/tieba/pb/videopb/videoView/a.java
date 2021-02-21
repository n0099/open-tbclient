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
    private int lSu;
    private String lSv;
    private View mRootView;
    private boolean mkJ;
    private boolean mkK;
    private Runnable mkM;
    private ObjectAnimator mkN;
    private ObjectAnimator mkO;
    private int mkg;
    private View mks;
    private final int mmU;
    private final int mmV;
    private final int mmW;
    private final int mmX;
    private final int mmY;
    private final int mmZ;
    private VideoPbFragment mmh;
    private PbVideoFullscreenAttentionLayout mna;
    private PbNextVideoLayout mnb;
    private ImageView mnc;
    private ImageView mnd;
    private int mne;
    private boolean mnf;
    private ObjectAnimator mng;
    private VideoPbViewModel mnh;
    private Runnable mni;
    private Runnable mnj;
    private Runnable mnk;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mmU = 16384;
        this.mmV = 32768;
        this.mmW = 65536;
        this.mmX = 131072;
        this.mmY = 5000;
        this.mmZ = 1500;
        this.mne = -1;
        this.lSu = 0;
        this.mni = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mKh.setVisibility(8);
            }
        };
        this.mnj = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mna.dvA()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.amB ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.mnf = true;
                    a.this.mng.setFloatValues(-l.getDimens(context2, i));
                    a.this.mng.removeAllListeners();
                    a.this.mng.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dvy();
                            e.mA().postDelayed(a.this.mnk, 5000L);
                        }
                    });
                    a.this.mng.start();
                }
            }
        };
        this.mnk = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.mng.setFloatValues(l.getDimens(a.this.mContext, a.this.amB ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.mng.removeAllListeners();
                a.this.mng.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mna.setVisibility(8);
                    }
                });
                a.this.mng.start();
            }
        };
        this.mkM = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mkK && (a.this.mContext instanceof Activity)) {
                    a.this.aHK();
                }
            }
        };
        dvt();
        if (context instanceof PbActivity) {
            this.mnh = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            this.mkJ = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xp(true);
        this.mKp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mna = (PbVideoFullscreenAttentionLayout) this.mKk.findViewById(R.id.video_fullscreen_attention);
        this.mnb = (PbNextVideoLayout) this.mKk.findViewById(R.id.video_next_layout);
        this.mnc = (ImageView) this.mKk.findViewById(R.id.video_pre);
        this.mnd = (ImageView) this.mKk.findViewById(R.id.video_next);
        SvgManager.bsR().a(this.mnc, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bsR().a(this.mnd, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.ams.bGo();
        this.ams.setDrawCorner(false);
        this.mna.setOnClickEvent(this);
        this.mnc.setOnClickListener(this);
        this.mnd.setOnClickListener(this);
        this.mnb.setOnClickListener(this);
        this.mkg = l.getEquipmentWidth(this.mContext) / 10;
        this.mKe.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gAl.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void ww(boolean z) {
        this.mnb.setIsCountDownValid(z);
    }

    public void aW(cb cbVar) {
        if (cbVar == null || cbVar.boh() == null || au.isEmpty(cbVar.boh().video_url)) {
            if (this.mViewState == this.mJP || this.mViewState == this.mJQ) {
                this.mViewState &= -65537;
                Gy(this.mViewState);
            }
            this.mJP &= -65537;
            this.mJQ &= -65537;
            return;
        }
        if (this.mViewState == this.mJP || this.mViewState == this.mJQ) {
            this.mViewState |= 65536;
            Gy(this.mViewState);
        }
        this.mJP |= 65536;
        this.mJQ |= 65536;
    }

    public void aX(cb cbVar) {
        if (cbVar == null || cbVar.boh() == null || au.isEmpty(cbVar.boh().video_url)) {
            if (this.mViewState == this.mJP || this.mViewState == this.mJQ || this.mViewState == this.mJS) {
                this.mViewState &= -32769;
                this.mViewState &= -131073;
                Gy(this.mViewState);
            }
            this.mJP &= -32769;
            this.mJQ &= -32769;
            this.mJS &= -131073;
            return;
        }
        if (this.mViewState == this.mJP || this.mViewState == this.mJQ) {
            this.mViewState |= 32768;
            Gy(this.mViewState);
        }
        if (this.mViewState == this.mJS) {
            this.mViewState |= 131072;
            Gy(this.mViewState);
        }
        this.mJP |= 32768;
        this.mJQ |= 32768;
        this.mJS |= 131072;
        this.mnb.setDate(cbVar);
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
                    this.lSu = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lSu == 0) {
                        this.lSu = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lSv = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lSv)) {
                        oVar.eNE = this.lSv;
                    }
                    oVar.mIx = Integer.toString(this.lSu);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mIx = this.source;
                }
            }
            if (cbVar.boh() != null) {
                oVar.mIA = cbVar.boh().video_md5;
                oVar.mIC = String.valueOf(cbVar.boh().is_vertical);
            }
            b(oVar);
            this.mnf = false;
            if (com.baidu.tbadk.a.d.bja()) {
                this.mnb.setIsCountDownValid(false);
            } else {
                this.mnb.setIsCountDownValid(true);
            }
            if (this.lNc && cbVar.boh() != null) {
                if (this.amB != (cbVar.boh().is_vertical.intValue() == 1)) {
                    dAS();
                }
            }
            super.setData(cbVar);
            xp(!this.amB);
            if (cbVar.bnQ() != null) {
                cbVar.bnQ().setIsLike(cbVar.bnQ().hadConcerned());
            }
            this.mna.setData(cbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvr() {
        super.dvr();
        if (this.lNc) {
            dvv();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mna.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lNc || motionEvent.getX() > ((float) this.mkg);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dvs() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvt() {
        this.mJM &= -33;
        this.mJN &= -33;
        this.mJO &= -33;
        this.mJP &= -33;
        this.mJQ &= -33;
        this.mJR &= -33;
        this.mJS &= -33;
        this.mJT &= -33;
        this.mJU &= -33;
        this.mJM |= 1024;
        this.mJN |= 1024;
        this.mJO &= -1025;
        this.mJP |= 1024;
        this.mJQ |= 1024;
        this.mJR |= 1024;
        this.mJS |= 1024;
        this.mJT |= 1024;
        this.mJU &= -1025;
        this.mJN |= 16384;
        this.mJR |= 16384;
        this.mJS &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvu() {
        int i = 0;
        this.mKd.au(this.amB, this.lNc);
        this.mKe.au(this.amB, this.lNc);
        if (this.mKc instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mKc).au(this.amB, this.lNc);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mKb.getLayoutParams();
        int dimens = (this.lNc && this.amB) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lNc && !this.amB) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mnc.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mnd.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lNc || this.amB) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mnb.au(this.amB, this.lNc);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gy(int i) {
        if (i != this.mJQ && i != this.mJR && i != this.mJP && i != this.mJN) {
            dvy();
            if (this.mna != null) {
                this.mna.setVisibility(8);
            }
        }
        if (this.mViewState != this.mJU && i == this.mJU) {
            e.mA().removeCallbacks(this.mni);
            if ((this.mViewState & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mViewState & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mJU = i;
        }
        super.Gy(i);
        if (!this.lNc) {
            this.mKf.setVisibility(8);
            this.mKg.setVisibility(8);
            if (this.mnh != null) {
                this.mnh.ws((i & 1024) > 0);
            }
        }
        if (this.mnh != null) {
            this.mnh.ws((i & 128) > 0);
        }
        if (this.mKc instanceof PbVideoMediaController) {
            this.mKc.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mKc).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mnc != null) {
            this.mnc.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mnd != null) {
            this.mnd.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mnb != null) {
            boolean z = (131072 & i) > 0;
            this.mnb.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(IS("c13600"));
            }
        }
        if (!this.lNc && !this.mkJ && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.mkK) {
                    if (this.mmh == null || !this.mmh.duu()) {
                        dur();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.mkK = true;
                    e.mA().removeCallbacks(this.mkM);
                    e.mA().postDelayed(this.mkM, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.mkK || (this.mmh != null && this.mmh.duu())) {
                aHK();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wx(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lNc);
        }
        super.wx(z);
        dvy();
        if (this.lNc) {
            dvv();
        } else {
            this.mna.setVisibility(8);
        }
    }

    private void dvv() {
        if (!this.mnf && !this.mna.dvA()) {
            this.mna.setTranslationX(0.0f);
            this.mna.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mna.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.amB ? R.dimen.tbds248 : R.dimen.tbds428);
            this.mng = ObjectAnimator.ofFloat(this.mna, "translationX", 0.0f);
            this.mng.setDuration(500);
            dvy();
            e.mA().postDelayed(this.mnj, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dvw() {
        if (this.mViewState == this.mJU) {
            return false;
        }
        this.mKh.setVisibility(0);
        this.mKh.c(this.mContext, true, 10);
        e.mA().removeCallbacks(this.mni);
        e.mA().postDelayed(this.mni, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dvx() {
        if (this.mViewState == this.mJU) {
            return false;
        }
        this.mKh.setVisibility(0);
        this.mKh.c(this.mContext, false, 10);
        e.mA().removeCallbacks(this.mni);
        e.mA().postDelayed(this.mni, 1500L);
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
                dvy();
                e.mA().post(this.mnk);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mnh != null) {
                    this.mnh.wt(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ar("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mnh != null) {
                    this.mnh.duJ();
                }
                TiebaStatic.log(new ar("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mJS &= -131073;
                this.mViewState &= -131073;
                this.mnb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        dvy();
        this.mna.setVisibility(8);
        if (!this.mkJ) {
            aHK();
        }
        if (z) {
            this.mne = this.mViewState;
            if (this.mViewState == this.mJQ || ((this.mViewState == this.mJR && !this.gAl.isPlaying()) || this.mViewState == this.mJS)) {
                this.mne |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mne == -1) {
            startPlay();
            return true;
        } else if (this.mne == this.mJN || this.mne == this.mJP || this.mne == this.mJO) {
            startPlay();
            return true;
        } else {
            this.mKc.setCurrentDuration(n.dAn().QE(this.mVideoUrl), false);
            Gy(this.mne);
            return true;
        }
    }

    private ar IS(String str) {
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dmx() != null) {
            dR.dR("ab_tag", ((PbActivity) this.mContext).dmx().dpw()).dR("obj_id", ((PbActivity) this.mContext).dmx().dpx()).dR("obj_source", ((PbActivity) this.mContext).dmx().dpv());
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
            TiebaStatic.log(IS("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ar("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ar("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(IS("c13601").ap("obj_type", this.mnb.mmR ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvy() {
        e.mA().removeCallbacks(this.mnj);
        e.mA().removeCallbacks(this.mnk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHK() {
        dus();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.mkK = false;
        if (this.mmh != null) {
            this.mmh.wo(false);
        }
    }

    private void dur() {
        if (this.mkN == null) {
            this.mkN = ObjectAnimator.ofFloat(this.mks, "alpha", 0.0f, 1.0f);
            this.mkN.setDuration(200L);
        }
        this.mkN.start();
    }

    private void dus() {
        if (this.mkO == null) {
            this.mkO = ObjectAnimator.ofFloat(this.mks, "alpha", 1.0f, 0.0f);
            this.mkO.setDuration(200L);
        }
        this.mkO.start();
    }

    public void onDestroy() {
        dvy();
        xp(false);
    }

    public boolean isVertical() {
        return this.amB;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mmh = videoPbFragment;
    }

    public void dT(View view) {
        this.mRootView = view;
    }

    public void dU(View view) {
        this.mks = view;
    }

    public boolean duu() {
        return this.mkK;
    }

    public void wo(boolean z) {
        this.mkK = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvz() {
        if (this.mKn != null) {
            o dAo = this.mKn.dAo();
            dAo.mLocate = "pb";
            h.a(dAo.mIA, "", "2", dAo, this.gAl.getPcdnState());
        }
    }
}
