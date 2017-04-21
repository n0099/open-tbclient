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
    private aj aSr;
    private PbActivity ekw;
    private FrameLayout erd;
    private int ere;
    private com.baidu.tieba.play.c eri;
    private c.InterfaceC0070c exb;
    private com.baidu.tieba.pb.pb.main.view.f exc;
    private bb exe;
    private bi exf;
    private bi exg;
    private String exh;
    private c.InterfaceC0070c exk;
    private ValueAnimator exl;
    private Handler mHandler;
    private String nameShow;
    private String mVideoUrl = null;
    private VideoInfo exd = null;
    private boolean exi = false;
    private int exj = 0;
    private boolean exm = true;
    private Animation.AnimationListener dxh = new e(this);
    private au.a dzQ = new i(this);
    private c.e exn = new j(this);

    public d(PbActivity pbActivity, com.baidu.tieba.play.c cVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.f fVar, int i) {
        this.ekw = pbActivity;
        this.eri = cVar;
        this.exc = fVar;
        this.erd = frameLayout;
        this.ere = i;
        if (this.eri != null) {
            this.eri.kx(true);
        }
        init();
    }

    private void init() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ekw.getActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.exb == null) {
            this.exb = new k(this, loadAnimation);
        }
        a(this.exb);
        this.exj = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.ekw.getActivity(), w.f.ds98);
        this.mHandler = new Handler();
    }

    public void aQl() {
        if (this.exc != null) {
            this.nameShow = this.exc.eux.getText().toString();
        }
    }

    public void a(VideoInfo videoInfo, bi biVar, String str) {
        if (videoInfo != null && this.eri != null && biVar != null) {
            this.exd = videoInfo;
            this.exf = biVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eri.stopPlay();
            this.eri.kw(true);
            this.aSr = new aj(this.ekw.getActivity());
            this.exe = new bb();
            this.exe.mLocate = "pb";
            this.exe.bsL = biVar.getTid();
            this.exe.bsM = str;
            this.exe.mUid = TbadkCoreApplication.getCurrentAccount();
            this.exe.mSource = biVar.Zy;
            this.exe.eXu = biVar.Zz;
            this.exe.eXv = this.ekw.aLp();
            if (biVar.ts() != null && biVar.ts().channelId > 0) {
                this.exe.VR = new StringBuilder(String.valueOf(biVar.ts().channelId)).toString();
            } else {
                this.exe.VR = "0";
            }
            this.exe.eXw = biVar.ZA;
            this.aSr.a(this.exe);
            this.eri.Lg().setBusiness(this.aSr);
            if (this.eri.azy()) {
                this.eri.azw();
            }
            this.eri.b(this.exk);
            if (this.eri != null) {
                this.eri.nT(this.exh);
            }
            this.exh = null;
            this.exg = null;
            this.eri.nT(this.exh);
            this.eri.azs().setOnDragingListener(this.dzQ);
            this.eri.a(new l(this));
            this.eri.a(new n(this));
            this.eri.a(new o(this));
            this.eri.a(new p(this));
            this.eri.a(new q(this));
            this.eri.ly(videoInfo.thumbnail_url);
            this.eri.bQ(videoInfo.play_count.intValue());
            this.eri.setVideoUrl(this.mVideoUrl);
            this.eri.oT(biVar.getTitle());
            this.eri.a(this.exn);
            this.eri.aml();
            this.eri.show();
        }
    }

    public void a(c.InterfaceC0070c interfaceC0070c) {
        this.exk = interfaceC0070c;
    }

    public void G(bi biVar) {
        this.exg = biVar;
    }

    public void nT(String str) {
        this.exh = str;
        if (this.eri != null) {
            this.eri.nT(this.exh);
        }
    }

    public void startPlay() {
        if (this.eri != null) {
            this.eri.oS(this.mVideoUrl);
        }
        aQs();
        KG();
    }

    public void destroy() {
        if (this.eri != null) {
            this.eri.destroy();
        }
        if (this.erd != null) {
            this.erd.clearAnimation();
        }
        if (this.exl != null) {
            this.exl.cancel();
            this.exl = null;
        }
    }

    public void onPause() {
        if (this.eri != null) {
            if (this.eri.aYN()) {
                this.exi = true;
                this.eri.pausePlay();
            } else if (this.eri.aYT() == 3) {
                this.exi = false;
            } else {
                this.exi = false;
                this.eri.pausePlay();
            }
        }
    }

    public void onResume() {
        if (this.eri != null && this.exi) {
            this.eri.azB();
            aQs();
        }
    }

    public boolean oz(int i) {
        if (this.eri == null) {
            return false;
        }
        return this.eri.qB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.exd != null) {
            ab.a(this.exd.video_md5, "", "1", this.exe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        this.exm = true;
    }

    public void aPe() {
        if (this.exc != null) {
            this.exc.aPe();
        }
    }

    public void aPd() {
        if (this.exc != null) {
            this.exc.aPd();
        }
    }

    public void oB(int i) {
        if (this.exc != null) {
            this.exc.oB(i);
            if (this.eri != null) {
                if (this.eri.aYN() || this.eri.aYT() == 0) {
                    this.exc.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            }
        }
    }

    public void aQn() {
        C(-this.ere, true);
    }

    public void aQo() {
        aQp();
    }

    public void aQp() {
        C(((RelativeLayout.LayoutParams) this.erd.getLayoutParams()).topMargin, false);
    }

    public void C(int i, boolean z) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, 0);
        ofInt.addUpdateListener(new f(this));
        ofInt.addListener(new g(this, z));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    private void aQq() {
        this.exl = ValueAnimator.ofInt(0, -this.ere);
        this.exl.addUpdateListener(new h(this));
        this.exl.setDuration(300L);
        this.exl.start();
    }

    public void a(AbsListView absListView, int i, TextView textView) {
        if (i == 1) {
            int i2 = ((RelativeLayout.LayoutParams) this.erd.getLayoutParams()).topMargin;
            boolean z = this.eri.aYT() == 1 || this.eri.aYT() == 0;
            if (absListView.getChildCount() > 0 && absListView.getChildAt(0) != textView && i2 == 0 && !z) {
                aQq();
            }
        }
    }

    public void b(AbsListView absListView, int i, TextView textView) {
        if (absListView.getChildCount() > i && this.exm) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.erd.getLayoutParams();
            if (this.eri.aYT() == 1 || this.eri.aYT() == 0) {
                layoutParams.topMargin = 0;
                this.erd.setLayoutParams(layoutParams);
                return;
            }
            float y = textView.getY();
            if (absListView.getChildAt(i) == textView) {
                layoutParams.topMargin = (int) y;
                this.erd.setLayoutParams(layoutParams);
                if (this.exl != null) {
                    this.exl.cancel();
                }
            } else {
                layoutParams.topMargin = -this.ere;
                this.erd.setLayoutParams(layoutParams);
            }
            oH(this.ere - Math.abs(layoutParams.topMargin));
            aQt();
        }
    }

    private void oH(int i) {
        if (this.eri.aYT() == 3) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 3));
            }
        } else if (this.eri.aYT() == 2) {
            if (i == 0) {
                TiebaStatic.log(new as("c11996").s("obj_type", 2));
            }
        } else if (this.eri.aYT() == 5 && i == 0) {
            TiebaStatic.log(new as("c11996").s("obj_type", 2));
        }
        if (this.ere == i) {
            TiebaStatic.log(new as("c11997").s("obj_type", 2));
        }
    }

    public void aQr() {
        TiebaStatic.log(new as("c11997").s("obj_type", 1));
        aQn();
    }

    public void aQs() {
        if (this.erd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.erd.getLayoutParams();
            layoutParams.topMargin = 0;
            this.erd.setLayoutParams(layoutParams);
            aQt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        int abs = this.ere - Math.abs(((RelativeLayout.LayoutParams) this.erd.getLayoutParams()).topMargin);
        oK(abs);
        oJ(abs);
        oL(abs);
        oM(abs);
        oI(abs);
    }

    private void oI(int i) {
        if (i < this.exj * 2) {
            this.eri.aYR();
        } else if (this.eri.azt().getVisibility() != 0 && this.eri.aYT() != 3 && this.eri.aYT() != 0) {
            this.eri.aYQ();
        }
    }

    private void oJ(int i) {
        if (i < this.exj) {
            if (this.exc.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.exc.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.exc.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.exj && i <= this.exj * 2) {
            float f = 1.0f - (((i - this.exj) * 1.0f) / this.exj);
            this.exc.mNavigationBar.getBarBgView().setAlpha(f);
            this.exc.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.exj * 2 && this.exc.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.exc.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.exc.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void oK(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (i < this.exj) {
                if (com.baidu.tbadk.core.util.au.dA(this.nameShow) > 10) {
                    String d = com.baidu.tbadk.core.util.au.d(this.nameShow, 10, "...");
                    String string = this.ekw.getPageContext().getString(w.l.bar);
                    if (d.lastIndexOf(string) == -1) {
                        d = String.valueOf(d) + string;
                    }
                    this.exc.eux.setText(d);
                } else {
                    this.exc.eux.setText(this.nameShow);
                }
                this.exc.jf(true);
                this.exc.euz.setVisibility(0);
                return;
            }
            this.exc.eux.setText(this.nameShow);
        }
    }

    private void oL(int i) {
        if (i < this.exj) {
            this.exc.aPb().setVisibility(0);
        } else {
            this.exc.aPb().setVisibility(8);
        }
    }

    private void oM(int i) {
        if (i < this.exj) {
            if (this.eri != null) {
                this.eri.kx(false);
            }
        } else if (this.eri != null) {
            this.eri.kx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQu() {
        return this.erd != null && ((RelativeLayout.LayoutParams) this.erd.getLayoutParams()).topMargin == 0;
    }

    public void aQv() {
        if (this.eri != null) {
            this.eri.aQv();
        }
    }
}
