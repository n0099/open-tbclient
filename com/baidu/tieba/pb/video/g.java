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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class g {
    private static VideoControllerView.a lbV = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.g.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bPc() {
        }
    };
    private static c.i mfi = new c.i() { // from class: com.baidu.tieba.pb.video.g.10
        @Override // com.baidu.tieba.play.c.i
        public void cHX() {
        }
    };
    private boolean ahw;
    private com.baidu.mcn.c jLy;
    private com.baidu.tieba.play.c jmr;
    private PbFragment lIN;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private com.baidu.tieba.pb.pb.main.view.c meA;
    private CustomFrameLayout meB;
    private c.d meC;
    private o meE;
    private e meF;
    private boolean meG;
    private bz meH;
    private bz meI;
    private String meJ;
    private float meO;
    private int meR;
    private double meS;
    private long meT;
    private PbVideoWifiTipLayout meU;
    private int meV;
    private c.d meX;
    private PbFullScreenFloatingHuajiAninationView meZ;
    private RelativeLayout mez;
    private com.baidu.adp.lib.guide.c mfb;
    private Bitmap mfc;
    private boolean mfd;
    private boolean mff;
    private int mfh;
    private String mVideoUrl = null;
    private VideoInfo meD = null;
    private boolean meK = false;
    private int meL = 0;
    private boolean meM = false;
    private int scrollState = 0;
    private int meN = 0;
    private boolean meP = false;
    private boolean meQ = false;
    private long startPosition = -1;
    private int iMi = 0;
    private c.p meW = new c.p() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // com.baidu.tieba.play.c.p
        public void dvm() {
            if (g.this.lIN != null && g.this.lIN.dnW() != null && g.this.lIN.dnW().getPbData() != null) {
                PostData dmO = g.this.lIN.dnW().getPbData().dmO();
                if (dmO == null && x.getCount(g.this.lIN.dnW().getPbData().dmH()) > 1) {
                    dmO = (PostData) x.getItem(g.this.lIN.dnW().getPbData().dmH(), 0);
                }
                com.baidu.tieba.pb.c.a.a(g.this.lIN.dnW().getPbData(), dmO, 1, 1, 4);
            }
        }
    };
    private boolean meY = true;
    private PbFullScreenFloatingHuajiAninationView.a mfa = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.g.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            g.this.vX(false);
        }
    };
    private boolean mfe = false;
    private c.m mfg = new c.m() { // from class: com.baidu.tieba.pb.video.g.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dvo() {
            if (g.this.meS >= 1.0d) {
                if (g.this.lIN.checkUpIsLogin()) {
                    g.this.lIN.dpz();
                    if (g.this.lIN.dnW() == null || g.this.lIN.dnW().getPbData() == null || g.this.lIN.dnW().getPbData().dne() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dne = g.this.lIN.dnW().getPbData().dne();
                    if (g.this.meZ == null) {
                        g.this.meZ = new PbFullScreenFloatingHuajiAninationView(g.this.lIN.getActivity());
                        g.this.meZ.setFloatingHuajiAninationListener(g.this.mfa);
                    }
                    g.this.meZ.wn(dne.dnA() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dvp() {
            return false;
        }
    };
    private CustomMessageListener PQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.g.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (g.this.jmr != null) {
                    g.this.jmr.setNetworkChange();
                }
                if (j.isMobileNet() && g.this.jmr != null && g.this.jmr.rn() && g.this.meD != null && g.this.meD.video_length.intValue() > 0 && g.this.meD.video_duration.intValue() > 0) {
                    float intValue = g.this.meD.video_length.intValue() * (1.0f - ((g.this.jmr.getCurrentPosition() * 1.0f) / (g.this.meD.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(g.this.lIN.getPageContext().getPageActivity(), String.format(g.this.lIN.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kZX = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.g.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.dtU();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.meD != null) {
                g.this.f(g.this.meD);
                g.this.jmr.dBz();
                g.this.jmr.dei();
                if (g.this.mEmptyView != null && g.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = g.this.mEmptyView.getLayoutParams();
                    layoutParams.height = g.this.meR;
                    g.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vX(boolean z) {
        if (this.lIN != null) {
            this.lIN.doR();
        }
    }

    public g(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.meO = 0.0f;
        this.lIN = pbFragment;
        this.meA = cVar;
        this.meO = l.getDimens(this.lIN.getActivity(), R.dimen.ds240);
        this.meT = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.PQ);
        this.jgY.setTag(pbFragment.getUniqueId());
        this.jgY.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.jgY);
        this.jLy = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.meB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lIN.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lIN.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.lIN.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lIN.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.meS = (intValue2 * 1.0d) / intValue;
            if (this.meS > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.meR = i;
        this.meB.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean isVertical() {
        return this.meS >= 1.0d;
    }

    public int dtz() {
        return this.meR;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.mez = (RelativeLayout) LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.meB = (CustomFrameLayout) this.mez.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.ahw = ((double) this.meR) <= (((double) l.getEquipmentWidth(this.lIN.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jmr = new com.baidu.tieba.play.c(this.lIN.getPageContext(), this.meB, true);
        this.jmr.setStageType("2002");
        this.jmr.a(this.mfg);
        this.jmr.wZ(false);
        this.jmr.a(this.meW);
        this.jmr.Ix(ao.qc(R.drawable.pic_use_header_40_n));
        this.jmr.a(new c.n() { // from class: com.baidu.tieba.pb.video.g.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                g.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lIN.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lIN.getBaseFragmentActivity())) {
            this.jmr.wQ(false);
        }
        this.jmr.a(new c.k() { // from class: com.baidu.tieba.pb.video.g.18
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
                        g.this.mLastY = motionEvent.getY();
                        if (g.this.lIN.getListView() != null && g.this.lIN.getListView().getChildCount() > 0 && g.this.lIN.getListView().getChildAt(0) == g.this.dvl()) {
                            g.this.mfh = g.this.dvl().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        g.this.mLastY = 0.0f;
                        g.this.mfh = 0;
                        break;
                    case 2:
                        if (g.this.lIN.getListView() != null && g.this.lIN.getListView().getChildCount() > 0 && g.this.lIN.getListView().getChildAt(0) == g.this.dvl()) {
                            g.this.lIN.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - g.this.mLastY)) + g.this.mfh);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.meS >= 1.0d) {
                this.jmr.ax(false, true);
            } else {
                this.jmr.ax(true, false);
            }
            this.meP = ((float) f) + this.meO > ((float) l.getEquipmentHeight(this.lIN.getActivity()));
            if (this.meP) {
                if (this.meF == null) {
                    this.meF = new e(this.lIN.getPageContext(), this.meB);
                }
                this.lIN.doP().dsQ();
                this.meG = true;
            }
        }
        dvg();
        this.mEmptyView = new View(this.lIN.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.meR));
        if (this.meA != null && this.meA.mNavigationBar != null) {
            this.meA.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.meA.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.meA.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bvB() && !TbSingleton.getInstance().isNotchScreen(this.lIN.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lIN.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.meU = (PbVideoWifiTipLayout) this.mez.findViewById(R.id.layout_wifi_tip);
        this.meU.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mfd = true;
                g.this.meU.setVisibility(8);
                g.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jLy != null) {
            this.jLy.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lIN.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.meC == null) {
            this.meC = new c.d() { // from class: com.baidu.tieba.pb.video.g.20
                @Override // com.baidu.tieba.play.c.d
                public void qS(boolean z) {
                    if (g.this.dvj() && g.this.meA != null) {
                        loadAnimation.setAnimationListener(null);
                        g.this.meA.dtM().clearAnimation();
                        g.this.dvh();
                        if (z) {
                            loadAnimation.setAnimationListener(g.this.kZX);
                            g.this.meA.dtM().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cHW() {
                    if (g.this.dvj()) {
                        g.this.dtU();
                    }
                }
            };
        }
        a(this.meC);
        this.meL = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lIN.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bz bzVar, final String str) {
        if (videoInfo != null && this.jmr != null && bzVar != null) {
            this.meD = videoInfo;
            this.meH = bzVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jmr.stopPlay();
            this.meE = new o();
            this.meE.mLocate = "pb";
            this.meE.anD = bzVar.getTid();
            this.meE.fPy = str;
            this.meE.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bzVar.isBjh()) {
                if (!StringUtils.isNull(this.lIN.lNN)) {
                    this.meE.eQd = this.lIN.lNN;
                }
                this.meE.mDI = this.lIN.lNM + "";
            } else {
                this.meE.mDI = this.lIN.doM();
            }
            bi dpB = this.lIN.dpB();
            if (dpB != null) {
                dpB.a(this.meE);
            }
            this.meE.mDL = videoInfo.video_md5;
            o dBR = this.meE.dBR();
            dBR.mLocate = "6";
            this.startPosition = -1L;
            if (this.jmr.getVideoView() != null && this.jmr.getVideoView().getMediaProgressObserver() != null) {
                this.jmr.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.g.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ch(int i, int i2) {
                        boolean z = true;
                        if (g.this.startPosition <= 0) {
                            g.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean jD = com.baidu.mcn.b.adv().jD(mcnAdInfo.jump_url);
                            if (g.this.ahw && !jD && !g.this.meM) {
                                boolean z2 = g.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!g.this.jLy.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.cio = mcnAdInfo.card_title;
                                        aVar.cip = mcnAdInfo.button_title;
                                        aVar.ciq = mcnAdInfo.jump_url;
                                        aVar.cin = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bzVar.getTid();
                                        aVar.cir = 4;
                                        if (z2) {
                                            g.this.jLy.b(aVar, (ViewGroup) g.this.jmr.dBy());
                                        } else {
                                            g.this.jLy.a(aVar, (ViewGroup) g.this.jmr.dBy());
                                        }
                                    }
                                } else if (g.this.jLy.isShowing()) {
                                    g.this.jLy.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jmr.getVideoView().setVideoStatData(dBR);
            if (this.jmr.dek()) {
                this.jmr.dei();
            }
            this.jmr.b(this.meX);
            this.meJ = null;
            this.meI = null;
            this.jmr.Qt(this.meJ);
            this.jmr.dee().setOnDragingListener(lbV);
            this.jmr.a(new c.InterfaceC0862c() { // from class: com.baidu.tieba.pb.video.g.3
                @Override // com.baidu.tieba.play.c.InterfaceC0862c
                public void rm() {
                    g.this.lIN.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    g.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.meV > 0) {
                                g.this.HF(g.this.meV);
                                g.this.HG(g.this.meV);
                                g.this.meV = 0;
                            }
                            g.this.meY = true;
                        }
                    }, 200L);
                    g.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0862c
                public void rl() {
                    g.this.lIN.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    g.this.meY = false;
                    g.this.meV = g.this.bUW().getHeight();
                }
            });
            this.jmr.a(new c.h() { // from class: com.baidu.tieba.pb.video.g.4
                @Override // com.baidu.tieba.play.c.h
                public void dvn() {
                    if (g.this.lIN != null && g.this.meI != null && !StringUtils.isNull(g.this.meI.getId())) {
                        g.this.lIN.PI(g.this.meI.getId());
                    }
                }
            });
            this.jmr.a(new c.j() { // from class: com.baidu.tieba.pb.video.g.5
                @Override // com.baidu.tieba.play.c.j
                public void vY(boolean z) {
                    if (g.this.meH != null) {
                        g.this.KL(z ? "1" : "2");
                    }
                }
            });
            this.jmr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.g.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", g.this.mVideoUrl);
                    return true;
                }
            });
            this.jmr.setThumbnail(videoInfo.thumbnail_url);
            this.jmr.setVideoUrl(this.mVideoUrl, bzVar.getTid());
            this.jmr.setFid(str);
            this.jmr.QS(bzVar.getTitle());
            this.jmr.a(mfi);
            this.jmr.cUw();
            this.jmr.show();
        }
    }

    public void Qs(String str) {
        if (this.meE != null) {
            this.meE.fPy = str;
        }
    }

    public void b(PostData postData, bz bzVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.meF != null) {
            this.meF.a(postData, bzVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.meX = dVar;
    }

    public void aP(bz bzVar) {
        this.meI = bzVar;
    }

    public void Qt(String str) {
        this.meJ = str;
        if (this.jmr != null) {
            this.jmr.Qt(this.meJ);
        }
    }

    public void startPlay() {
        if (this.jmr != null) {
            if (j.isMobileNet() && !this.mfd && !com.baidu.tieba.video.f.dTE().dTF()) {
                this.meU.setVisibility(0);
                this.meU.setData(this.meD);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.meH != null && this.meH.brI() != null) {
                TiebaStatic.log(new aq("c12619").dX("obj_locate", "pb").dX("tid", this.meH.getTid()));
                this.mVideoUrl = this.meH.brI().video_url;
            }
            this.jmr.fY(this.mVideoUrl, this.meH == null ? "" : this.meH.getTid());
            KL("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dvf() {
        if (this.jmr != null) {
            this.jmr.dvf();
        }
    }

    public void destroy() {
        if (this.jmr != null) {
            this.jmr.destroy();
        }
        if (this.meB != null) {
            this.meB.clearAnimation();
        }
        if (this.meF != null) {
            this.meF.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PQ);
        MessageManager.getInstance().unRegisterListener(this.jgY);
    }

    public void onPause() {
        if (this.jmr != null) {
            if (this.jmr.rn()) {
                this.meK = true;
                this.jmr.stopPlay();
            } else if (this.jmr.getCurrentState() == 3) {
                this.meK = false;
            } else if (this.jmr.getCurrentState() == 0 || this.jmr.getCurrentState() == 1) {
                this.meK = true;
                this.jmr.stopPlay();
            } else {
                this.meK = false;
                this.jmr.stopPlay();
            }
            if (this.meZ != null) {
                this.meZ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jmr != null && this.meK) {
            this.jmr.dBl();
        }
    }

    private void dvg() {
        if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.g.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(g.this.lIN.getActivity());
                    if (g.this.mfc == null) {
                        try {
                            g.this.mfc = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(g.this.mfc);
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.g.8
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    g.this.mfb = null;
                    if (g.this.mfc != null && !g.this.mfc.isRecycled()) {
                        g.this.mfc.recycle();
                    }
                    g.this.mfc = null;
                }
            });
            this.mfb = dVar.lG();
            this.mfb.showOnDecorView(this.lIN.getActivity());
        }
    }

    public boolean AB(int i) {
        if (this.jmr == null) {
            return false;
        }
        return this.jmr.Iz(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KL(String str) {
        if (this.meD != null) {
            if ("1".equals(str) || "2".equals(str)) {
                h.a(this.meD.video_md5, "", str, this.meE, this.jmr.getVideoView().getPcdnState());
            }
        }
    }

    public void dvh() {
        if (this.meA != null) {
            this.meA.vO(this.lIN.dnO());
        }
    }

    public void dtU() {
        if (this.meA != null) {
            this.meA.dtU();
        }
    }

    public void Hs(int i) {
        if (this.meA != null) {
            this.meA.Hs(i);
        }
        if (this.meZ != null) {
            this.meZ.onChangeSkinType(i);
        }
        if (this.meF != null) {
            this.meF.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dvk()) {
                    this.scrollState = i;
                    if (this.scrollState == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.11
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.HG(g.this.bUW().getHeight());
                            }
                        }, 100L);
                    }
                    dvi();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HF(int i) {
        if (bUW().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.meB.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.mff = false;
                    if (this.meR != bUW().getHeight()) {
                        this.meB.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lIN.getActivity()), Math.min(this.meR, bUW().getHeight() + i)));
                        this.jmr.dei();
                    }
                } else if (l.getEquipmentWidth(this.lIN.getActivity()) * 0.5625d != bUW().getHeight()) {
                    this.meB.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lIN.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lIN.getActivity()) * 0.5625d, bUW().getHeight() + i)));
                    this.jmr.dei();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dvl()) {
                int bottom = childAt.getBottom() - bUW().getBottom();
                if (childAt.getHeight() == 0 || bUW().getHeight() == 0) {
                    bottom = 0;
                }
                HF(bottom);
            } else {
                HF((-this.meR) + 2);
            }
        }
        if (!dvk() && this.meY) {
            if (this.scrollState == 1) {
                this.mfe = true;
                HG(bUW().getHeight());
            } else if (this.scrollState == 2) {
                this.mfe = true;
                int y = (int) bUW().getY();
                if (this.meN == y) {
                    HG(bUW().getHeight());
                } else {
                    this.meN = y;
                    HG(bUW().getHeight());
                }
                if (i == 0 && this.meQ) {
                    this.meQ = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.dvf();
                        }
                    }, 100L);
                }
            } else if (this.scrollState == 0) {
                if (this.mfe || !"nani_midpage".equals(this.lIN.doM())) {
                    HG(bUW().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG(int i) {
        HH(i);
        dvi();
    }

    public void vA(boolean z) {
        this.mff = z;
    }

    private void HH(int i) {
        if (this.meF != null) {
            if (this.meH != null && this.meH.bqa()) {
                this.meF.dvd().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.meR;
            }
            float f = this.meR - i;
            float f2 = f > this.meO ? 0.0f : 1.0f - (f / this.meO);
            if (this.mff) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.meF.dvd().setVisibility(8);
            } else {
                this.meF.dvd().setVisibility(0);
            }
            this.meF.aR(f2);
        }
    }

    public void dvi() {
        if (this.meF != null) {
            if (dvk()) {
                this.lIN.doP().dsQ();
            } else if (this.meF.dvd().getVisibility() == 0) {
                this.lIN.doP().dsQ();
                this.meG = true;
            } else if (this.meG) {
                this.lIN.doP().vz(false);
                this.meG = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvj() {
        return bUW().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.meM = false;
        if (this.jmr != null && this.meB != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.meB.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jLy != null && this.jLy.isShowing()) {
                    this.jLy.adw();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.mfb != null) {
                    this.mfb.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.meM = true;
                this.meB.setLayoutParams(layoutParams);
                this.lIN.doP().dsQ();
                this.meG = true;
            } else {
                f(this.meD);
                dvh();
                this.meM = false;
                this.meA.vN(true);
            }
            this.jmr.a(this.lIN.getPageContext(), configuration);
        }
    }

    public boolean dvk() {
        return this.meM;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.meF != null) {
            this.meF.X(onClickListener);
        }
    }

    public View bUW() {
        return this.mez;
    }

    public boolean dsZ() {
        if (bUW() == null) {
            return false;
        }
        return bUW().getBottom() > l.getEquipmentHeight(bUW().getContext()) - l.getDimens(bUW().getContext(), R.dimen.ds50);
    }

    public void dtx() {
        this.meQ = true;
    }

    public View dvl() {
        return this.mEmptyView;
    }
}
