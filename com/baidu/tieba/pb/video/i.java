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
    private static VideoControllerView.a fiK = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void UX() {
        }
    };
    private static c.i gcT = new c.i() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.i
        public void aBQ() {
        }
    };
    private n bJP;
    private com.baidu.tieba.play.c dFk;
    private PbActivity fMF;
    private int gcC;
    private double gcD;
    private float gcE;
    private long gcF;
    private PbVideoWifiTipLayout gcG;
    private int gcH;
    private c.d gcI;
    private PbFullScreenFloatingHuajiAninationView gcK;
    private com.baidu.adp.lib.guide.c gcM;
    private Bitmap gcN;
    private boolean gcO;
    private boolean gcQ;
    private int gcS;
    private RelativeLayout gcj;
    private com.baidu.tieba.pb.pb.main.view.b gck;
    private CustomFrameLayout gcl;
    private c.d gcm;
    private z gco;
    private g gcp;
    private boolean gcq;
    private bb gcr;
    private bb gcs;
    private String gct;
    private float gcz;
    private View mEmptyView;
    private Handler mHandler;
    private String aAy = null;
    private VideoInfo gcn = null;
    private boolean gcu = false;
    private int gcv = 0;
    private boolean gcw = false;
    private int gcx = 0;
    private int gcy = 0;
    private boolean gcA = false;
    private boolean gcB = false;
    private boolean gcJ = true;
    private PbFullScreenFloatingHuajiAninationView.a gcL = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lB(false);
        }
    };
    private boolean gcP = false;
    private c.m gcR = new c.m() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.m
        public boolean bmj() {
            if (i.this.fMF.checkUpIsLogin()) {
                i.this.fMF.bhd();
                if (i.this.fMF.bga() == null || i.this.fMF.bga().getPbData() == null || i.this.fMF.bga().getPbData().bft() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bft = i.this.fMF.bga().getPbData().bft();
                if (i.this.gcK == null) {
                    i.this.gcK = new PbFullScreenFloatingHuajiAninationView(i.this.fMF.getActivity());
                    i.this.gcK.setFloatingHuajiAninationListener(i.this.gcL);
                }
                i.this.gcK.lD(bft.bfz() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bmk() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dFk != null) {
                    i.this.dFk.setNetworkChange();
                }
                if (j.kX() && j.kZ() && i.this.dFk != null && i.this.dFk.bpH() && i.this.gcn != null && i.this.gcn.video_length.intValue() > 0 && i.this.gcn.video_duration.intValue() > 0) {
                    float intValue = i.this.gcn.video_length.intValue() * (1.0f - ((i.this.dFk.getCurrentPosition() * 1.0f) / (i.this.gcn.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fMF.getPageContext().getPageActivity(), String.format(i.this.fMF.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fgK = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bkW();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        if (this.fMF != null) {
            this.fMF.bgt();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.gcz = 0.0f;
        this.fMF = pbActivity;
        this.gck = bVar;
        this.gcz = l.h(this.fMF.getActivity(), e.C0175e.ds240);
        this.gcF = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fMF.getActivity());
        Rect y = az.y(this.fMF.getPageContext().getPageActivity());
        int aQ = y.height() <= 0 ? l.aQ(this.fMF.getActivity()) : y.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gcD = (intValue2 * 1.0d) / intValue;
            if (this.gcD > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.gcC = i;
        this.gcl.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.gcj = (RelativeLayout) LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gcl = (CustomFrameLayout) this.gcj.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dFk = new com.baidu.tieba.play.c((TbPageContext<?>) this.fMF.getPageContext(), (View) this.gcl, true);
        this.dFk.a(this.gcR);
        this.dFk.mj(false);
        this.dFk.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.12
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
                        i.this.gcE = motionEvent.getY();
                        if (i.this.fMF.getListView() != null && i.this.fMF.getListView().getChildCount() > 0 && i.this.fMF.getListView().getChildAt(0) == i.this.bmi()) {
                            i.this.gcS = i.this.bmi().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.gcE = 0.0f;
                        i.this.gcS = 0;
                        break;
                    case 2:
                        if (i.this.fMF.getListView() != null && i.this.fMF.getListView().getChildCount() > 0 && i.this.fMF.getListView().getChildAt(0) == i.this.bmi()) {
                            i.this.fMF.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.gcE)) + i.this.gcS);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gcD >= 1.0d) {
                this.dFk.Q(false, true);
            } else {
                this.dFk.Q(true, false);
            }
            this.gcA = ((float) e) + this.gcz > ((float) l.aQ(this.fMF.getActivity()));
            if (this.gcA) {
                if (this.gcp == null) {
                    this.gcp = new g(this.fMF.getPageContext(), this.gcl);
                }
                this.fMF.bgr().bkf();
                this.gcq = true;
            }
        }
        bma();
        this.mEmptyView = new View(this.fMF);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gcC));
        if (this.gck != null && this.gck.mNavigationBar != null) {
            this.gck.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gck.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gck.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.Bu() ? 0 : 8);
        }
        this.gcG = (PbVideoWifiTipLayout) this.gcj.findViewById(e.g.layout_wifi_tip);
        this.gcG.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gcO = true;
                i.this.gcG.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fMF.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gcm == null) {
            this.gcm = new c.d() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.c.d
                public void gJ(boolean z) {
                    if (i.this.bmd() && i.this.gck != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gck.bkQ().clearAnimation();
                        i.this.bmb();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fgK);
                            i.this.gck.bkQ().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBP() {
                    if (i.this.bmd()) {
                        i.this.bkW();
                    }
                }
            };
        }
        a(this.gcm);
        this.gcv = UtilHelper.getLightStatusBarHeight() + l.h(this.fMF.getActivity(), e.C0175e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dFk != null && bbVar != null) {
            this.gcn = videoInfo;
            this.gcr = bbVar;
            this.aAy = videoInfo.video_url;
            this.dFk.stopPlay();
            this.dFk.setIsNeedRecoveryVideoPlayer(true);
            this.bJP = new n(this.fMF.getActivity());
            this.gco = new z();
            this.gco.mLocate = "pb";
            this.gco.beh = bbVar.getTid();
            this.gco.cQb = str;
            this.gco.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gco.mSource = bbVar.mRecomSource;
            this.gco.gwx = bbVar.mRecomWeight;
            this.gco.gwy = this.fMF.bgp();
            this.gco.gwz = bbVar.mRecomAbTag;
            this.gco.gwA = videoInfo.video_md5;
            z bqP = this.gco.bqP();
            bqP.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bJP.setVideoStatsData(bqP);
            this.dFk.getVideoView().setBusiness(this.bJP);
            if (this.dFk.aXC()) {
                this.dFk.aXA();
            }
            this.dFk.b(this.gcI);
            this.gct = null;
            this.gcs = null;
            this.dFk.sQ(this.gct);
            this.dFk.aXw().setOnDragingListener(fiK);
            this.dFk.a(new c.InterfaceC0258c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XE() {
                    i.this.fMF.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.gcH > 0) {
                                i.this.rX(i.this.gcH);
                                i.this.rY(i.this.gcH);
                                i.this.gcH = 0;
                            }
                            i.this.gcJ = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XD() {
                    i.this.fMF.setSwipeBackEnabled(false);
                    i.this.gcJ = false;
                    i.this.gcH = i.this.bmf().getHeight();
                }
            });
            this.dFk.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void bml() {
                    if (i.this.fMF != null && i.this.gcs != null && !StringUtils.isNull(i.this.gcs.getId())) {
                        i.this.fMF.sl(i.this.gcs.getId());
                        if (i.this.gcr != null) {
                            long j = 0;
                            if (i.this.gcr.zy() != null) {
                                j = i.this.gcr.zy().channelId;
                            }
                            TiebaStatic.log(new am("c11921").h(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dFk.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.j
                public void lC(boolean z) {
                    if (i.this.gcr != null) {
                        long j = 0;
                        if (i.this.gcr.zy() != null) {
                            j = i.this.gcr.zy().channelId;
                        }
                        i.this.nE(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").ax("tid", i.this.gcr.getTid()).h(ImageViewerConfig.FORUM_ID, i.this.gcr.getFid()).h(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dFk.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aAy);
                    return true;
                }
            });
            this.dFk.setThumbnail(videoInfo.thumbnail_url);
            this.dFk.setVideoUrl(this.aAy, bbVar.getTid());
            this.dFk.setFid(str);
            this.dFk.tk(bbVar.getTitle());
            this.dFk.a(gcT);
            this.dFk.aKH();
            this.dFk.show();
        }
    }

    public void sP(String str) {
        if (this.gco != null) {
            this.gco.cQb = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.gcp != null) {
            this.gcp.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.gcI = dVar;
    }

    public void as(bb bbVar) {
        this.gcs = bbVar;
    }

    public void sQ(String str) {
        this.gct = str;
        if (this.dFk != null) {
            this.dFk.sQ(this.gct);
        }
    }

    public void startPlay() {
        if (this.dFk != null) {
            if (j.kZ() && !this.gcO && !com.baidu.tieba.video.g.bGn().bGo()) {
                this.gcG.setVisibility(0);
                this.gcG.setData(this.gcn);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aAy) && this.gcr != null && this.gcr.yN() != null) {
                TiebaStatic.log(new am("c12619").ax("obj_locate", "pb").ax("tid", this.gcr.getTid()));
                this.aAy = this.gcr.yN().video_url;
            }
            this.dFk.b(this.aAy, this.gcr == null ? "" : this.gcr.getTid(), this.gcF);
            nE("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void blZ() {
        if (this.dFk != null) {
            this.dFk.blZ();
        }
    }

    public void destroy() {
        if (this.dFk != null) {
            this.dFk.destroy();
        }
        if (this.gcl != null) {
            this.gcl.clearAnimation();
        }
        if (this.gcp != null) {
            this.gcp.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dFk != null) {
            if (this.dFk.bpH()) {
                this.gcu = true;
                this.dFk.stopPlay();
            } else if (this.dFk.getCurrentState() == 3) {
                this.gcu = false;
            } else if (this.dFk.getCurrentState() == 0 || this.dFk.getCurrentState() == 1) {
                this.gcu = true;
                this.dFk.stopPlay();
            } else {
                this.gcu = false;
                this.dFk.stopPlay();
            }
            if (this.gcK != null) {
                this.gcK.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dFk != null && this.gcu) {
            this.dFk.aXE();
        }
    }

    private void bma() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.N(true);
            dVar.P(false);
            dVar.ag(16908290).af(153).O(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fMF.getActivity());
                    if (i.this.gcN == null) {
                        try {
                            i.this.gcN = BitmapFactory.decodeResource(i.this.fMF.getResources(), e.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.gcN);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iS() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iT() {
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
                    i.this.gcM = null;
                    if (i.this.gcN != null && !i.this.gcN.isRecycled()) {
                        i.this.gcN.recycle();
                    }
                    i.this.gcN = null;
                }
            });
            this.gcM = dVar.iU();
            this.gcM.o(this.fMF.getActivity());
        }
    }

    public boolean lM(int i) {
        if (this.dFk == null) {
            return false;
        }
        return this.dFk.sy(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(String str) {
        if (this.gcn != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gcn.video_md5, "", str, this.gco);
            }
        }
    }

    public void bmb() {
        if (this.gck != null) {
            this.gck.lt(this.fMF.bfQ());
        }
    }

    public void bkW() {
        if (this.gck != null) {
            this.gck.bkW();
        }
    }

    public void rS(int i) {
        if (this.gck != null) {
            this.gck.rS(i);
        }
        if (this.gcK != null) {
            this.gcK.onChangeSkinType(i);
        }
        if (this.gcp != null) {
            this.gcp.ea(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bme()) {
                    this.gcx = i;
                    if (this.gcx == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.rY(i.this.bmf().getHeight());
                            }
                        }, 100L);
                    }
                    bmc();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rX(int i) {
        if (bmf().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gcl.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.gcQ = false;
                    if (this.gcC != bmf().getHeight()) {
                        this.gcl.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fMF.getActivity()), Math.min(this.gcC, bmf().getHeight() + i)));
                        this.dFk.aXA();
                    }
                } else if (l.aO(this.fMF.getActivity()) * 0.5625d != bmf().getHeight()) {
                    this.gcl.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fMF.getActivity()), (int) Math.max(l.aO(this.fMF.getActivity()) * 0.5625d, bmf().getHeight() + i)));
                    this.dFk.aXA();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bmi()) {
                int bottom = childAt.getBottom() - bmf().getBottom();
                if (childAt.getHeight() == 0 || bmf().getHeight() == 0) {
                    bottom = 0;
                }
                rX(bottom);
            } else {
                rX((-this.gcC) + 2);
            }
        }
        if (!bme() && this.gcJ) {
            if (this.gcx == 1) {
                this.gcP = true;
                rY(bmf().getHeight());
            } else if (this.gcx == 2) {
                this.gcP = true;
                int y = (int) bmf().getY();
                if (this.gcy == y) {
                    rY(bmf().getHeight());
                } else {
                    this.gcy = y;
                    rY(bmf().getHeight());
                }
                if (i == 0 && this.gcB) {
                    this.gcB = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.blZ();
                        }
                    }, 100L);
                }
            } else if (this.gcx == 0) {
                if (this.gcP || !"nani_midpage".equals(this.fMF.bgp())) {
                    rY(bmf().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(int i) {
        rZ(i);
        bmc();
    }

    public void lf(boolean z) {
        this.gcQ = z;
    }

    private void rZ(int i) {
        if (this.gcp != null) {
            if (i == 0) {
                i = this.gcC;
            }
            float f = this.gcC - i;
            float f2 = f > this.gcz ? 0.0f : 1.0f - (f / this.gcz);
            if (this.gcQ) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.gcp.blV().setVisibility(8);
            } else {
                this.gcp.blV().setVisibility(0);
            }
            this.gcp.au(f2);
        }
    }

    public void bmc() {
        if (this.gcp != null) {
            if (bme()) {
                this.fMF.bgr().bkf();
            } else if (this.gcp.blV().getVisibility() == 0) {
                this.fMF.bgr().bkf();
                this.gcq = true;
            } else if (this.gcq) {
                this.fMF.bgr().le(false);
                this.gcq = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmd() {
        return bmf().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.gcw = false;
        if (this.dFk != null && this.gcl != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gcl.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gcM != null) {
                    this.gcM.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gcw = true;
                this.gcl.setLayoutParams(layoutParams);
                this.fMF.bgr().bkf();
                this.gcq = true;
            } else {
                e(this.gcn);
                bmb();
                this.gcw = false;
                this.gck.ls(true);
            }
            this.dFk.a(this.fMF.getPageContext(), configuration);
        }
    }

    public boolean bme() {
        return this.gcw;
    }

    public void n(long j, int i) {
        if (this.gcp != null && j > 0) {
            this.gcp.l(i, j);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.gcp != null) {
            this.gcp.L(onClickListener);
        }
    }

    public View bmf() {
        return this.gcj;
    }

    public boolean bko() {
        if (bmf() == null) {
            return false;
        }
        return bmf().getBottom() > l.aQ(bmf().getContext()) - l.h(bmf().getContext(), e.C0175e.ds50);
    }

    public void bmg() {
        this.gcB = true;
    }

    public void bmh() {
        if (this.dFk != null) {
            this.dFk.pausePlay();
        }
    }

    public View bmi() {
        return this.mEmptyView;
    }
}
