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
    private static VideoControllerView.a lfH = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.g.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bLL() {
        }
    };
    private static c.i mjW = new c.i() { // from class: com.baidu.tieba.pb.video.g.10
        @Override // com.baidu.tieba.play.c.i
        public void cFy() {
        }
    };
    private boolean agu;
    private com.baidu.mcn.c jMK;
    private com.baidu.tieba.play.c jnF;
    private PbFragment lNm;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private float mjC;
    private int mjF;
    private double mjG;
    private long mjH;
    private PbVideoWifiTipLayout mjI;
    private int mjJ;
    private c.d mjL;
    private PbFullScreenFloatingHuajiAninationView mjN;
    private com.baidu.adp.lib.guide.c mjP;
    private Bitmap mjQ;
    private boolean mjR;
    private boolean mjT;
    private int mjV;
    private RelativeLayout mjn;
    private com.baidu.tieba.pb.pb.main.view.c mjo;
    private CustomFrameLayout mjp;
    private c.d mjq;
    private o mjs;
    private e mjt;
    private boolean mju;
    private cb mjv;
    private cb mjw;
    private String mjx;
    private String mVideoUrl = null;
    private VideoInfo mjr = null;
    private boolean mjy = false;
    private int mjz = 0;
    private boolean mjA = false;
    private int scrollState = 0;
    private int mjB = 0;
    private boolean mjD = false;
    private boolean mjE = false;
    private long startPosition = -1;
    private int iNx = 0;
    private c.p mjK = new c.p() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // com.baidu.tieba.play.c.p
        public void cMQ() {
            if (g.this.lNm != null && g.this.lNm.dmx() != null && g.this.lNm.dmx().getPbData() != null) {
                PostData dlp = g.this.lNm.dmx().getPbData().dlp();
                if (dlp == null && y.getCount(g.this.lNm.dmx().getPbData().dli()) > 1) {
                    dlp = (PostData) y.getItem(g.this.lNm.dmx().getPbData().dli(), 0);
                }
                com.baidu.tieba.pb.c.a.a(g.this.lNm.dmx().getPbData(), dlp, 1, 1, 4);
            }
        }
    };
    private boolean mjM = true;
    private PbFullScreenFloatingHuajiAninationView.a mjO = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.g.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            g.this.wj(false);
        }
    };
    private boolean mjS = false;
    private c.m mjU = new c.m() { // from class: com.baidu.tieba.pb.video.g.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dtQ() {
            if (g.this.mjG >= 1.0d) {
                if (g.this.lNm.checkUpIsLogin()) {
                    g.this.lNm.doc();
                    if (g.this.lNm.dmx() == null || g.this.lNm.dmx().getPbData() == null || g.this.lNm.dmx().getPbData().dlF() == null) {
                        return false;
                    }
                    p dlF = g.this.lNm.dmx().getPbData().dlF();
                    if (g.this.mjN == null) {
                        g.this.mjN = new PbFullScreenFloatingHuajiAninationView(g.this.lNm.getActivity());
                        g.this.mjN.setFloatingHuajiAninationListener(g.this.mjO);
                    }
                    g.this.mjN.wA(dlF.dma() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dtR() {
            return false;
        }
    };
    private CustomMessageListener PM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.g.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (g.this.jnF != null) {
                    g.this.jnF.setNetworkChange();
                }
                if (j.isMobileNet() && g.this.jnF != null && g.this.jnF.rl() && g.this.mjr != null && g.this.mjr.video_length.intValue() > 0 && g.this.mjr.video_duration.intValue() > 0) {
                    float intValue = g.this.mjr.video_length.intValue() * (1.0f - ((g.this.jnF.getCurrentPosition() * 1.0f) / (g.this.mjr.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(g.this.lNm.getPageContext().getPageActivity(), String.format(g.this.lNm.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener ldJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.g.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.dsx();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener jim = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.mjr != null) {
                g.this.f(g.this.mjr);
                g.this.jnF.dzX();
                g.this.jnF.dcv();
                if (g.this.mEmptyView != null && g.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = g.this.mEmptyView.getLayoutParams();
                    layoutParams.height = g.this.mjF;
                    g.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(boolean z) {
        if (this.lNm != null) {
            this.lNm.dnu();
        }
    }

    public g(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.mjC = 0.0f;
        this.lNm = pbFragment;
        this.mjo = cVar;
        this.mjC = l.getDimens(this.lNm.getActivity(), R.dimen.ds240);
        this.mjH = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.PM);
        this.jim.setTag(pbFragment.getUniqueId());
        this.jim.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.jim);
        this.jMK = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.mjp.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lNm.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lNm.getActivity());
        Rect visibilityRegion = bg.getVisibilityRegion(this.lNm.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lNm.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.mjG = (intValue2 * 1.0d) / intValue;
            if (this.mjG > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.mjF = i;
        this.mjp.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean isVertical() {
        return this.mjG >= 1.0d;
    }

    public int dsc() {
        return this.mjF;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.mjn = (RelativeLayout) LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.mjp = (CustomFrameLayout) this.mjn.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.agu = ((double) this.mjF) <= (((double) l.getEquipmentWidth(this.lNm.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jnF = new com.baidu.tieba.play.c(this.lNm.getPageContext(), this.mjp, true);
        this.jnF.setStageType("2002");
        this.jnF.a(this.mjU);
        this.jnF.xn(false);
        this.jnF.a(this.mjK);
        this.jnF.Hi(ap.oA(R.drawable.pic_use_header_40_n));
        this.jnF.a(new c.n() { // from class: com.baidu.tieba.pb.video.g.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                g.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lNm.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lNm.getBaseFragmentActivity())) {
            this.jnF.xd(false);
        }
        this.jnF.a(new c.k() { // from class: com.baidu.tieba.pb.video.g.18
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
                        if (g.this.lNm.getListView() != null && g.this.lNm.getListView().getChildCount() > 0 && g.this.lNm.getListView().getChildAt(0) == g.this.dtO()) {
                            g.this.mjV = g.this.dtO().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        g.this.mLastY = 0.0f;
                        g.this.mjV = 0;
                        break;
                    case 2:
                        if (g.this.lNm.getListView() != null && g.this.lNm.getListView().getChildCount() > 0 && g.this.lNm.getListView().getChildAt(0) == g.this.dtO()) {
                            g.this.lNm.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - g.this.mLastY)) + g.this.mjV);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.mjG >= 1.0d) {
                this.jnF.ax(false, true);
            } else {
                this.jnF.ax(true, false);
            }
            this.mjD = ((float) f) + this.mjC > ((float) l.getEquipmentHeight(this.lNm.getActivity()));
            if (this.mjD) {
                if (this.mjt == null) {
                    this.mjt = new e(this.lNm.getPageContext(), this.mjp);
                }
                this.lNm.dnr().drt();
                this.mju = true;
            }
        }
        dtJ();
        this.mEmptyView = new View(this.lNm.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mjF));
        if (this.mjo != null && this.mjo.mNavigationBar != null) {
            this.mjo.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.mjo.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.mjo.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bsa() && !TbSingleton.getInstance().isNotchScreen(this.lNm.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lNm.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.mjI = (PbVideoWifiTipLayout) this.mjn.findViewById(R.id.layout_wifi_tip);
        this.mjI.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mjR = true;
                g.this.mjI.setVisibility(8);
                g.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jMK != null) {
            this.jMK.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lNm.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.mjq == null) {
            this.mjq = new c.d() { // from class: com.baidu.tieba.pb.video.g.20
                @Override // com.baidu.tieba.play.c.d
                public void qY(boolean z) {
                    if (g.this.dtM() && g.this.mjo != null) {
                        loadAnimation.setAnimationListener(null);
                        g.this.mjo.dsp().clearAnimation();
                        g.this.dtK();
                        if (z) {
                            loadAnimation.setAnimationListener(g.this.ldJ);
                            g.this.mjo.dsp().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFx() {
                    if (g.this.dtM()) {
                        g.this.dsx();
                    }
                }
            };
        }
        a(this.mjq);
        this.mjz = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lNm.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final cb cbVar, final String str) {
        if (videoInfo != null && this.jnF != null && cbVar != null) {
            this.mjr = videoInfo;
            this.mjv = cbVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jnF.stopPlay();
            this.mjs = new o();
            this.mjs.mLocate = "pb";
            this.mjs.amC = cbVar.getTid();
            this.mjs.fNd = str;
            this.mjs.mUid = TbadkCoreApplication.getCurrentAccount();
            if (cbVar.isBjh()) {
                if (!StringUtils.isNull(this.lNm.lSv)) {
                    this.mjs.eNE = this.lNm.lSv;
                }
                this.mjs.mIx = this.lNm.lSu + "";
            } else {
                this.mjs.mIx = this.lNm.dno();
            }
            bk doe = this.lNm.doe();
            if (doe != null) {
                doe.a(this.mjs);
            }
            this.mjs.mIA = videoInfo.video_md5;
            o dAo = this.mjs.dAo();
            dAo.mLocate = "6";
            this.startPosition = -1L;
            if (this.jnF.getVideoView() != null && this.jnF.getVideoView().getMediaProgressObserver() != null) {
                this.jnF.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.g.2
                    @Override // com.baidu.tieba.play.f.b
                    public void cf(int i, int i2) {
                        boolean z = true;
                        if (g.this.startPosition <= 0) {
                            g.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean iY = com.baidu.mcn.b.abr().iY(mcnAdInfo.jump_url);
                            if (g.this.agu && !iY && !g.this.mjA) {
                                boolean z2 = g.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!g.this.jMK.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.chJ = mcnAdInfo.card_title;
                                        aVar.chK = mcnAdInfo.button_title;
                                        aVar.chL = mcnAdInfo.jump_url;
                                        aVar.chI = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = cbVar.getTid();
                                        aVar.chM = 4;
                                        if (z2) {
                                            g.this.jMK.b(aVar, (ViewGroup) g.this.jnF.dzW());
                                        } else {
                                            g.this.jMK.a(aVar, (ViewGroup) g.this.jnF.dzW());
                                        }
                                    }
                                } else if (g.this.jMK.isShowing()) {
                                    g.this.jMK.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jnF.getVideoView().setVideoStatData(dAo);
            if (this.jnF.dcx()) {
                this.jnF.dcv();
            }
            this.jnF.b(this.mjL);
            this.mjx = null;
            this.mjw = null;
            this.jnF.Qe(this.mjx);
            this.jnF.dcr().setOnDragingListener(lfH);
            this.jnF.a(new c.InterfaceC0849c() { // from class: com.baidu.tieba.pb.video.g.3
                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rk() {
                    g.this.lNm.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    g.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.mjJ > 0) {
                                g.this.Gs(g.this.mjJ);
                                g.this.Gt(g.this.mjJ);
                                g.this.mjJ = 0;
                            }
                            g.this.mjM = true;
                        }
                    }, 200L);
                    g.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0849c
                public void rj() {
                    g.this.lNm.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    g.this.mjM = false;
                    g.this.mjJ = g.this.getContainerView().getHeight();
                }
            });
            this.jnF.a(new c.h() { // from class: com.baidu.tieba.pb.video.g.4
                @Override // com.baidu.tieba.play.c.h
                public void dtP() {
                    if (g.this.lNm != null && g.this.mjw != null && !StringUtils.isNull(g.this.mjw.getId())) {
                        g.this.lNm.Pt(g.this.mjw.getId());
                    }
                }
            });
            this.jnF.a(new c.j() { // from class: com.baidu.tieba.pb.video.g.5
                @Override // com.baidu.tieba.play.c.j
                public void wk(boolean z) {
                    if (g.this.mjv != null) {
                        g.this.Kn(z ? "1" : "2");
                    }
                }
            });
            this.jnF.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.g.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", g.this.mVideoUrl);
                    return true;
                }
            });
            this.jnF.setThumbnail(videoInfo.thumbnail_url);
            this.jnF.setVideoUrl(this.mVideoUrl, cbVar.getTid());
            this.jnF.setFid(str);
            this.jnF.QD(cbVar.getTitle());
            this.jnF.a(mjW);
            this.jnF.cSK();
            this.jnF.show();
        }
    }

    public void Qd(String str) {
        if (this.mjs != null) {
            this.mjs.fNd = str;
        }
    }

    public void b(PostData postData, cb cbVar, p pVar) {
        if (this.mjt != null) {
            this.mjt.a(postData, cbVar, pVar);
        }
    }

    public void a(c.d dVar) {
        this.mjL = dVar;
    }

    public void aQ(cb cbVar) {
        this.mjw = cbVar;
    }

    public void Qe(String str) {
        this.mjx = str;
        if (this.jnF != null) {
            this.jnF.Qe(this.mjx);
        }
    }

    public void startPlay() {
        if (this.jnF != null) {
            if (j.isMobileNet() && !this.mjR && !com.baidu.tieba.video.f.dSf().dSg()) {
                this.mjI.setVisibility(0);
                this.mjI.setData(this.mjr);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.mjv != null && this.mjv.boh() != null) {
                TiebaStatic.log(new ar("c12619").dR("obj_locate", "pb").dR("tid", this.mjv.getTid()));
                this.mVideoUrl = this.mjv.boh().video_url;
            }
            this.jnF.fX(this.mVideoUrl, this.mjv == null ? "" : this.mjv.getTid());
            Kn("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dtI() {
        if (this.jnF != null) {
            this.jnF.dtI();
        }
    }

    public void destroy() {
        if (this.jnF != null) {
            this.jnF.destroy();
        }
        if (this.mjp != null) {
            this.mjp.clearAnimation();
        }
        if (this.mjt != null) {
            this.mjt.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PM);
        MessageManager.getInstance().unRegisterListener(this.jim);
    }

    public void onPause() {
        if (this.jnF != null) {
            if (this.jnF.rl()) {
                this.mjy = true;
                this.jnF.stopPlay();
            } else if (this.jnF.getCurrentState() == 3) {
                this.mjy = false;
            } else if (this.jnF.getCurrentState() == 0 || this.jnF.getCurrentState() == 1) {
                this.mjy = true;
                this.jnF.stopPlay();
            } else {
                this.mjy = false;
                this.jnF.stopPlay();
            }
            if (this.mjN != null) {
                this.mjN.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jnF != null && this.mjy) {
            this.jnF.dzJ();
        }
    }

    private void dtJ() {
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.g.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(g.this.lNm.getActivity());
                    if (g.this.mjQ == null) {
                        try {
                            g.this.mjQ = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(g.this.mjQ);
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
                    g.this.mjP = null;
                    if (g.this.mjQ != null && !g.this.mjQ.isRecycled()) {
                        g.this.mjQ.recycle();
                    }
                    g.this.mjQ = null;
                }
            });
            this.mjP = dVar.lF();
            this.mjP.showOnDecorView(this.lNm.getActivity());
        }
    }

    public boolean zf(int i) {
        if (this.jnF == null) {
            return false;
        }
        return this.jnF.Hl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn(String str) {
        if (this.mjr != null) {
            if ("1".equals(str) || "2".equals(str)) {
                h.a(this.mjr.video_md5, "", str, this.mjs, this.jnF.getVideoView().getPcdnState());
            }
        }
    }

    public void dtK() {
        if (this.mjo != null) {
            this.mjo.wa(this.lNm.dmp());
        }
    }

    public void dsx() {
        if (this.mjo != null) {
            this.mjo.dsx();
        }
    }

    public void Gf(int i) {
        if (this.mjo != null) {
            this.mjo.Gf(i);
        }
        if (this.mjN != null) {
            this.mjN.onChangeSkinType(i);
        }
        if (this.mjt != null) {
            this.mjt.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dtN()) {
                    this.scrollState = i;
                    if (this.scrollState == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.11
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.Gt(g.this.getContainerView().getHeight());
                            }
                        }, 100L);
                    }
                    dtL();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gs(int i) {
        if (getContainerView().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mjp.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.mjT = false;
                    if (this.mjF != getContainerView().getHeight()) {
                        this.mjp.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lNm.getActivity()), Math.min(this.mjF, getContainerView().getHeight() + i)));
                        this.jnF.dcv();
                    }
                } else if (l.getEquipmentWidth(this.lNm.getActivity()) * 0.5625d != getContainerView().getHeight()) {
                    this.mjp.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lNm.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lNm.getActivity()) * 0.5625d, getContainerView().getHeight() + i)));
                    this.jnF.dcv();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dtO()) {
                int bottom = childAt.getBottom() - getContainerView().getBottom();
                if (childAt.getHeight() == 0 || getContainerView().getHeight() == 0) {
                    bottom = 0;
                }
                Gs(bottom);
            } else {
                Gs((-this.mjF) + 2);
            }
        }
        if (!dtN() && this.mjM) {
            if (this.scrollState == 1) {
                this.mjS = true;
                Gt(getContainerView().getHeight());
            } else if (this.scrollState == 2) {
                this.mjS = true;
                int y = (int) getContainerView().getY();
                if (this.mjB == y) {
                    Gt(getContainerView().getHeight());
                } else {
                    this.mjB = y;
                    Gt(getContainerView().getHeight());
                }
                if (i == 0 && this.mjE) {
                    this.mjE = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.dtI();
                        }
                    }, 100L);
                }
            } else if (this.scrollState == 0) {
                if (this.mjS || !"nani_midpage".equals(this.lNm.dno())) {
                    Gt(getContainerView().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(int i) {
        Gu(i);
        dtL();
    }

    public void vL(boolean z) {
        this.mjT = z;
    }

    private void Gu(int i) {
        if (this.mjt != null) {
            if (this.mjv != null && this.mjv.bmz()) {
                this.mjt.dtG().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.mjF;
            }
            float f = this.mjF - i;
            float f2 = f > this.mjC ? 0.0f : 1.0f - (f / this.mjC);
            if (this.mjT) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.mjt.dtG().setVisibility(8);
            } else {
                this.mjt.dtG().setVisibility(0);
            }
            this.mjt.aU(f2);
        }
    }

    public void dtL() {
        if (this.mjt != null) {
            if (dtN()) {
                this.lNm.dnr().drt();
            } else if (this.mjt.dtG().getVisibility() == 0) {
                this.lNm.dnr().drt();
                this.mju = true;
            } else if (this.mju) {
                this.lNm.dnr().vK(false);
                this.mju = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtM() {
        return getContainerView().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mjA = false;
        if (this.jnF != null && this.mjp != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mjp.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jMK != null && this.jMK.isShowing()) {
                    this.jMK.abs();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.mjP != null) {
                    this.mjP.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.mjA = true;
                this.mjp.setLayoutParams(layoutParams);
                this.lNm.dnr().drt();
                this.mju = true;
            } else {
                f(this.mjr);
                dtK();
                this.mjA = false;
                this.mjo.vZ(true);
            }
            this.jnF.a(this.lNm.getPageContext(), configuration);
        }
    }

    public boolean dtN() {
        return this.mjA;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.mjt != null) {
            this.mjt.X(onClickListener);
        }
    }

    public View getContainerView() {
        return this.mjn;
    }

    public boolean drC() {
        if (getContainerView() == null) {
            return false;
        }
        return getContainerView().getBottom() > l.getEquipmentHeight(getContainerView().getContext()) - l.getDimens(getContainerView().getContext(), R.dimen.ds50);
    }

    public void dsa() {
        this.mjE = true;
    }

    public View dtO() {
        return this.mEmptyView;
    }
}
