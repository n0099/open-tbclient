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
    private static VideoControllerView.a fiJ = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void UX() {
        }
    };
    private static c.i gcS = new c.i() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.i
        public void aBP() {
        }
    };
    private n bJP;
    private com.baidu.tieba.play.c dFk;
    private PbActivity fME;
    private int gcB;
    private double gcC;
    private float gcD;
    private long gcE;
    private PbVideoWifiTipLayout gcF;
    private int gcG;
    private c.d gcH;
    private PbFullScreenFloatingHuajiAninationView gcJ;
    private com.baidu.adp.lib.guide.c gcL;
    private Bitmap gcM;
    private boolean gcN;
    private boolean gcP;
    private int gcR;
    private RelativeLayout gci;
    private com.baidu.tieba.pb.pb.main.view.b gcj;
    private CustomFrameLayout gck;
    private c.d gcl;
    private z gcn;
    private g gco;
    private boolean gcp;
    private bb gcq;
    private bb gcr;
    private String gcs;
    private float gcy;
    private View mEmptyView;
    private Handler mHandler;
    private String aAy = null;
    private VideoInfo gcm = null;
    private boolean gct = false;
    private int gcu = 0;
    private boolean gcv = false;
    private int gcw = 0;
    private int gcx = 0;
    private boolean gcz = false;
    private boolean gcA = false;
    private boolean gcI = true;
    private PbFullScreenFloatingHuajiAninationView.a gcK = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lB(false);
        }
    };
    private boolean gcO = false;
    private c.m gcQ = new c.m() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.m
        public boolean bmj() {
            if (i.this.fME.checkUpIsLogin()) {
                i.this.fME.bhd();
                if (i.this.fME.bga() == null || i.this.fME.bga().getPbData() == null || i.this.fME.bga().getPbData().bft() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bft = i.this.fME.bga().getPbData().bft();
                if (i.this.gcJ == null) {
                    i.this.gcJ = new PbFullScreenFloatingHuajiAninationView(i.this.fME.getActivity());
                    i.this.gcJ.setFloatingHuajiAninationListener(i.this.gcK);
                }
                i.this.gcJ.lD(bft.bfz() ? false : true);
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
                if (j.kX() && j.kZ() && i.this.dFk != null && i.this.dFk.bpH() && i.this.gcm != null && i.this.gcm.video_length.intValue() > 0 && i.this.gcm.video_duration.intValue() > 0) {
                    float intValue = i.this.gcm.video_length.intValue() * (1.0f - ((i.this.dFk.getCurrentPosition() * 1.0f) / (i.this.gcm.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fME.getPageContext().getPageActivity(), String.format(i.this.fME.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fgJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.15
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
        if (this.fME != null) {
            this.fME.bgt();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.gcy = 0.0f;
        this.fME = pbActivity;
        this.gcj = bVar;
        this.gcy = l.h(this.fME.getActivity(), e.C0175e.ds240);
        this.gcE = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fME.getActivity());
        Rect y = az.y(this.fME.getPageContext().getPageActivity());
        int aQ = y.height() <= 0 ? l.aQ(this.fME.getActivity()) : y.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gcC = (intValue2 * 1.0d) / intValue;
            if (this.gcC > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.gcB = i;
        this.gck.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.gci = (RelativeLayout) LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gck = (CustomFrameLayout) this.gci.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dFk = new com.baidu.tieba.play.c((TbPageContext<?>) this.fME.getPageContext(), (View) this.gck, true);
        this.dFk.a(this.gcQ);
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
                        i.this.gcD = motionEvent.getY();
                        if (i.this.fME.getListView() != null && i.this.fME.getListView().getChildCount() > 0 && i.this.fME.getListView().getChildAt(0) == i.this.bmi()) {
                            i.this.gcR = i.this.bmi().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.gcD = 0.0f;
                        i.this.gcR = 0;
                        break;
                    case 2:
                        if (i.this.fME.getListView() != null && i.this.fME.getListView().getChildCount() > 0 && i.this.fME.getListView().getChildAt(0) == i.this.bmi()) {
                            i.this.fME.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.gcD)) + i.this.gcR);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gcC >= 1.0d) {
                this.dFk.Q(false, true);
            } else {
                this.dFk.Q(true, false);
            }
            this.gcz = ((float) e) + this.gcy > ((float) l.aQ(this.fME.getActivity()));
            if (this.gcz) {
                if (this.gco == null) {
                    this.gco = new g(this.fME.getPageContext(), this.gck);
                }
                this.fME.bgr().bkf();
                this.gcp = true;
            }
        }
        bma();
        this.mEmptyView = new View(this.fME);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gcB));
        if (this.gcj != null && this.gcj.mNavigationBar != null) {
            this.gcj.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gcj.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gcj.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.Bu() ? 0 : 8);
        }
        this.gcF = (PbVideoWifiTipLayout) this.gci.findViewById(e.g.layout_wifi_tip);
        this.gcF.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gcN = true;
                i.this.gcF.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fME.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gcl == null) {
            this.gcl = new c.d() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.c.d
                public void gJ(boolean z) {
                    if (i.this.bmd() && i.this.gcj != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gcj.bkQ().clearAnimation();
                        i.this.bmb();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fgJ);
                            i.this.gcj.bkQ().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aBO() {
                    if (i.this.bmd()) {
                        i.this.bkW();
                    }
                }
            };
        }
        a(this.gcl);
        this.gcu = UtilHelper.getLightStatusBarHeight() + l.h(this.fME.getActivity(), e.C0175e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dFk != null && bbVar != null) {
            this.gcm = videoInfo;
            this.gcq = bbVar;
            this.aAy = videoInfo.video_url;
            this.dFk.stopPlay();
            this.dFk.setIsNeedRecoveryVideoPlayer(true);
            this.bJP = new n(this.fME.getActivity());
            this.gcn = new z();
            this.gcn.mLocate = "pb";
            this.gcn.beh = bbVar.getTid();
            this.gcn.cQb = str;
            this.gcn.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gcn.mSource = bbVar.mRecomSource;
            this.gcn.gww = bbVar.mRecomWeight;
            this.gcn.gwx = this.fME.bgp();
            this.gcn.gwy = bbVar.mRecomAbTag;
            this.gcn.gwz = videoInfo.video_md5;
            z bqP = this.gcn.bqP();
            bqP.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bJP.setVideoStatsData(bqP);
            this.dFk.getVideoView().setBusiness(this.bJP);
            if (this.dFk.aXC()) {
                this.dFk.aXA();
            }
            this.dFk.b(this.gcH);
            this.gcs = null;
            this.gcr = null;
            this.dFk.sQ(this.gcs);
            this.dFk.aXw().setOnDragingListener(fiJ);
            this.dFk.a(new c.InterfaceC0258c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XD() {
                    i.this.fME.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.gcG > 0) {
                                i.this.rX(i.this.gcG);
                                i.this.rY(i.this.gcG);
                                i.this.gcG = 0;
                            }
                            i.this.gcI = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0258c
                public void XC() {
                    i.this.fME.setSwipeBackEnabled(false);
                    i.this.gcI = false;
                    i.this.gcG = i.this.bmf().getHeight();
                }
            });
            this.dFk.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void bml() {
                    if (i.this.fME != null && i.this.gcr != null && !StringUtils.isNull(i.this.gcr.getId())) {
                        i.this.fME.sl(i.this.gcr.getId());
                        if (i.this.gcq != null) {
                            long j = 0;
                            if (i.this.gcq.zy() != null) {
                                j = i.this.gcq.zy().channelId;
                            }
                            TiebaStatic.log(new am("c11921").h(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dFk.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.j
                public void lC(boolean z) {
                    if (i.this.gcq != null) {
                        long j = 0;
                        if (i.this.gcq.zy() != null) {
                            j = i.this.gcq.zy().channelId;
                        }
                        i.this.nE(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").ax("tid", i.this.gcq.getTid()).h(ImageViewerConfig.FORUM_ID, i.this.gcq.getFid()).h(VideoPlayActivityConfig.OBJ_ID, j));
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
            this.dFk.a(gcS);
            this.dFk.aKH();
            this.dFk.show();
        }
    }

    public void sP(String str) {
        if (this.gcn != null) {
            this.gcn.cQb = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.gco != null) {
            this.gco.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.gcH = dVar;
    }

    public void as(bb bbVar) {
        this.gcr = bbVar;
    }

    public void sQ(String str) {
        this.gcs = str;
        if (this.dFk != null) {
            this.dFk.sQ(this.gcs);
        }
    }

    public void startPlay() {
        if (this.dFk != null) {
            if (j.kZ() && !this.gcN && !com.baidu.tieba.video.g.bGn().bGo()) {
                this.gcF.setVisibility(0);
                this.gcF.setData(this.gcm);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aAy) && this.gcq != null && this.gcq.yN() != null) {
                TiebaStatic.log(new am("c12619").ax("obj_locate", "pb").ax("tid", this.gcq.getTid()));
                this.aAy = this.gcq.yN().video_url;
            }
            this.dFk.b(this.aAy, this.gcq == null ? "" : this.gcq.getTid(), this.gcE);
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
        if (this.gck != null) {
            this.gck.clearAnimation();
        }
        if (this.gco != null) {
            this.gco.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dFk != null) {
            if (this.dFk.bpH()) {
                this.gct = true;
                this.dFk.stopPlay();
            } else if (this.dFk.getCurrentState() == 3) {
                this.gct = false;
            } else if (this.dFk.getCurrentState() == 0 || this.dFk.getCurrentState() == 1) {
                this.gct = true;
                this.dFk.stopPlay();
            } else {
                this.gct = false;
                this.dFk.stopPlay();
            }
            if (this.gcJ != null) {
                this.gcJ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dFk != null && this.gct) {
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
                    ImageView imageView = new ImageView(i.this.fME.getActivity());
                    if (i.this.gcM == null) {
                        try {
                            i.this.gcM = BitmapFactory.decodeResource(i.this.fME.getResources(), e.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.gcM);
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
                    i.this.gcL = null;
                    if (i.this.gcM != null && !i.this.gcM.isRecycled()) {
                        i.this.gcM.recycle();
                    }
                    i.this.gcM = null;
                }
            });
            this.gcL = dVar.iU();
            this.gcL.o(this.fME.getActivity());
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
        if (this.gcm != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gcm.video_md5, "", str, this.gcn);
            }
        }
    }

    public void bmb() {
        if (this.gcj != null) {
            this.gcj.lt(this.fME.bfQ());
        }
    }

    public void bkW() {
        if (this.gcj != null) {
            this.gcj.bkW();
        }
    }

    public void rS(int i) {
        if (this.gcj != null) {
            this.gcj.rS(i);
        }
        if (this.gcJ != null) {
            this.gcJ.onChangeSkinType(i);
        }
        if (this.gco != null) {
            this.gco.ea(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bme()) {
                    this.gcw = i;
                    if (this.gcw == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gck.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.gcP = false;
                    if (this.gcB != bmf().getHeight()) {
                        this.gck.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fME.getActivity()), Math.min(this.gcB, bmf().getHeight() + i)));
                        this.dFk.aXA();
                    }
                } else if (l.aO(this.fME.getActivity()) * 0.5625d != bmf().getHeight()) {
                    this.gck.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fME.getActivity()), (int) Math.max(l.aO(this.fME.getActivity()) * 0.5625d, bmf().getHeight() + i)));
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
                rX((-this.gcB) + 2);
            }
        }
        if (!bme() && this.gcI) {
            if (this.gcw == 1) {
                this.gcO = true;
                rY(bmf().getHeight());
            } else if (this.gcw == 2) {
                this.gcO = true;
                int y = (int) bmf().getY();
                if (this.gcx == y) {
                    rY(bmf().getHeight());
                } else {
                    this.gcx = y;
                    rY(bmf().getHeight());
                }
                if (i == 0 && this.gcA) {
                    this.gcA = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.blZ();
                        }
                    }, 100L);
                }
            } else if (this.gcw == 0) {
                if (this.gcO || !"nani_midpage".equals(this.fME.bgp())) {
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
        this.gcP = z;
    }

    private void rZ(int i) {
        if (this.gco != null) {
            if (i == 0) {
                i = this.gcB;
            }
            float f = this.gcB - i;
            float f2 = f > this.gcy ? 0.0f : 1.0f - (f / this.gcy);
            if (this.gcP) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.gco.blV().setVisibility(8);
            } else {
                this.gco.blV().setVisibility(0);
            }
            this.gco.au(f2);
        }
    }

    public void bmc() {
        if (this.gco != null) {
            if (bme()) {
                this.fME.bgr().bkf();
            } else if (this.gco.blV().getVisibility() == 0) {
                this.fME.bgr().bkf();
                this.gcp = true;
            } else if (this.gcp) {
                this.fME.bgr().le(false);
                this.gcp = false;
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
        this.gcv = false;
        if (this.dFk != null && this.gck != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gck.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gcL != null) {
                    this.gcL.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gcv = true;
                this.gck.setLayoutParams(layoutParams);
                this.fME.bgr().bkf();
                this.gcp = true;
            } else {
                e(this.gcm);
                bmb();
                this.gcv = false;
                this.gcj.ls(true);
            }
            this.dFk.a(this.fME.getPageContext(), configuration);
        }
    }

    public boolean bme() {
        return this.gcv;
    }

    public void n(long j, int i) {
        if (this.gco != null && j > 0) {
            this.gco.l(i, j);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.gco != null) {
            this.gco.L(onClickListener);
        }
    }

    public View bmf() {
        return this.gci;
    }

    public boolean bko() {
        if (bmf() == null) {
            return false;
        }
        return bmf().getBottom() > l.aQ(bmf().getContext()) - l.h(bmf().getContext(), e.C0175e.ds50);
    }

    public void bmg() {
        this.gcA = true;
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
