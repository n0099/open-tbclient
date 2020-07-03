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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.w;
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
    private static VideoControllerView.a juv = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bpq() {
        }
    };
    private static c.i kwD = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void caM() {
        }
    };
    private float VV;
    private boolean aek;
    private n fnj;
    private com.baidu.tieba.play.c hFU;
    private com.baidu.mcn.c ibP;
    private PbFragment kbv;
    private RelativeLayout kvT;
    private com.baidu.tieba.pb.pb.main.view.c kvU;
    private CustomFrameLayout kvV;
    private c.d kvW;
    private y kvY;
    private f kvZ;
    private boolean kwA;
    private int kwC;
    private boolean kwa;
    private bu kwb;
    private bu kwc;
    private String kwd;
    private float kwj;
    private int kwm;
    private double kwn;
    private long kwo;
    private PbVideoWifiTipLayout kwp;
    private int kwq;
    private c.d kws;
    private PbFullScreenFloatingHuajiAninationView kwu;
    private com.baidu.adp.lib.guide.c kww;
    private Bitmap kwx;
    private boolean kwy;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo kvX = null;
    private boolean kwe = false;
    private int kwf = 0;
    private boolean kwg = false;
    private int kwh = 0;
    private int kwi = 0;
    private boolean kwk = false;
    private boolean kwl = false;
    private long startPosition = -1;
    private int hhk = 0;
    private c.p kwr = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cOY() {
            if (h.this.kbv != null && h.this.kbv.cIe() != null && h.this.kbv.cIe().getPbData() != null) {
                PostData cGW = h.this.kbv.cIe().getPbData().cGW();
                if (cGW == null && w.getCount(h.this.kbv.cIe().getPbData().cGP()) > 1) {
                    cGW = (PostData) w.getItem(h.this.kbv.cIe().getPbData().cGP(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kbv.cIe().getPbData(), cGW, 1, 1, 4);
            }
        }
    };
    private boolean kwt = true;
    private PbFullScreenFloatingHuajiAninationView.a kwv = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.sK(false);
        }
    };
    private boolean kwz = false;
    private c.m kwB = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cPa() {
            if (h.this.kwn >= 1.0d) {
                if (h.this.kbv.checkUpIsLogin()) {
                    h.this.kbv.cJD();
                    if (h.this.kbv.cIe() == null || h.this.kbv.cIe().getPbData() == null || h.this.kbv.cIe().getPbData().cHl() == null) {
                        return false;
                    }
                    m cHl = h.this.kbv.cIe().getPbData().cHl();
                    if (h.this.kwu == null) {
                        h.this.kwu = new PbFullScreenFloatingHuajiAninationView(h.this.kbv.getActivity());
                        h.this.kwu.setFloatingHuajiAninationListener(h.this.kwv);
                    }
                    h.this.kwu.sZ(cHl.cHF() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cPb() {
            return false;
        }
    };
    private CustomMessageListener Ny = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hFU != null) {
                    h.this.hFU.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hFU != null && h.this.hFU.qf() && h.this.kvX != null && h.this.kvX.video_length.intValue() > 0 && h.this.kvX.video_duration.intValue() > 0) {
                    float intValue = h.this.kvX.video_length.intValue() * (1.0f - ((h.this.hFU.getCurrentPosition() * 1.0f) / (h.this.kvX.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kbv.getPageContext().getPageActivity(), String.format(h.this.kbv.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jsx = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cNK();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.kvX != null) {
                h.this.f(h.this.kvX);
                h.this.hFU.cUV();
                h.this.hFU.cxZ();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kwm;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(boolean z) {
        if (this.kbv != null) {
            this.kbv.cIW();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kwj = 0.0f;
        this.kbv = pbFragment;
        this.kvU = cVar;
        this.kwj = l.getDimens(this.kbv.getActivity(), R.dimen.ds240);
        this.kwo = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Ny);
        this.hBt.setTag(pbFragment.getUniqueId());
        this.hBt.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hBt);
        this.ibP = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kvV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kbv.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kbv.getActivity());
        Rect visibilityRegion = bd.getVisibilityRegion(this.kbv.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kbv.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kwn = (intValue2 * 1.0d) / intValue;
            if (this.kwn > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kwm = i;
        this.kvV.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bAr() {
        return this.kwn >= 1.0d;
    }

    public int cNq() {
        return this.kwm;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kvT = (RelativeLayout) LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kvV = (CustomFrameLayout) this.kvT.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.aek = ((double) this.kwm) <= (((double) l.getEquipmentWidth(this.kbv.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hFU = new com.baidu.tieba.play.c(this.kbv.getPageContext(), this.kvV, true, com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test") ? 1 : 0);
        this.hFU.a(this.kwB);
        this.hFU.tI(false);
        this.hFU.a(this.kwr);
        this.hFU.CG(an.lr(R.drawable.pic_use_header_60_n));
        this.hFU.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kbv.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kbv.getBaseFragmentActivity())) {
            this.hFU.tz(false);
        }
        this.hFU.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.VV = motionEvent.getY();
                        if (h.this.kbv.getListView() != null && h.this.kbv.getListView().getChildCount() > 0 && h.this.kbv.getListView().getChildAt(0) == h.this.cOX()) {
                            h.this.kwC = h.this.cOX().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.VV = 0.0f;
                        h.this.kwC = 0;
                        break;
                    case 2:
                        if (h.this.kbv.getListView() != null && h.this.kbv.getListView().getChildCount() > 0 && h.this.kbv.getListView().getChildAt(0) == h.this.cOX()) {
                            h.this.kbv.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.VV)) + h.this.kwC);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kwn >= 1.0d) {
                this.hFU.ao(false, true);
            } else {
                this.hFU.ao(true, false);
            }
            this.kwk = ((float) f) + this.kwj > ((float) l.getEquipmentHeight(this.kbv.getActivity()));
            if (this.kwk) {
                if (this.kvZ == null) {
                    this.kvZ = new f(this.kbv.getPageContext(), this.kvV);
                }
                this.kbv.cIU().cML();
                this.kwa = true;
            }
        }
        cOS();
        this.mEmptyView = new View(this.kbv.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kwm));
        if (this.kvU != null && this.kvU.mNavigationBar != null) {
            this.kvU.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kvU.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kvU.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aVZ() && !TbSingleton.getInstance().isNotchScreen(this.kbv.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kbv.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kwp = (PbVideoWifiTipLayout) this.kvT.findViewById(R.id.layout_wifi_tip);
        this.kwp.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kwy = true;
                h.this.kwp.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.ibP != null) {
            this.ibP.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kbv.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kvW == null) {
            this.kvW = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void nx(boolean z) {
                    if (h.this.cOV() && h.this.kvU != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kvU.cND().clearAnimation();
                        h.this.cOT();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jsx);
                            h.this.kvU.cND().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void caL() {
                    if (h.this.cOV()) {
                        h.this.cNK();
                    }
                }
            };
        }
        a(this.kvW);
        this.kwf = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kbv.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bu buVar, final String str) {
        if (videoInfo != null && this.hFU != null && buVar != null) {
            this.kvX = videoInfo;
            this.kwb = buVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hFU.stopPlay();
            this.hFU.setIsNeedRecoveryVideoPlayer(true);
            this.fnj = new n(this.kbv.getActivity());
            this.kvY = new y();
            this.kvY.mLocate = "pb";
            this.kvY.ajO = buVar.getTid();
            this.kvY.eEs = str;
            this.kvY.mUid = TbadkCoreApplication.getCurrentAccount();
            if (buVar.isBjh()) {
                if (!StringUtils.isNull(this.kbv.kfU)) {
                    this.kvY.dIK = this.kbv.kfU;
                }
                this.kvY.kVq = this.kbv.kfT + "";
            } else {
                this.kvY.kVq = this.kbv.cIR();
            }
            com.baidu.tbadk.core.data.bd cJF = this.kbv.cJF();
            if (cJF != null) {
                cJF.b(this.kvY);
            }
            this.kvY.kVt = videoInfo.video_md5;
            y cVW = this.kvY.cVW();
            cVW.mLocate = "6";
            this.startPosition = -1L;
            this.fnj.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bM(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean go = com.baidu.mcn.b.MG().go(mcnAdInfo.jump_url);
                        if (h.this.aek && !go && !h.this.kwg) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.ibP.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.btJ = mcnAdInfo.card_title;
                                    aVar.btK = mcnAdInfo.button_title;
                                    aVar.btL = mcnAdInfo.jump_url;
                                    aVar.btI = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = buVar.getTid();
                                    aVar.btM = 4;
                                    if (z2) {
                                        h.this.ibP.b(aVar, (ViewGroup) h.this.hFU.cUU());
                                    } else {
                                        h.this.ibP.a(aVar, (ViewGroup) h.this.hFU.cUU());
                                    }
                                }
                            } else if (h.this.ibP.isShowing()) {
                                h.this.ibP.dismiss();
                            }
                        }
                    }
                }
            });
            this.fnj.setVideoStatsData(cVW);
            this.hFU.cUD().setBusiness(this.fnj);
            if (this.hFU.cyb()) {
                this.hFU.cxZ();
            }
            this.hFU.b(this.kws);
            this.kwd = null;
            this.kwc = null;
            this.hFU.Kw(this.kwd);
            this.hFU.cxV().setOnDragingListener(juv);
            this.hFU.a(new c.InterfaceC0720c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qe() {
                    h.this.kbv.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kwq > 0) {
                                h.this.BQ(h.this.kwq);
                                h.this.BR(h.this.kwq);
                                h.this.kwq = 0;
                            }
                            h.this.kwt = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0720c
                public void qd() {
                    h.this.kbv.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kwt = false;
                    h.this.kwq = h.this.bua().getHeight();
                }
            });
            this.hFU.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cOZ() {
                    if (h.this.kbv != null && h.this.kwc != null && !StringUtils.isNull(h.this.kwc.getId())) {
                        h.this.kbv.JN(h.this.kwc.getId());
                    }
                }
            });
            this.hFU.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void sL(boolean z) {
                    if (h.this.kwb != null) {
                        h.this.Fh(z ? "1" : "2");
                    }
                }
            });
            this.hFU.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hFU.setThumbnail(videoInfo.thumbnail_url);
            this.hFU.setVideoUrl(this.mVideoUrl, buVar.getTid());
            this.hFU.setFid(str);
            this.hFU.KW(buVar.getTitle());
            this.hFU.a(kwD);
            this.hFU.cla();
            this.hFU.show();
        }
    }

    public void Kv(String str) {
        if (this.kvY != null) {
            this.kvY.eEs = str;
        }
    }

    public void b(PostData postData, bu buVar, m mVar) {
        if (this.kvZ != null) {
            this.kvZ.a(postData, buVar, mVar);
        }
    }

    public void a(c.d dVar) {
        this.kws = dVar;
    }

    public void aN(bu buVar) {
        this.kwc = buVar;
    }

    public void Kw(String str) {
        this.kwd = str;
        if (this.hFU != null) {
            this.hFU.Kw(this.kwd);
        }
    }

    public void startPlay() {
        if (this.hFU != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kwy && !com.baidu.tieba.video.h.dmk().dml()) {
                this.kwp.setVisibility(0);
                this.kwp.setData(this.kvX);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kwb != null && this.kwb.aSH() != null) {
                TiebaStatic.log(new ao("c12619").dk("obj_locate", "pb").dk("tid", this.kwb.getTid()));
                this.mVideoUrl = this.kwb.aSH().video_url;
            }
            this.hFU.fd(this.mVideoUrl, this.kwb == null ? "" : this.kwb.getTid());
            Fh("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cOR() {
        if (this.hFU != null) {
            this.hFU.cOR();
        }
    }

    public void destroy() {
        if (this.hFU != null) {
            this.hFU.destroy();
        }
        if (this.kvV != null) {
            this.kvV.clearAnimation();
        }
        if (this.kvZ != null) {
            this.kvZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Ny);
        MessageManager.getInstance().unRegisterListener(this.hBt);
    }

    public void onPause() {
        if (this.hFU != null) {
            if (this.hFU.qf()) {
                this.kwe = true;
                this.hFU.stopPlay();
            } else if (this.hFU.getCurrentState() == 3) {
                this.kwe = false;
            } else if (this.hFU.getCurrentState() == 0 || this.hFU.getCurrentState() == 1) {
                this.kwe = true;
                this.hFU.stopPlay();
            } else {
                this.kwe = false;
                this.hFU.stopPlay();
            }
            if (this.kwu != null) {
                this.kwu.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hFU != null && this.kwe) {
            this.hFU.cUH();
        }
    }

    private void cOS() {
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.ag(16908290).af(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.kbv.getActivity());
                    if (h.this.kwx == null) {
                        try {
                            h.this.kwx = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kwx);
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
                    h.this.kww = null;
                    if (h.this.kwx != null && !h.this.kwx.isRecycled()) {
                        h.this.kwx.recycle();
                    }
                    h.this.kwx = null;
                }
            });
            this.kww = dVar.kE();
            this.kww.showOnDecorView(this.kbv.getActivity());
        }
    }

    public boolean uR(int i) {
        if (this.hFU == null) {
            return false;
        }
        return this.hFU.CI(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(String str) {
        if (this.kvX != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.kvX.video_md5, "", str, this.kvY, this.hFU.cUD().getPcdnState());
            }
        }
    }

    public void cOT() {
        if (this.kvU != null) {
            this.kvU.sC(this.kbv.cHU());
        }
    }

    public void cNK() {
        if (this.kvU != null) {
            this.kvU.cNK();
        }
    }

    public void BF(int i) {
        if (this.kvU != null) {
            this.kvU.BF(i);
        }
        if (this.kwu != null) {
            this.kwu.onChangeSkinType(i);
        }
        if (this.kvZ != null) {
            this.kvZ.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cOW()) {
                    this.kwh = i;
                    if (this.kwh == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.BR(h.this.bua().getHeight());
                            }
                        }, 100L);
                    }
                    cOU();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ(int i) {
        if (bua().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kvV.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kwA = false;
                    if (this.kwm != bua().getHeight()) {
                        this.kvV.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kbv.getActivity()), Math.min(this.kwm, bua().getHeight() + i)));
                        this.hFU.cxZ();
                    }
                } else if (l.getEquipmentWidth(this.kbv.getActivity()) * 0.5625d != bua().getHeight()) {
                    this.kvV.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kbv.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kbv.getActivity()) * 0.5625d, bua().getHeight() + i)));
                    this.hFU.cxZ();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cOX()) {
                int bottom = childAt.getBottom() - bua().getBottom();
                if (childAt.getHeight() == 0 || bua().getHeight() == 0) {
                    bottom = 0;
                }
                BQ(bottom);
            } else {
                BQ((-this.kwm) + 2);
            }
        }
        if (!cOW() && this.kwt) {
            if (this.kwh == 1) {
                this.kwz = true;
                BR(bua().getHeight());
            } else if (this.kwh == 2) {
                this.kwz = true;
                int y = (int) bua().getY();
                if (this.kwi == y) {
                    BR(bua().getHeight());
                } else {
                    this.kwi = y;
                    BR(bua().getHeight());
                }
                if (i == 0 && this.kwl) {
                    this.kwl = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cOR();
                        }
                    }, 100L);
                }
            } else if (this.kwh == 0) {
                if (this.kwz || !"nani_midpage".equals(this.kbv.cIR())) {
                    BR(bua().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR(int i) {
        BS(i);
        cOU();
    }

    public void sp(boolean z) {
        this.kwA = z;
    }

    private void BS(int i) {
        if (this.kvZ != null) {
            if (this.kwb != null && this.kwb.aQZ()) {
                this.kvZ.cOP().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kwm;
            }
            float f = this.kwm - i;
            float f2 = f > this.kwj ? 0.0f : 1.0f - (f / this.kwj);
            if (this.kwA) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kvZ.cOP().setVisibility(8);
            } else {
                this.kvZ.cOP().setVisibility(0);
            }
            this.kvZ.as(f2);
        }
    }

    public void cOU() {
        if (this.kvZ != null) {
            if (cOW()) {
                this.kbv.cIU().cML();
            } else if (this.kvZ.cOP().getVisibility() == 0) {
                this.kbv.cIU().cML();
                this.kwa = true;
            } else if (this.kwa) {
                this.kbv.cIU().so(false);
                this.kwa = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOV() {
        return bua().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kwg = false;
        if (this.hFU != null && this.kvV != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kvV.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.ibP != null && this.ibP.isShowing()) {
                    this.ibP.MH();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kww != null) {
                    this.kww.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kwg = true;
                this.kvV.setLayoutParams(layoutParams);
                this.kbv.cIU().cML();
                this.kwa = true;
            } else {
                f(this.kvX);
                cOT();
                this.kwg = false;
                this.kvU.sB(true);
            }
            this.hFU.a(this.kbv.getPageContext(), configuration);
        }
    }

    public boolean cOW() {
        return this.kwg;
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.kvZ != null) {
            this.kvZ.T(onClickListener);
        }
    }

    public View bua() {
        return this.kvT;
    }

    public boolean cMU() {
        if (bua() == null) {
            return false;
        }
        return bua().getBottom() > l.getEquipmentHeight(bua().getContext()) - l.getDimens(bua().getContext(), R.dimen.ds50);
    }

    public void cNo() {
        this.kwl = true;
    }

    public View cOX() {
        return this.mEmptyView;
    }
}
