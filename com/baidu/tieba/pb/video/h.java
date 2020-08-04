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
    private static VideoControllerView.a jDb = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bst() {
        }
    };
    private static c.i kFy = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cel() {
        }
    };
    private float VN;
    private boolean aea;
    private com.baidu.tieba.play.c hLS;
    private com.baidu.mcn.c ihT;
    private RelativeLayout kEO;
    private com.baidu.tieba.pb.pb.main.view.c kEP;
    private CustomFrameLayout kEQ;
    private c.d kER;
    private o kET;
    private f kEU;
    private boolean kEV;
    private bv kEW;
    private bv kEX;
    private String kEY;
    private float kFe;
    private int kFh;
    private double kFi;
    private long kFj;
    private PbVideoWifiTipLayout kFk;
    private int kFl;
    private c.d kFn;
    private PbFullScreenFloatingHuajiAninationView kFp;
    private com.baidu.adp.lib.guide.c kFr;
    private Bitmap kFs;
    private boolean kFt;
    private boolean kFv;
    private int kFx;
    private PbFragment kkb;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo kES = null;
    private boolean kEZ = false;
    private int kFa = 0;
    private boolean kFb = false;
    private int kFc = 0;
    private int kFd = 0;
    private boolean kFf = false;
    private boolean kFg = false;
    private long startPosition = -1;
    private int hmU = 0;
    private c.p kFm = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cSM() {
            if (h.this.kkb != null && h.this.kkb.cLP() != null && h.this.kkb.cLP().getPbData() != null) {
                PostData cKG = h.this.kkb.cLP().getPbData().cKG();
                if (cKG == null && x.getCount(h.this.kkb.cLP().getPbData().cKz()) > 1) {
                    cKG = (PostData) x.getItem(h.this.kkb.cLP().getPbData().cKz(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kkb.cLP().getPbData(), cKG, 1, 1, 4);
            }
        }
    };
    private boolean kFo = true;
    private PbFullScreenFloatingHuajiAninationView.a kFq = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.tq(false);
        }
    };
    private boolean kFu = false;
    private c.m kFw = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cSO() {
            if (h.this.kFi >= 1.0d) {
                if (h.this.kkb.checkUpIsLogin()) {
                    h.this.kkb.cNo();
                    if (h.this.kkb.cLP() == null || h.this.kkb.cLP().getPbData() == null || h.this.kkb.cLP().getPbData().cKW() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o cKW = h.this.kkb.cLP().getPbData().cKW();
                    if (h.this.kFp == null) {
                        h.this.kFp = new PbFullScreenFloatingHuajiAninationView(h.this.kkb.getActivity());
                        h.this.kFp.setFloatingHuajiAninationListener(h.this.kFq);
                    }
                    h.this.kFp.tF(cKW.cLq() ? false : true);
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
                if (h.this.hLS != null) {
                    h.this.hLS.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hLS != null && h.this.hLS.qg() && h.this.kES != null && h.this.kES.video_length.intValue() > 0 && h.this.kES.video_duration.intValue() > 0) {
                    float intValue = h.this.kES.video_length.intValue() * (1.0f - ((h.this.hLS.getCurrentPosition() * 1.0f) / (h.this.kES.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kkb.getPageContext().getPageActivity(), String.format(h.this.kkb.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener jBc = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
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
            if (h.this.kES != null) {
                h.this.f(h.this.kES);
                h.this.hLS.cYK();
                h.this.hLS.cBY();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.kFh;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(boolean z) {
        if (this.kkb != null) {
            this.kkb.cMH();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.kFe = 0.0f;
        this.kkb = pbFragment;
        this.kEP = cVar;
        this.kFe = l.getDimens(this.kkb.getActivity(), R.dimen.ds240);
        this.kFj = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.Ny);
        this.hHo.setTag(pbFragment.getUniqueId());
        this.hHo.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hHo);
        this.ihT = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.kEQ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kkb.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kkb.getActivity());
        Rect visibilityRegion = be.getVisibilityRegion(this.kkb.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kkb.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.kFi = (intValue2 * 1.0d) / intValue;
            if (this.kFi > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.kFh = i;
        this.kEQ.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bDD() {
        return this.kFi >= 1.0d;
    }

    public int cRe() {
        return this.kFh;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.kEO = (RelativeLayout) LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.kEQ = (CustomFrameLayout) this.kEO.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.aea = ((double) this.kFh) <= (((double) l.getEquipmentWidth(this.kkb.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hLS = new com.baidu.tieba.play.c(this.kkb.getPageContext(), this.kEQ, true);
        this.hLS.a(this.kFw);
        this.hLS.uo(false);
        this.hLS.a(this.kFm);
        this.hLS.Dg(ao.lL(R.drawable.pic_use_header_60_n));
        this.hLS.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kkb.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kkb.getBaseFragmentActivity())) {
            this.hLS.uf(false);
        }
        this.hLS.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.kkb.getListView() != null && h.this.kkb.getListView().getChildCount() > 0 && h.this.kkb.getListView().getChildAt(0) == h.this.cSL()) {
                            h.this.kFx = h.this.cSL().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.VN = 0.0f;
                        h.this.kFx = 0;
                        break;
                    case 2:
                        if (h.this.kkb.getListView() != null && h.this.kkb.getListView().getChildCount() > 0 && h.this.kkb.getListView().getChildAt(0) == h.this.cSL()) {
                            h.this.kkb.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.VN)) + h.this.kFx);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.kFi >= 1.0d) {
                this.hLS.ap(false, true);
            } else {
                this.hLS.ap(true, false);
            }
            this.kFf = ((float) f) + this.kFe > ((float) l.getEquipmentHeight(this.kkb.getActivity()));
            if (this.kFf) {
                if (this.kEU == null) {
                    this.kEU = new f(this.kkb.getPageContext(), this.kEQ);
                }
                this.kkb.cMF().cQy();
                this.kEV = true;
            }
        }
        cSG();
        this.mEmptyView = new View(this.kkb.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.kFh));
        if (this.kEP != null && this.kEP.mNavigationBar != null) {
            this.kEP.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.kEP.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.kEP.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aZZ() && !TbSingleton.getInstance().isNotchScreen(this.kkb.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kkb.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.kFk = (PbVideoWifiTipLayout) this.kEO.findViewById(R.id.layout_wifi_tip);
        this.kFk.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.kFt = true;
                h.this.kFk.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.ihT != null) {
            this.ihT.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kkb.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.kER == null) {
            this.kER = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void oc(boolean z) {
                    if (h.this.cSJ() && h.this.kEP != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.kEP.cRr().clearAnimation();
                        h.this.cSH();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.jBc);
                            h.this.kEP.cRr().startAnimation(loadAnimation);
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
        a(this.kER);
        this.kFa = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kkb.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bv bvVar, final String str) {
        if (videoInfo != null && this.hLS != null && bvVar != null) {
            this.kES = videoInfo;
            this.kEW = bvVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hLS.stopPlay();
            this.kET = new o();
            this.kET.mLocate = "pb";
            this.kET.ajJ = bvVar.getTid();
            this.kET.eKO = str;
            this.kET.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bvVar.isBjh()) {
                if (!StringUtils.isNull(this.kkb.koL)) {
                    this.kET.dOV = this.kkb.koL;
                }
                this.kET.lcL = this.kkb.koK + "";
            } else {
                this.kET.lcL = this.kkb.cMC();
            }
            com.baidu.tbadk.core.data.be cNq = this.kkb.cNq();
            if (cNq != null) {
                cNq.a(this.kET);
            }
            this.kET.lcO = videoInfo.video_md5;
            o cZb = this.kET.cZb();
            cZb.mLocate = "6";
            this.startPosition = -1L;
            if (this.hLS.getVideoView() != null && this.hLS.getVideoView().getMediaProgressObserver() != null) {
                this.hLS.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void bP(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean gn = com.baidu.mcn.b.MN().gn(mcnAdInfo.jump_url);
                            if (h.this.aea && !gn && !h.this.kFb) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.ihT.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bug = mcnAdInfo.card_title;
                                        aVar.buh = mcnAdInfo.button_title;
                                        aVar.bui = mcnAdInfo.jump_url;
                                        aVar.bue = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bvVar.getTid();
                                        aVar.buj = 4;
                                        if (z2) {
                                            h.this.ihT.b(aVar, (ViewGroup) h.this.hLS.cYJ());
                                        } else {
                                            h.this.ihT.a(aVar, (ViewGroup) h.this.hLS.cYJ());
                                        }
                                    }
                                } else if (h.this.ihT.isShowing()) {
                                    h.this.ihT.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.hLS.getVideoView().setVideoStatData(cZb);
            if (this.hLS.cCa()) {
                this.hLS.cBY();
            }
            this.hLS.b(this.kFn);
            this.kEY = null;
            this.kEX = null;
            this.hLS.Lk(this.kEY);
            this.hLS.cBU().setOnDragingListener(jDb);
            this.hLS.a(new c.InterfaceC0731c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qf() {
                    h.this.kkb.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.kFl > 0) {
                                h.this.Cq(h.this.kFl);
                                h.this.Cr(h.this.kFl);
                                h.this.kFl = 0;
                            }
                            h.this.kFo = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0731c
                public void qe() {
                    h.this.kkb.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.kFo = false;
                    h.this.kFl = h.this.bxk().getHeight();
                }
            });
            this.hLS.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cSN() {
                    if (h.this.kkb != null && h.this.kEX != null && !StringUtils.isNull(h.this.kEX.getId())) {
                        h.this.kkb.KA(h.this.kEX.getId());
                    }
                }
            });
            this.hLS.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void tr(boolean z) {
                    if (h.this.kEW != null) {
                        h.this.FS(z ? "1" : "2");
                    }
                }
            });
            this.hLS.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hLS.setThumbnail(videoInfo.thumbnail_url);
            this.hLS.setVideoUrl(this.mVideoUrl, bvVar.getTid());
            this.hLS.setFid(str);
            this.hLS.LK(bvVar.getTitle());
            this.hLS.a(kFy);
            this.hLS.coB();
            this.hLS.show();
        }
    }

    public void Lj(String str) {
        if (this.kET != null) {
            this.kET.eKO = str;
        }
    }

    public void b(PostData postData, bv bvVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.kEU != null) {
            this.kEU.a(postData, bvVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.kFn = dVar;
    }

    public void aK(bv bvVar) {
        this.kEX = bvVar;
    }

    public void Lk(String str) {
        this.kEY = str;
        if (this.hLS != null) {
            this.hLS.Lk(this.kEY);
        }
    }

    public void startPlay() {
        if (this.hLS != null) {
            if (j.isMobileNet() && !this.kFt && !com.baidu.tieba.video.g.dpA().dpB()) {
                this.kFk.setVisibility(0);
                this.kFk.setData(this.kES);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.kEW != null && this.kEW.aWD() != null) {
                TiebaStatic.log(new ap("c12619").dn("obj_locate", "pb").dn("tid", this.kEW.getTid()));
                this.mVideoUrl = this.kEW.aWD().video_url;
            }
            this.hLS.ff(this.mVideoUrl, this.kEW == null ? "" : this.kEW.getTid());
            FS("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cSF() {
        if (this.hLS != null) {
            this.hLS.cSF();
        }
    }

    public void destroy() {
        if (this.hLS != null) {
            this.hLS.destroy();
        }
        if (this.kEQ != null) {
            this.kEQ.clearAnimation();
        }
        if (this.kEU != null) {
            this.kEU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.Ny);
        MessageManager.getInstance().unRegisterListener(this.hHo);
    }

    public void onPause() {
        if (this.hLS != null) {
            if (this.hLS.qg()) {
                this.kEZ = true;
                this.hLS.stopPlay();
            } else if (this.hLS.getCurrentState() == 3) {
                this.kEZ = false;
            } else if (this.hLS.getCurrentState() == 0 || this.hLS.getCurrentState() == 1) {
                this.kEZ = true;
                this.hLS.stopPlay();
            } else {
                this.kEZ = false;
                this.hLS.stopPlay();
            }
            if (this.kFp != null) {
                this.kFp.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hLS != null && this.kEZ) {
            this.hLS.cYw();
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
                    ImageView imageView = new ImageView(h.this.kkb.getActivity());
                    if (h.this.kFs == null) {
                        try {
                            h.this.kFs = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.kFs);
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
                    h.this.kFr = null;
                    if (h.this.kFs != null && !h.this.kFs.isRecycled()) {
                        h.this.kFs.recycle();
                    }
                    h.this.kFs = null;
                }
            });
            this.kFr = dVar.kE();
            this.kFr.showOnDecorView(this.kkb.getActivity());
        }
    }

    public boolean vj(int i) {
        if (this.hLS == null) {
            return false;
        }
        return this.hLS.Di(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(String str) {
        if (this.kES != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.kES.video_md5, "", str, this.kET, this.hLS.getVideoView().getPcdnState());
            }
        }
    }

    public void cSH() {
        if (this.kEP != null) {
            this.kEP.ti(this.kkb.cLF());
        }
    }

    public void cRy() {
        if (this.kEP != null) {
            this.kEP.cRy();
        }
    }

    public void Ce(int i) {
        if (this.kEP != null) {
            this.kEP.Ce(i);
        }
        if (this.kFp != null) {
            this.kFp.onChangeSkinType(i);
        }
        if (this.kEU != null) {
            this.kEU.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cSK()) {
                    this.kFc = i;
                    if (this.kFc == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kEQ.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.kFv = false;
                    if (this.kFh != bxk().getHeight()) {
                        this.kEQ.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kkb.getActivity()), Math.min(this.kFh, bxk().getHeight() + i)));
                        this.hLS.cBY();
                    }
                } else if (l.getEquipmentWidth(this.kkb.getActivity()) * 0.5625d != bxk().getHeight()) {
                    this.kEQ.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kkb.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kkb.getActivity()) * 0.5625d, bxk().getHeight() + i)));
                    this.hLS.cBY();
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
                Cq((-this.kFh) + 2);
            }
        }
        if (!cSK() && this.kFo) {
            if (this.kFc == 1) {
                this.kFu = true;
                Cr(bxk().getHeight());
            } else if (this.kFc == 2) {
                this.kFu = true;
                int y = (int) bxk().getY();
                if (this.kFd == y) {
                    Cr(bxk().getHeight());
                } else {
                    this.kFd = y;
                    Cr(bxk().getHeight());
                }
                if (i == 0 && this.kFg) {
                    this.kFg = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cSF();
                        }
                    }, 100L);
                }
            } else if (this.kFc == 0) {
                if (this.kFu || !"nani_midpage".equals(this.kkb.cMC())) {
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
        this.kFv = z;
    }

    private void Cs(int i) {
        if (this.kEU != null) {
            if (this.kEW != null && this.kEW.aUV()) {
                this.kEU.cSD().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.kFh;
            }
            float f = this.kFh - i;
            float f2 = f > this.kFe ? 0.0f : 1.0f - (f / this.kFe);
            if (this.kFv) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.kEU.cSD().setVisibility(8);
            } else {
                this.kEU.cSD().setVisibility(0);
            }
            this.kEU.ar(f2);
        }
    }

    public void cSI() {
        if (this.kEU != null) {
            if (cSK()) {
                this.kkb.cMF().cQy();
            } else if (this.kEU.cSD().getVisibility() == 0) {
                this.kkb.cMF().cQy();
                this.kEV = true;
            } else if (this.kEV) {
                this.kkb.cMF().sT(false);
                this.kEV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cSJ() {
        return bxk().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.kFb = false;
        if (this.hLS != null && this.kEQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kEQ.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.ihT != null && this.ihT.isShowing()) {
                    this.ihT.MO();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.kFr != null) {
                    this.kFr.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.kFb = true;
                this.kEQ.setLayoutParams(layoutParams);
                this.kkb.cMF().cQy();
                this.kEV = true;
            } else {
                f(this.kES);
                cSH();
                this.kFb = false;
                this.kEP.th(true);
            }
            this.hLS.a(this.kkb.getPageContext(), configuration);
        }
    }

    public boolean cSK() {
        return this.kFb;
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.kEU != null) {
            this.kEU.U(onClickListener);
        }
    }

    public View bxk() {
        return this.kEO;
    }

    public boolean cQH() {
        if (bxk() == null) {
            return false;
        }
        return bxk().getBottom() > l.getEquipmentHeight(bxk().getContext()) - l.getDimens(bxk().getContext(), R.dimen.ds50);
    }

    public void cRc() {
        this.kFg = true;
    }

    public View cSL() {
        return this.mEmptyView;
    }
}
