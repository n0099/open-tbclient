package com.baidu.tieba.pb.video;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private static VideoControllerView.a eTK = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Ri() {
        }
    };
    private static c.h fND = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void awn() {
        }
    };
    private n bvr;
    private com.baidu.tieba.play.c dqX;
    private RelativeLayout fMV;
    private com.baidu.tieba.pb.pb.main.view.b fMW;
    private CustomFrameLayout fMX;
    private c.InterfaceC0218c fMY;
    private int fNC;
    private y fNa;
    private g fNb;
    private boolean fNc;
    private bb fNd;
    private bb fNe;
    private String fNf;
    private float fNl;
    private int fNo;
    private double fNp;
    private float fNq;
    private long fNr;
    private PbVideoWifiTipLayout fNs;
    private c.InterfaceC0218c fNt;
    private PbFullScreenFloatingHuajiAninationView fNv;
    private com.baidu.adp.lib.guide.c fNx;
    private Bitmap fNy;
    private boolean fNz;
    private PbActivity fxt;
    private View mEmptyView;
    private Handler mHandler;
    private String bdb = null;
    private VideoInfo fMZ = null;
    private boolean fNg = false;
    private int fNh = 0;
    private boolean fNi = false;
    private int fNj = 0;
    private int fNk = 0;
    private boolean fNm = false;
    private boolean fNn = false;
    private boolean fNu = true;
    private PbFullScreenFloatingHuajiAninationView.a fNw = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.kO(false);
        }
    };
    private boolean fNA = false;
    private c.l fNB = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void bgz() {
            if (i.this.fxt.checkUpIsLogin()) {
                i.this.fxt.bbv();
                if (i.this.fxt.bat() != null && i.this.fxt.bat().getPbData() != null && i.this.fxt.bat().getPbData().aZL() != null) {
                    j aZL = i.this.fxt.bat().getPbData().aZL();
                    if (i.this.fNv == null) {
                        i.this.fNv = new PbFullScreenFloatingHuajiAninationView(i.this.fxt.getActivity());
                        i.this.fNv.setFloatingHuajiAninationListener(i.this.fNw);
                    }
                    i.this.fNv.kQ(!aZL.aZT());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dqX != null) {
                    i.this.dqX.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.jE() && com.baidu.adp.lib.util.j.jG() && i.this.dqX != null && i.this.dqX.bjU() && i.this.fMZ != null && i.this.fMZ.video_length.intValue() > 0 && i.this.fMZ.video_duration.intValue() > 0) {
                    float intValue = i.this.fMZ.video_length.intValue() * (1.0f - ((i.this.dqX.getCurrentPosition() * 1.0f) / (i.this.fMZ.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fxt.getPageContext().getPageActivity(), String.format(i.this.fxt.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eRM = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bfl();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(boolean z) {
        if (this.fxt.bat() != null && this.fxt.bat().getPbData() != null && this.fxt.bat().getPbData().aZL() != null) {
            j aZL = this.fxt.bat().getPbData().aZL();
            View findViewById = this.fxt.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aZL.aZT() || z) {
                this.fxt.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fxt.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZL.aZT() ? 0 : 1));
            } else if (aZL.aZT()) {
                if (aZL.ftm == 1 || aZL.ftm == 3 || aZL.ftm == 4) {
                    this.fxt.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fxt.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZL.aZT() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fNl = 0.0f;
        this.fxt = pbActivity;
        this.fMW = bVar;
        this.fNl = l.f(this.fxt.getActivity(), d.e.ds240);
        this.fNr = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int ah = l.ah(this.fxt.getActivity());
        Rect t = az.t(this.fxt.getPageContext().getPageActivity());
        int aj = t.height() <= 0 ? l.aj(this.fxt.getActivity()) : t.height();
        int i = (int) (ah * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fNp = (intValue2 * 1.0d) / intValue;
            if (this.fNp > 0.5625d) {
                i = Math.min((ah * intValue2) / intValue, aj);
            }
        }
        this.fNo = i;
        this.fMX.setLayoutParams(new RelativeLayout.LayoutParams(ah, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.fMV = (RelativeLayout) LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fMX = (CustomFrameLayout) this.fMV.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dqX = new com.baidu.tieba.play.c(this.fxt.getPageContext(), this.fMX, true);
        this.dqX.a(this.fNB);
        this.dqX.lt(false);
        this.dqX.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // com.baidu.tieba.play.c.j
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.j
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.j
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.fNq = motionEvent.getY();
                        if (i.this.fxt.getListView() != null && i.this.fxt.getListView().getChildCount() > 0 && i.this.fxt.getListView().getChildAt(0) == i.this.bgx()) {
                            i.this.fNC = i.this.bgx().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.fNq = 0.0f;
                        i.this.fNC = 0;
                        break;
                    case 2:
                        if (i.this.fxt.getListView() != null && i.this.fxt.getListView().getChildCount() > 0 && i.this.fxt.getListView().getChildAt(0) == i.this.bgx()) {
                            i.this.fxt.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.fNq)) + i.this.fNC);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fNp >= 1.0d) {
                this.dqX.N(false, true);
            } else {
                this.dqX.N(true, false);
            }
            this.fNm = ((float) e) + this.fNl > ((float) l.aj(this.fxt.getActivity()));
            if (this.fNm) {
                if (this.fNb == null) {
                    this.fNb = new g(this.fxt.getPageContext(), this.fMX);
                    this.fNb.M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kO(true);
                        }
                    });
                }
                this.fxt.baK().bez();
                this.fNc = true;
            }
        }
        bgq();
        this.mEmptyView = new View(this.fxt);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fNo));
        if (this.fMW != null && this.fMW.mNavigationBar != null) {
            this.fMW.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fMW.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fMW.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.yg() ? 0 : 8);
        }
        this.fNs = (PbVideoWifiTipLayout) this.fMV.findViewById(d.g.layout_wifi_tip);
        this.fNs.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fNz = true;
                i.this.fNs.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fxt.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fMY == null) {
            this.fMY = new c.InterfaceC0218c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (i.this.bgt() && i.this.fMW != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fMW.bff().clearAnimation();
                        i.this.bgr();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eRM);
                            i.this.fMW.bff().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awm() {
                    if (i.this.bgt()) {
                        i.this.bfl();
                    }
                }
            };
        }
        a(this.fMY);
        this.fNh = UtilHelper.getLightStatusBarHeight() + l.f(this.fxt.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dqX != null && bbVar != null) {
            this.fMZ = videoInfo;
            this.fNd = bbVar;
            this.bdb = videoInfo.video_url;
            this.dqX.stopPlay();
            this.dqX.setIsNeedRecoveryVideoPlayer(true);
            this.bvr = new n(this.fxt.getActivity());
            this.fNa = new y();
            this.fNa.mLocate = "pb";
            this.fNa.aWq = bbVar.getTid();
            this.fNa.cBU = str;
            this.fNa.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fNa.mSource = bbVar.mRecomSource;
            this.fNa.ghD = bbVar.mRecomWeight;
            this.fNa.ghE = this.fxt.baI();
            this.fNa.ghF = bbVar.mRecomAbTag;
            this.fNa.ghG = videoInfo.video_md5;
            y bkX = this.fNa.bkX();
            bkX.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bvr.setVideoStatsData(bkX);
            this.dqX.getVideoView().setBusiness(this.bvr);
            if (this.dqX.aSe()) {
                this.dqX.aSc();
            }
            this.dqX.b(this.fNt);
            this.fNf = null;
            this.fNe = null;
            this.dqX.rG(this.fNf);
            this.dqX.aRY().setOnDragingListener(eTK);
            this.dqX.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void awj() {
                    i.this.fxt.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fNu = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                    i.this.fxt.setSwipeBackEnabled(false);
                    i.this.fNu = false;
                }
            });
            this.dqX.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bgy() {
                    if (i.this.fxt != null && i.this.fNe != null && !StringUtils.isNull(i.this.fNe.getId())) {
                        i.this.fxt.rb(i.this.fNe.getId());
                        if (i.this.fNd != null) {
                            long j = 0;
                            if (i.this.fNd.wl() != null) {
                                j = i.this.fNd.wl().channelId;
                            }
                            TiebaStatic.log(new an("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dqX.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void kP(boolean z) {
                    if (i.this.fNd != null) {
                        long j = 0;
                        if (i.this.fNd.wl() != null) {
                            j = i.this.fNd.wl().channelId;
                        }
                        i.this.mx(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").af("tid", i.this.fNd.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fNd.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dqX.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bdb);
                    return true;
                }
            });
            this.dqX.setThumbnail(videoInfo.thumbnail_url);
            this.dqX.setVideoUrl(this.bdb, bbVar.getTid());
            this.dqX.sa(bbVar.getTitle());
            this.dqX.a(fND);
            this.dqX.aFd();
            this.dqX.show();
        }
    }

    public void rF(String str) {
        if (this.fNa != null) {
            this.fNa.cBU = str;
        }
    }

    public void b(PostData postData, bb bbVar, j jVar) {
        if (this.fNb != null) {
            this.fNb.a(postData, bbVar, jVar);
        }
    }

    public void a(c.InterfaceC0218c interfaceC0218c) {
        this.fNt = interfaceC0218c;
    }

    public void ar(bb bbVar) {
        this.fNe = bbVar;
    }

    public void rG(String str) {
        this.fNf = str;
        if (this.dqX != null) {
            this.dqX.rG(this.fNf);
        }
    }

    public void startPlay() {
        if (this.dqX != null) {
            if (com.baidu.adp.lib.util.j.jG() && !this.fNz && !com.baidu.tieba.video.g.bAi().bAj()) {
                this.fNs.setVisibility(0);
                this.fNs.setData(this.fMZ);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bdb) && this.fNd != null && this.fNd.vC() != null) {
                TiebaStatic.log(new an("c12619").af("obj_locate", "pb").af("tid", this.fNd.getTid()));
                this.bdb = this.fNd.vC().video_url;
            }
            this.dqX.b(this.bdb, this.fNd == null ? "" : this.fNd.getTid(), this.fNr);
            mx("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bgp() {
        if (this.dqX != null) {
            this.dqX.bgp();
        }
    }

    public void destroy() {
        if (this.dqX != null) {
            this.dqX.destroy();
        }
        if (this.fMX != null) {
            this.fMX.clearAnimation();
        }
        if (this.fNb != null) {
            this.fNb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dqX != null) {
            if (this.dqX.bjU()) {
                this.fNg = true;
                this.dqX.pausePlay();
            } else if (this.dqX.getCurrentState() == 3) {
                this.fNg = false;
            } else {
                this.fNg = false;
                this.dqX.pausePlay();
            }
            if (this.fNv != null) {
                this.fNv.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dqX != null && this.fNg) {
            this.dqX.aSg();
        }
    }

    private void bgq() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.D(true);
            dVar.F(false);
            dVar.Y(16908290).X(153).E(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fxt.getActivity());
                    if (i.this.fNy == null) {
                        try {
                            i.this.fNy = BitmapFactory.decodeResource(i.this.fxt.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fNy);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hw() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hx() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fNx = null;
                    if (i.this.fNy != null && !i.this.fNy.isRecycled()) {
                        i.this.fNy.recycle();
                    }
                    i.this.fNy = null;
                }
            });
            this.fNx = dVar.hy();
            this.fNx.l(this.fxt.getActivity());
        }
    }

    public boolean kM(int i) {
        if (this.dqX == null) {
            return false;
        }
        return this.dqX.rE(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(String str) {
        if (this.fMZ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fMZ.video_md5, "", str, this.fNa);
            }
        }
    }

    public void bgr() {
        if (this.fMW != null) {
            this.fMW.kE(this.fxt.bbu());
        }
    }

    public void bfl() {
        if (this.fMW != null) {
            this.fMW.bfl();
        }
    }

    public void qV(int i) {
        if (this.fMW != null) {
            this.fMW.qV(i);
        }
        if (this.fNv != null) {
            this.fNv.onChangeSkinType(i);
        }
        if (this.fNb != null) {
            this.fNb.dG(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bgu()) {
                    this.fNj = i;
                    if (this.fNj == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.rc(i.this.bgv().getHeight());
                            }
                        }, 100L);
                    }
                    bgs();
                    return;
                }
                return;
        }
    }

    private void rb(int i) {
        if (bgv().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMX.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fNo != bgv().getHeight()) {
                        this.fMX.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.fxt.getActivity()), Math.min(this.fNo, bgv().getHeight() + i)));
                        this.dqX.aSc();
                    }
                } else if (l.ah(this.fxt.getActivity()) * 0.5625d != bgv().getHeight()) {
                    this.fMX.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.fxt.getActivity()), (int) Math.max(l.ah(this.fxt.getActivity()) * 0.5625d, bgv().getHeight() + i)));
                    this.dqX.aSc();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bgx()) {
                int bottom = childAt.getBottom() - bgv().getBottom();
                if (childAt.getHeight() == 0 || bgv().getHeight() == 0) {
                    bottom = 0;
                }
                rb(bottom);
            } else {
                rb((-this.fNo) + 2);
            }
        }
        if (!bgu() && this.fNu) {
            if (this.fNj == 1) {
                this.fNA = true;
                rc(bgv().getHeight());
            } else if (this.fNj == 2) {
                this.fNA = true;
                int y = (int) bgv().getY();
                if (this.fNk == y) {
                    rc(bgv().getHeight());
                } else {
                    this.fNk = y;
                    rc(bgv().getHeight());
                }
                if (i == 0 && this.fNn) {
                    this.fNn = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bgp();
                        }
                    }, 100L);
                }
            } else if (this.fNj == 0) {
                if (this.fNA || !"nani_midpage".equals(this.fxt.baI())) {
                    rc(bgv().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(int i) {
        rd(i);
        bgs();
    }

    private void rd(int i) {
        if (this.fNb != null) {
            if (i == 0) {
                i = this.fNo;
            }
            float f = this.fNo - i;
            float f2 = f > this.fNl ? 0.0f : 1.0f - (f / this.fNl);
            if (f2 == 0.0f) {
                this.fNb.bgl().setVisibility(8);
            } else {
                this.fNb.bgl().setVisibility(0);
            }
            this.fNb.as(f2);
        }
    }

    public void bgs() {
        if (this.fNb != null) {
            if (bgu()) {
                this.fxt.baK().bez();
            } else if (this.fNb.bgl().getVisibility() == 0) {
                this.fxt.baK().bez();
                this.fNc = true;
            } else if (this.fNc) {
                this.fxt.baK().kq(false);
                this.fNc = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgt() {
        return bgv().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fNi = false;
        if (this.dqX != null && this.fMX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMX.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fNx != null) {
                    this.fNx.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fNi = true;
                this.fMX.setLayoutParams(layoutParams);
                this.fxt.baK().bez();
                this.fNc = true;
            } else {
                e(this.fMZ);
                bgr();
                this.fNi = false;
                this.fMW.kD(true);
            }
            this.dqX.a(this.fxt.getPageContext(), configuration);
        }
    }

    public boolean bgu() {
        return this.fNi;
    }

    public void k(long j, int i) {
        if (this.fNb != null && j > 0) {
            this.fNb.l(i, j);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.fNb != null) {
            this.fNb.L(onClickListener);
        }
    }

    public View bgv() {
        return this.fMV;
    }

    public boolean beI() {
        if (bgv() == null) {
            return false;
        }
        return bgv().getBottom() > l.aj(bgv().getContext()) - l.f(bgv().getContext(), d.e.ds50);
    }

    public void bgw() {
        this.fNn = true;
    }

    public View bgx() {
        return this.mEmptyView;
    }
}
