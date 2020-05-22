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
import com.alibaba.fastjson.asm.Opcodes;
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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
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
/* loaded from: classes9.dex */
public class h {
    private static VideoControllerView.a jcz = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bmO() {
        }
    };
    private static c.i kbK = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bXz() {
        }
    };
    private float Vr;
    private boolean adG;
    private n fbO;
    private com.baidu.mcn.c hNQ;
    private com.baidu.tieba.play.c hsT;
    private PbFragment jGF;
    private PbFullScreenFloatingHuajiAninationView kbB;
    private com.baidu.adp.lib.guide.c kbD;
    private Bitmap kbE;
    private boolean kbF;
    private boolean kbH;
    private int kbJ;
    private RelativeLayout kba;
    private com.baidu.tieba.pb.pb.main.view.c kbb;
    private CustomFrameLayout kbc;
    private c.d kbd;
    private y kbf;
    private f kbg;
    private boolean kbh;
    private bk kbi;
    private bk kbj;
    private String kbk;
    private float kbq;
    private int kbt;
    private double kbu;
    private long kbv;
    private PbVideoWifiTipLayout kbw;
    private int kbx;
    private c.d kbz;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo kbe = null;
    private boolean kbl = false;
    private int kbm = 0;
    private boolean kbn = false;
    private int kbo = 0;
    private int kbp = 0;
    private boolean kbr = false;
    private boolean kbs = false;
    private long startPosition = -1;
    private int gUq = 0;
    private c.p kby = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cKr() {
            if (h.this.jGF != null && h.this.jGF.cDy() != null && h.this.jGF.cDy().getPbData() != null) {
                PostData cCr = h.this.jGF.cDy().getPbData().cCr();
                if (cCr == null && v.getCount(h.this.jGF.cDy().getPbData().cCk()) > 1) {
                    cCr = (PostData) v.getItem(h.this.jGF.cDy().getPbData().cCk(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.jGF.cDy().getPbData(), cCr, 1, 1, 4);
            }
        }
    };
    private boolean kbA = true;
    private PbFullScreenFloatingHuajiAninationView.a kbC = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.sw(false);
        }
    };
    private boolean kbG = false;
    private c.m kbI = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cKt() {
            if (h.this.kbu < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.jGF.checkUpIsLogin()) {
                h.this.jGF.cEX();
                if (h.this.jGF.cDy() == null || h.this.jGF.cDy().getPbData() == null || h.this.jGF.cDy().getPbData().cCG() == null) {
                    return false;
                }
                m cCG = h.this.jGF.cDy().getPbData().cCG();
                if (h.this.kbB == null) {
                    h.this.kbB = new PbFullScreenFloatingHuajiAninationView(h.this.jGF.getActivity());
                    h.this.kbB.setFloatingHuajiAninationListener(h.this.kbC);
                }
                h.this.kbB.sL(cCG.cCZ() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cKu() {
            return false;
        }
    };
    private CustomMessageListener MX = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hsT != null) {
                    h.this.hsT.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hsT != null && h.this.hsT.pO() && h.this.kbe != null && h.this.kbe.video_length.intValue() > 0 && h.this.kbe.video_duration.intValue() > 0) {
                    float intValue = h.this.kbe.video_length.intValue() * (1.0f - ((h.this.hsT.getCurrentPosition() * 1.0f) / (h.this.kbe.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.jGF.getPageContext().getPageActivity(), String.format(h.this.jGF.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jaA = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cJd();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener hoI = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.kbe != null) {
                h.this.f(h.this.kbe);
                h.this.hsT.cQo();
                h.this.hsT.cub();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kbt;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(boolean z) {
        if (this.jGF != null) {
            this.jGF.cEq();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kbq = 0.0f;
        this.jGF = pbFragment;
        this.kbb = cVar;
        this.kbq = l.getDimens(this.jGF.getActivity(), R.dimen.ds240);
        this.kbv = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.MX);
        this.hoI.setTag(pbFragment.getUniqueId());
        this.hoI.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hoI);
        this.hNQ = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kbc.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.jGF.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.jGF.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.jGF.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.jGF.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kbu = (intValue2 * 1.0d) / intValue;
            if (this.kbu > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kbt = i;
        this.kbc.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bxC() {
        return this.kbu >= 1.0d;
    }

    public int cIJ() {
        return this.kbt;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kba = (RelativeLayout) LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kbc = (CustomFrameLayout) this.kba.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.adG = ((double) this.kbt) <= (((double) l.getEquipmentWidth(this.jGF.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hsT = new com.baidu.tieba.play.c(this.jGF.getPageContext(), this.kbc, true, com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test") ? 1 : 0);
        this.hsT.a(this.kbI);
        this.hsT.tu(false);
        this.hsT.a(this.kby);
        this.hsT.BC(am.lb(R.drawable.pic_use_header_60_n));
        this.hsT.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.jGF.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.jGF.getBaseFragmentActivity())) {
            this.hsT.tl(false);
        }
        this.hsT.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.Vr = motionEvent.getY();
                        if (h.this.jGF.getListView() != null && h.this.jGF.getListView().getChildCount() > 0 && h.this.jGF.getListView().getChildAt(0) == h.this.cKq()) {
                            h.this.kbJ = h.this.cKq().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.Vr = 0.0f;
                        h.this.kbJ = 0;
                        break;
                    case 2:
                        if (h.this.jGF.getListView() != null && h.this.jGF.getListView().getChildCount() > 0 && h.this.jGF.getListView().getChildAt(0) == h.this.cKq()) {
                            h.this.jGF.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.Vr)) + h.this.kbJ);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kbu >= 1.0d) {
                this.hsT.an(false, true);
            } else {
                this.hsT.an(true, false);
            }
            this.kbr = ((float) f) + this.kbq > ((float) l.getEquipmentHeight(this.jGF.getActivity()));
            if (this.kbr) {
                if (this.kbg == null) {
                    this.kbg = new f(this.jGF.getPageContext(), this.kbc);
                }
                this.jGF.cEo().cIe();
                this.kbh = true;
            }
        }
        cKl();
        this.mEmptyView = new View(this.jGF.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kbt));
        if (this.kbb != null && this.kbb.mNavigationBar != null) {
            this.kbb.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kbb.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kbb.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aUh() && !TbSingleton.getInstance().isNotchScreen(this.jGF.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jGF.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kbw = (PbVideoWifiTipLayout) this.kba.findViewById(R.id.layout_wifi_tip);
        this.kbw.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kbF = true;
                h.this.kbw.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.hNQ != null) {
            this.hNQ.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.jGF.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kbd == null) {
            this.kbd = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void nm(boolean z) {
                    if (h.this.cKo() && h.this.kbb != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kbb.cIW().clearAnimation();
                        h.this.cKm();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jaA);
                            h.this.kbb.cIW().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bXy() {
                    if (h.this.cKo()) {
                        h.this.cJd();
                    }
                }
            };
        }
        a(this.kbd);
        this.kbm = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jGF.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bk bkVar, final String str) {
        if (videoInfo != null && this.hsT != null && bkVar != null) {
            this.kbe = videoInfo;
            this.kbi = bkVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hsT.stopPlay();
            this.hsT.setIsNeedRecoveryVideoPlayer(true);
            this.fbO = new n(this.jGF.getActivity());
            this.kbf = new y();
            this.kbf.mLocate = "pb";
            this.kbf.ais = bkVar.getTid();
            this.kbf.evm = str;
            this.kbf.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bkVar.isBjh()) {
                if (!StringUtils.isNull(this.jGF.jLd)) {
                    this.kbf.dCp = this.jGF.jLd;
                }
                this.kbf.kAn = this.jGF.jLc + "";
            } else {
                this.kbf.kAn = this.jGF.cEl();
            }
            ay cEZ = this.jGF.cEZ();
            if (cEZ != null) {
                cEZ.b(this.kbf);
            }
            this.kbf.kAq = videoInfo.video_md5;
            y cRp = this.kbf.cRp();
            cRp.mLocate = "6";
            this.startPosition = -1L;
            this.fbO.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean gg = com.baidu.mcn.b.Lx().gg(mcnAdInfo.jump_url);
                        if (h.this.adG && !gg && !h.this.kbn) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.hNQ.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.boJ = mcnAdInfo.card_title;
                                    aVar.boK = mcnAdInfo.button_title;
                                    aVar.boL = mcnAdInfo.jump_url;
                                    aVar.boI = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bkVar.getTid();
                                    aVar.boM = 4;
                                    if (z2) {
                                        h.this.hNQ.b(aVar, (ViewGroup) h.this.hsT.cQn());
                                    } else {
                                        h.this.hNQ.a(aVar, (ViewGroup) h.this.hsT.cQn());
                                    }
                                }
                            } else if (h.this.hNQ.isShowing()) {
                                h.this.hNQ.dismiss();
                            }
                        }
                    }
                }
            });
            this.fbO.setVideoStatsData(cRp);
            this.hsT.cPW().setBusiness(this.fbO);
            if (this.hsT.cud()) {
                this.hsT.cub();
            }
            this.hsT.b(this.kbz);
            this.kbk = null;
            this.kbj = null;
            this.hsT.JT(this.kbk);
            this.hsT.ctX().setOnDragingListener(jcz);
            this.hsT.a(new c.InterfaceC0703c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pN() {
                    h.this.jGF.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kbx > 0) {
                                h.this.AM(h.this.kbx);
                                h.this.AN(h.this.kbx);
                                h.this.kbx = 0;
                            }
                            h.this.kbA = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0703c
                public void pM() {
                    h.this.jGF.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kbA = false;
                    h.this.kbx = h.this.brc().getHeight();
                }
            });
            this.hsT.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cKs() {
                    if (h.this.jGF != null && h.this.kbj != null && !StringUtils.isNull(h.this.kbj.getId())) {
                        h.this.jGF.Jk(h.this.kbj.getId());
                    }
                }
            });
            this.hsT.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void sx(boolean z) {
                    if (h.this.kbi != null) {
                        h.this.EG(z ? "1" : "2");
                    }
                }
            });
            this.hsT.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hsT.setThumbnail(videoInfo.thumbnail_url);
            this.hsT.setVideoUrl(this.mVideoUrl, bkVar.getTid());
            this.hsT.setFid(str);
            this.hsT.Ku(bkVar.getTitle());
            this.hsT.a(kbK);
            this.hsT.chf();
            this.hsT.show();
        }
    }

    public void JS(String str) {
        if (this.kbf != null) {
            this.kbf.evm = str;
        }
    }

    public void b(PostData postData, bk bkVar, m mVar) {
        if (this.kbg != null) {
            this.kbg.a(postData, bkVar, mVar);
        }
    }

    public void a(c.d dVar) {
        this.kbz = dVar;
    }

    public void aM(bk bkVar) {
        this.kbj = bkVar;
    }

    public void JT(String str) {
        this.kbk = str;
        if (this.hsT != null) {
            this.hsT.JT(this.kbk);
        }
    }

    public void startPlay() {
        if (this.hsT != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kbF && !com.baidu.tieba.video.g.dhK().dhL()) {
                this.kbw.setVisibility(0);
                this.kbw.setData(this.kbe);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kbi != null && this.kbi.aQQ() != null) {
                TiebaStatic.log(new an("c12619").dh("obj_locate", "pb").dh("tid", this.kbi.getTid()));
                this.mVideoUrl = this.kbi.aQQ().video_url;
            }
            this.hsT.eW(this.mVideoUrl, this.kbi == null ? "" : this.kbi.getTid());
            EG("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cKk() {
        if (this.hsT != null) {
            this.hsT.cKk();
        }
    }

    public void destroy() {
        if (this.hsT != null) {
            this.hsT.destroy();
        }
        if (this.kbc != null) {
            this.kbc.clearAnimation();
        }
        if (this.kbg != null) {
            this.kbg.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.MX);
        MessageManager.getInstance().unRegisterListener(this.hoI);
    }

    public void onPause() {
        if (this.hsT != null) {
            if (this.hsT.pO()) {
                this.kbl = true;
                this.hsT.stopPlay();
            } else if (this.hsT.getCurrentState() == 3) {
                this.kbl = false;
            } else if (this.hsT.getCurrentState() == 0 || this.hsT.getCurrentState() == 1) {
                this.kbl = true;
                this.hsT.stopPlay();
            } else {
                this.kbl = false;
                this.hsT.stopPlay();
            }
            if (this.kbB != null) {
                this.kbB.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hsT != null && this.kbl) {
            this.hsT.cQa();
        }
    }

    private void cKl() {
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ad(true);
            dVar.af(false);
            dVar.aa(16908290).Z(Opcodes.IFEQ).ae(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.jGF.getActivity());
                    if (h.this.kbE == null) {
                        try {
                            h.this.kbE = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kbE);
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
                    h.this.kbD = null;
                    if (h.this.kbE != null && !h.this.kbE.isRecycled()) {
                        h.this.kbE.recycle();
                    }
                    h.this.kbE = null;
                }
            });
            this.kbD = dVar.ko();
            this.kbD.showOnDecorView(this.jGF.getActivity());
        }
    }

    public boolean uk(int i) {
        if (this.hsT == null) {
            return false;
        }
        return this.hsT.BE(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(String str) {
        if (this.kbe != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.kbe.video_md5, "", str, this.kbf);
            }
        }
    }

    public void cKm() {
        if (this.kbb != null) {
            this.kbb.so(this.jGF.cDo());
        }
    }

    public void cJd() {
        if (this.kbb != null) {
            this.kbb.cJd();
        }
    }

    public void AB(int i) {
        if (this.kbb != null) {
            this.kbb.AB(i);
        }
        if (this.kbB != null) {
            this.kbB.onChangeSkinType(i);
        }
        if (this.kbg != null) {
            this.kbg.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cKp()) {
                    this.kbo = i;
                    if (this.kbo == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.AN(h.this.brc().getHeight());
                            }
                        }, 100L);
                    }
                    cKn();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(int i) {
        if (brc().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kbc.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kbH = false;
                    if (this.kbt != brc().getHeight()) {
                        this.kbc.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jGF.getActivity()), Math.min(this.kbt, brc().getHeight() + i)));
                        this.hsT.cub();
                    }
                } else if (l.getEquipmentWidth(this.jGF.getActivity()) * 0.5625d != brc().getHeight()) {
                    this.kbc.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jGF.getActivity()), (int) Math.max(l.getEquipmentWidth(this.jGF.getActivity()) * 0.5625d, brc().getHeight() + i)));
                    this.hsT.cub();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cKq()) {
                int bottom = childAt.getBottom() - brc().getBottom();
                if (childAt.getHeight() == 0 || brc().getHeight() == 0) {
                    bottom = 0;
                }
                AM(bottom);
            } else {
                AM((-this.kbt) + 2);
            }
        }
        if (!cKp() && this.kbA) {
            if (this.kbo == 1) {
                this.kbG = true;
                AN(brc().getHeight());
            } else if (this.kbo == 2) {
                this.kbG = true;
                int y = (int) brc().getY();
                if (this.kbp == y) {
                    AN(brc().getHeight());
                } else {
                    this.kbp = y;
                    AN(brc().getHeight());
                }
                if (i == 0 && this.kbs) {
                    this.kbs = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cKk();
                        }
                    }, 100L);
                }
            } else if (this.kbo == 0) {
                if (this.kbG || !"nani_midpage".equals(this.jGF.cEl())) {
                    AN(brc().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(int i) {
        AO(i);
        cKn();
    }

    public void sb(boolean z) {
        this.kbH = z;
    }

    private void AO(int i) {
        if (this.kbg != null) {
            if (this.kbi != null && this.kbi.aSx()) {
                this.kbg.cKi().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kbt;
            }
            float f = this.kbt - i;
            float f2 = f > this.kbq ? 0.0f : 1.0f - (f / this.kbq);
            if (this.kbH) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kbg.cKi().setVisibility(8);
            } else {
                this.kbg.cKi().setVisibility(0);
            }
            this.kbg.an(f2);
        }
    }

    public void cKn() {
        if (this.kbg != null) {
            if (cKp()) {
                this.jGF.cEo().cIe();
            } else if (this.kbg.cKi().getVisibility() == 0) {
                this.jGF.cEo().cIe();
                this.kbh = true;
            } else if (this.kbh) {
                this.jGF.cEo().sa(false);
                this.kbh = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKo() {
        return brc().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kbn = false;
        if (this.hsT != null && this.kbc != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kbc.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.hNQ != null && this.hNQ.isShowing()) {
                    this.hNQ.Ly();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kbD != null) {
                    this.kbD.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kbn = true;
                this.kbc.setLayoutParams(layoutParams);
                this.jGF.cEo().cIe();
                this.kbh = true;
            } else {
                f(this.kbe);
                cKm();
                this.kbn = false;
                this.kbb.sn(true);
            }
            this.hsT.a(this.jGF.getPageContext(), configuration);
        }
    }

    public boolean cKp() {
        return this.kbn;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.kbg != null) {
            this.kbg.S(onClickListener);
        }
    }

    public View brc() {
        return this.kba;
    }

    public boolean cIn() {
        if (brc() == null) {
            return false;
        }
        return brc().getBottom() > l.getEquipmentHeight(brc().getContext()) - l.getDimens(brc().getContext(), R.dimen.ds50);
    }

    public void cIH() {
        this.kbs = true;
    }

    public View cKq() {
        return this.mEmptyView;
    }
}
