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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class i {
    private static VideoControllerView.a fkd = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Vg() {
        }
    };
    private static c.i geq = new c.i() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.i
        public void aBn() {
        }
    };
    private n bKA;
    private com.baidu.tieba.play.c dGz;
    private PbActivity fOe;
    private RelativeLayout gdG;
    private com.baidu.tieba.pb.pb.main.view.b gdH;
    private CustomFrameLayout gdI;
    private c.d gdJ;
    private z gdL;
    private g gdM;
    private boolean gdN;
    private bb gdO;
    private bb gdP;
    private String gdQ;
    private float gdW;
    private int gdZ;
    private double gea;
    private long geb;
    private PbVideoWifiTipLayout gec;
    private int ged;
    private c.d gee;
    private PbFullScreenFloatingHuajiAninationView geg;
    private com.baidu.adp.lib.guide.c gei;
    private Bitmap gej;
    private boolean gek;
    private boolean gem;
    private int gep;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aBn = null;
    private VideoInfo gdK = null;
    private boolean gdR = false;
    private int gdS = 0;
    private boolean gdT = false;
    private int gdU = 0;
    private int gdV = 0;
    private boolean gdX = false;
    private boolean gdY = false;
    private boolean gef = true;
    private PbFullScreenFloatingHuajiAninationView.a geh = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lM(false);
        }
    };
    private boolean gel = false;
    private c.m gen = new c.m() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.m
        public boolean blF() {
            if (i.this.fOe.checkUpIsLogin()) {
                i.this.fOe.bgA();
                if (i.this.fOe.bfx() == null || i.this.fOe.bfx().getPbData() == null || i.this.fOe.bfx().getPbData().beR() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i beR = i.this.fOe.bfx().getPbData().beR();
                if (i.this.geg == null) {
                    i.this.geg = new PbFullScreenFloatingHuajiAninationView(i.this.fOe.getActivity());
                    i.this.geg.setFloatingHuajiAninationListener(i.this.geh);
                }
                i.this.geg.lO(beR.beX() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean blG() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dGz != null) {
                    i.this.dGz.setNetworkChange();
                }
                if (j.kV() && j.kX() && i.this.dGz != null && i.this.dGz.bpd() && i.this.gdK != null && i.this.gdK.video_length.intValue() > 0 && i.this.gdK.video_duration.intValue() > 0) {
                    float intValue = i.this.gdK.video_length.intValue() * (1.0f - ((i.this.dGz.getCurrentPosition() * 1.0f) / (i.this.gdK.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fOe.getPageContext().getPageActivity(), String.format(i.this.fOe.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fie = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bkt();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(boolean z) {
        if (this.fOe != null) {
            this.fOe.bfQ();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.gdW = 0.0f;
        this.fOe = pbActivity;
        this.gdH = bVar;
        this.gdW = l.h(this.fOe.getActivity(), e.C0200e.ds240);
        this.geb = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fOe.getActivity());
        Rect y = az.y(this.fOe.getPageContext().getPageActivity());
        int aQ = y.height() <= 0 ? l.aQ(this.fOe.getActivity()) : y.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gea = (intValue2 * 1.0d) / intValue;
            if (this.gea > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.gdZ = i;
        this.gdI.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.gdG = (RelativeLayout) LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gdI = (CustomFrameLayout) this.gdG.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dGz = new com.baidu.tieba.play.c((TbPageContext<?>) this.fOe.getPageContext(), (View) this.gdI, true);
        this.dGz.a(this.gen);
        this.dGz.mu(false);
        this.dGz.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.12
            @Override // com.baidu.tieba.play.c.k
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.k
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.k
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.fOe.getListView() != null && i.this.fOe.getListView().getChildCount() > 0 && i.this.fOe.getListView().getChildAt(0) == i.this.blE()) {
                            i.this.gep = i.this.blE().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gep = 0;
                        break;
                    case 2:
                        if (i.this.fOe.getListView() != null && i.this.fOe.getListView().getChildCount() > 0 && i.this.fOe.getListView().getChildAt(0) == i.this.blE()) {
                            i.this.fOe.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gep);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gea >= 1.0d) {
                this.dGz.S(false, true);
            } else {
                this.dGz.S(true, false);
            }
            this.gdX = ((float) e) + this.gdW > ((float) l.aQ(this.fOe.getActivity()));
            if (this.gdX) {
                if (this.gdM == null) {
                    this.gdM = new g(this.fOe.getPageContext(), this.gdI);
                }
                this.fOe.bfO().bjC();
                this.gdN = true;
            }
        }
        blw();
        this.mEmptyView = new View(this.fOe);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gdZ));
        if (this.gdH != null && this.gdH.mNavigationBar != null) {
            this.gdH.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gdH.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gdH.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.BB() ? 0 : 8);
        }
        this.gec = (PbVideoWifiTipLayout) this.gdG.findViewById(e.g.layout_wifi_tip);
        this.gec.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gek = true;
                i.this.gec.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fOe.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gdJ == null) {
            this.gdJ = new c.d() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.c.d
                public void gT(boolean z) {
                    if (i.this.blz() && i.this.gdH != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gdH.bkn().clearAnimation();
                        i.this.blx();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fie);
                            i.this.gdH.bkn().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBm() {
                    if (i.this.blz()) {
                        i.this.bkt();
                    }
                }
            };
        }
        a(this.gdJ);
        this.gdS = UtilHelper.getLightStatusBarHeight() + l.h(this.fOe.getActivity(), e.C0200e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dGz != null && bbVar != null) {
            this.gdK = videoInfo;
            this.gdO = bbVar;
            this.aBn = videoInfo.video_url;
            this.dGz.stopPlay();
            this.dGz.setIsNeedRecoveryVideoPlayer(true);
            this.bKA = new n(this.fOe.getActivity());
            this.gdL = new z();
            this.gdL.mLocate = "pb";
            this.gdL.beV = bbVar.getTid();
            this.gdL.cRh = str;
            this.gdL.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gdL.mSource = bbVar.mRecomSource;
            this.gdL.gxY = bbVar.mRecomWeight;
            this.gdL.gxZ = this.fOe.bfM();
            this.gdL.gya = bbVar.mRecomAbTag;
            this.gdL.gyb = videoInfo.video_md5;
            z bql = this.gdL.bql();
            bql.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bKA.setVideoStatsData(bql);
            this.dGz.getVideoView().setBusiness(this.bKA);
            if (this.dGz.aWZ()) {
                this.dGz.aWX();
            }
            this.dGz.b(this.gee);
            this.gdQ = null;
            this.gdP = null;
            this.dGz.sR(this.gdQ);
            this.dGz.aWT().setOnDragingListener(fkd);
            this.dGz.a(new c.InterfaceC0286c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XO() {
                    i.this.fOe.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.ged > 0) {
                                i.this.sq(i.this.ged);
                                i.this.sr(i.this.ged);
                                i.this.ged = 0;
                            }
                            i.this.gef = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0286c
                public void XN() {
                    i.this.fOe.setSwipeBackEnabled(false);
                    i.this.gef = false;
                    i.this.ged = i.this.blB().getHeight();
                }
            });
            this.dGz.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void blH() {
                    if (i.this.fOe != null && i.this.gdP != null && !StringUtils.isNull(i.this.gdP.getId())) {
                        i.this.fOe.sm(i.this.gdP.getId());
                        if (i.this.gdO != null) {
                            long j = 0;
                            if (i.this.gdO.zF() != null) {
                                j = i.this.gdO.zF().channelId;
                            }
                            TiebaStatic.log(new am("c11921").h(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dGz.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.j
                public void lN(boolean z) {
                    if (i.this.gdO != null) {
                        long j = 0;
                        if (i.this.gdO.zF() != null) {
                            j = i.this.gdO.zF().channelId;
                        }
                        i.this.nF(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").ax("tid", i.this.gdO.getTid()).h(ImageViewerConfig.FORUM_ID, i.this.gdO.getFid()).h(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dGz.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aBn);
                    return true;
                }
            });
            this.dGz.setThumbnail(videoInfo.thumbnail_url);
            this.dGz.setVideoUrl(this.aBn, bbVar.getTid());
            this.dGz.setFid(str);
            this.dGz.tp(bbVar.getTitle());
            this.dGz.a(geq);
            this.dGz.aKf();
            this.dGz.show();
        }
    }

    public void sQ(String str) {
        if (this.gdL != null) {
            this.gdL.cRh = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.gdM != null) {
            this.gdM.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.gee = dVar;
    }

    public void as(bb bbVar) {
        this.gdP = bbVar;
    }

    public void sR(String str) {
        this.gdQ = str;
        if (this.dGz != null) {
            this.dGz.sR(this.gdQ);
        }
    }

    public void startPlay() {
        if (this.dGz != null) {
            if (j.kX() && !this.gek && !com.baidu.tieba.video.g.bFM().bFN()) {
                this.gec.setVisibility(0);
                this.gec.setData(this.gdK);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aBn) && this.gdO != null && this.gdO.yU() != null) {
                TiebaStatic.log(new am("c12619").ax("obj_locate", "pb").ax("tid", this.gdO.getTid()));
                this.aBn = this.gdO.yU().video_url;
            }
            this.dGz.c(this.aBn, this.gdO == null ? "" : this.gdO.getTid(), this.geb);
            nF("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void blv() {
        if (this.dGz != null) {
            this.dGz.blv();
        }
    }

    public void destroy() {
        if (this.dGz != null) {
            this.dGz.destroy();
        }
        if (this.gdI != null) {
            this.gdI.clearAnimation();
        }
        if (this.gdM != null) {
            this.gdM.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dGz != null) {
            if (this.dGz.bpd()) {
                this.gdR = true;
                this.dGz.stopPlay();
            } else if (this.dGz.getCurrentState() == 3) {
                this.gdR = false;
            } else if (this.dGz.getCurrentState() == 0 || this.dGz.getCurrentState() == 1) {
                this.gdR = true;
                this.dGz.stopPlay();
            } else {
                this.gdR = false;
                this.dGz.stopPlay();
            }
            if (this.geg != null) {
                this.geg.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dGz != null && this.gdR) {
            this.dGz.bpa();
        }
    }

    private void blw() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ax(16908290).aw(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fOe.getActivity());
                    if (i.this.gej == null) {
                        try {
                            i.this.gej = BitmapFactory.decodeResource(i.this.fOe.getResources(), e.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.gej);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iR() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iS() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.gei = null;
                    if (i.this.gej != null && !i.this.gej.isRecycled()) {
                        i.this.gej.recycle();
                    }
                    i.this.gej = null;
                }
            });
            this.gei = dVar.iT();
            this.gei.o(this.fOe.getActivity());
        }
    }

    public boolean me(int i) {
        if (this.dGz == null) {
            return false;
        }
        return this.dGz.sR(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF(String str) {
        if (this.gdK != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gdK.video_md5, "", str, this.gdL);
            }
        }
    }

    public void blx() {
        if (this.gdH != null) {
            this.gdH.lE(this.fOe.bfn());
        }
    }

    public void bkt() {
        if (this.gdH != null) {
            this.gdH.bkt();
        }
    }

    public void sl(int i) {
        if (this.gdH != null) {
            this.gdH.sl(i);
        }
        if (this.geg != null) {
            this.geg.onChangeSkinType(i);
        }
        if (this.gdM != null) {
            this.gdM.eo(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!blA()) {
                    this.gdU = i;
                    if (this.gdU == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.sr(i.this.blB().getHeight());
                            }
                        }, 100L);
                    }
                    bly();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq(int i) {
        if (blB().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdI.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.gem = false;
                    if (this.gdZ != blB().getHeight()) {
                        this.gdI.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fOe.getActivity()), Math.min(this.gdZ, blB().getHeight() + i)));
                        this.dGz.aWX();
                    }
                } else if (l.aO(this.fOe.getActivity()) * 0.5625d != blB().getHeight()) {
                    this.gdI.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fOe.getActivity()), (int) Math.max(l.aO(this.fOe.getActivity()) * 0.5625d, blB().getHeight() + i)));
                    this.dGz.aWX();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == blE()) {
                int bottom = childAt.getBottom() - blB().getBottom();
                if (childAt.getHeight() == 0 || blB().getHeight() == 0) {
                    bottom = 0;
                }
                sq(bottom);
            } else {
                sq((-this.gdZ) + 2);
            }
        }
        if (!blA() && this.gef) {
            if (this.gdU == 1) {
                this.gel = true;
                sr(blB().getHeight());
            } else if (this.gdU == 2) {
                this.gel = true;
                int y = (int) blB().getY();
                if (this.gdV == y) {
                    sr(blB().getHeight());
                } else {
                    this.gdV = y;
                    sr(blB().getHeight());
                }
                if (i == 0 && this.gdY) {
                    this.gdY = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.blv();
                        }
                    }, 100L);
                }
            } else if (this.gdU == 0) {
                if (this.gel || !"nani_midpage".equals(this.fOe.bfM())) {
                    sr(blB().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(int i) {
        ss(i);
        bly();
    }

    public void lq(boolean z) {
        this.gem = z;
    }

    private void ss(int i) {
        if (this.gdM != null) {
            if (i == 0) {
                i = this.gdZ;
            }
            float f = this.gdZ - i;
            float f2 = f > this.gdW ? 0.0f : 1.0f - (f / this.gdW);
            if (this.gem) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.gdM.blr().setVisibility(8);
            } else {
                this.gdM.blr().setVisibility(0);
            }
            this.gdM.aw(f2);
        }
    }

    public void bly() {
        if (this.gdM != null) {
            if (blA()) {
                this.fOe.bfO().bjC();
            } else if (this.gdM.blr().getVisibility() == 0) {
                this.fOe.bfO().bjC();
                this.gdN = true;
            } else if (this.gdN) {
                this.fOe.bfO().lp(false);
                this.gdN = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blz() {
        return blB().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.gdT = false;
        if (this.dGz != null && this.gdI != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdI.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gei != null) {
                    this.gei.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gdT = true;
                this.gdI.setLayoutParams(layoutParams);
                this.fOe.bfO().bjC();
                this.gdN = true;
            } else {
                e(this.gdK);
                blx();
                this.gdT = false;
                this.gdH.lD(true);
            }
            this.dGz.a(this.fOe.getPageContext(), configuration);
        }
    }

    public boolean blA() {
        return this.gdT;
    }

    public void n(long j, int i) {
        if (this.gdM != null && j > 0) {
            this.gdM.l(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.gdM != null) {
            this.gdM.N(onClickListener);
        }
    }

    public View blB() {
        return this.gdG;
    }

    public boolean bjL() {
        if (blB() == null) {
            return false;
        }
        return blB().getBottom() > l.aQ(blB().getContext()) - l.h(blB().getContext(), e.C0200e.ds50);
    }

    public void blC() {
        this.gdY = true;
    }

    public void blD() {
        if (this.dGz != null) {
            this.dGz.pausePlay();
        }
    }

    public View blE() {
        return this.mEmptyView;
    }
}
