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
    private float NU;
    private boolean Vt;
    private n dlO;
    private com.baidu.mcn.c fNJ;
    private com.baidu.tieba.play.c fut;
    private PbActivity hGp;
    private float hWE;
    private int hWH;
    private double hWI;
    private long hWJ;
    private PbVideoWifiTipLayout hWK;
    private int hWL;
    private c.d hWN;
    private PbFullScreenFloatingHuajiAninationView hWP;
    private com.baidu.adp.lib.guide.c hWR;
    private Bitmap hWS;
    private boolean hWT;
    private boolean hWV;
    private int hWX;
    private RelativeLayout hWo;
    private com.baidu.tieba.pb.pb.main.view.c hWp;
    private CustomFrameLayout hWq;
    private c.d hWr;
    private z hWt;
    private g hWu;
    private boolean hWv;
    private bg hWw;
    private bg hWx;
    private String hWy;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a hbU = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aBR() {
        }
    };
    private static c.i hWY = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bml() {
        }
    };
    private String bUZ = null;
    private VideoInfo hWs = null;
    private boolean hWz = false;
    private int hWA = 0;
    private boolean hWB = false;
    private int hWC = 0;
    private int hWD = 0;
    private boolean hWF = false;
    private boolean hWG = false;
    private long startPosition = -1;
    private int eVy = 0;
    private c.p hWM = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bXi() {
            if (i.this.hGp != null && i.this.hGp.bQR() != null && i.this.hGp.bQR().getPbData() != null) {
                PostData bPS = i.this.hGp.bQR().getPbData().bPS();
                if (bPS == null && v.Z(i.this.hGp.bQR().getPbData().bPN()) > 1) {
                    bPS = (PostData) v.c(i.this.hGp.bQR().getPbData().bPN(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hGp.bQR().getPbData(), bPS, 1, 1, 4);
            }
        }
    };
    private boolean hWO = true;
    private PbFullScreenFloatingHuajiAninationView.a hWQ = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pe(false);
        }
    };
    private boolean hWU = false;
    private c.m hWW = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean bXk() {
            if (i.this.hWI < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hGp.checkUpIsLogin()) {
                i.this.hGp.bRT();
                if (i.this.hGp.bQR() == null || i.this.hGp.bQR().getPbData() == null || i.this.hGp.bQR().getPbData().bQi() == null) {
                    return false;
                }
                j bQi = i.this.hGp.bQR().getPbData().bQi();
                if (i.this.hWP == null) {
                    i.this.hWP = new PbFullScreenFloatingHuajiAninationView(i.this.hGp.getActivity());
                    i.this.hWP.setFloatingHuajiAninationListener(i.this.hWQ);
                }
                i.this.hWP.pg(bQi.bQr() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bXl() {
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
                if (com.baidu.adp.lib.util.j.jU() && i.this.fut != null && i.this.fut.pg() && i.this.hWs != null && i.this.hWs.video_length.intValue() > 0 && i.this.hWs.video_duration.intValue() > 0) {
                    float intValue = i.this.hWs.video_length.intValue() * (1.0f - ((i.this.fut.getCurrentPosition() * 1.0f) / (i.this.hWs.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hGp.getPageContext().getPageActivity(), String.format(i.this.hGp.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gZV = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bVS();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.hWs != null) {
                i.this.e(i.this.hWs);
                i.this.fut.caZ();
                i.this.fut.bIq();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.hWH;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pe(boolean z) {
        if (this.hGp != null) {
            this.hGp.bRj();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.hWE = 0.0f;
        this.hGp = pbActivity;
        this.hWp = cVar;
        this.hWE = l.g(this.hGp.getActivity(), R.dimen.ds240);
        this.hWJ = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fqu.setTag(pbActivity.getUniqueId());
        this.fqu.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fqu);
        this.fNJ = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int af = l.af(this.hGp.getActivity());
        Rect Y = bb.Y(this.hGp.getPageContext().getPageActivity());
        int ah = Y.height() <= 0 ? l.ah(this.hGp.getActivity()) : Y.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hWI = (intValue2 * 1.0d) / intValue;
            if (this.hWI > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.hWH = i;
        this.hWq.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    public boolean bWX() {
        return this.hWI >= 1.0d;
    }

    public int bWY() {
        return this.hWH;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.hWo = (RelativeLayout) LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.hWq = (CustomFrameLayout) this.hWo.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.Vt = ((double) this.hWH) <= (((double) l.af(this.hGp.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fut = new com.baidu.tieba.play.c((TbPageContext<?>) this.hGp.getPageContext(), (View) this.hWq, true);
        this.fut.a(this.hWW);
        this.fut.pN(false);
        this.fut.a(this.hWM);
        this.fut.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hGp) || TbSingleton.getInstance().isCutoutScreen(this.hGp)) {
            this.fut.pE(false);
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
                        i.this.NU = motionEvent.getY();
                        if (i.this.hGp.getListView() != null && i.this.hGp.getListView().getChildCount() > 0 && i.this.hGp.getListView().getChildAt(0) == i.this.bXh()) {
                            i.this.hWX = i.this.bXh().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.NU = 0.0f;
                        i.this.hWX = 0;
                        break;
                    case 2:
                        if (i.this.hGp.getListView() != null && i.this.hGp.getListView().getChildCount() > 0 && i.this.hGp.getListView().getChildAt(0) == i.this.bXh()) {
                            i.this.hGp.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.NU)) + i.this.hWX);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hWI >= 1.0d) {
                this.fut.ad(false, true);
            } else {
                this.fut.ad(true, false);
            }
            this.hWF = ((float) e) + this.hWE > ((float) l.ah(this.hGp.getActivity()));
            if (this.hWF) {
                if (this.hWu == null) {
                    this.hWu = new g(this.hGp.getPageContext(), this.hWq);
                }
                this.hGp.bRh().bVb();
                this.hWv = true;
            }
        }
        bXa();
        this.mEmptyView = new View(this.hGp);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hWH));
        if (this.hWp != null && this.hWp.mNavigationBar != null) {
            this.hWp.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hWp.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.hWp.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.agW() && !TbSingleton.getInstance().isNotchScreen(this.hGp) && !TbSingleton.getInstance().isCutoutScreen(this.hGp)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.hWK = (PbVideoWifiTipLayout) this.hWo.findViewById(R.id.layout_wifi_tip);
        this.hWK.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hWT = true;
                i.this.hWK.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fNJ != null) {
            this.fNJ.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hGp.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hWr == null) {
            this.hWr = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (i.this.bXd() && i.this.hWp != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hWp.bVM().clearAnimation();
                        i.this.bXb();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gZV);
                            i.this.hWp.bVM().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmk() {
                    if (i.this.bXd()) {
                        i.this.bVS();
                    }
                }
            };
        }
        a(this.hWr);
        this.hWA = UtilHelper.getLightStatusBarHeight() + l.g(this.hGp.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fut != null && bgVar != null) {
            this.hWs = videoInfo;
            this.hWw = bgVar;
            this.bUZ = videoInfo.video_url;
            this.fut.stopPlay();
            this.fut.setIsNeedRecoveryVideoPlayer(true);
            this.dlO = new n(this.hGp.getActivity());
            this.hWt = new z();
            this.hWt.mLocate = "pb";
            this.hWt.bVL = bgVar.getTid();
            this.hWt.eAC = str;
            this.hWt.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hWt.mSource = bgVar.mRecomSource;
            this.hWt.iri = bgVar.mRecomWeight;
            this.hWt.irj = this.hGp.bRf();
            this.hWt.irk = bgVar.mRecomAbTag;
            this.hWt.irl = videoInfo.video_md5;
            z cbW = this.hWt.cbW();
            cbW.mLocate = Constants.VIA_SHARE_TYPE_INFO;
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
                        boolean cF = com.baidu.mcn.b.tJ().cF(mcnAdInfo.jump_url);
                        if (i.this.Vt && !cF && !i.this.hWB) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fNJ.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeW = mcnAdInfo.card_title;
                                    aVar.aeX = mcnAdInfo.button_title;
                                    aVar.aeY = mcnAdInfo.jump_url;
                                    aVar.aeV = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeZ = 4;
                                    if (z2) {
                                        i.this.fNJ.b(aVar, (ViewGroup) i.this.fut.caY());
                                    } else {
                                        i.this.fNJ.a(aVar, (ViewGroup) i.this.fut.caY());
                                    }
                                }
                            } else if (i.this.fNJ.isShowing()) {
                                i.this.fNJ.dismiss();
                            }
                        }
                    }
                }
            });
            this.dlO.setVideoStatsData(cbW);
            this.fut.getVideoView().setBusiness(this.dlO);
            if (this.fut.bIs()) {
                this.fut.bIq();
            }
            this.fut.b(this.hWN);
            this.hWy = null;
            this.hWx = null;
            this.fut.BG(this.hWy);
            this.fut.bIm().setOnDragingListener(hbU);
            this.fut.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    i.this.hGp.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hWL > 0) {
                                i.this.xN(i.this.hWL);
                                i.this.xO(i.this.hWL);
                                i.this.hWL = 0;
                            }
                            i.this.hWO = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    i.this.hGp.setSwipeBackEnabled(false);
                    i.this.hWO = false;
                    i.this.hWL = i.this.aHS().getHeight();
                }
            });
            this.fut.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bXj() {
                    if (i.this.hGp != null && i.this.hWx != null && !StringUtils.isNull(i.this.hWx.getId())) {
                        i.this.hGp.AZ(i.this.hWx.getId());
                        if (i.this.hWw != null) {
                            long j = 0;
                            if (i.this.hWw.aeF() != null) {
                                j = i.this.hWw.aeF().channelId;
                            }
                            TiebaStatic.log(new am("c11921").l(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fut.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void pf(boolean z) {
                    if (i.this.hWw != null) {
                        long j = 0;
                        if (i.this.hWw.aeF() != null) {
                            j = i.this.hWw.aeF().channelId;
                        }
                        i.this.wv(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bT("tid", i.this.hWw.getTid()).l("fid", i.this.hWw.getFid()).l(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fut.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bUZ);
                    return true;
                }
            });
            this.fut.setThumbnail(videoInfo.thumbnail_url);
            this.fut.setVideoUrl(this.bUZ, bgVar.getTid());
            this.fut.setFid(str);
            this.fut.Cf(bgVar.getTitle());
            this.fut.a(hWY);
            this.fut.bvt();
            this.fut.show();
        }
    }

    public void BF(String str) {
        if (this.hWt != null) {
            this.hWt.eAC = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.hWu != null) {
            this.hWu.a(postData, bgVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.hWN = dVar;
    }

    public void aB(bg bgVar) {
        this.hWx = bgVar;
    }

    public void BG(String str) {
        this.hWy = str;
        if (this.fut != null) {
            this.fut.BG(this.hWy);
        }
    }

    public void startPlay() {
        if (this.fut != null) {
            if (com.baidu.adp.lib.util.j.jU() && !this.hWT && !com.baidu.tieba.video.g.cqS().cqT()) {
                this.hWK.setVisibility(0);
                this.hWK.setData(this.hWs);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bUZ) && this.hWw != null && this.hWw.adM() != null) {
                TiebaStatic.log(new am("c12619").bT("obj_locate", "pb").bT("tid", this.hWw.getTid()));
                this.bUZ = this.hWw.adM().video_url;
            }
            this.fut.i(this.bUZ, this.hWw == null ? "" : this.hWw.getTid(), this.hWJ);
            wv("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bWZ() {
        if (this.fut != null) {
            this.fut.bWZ();
        }
    }

    public void destroy() {
        if (this.fut != null) {
            this.fut.destroy();
        }
        if (this.hWq != null) {
            this.hWq.clearAnimation();
        }
        if (this.hWu != null) {
            this.hWu.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fqu);
    }

    public void onPause() {
        if (this.fut != null) {
            if (this.fut.pg()) {
                this.hWz = true;
                this.fut.stopPlay();
            } else if (this.fut.getCurrentState() == 3) {
                this.hWz = false;
            } else if (this.fut.getCurrentState() == 0 || this.fut.getCurrentState() == 1) {
                this.hWz = true;
                this.fut.stopPlay();
            } else {
                this.hWz = false;
                this.fut.stopPlay();
            }
            if (this.hWP != null) {
                this.hWP.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fut != null && this.hWz) {
            this.fut.caK();
        }
    }

    private void bXa() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.T(true);
            dVar.V(false);
            dVar.Y(16908290).X(153).U(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hGp.getActivity());
                    if (i.this.hWS == null) {
                        try {
                            i.this.hWS = BitmapFactory.decodeResource(i.this.hGp.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hWS);
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
                    i.this.hWR = null;
                    if (i.this.hWS != null && !i.this.hWS.isRecycled()) {
                        i.this.hWS.recycle();
                    }
                    i.this.hWS = null;
                }
            });
            this.hWR = dVar.hL();
            this.hWR.o(this.hGp.getActivity());
        }
    }

    public boolean rz(int i) {
        if (this.fut == null) {
            return false;
        }
        return this.fut.yo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(String str) {
        if (this.hWs != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hWs.video_md5, "", str, this.hWt);
            }
        }
    }

    public void bXb() {
        if (this.hWp != null) {
            this.hWp.oW(this.hGp.bQH());
        }
    }

    public void bVS() {
        if (this.hWp != null) {
            this.hWp.bVS();
        }
    }

    public void xI(int i) {
        if (this.hWp != null) {
            this.hWp.xI(i);
        }
        if (this.hWP != null) {
            this.hWP.onChangeSkinType(i);
        }
        if (this.hWu != null) {
            this.hWu.iW(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bXe()) {
                    this.hWC = i;
                    if (this.hWC == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.xO(i.this.aHS().getHeight());
                            }
                        }, 100L);
                    }
                    bXc();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (aHS().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWq.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hWV = false;
                    if (this.hWH != aHS().getHeight()) {
                        this.hWq.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hGp.getActivity()), Math.min(this.hWH, aHS().getHeight() + i)));
                        this.fut.bIq();
                    }
                } else if (l.af(this.hGp.getActivity()) * 0.5625d != aHS().getHeight()) {
                    this.hWq.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hGp.getActivity()), (int) Math.max(l.af(this.hGp.getActivity()) * 0.5625d, aHS().getHeight() + i)));
                    this.fut.bIq();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bXh()) {
                int bottom = childAt.getBottom() - aHS().getBottom();
                if (childAt.getHeight() == 0 || aHS().getHeight() == 0) {
                    bottom = 0;
                }
                xN(bottom);
            } else {
                xN((-this.hWH) + 2);
            }
        }
        if (!bXe() && this.hWO) {
            if (this.hWC == 1) {
                this.hWU = true;
                xO(aHS().getHeight());
            } else if (this.hWC == 2) {
                this.hWU = true;
                int y = (int) aHS().getY();
                if (this.hWD == y) {
                    xO(aHS().getHeight());
                } else {
                    this.hWD = y;
                    xO(aHS().getHeight());
                }
                if (i == 0 && this.hWG) {
                    this.hWG = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bWZ();
                        }
                    }, 100L);
                }
            } else if (this.hWC == 0) {
                if (this.hWU || !"nani_midpage".equals(this.hGp.bRf())) {
                    xO(aHS().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(int i) {
        xP(i);
        bXc();
    }

    public void oK(boolean z) {
        this.hWV = z;
    }

    private void xP(int i) {
        if (this.hWu != null) {
            if (i == 0) {
                i = this.hWH;
            }
            float f = this.hWH - i;
            float f2 = f > this.hWE ? 0.0f : 1.0f - (f / this.hWE);
            if (this.hWV) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hWu.bWT().setVisibility(8);
            } else {
                this.hWu.bWT().setVisibility(0);
            }
            this.hWu.aN(f2);
        }
    }

    public void bXc() {
        if (this.hWu != null) {
            if (bXe()) {
                this.hGp.bRh().bVb();
            } else if (this.hWu.bWT().getVisibility() == 0) {
                this.hGp.bRh().bVb();
                this.hWv = true;
            } else if (this.hWv) {
                this.hGp.bRh().oJ(false);
                this.hWv = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXd() {
        return aHS().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hWB = false;
        if (this.fut != null && this.hWq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWq.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fNJ != null && this.fNJ.isShowing()) {
                    this.fNJ.tK();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hWR != null) {
                    this.hWR.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hWB = true;
                this.hWq.setLayoutParams(layoutParams);
                this.hGp.bRh().bVb();
                this.hWv = true;
            } else {
                e(this.hWs);
                bXb();
                this.hWB = false;
                this.hWp.oV(true);
            }
            this.fut.a(this.hGp.getPageContext(), configuration);
        }
    }

    public boolean bXe() {
        return this.hWB;
    }

    public void q(long j, int i) {
        if (this.hWu != null && j > 0) {
            this.hWu.w(i, j);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.hWu != null) {
            this.hWu.P(onClickListener);
        }
    }

    public View aHS() {
        return this.hWo;
    }

    public boolean bVk() {
        if (aHS() == null) {
            return false;
        }
        return aHS().getBottom() > l.ah(aHS().getContext()) - l.g(aHS().getContext(), R.dimen.ds50);
    }

    public void bXf() {
        this.hWG = true;
    }

    public void bXg() {
        if (this.fut != null) {
            this.fut.pausePlay();
        }
    }

    public View bXh() {
        return this.mEmptyView;
    }
}
