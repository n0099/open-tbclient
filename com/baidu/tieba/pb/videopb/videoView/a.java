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
    private int iWO;
    private final int iYU;
    private final int iYV;
    private final int iYW;
    private final int iYX;
    private final int iYY;
    private final int iYZ;
    private PbVideoFullscreenAttentionLayout iZa;
    private PbNextVideoLayout iZb;
    private ImageView iZc;
    private ImageView iZd;
    private int iZe;
    private boolean iZf;
    private boolean iZg;
    private ObjectAnimator iZh;
    private e iZi;
    private Runnable iZj;
    private Runnable iZk;
    private Runnable iZl;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.iYU = 16384;
        this.iYV = 32768;
        this.iYW = 65536;
        this.iYX = 131072;
        this.iYY = 5000;
        this.iYZ = 1500;
        this.iZe = -1;
        this.iGA = 0;
        this.iZj = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jxe.setVisibility(8);
            }
        };
        this.iZk = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iZa.csB()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.OF ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.iZg = true;
                    a.this.iZh.setFloatValues(-l.getDimens(context2, i));
                    a.this.iZh.removeAllListeners();
                    a.this.iZh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.csA();
                            com.baidu.adp.lib.f.e.gx().postDelayed(a.this.iZl, 5000L);
                        }
                    });
                    a.this.iZh.start();
                }
            }
        };
        this.iZl = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.iZh.setFloatValues(l.getDimens(a.this.mContext, a.this.OF ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.iZh.removeAllListeners();
                a.this.iZh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.iZa.setVisibility(8);
                    }
                });
                a.this.iZh.start();
            }
        };
        csv();
        if (context instanceof PbActivity) {
            this.iZi = (e) y.b((PbActivity) context).l(e.class);
        }
        rN(true);
        this.jxk = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.iZa = (PbVideoFullscreenAttentionLayout) this.jxh.findViewById(R.id.video_fullscreen_attention);
        this.iZb = (PbNextVideoLayout) this.jxh.findViewById(R.id.video_next_layout);
        this.iZc = (ImageView) this.jxh.findViewById(R.id.video_pre);
        this.iZd = (ImageView) this.jxh.findViewById(R.id.video_next);
        SvgManager.aEp().a(this.iZc, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aEp().a(this.iZd, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.Ow.aQz();
        this.Ow.setDrawCorner(false);
        this.iZa.setOnClickEvent(this);
        this.iZc.setOnClickListener(this);
        this.iZd.setOnClickListener(this);
        this.iZb.setOnClickListener(this);
        this.iWO = l.getEquipmentWidth(this.mContext) / 10;
        this.jxb.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void csq() {
        this.jsB.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void qU(boolean z) {
        this.iZb.setIsCountDownValid(z);
    }

    public void aN(bj bjVar) {
        if (bjVar == null || bjVar.aAo() == null || aq.isEmpty(bjVar.aAo().video_url)) {
            if (this.jwQ == this.jwK || this.jwQ == this.STATE_PAUSE) {
                this.jwQ &= -65537;
                zr(this.jwQ);
            }
            this.jwK &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jwQ == this.jwK || this.jwQ == this.STATE_PAUSE) {
            this.jwQ |= 65536;
            zr(this.jwQ);
        }
        this.jwK |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aO(bj bjVar) {
        if (bjVar == null || bjVar.aAo() == null || aq.isEmpty(bjVar.aAo().video_url)) {
            if (this.jwQ == this.jwK || this.jwQ == this.STATE_PAUSE || this.jwQ == this.jwM) {
                this.jwQ &= -32769;
                this.jwQ &= -131073;
                zr(this.jwQ);
            }
            this.jwK &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jwM &= -131073;
            return;
        }
        if (this.jwQ == this.jwK || this.jwQ == this.STATE_PAUSE) {
            this.jwQ |= 32768;
            zr(this.jwQ);
        }
        if (this.jwQ == this.jwM) {
            this.jwQ |= 131072;
            zr(this.jwQ);
        }
        this.jwK |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jwM |= 131072;
        this.iZb.setDate(bjVar);
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
                    yVar.jvL = Integer.toString(this.iGA);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jvL = this.source;
                }
            }
            if (bjVar.aAo() != null) {
                yVar.jvN = bjVar.aAo().video_md5;
                yVar.jvP = String.valueOf(bjVar.aAo().is_vertical);
            }
            c(yVar);
            this.iZg = false;
            this.iZb.setIsCountDownValid(true);
            if (this.iBU && bjVar.aAo() != null) {
                if (this.OF != (bjVar.aAo().is_vertical.intValue() == 1)) {
                    cyi();
                }
            }
            super.setData(bjVar);
            rN(!this.OF);
            if (bjVar.azX() != null) {
                bjVar.azX().setIsLike(bjVar.azX().hadConcerned());
            }
            this.iZa.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csr() {
        super.csr();
        if (this.iBU) {
            csx();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.iZa.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iBU || motionEvent.getX() > ((float) this.iWO);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean css() {
        return false;
    }

    public void cst() {
        this.iZf = false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean csu() {
        return !this.iZf && this.jxa.csC();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csv() {
        this.STATE_STOP &= -33;
        this.jwI &= -33;
        this.jwJ &= -33;
        this.jwK &= -33;
        this.STATE_PAUSE &= -33;
        this.jwL &= -33;
        this.jwM &= -33;
        this.jwN &= -33;
        this.jwO &= -33;
        this.STATE_STOP |= 1024;
        this.jwI |= 1024;
        this.jwJ &= -1025;
        this.jwK |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jwL |= 1024;
        this.jwM |= 1024;
        this.jwN |= 1024;
        this.jwO &= -1025;
        this.jwI |= 16384;
        this.jwL |= 16384;
        this.jwM &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csw() {
        int i = 0;
        this.jxa.af(this.OF, this.iBU);
        this.jxb.af(this.OF, this.iBU);
        if (this.jwZ instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jwZ).af(this.OF, this.iBU);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jwY.getLayoutParams();
        int dimens = (this.iBU && this.OF) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iBU && !this.OF) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iZc.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iZd.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iBU || this.OF) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.iZb.af(this.OF, this.iBU);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zr(int i) {
        if (i != this.STATE_PAUSE && i != this.jwL && i != this.jwK && i != this.jwI) {
            csA();
            if (this.iZa != null) {
                this.iZa.setVisibility(8);
            }
        }
        if (this.jwQ != this.jwO && i == this.jwO) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZj);
            if ((this.jwQ & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jwQ & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jwO = i;
        }
        super.zr(i);
        if (!this.iBU) {
            this.jxc.setVisibility(8);
            this.jxd.setVisibility(8);
            if (this.iZi != null) {
                this.iZi.qR((i & 1024) > 0);
            }
        }
        if (this.jwZ instanceof PbVideoMediaController) {
            this.jwZ.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jwZ).setBottomBarShow((i & 16384) > 0);
        }
        if (this.iZc != null) {
            this.iZc.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.iZd != null) {
            this.iZd.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.iZb != null) {
            boolean z = (131072 & i) > 0;
            this.iZb.setVisibility(z ? 0 : 8);
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
        csA();
        if (this.iBU) {
            csx();
        } else {
            this.iZa.setVisibility(8);
        }
    }

    private void csx() {
        if (!this.iZg && !this.iZa.csB()) {
            this.iZa.setTranslationX(0.0f);
            this.iZa.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.iZa.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.OF ? R.dimen.tbds248 : R.dimen.tbds428);
            this.iZh = ObjectAnimator.ofFloat(this.iZa, "translationX", 0.0f);
            this.iZh.setDuration(500);
            csA();
            com.baidu.adp.lib.f.e.gx().postDelayed(this.iZk, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean csy() {
        if (this.jwQ == this.jwO) {
            return false;
        }
        this.jxe.setVisibility(0);
        this.jxe.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZj);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.iZj, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean csz() {
        if (this.jwQ == this.jwO) {
            return false;
        }
        this.jxe.setVisibility(0);
        this.jxe.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZj);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.iZj, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                this.iZf = true;
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                csA();
                com.baidu.adp.lib.f.e.gx().post(this.iZl);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.iZi != null) {
                    this.iZi.qS(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.iZi != null) {
                    this.iZi.crT();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jwM &= -131073;
                this.jwQ &= -131073;
                this.iZb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mJ(boolean z) {
        csA();
        this.iZa.setVisibility(8);
        if (z) {
            this.iZe = this.jwQ;
            if (this.jwQ == this.STATE_PAUSE || ((this.jwQ == this.jwL && !this.jsB.isPlaying()) || this.jwQ == this.jwM)) {
                this.iZe |= 1;
            }
            stopPlay();
            return true;
        } else if (this.iZe == -1) {
            startPlay();
            return true;
        } else if (this.iZe == this.jwI || this.iZe == this.jwK) {
            startPlay();
            return true;
        } else {
            this.jwZ.setCurrentDuration(x.cxU().GP(this.mVideoUrl), false);
            zr(this.iZe);
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
            TiebaStatic.log(zG("c13601").Z("obj_type", this.iZb.iYR ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csA() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZk);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iZl);
    }

    public void onDestroy() {
        csA();
        rN(false);
    }

    public boolean bgb() {
        return this.OF;
    }
}
