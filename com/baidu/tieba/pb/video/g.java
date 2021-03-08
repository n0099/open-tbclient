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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.p;
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
    private static VideoControllerView.a lhJ = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.g.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLP() {
        }
    };
    private static c.i mlY = new c.i() { // from class: com.baidu.tieba.pb.video.g.10
        @Override // com.baidu.tieba.play.c.i
        public void cFE() {
        }
    };
    private boolean ahM;
    private com.baidu.mcn.c jOt;
    private com.baidu.tieba.play.c jpo;
    private PbFragment lPo;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private float mlE;
    private int mlH;
    private double mlI;
    private long mlJ;
    private PbVideoWifiTipLayout mlK;
    private int mlL;
    private c.d mlN;
    private PbFullScreenFloatingHuajiAninationView mlP;
    private com.baidu.adp.lib.guide.c mlR;
    private Bitmap mlS;
    private boolean mlT;
    private boolean mlV;
    private int mlX;
    private RelativeLayout mlp;
    private com.baidu.tieba.pb.pb.main.view.c mlq;
    private CustomFrameLayout mlr;
    private c.d mls;
    private o mlu;
    private e mlv;
    private boolean mlw;
    private cb mlx;
    private cb mly;
    private String mlz;
    private String mVideoUrl = null;
    private VideoInfo mlt = null;
    private boolean mlA = false;
    private int mlB = 0;
    private boolean mlC = false;
    private int scrollState = 0;
    private int mlD = 0;
    private boolean mlF = false;
    private boolean mlG = false;
    private long startPosition = -1;
    private int iPg = 0;
    private c.p mlM = new c.p() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // com.baidu.tieba.play.c.p
        public void cMW() {
            if (g.this.lPo != null && g.this.lPo.dmG() != null && g.this.lPo.dmG().getPbData() != null) {
                PostData dly = g.this.lPo.dmG().getPbData().dly();
                if (dly == null && y.getCount(g.this.lPo.dmG().getPbData().dlr()) > 1) {
                    dly = (PostData) y.getItem(g.this.lPo.dmG().getPbData().dlr(), 0);
                }
                com.baidu.tieba.pb.c.a.a(g.this.lPo.dmG().getPbData(), dly, 1, 1, 4);
            }
        }
    };
    private boolean mlO = true;
    private PbFullScreenFloatingHuajiAninationView.a mlQ = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.g.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            g.this.wj(false);
        }
    };
    private boolean mlU = false;
    private c.m mlW = new c.m() { // from class: com.baidu.tieba.pb.video.g.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dtZ() {
            if (g.this.mlI >= 1.0d) {
                if (g.this.lPo.checkUpIsLogin()) {
                    g.this.lPo.dol();
                    if (g.this.lPo.dmG() == null || g.this.lPo.dmG().getPbData() == null || g.this.lPo.dmG().getPbData().dlO() == null) {
                        return false;
                    }
                    p dlO = g.this.lPo.dmG().getPbData().dlO();
                    if (g.this.mlP == null) {
                        g.this.mlP = new PbFullScreenFloatingHuajiAninationView(g.this.lPo.getActivity());
                        g.this.mlP.setFloatingHuajiAninationListener(g.this.mlQ);
                    }
                    g.this.mlP.wA(dlO.dmj() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dua() {
            return false;
        }
    };
    private CustomMessageListener Ri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.g.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (g.this.jpo != null) {
                    g.this.jpo.setNetworkChange();
                }
                if (j.isMobileNet() && g.this.jpo != null && g.this.jpo.rl() && g.this.mlt != null && g.this.mlt.video_length.intValue() > 0 && g.this.mlt.video_duration.intValue() > 0) {
                    float intValue = g.this.mlt.video_length.intValue() * (1.0f - ((g.this.jpo.getCurrentPosition() * 1.0f) / (g.this.mlt.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(g.this.lPo.getPageContext().getPageActivity(), String.format(g.this.lPo.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener lfM = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.g.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.dsG();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener jjV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.mlt != null) {
                g.this.f(g.this.mlt);
                g.this.jpo.dAg();
                g.this.jpo.dcE();
                if (g.this.mEmptyView != null && g.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = g.this.mEmptyView.getLayoutParams();
                    layoutParams.height = g.this.mlH;
                    g.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(boolean z) {
        if (this.lPo != null) {
            this.lPo.dnD();
        }
    }

    public g(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.mlE = 0.0f;
        this.lPo = pbFragment;
        this.mlq = cVar;
        this.mlE = l.getDimens(this.lPo.getActivity(), R.dimen.ds240);
        this.mlJ = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Ri);
        this.jjV.setTag(pbFragment.getUniqueId());
        this.jjV.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.jjV);
        this.jOt = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.mlr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lPo.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lPo.getActivity());
        Rect visibilityRegion = bg.getVisibilityRegion(this.lPo.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lPo.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.mlI = (intValue2 * 1.0d) / intValue;
            if (this.mlI > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.mlH = i;
        this.mlr.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean isVertical() {
        return this.mlI >= 1.0d;
    }

    public int dsl() {
        return this.mlH;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.mlp = (RelativeLayout) LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.mlr = (CustomFrameLayout) this.mlp.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.ahM = ((double) this.mlH) <= (((double) l.getEquipmentWidth(this.lPo.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jpo = new com.baidu.tieba.play.c(this.lPo.getPageContext(), this.mlr, true);
        this.jpo.setStageType("2002");
        this.jpo.a(this.mlW);
        this.jpo.xn(false);
        this.jpo.a(this.mlM);
        this.jpo.Hl(ap.oB(R.drawable.pic_use_header_40_n));
        this.jpo.a(new c.n() { // from class: com.baidu.tieba.pb.video.g.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                g.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lPo.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lPo.getBaseFragmentActivity())) {
            this.jpo.xd(false);
        }
        this.jpo.a(new c.k() { // from class: com.baidu.tieba.pb.video.g.18
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
                        if (g.this.lPo.getListView() != null && g.this.lPo.getListView().getChildCount() > 0 && g.this.lPo.getListView().getChildAt(0) == g.this.dtX()) {
                            g.this.mlX = g.this.dtX().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        g.this.mLastY = 0.0f;
                        g.this.mlX = 0;
                        break;
                    case 2:
                        if (g.this.lPo.getListView() != null && g.this.lPo.getListView().getChildCount() > 0 && g.this.lPo.getListView().getChildAt(0) == g.this.dtX()) {
                            g.this.lPo.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - g.this.mLastY)) + g.this.mlX);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.mlI >= 1.0d) {
                this.jpo.ax(false, true);
            } else {
                this.jpo.ax(true, false);
            }
            this.mlF = ((float) f) + this.mlE > ((float) l.getEquipmentHeight(this.lPo.getActivity()));
            if (this.mlF) {
                if (this.mlv == null) {
                    this.mlv = new e(this.lPo.getPageContext(), this.mlr);
                }
                this.lPo.dnB().drC();
                this.mlw = true;
            }
        }
        dtS();
        this.mEmptyView = new View(this.lPo.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mlH));
        if (this.mlq != null && this.mlq.mNavigationBar != null) {
            this.mlq.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.mlq.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.mlq.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bsb() && !TbSingleton.getInstance().isNotchScreen(this.lPo.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lPo.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.mlK = (PbVideoWifiTipLayout) this.mlp.findViewById(R.id.layout_wifi_tip);
        this.mlK.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mlT = true;
                g.this.mlK.setVisibility(8);
                g.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jOt != null) {
            this.jOt.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lPo.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.mls == null) {
            this.mls = new c.d() { // from class: com.baidu.tieba.pb.video.g.20
                @Override // com.baidu.tieba.play.c.d
                public void qY(boolean z) {
                    if (g.this.dtV() && g.this.mlq != null) {
                        loadAnimation.setAnimationListener(null);
                        g.this.mlq.dsy().clearAnimation();
                        g.this.dtT();
                        if (z) {
                            loadAnimation.setAnimationListener(g.this.lfM);
                            g.this.mlq.dsy().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFD() {
                    if (g.this.dtV()) {
                        g.this.dsG();
                    }
                }
            };
        }
        a(this.mls);
        this.mlB = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lPo.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final cb cbVar, final String str) {
        if (videoInfo != null && this.jpo != null && cbVar != null) {
            this.mlt = videoInfo;
            this.mlx = cbVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jpo.stopPlay();
            this.mlu = new o();
            this.mlu.mLocate = "pb";
            this.mlu.anU = cbVar.getTid();
            this.mlu.fOD = str;
            this.mlu.mUid = TbadkCoreApplication.getCurrentAccount();
            if (cbVar.isBjh()) {
                if (!StringUtils.isNull(this.lPo.lUx)) {
                    this.mlu.ePf = this.lPo.lUx;
                }
                this.mlu.mKB = this.lPo.lUw + "";
            } else {
                this.mlu.mKB = this.lPo.dny();
            }
            bk don = this.lPo.don();
            if (don != null) {
                don.a(this.mlu);
            }
            this.mlu.mKE = videoInfo.video_md5;
            o dAw = this.mlu.dAw();
            dAw.mLocate = "6";
            this.startPosition = -1L;
            if (this.jpo.getVideoView() != null && this.jpo.getVideoView().getMediaProgressObserver() != null) {
                this.jpo.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.g.2
                    @Override // com.baidu.tieba.play.f.b
                    public void cf(int i, int i2) {
                        boolean z = true;
                        if (g.this.startPosition <= 0) {
                            g.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean je = com.baidu.mcn.b.abu().je(mcnAdInfo.jump_url);
                            if (g.this.ahM && !je && !g.this.mlC) {
                                boolean z2 = g.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!g.this.jOt.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.cjk = mcnAdInfo.card_title;
                                        aVar.cjl = mcnAdInfo.button_title;
                                        aVar.cjm = mcnAdInfo.jump_url;
                                        aVar.cjj = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = cbVar.getTid();
                                        aVar.cjn = 4;
                                        if (z2) {
                                            g.this.jOt.b(aVar, (ViewGroup) g.this.jpo.dAf());
                                        } else {
                                            g.this.jOt.a(aVar, (ViewGroup) g.this.jpo.dAf());
                                        }
                                    }
                                } else if (g.this.jOt.isShowing()) {
                                    g.this.jOt.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jpo.getVideoView().setVideoStatData(dAw);
            if (this.jpo.dcG()) {
                this.jpo.dcE();
            }
            this.jpo.b(this.mlN);
            this.mlz = null;
            this.mly = null;
            this.jpo.Qk(this.mlz);
            this.jpo.dcA().setOnDragingListener(lhJ);
            this.jpo.a(new c.InterfaceC0855c() { // from class: com.baidu.tieba.pb.video.g.3
                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rk() {
                    g.this.lPo.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    g.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.mlL > 0) {
                                g.this.Gv(g.this.mlL);
                                g.this.Gw(g.this.mlL);
                                g.this.mlL = 0;
                            }
                            g.this.mlO = true;
                        }
                    }, 200L);
                    g.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0855c
                public void rj() {
                    g.this.lPo.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    g.this.mlO = false;
                    g.this.mlL = g.this.getContainerView().getHeight();
                }
            });
            this.jpo.a(new c.h() { // from class: com.baidu.tieba.pb.video.g.4
                @Override // com.baidu.tieba.play.c.h
                public void dtY() {
                    if (g.this.lPo != null && g.this.mly != null && !StringUtils.isNull(g.this.mly.getId())) {
                        g.this.lPo.Pz(g.this.mly.getId());
                    }
                }
            });
            this.jpo.a(new c.j() { // from class: com.baidu.tieba.pb.video.g.5
                @Override // com.baidu.tieba.play.c.j
                public void wk(boolean z) {
                    if (g.this.mlx != null) {
                        g.this.Kw(z ? "1" : "2");
                    }
                }
            });
            this.jpo.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.g.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", g.this.mVideoUrl);
                    return true;
                }
            });
            this.jpo.setThumbnail(videoInfo.thumbnail_url);
            this.jpo.setVideoUrl(this.mVideoUrl, cbVar.getTid());
            this.jpo.setFid(str);
            this.jpo.QJ(cbVar.getTitle());
            this.jpo.a(mlY);
            this.jpo.cSR();
            this.jpo.show();
        }
    }

    public void Qj(String str) {
        if (this.mlu != null) {
            this.mlu.fOD = str;
        }
    }

    public void b(PostData postData, cb cbVar, p pVar) {
        if (this.mlv != null) {
            this.mlv.a(postData, cbVar, pVar);
        }
    }

    public void a(c.d dVar) {
        this.mlN = dVar;
    }

    public void aQ(cb cbVar) {
        this.mly = cbVar;
    }

    public void Qk(String str) {
        this.mlz = str;
        if (this.jpo != null) {
            this.jpo.Qk(this.mlz);
        }
    }

    public void startPlay() {
        if (this.jpo != null) {
            if (j.isMobileNet() && !this.mlT && !com.baidu.tieba.video.f.dSn().dSo()) {
                this.mlK.setVisibility(0);
                this.mlK.setData(this.mlt);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.mlx != null && this.mlx.boj() != null) {
                TiebaStatic.log(new ar("c12619").dR("obj_locate", "pb").dR("tid", this.mlx.getTid()));
                this.mVideoUrl = this.mlx.boj().video_url;
            }
            this.jpo.fX(this.mVideoUrl, this.mlx == null ? "" : this.mlx.getTid());
            Kw("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dtR() {
        if (this.jpo != null) {
            this.jpo.dtR();
        }
    }

    public void destroy() {
        if (this.jpo != null) {
            this.jpo.destroy();
        }
        if (this.mlr != null) {
            this.mlr.clearAnimation();
        }
        if (this.mlv != null) {
            this.mlv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Ri);
        MessageManager.getInstance().unRegisterListener(this.jjV);
    }

    public void onPause() {
        if (this.jpo != null) {
            if (this.jpo.rl()) {
                this.mlA = true;
                this.jpo.stopPlay();
            } else if (this.jpo.getCurrentState() == 3) {
                this.mlA = false;
            } else if (this.jpo.getCurrentState() == 0 || this.jpo.getCurrentState() == 1) {
                this.mlA = true;
                this.jpo.stopPlay();
            } else {
                this.mlA = false;
                this.jpo.stopPlay();
            }
            if (this.mlP != null) {
                this.mlP.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jpo != null && this.mlA) {
            this.jpo.dzS();
        }
    }

    private void dtS() {
        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.g.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(g.this.lPo.getActivity());
                    if (g.this.mlS == null) {
                        try {
                            g.this.mlS = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(g.this.mlS);
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
                    g.this.mlR = null;
                    if (g.this.mlS != null && !g.this.mlS.isRecycled()) {
                        g.this.mlS.recycle();
                    }
                    g.this.mlS = null;
                }
            });
            this.mlR = dVar.lF();
            this.mlR.showOnDecorView(this.lPo.getActivity());
        }
    }

    public boolean zg(int i) {
        if (this.jpo == null) {
            return false;
        }
        return this.jpo.Ho(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kw(String str) {
        if (this.mlt != null) {
            if ("1".equals(str) || "2".equals(str)) {
                h.a(this.mlt.video_md5, "", str, this.mlu, this.jpo.getVideoView().getPcdnState());
            }
        }
    }

    public void dtT() {
        if (this.mlq != null) {
            this.mlq.wa(this.lPo.dmy());
        }
    }

    public void dsG() {
        if (this.mlq != null) {
            this.mlq.dsG();
        }
    }

    public void Gi(int i) {
        if (this.mlq != null) {
            this.mlq.Gi(i);
        }
        if (this.mlP != null) {
            this.mlP.onChangeSkinType(i);
        }
        if (this.mlv != null) {
            this.mlv.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dtW()) {
                    this.scrollState = i;
                    if (this.scrollState == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.11
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.Gw(g.this.getContainerView().getHeight());
                            }
                        }, 100L);
                    }
                    dtU();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv(int i) {
        if (getContainerView().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mlr.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.mlV = false;
                    if (this.mlH != getContainerView().getHeight()) {
                        this.mlr.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lPo.getActivity()), Math.min(this.mlH, getContainerView().getHeight() + i)));
                        this.jpo.dcE();
                    }
                } else if (l.getEquipmentWidth(this.lPo.getActivity()) * 0.5625d != getContainerView().getHeight()) {
                    this.mlr.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lPo.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lPo.getActivity()) * 0.5625d, getContainerView().getHeight() + i)));
                    this.jpo.dcE();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dtX()) {
                int bottom = childAt.getBottom() - getContainerView().getBottom();
                if (childAt.getHeight() == 0 || getContainerView().getHeight() == 0) {
                    bottom = 0;
                }
                Gv(bottom);
            } else {
                Gv((-this.mlH) + 2);
            }
        }
        if (!dtW() && this.mlO) {
            if (this.scrollState == 1) {
                this.mlU = true;
                Gw(getContainerView().getHeight());
            } else if (this.scrollState == 2) {
                this.mlU = true;
                int y = (int) getContainerView().getY();
                if (this.mlD == y) {
                    Gw(getContainerView().getHeight());
                } else {
                    this.mlD = y;
                    Gw(getContainerView().getHeight());
                }
                if (i == 0 && this.mlG) {
                    this.mlG = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.dtR();
                        }
                    }, 100L);
                }
            } else if (this.scrollState == 0) {
                if (this.mlU || !"nani_midpage".equals(this.lPo.dny())) {
                    Gw(getContainerView().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gw(int i) {
        Gx(i);
        dtU();
    }

    public void vL(boolean z) {
        this.mlV = z;
    }

    private void Gx(int i) {
        if (this.mlv != null) {
            if (this.mlx != null && this.mlx.bmB()) {
                this.mlv.dtP().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.mlH;
            }
            float f = this.mlH - i;
            float f2 = f > this.mlE ? 0.0f : 1.0f - (f / this.mlE);
            if (this.mlV) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.mlv.dtP().setVisibility(8);
            } else {
                this.mlv.dtP().setVisibility(0);
            }
            this.mlv.aY(f2);
        }
    }

    public void dtU() {
        if (this.mlv != null) {
            if (dtW()) {
                this.lPo.dnB().drC();
            } else if (this.mlv.dtP().getVisibility() == 0) {
                this.lPo.dnB().drC();
                this.mlw = true;
            } else if (this.mlw) {
                this.lPo.dnB().vK(false);
                this.mlw = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtV() {
        return getContainerView().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mlC = false;
        if (this.jpo != null && this.mlr != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mlr.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jOt != null && this.jOt.isShowing()) {
                    this.jOt.abv();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.mlR != null) {
                    this.mlR.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.mlC = true;
                this.mlr.setLayoutParams(layoutParams);
                this.lPo.dnB().drC();
                this.mlw = true;
            } else {
                f(this.mlt);
                dtT();
                this.mlC = false;
                this.mlq.vZ(true);
            }
            this.jpo.a(this.lPo.getPageContext(), configuration);
        }
    }

    public boolean dtW() {
        return this.mlC;
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.mlv != null) {
            this.mlv.Y(onClickListener);
        }
    }

    public View getContainerView() {
        return this.mlp;
    }

    public boolean drL() {
        if (getContainerView() == null) {
            return false;
        }
        return getContainerView().getBottom() > l.getEquipmentHeight(getContainerView().getContext()) - l.getDimens(getContainerView().getContext(), R.dimen.ds50);
    }

    public void dsj() {
        this.mlG = true;
    }

    public View dtX() {
        return this.mEmptyView;
    }
}
