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
import com.baidu.tbadk.core.data.bj;
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
    private aj aRZ;
    private PbActivity eka;
    private FrameLayout eqD;
    private int eqE;
    private com.baidu.tieba.play.c eqI;
    private c.InterfaceC0071c ewG;
    private com.baidu.tieba.pb.pb.main.view.f ewH;
    private bb ewI;
    private bj ewJ;
    private bj ewK;
    private String ewL;
    private c.InterfaceC0071c ewO;
    private ValueAnimator ewP;
    private Handler mHandler;
    private String nameShow;
    private String aTZ = null;
    private VideoInfo dxu = null;
    private boolean ewM = false;
    private int ewN = 0;
    private boolean ewQ = true;
    private Animation.AnimationListener dyu = new e(this);
    private au.a dAS = new i(this);
    private c.e ewR = new j(this);

    public d(PbActivity pbActivity, com.baidu.tieba.play.c cVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.f fVar, int i) {
        this.eka = pbActivity;
        this.eqI = cVar;
        this.ewH = fVar;
        this.eqD = frameLayout;
        this.eqE = i;
        if (this.eqI != null) {
            this.eqI.ko(true);
        }
        init();
    }

    private void init() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eka.getActivity(), w.a.anim_alpha_1_to_0_duration_2000);
        if (this.ewG == null) {
            this.ewG = new k(this, loadAnimation);
        }
        a(this.ewG);
        this.ewN = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eka.getActivity(), w.f.ds98);
        this.mHandler = new Handler();
    }

    public void aPb() {
        if (this.ewH != null) {
            this.nameShow = this.ewH.euc.getText().toString();
        }
    }

    public void a(VideoInfo videoInfo, bj bjVar, String str) {
        if (videoInfo != null && this.eqI != null && bjVar != null) {
            this.dxu = videoInfo;
            this.ewJ = bjVar;
            this.aTZ = videoInfo.video_url;
            this.eqI.stopPlay();
            this.eqI.kn(true);
            this.aRZ = new aj(this.eka.getActivity());
            this.ewI = new bb();
            this.ewI.mLocate = "pb";
            this.ewI.bqB = bjVar.getTid();
            this.ewI.bqC = str;
            this.ewI.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ewI.mSource = bjVar.Zh;
            this.ewI.eXe = bjVar.Zj;
            this.ewI.eXf = bjVar.Zi;
            this.ewI.eXg = this.eka.aKh();
            if (bjVar.sU() != null && bjVar.sU().channelId > 0) {
                this.ewI.Vy = new StringBuilder(String.valueOf(bjVar.sU().channelId)).toString();
            } else {
                this.ewI.Vy = "0";
            }
            this.aRZ.a(this.ewI);
            this.eqI.KG().setBusiness(this.aRZ);
            if (this.eqI.ayT()) {
                this.eqI.ayR();
            }
            this.eqI.b(this.ewO);
            if (this.eqI != null) {
                this.eqI.nO(this.ewL);
            }
            this.ewL = null;
            this.ewK = null;
            this.eqI.nO(this.ewL);
            this.eqI.ayN().setOnDragingListener(this.dAS);
            this.eqI.a(new l(this));
            this.eqI.a(new n(this));
            this.eqI.a(new o(this));
            this.eqI.a(new p(this));
            this.eqI.a(new q(this));
            this.eqI.lu(videoInfo.thumbnail_url);
            this.eqI.bQ(videoInfo.play_count.intValue());
            this.eqI.setVideoUrl(this.aTZ);
            this.eqI.oL(bjVar.getTitle());
            this.eqI.a(this.ewR);
            this.eqI.alq();
            this.eqI.show();
        }
    }

    public void a(c.InterfaceC0071c interfaceC0071c) {
        this.ewO = interfaceC0071c;
    }

    public void J(bj bjVar) {
        this.ewK = bjVar;
    }

    public void nO(String str) {
        this.ewL = str;
        if (this.eqI != null) {
            this.eqI.nO(this.ewL);
        }
    }

    public void startPlay() {
        if (this.eqI != null) {
            this.eqI.oK(this.aTZ);
        }
        aPi();
        Kg();
    }

    public void destroy() {
        if (this.eqI != null) {
            this.eqI.destroy();
        }
        if (this.eqD != null) {
            this.eqD.clearAnimation();
        }
        if (this.ewP != null) {
            this.ewP.cancel();
            this.ewP = null;
        }
    }

    public void onPause() {
        if (this.eqI != null) {
            if (this.eqI.aXD()) {
                this.ewM = true;
                this.eqI.pausePlay();
            } else if (this.eqI.aXJ() == 3) {
                this.ewM = false;
            } else {
                this.ewM = false;
                this.eqI.pausePlay();
            }
        }
    }

    public void onResume() {
        if (this.eqI != null && this.ewM) {
            this.eqI.ayW();
            aPi();
        }
    }

    public boolean ov(int i) {
        if (this.eqI == null) {
            return false;
        }
        return this.eqI.qx(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (this.dxu != null) {
            ab.a(this.dxu.video_md5, "", "1", this.ewI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPc() {
        this.ewQ = true;
    }

    public void aNU() {
        if (this.ewH != null) {
            this.ewH.aNU();
        }
    }

    public void aNT() {
        if (this.ewH != null) {
            this.ewH.aNT();
        }
    }

    public void ox(int i) {
        if (this.ewH != null) {
            this.ewH.ox(i);
            if (this.eqI != null) {
                if (this.eqI.aXD() || this.eqI.aXJ() == 0) {
                    this.ewH.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            }
        }
    }

    public void aPd() {
        C(-this.eqE, true);
    }

    public void aPe() {
        aPf();
    }

    public void aPf() {
        C(((RelativeLayout.LayoutParams) this.eqD.getLayoutParams()).topMargin, false);
    }

    public void C(int i, boolean z) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, 0);
        ofInt.addUpdateListener(new f(this));
        ofInt.addListener(new g(this, z));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    private void aPg() {
        this.ewP = ValueAnimator.ofInt(0, -this.eqE);
        this.ewP.addUpdateListener(new h(this));
        this.ewP.setDuration(300L);
        this.ewP.start();
    }

    public void a(AbsListView absListView, int i, TextView textView) {
        if (i == 1) {
            int i2 = ((RelativeLayout.LayoutParams) this.eqD.getLayoutParams()).topMargin;
            boolean z = this.eqI.aXJ() == 1 || this.eqI.aXJ() == 0;
            if (absListView.getChildCount() > 0 && absListView.getChildAt(0) != textView && i2 == 0 && !z) {
                aPg();
            }
        }
    }

    public void b(AbsListView absListView, int i, TextView textView) {
        if (absListView.getChildCount() > i && this.ewQ) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eqD.getLayoutParams();
            if (this.eqI.aXJ() == 1 || this.eqI.aXJ() == 0) {
                layoutParams.topMargin = 0;
                this.eqD.setLayoutParams(layoutParams);
                return;
            }
            float y = textView.getY();
            if (absListView.getChildAt(i) == textView) {
                layoutParams.topMargin = (int) y;
                this.eqD.setLayoutParams(layoutParams);
                if (this.ewP != null) {
                    this.ewP.cancel();
                }
            } else {
                layoutParams.topMargin = -this.eqE;
                this.eqD.setLayoutParams(layoutParams);
            }
            oD(this.eqE - Math.abs(layoutParams.topMargin));
            aPj();
        }
    }

    private void oD(int i) {
        if (this.eqI.aXJ() == 3) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 3));
            }
        } else if (this.eqI.aXJ() == 2) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 2));
            }
        } else if (this.eqI.aXJ() == 5 && i == 0) {
            TiebaStatic.log(new as("c11996").s("obj_type", 2));
        }
        if (this.eqE == i) {
            TiebaStatic.log(new as("c11997").s("obj_type", 2));
        }
    }

    public void aPh() {
        TiebaStatic.log(new as("c11997").s("obj_type", 1));
        aPd();
    }

    public void aPi() {
        if (this.eqD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eqD.getLayoutParams();
            layoutParams.topMargin = 0;
            this.eqD.setLayoutParams(layoutParams);
            aPj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPj() {
        int abs = this.eqE - Math.abs(((RelativeLayout.LayoutParams) this.eqD.getLayoutParams()).topMargin);
        oG(abs);
        oF(abs);
        oH(abs);
        oI(abs);
        oE(abs);
    }

    private void oE(int i) {
        if (i < this.ewN * 2) {
            this.eqI.aXH();
        } else if (this.eqI.ayO().getVisibility() != 0 && this.eqI.aXJ() != 3 && this.eqI.aXJ() != 0) {
            this.eqI.aXG();
        }
    }

    private void oF(int i) {
        if (i < this.ewN) {
            if (this.ewH.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.ewH.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.ewH.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.ewN && i <= this.ewN * 2) {
            float f = 1.0f - (((i - this.ewN) * 1.0f) / this.ewN);
            this.ewH.mNavigationBar.getBarBgView().setAlpha(f);
            this.ewH.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.ewN * 2 && this.ewH.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.ewH.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.ewH.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void oG(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (i < this.ewN) {
                if (com.baidu.tbadk.core.util.au.du(this.nameShow) > 10) {
                    String d = com.baidu.tbadk.core.util.au.d(this.nameShow, 10, "...");
                    String string = this.eka.getPageContext().getString(w.l.bar);
                    if (d.lastIndexOf(string) == -1) {
                        d = String.valueOf(d) + string;
                    }
                    this.ewH.euc.setText(d);
                } else {
                    this.ewH.euc.setText(this.nameShow);
                }
                this.ewH.iW(true);
                this.ewH.eue.setVisibility(0);
                return;
            }
            this.ewH.euc.setText(this.nameShow);
        }
    }

    private void oH(int i) {
        if (i < this.ewN) {
            this.ewH.aNR().setVisibility(0);
        } else {
            this.ewH.aNR().setVisibility(8);
        }
    }

    private void oI(int i) {
        if (i < this.ewN) {
            if (this.eqI != null) {
                this.eqI.ko(false);
            }
        } else if (this.eqI != null) {
            this.eqI.ko(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPk() {
        return this.eqD != null && ((RelativeLayout.LayoutParams) this.eqD.getLayoutParams()).topMargin == 0;
    }

    public void aPl() {
        if (this.eqI != null) {
            this.eqI.aPl();
        }
    }
}
