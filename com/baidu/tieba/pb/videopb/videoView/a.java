package com.baidu.tieba.pb.videopb.videoView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.play.operableVideoView.d;
import com.baidu.tieba.play.x;
/* loaded from: classes7.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int iGA;
    private String iGB;
    private int iWT;
    private final int iYZ;
    private final int iZa;
    private final int iZb;
    private final int iZc;
    private final int iZd;
    private final int iZe;
    private PbVideoFullscreenAttentionLayout iZf;
    private PbNextVideoLayout iZg;
    private ImageView iZh;
    private ImageView iZi;
    private int iZj;
    private boolean iZk;
    private boolean iZl;
    private ObjectAnimator iZm;
    private e iZn;
    private Runnable iZo;
    private Runnable iZp;
    private Runnable iZq;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.iYZ = 16384;
        this.iZa = 32768;
        this.iZb = 65536;
        this.iZc = 131072;
        this.iZd = 5000;
        this.iZe = 1500;
        this.iZj = -1;
        this.iGA = 0;
        this.iZo = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jxj.setVisibility(8);
            }
        };
        this.iZp = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iZf.csD()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.OF ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.iZl = true;
                    a.this.iZm.setFloatValues(-l.getDimens(context2, i));
                    a.this.iZm.removeAllListeners();
                    a.this.iZm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.csC();
                            com.baidu.adp.lib.f.e.gx().postDelayed(a.this.iZq, 5000L);
                        }
                    });
                    a.this.iZm.start();
                }
            }
        };
        this.iZq = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.iZm.setFloatValues(l.getDimens(a.this.mContext, a.this.OF ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.iZm.removeAllListeners();
                a.this.iZm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.iZf.setVisibility(8);
                    }
                });
                a.this.iZm.start();
            }
        };
        csx();
        if (context instanceof PbActivity) {
            this.iZn = (e) y.b((PbActivity) context).l(e.class);
        }
        rN(true);
        this.jxp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.iZf = (PbVideoFullscreenAttentionLayout) this.jxm.findViewById(R.id.video_fullscreen_attention);
        this.iZg = (PbNextVideoLayout) this.jxm.findViewById(R.id.video_next_layout);
        this.iZh = (ImageView) this.jxm.findViewById(R.id.video_pre);
        this.iZi = (ImageView) this.jxm.findViewById(R.id.video_next);
        SvgManager.aEp().a(this.iZh, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aEp().a(this.iZi, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.Ow.aQz();
        this.Ow.setDrawCorner(false);
        this.iZf.setOnClickEvent(this);
        this.iZh.setOnClickListener(this);
        this.iZi.setOnClickListener(this);
        this.iZg.setOnClickListener(this);
        this.iWT = l.getEquipmentWidth(this.mContext) / 10;
        this.jxg.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void css() {
        this.jsG.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void qU(boolean z) {
        this.iZg.setIsCountDownValid(z);
    }

    public void aN(bj bjVar) {
        if (bjVar == null || bjVar.aAo() == null || aq.isEmpty(bjVar.aAo().video_url)) {
            if (this.jwV == this.jwP || this.jwV == this.STATE_PAUSE) {
                this.jwV &= -65537;
                zr(this.jwV);
            }
            this.jwP &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jwV == this.jwP || this.jwV == this.STATE_PAUSE) {
            this.jwV |= 65536;
            zr(this.jwV);
        }
        this.jwP |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aO(bj bjVar) {
        if (bjVar == null || bjVar.aAo() == null || aq.isEmpty(bjVar.aAo().video_url)) {
            if (this.jwV == this.jwP || this.jwV == this.STATE_PAUSE || this.jwV == this.jwR) {
                this.jwV &= -32769;
                this.jwV &= -131073;
                zr(this.jwV);
            }
            this.jwP &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jwR &= -131073;
            return;
        }
        if (this.jwV == this.jwP || this.jwV == this.STATE_PAUSE) {
            this.jwV |= 32768;
            zr(this.jwV);
        }
        if (this.jwV == this.jwR) {
            this.jwV |= 131072;
            zr(this.jwV);
        }
        this.jwP |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jwR |= 131072;
        this.iZg.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.OG = bjVar.getTid();
            yVar.fKa = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.iGA = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.iGA == 0) {
                        this.iGA = intent.getIntExtra("key_start_from", 0);
                    }
                    this.iGB = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.iGB)) {
                        yVar.cKN = this.iGB;
                    }
                    yVar.jvQ = Integer.toString(this.iGA);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jvQ = this.source;
                }
            }
            if (bjVar.aAo() != null) {
                yVar.jvS = bjVar.aAo().video_md5;
                yVar.jvU = String.valueOf(bjVar.aAo().is_vertical);
            }
            c(yVar);
            this.iZl = false;
            this.iZg.setIsCountDownValid(true);
            if (this.iBU && bjVar.aAo() != null) {
                if (this.OF != (bjVar.aAo().is_vertical.intValue() == 1)) {
                    cyk();
                }
            }
            super.setData(bjVar);
            rN(!this.OF);
            if (bjVar.azX() != null) {
                bjVar.azX().setIsLike(bjVar.azX().hadConcerned());
            }
            this.iZf.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cst() {
        super.cst();
        if (this.iBU) {
            csz();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.iZf.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iBU || motionEvent.getX() > ((float) this.iWT);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean csu() {
        return false;
    }

    public void csv() {
        this.iZk = false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean csw() {
        return !this.iZk && this.jxf.csE();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csx() {
        this.STATE_STOP &= -33;
        this.jwN &= -33;
        this.jwO &= -33;
        this.jwP &= -33;
        this.STATE_PAUSE &= -33;
        this.jwQ &= -33;
        this.jwR &= -33;
        this.jwS &= -33;
        this.jwT &= -33;
        this.STATE_STOP |= 1024;
        this.jwN |= 1024;
        this.jwO &= -1025;
        this.jwP |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jwQ |= 1024;
        this.jwR |= 1024;
        this.jwS |= 1024;
        this.jwT &= -1025;
        this.jwN |= 16384;
        this.jwQ |= 16384;
        this.jwR &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csy() {
        int i = 0;
        this.jxf.af(this.OF, this.iBU);
        this.jxg.af(this.OF, this.iBU);
        if (this.jxe instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jxe).af(this.OF, this.iBU);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jxd.getLayoutParams();
        int dimens = (this.iBU && this.OF) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iBU && !this.OF) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iZh.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iZi.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iBU || this.OF) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.iZg.af(this.OF, this.iBU);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zr(int i) {
        if (i != this.STATE_PAUSE && i != this.jwQ && i != this.jwP && i != this.jwN) {
            csC();
            if (this.iZf != null) {
                this.iZf.setVisibility(8);
            }
        }
        if (this.jwV != this.jwT && i == this.jwT) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZo);
            if ((this.jwV & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jwV & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jwT = i;
        }
        super.zr(i);
        if (!this.iBU) {
            this.jxh.setVisibility(8);
            this.jxi.setVisibility(8);
            if (this.iZn != null) {
                this.iZn.qR((i & 1024) > 0);
            }
        }
        if (this.jxe instanceof PbVideoMediaController) {
            this.jxe.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jxe).setBottomBarShow((i & 16384) > 0);
        }
        if (this.iZh != null) {
            this.iZh.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.iZi != null) {
            this.iZi.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.iZg != null) {
            boolean z = (131072 & i) > 0;
            this.iZg.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(zG("c13600"));
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void qV(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.iBU);
        }
        super.qV(z);
        csC();
        if (this.iBU) {
            csz();
        } else {
            this.iZf.setVisibility(8);
        }
    }

    private void csz() {
        if (!this.iZl && !this.iZf.csD()) {
            this.iZf.setTranslationX(0.0f);
            this.iZf.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.iZf.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.OF ? R.dimen.tbds248 : R.dimen.tbds428);
            this.iZm = ObjectAnimator.ofFloat(this.iZf, "translationX", 0.0f);
            this.iZm.setDuration(500);
            csC();
            com.baidu.adp.lib.f.e.gx().postDelayed(this.iZp, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean csA() {
        if (this.jwV == this.jwT) {
            return false;
        }
        this.jxj.setVisibility(0);
        this.jxj.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZo);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.iZo, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean csB() {
        if (this.jwV == this.jwT) {
            return false;
        }
        this.jxj.setVisibility(0);
        this.jxj.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZo);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.iZo, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                this.iZk = true;
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                csC();
                com.baidu.adp.lib.f.e.gx().post(this.iZq);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.iZn != null) {
                    this.iZn.qS(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.iZn != null) {
                    this.iZn.crV();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jwR &= -131073;
                this.jwV &= -131073;
                this.iZg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mJ(boolean z) {
        csC();
        this.iZf.setVisibility(8);
        if (z) {
            this.iZj = this.jwV;
            if (this.jwV == this.STATE_PAUSE || ((this.jwV == this.jwQ && !this.jsG.isPlaying()) || this.jwV == this.jwR)) {
                this.iZj |= 1;
            }
            stopPlay();
            return true;
        } else if (this.iZj == -1) {
            startPlay();
            return true;
        } else if (this.iZj == this.jwN || this.iZj == this.jwP) {
            startPlay();
            return true;
        } else {
            this.jxe.setCurrentDuration(x.cxW().GP(this.mVideoUrl), false);
            zr(this.iZj);
            return true;
        }
    }

    private an zG(String str) {
        an cp = new an(str).cp("tid", this.OG).s("fid", this.mFid).cp("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.baijiahaoData != null) {
            cp.cp("obj_param4", this.baijiahaoData.oriUgcNid);
            cp.cp("obj_param6", this.baijiahaoData.oriUgcVid);
            if (this.baijiahaoData.oriUgcType == 4) {
                cp.Z("obj_param5", 2);
            } else if (this.baijiahaoData.oriUgcType == 2) {
                cp.Z("obj_param5", 3);
            }
        } else {
            cp.Z("obj_param5", 1);
        }
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).ckc() != null) {
            cp.cp(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).ckc().cmZ()).cp("obj_id", ((PbActivity) this.mContext).ckc().cna()).cp("obj_source", ((PbActivity) this.mContext).ckc().cmY());
        }
        return cp;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void zs(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new an("c13598"));
            } else {
                TiebaStatic.log(new an("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(zG("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(zG("c13601").Z("obj_type", this.iZg.iYW ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csC() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZp);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZq);
    }

    public void onDestroy() {
        csC();
        rN(false);
    }

    public boolean bgb() {
        return this.OF;
    }
}
