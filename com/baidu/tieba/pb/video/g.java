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
        public void bPb() {
        }
    };
    private static c.i mfj = new c.i() { // from class: com.baidu.tieba.pb.video.g.10
        @Override // com.baidu.tieba.play.c.i
        public void cHW() {
        }
    };
    private boolean ahw;
    private com.baidu.mcn.c jLy;
    private com.baidu.tieba.play.c jmr;
    private PbFragment lIO;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private RelativeLayout meA;
    private com.baidu.tieba.pb.pb.main.view.c meB;
    private CustomFrameLayout meC;
    private c.d meD;
    private o meF;
    private e meG;
    private boolean meH;
    private bz meI;
    private bz meJ;
    private String meK;
    private float meP;
    private int meS;
    private double meT;
    private long meU;
    private PbVideoWifiTipLayout meV;
    private int meW;
    private c.d meY;
    private PbFullScreenFloatingHuajiAninationView mfa;
    private com.baidu.adp.lib.guide.c mfc;
    private Bitmap mfd;
    private boolean mfe;
    private boolean mfg;
    private int mfi;
    private String mVideoUrl = null;
    private VideoInfo meE = null;
    private boolean meL = false;
    private int meM = 0;
    private boolean meN = false;
    private int scrollState = 0;
    private int meO = 0;
    private boolean meQ = false;
    private boolean meR = false;
    private long startPosition = -1;
    private int iMi = 0;
    private c.p meX = new c.p() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // com.baidu.tieba.play.c.p
        public void dvl() {
            if (g.this.lIO != null && g.this.lIO.dnV() != null && g.this.lIO.dnV().getPbData() != null) {
                PostData dmN = g.this.lIO.dnV().getPbData().dmN();
                if (dmN == null && x.getCount(g.this.lIO.dnV().getPbData().dmG()) > 1) {
                    dmN = (PostData) x.getItem(g.this.lIO.dnV().getPbData().dmG(), 0);
                }
                com.baidu.tieba.pb.c.a.a(g.this.lIO.dnV().getPbData(), dmN, 1, 1, 4);
            }
        }
    };
    private boolean meZ = true;
    private PbFullScreenFloatingHuajiAninationView.a mfb = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.g.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            g.this.vX(false);
        }
    };
    private boolean mff = false;
    private c.m mfh = new c.m() { // from class: com.baidu.tieba.pb.video.g.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dvn() {
            if (g.this.meT >= 1.0d) {
                if (g.this.lIO.checkUpIsLogin()) {
                    g.this.lIO.dpy();
                    if (g.this.lIO.dnV() == null || g.this.lIO.dnV().getPbData() == null || g.this.lIO.dnV().getPbData().dnd() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dnd = g.this.lIO.dnV().getPbData().dnd();
                    if (g.this.mfa == null) {
                        g.this.mfa = new PbFullScreenFloatingHuajiAninationView(g.this.lIO.getActivity());
                        g.this.mfa.setFloatingHuajiAninationListener(g.this.mfb);
                    }
                    g.this.mfa.wn(dnd.dnz() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dvo() {
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
                if (j.isMobileNet() && g.this.jmr != null && g.this.jmr.rn() && g.this.meE != null && g.this.meE.video_length.intValue() > 0 && g.this.meE.video_duration.intValue() > 0) {
                    float intValue = g.this.meE.video_length.intValue() * (1.0f - ((g.this.jmr.getCurrentPosition() * 1.0f) / (g.this.meE.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(g.this.lIO.getPageContext().getPageActivity(), String.format(g.this.lIO.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
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
            g.this.dtT();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.meE != null) {
                g.this.f(g.this.meE);
                g.this.jmr.dBy();
                g.this.jmr.deh();
                if (g.this.mEmptyView != null && g.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = g.this.mEmptyView.getLayoutParams();
                    layoutParams.height = g.this.meS;
                    g.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vX(boolean z) {
        if (this.lIO != null) {
            this.lIO.doQ();
        }
    }

    public g(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.meP = 0.0f;
        this.lIO = pbFragment;
        this.meB = cVar;
        this.meP = l.getDimens(this.lIO.getActivity(), R.dimen.ds240);
        this.meU = j;
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
            this.meC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lIO.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lIO.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.lIO.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lIO.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.meT = (intValue2 * 1.0d) / intValue;
            if (this.meT > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.meS = i;
        this.meC.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean isVertical() {
        return this.meT >= 1.0d;
    }

    public int dty() {
        return this.meS;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.meA = (RelativeLayout) LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.meC = (CustomFrameLayout) this.meA.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.ahw = ((double) this.meS) <= (((double) l.getEquipmentWidth(this.lIO.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jmr = new com.baidu.tieba.play.c(this.lIO.getPageContext(), this.meC, true);
        this.jmr.setStageType("2002");
        this.jmr.a(this.mfh);
        this.jmr.wZ(false);
        this.jmr.a(this.meX);
        this.jmr.Ix(ao.qc(R.drawable.pic_use_header_40_n));
        this.jmr.a(new c.n() { // from class: com.baidu.tieba.pb.video.g.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                g.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lIO.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lIO.getBaseFragmentActivity())) {
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
                        if (g.this.lIO.getListView() != null && g.this.lIO.getListView().getChildCount() > 0 && g.this.lIO.getListView().getChildAt(0) == g.this.dvk()) {
                            g.this.mfi = g.this.dvk().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        g.this.mLastY = 0.0f;
                        g.this.mfi = 0;
                        break;
                    case 2:
                        if (g.this.lIO.getListView() != null && g.this.lIO.getListView().getChildCount() > 0 && g.this.lIO.getListView().getChildAt(0) == g.this.dvk()) {
                            g.this.lIO.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - g.this.mLastY)) + g.this.mfi);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.meT >= 1.0d) {
                this.jmr.ax(false, true);
            } else {
                this.jmr.ax(true, false);
            }
            this.meQ = ((float) f) + this.meP > ((float) l.getEquipmentHeight(this.lIO.getActivity()));
            if (this.meQ) {
                if (this.meG == null) {
                    this.meG = new e(this.lIO.getPageContext(), this.meC);
                }
                this.lIO.doO().dsP();
                this.meH = true;
            }
        }
        dvf();
        this.mEmptyView = new View(this.lIO.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.meS));
        if (this.meB != null && this.meB.mNavigationBar != null) {
            this.meB.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.meB.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.meB.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bvA() && !TbSingleton.getInstance().isNotchScreen(this.lIO.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lIO.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.meV = (PbVideoWifiTipLayout) this.meA.findViewById(R.id.layout_wifi_tip);
        this.meV.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mfe = true;
                g.this.meV.setVisibility(8);
                g.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jLy != null) {
            this.jLy.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lIO.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.meD == null) {
            this.meD = new c.d() { // from class: com.baidu.tieba.pb.video.g.20
                @Override // com.baidu.tieba.play.c.d
                public void qS(boolean z) {
                    if (g.this.dvi() && g.this.meB != null) {
                        loadAnimation.setAnimationListener(null);
                        g.this.meB.dtL().clearAnimation();
                        g.this.dvg();
                        if (z) {
                            loadAnimation.setAnimationListener(g.this.kZX);
                            g.this.meB.dtL().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cHV() {
                    if (g.this.dvi()) {
                        g.this.dtT();
                    }
                }
            };
        }
        a(this.meD);
        this.meM = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lIO.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bz bzVar, final String str) {
        if (videoInfo != null && this.jmr != null && bzVar != null) {
            this.meE = videoInfo;
            this.meI = bzVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jmr.stopPlay();
            this.meF = new o();
            this.meF.mLocate = "pb";
            this.meF.anD = bzVar.getTid();
            this.meF.fPy = str;
            this.meF.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bzVar.isBjh()) {
                if (!StringUtils.isNull(this.lIO.lNO)) {
                    this.meF.eQd = this.lIO.lNO;
                }
                this.meF.mDJ = this.lIO.lNN + "";
            } else {
                this.meF.mDJ = this.lIO.doL();
            }
            bi dpA = this.lIO.dpA();
            if (dpA != null) {
                dpA.a(this.meF);
            }
            this.meF.mDM = videoInfo.video_md5;
            o dBQ = this.meF.dBQ();
            dBQ.mLocate = "6";
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
                            boolean jD = com.baidu.mcn.b.adu().jD(mcnAdInfo.jump_url);
                            if (g.this.ahw && !jD && !g.this.meN) {
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
                                            g.this.jLy.b(aVar, (ViewGroup) g.this.jmr.dBx());
                                        } else {
                                            g.this.jLy.a(aVar, (ViewGroup) g.this.jmr.dBx());
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
            this.jmr.getVideoView().setVideoStatData(dBQ);
            if (this.jmr.dej()) {
                this.jmr.deh();
            }
            this.jmr.b(this.meY);
            this.meK = null;
            this.meJ = null;
            this.jmr.Qu(this.meK);
            this.jmr.ded().setOnDragingListener(lbV);
            this.jmr.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.pb.video.g.3
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rm() {
                    g.this.lIO.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    g.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.meW > 0) {
                                g.this.HF(g.this.meW);
                                g.this.HG(g.this.meW);
                                g.this.meW = 0;
                            }
                            g.this.meZ = true;
                        }
                    }, 200L);
                    g.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rl() {
                    g.this.lIO.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    g.this.meZ = false;
                    g.this.meW = g.this.bUV().getHeight();
                }
            });
            this.jmr.a(new c.h() { // from class: com.baidu.tieba.pb.video.g.4
                @Override // com.baidu.tieba.play.c.h
                public void dvm() {
                    if (g.this.lIO != null && g.this.meJ != null && !StringUtils.isNull(g.this.meJ.getId())) {
                        g.this.lIO.PJ(g.this.meJ.getId());
                    }
                }
            });
            this.jmr.a(new c.j() { // from class: com.baidu.tieba.pb.video.g.5
                @Override // com.baidu.tieba.play.c.j
                public void vY(boolean z) {
                    if (g.this.meI != null) {
                        g.this.KM(z ? "1" : "2");
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
            this.jmr.QT(bzVar.getTitle());
            this.jmr.a(mfj);
            this.jmr.cUv();
            this.jmr.show();
        }
    }

    public void Qt(String str) {
        if (this.meF != null) {
            this.meF.fPy = str;
        }
    }

    public void b(PostData postData, bz bzVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.meG != null) {
            this.meG.a(postData, bzVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.meY = dVar;
    }

    public void aP(bz bzVar) {
        this.meJ = bzVar;
    }

    public void Qu(String str) {
        this.meK = str;
        if (this.jmr != null) {
            this.jmr.Qu(this.meK);
        }
    }

    public void startPlay() {
        if (this.jmr != null) {
            if (j.isMobileNet() && !this.mfe && !com.baidu.tieba.video.f.dTD().dTE()) {
                this.meV.setVisibility(0);
                this.meV.setData(this.meE);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.meI != null && this.meI.brH() != null) {
                TiebaStatic.log(new aq("c12619").dX("obj_locate", "pb").dX("tid", this.meI.getTid()));
                this.mVideoUrl = this.meI.brH().video_url;
            }
            this.jmr.fY(this.mVideoUrl, this.meI == null ? "" : this.meI.getTid());
            KM("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dve() {
        if (this.jmr != null) {
            this.jmr.dve();
        }
    }

    public void destroy() {
        if (this.jmr != null) {
            this.jmr.destroy();
        }
        if (this.meC != null) {
            this.meC.clearAnimation();
        }
        if (this.meG != null) {
            this.meG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PQ);
        MessageManager.getInstance().unRegisterListener(this.jgY);
    }

    public void onPause() {
        if (this.jmr != null) {
            if (this.jmr.rn()) {
                this.meL = true;
                this.jmr.stopPlay();
            } else if (this.jmr.getCurrentState() == 3) {
                this.meL = false;
            } else if (this.jmr.getCurrentState() == 0 || this.jmr.getCurrentState() == 1) {
                this.meL = true;
                this.jmr.stopPlay();
            } else {
                this.meL = false;
                this.jmr.stopPlay();
            }
            if (this.mfa != null) {
                this.mfa.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jmr != null && this.meL) {
            this.jmr.dBk();
        }
    }

    private void dvf() {
        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.g.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(g.this.lIO.getActivity());
                    if (g.this.mfd == null) {
                        try {
                            g.this.mfd = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(g.this.mfd);
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
                    g.this.mfc = null;
                    if (g.this.mfd != null && !g.this.mfd.isRecycled()) {
                        g.this.mfd.recycle();
                    }
                    g.this.mfd = null;
                }
            });
            this.mfc = dVar.lG();
            this.mfc.showOnDecorView(this.lIO.getActivity());
        }
    }

    public boolean AB(int i) {
        if (this.jmr == null) {
            return false;
        }
        return this.jmr.Iz(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM(String str) {
        if (this.meE != null) {
            if ("1".equals(str) || "2".equals(str)) {
                h.a(this.meE.video_md5, "", str, this.meF, this.jmr.getVideoView().getPcdnState());
            }
        }
    }

    public void dvg() {
        if (this.meB != null) {
            this.meB.vO(this.lIO.dnN());
        }
    }

    public void dtT() {
        if (this.meB != null) {
            this.meB.dtT();
        }
    }

    public void Hs(int i) {
        if (this.meB != null) {
            this.meB.Hs(i);
        }
        if (this.mfa != null) {
            this.mfa.onChangeSkinType(i);
        }
        if (this.meG != null) {
            this.meG.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dvj()) {
                    this.scrollState = i;
                    if (this.scrollState == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.11
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.HG(g.this.bUV().getHeight());
                            }
                        }, 100L);
                    }
                    dvh();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HF(int i) {
        if (bUV().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.meC.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.mfg = false;
                    if (this.meS != bUV().getHeight()) {
                        this.meC.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lIO.getActivity()), Math.min(this.meS, bUV().getHeight() + i)));
                        this.jmr.deh();
                    }
                } else if (l.getEquipmentWidth(this.lIO.getActivity()) * 0.5625d != bUV().getHeight()) {
                    this.meC.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lIO.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lIO.getActivity()) * 0.5625d, bUV().getHeight() + i)));
                    this.jmr.deh();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dvk()) {
                int bottom = childAt.getBottom() - bUV().getBottom();
                if (childAt.getHeight() == 0 || bUV().getHeight() == 0) {
                    bottom = 0;
                }
                HF(bottom);
            } else {
                HF((-this.meS) + 2);
            }
        }
        if (!dvj() && this.meZ) {
            if (this.scrollState == 1) {
                this.mff = true;
                HG(bUV().getHeight());
            } else if (this.scrollState == 2) {
                this.mff = true;
                int y = (int) bUV().getY();
                if (this.meO == y) {
                    HG(bUV().getHeight());
                } else {
                    this.meO = y;
                    HG(bUV().getHeight());
                }
                if (i == 0 && this.meR) {
                    this.meR = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.dve();
                        }
                    }, 100L);
                }
            } else if (this.scrollState == 0) {
                if (this.mff || !"nani_midpage".equals(this.lIO.doL())) {
                    HG(bUV().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG(int i) {
        HH(i);
        dvh();
    }

    public void vA(boolean z) {
        this.mfg = z;
    }

    private void HH(int i) {
        if (this.meG != null) {
            if (this.meI != null && this.meI.bpZ()) {
                this.meG.dvc().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.meS;
            }
            float f = this.meS - i;
            float f2 = f > this.meP ? 0.0f : 1.0f - (f / this.meP);
            if (this.mfg) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.meG.dvc().setVisibility(8);
            } else {
                this.meG.dvc().setVisibility(0);
            }
            this.meG.aR(f2);
        }
    }

    public void dvh() {
        if (this.meG != null) {
            if (dvj()) {
                this.lIO.doO().dsP();
            } else if (this.meG.dvc().getVisibility() == 0) {
                this.lIO.doO().dsP();
                this.meH = true;
            } else if (this.meH) {
                this.lIO.doO().vz(false);
                this.meH = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvi() {
        return bUV().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.meN = false;
        if (this.jmr != null && this.meC != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.meC.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jLy != null && this.jLy.isShowing()) {
                    this.jLy.adv();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.mfc != null) {
                    this.mfc.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.meN = true;
                this.meC.setLayoutParams(layoutParams);
                this.lIO.doO().dsP();
                this.meH = true;
            } else {
                f(this.meE);
                dvg();
                this.meN = false;
                this.meB.vN(true);
            }
            this.jmr.a(this.lIO.getPageContext(), configuration);
        }
    }

    public boolean dvj() {
        return this.meN;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.meG != null) {
            this.meG.X(onClickListener);
        }
    }

    public View bUV() {
        return this.meA;
    }

    public boolean dsY() {
        if (bUV() == null) {
            return false;
        }
        return bUV().getBottom() > l.getEquipmentHeight(bUV().getContext()) - l.getDimens(bUV().getContext(), R.dimen.ds50);
    }

    public void dtw() {
        this.meR = true;
    }

    public View dvk() {
        return this.mEmptyView;
    }
}
