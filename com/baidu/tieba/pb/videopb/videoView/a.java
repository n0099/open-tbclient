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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private int lIw;
    private String lIx;
    private View mRootView;
    private boolean maJ;
    private boolean maK;
    private Runnable maM;
    private ObjectAnimator maN;
    private ObjectAnimator maO;
    private int mae;
    private View mar;
    private final int mcU;
    private final int mcV;
    private final int mcW;
    private final int mcX;
    private final int mcY;
    private final int mcZ;
    private VideoPbFragment mci;
    private PbVideoFullscreenAttentionLayout mda;
    private PbNextVideoLayout mdb;
    private ImageView mdc;
    private ImageView mdd;
    private int mde;
    private boolean mdf;
    private ObjectAnimator mdg;
    private e mdh;
    private Runnable mdi;
    private Runnable mdj;
    private Runnable mdk;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mcU = 16384;
        this.mcV = 32768;
        this.mcW = 65536;
        this.mcX = 131072;
        this.mcY = 5000;
        this.mcZ = 1500;
        this.mde = -1;
        this.lIw = 0;
        this.mdi = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mzZ.setVisibility(8);
            }
        };
        this.mdj = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mda.dxh()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.amX ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.mdf = true;
                    a.this.mdg.setFloatValues(-l.getDimens(context2, i));
                    a.this.mdg.removeAllListeners();
                    a.this.mdg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dxf();
                            com.baidu.adp.lib.f.e.mY().postDelayed(a.this.mdk, 5000L);
                        }
                    });
                    a.this.mdg.start();
                }
            }
        };
        this.mdk = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.mdg.setFloatValues(l.getDimens(a.this.mContext, a.this.amX ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.mdg.removeAllListeners();
                a.this.mdg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mda.setVisibility(8);
                    }
                });
                a.this.mdg.start();
            }
        };
        this.maM = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.maK && (a.this.mContext instanceof Activity)) {
                    a.this.aJr();
                }
            }
        };
        dxa();
        if (context instanceof PbActivity) {
            this.mdh = (e) y.b((PbActivity) context).l(e.class);
            this.maJ = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xa(true);
        this.mAh = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mda = (PbVideoFullscreenAttentionLayout) this.mAc.findViewById(R.id.video_fullscreen_attention);
        this.mdb = (PbNextVideoLayout) this.mAc.findViewById(R.id.video_next_layout);
        this.mdc = (ImageView) this.mAc.findViewById(R.id.video_pre);
        this.mdd = (ImageView) this.mAc.findViewById(R.id.video_next);
        SvgManager.btW().a(this.mdc, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.btW().a(this.mdd, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.amP.bHt();
        this.amP.setDrawCorner(false);
        this.mda.setOnClickEvent(this);
        this.mdc.setOnClickListener(this);
        this.mdd.setOnClickListener(this);
        this.mdb.setOnClickListener(this);
        this.mae = l.getEquipmentWidth(this.mContext) / 10;
        this.mzW.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gqT.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void wi(boolean z) {
        this.mdb.setIsCountDownValid(z);
    }

    public void aU(by byVar) {
        if (byVar == null || byVar.bph() == null || au.isEmpty(byVar.bph().video_url)) {
            if (this.mzM == this.mzF || this.mzM == this.mzG) {
                this.mzM &= -65537;
                HS(this.mzM);
            }
            this.mzF &= -65537;
            this.mzG &= -65537;
            return;
        }
        if (this.mzM == this.mzF || this.mzM == this.mzG) {
            this.mzM |= 65536;
            HS(this.mzM);
        }
        this.mzF |= 65536;
        this.mzG |= 65536;
    }

    public void aV(by byVar) {
        if (byVar == null || byVar.bph() == null || au.isEmpty(byVar.bph().video_url)) {
            if (this.mzM == this.mzF || this.mzM == this.mzG || this.mzM == this.mzI) {
                this.mzM &= -32769;
                this.mzM &= -131073;
                HS(this.mzM);
            }
            this.mzF &= -32769;
            this.mzG &= -32769;
            this.mzI &= -131073;
            return;
        }
        if (this.mzM == this.mzF || this.mzM == this.mzG) {
            this.mzM |= 32768;
            HS(this.mzM);
        }
        if (this.mzM == this.mzI) {
            this.mzM |= 131072;
            HS(this.mzM);
        }
        this.mzF |= 32768;
        this.mzG |= 32768;
        this.mzI |= 131072;
        this.mdb.setDate(byVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        if (byVar != null) {
            this.baijiahaoData = byVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.amY = byVar.getTid();
            oVar.fFV = Long.toString(byVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (byVar.isBjh()) {
                    this.lIw = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lIw == 0) {
                        this.lIw = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lIx = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lIx)) {
                        oVar.eGn = this.lIx;
                    }
                    oVar.myq = Integer.toString(this.lIw);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.myq = this.source;
                }
            }
            if (byVar.bph() != null) {
                oVar.myt = byVar.bph().video_md5;
                oVar.myv = String.valueOf(byVar.bph().is_vertical);
            }
            b(oVar);
            this.mdf = false;
            if (com.baidu.tbadk.a.d.bkt()) {
                this.mdb.setIsCountDownValid(false);
            } else {
                this.mdb.setIsCountDownValid(true);
            }
            if (this.lDw && byVar.bph() != null) {
                if (this.amX != (byVar.bph().is_vertical.intValue() == 1)) {
                    dCC();
                }
            }
            super.setData(byVar);
            xa(!this.amX);
            if (byVar.boP() != null) {
                byVar.boP().setIsLike(byVar.boP().hadConcerned());
            }
            this.mda.setData(byVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwY() {
        super.dwY();
        if (this.lDw) {
            dxc();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mda.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lDw || motionEvent.getX() > ((float) this.mae);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dwZ() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxa() {
        this.mzC &= -33;
        this.mzD &= -33;
        this.mzE &= -33;
        this.mzF &= -33;
        this.mzG &= -33;
        this.mzH &= -33;
        this.mzI &= -33;
        this.mzJ &= -33;
        this.mzK &= -33;
        this.mzC |= 1024;
        this.mzD |= 1024;
        this.mzE &= -1025;
        this.mzF |= 1024;
        this.mzG |= 1024;
        this.mzH |= 1024;
        this.mzI |= 1024;
        this.mzJ |= 1024;
        this.mzK &= -1025;
        this.mzD |= 16384;
        this.mzH |= 16384;
        this.mzI &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxb() {
        int i = 0;
        this.mzV.as(this.amX, this.lDw);
        this.mzW.as(this.amX, this.lDw);
        if (this.mzU instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mzU).as(this.amX, this.lDw);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mzT.getLayoutParams();
        int dimens = (this.lDw && this.amX) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lDw && !this.amX) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mdc.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mdd.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lDw || this.amX) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mdb.as(this.amX, this.lDw);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HS(int i) {
        if (i != this.mzG && i != this.mzH && i != this.mzF && i != this.mzD) {
            dxf();
            if (this.mda != null) {
                this.mda.setVisibility(8);
            }
        }
        if (this.mzM != this.mzK && i == this.mzK) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdi);
            if ((this.mzM & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mzM & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mzK = i;
        }
        super.HS(i);
        if (!this.lDw) {
            this.mzX.setVisibility(8);
            this.mzY.setVisibility(8);
            if (this.mdh != null) {
                this.mdh.we((i & 1024) > 0);
            }
        }
        if (this.mdh != null) {
            this.mdh.we((i & 128) > 0);
        }
        if (this.mzU instanceof PbVideoMediaController) {
            this.mzU.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mzU).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mdc != null) {
            this.mdc.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mdd != null) {
            this.mdd.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mdb != null) {
            boolean z = (131072 & i) > 0;
            this.mdb.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Ju("c13600"));
            }
        }
        if (!this.lDw && !this.maJ && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.maK) {
                    if (this.mci == null || !this.mci.dwc()) {
                        dvZ();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.maK = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.maM);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.maM, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.maK || (this.mci != null && this.mci.dwc())) {
                aJr();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wj(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lDw);
        }
        super.wj(z);
        dxf();
        if (this.lDw) {
            dxc();
        } else {
            this.mda.setVisibility(8);
        }
    }

    private void dxc() {
        if (!this.mdf && !this.mda.dxh()) {
            this.mda.setTranslationX(0.0f);
            this.mda.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mda.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.amX ? R.dimen.tbds248 : R.dimen.tbds428);
            this.mdg = ObjectAnimator.ofFloat(this.mda, "translationX", 0.0f);
            this.mdg.setDuration(500);
            dxf();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mdj, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dxd() {
        if (this.mzM == this.mzK) {
            return false;
        }
        this.mzZ.setVisibility(0);
        this.mzZ.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdi);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mdi, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dxe() {
        if (this.mzM == this.mzK) {
            return false;
        }
        this.mzZ.setVisibility(0);
        this.mzZ.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdi);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mdi, 1500L);
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
                dxf();
                com.baidu.adp.lib.f.e.mY().post(this.mdk);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mdh != null) {
                    this.mdh.wf(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ar("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mdh != null) {
                    this.mdh.dws();
                }
                TiebaStatic.log(new ar("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mzI &= -131073;
                this.mzM &= -131073;
                this.mdb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean rJ(boolean z) {
        dxf();
        this.mda.setVisibility(8);
        if (!this.maJ) {
            aJr();
        }
        if (z) {
            this.mde = this.mzM;
            if (this.mzM == this.mzG || ((this.mzM == this.mzH && !this.gqT.isPlaying()) || this.mzM == this.mzI)) {
                this.mde |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mde == -1) {
            startPlay();
            return true;
        } else if (this.mde == this.mzD || this.mde == this.mzF || this.mde == this.mzE) {
            startPlay();
            return true;
        } else {
            this.mzU.setCurrentDuration(n.dBZ().Ro(this.mVideoUrl), false);
            HS(this.mde);
            return true;
        }
    }

    private ar Ju(String str) {
        ar dY = new ar(str).dY("tid", this.amY).w("fid", this.mFid).dY("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dY.dY("obj_param4", this.baijiahaoData.oriUgcNid);
            dY.dY("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dY.al("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dY.al("obj_param5", 3);
            }
        } else {
            dY.al("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dok() != null) {
            dY.dY("ab_tag", ((PbActivity) this.mContext).dok().drf()).dY("obj_id", ((PbActivity) this.mContext).dok().drg()).dY("obj_source", ((PbActivity) this.mContext).dok().dre());
        }
        return dY;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void HT(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ar("c13598"));
            } else {
                TiebaStatic.log(new ar("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Ju("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ar("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ar("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Ju("c13601").al("obj_type", this.mdb.mcR ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxf() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdj);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJr() {
        dwa();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.maK = false;
        if (this.mci != null) {
            this.mci.wa(false);
        }
    }

    private void dvZ() {
        if (this.maN == null) {
            this.maN = ObjectAnimator.ofFloat(this.mar, "alpha", 0.0f, 1.0f);
            this.maN.setDuration(200L);
        }
        this.maN.start();
    }

    private void dwa() {
        if (this.maO == null) {
            this.maO = ObjectAnimator.ofFloat(this.mar, "alpha", 1.0f, 0.0f);
            this.maO.setDuration(200L);
        }
        this.maO.start();
    }

    public void onDestroy() {
        dxf();
        xa(false);
    }

    public boolean caj() {
        return this.amX;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mci = videoPbFragment;
    }

    public void dL(View view) {
        this.mRootView = view;
    }

    public void dM(View view) {
        this.mar = view;
    }

    public boolean dwc() {
        return this.maK;
    }

    public void wa(boolean z) {
        this.maK = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxg() {
        if (this.mAf != null) {
            o dCa = this.mAf.dCa();
            dCa.mLocate = "pb";
            h.a(dCa.myt, "", "2", dCa, this.gqT.getPcdnState());
        }
    }
}
