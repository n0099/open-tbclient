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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private int lNM;
    private String lNN;
    private View mRootView;
    private View mfF;
    private boolean mfW;
    private boolean mfX;
    private Runnable mfZ;
    private int mft;
    private ObjectAnimator mga;
    private ObjectAnimator mgb;
    private VideoPbFragment mhv;
    private final int mii;
    private final int mij;
    private final int mik;
    private final int mil;
    private final int mim;
    private final int mio;
    private PbVideoFullscreenAttentionLayout mip;
    private PbNextVideoLayout miq;
    private ImageView mir;
    private ImageView mis;
    private int mit;
    private boolean miu;
    private ObjectAnimator miv;
    private VideoPbViewModel miw;
    private Runnable mix;
    private Runnable miy;
    private Runnable miz;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mii = 16384;
        this.mij = 32768;
        this.mik = 65536;
        this.mil = 131072;
        this.mim = 5000;
        this.mio = 1500;
        this.mit = -1;
        this.lNM = 0;
        this.mix = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mFr.setVisibility(8);
            }
        };
        this.miy = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mip.dwY()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.anC ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.miu = true;
                    a.this.miv.setFloatValues(-l.getDimens(context2, i));
                    a.this.miv.removeAllListeners();
                    a.this.miv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dwW();
                            e.mB().postDelayed(a.this.miz, 5000L);
                        }
                    });
                    a.this.miv.start();
                }
            }
        };
        this.miz = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.miv.setFloatValues(l.getDimens(a.this.mContext, a.this.anC ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.miv.removeAllListeners();
                a.this.miv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mip.setVisibility(8);
                    }
                });
                a.this.miv.start();
            }
        };
        this.mfZ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mfX && (a.this.mContext instanceof Activity)) {
                    a.this.aLl();
                }
            }
        };
        dwR();
        if (context instanceof PbActivity) {
            this.miw = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            this.mfW = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xb(true);
        this.mFz = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mip = (PbVideoFullscreenAttentionLayout) this.mFu.findViewById(R.id.video_fullscreen_attention);
        this.miq = (PbNextVideoLayout) this.mFu.findViewById(R.id.video_next_layout);
        this.mir = (ImageView) this.mFu.findViewById(R.id.video_pre);
        this.mis = (ImageView) this.mFu.findViewById(R.id.video_next);
        SvgManager.bwr().a(this.mir, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bwr().a(this.mis, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.ant.bJM();
        this.ant.setDrawCorner(false);
        this.mip.setOnClickEvent(this);
        this.mir.setOnClickListener(this);
        this.mis.setOnClickListener(this);
        this.miq.setOnClickListener(this);
        this.mft = l.getEquipmentWidth(this.mContext) / 10;
        this.mFo.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gBU.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void wj(boolean z) {
        this.miq.setIsCountDownValid(z);
    }

    public void aV(bz bzVar) {
        if (bzVar == null || bzVar.brI() == null || at.isEmpty(bzVar.brI().video_url)) {
            if (this.mFf == this.mEY || this.mFf == this.mEZ) {
                this.mFf &= -65537;
                HL(this.mFf);
            }
            this.mEY &= -65537;
            this.mEZ &= -65537;
            return;
        }
        if (this.mFf == this.mEY || this.mFf == this.mEZ) {
            this.mFf |= 65536;
            HL(this.mFf);
        }
        this.mEY |= 65536;
        this.mEZ |= 65536;
    }

    public void aW(bz bzVar) {
        if (bzVar == null || bzVar.brI() == null || at.isEmpty(bzVar.brI().video_url)) {
            if (this.mFf == this.mEY || this.mFf == this.mEZ || this.mFf == this.mFb) {
                this.mFf &= -32769;
                this.mFf &= -131073;
                HL(this.mFf);
            }
            this.mEY &= -32769;
            this.mEZ &= -32769;
            this.mFb &= -131073;
            return;
        }
        if (this.mFf == this.mEY || this.mFf == this.mEZ) {
            this.mFf |= 32768;
            HL(this.mFf);
        }
        if (this.mFf == this.mFb) {
            this.mFf |= 131072;
            HL(this.mFf);
        }
        this.mEY |= 32768;
        this.mEZ |= 32768;
        this.mFb |= 131072;
        this.miq.setDate(bzVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        if (bzVar != null) {
            this.baijiahaoData = bzVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.anD = bzVar.getTid();
            oVar.fPy = Long.toString(bzVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bzVar.isBjh()) {
                    this.lNM = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lNM == 0) {
                        this.lNM = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lNN = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lNN)) {
                        oVar.eQd = this.lNN;
                    }
                    oVar.mDI = Integer.toString(this.lNM);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mDI = this.source;
                }
            }
            if (bzVar.brI() != null) {
                oVar.mDL = bzVar.brI().video_md5;
                oVar.mDN = String.valueOf(bzVar.brI().is_vertical);
            }
            b(oVar);
            this.miu = false;
            if (com.baidu.tbadk.a.d.bmI()) {
                this.miq.setIsCountDownValid(false);
            } else {
                this.miq.setIsCountDownValid(true);
            }
            if (this.lID && bzVar.brI() != null) {
                if (this.anC != (bzVar.brI().is_vertical.intValue() == 1)) {
                    dCt();
                }
            }
            super.setData(bzVar);
            xb(!this.anC);
            if (bzVar.brr() != null) {
                bzVar.brr().setIsLike(bzVar.brr().hadConcerned());
            }
            this.mip.setData(bzVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwP() {
        super.dwP();
        if (this.lID) {
            dwT();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mip.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lID || motionEvent.getX() > ((float) this.mft);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dwQ() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwR() {
        this.mEV &= -33;
        this.mEW &= -33;
        this.mEX &= -33;
        this.mEY &= -33;
        this.mEZ &= -33;
        this.mFa &= -33;
        this.mFb &= -33;
        this.mFc &= -33;
        this.mFd &= -33;
        this.mEV |= 1024;
        this.mEW |= 1024;
        this.mEX &= -1025;
        this.mEY |= 1024;
        this.mEZ |= 1024;
        this.mFa |= 1024;
        this.mFb |= 1024;
        this.mFc |= 1024;
        this.mFd &= -1025;
        this.mEW |= 16384;
        this.mFa |= 16384;
        this.mFb &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwS() {
        int i = 0;
        this.mFn.au(this.anC, this.lID);
        this.mFo.au(this.anC, this.lID);
        if (this.mFm instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mFm).au(this.anC, this.lID);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFl.getLayoutParams();
        int dimens = (this.lID && this.anC) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lID && !this.anC) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mir.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mis.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lID || this.anC) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.miq.au(this.anC, this.lID);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HL(int i) {
        if (i != this.mEZ && i != this.mFa && i != this.mEY && i != this.mEW) {
            dwW();
            if (this.mip != null) {
                this.mip.setVisibility(8);
            }
        }
        if (this.mFf != this.mFd && i == this.mFd) {
            e.mB().removeCallbacks(this.mix);
            if ((this.mFf & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mFf & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mFd = i;
        }
        super.HL(i);
        if (!this.lID) {
            this.mFp.setVisibility(8);
            this.mFq.setVisibility(8);
            if (this.miw != null) {
                this.miw.wf((i & 1024) > 0);
            }
        }
        if (this.miw != null) {
            this.miw.wf((i & 128) > 0);
        }
        if (this.mFm instanceof PbVideoMediaController) {
            this.mFm.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mFm).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mir != null) {
            this.mir.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mis != null) {
            this.mis.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.miq != null) {
            boolean z = (131072 & i) > 0;
            this.miq.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Jr("c13600"));
            }
        }
        if (!this.lID && !this.mfW && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.mfX) {
                    if (this.mhv == null || !this.mhv.dvT()) {
                        dvQ();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.mfX = true;
                    e.mB().removeCallbacks(this.mfZ);
                    e.mB().postDelayed(this.mfZ, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.mfX || (this.mhv != null && this.mhv.dvT())) {
                aLl();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wk(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lID);
        }
        super.wk(z);
        dwW();
        if (this.lID) {
            dwT();
        } else {
            this.mip.setVisibility(8);
        }
    }

    private void dwT() {
        if (!this.miu && !this.mip.dwY()) {
            this.mip.setTranslationX(0.0f);
            this.mip.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mip.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.anC ? R.dimen.tbds248 : R.dimen.tbds428);
            this.miv = ObjectAnimator.ofFloat(this.mip, "translationX", 0.0f);
            this.miv.setDuration(500);
            dwW();
            e.mB().postDelayed(this.miy, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dwU() {
        if (this.mFf == this.mFd) {
            return false;
        }
        this.mFr.setVisibility(0);
        this.mFr.c(this.mContext, true, 10);
        e.mB().removeCallbacks(this.mix);
        e.mB().postDelayed(this.mix, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dwV() {
        if (this.mFf == this.mFd) {
            return false;
        }
        this.mFr.setVisibility(0);
        this.mFr.c(this.mContext, false, 10);
        e.mB().removeCallbacks(this.mix);
        e.mB().postDelayed(this.mix, 1500L);
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
                dwW();
                e.mB().post(this.miz);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.miw != null) {
                    this.miw.wg(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.miw != null) {
                    this.miw.dwj();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mFb &= -131073;
                this.mFf &= -131073;
                this.miq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sg(boolean z) {
        dwW();
        this.mip.setVisibility(8);
        if (!this.mfW) {
            aLl();
        }
        if (z) {
            this.mit = this.mFf;
            if (this.mFf == this.mEZ || ((this.mFf == this.mFa && !this.gBU.isPlaying()) || this.mFf == this.mFb)) {
                this.mit |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mit == -1) {
            startPlay();
            return true;
        } else if (this.mit == this.mEW || this.mit == this.mEY || this.mit == this.mEX) {
            startPlay();
            return true;
        } else {
            this.mFm.setCurrentDuration(n.dBQ().QT(this.mVideoUrl), false);
            HL(this.mit);
            return true;
        }
    }

    private aq Jr(String str) {
        aq dX = new aq(str).dX("tid", this.anD).w("fid", this.mFid).dX("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dX.dX("obj_param4", this.baijiahaoData.oriUgcNid);
            dX.dX("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dX.an("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dX.an("obj_param5", 3);
            }
        } else {
            dX.an("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dnW() != null) {
            dX.dX("ab_tag", ((PbActivity) this.mContext).dnW().dqT()).dX("obj_id", ((PbActivity) this.mContext).dnW().dqU()).dX("obj_source", ((PbActivity) this.mContext).dnW().dqS());
        }
        return dX;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void HM(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Jr("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Jr("c13601").an("obj_type", this.miq.mif ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwW() {
        e.mB().removeCallbacks(this.miy);
        e.mB().removeCallbacks(this.miz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLl() {
        dvR();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.mfX = false;
        if (this.mhv != null) {
            this.mhv.wb(false);
        }
    }

    private void dvQ() {
        if (this.mga == null) {
            this.mga = ObjectAnimator.ofFloat(this.mfF, "alpha", 0.0f, 1.0f);
            this.mga.setDuration(200L);
        }
        this.mga.start();
    }

    private void dvR() {
        if (this.mgb == null) {
            this.mgb = ObjectAnimator.ofFloat(this.mfF, "alpha", 1.0f, 0.0f);
            this.mgb.setDuration(200L);
        }
        this.mgb.start();
    }

    public void onDestroy() {
        dwW();
        xb(false);
    }

    public boolean isVertical() {
        return this.anC;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mhv = videoPbFragment;
    }

    public void dV(View view) {
        this.mRootView = view;
    }

    public void dW(View view) {
        this.mfF = view;
    }

    public boolean dvT() {
        return this.mfX;
    }

    public void wb(boolean z) {
        this.mfX = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwX() {
        if (this.mFx != null) {
            o dBR = this.mFx.dBR();
            dBR.mLocate = "pb";
            h.a(dBR.mDL, "", "2", dBR, this.gBU.getPcdnState());
        }
    }
}
