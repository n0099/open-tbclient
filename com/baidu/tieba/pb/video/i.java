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
    private com.baidu.tieba.play.m bHw;
    private PbActivity eIu;
    private com.baidu.tieba.play.c eZB;
    private w eZC;
    private g eZD;
    private boolean eZE;
    private bl eZF;
    private bl eZG;
    private String eZH;
    private float eZN;
    private int eZQ;
    private double eZR;
    private c.InterfaceC0117c eZS;
    private com.baidu.tieba.pb.view.c eZU;
    private com.baidu.adp.lib.guide.c eZW;
    private Bitmap eZX;
    private RelativeLayout eZw;
    private com.baidu.tieba.pb.pb.main.view.d eZx;
    private FrameLayout eZy;
    private c.InterfaceC0117c eZz;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo eZA = null;
    private boolean eZI = false;
    private int eZJ = 0;
    private boolean eZK = false;
    private int eZL = 0;
    private int eZM = 0;
    private boolean eZO = false;
    private boolean eZP = false;
    private boolean eZT = true;
    private c.a eZV = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kg(false);
        }
    };
    private c.h eZY = new c.h() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.h
        public void aWO() {
            if (i.this.eIu.checkUpIsLogin()) {
                i.this.eIu.aRF();
                if (i.this.eIu.aQU() != null && i.this.eIu.aQU().getPbData() != null && i.this.eIu.aQU().getPbData().aQn() != null) {
                    com.baidu.tieba.pb.data.m aQn = i.this.eIu.aQU().getPbData().aQn();
                    if (i.this.eZU == null) {
                        i.this.eZU = new com.baidu.tieba.pb.view.c(i.this.eIu.getActivity());
                        i.this.eZU.setFloatingHuajiAninationListener(i.this.eZV);
                    }
                    i.this.eZU.startAnimation(!aQn.aQt());
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
            i.this.aVr();
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
    private c.e eZZ = new c.e() { // from class: com.baidu.tieba.pb.video.i.5
        @Override // com.baidu.tieba.play.c.e
        public void aWN() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(boolean z) {
        if (this.eIu.aQU() != null && this.eIu.aQU().getPbData() != null && this.eIu.aQU().getPbData().aQn() != null) {
            com.baidu.tieba.pb.data.m aQn = this.eIu.aQU().getPbData().aQn();
            View findViewById = this.eIu.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aQn.aQt() || z) {
                this.eIu.f(findViewById, 2, false);
                TiebaStatic.log(this.eIu.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQn.aQt() ? 0 : 1));
            } else if (aQn.aQt()) {
                if (aQn.eGu == 1 || aQn.eGu == 3 || aQn.eGu == 4) {
                    this.eIu.f(findViewById, 2, true);
                    TiebaStatic.log(this.eIu.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQn.aQt() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.d dVar, VideoInfo videoInfo) {
        this.eZN = 0.0f;
        this.eIu = pbActivity;
        this.eZx = dVar;
        this.eZN = com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ag = com.baidu.adp.lib.util.k.ag(this.eIu.getActivity());
        Rect s = av.s(this.eIu.getPageContext().getPageActivity());
        int ah = s.height() <= 0 ? com.baidu.adp.lib.util.k.ah(this.eIu.getActivity()) : s.height();
        int i = (int) (ag * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eZR = (intValue2 * 1.0d) / intValue;
            if (this.eZR > 0.5625d) {
                i = Math.min((ag * intValue2) / intValue, ah);
            }
        }
        this.eZQ = i;
        this.eZy.setLayoutParams(new RelativeLayout.LayoutParams(ag, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eZw = (RelativeLayout) LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eZy = (FrameLayout) this.eZw.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.eZB = new com.baidu.tieba.play.c(this.eIu.getPageContext(), this.eZy);
        this.eZB.a(this.eZY);
        if (intValue > 0) {
            if (this.eZR >= 1.0d) {
                this.eZB.lx(false);
            } else {
                this.eZB.lx(true);
            }
            this.eZO = ((float) b) + this.eZN > ((float) com.baidu.adp.lib.util.k.ah(this.eIu.getActivity()));
            if (this.eZO) {
                if (this.eZD == null) {
                    this.eZD = new g(this.eIu.getPageContext(), this.eZy);
                    this.eZD.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kg(true);
                        }
                    });
                }
                this.eIu.aQT().aUj();
                this.eZE = true;
            }
        }
        aWG();
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eIu.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eZz == null) {
            this.eZz = new c.InterfaceC0117c() { // from class: com.baidu.tieba.pb.video.i.9
                @Override // com.baidu.tieba.play.c.InterfaceC0117c
                public void kh(boolean z) {
                    if (i.this.aWJ() && i.this.eZx != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eZx.aVm().clearAnimation();
                        i.this.aWH();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dRl);
                            i.this.eZx.aVm().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0117c
                public void aWP() {
                    if (i.this.aWJ()) {
                        i.this.aVr();
                    }
                }
            };
        }
        a(this.eZz);
        this.eZJ = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bl blVar, String str) {
        if (videoInfo != null && this.eZB != null && blVar != null) {
            this.eZA = videoInfo;
            this.eZF = blVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eZB.stopPlay();
            this.eZB.lv(true);
            this.bHw = new com.baidu.tieba.play.m(this.eIu.getActivity());
            this.eZC = new w();
            this.eZC.mLocate = "pb";
            this.eZC.bDM = blVar.getTid();
            this.eZC.aAC = str;
            this.eZC.mUid = TbadkCoreApplication.getCurrentAccount();
            this.eZC.mSource = blVar.aaC;
            this.eZC.fCr = blVar.aaD;
            this.eZC.fCs = this.eIu.aQR();
            if (blVar.sJ() != null && blVar.sJ().channelId > 0) {
                this.eZC.WK = blVar.sJ().channelId + "";
            } else {
                this.eZC.WK = "0";
            }
            this.eZC.fCt = blVar.aaE;
            this.bHw.setVideoStatsData(this.eZC);
            this.eZB.getVideoView().setBusiness(this.bHw);
            if (this.eZB.aDI()) {
                this.eZB.aDG();
            }
            this.eZB.b(this.eZS);
            this.eZH = null;
            this.eZG = null;
            this.eZB.pP(this.eZH);
            this.eZB.aDC().setOnDragingListener(this.dTZ);
            this.eZB.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.11
                @Override // com.baidu.tieba.play.c.b
                public void aDS() {
                    i.this.eIu.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eZT = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aDR() {
                    i.this.eIu.setSwipeBackEnabled(false);
                    i.this.eZT = false;
                }
            });
            this.eZB.a(new c.d() { // from class: com.baidu.tieba.pb.video.i.12
                @Override // com.baidu.tieba.play.c.d
                public void aWQ() {
                    if (i.this.eIu != null && i.this.eZG != null && !StringUtils.isNull(i.this.eZG.getId())) {
                        i.this.eIu.pn(i.this.eZG.getId());
                        if (i.this.eZF != null) {
                            long j = 0;
                            if (i.this.eZF.sJ() != null) {
                                j = i.this.eZF.sJ().channelId;
                            }
                            TiebaStatic.log(new aj("c11921").g("obj_id", j));
                        }
                    }
                }
            });
            this.eZB.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.f
                public void aWR() {
                    if (i.this.eZF != null) {
                        long j = 0;
                        if (i.this.eZF.sJ() != null) {
                            j = i.this.eZF.sJ().channelId;
                        }
                        i.this.Xa();
                        TiebaStatic.log(new aj("c10795").aa("tid", i.this.eZF.getTid()).g("fid", i.this.eZF.getFid()).g("obj_id", j));
                    }
                }
            });
            this.eZB.a(new f.b() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.f.b
                public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                    TiebaStatic.log(new aj("c12029").r("verrno", i).r("extra", i2));
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.mVideoUrl);
                    return true;
                }
            });
            this.eZB.nh(videoInfo.thumbnail_url);
            this.eZB.bU(videoInfo.play_count.intValue());
            this.eZB.setVideoUrl(this.mVideoUrl);
            this.eZB.qI(blVar.getTitle());
            this.eZB.a(this.eZZ);
            this.eZB.aqk();
            this.eZB.show();
        }
    }

    public void b(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        if (this.eZD != null) {
            this.eZD.a(postData, blVar, mVar);
        }
    }

    public void a(c.InterfaceC0117c interfaceC0117c) {
        this.eZS = interfaceC0117c;
    }

    public void ab(bl blVar) {
        this.eZG = blVar;
    }

    public void pP(String str) {
        this.eZH = str;
        if (this.eZB != null) {
            this.eZB.pP(this.eZH);
        }
    }

    public void startPlay() {
        if (this.eZB != null) {
            this.eZB.qH(this.mVideoUrl);
        }
        Xa();
    }

    public void aWF() {
        if (this.eZB != null) {
            this.eZB.aWF();
        }
    }

    public void destroy() {
        if (this.eZB != null) {
            this.eZB.destroy();
        }
        if (this.eZy != null) {
            this.eZy.clearAnimation();
        }
        if (this.eZD != null) {
            this.eZD.onDestroy();
        }
    }

    public void onPause() {
        if (this.eZB != null) {
            if (this.eZB.bgg()) {
                this.eZI = true;
                this.eZB.pausePlay();
            } else if (this.eZB.bgl() == 3) {
                this.eZI = false;
            } else {
                this.eZI = false;
                this.eZB.pausePlay();
            }
            if (this.eZU != null) {
                this.eZU.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.eZB != null && this.eZI) {
            this.eZB.aDL();
        }
    }

    private void aWG() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.y(true);
            dVar.A(false);
            dVar.ah(16908290).ag(153).z(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eIu.getActivity());
                    if (i.this.eZX == null) {
                        try {
                            i.this.eZX = BitmapFactory.decodeResource(i.this.eIu.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eZX);
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
                    i.this.eZW = null;
                    if (i.this.eZX != null && !i.this.eZX.isRecycled()) {
                        i.this.eZX.recycle();
                    }
                    i.this.eZX = null;
                }
            });
            this.eZW = dVar.fk();
            this.eZW.k(this.eIu.getActivity());
        }
    }

    public boolean pN(int i) {
        if (this.eZB == null) {
            return false;
        }
        return this.eZB.rK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        if (this.eZA != null) {
            com.baidu.tieba.play.k.a(this.eZA.video_md5, "", "1", this.eZC);
        }
    }

    public void aWH() {
        if (this.eZx != null) {
            this.eZx.jV(this.eIu.aRE());
        }
    }

    public void aVr() {
        if (this.eZx != null) {
            this.eZx.aVr();
        }
    }

    public void pH(int i) {
        if (this.eZx != null) {
            this.eZx.pH(i);
        }
        if (this.eZU != null) {
            this.eZU.onChangeSkinType(i);
        }
        if (this.eZD != null) {
            this.eZD.dt(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aWK()) {
            this.eZL = i;
            aWI();
        }
    }

    public void b(AbsListView absListView, int i) {
        if (!aWK() && this.eZT) {
            if (this.eZL == 1) {
                int y = (int) aWL().getY();
                if (i != 0) {
                    y = aWL().getHeight();
                }
                pO(y);
            } else if (this.eZL == 2) {
                int y2 = (int) aWL().getY();
                if (this.eZM == y2) {
                    if (i != 0) {
                        y2 = aWL().getHeight();
                    }
                    pO(y2);
                } else {
                    this.eZM = y2;
                    pO(y2);
                }
                if (i == 0 && this.eZP) {
                    this.eZP = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aWF();
                        }
                    }, 100L);
                }
            } else if (this.eZL == 0) {
                if (this.eZB.bgg()) {
                    pT(aWL().getHeight() - Math.abs((int) aWL().getY()));
                    return;
                }
                int y3 = (int) aWL().getY();
                if (i != 0) {
                    y3 = aWL().getHeight();
                }
                pO(y3);
            }
        }
    }

    private void pO(int i) {
        int height = aWL().getHeight() - Math.abs(i);
        pP(height);
        pR(height);
        pS(height);
        pQ(height);
        pT(height);
        aWI();
    }

    private void pP(int i) {
        if (i <= 0) {
            this.eZB.lx(false);
        } else if (this.eZR >= 1.0d) {
            this.eZB.lx(false);
        } else {
            this.eZB.lx(true);
        }
    }

    private void pQ(int i) {
        if (this.eZD != null) {
            float height = aWL().getHeight() - i;
            float f = height > this.eZN ? 0.0f : 1.0f - (height / this.eZN);
            if (f == 0.0f) {
                this.eZD.aWB().setVisibility(8);
            } else {
                this.eZD.aWB().setVisibility(0);
            }
            this.eZD.ah(f);
        }
    }

    public void aWI() {
        if (this.eZD != null) {
            if (this.eZD.aWB().getVisibility() == 0) {
                this.eIu.aQT().aUj();
                this.eZE = true;
            } else if (this.eZE) {
                this.eIu.aQT().hl(false);
                this.eZE = false;
            }
        }
    }

    private void pR(int i) {
        if (i < this.eZJ) {
            if (this.eZx.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.eZx.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.eZx.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.eZJ && i <= this.eZJ * 2) {
            float f = 1.0f - (((i - this.eZJ) * 1.0f) / this.eZJ);
            this.eZx.mNavigationBar.getBarBgView().setAlpha(f);
            this.eZx.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.eZJ * 2 && this.eZx.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.eZx.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eZx.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void pS(int i) {
        if (i < this.eZJ) {
            this.eZx.aVp().setVisibility(0);
            this.eZx.eWn.setVisibility(8);
            this.eZx.cbd.setVisibility(8);
            if (TbadkCoreApplication.isLogin()) {
                this.eZx.eWp.setVisibility(0);
                this.eZx.jX(true);
                return;
            }
            this.eZx.eWp.setVisibility(8);
            this.eZx.jX(false);
            return;
        }
        this.eZx.jW(true);
        this.eZx.aVp().setVisibility(8);
    }

    private void pT(int i) {
        if (i < this.eZQ / 2 && this.eZB.bgg()) {
            this.eZI = false;
            if (this.eZx.aVm() != null) {
                this.eZx.aVm().clearAnimation();
            }
            this.eZB.clearAnimation();
            this.eZB.pausePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWJ() {
        return aWL().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eZK = false;
        if (this.eZB != null && this.eZy != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZy.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eZW != null) {
                    this.eZW.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eZK = true;
                this.eZy.setLayoutParams(layoutParams);
                if (!this.eZE) {
                    this.eIu.aQT().aUj();
                    this.eZE = true;
                }
            } else {
                b(this.eZA);
                aWH();
                this.eZK = false;
                this.eZx.setTitleVisibility(true);
            }
            this.eZB.a(this.eIu, configuration);
        }
    }

    public boolean aWK() {
        return this.eZK;
    }

    public void w(long j, int i) {
        if (this.eZD != null && j > 0) {
            this.eZD.j(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.eZD != null) {
            this.eZD.J(onClickListener);
        }
    }

    public View aWL() {
        return this.eZw;
    }

    public boolean aUv() {
        return this.eZO;
    }

    public void aWM() {
        this.eZP = true;
    }
}
