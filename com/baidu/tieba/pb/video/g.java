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
    private static VideoControllerView.a lft = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.g.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLE() {
        }
    };
    private static c.i mjH = new c.i() { // from class: com.baidu.tieba.pb.video.g.10
        @Override // com.baidu.tieba.play.c.i
        public void cFr() {
        }
    };
    private boolean agu;
    private com.baidu.mcn.c jMw;
    private com.baidu.tieba.play.c jnr;
    private PbFragment lMX;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private RelativeLayout miY;
    private com.baidu.tieba.pb.pb.main.view.c miZ;
    private com.baidu.adp.lib.guide.c mjA;
    private Bitmap mjB;
    private boolean mjC;
    private boolean mjE;
    private int mjG;
    private CustomFrameLayout mja;
    private c.d mjb;
    private o mjd;
    private e mje;
    private boolean mjf;
    private cb mjg;
    private cb mjh;
    private String mji;
    private float mjn;
    private int mjq;
    private double mjr;
    private long mjs;
    private PbVideoWifiTipLayout mjt;
    private int mju;
    private c.d mjw;
    private PbFullScreenFloatingHuajiAninationView mjy;
    private String mVideoUrl = null;
    private VideoInfo mjc = null;
    private boolean mjj = false;
    private int mjk = 0;
    private boolean mjl = false;
    private int scrollState = 0;
    private int mjm = 0;
    private boolean mjo = false;
    private boolean mjp = false;
    private long startPosition = -1;
    private int iNj = 0;
    private c.p mjv = new c.p() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // com.baidu.tieba.play.c.p
        public void cMJ() {
            if (g.this.lMX != null && g.this.lMX.dmq() != null && g.this.lMX.dmq().getPbData() != null) {
                PostData dli = g.this.lMX.dmq().getPbData().dli();
                if (dli == null && y.getCount(g.this.lMX.dmq().getPbData().dlb()) > 1) {
                    dli = (PostData) y.getItem(g.this.lMX.dmq().getPbData().dlb(), 0);
                }
                com.baidu.tieba.pb.c.a.a(g.this.lMX.dmq().getPbData(), dli, 1, 1, 4);
            }
        }
    };
    private boolean mjx = true;
    private PbFullScreenFloatingHuajiAninationView.a mjz = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.g.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            g.this.wj(false);
        }
    };
    private boolean mjD = false;
    private c.m mjF = new c.m() { // from class: com.baidu.tieba.pb.video.g.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dtJ() {
            if (g.this.mjr >= 1.0d) {
                if (g.this.lMX.checkUpIsLogin()) {
                    g.this.lMX.dnV();
                    if (g.this.lMX.dmq() == null || g.this.lMX.dmq().getPbData() == null || g.this.lMX.dmq().getPbData().dly() == null) {
                        return false;
                    }
                    p dly = g.this.lMX.dmq().getPbData().dly();
                    if (g.this.mjy == null) {
                        g.this.mjy = new PbFullScreenFloatingHuajiAninationView(g.this.lMX.getActivity());
                        g.this.mjy.setFloatingHuajiAninationListener(g.this.mjz);
                    }
                    g.this.mjy.wA(dly.dlT() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dtK() {
            return false;
        }
    };
    private CustomMessageListener PM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.g.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (g.this.jnr != null) {
                    g.this.jnr.setNetworkChange();
                }
                if (j.isMobileNet() && g.this.jnr != null && g.this.jnr.rl() && g.this.mjc != null && g.this.mjc.video_length.intValue() > 0 && g.this.mjc.video_duration.intValue() > 0) {
                    float intValue = g.this.mjc.video_length.intValue() * (1.0f - ((g.this.jnr.getCurrentPosition() * 1.0f) / (g.this.mjc.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(g.this.lMX.getPageContext().getPageActivity(), String.format(g.this.lMX.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener ldv = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.g.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.dsq();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener jhX = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.mjc != null) {
                g.this.f(g.this.mjc);
                g.this.jnr.dzQ();
                g.this.jnr.dco();
                if (g.this.mEmptyView != null && g.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = g.this.mEmptyView.getLayoutParams();
                    layoutParams.height = g.this.mjq;
                    g.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(boolean z) {
        if (this.lMX != null) {
            this.lMX.dnm();
        }
    }

    public g(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.mjn = 0.0f;
        this.lMX = pbFragment;
        this.miZ = cVar;
        this.mjn = l.getDimens(this.lMX.getActivity(), R.dimen.ds240);
        this.mjs = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.PM);
        this.jhX.setTag(pbFragment.getUniqueId());
        this.jhX.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.jhX);
        this.jMw = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.mja.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lMX.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lMX.getActivity());
        Rect visibilityRegion = bg.getVisibilityRegion(this.lMX.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lMX.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.mjr = (intValue2 * 1.0d) / intValue;
            if (this.mjr > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.mjq = i;
        this.mja.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean isVertical() {
        return this.mjr >= 1.0d;
    }

    public int drV() {
        return this.mjq;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.miY = (RelativeLayout) LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.mja = (CustomFrameLayout) this.miY.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.agu = ((double) this.mjq) <= (((double) l.getEquipmentWidth(this.lMX.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jnr = new com.baidu.tieba.play.c(this.lMX.getPageContext(), this.mja, true);
        this.jnr.setStageType("2002");
        this.jnr.a(this.mjF);
        this.jnr.xn(false);
        this.jnr.a(this.mjv);
        this.jnr.Hi(ap.oA(R.drawable.pic_use_header_40_n));
        this.jnr.a(new c.n() { // from class: com.baidu.tieba.pb.video.g.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                g.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lMX.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lMX.getBaseFragmentActivity())) {
            this.jnr.xd(false);
        }
        this.jnr.a(new c.k() { // from class: com.baidu.tieba.pb.video.g.18
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
                        if (g.this.lMX.getListView() != null && g.this.lMX.getListView().getChildCount() > 0 && g.this.lMX.getListView().getChildAt(0) == g.this.dtH()) {
                            g.this.mjG = g.this.dtH().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        g.this.mLastY = 0.0f;
                        g.this.mjG = 0;
                        break;
                    case 2:
                        if (g.this.lMX.getListView() != null && g.this.lMX.getListView().getChildCount() > 0 && g.this.lMX.getListView().getChildAt(0) == g.this.dtH()) {
                            g.this.lMX.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - g.this.mLastY)) + g.this.mjG);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.mjr >= 1.0d) {
                this.jnr.ax(false, true);
            } else {
                this.jnr.ax(true, false);
            }
            this.mjo = ((float) f) + this.mjn > ((float) l.getEquipmentHeight(this.lMX.getActivity()));
            if (this.mjo) {
                if (this.mje == null) {
                    this.mje = new e(this.lMX.getPageContext(), this.mja);
                }
                this.lMX.dnk().drm();
                this.mjf = true;
            }
        }
        dtC();
        this.mEmptyView = new View(this.lMX.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mjq));
        if (this.miZ != null && this.miZ.mNavigationBar != null) {
            this.miZ.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.miZ.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.miZ.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bsa() && !TbSingleton.getInstance().isNotchScreen(this.lMX.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lMX.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.mjt = (PbVideoWifiTipLayout) this.miY.findViewById(R.id.layout_wifi_tip);
        this.mjt.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mjC = true;
                g.this.mjt.setVisibility(8);
                g.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jMw != null) {
            this.jMw.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lMX.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.mjb == null) {
            this.mjb = new c.d() { // from class: com.baidu.tieba.pb.video.g.20
                @Override // com.baidu.tieba.play.c.d
                public void qY(boolean z) {
                    if (g.this.dtF() && g.this.miZ != null) {
                        loadAnimation.setAnimationListener(null);
                        g.this.miZ.dsi().clearAnimation();
                        g.this.dtD();
                        if (z) {
                            loadAnimation.setAnimationListener(g.this.ldv);
                            g.this.miZ.dsi().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFq() {
                    if (g.this.dtF()) {
                        g.this.dsq();
                    }
                }
            };
        }
        a(this.mjb);
        this.mjk = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lMX.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final cb cbVar, final String str) {
        if (videoInfo != null && this.jnr != null && cbVar != null) {
            this.mjc = videoInfo;
            this.mjg = cbVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jnr.stopPlay();
            this.mjd = new o();
            this.mjd.mLocate = "pb";
            this.mjd.amC = cbVar.getTid();
            this.mjd.fNd = str;
            this.mjd.mUid = TbadkCoreApplication.getCurrentAccount();
            if (cbVar.isBjh()) {
                if (!StringUtils.isNull(this.lMX.lSg)) {
                    this.mjd.eNE = this.lMX.lSg;
                }
                this.mjd.mIg = this.lMX.lSf + "";
            } else {
                this.mjd.mIg = this.lMX.dnh();
            }
            bk dnX = this.lMX.dnX();
            if (dnX != null) {
                dnX.a(this.mjd);
            }
            this.mjd.mIj = videoInfo.video_md5;
            o dAh = this.mjd.dAh();
            dAh.mLocate = "6";
            this.startPosition = -1L;
            if (this.jnr.getVideoView() != null && this.jnr.getVideoView().getMediaProgressObserver() != null) {
                this.jnr.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.g.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ce(int i, int i2) {
                        boolean z = true;
                        if (g.this.startPosition <= 0) {
                            g.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean iY = com.baidu.mcn.b.abr().iY(mcnAdInfo.jump_url);
                            if (g.this.agu && !iY && !g.this.mjl) {
                                boolean z2 = g.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!g.this.jMw.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.chJ = mcnAdInfo.card_title;
                                        aVar.chK = mcnAdInfo.button_title;
                                        aVar.chL = mcnAdInfo.jump_url;
                                        aVar.chI = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = cbVar.getTid();
                                        aVar.chM = 4;
                                        if (z2) {
                                            g.this.jMw.b(aVar, (ViewGroup) g.this.jnr.dzP());
                                        } else {
                                            g.this.jMw.a(aVar, (ViewGroup) g.this.jnr.dzP());
                                        }
                                    }
                                } else if (g.this.jMw.isShowing()) {
                                    g.this.jMw.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jnr.getVideoView().setVideoStatData(dAh);
            if (this.jnr.dcq()) {
                this.jnr.dco();
            }
            this.jnr.b(this.mjw);
            this.mji = null;
            this.mjh = null;
            this.jnr.Qd(this.mji);
            this.jnr.dck().setOnDragingListener(lft);
            this.jnr.a(new c.InterfaceC0848c() { // from class: com.baidu.tieba.pb.video.g.3
                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rk() {
                    g.this.lMX.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    g.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.mju > 0) {
                                g.this.Gs(g.this.mju);
                                g.this.Gt(g.this.mju);
                                g.this.mju = 0;
                            }
                            g.this.mjx = true;
                        }
                    }, 200L);
                    g.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0848c
                public void rj() {
                    g.this.lMX.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    g.this.mjx = false;
                    g.this.mju = g.this.getContainerView().getHeight();
                }
            });
            this.jnr.a(new c.h() { // from class: com.baidu.tieba.pb.video.g.4
                @Override // com.baidu.tieba.play.c.h
                public void dtI() {
                    if (g.this.lMX != null && g.this.mjh != null && !StringUtils.isNull(g.this.mjh.getId())) {
                        g.this.lMX.Ps(g.this.mjh.getId());
                    }
                }
            });
            this.jnr.a(new c.j() { // from class: com.baidu.tieba.pb.video.g.5
                @Override // com.baidu.tieba.play.c.j
                public void wk(boolean z) {
                    if (g.this.mjg != null) {
                        g.this.Km(z ? "1" : "2");
                    }
                }
            });
            this.jnr.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.g.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", g.this.mVideoUrl);
                    return true;
                }
            });
            this.jnr.setThumbnail(videoInfo.thumbnail_url);
            this.jnr.setVideoUrl(this.mVideoUrl, cbVar.getTid());
            this.jnr.setFid(str);
            this.jnr.QC(cbVar.getTitle());
            this.jnr.a(mjH);
            this.jnr.cSD();
            this.jnr.show();
        }
    }

    public void Qc(String str) {
        if (this.mjd != null) {
            this.mjd.fNd = str;
        }
    }

    public void b(PostData postData, cb cbVar, p pVar) {
        if (this.mje != null) {
            this.mje.a(postData, cbVar, pVar);
        }
    }

    public void a(c.d dVar) {
        this.mjw = dVar;
    }

    public void aQ(cb cbVar) {
        this.mjh = cbVar;
    }

    public void Qd(String str) {
        this.mji = str;
        if (this.jnr != null) {
            this.jnr.Qd(this.mji);
        }
    }

    public void startPlay() {
        if (this.jnr != null) {
            if (j.isMobileNet() && !this.mjC && !com.baidu.tieba.video.f.dRX().dRY()) {
                this.mjt.setVisibility(0);
                this.mjt.setData(this.mjc);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.mjg != null && this.mjg.boh() != null) {
                TiebaStatic.log(new ar("c12619").dR("obj_locate", "pb").dR("tid", this.mjg.getTid()));
                this.mVideoUrl = this.mjg.boh().video_url;
            }
            this.jnr.fX(this.mVideoUrl, this.mjg == null ? "" : this.mjg.getTid());
            Km("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dtB() {
        if (this.jnr != null) {
            this.jnr.dtB();
        }
    }

    public void destroy() {
        if (this.jnr != null) {
            this.jnr.destroy();
        }
        if (this.mja != null) {
            this.mja.clearAnimation();
        }
        if (this.mje != null) {
            this.mje.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PM);
        MessageManager.getInstance().unRegisterListener(this.jhX);
    }

    public void onPause() {
        if (this.jnr != null) {
            if (this.jnr.rl()) {
                this.mjj = true;
                this.jnr.stopPlay();
            } else if (this.jnr.getCurrentState() == 3) {
                this.mjj = false;
            } else if (this.jnr.getCurrentState() == 0 || this.jnr.getCurrentState() == 1) {
                this.mjj = true;
                this.jnr.stopPlay();
            } else {
                this.mjj = false;
                this.jnr.stopPlay();
            }
            if (this.mjy != null) {
                this.mjy.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jnr != null && this.mjj) {
            this.jnr.dzC();
        }
    }

    private void dtC() {
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.g.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(g.this.lMX.getActivity());
                    if (g.this.mjB == null) {
                        try {
                            g.this.mjB = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(g.this.mjB);
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
                    g.this.mjA = null;
                    if (g.this.mjB != null && !g.this.mjB.isRecycled()) {
                        g.this.mjB.recycle();
                    }
                    g.this.mjB = null;
                }
            });
            this.mjA = dVar.lF();
            this.mjA.showOnDecorView(this.lMX.getActivity());
        }
    }

    public boolean zf(int i) {
        if (this.jnr == null) {
            return false;
        }
        return this.jnr.Hl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(String str) {
        if (this.mjc != null) {
            if ("1".equals(str) || "2".equals(str)) {
                h.a(this.mjc.video_md5, "", str, this.mjd, this.jnr.getVideoView().getPcdnState());
            }
        }
    }

    public void dtD() {
        if (this.miZ != null) {
            this.miZ.wa(this.lMX.dmi());
        }
    }

    public void dsq() {
        if (this.miZ != null) {
            this.miZ.dsq();
        }
    }

    public void Gf(int i) {
        if (this.miZ != null) {
            this.miZ.Gf(i);
        }
        if (this.mjy != null) {
            this.mjy.onChangeSkinType(i);
        }
        if (this.mje != null) {
            this.mje.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dtG()) {
                    this.scrollState = i;
                    if (this.scrollState == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.11
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.Gt(g.this.getContainerView().getHeight());
                            }
                        }, 100L);
                    }
                    dtE();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gs(int i) {
        if (getContainerView().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mja.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.mjE = false;
                    if (this.mjq != getContainerView().getHeight()) {
                        this.mja.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lMX.getActivity()), Math.min(this.mjq, getContainerView().getHeight() + i)));
                        this.jnr.dco();
                    }
                } else if (l.getEquipmentWidth(this.lMX.getActivity()) * 0.5625d != getContainerView().getHeight()) {
                    this.mja.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lMX.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lMX.getActivity()) * 0.5625d, getContainerView().getHeight() + i)));
                    this.jnr.dco();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dtH()) {
                int bottom = childAt.getBottom() - getContainerView().getBottom();
                if (childAt.getHeight() == 0 || getContainerView().getHeight() == 0) {
                    bottom = 0;
                }
                Gs(bottom);
            } else {
                Gs((-this.mjq) + 2);
            }
        }
        if (!dtG() && this.mjx) {
            if (this.scrollState == 1) {
                this.mjD = true;
                Gt(getContainerView().getHeight());
            } else if (this.scrollState == 2) {
                this.mjD = true;
                int y = (int) getContainerView().getY();
                if (this.mjm == y) {
                    Gt(getContainerView().getHeight());
                } else {
                    this.mjm = y;
                    Gt(getContainerView().getHeight());
                }
                if (i == 0 && this.mjp) {
                    this.mjp = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.dtB();
                        }
                    }, 100L);
                }
            } else if (this.scrollState == 0) {
                if (this.mjD || !"nani_midpage".equals(this.lMX.dnh())) {
                    Gt(getContainerView().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(int i) {
        Gu(i);
        dtE();
    }

    public void vL(boolean z) {
        this.mjE = z;
    }

    private void Gu(int i) {
        if (this.mje != null) {
            if (this.mjg != null && this.mjg.bmz()) {
                this.mje.dtz().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.mjq;
            }
            float f = this.mjq - i;
            float f2 = f > this.mjn ? 0.0f : 1.0f - (f / this.mjn);
            if (this.mjE) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.mje.dtz().setVisibility(8);
            } else {
                this.mje.dtz().setVisibility(0);
            }
            this.mje.aU(f2);
        }
    }

    public void dtE() {
        if (this.mje != null) {
            if (dtG()) {
                this.lMX.dnk().drm();
            } else if (this.mje.dtz().getVisibility() == 0) {
                this.lMX.dnk().drm();
                this.mjf = true;
            } else if (this.mjf) {
                this.lMX.dnk().vK(false);
                this.mjf = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtF() {
        return getContainerView().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mjl = false;
        if (this.jnr != null && this.mja != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mja.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jMw != null && this.jMw.isShowing()) {
                    this.jMw.abs();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.mjA != null) {
                    this.mjA.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.mjl = true;
                this.mja.setLayoutParams(layoutParams);
                this.lMX.dnk().drm();
                this.mjf = true;
            } else {
                f(this.mjc);
                dtD();
                this.mjl = false;
                this.miZ.vZ(true);
            }
            this.jnr.a(this.lMX.getPageContext(), configuration);
        }
    }

    public boolean dtG() {
        return this.mjl;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.mje != null) {
            this.mje.X(onClickListener);
        }
    }

    public View getContainerView() {
        return this.miY;
    }

    public boolean drv() {
        if (getContainerView() == null) {
            return false;
        }
        return getContainerView().getBottom() > l.getEquipmentHeight(getContainerView().getContext()) - l.getDimens(getContainerView().getContext(), R.dimen.ds50);
    }

    public void drT() {
        this.mjp = true;
    }

    public View dtH() {
        return this.mEmptyView;
    }
}
