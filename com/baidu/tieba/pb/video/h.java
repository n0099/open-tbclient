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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes22.dex */
public class h {
    private static VideoControllerView.a kWp = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bMI() {
        }
    };
    private static c.i lZS = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cFb() {
        }
    };
    private boolean agX;
    private com.baidu.tieba.play.c jac;
    private com.baidu.mcn.c jyX;
    private PbFragment lDG;
    private int lZB;
    private double lZC;
    private long lZD;
    private PbVideoWifiTipLayout lZE;
    private int lZF;
    private c.d lZH;
    private PbFullScreenFloatingHuajiAninationView lZJ;
    private com.baidu.adp.lib.guide.c lZL;
    private Bitmap lZM;
    private boolean lZN;
    private boolean lZP;
    private int lZR;
    private RelativeLayout lZi;
    private com.baidu.tieba.pb.pb.main.view.c lZj;
    private CustomFrameLayout lZk;
    private c.d lZl;
    private o lZn;
    private f lZo;
    private boolean lZp;
    private by lZq;
    private by lZr;
    private String lZs;
    private float lZy;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo lZm = null;
    private boolean lZt = false;
    private int lZu = 0;
    private boolean lZv = false;
    private int lZw = 0;
    private int lZx = 0;
    private boolean lZz = false;
    private boolean lZA = false;
    private long startPosition = -1;
    private int izT = 0;
    private c.p lZG = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void dvv() {
            if (h.this.lDG != null && h.this.lDG.dok() != null && h.this.lDG.dok().getPbData() != null) {
                PostData dnc = h.this.lDG.dok().getPbData().dnc();
                if (dnc == null && y.getCount(h.this.lDG.dok().getPbData().dmV()) > 1) {
                    dnc = (PostData) y.getItem(h.this.lDG.dok().getPbData().dmV(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.lDG.dok().getPbData(), dnc, 1, 1, 4);
            }
        }
    };
    private boolean lZI = true;
    private PbFullScreenFloatingHuajiAninationView.a lZK = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.vW(false);
        }
    };
    private boolean lZO = false;
    private c.m lZQ = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dvx() {
            if (h.this.lZC >= 1.0d) {
                if (h.this.lDG.checkUpIsLogin()) {
                    h.this.lDG.dpL();
                    if (h.this.lDG.dok() == null || h.this.lDG.dok().getPbData() == null || h.this.lDG.dok().getPbData().dnt() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dnt = h.this.lDG.dok().getPbData().dnt();
                    if (h.this.lZJ == null) {
                        h.this.lZJ = new PbFullScreenFloatingHuajiAninationView(h.this.lDG.getActivity());
                        h.this.lZJ.setFloatingHuajiAninationListener(h.this.lZK);
                    }
                    h.this.lZJ.wm(dnt.dnO() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dvy() {
            return false;
        }
    };
    private CustomMessageListener PN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.jac != null) {
                    h.this.jac.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.jac != null && h.this.jac.rM() && h.this.lZm != null && h.this.lZm.video_length.intValue() > 0 && h.this.lZm.video_duration.intValue() > 0) {
                    float intValue = h.this.lZm.video_length.intValue() * (1.0f - ((h.this.jac.getCurrentPosition() * 1.0f) / (h.this.lZm.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.lDG.getPageContext().getPageActivity(), String.format(h.this.lDG.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kUs = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.dud();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.lZm != null) {
                h.this.f(h.this.lZm);
                h.this.jac.dBI();
                h.this.jac.dev();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.lZB;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(boolean z) {
        if (this.lDG != null) {
            this.lDG.dpd();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.lZy = 0.0f;
        this.lDG = pbFragment;
        this.lZj = cVar;
        this.lZy = l.getDimens(this.lDG.getActivity(), R.dimen.ds240);
        this.lZD = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.PN);
        this.iUK.setTag(pbFragment.getUniqueId());
        this.iUK.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iUK);
        this.jyX = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lZk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lDG.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lDG.getActivity());
        Rect visibilityRegion = bg.getVisibilityRegion(this.lDG.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lDG.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.lZC = (intValue2 * 1.0d) / intValue;
            if (this.lZC > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.lZB = i;
        this.lZk.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean caj() {
        return this.lZC >= 1.0d;
    }

    public int dtI() {
        return this.lZB;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lZi = (RelativeLayout) LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lZk = (CustomFrameLayout) this.lZi.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.agX = ((double) this.lZB) <= (((double) l.getEquipmentWidth(this.lDG.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jac = new com.baidu.tieba.play.c(this.lDG.getPageContext(), this.lZk, true);
        this.jac.setStageType("2002");
        this.jac.a(this.lZQ);
        this.jac.wY(false);
        this.jac.a(this.lZG);
        this.jac.ID(ap.pS(R.drawable.pic_use_header_40_n));
        this.jac.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lDG.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lDG.getBaseFragmentActivity())) {
            this.jac.wP(false);
        }
        this.jac.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.mLastY = motionEvent.getY();
                        if (h.this.lDG.getListView() != null && h.this.lDG.getListView().getChildCount() > 0 && h.this.lDG.getListView().getChildAt(0) == h.this.dvu()) {
                            h.this.lZR = h.this.dvu().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.lZR = 0;
                        break;
                    case 2:
                        if (h.this.lDG.getListView() != null && h.this.lDG.getListView().getChildCount() > 0 && h.this.lDG.getListView().getChildAt(0) == h.this.dvu()) {
                            h.this.lDG.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.lZR);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.lZC >= 1.0d) {
                this.jac.av(false, true);
            } else {
                this.jac.av(true, false);
            }
            this.lZz = ((float) f) + this.lZy > ((float) l.getEquipmentHeight(this.lDG.getActivity()));
            if (this.lZz) {
                if (this.lZo == null) {
                    this.lZo = new f(this.lDG.getPageContext(), this.lZk);
                }
                this.lDG.dpb().dta();
                this.lZp = true;
            }
        }
        dvp();
        this.mEmptyView = new View(this.lDG.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.lZB));
        if (this.lZj != null && this.lZj.mNavigationBar != null) {
            this.lZj.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lZj.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lZj.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bsY() && !TbSingleton.getInstance().isNotchScreen(this.lDG.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lDG.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.lZE = (PbVideoWifiTipLayout) this.lZi.findViewById(R.id.layout_wifi_tip);
        this.lZE.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.lZN = true;
                h.this.lZE.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jyX != null) {
            this.jyX.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lDG.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lZl == null) {
            this.lZl = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void qu(boolean z) {
                    if (h.this.dvs() && h.this.lZj != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.lZj.dtV().clearAnimation();
                        h.this.dvq();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.kUs);
                            h.this.lZj.dtV().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFa() {
                    if (h.this.dvs()) {
                        h.this.dud();
                    }
                }
            };
        }
        a(this.lZl);
        this.lZu = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lDG.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final by byVar, final String str) {
        if (videoInfo != null && this.jac != null && byVar != null) {
            this.lZm = videoInfo;
            this.lZq = byVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jac.stopPlay();
            this.lZn = new o();
            this.lZn.mLocate = "pb";
            this.lZn.amY = byVar.getTid();
            this.lZn.fFV = str;
            this.lZn.mUid = TbadkCoreApplication.getCurrentAccount();
            if (byVar.isBjh()) {
                if (!StringUtils.isNull(this.lDG.lIx)) {
                    this.lZn.eGn = this.lDG.lIx;
                }
                this.lZn.myq = this.lDG.lIw + "";
            } else {
                this.lZn.myq = this.lDG.doY();
            }
            bh dpN = this.lDG.dpN();
            if (dpN != null) {
                dpN.a(this.lZn);
            }
            this.lZn.myt = videoInfo.video_md5;
            o dCa = this.lZn.dCa();
            dCa.mLocate = "6";
            this.startPosition = -1L;
            if (this.jac.getVideoView() != null && this.jac.getVideoView().getMediaProgressObserver() != null) {
                this.jac.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ci(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean jK = com.baidu.mcn.b.abJ().jK(mcnAdInfo.jump_url);
                            if (h.this.agX && !jK && !h.this.lZv) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.jyX.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.cbD = mcnAdInfo.card_title;
                                        aVar.cbE = mcnAdInfo.button_title;
                                        aVar.cbF = mcnAdInfo.jump_url;
                                        aVar.cbC = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = byVar.getTid();
                                        aVar.cbG = 4;
                                        if (z2) {
                                            h.this.jyX.b(aVar, (ViewGroup) h.this.jac.dBH());
                                        } else {
                                            h.this.jyX.a(aVar, (ViewGroup) h.this.jac.dBH());
                                        }
                                    }
                                } else if (h.this.jyX.isShowing()) {
                                    h.this.jyX.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jac.getVideoView().setVideoStatData(dCa);
            if (this.jac.dex()) {
                this.jac.dev();
            }
            this.jac.b(this.lZH);
            this.lZs = null;
            this.lZr = null;
            this.jac.QO(this.lZs);
            this.jac.der().setOnDragingListener(kWp);
            this.jac.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                    h.this.lDG.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.lZF > 0) {
                                h.this.HM(h.this.lZF);
                                h.this.HN(h.this.lZF);
                                h.this.lZF = 0;
                            }
                            h.this.lZI = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                    h.this.lDG.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.lZI = false;
                    h.this.lZF = h.this.bSs().getHeight();
                }
            });
            this.jac.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dvw() {
                    if (h.this.lDG != null && h.this.lZr != null && !StringUtils.isNull(h.this.lZr.getId())) {
                        h.this.lDG.Qd(h.this.lZr.getId());
                    }
                }
            });
            this.jac.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void vX(boolean z) {
                    if (h.this.lZq != null) {
                        h.this.KN(z ? "1" : "2");
                    }
                }
            });
            this.jac.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.jac.setThumbnail(videoInfo.thumbnail_url);
            this.jac.setVideoUrl(this.mVideoUrl, byVar.getTid());
            this.jac.setFid(str);
            this.jac.Rn(byVar.getTitle());
            this.jac.a(lZS);
            this.jac.cRo();
            this.jac.show();
        }
    }

    public void QN(String str) {
        if (this.lZn != null) {
            this.lZn.fFV = str;
        }
    }

    public void b(PostData postData, by byVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lZo != null) {
            this.lZo.a(postData, byVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.lZH = dVar;
    }

    public void aO(by byVar) {
        this.lZr = byVar;
    }

    public void QO(String str) {
        this.lZs = str;
        if (this.jac != null) {
            this.jac.QO(this.lZs);
        }
    }

    public void startPlay() {
        if (this.jac != null) {
            if (j.isMobileNet() && !this.lZN && !com.baidu.tieba.video.g.dTL().dTM()) {
                this.lZE.setVisibility(0);
                this.lZE.setData(this.lZm);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lZq != null && this.lZq.bph() != null) {
                TiebaStatic.log(new ar("c12619").dY("obj_locate", "pb").dY("tid", this.lZq.getTid()));
                this.mVideoUrl = this.lZq.bph().video_url;
            }
            this.jac.gb(this.mVideoUrl, this.lZq == null ? "" : this.lZq.getTid());
            KN("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dvo() {
        if (this.jac != null) {
            this.jac.dvo();
        }
    }

    public void destroy() {
        if (this.jac != null) {
            this.jac.destroy();
        }
        if (this.lZk != null) {
            this.lZk.clearAnimation();
        }
        if (this.lZo != null) {
            this.lZo.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PN);
        MessageManager.getInstance().unRegisterListener(this.iUK);
    }

    public void onPause() {
        if (this.jac != null) {
            if (this.jac.rM()) {
                this.lZt = true;
                this.jac.stopPlay();
            } else if (this.jac.getCurrentState() == 3) {
                this.lZt = false;
            } else if (this.jac.getCurrentState() == 0 || this.jac.getCurrentState() == 1) {
                this.lZt = true;
                this.jac.stopPlay();
            } else {
                this.lZt = false;
                this.jac.stopPlay();
            }
            if (this.lZJ != null) {
                this.lZJ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jac != null && this.lZt) {
            this.jac.dBu();
        }
    }

    private void dvp() {
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ac(true);
            dVar.ae(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ad(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.lDG.getActivity());
                    if (h.this.lZM == null) {
                        try {
                            h.this.lZM = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.lZM);
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
                    h.this.lZL = null;
                    if (h.this.lZM != null && !h.this.lZM.isRecycled()) {
                        h.this.lZM.recycle();
                    }
                    h.this.lZM = null;
                }
            });
            this.lZL = dVar.mi();
            this.lZL.showOnDecorView(this.lDG.getActivity());
        }
    }

    public boolean Ap(int i) {
        if (this.jac == null) {
            return false;
        }
        return this.jac.IF(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN(String str) {
        if (this.lZm != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.lZm.video_md5, "", str, this.lZn, this.jac.getVideoView().getPcdnState());
            }
        }
    }

    public void dvq() {
        if (this.lZj != null) {
            this.lZj.vN(this.lDG.doc());
        }
    }

    public void dud() {
        if (this.lZj != null) {
            this.lZj.dud();
        }
    }

    public void Hz(int i) {
        if (this.lZj != null) {
            this.lZj.Hz(i);
        }
        if (this.lZJ != null) {
            this.lZJ.onChangeSkinType(i);
        }
        if (this.lZo != null) {
            this.lZo.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dvt()) {
                    this.lZw = i;
                    if (this.lZw == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.HN(h.this.bSs().getHeight());
                            }
                        }, 100L);
                    }
                    dvr();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM(int i) {
        if (bSs().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZk.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.lZP = false;
                    if (this.lZB != bSs().getHeight()) {
                        this.lZk.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lDG.getActivity()), Math.min(this.lZB, bSs().getHeight() + i)));
                        this.jac.dev();
                    }
                } else if (l.getEquipmentWidth(this.lDG.getActivity()) * 0.5625d != bSs().getHeight()) {
                    this.lZk.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lDG.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lDG.getActivity()) * 0.5625d, bSs().getHeight() + i)));
                    this.jac.dev();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dvu()) {
                int bottom = childAt.getBottom() - bSs().getBottom();
                if (childAt.getHeight() == 0 || bSs().getHeight() == 0) {
                    bottom = 0;
                }
                HM(bottom);
            } else {
                HM((-this.lZB) + 2);
            }
        }
        if (!dvt() && this.lZI) {
            if (this.lZw == 1) {
                this.lZO = true;
                HN(bSs().getHeight());
            } else if (this.lZw == 2) {
                this.lZO = true;
                int y = (int) bSs().getY();
                if (this.lZx == y) {
                    HN(bSs().getHeight());
                } else {
                    this.lZx = y;
                    HN(bSs().getHeight());
                }
                if (i == 0 && this.lZA) {
                    this.lZA = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dvo();
                        }
                    }, 100L);
                }
            } else if (this.lZw == 0) {
                if (this.lZO || !"nani_midpage".equals(this.lDG.doY())) {
                    HN(bSs().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN(int i) {
        HO(i);
        dvr();
    }

    public void vz(boolean z) {
        this.lZP = z;
    }

    private void HO(int i) {
        if (this.lZo != null) {
            if (this.lZq != null && this.lZq.bnz()) {
                this.lZo.dvm().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.lZB;
            }
            float f = this.lZB - i;
            float f2 = f > this.lZy ? 0.0f : 1.0f - (f / this.lZy);
            if (this.lZP) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lZo.dvm().setVisibility(8);
            } else {
                this.lZo.dvm().setVisibility(0);
            }
            this.lZo.aP(f2);
        }
    }

    public void dvr() {
        if (this.lZo != null) {
            if (dvt()) {
                this.lDG.dpb().dta();
            } else if (this.lZo.dvm().getVisibility() == 0) {
                this.lDG.dpb().dta();
                this.lZp = true;
            } else if (this.lZp) {
                this.lDG.dpb().vy(false);
                this.lZp = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvs() {
        return bSs().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.lZv = false;
        if (this.jac != null && this.lZk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZk.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jyX != null && this.jyX.isShowing()) {
                    this.jyX.abK();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.lZL != null) {
                    this.lZL.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.lZv = true;
                this.lZk.setLayoutParams(layoutParams);
                this.lDG.dpb().dta();
                this.lZp = true;
            } else {
                f(this.lZm);
                dvq();
                this.lZv = false;
                this.lZj.vM(true);
            }
            this.jac.a(this.lDG.getPageContext(), configuration);
        }
    }

    public boolean dvt() {
        return this.lZv;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lZo != null) {
            this.lZo.V(onClickListener);
        }
    }

    public View bSs() {
        return this.lZi;
    }

    public boolean dtj() {
        if (bSs() == null) {
            return false;
        }
        return bSs().getBottom() > l.getEquipmentHeight(bSs().getContext()) - l.getDimens(bSs().getContext(), R.dimen.ds50);
    }

    public void dtG() {
        this.lZA = true;
    }

    public View dvu() {
        return this.mEmptyView;
    }
}
