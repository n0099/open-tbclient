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
    private int lNN;
    private String lNO;
    private View mRootView;
    private View mfG;
    private boolean mfX;
    private boolean mfY;
    private int mfu;
    private Runnable mga;
    private ObjectAnimator mgb;
    private ObjectAnimator mgc;
    private VideoPbFragment mhw;
    private Runnable miA;
    private final int mij;
    private final int mik;
    private final int mil;
    private final int mim;
    private final int mio;
    private final int mip;
    private PbVideoFullscreenAttentionLayout miq;
    private PbNextVideoLayout mir;
    private ImageView mis;
    private ImageView mit;
    private int miu;
    private boolean miv;
    private ObjectAnimator miw;
    private VideoPbViewModel mix;
    private Runnable miy;
    private Runnable miz;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mij = 16384;
        this.mik = 32768;
        this.mil = 65536;
        this.mim = 131072;
        this.mio = 5000;
        this.mip = 1500;
        this.miu = -1;
        this.lNN = 0;
        this.miy = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mFs.setVisibility(8);
            }
        };
        this.miz = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.miq.dwX()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.anC ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.miv = true;
                    a.this.miw.setFloatValues(-l.getDimens(context2, i));
                    a.this.miw.removeAllListeners();
                    a.this.miw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dwV();
                            e.mB().postDelayed(a.this.miA, 5000L);
                        }
                    });
                    a.this.miw.start();
                }
            }
        };
        this.miA = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.miw.setFloatValues(l.getDimens(a.this.mContext, a.this.anC ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.miw.removeAllListeners();
                a.this.miw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.miq.setVisibility(8);
                    }
                });
                a.this.miw.start();
            }
        };
        this.mga = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mfY && (a.this.mContext instanceof Activity)) {
                    a.this.aLk();
                }
            }
        };
        dwQ();
        if (context instanceof PbActivity) {
            this.mix = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            this.mfX = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xb(true);
        this.mFA = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.miq = (PbVideoFullscreenAttentionLayout) this.mFv.findViewById(R.id.video_fullscreen_attention);
        this.mir = (PbNextVideoLayout) this.mFv.findViewById(R.id.video_next_layout);
        this.mis = (ImageView) this.mFv.findViewById(R.id.video_pre);
        this.mit = (ImageView) this.mFv.findViewById(R.id.video_next);
        SvgManager.bwq().a(this.mis, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bwq().a(this.mit, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.ant.bJL();
        this.ant.setDrawCorner(false);
        this.miq.setOnClickEvent(this);
        this.mis.setOnClickListener(this);
        this.mit.setOnClickListener(this);
        this.mir.setOnClickListener(this);
        this.mfu = l.getEquipmentWidth(this.mContext) / 10;
        this.mFp.setShareFrom(18);
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
        this.mir.setIsCountDownValid(z);
    }

    public void aV(bz bzVar) {
        if (bzVar == null || bzVar.brH() == null || at.isEmpty(bzVar.brH().video_url)) {
            if (this.mFg == this.mEZ || this.mFg == this.mFa) {
                this.mFg &= -65537;
                HL(this.mFg);
            }
            this.mEZ &= -65537;
            this.mFa &= -65537;
            return;
        }
        if (this.mFg == this.mEZ || this.mFg == this.mFa) {
            this.mFg |= 65536;
            HL(this.mFg);
        }
        this.mEZ |= 65536;
        this.mFa |= 65536;
    }

    public void aW(bz bzVar) {
        if (bzVar == null || bzVar.brH() == null || at.isEmpty(bzVar.brH().video_url)) {
            if (this.mFg == this.mEZ || this.mFg == this.mFa || this.mFg == this.mFc) {
                this.mFg &= -32769;
                this.mFg &= -131073;
                HL(this.mFg);
            }
            this.mEZ &= -32769;
            this.mFa &= -32769;
            this.mFc &= -131073;
            return;
        }
        if (this.mFg == this.mEZ || this.mFg == this.mFa) {
            this.mFg |= 32768;
            HL(this.mFg);
        }
        if (this.mFg == this.mFc) {
            this.mFg |= 131072;
            HL(this.mFg);
        }
        this.mEZ |= 32768;
        this.mFa |= 32768;
        this.mFc |= 131072;
        this.mir.setDate(bzVar);
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
                    this.lNN = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lNN == 0) {
                        this.lNN = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lNO = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lNO)) {
                        oVar.eQd = this.lNO;
                    }
                    oVar.mDJ = Integer.toString(this.lNN);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mDJ = this.source;
                }
            }
            if (bzVar.brH() != null) {
                oVar.mDM = bzVar.brH().video_md5;
                oVar.mDO = String.valueOf(bzVar.brH().is_vertical);
            }
            b(oVar);
            this.miv = false;
            if (com.baidu.tbadk.a.d.bmH()) {
                this.mir.setIsCountDownValid(false);
            } else {
                this.mir.setIsCountDownValid(true);
            }
            if (this.lIE && bzVar.brH() != null) {
                if (this.anC != (bzVar.brH().is_vertical.intValue() == 1)) {
                    dCs();
                }
            }
            super.setData(bzVar);
            xb(!this.anC);
            if (bzVar.brq() != null) {
                bzVar.brq().setIsLike(bzVar.brq().hadConcerned());
            }
            this.miq.setData(bzVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwO() {
        super.dwO();
        if (this.lIE) {
            dwS();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.miq.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lIE || motionEvent.getX() > ((float) this.mfu);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dwP() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwQ() {
        this.mEW &= -33;
        this.mEX &= -33;
        this.mEY &= -33;
        this.mEZ &= -33;
        this.mFa &= -33;
        this.mFb &= -33;
        this.mFc &= -33;
        this.mFd &= -33;
        this.mFe &= -33;
        this.mEW |= 1024;
        this.mEX |= 1024;
        this.mEY &= -1025;
        this.mEZ |= 1024;
        this.mFa |= 1024;
        this.mFb |= 1024;
        this.mFc |= 1024;
        this.mFd |= 1024;
        this.mFe &= -1025;
        this.mEX |= 16384;
        this.mFb |= 16384;
        this.mFc &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwR() {
        int i = 0;
        this.mFo.au(this.anC, this.lIE);
        this.mFp.au(this.anC, this.lIE);
        if (this.mFn instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mFn).au(this.anC, this.lIE);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFm.getLayoutParams();
        int dimens = (this.lIE && this.anC) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lIE && !this.anC) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mis.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mit.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lIE || this.anC) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mir.au(this.anC, this.lIE);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HL(int i) {
        if (i != this.mFa && i != this.mFb && i != this.mEZ && i != this.mEX) {
            dwV();
            if (this.miq != null) {
                this.miq.setVisibility(8);
            }
        }
        if (this.mFg != this.mFe && i == this.mFe) {
            e.mB().removeCallbacks(this.miy);
            if ((this.mFg & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mFg & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mFe = i;
        }
        super.HL(i);
        if (!this.lIE) {
            this.mFq.setVisibility(8);
            this.mFr.setVisibility(8);
            if (this.mix != null) {
                this.mix.wf((i & 1024) > 0);
            }
        }
        if (this.mix != null) {
            this.mix.wf((i & 128) > 0);
        }
        if (this.mFn instanceof PbVideoMediaController) {
            this.mFn.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mFn).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mis != null) {
            this.mis.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mit != null) {
            this.mit.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mir != null) {
            boolean z = (131072 & i) > 0;
            this.mir.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Js("c13600"));
            }
        }
        if (!this.lIE && !this.mfX && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.mfY) {
                    if (this.mhw == null || !this.mhw.dvS()) {
                        dvP();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.mfY = true;
                    e.mB().removeCallbacks(this.mga);
                    e.mB().postDelayed(this.mga, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.mfY || (this.mhw != null && this.mhw.dvS())) {
                aLk();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wk(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lIE);
        }
        super.wk(z);
        dwV();
        if (this.lIE) {
            dwS();
        } else {
            this.miq.setVisibility(8);
        }
    }

    private void dwS() {
        if (!this.miv && !this.miq.dwX()) {
            this.miq.setTranslationX(0.0f);
            this.miq.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.miq.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.anC ? R.dimen.tbds248 : R.dimen.tbds428);
            this.miw = ObjectAnimator.ofFloat(this.miq, "translationX", 0.0f);
            this.miw.setDuration(500);
            dwV();
            e.mB().postDelayed(this.miz, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dwT() {
        if (this.mFg == this.mFe) {
            return false;
        }
        this.mFs.setVisibility(0);
        this.mFs.c(this.mContext, true, 10);
        e.mB().removeCallbacks(this.miy);
        e.mB().postDelayed(this.miy, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dwU() {
        if (this.mFg == this.mFe) {
            return false;
        }
        this.mFs.setVisibility(0);
        this.mFs.c(this.mContext, false, 10);
        e.mB().removeCallbacks(this.miy);
        e.mB().postDelayed(this.miy, 1500L);
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
                dwV();
                e.mB().post(this.miA);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mix != null) {
                    this.mix.wg(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mix != null) {
                    this.mix.dwi();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mFc &= -131073;
                this.mFg &= -131073;
                this.mir.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sg(boolean z) {
        dwV();
        this.miq.setVisibility(8);
        if (!this.mfX) {
            aLk();
        }
        if (z) {
            this.miu = this.mFg;
            if (this.mFg == this.mFa || ((this.mFg == this.mFb && !this.gBU.isPlaying()) || this.mFg == this.mFc)) {
                this.miu |= 1;
            }
            stopPlay();
            return true;
        } else if (this.miu == -1) {
            startPlay();
            return true;
        } else if (this.miu == this.mEX || this.miu == this.mEZ || this.miu == this.mEY) {
            startPlay();
            return true;
        } else {
            this.mFn.setCurrentDuration(n.dBP().QU(this.mVideoUrl), false);
            HL(this.miu);
            return true;
        }
    }

    private aq Js(String str) {
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dnV() != null) {
            dX.dX("ab_tag", ((PbActivity) this.mContext).dnV().dqS()).dX("obj_id", ((PbActivity) this.mContext).dnV().dqT()).dX("obj_source", ((PbActivity) this.mContext).dnV().dqR());
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
            TiebaStatic.log(Js("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Js("c13601").an("obj_type", this.mir.mig ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwV() {
        e.mB().removeCallbacks(this.miz);
        e.mB().removeCallbacks(this.miA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLk() {
        dvQ();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.mfY = false;
        if (this.mhw != null) {
            this.mhw.wb(false);
        }
    }

    private void dvP() {
        if (this.mgb == null) {
            this.mgb = ObjectAnimator.ofFloat(this.mfG, "alpha", 0.0f, 1.0f);
            this.mgb.setDuration(200L);
        }
        this.mgb.start();
    }

    private void dvQ() {
        if (this.mgc == null) {
            this.mgc = ObjectAnimator.ofFloat(this.mfG, "alpha", 1.0f, 0.0f);
            this.mgc.setDuration(200L);
        }
        this.mgc.start();
    }

    public void onDestroy() {
        dwV();
        xb(false);
    }

    public boolean isVertical() {
        return this.anC;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mhw = videoPbFragment;
    }

    public void dV(View view) {
        this.mRootView = view;
    }

    public void dW(View view) {
        this.mfG = view;
    }

    public boolean dvS() {
        return this.mfY;
    }

    public void wb(boolean z) {
        this.mfY = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwW() {
        if (this.mFy != null) {
            o dBQ = this.mFy.dBQ();
            dBQ.mLocate = "pb";
            h.a(dBQ.mDM, "", "2", dBQ, this.gBU.getPcdnState());
        }
    }
}
