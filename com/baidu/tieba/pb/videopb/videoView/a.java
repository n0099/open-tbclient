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
/* loaded from: classes16.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int kEb;
    private String kEc;
    private View kVB;
    private boolean kVS;
    private boolean kVT;
    private Runnable kVV;
    private ObjectAnimator kVW;
    private ObjectAnimator kVX;
    private int kVp;
    private VideoPbFragment kXq;
    private final int kYc;
    private final int kYd;
    private final int kYe;
    private final int kYf;
    private final int kYg;
    private final int kYh;
    private PbVideoFullscreenAttentionLayout kYi;
    private PbNextVideoLayout kYj;
    private ImageView kYk;
    private ImageView kYl;
    private int kYm;
    private boolean kYn;
    private ObjectAnimator kYo;
    private e kYp;
    private Runnable kYq;
    private Runnable kYr;
    private Runnable kYs;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.kYc = 16384;
        this.kYd = 32768;
        this.kYe = 65536;
        this.kYf = 131072;
        this.kYg = 5000;
        this.kYh = 1500;
        this.kYm = -1;
        this.kEb = 0;
        this.kYq = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.luN.setVisibility(8);
            }
        };
        this.kYr = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kYi.dfr()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.akX ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.kYn = true;
                    a.this.kYo.setFloatValues(-l.getDimens(context2, i));
                    a.this.kYo.removeAllListeners();
                    a.this.kYo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dfp();
                            com.baidu.adp.lib.f.e.mS().postDelayed(a.this.kYs, 5000L);
                        }
                    });
                    a.this.kYo.start();
                }
            }
        };
        this.kYs = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.kYo.setFloatValues(l.getDimens(a.this.mContext, a.this.akX ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.kYo.removeAllListeners();
                a.this.kYo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kYi.setVisibility(8);
                    }
                });
                a.this.kYo.start();
            }
        };
        this.kVV = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kVT && (a.this.mContext instanceof Activity)) {
                    a.this.azf();
                }
            }
        };
        dfk();
        if (context instanceof PbActivity) {
            this.kYp = (e) y.b((PbActivity) context).l(e.class);
            this.kVS = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        vc(true);
        this.luV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kYi = (PbVideoFullscreenAttentionLayout) this.luQ.findViewById(R.id.video_fullscreen_attention);
        this.kYj = (PbNextVideoLayout) this.luQ.findViewById(R.id.video_next_layout);
        this.kYk = (ImageView) this.luQ.findViewById(R.id.video_pre);
        this.kYl = (ImageView) this.luQ.findViewById(R.id.video_next);
        SvgManager.bjq().a(this.kYk, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.bjq().a(this.kYl, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.akO.bwm();
        this.akO.setDrawCorner(false);
        this.kYi.setOnClickEvent(this);
        this.kYk.setOnClickListener(this);
        this.kYl.setOnClickListener(this);
        this.kYj.setOnClickListener(this);
        this.kVp = l.getEquipmentWidth(this.mContext) / 10;
        this.luK.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dfh() {
        this.fDL.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void uk(boolean z) {
        this.kYj.setIsCountDownValid(z);
    }

    public void aR(bw bwVar) {
        if (bwVar == null || bwVar.beW() == null || at.isEmpty(bwVar.beW().video_url)) {
            if (this.luA == this.lut || this.luA == this.luu) {
                this.luA &= -65537;
                EQ(this.luA);
            }
            this.lut &= -65537;
            this.luu &= -65537;
            return;
        }
        if (this.luA == this.lut || this.luA == this.luu) {
            this.luA |= 65536;
            EQ(this.luA);
        }
        this.lut |= 65536;
        this.luu |= 65536;
    }

    public void aS(bw bwVar) {
        if (bwVar == null || bwVar.beW() == null || at.isEmpty(bwVar.beW().video_url)) {
            if (this.luA == this.lut || this.luA == this.luu || this.luA == this.luw) {
                this.luA &= -32769;
                this.luA &= -131073;
                EQ(this.luA);
            }
            this.lut &= -32769;
            this.luu &= -32769;
            this.luw &= -131073;
            return;
        }
        if (this.luA == this.lut || this.luA == this.luu) {
            this.luA |= 32768;
            EQ(this.luA);
        }
        if (this.luA == this.luw) {
            this.luA |= 131072;
            EQ(this.luA);
        }
        this.lut |= 32768;
        this.luu |= 32768;
        this.luw |= 131072;
        this.kYj.setDate(bwVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.baijiahaoData = bwVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.akY = bwVar.getTid();
            oVar.eVt = Long.toString(bwVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bwVar.isBjh()) {
                    this.kEb = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.kEb == 0) {
                        this.kEb = intent.getIntExtra("key_start_from", 0);
                    }
                    this.kEc = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.kEc)) {
                        oVar.dYo = this.kEc;
                    }
                    oVar.lte = Integer.toString(this.kEb);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.lte = this.source;
                }
            }
            if (bwVar.beW() != null) {
                oVar.lth = bwVar.beW().video_md5;
                oVar.ltj = String.valueOf(bwVar.beW().is_vertical);
            }
            b(oVar);
            this.kYn = false;
            if (com.baidu.tbadk.a.d.bah()) {
                this.kYj.setIsCountDownValid(false);
            } else {
                this.kYj.setIsCountDownValid(true);
            }
            if (this.kzj && bwVar.beW() != null) {
                if (this.akX != (bwVar.beW().is_vertical.intValue() == 1)) {
                    dkH();
                }
            }
            super.setData(bwVar);
            vc(!this.akX);
            if (bwVar.beE() != null) {
                bwVar.beE().setIsLike(bwVar.beE().hadConcerned());
            }
            this.kYi.setData(bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfi() {
        super.dfi();
        if (this.kzj) {
            dfm();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kYi.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kzj || motionEvent.getX() > ((float) this.kVp);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dfj() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfk() {
        this.luq &= -33;
        this.lur &= -33;
        this.lus &= -33;
        this.lut &= -33;
        this.luu &= -33;
        this.luv &= -33;
        this.luw &= -33;
        this.lux &= -33;
        this.luy &= -33;
        this.luq |= 1024;
        this.lur |= 1024;
        this.lus &= -1025;
        this.lut |= 1024;
        this.luu |= 1024;
        this.luv |= 1024;
        this.luw |= 1024;
        this.lux |= 1024;
        this.luy &= -1025;
        this.lur |= 16384;
        this.luv |= 16384;
        this.luw &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfl() {
        int i = 0;
        this.luJ.ar(this.akX, this.kzj);
        this.luK.ar(this.akX, this.kzj);
        if (this.luI instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.luI).ar(this.akX, this.kzj);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.luH.getLayoutParams();
        int dimens = (this.kzj && this.akX) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kzj && !this.akX) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kYk.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kYl.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kzj || this.akX) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kYj.ar(this.akX, this.kzj);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void EQ(int i) {
        if (i != this.luu && i != this.luv && i != this.lut && i != this.lur) {
            dfp();
            if (this.kYi != null) {
                this.kYi.setVisibility(8);
            }
        }
        if (this.luA != this.luy && i == this.luy) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYq);
            if ((this.luA & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.luA & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.luy = i;
        }
        super.EQ(i);
        if (!this.kzj) {
            this.luL.setVisibility(8);
            this.luM.setVisibility(8);
            if (this.kYp != null) {
                this.kYp.uh((i & 1024) > 0);
            }
        }
        if (this.kYp != null) {
            this.kYp.uh((i & 128) > 0);
        }
        if (this.luI instanceof PbVideoMediaController) {
            this.luI.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.luI).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kYk != null) {
            this.kYk.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.kYl != null) {
            this.kYl.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kYj != null) {
            boolean z = (131072 & i) > 0;
            this.kYj.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Hc("c13600"));
            }
        }
        if (!this.kzj && !this.kVS && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kVT) {
                    if (this.kXq == null || !this.kXq.del()) {
                        dei();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kVT = true;
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kVV);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.kVV, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.kVT || (this.kXq != null && this.kXq.del())) {
                azf();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ul(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kzj);
        }
        super.ul(z);
        dfp();
        if (this.kzj) {
            dfm();
        } else {
            this.kYi.setVisibility(8);
        }
    }

    private void dfm() {
        if (!this.kYn && !this.kYi.dfr()) {
            this.kYi.setTranslationX(0.0f);
            this.kYi.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kYi.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.akX ? R.dimen.tbds248 : R.dimen.tbds428);
            this.kYo = ObjectAnimator.ofFloat(this.kYi, "translationX", 0.0f);
            this.kYo.setDuration(500);
            dfp();
            com.baidu.adp.lib.f.e.mS().postDelayed(this.kYr, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dfn() {
        if (this.luA == this.luy) {
            return false;
        }
        this.luN.setVisibility(0);
        this.luN.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYq);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.kYq, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dfo() {
        if (this.luA == this.luy) {
            return false;
        }
        this.luN.setVisibility(0);
        this.luN.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYq);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.kYq, 1500L);
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
                dfp();
                com.baidu.adp.lib.f.e.mS().post(this.kYs);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.kYp != null) {
                    this.kYp.ui(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.kYp != null) {
                    this.kYp.deB();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.luw &= -131073;
                this.luA &= -131073;
                this.kYj.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean pN(boolean z) {
        dfp();
        this.kYi.setVisibility(8);
        if (!this.kVS) {
            azf();
        }
        if (z) {
            this.kYm = this.luA;
            if (this.luA == this.luu || ((this.luA == this.luv && !this.fDL.isPlaying()) || this.luA == this.luw)) {
                this.kYm |= 1;
            }
            stopPlay();
            return true;
        } else if (this.kYm == -1) {
            startPlay();
            return true;
        } else if (this.kYm == this.lur || this.kYm == this.lut || this.kYm == this.lus) {
            startPlay();
            return true;
        } else {
            this.luI.setCurrentDuration(n.dkd().OE(this.mVideoUrl), false);
            EQ(this.kYm);
            return true;
        }
    }

    private aq Hc(String str) {
        aq dD = new aq(str).dD("tid", this.akY).u("fid", this.mFid).dD("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dD.dD("obj_param4", this.baijiahaoData.oriUgcNid);
            dD.dD("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dD.ai("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dD.ai("obj_param5", 3);
            }
        } else {
            dD.ai("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cWD() != null) {
            dD.dD("ab_tag", ((PbActivity) this.mContext).cWD().cZw()).dD("obj_id", ((PbActivity) this.mContext).cWD().cZx()).dD("obj_source", ((PbActivity) this.mContext).cWD().cZv());
        }
        return dD;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void ER(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new aq("c13598"));
            } else {
                TiebaStatic.log(new aq("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(Hc("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Hc("c13601").ai("obj_type", this.kYj.kXZ ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfp() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYr);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azf() {
        dej();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kVT = false;
        if (this.kXq != null) {
            this.kXq.ud(false);
        }
    }

    private void dei() {
        if (this.kVW == null) {
            this.kVW = ObjectAnimator.ofFloat(this.kVB, "alpha", 0.0f, 1.0f);
            this.kVW.setDuration(200L);
        }
        this.kVW.start();
    }

    private void dej() {
        if (this.kVX == null) {
            this.kVX = ObjectAnimator.ofFloat(this.kVB, "alpha", 1.0f, 0.0f);
            this.kVX.setDuration(200L);
        }
        this.kVX.start();
    }

    public void onDestroy() {
        dfp();
        vc(false);
    }

    public boolean bNe() {
        return this.akX;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.kXq = videoPbFragment;
    }

    public void db(View view) {
        this.mRootView = view;
    }

    public void dc(View view) {
        this.kVB = view;
    }

    public boolean del() {
        return this.kVT;
    }

    public void ud(boolean z) {
        this.kVT = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfq() {
        if (this.luT != null) {
            o dke = this.luT.dke();
            dke.mLocate = "pb";
            h.a(dke.lth, "", "2", dke, this.fDL.getPcdnState());
        }
    }
}
