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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private int lbT;
    private String lbU;
    private View ltE;
    private boolean ltV;
    private boolean ltW;
    private Runnable ltY;
    private ObjectAnimator ltZ;
    private int lts;
    private ObjectAnimator lua;
    private VideoPbFragment lvu;
    private final int lwg;
    private final int lwh;
    private final int lwi;
    private final int lwj;
    private final int lwk;
    private final int lwl;
    private PbVideoFullscreenAttentionLayout lwm;
    private PbNextVideoLayout lwn;
    private ImageView lwo;
    private ImageView lwp;
    private int lwq;
    private boolean lwr;
    private ObjectAnimator lws;
    private e lwt;
    private Runnable lwu;
    private Runnable lwv;
    private Runnable lww;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.lwg = 16384;
        this.lwh = 32768;
        this.lwi = 65536;
        this.lwj = 131072;
        this.lwk = 5000;
        this.lwl = 1500;
        this.lwq = -1;
        this.lbT = 0;
        this.lwu = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.lTe.setVisibility(8);
            }
        };
        this.lwv = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.lwm.dmF()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.alR ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.lwr = true;
                    a.this.lws.setFloatValues(-l.getDimens(context2, i));
                    a.this.lws.removeAllListeners();
                    a.this.lws.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dmD();
                            com.baidu.adp.lib.f.e.mY().postDelayed(a.this.lww, 5000L);
                        }
                    });
                    a.this.lws.start();
                }
            }
        };
        this.lww = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.lws.setFloatValues(l.getDimens(a.this.mContext, a.this.alR ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.lws.removeAllListeners();
                a.this.lws.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.lwm.setVisibility(8);
                    }
                });
                a.this.lws.start();
            }
        };
        this.ltY = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ltW && (a.this.mContext instanceof Activity)) {
                    a.this.aCx();
                }
            }
        };
        dmy();
        if (context instanceof PbActivity) {
            this.lwt = (e) y.b((PbActivity) context).l(e.class);
            this.ltV = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        vT(true);
        this.lTm = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lwm = (PbVideoFullscreenAttentionLayout) this.lTh.findViewById(R.id.video_fullscreen_attention);
        this.lwn = (PbNextVideoLayout) this.lTh.findViewById(R.id.video_next_layout);
        this.lwo = (ImageView) this.lTh.findViewById(R.id.video_pre);
        this.lwp = (ImageView) this.lTh.findViewById(R.id.video_next);
        SvgManager.bmU().a(this.lwo, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.bmU().a(this.lwp, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.alI.bAg();
        this.alI.setDrawCorner(false);
        this.lwm.setOnClickEvent(this);
        this.lwo.setOnClickListener(this);
        this.lwp.setOnClickListener(this);
        this.lwn.setOnClickListener(this);
        this.lts = l.getEquipmentWidth(this.mContext) / 10;
        this.lTb.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dmv() {
        this.fTk.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void vb(boolean z) {
        this.lwn.setIsCountDownValid(z);
    }

    public void aS(bw bwVar) {
        if (bwVar == null || bwVar.biz() == null || at.isEmpty(bwVar.biz().video_url)) {
            if (this.lSR == this.lSK || this.lSR == this.lSL) {
                this.lSR &= -65537;
                FX(this.lSR);
            }
            this.lSK &= -65537;
            this.lSL &= -65537;
            return;
        }
        if (this.lSR == this.lSK || this.lSR == this.lSL) {
            this.lSR |= 65536;
            FX(this.lSR);
        }
        this.lSK |= 65536;
        this.lSL |= 65536;
    }

    public void aT(bw bwVar) {
        if (bwVar == null || bwVar.biz() == null || at.isEmpty(bwVar.biz().video_url)) {
            if (this.lSR == this.lSK || this.lSR == this.lSL || this.lSR == this.lSN) {
                this.lSR &= -32769;
                this.lSR &= -131073;
                FX(this.lSR);
            }
            this.lSK &= -32769;
            this.lSL &= -32769;
            this.lSN &= -131073;
            return;
        }
        if (this.lSR == this.lSK || this.lSR == this.lSL) {
            this.lSR |= 32768;
            FX(this.lSR);
        }
        if (this.lSR == this.lSN) {
            this.lSR |= 131072;
            FX(this.lSR);
        }
        this.lSK |= 32768;
        this.lSL |= 32768;
        this.lSN |= 131072;
        this.lwn.setDate(bwVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.baijiahaoData = bwVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.alS = bwVar.getTid();
            oVar.fkA = Long.toString(bwVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bwVar.isBjh()) {
                    this.lbT = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.lbT == 0) {
                        this.lbT = intent.getIntExtra("key_start_from", 0);
                    }
                    this.lbU = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.lbU)) {
                        oVar.emE = this.lbU;
                    }
                    oVar.lRw = Integer.toString(this.lbT);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.lRw = this.source;
                }
            }
            if (bwVar.biz() != null) {
                oVar.lRz = bwVar.biz().video_md5;
                oVar.lRB = String.valueOf(bwVar.biz().is_vertical);
            }
            b(oVar);
            this.lwr = false;
            if (com.baidu.tbadk.a.d.bdE()) {
                this.lwn.setIsCountDownValid(false);
            } else {
                this.lwn.setIsCountDownValid(true);
            }
            if (this.kWY && bwVar.biz() != null) {
                if (this.alR != (bwVar.biz().is_vertical.intValue() == 1)) {
                    dsc();
                }
            }
            super.setData(bwVar);
            vT(!this.alR);
            if (bwVar.bih() != null) {
                bwVar.bih().setIsLike(bwVar.bih().hadConcerned());
            }
            this.lwm.setData(bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmw() {
        super.dmw();
        if (this.kWY) {
            dmA();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.lwm.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kWY || motionEvent.getX() > ((float) this.lts);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dmx() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmy() {
        this.lSH &= -33;
        this.lSI &= -33;
        this.lSJ &= -33;
        this.lSK &= -33;
        this.lSL &= -33;
        this.lSM &= -33;
        this.lSN &= -33;
        this.lSO &= -33;
        this.lSP &= -33;
        this.lSH |= 1024;
        this.lSI |= 1024;
        this.lSJ &= -1025;
        this.lSK |= 1024;
        this.lSL |= 1024;
        this.lSM |= 1024;
        this.lSN |= 1024;
        this.lSO |= 1024;
        this.lSP &= -1025;
        this.lSI |= 16384;
        this.lSM |= 16384;
        this.lSN &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmz() {
        int i = 0;
        this.lTa.as(this.alR, this.kWY);
        this.lTb.as(this.alR, this.kWY);
        if (this.lSZ instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.lSZ).as(this.alR, this.kWY);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lSY.getLayoutParams();
        int dimens = (this.kWY && this.alR) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kWY && !this.alR) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lwo.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lwp.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kWY || this.alR) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.lwn.as(this.alR, this.kWY);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void FX(int i) {
        if (i != this.lSL && i != this.lSM && i != this.lSK && i != this.lSI) {
            dmD();
            if (this.lwm != null) {
                this.lwm.setVisibility(8);
            }
        }
        if (this.lSR != this.lSP && i == this.lSP) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lwu);
            if ((this.lSR & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.lSR & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.lSP = i;
        }
        super.FX(i);
        if (!this.kWY) {
            this.lTc.setVisibility(8);
            this.lTd.setVisibility(8);
            if (this.lwt != null) {
                this.lwt.uY((i & 1024) > 0);
            }
        }
        if (this.lwt != null) {
            this.lwt.uY((i & 128) > 0);
        }
        if (this.lSZ instanceof PbVideoMediaController) {
            this.lSZ.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.lSZ).setBottomBarShow((i & 16384) > 0);
        }
        if (this.lwo != null) {
            this.lwo.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.lwp != null) {
            this.lwp.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.lwn != null) {
            boolean z = (131072 & i) > 0;
            this.lwn.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(In("c13600"));
            }
        }
        if (!this.kWY && !this.ltV && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.ltW) {
                    if (this.lvu == null || !this.lvu.dlz()) {
                        dlw();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.ltW = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ltY);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.ltY, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.ltW || (this.lvu != null && this.lvu.dlz())) {
                aCx();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vc(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kWY);
        }
        super.vc(z);
        dmD();
        if (this.kWY) {
            dmA();
        } else {
            this.lwm.setVisibility(8);
        }
    }

    private void dmA() {
        if (!this.lwr && !this.lwm.dmF()) {
            this.lwm.setTranslationX(0.0f);
            this.lwm.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.lwm.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.alR ? R.dimen.tbds248 : R.dimen.tbds428);
            this.lws = ObjectAnimator.ofFloat(this.lwm, "translationX", 0.0f);
            this.lws.setDuration(500);
            dmD();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.lwv, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dmB() {
        if (this.lSR == this.lSP) {
            return false;
        }
        this.lTe.setVisibility(0);
        this.lTe.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lwu);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lwu, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dmC() {
        if (this.lSR == this.lSP) {
            return false;
        }
        this.lTe.setVisibility(0);
        this.lTe.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lwu);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lwu, 1500L);
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
                dmD();
                com.baidu.adp.lib.f.e.mY().post(this.lww);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.lwt != null) {
                    this.lwt.uZ(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.lwt != null) {
                    this.lwt.dlP();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.lSN &= -131073;
                this.lSR &= -131073;
                this.lwn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean qD(boolean z) {
        dmD();
        this.lwm.setVisibility(8);
        if (!this.ltV) {
            aCx();
        }
        if (z) {
            this.lwq = this.lSR;
            if (this.lSR == this.lSL || ((this.lSR == this.lSM && !this.fTk.isPlaying()) || this.lSR == this.lSN)) {
                this.lwq |= 1;
            }
            stopPlay();
            return true;
        } else if (this.lwq == -1) {
            startPlay();
            return true;
        } else if (this.lwq == this.lSI || this.lwq == this.lSK || this.lwq == this.lSJ) {
            startPlay();
            return true;
        } else {
            this.lSZ.setCurrentDuration(n.dry().PV(this.mVideoUrl), false);
            FX(this.lwq);
            return true;
        }
    }

    private aq In(String str) {
        aq dK = new aq(str).dK("tid", this.alS).u("fid", this.mFid).dK("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dK.dK("obj_param4", this.baijiahaoData.oriUgcNid);
            dK.dK("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dK.aj("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dK.aj("obj_param5", 3);
            }
        } else {
            dK.aj("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).ddQ() != null) {
            dK.dK("ab_tag", ((PbActivity) this.mContext).ddQ().dgJ()).dK("obj_id", ((PbActivity) this.mContext).ddQ().dgK()).dK("obj_source", ((PbActivity) this.mContext).ddQ().dgI());
        }
        return dK;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void FY(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(In("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(In("c13601").aj("obj_type", this.lwn.lwd ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmD() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lwv);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lww);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCx() {
        dlx();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.ltW = false;
        if (this.lvu != null) {
            this.lvu.uU(false);
        }
    }

    private void dlw() {
        if (this.ltZ == null) {
            this.ltZ = ObjectAnimator.ofFloat(this.ltE, "alpha", 0.0f, 1.0f);
            this.ltZ.setDuration(200L);
        }
        this.ltZ.start();
    }

    private void dlx() {
        if (this.lua == null) {
            this.lua = ObjectAnimator.ofFloat(this.ltE, "alpha", 1.0f, 0.0f);
            this.lua.setDuration(200L);
        }
        this.lua.start();
    }

    public void onDestroy() {
        dmD();
        vT(false);
    }

    public boolean bRF() {
        return this.alR;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.lvu = videoPbFragment;
    }

    public void dn(View view) {
        this.mRootView = view;
    }

    /* renamed from: do  reason: not valid java name */
    public void m41do(View view) {
        this.ltE = view;
    }

    public boolean dlz() {
        return this.ltW;
    }

    public void uU(boolean z) {
        this.ltW = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmE() {
        if (this.lTk != null) {
            o drz = this.lTk.drz();
            drz.mLocate = "pb";
            h.a(drz.lRz, "", "2", drz, this.fTk.getPcdnState());
        }
    }
}
