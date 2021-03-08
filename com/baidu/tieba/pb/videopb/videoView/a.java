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
    private int lUw;
    private String lUx;
    private View mRootView;
    private boolean mmL;
    private boolean mmM;
    private Runnable mmO;
    private ObjectAnimator mmP;
    private ObjectAnimator mmQ;
    private int mmi;
    private View mmu;
    private final int moX;
    private final int moY;
    private final int moZ;
    private VideoPbFragment moj;
    private final int mpa;
    private final int mpb;
    private final int mpc;
    private PbVideoFullscreenAttentionLayout mpd;
    private PbNextVideoLayout mpe;
    private ImageView mpf;
    private ImageView mpg;
    private int mph;
    private boolean mpi;
    private ObjectAnimator mpj;
    private VideoPbViewModel mpk;
    private Runnable mpl;
    private Runnable mpm;
    private Runnable mpn;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.moX = 16384;
        this.moY = 32768;
        this.moZ = 65536;
        this.mpa = 131072;
        this.mpb = 5000;
        this.mpc = 1500;
        this.mph = -1;
        this.lUw = 0;
        this.mpl = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mMj.setVisibility(8);
            }
        };
        this.mpm = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mpd.dvJ()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.anT ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.mpi = true;
                    a.this.mpj.setFloatValues(-l.getDimens(context2, i));
                    a.this.mpj.removeAllListeners();
                    a.this.mpj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dvH();
                            e.mA().postDelayed(a.this.mpn, 5000L);
                        }
                    });
                    a.this.mpj.start();
                }
            }
        };
        this.mpn = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.mpj.setFloatValues(l.getDimens(a.this.mContext, a.this.anT ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.mpj.removeAllListeners();
                a.this.mpj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mpd.setVisibility(8);
                    }
                });
                a.this.mpj.start();
            }
        };
        this.mmO = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mmM && (a.this.mContext instanceof Activity)) {
                    a.this.aHN();
                }
            }
        };
        dvC();
        if (context instanceof PbActivity) {
            this.mpk = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            this.mmL = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xp(true);
        this.mMr = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mpd = (PbVideoFullscreenAttentionLayout) this.mMm.findViewById(R.id.video_fullscreen_attention);
        this.mpe = (PbNextVideoLayout) this.mMm.findViewById(R.id.video_next_layout);
        this.mpf = (ImageView) this.mMm.findViewById(R.id.video_pre);
        this.mpg = (ImageView) this.mMm.findViewById(R.id.video_next);
        SvgManager.bsU().a(this.mpf, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bsU().a(this.mpg, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.anK.bGs();
        this.anK.setDrawCorner(false);
        this.mpd.setOnClickEvent(this);
        this.mpf.setOnClickListener(this);
        this.mpg.setOnClickListener(this);
        this.mpe.setOnClickListener(this);
        this.mmi = l.getEquipmentWidth(this.mContext) / 10;
        this.mMg.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gBU.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void ww(boolean z) {
        this.mpe.setIsCountDownValid(z);
    }

    public void aW(cb cbVar) {
        if (cbVar == null || cbVar.boj() == null || au.isEmpty(cbVar.boj().video_url)) {
            if (this.mViewState == this.mLR || this.mViewState == this.mLS) {
                this.mViewState &= -65537;
                GB(this.mViewState);
            }
            this.mLR &= -65537;
            this.mLS &= -65537;
            return;
        }
        if (this.mViewState == this.mLR || this.mViewState == this.mLS) {
            this.mViewState |= 65536;
            GB(this.mViewState);
        }
        this.mLR |= 65536;
        this.mLS |= 65536;
    }

    public void aX(cb cbVar) {
        if (cbVar == null || cbVar.boj() == null || au.isEmpty(cbVar.boj().video_url)) {
            if (this.mViewState == this.mLR || this.mViewState == this.mLS || this.mViewState == this.mLU) {
                this.mViewState &= -32769;
                this.mViewState &= -131073;
                GB(this.mViewState);
            }
            this.mLR &= -32769;
            this.mLS &= -32769;
            this.mLU &= -131073;
            return;
        }
        if (this.mViewState == this.mLR || this.mViewState == this.mLS) {
            this.mViewState |= 32768;
            GB(this.mViewState);
        }
        if (this.mViewState == this.mLU) {
            this.mViewState |= 131072;
            GB(this.mViewState);
        }
        this.mLR |= 32768;
        this.mLS |= 32768;
        this.mLU |= 131072;
        this.mpe.setDate(cbVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        if (cbVar != null) {
            this.baijiahaoData = cbVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.anU = cbVar.getTid();
            oVar.fOD = Long.toString(cbVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (cbVar.isBjh()) {
                    this.lUw = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lUw == 0) {
                        this.lUw = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lUx = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lUx)) {
                        oVar.ePf = this.lUx;
                    }
                    oVar.mKB = Integer.toString(this.lUw);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mKB = this.source;
                }
            }
            if (cbVar.boj() != null) {
                oVar.mKE = cbVar.boj().video_md5;
                oVar.mKG = String.valueOf(cbVar.boj().is_vertical);
            }
            b(oVar);
            this.mpi = false;
            if (com.baidu.tbadk.a.d.bjc()) {
                this.mpe.setIsCountDownValid(false);
            } else {
                this.mpe.setIsCountDownValid(true);
            }
            if (this.lPe && cbVar.boj() != null) {
                if (this.anT != (cbVar.boj().is_vertical.intValue() == 1)) {
                    dBa();
                }
            }
            super.setData(cbVar);
            xp(!this.anT);
            if (cbVar.bnS() != null) {
                cbVar.bnS().setIsLike(cbVar.bnS().hadConcerned());
            }
            this.mpd.setData(cbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvA() {
        super.dvA();
        if (this.lPe) {
            dvE();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mpd.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lPe || motionEvent.getX() > ((float) this.mmi);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dvB() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvC() {
        this.mLO &= -33;
        this.mLP &= -33;
        this.mLQ &= -33;
        this.mLR &= -33;
        this.mLS &= -33;
        this.mLT &= -33;
        this.mLU &= -33;
        this.mLV &= -33;
        this.mLW &= -33;
        this.mLO |= 1024;
        this.mLP |= 1024;
        this.mLQ &= -1025;
        this.mLR |= 1024;
        this.mLS |= 1024;
        this.mLT |= 1024;
        this.mLU |= 1024;
        this.mLV |= 1024;
        this.mLW &= -1025;
        this.mLP |= 16384;
        this.mLT |= 16384;
        this.mLU &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvD() {
        int i = 0;
        this.mMf.au(this.anT, this.lPe);
        this.mMg.au(this.anT, this.lPe);
        if (this.mMe instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mMe).au(this.anT, this.lPe);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMd.getLayoutParams();
        int dimens = (this.lPe && this.anT) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lPe && !this.anT) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mpf.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mpg.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lPe || this.anT) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mpe.au(this.anT, this.lPe);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void GB(int i) {
        if (i != this.mLS && i != this.mLT && i != this.mLR && i != this.mLP) {
            dvH();
            if (this.mpd != null) {
                this.mpd.setVisibility(8);
            }
        }
        if (this.mViewState != this.mLW && i == this.mLW) {
            e.mA().removeCallbacks(this.mpl);
            if ((this.mViewState & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mViewState & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mLW = i;
        }
        super.GB(i);
        if (!this.lPe) {
            this.mMh.setVisibility(8);
            this.mMi.setVisibility(8);
            if (this.mpk != null) {
                this.mpk.ws((i & 1024) > 0);
            }
        }
        if (this.mpk != null) {
            this.mpk.ws((i & 128) > 0);
        }
        if (this.mMe instanceof PbVideoMediaController) {
            this.mMe.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mMe).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mpf != null) {
            this.mpf.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mpg != null) {
            this.mpg.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mpe != null) {
            boolean z = (131072 & i) > 0;
            this.mpe.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Jb("c13600"));
            }
        }
        if (!this.lPe && !this.mmL && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.mmM) {
                    if (this.moj == null || !this.moj.duD()) {
                        duA();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.mmM = true;
                    e.mA().removeCallbacks(this.mmO);
                    e.mA().postDelayed(this.mmO, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.mmM || (this.moj != null && this.moj.duD())) {
                aHN();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wx(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lPe);
        }
        super.wx(z);
        dvH();
        if (this.lPe) {
            dvE();
        } else {
            this.mpd.setVisibility(8);
        }
    }

    private void dvE() {
        if (!this.mpi && !this.mpd.dvJ()) {
            this.mpd.setTranslationX(0.0f);
            this.mpd.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mpd.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.anT ? R.dimen.tbds248 : R.dimen.tbds428);
            this.mpj = ObjectAnimator.ofFloat(this.mpd, "translationX", 0.0f);
            this.mpj.setDuration(500);
            dvH();
            e.mA().postDelayed(this.mpm, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dvF() {
        if (this.mViewState == this.mLW) {
            return false;
        }
        this.mMj.setVisibility(0);
        this.mMj.c(this.mContext, true, 10);
        e.mA().removeCallbacks(this.mpl);
        e.mA().postDelayed(this.mpl, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dvG() {
        if (this.mViewState == this.mLW) {
            return false;
        }
        this.mMj.setVisibility(0);
        this.mMj.c(this.mContext, false, 10);
        e.mA().removeCallbacks(this.mpl);
        e.mA().postDelayed(this.mpl, 1500L);
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
                dvH();
                e.mA().post(this.mpn);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mpk != null) {
                    this.mpk.wt(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ar("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mpk != null) {
                    this.mpk.duS();
                }
                TiebaStatic.log(new ar("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mLU &= -131073;
                this.mViewState &= -131073;
                this.mpe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        dvH();
        this.mpd.setVisibility(8);
        if (!this.mmL) {
            aHN();
        }
        if (z) {
            this.mph = this.mViewState;
            if (this.mViewState == this.mLS || ((this.mViewState == this.mLT && !this.gBU.isPlaying()) || this.mViewState == this.mLU)) {
                this.mph |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mph == -1) {
            startPlay();
            return true;
        } else if (this.mph == this.mLP || this.mph == this.mLR || this.mph == this.mLQ) {
            startPlay();
            return true;
        } else {
            this.mMe.setCurrentDuration(n.dAv().QK(this.mVideoUrl), false);
            GB(this.mph);
            return true;
        }
    }

    private ar Jb(String str) {
        ar dR = new ar(str).dR("tid", this.anU).v("fid", this.mFid).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dR.dR("obj_param4", this.baijiahaoData.oriUgcNid);
            dR.dR("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dR.aq("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dR.aq("obj_param5", 3);
            }
        } else {
            dR.aq("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dmG() != null) {
            dR.dR("ab_tag", ((PbActivity) this.mContext).dmG().dpF()).dR("obj_id", ((PbActivity) this.mContext).dmG().dpG()).dR("obj_source", ((PbActivity) this.mContext).dmG().dpE());
        }
        return dR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void GC(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ar("c13598"));
            } else {
                TiebaStatic.log(new ar("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Jb("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ar("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ar("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Jb("c13601").aq("obj_type", this.mpe.moU ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvH() {
        e.mA().removeCallbacks(this.mpm);
        e.mA().removeCallbacks(this.mpn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHN() {
        duB();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.mmM = false;
        if (this.moj != null) {
            this.moj.wo(false);
        }
    }

    private void duA() {
        if (this.mmP == null) {
            this.mmP = ObjectAnimator.ofFloat(this.mmu, "alpha", 0.0f, 1.0f);
            this.mmP.setDuration(200L);
        }
        this.mmP.start();
    }

    private void duB() {
        if (this.mmQ == null) {
            this.mmQ = ObjectAnimator.ofFloat(this.mmu, "alpha", 1.0f, 0.0f);
            this.mmQ.setDuration(200L);
        }
        this.mmQ.start();
    }

    public void onDestroy() {
        dvH();
        xp(false);
    }

    public boolean isVertical() {
        return this.anT;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.moj = videoPbFragment;
    }

    public void dT(View view) {
        this.mRootView = view;
    }

    public void dU(View view) {
        this.mmu = view;
    }

    public boolean duD() {
        return this.mmM;
    }

    public void wo(boolean z) {
        this.mmM = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvI() {
        if (this.mMp != null) {
            o dAw = this.mMp.dAw();
            dAw.mLocate = "pb";
            h.a(dAw.mKE, "", "2", dAw, this.gBU.getPcdnState());
        }
    }
}
