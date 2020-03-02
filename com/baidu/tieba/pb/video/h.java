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
    private n ekZ;
    private com.baidu.mcn.c gNF;
    private com.baidu.tieba.play.c gtY;
    private PbFragment iDY;
    private String iXA;
    private float iXG;
    private int iXJ;
    private double iXK;
    private long iXL;
    private PbVideoWifiTipLayout iXM;
    private int iXN;
    private c.d iXP;
    private PbFullScreenFloatingHuajiAninationView iXR;
    private com.baidu.adp.lib.guide.c iXT;
    private Bitmap iXU;
    private boolean iXV;
    private boolean iXX;
    private int iXZ;
    private RelativeLayout iXq;
    private com.baidu.tieba.pb.pb.main.view.c iXr;
    private CustomFrameLayout iXs;
    private c.d iXt;
    private y iXv;
    private f iXw;
    private boolean iXx;
    private bj iXy;
    private bj iXz;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a ibN = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aYw() {
        }
    };
    private static c.i iYa = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bGq() {
        }
    };
    private String mVideoUrl = null;
    private VideoInfo iXu = null;
    private boolean iXB = false;
    private int iXC = 0;
    private boolean iXD = false;
    private int iXE = 0;
    private int iXF = 0;
    private boolean iXH = false;
    private boolean iXI = false;
    private long startPosition = -1;
    private int fYc = 0;
    private c.p iXO = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cst() {
            if (h.this.iDY != null && h.this.iDY.clB() != null && h.this.iDY.clB().getPbData() != null) {
                PostData ckB = h.this.iDY.clB().getPbData().ckB();
                if (ckB == null && v.getCount(h.this.iDY.clB().getPbData().ckw()) > 1) {
                    ckB = (PostData) v.getItem(h.this.iDY.clB().getPbData().ckw(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iDY.clB().getPbData(), ckB, 1, 1, 4);
            }
        }
    };
    private boolean iXQ = true;
    private PbFullScreenFloatingHuajiAninationView.a iXS = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qO(false);
        }
    };
    private boolean iXW = false;
    private c.m iXY = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean csv() {
            if (h.this.iXK < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iDY.checkUpIsLogin()) {
                h.this.iDY.cnd();
                if (h.this.iDY.clB() == null || h.this.iDY.clB().getPbData() == null || h.this.iDY.clB().getPbData().ckP() == null) {
                    return false;
                }
                k ckP = h.this.iDY.clB().getPbData().ckP();
                if (h.this.iXR == null) {
                    h.this.iXR = new PbFullScreenFloatingHuajiAninationView(h.this.iDY.getActivity());
                    h.this.iXR.setFloatingHuajiAninationListener(h.this.iXS);
                }
                h.this.iXR.rd(ckP.clc() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean csw() {
            return false;
        }
    };
    private CustomMessageListener tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.gtY != null) {
                    h.this.gtY.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.gtY != null && h.this.gtY.le() && h.this.iXu != null && h.this.iXu.video_length.intValue() > 0 && h.this.iXu.video_duration.intValue() > 0) {
                    float intValue = h.this.iXu.video_length.intValue() * (1.0f - ((h.this.gtY.getCurrentPosition() * 1.0f) / (h.this.iXu.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.iDY.getPageContext().getPageActivity(), String.format(h.this.iDY.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hZP = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.crg();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gpJ = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.iXu != null) {
                h.this.f(h.this.iXu);
                h.this.gtY.cys();
                h.this.gtY.ccG();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iXJ;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(boolean z) {
        if (this.iDY != null) {
            this.iDY.cmv();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.iXG = 0.0f;
        this.iDY = pbFragment;
        this.iXr = cVar;
        this.iXG = l.getDimens(this.iDY.getActivity(), R.dimen.ds240);
        this.iXL = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.gpJ.setTag(pbFragment.getUniqueId());
        this.gpJ.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gpJ);
        this.gNF = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.iXs.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.iDY.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.iDY.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iDY.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.iDY.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iXK = (intValue2 * 1.0d) / intValue;
            if (this.iXK > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iXJ = i;
        this.iXs.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bim() {
        return this.iXK >= 1.0d;
    }

    public int cqM() {
        return this.iXJ;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iXq = (RelativeLayout) LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iXs = (CustomFrameLayout) this.iXq.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.Kn = ((double) this.iXJ) <= (((double) l.getEquipmentWidth(this.iDY.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.gtY = new com.baidu.tieba.play.c(this.iDY.getPageContext(), this.iXs, true, com.baidu.tbadk.a.b.rH("cyber_player_test") ? 1 : 0);
        this.gtY.a(this.iXY);
        this.gtY.rM(false);
        this.gtY.a(this.iXO);
        this.gtY.Ak(am.ku(R.drawable.pic_use_header_60_n));
        this.gtY.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.iDY.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.iDY.getBaseFragmentActivity())) {
            this.gtY.rD(false);
        }
        this.gtY.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.iDY.getListView() != null && h.this.iDY.getListView().getChildCount() > 0 && h.this.iDY.getListView().getChildAt(0) == h.this.css()) {
                            h.this.iXZ = h.this.css().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.BF = 0.0f;
                        h.this.iXZ = 0;
                        break;
                    case 2:
                        if (h.this.iDY.getListView() != null && h.this.iDY.getListView().getChildCount() > 0 && h.this.iDY.getListView().getChildAt(0) == h.this.css()) {
                            h.this.iDY.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.BF)) + h.this.iXZ);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iXK >= 1.0d) {
                this.gtY.aj(false, true);
            } else {
                this.gtY.aj(true, false);
            }
            this.iXH = ((float) f) + this.iXG > ((float) l.getEquipmentHeight(this.iDY.getActivity()));
            if (this.iXH) {
                if (this.iXw == null) {
                    this.iXw = new f(this.iDY.getPageContext(), this.iXs);
                }
                this.iDY.cmt().cqi();
                this.iXx = true;
            }
        }
        csn();
        this.mEmptyView = new View(this.iDY.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iXJ));
        if (this.iXr != null && this.iXr.mNavigationBar != null) {
            this.iXr.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iXr.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iXr.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aFN() && !TbSingleton.getInstance().isNotchScreen(this.iDY.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iDY.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iXM = (PbVideoWifiTipLayout) this.iXq.findViewById(R.id.layout_wifi_tip);
        this.iXM.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iXV = true;
                h.this.iXM.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.gNF != null) {
            this.gNF.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.iDY.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.iXt == null) {
            this.iXt = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lI(boolean z) {
                    if (h.this.csq() && h.this.iXr != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iXr.cqZ().clearAnimation();
                        h.this.cso();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.hZP);
                            h.this.iXr.cqZ().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGp() {
                    if (h.this.csq()) {
                        h.this.crg();
                    }
                }
            };
        }
        a(this.iXt);
        this.iXC = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iDY.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.gtY != null && bjVar != null) {
            this.iXu = videoInfo;
            this.iXy = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.gtY.stopPlay();
            this.gtY.setIsNeedRecoveryVideoPlayer(true);
            this.ekZ = new n(this.iDY.getActivity());
            this.iXv = new y();
            this.iXv.mLocate = "pb";
            this.iXv.Pj = bjVar.getTid();
            this.iXv.emb = str;
            this.iXv.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iDY.iIh)) {
                    this.iXv.cOR = this.iDY.iIh;
                }
                this.iXv.jwI = this.iDY.iIg + "";
            } else {
                this.iXv.jwI = this.iDY.cmq();
            }
            ax cnf = this.iDY.cnf();
            if (cnf != null) {
                cnf.b(this.iXv);
            }
            this.iXv.jwK = videoInfo.video_md5;
            y czt = this.iXv.czt();
            czt.mLocate = "6";
            this.startPosition = -1L;
            this.ekZ.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean eB = com.baidu.mcn.b.DG().eB(mcnAdInfo.jump_url);
                        if (h.this.Kn && !eB && !h.this.iXD) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.gNF.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLk = mcnAdInfo.card_title;
                                    aVar.aLl = mcnAdInfo.button_title;
                                    aVar.aLm = mcnAdInfo.jump_url;
                                    aVar.aLj = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.aLn = 4;
                                    if (z2) {
                                        h.this.gNF.b(aVar, (ViewGroup) h.this.gtY.cyr());
                                    } else {
                                        h.this.gNF.a(aVar, (ViewGroup) h.this.gtY.cyr());
                                    }
                                }
                            } else if (h.this.gNF.isShowing()) {
                                h.this.gNF.dismiss();
                            }
                        }
                    }
                }
            });
            this.ekZ.setVideoStatsData(czt);
            this.gtY.cya().setBusiness(this.ekZ);
            if (this.gtY.ccI()) {
                this.gtY.ccG();
            }
            this.gtY.b(this.iXP);
            this.iXA = null;
            this.iXz = null;
            this.gtY.Gw(this.iXA);
            this.gtY.ccC().setOnDragingListener(ibN);
            this.gtY.a(new c.InterfaceC0589c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void ld() {
                    h.this.iDY.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iXN > 0) {
                                h.this.zs(h.this.iXN);
                                h.this.zt(h.this.iXN);
                                h.this.iXN = 0;
                            }
                            h.this.iXQ = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0589c
                public void lc() {
                    h.this.iDY.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iXQ = false;
                    h.this.iXN = h.this.bcK().getHeight();
                }
            });
            this.gtY.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void csu() {
                    if (h.this.iDY != null && h.this.iXz != null && !StringUtils.isNull(h.this.iXz.getId())) {
                        h.this.iDY.FO(h.this.iXz.getId());
                    }
                }
            });
            this.gtY.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qP(boolean z) {
                    if (h.this.iXy != null) {
                        h.this.Bi(z ? "1" : "2");
                    }
                }
            });
            this.gtY.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.gtY.setThumbnail(videoInfo.thumbnail_url);
            this.gtY.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.gtY.setFid(str);
            this.gtY.GX(bjVar.getTitle());
            this.gtY.a(iYa);
            this.gtY.bPO();
            this.gtY.show();
        }
    }

    public void Gv(String str) {
        if (this.iXv != null) {
            this.iXv.emb = str;
        }
    }

    public void b(PostData postData, bj bjVar, k kVar) {
        if (this.iXw != null) {
            this.iXw.a(postData, bjVar, kVar);
        }
    }

    public void a(c.d dVar) {
        this.iXP = dVar;
    }

    public void aK(bj bjVar) {
        this.iXz = bjVar;
    }

    public void Gw(String str) {
        this.iXA = str;
        if (this.gtY != null) {
            this.gtY.Gw(this.iXA);
        }
    }

    public void startPlay() {
        if (this.gtY != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iXV && !com.baidu.tieba.video.g.cPh().cPi()) {
                this.iXM.setVisibility(0);
                this.iXM.setData(this.iXu);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iXy != null && this.iXy.aCF() != null) {
                TiebaStatic.log(new an("c12619").cy("obj_locate", "pb").cy("tid", this.iXy.getTid()));
                this.mVideoUrl = this.iXy.aCF().video_url;
            }
            this.gtY.ei(this.mVideoUrl, this.iXy == null ? "" : this.iXy.getTid());
            Bi("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void csm() {
        if (this.gtY != null) {
            this.gtY.csm();
        }
    }

    public void destroy() {
        if (this.gtY != null) {
            this.gtY.destroy();
        }
        if (this.iXs != null) {
            this.iXs.clearAnimation();
        }
        if (this.iXw != null) {
            this.iXw.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tR);
        MessageManager.getInstance().unRegisterListener(this.gpJ);
    }

    public void onPause() {
        if (this.gtY != null) {
            if (this.gtY.le()) {
                this.iXB = true;
                this.gtY.stopPlay();
            } else if (this.gtY.getCurrentState() == 3) {
                this.iXB = false;
            } else if (this.gtY.getCurrentState() == 0 || this.gtY.getCurrentState() == 1) {
                this.iXB = true;
                this.gtY.stopPlay();
            } else {
                this.iXB = false;
                this.gtY.stopPlay();
            }
            if (this.iXR != null) {
                this.iXR.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.gtY != null && this.iXB) {
            this.gtY.cye();
        }
    }

    private void csn() {
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.N(16908290).M(Opcodes.IFEQ).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.iDY.getActivity());
                    if (h.this.iXU == null) {
                        try {
                            h.this.iXU = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iXU);
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
                    h.this.iXT = null;
                    if (h.this.iXU != null && !h.this.iXU.isRecycled()) {
                        h.this.iXU.recycle();
                    }
                    h.this.iXU = null;
                }
            });
            this.iXT = dVar.fI();
            this.iXT.showOnDecorView(this.iDY.getActivity());
        }
    }

    public boolean tf(int i) {
        if (this.gtY == null) {
            return false;
        }
        return this.gtY.Am(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(String str) {
        if (this.iXu != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iXu.video_md5, "", str, this.iXv);
            }
        }
    }

    public void cso() {
        if (this.iXr != null) {
            this.iXr.qF(this.iDY.clr());
        }
    }

    public void crg() {
        if (this.iXr != null) {
            this.iXr.crg();
        }
    }

    public void zh(int i) {
        if (this.iXr != null) {
            this.iXr.zh(i);
        }
        if (this.iXR != null) {
            this.iXR.onChangeSkinType(i);
        }
        if (this.iXw != null) {
            this.iXw.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!csr()) {
                    this.iXE = i;
                    if (this.iXE == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zt(h.this.bcK().getHeight());
                            }
                        }, 100L);
                    }
                    csp();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(int i) {
        if (bcK().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXs.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iXX = false;
                    if (this.iXJ != bcK().getHeight()) {
                        this.iXs.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iDY.getActivity()), Math.min(this.iXJ, bcK().getHeight() + i)));
                        this.gtY.ccG();
                    }
                } else if (l.getEquipmentWidth(this.iDY.getActivity()) * 0.5625d != bcK().getHeight()) {
                    this.iXs.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iDY.getActivity()), (int) Math.max(l.getEquipmentWidth(this.iDY.getActivity()) * 0.5625d, bcK().getHeight() + i)));
                    this.gtY.ccG();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == css()) {
                int bottom = childAt.getBottom() - bcK().getBottom();
                if (childAt.getHeight() == 0 || bcK().getHeight() == 0) {
                    bottom = 0;
                }
                zs(bottom);
            } else {
                zs((-this.iXJ) + 2);
            }
        }
        if (!csr() && this.iXQ) {
            if (this.iXE == 1) {
                this.iXW = true;
                zt(bcK().getHeight());
            } else if (this.iXE == 2) {
                this.iXW = true;
                int y = (int) bcK().getY();
                if (this.iXF == y) {
                    zt(bcK().getHeight());
                } else {
                    this.iXF = y;
                    zt(bcK().getHeight());
                }
                if (i == 0 && this.iXI) {
                    this.iXI = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.csm();
                        }
                    }, 100L);
                }
            } else if (this.iXE == 0) {
                if (this.iXW || !"nani_midpage".equals(this.iDY.cmq())) {
                    zt(bcK().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(int i) {
        zu(i);
        csp();
    }

    public void qs(boolean z) {
        this.iXX = z;
    }

    private void zu(int i) {
        if (this.iXw != null) {
            if (this.iXy != null && this.iXy.aEi()) {
                this.iXw.csk().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iXJ;
            }
            float f = this.iXJ - i;
            float f2 = f > this.iXG ? 0.0f : 1.0f - (f / this.iXG);
            if (this.iXX) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iXw.csk().setVisibility(8);
            } else {
                this.iXw.csk().setVisibility(0);
            }
            this.iXw.aE(f2);
        }
    }

    public void csp() {
        if (this.iXw != null) {
            if (csr()) {
                this.iDY.cmt().cqi();
            } else if (this.iXw.csk().getVisibility() == 0) {
                this.iDY.cmt().cqi();
                this.iXx = true;
            } else if (this.iXx) {
                this.iDY.cmt().qr(false);
                this.iXx = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csq() {
        return bcK().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iXD = false;
        if (this.gtY != null && this.iXs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXs.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gNF != null && this.gNF.isShowing()) {
                    this.gNF.DH();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iXT != null) {
                    this.iXT.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iXD = true;
                this.iXs.setLayoutParams(layoutParams);
                this.iDY.cmt().cqi();
                this.iXx = true;
            } else {
                f(this.iXu);
                cso();
                this.iXD = false;
                this.iXr.qE(true);
            }
            this.gtY.a(this.iDY.getPageContext(), configuration);
        }
    }

    public boolean csr() {
        return this.iXD;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iXw != null) {
            this.iXw.R(onClickListener);
        }
    }

    public View bcK() {
        return this.iXq;
    }

    public boolean cqr() {
        if (bcK() == null) {
            return false;
        }
        return bcK().getBottom() > l.getEquipmentHeight(bcK().getContext()) - l.getDimens(bcK().getContext(), R.dimen.ds50);
    }

    public void cqK() {
        this.iXI = true;
    }

    public View css() {
        return this.mEmptyView;
    }
}
