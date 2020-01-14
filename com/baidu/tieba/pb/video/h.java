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
    private static c.i iWJ = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
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
    private RelativeLayout iVZ;
    private PbFullScreenFloatingHuajiAninationView iWA;
    private com.baidu.adp.lib.guide.c iWC;
    private Bitmap iWD;
    private boolean iWE;
    private boolean iWG;
    private int iWI;
    private com.baidu.tieba.pb.pb.main.view.c iWa;
    private CustomFrameLayout iWb;
    private c.d iWc;
    private y iWe;
    private f iWf;
    private boolean iWg;
    private bj iWh;
    private bj iWi;
    private String iWj;
    private float iWp;
    private int iWs;
    private double iWt;
    private long iWu;
    private PbVideoWifiTipLayout iWv;
    private int iWw;
    private c.d iWy;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo iWd = null;
    private boolean iWk = false;
    private int iWl = 0;
    private boolean iWm = false;
    private int iWn = 0;
    private int iWo = 0;
    private boolean iWq = false;
    private boolean iWr = false;
    private long startPosition = -1;
    private int fVZ = 0;
    private c.p iWx = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void crb() {
            if (h.this.iCe != null && h.this.iCe.ckc() != null && h.this.iCe.ckc().getPbData() != null) {
                PostData ciZ = h.this.iCe.ckc().getPbData().ciZ();
                if (ciZ == null && v.getCount(h.this.iCe.ckc().getPbData().ciU()) > 1) {
                    ciZ = (PostData) v.getItem(h.this.iCe.ckc().getPbData().ciU(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iCe.ckc().getPbData(), ciZ, 1, 1, 4);
            }
        }
    };
    private boolean iWz = true;
    private PbFullScreenFloatingHuajiAninationView.a iWB = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qM(false);
        }
    };
    private boolean iWF = false;
    private c.m iWH = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean crd() {
            if (h.this.iWt < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iCe.checkUpIsLogin()) {
                h.this.iCe.clH();
                if (h.this.iCe.ckc() == null || h.this.iCe.ckc().getPbData() == null || h.this.iCe.ckc().getPbData().cjo() == null) {
                    return false;
                }
                l cjo = h.this.iCe.ckc().getPbData().cjo();
                if (h.this.iWA == null) {
                    h.this.iWA = new PbFullScreenFloatingHuajiAninationView(h.this.iCe.getActivity());
                    h.this.iWA.setFloatingHuajiAninationListener(h.this.iWB);
                }
                h.this.iWA.qY(cjo.cjC() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cre() {
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
                if (j.isMobileNet() && h.this.grV != null && h.this.grV.kP() && h.this.iWd != null && h.this.iWd.video_length.intValue() > 0 && h.this.iWd.video_duration.intValue() > 0) {
                    float intValue = h.this.iWd.video_length.intValue() * (1.0f - ((h.this.grV.getCurrentPosition() * 1.0f) / (h.this.iWd.video_duration.intValue() * 1000)));
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
            if (h.this.iWd != null) {
                h.this.f(h.this.iWd);
                h.this.grV.cwX();
                h.this.grV.cbd();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iWs;
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
        this.iWp = 0.0f;
        this.iCe = pbFragment;
        this.iWa = cVar;
        this.iWp = com.baidu.adp.lib.util.l.getDimens(this.iCe.getActivity(), R.dimen.ds240);
        this.iWu = j;
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
            this.iWb.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity());
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iCe.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? com.baidu.adp.lib.util.l.getEquipmentHeight(this.iCe.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iWt = (intValue2 * 1.0d) / intValue;
            if (this.iWt > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iWs = i;
        this.iWb.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bgb() {
        return this.iWt >= 1.0d;
    }

    public int cps() {
        return this.iWs;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iVZ = (RelativeLayout) LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iWb = (CustomFrameLayout) this.iVZ.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.JR = ((double) this.iWs) <= (((double) com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.grV = new com.baidu.tieba.play.c(this.iCe.getPageContext(), this.iWb, true, com.baidu.tbadk.a.b.rs("cyber_player_test") ? 1 : 0);
        this.grV.a(this.iWH);
        this.grV.rJ(false);
        this.grV.a(this.iWx);
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
                        if (h.this.iCe.getListView() != null && h.this.iCe.getListView().getChildCount() > 0 && h.this.iCe.getListView().getChildAt(0) == h.this.cra()) {
                            h.this.iWI = h.this.cra().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.Bn = 0.0f;
                        h.this.iWI = 0;
                        break;
                    case 2:
                        if (h.this.iCe.getListView() != null && h.this.iCe.getListView().getChildCount() > 0 && h.this.iCe.getListView().getChildAt(0) == h.this.cra()) {
                            h.this.iCe.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.Bn)) + h.this.iWI);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iWt >= 1.0d) {
                this.grV.ah(false, true);
            } else {
                this.grV.ah(true, false);
            }
            this.iWq = ((float) f) + this.iWp > ((float) com.baidu.adp.lib.util.l.getEquipmentHeight(this.iCe.getActivity()));
            if (this.iWq) {
                if (this.iWf == null) {
                    this.iWf = new f(this.iCe.getPageContext(), this.iWb);
                }
                this.iCe.ckX().coO();
                this.iWg = true;
            }
        }
        cqV();
        this.mEmptyView = new View(this.iCe.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iWs));
        if (this.iWa != null && this.iWa.mNavigationBar != null) {
            this.iWa.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iWa.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iWa.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aDB() && !TbSingleton.getInstance().isNotchScreen(this.iCe.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iCe.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iWv = (PbVideoWifiTipLayout) this.iVZ.findViewById(R.id.layout_wifi_tip);
        this.iWv.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iWE = true;
                h.this.iWv.setVisibility(8);
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
        if (this.iWc == null) {
            this.iWc = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lF(boolean z) {
                    if (h.this.cqY() && h.this.iWa != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iWa.cpE().clearAnimation();
                        h.this.cqW();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.hXP);
                            h.this.iWa.cpE().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bEL() {
                    if (h.this.cqY()) {
                        h.this.cpM();
                    }
                }
            };
        }
        a(this.iWc);
        this.iWl = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iCe.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.grV != null && bjVar != null) {
            this.iWd = videoInfo;
            this.iWh = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.grV.stopPlay();
            this.grV.setIsNeedRecoveryVideoPlayer(true);
            this.egU = new n(this.iCe.getActivity());
            this.iWe = new y();
            this.iWe.mLocate = "pb";
            this.iWe.OG = bjVar.getTid();
            this.iWe.fKa = str;
            this.iWe.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iCe.iGB)) {
                    this.iWe.cKN = this.iCe.iGB;
                }
                this.iWe.jvQ = this.iCe.iGA + "";
            } else {
                this.iWe.jvQ = this.iCe.ckU();
            }
            ax clJ = this.iCe.clJ();
            if (clJ != null) {
                clJ.b(this.iWe);
            }
            this.iWe.jvS = videoInfo.video_md5;
            y cxX = this.iWe.cxX();
            cxX.mLocate = "6";
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
                        if (h.this.JR && !em && !h.this.iWm) {
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
                                        h.this.gLE.b(aVar, (ViewGroup) h.this.grV.cwW());
                                    } else {
                                        h.this.gLE.a(aVar, (ViewGroup) h.this.grV.cwW());
                                    }
                                }
                            } else if (h.this.gLE.isShowing()) {
                                h.this.gLE.dismiss();
                            }
                        }
                    }
                }
            });
            this.egU.setVideoStatsData(cxX);
            this.grV.cwF().setBusiness(this.egU);
            if (this.grV.cbf()) {
                this.grV.cbd();
            }
            this.grV.b(this.iWy);
            this.iWj = null;
            this.iWi = null;
            this.grV.Gh(this.iWj);
            this.grV.caZ().setOnDragingListener(hZN);
            this.grV.a(new c.InterfaceC0581c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kO() {
                    h.this.iCe.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iWw > 0) {
                                h.this.zm(h.this.iWw);
                                h.this.zn(h.this.iWw);
                                h.this.iWw = 0;
                            }
                            h.this.iWz = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0581c
                public void kN() {
                    h.this.iCe.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iWz = false;
                    h.this.iWw = h.this.bat().getHeight();
                }
            });
            this.grV.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void crc() {
                    if (h.this.iCe != null && h.this.iWi != null && !StringUtils.isNull(h.this.iWi.getId())) {
                        h.this.iCe.Fz(h.this.iWi.getId());
                    }
                }
            });
            this.grV.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qN(boolean z) {
                    if (h.this.iWh != null) {
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
            this.grV.a(iWJ);
            this.grV.bOk();
            this.grV.show();
        }
    }

    public void Gg(String str) {
        if (this.iWe != null) {
            this.iWe.fKa = str;
        }
    }

    public void b(PostData postData, bj bjVar, l lVar) {
        if (this.iWf != null) {
            this.iWf.a(postData, bjVar, lVar);
        }
    }

    public void a(c.d dVar) {
        this.iWy = dVar;
    }

    public void aH(bj bjVar) {
        this.iWi = bjVar;
    }

    public void Gh(String str) {
        this.iWj = str;
        if (this.grV != null) {
            this.grV.Gh(this.iWj);
        }
    }

    public void startPlay() {
        if (this.grV != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iWE && !com.baidu.tieba.video.g.cNK().cNL()) {
                this.iWv.setVisibility(0);
                this.iWv.setData(this.iWd);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iWh != null && this.iWh.aAo() != null) {
                TiebaStatic.log(new an("c12619").cp("obj_locate", "pb").cp("tid", this.iWh.getTid()));
                this.mVideoUrl = this.iWh.aAo().video_url;
            }
            this.grV.dZ(this.mVideoUrl, this.iWh == null ? "" : this.iWh.getTid());
            AS("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cqU() {
        if (this.grV != null) {
            this.grV.cqU();
        }
    }

    public void destroy() {
        if (this.grV != null) {
            this.grV.destroy();
        }
        if (this.iWb != null) {
            this.iWb.clearAnimation();
        }
        if (this.iWf != null) {
            this.iWf.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tB);
        MessageManager.getInstance().unRegisterListener(this.gnG);
    }

    public void onPause() {
        if (this.grV != null) {
            if (this.grV.kP()) {
                this.iWk = true;
                this.grV.stopPlay();
            } else if (this.grV.getCurrentState() == 3) {
                this.iWk = false;
            } else if (this.grV.getCurrentState() == 0 || this.grV.getCurrentState() == 1) {
                this.iWk = true;
                this.grV.stopPlay();
            } else {
                this.iWk = false;
                this.grV.stopPlay();
            }
            if (this.iWA != null) {
                this.iWA.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.grV != null && this.iWk) {
            this.grV.cwJ();
        }
    }

    private void cqV() {
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
                    if (h.this.iWD == null) {
                        try {
                            h.this.iWD = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iWD);
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
                    h.this.iWC = null;
                    if (h.this.iWD != null && !h.this.iWD.isRecycled()) {
                        h.this.iWD.recycle();
                    }
                    h.this.iWD = null;
                }
            });
            this.iWC = dVar.fI();
            this.iWC.showOnDecorView(this.iCe.getActivity());
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
        if (this.iWd != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iWd.video_md5, "", str, this.iWe);
            }
        }
    }

    public void cqW() {
        if (this.iWa != null) {
            this.iWa.qC(this.iCe.cjR());
        }
    }

    public void cpM() {
        if (this.iWa != null) {
            this.iWa.cpM();
        }
    }

    public void zb(int i) {
        if (this.iWa != null) {
            this.iWa.zb(i);
        }
        if (this.iWA != null) {
            this.iWA.onChangeSkinType(i);
        }
        if (this.iWf != null) {
            this.iWf.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cqZ()) {
                    this.iWn = i;
                    if (this.iWn == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zn(h.this.bat().getHeight());
                            }
                        }, 100L);
                    }
                    cqX();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(int i) {
        if (bat().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iWb.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iWG = false;
                    if (this.iWs != bat().getHeight()) {
                        this.iWb.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()), Math.min(this.iWs, bat().getHeight() + i)));
                        this.grV.cbd();
                    }
                } else if (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()) * 0.5625d != bat().getHeight()) {
                    this.iWb.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getActivity()) * 0.5625d, bat().getHeight() + i)));
                    this.grV.cbd();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cra()) {
                int bottom = childAt.getBottom() - bat().getBottom();
                if (childAt.getHeight() == 0 || bat().getHeight() == 0) {
                    bottom = 0;
                }
                zm(bottom);
            } else {
                zm((-this.iWs) + 2);
            }
        }
        if (!cqZ() && this.iWz) {
            if (this.iWn == 1) {
                this.iWF = true;
                zn(bat().getHeight());
            } else if (this.iWn == 2) {
                this.iWF = true;
                int y = (int) bat().getY();
                if (this.iWo == y) {
                    zn(bat().getHeight());
                } else {
                    this.iWo = y;
                    zn(bat().getHeight());
                }
                if (i == 0 && this.iWr) {
                    this.iWr = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cqU();
                        }
                    }, 100L);
                }
            } else if (this.iWn == 0) {
                if (this.iWF || !"nani_midpage".equals(this.iCe.ckU())) {
                    zn(bat().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        zo(i);
        cqX();
    }

    public void qp(boolean z) {
        this.iWG = z;
    }

    private void zo(int i) {
        if (this.iWf != null) {
            if (this.iWh != null && this.iWh.aBV()) {
                this.iWf.cqS().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iWs;
            }
            float f = this.iWs - i;
            float f2 = f > this.iWp ? 0.0f : 1.0f - (f / this.iWp);
            if (this.iWG) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iWf.cqS().setVisibility(8);
            } else {
                this.iWf.cqS().setVisibility(0);
            }
            this.iWf.aF(f2);
        }
    }

    public void cqX() {
        if (this.iWf != null) {
            if (cqZ()) {
                this.iCe.ckX().coO();
            } else if (this.iWf.cqS().getVisibility() == 0) {
                this.iCe.ckX().coO();
                this.iWg = true;
            } else if (this.iWg) {
                this.iCe.ckX().qo(false);
                this.iWg = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqY() {
        return bat().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iWm = false;
        if (this.grV != null && this.iWb != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iWb.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gLE != null && this.gLE.isShowing()) {
                    this.gLE.Bp();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iWC != null) {
                    this.iWC.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iWm = true;
                this.iWb.setLayoutParams(layoutParams);
                this.iCe.ckX().coO();
                this.iWg = true;
            } else {
                f(this.iWd);
                cqW();
                this.iWm = false;
                this.iWa.qB(true);
            }
            this.grV.a(this.iCe.getPageContext(), configuration);
        }
    }

    public boolean cqZ() {
        return this.iWm;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iWf != null) {
            this.iWf.R(onClickListener);
        }
    }

    public View bat() {
        return this.iVZ;
    }

    public boolean coX() {
        if (bat() == null) {
            return false;
        }
        return bat().getBottom() > com.baidu.adp.lib.util.l.getEquipmentHeight(bat().getContext()) - com.baidu.adp.lib.util.l.getDimens(bat().getContext(), R.dimen.ds50);
    }

    public void cpq() {
        this.iWr = true;
    }

    public View cra() {
        return this.mEmptyView;
    }
}
