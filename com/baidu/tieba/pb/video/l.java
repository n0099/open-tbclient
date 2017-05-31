package com.baidu.tieba.pb.video;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.d;
import com.baidu.tieba.play.ak;
import com.baidu.tieba.play.av;
import com.baidu.tieba.play.bc;
import com.baidu.tieba.play.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class l {
    private ak bAD;
    private h eAA;
    private bl eAB;
    private bl eAC;
    private String eAD;
    private float eAJ;
    private int eAM;
    private double eAN;
    private c.InterfaceC0078c eAO;
    private com.baidu.tieba.pb.view.d eAQ;
    private com.baidu.adp.lib.guide.d eAS;
    private Bitmap eAT;
    private RelativeLayout eAt;
    private com.baidu.tieba.pb.pb.main.view.h eAu;
    private FrameLayout eAv;
    private c.InterfaceC0078c eAw;
    private com.baidu.tieba.play.c eAy;
    private bc eAz;
    private PbActivity elf;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo eAx = null;
    private boolean eAE = false;
    private int eAF = 0;
    private boolean eAG = false;
    private int eAH = 0;
    private int eAI = 0;
    private boolean eAK = false;
    private boolean eAL = false;
    private boolean eAP = true;
    private d.a eAR = new m(this);
    private c.h eAU = new s(this);
    private Animation.AnimationListener dwI = new t(this);
    private av.a dzx = new u(this);
    private c.e eAV = new v(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        if (this.elf.aJF() != null && this.elf.aJF().getPbData() != null && this.elf.aJF().getPbData().aIY() != null) {
            com.baidu.tieba.pb.data.m aIY = this.elf.aJF().getPbData().aIY();
            View findViewById = this.elf.getActivity().findViewById(w.h.view_main_thread_praise_state);
            if (!aIY.aJe() || z) {
                this.elf.f(findViewById, 2, false);
            }
        }
    }

    public l(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.h hVar, VideoInfo videoInfo) {
        this.eAJ = 0.0f;
        this.elf = pbActivity;
        this.eAu = hVar;
        this.eAJ = com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int af = com.baidu.adp.lib.util.k.af(this.elf.getActivity());
        Rect s = bg.s(this.elf.getPageContext().getPageActivity());
        int ag = s.height() <= 0 ? com.baidu.adp.lib.util.k.ag(this.elf.getActivity()) : s.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eAN = (intValue2 * 1.0d) / intValue;
            if (this.eAN > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ag);
            }
        }
        this.eAM = i;
        this.eAv.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eAt = (RelativeLayout) LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.video_pb_container_layout, (ViewGroup) null);
        this.eAv = (FrameLayout) this.eAt.findViewById(w.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.eAy = new com.baidu.tieba.play.c(this.elf.getPageContext(), this.eAv);
        this.eAy.a(this.eAU);
        if (intValue > 0) {
            if (this.eAN >= 1.0d) {
                this.eAy.kz(false);
            } else {
                this.eAy.kz(true);
            }
            this.eAK = ((float) b) + this.eAJ > ((float) com.baidu.adp.lib.util.k.ag(this.elf.getActivity()));
            if (this.eAK) {
                if (this.eAA == null) {
                    this.eAA = new h(this.elf.getPageContext(), this.eAv);
                    this.eAA.L(new w(this));
                }
                this.elf.aJE().aMP();
            }
        }
        aOS();
    }

    private void initData() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.elf.getActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eAw == null) {
            this.eAw = new x(this, loadAnimation);
        }
        a(this.eAw);
        this.eAF = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bl blVar, String str) {
        if (videoInfo != null && this.eAy != null && blVar != null) {
            this.eAx = videoInfo;
            this.eAB = blVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eAy.stopPlay();
            this.eAy.kx(true);
            this.bAD = new ak(this.elf.getActivity());
            this.eAz = new bc();
            this.eAz.mLocate = "pb";
            this.eAz.buq = blVar.getTid();
            this.eAz.bur = str;
            this.eAz.mUid = TbadkCoreApplication.getCurrentAccount();
            this.eAz.mSource = blVar.YM;
            this.eAz.fch = blVar.YN;
            this.eAz.fci = this.elf.aJC();
            if (blVar.sx() != null && blVar.sx().channelId > 0) {
                this.eAz.UX = new StringBuilder(String.valueOf(blVar.sx().channelId)).toString();
            } else {
                this.eAz.UX = "0";
            }
            this.eAz.fcj = blVar.YO;
            this.bAD.a(this.eAz);
            this.eAy.Uy().setBusiness(this.bAD);
            if (this.eAy.axo()) {
                this.eAy.axm();
            }
            this.eAy.b(this.eAO);
            this.eAD = null;
            this.eAC = null;
            this.eAy.oo(this.eAD);
            this.eAy.axi().setOnDragingListener(this.dzx);
            this.eAy.a(new y(this));
            this.eAy.a(new aa(this));
            this.eAy.a(new n(this));
            this.eAy.a(new o(this));
            this.eAy.lM(videoInfo.thumbnail_url);
            this.eAy.bE(videoInfo.play_count.intValue());
            this.eAy.setVideoUrl(this.mVideoUrl);
            this.eAy.pf(blVar.getTitle());
            this.eAy.a(this.eAV);
            this.eAy.aka();
            this.eAy.show();
        }
    }

    public void b(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        if (this.eAA != null) {
            this.eAA.a(postData, blVar, mVar);
        }
    }

    public void a(c.InterfaceC0078c interfaceC0078c) {
        this.eAO = interfaceC0078c;
    }

    public void U(bl blVar) {
        this.eAC = blVar;
    }

    public void oo(String str) {
        this.eAD = str;
        if (this.eAy != null) {
            this.eAy.oo(this.eAD);
        }
    }

    public void startPlay() {
        if (this.eAy != null) {
            this.eAy.pe(this.mVideoUrl);
        }
        UA();
    }

    public void aOR() {
        if (this.eAy != null) {
            this.eAy.aOR();
        }
    }

    public void destroy() {
        if (this.eAy != null) {
            this.eAy.destroy();
        }
        if (this.eAv != null) {
            this.eAv.clearAnimation();
        }
        if (this.eAA != null) {
            this.eAA.onDestroy();
        }
    }

    public void onPause() {
        if (this.eAy != null) {
            if (this.eAy.aXD()) {
                this.eAE = true;
                this.eAy.pausePlay();
            } else if (this.eAy.aXI() == 3) {
                this.eAE = false;
            } else {
                this.eAE = false;
                this.eAy.pausePlay();
            }
            if (this.eAQ != null) {
                this.eAQ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.eAy != null && this.eAE) {
            this.eAy.axr();
        }
    }

    private void aOS() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.y(true);
            gVar.A(false);
            gVar.ae(16908290).ad(153).z(false);
            gVar.a(new p(this));
            gVar.b(new q(this));
            this.eAS = gVar.fc();
            this.eAS.k(this.elf.getActivity());
        }
    }

    public boolean oV(int i) {
        if (this.eAy == null) {
            return false;
        }
        return this.eAy.qS(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        if (this.eAx != null) {
            com.baidu.tieba.play.ab.a(this.eAx.video_md5, "", "1", this.eAz);
        }
    }

    public void aOT() {
        if (this.eAu != null) {
            this.eAu.iZ(this.elf.aKl());
        }
    }

    public void aNC() {
        if (this.eAu != null) {
            this.eAu.aNC();
        }
    }

    public void oP(int i) {
        if (this.eAu != null) {
            this.eAu.oP(i);
        }
        if (this.eAQ != null) {
            this.eAQ.onChangeSkinType(i);
        }
        if (this.eAA != null) {
            this.eAA.dn(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aOW()) {
            this.eAH = i;
            aOU();
        }
    }

    public void b(AbsListView absListView, int i) {
        if (!aOW() && this.eAP) {
            if (this.eAH == 1) {
                int y = (int) aOX().getY();
                if (i != 0) {
                    y = aOX().getHeight();
                }
                oW(y);
            } else if (this.eAH == 2) {
                int y2 = (int) aOX().getY();
                if (this.eAI == y2) {
                    if (i != 0) {
                        y2 = aOX().getHeight();
                    }
                    oW(y2);
                } else {
                    this.eAI = y2;
                    oW(y2);
                }
                if (i == 0 && this.eAL) {
                    this.eAL = false;
                    this.mHandler.postDelayed(new r(this), 100L);
                }
            } else if (this.eAH == 0) {
                if (this.eAy.aXD()) {
                    pb(aOX().getHeight() - Math.abs((int) aOX().getY()));
                    return;
                }
                int y3 = (int) aOX().getY();
                if (i != 0) {
                    y3 = aOX().getHeight();
                }
                oW(y3);
            }
        }
    }

    private void oW(int i) {
        int height = aOX().getHeight() - Math.abs(i);
        oX(height);
        oZ(height);
        pa(height);
        oY(height);
        pb(height);
        aOU();
    }

    private void oX(int i) {
        if (i <= 0) {
            this.eAy.kz(false);
        } else if (this.eAN >= 1.0d) {
            this.eAy.kz(false);
        } else {
            this.eAy.kz(true);
        }
    }

    private void oY(int i) {
        if (this.eAA != null) {
            float height = aOX().getHeight() - i;
            float f = height > this.eAJ ? 0.0f : 1.0f - (height / this.eAJ);
            if (f == 0.0f) {
                this.eAA.aON().setVisibility(8);
            } else {
                this.eAA.aON().setVisibility(0);
            }
            this.eAA.ab(f);
        }
    }

    public void aOU() {
        if (this.eAA != null) {
            if (this.eAA.aON().getVisibility() == 0) {
                this.elf.aJE().aMP();
            } else {
                this.elf.aKn();
            }
        }
    }

    private void oZ(int i) {
        if (i < this.eAF) {
            if (this.eAu.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.eAu.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.eAu.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.eAF && i <= this.eAF * 2) {
            float f = 1.0f - (((i - this.eAF) * 1.0f) / this.eAF);
            this.eAu.mNavigationBar.getBarBgView().setAlpha(f);
            this.eAu.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.eAF * 2 && this.eAu.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.eAu.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eAu.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void pa(int i) {
        if (i < this.eAF) {
            this.eAu.aNA().setVisibility(0);
            this.eAu.exi.setVisibility(8);
            this.eAu.bOc.setVisibility(8);
            if (TbadkCoreApplication.isLogin()) {
                this.eAu.exk.setVisibility(0);
                this.eAu.jb(true);
                return;
            }
            this.eAu.exk.setVisibility(8);
            this.eAu.jb(false);
            return;
        }
        this.eAu.ja(true);
        this.eAu.aNA().setVisibility(8);
    }

    private void pb(int i) {
        if (i < this.eAM / 2 && this.eAy.aXD()) {
            this.eAE = false;
            if (this.eAu.aNx() != null) {
                this.eAu.aNx().clearAnimation();
            }
            this.eAy.clearAnimation();
            this.eAy.pausePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOV() {
        return aOX().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eAG = false;
        if (this.eAy != null && this.eAv != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAv.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eAS != null) {
                    this.eAS.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eAG = true;
                this.eAv.setLayoutParams(layoutParams);
                this.elf.aJE().aMP();
            } else {
                b(this.eAx);
                aOT();
                this.eAG = false;
                this.eAu.setTitleVisibility(true);
            }
            this.eAy.a(this.elf, configuration);
        }
    }

    public boolean aOW() {
        return this.eAG;
    }

    public void v(long j, int i) {
        if (this.eAA != null && j > 0) {
            this.eAA.j(i, j);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.eAA != null) {
            this.eAA.K(onClickListener);
        }
    }

    public View aOX() {
        return this.eAt;
    }

    public boolean aNb() {
        return this.eAK;
    }

    public void aOY() {
        this.eAL = true;
    }
}
