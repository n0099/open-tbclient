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
    private com.baidu.tieba.play.m bGN;
    private PbActivity eGA;
    private RelativeLayout eXD;
    private com.baidu.tieba.pb.pb.main.view.d eXE;
    private FrameLayout eXF;
    private c.InterfaceC0116c eXG;
    private com.baidu.tieba.play.c eXI;
    private w eXJ;
    private g eXK;
    private boolean eXL;
    private bl eXM;
    private bl eXN;
    private String eXO;
    private float eXU;
    private int eXX;
    private double eXY;
    private c.InterfaceC0116c eXZ;
    private com.baidu.tieba.pb.view.c eYb;
    private com.baidu.adp.lib.guide.c eYd;
    private Bitmap eYe;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo eXH = null;
    private boolean eXP = false;
    private int eXQ = 0;
    private boolean eXR = false;
    private int eXS = 0;
    private int eXT = 0;
    private boolean eXV = false;
    private boolean eXW = false;
    private boolean eYa = true;
    private c.a eYc = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kd(false);
        }
    };
    private c.h eYf = new c.h() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.h
        public void aWh() {
            if (i.this.eGA.checkUpIsLogin()) {
                i.this.eGA.aQY();
                if (i.this.eGA.aQn() != null && i.this.eGA.aQn().getPbData() != null && i.this.eGA.aQn().getPbData().aPG() != null) {
                    com.baidu.tieba.pb.data.m aPG = i.this.eGA.aQn().getPbData().aPG();
                    if (i.this.eYb == null) {
                        i.this.eYb = new com.baidu.tieba.pb.view.c(i.this.eGA.getActivity());
                        i.this.eYb.setFloatingHuajiAninationListener(i.this.eYc);
                    }
                    i.this.eYb.startAnimation(!aPG.aPM());
                }
            }
        }
    };
    private Animation.AnimationListener dPp = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aUK();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private s.a dSd = new s.a() { // from class: com.baidu.tieba.pb.video.i.4
        @Override // com.baidu.tieba.play.s.a
        public void Lf() {
        }
    };
    private c.e eYg = new c.e() { // from class: com.baidu.tieba.pb.video.i.5
        @Override // com.baidu.tieba.play.c.e
        public void aWg() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (this.eGA.aQn() != null && this.eGA.aQn().getPbData() != null && this.eGA.aQn().getPbData().aPG() != null) {
            com.baidu.tieba.pb.data.m aPG = this.eGA.aQn().getPbData().aPG();
            View findViewById = this.eGA.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aPG.aPM() || z) {
                this.eGA.f(findViewById, 2, false);
                TiebaStatic.log(this.eGA.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPG.aPM() ? 0 : 1));
            } else if (aPG.aPM()) {
                if (aPG.eEA == 1 || aPG.eEA == 3 || aPG.eEA == 4) {
                    this.eGA.f(findViewById, 2, true);
                    TiebaStatic.log(this.eGA.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPG.aPM() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.d dVar, VideoInfo videoInfo) {
        this.eXU = 0.0f;
        this.eGA = pbActivity;
        this.eXE = dVar;
        this.eXU = com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ag = com.baidu.adp.lib.util.k.ag(this.eGA.getActivity());
        Rect s = av.s(this.eGA.getPageContext().getPageActivity());
        int ah = s.height() <= 0 ? com.baidu.adp.lib.util.k.ah(this.eGA.getActivity()) : s.height();
        int i = (int) (ag * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eXY = (intValue2 * 1.0d) / intValue;
            if (this.eXY > 0.5625d) {
                i = Math.min((ag * intValue2) / intValue, ah);
            }
        }
        this.eXX = i;
        this.eXF.setLayoutParams(new RelativeLayout.LayoutParams(ag, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eXD = (RelativeLayout) LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eXF = (FrameLayout) this.eXD.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.eXI = new com.baidu.tieba.play.c(this.eGA.getPageContext(), this.eXF);
        this.eXI.a(this.eYf);
        if (intValue > 0) {
            if (this.eXY >= 1.0d) {
                this.eXI.lu(false);
            } else {
                this.eXI.lu(true);
            }
            this.eXV = ((float) b) + this.eXU > ((float) com.baidu.adp.lib.util.k.ah(this.eGA.getActivity()));
            if (this.eXV) {
                if (this.eXK == null) {
                    this.eXK = new g(this.eGA.getPageContext(), this.eXF);
                    this.eXK.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kd(true);
                        }
                    });
                }
                this.eGA.aQm().aTC();
                this.eXL = true;
            }
        }
        aVZ();
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eGA.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eXG == null) {
            this.eXG = new c.InterfaceC0116c() { // from class: com.baidu.tieba.pb.video.i.9
                @Override // com.baidu.tieba.play.c.InterfaceC0116c
                public void ke(boolean z) {
                    if (i.this.aWc() && i.this.eXE != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eXE.aUF().clearAnimation();
                        i.this.aWa();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dPp);
                            i.this.eXE.aUF().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0116c
                public void aWi() {
                    if (i.this.aWc()) {
                        i.this.aUK();
                    }
                }
            };
        }
        a(this.eXG);
        this.eXQ = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bl blVar, String str) {
        if (videoInfo != null && this.eXI != null && blVar != null) {
            this.eXH = videoInfo;
            this.eXM = blVar;
            this.mVideoUrl = videoInfo.video_url;
            this.eXI.stopPlay();
            this.eXI.ls(true);
            this.bGN = new com.baidu.tieba.play.m(this.eGA.getActivity());
            this.eXJ = new w();
            this.eXJ.mLocate = "pb";
            this.eXJ.bDd = blVar.getTid();
            this.eXJ.aAB = str;
            this.eXJ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.eXJ.mSource = blVar.aaA;
            this.eXJ.fAy = blVar.aaB;
            this.eXJ.fAz = this.eGA.aQk();
            if (blVar.sJ() != null && blVar.sJ().channelId > 0) {
                this.eXJ.WI = blVar.sJ().channelId + "";
            } else {
                this.eXJ.WI = "0";
            }
            this.eXJ.fAA = blVar.aaC;
            this.bGN.setVideoStatsData(this.eXJ);
            this.eXI.getVideoView().setBusiness(this.bGN);
            if (this.eXI.aDb()) {
                this.eXI.aCZ();
            }
            this.eXI.b(this.eXZ);
            this.eXO = null;
            this.eXN = null;
            this.eXI.pN(this.eXO);
            this.eXI.aCV().setOnDragingListener(this.dSd);
            this.eXI.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.11
                @Override // com.baidu.tieba.play.c.b
                public void aDl() {
                    i.this.eGA.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eYa = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aDk() {
                    i.this.eGA.setSwipeBackEnabled(false);
                    i.this.eYa = false;
                }
            });
            this.eXI.a(new c.d() { // from class: com.baidu.tieba.pb.video.i.12
                @Override // com.baidu.tieba.play.c.d
                public void aWj() {
                    if (i.this.eGA != null && i.this.eXN != null && !StringUtils.isNull(i.this.eXN.getId())) {
                        i.this.eGA.pj(i.this.eXN.getId());
                        if (i.this.eXM != null) {
                            long j = 0;
                            if (i.this.eXM.sJ() != null) {
                                j = i.this.eXM.sJ().channelId;
                            }
                            TiebaStatic.log(new aj("c11921").g("obj_id", j));
                        }
                    }
                }
            });
            this.eXI.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.f
                public void aWk() {
                    if (i.this.eXM != null) {
                        long j = 0;
                        if (i.this.eXM.sJ() != null) {
                            j = i.this.eXM.sJ().channelId;
                        }
                        i.this.WE();
                        TiebaStatic.log(new aj("c10795").aa("tid", i.this.eXM.getTid()).g("fid", i.this.eXM.getFid()).g("obj_id", j));
                    }
                }
            });
            this.eXI.a(new f.b() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.f.b
                public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                    TiebaStatic.log(new aj("c12029").r("verrno", i).r("extra", i2));
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.mVideoUrl);
                    return true;
                }
            });
            this.eXI.nd(videoInfo.thumbnail_url);
            this.eXI.bU(videoInfo.play_count.intValue());
            this.eXI.setVideoUrl(this.mVideoUrl);
            this.eXI.qG(blVar.getTitle());
            this.eXI.a(this.eYg);
            this.eXI.apD();
            this.eXI.show();
        }
    }

    public void b(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        if (this.eXK != null) {
            this.eXK.a(postData, blVar, mVar);
        }
    }

    public void a(c.InterfaceC0116c interfaceC0116c) {
        this.eXZ = interfaceC0116c;
    }

    public void ab(bl blVar) {
        this.eXN = blVar;
    }

    public void pN(String str) {
        this.eXO = str;
        if (this.eXI != null) {
            this.eXI.pN(this.eXO);
        }
    }

    public void startPlay() {
        if (this.eXI != null) {
            this.eXI.qF(this.mVideoUrl);
        }
        WE();
    }

    public void aVY() {
        if (this.eXI != null) {
            this.eXI.aVY();
        }
    }

    public void destroy() {
        if (this.eXI != null) {
            this.eXI.destroy();
        }
        if (this.eXF != null) {
            this.eXF.clearAnimation();
        }
        if (this.eXK != null) {
            this.eXK.onDestroy();
        }
    }

    public void onPause() {
        if (this.eXI != null) {
            if (this.eXI.bfA()) {
                this.eXP = true;
                this.eXI.pausePlay();
            } else if (this.eXI.bfF() == 3) {
                this.eXP = false;
            } else {
                this.eXP = false;
                this.eXI.pausePlay();
            }
            if (this.eYb != null) {
                this.eYb.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.eXI != null && this.eXP) {
            this.eXI.aDe();
        }
    }

    private void aVZ() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.y(true);
            dVar.A(false);
            dVar.ah(16908290).ag(153).z(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eGA.getActivity());
                    if (i.this.eYe == null) {
                        try {
                            i.this.eYe = BitmapFactory.decodeResource(i.this.eGA.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eYe);
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
                    i.this.eYd = null;
                    if (i.this.eYe != null && !i.this.eYe.isRecycled()) {
                        i.this.eYe.recycle();
                    }
                    i.this.eYe = null;
                }
            });
            this.eYd = dVar.fk();
            this.eYd.k(this.eGA.getActivity());
        }
    }

    public boolean pD(int i) {
        if (this.eXI == null) {
            return false;
        }
        return this.eXI.rA(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        if (this.eXH != null) {
            com.baidu.tieba.play.k.a(this.eXH.video_md5, "", "1", this.eXJ);
        }
    }

    public void aWa() {
        if (this.eXE != null) {
            this.eXE.jS(this.eGA.aQX());
        }
    }

    public void aUK() {
        if (this.eXE != null) {
            this.eXE.aUK();
        }
    }

    public void px(int i) {
        if (this.eXE != null) {
            this.eXE.px(i);
        }
        if (this.eYb != null) {
            this.eYb.onChangeSkinType(i);
        }
        if (this.eXK != null) {
            this.eXK.dt(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aWd()) {
            this.eXS = i;
            aWb();
        }
    }

    public void b(AbsListView absListView, int i) {
        if (!aWd() && this.eYa) {
            if (this.eXS == 1) {
                int y = (int) aWe().getY();
                if (i != 0) {
                    y = aWe().getHeight();
                }
                pE(y);
            } else if (this.eXS == 2) {
                int y2 = (int) aWe().getY();
                if (this.eXT == y2) {
                    if (i != 0) {
                        y2 = aWe().getHeight();
                    }
                    pE(y2);
                } else {
                    this.eXT = y2;
                    pE(y2);
                }
                if (i == 0 && this.eXW) {
                    this.eXW = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aVY();
                        }
                    }, 100L);
                }
            } else if (this.eXS == 0) {
                if (this.eXI.bfA()) {
                    pJ(aWe().getHeight() - Math.abs((int) aWe().getY()));
                    return;
                }
                int y3 = (int) aWe().getY();
                if (i != 0) {
                    y3 = aWe().getHeight();
                }
                pE(y3);
            }
        }
    }

    private void pE(int i) {
        int height = aWe().getHeight() - Math.abs(i);
        pF(height);
        pH(height);
        pI(height);
        pG(height);
        pJ(height);
        aWb();
    }

    private void pF(int i) {
        if (i <= 0) {
            this.eXI.lu(false);
        } else if (this.eXY >= 1.0d) {
            this.eXI.lu(false);
        } else {
            this.eXI.lu(true);
        }
    }

    private void pG(int i) {
        if (this.eXK != null) {
            float height = aWe().getHeight() - i;
            float f = height > this.eXU ? 0.0f : 1.0f - (height / this.eXU);
            if (f == 0.0f) {
                this.eXK.aVU().setVisibility(8);
            } else {
                this.eXK.aVU().setVisibility(0);
            }
            this.eXK.ah(f);
        }
    }

    public void aWb() {
        if (this.eXK != null) {
            if (this.eXK.aVU().getVisibility() == 0) {
                this.eGA.aQm().aTC();
                this.eXL = true;
            } else if (this.eXL) {
                this.eGA.aQm().hi(false);
                this.eXL = false;
            }
        }
    }

    private void pH(int i) {
        if (i < this.eXQ) {
            if (this.eXE.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.eXE.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.eXE.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= this.eXQ && i <= this.eXQ * 2) {
            float f = 1.0f - (((i - this.eXQ) * 1.0f) / this.eXQ);
            this.eXE.mNavigationBar.getBarBgView().setAlpha(f);
            this.eXE.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > this.eXQ * 2 && this.eXE.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.eXE.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eXE.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void pI(int i) {
        if (i < this.eXQ) {
            this.eXE.aUI().setVisibility(0);
            this.eXE.eUu.setVisibility(8);
            this.eXE.car.setVisibility(8);
            if (TbadkCoreApplication.isLogin()) {
                this.eXE.eUw.setVisibility(0);
                this.eXE.jU(true);
                return;
            }
            this.eXE.eUw.setVisibility(8);
            this.eXE.jU(false);
            return;
        }
        this.eXE.jT(true);
        this.eXE.aUI().setVisibility(8);
    }

    private void pJ(int i) {
        if (i < this.eXX / 2 && this.eXI.bfA()) {
            this.eXP = false;
            if (this.eXE.aUF() != null) {
                this.eXE.aUF().clearAnimation();
            }
            this.eXI.clearAnimation();
            this.eXI.pausePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWc() {
        return aWe().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eXR = false;
        if (this.eXI != null && this.eXF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eXF.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eYd != null) {
                    this.eYd.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eXR = true;
                this.eXF.setLayoutParams(layoutParams);
                if (!this.eXL) {
                    this.eGA.aQm().aTC();
                    this.eXL = true;
                }
            } else {
                b(this.eXH);
                aWa();
                this.eXR = false;
                this.eXE.setTitleVisibility(true);
            }
            this.eXI.a(this.eGA, configuration);
        }
    }

    public boolean aWd() {
        return this.eXR;
    }

    public void w(long j, int i) {
        if (this.eXK != null && j > 0) {
            this.eXK.j(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.eXK != null) {
            this.eXK.J(onClickListener);
        }
    }

    public View aWe() {
        return this.eXD;
    }

    public boolean aTO() {
        return this.eXV;
    }

    public void aWf() {
        this.eXW = true;
    }
}
