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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
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
    private static VideoControllerView.a jdm = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bmQ() {
        }
    };
    private static c.i kcQ = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bXB() {
        }
    };
    private float Vr;
    private boolean adG;
    private n fbZ;
    private com.baidu.mcn.c hOD;
    private com.baidu.tieba.play.c hte;
    private PbFragment jHL;
    private double kcA;
    private long kcB;
    private PbVideoWifiTipLayout kcC;
    private int kcD;
    private c.d kcF;
    private PbFullScreenFloatingHuajiAninationView kcH;
    private com.baidu.adp.lib.guide.c kcJ;
    private Bitmap kcK;
    private boolean kcL;
    private boolean kcN;
    private int kcP;
    private RelativeLayout kcg;
    private com.baidu.tieba.pb.pb.main.view.c kch;
    private CustomFrameLayout kci;
    private c.d kcj;
    private y kcl;
    private f kcm;
    private boolean kcn;
    private bk kco;
    private bk kcp;
    private String kcq;
    private float kcw;
    private int kcz;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo kck = null;
    private boolean kcr = false;
    private int kcs = 0;
    private boolean kct = false;
    private int kcu = 0;
    private int kcv = 0;
    private boolean kcx = false;
    private boolean kcy = false;
    private long startPosition = -1;
    private int gUB = 0;
    private c.p kcE = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cKH() {
            if (h.this.jHL != null && h.this.jHL.cDO() != null && h.this.jHL.cDO().getPbData() != null) {
                PostData cCH = h.this.jHL.cDO().getPbData().cCH();
                if (cCH == null && v.getCount(h.this.jHL.cDO().getPbData().cCA()) > 1) {
                    cCH = (PostData) v.getItem(h.this.jHL.cDO().getPbData().cCA(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.jHL.cDO().getPbData(), cCH, 1, 1, 4);
            }
        }
    };
    private boolean kcG = true;
    private PbFullScreenFloatingHuajiAninationView.a kcI = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.sw(false);
        }
    };
    private boolean kcM = false;
    private c.m kcO = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cKJ() {
            if (h.this.kcA < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.jHL.checkUpIsLogin()) {
                h.this.jHL.cFn();
                if (h.this.jHL.cDO() == null || h.this.jHL.cDO().getPbData() == null || h.this.jHL.cDO().getPbData().cCW() == null) {
                    return false;
                }
                m cCW = h.this.jHL.cDO().getPbData().cCW();
                if (h.this.kcH == null) {
                    h.this.kcH = new PbFullScreenFloatingHuajiAninationView(h.this.jHL.getActivity());
                    h.this.kcH.setFloatingHuajiAninationListener(h.this.kcI);
                }
                h.this.kcH.sL(cCW.cDp() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cKK() {
            return false;
        }
    };
    private CustomMessageListener MX = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hte != null) {
                    h.this.hte.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hte != null && h.this.hte.pO() && h.this.kck != null && h.this.kck.video_length.intValue() > 0 && h.this.kck.video_duration.intValue() > 0) {
                    float intValue = h.this.kck.video_length.intValue() * (1.0f - ((h.this.hte.getCurrentPosition() * 1.0f) / (h.this.kck.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.jHL.getPageContext().getPageActivity(), String.format(h.this.jHL.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jbn = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cJt();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener hoT = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.kck != null) {
                h.this.f(h.this.kck);
                h.this.hte.cQE();
                h.this.hte.cuk();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kcz;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(boolean z) {
        if (this.jHL != null) {
            this.jHL.cEG();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kcw = 0.0f;
        this.jHL = pbFragment;
        this.kch = cVar;
        this.kcw = l.getDimens(this.jHL.getActivity(), R.dimen.ds240);
        this.kcB = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.MX);
        this.hoT.setTag(pbFragment.getUniqueId());
        this.hoT.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hoT);
        this.hOD = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kci.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.jHL.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.jHL.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.jHL.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.jHL.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kcA = (intValue2 * 1.0d) / intValue;
            if (this.kcA > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kcz = i;
        this.kci.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bxE() {
        return this.kcA >= 1.0d;
    }

    public int cIZ() {
        return this.kcz;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kcg = (RelativeLayout) LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kci = (CustomFrameLayout) this.kcg.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.adG = ((double) this.kcz) <= (((double) l.getEquipmentWidth(this.jHL.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hte = new com.baidu.tieba.play.c(this.jHL.getPageContext(), this.kci, true, com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test") ? 1 : 0);
        this.hte.a(this.kcO);
        this.hte.tu(false);
        this.hte.a(this.kcE);
        this.hte.BE(am.ld(R.drawable.pic_use_header_60_n));
        this.hte.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.jHL.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.jHL.getBaseFragmentActivity())) {
            this.hte.tl(false);
        }
        this.hte.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.Vr = motionEvent.getY();
                        if (h.this.jHL.getListView() != null && h.this.jHL.getListView().getChildCount() > 0 && h.this.jHL.getListView().getChildAt(0) == h.this.cKG()) {
                            h.this.kcP = h.this.cKG().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.Vr = 0.0f;
                        h.this.kcP = 0;
                        break;
                    case 2:
                        if (h.this.jHL.getListView() != null && h.this.jHL.getListView().getChildCount() > 0 && h.this.jHL.getListView().getChildAt(0) == h.this.cKG()) {
                            h.this.jHL.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.Vr)) + h.this.kcP);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kcA >= 1.0d) {
                this.hte.an(false, true);
            } else {
                this.hte.an(true, false);
            }
            this.kcx = ((float) f) + this.kcw > ((float) l.getEquipmentHeight(this.jHL.getActivity()));
            if (this.kcx) {
                if (this.kcm == null) {
                    this.kcm = new f(this.jHL.getPageContext(), this.kci);
                }
                this.jHL.cEE().cIu();
                this.kcn = true;
            }
        }
        cKB();
        this.mEmptyView = new View(this.jHL.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kcz));
        if (this.kch != null && this.kch.mNavigationBar != null) {
            this.kch.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kch.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kch.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aUh() && !TbSingleton.getInstance().isNotchScreen(this.jHL.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jHL.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kcC = (PbVideoWifiTipLayout) this.kcg.findViewById(R.id.layout_wifi_tip);
        this.kcC.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kcL = true;
                h.this.kcC.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.hOD != null) {
            this.hOD.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.jHL.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kcj == null) {
            this.kcj = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void nm(boolean z) {
                    if (h.this.cKE() && h.this.kch != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kch.cJm().clearAnimation();
                        h.this.cKC();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jbn);
                            h.this.kch.cJm().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bXA() {
                    if (h.this.cKE()) {
                        h.this.cJt();
                    }
                }
            };
        }
        a(this.kcj);
        this.kcs = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jHL.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bk bkVar, final String str) {
        if (videoInfo != null && this.hte != null && bkVar != null) {
            this.kck = videoInfo;
            this.kco = bkVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hte.stopPlay();
            this.hte.setIsNeedRecoveryVideoPlayer(true);
            this.fbZ = new n(this.jHL.getActivity());
            this.kcl = new y();
            this.kcl.mLocate = "pb";
            this.kcl.ais = bkVar.getTid();
            this.kcl.evm = str;
            this.kcl.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bkVar.isBjh()) {
                if (!StringUtils.isNull(this.jHL.jMj)) {
                    this.kcl.dCp = this.jHL.jMj;
                }
                this.kcl.kBt = this.jHL.jMi + "";
            } else {
                this.kcl.kBt = this.jHL.cEB();
            }
            ay cFp = this.jHL.cFp();
            if (cFp != null) {
                cFp.b(this.kcl);
            }
            this.kcl.kBw = videoInfo.video_md5;
            y cRF = this.kcl.cRF();
            cRF.mLocate = "6";
            this.startPosition = -1L;
            this.fbZ.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean gg = com.baidu.mcn.b.Lx().gg(mcnAdInfo.jump_url);
                        if (h.this.adG && !gg && !h.this.kct) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.hOD.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.boJ = mcnAdInfo.card_title;
                                    aVar.boK = mcnAdInfo.button_title;
                                    aVar.boL = mcnAdInfo.jump_url;
                                    aVar.boI = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bkVar.getTid();
                                    aVar.boM = 4;
                                    if (z2) {
                                        h.this.hOD.b(aVar, (ViewGroup) h.this.hte.cQD());
                                    } else {
                                        h.this.hOD.a(aVar, (ViewGroup) h.this.hte.cQD());
                                    }
                                }
                            } else if (h.this.hOD.isShowing()) {
                                h.this.hOD.dismiss();
                            }
                        }
                    }
                }
            });
            this.fbZ.setVideoStatsData(cRF);
            this.hte.cQm().setBusiness(this.fbZ);
            if (this.hte.cum()) {
                this.hte.cuk();
            }
            this.hte.b(this.kcF);
            this.kcq = null;
            this.kcp = null;
            this.hte.JU(this.kcq);
            this.hte.cug().setOnDragingListener(jdm);
            this.hte.a(new c.InterfaceC0704c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pN() {
                    h.this.jHL.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kcD > 0) {
                                h.this.AO(h.this.kcD);
                                h.this.AP(h.this.kcD);
                                h.this.kcD = 0;
                            }
                            h.this.kcG = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pM() {
                    h.this.jHL.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kcG = false;
                    h.this.kcD = h.this.bre().getHeight();
                }
            });
            this.hte.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cKI() {
                    if (h.this.jHL != null && h.this.kcp != null && !StringUtils.isNull(h.this.kcp.getId())) {
                        h.this.jHL.Jl(h.this.kcp.getId());
                    }
                }
            });
            this.hte.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void sx(boolean z) {
                    if (h.this.kco != null) {
                        h.this.EG(z ? "1" : "2");
                    }
                }
            });
            this.hte.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hte.setThumbnail(videoInfo.thumbnail_url);
            this.hte.setVideoUrl(this.mVideoUrl, bkVar.getTid());
            this.hte.setFid(str);
            this.hte.Kv(bkVar.getTitle());
            this.hte.a(kcQ);
            this.hte.cho();
            this.hte.show();
        }
    }

    public void JT(String str) {
        if (this.kcl != null) {
            this.kcl.evm = str;
        }
    }

    public void b(PostData postData, bk bkVar, m mVar) {
        if (this.kcm != null) {
            this.kcm.a(postData, bkVar, mVar);
        }
    }

    public void a(c.d dVar) {
        this.kcF = dVar;
    }

    public void aM(bk bkVar) {
        this.kcp = bkVar;
    }

    public void JU(String str) {
        this.kcq = str;
        if (this.hte != null) {
            this.hte.JU(this.kcq);
        }
    }

    public void startPlay() {
        if (this.hte != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kcL && !com.baidu.tieba.video.g.dhZ().dia()) {
                this.kcC.setVisibility(0);
                this.kcC.setData(this.kck);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kco != null && this.kco.aQQ() != null) {
                TiebaStatic.log(new an("c12619").dh("obj_locate", "pb").dh("tid", this.kco.getTid()));
                this.mVideoUrl = this.kco.aQQ().video_url;
            }
            this.hte.eW(this.mVideoUrl, this.kco == null ? "" : this.kco.getTid());
            EG("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cKA() {
        if (this.hte != null) {
            this.hte.cKA();
        }
    }

    public void destroy() {
        if (this.hte != null) {
            this.hte.destroy();
        }
        if (this.kci != null) {
            this.kci.clearAnimation();
        }
        if (this.kcm != null) {
            this.kcm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.MX);
        MessageManager.getInstance().unRegisterListener(this.hoT);
    }

    public void onPause() {
        if (this.hte != null) {
            if (this.hte.pO()) {
                this.kcr = true;
                this.hte.stopPlay();
            } else if (this.hte.getCurrentState() == 3) {
                this.kcr = false;
            } else if (this.hte.getCurrentState() == 0 || this.hte.getCurrentState() == 1) {
                this.kcr = true;
                this.hte.stopPlay();
            } else {
                this.kcr = false;
                this.hte.stopPlay();
            }
            if (this.kcH != null) {
                this.kcH.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hte != null && this.kcr) {
            this.hte.cQq();
        }
    }

    private void cKB() {
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ad(true);
            dVar.af(false);
            dVar.aa(16908290).Z(Opcodes.IFEQ).ae(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.jHL.getActivity());
                    if (h.this.kcK == null) {
                        try {
                            h.this.kcK = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kcK);
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
                    h.this.kcJ = null;
                    if (h.this.kcK != null && !h.this.kcK.isRecycled()) {
                        h.this.kcK.recycle();
                    }
                    h.this.kcK = null;
                }
            });
            this.kcJ = dVar.ko();
            this.kcJ.showOnDecorView(this.jHL.getActivity());
        }
    }

    public boolean um(int i) {
        if (this.hte == null) {
            return false;
        }
        return this.hte.BG(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(String str) {
        if (this.kck != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.kck.video_md5, "", str, this.kcl, this.hte.cQm().getPcdnState());
            }
        }
    }

    public void cKC() {
        if (this.kch != null) {
            this.kch.so(this.jHL.cDE());
        }
    }

    public void cJt() {
        if (this.kch != null) {
            this.kch.cJt();
        }
    }

    public void AD(int i) {
        if (this.kch != null) {
            this.kch.AD(i);
        }
        if (this.kcH != null) {
            this.kcH.onChangeSkinType(i);
        }
        if (this.kcm != null) {
            this.kcm.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cKF()) {
                    this.kcu = i;
                    if (this.kcu == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.AP(h.this.bre().getHeight());
                            }
                        }, 100L);
                    }
                    cKD();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO(int i) {
        if (bre().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kci.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kcN = false;
                    if (this.kcz != bre().getHeight()) {
                        this.kci.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jHL.getActivity()), Math.min(this.kcz, bre().getHeight() + i)));
                        this.hte.cuk();
                    }
                } else if (l.getEquipmentWidth(this.jHL.getActivity()) * 0.5625d != bre().getHeight()) {
                    this.kci.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jHL.getActivity()), (int) Math.max(l.getEquipmentWidth(this.jHL.getActivity()) * 0.5625d, bre().getHeight() + i)));
                    this.hte.cuk();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cKG()) {
                int bottom = childAt.getBottom() - bre().getBottom();
                if (childAt.getHeight() == 0 || bre().getHeight() == 0) {
                    bottom = 0;
                }
                AO(bottom);
            } else {
                AO((-this.kcz) + 2);
            }
        }
        if (!cKF() && this.kcG) {
            if (this.kcu == 1) {
                this.kcM = true;
                AP(bre().getHeight());
            } else if (this.kcu == 2) {
                this.kcM = true;
                int y = (int) bre().getY();
                if (this.kcv == y) {
                    AP(bre().getHeight());
                } else {
                    this.kcv = y;
                    AP(bre().getHeight());
                }
                if (i == 0 && this.kcy) {
                    this.kcy = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cKA();
                        }
                    }, 100L);
                }
            } else if (this.kcu == 0) {
                if (this.kcM || !"nani_midpage".equals(this.jHL.cEB())) {
                    AP(bre().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP(int i) {
        AQ(i);
        cKD();
    }

    public void sb(boolean z) {
        this.kcN = z;
    }

    private void AQ(int i) {
        if (this.kcm != null) {
            if (this.kco != null && this.kco.aSx()) {
                this.kcm.cKy().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kcz;
            }
            float f = this.kcz - i;
            float f2 = f > this.kcw ? 0.0f : 1.0f - (f / this.kcw);
            if (this.kcN) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kcm.cKy().setVisibility(8);
            } else {
                this.kcm.cKy().setVisibility(0);
            }
            this.kcm.an(f2);
        }
    }

    public void cKD() {
        if (this.kcm != null) {
            if (cKF()) {
                this.jHL.cEE().cIu();
            } else if (this.kcm.cKy().getVisibility() == 0) {
                this.jHL.cEE().cIu();
                this.kcn = true;
            } else if (this.kcn) {
                this.jHL.cEE().sa(false);
                this.kcn = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKE() {
        return bre().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kct = false;
        if (this.hte != null && this.kci != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kci.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.hOD != null && this.hOD.isShowing()) {
                    this.hOD.Ly();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kcJ != null) {
                    this.kcJ.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kct = true;
                this.kci.setLayoutParams(layoutParams);
                this.jHL.cEE().cIu();
                this.kcn = true;
            } else {
                f(this.kck);
                cKC();
                this.kct = false;
                this.kch.sn(true);
            }
            this.hte.a(this.jHL.getPageContext(), configuration);
        }
    }

    public boolean cKF() {
        return this.kct;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.kcm != null) {
            this.kcm.S(onClickListener);
        }
    }

    public View bre() {
        return this.kcg;
    }

    public boolean cID() {
        if (bre() == null) {
            return false;
        }
        return bre().getBottom() > l.getEquipmentHeight(bre().getContext()) - l.getDimens(bre().getContext(), R.dimen.ds50);
    }

    public void cIX() {
        this.kcy = true;
    }

    public View cKG() {
        return this.mEmptyView;
    }
}
