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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
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
    private static VideoControllerView.a jCZ = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bst() {
        }
    };
    private static c.i kFw = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cel() {
        }
    };
    private float VN;
    private boolean aea;
    private com.baidu.tieba.play.c hLQ;
    private com.baidu.mcn.c ihR;
    private RelativeLayout kEM;
    private com.baidu.tieba.pb.pb.main.view.c kEN;
    private CustomFrameLayout kEO;
    private c.d kEP;
    private o kER;
    private f kES;
    private boolean kET;
    private bv kEU;
    private bv kEV;
    private String kEW;
    private float kFc;
    private int kFf;
    private double kFg;
    private long kFh;
    private PbVideoWifiTipLayout kFi;
    private int kFj;
    private c.d kFl;
    private PbFullScreenFloatingHuajiAninationView kFn;
    private com.baidu.adp.lib.guide.c kFp;
    private Bitmap kFq;
    private boolean kFr;
    private boolean kFt;
    private int kFv;
    private PbFragment kjZ;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo kEQ = null;
    private boolean kEX = false;
    private int kEY = 0;
    private boolean kEZ = false;
    private int kFa = 0;
    private int kFb = 0;
    private boolean kFd = false;
    private boolean kFe = false;
    private long startPosition = -1;
    private int hmU = 0;
    private c.p kFk = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cSM() {
            if (h.this.kjZ != null && h.this.kjZ.cLP() != null && h.this.kjZ.cLP().getPbData() != null) {
                PostData cKG = h.this.kjZ.cLP().getPbData().cKG();
                if (cKG == null && x.getCount(h.this.kjZ.cLP().getPbData().cKz()) > 1) {
                    cKG = (PostData) x.getItem(h.this.kjZ.cLP().getPbData().cKz(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kjZ.cLP().getPbData(), cKG, 1, 1, 4);
            }
        }
    };
    private boolean kFm = true;
    private PbFullScreenFloatingHuajiAninationView.a kFo = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.tq(false);
        }
    };
    private boolean kFs = false;
    private c.m kFu = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cSO() {
            if (h.this.kFg >= 1.0d) {
                if (h.this.kjZ.checkUpIsLogin()) {
                    h.this.kjZ.cNo();
                    if (h.this.kjZ.cLP() == null || h.this.kjZ.cLP().getPbData() == null || h.this.kjZ.cLP().getPbData().cKW() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o cKW = h.this.kjZ.cLP().getPbData().cKW();
                    if (h.this.kFn == null) {
                        h.this.kFn = new PbFullScreenFloatingHuajiAninationView(h.this.kjZ.getActivity());
                        h.this.kFn.setFloatingHuajiAninationListener(h.this.kFo);
                    }
                    h.this.kFn.tF(cKW.cLq() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cSP() {
            return false;
        }
    };
    private CustomMessageListener Ny = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hLQ != null) {
                    h.this.hLQ.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hLQ != null && h.this.hLQ.qg() && h.this.kEQ != null && h.this.kEQ.video_length.intValue() > 0 && h.this.kEQ.video_duration.intValue() > 0) {
                    float intValue = h.this.kEQ.video_length.intValue() * (1.0f - ((h.this.hLQ.getCurrentPosition() * 1.0f) / (h.this.kEQ.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kjZ.getPageContext().getPageActivity(), String.format(h.this.kjZ.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jBa = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cRy();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.kEQ != null) {
                h.this.f(h.this.kEQ);
                h.this.hLQ.cYK();
                h.this.hLQ.cBY();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kFf;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(boolean z) {
        if (this.kjZ != null) {
            this.kjZ.cMH();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kFc = 0.0f;
        this.kjZ = pbFragment;
        this.kEN = cVar;
        this.kFc = l.getDimens(this.kjZ.getActivity(), R.dimen.ds240);
        this.kFh = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Ny);
        this.hHo.setTag(pbFragment.getUniqueId());
        this.hHo.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hHo);
        this.ihR = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kEO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kjZ.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kjZ.getActivity());
        Rect visibilityRegion = be.getVisibilityRegion(this.kjZ.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kjZ.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kFg = (intValue2 * 1.0d) / intValue;
            if (this.kFg > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kFf = i;
        this.kEO.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bDD() {
        return this.kFg >= 1.0d;
    }

    public int cRe() {
        return this.kFf;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kEM = (RelativeLayout) LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kEO = (CustomFrameLayout) this.kEM.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.aea = ((double) this.kFf) <= (((double) l.getEquipmentWidth(this.kjZ.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hLQ = new com.baidu.tieba.play.c(this.kjZ.getPageContext(), this.kEO, true);
        this.hLQ.a(this.kFu);
        this.hLQ.uo(false);
        this.hLQ.a(this.kFk);
        this.hLQ.Dg(ao.lL(R.drawable.pic_use_header_60_n));
        this.hLQ.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kjZ.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kjZ.getBaseFragmentActivity())) {
            this.hLQ.uf(false);
        }
        this.hLQ.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.VN = motionEvent.getY();
                        if (h.this.kjZ.getListView() != null && h.this.kjZ.getListView().getChildCount() > 0 && h.this.kjZ.getListView().getChildAt(0) == h.this.cSL()) {
                            h.this.kFv = h.this.cSL().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.VN = 0.0f;
                        h.this.kFv = 0;
                        break;
                    case 2:
                        if (h.this.kjZ.getListView() != null && h.this.kjZ.getListView().getChildCount() > 0 && h.this.kjZ.getListView().getChildAt(0) == h.this.cSL()) {
                            h.this.kjZ.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.VN)) + h.this.kFv);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kFg >= 1.0d) {
                this.hLQ.ap(false, true);
            } else {
                this.hLQ.ap(true, false);
            }
            this.kFd = ((float) f) + this.kFc > ((float) l.getEquipmentHeight(this.kjZ.getActivity()));
            if (this.kFd) {
                if (this.kES == null) {
                    this.kES = new f(this.kjZ.getPageContext(), this.kEO);
                }
                this.kjZ.cMF().cQy();
                this.kET = true;
            }
        }
        cSG();
        this.mEmptyView = new View(this.kjZ.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kFf));
        if (this.kEN != null && this.kEN.mNavigationBar != null) {
            this.kEN.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kEN.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kEN.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aZZ() && !TbSingleton.getInstance().isNotchScreen(this.kjZ.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kjZ.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kFi = (PbVideoWifiTipLayout) this.kEM.findViewById(R.id.layout_wifi_tip);
        this.kFi.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kFr = true;
                h.this.kFi.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.ihR != null) {
            this.ihR.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kjZ.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kEP == null) {
            this.kEP = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void oc(boolean z) {
                    if (h.this.cSJ() && h.this.kEN != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kEN.cRr().clearAnimation();
                        h.this.cSH();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jBa);
                            h.this.kEN.cRr().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cek() {
                    if (h.this.cSJ()) {
                        h.this.cRy();
                    }
                }
            };
        }
        a(this.kEP);
        this.kEY = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kjZ.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bv bvVar, final String str) {
        if (videoInfo != null && this.hLQ != null && bvVar != null) {
            this.kEQ = videoInfo;
            this.kEU = bvVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hLQ.stopPlay();
            this.kER = new o();
            this.kER.mLocate = "pb";
            this.kER.ajJ = bvVar.getTid();
            this.kER.eKO = str;
            this.kER.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bvVar.isBjh()) {
                if (!StringUtils.isNull(this.kjZ.koJ)) {
                    this.kER.dOV = this.kjZ.koJ;
                }
                this.kER.lcJ = this.kjZ.koI + "";
            } else {
                this.kER.lcJ = this.kjZ.cMC();
            }
            com.baidu.tbadk.core.data.be cNq = this.kjZ.cNq();
            if (cNq != null) {
                cNq.a(this.kER);
            }
            this.kER.lcM = videoInfo.video_md5;
            o cZb = this.kER.cZb();
            cZb.mLocate = "6";
            this.startPosition = -1L;
            if (this.hLQ.getVideoView() != null && this.hLQ.getVideoView().getMediaProgressObserver() != null) {
                this.hLQ.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bP(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean gn = com.baidu.mcn.b.MN().gn(mcnAdInfo.jump_url);
                            if (h.this.aea && !gn && !h.this.kEZ) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.ihR.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bug = mcnAdInfo.card_title;
                                        aVar.buh = mcnAdInfo.button_title;
                                        aVar.bui = mcnAdInfo.jump_url;
                                        aVar.bue = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bvVar.getTid();
                                        aVar.buj = 4;
                                        if (z2) {
                                            h.this.ihR.b(aVar, (ViewGroup) h.this.hLQ.cYJ());
                                        } else {
                                            h.this.ihR.a(aVar, (ViewGroup) h.this.hLQ.cYJ());
                                        }
                                    }
                                } else if (h.this.ihR.isShowing()) {
                                    h.this.ihR.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.hLQ.getVideoView().setVideoStatData(cZb);
            if (this.hLQ.cCa()) {
                this.hLQ.cBY();
            }
            this.hLQ.b(this.kFl);
            this.kEW = null;
            this.kEV = null;
            this.hLQ.Lk(this.kEW);
            this.hLQ.cBU().setOnDragingListener(jCZ);
            this.hLQ.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                    h.this.kjZ.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kFj > 0) {
                                h.this.Cq(h.this.kFj);
                                h.this.Cr(h.this.kFj);
                                h.this.kFj = 0;
                            }
                            h.this.kFm = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                    h.this.kjZ.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kFm = false;
                    h.this.kFj = h.this.bxk().getHeight();
                }
            });
            this.hLQ.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cSN() {
                    if (h.this.kjZ != null && h.this.kEV != null && !StringUtils.isNull(h.this.kEV.getId())) {
                        h.this.kjZ.KA(h.this.kEV.getId());
                    }
                }
            });
            this.hLQ.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void tr(boolean z) {
                    if (h.this.kEU != null) {
                        h.this.FS(z ? "1" : "2");
                    }
                }
            });
            this.hLQ.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hLQ.setThumbnail(videoInfo.thumbnail_url);
            this.hLQ.setVideoUrl(this.mVideoUrl, bvVar.getTid());
            this.hLQ.setFid(str);
            this.hLQ.LK(bvVar.getTitle());
            this.hLQ.a(kFw);
            this.hLQ.coB();
            this.hLQ.show();
        }
    }

    public void Lj(String str) {
        if (this.kER != null) {
            this.kER.eKO = str;
        }
    }

    public void b(PostData postData, bv bvVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.kES != null) {
            this.kES.a(postData, bvVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.kFl = dVar;
    }

    public void aK(bv bvVar) {
        this.kEV = bvVar;
    }

    public void Lk(String str) {
        this.kEW = str;
        if (this.hLQ != null) {
            this.hLQ.Lk(this.kEW);
        }
    }

    public void startPlay() {
        if (this.hLQ != null) {
            if (j.isMobileNet() && !this.kFr && !com.baidu.tieba.video.g.dpz().dpA()) {
                this.kFi.setVisibility(0);
                this.kFi.setData(this.kEQ);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kEU != null && this.kEU.aWD() != null) {
                TiebaStatic.log(new ap("c12619").dn("obj_locate", "pb").dn("tid", this.kEU.getTid()));
                this.mVideoUrl = this.kEU.aWD().video_url;
            }
            this.hLQ.ff(this.mVideoUrl, this.kEU == null ? "" : this.kEU.getTid());
            FS("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cSF() {
        if (this.hLQ != null) {
            this.hLQ.cSF();
        }
    }

    public void destroy() {
        if (this.hLQ != null) {
            this.hLQ.destroy();
        }
        if (this.kEO != null) {
            this.kEO.clearAnimation();
        }
        if (this.kES != null) {
            this.kES.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Ny);
        MessageManager.getInstance().unRegisterListener(this.hHo);
    }

    public void onPause() {
        if (this.hLQ != null) {
            if (this.hLQ.qg()) {
                this.kEX = true;
                this.hLQ.stopPlay();
            } else if (this.hLQ.getCurrentState() == 3) {
                this.kEX = false;
            } else if (this.hLQ.getCurrentState() == 0 || this.hLQ.getCurrentState() == 1) {
                this.kEX = true;
                this.hLQ.stopPlay();
            } else {
                this.kEX = false;
                this.hLQ.stopPlay();
            }
            if (this.kFn != null) {
                this.kFn.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hLQ != null && this.kEX) {
            this.hLQ.cYw();
        }
    }

    private void cSG() {
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.ai(16908290).ah(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.kjZ.getActivity());
                    if (h.this.kFq == null) {
                        try {
                            h.this.kFq = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kFq);
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
                    h.this.kFp = null;
                    if (h.this.kFq != null && !h.this.kFq.isRecycled()) {
                        h.this.kFq.recycle();
                    }
                    h.this.kFq = null;
                }
            });
            this.kFp = dVar.kE();
            this.kFp.showOnDecorView(this.kjZ.getActivity());
        }
    }

    public boolean vj(int i) {
        if (this.hLQ == null) {
            return false;
        }
        return this.hLQ.Di(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(String str) {
        if (this.kEQ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.kEQ.video_md5, "", str, this.kER, this.hLQ.getVideoView().getPcdnState());
            }
        }
    }

    public void cSH() {
        if (this.kEN != null) {
            this.kEN.ti(this.kjZ.cLF());
        }
    }

    public void cRy() {
        if (this.kEN != null) {
            this.kEN.cRy();
        }
    }

    public void Ce(int i) {
        if (this.kEN != null) {
            this.kEN.Ce(i);
        }
        if (this.kFn != null) {
            this.kFn.onChangeSkinType(i);
        }
        if (this.kES != null) {
            this.kES.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cSK()) {
                    this.kFa = i;
                    if (this.kFa == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.Cr(h.this.bxk().getHeight());
                            }
                        }, 100L);
                    }
                    cSI();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cq(int i) {
        if (bxk().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kEO.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kFt = false;
                    if (this.kFf != bxk().getHeight()) {
                        this.kEO.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kjZ.getActivity()), Math.min(this.kFf, bxk().getHeight() + i)));
                        this.hLQ.cBY();
                    }
                } else if (l.getEquipmentWidth(this.kjZ.getActivity()) * 0.5625d != bxk().getHeight()) {
                    this.kEO.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kjZ.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kjZ.getActivity()) * 0.5625d, bxk().getHeight() + i)));
                    this.hLQ.cBY();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cSL()) {
                int bottom = childAt.getBottom() - bxk().getBottom();
                if (childAt.getHeight() == 0 || bxk().getHeight() == 0) {
                    bottom = 0;
                }
                Cq(bottom);
            } else {
                Cq((-this.kFf) + 2);
            }
        }
        if (!cSK() && this.kFm) {
            if (this.kFa == 1) {
                this.kFs = true;
                Cr(bxk().getHeight());
            } else if (this.kFa == 2) {
                this.kFs = true;
                int y = (int) bxk().getY();
                if (this.kFb == y) {
                    Cr(bxk().getHeight());
                } else {
                    this.kFb = y;
                    Cr(bxk().getHeight());
                }
                if (i == 0 && this.kFe) {
                    this.kFe = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cSF();
                        }
                    }, 100L);
                }
            } else if (this.kFa == 0) {
                if (this.kFs || !"nani_midpage".equals(this.kjZ.cMC())) {
                    Cr(bxk().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr(int i) {
        Cs(i);
        cSI();
    }

    public void sU(boolean z) {
        this.kFt = z;
    }

    private void Cs(int i) {
        if (this.kES != null) {
            if (this.kEU != null && this.kEU.aUV()) {
                this.kES.cSD().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kFf;
            }
            float f = this.kFf - i;
            float f2 = f > this.kFc ? 0.0f : 1.0f - (f / this.kFc);
            if (this.kFt) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kES.cSD().setVisibility(8);
            } else {
                this.kES.cSD().setVisibility(0);
            }
            this.kES.ar(f2);
        }
    }

    public void cSI() {
        if (this.kES != null) {
            if (cSK()) {
                this.kjZ.cMF().cQy();
            } else if (this.kES.cSD().getVisibility() == 0) {
                this.kjZ.cMF().cQy();
                this.kET = true;
            } else if (this.kET) {
                this.kjZ.cMF().sT(false);
                this.kET = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cSJ() {
        return bxk().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kEZ = false;
        if (this.hLQ != null && this.kEO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kEO.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.ihR != null && this.ihR.isShowing()) {
                    this.ihR.MO();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kFp != null) {
                    this.kFp.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kEZ = true;
                this.kEO.setLayoutParams(layoutParams);
                this.kjZ.cMF().cQy();
                this.kET = true;
            } else {
                f(this.kEQ);
                cSH();
                this.kEZ = false;
                this.kEN.th(true);
            }
            this.hLQ.a(this.kjZ.getPageContext(), configuration);
        }
    }

    public boolean cSK() {
        return this.kEZ;
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.kES != null) {
            this.kES.U(onClickListener);
        }
    }

    public View bxk() {
        return this.kEM;
    }

    public boolean cQH() {
        if (bxk() == null) {
            return false;
        }
        return bxk().getBottom() > l.getEquipmentHeight(bxk().getContext()) - l.getDimens(bxk().getContext(), R.dimen.ds50);
    }

    public void cRc() {
        this.kFe = true;
    }

    public View cSL() {
        return this.mEmptyView;
    }
}
