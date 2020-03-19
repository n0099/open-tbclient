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
    private n elC;
    private com.baidu.mcn.c gOY;
    private com.baidu.tieba.play.c guO;
    private PbFragment iFL;
    private int iZA;
    private c.d iZC;
    private PbFullScreenFloatingHuajiAninationView iZE;
    private com.baidu.adp.lib.guide.c iZG;
    private Bitmap iZH;
    private boolean iZI;
    private boolean iZK;
    private int iZM;
    private RelativeLayout iZd;
    private com.baidu.tieba.pb.pb.main.view.c iZe;
    private CustomFrameLayout iZf;
    private c.d iZg;
    private y iZi;
    private f iZj;
    private boolean iZk;
    private bj iZl;
    private bj iZm;
    private String iZn;
    private float iZt;
    private int iZw;
    private double iZx;
    private long iZy;
    private PbVideoWifiTipLayout iZz;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a idD = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aYB() {
        }
    };
    private static c.i iZN = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bGD() {
        }
    };
    private String mVideoUrl = null;
    private VideoInfo iZh = null;
    private boolean iZo = false;
    private int iZp = 0;
    private boolean iZq = false;
    private int iZr = 0;
    private int iZs = 0;
    private boolean iZu = false;
    private boolean iZv = false;
    private long startPosition = -1;
    private int fYX = 0;
    private c.p iZB = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void csP() {
            if (h.this.iFL != null && h.this.iFL.clX() != null && h.this.iFL.clX().getPbData() != null) {
                PostData ckW = h.this.iFL.clX().getPbData().ckW();
                if (ckW == null && v.getCount(h.this.iFL.clX().getPbData().ckR()) > 1) {
                    ckW = (PostData) v.getItem(h.this.iFL.clX().getPbData().ckR(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iFL.clX().getPbData(), ckW, 1, 1, 4);
            }
        }
    };
    private boolean iZD = true;
    private PbFullScreenFloatingHuajiAninationView.a iZF = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qU(false);
        }
    };
    private boolean iZJ = false;
    private c.m iZL = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean csR() {
            if (h.this.iZx < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iFL.checkUpIsLogin()) {
                h.this.iFL.cnz();
                if (h.this.iFL.clX() == null || h.this.iFL.clX().getPbData() == null || h.this.iFL.clX().getPbData().clk() == null) {
                    return false;
                }
                k clk = h.this.iFL.clX().getPbData().clk();
                if (h.this.iZE == null) {
                    h.this.iZE = new PbFullScreenFloatingHuajiAninationView(h.this.iFL.getActivity());
                    h.this.iZE.setFloatingHuajiAninationListener(h.this.iZF);
                }
                h.this.iZE.rj(clk.cly() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean csS() {
            return false;
        }
    };
    private CustomMessageListener tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.guO != null) {
                    h.this.guO.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.guO != null && h.this.guO.le() && h.this.iZh != null && h.this.iZh.video_length.intValue() > 0 && h.this.iZh.video_duration.intValue() > 0) {
                    float intValue = h.this.iZh.video_length.intValue() * (1.0f - ((h.this.guO.getCurrentPosition() * 1.0f) / (h.this.iZh.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.iFL.getPageContext().getPageActivity(), String.format(h.this.iFL.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener ibB = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.crC();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gqG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.iZh != null) {
                h.this.f(h.this.iZh);
                h.this.guO.cyM();
                h.this.guO.cda();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iZw;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void qU(boolean z) {
        if (this.iFL != null) {
            this.iFL.cmR();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.iZt = 0.0f;
        this.iFL = pbFragment;
        this.iZe = cVar;
        this.iZt = l.getDimens(this.iFL.getActivity(), R.dimen.ds240);
        this.iZy = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.gqG.setTag(pbFragment.getUniqueId());
        this.gqG.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gqG);
        this.gOY = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.iZf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.iFL.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.iFL.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iFL.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.iFL.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iZx = (intValue2 * 1.0d) / intValue;
            if (this.iZx > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iZw = i;
        this.iZf.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bis() {
        return this.iZx >= 1.0d;
    }

    public int cri() {
        return this.iZw;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iZd = (RelativeLayout) LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iZf = (CustomFrameLayout) this.iZd.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.Kn = ((double) this.iZw) <= (((double) l.getEquipmentWidth(this.iFL.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.guO = new com.baidu.tieba.play.c(this.iFL.getPageContext(), this.iZf, true, com.baidu.tbadk.a.b.rH("cyber_player_test") || com.baidu.tbadk.a.b.rG("cyber_player_test") ? 1 : 0);
        this.guO.a(this.iZL);
        this.guO.rS(false);
        this.guO.a(this.iZB);
        this.guO.As(am.ku(R.drawable.pic_use_header_60_n));
        this.guO.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.iFL.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.iFL.getBaseFragmentActivity())) {
            this.guO.rJ(false);
        }
        this.guO.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.iFL.getListView() != null && h.this.iFL.getListView().getChildCount() > 0 && h.this.iFL.getListView().getChildAt(0) == h.this.csO()) {
                            h.this.iZM = h.this.csO().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.BF = 0.0f;
                        h.this.iZM = 0;
                        break;
                    case 2:
                        if (h.this.iFL.getListView() != null && h.this.iFL.getListView().getChildCount() > 0 && h.this.iFL.getListView().getChildAt(0) == h.this.csO()) {
                            h.this.iFL.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.BF)) + h.this.iZM);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iZx >= 1.0d) {
                this.guO.aj(false, true);
            } else {
                this.guO.aj(true, false);
            }
            this.iZu = ((float) f) + this.iZt > ((float) l.getEquipmentHeight(this.iFL.getActivity()));
            if (this.iZu) {
                if (this.iZj == null) {
                    this.iZj = new f(this.iFL.getPageContext(), this.iZf);
                }
                this.iFL.cmP().cqE();
                this.iZk = true;
            }
        }
        csJ();
        this.mEmptyView = new View(this.iFL.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iZw));
        if (this.iZe != null && this.iZe.mNavigationBar != null) {
            this.iZe.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iZe.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iZe.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aFR() && !TbSingleton.getInstance().isNotchScreen(this.iFL.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iFL.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iZz = (PbVideoWifiTipLayout) this.iZd.findViewById(R.id.layout_wifi_tip);
        this.iZz.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iZI = true;
                h.this.iZz.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.gOY != null) {
            this.gOY.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.iFL.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.iZg == null) {
            this.iZg = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lN(boolean z) {
                    if (h.this.csM() && h.this.iZe != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iZe.crv().clearAnimation();
                        h.this.csK();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.ibB);
                            h.this.iZe.crv().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bGC() {
                    if (h.this.csM()) {
                        h.this.crC();
                    }
                }
            };
        }
        a(this.iZg);
        this.iZp = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iFL.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.guO != null && bjVar != null) {
            this.iZh = videoInfo;
            this.iZl = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.guO.stopPlay();
            this.guO.setIsNeedRecoveryVideoPlayer(true);
            this.elC = new n(this.iFL.getActivity());
            this.iZi = new y();
            this.iZi.mLocate = "pb";
            this.iZi.Pk = bjVar.getTid();
            this.iZi.emF = str;
            this.iZi.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iFL.iJU)) {
                    this.iZi.cPf = this.iFL.iJU;
                }
                this.iZi.jyt = this.iFL.iJT + "";
            } else {
                this.iZi.jyt = this.iFL.cmM();
            }
            ax cnB = this.iFL.cnB();
            if (cnB != null) {
                cnB.b(this.iZi);
            }
            this.iZi.jyv = videoInfo.video_md5;
            y czN = this.iZi.czN();
            czN.mLocate = "6";
            this.startPosition = -1L;
            this.elC.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bz(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean eA = com.baidu.mcn.b.DN().eA(mcnAdInfo.jump_url);
                        if (h.this.Kn && !eA && !h.this.iZq) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.gOY.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLz = mcnAdInfo.card_title;
                                    aVar.aLA = mcnAdInfo.button_title;
                                    aVar.aLB = mcnAdInfo.jump_url;
                                    aVar.aLy = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.aLC = 4;
                                    if (z2) {
                                        h.this.gOY.b(aVar, (ViewGroup) h.this.guO.cyL());
                                    } else {
                                        h.this.gOY.a(aVar, (ViewGroup) h.this.guO.cyL());
                                    }
                                }
                            } else if (h.this.gOY.isShowing()) {
                                h.this.gOY.dismiss();
                            }
                        }
                    }
                }
            });
            this.elC.setVideoStatsData(czN);
            this.guO.cyu().setBusiness(this.elC);
            if (this.guO.cdc()) {
                this.guO.cda();
            }
            this.guO.b(this.iZC);
            this.iZn = null;
            this.iZm = null;
            this.guO.Gx(this.iZn);
            this.guO.ccW().setOnDragingListener(idD);
            this.guO.a(new c.InterfaceC0590c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void ld() {
                    h.this.iFL.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iZA > 0) {
                                h.this.zA(h.this.iZA);
                                h.this.zB(h.this.iZA);
                                h.this.iZA = 0;
                            }
                            h.this.iZD = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0590c
                public void lc() {
                    h.this.iFL.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iZD = false;
                    h.this.iZA = h.this.bcP().getHeight();
                }
            });
            this.guO.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void csQ() {
                    if (h.this.iFL != null && h.this.iZm != null && !StringUtils.isNull(h.this.iZm.getId())) {
                        h.this.iFL.FP(h.this.iZm.getId());
                    }
                }
            });
            this.guO.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qV(boolean z) {
                    if (h.this.iZl != null) {
                        h.this.Bk(z ? "1" : "2");
                    }
                }
            });
            this.guO.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.guO.setThumbnail(videoInfo.thumbnail_url);
            this.guO.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.guO.setFid(str);
            this.guO.GY(bjVar.getTitle());
            this.guO.a(iZN);
            this.guO.bQh();
            this.guO.show();
        }
    }

    public void Gw(String str) {
        if (this.iZi != null) {
            this.iZi.emF = str;
        }
    }

    public void b(PostData postData, bj bjVar, k kVar) {
        if (this.iZj != null) {
            this.iZj.a(postData, bjVar, kVar);
        }
    }

    public void a(c.d dVar) {
        this.iZC = dVar;
    }

    public void aL(bj bjVar) {
        this.iZm = bjVar;
    }

    public void Gx(String str) {
        this.iZn = str;
        if (this.guO != null) {
            this.guO.Gx(this.iZn);
        }
    }

    public void startPlay() {
        if (this.guO != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iZI && !com.baidu.tieba.video.g.cPC().cPD()) {
                this.iZz.setVisibility(0);
                this.iZz.setData(this.iZh);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iZl != null && this.iZl.aCI() != null) {
                TiebaStatic.log(new an("c12619").cx("obj_locate", "pb").cx("tid", this.iZl.getTid()));
                this.mVideoUrl = this.iZl.aCI().video_url;
            }
            this.guO.eg(this.mVideoUrl, this.iZl == null ? "" : this.iZl.getTid());
            Bk("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void csI() {
        if (this.guO != null) {
            this.guO.csI();
        }
    }

    public void destroy() {
        if (this.guO != null) {
            this.guO.destroy();
        }
        if (this.iZf != null) {
            this.iZf.clearAnimation();
        }
        if (this.iZj != null) {
            this.iZj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tR);
        MessageManager.getInstance().unRegisterListener(this.gqG);
    }

    public void onPause() {
        if (this.guO != null) {
            if (this.guO.le()) {
                this.iZo = true;
                this.guO.stopPlay();
            } else if (this.guO.getCurrentState() == 3) {
                this.iZo = false;
            } else if (this.guO.getCurrentState() == 0 || this.guO.getCurrentState() == 1) {
                this.iZo = true;
                this.guO.stopPlay();
            } else {
                this.iZo = false;
                this.guO.stopPlay();
            }
            if (this.iZE != null) {
                this.iZE.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.guO != null && this.iZo) {
            this.guO.cyy();
        }
    }

    private void csJ() {
        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.N(16908290).M(Opcodes.IFEQ).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.iFL.getActivity());
                    if (h.this.iZH == null) {
                        try {
                            h.this.iZH = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iZH);
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
                    h.this.iZG = null;
                    if (h.this.iZH != null && !h.this.iZH.isRecycled()) {
                        h.this.iZH.recycle();
                    }
                    h.this.iZH = null;
                }
            });
            this.iZG = dVar.fI();
            this.iZG.showOnDecorView(this.iFL.getActivity());
        }
    }

    public boolean th(int i) {
        if (this.guO == null) {
            return false;
        }
        return this.guO.Au(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(String str) {
        if (this.iZh != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iZh.video_md5, "", str, this.iZi);
            }
        }
    }

    public void csK() {
        if (this.iZe != null) {
            this.iZe.qL(this.iFL.clN());
        }
    }

    public void crC() {
        if (this.iZe != null) {
            this.iZe.crC();
        }
    }

    public void zp(int i) {
        if (this.iZe != null) {
            this.iZe.zp(i);
        }
        if (this.iZE != null) {
            this.iZE.onChangeSkinType(i);
        }
        if (this.iZj != null) {
            this.iZj.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!csN()) {
                    this.iZr = i;
                    if (this.iZr == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zB(h.this.bcP().getHeight());
                            }
                        }, 100L);
                    }
                    csL();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        if (bcP().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZf.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iZK = false;
                    if (this.iZw != bcP().getHeight()) {
                        this.iZf.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iFL.getActivity()), Math.min(this.iZw, bcP().getHeight() + i)));
                        this.guO.cda();
                    }
                } else if (l.getEquipmentWidth(this.iFL.getActivity()) * 0.5625d != bcP().getHeight()) {
                    this.iZf.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.iFL.getActivity()), (int) Math.max(l.getEquipmentWidth(this.iFL.getActivity()) * 0.5625d, bcP().getHeight() + i)));
                    this.guO.cda();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == csO()) {
                int bottom = childAt.getBottom() - bcP().getBottom();
                if (childAt.getHeight() == 0 || bcP().getHeight() == 0) {
                    bottom = 0;
                }
                zA(bottom);
            } else {
                zA((-this.iZw) + 2);
            }
        }
        if (!csN() && this.iZD) {
            if (this.iZr == 1) {
                this.iZJ = true;
                zB(bcP().getHeight());
            } else if (this.iZr == 2) {
                this.iZJ = true;
                int y = (int) bcP().getY();
                if (this.iZs == y) {
                    zB(bcP().getHeight());
                } else {
                    this.iZs = y;
                    zB(bcP().getHeight());
                }
                if (i == 0 && this.iZv) {
                    this.iZv = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.csI();
                        }
                    }, 100L);
                }
            } else if (this.iZr == 0) {
                if (this.iZJ || !"nani_midpage".equals(this.iFL.cmM())) {
                    zB(bcP().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zB(int i) {
        zC(i);
        csL();
    }

    public void qy(boolean z) {
        this.iZK = z;
    }

    private void zC(int i) {
        if (this.iZj != null) {
            if (this.iZl != null && this.iZl.aEm()) {
                this.iZj.csG().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iZw;
            }
            float f = this.iZw - i;
            float f2 = f > this.iZt ? 0.0f : 1.0f - (f / this.iZt);
            if (this.iZK) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iZj.csG().setVisibility(8);
            } else {
                this.iZj.csG().setVisibility(0);
            }
            this.iZj.aE(f2);
        }
    }

    public void csL() {
        if (this.iZj != null) {
            if (csN()) {
                this.iFL.cmP().cqE();
            } else if (this.iZj.csG().getVisibility() == 0) {
                this.iFL.cmP().cqE();
                this.iZk = true;
            } else if (this.iZk) {
                this.iFL.cmP().qx(false);
                this.iZk = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csM() {
        return bcP().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iZq = false;
        if (this.guO != null && this.iZf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZf.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gOY != null && this.gOY.isShowing()) {
                    this.gOY.DO();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iZG != null) {
                    this.iZG.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iZq = true;
                this.iZf.setLayoutParams(layoutParams);
                this.iFL.cmP().cqE();
                this.iZk = true;
            } else {
                f(this.iZh);
                csK();
                this.iZq = false;
                this.iZe.qK(true);
            }
            this.guO.a(this.iFL.getPageContext(), configuration);
        }
    }

    public boolean csN() {
        return this.iZq;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iZj != null) {
            this.iZj.R(onClickListener);
        }
    }

    public View bcP() {
        return this.iZd;
    }

    public boolean cqN() {
        if (bcP() == null) {
            return false;
        }
        return bcP().getBottom() > l.getEquipmentHeight(bcP().getContext()) - l.getDimens(bcP().getContext(), R.dimen.ds50);
    }

    public void crg() {
        this.iZv = true;
    }

    public View csO() {
        return this.mEmptyView;
    }
}
