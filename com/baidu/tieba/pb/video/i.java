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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class i {
    private float NT;
    private boolean Vs;
    private n dlO;
    private com.baidu.mcn.c fNL;
    private com.baidu.tieba.play.c fut;
    private PbActivity hGq;
    private float hWF;
    private int hWI;
    private double hWJ;
    private long hWK;
    private PbVideoWifiTipLayout hWL;
    private int hWM;
    private c.d hWO;
    private PbFullScreenFloatingHuajiAninationView hWQ;
    private com.baidu.adp.lib.guide.c hWS;
    private Bitmap hWT;
    private boolean hWU;
    private boolean hWW;
    private int hWY;
    private RelativeLayout hWp;
    private com.baidu.tieba.pb.pb.main.view.c hWq;
    private CustomFrameLayout hWr;
    private c.d hWs;
    private z hWu;
    private g hWv;
    private boolean hWw;
    private bg hWx;
    private bg hWy;
    private String hWz;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a hbV = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aBR() {
        }
    };
    private static c.i hWZ = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bml() {
        }
    };
    private String bVa = null;
    private VideoInfo hWt = null;
    private boolean hWA = false;
    private int hWB = 0;
    private boolean hWC = false;
    private int hWD = 0;
    private int hWE = 0;
    private boolean hWG = false;
    private boolean hWH = false;
    private long startPosition = -1;
    private int eVy = 0;
    private c.p hWN = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bXj() {
            if (i.this.hGq != null && i.this.hGq.bQS() != null && i.this.hGq.bQS().getPbData() != null) {
                PostData bPT = i.this.hGq.bQS().getPbData().bPT();
                if (bPT == null && v.Z(i.this.hGq.bQS().getPbData().bPO()) > 1) {
                    bPT = (PostData) v.c(i.this.hGq.bQS().getPbData().bPO(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hGq.bQS().getPbData(), bPT, 1, 1, 4);
            }
        }
    };
    private boolean hWP = true;
    private PbFullScreenFloatingHuajiAninationView.a hWR = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pf(false);
        }
    };
    private boolean hWV = false;
    private c.m hWX = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean bXl() {
            if (i.this.hWJ < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hGq.checkUpIsLogin()) {
                i.this.hGq.bRU();
                if (i.this.hGq.bQS() == null || i.this.hGq.bQS().getPbData() == null || i.this.hGq.bQS().getPbData().bQj() == null) {
                    return false;
                }
                j bQj = i.this.hGq.bQS().getPbData().bQj();
                if (i.this.hWQ == null) {
                    i.this.hWQ = new PbFullScreenFloatingHuajiAninationView(i.this.hGq.getActivity());
                    i.this.hWQ.setFloatingHuajiAninationListener(i.this.hWR);
                }
                i.this.hWQ.ph(bQj.bQs() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bXm() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.jS()) {
                if (i.this.fut != null) {
                    i.this.fut.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.jU() && i.this.fut != null && i.this.fut.pg() && i.this.hWt != null && i.this.hWt.video_length.intValue() > 0 && i.this.hWt.video_duration.intValue() > 0) {
                    float intValue = i.this.hWt.video_length.intValue() * (1.0f - ((i.this.fut.getCurrentPosition() * 1.0f) / (i.this.hWt.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hGq.getPageContext().getPageActivity(), String.format(i.this.hGq.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gZW = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bVT();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.hWt != null) {
                i.this.e(i.this.hWt);
                i.this.fut.cba();
                i.this.fut.bIr();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.hWI;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pf(boolean z) {
        if (this.hGq != null) {
            this.hGq.bRk();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.hWF = 0.0f;
        this.hGq = pbActivity;
        this.hWq = cVar;
        this.hWF = l.g(this.hGq.getActivity(), R.dimen.ds240);
        this.hWK = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fqu.setTag(pbActivity.getUniqueId());
        this.fqu.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fqu);
        this.fNL = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int af = l.af(this.hGq.getActivity());
        Rect Y = bb.Y(this.hGq.getPageContext().getPageActivity());
        int ah = Y.height() <= 0 ? l.ah(this.hGq.getActivity()) : Y.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hWJ = (intValue2 * 1.0d) / intValue;
            if (this.hWJ > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.hWI = i;
        this.hWr.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    public boolean bWY() {
        return this.hWJ >= 1.0d;
    }

    public int bWZ() {
        return this.hWI;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.hWp = (RelativeLayout) LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.hWr = (CustomFrameLayout) this.hWp.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.Vs = ((double) this.hWI) <= (((double) l.af(this.hGq.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fut = new com.baidu.tieba.play.c((TbPageContext<?>) this.hGq.getPageContext(), (View) this.hWr, true);
        this.fut.a(this.hWX);
        this.fut.pO(false);
        this.fut.a(this.hWN);
        this.fut.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hGq) || TbSingleton.getInstance().isCutoutScreen(this.hGq)) {
            this.fut.pF(false);
        }
        this.fut.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        i.this.NT = motionEvent.getY();
                        if (i.this.hGq.getListView() != null && i.this.hGq.getListView().getChildCount() > 0 && i.this.hGq.getListView().getChildAt(0) == i.this.bXi()) {
                            i.this.hWY = i.this.bXi().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.NT = 0.0f;
                        i.this.hWY = 0;
                        break;
                    case 2:
                        if (i.this.hGq.getListView() != null && i.this.hGq.getListView().getChildCount() > 0 && i.this.hGq.getListView().getChildAt(0) == i.this.bXi()) {
                            i.this.hGq.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.NT)) + i.this.hWY);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hWJ >= 1.0d) {
                this.fut.ad(false, true);
            } else {
                this.fut.ad(true, false);
            }
            this.hWG = ((float) e) + this.hWF > ((float) l.ah(this.hGq.getActivity()));
            if (this.hWG) {
                if (this.hWv == null) {
                    this.hWv = new g(this.hGq.getPageContext(), this.hWr);
                }
                this.hGq.bRi().bVc();
                this.hWw = true;
            }
        }
        bXb();
        this.mEmptyView = new View(this.hGq);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hWI));
        if (this.hWq != null && this.hWq.mNavigationBar != null) {
            this.hWq.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hWq.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.hWq.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.agW() && !TbSingleton.getInstance().isNotchScreen(this.hGq) && !TbSingleton.getInstance().isCutoutScreen(this.hGq)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.hWL = (PbVideoWifiTipLayout) this.hWp.findViewById(R.id.layout_wifi_tip);
        this.hWL.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hWU = true;
                i.this.hWL.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fNL != null) {
            this.fNL.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hGq.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hWs == null) {
            this.hWs = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (i.this.bXe() && i.this.hWq != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hWq.bVN().clearAnimation();
                        i.this.bXc();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gZW);
                            i.this.hWq.bVN().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmk() {
                    if (i.this.bXe()) {
                        i.this.bVT();
                    }
                }
            };
        }
        a(this.hWs);
        this.hWB = UtilHelper.getLightStatusBarHeight() + l.g(this.hGq.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fut != null && bgVar != null) {
            this.hWt = videoInfo;
            this.hWx = bgVar;
            this.bVa = videoInfo.video_url;
            this.fut.stopPlay();
            this.fut.setIsNeedRecoveryVideoPlayer(true);
            this.dlO = new n(this.hGq.getActivity());
            this.hWu = new z();
            this.hWu.mLocate = "pb";
            this.hWu.bVM = bgVar.getTid();
            this.hWu.eAC = str;
            this.hWu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hWu.mSource = bgVar.mRecomSource;
            this.hWu.irj = bgVar.mRecomWeight;
            this.hWu.irk = this.hGq.bRg();
            this.hWu.irl = bgVar.mRecomAbTag;
            this.hWu.irm = videoInfo.video_md5;
            z cbX = this.hWu.cbX();
            cbX.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dlO.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cE = com.baidu.mcn.b.tJ().cE(mcnAdInfo.jump_url);
                        if (i.this.Vs && !cE && !i.this.hWC) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fNL.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeW = mcnAdInfo.card_title;
                                    aVar.aeX = mcnAdInfo.button_title;
                                    aVar.aeY = mcnAdInfo.jump_url;
                                    aVar.aeV = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeZ = 4;
                                    if (z2) {
                                        i.this.fNL.b(aVar, (ViewGroup) i.this.fut.caZ());
                                    } else {
                                        i.this.fNL.a(aVar, (ViewGroup) i.this.fut.caZ());
                                    }
                                }
                            } else if (i.this.fNL.isShowing()) {
                                i.this.fNL.dismiss();
                            }
                        }
                    }
                }
            });
            this.dlO.setVideoStatsData(cbX);
            this.fut.getVideoView().setBusiness(this.dlO);
            if (this.fut.bIt()) {
                this.fut.bIr();
            }
            this.fut.b(this.hWO);
            this.hWz = null;
            this.hWy = null;
            this.fut.BI(this.hWz);
            this.fut.bIn().setOnDragingListener(hbV);
            this.fut.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    i.this.hGq.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hWM > 0) {
                                i.this.xN(i.this.hWM);
                                i.this.xO(i.this.hWM);
                                i.this.hWM = 0;
                            }
                            i.this.hWP = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    i.this.hGq.setSwipeBackEnabled(false);
                    i.this.hWP = false;
                    i.this.hWM = i.this.aHS().getHeight();
                }
            });
            this.fut.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bXk() {
                    if (i.this.hGq != null && i.this.hWy != null && !StringUtils.isNull(i.this.hWy.getId())) {
                        i.this.hGq.Bb(i.this.hWy.getId());
                        if (i.this.hWx != null) {
                            long j = 0;
                            if (i.this.hWx.aeF() != null) {
                                j = i.this.hWx.aeF().channelId;
                            }
                            TiebaStatic.log(new am("c11921").l(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fut.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void pg(boolean z) {
                    if (i.this.hWx != null) {
                        long j = 0;
                        if (i.this.hWx.aeF() != null) {
                            j = i.this.hWx.aeF().channelId;
                        }
                        i.this.wu(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bT("tid", i.this.hWx.getTid()).l("fid", i.this.hWx.getFid()).l(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fut.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bVa);
                    return true;
                }
            });
            this.fut.setThumbnail(videoInfo.thumbnail_url);
            this.fut.setVideoUrl(this.bVa, bgVar.getTid());
            this.fut.setFid(str);
            this.fut.Ch(bgVar.getTitle());
            this.fut.a(hWZ);
            this.fut.bvu();
            this.fut.show();
        }
    }

    public void BH(String str) {
        if (this.hWu != null) {
            this.hWu.eAC = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.hWv != null) {
            this.hWv.a(postData, bgVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.hWO = dVar;
    }

    public void aB(bg bgVar) {
        this.hWy = bgVar;
    }

    public void BI(String str) {
        this.hWz = str;
        if (this.fut != null) {
            this.fut.BI(this.hWz);
        }
    }

    public void startPlay() {
        if (this.fut != null) {
            if (com.baidu.adp.lib.util.j.jU() && !this.hWU && !com.baidu.tieba.video.g.cqT().cqU()) {
                this.hWL.setVisibility(0);
                this.hWL.setData(this.hWt);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bVa) && this.hWx != null && this.hWx.adM() != null) {
                TiebaStatic.log(new am("c12619").bT("obj_locate", "pb").bT("tid", this.hWx.getTid()));
                this.bVa = this.hWx.adM().video_url;
            }
            this.fut.i(this.bVa, this.hWx == null ? "" : this.hWx.getTid(), this.hWK);
            wu("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bXa() {
        if (this.fut != null) {
            this.fut.bXa();
        }
    }

    public void destroy() {
        if (this.fut != null) {
            this.fut.destroy();
        }
        if (this.hWr != null) {
            this.hWr.clearAnimation();
        }
        if (this.hWv != null) {
            this.hWv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fqu);
    }

    public void onPause() {
        if (this.fut != null) {
            if (this.fut.pg()) {
                this.hWA = true;
                this.fut.stopPlay();
            } else if (this.fut.getCurrentState() == 3) {
                this.hWA = false;
            } else if (this.fut.getCurrentState() == 0 || this.fut.getCurrentState() == 1) {
                this.hWA = true;
                this.fut.stopPlay();
            } else {
                this.hWA = false;
                this.fut.stopPlay();
            }
            if (this.hWQ != null) {
                this.hWQ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fut != null && this.hWA) {
            this.fut.caL();
        }
    }

    private void bXb() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.T(true);
            dVar.V(false);
            dVar.Y(16908290).X(153).U(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hGq.getActivity());
                    if (i.this.hWT == null) {
                        try {
                            i.this.hWT = BitmapFactory.decodeResource(i.this.hGq.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hWT);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hJ() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hK() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.8
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.hWS = null;
                    if (i.this.hWT != null && !i.this.hWT.isRecycled()) {
                        i.this.hWT.recycle();
                    }
                    i.this.hWT = null;
                }
            });
            this.hWS = dVar.hL();
            this.hWS.o(this.hGq.getActivity());
        }
    }

    public boolean rz(int i) {
        if (this.fut == null) {
            return false;
        }
        return this.fut.yo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(String str) {
        if (this.hWt != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hWt.video_md5, "", str, this.hWu);
            }
        }
    }

    public void bXc() {
        if (this.hWq != null) {
            this.hWq.oX(this.hGq.bQI());
        }
    }

    public void bVT() {
        if (this.hWq != null) {
            this.hWq.bVT();
        }
    }

    public void xI(int i) {
        if (this.hWq != null) {
            this.hWq.xI(i);
        }
        if (this.hWQ != null) {
            this.hWQ.onChangeSkinType(i);
        }
        if (this.hWv != null) {
            this.hWv.iW(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bXf()) {
                    this.hWD = i;
                    if (this.hWD == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.xO(i.this.aHS().getHeight());
                            }
                        }, 100L);
                    }
                    bXd();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (aHS().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWr.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hWW = false;
                    if (this.hWI != aHS().getHeight()) {
                        this.hWr.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hGq.getActivity()), Math.min(this.hWI, aHS().getHeight() + i)));
                        this.fut.bIr();
                    }
                } else if (l.af(this.hGq.getActivity()) * 0.5625d != aHS().getHeight()) {
                    this.hWr.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hGq.getActivity()), (int) Math.max(l.af(this.hGq.getActivity()) * 0.5625d, aHS().getHeight() + i)));
                    this.fut.bIr();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bXi()) {
                int bottom = childAt.getBottom() - aHS().getBottom();
                if (childAt.getHeight() == 0 || aHS().getHeight() == 0) {
                    bottom = 0;
                }
                xN(bottom);
            } else {
                xN((-this.hWI) + 2);
            }
        }
        if (!bXf() && this.hWP) {
            if (this.hWD == 1) {
                this.hWV = true;
                xO(aHS().getHeight());
            } else if (this.hWD == 2) {
                this.hWV = true;
                int y = (int) aHS().getY();
                if (this.hWE == y) {
                    xO(aHS().getHeight());
                } else {
                    this.hWE = y;
                    xO(aHS().getHeight());
                }
                if (i == 0 && this.hWH) {
                    this.hWH = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bXa();
                        }
                    }, 100L);
                }
            } else if (this.hWD == 0) {
                if (this.hWV || !"nani_midpage".equals(this.hGq.bRg())) {
                    xO(aHS().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(int i) {
        xP(i);
        bXd();
    }

    public void oL(boolean z) {
        this.hWW = z;
    }

    private void xP(int i) {
        if (this.hWv != null) {
            if (i == 0) {
                i = this.hWI;
            }
            float f = this.hWI - i;
            float f2 = f > this.hWF ? 0.0f : 1.0f - (f / this.hWF);
            if (this.hWW) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hWv.bWU().setVisibility(8);
            } else {
                this.hWv.bWU().setVisibility(0);
            }
            this.hWv.aN(f2);
        }
    }

    public void bXd() {
        if (this.hWv != null) {
            if (bXf()) {
                this.hGq.bRi().bVc();
            } else if (this.hWv.bWU().getVisibility() == 0) {
                this.hGq.bRi().bVc();
                this.hWw = true;
            } else if (this.hWw) {
                this.hGq.bRi().oK(false);
                this.hWw = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXe() {
        return aHS().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hWC = false;
        if (this.fut != null && this.hWr != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWr.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fNL != null && this.fNL.isShowing()) {
                    this.fNL.tK();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hWS != null) {
                    this.hWS.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hWC = true;
                this.hWr.setLayoutParams(layoutParams);
                this.hGq.bRi().bVc();
                this.hWw = true;
            } else {
                e(this.hWt);
                bXc();
                this.hWC = false;
                this.hWq.oW(true);
            }
            this.fut.a(this.hGq.getPageContext(), configuration);
        }
    }

    public boolean bXf() {
        return this.hWC;
    }

    public void q(long j, int i) {
        if (this.hWv != null && j > 0) {
            this.hWv.w(i, j);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.hWv != null) {
            this.hWv.P(onClickListener);
        }
    }

    public View aHS() {
        return this.hWp;
    }

    public boolean bVl() {
        if (aHS() == null) {
            return false;
        }
        return aHS().getBottom() > l.ah(aHS().getContext()) - l.g(aHS().getContext(), R.dimen.ds50);
    }

    public void bXg() {
        this.hWH = true;
    }

    public void bXh() {
        if (this.fut != null) {
            this.fut.pausePlay();
        }
    }

    public View bXi() {
        return this.mEmptyView;
    }
}
