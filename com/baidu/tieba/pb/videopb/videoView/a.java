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
    private int lJi;
    private String lJj;
    private View mRootView;
    private int maO;
    private View mba;
    private boolean mbr;
    private boolean mbs;
    private Runnable mbu;
    private ObjectAnimator mbv;
    private ObjectAnimator mbw;
    private VideoPbFragment mcQ;
    private final int mdC;
    private final int mdD;
    private final int mdE;
    private final int mdF;
    private final int mdG;
    private final int mdH;
    private PbVideoFullscreenAttentionLayout mdI;
    private PbNextVideoLayout mdJ;
    private ImageView mdK;
    private ImageView mdL;
    private int mdM;
    private boolean mdN;
    private ObjectAnimator mdO;
    private VideoPbViewModel mdP;
    private Runnable mdQ;
    private Runnable mdR;
    private Runnable mdS;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mdC = 16384;
        this.mdD = 32768;
        this.mdE = 65536;
        this.mdF = 131072;
        this.mdG = 5000;
        this.mdH = 1500;
        this.mdM = -1;
        this.lJi = 0;
        this.mdQ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mAI.setVisibility(8);
            }
        };
        this.mdR = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mdI.dtg()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.amL ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.mdN = true;
                    a.this.mdO.setFloatValues(-l.getDimens(context2, i));
                    a.this.mdO.removeAllListeners();
                    a.this.mdO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dte();
                            e.mB().postDelayed(a.this.mdS, 5000L);
                        }
                    });
                    a.this.mdO.start();
                }
            }
        };
        this.mdS = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.mdO.setFloatValues(l.getDimens(a.this.mContext, a.this.amL ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.mdO.removeAllListeners();
                a.this.mdO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mdI.setVisibility(8);
                    }
                });
                a.this.mdO.start();
            }
        };
        this.mbu = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mbs && (a.this.mContext instanceof Activity)) {
                    a.this.aHr();
                }
            }
        };
        dsZ();
        if (context instanceof PbActivity) {
            this.mdP = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            this.mbr = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        wX(true);
        this.mAQ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mdI = (PbVideoFullscreenAttentionLayout) this.mAL.findViewById(R.id.video_fullscreen_attention);
        this.mdJ = (PbNextVideoLayout) this.mAL.findViewById(R.id.video_next_layout);
        this.mdK = (ImageView) this.mAL.findViewById(R.id.video_pre);
        this.mdL = (ImageView) this.mAL.findViewById(R.id.video_next);
        SvgManager.bsx().a(this.mdK, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.bsx().a(this.mdL, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.amC.bFU();
        this.amC.setDrawCorner(false);
        this.mdI.setOnClickEvent(this);
        this.mdK.setOnClickListener(this);
        this.mdL.setOnClickListener(this);
        this.mdJ.setOnClickListener(this);
        this.maO = l.getEquipmentWidth(this.mContext) / 10;
        this.mAF.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gxn.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void wf(boolean z) {
        this.mdJ.setIsCountDownValid(z);
    }

    public void aV(bz bzVar) {
        if (bzVar == null || bzVar.bnO() == null || at.isEmpty(bzVar.bnO().video_url)) {
            if (this.mAw == this.mAp || this.mAw == this.mAq) {
                this.mAw &= -65537;
                Gf(this.mAw);
            }
            this.mAp &= -65537;
            this.mAq &= -65537;
            return;
        }
        if (this.mAw == this.mAp || this.mAw == this.mAq) {
            this.mAw |= 65536;
            Gf(this.mAw);
        }
        this.mAp |= 65536;
        this.mAq |= 65536;
    }

    public void aW(bz bzVar) {
        if (bzVar == null || bzVar.bnO() == null || at.isEmpty(bzVar.bnO().video_url)) {
            if (this.mAw == this.mAp || this.mAw == this.mAq || this.mAw == this.mAs) {
                this.mAw &= -32769;
                this.mAw &= -131073;
                Gf(this.mAw);
            }
            this.mAp &= -32769;
            this.mAq &= -32769;
            this.mAs &= -131073;
            return;
        }
        if (this.mAw == this.mAp || this.mAw == this.mAq) {
            this.mAw |= 32768;
            Gf(this.mAw);
        }
        if (this.mAw == this.mAs) {
            this.mAw |= 131072;
            Gf(this.mAw);
        }
        this.mAp |= 32768;
        this.mAq |= 32768;
        this.mAs |= 131072;
        this.mdJ.setDate(bzVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        if (bzVar != null) {
            this.baijiahaoData = bzVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.amM = bzVar.getTid();
            oVar.fKR = Long.toString(bzVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bzVar.isBjh()) {
                    this.lJi = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lJi == 0) {
                        this.lJi = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lJj = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lJj)) {
                        oVar.eLs = this.lJj;
                    }
                    oVar.myZ = Integer.toString(this.lJi);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.myZ = this.source;
                }
            }
            if (bzVar.bnO() != null) {
                oVar.mzc = bzVar.bnO().video_md5;
                oVar.mze = String.valueOf(bzVar.bnO().is_vertical);
            }
            b(oVar);
            this.mdN = false;
            if (com.baidu.tbadk.a.d.biO()) {
                this.mdJ.setIsCountDownValid(false);
            } else {
                this.mdJ.setIsCountDownValid(true);
            }
            if (this.lDY && bzVar.bnO() != null) {
                if (this.amL != (bzVar.bnO().is_vertical.intValue() == 1)) {
                    dyB();
                }
            }
            super.setData(bzVar);
            wX(!this.amL);
            if (bzVar.bnx() != null) {
                bzVar.bnx().setIsLike(bzVar.bnx().hadConcerned());
            }
            this.mdI.setData(bzVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsX() {
        super.dsX();
        if (this.lDY) {
            dtb();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mdI.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lDY || motionEvent.getX() > ((float) this.maO);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dsY() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsZ() {
        this.mAm &= -33;
        this.mAn &= -33;
        this.mAo &= -33;
        this.mAp &= -33;
        this.mAq &= -33;
        this.mAr &= -33;
        this.mAs &= -33;
        this.mAt &= -33;
        this.mAu &= -33;
        this.mAm |= 1024;
        this.mAn |= 1024;
        this.mAo &= -1025;
        this.mAp |= 1024;
        this.mAq |= 1024;
        this.mAr |= 1024;
        this.mAs |= 1024;
        this.mAt |= 1024;
        this.mAu &= -1025;
        this.mAn |= 16384;
        this.mAr |= 16384;
        this.mAs &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dta() {
        int i = 0;
        this.mAE.au(this.amL, this.lDY);
        this.mAF.au(this.amL, this.lDY);
        if (this.mAD instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mAD).au(this.amL, this.lDY);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mAC.getLayoutParams();
        int dimens = (this.lDY && this.amL) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lDY && !this.amL) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mdK.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mdL.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lDY || this.amL) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mdJ.au(this.amL, this.lDY);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gf(int i) {
        if (i != this.mAq && i != this.mAr && i != this.mAp && i != this.mAn) {
            dte();
            if (this.mdI != null) {
                this.mdI.setVisibility(8);
            }
        }
        if (this.mAw != this.mAu && i == this.mAu) {
            e.mB().removeCallbacks(this.mdQ);
            if ((this.mAw & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mAw & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mAu = i;
        }
        super.Gf(i);
        if (!this.lDY) {
            this.mAG.setVisibility(8);
            this.mAH.setVisibility(8);
            if (this.mdP != null) {
                this.mdP.wb((i & 1024) > 0);
            }
        }
        if (this.mdP != null) {
            this.mdP.wb((i & 128) > 0);
        }
        if (this.mAD instanceof PbVideoMediaController) {
            this.mAD.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mAD).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mdK != null) {
            this.mdK.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mdL != null) {
            this.mdL.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mdJ != null) {
            boolean z = (131072 & i) > 0;
            this.mdJ.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Ig("c13600"));
            }
        }
        if (!this.lDY && !this.mbr && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.mbs) {
                    if (this.mcQ == null || !this.mcQ.dsb()) {
                        drY();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.mbs = true;
                    e.mB().removeCallbacks(this.mbu);
                    e.mB().postDelayed(this.mbu, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.mbs || (this.mcQ != null && this.mcQ.dsb())) {
                aHr();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wg(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lDY);
        }
        super.wg(z);
        dte();
        if (this.lDY) {
            dtb();
        } else {
            this.mdI.setVisibility(8);
        }
    }

    private void dtb() {
        if (!this.mdN && !this.mdI.dtg()) {
            this.mdI.setTranslationX(0.0f);
            this.mdI.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mdI.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.amL ? R.dimen.tbds248 : R.dimen.tbds428);
            this.mdO = ObjectAnimator.ofFloat(this.mdI, "translationX", 0.0f);
            this.mdO.setDuration(500);
            dte();
            e.mB().postDelayed(this.mdR, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dtc() {
        if (this.mAw == this.mAu) {
            return false;
        }
        this.mAI.setVisibility(0);
        this.mAI.c(this.mContext, true, 10);
        e.mB().removeCallbacks(this.mdQ);
        e.mB().postDelayed(this.mdQ, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dtd() {
        if (this.mAw == this.mAu) {
            return false;
        }
        this.mAI.setVisibility(0);
        this.mAI.c(this.mContext, false, 10);
        e.mB().removeCallbacks(this.mdQ);
        e.mB().postDelayed(this.mdQ, 1500L);
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
                dte();
                e.mB().post(this.mdS);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mdP != null) {
                    this.mdP.wc(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mdP != null) {
                    this.mdP.dsr();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mAs &= -131073;
                this.mAw &= -131073;
                this.mdJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sc(boolean z) {
        dte();
        this.mdI.setVisibility(8);
        if (!this.mbr) {
            aHr();
        }
        if (z) {
            this.mdM = this.mAw;
            if (this.mAw == this.mAq || ((this.mAw == this.mAr && !this.gxn.isPlaying()) || this.mAw == this.mAs)) {
                this.mdM |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mdM == -1) {
            startPlay();
            return true;
        } else if (this.mdM == this.mAn || this.mdM == this.mAp || this.mdM == this.mAo) {
            startPlay();
            return true;
        } else {
            this.mAD.setCurrentDuration(n.dxY().PM(this.mVideoUrl), false);
            Gf(this.mdM);
            return true;
        }
    }

    private aq Ig(String str) {
        aq dW = new aq(str).dW("tid", this.amM).w("fid", this.mFid).dW("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dW.dW("obj_param4", this.baijiahaoData.oriUgcNid);
            dW.dW("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dW.an("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dW.an("obj_param5", 3);
            }
        } else {
            dW.an("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dkd() != null) {
            dW.dW("ab_tag", ((PbActivity) this.mContext).dkd().dna()).dW("obj_id", ((PbActivity) this.mContext).dkd().dnb()).dW("obj_source", ((PbActivity) this.mContext).dkd().dmZ());
        }
        return dW;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Gg(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Ig("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Ig("c13601").an("obj_type", this.mdJ.mdz ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dte() {
        e.mB().removeCallbacks(this.mdR);
        e.mB().removeCallbacks(this.mdS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHr() {
        drZ();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.mbs = false;
        if (this.mcQ != null) {
            this.mcQ.vX(false);
        }
    }

    private void drY() {
        if (this.mbv == null) {
            this.mbv = ObjectAnimator.ofFloat(this.mba, "alpha", 0.0f, 1.0f);
            this.mbv.setDuration(200L);
        }
        this.mbv.start();
    }

    private void drZ() {
        if (this.mbw == null) {
            this.mbw = ObjectAnimator.ofFloat(this.mba, "alpha", 1.0f, 0.0f);
            this.mbw.setDuration(200L);
        }
        this.mbw.start();
    }

    public void onDestroy() {
        dte();
        wX(false);
    }

    public boolean isVertical() {
        return this.amL;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mcQ = videoPbFragment;
    }

    public void dV(View view) {
        this.mRootView = view;
    }

    public void dW(View view) {
        this.mba = view;
    }

    public boolean dsb() {
        return this.mbs;
    }

    public void vX(boolean z) {
        this.mbs = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dtf() {
        if (this.mAO != null) {
            o dxZ = this.mAO.dxZ();
            dxZ.mLocate = "pb";
            h.a(dxZ.mzc, "", "2", dxZ, this.gxn.getPcdnState());
        }
    }
}
