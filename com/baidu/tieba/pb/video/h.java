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
    private static VideoControllerView.a jSu = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bBq() {
        }
    };
    private static c.i kVf = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void coP() {
        }
    };
    private boolean afg;
    private com.baidu.tieba.play.c hZX;
    private com.baidu.mcn.c ivY;
    private o kUA;
    private f kUB;
    private boolean kUC;
    private bw kUD;
    private bw kUE;
    private String kUF;
    private float kUL;
    private int kUO;
    private double kUP;
    private long kUQ;
    private PbVideoWifiTipLayout kUR;
    private int kUS;
    private c.d kUU;
    private PbFullScreenFloatingHuajiAninationView kUW;
    private com.baidu.adp.lib.guide.c kUY;
    private Bitmap kUZ;
    private RelativeLayout kUv;
    private com.baidu.tieba.pb.pb.main.view.c kUw;
    private CustomFrameLayout kUx;
    private c.d kUy;
    private boolean kVa;
    private boolean kVc;
    private int kVe;
    private PbFragment kzt;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo kUz = null;
    private boolean kUG = false;
    private int kUH = 0;
    private boolean kUI = false;
    private int kUJ = 0;
    private int kUK = 0;
    private boolean kUM = false;
    private boolean kUN = false;
    private long startPosition = -1;
    private int hzL = 0;
    private c.p kUT = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void ddE() {
            if (h.this.kzt != null && h.this.kzt.cWD() != null && h.this.kzt.cWD().getPbData() != null) {
                PostData cVu = h.this.kzt.cWD().getPbData().cVu();
                if (cVu == null && y.getCount(h.this.kzt.cWD().getPbData().cVn()) > 1) {
                    cVu = (PostData) y.getItem(h.this.kzt.cWD().getPbData().cVn(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kzt.cWD().getPbData(), cVu, 1, 1, 4);
            }
        }
    };
    private boolean kUV = true;
    private PbFullScreenFloatingHuajiAninationView.a kUX = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.tZ(false);
        }
    };
    private boolean kVb = false;
    private c.m kVd = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean ddG() {
            if (h.this.kUP >= 1.0d) {
                if (h.this.kzt.checkUpIsLogin()) {
                    h.this.kzt.cYd();
                    if (h.this.kzt.cWD() == null || h.this.kzt.cWD().getPbData() == null || h.this.kzt.cWD().getPbData().cVK() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o cVK = h.this.kzt.cWD().getPbData().cVK();
                    if (h.this.kUW == null) {
                        h.this.kUW = new PbFullScreenFloatingHuajiAninationView(h.this.kzt.getActivity());
                        h.this.kUW.setFloatingHuajiAninationListener(h.this.kUX);
                    }
                    h.this.kUW.uo(cVK.cWe() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean ddH() {
            return false;
        }
    };
    private CustomMessageListener Oe = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hZX != null) {
                    h.this.hZX.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hZX != null && h.this.hZX.rF() && h.this.kUz != null && h.this.kUz.video_length.intValue() > 0 && h.this.kUz.video_duration.intValue() > 0) {
                    float intValue = h.this.kUz.video_length.intValue() * (1.0f - ((h.this.hZX.getCurrentPosition() * 1.0f) / (h.this.kUz.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kzt.getPageContext().getPageActivity(), String.format(h.this.kzt.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jQw = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.dco();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.kUz != null) {
                h.this.f(h.this.kUz);
                h.this.hZX.djN();
                h.this.hZX.cMQ();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kUO;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(boolean z) {
        if (this.kzt != null) {
            this.kzt.cXv();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kUL = 0.0f;
        this.kzt = pbFragment;
        this.kUw = cVar;
        this.kUL = l.getDimens(this.kzt.getActivity(), R.dimen.ds240);
        this.kUQ = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Oe);
        this.hUE.setTag(pbFragment.getUniqueId());
        this.hUE.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hUE);
        this.ivY = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kUx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kzt.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kzt.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.kzt.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kzt.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kUP = (intValue2 * 1.0d) / intValue;
            if (this.kUP > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kUO = i;
        this.kUx.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bNe() {
        return this.kUP >= 1.0d;
    }

    public int dbU() {
        return this.kUO;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kUv = (RelativeLayout) LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kUx = (CustomFrameLayout) this.kUv.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afg = ((double) this.kUO) <= (((double) l.getEquipmentWidth(this.kzt.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hZX = new com.baidu.tieba.play.c(this.kzt.getPageContext(), this.kUx, true);
        this.hZX.setStageType("2002");
        this.hZX.a(this.kVd);
        this.hZX.va(false);
        this.hZX.a(this.kUT);
        this.hZX.FB(ap.nS(R.drawable.pic_use_header_60_n));
        this.hZX.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kzt.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kzt.getBaseFragmentActivity())) {
            this.hZX.uR(false);
        }
        this.hZX.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.kzt.getListView() != null && h.this.kzt.getListView().getChildCount() > 0 && h.this.kzt.getListView().getChildAt(0) == h.this.ddD()) {
                            h.this.kVe = h.this.ddD().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.kVe = 0;
                        break;
                    case 2:
                        if (h.this.kzt.getListView() != null && h.this.kzt.getListView().getChildCount() > 0 && h.this.kzt.getListView().getChildAt(0) == h.this.ddD()) {
                            h.this.kzt.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.kVe);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kUP >= 1.0d) {
                this.hZX.au(false, true);
            } else {
                this.hZX.au(true, false);
            }
            this.kUM = ((float) f) + this.kUL > ((float) l.getEquipmentHeight(this.kzt.getActivity()));
            if (this.kUM) {
                if (this.kUB == null) {
                    this.kUB = new f(this.kzt.getPageContext(), this.kUx);
                }
                this.kzt.cXt().dbo();
                this.kUC = true;
            }
        }
        ddy();
        this.mEmptyView = new View(this.kzt.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kUO));
        if (this.kUw != null && this.kUw.mNavigationBar != null) {
            this.kUw.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kUw.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kUw.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.biu() && !TbSingleton.getInstance().isNotchScreen(this.kzt.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kzt.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kUR = (PbVideoWifiTipLayout) this.kUv.findViewById(R.id.layout_wifi_tip);
        this.kUR.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kVa = true;
                h.this.kUR.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.ivY != null) {
            this.ivY.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kzt.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kUy == null) {
            this.kUy = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void oG(boolean z) {
                    if (h.this.ddB() && h.this.kUw != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kUw.dch().clearAnimation();
                        h.this.ddz();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jQw);
                            h.this.kUw.dch().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void coO() {
                    if (h.this.ddB()) {
                        h.this.dco();
                    }
                }
            };
        }
        a(this.kUy);
        this.kUH = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kzt.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bw bwVar, final String str) {
        if (videoInfo != null && this.hZX != null && bwVar != null) {
            this.kUz = videoInfo;
            this.kUD = bwVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hZX.stopPlay();
            this.kUA = new o();
            this.kUA.mLocate = "pb";
            this.kUA.akY = bwVar.getTid();
            this.kUA.eVt = str;
            this.kUA.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.isBjh()) {
                if (!StringUtils.isNull(this.kzt.kEc)) {
                    this.kUA.dYo = this.kzt.kEc;
                }
                this.kUA.lte = this.kzt.kEb + "";
            } else {
                this.kUA.lte = this.kzt.cXq();
            }
            com.baidu.tbadk.core.data.bf cYf = this.kzt.cYf();
            if (cYf != null) {
                cYf.a(this.kUA);
            }
            this.kUA.lth = videoInfo.video_md5;
            o dke = this.kUA.dke();
            dke.mLocate = "6";
            this.startPosition = -1L;
            if (this.hZX.getVideoView() != null && this.hZX.getVideoView().getMediaProgressObserver() != null) {
                this.hZX.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bX(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean hI = com.baidu.mcn.b.SM().hI(mcnAdInfo.jump_url);
                            if (h.this.afg && !hI && !h.this.kUI) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.ivY.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bzR = mcnAdInfo.card_title;
                                        aVar.bzS = mcnAdInfo.button_title;
                                        aVar.bzT = mcnAdInfo.jump_url;
                                        aVar.bzQ = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bwVar.getTid();
                                        aVar.bzU = 4;
                                        if (z2) {
                                            h.this.ivY.b(aVar, (ViewGroup) h.this.hZX.djM());
                                        } else {
                                            h.this.ivY.a(aVar, (ViewGroup) h.this.hZX.djM());
                                        }
                                    }
                                } else if (h.this.ivY.isShowing()) {
                                    h.this.ivY.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.hZX.getVideoView().setVideoStatData(dke);
            if (this.hZX.cMS()) {
                this.hZX.cMQ();
            }
            this.hZX.b(this.kUU);
            this.kUF = null;
            this.kUE = null;
            this.hZX.Od(this.kUF);
            this.hZX.cMM().setOnDragingListener(jSu);
            this.hZX.a(new c.InterfaceC0782c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rE() {
                    h.this.kzt.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kUS > 0) {
                                h.this.EK(h.this.kUS);
                                h.this.EL(h.this.kUS);
                                h.this.kUS = 0;
                            }
                            h.this.kUV = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0782c
                public void rD() {
                    h.this.kzt.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kUV = false;
                    h.this.kUS = h.this.bGj().getHeight();
                }
            });
            this.hZX.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void ddF() {
                    if (h.this.kzt != null && h.this.kUE != null && !StringUtils.isNull(h.this.kUE.getId())) {
                        h.this.kzt.Nt(h.this.kUE.getId());
                    }
                }
            });
            this.hZX.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void ua(boolean z) {
                    if (h.this.kUD != null) {
                        h.this.Iu(z ? "1" : "2");
                    }
                }
            });
            this.hZX.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hZX.setThumbnail(videoInfo.thumbnail_url);
            this.hZX.setVideoUrl(this.mVideoUrl, bwVar.getTid());
            this.hZX.setFid(str);
            this.hZX.OD(bwVar.getTitle());
            this.hZX.a(kVf);
            this.hZX.czu();
            this.hZX.show();
        }
    }

    public void Oc(String str) {
        if (this.kUA != null) {
            this.kUA.eVt = str;
        }
    }

    public void b(PostData postData, bw bwVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.kUB != null) {
            this.kUB.a(postData, bwVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.kUU = dVar;
    }

    public void aL(bw bwVar) {
        this.kUE = bwVar;
    }

    public void Od(String str) {
        this.kUF = str;
        if (this.hZX != null) {
            this.hZX.Od(this.kUF);
        }
    }

    public void startPlay() {
        if (this.hZX != null) {
            if (j.isMobileNet() && !this.kVa && !com.baidu.tieba.video.g.dAV().dAW()) {
                this.kUR.setVisibility(0);
                this.kUR.setData(this.kUz);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kUD != null && this.kUD.beW() != null) {
                TiebaStatic.log(new aq("c12619").dD("obj_locate", "pb").dD("tid", this.kUD.getTid()));
                this.mVideoUrl = this.kUD.beW().video_url;
            }
            this.hZX.fw(this.mVideoUrl, this.kUD == null ? "" : this.kUD.getTid());
            Iu("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void ddx() {
        if (this.hZX != null) {
            this.hZX.ddx();
        }
    }

    public void destroy() {
        if (this.hZX != null) {
            this.hZX.destroy();
        }
        if (this.kUx != null) {
            this.kUx.clearAnimation();
        }
        if (this.kUB != null) {
            this.kUB.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Oe);
        MessageManager.getInstance().unRegisterListener(this.hUE);
    }

    public void onPause() {
        if (this.hZX != null) {
            if (this.hZX.rF()) {
                this.kUG = true;
                this.hZX.stopPlay();
            } else if (this.hZX.getCurrentState() == 3) {
                this.kUG = false;
            } else if (this.hZX.getCurrentState() == 0 || this.hZX.getCurrentState() == 1) {
                this.kUG = true;
                this.hZX.stopPlay();
            } else {
                this.kUG = false;
                this.hZX.stopPlay();
            }
            if (this.kUW != null) {
                this.kUW.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hZX != null && this.kUG) {
            this.hZX.djz();
        }
    }

    private void ddy() {
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.af(true);
            dVar.ah(false);
            dVar.ak(16908290).aj(Opcodes.IFEQ).ag(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.kzt.getActivity());
                    if (h.this.kUZ == null) {
                        try {
                            h.this.kUZ = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kUZ);
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
                    h.this.kUY = null;
                    if (h.this.kUZ != null && !h.this.kUZ.isRecycled()) {
                        h.this.kUZ.recycle();
                    }
                    h.this.kUZ = null;
                }
            });
            this.kUY = dVar.md();
            this.kUY.showOnDecorView(this.kzt.getActivity());
        }
    }

    public boolean xB(int i) {
        if (this.hZX == null) {
            return false;
        }
        return this.hZX.FD(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu(String str) {
        if (this.kUz != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.kUz.video_md5, "", str, this.kUA, this.hZX.getVideoView().getPcdnState());
            }
        }
    }

    public void ddz() {
        if (this.kUw != null) {
            this.kUw.tR(this.kzt.cWt());
        }
    }

    public void dco() {
        if (this.kUw != null) {
            this.kUw.dco();
        }
    }

    public void Ey(int i) {
        if (this.kUw != null) {
            this.kUw.Ey(i);
        }
        if (this.kUW != null) {
            this.kUW.onChangeSkinType(i);
        }
        if (this.kUB != null) {
            this.kUB.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!ddC()) {
                    this.kUJ = i;
                    if (this.kUJ == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.EL(h.this.bGj().getHeight());
                            }
                        }, 100L);
                    }
                    ddA();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EK(int i) {
        if (bGj().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUx.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kVc = false;
                    if (this.kUO != bGj().getHeight()) {
                        this.kUx.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kzt.getActivity()), Math.min(this.kUO, bGj().getHeight() + i)));
                        this.hZX.cMQ();
                    }
                } else if (l.getEquipmentWidth(this.kzt.getActivity()) * 0.5625d != bGj().getHeight()) {
                    this.kUx.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kzt.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kzt.getActivity()) * 0.5625d, bGj().getHeight() + i)));
                    this.hZX.cMQ();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == ddD()) {
                int bottom = childAt.getBottom() - bGj().getBottom();
                if (childAt.getHeight() == 0 || bGj().getHeight() == 0) {
                    bottom = 0;
                }
                EK(bottom);
            } else {
                EK((-this.kUO) + 2);
            }
        }
        if (!ddC() && this.kUV) {
            if (this.kUJ == 1) {
                this.kVb = true;
                EL(bGj().getHeight());
            } else if (this.kUJ == 2) {
                this.kVb = true;
                int y = (int) bGj().getY();
                if (this.kUK == y) {
                    EL(bGj().getHeight());
                } else {
                    this.kUK = y;
                    EL(bGj().getHeight());
                }
                if (i == 0 && this.kUN) {
                    this.kUN = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.ddx();
                        }
                    }, 100L);
                }
            } else if (this.kUJ == 0) {
                if (this.kVb || !"nani_midpage".equals(this.kzt.cXq())) {
                    EL(bGj().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EL(int i) {
        EM(i);
        ddA();
    }

    public void tD(boolean z) {
        this.kVc = z;
    }

    private void EM(int i) {
        if (this.kUB != null) {
            if (this.kUD != null && this.kUD.bdo()) {
                this.kUB.ddv().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kUO;
            }
            float f = this.kUO - i;
            float f2 = f > this.kUL ? 0.0f : 1.0f - (f / this.kUL);
            if (this.kVc) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kUB.ddv().setVisibility(8);
            } else {
                this.kUB.ddv().setVisibility(0);
            }
            this.kUB.ax(f2);
        }
    }

    public void ddA() {
        if (this.kUB != null) {
            if (ddC()) {
                this.kzt.cXt().dbo();
            } else if (this.kUB.ddv().getVisibility() == 0) {
                this.kzt.cXt().dbo();
                this.kUC = true;
            } else if (this.kUC) {
                this.kzt.cXt().tC(false);
                this.kUC = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ddB() {
        return bGj().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kUI = false;
        if (this.hZX != null && this.kUx != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUx.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.ivY != null && this.ivY.isShowing()) {
                    this.ivY.SN();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kUY != null) {
                    this.kUY.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kUI = true;
                this.kUx.setLayoutParams(layoutParams);
                this.kzt.cXt().dbo();
                this.kUC = true;
            } else {
                f(this.kUz);
                ddz();
                this.kUI = false;
                this.kUw.tQ(true);
            }
            this.hZX.a(this.kzt.getPageContext(), configuration);
        }
    }

    public boolean ddC() {
        return this.kUI;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.kUB != null) {
            this.kUB.V(onClickListener);
        }
    }

    public View bGj() {
        return this.kUv;
    }

    public boolean dbx() {
        if (bGj() == null) {
            return false;
        }
        return bGj().getBottom() > l.getEquipmentHeight(bGj().getContext()) - l.getDimens(bGj().getContext(), R.dimen.ds50);
    }

    public void dbS() {
        this.kUN = true;
    }

    public View ddD() {
        return this.mEmptyView;
    }
}
