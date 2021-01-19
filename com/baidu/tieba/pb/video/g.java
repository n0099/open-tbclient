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
    private static VideoControllerView.a kXp = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.g.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLk() {
        }
    };
    private static c.i maD = new c.i() { // from class: com.baidu.tieba.pb.video.g.10
        @Override // com.baidu.tieba.play.c.i
        public void cEf() {
        }
    };
    private boolean agF;
    private com.baidu.mcn.c jGS;
    private com.baidu.tieba.play.c jhJ;
    private PbFragment lEi;
    private RelativeLayout lZR;
    private com.baidu.tieba.pb.pb.main.view.c lZS;
    private CustomFrameLayout lZT;
    private c.d lZU;
    private o lZW;
    private e lZX;
    private boolean lZY;
    private bz lZZ;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private boolean maA;
    private int maC;
    private bz maa;
    private String mab;
    private float mah;
    private int mak;
    private double mal;
    private long mam;
    private PbVideoWifiTipLayout man;
    private int mao;
    private c.d mar;
    private PbFullScreenFloatingHuajiAninationView mat;
    private com.baidu.adp.lib.guide.c mav;
    private Bitmap maw;
    private boolean may;
    private String mVideoUrl = null;
    private VideoInfo lZV = null;
    private boolean mad = false;
    private int mae = 0;
    private boolean maf = false;
    private int scrollState = 0;
    private int mag = 0;
    private boolean mai = false;
    private boolean maj = false;
    private long startPosition = -1;
    private int iHB = 0;
    private c.p maq = new c.p() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // com.baidu.tieba.play.c.p
        public void dru() {
            if (g.this.lEi != null && g.this.lEi.dkd() != null && g.this.lEi.dkd().getPbData() != null) {
                PostData diW = g.this.lEi.dkd().getPbData().diW();
                if (diW == null && x.getCount(g.this.lEi.dkd().getPbData().diP()) > 1) {
                    diW = (PostData) x.getItem(g.this.lEi.dkd().getPbData().diP(), 0);
                }
                com.baidu.tieba.pb.c.a.a(g.this.lEi.dkd().getPbData(), diW, 1, 1, 4);
            }
        }
    };
    private boolean mas = true;
    private PbFullScreenFloatingHuajiAninationView.a mau = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.g.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            g.this.vT(false);
        }
    };
    private boolean maz = false;
    private c.m maB = new c.m() { // from class: com.baidu.tieba.pb.video.g.15
        @Override // com.baidu.tieba.play.c.m
        public boolean drw() {
            if (g.this.mal >= 1.0d) {
                if (g.this.lEi.checkUpIsLogin()) {
                    g.this.lEi.dlG();
                    if (g.this.lEi.dkd() == null || g.this.lEi.dkd().getPbData() == null || g.this.lEi.dkd().getPbData().djm() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o djm = g.this.lEi.dkd().getPbData().djm();
                    if (g.this.mat == null) {
                        g.this.mat = new PbFullScreenFloatingHuajiAninationView(g.this.lEi.getActivity());
                        g.this.mat.setFloatingHuajiAninationListener(g.this.mau);
                    }
                    g.this.mat.wj(djm.djH() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean drx() {
            return false;
        }
    };
    private CustomMessageListener PO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.g.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (g.this.jhJ != null) {
                    g.this.jhJ.setNetworkChange();
                }
                if (j.isMobileNet() && g.this.jhJ != null && g.this.jhJ.rn() && g.this.lZV != null && g.this.lZV.video_length.intValue() > 0 && g.this.lZV.video_duration.intValue() > 0) {
                    float intValue = g.this.lZV.video_length.intValue() * (1.0f - ((g.this.jhJ.getCurrentPosition() * 1.0f) / (g.this.lZV.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(g.this.lEi.getPageContext().getPageActivity(), String.format(g.this.lEi.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kVs = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.g.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.dqc();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener jcr = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.lZV != null) {
                g.this.f(g.this.lZV);
                g.this.jhJ.dxH();
                g.this.jhJ.daq();
                if (g.this.mEmptyView != null && g.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = g.this.mEmptyView.getLayoutParams();
                    layoutParams.height = g.this.mak;
                    g.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(boolean z) {
        if (this.lEi != null) {
            this.lEi.dkY();
        }
    }

    public g(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.mah = 0.0f;
        this.lEi = pbFragment;
        this.lZS = cVar;
        this.mah = l.getDimens(this.lEi.getActivity(), R.dimen.ds240);
        this.mam = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.PO);
        this.jcr.setTag(pbFragment.getUniqueId());
        this.jcr.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.jcr);
        this.jGS = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lZT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lEi.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lEi.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.lEi.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lEi.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.mal = (intValue2 * 1.0d) / intValue;
            if (this.mal > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.mak = i;
        this.lZT.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean isVertical() {
        return this.mal >= 1.0d;
    }

    public int dpH() {
        return this.mak;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lZR = (RelativeLayout) LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lZT = (CustomFrameLayout) this.lZR.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.agF = ((double) this.mak) <= (((double) l.getEquipmentWidth(this.lEi.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jhJ = new com.baidu.tieba.play.c(this.lEi.getPageContext(), this.lZT, true);
        this.jhJ.setStageType("2002");
        this.jhJ.a(this.maB);
        this.jhJ.wV(false);
        this.jhJ.a(this.maq);
        this.jhJ.GQ(ao.ov(R.drawable.pic_use_header_40_n));
        this.jhJ.a(new c.n() { // from class: com.baidu.tieba.pb.video.g.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                g.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lEi.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lEi.getBaseFragmentActivity())) {
            this.jhJ.wM(false);
        }
        this.jhJ.a(new c.k() { // from class: com.baidu.tieba.pb.video.g.18
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
                        if (g.this.lEi.getListView() != null && g.this.lEi.getListView().getChildCount() > 0 && g.this.lEi.getListView().getChildAt(0) == g.this.drt()) {
                            g.this.maC = g.this.drt().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        g.this.mLastY = 0.0f;
                        g.this.maC = 0;
                        break;
                    case 2:
                        if (g.this.lEi.getListView() != null && g.this.lEi.getListView().getChildCount() > 0 && g.this.lEi.getListView().getChildAt(0) == g.this.drt()) {
                            g.this.lEi.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - g.this.mLastY)) + g.this.maC);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.mal >= 1.0d) {
                this.jhJ.ax(false, true);
            } else {
                this.jhJ.ax(true, false);
            }
            this.mai = ((float) f) + this.mah > ((float) l.getEquipmentHeight(this.lEi.getActivity()));
            if (this.mai) {
                if (this.lZX == null) {
                    this.lZX = new e(this.lEi.getPageContext(), this.lZT);
                }
                this.lEi.dkW().doY();
                this.lZY = true;
            }
        }
        dro();
        this.mEmptyView = new View(this.lEi.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mak));
        if (this.lZS != null && this.lZS.mNavigationBar != null) {
            this.lZS.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lZS.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lZS.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.brH() && !TbSingleton.getInstance().isNotchScreen(this.lEi.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lEi.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.man = (PbVideoWifiTipLayout) this.lZR.findViewById(R.id.layout_wifi_tip);
        this.man.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.may = true;
                g.this.man.setVisibility(8);
                g.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jGS != null) {
            this.jGS.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lEi.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lZU == null) {
            this.lZU = new c.d() { // from class: com.baidu.tieba.pb.video.g.20
                @Override // com.baidu.tieba.play.c.d
                public void qO(boolean z) {
                    if (g.this.drr() && g.this.lZS != null) {
                        loadAnimation.setAnimationListener(null);
                        g.this.lZS.dpU().clearAnimation();
                        g.this.drp();
                        if (z) {
                            loadAnimation.setAnimationListener(g.this.kVs);
                            g.this.lZS.dpU().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cEe() {
                    if (g.this.drr()) {
                        g.this.dqc();
                    }
                }
            };
        }
        a(this.lZU);
        this.mae = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lEi.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bz bzVar, final String str) {
        if (videoInfo != null && this.jhJ != null && bzVar != null) {
            this.lZV = videoInfo;
            this.lZZ = bzVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jhJ.stopPlay();
            this.lZW = new o();
            this.lZW.mLocate = "pb";
            this.lZW.amM = bzVar.getTid();
            this.lZW.fKR = str;
            this.lZW.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bzVar.isBjh()) {
                if (!StringUtils.isNull(this.lEi.lJj)) {
                    this.lZW.eLs = this.lEi.lJj;
                }
                this.lZW.myZ = this.lEi.lJi + "";
            } else {
                this.lZW.myZ = this.lEi.dkT();
            }
            bi dlI = this.lEi.dlI();
            if (dlI != null) {
                dlI.a(this.lZW);
            }
            this.lZW.mzc = videoInfo.video_md5;
            o dxZ = this.lZW.dxZ();
            dxZ.mLocate = "6";
            this.startPosition = -1L;
            if (this.jhJ.getVideoView() != null && this.jhJ.getVideoView().getMediaProgressObserver() != null) {
                this.jhJ.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.g.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ch(int i, int i2) {
                        boolean z = true;
                        if (g.this.startPosition <= 0) {
                            g.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean is = com.baidu.mcn.b.ZC().is(mcnAdInfo.jump_url);
                            if (g.this.agF && !is && !g.this.maf) {
                                boolean z2 = g.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!g.this.jGS.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.cdB = mcnAdInfo.card_title;
                                        aVar.cdC = mcnAdInfo.button_title;
                                        aVar.cdD = mcnAdInfo.jump_url;
                                        aVar.cdA = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bzVar.getTid();
                                        aVar.cdE = 4;
                                        if (z2) {
                                            g.this.jGS.b(aVar, (ViewGroup) g.this.jhJ.dxG());
                                        } else {
                                            g.this.jGS.a(aVar, (ViewGroup) g.this.jhJ.dxG());
                                        }
                                    }
                                } else if (g.this.jGS.isShowing()) {
                                    g.this.jGS.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jhJ.getVideoView().setVideoStatData(dxZ);
            if (this.jhJ.das()) {
                this.jhJ.daq();
            }
            this.jhJ.b(this.mar);
            this.mab = null;
            this.maa = null;
            this.jhJ.Pm(this.mab);
            this.jhJ.dam().setOnDragingListener(kXp);
            this.jhJ.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.pb.video.g.3
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rm() {
                    g.this.lEi.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    g.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.mao > 0) {
                                g.this.FZ(g.this.mao);
                                g.this.Ga(g.this.mao);
                                g.this.mao = 0;
                            }
                            g.this.mas = true;
                        }
                    }, 200L);
                    g.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rl() {
                    g.this.lEi.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    g.this.mas = false;
                    g.this.mao = g.this.bRe().getHeight();
                }
            });
            this.jhJ.a(new c.h() { // from class: com.baidu.tieba.pb.video.g.4
                @Override // com.baidu.tieba.play.c.h
                public void drv() {
                    if (g.this.lEi != null && g.this.maa != null && !StringUtils.isNull(g.this.maa.getId())) {
                        g.this.lEi.OB(g.this.maa.getId());
                    }
                }
            });
            this.jhJ.a(new c.j() { // from class: com.baidu.tieba.pb.video.g.5
                @Override // com.baidu.tieba.play.c.j
                public void vU(boolean z) {
                    if (g.this.lZZ != null) {
                        g.this.JB(z ? "1" : "2");
                    }
                }
            });
            this.jhJ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.g.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", g.this.mVideoUrl);
                    return true;
                }
            });
            this.jhJ.setThumbnail(videoInfo.thumbnail_url);
            this.jhJ.setVideoUrl(this.mVideoUrl, bzVar.getTid());
            this.jhJ.setFid(str);
            this.jhJ.PL(bzVar.getTitle());
            this.jhJ.a(maD);
            this.jhJ.cQE();
            this.jhJ.show();
        }
    }

    public void Pl(String str) {
        if (this.lZW != null) {
            this.lZW.fKR = str;
        }
    }

    public void b(PostData postData, bz bzVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lZX != null) {
            this.lZX.a(postData, bzVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.mar = dVar;
    }

    public void aP(bz bzVar) {
        this.maa = bzVar;
    }

    public void Pm(String str) {
        this.mab = str;
        if (this.jhJ != null) {
            this.jhJ.Pm(this.mab);
        }
    }

    public void startPlay() {
        if (this.jhJ != null) {
            if (j.isMobileNet() && !this.may && !com.baidu.tieba.video.f.dPM().dPN()) {
                this.man.setVisibility(0);
                this.man.setData(this.lZV);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lZZ != null && this.lZZ.bnO() != null) {
                TiebaStatic.log(new aq("c12619").dW("obj_locate", "pb").dW("tid", this.lZZ.getTid()));
                this.mVideoUrl = this.lZZ.bnO().video_url;
            }
            this.jhJ.fX(this.mVideoUrl, this.lZZ == null ? "" : this.lZZ.getTid());
            JB("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void drn() {
        if (this.jhJ != null) {
            this.jhJ.drn();
        }
    }

    public void destroy() {
        if (this.jhJ != null) {
            this.jhJ.destroy();
        }
        if (this.lZT != null) {
            this.lZT.clearAnimation();
        }
        if (this.lZX != null) {
            this.lZX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PO);
        MessageManager.getInstance().unRegisterListener(this.jcr);
    }

    public void onPause() {
        if (this.jhJ != null) {
            if (this.jhJ.rn()) {
                this.mad = true;
                this.jhJ.stopPlay();
            } else if (this.jhJ.getCurrentState() == 3) {
                this.mad = false;
            } else if (this.jhJ.getCurrentState() == 0 || this.jhJ.getCurrentState() == 1) {
                this.mad = true;
                this.jhJ.stopPlay();
            } else {
                this.mad = false;
                this.jhJ.stopPlay();
            }
            if (this.mat != null) {
                this.mat.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jhJ != null && this.mad) {
            this.jhJ.dxt();
        }
    }

    private void dro() {
        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.g.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(g.this.lEi.getActivity());
                    if (g.this.maw == null) {
                        try {
                            g.this.maw = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(g.this.maw);
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
                    g.this.mav = null;
                    if (g.this.maw != null && !g.this.maw.isRecycled()) {
                        g.this.maw.recycle();
                    }
                    g.this.maw = null;
                }
            });
            this.mav = dVar.lG();
            this.mav.showOnDecorView(this.lEi.getActivity());
        }
    }

    public boolean yV(int i) {
        if (this.jhJ == null) {
            return false;
        }
        return this.jhJ.GS(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB(String str) {
        if (this.lZV != null) {
            if ("1".equals(str) || "2".equals(str)) {
                h.a(this.lZV.video_md5, "", str, this.lZW, this.jhJ.getVideoView().getPcdnState());
            }
        }
    }

    public void drp() {
        if (this.lZS != null) {
            this.lZS.vK(this.lEi.djV());
        }
    }

    public void dqc() {
        if (this.lZS != null) {
            this.lZS.dqc();
        }
    }

    public void FM(int i) {
        if (this.lZS != null) {
            this.lZS.FM(i);
        }
        if (this.mat != null) {
            this.mat.onChangeSkinType(i);
        }
        if (this.lZX != null) {
            this.lZX.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!drs()) {
                    this.scrollState = i;
                    if (this.scrollState == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.11
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.Ga(g.this.bRe().getHeight());
                            }
                        }, 100L);
                    }
                    drq();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FZ(int i) {
        if (bRe().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZT.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.maA = false;
                    if (this.mak != bRe().getHeight()) {
                        this.lZT.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lEi.getActivity()), Math.min(this.mak, bRe().getHeight() + i)));
                        this.jhJ.daq();
                    }
                } else if (l.getEquipmentWidth(this.lEi.getActivity()) * 0.5625d != bRe().getHeight()) {
                    this.lZT.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lEi.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lEi.getActivity()) * 0.5625d, bRe().getHeight() + i)));
                    this.jhJ.daq();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == drt()) {
                int bottom = childAt.getBottom() - bRe().getBottom();
                if (childAt.getHeight() == 0 || bRe().getHeight() == 0) {
                    bottom = 0;
                }
                FZ(bottom);
            } else {
                FZ((-this.mak) + 2);
            }
        }
        if (!drs() && this.mas) {
            if (this.scrollState == 1) {
                this.maz = true;
                Ga(bRe().getHeight());
            } else if (this.scrollState == 2) {
                this.maz = true;
                int y = (int) bRe().getY();
                if (this.mag == y) {
                    Ga(bRe().getHeight());
                } else {
                    this.mag = y;
                    Ga(bRe().getHeight());
                }
                if (i == 0 && this.maj) {
                    this.maj = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.drn();
                        }
                    }, 100L);
                }
            } else if (this.scrollState == 0) {
                if (this.maz || !"nani_midpage".equals(this.lEi.dkT())) {
                    Ga(bRe().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(int i) {
        Gb(i);
        drq();
    }

    public void vw(boolean z) {
        this.maA = z;
    }

    private void Gb(int i) {
        if (this.lZX != null) {
            if (this.lZZ != null && this.lZZ.bmg()) {
                this.lZX.drl().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.mak;
            }
            float f = this.mak - i;
            float f2 = f > this.mah ? 0.0f : 1.0f - (f / this.mah);
            if (this.maA) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lZX.drl().setVisibility(8);
            } else {
                this.lZX.drl().setVisibility(0);
            }
            this.lZX.aR(f2);
        }
    }

    public void drq() {
        if (this.lZX != null) {
            if (drs()) {
                this.lEi.dkW().doY();
            } else if (this.lZX.drl().getVisibility() == 0) {
                this.lEi.dkW().doY();
                this.lZY = true;
            } else if (this.lZY) {
                this.lEi.dkW().vv(false);
                this.lZY = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drr() {
        return bRe().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.maf = false;
        if (this.jhJ != null && this.lZT != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZT.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jGS != null && this.jGS.isShowing()) {
                    this.jGS.ZD();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.mav != null) {
                    this.mav.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.maf = true;
                this.lZT.setLayoutParams(layoutParams);
                this.lEi.dkW().doY();
                this.lZY = true;
            } else {
                f(this.lZV);
                drp();
                this.maf = false;
                this.lZS.vJ(true);
            }
            this.jhJ.a(this.lEi.getPageContext(), configuration);
        }
    }

    public boolean drs() {
        return this.maf;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.lZX != null) {
            this.lZX.X(onClickListener);
        }
    }

    public View bRe() {
        return this.lZR;
    }

    public boolean dph() {
        if (bRe() == null) {
            return false;
        }
        return bRe().getBottom() > l.getEquipmentHeight(bRe().getContext()) - l.getDimens(bRe().getContext(), R.dimen.ds50);
    }

    public void dpF() {
        this.maj = true;
    }

    public View drt() {
        return this.mEmptyView;
    }
}
