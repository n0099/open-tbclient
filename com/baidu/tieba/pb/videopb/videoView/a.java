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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
    private int kFG;
    private View kFS;
    private boolean kGj;
    private boolean kGk;
    private Runnable kGm;
    private ObjectAnimator kGn;
    private ObjectAnimator kGo;
    private VideoPbFragment kHE;
    private e kIA;
    private Runnable kIB;
    private Runnable kIC;
    private Runnable kID;
    private final int kIn;
    private final int kIo;
    private final int kIp;
    private final int kIq;
    private final int kIr;
    private final int kIs;
    private PbVideoFullscreenAttentionLayout kIt;
    private PbNextVideoLayout kIu;
    private ImageView kIv;
    private ImageView kIw;
    private int kIx;
    private boolean kIy;
    private ObjectAnimator kIz;
    private int koI;
    private String koJ;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.kIn = 16384;
        this.kIo = 32768;
        this.kIp = 65536;
        this.kIq = 131072;
        this.kIr = 5000;
        this.kIs = 1500;
        this.kIx = -1;
        this.koI = 0;
        this.kIB = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.les.setVisibility(8);
            }
        };
        this.kIC = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kIt.cUu()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.ajI ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.kIy = true;
                    a.this.kIz.setFloatValues(-l.getDimens(context2, i));
                    a.this.kIz.removeAllListeners();
                    a.this.kIz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.cUs();
                            com.baidu.adp.lib.f.e.lt().postDelayed(a.this.kID, 5000L);
                        }
                    });
                    a.this.kIz.start();
                }
            }
        };
        this.kID = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.kIz.setFloatValues(l.getDimens(a.this.mContext, a.this.ajI ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.kIz.removeAllListeners();
                a.this.kIz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kIt.setVisibility(8);
                    }
                });
                a.this.kIz.start();
            }
        };
        this.kGm = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kGk && (a.this.mContext instanceof Activity)) {
                    a.this.aqT();
                }
            }
        };
        cUn();
        if (context instanceof PbActivity) {
            this.kIA = (e) y.b((PbActivity) context).l(e.class);
            this.kGj = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        uq(true);
        this.leA = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kIt = (PbVideoFullscreenAttentionLayout) this.lev.findViewById(R.id.video_fullscreen_attention);
        this.kIu = (PbNextVideoLayout) this.lev.findViewById(R.id.video_next_layout);
        this.kIv = (ImageView) this.lev.findViewById(R.id.video_pre);
        this.kIw = (ImageView) this.lev.findViewById(R.id.video_next);
        SvgManager.baR().a(this.kIv, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.baR().a(this.kIw, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ajz.bny();
        this.ajz.setDrawCorner(false);
        this.kIt.setOnClickEvent(this);
        this.kIv.setOnClickListener(this);
        this.kIw.setOnClickListener(this);
        this.kIu.setOnClickListener(this);
        this.kFG = l.getEquipmentWidth(this.mContext) / 10;
        this.lep.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void cUk() {
        this.fsr.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void tB(boolean z) {
        this.kIu.setIsCountDownValid(z);
    }

    public void aQ(bv bvVar) {
        if (bvVar == null || bvVar.aWD() == null || as.isEmpty(bvVar.aWD().video_url)) {
            if (this.lee == this.ldX || this.lee == this.ldY) {
                this.lee &= -65537;
                Cw(this.lee);
            }
            this.ldX &= -65537;
            this.ldY &= -65537;
            return;
        }
        if (this.lee == this.ldX || this.lee == this.ldY) {
            this.lee |= 65536;
            Cw(this.lee);
        }
        this.ldX |= 65536;
        this.ldY |= 65536;
    }

    public void aR(bv bvVar) {
        if (bvVar == null || bvVar.aWD() == null || as.isEmpty(bvVar.aWD().video_url)) {
            if (this.lee == this.ldX || this.lee == this.ldY || this.lee == this.lea) {
                this.lee &= -32769;
                this.lee &= -131073;
                Cw(this.lee);
            }
            this.ldX &= -32769;
            this.ldY &= -32769;
            this.lea &= -131073;
            return;
        }
        if (this.lee == this.ldX || this.lee == this.ldY) {
            this.lee |= 32768;
            Cw(this.lee);
        }
        if (this.lee == this.lea) {
            this.lee |= 131072;
            Cw(this.lee);
        }
        this.ldX |= 32768;
        this.ldY |= 32768;
        this.lea |= 131072;
        this.kIu.setDate(bvVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        if (bvVar != null) {
            this.baijiahaoData = bvVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.ajJ = bvVar.getTid();
            oVar.eKO = Long.toString(bvVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bvVar.isBjh()) {
                    this.koI = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.koI == 0) {
                        this.koI = intent.getIntExtra("key_start_from", 0);
                    }
                    this.koJ = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.koJ)) {
                        oVar.dOV = this.koJ;
                    }
                    oVar.lcJ = Integer.toString(this.koI);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.lcJ = this.source;
                }
            }
            if (bvVar.aWD() != null) {
                oVar.lcM = bvVar.aWD().video_md5;
                oVar.lcO = String.valueOf(bvVar.aWD().is_vertical);
            }
            b(oVar);
            this.kIy = false;
            if (com.baidu.tbadk.a.d.aRQ()) {
                this.kIu.setIsCountDownValid(false);
            } else {
                this.kIu.setIsCountDownValid(true);
            }
            if (this.kjP && bvVar.aWD() != null) {
                if (this.ajI != (bvVar.aWD().is_vertical.intValue() == 1)) {
                    cZD();
                }
            }
            super.setData(bvVar);
            uq(!this.ajI);
            if (bvVar.aWl() != null) {
                bvVar.aWl().setIsLike(bvVar.aWl().hadConcerned());
            }
            this.kIt.setData(bvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUl() {
        super.cUl();
        if (this.kjP) {
            cUp();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kIt.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean J(MotionEvent motionEvent) {
        return this.kjP || motionEvent.getX() > ((float) this.kFG);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean cUm() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUn() {
        this.ldU &= -33;
        this.ldV &= -33;
        this.ldW &= -33;
        this.ldX &= -33;
        this.ldY &= -33;
        this.ldZ &= -33;
        this.lea &= -33;
        this.leb &= -33;
        this.lec &= -33;
        this.ldU |= 1024;
        this.ldV |= 1024;
        this.ldW &= -1025;
        this.ldX |= 1024;
        this.ldY |= 1024;
        this.ldZ |= 1024;
        this.lea |= 1024;
        this.leb |= 1024;
        this.lec &= -1025;
        this.ldV |= 16384;
        this.ldZ |= 16384;
        this.lea &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUo() {
        int i = 0;
        this.leo.an(this.ajI, this.kjP);
        this.lep.an(this.ajI, this.kjP);
        if (this.lem instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.lem).an(this.ajI, this.kjP);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lel.getLayoutParams();
        int dimens = (this.kjP && this.ajI) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kjP && !this.ajI) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kIv.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kIw.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kjP || this.ajI) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kIu.an(this.ajI, this.kjP);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Cw(int i) {
        if (i != this.ldY && i != this.ldZ && i != this.ldX && i != this.ldV) {
            cUs();
            if (this.kIt != null) {
                this.kIt.setVisibility(8);
            }
        }
        if (this.lee != this.lec && i == this.lec) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kIB);
            if ((this.lee & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.lee & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.lec = i;
        }
        super.Cw(i);
        if (!this.kjP) {
            this.leq.setVisibility(8);
            this.ler.setVisibility(8);
            if (this.kIA != null) {
                this.kIA.ty((i & 1024) > 0);
            }
        }
        if (this.kIA != null) {
            this.kIA.ty((i & 128) > 0);
        }
        if (this.lem instanceof PbVideoMediaController) {
            this.lem.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.lem).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kIv != null) {
            this.kIv.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.kIw != null) {
            this.kIw.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kIu != null) {
            boolean z = (131072 & i) > 0;
            this.kIu.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(ED("c13600"));
            }
        }
        if (!this.kjP && !this.kGj && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kGk) {
                    if (this.kHE == null || !this.kHE.cTt()) {
                        cTq();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kGk = true;
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kGm);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.kGm, 3000L);
                }
            } else if (this.kGk || (this.kHE != null && this.kHE.cTt())) {
                aqT();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void tC(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kjP);
        }
        super.tC(z);
        cUs();
        if (this.kjP) {
            cUp();
        } else {
            this.kIt.setVisibility(8);
        }
    }

    private void cUp() {
        if (!this.kIy && !this.kIt.cUu()) {
            this.kIt.setTranslationX(0.0f);
            this.kIt.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kIt.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.ajI ? R.dimen.tbds248 : R.dimen.tbds428);
            this.kIz = ObjectAnimator.ofFloat(this.kIt, "translationX", 0.0f);
            this.kIz.setDuration(500);
            cUs();
            com.baidu.adp.lib.f.e.lt().postDelayed(this.kIC, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cUq() {
        if (this.lee == this.lec) {
            return false;
        }
        this.les.setVisibility(0);
        this.les.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kIB);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kIB, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean cUr() {
        if (this.lee == this.lec) {
            return false;
        }
        this.les.setVisibility(0);
        this.les.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kIB);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kIB, 1500L);
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
                cUs();
                com.baidu.adp.lib.f.e.lt().post(this.kID);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.kIA != null) {
                    this.kIA.tz(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new ap("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.kIA != null) {
                    this.kIA.cTJ();
                }
                TiebaStatic.log(new ap("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.lea &= -131073;
                this.lee &= -131073;
                this.kIu.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean ph(boolean z) {
        cUs();
        this.kIt.setVisibility(8);
        if (!this.kGj) {
            aqT();
        }
        if (z) {
            this.kIx = this.lee;
            if (this.lee == this.ldY || ((this.lee == this.ldZ && !this.fsr.isPlaying()) || this.lee == this.lea)) {
                this.kIx |= 1;
            }
            stopPlay();
            return true;
        } else if (this.kIx == -1) {
            startPlay();
            return true;
        } else if (this.kIx == this.ldV || this.kIx == this.ldX || this.kIx == this.ldW) {
            startPlay();
            return true;
        } else {
            this.lem.setCurrentDuration(n.cZa().LL(this.mVideoUrl), false);
            Cw(this.kIx);
            return true;
        }
    }

    private ap ED(String str) {
        ap dn = new ap(str).dn("tid", this.ajJ).t("fid", this.mFid).dn("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            dn.dn("obj_param4", this.baijiahaoData.oriUgcNid);
            dn.dn("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                dn.ah("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                dn.ah("obj_param5", 3);
            }
        } else {
            dn.ah("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cLP() != null) {
            dn.dn("ab_tag", ((PbActivity) this.mContext).cLP().cOG()).dn("obj_id", ((PbActivity) this.mContext).cLP().cOH()).dn("obj_source", ((PbActivity) this.mContext).cLP().cOF());
        }
        return dn;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void Cx(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new ap("c13598"));
            } else {
                TiebaStatic.log(new ap("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(ED("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new ap("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new ap("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(ED("c13601").ah("obj_type", this.kIu.kIk ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUs() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kIC);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqT() {
        cTr();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kGk = false;
        if (this.kHE != null) {
            this.kHE.tu(false);
        }
    }

    private void cTq() {
        if (this.kGn == null) {
            this.kGn = ObjectAnimator.ofFloat(this.kFS, "alpha", 0.0f, 1.0f);
            this.kGn.setDuration(200L);
        }
        this.kGn.start();
    }

    private void cTr() {
        if (this.kGo == null) {
            this.kGo = ObjectAnimator.ofFloat(this.kFS, "alpha", 1.0f, 0.0f);
            this.kGo.setDuration(200L);
        }
        this.kGo.start();
    }

    public void onDestroy() {
        cUs();
        uq(false);
    }

    public boolean bDD() {
        return this.ajI;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.kHE = videoPbFragment;
    }

    public void cX(View view) {
        this.mRootView = view;
    }

    public void cY(View view) {
        this.kFS = view;
    }

    public boolean cTt() {
        return this.kGk;
    }

    public void tu(boolean z) {
        this.kGk = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUt() {
        if (this.ley != null) {
            o cZb = this.ley.cZb();
            cZb.mLocate = "pb";
            h.a(cZb.lcM, "", "2", cZb, this.fsr.getPcdnState());
        }
    }
}
