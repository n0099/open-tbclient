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
/* loaded from: classes21.dex */
public class h {
    private static VideoControllerView.a kbd = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bCD() {
        }
    };
    private static c.i ldQ = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void csd() {
        }
    };
    private boolean afB;
    private com.baidu.mcn.c iDA;
    private com.baidu.tieba.play.c ihi;
    private PbFragment kHX;
    private double ldA;
    private long ldB;
    private PbVideoWifiTipLayout ldC;
    private int ldD;
    private c.d ldF;
    private PbFullScreenFloatingHuajiAninationView ldH;
    private com.baidu.adp.lib.guide.c ldJ;
    private Bitmap ldK;
    private boolean ldL;
    private boolean ldN;
    private int ldP;
    private RelativeLayout ldg;
    private com.baidu.tieba.pb.pb.main.view.c ldh;
    private CustomFrameLayout ldi;
    private c.d ldj;
    private o ldl;
    private f ldm;
    private boolean ldn;
    private bw ldo;
    private bw ldp;
    private String ldq;
    private float ldw;
    private int ldz;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo ldk = null;
    private boolean ldr = false;
    private int lds = 0;
    private boolean ldt = false;
    private int ldu = 0;
    private int ldv = 0;
    private boolean ldx = false;
    private boolean ldy = false;
    private long startPosition = -1;
    private int hGT = 0;
    private c.p ldE = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void dhj() {
            if (h.this.kHX != null && h.this.kHX.dah() != null && h.this.kHX.dah().getPbData() != null) {
                PostData cZa = h.this.kHX.dah().getPbData().cZa();
                if (cZa == null && y.getCount(h.this.kHX.dah().getPbData().cYT()) > 1) {
                    cZa = (PostData) y.getItem(h.this.kHX.dah().getPbData().cYT(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kHX.dah().getPbData(), cZa, 1, 1, 4);
            }
        }
    };
    private boolean ldG = true;
    private PbFullScreenFloatingHuajiAninationView.a ldI = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.uj(false);
        }
    };
    private boolean ldM = false;
    private c.m ldO = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dhl() {
            if (h.this.ldA >= 1.0d) {
                if (h.this.kHX.checkUpIsLogin()) {
                    h.this.kHX.dbH();
                    if (h.this.kHX.dah() == null || h.this.kHX.dah().getPbData() == null || h.this.kHX.dah().getPbData().cZq() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o cZq = h.this.kHX.dah().getPbData().cZq();
                    if (h.this.ldH == null) {
                        h.this.ldH = new PbFullScreenFloatingHuajiAninationView(h.this.kHX.getActivity());
                        h.this.ldH.setFloatingHuajiAninationListener(h.this.ldI);
                    }
                    h.this.ldH.uy(cZq.cZJ() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dhm() {
            return false;
        }
    };
    private CustomMessageListener Ox = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.ihi != null) {
                    h.this.ihi.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.ihi != null && h.this.ihi.rK() && h.this.ldk != null && h.this.ldk.video_length.intValue() > 0 && h.this.ldk.video_duration.intValue() > 0) {
                    float intValue = h.this.ldk.video_length.intValue() * (1.0f - ((h.this.ihi.getCurrentPosition() * 1.0f) / (h.this.ldk.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kHX.getPageContext().getPageActivity(), String.format(h.this.kHX.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jZf = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.dfT();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.ldk != null) {
                h.this.f(h.this.ldk);
                h.this.ihi.dnw();
                h.this.ihi.cQw();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.ldz;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(boolean z) {
        if (this.kHX != null) {
            this.kHX.daZ();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.ldw = 0.0f;
        this.kHX = pbFragment;
        this.ldh = cVar;
        this.ldw = l.getDimens(this.kHX.getActivity(), R.dimen.ds240);
        this.ldB = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Ox);
        this.ibK.setTag(pbFragment.getUniqueId());
        this.ibK.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ibK);
        this.iDA = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.ldi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kHX.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kHX.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.kHX.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kHX.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.ldA = (intValue2 * 1.0d) / intValue;
            if (this.ldA > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.ldz = i;
        this.ldi.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bOo() {
        return this.ldA >= 1.0d;
    }

    public int dfz() {
        return this.ldz;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.ldg = (RelativeLayout) LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.ldi = (CustomFrameLayout) this.ldg.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afB = ((double) this.ldz) <= (((double) l.getEquipmentWidth(this.kHX.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.ihi = new com.baidu.tieba.play.c(this.kHX.getPageContext(), this.ldi, true);
        this.ihi.setStageType("2002");
        this.ihi.a(this.ldO);
        this.ihi.vk(false);
        this.ihi.a(this.ldE);
        this.ihi.Gc(ap.oe(R.drawable.pic_use_header_60_n));
        this.ihi.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kHX.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kHX.getBaseFragmentActivity())) {
            this.ihi.vb(false);
        }
        this.ihi.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.kHX.getListView() != null && h.this.kHX.getListView().getChildCount() > 0 && h.this.kHX.getListView().getChildAt(0) == h.this.dhi()) {
                            h.this.ldP = h.this.dhi().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.ldP = 0;
                        break;
                    case 2:
                        if (h.this.kHX.getListView() != null && h.this.kHX.getListView().getChildCount() > 0 && h.this.kHX.getListView().getChildAt(0) == h.this.dhi()) {
                            h.this.kHX.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.ldP);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.ldA >= 1.0d) {
                this.ihi.aw(false, true);
            } else {
                this.ihi.aw(true, false);
            }
            this.ldx = ((float) f) + this.ldw > ((float) l.getEquipmentHeight(this.kHX.getActivity()));
            if (this.ldx) {
                if (this.ldm == null) {
                    this.ldm = new f(this.kHX.getPageContext(), this.ldi);
                }
                this.kHX.daX().deS();
                this.ldn = true;
            }
        }
        dhd();
        this.mEmptyView = new View(this.kHX.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.ldz));
        if (this.ldh != null && this.ldh.mNavigationBar != null) {
            this.ldh.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.ldh.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.ldh.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bjp() && !TbSingleton.getInstance().isNotchScreen(this.kHX.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kHX.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.ldC = (PbVideoWifiTipLayout) this.ldg.findViewById(R.id.layout_wifi_tip);
        this.ldC.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.ldL = true;
                h.this.ldC.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.iDA != null) {
            this.iDA.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kHX.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.ldj == null) {
            this.ldj = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void oO(boolean z) {
                    if (h.this.dhg() && h.this.ldh != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.ldh.dfM().clearAnimation();
                        h.this.dhe();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jZf);
                            h.this.ldh.dfM().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void csc() {
                    if (h.this.dhg()) {
                        h.this.dfT();
                    }
                }
            };
        }
        a(this.ldj);
        this.lds = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kHX.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bw bwVar, final String str) {
        if (videoInfo != null && this.ihi != null && bwVar != null) {
            this.ldk = videoInfo;
            this.ldo = bwVar;
            this.mVideoUrl = videoInfo.video_url;
            this.ihi.stopPlay();
            this.ldl = new o();
            this.ldl.mLocate = "pb";
            this.ldl.alA = bwVar.getTid();
            this.ldl.eYo = str;
            this.ldl.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.isBjh()) {
                if (!StringUtils.isNull(this.kHX.kMI)) {
                    this.ldl.eaC = this.kHX.kMI;
                }
                this.ldl.lCh = this.kHX.kMH + "";
            } else {
                this.ldl.lCh = this.kHX.daU();
            }
            com.baidu.tbadk.core.data.bf dbJ = this.kHX.dbJ();
            if (dbJ != null) {
                dbJ.a(this.ldl);
            }
            this.ldl.lCk = videoInfo.video_md5;
            o dnO = this.ldl.dnO();
            dnO.mLocate = "6";
            this.startPosition = -1L;
            if (this.ihi.getVideoView() != null && this.ihi.getVideoView().getMediaProgressObserver() != null) {
                this.ihi.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ca(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean m29if = com.baidu.mcn.b.TD().m29if(mcnAdInfo.jump_url);
                            if (h.this.afB && !m29if && !h.this.ldt) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.iDA.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bDr = mcnAdInfo.card_title;
                                        aVar.bDs = mcnAdInfo.button_title;
                                        aVar.bDt = mcnAdInfo.jump_url;
                                        aVar.bDq = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bwVar.getTid();
                                        aVar.bDu = 4;
                                        if (z2) {
                                            h.this.iDA.b(aVar, (ViewGroup) h.this.ihi.dnv());
                                        } else {
                                            h.this.iDA.a(aVar, (ViewGroup) h.this.ihi.dnv());
                                        }
                                    }
                                } else if (h.this.iDA.isShowing()) {
                                    h.this.iDA.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.ihi.getVideoView().setVideoStatData(dnO);
            if (this.ihi.cQy()) {
                this.ihi.cQw();
            }
            this.ihi.b(this.ldF);
            this.ldq = null;
            this.ldp = null;
            this.ihi.OF(this.ldq);
            this.ihi.cQs().setOnDragingListener(kbd);
            this.ihi.a(new c.InterfaceC0779c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rJ() {
                    h.this.kHX.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.ldD > 0) {
                                h.this.Fl(h.this.ldD);
                                h.this.Fm(h.this.ldD);
                                h.this.ldD = 0;
                            }
                            h.this.ldG = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0779c
                public void rI() {
                    h.this.kHX.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.ldG = false;
                    h.this.ldD = h.this.bHA().getHeight();
                }
            });
            this.ihi.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dhk() {
                    if (h.this.kHX != null && h.this.ldp != null && !StringUtils.isNull(h.this.ldp.getId())) {
                        h.this.kHX.NV(h.this.ldp.getId());
                    }
                }
            });
            this.ihi.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void uk(boolean z) {
                    if (h.this.ldo != null) {
                        h.this.IS(z ? "1" : "2");
                    }
                }
            });
            this.ihi.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.ihi.setThumbnail(videoInfo.thumbnail_url);
            this.ihi.setVideoUrl(this.mVideoUrl, bwVar.getTid());
            this.ihi.setFid(str);
            this.ihi.Pf(bwVar.getTitle());
            this.ihi.a(ldQ);
            this.ihi.cDc();
            this.ihi.show();
        }
    }

    public void OE(String str) {
        if (this.ldl != null) {
            this.ldl.eYo = str;
        }
    }

    public void b(PostData postData, bw bwVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.ldm != null) {
            this.ldm.a(postData, bwVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.ldF = dVar;
    }

    public void aM(bw bwVar) {
        this.ldp = bwVar;
    }

    public void OF(String str) {
        this.ldq = str;
        if (this.ihi != null) {
            this.ihi.OF(this.ldq);
        }
    }

    public void startPlay() {
        if (this.ihi != null) {
            if (j.isMobileNet() && !this.ldL && !com.baidu.tieba.video.g.dEY().dEZ()) {
                this.ldC.setVisibility(0);
                this.ldC.setData(this.ldk);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.ldo != null && this.ldo.bfQ() != null) {
                TiebaStatic.log(new aq("c12619").dF("obj_locate", "pb").dF("tid", this.ldo.getTid()));
                this.mVideoUrl = this.ldo.bfQ().video_url;
            }
            this.ihi.fK(this.mVideoUrl, this.ldo == null ? "" : this.ldo.getTid());
            IS("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dhc() {
        if (this.ihi != null) {
            this.ihi.dhc();
        }
    }

    public void destroy() {
        if (this.ihi != null) {
            this.ihi.destroy();
        }
        if (this.ldi != null) {
            this.ldi.clearAnimation();
        }
        if (this.ldm != null) {
            this.ldm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Ox);
        MessageManager.getInstance().unRegisterListener(this.ibK);
    }

    public void onPause() {
        if (this.ihi != null) {
            if (this.ihi.rK()) {
                this.ldr = true;
                this.ihi.stopPlay();
            } else if (this.ihi.getCurrentState() == 3) {
                this.ldr = false;
            } else if (this.ihi.getCurrentState() == 0 || this.ihi.getCurrentState() == 1) {
                this.ldr = true;
                this.ihi.stopPlay();
            } else {
                this.ldr = false;
                this.ihi.stopPlay();
            }
            if (this.ldH != null) {
                this.ldH.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.ihi != null && this.ldr) {
            this.ihi.dnh();
        }
    }

    private void dhd() {
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.al(16908290).ak(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.kHX.getActivity());
                    if (h.this.ldK == null) {
                        try {
                            h.this.ldK = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.ldK);
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
                    h.this.ldJ = null;
                    if (h.this.ldK != null && !h.this.ldK.isRecycled()) {
                        h.this.ldK.recycle();
                    }
                    h.this.ldK = null;
                }
            });
            this.ldJ = dVar.mh();
            this.ldJ.showOnDecorView(this.kHX.getActivity());
        }
    }

    public boolean ya(int i) {
        if (this.ihi == null) {
            return false;
        }
        return this.ihi.Ge(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IS(String str) {
        if (this.ldk != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.ldk.video_md5, "", str, this.ldl, this.ihi.getVideoView().getPcdnState());
            }
        }
    }

    public void dhe() {
        if (this.ldh != null) {
            this.ldh.ua(this.kHX.cZX());
        }
    }

    public void dfT() {
        if (this.ldh != null) {
            this.ldh.dfT();
        }
    }

    public void EZ(int i) {
        if (this.ldh != null) {
            this.ldh.EZ(i);
        }
        if (this.ldH != null) {
            this.ldH.onChangeSkinType(i);
        }
        if (this.ldm != null) {
            this.ldm.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dhh()) {
                    this.ldu = i;
                    if (this.ldu == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.Fm(h.this.bHA().getHeight());
                            }
                        }, 100L);
                    }
                    dhf();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fl(int i) {
        if (bHA().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ldi.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.ldN = false;
                    if (this.ldz != bHA().getHeight()) {
                        this.ldi.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kHX.getActivity()), Math.min(this.ldz, bHA().getHeight() + i)));
                        this.ihi.cQw();
                    }
                } else if (l.getEquipmentWidth(this.kHX.getActivity()) * 0.5625d != bHA().getHeight()) {
                    this.ldi.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kHX.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kHX.getActivity()) * 0.5625d, bHA().getHeight() + i)));
                    this.ihi.cQw();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dhi()) {
                int bottom = childAt.getBottom() - bHA().getBottom();
                if (childAt.getHeight() == 0 || bHA().getHeight() == 0) {
                    bottom = 0;
                }
                Fl(bottom);
            } else {
                Fl((-this.ldz) + 2);
            }
        }
        if (!dhh() && this.ldG) {
            if (this.ldu == 1) {
                this.ldM = true;
                Fm(bHA().getHeight());
            } else if (this.ldu == 2) {
                this.ldM = true;
                int y = (int) bHA().getY();
                if (this.ldv == y) {
                    Fm(bHA().getHeight());
                } else {
                    this.ldv = y;
                    Fm(bHA().getHeight());
                }
                if (i == 0 && this.ldy) {
                    this.ldy = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dhc();
                        }
                    }, 100L);
                }
            } else if (this.ldu == 0) {
                if (this.ldM || !"nani_midpage".equals(this.kHX.daU())) {
                    Fm(bHA().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(int i) {
        Fn(i);
        dhf();
    }

    public void tM(boolean z) {
        this.ldN = z;
    }

    private void Fn(int i) {
        if (this.ldm != null) {
            if (this.ldo != null && this.ldo.bei()) {
                this.ldm.dha().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.ldz;
            }
            float f = this.ldz - i;
            float f2 = f > this.ldw ? 0.0f : 1.0f - (f / this.ldw);
            if (this.ldN) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.ldm.dha().setVisibility(8);
            } else {
                this.ldm.dha().setVisibility(0);
            }
            this.ldm.ax(f2);
        }
    }

    public void dhf() {
        if (this.ldm != null) {
            if (dhh()) {
                this.kHX.daX().deS();
            } else if (this.ldm.dha().getVisibility() == 0) {
                this.kHX.daX().deS();
                this.ldn = true;
            } else if (this.ldn) {
                this.kHX.daX().tL(false);
                this.ldn = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhg() {
        return bHA().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.ldt = false;
        if (this.ihi != null && this.ldi != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ldi.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.iDA != null && this.iDA.isShowing()) {
                    this.iDA.TE();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.ldJ != null) {
                    this.ldJ.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.ldt = true;
                this.ldi.setLayoutParams(layoutParams);
                this.kHX.daX().deS();
                this.ldn = true;
            } else {
                f(this.ldk);
                dhe();
                this.ldt = false;
                this.ldh.tZ(true);
            }
            this.ihi.a(this.kHX.getPageContext(), configuration);
        }
    }

    public boolean dhh() {
        return this.ldt;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.ldm != null) {
            this.ldm.V(onClickListener);
        }
    }

    public View bHA() {
        return this.ldg;
    }

    public boolean dfb() {
        if (bHA() == null) {
            return false;
        }
        return bHA().getBottom() > l.getEquipmentHeight(bHA().getContext()) - l.getDimens(bHA().getContext(), R.dimen.ds50);
    }

    public void dfx() {
        this.ldy = true;
    }

    public View dhi() {
        return this.mEmptyView;
    }
}
