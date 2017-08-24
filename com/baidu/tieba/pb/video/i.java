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
    private com.baidu.tieba.play.m bHx;
    private PbActivity eIw;
    private FrameLayout eZA;
    private c.InterfaceC0117c eZB;
    private com.baidu.tieba.play.c eZD;
    private w eZE;
    private g eZF;
    private boolean eZG;
    private bl eZH;
    private bl eZI;
    private String eZJ;
    private float eZP;
    private int eZS;
    private double eZT;
    private c.InterfaceC0117c eZU;
    private com.baidu.tieba.pb.view.c eZW;
    private com.baidu.adp.lib.guide.c eZY;
    private Bitmap eZZ;
    private RelativeLayout eZy;
    private com.baidu.tieba.pb.pb.main.view.d eZz;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo eZC = null;
    private boolean eZK = false;
    private int eZL = 0;
    private boolean eZM = false;
    private int eZN = 0;
    private int eZO = 0;
    private boolean eZQ = false;
    private boolean eZR = false;
    private boolean eZV = true;
    private c.a eZX = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kg(false);
        }
    };
    private c.h faa = new c.h() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.h
        public void aWJ() {
            if (i.this.eIw.checkUpIsLogin()) {
                i.this.eIw.aRA();
                if (i.this.eIw.aQP() != null && i.this.eIw.aQP().getPbData() != null && i.this.eIw.aQP().getPbData().aQi() != null) {
                    com.baidu.tieba.pb.data.m aQi = i.this.eIw.aQP().getPbData().aQi();
                    if (i.this.eZW == null) {
                        i.this.eZW = new com.baidu.tieba.pb.view.c(i.this.eIw.getActivity());
                        i.this.eZW.setFloatingHuajiAninationListener(i.this.eZX);
                    }
                    i.this.eZW.startAnimation(!aQi.aQo());
                }
            }
        }
    };
    private Animation.AnimationListener dRl = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aVm();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private s.a dTZ = new s.a() { // from class: com.baidu.tieba.pb.video.i.4
        @Override // com.baidu.tieba.play.s.a
        public void Lf() {
        }
    };
    private c.e fab = new c.e() { // from class: com.baidu.tieba.pb.video.i.5
        @Override // com.baidu.tieba.play.c.e
        public void aWI() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(boolean z) {
        if (this.eIw.aQP() != null && this.eIw.aQP().getPbData() != null && this.eIw.aQP().getPbData().aQi() != null) {
            com.baidu.tieba.pb.data.m aQi = this.eIw.aQP().getPbData().aQi();
            View findViewById = this.eIw.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aQi.aQo() || z) {
                this.eIw.f(findViewById, 2, false);
                TiebaStatic.log(this.eIw.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQi.aQo() ? 0 : 1));
            } else if (aQi.aQo()) {
                if (aQi.eGw == 1 || aQi.eGw == 3 || aQi.eGw == 4) {
                    this.eIw.f(findViewById, 2, true);
                    TiebaStatic.log(this.eIw.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQi.aQo() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.d dVar, VideoInfo videoInfo) {
        this.eZP = 0.0f;
        this.eIw = pbActivity;
        this.eZz = dVar;
        this.eZP = com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ag = com.baidu.adp.lib.util.k.ag(this.eIw.getActivity());
        Rect s = av.s(this.eIw.getPageContext().getPageActivity());
        int ah = s.height() <= 0 ? com.baidu.adp.lib.util.k.ah(this.eIw.getActivity()) : s.height();
        int i = (int) (ag * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eZT = (intValue2 * 1.0d) / intValue;
            if (this.eZT > 0.5625d) {
                i = Math.min((ag * intValue2) / intValue, ah);
            }
        }
        this.eZS = i;
        this.eZA.setLayoutParams(new RelativeLayout.LayoutParams(ag, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eZy = (RelativeLayout) LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eZA = (FrameLayout) this.eZy.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.eZD = new com.baidu.tieba.play.c(this.eIw.getPageContext(), this.eZA);
        this.eZD.a(this.faa);
        if (intValue > 0) {
            if (this.eZT >= 1.0d) {
                this.eZD.lx(false);
            } else {
                this.eZD.lx(true);
            }
            this.eZQ = ((float) b) + this.eZP > ((float) com.baidu.adp.lib.util.k.ah(this.eIw.getActivity()));
            if (this.eZQ) {
                if (this.eZF == null) {
                    this.eZF = new g(this.eIw.getPageContext(), this.eZA);
                    this.eZF.G(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kg(true);
                        }
                    });
                }
                this.eIw.aQO().aUe();
                this.eZG = true;
            }
        }
        aWB();
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eIw.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eZB == null) {
            this.eZB = new c.InterfaceC0117c() { // from class: com.baidu.tieba.pb.video.i.9
                @Override // com.baidu.tieba.play.c.InterfaceC0117c
                public void kh(boolean z) {
                    if (i.this.aWE() && i.this.eZz != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eZz.aVh().clearAnimation();
                        i.this.aWC();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dRl);
                            i.this.eZz.aVh().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0117c
                public void aWK() {
                    if (i.this.aWE()) {
                        i.this.aVm();
                    }
                }
            };
        }
        a(this.eZB);
        this.eZL = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bl blVar, String str) {
        if (videoInfo != null && this.eZD != null && blVar != null) {
            this.eZC = videoInfo;
            this.eZH = blVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eZD.stopPlay();
            this.eZD.lv(true);
            this.bHx = new com.baidu.tieba.play.m(this.eIw.getActivity());
            this.eZE = new w();
            this.eZE.mLocate = "pb";
            this.eZE.bDN = blVar.getTid();
            this.eZE.aAD = str;
            this.eZE.mUid = TbadkCoreApplication.getCurrentAccount();
            this.eZE.mSource = blVar.aaC;
            this.eZE.fCt = blVar.aaD;
            this.eZE.fCu = this.eIw.aQM();
            if (blVar.sK() != null && blVar.sK().channelId > 0) {
                this.eZE.WL = blVar.sK().channelId + "";
            } else {
                this.eZE.WL = "0";
            }
            this.eZE.fCv = blVar.aaE;
            this.bHx.setVideoStatsData(this.eZE);
            this.eZD.getVideoView().setBusiness(this.bHx);
            if (this.eZD.aDD()) {
                this.eZD.aDB();
            }
            this.eZD.b(this.eZU);
            this.eZJ = null;
            this.eZI = null;
            this.eZD.pU(this.eZJ);
            this.eZD.aDx().setOnDragingListener(this.dTZ);
            this.eZD.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.11
                @Override // com.baidu.tieba.play.c.b
                public void aDN() {
                    i.this.eIw.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eZV = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aDM() {
                    i.this.eIw.setSwipeBackEnabled(false);
                    i.this.eZV = false;
                }
            });
            this.eZD.a(new c.d() { // from class: com.baidu.tieba.pb.video.i.12
                @Override // com.baidu.tieba.play.c.d
                public void aWL() {
                    if (i.this.eIw != null && i.this.eZI != null && !StringUtils.isNull(i.this.eZI.getId())) {
                        i.this.eIw.ps(i.this.eZI.getId());
                        if (i.this.eZH != null) {
                            long j = 0;
                            if (i.this.eZH.sK() != null) {
                                j = i.this.eZH.sK().channelId;
                            }
                            TiebaStatic.log(new aj("c11921").g("obj_id", j));
                        }
                    }
                }
            });
            this.eZD.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.f
                public void aWM() {
                    if (i.this.eZH != null) {
                        long j = 0;
                        if (i.this.eZH.sK() != null) {
                            j = i.this.eZH.sK().channelId;
                        }
                        i.this.WX();
                        TiebaStatic.log(new aj("c10795").aa("tid", i.this.eZH.getTid()).g("fid", i.this.eZH.getFid()).g("obj_id", j));
                    }
                }
            });
            this.eZD.a(new f.b() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.f.b
                public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                    TiebaStatic.log(new aj("c12029").r("verrno", i).r("extra", i2));
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.mVideoUrl);
                    return true;
                }
            });
            this.eZD.nm(videoInfo.thumbnail_url);
            this.eZD.bU(videoInfo.play_count.intValue());
            this.eZD.setVideoUrl(this.mVideoUrl);
            this.eZD.qN(blVar.getTitle());
            this.eZD.a(this.fab);
            this.eZD.aqe();
            this.eZD.show();
        }
    }

    public void b(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        if (this.eZF != null) {
            this.eZF.a(postData, blVar, mVar);
        }
    }

    public void a(c.InterfaceC0117c interfaceC0117c) {
        this.eZU = interfaceC0117c;
    }

    public void ab(bl blVar) {
        this.eZI = blVar;
    }

    public void pU(String str) {
        this.eZJ = str;
        if (this.eZD != null) {
            this.eZD.pU(this.eZJ);
        }
    }

    public void startPlay() {
        if (this.eZD != null) {
            this.eZD.qM(this.mVideoUrl);
        }
        WX();
    }

    public void aWA() {
        if (this.eZD != null) {
            this.eZD.aWA();
        }
    }

    public void destroy() {
        if (this.eZD != null) {
            this.eZD.destroy();
        }
        if (this.eZA != null) {
            this.eZA.clearAnimation();
        }
        if (this.eZF != null) {
            this.eZF.onDestroy();
        }
    }

    public void onPause() {
        if (this.eZD != null) {
            if (this.eZD.bgb()) {
                this.eZK = true;
                this.eZD.pausePlay();
            } else if (this.eZD.bgg() == 3) {
                this.eZK = false;
            } else {
                this.eZK = false;
                this.eZD.pausePlay();
            }
            if (this.eZW != null) {
                this.eZW.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.eZD != null && this.eZK) {
            this.eZD.aDG();
        }
    }

    private void aWB() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.y(true);
            dVar.A(false);
            dVar.ah(16908290).ag(153).z(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eIw.getActivity());
                    if (i.this.eZZ == null) {
                        try {
                            i.this.eZZ = BitmapFactory.decodeResource(i.this.eIw.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eZZ);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int fi() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int fj() {
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
                public void fl() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.eZY = null;
                    if (i.this.eZZ != null && !i.this.eZZ.isRecycled()) {
                        i.this.eZZ.recycle();
                    }
                    i.this.eZZ = null;
                }
            });
            this.eZY = dVar.fk();
            this.eZY.k(this.eIw.getActivity());
        }
    }

    public boolean pN(int i) {
        if (this.eZD == null) {
            return false;
        }
        return this.eZD.rK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        if (this.eZC != null) {
            com.baidu.tieba.play.k.a(this.eZC.video_md5, "", "1", this.eZE);
        }
    }

    public void aWC() {
        if (this.eZz != null) {
            this.eZz.jV(this.eIw.aRz());
        }
    }

    public void aVm() {
        if (this.eZz != null) {
            this.eZz.aVm();
        }
    }

    public void pH(int i) {
        if (this.eZz != null) {
            this.eZz.pH(i);
        }
        if (this.eZW != null) {
            this.eZW.onChangeSkinType(i);
        }
        if (this.eZF != null) {
            this.eZF.dt(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aWF()) {
            this.eZN = i;
            aWD();
        }
    }

    public void b(AbsListView absListView, int i) {
        if (!aWF() && this.eZV) {
            if (this.eZN == 1) {
                int y = (int) aWG().getY();
                if (i != 0) {
                    y = aWG().getHeight();
                }
                pO(y);
            } else if (this.eZN == 2) {
                int y2 = (int) aWG().getY();
                if (this.eZO == y2) {
                    if (i != 0) {
                        y2 = aWG().getHeight();
                    }
                    pO(y2);
                } else {
                    this.eZO = y2;
                    pO(y2);
                }
                if (i == 0 && this.eZR) {
                    this.eZR = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aWA();
                        }
                    }, 100L);
                }
            } else if (this.eZN == 0) {
                if (this.eZD.bgb()) {
                    pT(aWG().getHeight() - Math.abs((int) aWG().getY()));
                    return;
                }
                int y3 = (int) aWG().getY();
                if (i != 0) {
                    y3 = aWG().getHeight();
                }
                pO(y3);
            }
        }
    }

    private void pO(int i) {
        int height = aWG().getHeight() - Math.abs(i);
        pP(height);
        pR(height);
        pS(height);
        pQ(height);
        pT(height);
        aWD();
    }

    private void pP(int i) {
        if (i <= 0) {
            this.eZD.lx(false);
        } else if (this.eZT >= 1.0d) {
            this.eZD.lx(false);
        } else {
            this.eZD.lx(true);
        }
    }

    private void pQ(int i) {
        if (this.eZF != null) {
            float height = aWG().getHeight() - i;
            float f = height > this.eZP ? 0.0f : 1.0f - (height / this.eZP);
            if (f == 0.0f) {
                this.eZF.aWw().setVisibility(8);
            } else {
                this.eZF.aWw().setVisibility(0);
            }
            this.eZF.ah(f);
        }
    }

    public void aWD() {
        if (this.eZF != null) {
            if (this.eZF.aWw().getVisibility() == 0) {
                this.eIw.aQO().aUe();
                this.eZG = true;
            } else if (this.eZG) {
                this.eIw.aQO().hl(false);
                this.eZG = false;
            }
        }
    }

    private void pR(int i) {
        if (i < this.eZL) {
            if (this.eZz.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.eZz.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.eZz.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.eZL && i <= this.eZL * 2) {
            float f = 1.0f - (((i - this.eZL) * 1.0f) / this.eZL);
            this.eZz.mNavigationBar.getBarBgView().setAlpha(f);
            this.eZz.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.eZL * 2 && this.eZz.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.eZz.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eZz.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void pS(int i) {
        if (i < this.eZL) {
            this.eZz.aVk().setVisibility(0);
            this.eZz.eWp.setVisibility(8);
            this.eZz.cbe.setVisibility(8);
            if (TbadkCoreApplication.isLogin()) {
                this.eZz.eWr.setVisibility(0);
                this.eZz.jX(true);
                return;
            }
            this.eZz.eWr.setVisibility(8);
            this.eZz.jX(false);
            return;
        }
        this.eZz.jW(true);
        this.eZz.aVk().setVisibility(8);
    }

    private void pT(int i) {
        if (i < this.eZS / 2 && this.eZD.bgb()) {
            this.eZK = false;
            if (this.eZz.aVh() != null) {
                this.eZz.aVh().clearAnimation();
            }
            this.eZD.clearAnimation();
            this.eZD.pausePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWE() {
        return aWG().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eZM = false;
        if (this.eZD != null && this.eZA != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZA.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eZY != null) {
                    this.eZY.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eZM = true;
                this.eZA.setLayoutParams(layoutParams);
                if (!this.eZG) {
                    this.eIw.aQO().aUe();
                    this.eZG = true;
                }
            } else {
                b(this.eZC);
                aWC();
                this.eZM = false;
                this.eZz.setTitleVisibility(true);
            }
            this.eZD.a(this.eIw, configuration);
        }
    }

    public boolean aWF() {
        return this.eZM;
    }

    public void w(long j, int i) {
        if (this.eZF != null && j > 0) {
            this.eZF.j(i, j);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.eZF != null) {
            this.eZF.F(onClickListener);
        }
    }

    public View aWG() {
        return this.eZy;
    }

    public boolean aUq() {
        return this.eZQ;
    }

    public void aWH() {
        this.eZR = true;
    }
}
