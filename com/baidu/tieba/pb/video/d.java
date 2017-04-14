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
import com.baidu.tbadk.core.data.bi;
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
public class d {
    private aj aSp;
    private PbActivity eig;
    private FrameLayout eoM;
    private int eoN;
    private com.baidu.tieba.play.c eoR;
    private c.InterfaceC0070c euL;
    private com.baidu.tieba.pb.pb.main.view.f euM;
    private bb euO;
    private bi euP;
    private bi euQ;
    private String euR;
    private c.InterfaceC0070c euU;
    private ValueAnimator euV;
    private Handler mHandler;
    private String nameShow;
    private String mVideoUrl = null;
    private VideoInfo euN = null;
    private boolean euS = false;
    private int euT = 0;
    private boolean euW = true;
    private Animation.AnimationListener duR = new e(this);
    private au.a dxA = new i(this);
    private c.e euX = new j(this);

    public d(PbActivity pbActivity, com.baidu.tieba.play.c cVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.f fVar, int i) {
        this.eig = pbActivity;
        this.eoR = cVar;
        this.euM = fVar;
        this.eoM = frameLayout;
        this.eoN = i;
        if (this.eoR != null) {
            this.eoR.kn(true);
        }
        init();
    }

    private void init() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eig.getActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.euL == null) {
            this.euL = new k(this, loadAnimation);
        }
        a(this.euL);
        this.euT = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eig.getActivity(), w.f.ds98);
        this.mHandler = new Handler();
    }

    public void aPk() {
        if (this.euM != null) {
            this.nameShow = this.euM.esf.getText().toString();
        }
    }

    public void a(VideoInfo videoInfo, bi biVar, String str) {
        if (videoInfo != null && this.eoR != null && biVar != null) {
            this.euN = videoInfo;
            this.euP = biVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eoR.stopPlay();
            this.eoR.km(true);
            this.aSp = new aj(this.eig.getActivity());
            this.euO = new bb();
            this.euO.mLocate = "pb";
            this.euO.bqu = biVar.getTid();
            this.euO.bqv = str;
            this.euO.mUid = TbadkCoreApplication.getCurrentAccount();
            this.euO.mSource = biVar.Zx;
            this.euO.eVd = biVar.Zz;
            this.euO.eVe = biVar.Zy;
            this.euO.eVf = this.eig.aKo();
            if (biVar.ts() != null && biVar.ts().channelId > 0) {
                this.euO.VP = new StringBuilder(String.valueOf(biVar.ts().channelId)).toString();
            } else {
                this.euO.VP = "0";
            }
            this.aSp.a(this.euO);
            this.eoR.Lg().setBusiness(this.aSp);
            if (this.eoR.ayx()) {
                this.eoR.ayv();
            }
            this.eoR.b(this.euU);
            if (this.eoR != null) {
                this.eoR.nS(this.euR);
            }
            this.euR = null;
            this.euQ = null;
            this.eoR.nS(this.euR);
            this.eoR.ayr().setOnDragingListener(this.dxA);
            this.eoR.a(new l(this));
            this.eoR.a(new n(this));
            this.eoR.a(new o(this));
            this.eoR.a(new p(this));
            this.eoR.a(new q(this));
            this.eoR.lx(videoInfo.thumbnail_url);
            this.eoR.bQ(videoInfo.play_count.intValue());
            this.eoR.setVideoUrl(this.mVideoUrl);
            this.eoR.oS(biVar.getTitle());
            this.eoR.a(this.euX);
            this.eoR.alk();
            this.eoR.show();
        }
    }

    public void a(c.InterfaceC0070c interfaceC0070c) {
        this.euU = interfaceC0070c;
    }

    public void G(bi biVar) {
        this.euQ = biVar;
    }

    public void nS(String str) {
        this.euR = str;
        if (this.eoR != null) {
            this.eoR.nS(this.euR);
        }
    }

    public void startPlay() {
        if (this.eoR != null) {
            this.eoR.oR(this.mVideoUrl);
        }
        aPr();
        KG();
    }

    public void destroy() {
        if (this.eoR != null) {
            this.eoR.destroy();
        }
        if (this.eoM != null) {
            this.eoM.clearAnimation();
        }
        if (this.euV != null) {
            this.euV.cancel();
            this.euV = null;
        }
    }

    public void onPause() {
        if (this.eoR != null) {
            if (this.eoR.aXM()) {
                this.euS = true;
                this.eoR.pausePlay();
            } else if (this.eoR.aXS() == 3) {
                this.euS = false;
            } else {
                this.euS = false;
                this.eoR.pausePlay();
            }
        }
    }

    public void onResume() {
        if (this.eoR != null && this.euS) {
            this.eoR.ayA();
            aPr();
        }
    }

    public boolean ot(int i) {
        if (this.eoR == null) {
            return false;
        }
        return this.eoR.qv(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.euN != null) {
            ab.a(this.euN.video_md5, "", "1", this.euO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPl() {
        this.euW = true;
    }

    public void aOd() {
        if (this.euM != null) {
            this.euM.aOd();
        }
    }

    public void aOc() {
        if (this.euM != null) {
            this.euM.aOc();
        }
    }

    public void ov(int i) {
        if (this.euM != null) {
            this.euM.ov(i);
            if (this.eoR != null) {
                if (this.eoR.aXM() || this.eoR.aXS() == 0) {
                    this.euM.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            }
        }
    }

    public void aPm() {
        C(-this.eoN, true);
    }

    public void aPn() {
        aPo();
    }

    public void aPo() {
        C(((RelativeLayout.LayoutParams) this.eoM.getLayoutParams()).topMargin, false);
    }

    public void C(int i, boolean z) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, 0);
        ofInt.addUpdateListener(new f(this));
        ofInt.addListener(new g(this, z));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    private void aPp() {
        this.euV = ValueAnimator.ofInt(0, -this.eoN);
        this.euV.addUpdateListener(new h(this));
        this.euV.setDuration(300L);
        this.euV.start();
    }

    public void a(AbsListView absListView, int i, TextView textView) {
        if (i == 1) {
            int i2 = ((RelativeLayout.LayoutParams) this.eoM.getLayoutParams()).topMargin;
            boolean z = this.eoR.aXS() == 1 || this.eoR.aXS() == 0;
            if (absListView.getChildCount() > 0 && absListView.getChildAt(0) != textView && i2 == 0 && !z) {
                aPp();
            }
        }
    }

    public void b(AbsListView absListView, int i, TextView textView) {
        if (absListView.getChildCount() > i && this.euW) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eoM.getLayoutParams();
            if (this.eoR.aXS() == 1 || this.eoR.aXS() == 0) {
                layoutParams.topMargin = 0;
                this.eoM.setLayoutParams(layoutParams);
                return;
            }
            float y = textView.getY();
            if (absListView.getChildAt(i) == textView) {
                layoutParams.topMargin = (int) y;
                this.eoM.setLayoutParams(layoutParams);
                if (this.euV != null) {
                    this.euV.cancel();
                }
            } else {
                layoutParams.topMargin = -this.eoN;
                this.eoM.setLayoutParams(layoutParams);
            }
            oB(this.eoN - Math.abs(layoutParams.topMargin));
            aPs();
        }
    }

    private void oB(int i) {
        if (this.eoR.aXS() == 3) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 3));
            }
        } else if (this.eoR.aXS() == 2) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 2));
            }
        } else if (this.eoR.aXS() == 5 && i == 0) {
            TiebaStatic.log(new as("c11996").s("obj_type", 2));
        }
        if (this.eoN == i) {
            TiebaStatic.log(new as("c11997").s("obj_type", 2));
        }
    }

    public void aPq() {
        TiebaStatic.log(new as("c11997").s("obj_type", 1));
        aPm();
    }

    public void aPr() {
        if (this.eoM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eoM.getLayoutParams();
            layoutParams.topMargin = 0;
            this.eoM.setLayoutParams(layoutParams);
            aPs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPs() {
        int abs = this.eoN - Math.abs(((RelativeLayout.LayoutParams) this.eoM.getLayoutParams()).topMargin);
        oE(abs);
        oD(abs);
        oF(abs);
        oG(abs);
        oC(abs);
    }

    private void oC(int i) {
        if (i < this.euT * 2) {
            this.eoR.aXQ();
        } else if (this.eoR.ays().getVisibility() != 0 && this.eoR.aXS() != 3 && this.eoR.aXS() != 0) {
            this.eoR.aXP();
        }
    }

    private void oD(int i) {
        if (i < this.euT) {
            if (this.euM.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.euM.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.euM.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.euT && i <= this.euT * 2) {
            float f = 1.0f - (((i - this.euT) * 1.0f) / this.euT);
            this.euM.mNavigationBar.getBarBgView().setAlpha(f);
            this.euM.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.euT * 2 && this.euM.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.euM.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.euM.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void oE(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (i < this.euT) {
                if (com.baidu.tbadk.core.util.au.dA(this.nameShow) > 10) {
                    String d = com.baidu.tbadk.core.util.au.d(this.nameShow, 10, "...");
                    String string = this.eig.getPageContext().getString(w.l.bar);
                    if (d.lastIndexOf(string) == -1) {
                        d = String.valueOf(d) + string;
                    }
                    this.euM.esf.setText(d);
                } else {
                    this.euM.esf.setText(this.nameShow);
                }
                this.euM.iV(true);
                this.euM.esh.setVisibility(0);
                return;
            }
            this.euM.esf.setText(this.nameShow);
        }
    }

    private void oF(int i) {
        if (i < this.euT) {
            this.euM.aOa().setVisibility(0);
        } else {
            this.euM.aOa().setVisibility(8);
        }
    }

    private void oG(int i) {
        if (i < this.euT) {
            if (this.eoR != null) {
                this.eoR.kn(false);
            }
        } else if (this.eoR != null) {
            this.eoR.kn(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPt() {
        return this.eoM != null && ((RelativeLayout.LayoutParams) this.eoM.getLayoutParams()).topMargin == 0;
    }

    public void aPu() {
        if (this.eoR != null) {
            this.eoR.aPu();
        }
    }
}
