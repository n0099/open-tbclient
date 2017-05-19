package com.baidu.tieba.pb.video;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.ab;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.au;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.c;
import com.baidu.tieba.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class g {
    private aj aSM;
    private PbActivity efF;
    private FrameLayout emJ;
    private int emK;
    private com.baidu.tieba.play.c emO;
    private c.InterfaceC0076c esL;
    private com.baidu.tieba.pb.pb.main.view.f esM;
    private bb esO;
    private bk esP;
    private bk esQ;
    private String esR;
    private c.InterfaceC0076c esU;
    private ValueAnimator esV;
    private Handler mHandler;
    private String nameShow;
    private String mVideoUrl = null;
    private VideoInfo esN = null;
    private boolean esS = false;
    private int esT = 0;
    private boolean esW = true;
    private Animation.AnimationListener drq = new h(this);
    private au.a duf = new l(this);
    private c.e esX = new m(this);

    public g(PbActivity pbActivity, com.baidu.tieba.play.c cVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.f fVar, int i) {
        this.efF = pbActivity;
        this.emO = cVar;
        this.esM = fVar;
        this.emJ = frameLayout;
        this.emK = i;
        if (this.emO != null) {
            this.emO.ke(true);
        }
        init();
    }

    private void init() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.efF.getActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.esL == null) {
            this.esL = new n(this, loadAnimation);
        }
        a(this.esL);
        this.esT = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds98);
        this.mHandler = new Handler();
    }

    public void aNC() {
        if (this.esM != null) {
            this.nameShow = this.esM.eqa.getText().toString();
        }
    }

    public void a(VideoInfo videoInfo, bk bkVar, String str) {
        if (videoInfo != null && this.emO != null && bkVar != null) {
            this.esN = videoInfo;
            this.esP = bkVar;
            this.mVideoUrl = videoInfo.video_url;
            this.emO.stopPlay();
            this.emO.kd(true);
            this.aSM = new aj(this.efF.getActivity());
            this.esO = new bb();
            this.esO.mLocate = "pb";
            this.esO.bti = bkVar.getTid();
            this.esO.btj = str;
            this.esO.mUid = TbadkCoreApplication.getCurrentAccount();
            this.esO.mSource = bkVar.YQ;
            this.esO.eTu = bkVar.YR;
            this.esO.eTv = this.efF.aIK();
            if (bkVar.sC() != null && bkVar.sC().channelId > 0) {
                this.esO.Vk = new StringBuilder(String.valueOf(bkVar.sC().channelId)).toString();
            } else {
                this.esO.Vk = "0";
            }
            this.esO.eTw = bkVar.YS;
            this.aSM.a(this.esO);
            this.emO.Ku().setBusiness(this.aSM);
            if (this.emO.awv()) {
                this.emO.awt();
            }
            this.emO.b(this.esU);
            if (this.emO != null) {
                this.emO.nZ(this.esR);
            }
            this.esR = null;
            this.esQ = null;
            this.emO.nZ(this.esR);
            this.emO.awp().setOnDragingListener(this.duf);
            this.emO.a(new o(this));
            this.emO.a(new q(this));
            this.emO.a(new r(this));
            this.emO.a(new s(this));
            this.emO.a(new t(this));
            this.emO.lC(videoInfo.thumbnail_url);
            this.emO.bB(videoInfo.play_count.intValue());
            this.emO.setVideoUrl(this.mVideoUrl);
            this.emO.oR(bkVar.getTitle());
            this.emO.a(this.esX);
            this.emO.ajb();
            this.emO.show();
        }
    }

    public void a(c.InterfaceC0076c interfaceC0076c) {
        this.esU = interfaceC0076c;
    }

    public void K(bk bkVar) {
        this.esQ = bkVar;
    }

    public void nZ(String str) {
        this.esR = str;
        if (this.emO != null) {
            this.emO.nZ(this.esR);
        }
    }

    public void startPlay() {
        if (this.emO != null) {
            this.emO.oQ(this.mVideoUrl);
        }
        aNJ();
        JU();
    }

    public void destroy() {
        if (this.emO != null) {
            this.emO.destroy();
        }
        if (this.emJ != null) {
            this.emJ.clearAnimation();
        }
        if (this.esV != null) {
            this.esV.cancel();
            this.esV = null;
        }
    }

    public void onPause() {
        if (this.emO != null) {
            if (this.emO.aWm()) {
                this.esS = true;
                this.emO.pausePlay();
            } else if (this.emO.aWs() == 3) {
                this.esS = false;
            } else {
                this.esS = false;
                this.emO.pausePlay();
            }
        }
    }

    public void onResume() {
        if (this.emO != null && this.esS) {
            this.emO.awy();
            aNJ();
        }
    }

    public boolean oq(int i) {
        if (this.emO == null) {
            return false;
        }
        return this.emO.qt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        if (this.esN != null) {
            ab.a(this.esN.video_md5, "", "1", this.esO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aND() {
        this.esW = true;
    }

    public void aMt() {
        if (this.esM != null) {
            this.esM.aMt();
        }
    }

    public void aMs() {
        if (this.esM != null) {
            this.esM.aMs();
        }
    }

    public void or(int i) {
        if (this.esM != null) {
            this.esM.or(i);
            if (this.emO != null) {
                if (this.emO.aWm() || this.emO.aWs() == 0) {
                    this.esM.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            }
        }
    }

    public void aNE() {
        B(-this.emK, true);
    }

    public void aNF() {
        aNG();
    }

    public void aNG() {
        B(((RelativeLayout.LayoutParams) this.emJ.getLayoutParams()).topMargin, false);
    }

    public void B(int i, boolean z) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, 0);
        ofInt.addUpdateListener(new i(this));
        ofInt.addListener(new j(this, z));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    private void aNH() {
        this.esV = ValueAnimator.ofInt(0, -this.emK);
        this.esV.addUpdateListener(new k(this));
        this.esV.setDuration(300L);
        this.esV.start();
    }

    public void a(AbsListView absListView, int i, TextView textView) {
        if (i == 1) {
            int i2 = ((RelativeLayout.LayoutParams) this.emJ.getLayoutParams()).topMargin;
            boolean z = this.emO.aWs() == 1 || this.emO.aWs() == 0;
            if (absListView.getChildCount() > 0 && absListView.getChildAt(0) != textView && i2 == 0 && !z) {
                aNH();
            }
        }
    }

    public void b(AbsListView absListView, int i, TextView textView) {
        if (absListView.getChildCount() > i && this.esW) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emJ.getLayoutParams();
            if (this.emO.aWs() == 1 || this.emO.aWs() == 0) {
                layoutParams.topMargin = 0;
                this.emJ.setLayoutParams(layoutParams);
                return;
            }
            float y = textView.getY();
            if (absListView.getChildAt(i) == textView) {
                layoutParams.topMargin = (int) y;
                this.emJ.setLayoutParams(layoutParams);
                if (this.esV != null) {
                    this.esV.cancel();
                }
            } else {
                layoutParams.topMargin = -this.emK;
                this.emJ.setLayoutParams(layoutParams);
            }
            ox(this.emK - Math.abs(layoutParams.topMargin));
            aNK();
        }
    }

    private void ox(int i) {
        if (this.emO.aWs() == 3) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 3));
            }
        } else if (this.emO.aWs() == 2) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 2));
            }
        } else if (this.emO.aWs() == 5 && i == 0) {
            TiebaStatic.log(new as("c11996").s("obj_type", 2));
        }
        if (this.emK == i) {
            TiebaStatic.log(new as("c11997").s("obj_type", 2));
        }
    }

    public void aNI() {
        TiebaStatic.log(new as("c11997").s("obj_type", 1));
        aNE();
    }

    public void aNJ() {
        if (this.emJ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emJ.getLayoutParams();
            layoutParams.topMargin = 0;
            this.emJ.setLayoutParams(layoutParams);
            aNK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNK() {
        int abs = this.emK - Math.abs(((RelativeLayout.LayoutParams) this.emJ.getLayoutParams()).topMargin);
        oA(abs);
        oz(abs);
        oB(abs);
        oC(abs);
        oy(abs);
    }

    private void oy(int i) {
        if (i < this.esT * 2) {
            this.emO.aWq();
        } else if (this.emO.awq().getVisibility() != 0 && this.emO.aWs() != 3 && this.emO.aWs() != 0) {
            this.emO.aWp();
        }
    }

    private void oz(int i) {
        if (i < this.esT) {
            if (this.esM.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.esM.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.esM.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.esT && i <= this.esT * 2) {
            float f = 1.0f - (((i - this.esT) * 1.0f) / this.esT);
            this.esM.mNavigationBar.getBarBgView().setAlpha(f);
            this.esM.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.esT * 2 && this.esM.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.esM.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.esM.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void oA(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (i < this.esT) {
                if (com.baidu.tbadk.core.util.au.dy(this.nameShow) > 10) {
                    String d = com.baidu.tbadk.core.util.au.d(this.nameShow, 10, "...");
                    String string = this.efF.getPageContext().getString(w.l.bar);
                    if (d.lastIndexOf(string) == -1) {
                        d = String.valueOf(d) + string;
                    }
                    this.esM.eqa.setText(d);
                } else {
                    this.esM.eqa.setText(this.nameShow);
                }
                this.esM.iK(true);
                this.esM.eqc.setVisibility(0);
                return;
            }
            this.esM.eqa.setText(this.nameShow);
        }
    }

    private void oB(int i) {
        if (i < this.esT) {
            this.esM.aMq().setVisibility(0);
        } else {
            this.esM.aMq().setVisibility(8);
        }
    }

    private void oC(int i) {
        if (i < this.esT) {
            if (this.emO != null) {
                this.emO.ke(false);
            }
        } else if (this.emO != null) {
            this.emO.ke(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNL() {
        return this.emJ != null && ((RelativeLayout.LayoutParams) this.emJ.getLayoutParams()).topMargin == 0;
    }

    public void aNM() {
        if (this.emO != null) {
            this.emO.aNM();
        }
    }
}
