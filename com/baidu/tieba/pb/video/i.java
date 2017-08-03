package com.baidu.tieba.pb.video;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.c;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.s;
import com.baidu.tieba.play.w;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tieba.play.m bFD;
    private PbActivity eFn;
    private bl eWA;
    private bl eWB;
    private String eWC;
    private float eWI;
    private int eWL;
    private double eWM;
    private c.InterfaceC0117c eWN;
    private com.baidu.tieba.pb.view.c eWP;
    private com.baidu.adp.lib.guide.c eWR;
    private Bitmap eWS;
    private RelativeLayout eWr;
    private com.baidu.tieba.pb.pb.main.view.d eWs;
    private FrameLayout eWt;
    private c.InterfaceC0117c eWu;
    private com.baidu.tieba.play.c eWw;
    private w eWx;
    private g eWy;
    private boolean eWz;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo eWv = null;
    private boolean eWD = false;
    private int eWE = 0;
    private boolean eWF = false;
    private int eWG = 0;
    private int eWH = 0;
    private boolean eWJ = false;
    private boolean eWK = false;
    private boolean eWO = true;
    private c.a eWQ = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kd(false);
        }
    };
    private c.h eWT = new c.h() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.h
        public void aVW() {
            if (i.this.eFn.checkUpIsLogin()) {
                i.this.eFn.aQN();
                if (i.this.eFn.aQc() != null && i.this.eFn.aQc().getPbData() != null && i.this.eFn.aQc().getPbData().aPv() != null) {
                    com.baidu.tieba.pb.data.m aPv = i.this.eFn.aQc().getPbData().aPv();
                    if (i.this.eWP == null) {
                        i.this.eWP = new com.baidu.tieba.pb.view.c(i.this.eFn.getActivity());
                        i.this.eWP.setFloatingHuajiAninationListener(i.this.eWQ);
                    }
                    i.this.eWP.startAnimation(!aPv.aPB());
                }
            }
        }
    };
    private Animation.AnimationListener dNY = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aUz();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private s.a dQM = new s.a() { // from class: com.baidu.tieba.pb.video.i.4
        @Override // com.baidu.tieba.play.s.a
        public void La() {
        }
    };
    private c.e eWU = new c.e() { // from class: com.baidu.tieba.pb.video.i.5
        @Override // com.baidu.tieba.play.c.e
        public void aVV() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (this.eFn.aQc() != null && this.eFn.aQc().getPbData() != null && this.eFn.aQc().getPbData().aPv() != null) {
            com.baidu.tieba.pb.data.m aPv = this.eFn.aQc().getPbData().aPv();
            View findViewById = this.eFn.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aPv.aPB() || z) {
                this.eFn.f(findViewById, 2, false);
                TiebaStatic.log(this.eFn.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPv.aPB() ? 0 : 1));
            } else if (aPv.aPB()) {
                if (aPv.eDn == 1 || aPv.eDn == 3 || aPv.eDn == 4) {
                    this.eFn.f(findViewById, 2, true);
                    TiebaStatic.log(this.eFn.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPv.aPB() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.d dVar, VideoInfo videoInfo) {
        this.eWI = 0.0f;
        this.eFn = pbActivity;
        this.eWs = dVar;
        this.eWI = com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int af = com.baidu.adp.lib.util.k.af(this.eFn.getActivity());
        Rect s = av.s(this.eFn.getPageContext().getPageActivity());
        int ag = s.height() <= 0 ? com.baidu.adp.lib.util.k.ag(this.eFn.getActivity()) : s.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eWM = (intValue2 * 1.0d) / intValue;
            if (this.eWM > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ag);
            }
        }
        this.eWL = i;
        this.eWt.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eWr = (RelativeLayout) LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eWt = (FrameLayout) this.eWr.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.eWw = new com.baidu.tieba.play.c(this.eFn.getPageContext(), this.eWt);
        this.eWw.a(this.eWT);
        if (intValue > 0) {
            if (this.eWM >= 1.0d) {
                this.eWw.lu(false);
            } else {
                this.eWw.lu(true);
            }
            this.eWJ = ((float) b) + this.eWI > ((float) com.baidu.adp.lib.util.k.ag(this.eFn.getActivity()));
            if (this.eWJ) {
                if (this.eWy == null) {
                    this.eWy = new g(this.eFn.getPageContext(), this.eWt);
                    this.eWy.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kd(true);
                        }
                    });
                }
                this.eFn.aQb().aTr();
                this.eWz = true;
            }
        }
        aVO();
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eFn.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eWu == null) {
            this.eWu = new c.InterfaceC0117c() { // from class: com.baidu.tieba.pb.video.i.9
                @Override // com.baidu.tieba.play.c.InterfaceC0117c
                public void ke(boolean z) {
                    if (i.this.aVR() && i.this.eWs != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eWs.aUu().clearAnimation();
                        i.this.aVP();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dNY);
                            i.this.eWs.aUu().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0117c
                public void aVX() {
                    if (i.this.aVR()) {
                        i.this.aUz();
                    }
                }
            };
        }
        a(this.eWu);
        this.eWE = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bl blVar, String str) {
        if (videoInfo != null && this.eWw != null && blVar != null) {
            this.eWv = videoInfo;
            this.eWA = blVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eWw.stopPlay();
            this.eWw.ls(true);
            this.bFD = new com.baidu.tieba.play.m(this.eFn.getActivity());
            this.eWx = new w();
            this.eWx.mLocate = "pb";
            this.eWx.bBT = blVar.getTid();
            this.eWx.azk = str;
            this.eWx.mUid = TbadkCoreApplication.getCurrentAccount();
            this.eWx.mSource = blVar.Ze;
            this.eWx.fzm = blVar.Zf;
            this.eWx.fzn = this.eFn.aPZ();
            if (blVar.sz() != null && blVar.sz().channelId > 0) {
                this.eWx.Vm = blVar.sz().channelId + "";
            } else {
                this.eWx.Vm = "0";
            }
            this.eWx.fzo = blVar.Zg;
            this.bFD.setVideoStatsData(this.eWx);
            this.eWw.getVideoView().setBusiness(this.bFD);
            if (this.eWw.aCQ()) {
                this.eWw.aCO();
            }
            this.eWw.b(this.eWN);
            this.eWC = null;
            this.eWB = null;
            this.eWw.pI(this.eWC);
            this.eWw.aCK().setOnDragingListener(this.dQM);
            this.eWw.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.11
                @Override // com.baidu.tieba.play.c.b
                public void aDa() {
                    i.this.eFn.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eWO = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aCZ() {
                    i.this.eFn.setSwipeBackEnabled(false);
                    i.this.eWO = false;
                }
            });
            this.eWw.a(new c.d() { // from class: com.baidu.tieba.pb.video.i.12
                @Override // com.baidu.tieba.play.c.d
                public void aVY() {
                    if (i.this.eFn != null && i.this.eWB != null && !StringUtils.isNull(i.this.eWB.getId())) {
                        i.this.eFn.pf(i.this.eWB.getId());
                        if (i.this.eWA != null) {
                            long j = 0;
                            if (i.this.eWA.sz() != null) {
                                j = i.this.eWA.sz().channelId;
                            }
                            TiebaStatic.log(new aj("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.eWw.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.f
                public void aVZ() {
                    if (i.this.eWA != null) {
                        long j = 0;
                        if (i.this.eWA.sz() != null) {
                            j = i.this.eWA.sz().channelId;
                        }
                        i.this.Wz();
                        TiebaStatic.log(new aj("c10795").aa("tid", i.this.eWA.getTid()).f("fid", i.this.eWA.getFid()).f("obj_id", j));
                    }
                }
            });
            this.eWw.a(new f.b() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.f.b
                public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                    TiebaStatic.log(new aj("c12029").r("verrno", i).r("extra", i2));
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.mVideoUrl);
                    return true;
                }
            });
            this.eWw.mZ(videoInfo.thumbnail_url);
            this.eWw.bU(videoInfo.play_count.intValue());
            this.eWw.setVideoUrl(this.mVideoUrl);
            this.eWw.qB(blVar.getTitle());
            this.eWw.a(this.eWU);
            this.eWw.apr();
            this.eWw.show();
        }
    }

    public void b(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        if (this.eWy != null) {
            this.eWy.a(postData, blVar, mVar);
        }
    }

    public void a(c.InterfaceC0117c interfaceC0117c) {
        this.eWN = interfaceC0117c;
    }

    public void ab(bl blVar) {
        this.eWB = blVar;
    }

    public void pI(String str) {
        this.eWC = str;
        if (this.eWw != null) {
            this.eWw.pI(this.eWC);
        }
    }

    public void startPlay() {
        if (this.eWw != null) {
            this.eWw.qA(this.mVideoUrl);
        }
        Wz();
    }

    public void aVN() {
        if (this.eWw != null) {
            this.eWw.aVN();
        }
    }

    public void destroy() {
        if (this.eWw != null) {
            this.eWw.destroy();
        }
        if (this.eWt != null) {
            this.eWt.clearAnimation();
        }
        if (this.eWy != null) {
            this.eWy.onDestroy();
        }
    }

    public void onPause() {
        if (this.eWw != null) {
            if (this.eWw.bfq()) {
                this.eWD = true;
                this.eWw.pausePlay();
            } else if (this.eWw.bfv() == 3) {
                this.eWD = false;
            } else {
                this.eWD = false;
                this.eWw.pausePlay();
            }
            if (this.eWP != null) {
                this.eWP.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.eWw != null && this.eWD) {
            this.eWw.aCT();
        }
    }

    private void aVO() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.y(true);
            dVar.A(false);
            dVar.ae(16908290).ad(153).z(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eFn.getActivity());
                    if (i.this.eWS == null) {
                        try {
                            i.this.eWS = BitmapFactory.decodeResource(i.this.eFn.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eWS);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eX() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eY() {
                    return 32;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getXOffset() {
                    return 0;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getYOffset() {
                    return 0;
                }
            });
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.adp.lib.guide.d.a
                public void fa() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.eWR = null;
                    if (i.this.eWS != null && !i.this.eWS.isRecycled()) {
                        i.this.eWS.recycle();
                    }
                    i.this.eWS = null;
                }
            });
            this.eWR = dVar.eZ();
            this.eWR.k(this.eFn.getActivity());
        }
    }

    public boolean pD(int i) {
        if (this.eWw == null) {
            return false;
        }
        return this.eWw.rA(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wz() {
        if (this.eWv != null) {
            com.baidu.tieba.play.k.a(this.eWv.video_md5, "", "1", this.eWx);
        }
    }

    public void aVP() {
        if (this.eWs != null) {
            this.eWs.jS(this.eFn.aQM());
        }
    }

    public void aUz() {
        if (this.eWs != null) {
            this.eWs.aUz();
        }
    }

    public void px(int i) {
        if (this.eWs != null) {
            this.eWs.px(i);
        }
        if (this.eWP != null) {
            this.eWP.onChangeSkinType(i);
        }
        if (this.eWy != null) {
            this.eWy.dr(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aVS()) {
            this.eWG = i;
            aVQ();
        }
    }

    public void b(AbsListView absListView, int i) {
        if (!aVS() && this.eWO) {
            if (this.eWG == 1) {
                int y = (int) aVT().getY();
                if (i != 0) {
                    y = aVT().getHeight();
                }
                pE(y);
            } else if (this.eWG == 2) {
                int y2 = (int) aVT().getY();
                if (this.eWH == y2) {
                    if (i != 0) {
                        y2 = aVT().getHeight();
                    }
                    pE(y2);
                } else {
                    this.eWH = y2;
                    pE(y2);
                }
                if (i == 0 && this.eWK) {
                    this.eWK = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aVN();
                        }
                    }, 100L);
                }
            } else if (this.eWG == 0) {
                if (this.eWw.bfq()) {
                    pJ(aVT().getHeight() - Math.abs((int) aVT().getY()));
                    return;
                }
                int y3 = (int) aVT().getY();
                if (i != 0) {
                    y3 = aVT().getHeight();
                }
                pE(y3);
            }
        }
    }

    private void pE(int i) {
        int height = aVT().getHeight() - Math.abs(i);
        pF(height);
        pH(height);
        pI(height);
        pG(height);
        pJ(height);
        aVQ();
    }

    private void pF(int i) {
        if (i <= 0) {
            this.eWw.lu(false);
        } else if (this.eWM >= 1.0d) {
            this.eWw.lu(false);
        } else {
            this.eWw.lu(true);
        }
    }

    private void pG(int i) {
        if (this.eWy != null) {
            float height = aVT().getHeight() - i;
            float f = height > this.eWI ? 0.0f : 1.0f - (height / this.eWI);
            if (f == 0.0f) {
                this.eWy.aVJ().setVisibility(8);
            } else {
                this.eWy.aVJ().setVisibility(0);
            }
            this.eWy.ah(f);
        }
    }

    public void aVQ() {
        if (this.eWy != null) {
            if (this.eWy.aVJ().getVisibility() == 0) {
                this.eFn.aQb().aTr();
                this.eWz = true;
            } else if (this.eWz) {
                this.eFn.aQb().hi(false);
                this.eWz = false;
            }
        }
    }

    private void pH(int i) {
        if (i < this.eWE) {
            if (this.eWs.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.eWs.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.eWs.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.eWE && i <= this.eWE * 2) {
            float f = 1.0f - (((i - this.eWE) * 1.0f) / this.eWE);
            this.eWs.mNavigationBar.getBarBgView().setAlpha(f);
            this.eWs.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.eWE * 2 && this.eWs.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.eWs.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eWs.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void pI(int i) {
        if (i < this.eWE) {
            this.eWs.aUx().setVisibility(0);
            this.eWs.eTh.setVisibility(8);
            this.eWs.bZl.setVisibility(8);
            if (TbadkCoreApplication.isLogin()) {
                this.eWs.eTj.setVisibility(0);
                this.eWs.jU(true);
                return;
            }
            this.eWs.eTj.setVisibility(8);
            this.eWs.jU(false);
            return;
        }
        this.eWs.jT(true);
        this.eWs.aUx().setVisibility(8);
    }

    private void pJ(int i) {
        if (i < this.eWL / 2 && this.eWw.bfq()) {
            this.eWD = false;
            if (this.eWs.aUu() != null) {
                this.eWs.aUu().clearAnimation();
            }
            this.eWw.clearAnimation();
            this.eWw.pausePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVR() {
        return aVT().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eWF = false;
        if (this.eWw != null && this.eWt != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWt.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eWR != null) {
                    this.eWR.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eWF = true;
                this.eWt.setLayoutParams(layoutParams);
                if (!this.eWz) {
                    this.eFn.aQb().aTr();
                    this.eWz = true;
                }
            } else {
                b(this.eWv);
                aVP();
                this.eWF = false;
                this.eWs.setTitleVisibility(true);
            }
            this.eWw.a(this.eFn, configuration);
        }
    }

    public boolean aVS() {
        return this.eWF;
    }

    public void w(long j, int i) {
        if (this.eWy != null && j > 0) {
            this.eWy.j(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.eWy != null) {
            this.eWy.J(onClickListener);
        }
    }

    public View aVT() {
        return this.eWr;
    }

    public boolean aTD() {
        return this.eWJ;
    }

    public void aVU() {
        this.eWK = true;
    }
}
