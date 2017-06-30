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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bk;
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
    private ak bBw;
    private RelativeLayout eJR;
    private com.baidu.tieba.pb.pb.main.view.j eJS;
    private FrameLayout eJT;
    private c.InterfaceC0081c eJU;
    private com.baidu.tieba.play.c eJW;
    private bc eJX;
    private h eJY;
    private bm eJZ;
    private bm eKa;
    private String eKb;
    private float eKh;
    private int eKk;
    private double eKl;
    private c.InterfaceC0081c eKm;
    private com.baidu.tieba.pb.view.d eKo;
    private com.baidu.adp.lib.guide.d eKq;
    private Bitmap eKr;
    private PbActivity euf;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo eJV = null;
    private boolean eKc = false;
    private int eKd = 0;
    private boolean eKe = false;
    private int eKf = 0;
    private int eKg = 0;
    private boolean eKi = false;
    private boolean eKj = false;
    private boolean eKn = true;
    private d.a eKp = new m(this);
    private c.h eKs = new s(this);
    private Animation.AnimationListener dFv = new t(this);
    private av.a dIj = new u(this);
    private c.e eKt = new v(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(boolean z) {
        if (this.euf.aNz() != null && this.euf.aNz().getPbData() != null && this.euf.aNz().getPbData().aMS() != null) {
            com.baidu.tieba.pb.data.m aMS = this.euf.aNz().getPbData().aMS();
            View findViewById = this.euf.getActivity().findViewById(w.h.view_main_thread_praise_state);
            if (!aMS.aMY() || z) {
                this.euf.f(findViewById, 2, false);
                TiebaStatic.log(this.euf.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aMS.aMY() ? 0 : 1));
            }
        }
    }

    public l(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.j jVar, VideoInfo videoInfo) {
        this.eKh = 0.0f;
        this.euf = pbActivity;
        this.eJS = jVar;
        this.eKh = com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int af = com.baidu.adp.lib.util.k.af(this.euf.getActivity());
        Rect s = bk.s(this.euf.getPageContext().getPageActivity());
        int ag = s.height() <= 0 ? com.baidu.adp.lib.util.k.ag(this.euf.getActivity()) : s.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eKl = (intValue2 * 1.0d) / intValue;
            if (this.eKl > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ag);
            }
        }
        this.eKk = i;
        this.eJT.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eJR = (RelativeLayout) LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.video_pb_container_layout, (ViewGroup) null);
        this.eJT = (FrameLayout) this.eJR.findViewById(w.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.eJW = new com.baidu.tieba.play.c(this.euf.getPageContext(), this.eJT);
        this.eJW.a(this.eKs);
        if (intValue > 0) {
            if (this.eKl >= 1.0d) {
                this.eJW.kZ(false);
            } else {
                this.eJW.kZ(true);
            }
            this.eKi = ((float) b) + this.eKh > ((float) com.baidu.adp.lib.util.k.ag(this.euf.getActivity()));
            if (this.eKi) {
                if (this.eJY == null) {
                    this.eJY = new h(this.euf.getPageContext(), this.eJT);
                    this.eJY.M(new w(this));
                }
                this.euf.aNy().aQN();
            }
        }
        aSR();
    }

    private void initData() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.euf.getActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eJU == null) {
            this.eJU = new x(this, loadAnimation);
        }
        a(this.eJU);
        this.eKd = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bm bmVar, String str) {
        if (videoInfo != null && this.eJW != null && bmVar != null) {
            this.eJV = videoInfo;
            this.eJZ = bmVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eJW.stopPlay();
            this.eJW.kX(true);
            this.bBw = new ak(this.euf.getActivity());
            this.eJX = new bc();
            this.eJX.mLocate = "pb";
            this.eJX.bxL = bmVar.getTid();
            this.eJX.bxM = str;
            this.eJX.mUid = TbadkCoreApplication.getCurrentAccount();
            this.eJX.mSource = bmVar.YN;
            this.eJX.fmx = bmVar.YO;
            this.eJX.fmy = this.euf.aNw();
            if (bmVar.sv() != null && bmVar.sv().channelId > 0) {
                this.eJX.UW = new StringBuilder(String.valueOf(bmVar.sv().channelId)).toString();
            } else {
                this.eJX.UW = "0";
            }
            this.eJX.fmz = bmVar.YP;
            this.bBw.a(this.eJX);
            this.eJW.VP().setBusiness(this.bBw);
            if (this.eJW.aBn()) {
                this.eJW.aBl();
            }
            this.eJW.b(this.eKm);
            this.eKb = null;
            this.eKa = null;
            this.eJW.pj(this.eKb);
            this.eJW.aBh().setOnDragingListener(this.dIj);
            this.eJW.a(new y(this));
            this.eJW.a(new aa(this));
            this.eJW.a(new n(this));
            this.eJW.a(new o(this));
            this.eJW.mJ(videoInfo.thumbnail_url);
            this.eJW.bS(videoInfo.play_count.intValue());
            this.eJW.setVideoUrl(this.mVideoUrl);
            this.eJW.qc(bmVar.getTitle());
            this.eJW.a(this.eKt);
            this.eJW.anL();
            this.eJW.show();
        }
    }

    public void b(PostData postData, bm bmVar, com.baidu.tieba.pb.data.m mVar) {
        if (this.eJY != null) {
            this.eJY.a(postData, bmVar, mVar);
        }
    }

    public void a(c.InterfaceC0081c interfaceC0081c) {
        this.eKm = interfaceC0081c;
    }

    public void V(bm bmVar) {
        this.eKa = bmVar;
    }

    public void pj(String str) {
        this.eKb = str;
        if (this.eJW != null) {
            this.eJW.pj(this.eKb);
        }
    }

    public void startPlay() {
        if (this.eJW != null) {
            this.eJW.qb(this.mVideoUrl);
        }
        VR();
    }

    public void aSQ() {
        if (this.eJW != null) {
            this.eJW.aSQ();
        }
    }

    public void destroy() {
        if (this.eJW != null) {
            this.eJW.destroy();
        }
        if (this.eJT != null) {
            this.eJT.clearAnimation();
        }
        if (this.eJY != null) {
            this.eJY.onDestroy();
        }
    }

    public void onPause() {
        if (this.eJW != null) {
            if (this.eJW.bbO()) {
                this.eKc = true;
                this.eJW.pausePlay();
            } else if (this.eJW.bbT() == 3) {
                this.eKc = false;
            } else {
                this.eKc = false;
                this.eJW.pausePlay();
            }
            if (this.eKo != null) {
                this.eKo.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.eJW != null && this.eKc) {
            this.eJW.aBq();
        }
    }

    private void aSR() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.y(true);
            gVar.A(false);
            gVar.ae(16908290).ad(153).z(false);
            gVar.a(new p(this));
            gVar.b(new q(this));
            this.eKq = gVar.fb();
            this.eKq.k(this.euf.getActivity());
        }
    }

    public boolean po(int i) {
        if (this.eJW == null) {
            return false;
        }
        return this.eJW.rl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.eJV != null) {
            com.baidu.tieba.play.ab.a(this.eJV.video_md5, "", "1", this.eJX);
        }
    }

    public void aSS() {
        if (this.eJS != null) {
            this.eJS.jx(this.euf.aOi());
        }
    }

    public void aRC() {
        if (this.eJS != null) {
            this.eJS.aRC();
        }
    }

    public void pi(int i) {
        if (this.eJS != null) {
            this.eJS.pi(i);
        }
        if (this.eKo != null) {
            this.eKo.onChangeSkinType(i);
        }
        if (this.eJY != null) {
            this.eJY.dp(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aSV()) {
            this.eKf = i;
            aST();
        }
    }

    public void b(AbsListView absListView, int i) {
        if (!aSV() && this.eKn) {
            if (this.eKf == 1) {
                int y = (int) aSW().getY();
                if (i != 0) {
                    y = aSW().getHeight();
                }
                pp(y);
            } else if (this.eKf == 2) {
                int y2 = (int) aSW().getY();
                if (this.eKg == y2) {
                    if (i != 0) {
                        y2 = aSW().getHeight();
                    }
                    pp(y2);
                } else {
                    this.eKg = y2;
                    pp(y2);
                }
                if (i == 0 && this.eKj) {
                    this.eKj = false;
                    this.mHandler.postDelayed(new r(this), 100L);
                }
            } else if (this.eKf == 0) {
                if (this.eJW.bbO()) {
                    pu(aSW().getHeight() - Math.abs((int) aSW().getY()));
                    return;
                }
                int y3 = (int) aSW().getY();
                if (i != 0) {
                    y3 = aSW().getHeight();
                }
                pp(y3);
            }
        }
    }

    private void pp(int i) {
        int height = aSW().getHeight() - Math.abs(i);
        pq(height);
        ps(height);
        pt(height);
        pr(height);
        pu(height);
        aST();
    }

    private void pq(int i) {
        if (i <= 0) {
            this.eJW.kZ(false);
        } else if (this.eKl >= 1.0d) {
            this.eJW.kZ(false);
        } else {
            this.eJW.kZ(true);
        }
    }

    private void pr(int i) {
        if (this.eJY != null) {
            float height = aSW().getHeight() - i;
            float f = height > this.eKh ? 0.0f : 1.0f - (height / this.eKh);
            if (f == 0.0f) {
                this.eJY.aSM().setVisibility(8);
            } else {
                this.eJY.aSM().setVisibility(0);
            }
            this.eJY.ah(f);
        }
    }

    public void aST() {
        if (this.eJY != null) {
            if (this.eJY.aSM().getVisibility() == 0) {
                this.euf.aNy().aQN();
            } else {
                this.euf.aOk();
            }
        }
    }

    private void ps(int i) {
        if (i < this.eKd) {
            if (this.eJS.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.eJS.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.eJS.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.eKd && i <= this.eKd * 2) {
            float f = 1.0f - (((i - this.eKd) * 1.0f) / this.eKd);
            this.eJS.mNavigationBar.getBarBgView().setAlpha(f);
            this.eJS.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.eKd * 2 && this.eJS.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.eJS.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eJS.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void pt(int i) {
        if (i < this.eKd) {
            this.eJS.aRA().setVisibility(0);
            this.eJS.eGH.setVisibility(8);
            this.eJS.bUX.setVisibility(8);
            if (TbadkCoreApplication.isLogin()) {
                this.eJS.eGJ.setVisibility(0);
                this.eJS.jz(true);
                return;
            }
            this.eJS.eGJ.setVisibility(8);
            this.eJS.jz(false);
            return;
        }
        this.eJS.jy(true);
        this.eJS.aRA().setVisibility(8);
    }

    private void pu(int i) {
        if (i < this.eKk / 2 && this.eJW.bbO()) {
            this.eKc = false;
            if (this.eJS.aRx() != null) {
                this.eJS.aRx().clearAnimation();
            }
            this.eJW.clearAnimation();
            this.eJW.pausePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSU() {
        return aSW().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eKe = false;
        if (this.eJW != null && this.eJT != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJT.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eKq != null) {
                    this.eKq.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eKe = true;
                this.eJT.setLayoutParams(layoutParams);
                this.euf.aNy().aQN();
            } else {
                b(this.eJV);
                aSS();
                this.eKe = false;
                this.eJS.setTitleVisibility(true);
            }
            this.eJW.a(this.euf, configuration);
        }
    }

    public boolean aSV() {
        return this.eKe;
    }

    public void w(long j, int i) {
        if (this.eJY != null && j > 0) {
            this.eJY.j(i, j);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eJY != null) {
            this.eJY.L(onClickListener);
        }
    }

    public View aSW() {
        return this.eJR;
    }

    public boolean aQZ() {
        return this.eKi;
    }

    public void aSX() {
        this.eKj = true;
    }
}
