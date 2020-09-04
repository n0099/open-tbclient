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
    private int kEi;
    private String kEj;
    private View kVI;
    private boolean kVZ;
    private int kVw;
    private boolean kWa;
    private Runnable kWc;
    private ObjectAnimator kWd;
    private ObjectAnimator kWe;
    private VideoPbFragment kXx;
    private final int kYj;
    private final int kYk;
    private final int kYl;
    private final int kYm;
    private final int kYn;
    private final int kYo;
    private PbVideoFullscreenAttentionLayout kYp;
    private PbNextVideoLayout kYq;
    private ImageView kYr;
    private ImageView kYs;
    private int kYt;
    private boolean kYu;
    private ObjectAnimator kYv;
    private e kYw;
    private Runnable kYx;
    private Runnable kYy;
    private Runnable kYz;
    private View mRootView;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.kYj = 16384;
        this.kYk = 32768;
        this.kYl = 65536;
        this.kYm = 131072;
        this.kYn = 5000;
        this.kYo = 1500;
        this.kYt = -1;
        this.kEi = 0;
        this.kYx = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.luY.setVisibility(8);
            }
        };
        this.kYy = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kYp.dfs()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.akZ ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.kYu = true;
                    a.this.kYv.setFloatValues(-l.getDimens(context2, i));
                    a.this.kYv.removeAllListeners();
                    a.this.kYv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.dfq();
                            com.baidu.adp.lib.f.e.mS().postDelayed(a.this.kYz, 5000L);
                        }
                    });
                    a.this.kYv.start();
                }
            }
        };
        this.kYz = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.kYv.setFloatValues(l.getDimens(a.this.mContext, a.this.akZ ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.kYv.removeAllListeners();
                a.this.kYv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.kYp.setVisibility(8);
                    }
                });
                a.this.kYv.start();
            }
        };
        this.kWc = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.kWa && (a.this.mContext instanceof Activity)) {
                    a.this.azf();
                }
            }
        };
        dfl();
        if (context instanceof PbActivity) {
            this.kYw = (e) y.b((PbActivity) context).l(e.class);
            this.kVZ = TbSingleton.getInstance().isNotchScreen((Activity) context) || TbSingleton.getInstance().isCutoutScreen((Activity) context);
        }
        ve(true);
        this.lvg = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kYp = (PbVideoFullscreenAttentionLayout) this.lvb.findViewById(R.id.video_fullscreen_attention);
        this.kYq = (PbNextVideoLayout) this.lvb.findViewById(R.id.video_next_layout);
        this.kYr = (ImageView) this.lvb.findViewById(R.id.video_pre);
        this.kYs = (ImageView) this.lvb.findViewById(R.id.video_next);
        SvgManager.bjq().a(this.kYr, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.bjq().a(this.kYs, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.akQ.bwn();
        this.akQ.setDrawCorner(false);
        this.kYp.setOnClickEvent(this);
        this.kYr.setOnClickListener(this);
        this.kYs.setOnClickListener(this);
        this.kYq.setOnClickListener(this);
        this.kVw = l.getEquipmentWidth(this.mContext) / 10;
        this.luV.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dfi() {
        this.fDP.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void um(boolean z) {
        this.kYq.setIsCountDownValid(z);
    }

    public void aR(bw bwVar) {
        if (bwVar == null || bwVar.beW() == null || at.isEmpty(bwVar.beW().video_url)) {
            if (this.luL == this.luE || this.luL == this.luF) {
                this.luL &= -65537;
                EQ(this.luL);
            }
            this.luE &= -65537;
            this.luF &= -65537;
            return;
        }
        if (this.luL == this.luE || this.luL == this.luF) {
            this.luL |= 65536;
            EQ(this.luL);
        }
        this.luE |= 65536;
        this.luF |= 65536;
    }

    public void aS(bw bwVar) {
        if (bwVar == null || bwVar.beW() == null || at.isEmpty(bwVar.beW().video_url)) {
            if (this.luL == this.luE || this.luL == this.luF || this.luL == this.luH) {
                this.luL &= -32769;
                this.luL &= -131073;
                EQ(this.luL);
            }
            this.luE &= -32769;
            this.luF &= -32769;
            this.luH &= -131073;
            return;
        }
        if (this.luL == this.luE || this.luL == this.luF) {
            this.luL |= 32768;
            EQ(this.luL);
        }
        if (this.luL == this.luH) {
            this.luL |= 131072;
            EQ(this.luL);
        }
        this.luE |= 32768;
        this.luF |= 32768;
        this.luH |= 131072;
        this.kYq.setDate(bwVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.baijiahaoData = bwVar.getBaijiahaoData();
            o oVar = new o();
            oVar.mLocate = "6";
            oVar.ala = bwVar.getTid();
            oVar.eVx = Long.toString(bwVar.getFid());
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bwVar.isBjh()) {
                    this.kEi = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.kEi == 0) {
                        this.kEi = intent.getIntExtra("key_start_from", 0);
                    }
                    this.kEj = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.kEj)) {
                        oVar.dYs = this.kEj;
                    }
                    oVar.ltp = Integer.toString(this.kEi);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    oVar.ltp = this.source;
                }
            }
            if (bwVar.beW() != null) {
                oVar.ltt = bwVar.beW().video_md5;
                oVar.ltv = String.valueOf(bwVar.beW().is_vertical);
            }
            b(oVar);
            this.kYu = false;
            if (com.baidu.tbadk.a.d.bah()) {
                this.kYq.setIsCountDownValid(false);
            } else {
                this.kYq.setIsCountDownValid(true);
            }
            if (this.kzq && bwVar.beW() != null) {
                if (this.akZ != (bwVar.beW().is_vertical.intValue() == 1)) {
                    dkK();
                }
            }
            super.setData(bwVar);
            ve(!this.akZ);
            if (bwVar.beE() != null) {
                bwVar.beE().setIsLike(bwVar.beE().hadConcerned());
            }
            this.kYp.setData(bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfj() {
        super.dfj();
        if (this.kzq) {
            dfn();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.kYp.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kzq || motionEvent.getX() > ((float) this.kVw);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean dfk() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfl() {
        this.luB &= -33;
        this.luC &= -33;
        this.luD &= -33;
        this.luE &= -33;
        this.luF &= -33;
        this.luG &= -33;
        this.luH &= -33;
        this.luI &= -33;
        this.luJ &= -33;
        this.luB |= 1024;
        this.luC |= 1024;
        this.luD &= -1025;
        this.luE |= 1024;
        this.luF |= 1024;
        this.luG |= 1024;
        this.luH |= 1024;
        this.luI |= 1024;
        this.luJ &= -1025;
        this.luC |= 16384;
        this.luG |= 16384;
        this.luH &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfm() {
        int i = 0;
        this.luU.ar(this.akZ, this.kzq);
        this.luV.ar(this.akZ, this.kzq);
        if (this.luT instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.luT).ar(this.akZ, this.kzq);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.luS.getLayoutParams();
        int dimens = (this.kzq && this.akZ) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.kzq && !this.akZ) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kYr.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kYs.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.kzq || this.akZ) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.kYq.ar(this.akZ, this.kzq);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void EQ(int i) {
        if (i != this.luF && i != this.luG && i != this.luE && i != this.luC) {
            dfq();
            if (this.kYp != null) {
                this.kYp.setVisibility(8);
            }
        }
        if (this.luL != this.luJ && i == this.luJ) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYx);
            if ((this.luL & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.luL & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.luJ = i;
        }
        super.EQ(i);
        if (!this.kzq) {
            this.luW.setVisibility(8);
            this.luX.setVisibility(8);
            if (this.kYw != null) {
                this.kYw.uj((i & 1024) > 0);
            }
        }
        if (this.kYw != null) {
            this.kYw.uj((i & 128) > 0);
        }
        if (this.luT instanceof PbVideoMediaController) {
            this.luT.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.luT).setBottomBarShow((i & 16384) > 0);
        }
        if (this.kYr != null) {
            this.kYr.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.kYs != null) {
            this.kYs.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.kYq != null) {
            boolean z = (131072 & i) > 0;
            this.kYq.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(Hd("c13600"));
            }
        }
        if (!this.kzq && !this.kVZ && (this.mContext instanceof Activity)) {
            if ((i & 128) > 0) {
                if (!this.kWa) {
                    if (this.kXx == null || !this.kXx.dem()) {
                        dej();
                        UtilHelper.showStatusBar((Activity) this.mContext, this.mRootView);
                    }
                    this.kWa = true;
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kWc);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.kWc, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (this.kWa || (this.kXx != null && this.kXx.dem())) {
                azf();
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void un(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kzq);
        }
        super.un(z);
        dfq();
        if (this.kzq) {
            dfn();
        } else {
            this.kYp.setVisibility(8);
        }
    }

    private void dfn() {
        if (!this.kYu && !this.kYp.dfs()) {
            this.kYp.setTranslationX(0.0f);
            this.kYp.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kYp.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.akZ ? R.dimen.tbds248 : R.dimen.tbds428);
            this.kYv = ObjectAnimator.ofFloat(this.kYp, "translationX", 0.0f);
            this.kYv.setDuration(500);
            dfq();
            com.baidu.adp.lib.f.e.mS().postDelayed(this.kYy, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dfo() {
        if (this.luL == this.luJ) {
            return false;
        }
        this.luY.setVisibility(0);
        this.luY.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYx);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.kYx, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean dfp() {
        if (this.luL == this.luJ) {
            return false;
        }
        this.luY.setVisibility(0);
        this.luY.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYx);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.kYx, 1500L);
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
                dfq();
                com.baidu.adp.lib.f.e.mS().post(this.kYz);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.kYw != null) {
                    this.kYw.uk(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new aq("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.kYw != null) {
                    this.kYw.deC();
                }
                TiebaStatic.log(new aq("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.luH &= -131073;
                this.luL &= -131073;
                this.kYq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean pP(boolean z) {
        dfq();
        this.kYp.setVisibility(8);
        if (!this.kVZ) {
            azf();
        }
        if (z) {
            this.kYt = this.luL;
            if (this.luL == this.luF || ((this.luL == this.luG && !this.fDP.isPlaying()) || this.luL == this.luH)) {
                this.kYt |= 1;
            }
            stopPlay();
            return true;
        } else if (this.kYt == -1) {
            startPlay();
            return true;
        } else if (this.kYt == this.luC || this.kYt == this.luE || this.kYt == this.luD) {
            startPlay();
            return true;
        } else {
            this.luT.setCurrentDuration(n.dkg().OF(this.mVideoUrl), false);
            EQ(this.kYt);
            return true;
        }
    }

    private aq Hd(String str) {
        aq dD = new aq(str).dD("tid", this.ala).u("fid", this.mFid).dD("uid", TbadkCoreApplication.getCurrentAccount());
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).cWE() != null) {
            dD.dD("ab_tag", ((PbActivity) this.mContext).cWE().cZx()).dD("obj_id", ((PbActivity) this.mContext).cWE().cZy()).dD("obj_source", ((PbActivity) this.mContext).cWE().cZw());
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
            TiebaStatic.log(Hd("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new aq("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new aq("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(Hd("c13601").ai("obj_type", this.kYq.kYg ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfq() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYy);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kYz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azf() {
        dek();
        UtilHelper.hideStatusBar((Activity) this.mContext, this.mRootView);
        this.kWa = false;
        if (this.kXx != null) {
            this.kXx.uf(false);
        }
    }

    private void dej() {
        if (this.kWd == null) {
            this.kWd = ObjectAnimator.ofFloat(this.kVI, "alpha", 0.0f, 1.0f);
            this.kWd.setDuration(200L);
        }
        this.kWd.start();
    }

    private void dek() {
        if (this.kWe == null) {
            this.kWe = ObjectAnimator.ofFloat(this.kVI, "alpha", 1.0f, 0.0f);
            this.kWe.setDuration(200L);
        }
        this.kWe.start();
    }

    public void onDestroy() {
        dfq();
        ve(false);
    }

    public boolean bNf() {
        return this.akZ;
    }

    public void af(VideoPbFragment videoPbFragment) {
        this.kXx = videoPbFragment;
    }

    public void db(View view) {
        this.mRootView = view;
    }

    public void dc(View view) {
        this.kVI = view;
    }

    public boolean dem() {
        return this.kWa;
    }

    public void uf(boolean z) {
        this.kWa = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfr() {
        if (this.lve != null) {
            o dkh = this.lve.dkh();
            dkh.mLocate = "pb";
            h.a(dkh.ltt, "", "2", dkh, this.fDP.getPcdnState());
        }
    }
}
