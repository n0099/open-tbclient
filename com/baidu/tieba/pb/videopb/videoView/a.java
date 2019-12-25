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
/* loaded from: classes6.dex */
public class a extends d {
    private BaijiahaoData baijiahaoData;
    private int iCW;
    private String iCX;
    private int iTl;
    private ImageView iVA;
    private int iVB;
    private boolean iVC;
    private boolean iVD;
    private ObjectAnimator iVE;
    private e iVF;
    private Runnable iVG;
    private Runnable iVH;
    private Runnable iVI;
    private final int iVr;
    private final int iVs;
    private final int iVt;
    private final int iVu;
    private final int iVv;
    private final int iVw;
    private PbVideoFullscreenAttentionLayout iVx;
    private PbNextVideoLayout iVy;
    private ImageView iVz;
    private String source;

    public a(Context context, View view) {
        super(context, view);
        this.iVr = 16384;
        this.iVs = 32768;
        this.iVt = 65536;
        this.iVu = 131072;
        this.iVv = 5000;
        this.iVw = 1500;
        this.iVB = -1;
        this.iCW = 0;
        this.iVG = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.jtC.setVisibility(8);
            }
        };
        this.iVH = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iVx.cru()) {
                    Context context2 = a.this.mContext;
                    int i = a.this.OB ? R.dimen.tbds210 : R.dimen.tbds244;
                    a.this.iVD = true;
                    a.this.iVE.setFloatValues(-l.getDimens(context2, i));
                    a.this.iVE.removeAllListeners();
                    a.this.iVE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.crt();
                            com.baidu.adp.lib.f.e.gy().postDelayed(a.this.iVI, 5000L);
                        }
                    });
                    a.this.iVE.start();
                }
            }
        };
        this.iVI = new Runnable() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.iVE.setFloatValues(l.getDimens(a.this.mContext, a.this.OB ? R.dimen.tbds210 : R.dimen.tbds244));
                a.this.iVE.removeAllListeners();
                a.this.iVE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.videopb.videoView.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.iVx.setVisibility(8);
                    }
                });
                a.this.iVE.start();
            }
        };
        cro();
        if (context instanceof PbActivity) {
            this.iVF = (e) y.b((PbActivity) context).l(e.class);
        }
        rA(true);
        this.jtI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.iVx = (PbVideoFullscreenAttentionLayout) this.jtF.findViewById(R.id.video_fullscreen_attention);
        this.iVy = (PbNextVideoLayout) this.jtF.findViewById(R.id.video_next_layout);
        this.iVz = (ImageView) this.jtF.findViewById(R.id.video_pre);
        this.iVA = (ImageView) this.jtF.findViewById(R.id.video_next);
        SvgManager.aDW().a(this.iVz, R.drawable.ic_icon_pure_video_up44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        SvgManager.aDW().a(this.iVA, R.drawable.ic_icon_pure_video_down44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.Os.aQg();
        this.Os.setDrawCorner(false);
        this.iVx.setOnClickEvent(this);
        this.iVz.setOnClickListener(this);
        this.iVA.setOnClickListener(this);
        this.iVy.setOnClickListener(this);
        this.iTl = l.getEquipmentWidth(this.mContext) / 10;
        this.jtz.setShareFrom(18);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void crj() {
        this.jpa.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public int getLayoutR() {
        return R.layout.pb_operable_video_container;
    }

    public void qH(boolean z) {
        this.iVy.setIsCountDownValid(z);
    }

    public void aM(bj bjVar) {
        if (bjVar == null || bjVar.azV() == null || aq.isEmpty(bjVar.azV().video_url)) {
            if (this.jto == this.jti || this.jto == this.STATE_PAUSE) {
                this.jto &= -65537;
                zm(this.jto);
            }
            this.jti &= -65537;
            this.STATE_PAUSE &= -65537;
            return;
        }
        if (this.jto == this.jti || this.jto == this.STATE_PAUSE) {
            this.jto |= 65536;
            zm(this.jto);
        }
        this.jti |= 65536;
        this.STATE_PAUSE |= 65536;
    }

    public void aN(bj bjVar) {
        if (bjVar == null || bjVar.azV() == null || aq.isEmpty(bjVar.azV().video_url)) {
            if (this.jto == this.jti || this.jto == this.STATE_PAUSE || this.jto == this.jtk) {
                this.jto &= -32769;
                this.jto &= -131073;
                zm(this.jto);
            }
            this.jti &= -32769;
            this.STATE_PAUSE &= -32769;
            this.jtk &= -131073;
            return;
        }
        if (this.jto == this.jti || this.jto == this.STATE_PAUSE) {
            this.jto |= 32768;
            zm(this.jto);
        }
        if (this.jto == this.jtk) {
            this.jto |= 131072;
            zm(this.jto);
        }
        this.jti |= 32768;
        this.STATE_PAUSE |= 32768;
        this.jtk |= 131072;
        this.iVy.setDate(bjVar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.baijiahaoData = bjVar.getBaijiahaoData();
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "6";
            yVar.OC = bjVar.getTid();
            yVar.fGQ = Long.toString(bjVar.getFid());
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.mContext instanceof BaseFragmentActivity) {
                Intent intent = ((BaseFragmentActivity) this.mContext).getIntent();
                if (bjVar.isBjh()) {
                    this.iCW = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                    if (this.iCW == 0) {
                        this.iCW = intent.getIntExtra("key_start_from", 0);
                    }
                    this.iCX = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                    if (!StringUtils.isNull(this.iCX)) {
                        yVar.cKC = this.iCX;
                    }
                    yVar.jsk = Integer.toString(this.iCW);
                } else {
                    this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                    yVar.jsk = this.source;
                }
            }
            if (bjVar.azV() != null) {
                yVar.jsl = bjVar.azV().video_md5;
                yVar.jsn = String.valueOf(bjVar.azV().is_vertical);
            }
            c(yVar);
            this.iVD = false;
            this.iVy.setIsCountDownValid(true);
            if (this.iyq && bjVar.azV() != null) {
                if (this.OB != (bjVar.azV().is_vertical.intValue() == 1)) {
                    cxb();
                }
            }
            super.setData(bjVar);
            rA(!this.OB);
            if (bjVar.azE() != null) {
                bjVar.azE().setIsLike(bjVar.azE().hadConcerned());
            }
            this.iVx.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void crk() {
        super.crk();
        if (this.iyq) {
            crq();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.iVx.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean E(MotionEvent motionEvent) {
        return this.iyq || motionEvent.getX() > ((float) this.iTl);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean crl() {
        return false;
    }

    public void crm() {
        this.iVC = false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean crn() {
        return !this.iVC && this.jty.crv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cro() {
        this.STATE_STOP &= -33;
        this.jtg &= -33;
        this.jth &= -33;
        this.jti &= -33;
        this.STATE_PAUSE &= -33;
        this.jtj &= -33;
        this.jtk &= -33;
        this.jtl &= -33;
        this.jtm &= -33;
        this.STATE_STOP |= 1024;
        this.jtg |= 1024;
        this.jth &= -1025;
        this.jti |= 1024;
        this.STATE_PAUSE |= 1024;
        this.jtj |= 1024;
        this.jtk |= 1024;
        this.jtl |= 1024;
        this.jtm &= -1025;
        this.jtg |= 16384;
        this.jtj |= 16384;
        this.jtk &= -2;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void crp() {
        int i = 0;
        this.jty.af(this.OB, this.iyq);
        this.jtz.af(this.OB, this.iyq);
        if (this.jtx instanceof PbVideoMediaController) {
            ((PbVideoMediaController) this.jtx).af(this.OB, this.iyq);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jtw.getLayoutParams();
        int dimens = (this.iyq && this.OB) ? l.getDimens(this.mContext, R.dimen.tbds42) : 0;
        if (this.iyq && !this.OB) {
            i = l.getDimens(this.mContext, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = dimens;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iVz.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iVA.getLayoutParams();
        int dimens2 = l.getDimens(this.mContext, (!this.iyq || this.OB) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = dimens2;
        layoutParams2.rightMargin = dimens2;
        this.iVy.af(this.OB, this.iyq);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void zm(int i) {
        if (i != this.STATE_PAUSE && i != this.jtj && i != this.jti && i != this.jtg) {
            crt();
            if (this.iVx != null) {
                this.iVx.setVisibility(8);
            }
        }
        if (this.jto != this.jtm && i == this.jtm) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iVG);
            if ((this.jto & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((this.jto & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.jtm = i;
        }
        super.zm(i);
        if (!this.iyq) {
            this.jtA.setVisibility(8);
            this.jtB.setVisibility(8);
            if (this.iVF != null) {
                this.iVF.qE((i & 1024) > 0);
            }
        }
        if (this.jtx instanceof PbVideoMediaController) {
            this.jtx.setVisibility(((i & 16384) > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.jtx).setBottomBarShow((i & 16384) > 0);
        }
        if (this.iVz != null) {
            this.iVz.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        if (this.iVA != null) {
            this.iVA.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.iVy != null) {
            boolean z = (131072 & i) > 0;
            this.iVy.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(zw("c13600"));
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void qI(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.iyq);
        }
        super.qI(z);
        crt();
        if (this.iyq) {
            crq();
        } else {
            this.iVx.setVisibility(8);
        }
    }

    private void crq() {
        if (!this.iVD && !this.iVx.cru()) {
            this.iVx.setTranslationX(0.0f);
            this.iVx.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.iVx.getLayoutParams()).bottomMargin = l.getDimens(this.mContext, this.OB ? R.dimen.tbds248 : R.dimen.tbds428);
            this.iVE = ObjectAnimator.ofFloat(this.iVx, "translationX", 0.0f);
            this.iVE.setDuration(500);
            crt();
            com.baidu.adp.lib.f.e.gy().postDelayed(this.iVH, 5000L);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean crr() {
        if (this.jto == this.jtm) {
            return false;
        }
        this.jtC.setVisibility(0);
        this.jtC.c(this.mContext, true, 10);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iVG);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.iVG, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public boolean crs() {
        if (this.jto == this.jtm) {
            return false;
        }
        this.jtC.setVisibility(0);
        this.jtC.c(this.mContext, false, 10);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iVG);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.iVG, 1500L);
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.play) {
                this.iVC = true;
            }
            super.onClick(view);
            if (id == R.id.concern_video_info_item) {
                crt();
                com.baidu.adp.lib.f.e.gy().post(this.iVI);
            } else if (id == R.id.video_next || id == R.id.video_next_layout) {
                if (this.iVF != null) {
                    this.iVF.qF(id == R.id.video_next_layout);
                }
                if (id == R.id.video_next) {
                    TiebaStatic.log(new an("c13595"));
                }
            } else if (id == R.id.video_pre) {
                if (this.iVF != null) {
                    this.iVF.cqM();
                }
                TiebaStatic.log(new an("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.jtk &= -131073;
                this.jto &= -131073;
                this.iVy.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean my(boolean z) {
        crt();
        this.iVx.setVisibility(8);
        if (z) {
            this.iVB = this.jto;
            if (this.jto == this.STATE_PAUSE || ((this.jto == this.jtj && !this.jpa.isPlaying()) || this.jto == this.jtk)) {
                this.iVB |= 1;
            }
            stopPlay();
            return true;
        } else if (this.iVB == -1) {
            startPlay();
            return true;
        } else if (this.iVB == this.jtg || this.iVB == this.jti) {
            startPlay();
            return true;
        } else {
            this.jtx.setCurrentDuration(x.cwN().GF(this.mVideoUrl), false);
            zm(this.iVB);
            return true;
        }
    }

    private an zw(String str) {
        an cp = new an(str).cp("tid", this.OC).s("fid", this.mFid).cp("uid", TbadkCoreApplication.getCurrentAccount());
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
        if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).ciU() != null) {
            cp.cp(TiebaInitialize.Params.AB_TAG, ((PbActivity) this.mContext).ciU().clR()).cp("obj_id", ((PbActivity) this.mContext).ciU().clS()).cp("obj_source", ((PbActivity) this.mContext).ciU().clQ());
        }
        return cp;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void zn(int i) {
        if (i == R.id.video_full_screen) {
            if (!isFullScreen()) {
                TiebaStatic.log(new an("c13598"));
            } else {
                TiebaStatic.log(new an("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(zw("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new an("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new an("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(zw("c13601").Z("obj_type", this.iVy.iVo ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crt() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iVH);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iVI);
    }

    public void onDestroy() {
        crt();
        rA(false);
    }

    public boolean bfB() {
        return this.OB;
    }
}
