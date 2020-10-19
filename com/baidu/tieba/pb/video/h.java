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
/* loaded from: classes22.dex */
public class h {
    private static VideoControllerView.a kqr = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bFp() {
        }
    };
    private static c.i lth = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cvA() {
        }
    };
    private boolean afS;
    private com.baidu.mcn.c iSq;
    private com.baidu.tieba.play.c iwf;
    private PbFragment kXi;
    private c.d lsA;
    private o lsC;
    private f lsD;
    private boolean lsE;
    private bw lsF;
    private bw lsG;
    private String lsH;
    private float lsN;
    private int lsQ;
    private double lsR;
    private long lsS;
    private PbVideoWifiTipLayout lsT;
    private int lsU;
    private c.d lsW;
    private PbFullScreenFloatingHuajiAninationView lsY;
    private RelativeLayout lsx;
    private com.baidu.tieba.pb.pb.main.view.c lsy;
    private CustomFrameLayout lsz;
    private com.baidu.adp.lib.guide.c lta;
    private Bitmap ltb;
    private boolean ltc;
    private boolean lte;
    private int ltg;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo lsB = null;
    private boolean lsI = false;
    private int lsJ = 0;
    private boolean lsK = false;
    private int lsL = 0;
    private int lsM = 0;
    private boolean lsO = false;
    private boolean lsP = false;
    private long startPosition = -1;
    private int hVO = 0;
    private c.p lsV = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void dkS() {
            if (h.this.kXi != null && h.this.kXi.ddQ() != null && h.this.kXi.ddQ().getPbData() != null) {
                PostData dcJ = h.this.kXi.ddQ().getPbData().dcJ();
                if (dcJ == null && y.getCount(h.this.kXi.ddQ().getPbData().dcC()) > 1) {
                    dcJ = (PostData) y.getItem(h.this.kXi.ddQ().getPbData().dcC(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.kXi.ddQ().getPbData(), dcJ, 1, 1, 4);
            }
        }
    };
    private boolean lsX = true;
    private PbFullScreenFloatingHuajiAninationView.a lsZ = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.uQ(false);
        }
    };
    private boolean ltd = false;
    private c.m ltf = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dkU() {
            if (h.this.lsR >= 1.0d) {
                if (h.this.kXi.checkUpIsLogin()) {
                    h.this.kXi.dfq();
                    if (h.this.kXi.ddQ() == null || h.this.kXi.ddQ().getPbData() == null || h.this.kXi.ddQ().getPbData().dcZ() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dcZ = h.this.kXi.ddQ().getPbData().dcZ();
                    if (h.this.lsY == null) {
                        h.this.lsY = new PbFullScreenFloatingHuajiAninationView(h.this.kXi.getActivity());
                        h.this.lsY.setFloatingHuajiAninationListener(h.this.lsZ);
                    }
                    h.this.lsY.vf(dcZ.dds() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dkV() {
            return false;
        }
    };
    private CustomMessageListener OP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.iwf != null) {
                    h.this.iwf.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.iwf != null && h.this.iwf.rK() && h.this.lsB != null && h.this.lsB.video_length.intValue() > 0 && h.this.lsB.video_duration.intValue() > 0) {
                    float intValue = h.this.lsB.video_length.intValue() * (1.0f - ((h.this.iwf.getCurrentPosition() * 1.0f) / (h.this.lsB.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.kXi.getPageContext().getPageActivity(), String.format(h.this.kXi.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kou = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.djC();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener iqL = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.lsB != null) {
                h.this.f(h.this.lsB);
                h.this.iwf.drh();
                h.this.iwf.cUg();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.lsQ;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(boolean z) {
        if (this.kXi != null) {
            this.kXi.deI();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.lsN = 0.0f;
        this.kXi = pbFragment;
        this.lsy = cVar;
        this.lsN = l.getDimens(this.kXi.getActivity(), R.dimen.ds240);
        this.lsS = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.OP);
        this.iqL.setTag(pbFragment.getUniqueId());
        this.iqL.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iqL);
        this.iSq = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lsz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.kXi.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.kXi.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.kXi.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.kXi.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.lsR = (intValue2 * 1.0d) / intValue;
            if (this.lsR > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.lsQ = i;
        this.lsz.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bRF() {
        return this.lsR >= 1.0d;
    }

    public int dji() {
        return this.lsQ;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lsx = (RelativeLayout) LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lsz = (CustomFrameLayout) this.lsx.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afS = ((double) this.lsQ) <= (((double) l.getEquipmentWidth(this.kXi.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.iwf = new com.baidu.tieba.play.c(this.kXi.getPageContext(), this.lsz, true);
        this.iwf.setStageType("2002");
        this.iwf.a(this.ltf);
        this.iwf.vR(false);
        this.iwf.a(this.lsV);
        this.iwf.GI(ap.oB(R.drawable.pic_use_header_60_n));
        this.iwf.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.kXi.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.kXi.getBaseFragmentActivity())) {
            this.iwf.vI(false);
        }
        this.iwf.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.kXi.getListView() != null && h.this.kXi.getListView().getChildCount() > 0 && h.this.kXi.getListView().getChildAt(0) == h.this.dkR()) {
                            h.this.ltg = h.this.dkR().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.ltg = 0;
                        break;
                    case 2:
                        if (h.this.kXi.getListView() != null && h.this.kXi.getListView().getChildCount() > 0 && h.this.kXi.getListView().getChildAt(0) == h.this.dkR()) {
                            h.this.kXi.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.ltg);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.lsR >= 1.0d) {
                this.iwf.av(false, true);
            } else {
                this.iwf.av(true, false);
            }
            this.lsO = ((float) f) + this.lsN > ((float) l.getEquipmentHeight(this.kXi.getActivity()));
            if (this.lsO) {
                if (this.lsD == null) {
                    this.lsD = new f(this.kXi.getPageContext(), this.lsz);
                }
                this.kXi.deG().diB();
                this.lsE = true;
            }
        }
        dkM();
        this.mEmptyView = new View(this.kXi.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.lsQ));
        if (this.lsy != null && this.lsy.mNavigationBar != null) {
            this.lsy.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lsy.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lsy.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.blY() && !TbSingleton.getInstance().isNotchScreen(this.kXi.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kXi.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.lsT = (PbVideoWifiTipLayout) this.lsx.findViewById(R.id.layout_wifi_tip);
        this.lsT.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.ltc = true;
                h.this.lsT.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.iSq != null) {
            this.iSq.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.kXi.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lsA == null) {
            this.lsA = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void pt(boolean z) {
                    if (h.this.dkP() && h.this.lsy != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.lsy.djv().clearAnimation();
                        h.this.dkN();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.kou);
                            h.this.lsy.djv().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cvz() {
                    if (h.this.dkP()) {
                        h.this.djC();
                    }
                }
            };
        }
        a(this.lsA);
        this.lsJ = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.kXi.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bw bwVar, final String str) {
        if (videoInfo != null && this.iwf != null && bwVar != null) {
            this.lsB = videoInfo;
            this.lsF = bwVar;
            this.mVideoUrl = videoInfo.video_url;
            this.iwf.stopPlay();
            this.lsC = new o();
            this.lsC.mLocate = "pb";
            this.lsC.alS = bwVar.getTid();
            this.lsC.fkA = str;
            this.lsC.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.isBjh()) {
                if (!StringUtils.isNull(this.kXi.lbU)) {
                    this.lsC.emE = this.kXi.lbU;
                }
                this.lsC.lRw = this.kXi.lbT + "";
            } else {
                this.lsC.lRw = this.kXi.deD();
            }
            com.baidu.tbadk.core.data.bf dfs = this.kXi.dfs();
            if (dfs != null) {
                dfs.a(this.lsC);
            }
            this.lsC.lRz = videoInfo.video_md5;
            o drz = this.lsC.drz();
            drz.mLocate = "6";
            this.startPosition = -1L;
            if (this.iwf.getVideoView() != null && this.iwf.getVideoView().getMediaProgressObserver() != null) {
                this.iwf.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ca(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean iG = com.baidu.mcn.b.Vw().iG(mcnAdInfo.jump_url);
                            if (h.this.afS && !iG && !h.this.lsK) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.iSq.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bJT = mcnAdInfo.card_title;
                                        aVar.bJU = mcnAdInfo.button_title;
                                        aVar.bJV = mcnAdInfo.jump_url;
                                        aVar.bJS = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bwVar.getTid();
                                        aVar.bJW = 4;
                                        if (z2) {
                                            h.this.iSq.b(aVar, (ViewGroup) h.this.iwf.drg());
                                        } else {
                                            h.this.iSq.a(aVar, (ViewGroup) h.this.iwf.drg());
                                        }
                                    }
                                } else if (h.this.iSq.isShowing()) {
                                    h.this.iSq.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.iwf.getVideoView().setVideoStatData(drz);
            if (this.iwf.cUi()) {
                this.iwf.cUg();
            }
            this.iwf.b(this.lsW);
            this.lsH = null;
            this.lsG = null;
            this.iwf.Pu(this.lsH);
            this.iwf.cUc().setOnDragingListener(kqr);
            this.iwf.a(new c.InterfaceC0797c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rJ() {
                    h.this.kXi.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.lsU > 0) {
                                h.this.FR(h.this.lsU);
                                h.this.FS(h.this.lsU);
                                h.this.lsU = 0;
                            }
                            h.this.lsX = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0797c
                public void rI() {
                    h.this.kXi.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.lsX = false;
                    h.this.lsU = h.this.bKm().getHeight();
                }
            });
            this.iwf.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dkT() {
                    if (h.this.kXi != null && h.this.lsG != null && !StringUtils.isNull(h.this.lsG.getId())) {
                        h.this.kXi.OK(h.this.lsG.getId());
                    }
                }
            });
            this.iwf.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void uR(boolean z) {
                    if (h.this.lsF != null) {
                        h.this.JF(z ? "1" : "2");
                    }
                }
            });
            this.iwf.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.iwf.setThumbnail(videoInfo.thumbnail_url);
            this.iwf.setVideoUrl(this.mVideoUrl, bwVar.getTid());
            this.iwf.setFid(str);
            this.iwf.PU(bwVar.getTitle());
            this.iwf.a(lth);
            this.iwf.cGL();
            this.iwf.show();
        }
    }

    public void Pt(String str) {
        if (this.lsC != null) {
            this.lsC.fkA = str;
        }
    }

    public void b(PostData postData, bw bwVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lsD != null) {
            this.lsD.a(postData, bwVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.lsW = dVar;
    }

    public void aM(bw bwVar) {
        this.lsG = bwVar;
    }

    public void Pu(String str) {
        this.lsH = str;
        if (this.iwf != null) {
            this.iwf.Pu(this.lsH);
        }
    }

    public void startPlay() {
        if (this.iwf != null) {
            if (j.isMobileNet() && !this.ltc && !com.baidu.tieba.video.g.dIK().dIL()) {
                this.lsT.setVisibility(0);
                this.lsT.setData(this.lsB);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lsF != null && this.lsF.biz() != null) {
                TiebaStatic.log(new aq("c12619").dK("obj_locate", "pb").dK("tid", this.lsF.getTid()));
                this.mVideoUrl = this.lsF.biz().video_url;
            }
            this.iwf.fR(this.mVideoUrl, this.lsF == null ? "" : this.lsF.getTid());
            JF("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dkL() {
        if (this.iwf != null) {
            this.iwf.dkL();
        }
    }

    public void destroy() {
        if (this.iwf != null) {
            this.iwf.destroy();
        }
        if (this.lsz != null) {
            this.lsz.clearAnimation();
        }
        if (this.lsD != null) {
            this.lsD.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.OP);
        MessageManager.getInstance().unRegisterListener(this.iqL);
    }

    public void onPause() {
        if (this.iwf != null) {
            if (this.iwf.rK()) {
                this.lsI = true;
                this.iwf.stopPlay();
            } else if (this.iwf.getCurrentState() == 3) {
                this.lsI = false;
            } else if (this.iwf.getCurrentState() == 0 || this.iwf.getCurrentState() == 1) {
                this.lsI = true;
                this.iwf.stopPlay();
            } else {
                this.lsI = false;
                this.iwf.stopPlay();
            }
            if (this.lsY != null) {
                this.lsY.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.iwf != null && this.lsI) {
            this.iwf.dqT();
        }
    }

    private void dkM() {
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.al(16908290).ak(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.kXi.getActivity());
                    if (h.this.ltb == null) {
                        try {
                            h.this.ltb = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.ltb);
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
                    h.this.lta = null;
                    if (h.this.ltb != null && !h.this.ltb.isRecycled()) {
                        h.this.ltb.recycle();
                    }
                    h.this.ltb = null;
                }
            });
            this.lta = dVar.mi();
            this.lta.showOnDecorView(this.kXi.getActivity());
        }
    }

    public boolean yG(int i) {
        if (this.iwf == null) {
            return false;
        }
        return this.iwf.GK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF(String str) {
        if (this.lsB != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.lsB.video_md5, "", str, this.lsC, this.iwf.getVideoView().getPcdnState());
            }
        }
    }

    public void dkN() {
        if (this.lsy != null) {
            this.lsy.uH(this.kXi.ddG());
        }
    }

    public void djC() {
        if (this.lsy != null) {
            this.lsy.djC();
        }
    }

    public void FF(int i) {
        if (this.lsy != null) {
            this.lsy.FF(i);
        }
        if (this.lsY != null) {
            this.lsY.onChangeSkinType(i);
        }
        if (this.lsD != null) {
            this.lsD.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dkQ()) {
                    this.lsL = i;
                    if (this.lsL == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.FS(h.this.bKm().getHeight());
                            }
                        }, 100L);
                    }
                    dkO();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(int i) {
        if (bKm().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lsz.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.lte = false;
                    if (this.lsQ != bKm().getHeight()) {
                        this.lsz.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kXi.getActivity()), Math.min(this.lsQ, bKm().getHeight() + i)));
                        this.iwf.cUg();
                    }
                } else if (l.getEquipmentWidth(this.kXi.getActivity()) * 0.5625d != bKm().getHeight()) {
                    this.lsz.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kXi.getActivity()), (int) Math.max(l.getEquipmentWidth(this.kXi.getActivity()) * 0.5625d, bKm().getHeight() + i)));
                    this.iwf.cUg();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dkR()) {
                int bottom = childAt.getBottom() - bKm().getBottom();
                if (childAt.getHeight() == 0 || bKm().getHeight() == 0) {
                    bottom = 0;
                }
                FR(bottom);
            } else {
                FR((-this.lsQ) + 2);
            }
        }
        if (!dkQ() && this.lsX) {
            if (this.lsL == 1) {
                this.ltd = true;
                FS(bKm().getHeight());
            } else if (this.lsL == 2) {
                this.ltd = true;
                int y = (int) bKm().getY();
                if (this.lsM == y) {
                    FS(bKm().getHeight());
                } else {
                    this.lsM = y;
                    FS(bKm().getHeight());
                }
                if (i == 0 && this.lsP) {
                    this.lsP = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dkL();
                        }
                    }, 100L);
                }
            } else if (this.lsL == 0) {
                if (this.ltd || !"nani_midpage".equals(this.kXi.deD())) {
                    FS(bKm().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(int i) {
        FT(i);
        dkO();
    }

    public void ut(boolean z) {
        this.lte = z;
    }

    private void FT(int i) {
        if (this.lsD != null) {
            if (this.lsF != null && this.lsF.bgR()) {
                this.lsD.dkJ().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.lsQ;
            }
            float f = this.lsQ - i;
            float f2 = f > this.lsN ? 0.0f : 1.0f - (f / this.lsN);
            if (this.lte) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lsD.dkJ().setVisibility(8);
            } else {
                this.lsD.dkJ().setVisibility(0);
            }
            this.lsD.aD(f2);
        }
    }

    public void dkO() {
        if (this.lsD != null) {
            if (dkQ()) {
                this.kXi.deG().diB();
            } else if (this.lsD.dkJ().getVisibility() == 0) {
                this.kXi.deG().diB();
                this.lsE = true;
            } else if (this.lsE) {
                this.kXi.deG().us(false);
                this.lsE = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dkP() {
        return bKm().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.lsK = false;
        if (this.iwf != null && this.lsz != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lsz.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.iSq != null && this.iSq.isShowing()) {
                    this.iSq.Vx();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.lta != null) {
                    this.lta.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.lsK = true;
                this.lsz.setLayoutParams(layoutParams);
                this.kXi.deG().diB();
                this.lsE = true;
            } else {
                f(this.lsB);
                dkN();
                this.lsK = false;
                this.lsy.uG(true);
            }
            this.iwf.a(this.kXi.getPageContext(), configuration);
        }
    }

    public boolean dkQ() {
        return this.lsK;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lsD != null) {
            this.lsD.V(onClickListener);
        }
    }

    public View bKm() {
        return this.lsx;
    }

    public boolean diK() {
        if (bKm() == null) {
            return false;
        }
        return bKm().getBottom() > l.getEquipmentHeight(bKm().getContext()) - l.getDimens(bKm().getContext(), R.dimen.ds50);
    }

    public void djg() {
        this.lsP = true;
    }

    public View dkR() {
        return this.mEmptyView;
    }
}
