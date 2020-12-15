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
    private int lIy;
    private String lIz;
    private View mRootView;
    private boolean maL;
    private boolean maM;
    private Runnable maO;
    private ObjectAnimator maP;
    private ObjectAnimator maQ;
    private int mag;
    private View mat;
    private final int mcW;
    private final int mcX;
    private final int mcY;
    private final int mcZ;
    private VideoPbFragment mck;
    private final int mda;
    private final int mdb;
    private PbVideoFullscreenAttentionLayout mdc;
    private PbNextVideoLayout mdd;
    private ImageView mde;
    private ImageView mdf;
    private int mdg;
    private boolean mdh;
    private ObjectAnimator mdi;
    private e mdj;
    private Runnable mdk;
    private Runnable mdl;
    private Runnable mdm;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.mcW = 16384;
        this.mcX = 32768;
        this.mcY = 65536;
        this.mcZ = 131072;
        this.mda = 5000;
        this.mdb = 1500;
        this.mdg = -1;
        this.lIy = 0;
        this.mdk = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.mAb.setVisibility(8);
            }
        };
        this.mdl = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mdc.dxi()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.amX ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.mdh = true;
                    a.this.mdi.setFloatValues(-l.getDimens(context2, i));
                    a.this.mdi.removeAllListeners();
                    a.this.mdi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dxg();
                            com.baidu.adp.lib.f.e.mY().postDelayed(a.this.mdm, 5000L);
                        }
                    });
                    a.this.mdi.start();
                }
            }
        };
        this.mdm = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.mdi.setFloatValues(l.getDimens(a.this.mContext, a.this.amX ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.mdi.removeAllListeners();
                a.this.mdi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.mdc.setVisibility(8);
                    }
                });
                a.this.mdi.start();
            }
        };
        this.maO = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.maM && (a.this.mContext instanceof Activity)) {
                    a.this.aJr();
                }
            }
        };
        dxb();
        if (context instanceof PbActivity) {
            this.mdj = (e) y.b((PbActivity) context).l(e.class);
            this.maL = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        xa(true);
        this.mAj = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mdc = (PbVideoFullscreenAttentionLayout) this.mAe.findViewById(R.id.video_fullscreen_attention);
        this.mdd = (PbNextVideoLayout) this.mAe.findViewById(R.id.video_next_layout);
        this.mde = (ImageView) this.mAe.findViewById(R.id.video_pre);
        this.mdf = (ImageView) this.mAe.findViewById(R.id.video_next);
        SvgManager.btW().a(this.mde, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        SvgManager.btW().a(this.mdf, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.amP.bHt();
        this.amP.setDrawCorner(false);
        this.mdc.setOnClickEvent(this);
        this.mde.setOnClickListener(this);
        this.mdf.setOnClickListener(this);
        this.mdd.setOnClickListener(this);
        this.mag = l.getEquipmentWidth(this.mContext) / 10;
        this.mzY.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gqV.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void wi(boolean z) {
        this.mdd.setIsCountDownValid(z);
    }

    public void aU(by byVar) {
        if (byVar == null || byVar.bph() == null || au.isEmpty(byVar.bph().video_url)) {
            if (this.mzO == this.mzH || this.mzO == this.mzI) {
                this.mzO &= -65537;
                HS(this.mzO);
            }
            this.mzH &= -65537;
            this.mzI &= -65537;
            return;
        }
        if (this.mzO == this.mzH || this.mzO == this.mzI) {
            this.mzO |= 65536;
            HS(this.mzO);
        }
        this.mzH |= 65536;
        this.mzI |= 65536;
    }

    public void aV(by byVar) {
        if (byVar == null || byVar.bph() == null || au.isEmpty(byVar.bph().video_url)) {
            if (this.mzO == this.mzH || this.mzO == this.mzI || this.mzO == this.mzK) {
                this.mzO &= -32769;
                this.mzO &= -131073;
                HS(this.mzO);
            }
            this.mzH &= -32769;
            this.mzI &= -32769;
            this.mzK &= -131073;
            return;
        }
        if (this.mzO == this.mzH || this.mzO == this.mzI) {
            this.mzO |= 32768;
            HS(this.mzO);
        }
        if (this.mzO == this.mzK) {
            this.mzO |= 131072;
            HS(this.mzO);
        }
        this.mzH |= 32768;
        this.mzI |= 32768;
        this.mzK |= 131072;
        this.mdd.setDate(byVar);
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
                    this.lIy = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lIy == 0) {
                        this.lIy = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lIz = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lIz)) {
                        oVar.eGn = this.lIz;
                    }
                    oVar.mys = Integer.toString(this.lIy);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.mys = this.source;
                }
            }
            if (byVar.bph() != null) {
                oVar.myv = byVar.bph().video_md5;
                oVar.myx = String.valueOf(byVar.bph().is_vertical);
            }
            b(oVar);
            this.mdh = false;
            if (com.baidu.tbadk.a.d.bkt()) {
                this.mdd.setIsCountDownValid(false);
            } else {
                this.mdd.setIsCountDownValid(true);
            }
            if (this.lDy && byVar.bph() != null) {
                if (this.amX != (byVar.bph().is_vertical.intValue() == 1)) {
                    dCD();
                }
            }
            super.setData(byVar);
            xa(!this.amX);
            if (byVar.boP() != null) {
                byVar.boP().setIsLike(byVar.boP().hadConcerned());
            }
            this.mdc.setData(byVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwZ() {
        super.dwZ();
        if (this.lDy) {
            dxd();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mdc.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lDy || motionEvent.getX() > ((float) this.mag);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dxa() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxb() {
        this.mzE &= -33;
        this.mzF &= -33;
        this.mzG &= -33;
        this.mzH &= -33;
        this.mzI &= -33;
        this.mzJ &= -33;
        this.mzK &= -33;
        this.mzL &= -33;
        this.mzM &= -33;
        this.mzE |= 1024;
        this.mzF |= 1024;
        this.mzG &= -1025;
        this.mzH |= 1024;
        this.mzI |= 1024;
        this.mzJ |= 1024;
        this.mzK |= 1024;
        this.mzL |= 1024;
        this.mzM &= -1025;
        this.mzF |= 16384;
        this.mzJ |= 16384;
        this.mzK &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxc() {
        int i = 0;
        this.mzX.as(this.amX, this.lDy);
        this.mzY.as(this.amX, this.lDy);
        if (this.mzW instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.mzW).as(this.amX, this.lDy);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mzV.getLayoutParams();
        int dimens = (this.lDy && this.amX) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.lDy && !this.amX) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mde.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mdf.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.lDy || this.amX) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.mdd.as(this.amX, this.lDy);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HS(int i) {
        if (i != this.mzI && i != this.mzJ && i != this.mzH && i != this.mzF) {
            dxg();
            if (this.mdc != null) {
                this.mdc.setVisibility(8);
            }
        }
        if (this.mzO != this.mzM && i == this.mzM) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdk);
            if ((this.mzO & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.mzO & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.mzM = i;
        }
        super.HS(i);
        if (!this.lDy) {
            this.mzZ.setVisibility(8);
            this.mAa.setVisibility(8);
            if (this.mdj != null) {
                this.mdj.we((i & 1024) > 0);
            }
        }
        if (this.mdj != null) {
            this.mdj.we((i & 128) > 0);
        }
        if (this.mzW instanceof PbVideoMediaController) {
            this.mzW.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.mzW).setBottomBarShow((i & 16384) > 0);
        }
        if (this.mde != null) {
            this.mde.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.mdf != null) {
            this.mdf.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.mdd != null) {
            boolean z = (131072 & i) > 0;
            this.mdd.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Ju("c13600"));
            }
        }
        if (!this.lDy && !this.maL && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.maM) {
                    if (this.mck == null || !this.mck.dwd()) {
                        dwa();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.maM = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.maO);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.maO, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.maM || (this.mck != null && this.mck.dwd())) {
                aJr();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wj(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lDy);
        }
        super.wj(z);
        dxg();
        if (this.lDy) {
            dxd();
        } else {
            this.mdc.setVisibility(8);
        }
    }

    private void dxd() {
        if (!this.mdh && !this.mdc.dxi()) {
            this.mdc.setTranslationX(0.0f);
            this.mdc.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.mdc.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.amX ? R.dimen.tbds248 : R.dimen.tbds428);
            this.mdi = ObjectAnimator.ofFloat(this.mdc, "translationX", 0.0f);
            this.mdi.setDuration(500);
            dxg();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mdl, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dxe() {
        if (this.mzO == this.mzM) {
            return false;
        }
        this.mAb.setVisibility(0);
        this.mAb.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdk);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mdk, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dxf() {
        if (this.mzO == this.mzM) {
            return false;
        }
        this.mAb.setVisibility(0);
        this.mAb.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdk);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mdk, 1500L);
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
                dxg();
                com.baidu.adp.lib.f.e.mY().post(this.mdm);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.mdj != null) {
                    this.mdj.wf(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ar("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.mdj != null) {
                    this.mdj.dwt();
                }
                TiebaStatic.log(new ar("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.mzK &= -131073;
                this.mzO &= -131073;
                this.mdd.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean rJ(boolean z) {
        dxg();
        this.mdc.setVisibility(8);
        if (!this.maL) {
            aJr();
        }
        if (z) {
            this.mdg = this.mzO;
            if (this.mzO == this.mzI || ((this.mzO == this.mzJ && !this.gqV.isPlaying()) || this.mzO == this.mzK)) {
                this.mdg |= 1;
            }
            stopPlay();
            return true;
        } else if (this.mdg == -1) {
            startPlay();
            return true;
        } else if (this.mdg == this.mzF || this.mdg == this.mzH || this.mdg == this.mzG) {
            startPlay();
            return true;
        } else {
            this.mzW.setCurrentDuration(n.dCa().Ro(this.mVideoUrl), false);
            HS(this.mdg);
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).dol() != null) {
            dY.dY("ab_tag", ((PbActivity) this.mContext).dol().drg()).dY("obj_id", ((PbActivity) this.mContext).dol().drh()).dY("obj_source", ((PbActivity) this.mContext).dol().drf());
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
            TiebaStatic.log(Ju("c13601").al("obj_type", this.mdd.mcT ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxg() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdl);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJr() {
        dwb();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.maM = false;
        if (this.mck != null) {
            this.mck.wa(false);
        }
    }

    private void dwa() {
        if (this.maP == null) {
            this.maP = ObjectAnimator.ofFloat(this.mat, "alpha", 0.0f, 1.0f);
            this.maP.setDuration(200L);
        }
        this.maP.start();
    }

    private void dwb() {
        if (this.maQ == null) {
            this.maQ = ObjectAnimator.ofFloat(this.mat, "alpha", 1.0f, 0.0f);
            this.maQ.setDuration(200L);
        }
        this.maQ.start();
    }

    public void onDestroy() {
        dxg();
        xa(false);
    }

    public boolean cak() {
        return this.amX;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.mck = videoPbFragment;
    }

    public void dL(View view) {
        this.mRootView = view;
    }

    public void dM(View view) {
        this.mat = view;
    }

    public boolean dwd() {
        return this.maM;
    }

    public void wa(boolean z) {
        this.maM = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxh() {
        if (this.mAh != null) {
            o dCb = this.mAh.dCb();
            dCb.mLocate = "pb";
            h.a(dCb.myv, "", "2", dCb, this.gqV.getPcdnState());
        }
    }
}
