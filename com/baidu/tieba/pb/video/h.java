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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes16.dex */
public class h {
    private static VideoControllerView.a jSA = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bBr() {
        }
    };
    private static c.i kVm = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void coQ() {
        }
    };
    private boolean afi;
    private com.baidu.tieba.play.c iad;
    private com.baidu.mcn.c iwe;
    private RelativeLayout kUC;
    private com.baidu.tieba.pb.pb.main.view.c kUD;
    private CustomFrameLayout kUE;
    private c.d kUF;
    private o kUH;
    private f kUI;
    private boolean kUJ;
    private bw kUK;
    private bw kUL;
    private String kUM;
    private float kUS;
    private int kUV;
    private double kUW;
    private long kUX;
    private PbVideoWifiTipLayout kUY;
    private int kUZ;
    private c.d kVb;
    private PbFullScreenFloatingHuajiAninationView kVd;
    private com.baidu.adp.lib.guide.c kVf;
    private Bitmap kVg;
    private boolean kVh;
    private boolean kVj;
    private int kVl;
    private PbFragment kzA;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo kUG = null;
    private boolean kUN = false;
    private int kUO = 0;
    private boolean kUP = false;
    private int kUQ = 0;
    private int kUR = 0;
    private boolean kUT = false;
    private boolean kUU = false;
    private long startPosition = -1;
    private int hzR = 0;
    private c.p kVa = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void ddF() {
            if (h.this.kzA != null && h.this.kzA.cWE() != null && h.this.kzA.cWE().getPbData() != null) {
                PostData cVv = h.this.kzA.cWE().getPbData().cVv();
                if (cVv == null && y.getCount(h.this.kzA.cWE().getPbData().cVo()) > 1) {
                    cVv = (PostData) y.getItem(h.this.kzA.cWE().getPbData().cVo(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kzA.cWE().getPbData(), cVv, 1, 1, 4);
            }
        }
    };
    private boolean kVc = true;
    private PbFullScreenFloatingHuajiAninationView.a kVe = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.ub(false);
        }
    };
    private boolean kVi = false;
    private c.m kVk = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean ddH() {
            if (h.this.kUW >= 1.0d) {
                if (h.this.kzA.checkUpIsLogin()) {
                    h.this.kzA.cYe();
                    if (h.this.kzA.cWE() == null || h.this.kzA.cWE().getPbData() == null || h.this.kzA.cWE().getPbData().cVL() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o cVL = h.this.kzA.cWE().getPbData().cVL();
                    if (h.this.kVd == null) {
                        h.this.kVd = new PbFullScreenFloatingHuajiAninationView(h.this.kzA.getActivity());
                        h.this.kVd.setFloatingHuajiAninationListener(h.this.kVe);
                    }
                    h.this.kVd.uq(cVL.cWf() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean ddI() {
            return false;
        }
    };
    private CustomMessageListener Oe = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.iad != null) {
                    h.this.iad.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.iad != null && h.this.iad.rF() && h.this.kUG != null && h.this.kUG.video_length.intValue() > 0 && h.this.kUG.video_duration.intValue() > 0) {
                    float intValue = h.this.kUG.video_length.intValue() * (1.0f - ((h.this.iad.getCurrentPosition() * 1.0f) / (h.this.kUG.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kzA.getPageContext().getPageActivity(), String.format(h.this.kzA.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jQC = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.dcp();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener hUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.kUG != null) {
                h.this.f(h.this.kUG);
                h.this.iad.djQ();
                h.this.iad.cMR();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kUV;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(boolean z) {
        if (this.kzA != null) {
            this.kzA.cXw();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kUS = 0.0f;
        this.kzA = pbFragment;
        this.kUD = cVar;
        this.kUS = l.getDimens(this.kzA.getActivity(), R.dimen.ds240);
        this.kUX = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Oe);
        this.hUK.setTag(pbFragment.getUniqueId());
        this.hUK.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hUK);
        this.iwe = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kUE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kzA.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kzA.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.kzA.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kzA.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kUW = (intValue2 * 1.0d) / intValue;
            if (this.kUW > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kUV = i;
        this.kUE.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bNf() {
        return this.kUW >= 1.0d;
    }

    public int dbV() {
        return this.kUV;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kUC = (RelativeLayout) LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kUE = (CustomFrameLayout) this.kUC.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afi = ((double) this.kUV) <= (((double) l.getEquipmentWidth(this.kzA.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.iad = new com.baidu.tieba.play.c(this.kzA.getPageContext(), this.kUE, true);
        this.iad.setStageType("2002");
        this.iad.a(this.kVk);
        this.iad.vc(false);
        this.iad.a(this.kVa);
        this.iad.FB(ap.nS(R.drawable.pic_use_header_60_n));
        this.iad.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kzA.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kzA.getBaseFragmentActivity())) {
            this.iad.uT(false);
        }
        this.iad.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.kzA.getListView() != null && h.this.kzA.getListView().getChildCount() > 0 && h.this.kzA.getListView().getChildAt(0) == h.this.ddE()) {
                            h.this.kVl = h.this.ddE().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.kVl = 0;
                        break;
                    case 2:
                        if (h.this.kzA.getListView() != null && h.this.kzA.getListView().getChildCount() > 0 && h.this.kzA.getListView().getChildAt(0) == h.this.ddE()) {
                            h.this.kzA.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.kVl);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kUW >= 1.0d) {
                this.iad.au(false, true);
            } else {
                this.iad.au(true, false);
            }
            this.kUT = ((float) f) + this.kUS > ((float) l.getEquipmentHeight(this.kzA.getActivity()));
            if (this.kUT) {
                if (this.kUI == null) {
                    this.kUI = new f(this.kzA.getPageContext(), this.kUE);
                }
                this.kzA.cXu().dbp();
                this.kUJ = true;
            }
        }
        ddz();
        this.mEmptyView = new View(this.kzA.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kUV));
        if (this.kUD != null && this.kUD.mNavigationBar != null) {
            this.kUD.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kUD.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kUD.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.biu() && !TbSingleton.getInstance().isNotchScreen(this.kzA.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kzA.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kUY = (PbVideoWifiTipLayout) this.kUC.findViewById(R.id.layout_wifi_tip);
        this.kUY.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kVh = true;
                h.this.kUY.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.iwe != null) {
            this.iwe.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kzA.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kUF == null) {
            this.kUF = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void oI(boolean z) {
                    if (h.this.ddC() && h.this.kUD != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kUD.dci().clearAnimation();
                        h.this.ddA();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jQC);
                            h.this.kUD.dci().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void coP() {
                    if (h.this.ddC()) {
                        h.this.dcp();
                    }
                }
            };
        }
        a(this.kUF);
        this.kUO = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kzA.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bw bwVar, final String str) {
        if (videoInfo != null && this.iad != null && bwVar != null) {
            this.kUG = videoInfo;
            this.kUK = bwVar;
            this.mVideoUrl = videoInfo.video_url;
            this.iad.stopPlay();
            this.kUH = new o();
            this.kUH.mLocate = "pb";
            this.kUH.ala = bwVar.getTid();
            this.kUH.eVx = str;
            this.kUH.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.isBjh()) {
                if (!StringUtils.isNull(this.kzA.kEj)) {
                    this.kUH.dYs = this.kzA.kEj;
                }
                this.kUH.ltp = this.kzA.kEi + "";
            } else {
                this.kUH.ltp = this.kzA.cXr();
            }
            com.baidu.tbadk.core.data.bf cYg = this.kzA.cYg();
            if (cYg != null) {
                cYg.a(this.kUH);
            }
            this.kUH.ltt = videoInfo.video_md5;
            o dkh = this.kUH.dkh();
            dkh.mLocate = "6";
            this.startPosition = -1L;
            if (this.iad.getVideoView() != null && this.iad.getVideoView().getMediaProgressObserver() != null) {
                this.iad.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bX(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean hJ = com.baidu.mcn.b.SM().hJ(mcnAdInfo.jump_url);
                            if (h.this.afi && !hJ && !h.this.kUP) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.iwe.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bzU = mcnAdInfo.card_title;
                                        aVar.bzV = mcnAdInfo.button_title;
                                        aVar.bzW = mcnAdInfo.jump_url;
                                        aVar.bzT = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bwVar.getTid();
                                        aVar.bzX = 4;
                                        if (z2) {
                                            h.this.iwe.b(aVar, (ViewGroup) h.this.iad.djP());
                                        } else {
                                            h.this.iwe.a(aVar, (ViewGroup) h.this.iad.djP());
                                        }
                                    }
                                } else if (h.this.iwe.isShowing()) {
                                    h.this.iwe.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.iad.getVideoView().setVideoStatData(dkh);
            if (this.iad.cMT()) {
                this.iad.cMR();
            }
            this.iad.b(this.kVb);
            this.kUM = null;
            this.kUL = null;
            this.iad.Oe(this.kUM);
            this.iad.cMN().setOnDragingListener(jSA);
            this.iad.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                    h.this.kzA.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kUZ > 0) {
                                h.this.EK(h.this.kUZ);
                                h.this.EL(h.this.kUZ);
                                h.this.kUZ = 0;
                            }
                            h.this.kVc = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                    h.this.kzA.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kVc = false;
                    h.this.kUZ = h.this.bGk().getHeight();
                }
            });
            this.iad.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void ddG() {
                    if (h.this.kzA != null && h.this.kUL != null && !StringUtils.isNull(h.this.kUL.getId())) {
                        h.this.kzA.Nu(h.this.kUL.getId());
                    }
                }
            });
            this.iad.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void uc(boolean z) {
                    if (h.this.kUK != null) {
                        h.this.Iv(z ? "1" : "2");
                    }
                }
            });
            this.iad.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.iad.setThumbnail(videoInfo.thumbnail_url);
            this.iad.setVideoUrl(this.mVideoUrl, bwVar.getTid());
            this.iad.setFid(str);
            this.iad.OE(bwVar.getTitle());
            this.iad.a(kVm);
            this.iad.czv();
            this.iad.show();
        }
    }

    public void Od(String str) {
        if (this.kUH != null) {
            this.kUH.eVx = str;
        }
    }

    public void b(PostData postData, bw bwVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.kUI != null) {
            this.kUI.a(postData, bwVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.kVb = dVar;
    }

    public void aL(bw bwVar) {
        this.kUL = bwVar;
    }

    public void Oe(String str) {
        this.kUM = str;
        if (this.iad != null) {
            this.iad.Oe(this.kUM);
        }
    }

    public void startPlay() {
        if (this.iad != null) {
            if (j.isMobileNet() && !this.kVh && !com.baidu.tieba.video.g.dBe().dBf()) {
                this.kUY.setVisibility(0);
                this.kUY.setData(this.kUG);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kUK != null && this.kUK.beW() != null) {
                TiebaStatic.log(new aq("c12619").dD("obj_locate", "pb").dD("tid", this.kUK.getTid()));
                this.mVideoUrl = this.kUK.beW().video_url;
            }
            this.iad.fx(this.mVideoUrl, this.kUK == null ? "" : this.kUK.getTid());
            Iv("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void ddy() {
        if (this.iad != null) {
            this.iad.ddy();
        }
    }

    public void destroy() {
        if (this.iad != null) {
            this.iad.destroy();
        }
        if (this.kUE != null) {
            this.kUE.clearAnimation();
        }
        if (this.kUI != null) {
            this.kUI.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Oe);
        MessageManager.getInstance().unRegisterListener(this.hUK);
    }

    public void onPause() {
        if (this.iad != null) {
            if (this.iad.rF()) {
                this.kUN = true;
                this.iad.stopPlay();
            } else if (this.iad.getCurrentState() == 3) {
                this.kUN = false;
            } else if (this.iad.getCurrentState() == 0 || this.iad.getCurrentState() == 1) {
                this.kUN = true;
                this.iad.stopPlay();
            } else {
                this.kUN = false;
                this.iad.stopPlay();
            }
            if (this.kVd != null) {
                this.kVd.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.iad != null && this.kUN) {
            this.iad.djC();
        }
    }

    private void ddz() {
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.af(true);
            dVar.ah(false);
            dVar.ak(16908290).aj(Opcodes.IFEQ).ag(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.kzA.getActivity());
                    if (h.this.kVg == null) {
                        try {
                            h.this.kVg = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kVg);
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
                    h.this.kVf = null;
                    if (h.this.kVg != null && !h.this.kVg.isRecycled()) {
                        h.this.kVg.recycle();
                    }
                    h.this.kVg = null;
                }
            });
            this.kVf = dVar.md();
            this.kVf.showOnDecorView(this.kzA.getActivity());
        }
    }

    public boolean xB(int i) {
        if (this.iad == null) {
            return false;
        }
        return this.iad.FD(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv(String str) {
        if (this.kUG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.kUG.video_md5, "", str, this.kUH, this.iad.getVideoView().getPcdnState());
            }
        }
    }

    public void ddA() {
        if (this.kUD != null) {
            this.kUD.tT(this.kzA.cWu());
        }
    }

    public void dcp() {
        if (this.kUD != null) {
            this.kUD.dcp();
        }
    }

    public void Ey(int i) {
        if (this.kUD != null) {
            this.kUD.Ey(i);
        }
        if (this.kVd != null) {
            this.kVd.onChangeSkinType(i);
        }
        if (this.kUI != null) {
            this.kUI.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!ddD()) {
                    this.kUQ = i;
                    if (this.kUQ == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.EL(h.this.bGk().getHeight());
                            }
                        }, 100L);
                    }
                    ddB();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EK(int i) {
        if (bGk().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUE.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kVj = false;
                    if (this.kUV != bGk().getHeight()) {
                        this.kUE.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kzA.getActivity()), Math.min(this.kUV, bGk().getHeight() + i)));
                        this.iad.cMR();
                    }
                } else if (l.getEquipmentWidth(this.kzA.getActivity()) * 0.5625d != bGk().getHeight()) {
                    this.kUE.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kzA.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kzA.getActivity()) * 0.5625d, bGk().getHeight() + i)));
                    this.iad.cMR();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == ddE()) {
                int bottom = childAt.getBottom() - bGk().getBottom();
                if (childAt.getHeight() == 0 || bGk().getHeight() == 0) {
                    bottom = 0;
                }
                EK(bottom);
            } else {
                EK((-this.kUV) + 2);
            }
        }
        if (!ddD() && this.kVc) {
            if (this.kUQ == 1) {
                this.kVi = true;
                EL(bGk().getHeight());
            } else if (this.kUQ == 2) {
                this.kVi = true;
                int y = (int) bGk().getY();
                if (this.kUR == y) {
                    EL(bGk().getHeight());
                } else {
                    this.kUR = y;
                    EL(bGk().getHeight());
                }
                if (i == 0 && this.kUU) {
                    this.kUU = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.ddy();
                        }
                    }, 100L);
                }
            } else if (this.kUQ == 0) {
                if (this.kVi || !"nani_midpage".equals(this.kzA.cXr())) {
                    EL(bGk().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EL(int i) {
        EM(i);
        ddB();
    }

    public void tF(boolean z) {
        this.kVj = z;
    }

    private void EM(int i) {
        if (this.kUI != null) {
            if (this.kUK != null && this.kUK.bdo()) {
                this.kUI.ddw().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kUV;
            }
            float f = this.kUV - i;
            float f2 = f > this.kUS ? 0.0f : 1.0f - (f / this.kUS);
            if (this.kVj) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kUI.ddw().setVisibility(8);
            } else {
                this.kUI.ddw().setVisibility(0);
            }
            this.kUI.ax(f2);
        }
    }

    public void ddB() {
        if (this.kUI != null) {
            if (ddD()) {
                this.kzA.cXu().dbp();
            } else if (this.kUI.ddw().getVisibility() == 0) {
                this.kzA.cXu().dbp();
                this.kUJ = true;
            } else if (this.kUJ) {
                this.kzA.cXu().tE(false);
                this.kUJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddC() {
        return bGk().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kUP = false;
        if (this.iad != null && this.kUE != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUE.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.iwe != null && this.iwe.isShowing()) {
                    this.iwe.SN();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kVf != null) {
                    this.kVf.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kUP = true;
                this.kUE.setLayoutParams(layoutParams);
                this.kzA.cXu().dbp();
                this.kUJ = true;
            } else {
                f(this.kUG);
                ddA();
                this.kUP = false;
                this.kUD.tS(true);
            }
            this.iad.a(this.kzA.getPageContext(), configuration);
        }
    }

    public boolean ddD() {
        return this.kUP;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.kUI != null) {
            this.kUI.V(onClickListener);
        }
    }

    public View bGk() {
        return this.kUC;
    }

    public boolean dby() {
        if (bGk() == null) {
            return false;
        }
        return bGk().getBottom() > l.getEquipmentHeight(bGk().getContext()) - l.getDimens(bGk().getContext(), R.dimen.ds50);
    }

    public void dbT() {
        this.kUU = true;
    }

    public View ddE() {
        return this.mEmptyView;
    }
}
