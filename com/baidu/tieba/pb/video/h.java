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
import com.baidu.tieba.pb.data.k;
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
    private float BF;
    private boolean Kn;
    private n elm;
    private com.baidu.mcn.c gNR;
    private com.baidu.tieba.play.c guk;
    private PbFragment iEk;
    private RelativeLayout iXC;
    private com.baidu.tieba.pb.pb.main.view.c iXD;
    private CustomFrameLayout iXE;
    private c.d iXF;
    private y iXH;
    private f iXI;
    private boolean iXJ;
    private bj iXK;
    private bj iXL;
    private String iXM;
    private float iXS;
    private int iXV;
    private double iXW;
    private long iXX;
    private PbVideoWifiTipLayout iXY;
    private int iXZ;
    private c.d iYb;
    private PbFullScreenFloatingHuajiAninationView iYd;
    private com.baidu.adp.lib.guide.c iYf;
    private Bitmap iYg;
    private boolean iYh;
    private boolean iYj;
    private int iYl;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a ibZ = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aYx() {
        }
    };
    private static c.i iYm = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bGr() {
        }
    };
    private String mVideoUrl = null;
    private VideoInfo iXG = null;
    private boolean iXN = false;
    private int iXO = 0;
    private boolean iXP = false;
    private int iXQ = 0;
    private int iXR = 0;
    private boolean iXT = false;
    private boolean iXU = false;
    private long startPosition = -1;
    private int fYp = 0;
    private c.p iYa = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void csu() {
            if (h.this.iEk != null && h.this.iEk.clC() != null && h.this.iEk.clC().getPbData() != null) {
                PostData ckC = h.this.iEk.clC().getPbData().ckC();
                if (ckC == null && v.getCount(h.this.iEk.clC().getPbData().ckx()) > 1) {
                    ckC = (PostData) v.getItem(h.this.iEk.clC().getPbData().ckx(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iEk.clC().getPbData(), ckC, 1, 1, 4);
            }
        }
    };
    private boolean iYc = true;
    private PbFullScreenFloatingHuajiAninationView.a iYe = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qO(false);
        }
    };
    private boolean iYi = false;
    private c.m iYk = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean csw() {
            if (h.this.iXW < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iEk.checkUpIsLogin()) {
                h.this.iEk.cne();
                if (h.this.iEk.clC() == null || h.this.iEk.clC().getPbData() == null || h.this.iEk.clC().getPbData().ckQ() == null) {
                    return false;
                }
                k ckQ = h.this.iEk.clC().getPbData().ckQ();
                if (h.this.iYd == null) {
                    h.this.iYd = new PbFullScreenFloatingHuajiAninationView(h.this.iEk.getActivity());
                    h.this.iYd.setFloatingHuajiAninationListener(h.this.iYe);
                }
                h.this.iYd.rd(ckQ.cld() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean csx() {
            return false;
        }
    };
    private CustomMessageListener tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.guk != null) {
                    h.this.guk.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.guk != null && h.this.guk.le() && h.this.iXG != null && h.this.iXG.video_length.intValue() > 0 && h.this.iXG.video_duration.intValue() > 0) {
                    float intValue = h.this.iXG.video_length.intValue() * (1.0f - ((h.this.guk.getCurrentPosition() * 1.0f) / (h.this.iXG.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.iEk.getPageContext().getPageActivity(), String.format(h.this.iEk.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener iab = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.crh();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gpW = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.iXG != null) {
                h.this.f(h.this.iXG);
                h.this.guk.cyt();
                h.this.guk.ccH();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iXV;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(boolean z) {
        if (this.iEk != null) {
            this.iEk.cmw();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.iXS = 0.0f;
        this.iEk = pbFragment;
        this.iXD = cVar;
        this.iXS = l.getDimens(this.iEk.getActivity(), R.dimen.ds240);
        this.iXX = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.gpW.setTag(pbFragment.getUniqueId());
        this.gpW.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gpW);
        this.gNR = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.iXE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.iEk.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.iEk.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iEk.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.iEk.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iXW = (intValue2 * 1.0d) / intValue;
            if (this.iXW > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iXV = i;
        this.iXE.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bin() {
        return this.iXW >= 1.0d;
    }

    public int cqN() {
        return this.iXV;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iXC = (RelativeLayout) LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iXE = (CustomFrameLayout) this.iXC.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.Kn = ((double) this.iXV) <= (((double) l.getEquipmentWidth(this.iEk.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.guk = new com.baidu.tieba.play.c(this.iEk.getPageContext(), this.iXE, true, com.baidu.tbadk.a.b.rH("cyber_player_test") ? 1 : 0);
        this.guk.a(this.iYk);
        this.guk.rM(false);
        this.guk.a(this.iYa);
        this.guk.Ak(am.ku(R.drawable.pic_use_header_60_n));
        this.guk.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.iEk.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.iEk.getBaseFragmentActivity())) {
            this.guk.rD(false);
        }
        this.guk.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.BF = motionEvent.getY();
                        if (h.this.iEk.getListView() != null && h.this.iEk.getListView().getChildCount() > 0 && h.this.iEk.getListView().getChildAt(0) == h.this.cst()) {
                            h.this.iYl = h.this.cst().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.BF = 0.0f;
                        h.this.iYl = 0;
                        break;
                    case 2:
                        if (h.this.iEk.getListView() != null && h.this.iEk.getListView().getChildCount() > 0 && h.this.iEk.getListView().getChildAt(0) == h.this.cst()) {
                            h.this.iEk.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.BF)) + h.this.iYl);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iXW >= 1.0d) {
                this.guk.aj(false, true);
            } else {
                this.guk.aj(true, false);
            }
            this.iXT = ((float) f) + this.iXS > ((float) l.getEquipmentHeight(this.iEk.getActivity()));
            if (this.iXT) {
                if (this.iXI == null) {
                    this.iXI = new f(this.iEk.getPageContext(), this.iXE);
                }
                this.iEk.cmu().cqj();
                this.iXJ = true;
            }
        }
        cso();
        this.mEmptyView = new View(this.iEk.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iXV));
        if (this.iXD != null && this.iXD.mNavigationBar != null) {
            this.iXD.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iXD.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iXD.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aFN() && !TbSingleton.getInstance().isNotchScreen(this.iEk.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iEk.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iXY = (PbVideoWifiTipLayout) this.iXC.findViewById(R.id.layout_wifi_tip);
        this.iXY.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iYh = true;
                h.this.iXY.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.gNR != null) {
            this.gNR.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.iEk.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.iXF == null) {
            this.iXF = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lI(boolean z) {
                    if (h.this.csr() && h.this.iXD != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iXD.cra().clearAnimation();
                        h.this.csp();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.iab);
                            h.this.iXD.cra().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGq() {
                    if (h.this.csr()) {
                        h.this.crh();
                    }
                }
            };
        }
        a(this.iXF);
        this.iXO = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iEk.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.guk != null && bjVar != null) {
            this.iXG = videoInfo;
            this.iXK = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.guk.stopPlay();
            this.guk.setIsNeedRecoveryVideoPlayer(true);
            this.elm = new n(this.iEk.getActivity());
            this.iXH = new y();
            this.iXH.mLocate = "pb";
            this.iXH.Pj = bjVar.getTid();
            this.iXH.emo = str;
            this.iXH.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iEk.iIt)) {
                    this.iXH.cOS = this.iEk.iIt;
                }
                this.iXH.jwU = this.iEk.iIs + "";
            } else {
                this.iXH.jwU = this.iEk.cmr();
            }
            ax cng = this.iEk.cng();
            if (cng != null) {
                cng.b(this.iXH);
            }
            this.iXH.jwW = videoInfo.video_md5;
            y czu = this.iXH.czu();
            czu.mLocate = "6";
            this.startPosition = -1L;
            this.elm.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean eB = com.baidu.mcn.b.DG().eB(mcnAdInfo.jump_url);
                        if (h.this.Kn && !eB && !h.this.iXP) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.gNR.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLl = mcnAdInfo.card_title;
                                    aVar.aLm = mcnAdInfo.button_title;
                                    aVar.aLn = mcnAdInfo.jump_url;
                                    aVar.aLk = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.aLo = 4;
                                    if (z2) {
                                        h.this.gNR.b(aVar, (ViewGroup) h.this.guk.cys());
                                    } else {
                                        h.this.gNR.a(aVar, (ViewGroup) h.this.guk.cys());
                                    }
                                }
                            } else if (h.this.gNR.isShowing()) {
                                h.this.gNR.dismiss();
                            }
                        }
                    }
                }
            });
            this.elm.setVideoStatsData(czu);
            this.guk.cyb().setBusiness(this.elm);
            if (this.guk.ccJ()) {
                this.guk.ccH();
            }
            this.guk.b(this.iYb);
            this.iXM = null;
            this.iXL = null;
            this.guk.Gx(this.iXM);
            this.guk.ccD().setOnDragingListener(ibZ);
            this.guk.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    h.this.iEk.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iXZ > 0) {
                                h.this.zs(h.this.iXZ);
                                h.this.zt(h.this.iXZ);
                                h.this.iXZ = 0;
                            }
                            h.this.iYc = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    h.this.iEk.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iYc = false;
                    h.this.iXZ = h.this.bcL().getHeight();
                }
            });
            this.guk.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void csv() {
                    if (h.this.iEk != null && h.this.iXL != null && !StringUtils.isNull(h.this.iXL.getId())) {
                        h.this.iEk.FP(h.this.iXL.getId());
                    }
                }
            });
            this.guk.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qP(boolean z) {
                    if (h.this.iXK != null) {
                        h.this.Bj(z ? "1" : "2");
                    }
                }
            });
            this.guk.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.guk.setThumbnail(videoInfo.thumbnail_url);
            this.guk.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.guk.setFid(str);
            this.guk.GY(bjVar.getTitle());
            this.guk.a(iYm);
            this.guk.bPP();
            this.guk.show();
        }
    }

    public void Gw(String str) {
        if (this.iXH != null) {
            this.iXH.emo = str;
        }
    }

    public void b(PostData postData, bj bjVar, k kVar) {
        if (this.iXI != null) {
            this.iXI.a(postData, bjVar, kVar);
        }
    }

    public void a(c.d dVar) {
        this.iYb = dVar;
    }

    public void aK(bj bjVar) {
        this.iXL = bjVar;
    }

    public void Gx(String str) {
        this.iXM = str;
        if (this.guk != null) {
            this.guk.Gx(this.iXM);
        }
    }

    public void startPlay() {
        if (this.guk != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iYh && !com.baidu.tieba.video.g.cPi().cPj()) {
                this.iXY.setVisibility(0);
                this.iXY.setData(this.iXG);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iXK != null && this.iXK.aCF() != null) {
                TiebaStatic.log(new an("c12619").cy("obj_locate", "pb").cy("tid", this.iXK.getTid()));
                this.mVideoUrl = this.iXK.aCF().video_url;
            }
            this.guk.ei(this.mVideoUrl, this.iXK == null ? "" : this.iXK.getTid());
            Bj("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void csn() {
        if (this.guk != null) {
            this.guk.csn();
        }
    }

    public void destroy() {
        if (this.guk != null) {
            this.guk.destroy();
        }
        if (this.iXE != null) {
            this.iXE.clearAnimation();
        }
        if (this.iXI != null) {
            this.iXI.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tR);
        MessageManager.getInstance().unRegisterListener(this.gpW);
    }

    public void onPause() {
        if (this.guk != null) {
            if (this.guk.le()) {
                this.iXN = true;
                this.guk.stopPlay();
            } else if (this.guk.getCurrentState() == 3) {
                this.iXN = false;
            } else if (this.guk.getCurrentState() == 0 || this.guk.getCurrentState() == 1) {
                this.iXN = true;
                this.guk.stopPlay();
            } else {
                this.iXN = false;
                this.guk.stopPlay();
            }
            if (this.iYd != null) {
                this.iYd.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.guk != null && this.iXN) {
            this.guk.cyf();
        }
    }

    private void cso() {
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.N(16908290).M(Opcodes.IFEQ).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.iEk.getActivity());
                    if (h.this.iYg == null) {
                        try {
                            h.this.iYg = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iYg);
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
                    h.this.iYf = null;
                    if (h.this.iYg != null && !h.this.iYg.isRecycled()) {
                        h.this.iYg.recycle();
                    }
                    h.this.iYg = null;
                }
            });
            this.iYf = dVar.fI();
            this.iYf.showOnDecorView(this.iEk.getActivity());
        }
    }

    public boolean tf(int i) {
        if (this.guk == null) {
            return false;
        }
        return this.guk.Am(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(String str) {
        if (this.iXG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iXG.video_md5, "", str, this.iXH);
            }
        }
    }

    public void csp() {
        if (this.iXD != null) {
            this.iXD.qF(this.iEk.cls());
        }
    }

    public void crh() {
        if (this.iXD != null) {
            this.iXD.crh();
        }
    }

    public void zh(int i) {
        if (this.iXD != null) {
            this.iXD.zh(i);
        }
        if (this.iYd != null) {
            this.iYd.onChangeSkinType(i);
        }
        if (this.iXI != null) {
            this.iXI.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!css()) {
                    this.iXQ = i;
                    if (this.iXQ == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zt(h.this.bcL().getHeight());
                            }
                        }, 100L);
                    }
                    csq();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(int i) {
        if (bcL().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXE.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iYj = false;
                    if (this.iXV != bcL().getHeight()) {
                        this.iXE.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iEk.getActivity()), Math.min(this.iXV, bcL().getHeight() + i)));
                        this.guk.ccH();
                    }
                } else if (l.getEquipmentWidth(this.iEk.getActivity()) * 0.5625d != bcL().getHeight()) {
                    this.iXE.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iEk.getActivity()), (int) Math.max(l.getEquipmentWidth(this.iEk.getActivity()) * 0.5625d, bcL().getHeight() + i)));
                    this.guk.ccH();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cst()) {
                int bottom = childAt.getBottom() - bcL().getBottom();
                if (childAt.getHeight() == 0 || bcL().getHeight() == 0) {
                    bottom = 0;
                }
                zs(bottom);
            } else {
                zs((-this.iXV) + 2);
            }
        }
        if (!css() && this.iYc) {
            if (this.iXQ == 1) {
                this.iYi = true;
                zt(bcL().getHeight());
            } else if (this.iXQ == 2) {
                this.iYi = true;
                int y = (int) bcL().getY();
                if (this.iXR == y) {
                    zt(bcL().getHeight());
                } else {
                    this.iXR = y;
                    zt(bcL().getHeight());
                }
                if (i == 0 && this.iXU) {
                    this.iXU = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.csn();
                        }
                    }, 100L);
                }
            } else if (this.iXQ == 0) {
                if (this.iYi || !"nani_midpage".equals(this.iEk.cmr())) {
                    zt(bcL().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(int i) {
        zu(i);
        csq();
    }

    public void qs(boolean z) {
        this.iYj = z;
    }

    private void zu(int i) {
        if (this.iXI != null) {
            if (this.iXK != null && this.iXK.aEi()) {
                this.iXI.csl().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iXV;
            }
            float f = this.iXV - i;
            float f2 = f > this.iXS ? 0.0f : 1.0f - (f / this.iXS);
            if (this.iYj) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iXI.csl().setVisibility(8);
            } else {
                this.iXI.csl().setVisibility(0);
            }
            this.iXI.aE(f2);
        }
    }

    public void csq() {
        if (this.iXI != null) {
            if (css()) {
                this.iEk.cmu().cqj();
            } else if (this.iXI.csl().getVisibility() == 0) {
                this.iEk.cmu().cqj();
                this.iXJ = true;
            } else if (this.iXJ) {
                this.iEk.cmu().qr(false);
                this.iXJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csr() {
        return bcL().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iXP = false;
        if (this.guk != null && this.iXE != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXE.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gNR != null && this.gNR.isShowing()) {
                    this.gNR.DH();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iYf != null) {
                    this.iYf.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iXP = true;
                this.iXE.setLayoutParams(layoutParams);
                this.iEk.cmu().cqj();
                this.iXJ = true;
            } else {
                f(this.iXG);
                csp();
                this.iXP = false;
                this.iXD.qE(true);
            }
            this.guk.a(this.iEk.getPageContext(), configuration);
        }
    }

    public boolean css() {
        return this.iXP;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iXI != null) {
            this.iXI.R(onClickListener);
        }
    }

    public View bcL() {
        return this.iXC;
    }

    public boolean cqs() {
        if (bcL() == null) {
            return false;
        }
        return bcL().getBottom() > l.getEquipmentHeight(bcL().getContext()) - l.getDimens(bcL().getContext(), R.dimen.ds50);
    }

    public void cqL() {
        this.iXU = true;
    }

    public View cst() {
        return this.mEmptyView;
    }
}
