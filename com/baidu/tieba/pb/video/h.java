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
import android.widget.SeekBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class h {
    private static VideoControllerView.a hZN = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aWf() {
        }
    };
    private static c.i iWE = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bEM() {
        }
    };
    private float Bn;
    private boolean JR;
    private n egU;
    private com.baidu.mcn.c gLE;
    private com.baidu.tieba.play.c grV;
    private PbFragment iCe;
    private RelativeLayout iVU;
    private com.baidu.tieba.pb.pb.main.view.c iVV;
    private CustomFrameLayout iVW;
    private c.d iVX;
    private y iVZ;
    private boolean iWB;
    private int iWD;
    private f iWa;
    private boolean iWb;
    private bj iWc;
    private bj iWd;
    private String iWe;
    private float iWk;
    private int iWn;
    private double iWo;
    private long iWp;
    private PbVideoWifiTipLayout iWq;
    private int iWr;
    private c.d iWt;
    private PbFullScreenFloatingHuajiAninationView iWv;
    private com.baidu.adp.lib.guide.c iWx;
    private Bitmap iWy;
    private boolean iWz;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo iVY = null;
    private boolean iWf = false;
    private int iWg = 0;
    private boolean iWh = false;
    private int iWi = 0;
    private int iWj = 0;
    private boolean iWl = false;
    private boolean iWm = false;
    private long startPosition = -1;
    private int fVZ = 0;
    private c.p iWs = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cqZ() {
            if (h.this.iCe != null && h.this.iCe.ckc() != null && h.this.iCe.ckc().getPbData() != null) {
                PostData ciZ = h.this.iCe.ckc().getPbData().ciZ();
                if (ciZ == null && v.getCount(h.this.iCe.ckc().getPbData().ciU()) > 1) {
                    ciZ = (PostData) v.getItem(h.this.iCe.ckc().getPbData().ciU(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iCe.ckc().getPbData(), ciZ, 1, 1, 4);
            }
        }
    };
    private boolean iWu = true;
    private PbFullScreenFloatingHuajiAninationView.a iWw = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qM(false);
        }
    };
    private boolean iWA = false;
    private c.m iWC = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean crb() {
            if (h.this.iWo < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iCe.checkUpIsLogin()) {
                h.this.iCe.clH();
                if (h.this.iCe.ckc() == null || h.this.iCe.ckc().getPbData() == null || h.this.iCe.ckc().getPbData().cjo() == null) {
                    return false;
                }
                l cjo = h.this.iCe.ckc().getPbData().cjo();
                if (h.this.iWv == null) {
                    h.this.iWv = new PbFullScreenFloatingHuajiAninationView(h.this.iCe.getActivity());
                    h.this.iWv.setFloatingHuajiAninationListener(h.this.iWw);
                }
                h.this.iWv.qY(cjo.cjC() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean crc() {
            return false;
        }
    };
    private CustomMessageListener tB = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.grV != null) {
                    h.this.grV.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.grV != null && h.this.grV.kP() && h.this.iVY != null && h.this.iVY.video_length.intValue() > 0 && h.this.iVY.video_duration.intValue() > 0) {
                    float intValue = h.this.iVY.video_length.intValue() * (1.0f - ((h.this.grV.getCurrentPosition() * 1.0f) / (h.this.iVY.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(h.this.iCe.getPageContext().getPageActivity(), String.format(h.this.iCe.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hXP = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cpM();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.iVY != null) {
                h.this.f(h.this.iVY);
                h.this.grV.cwV();
                h.this.grV.cbd();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iWn;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        if (this.iCe != null) {
            this.iCe.ckZ();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.iWk = 0.0f;
        this.iCe = pbFragment;
        this.iVV = cVar;
        this.iWk = com.baidu.adp.lib.util.l.getDimens(this.iCe.getActivity(), R.dimen.ds240);
        this.iWp = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.tB);
        this.gnG.setTag(pbFragment.getUniqueId());
        this.gnG.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gnG);
        this.gLE = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.iVW.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity());
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iCe.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? com.baidu.adp.lib.util.l.getEquipmentHeight(this.iCe.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iWo = (intValue2 * 1.0d) / intValue;
            if (this.iWo > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iWn = i;
        this.iVW.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bgb() {
        return this.iWo >= 1.0d;
    }

    public int cps() {
        return this.iWn;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iVU = (RelativeLayout) LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iVW = (CustomFrameLayout) this.iVU.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.JR = ((double) this.iWn) <= (((double) com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.grV = new com.baidu.tieba.play.c(this.iCe.getPageContext(), this.iVW, true, com.baidu.tbadk.a.b.rs("cyber_player_test") ? 1 : 0);
        this.grV.a(this.iWC);
        this.grV.rJ(false);
        this.grV.a(this.iWs);
        this.grV.Ac(am.kd(R.drawable.pic_use_header_60_n));
        this.grV.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.iCe.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.iCe.getBaseFragmentActivity())) {
            this.grV.rA(false);
        }
        this.grV.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.Bn = motionEvent.getY();
                        if (h.this.iCe.getListView() != null && h.this.iCe.getListView().getChildCount() > 0 && h.this.iCe.getListView().getChildAt(0) == h.this.cqY()) {
                            h.this.iWD = h.this.cqY().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.Bn = 0.0f;
                        h.this.iWD = 0;
                        break;
                    case 2:
                        if (h.this.iCe.getListView() != null && h.this.iCe.getListView().getChildCount() > 0 && h.this.iCe.getListView().getChildAt(0) == h.this.cqY()) {
                            h.this.iCe.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.Bn)) + h.this.iWD);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iWo >= 1.0d) {
                this.grV.ah(false, true);
            } else {
                this.grV.ah(true, false);
            }
            this.iWl = ((float) f) + this.iWk > ((float) com.baidu.adp.lib.util.l.getEquipmentHeight(this.iCe.getActivity()));
            if (this.iWl) {
                if (this.iWa == null) {
                    this.iWa = new f(this.iCe.getPageContext(), this.iVW);
                }
                this.iCe.ckX().coO();
                this.iWb = true;
            }
        }
        cqT();
        this.mEmptyView = new View(this.iCe.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iWn));
        if (this.iVV != null && this.iVV.mNavigationBar != null) {
            this.iVV.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iVV.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iVV.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aDB() && !TbSingleton.getInstance().isNotchScreen(this.iCe.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iCe.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iWq = (PbVideoWifiTipLayout) this.iVU.findViewById(R.id.layout_wifi_tip);
        this.iWq.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iWz = true;
                h.this.iWq.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.gLE != null) {
            this.gLE.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.iCe.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.iVX == null) {
            this.iVX = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lF(boolean z) {
                    if (h.this.cqW() && h.this.iVV != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iVV.cpE().clearAnimation();
                        h.this.cqU();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.hXP);
                            h.this.iVV.cpE().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bEL() {
                    if (h.this.cqW()) {
                        h.this.cpM();
                    }
                }
            };
        }
        a(this.iVX);
        this.iWg = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iCe.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.grV != null && bjVar != null) {
            this.iVY = videoInfo;
            this.iWc = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.grV.stopPlay();
            this.grV.setIsNeedRecoveryVideoPlayer(true);
            this.egU = new n(this.iCe.getActivity());
            this.iVZ = new y();
            this.iVZ.mLocate = "pb";
            this.iVZ.OG = bjVar.getTid();
            this.iVZ.fKa = str;
            this.iVZ.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iCe.iGB)) {
                    this.iVZ.cKN = this.iCe.iGB;
                }
                this.iVZ.jvL = this.iCe.iGA + "";
            } else {
                this.iVZ.jvL = this.iCe.ckU();
            }
            ax clJ = this.iCe.clJ();
            if (clJ != null) {
                clJ.b(this.iVZ);
            }
            this.iVZ.jvN = videoInfo.video_md5;
            y cxV = this.iVZ.cxV();
            cxV.mLocate = "6";
            this.startPosition = -1L;
            this.egU.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bx(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean em = com.baidu.mcn.b.Bo().em(mcnAdInfo.jump_url);
                        if (h.this.JR && !em && !h.this.iWh) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.gLE.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aHe = mcnAdInfo.card_title;
                                    aVar.aHf = mcnAdInfo.button_title;
                                    aVar.aHg = mcnAdInfo.jump_url;
                                    aVar.aHd = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.aHh = 4;
                                    if (z2) {
                                        h.this.gLE.b(aVar, (ViewGroup) h.this.grV.cwU());
                                    } else {
                                        h.this.gLE.a(aVar, (ViewGroup) h.this.grV.cwU());
                                    }
                                }
                            } else if (h.this.gLE.isShowing()) {
                                h.this.gLE.dismiss();
                            }
                        }
                    }
                }
            });
            this.egU.setVideoStatsData(cxV);
            this.grV.cwD().setBusiness(this.egU);
            if (this.grV.cbf()) {
                this.grV.cbd();
            }
            this.grV.b(this.iWt);
            this.iWe = null;
            this.iWd = null;
            this.grV.Gh(this.iWe);
            this.grV.caZ().setOnDragingListener(hZN);
            this.grV.a(new c.InterfaceC0581c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kO() {
                    h.this.iCe.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iWr > 0) {
                                h.this.zm(h.this.iWr);
                                h.this.zn(h.this.iWr);
                                h.this.iWr = 0;
                            }
                            h.this.iWu = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kN() {
                    h.this.iCe.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iWu = false;
                    h.this.iWr = h.this.bat().getHeight();
                }
            });
            this.grV.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cra() {
                    if (h.this.iCe != null && h.this.iWd != null && !StringUtils.isNull(h.this.iWd.getId())) {
                        h.this.iCe.Fz(h.this.iWd.getId());
                    }
                }
            });
            this.grV.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qN(boolean z) {
                    if (h.this.iWc != null) {
                        h.this.AS(z ? "1" : "2");
                    }
                }
            });
            this.grV.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.grV.setThumbnail(videoInfo.thumbnail_url);
            this.grV.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.grV.setFid(str);
            this.grV.GJ(bjVar.getTitle());
            this.grV.a(iWE);
            this.grV.bOk();
            this.grV.show();
        }
    }

    public void Gg(String str) {
        if (this.iVZ != null) {
            this.iVZ.fKa = str;
        }
    }

    public void b(PostData postData, bj bjVar, l lVar) {
        if (this.iWa != null) {
            this.iWa.a(postData, bjVar, lVar);
        }
    }

    public void a(c.d dVar) {
        this.iWt = dVar;
    }

    public void aH(bj bjVar) {
        this.iWd = bjVar;
    }

    public void Gh(String str) {
        this.iWe = str;
        if (this.grV != null) {
            this.grV.Gh(this.iWe);
        }
    }

    public void startPlay() {
        if (this.grV != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iWz && !com.baidu.tieba.video.g.cNI().cNJ()) {
                this.iWq.setVisibility(0);
                this.iWq.setData(this.iVY);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iWc != null && this.iWc.aAo() != null) {
                TiebaStatic.log(new an("c12619").cp("obj_locate", "pb").cp("tid", this.iWc.getTid()));
                this.mVideoUrl = this.iWc.aAo().video_url;
            }
            this.grV.dZ(this.mVideoUrl, this.iWc == null ? "" : this.iWc.getTid());
            AS("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cqS() {
        if (this.grV != null) {
            this.grV.cqS();
        }
    }

    public void destroy() {
        if (this.grV != null) {
            this.grV.destroy();
        }
        if (this.iVW != null) {
            this.iVW.clearAnimation();
        }
        if (this.iWa != null) {
            this.iWa.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tB);
        MessageManager.getInstance().unRegisterListener(this.gnG);
    }

    public void onPause() {
        if (this.grV != null) {
            if (this.grV.kP()) {
                this.iWf = true;
                this.grV.stopPlay();
            } else if (this.grV.getCurrentState() == 3) {
                this.iWf = false;
            } else if (this.grV.getCurrentState() == 0 || this.grV.getCurrentState() == 1) {
                this.iWf = true;
                this.grV.stopPlay();
            } else {
                this.iWf = false;
                this.grV.stopPlay();
            }
            if (this.iWv != null) {
                this.iWv.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.grV != null && this.iWf) {
            this.grV.cwH();
        }
    }

    private void cqT() {
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.K(16908290).J(153).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.iCe.getActivity());
                    if (h.this.iWy == null) {
                        try {
                            h.this.iWy = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iWy);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getAnchor() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getFitPosition() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.h.8
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    h.this.iWx = null;
                    if (h.this.iWy != null && !h.this.iWy.isRecycled()) {
                        h.this.iWy.recycle();
                    }
                    h.this.iWy = null;
                }
            });
            this.iWx = dVar.fI();
            this.iWx.showOnDecorView(this.iCe.getActivity());
        }
    }

    public boolean sZ(int i) {
        if (this.grV == null) {
            return false;
        }
        return this.grV.Ad(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS(String str) {
        if (this.iVY != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iVY.video_md5, "", str, this.iVZ);
            }
        }
    }

    public void cqU() {
        if (this.iVV != null) {
            this.iVV.qC(this.iCe.cjR());
        }
    }

    public void cpM() {
        if (this.iVV != null) {
            this.iVV.cpM();
        }
    }

    public void zb(int i) {
        if (this.iVV != null) {
            this.iVV.zb(i);
        }
        if (this.iWv != null) {
            this.iWv.onChangeSkinType(i);
        }
        if (this.iWa != null) {
            this.iWa.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cqX()) {
                    this.iWi = i;
                    if (this.iWi == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zn(h.this.bat().getHeight());
                            }
                        }, 100L);
                    }
                    cqV();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(int i) {
        if (bat().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iVW.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iWB = false;
                    if (this.iWn != bat().getHeight()) {
                        this.iVW.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()), Math.min(this.iWn, bat().getHeight() + i)));
                        this.grV.cbd();
                    }
                } else if (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()) * 0.5625d != bat().getHeight()) {
                    this.iVW.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()) * 0.5625d, bat().getHeight() + i)));
                    this.grV.cbd();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cqY()) {
                int bottom = childAt.getBottom() - bat().getBottom();
                if (childAt.getHeight() == 0 || bat().getHeight() == 0) {
                    bottom = 0;
                }
                zm(bottom);
            } else {
                zm((-this.iWn) + 2);
            }
        }
        if (!cqX() && this.iWu) {
            if (this.iWi == 1) {
                this.iWA = true;
                zn(bat().getHeight());
            } else if (this.iWi == 2) {
                this.iWA = true;
                int y = (int) bat().getY();
                if (this.iWj == y) {
                    zn(bat().getHeight());
                } else {
                    this.iWj = y;
                    zn(bat().getHeight());
                }
                if (i == 0 && this.iWm) {
                    this.iWm = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cqS();
                        }
                    }, 100L);
                }
            } else if (this.iWi == 0) {
                if (this.iWA || !"nani_midpage".equals(this.iCe.ckU())) {
                    zn(bat().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        zo(i);
        cqV();
    }

    public void qp(boolean z) {
        this.iWB = z;
    }

    private void zo(int i) {
        if (this.iWa != null) {
            if (this.iWc != null && this.iWc.aBV()) {
                this.iWa.cqQ().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iWn;
            }
            float f = this.iWn - i;
            float f2 = f > this.iWk ? 0.0f : 1.0f - (f / this.iWk);
            if (this.iWB) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iWa.cqQ().setVisibility(8);
            } else {
                this.iWa.cqQ().setVisibility(0);
            }
            this.iWa.aF(f2);
        }
    }

    public void cqV() {
        if (this.iWa != null) {
            if (cqX()) {
                this.iCe.ckX().coO();
            } else if (this.iWa.cqQ().getVisibility() == 0) {
                this.iCe.ckX().coO();
                this.iWb = true;
            } else if (this.iWb) {
                this.iCe.ckX().qo(false);
                this.iWb = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqW() {
        return bat().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iWh = false;
        if (this.grV != null && this.iVW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iVW.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gLE != null && this.gLE.isShowing()) {
                    this.gLE.Bp();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iWx != null) {
                    this.iWx.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iWh = true;
                this.iVW.setLayoutParams(layoutParams);
                this.iCe.ckX().coO();
                this.iWb = true;
            } else {
                f(this.iVY);
                cqU();
                this.iWh = false;
                this.iVV.qB(true);
            }
            this.grV.a(this.iCe.getPageContext(), configuration);
        }
    }

    public boolean cqX() {
        return this.iWh;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iWa != null) {
            this.iWa.R(onClickListener);
        }
    }

    public View bat() {
        return this.iVU;
    }

    public boolean coX() {
        if (bat() == null) {
            return false;
        }
        return bat().getBottom() > com.baidu.adp.lib.util.l.getEquipmentHeight(bat().getContext()) - com.baidu.adp.lib.util.l.getDimens(bat().getContext(), R.dimen.ds50);
    }

    public void cpq() {
        this.iWm = true;
    }

    public View cqY() {
        return this.mEmptyView;
    }
}
