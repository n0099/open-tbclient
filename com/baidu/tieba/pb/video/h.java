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
    private n ekY;
    private com.baidu.mcn.c gND;
    private com.baidu.tieba.play.c gtW;
    private PbFragment iDW;
    private float iXE;
    private int iXH;
    private double iXI;
    private long iXJ;
    private PbVideoWifiTipLayout iXK;
    private int iXL;
    private c.d iXN;
    private PbFullScreenFloatingHuajiAninationView iXP;
    private com.baidu.adp.lib.guide.c iXR;
    private Bitmap iXS;
    private boolean iXT;
    private boolean iXV;
    private int iXX;
    private RelativeLayout iXo;
    private com.baidu.tieba.pb.pb.main.view.c iXp;
    private CustomFrameLayout iXq;
    private c.d iXr;
    private y iXt;
    private f iXu;
    private boolean iXv;
    private bj iXw;
    private bj iXx;
    private String iXy;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a ibL = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aYu() {
        }
    };
    private static c.i iXY = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bGo() {
        }
    };
    private String mVideoUrl = null;
    private VideoInfo iXs = null;
    private boolean iXz = false;
    private int iXA = 0;
    private boolean iXB = false;
    private int iXC = 0;
    private int iXD = 0;
    private boolean iXF = false;
    private boolean iXG = false;
    private long startPosition = -1;
    private int fYa = 0;
    private c.p iXM = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void csr() {
            if (h.this.iDW != null && h.this.iDW.clz() != null && h.this.iDW.clz().getPbData() != null) {
                PostData ckz = h.this.iDW.clz().getPbData().ckz();
                if (ckz == null && v.getCount(h.this.iDW.clz().getPbData().cku()) > 1) {
                    ckz = (PostData) v.getItem(h.this.iDW.clz().getPbData().cku(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iDW.clz().getPbData(), ckz, 1, 1, 4);
            }
        }
    };
    private boolean iXO = true;
    private PbFullScreenFloatingHuajiAninationView.a iXQ = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qO(false);
        }
    };
    private boolean iXU = false;
    private c.m iXW = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cst() {
            if (h.this.iXI < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iDW.checkUpIsLogin()) {
                h.this.iDW.cnb();
                if (h.this.iDW.clz() == null || h.this.iDW.clz().getPbData() == null || h.this.iDW.clz().getPbData().ckN() == null) {
                    return false;
                }
                k ckN = h.this.iDW.clz().getPbData().ckN();
                if (h.this.iXP == null) {
                    h.this.iXP = new PbFullScreenFloatingHuajiAninationView(h.this.iDW.getActivity());
                    h.this.iXP.setFloatingHuajiAninationListener(h.this.iXQ);
                }
                h.this.iXP.rd(ckN.cla() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean csu() {
            return false;
        }
    };
    private CustomMessageListener tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.gtW != null) {
                    h.this.gtW.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.gtW != null && h.this.gtW.le() && h.this.iXs != null && h.this.iXs.video_length.intValue() > 0 && h.this.iXs.video_duration.intValue() > 0) {
                    float intValue = h.this.iXs.video_length.intValue() * (1.0f - ((h.this.gtW.getCurrentPosition() * 1.0f) / (h.this.iXs.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.iDW.getPageContext().getPageActivity(), String.format(h.this.iDW.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hZN = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cre();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.iXs != null) {
                h.this.f(h.this.iXs);
                h.this.gtW.cyq();
                h.this.gtW.ccE();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iXH;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(boolean z) {
        if (this.iDW != null) {
            this.iDW.cmt();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.iXE = 0.0f;
        this.iDW = pbFragment;
        this.iXp = cVar;
        this.iXE = l.getDimens(this.iDW.getActivity(), R.dimen.ds240);
        this.iXJ = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.gpH.setTag(pbFragment.getUniqueId());
        this.gpH.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gpH);
        this.gND = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.iXq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.iDW.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.iDW.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iDW.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.iDW.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iXI = (intValue2 * 1.0d) / intValue;
            if (this.iXI > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iXH = i;
        this.iXq.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bik() {
        return this.iXI >= 1.0d;
    }

    public int cqK() {
        return this.iXH;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iXo = (RelativeLayout) LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iXq = (CustomFrameLayout) this.iXo.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.Kn = ((double) this.iXH) <= (((double) l.getEquipmentWidth(this.iDW.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.gtW = new com.baidu.tieba.play.c(this.iDW.getPageContext(), this.iXq, true, com.baidu.tbadk.a.b.rH("cyber_player_test") ? 1 : 0);
        this.gtW.a(this.iXW);
        this.gtW.rM(false);
        this.gtW.a(this.iXM);
        this.gtW.Ak(am.ku(R.drawable.pic_use_header_60_n));
        this.gtW.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.iDW.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.iDW.getBaseFragmentActivity())) {
            this.gtW.rD(false);
        }
        this.gtW.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.iDW.getListView() != null && h.this.iDW.getListView().getChildCount() > 0 && h.this.iDW.getListView().getChildAt(0) == h.this.csq()) {
                            h.this.iXX = h.this.csq().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.BF = 0.0f;
                        h.this.iXX = 0;
                        break;
                    case 2:
                        if (h.this.iDW.getListView() != null && h.this.iDW.getListView().getChildCount() > 0 && h.this.iDW.getListView().getChildAt(0) == h.this.csq()) {
                            h.this.iDW.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.BF)) + h.this.iXX);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iXI >= 1.0d) {
                this.gtW.aj(false, true);
            } else {
                this.gtW.aj(true, false);
            }
            this.iXF = ((float) f) + this.iXE > ((float) l.getEquipmentHeight(this.iDW.getActivity()));
            if (this.iXF) {
                if (this.iXu == null) {
                    this.iXu = new f(this.iDW.getPageContext(), this.iXq);
                }
                this.iDW.cmr().cqg();
                this.iXv = true;
            }
        }
        csl();
        this.mEmptyView = new View(this.iDW.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iXH));
        if (this.iXp != null && this.iXp.mNavigationBar != null) {
            this.iXp.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iXp.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iXp.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aFL() && !TbSingleton.getInstance().isNotchScreen(this.iDW.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iDW.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iXK = (PbVideoWifiTipLayout) this.iXo.findViewById(R.id.layout_wifi_tip);
        this.iXK.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iXT = true;
                h.this.iXK.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.gND != null) {
            this.gND.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.iDW.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.iXr == null) {
            this.iXr = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lI(boolean z) {
                    if (h.this.cso() && h.this.iXp != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iXp.cqX().clearAnimation();
                        h.this.csm();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.hZN);
                            h.this.iXp.cqX().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGn() {
                    if (h.this.cso()) {
                        h.this.cre();
                    }
                }
            };
        }
        a(this.iXr);
        this.iXA = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iDW.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.gtW != null && bjVar != null) {
            this.iXs = videoInfo;
            this.iXw = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.gtW.stopPlay();
            this.gtW.setIsNeedRecoveryVideoPlayer(true);
            this.ekY = new n(this.iDW.getActivity());
            this.iXt = new y();
            this.iXt.mLocate = "pb";
            this.iXt.Pj = bjVar.getTid();
            this.iXt.ema = str;
            this.iXt.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iDW.iIf)) {
                    this.iXt.cOQ = this.iDW.iIf;
                }
                this.iXt.jwG = this.iDW.iIe + "";
            } else {
                this.iXt.jwG = this.iDW.cmo();
            }
            ax cnd = this.iDW.cnd();
            if (cnd != null) {
                cnd.b(this.iXt);
            }
            this.iXt.jwI = videoInfo.video_md5;
            y czr = this.iXt.czr();
            czr.mLocate = "6";
            this.startPosition = -1L;
            this.ekY.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean eB = com.baidu.mcn.b.DE().eB(mcnAdInfo.jump_url);
                        if (h.this.Kn && !eB && !h.this.iXB) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.gND.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLj = mcnAdInfo.card_title;
                                    aVar.aLk = mcnAdInfo.button_title;
                                    aVar.aLl = mcnAdInfo.jump_url;
                                    aVar.aLi = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.aLm = 4;
                                    if (z2) {
                                        h.this.gND.b(aVar, (ViewGroup) h.this.gtW.cyp());
                                    } else {
                                        h.this.gND.a(aVar, (ViewGroup) h.this.gtW.cyp());
                                    }
                                }
                            } else if (h.this.gND.isShowing()) {
                                h.this.gND.dismiss();
                            }
                        }
                    }
                }
            });
            this.ekY.setVideoStatsData(czr);
            this.gtW.cxY().setBusiness(this.ekY);
            if (this.gtW.ccG()) {
                this.gtW.ccE();
            }
            this.gtW.b(this.iXN);
            this.iXy = null;
            this.iXx = null;
            this.gtW.Gw(this.iXy);
            this.gtW.ccA().setOnDragingListener(ibL);
            this.gtW.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    h.this.iDW.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iXL > 0) {
                                h.this.zs(h.this.iXL);
                                h.this.zt(h.this.iXL);
                                h.this.iXL = 0;
                            }
                            h.this.iXO = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    h.this.iDW.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iXO = false;
                    h.this.iXL = h.this.bcI().getHeight();
                }
            });
            this.gtW.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void css() {
                    if (h.this.iDW != null && h.this.iXx != null && !StringUtils.isNull(h.this.iXx.getId())) {
                        h.this.iDW.FO(h.this.iXx.getId());
                    }
                }
            });
            this.gtW.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qP(boolean z) {
                    if (h.this.iXw != null) {
                        h.this.Bi(z ? "1" : "2");
                    }
                }
            });
            this.gtW.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.gtW.setThumbnail(videoInfo.thumbnail_url);
            this.gtW.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.gtW.setFid(str);
            this.gtW.GX(bjVar.getTitle());
            this.gtW.a(iXY);
            this.gtW.bPM();
            this.gtW.show();
        }
    }

    public void Gv(String str) {
        if (this.iXt != null) {
            this.iXt.ema = str;
        }
    }

    public void b(PostData postData, bj bjVar, k kVar) {
        if (this.iXu != null) {
            this.iXu.a(postData, bjVar, kVar);
        }
    }

    public void a(c.d dVar) {
        this.iXN = dVar;
    }

    public void aK(bj bjVar) {
        this.iXx = bjVar;
    }

    public void Gw(String str) {
        this.iXy = str;
        if (this.gtW != null) {
            this.gtW.Gw(this.iXy);
        }
    }

    public void startPlay() {
        if (this.gtW != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iXT && !com.baidu.tieba.video.g.cPf().cPg()) {
                this.iXK.setVisibility(0);
                this.iXK.setData(this.iXs);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iXw != null && this.iXw.aCD() != null) {
                TiebaStatic.log(new an("c12619").cy("obj_locate", "pb").cy("tid", this.iXw.getTid()));
                this.mVideoUrl = this.iXw.aCD().video_url;
            }
            this.gtW.ei(this.mVideoUrl, this.iXw == null ? "" : this.iXw.getTid());
            Bi("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void csk() {
        if (this.gtW != null) {
            this.gtW.csk();
        }
    }

    public void destroy() {
        if (this.gtW != null) {
            this.gtW.destroy();
        }
        if (this.iXq != null) {
            this.iXq.clearAnimation();
        }
        if (this.iXu != null) {
            this.iXu.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tR);
        MessageManager.getInstance().unRegisterListener(this.gpH);
    }

    public void onPause() {
        if (this.gtW != null) {
            if (this.gtW.le()) {
                this.iXz = true;
                this.gtW.stopPlay();
            } else if (this.gtW.getCurrentState() == 3) {
                this.iXz = false;
            } else if (this.gtW.getCurrentState() == 0 || this.gtW.getCurrentState() == 1) {
                this.iXz = true;
                this.gtW.stopPlay();
            } else {
                this.iXz = false;
                this.gtW.stopPlay();
            }
            if (this.iXP != null) {
                this.iXP.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.gtW != null && this.iXz) {
            this.gtW.cyc();
        }
    }

    private void csl() {
        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.N(16908290).M(Opcodes.IFEQ).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.iDW.getActivity());
                    if (h.this.iXS == null) {
                        try {
                            h.this.iXS = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iXS);
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
                    h.this.iXR = null;
                    if (h.this.iXS != null && !h.this.iXS.isRecycled()) {
                        h.this.iXS.recycle();
                    }
                    h.this.iXS = null;
                }
            });
            this.iXR = dVar.fI();
            this.iXR.showOnDecorView(this.iDW.getActivity());
        }
    }

    public boolean tf(int i) {
        if (this.gtW == null) {
            return false;
        }
        return this.gtW.Am(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(String str) {
        if (this.iXs != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iXs.video_md5, "", str, this.iXt);
            }
        }
    }

    public void csm() {
        if (this.iXp != null) {
            this.iXp.qF(this.iDW.clp());
        }
    }

    public void cre() {
        if (this.iXp != null) {
            this.iXp.cre();
        }
    }

    public void zh(int i) {
        if (this.iXp != null) {
            this.iXp.zh(i);
        }
        if (this.iXP != null) {
            this.iXP.onChangeSkinType(i);
        }
        if (this.iXu != null) {
            this.iXu.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!csp()) {
                    this.iXC = i;
                    if (this.iXC == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zt(h.this.bcI().getHeight());
                            }
                        }, 100L);
                    }
                    csn();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(int i) {
        if (bcI().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXq.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iXV = false;
                    if (this.iXH != bcI().getHeight()) {
                        this.iXq.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iDW.getActivity()), Math.min(this.iXH, bcI().getHeight() + i)));
                        this.gtW.ccE();
                    }
                } else if (l.getEquipmentWidth(this.iDW.getActivity()) * 0.5625d != bcI().getHeight()) {
                    this.iXq.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iDW.getActivity()), (int) Math.max(l.getEquipmentWidth(this.iDW.getActivity()) * 0.5625d, bcI().getHeight() + i)));
                    this.gtW.ccE();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == csq()) {
                int bottom = childAt.getBottom() - bcI().getBottom();
                if (childAt.getHeight() == 0 || bcI().getHeight() == 0) {
                    bottom = 0;
                }
                zs(bottom);
            } else {
                zs((-this.iXH) + 2);
            }
        }
        if (!csp() && this.iXO) {
            if (this.iXC == 1) {
                this.iXU = true;
                zt(bcI().getHeight());
            } else if (this.iXC == 2) {
                this.iXU = true;
                int y = (int) bcI().getY();
                if (this.iXD == y) {
                    zt(bcI().getHeight());
                } else {
                    this.iXD = y;
                    zt(bcI().getHeight());
                }
                if (i == 0 && this.iXG) {
                    this.iXG = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.csk();
                        }
                    }, 100L);
                }
            } else if (this.iXC == 0) {
                if (this.iXU || !"nani_midpage".equals(this.iDW.cmo())) {
                    zt(bcI().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(int i) {
        zu(i);
        csn();
    }

    public void qs(boolean z) {
        this.iXV = z;
    }

    private void zu(int i) {
        if (this.iXu != null) {
            if (this.iXw != null && this.iXw.aEg()) {
                this.iXu.csi().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iXH;
            }
            float f = this.iXH - i;
            float f2 = f > this.iXE ? 0.0f : 1.0f - (f / this.iXE);
            if (this.iXV) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iXu.csi().setVisibility(8);
            } else {
                this.iXu.csi().setVisibility(0);
            }
            this.iXu.aE(f2);
        }
    }

    public void csn() {
        if (this.iXu != null) {
            if (csp()) {
                this.iDW.cmr().cqg();
            } else if (this.iXu.csi().getVisibility() == 0) {
                this.iDW.cmr().cqg();
                this.iXv = true;
            } else if (this.iXv) {
                this.iDW.cmr().qr(false);
                this.iXv = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cso() {
        return bcI().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iXB = false;
        if (this.gtW != null && this.iXq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXq.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gND != null && this.gND.isShowing()) {
                    this.gND.DF();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iXR != null) {
                    this.iXR.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iXB = true;
                this.iXq.setLayoutParams(layoutParams);
                this.iDW.cmr().cqg();
                this.iXv = true;
            } else {
                f(this.iXs);
                csm();
                this.iXB = false;
                this.iXp.qE(true);
            }
            this.gtW.a(this.iDW.getPageContext(), configuration);
        }
    }

    public boolean csp() {
        return this.iXB;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iXu != null) {
            this.iXu.R(onClickListener);
        }
    }

    public View bcI() {
        return this.iXo;
    }

    public boolean cqp() {
        if (bcI() == null) {
            return false;
        }
        return bcI().getBottom() > l.getEquipmentHeight(bcI().getContext()) - l.getDimens(bcI().getContext(), R.dimen.ds50);
    }

    public void cqI() {
        this.iXG = true;
    }

    public View csq() {
        return this.mEmptyView;
    }
}
