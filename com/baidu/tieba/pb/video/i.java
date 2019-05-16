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
    private n dlN;
    private com.baidu.mcn.c fNI;
    private com.baidu.tieba.play.c fus;
    private PbActivity hGm;
    private float hWB;
    private int hWE;
    private double hWF;
    private long hWG;
    private PbVideoWifiTipLayout hWH;
    private int hWI;
    private c.d hWK;
    private PbFullScreenFloatingHuajiAninationView hWM;
    private com.baidu.adp.lib.guide.c hWO;
    private Bitmap hWP;
    private boolean hWQ;
    private boolean hWS;
    private int hWU;
    private RelativeLayout hWl;
    private com.baidu.tieba.pb.pb.main.view.c hWm;
    private CustomFrameLayout hWn;
    private c.d hWo;
    private z hWq;
    private g hWr;
    private boolean hWs;
    private bg hWt;
    private bg hWu;
    private String hWv;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a hbR = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aBO() {
        }
    };
    private static c.i hWV = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bmi() {
        }
    };
    private String bUZ = null;
    private VideoInfo hWp = null;
    private boolean hWw = false;
    private int hWx = 0;
    private boolean hWy = false;
    private int hWz = 0;
    private int hWA = 0;
    private boolean hWC = false;
    private boolean hWD = false;
    private long startPosition = -1;
    private int eVx = 0;
    private c.p hWJ = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bXf() {
            if (i.this.hGm != null && i.this.hGm.bQO() != null && i.this.hGm.bQO().getPbData() != null) {
                PostData bPP = i.this.hGm.bQO().getPbData().bPP();
                if (bPP == null && v.Z(i.this.hGm.bQO().getPbData().bPK()) > 1) {
                    bPP = (PostData) v.c(i.this.hGm.bQO().getPbData().bPK(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hGm.bQO().getPbData(), bPP, 1, 1, 4);
            }
        }
    };
    private boolean hWL = true;
    private PbFullScreenFloatingHuajiAninationView.a hWN = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pe(false);
        }
    };
    private boolean hWR = false;
    private c.m hWT = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean bXh() {
            if (i.this.hWF < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hGm.checkUpIsLogin()) {
                i.this.hGm.bRQ();
                if (i.this.hGm.bQO() == null || i.this.hGm.bQO().getPbData() == null || i.this.hGm.bQO().getPbData().bQf() == null) {
                    return false;
                }
                j bQf = i.this.hGm.bQO().getPbData().bQf();
                if (i.this.hWM == null) {
                    i.this.hWM = new PbFullScreenFloatingHuajiAninationView(i.this.hGm.getActivity());
                    i.this.hWM.setFloatingHuajiAninationListener(i.this.hWN);
                }
                i.this.hWM.pg(bQf.bQo() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bXi() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.jS()) {
                if (i.this.fus != null) {
                    i.this.fus.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.jU() && i.this.fus != null && i.this.fus.pg() && i.this.hWp != null && i.this.hWp.video_length.intValue() > 0 && i.this.hWp.video_duration.intValue() > 0) {
                    float intValue = i.this.hWp.video_length.intValue() * (1.0f - ((i.this.fus.getCurrentPosition() * 1.0f) / (i.this.hWp.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hGm.getPageContext().getPageActivity(), String.format(i.this.hGm.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gZS = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bVP();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.hWp != null) {
                i.this.e(i.this.hWp);
                i.this.fus.caW();
                i.this.fus.bIn();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.hWE;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pe(boolean z) {
        if (this.hGm != null) {
            this.hGm.bRg();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.hWB = 0.0f;
        this.hGm = pbActivity;
        this.hWm = cVar;
        this.hWB = l.g(this.hGm.getActivity(), R.dimen.ds240);
        this.hWG = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fqt.setTag(pbActivity.getUniqueId());
        this.fqt.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fqt);
        this.fNI = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int af = l.af(this.hGm.getActivity());
        Rect Y = bb.Y(this.hGm.getPageContext().getPageActivity());
        int ah = Y.height() <= 0 ? l.ah(this.hGm.getActivity()) : Y.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hWF = (intValue2 * 1.0d) / intValue;
            if (this.hWF > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.hWE = i;
        this.hWn.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    public boolean bWU() {
        return this.hWF >= 1.0d;
    }

    public int bWV() {
        return this.hWE;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.hWl = (RelativeLayout) LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.hWn = (CustomFrameLayout) this.hWl.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.Vt = ((double) this.hWE) <= (((double) l.af(this.hGm.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fus = new com.baidu.tieba.play.c((TbPageContext<?>) this.hGm.getPageContext(), (View) this.hWn, true);
        this.fus.a(this.hWT);
        this.fus.pN(false);
        this.fus.a(this.hWJ);
        this.fus.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hGm) || TbSingleton.getInstance().isCutoutScreen(this.hGm)) {
            this.fus.pE(false);
        }
        this.fus.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        if (i.this.hGm.getListView() != null && i.this.hGm.getListView().getChildCount() > 0 && i.this.hGm.getListView().getChildAt(0) == i.this.bXe()) {
                            i.this.hWU = i.this.bXe().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.NU = 0.0f;
                        i.this.hWU = 0;
                        break;
                    case 2:
                        if (i.this.hGm.getListView() != null && i.this.hGm.getListView().getChildCount() > 0 && i.this.hGm.getListView().getChildAt(0) == i.this.bXe()) {
                            i.this.hGm.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.NU)) + i.this.hWU);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hWF >= 1.0d) {
                this.fus.ad(false, true);
            } else {
                this.fus.ad(true, false);
            }
            this.hWC = ((float) e) + this.hWB > ((float) l.ah(this.hGm.getActivity()));
            if (this.hWC) {
                if (this.hWr == null) {
                    this.hWr = new g(this.hGm.getPageContext(), this.hWn);
                }
                this.hGm.bRe().bUY();
                this.hWs = true;
            }
        }
        bWX();
        this.mEmptyView = new View(this.hGm);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hWE));
        if (this.hWm != null && this.hWm.mNavigationBar != null) {
            this.hWm.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hWm.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.hWm.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.agW() && !TbSingleton.getInstance().isNotchScreen(this.hGm) && !TbSingleton.getInstance().isCutoutScreen(this.hGm)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.hWH = (PbVideoWifiTipLayout) this.hWl.findViewById(R.id.layout_wifi_tip);
        this.hWH.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hWQ = true;
                i.this.hWH.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fNI != null) {
            this.fNI.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hGm.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hWo == null) {
            this.hWo = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (i.this.bXa() && i.this.hWm != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hWm.bVJ().clearAnimation();
                        i.this.bWY();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gZS);
                            i.this.hWm.bVJ().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmh() {
                    if (i.this.bXa()) {
                        i.this.bVP();
                    }
                }
            };
        }
        a(this.hWo);
        this.hWx = UtilHelper.getLightStatusBarHeight() + l.g(this.hGm.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fus != null && bgVar != null) {
            this.hWp = videoInfo;
            this.hWt = bgVar;
            this.bUZ = videoInfo.video_url;
            this.fus.stopPlay();
            this.fus.setIsNeedRecoveryVideoPlayer(true);
            this.dlN = new n(this.hGm.getActivity());
            this.hWq = new z();
            this.hWq.mLocate = "pb";
            this.hWq.bVL = bgVar.getTid();
            this.hWq.eAB = str;
            this.hWq.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hWq.mSource = bgVar.mRecomSource;
            this.hWq.irf = bgVar.mRecomWeight;
            this.hWq.irg = this.hGm.bRc();
            this.hWq.irh = bgVar.mRecomAbTag;
            this.hWq.iri = videoInfo.video_md5;
            z cbT = this.hWq.cbT();
            cbT.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dlN.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cF = com.baidu.mcn.b.tJ().cF(mcnAdInfo.jump_url);
                        if (i.this.Vt && !cF && !i.this.hWy) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fNI.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeW = mcnAdInfo.card_title;
                                    aVar.aeX = mcnAdInfo.button_title;
                                    aVar.aeY = mcnAdInfo.jump_url;
                                    aVar.aeV = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeZ = 4;
                                    if (z2) {
                                        i.this.fNI.b(aVar, (ViewGroup) i.this.fus.caV());
                                    } else {
                                        i.this.fNI.a(aVar, (ViewGroup) i.this.fus.caV());
                                    }
                                }
                            } else if (i.this.fNI.isShowing()) {
                                i.this.fNI.dismiss();
                            }
                        }
                    }
                }
            });
            this.dlN.setVideoStatsData(cbT);
            this.fus.getVideoView().setBusiness(this.dlN);
            if (this.fus.bIp()) {
                this.fus.bIn();
            }
            this.fus.b(this.hWK);
            this.hWv = null;
            this.hWu = null;
            this.fus.BG(this.hWv);
            this.fus.bIj().setOnDragingListener(hbR);
            this.fus.a(new c.InterfaceC0387c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pf() {
                    i.this.hGm.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hWI > 0) {
                                i.this.xN(i.this.hWI);
                                i.this.xO(i.this.hWI);
                                i.this.hWI = 0;
                            }
                            i.this.hWL = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0387c
                public void pe() {
                    i.this.hGm.setSwipeBackEnabled(false);
                    i.this.hWL = false;
                    i.this.hWI = i.this.aHP().getHeight();
                }
            });
            this.fus.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bXg() {
                    if (i.this.hGm != null && i.this.hWu != null && !StringUtils.isNull(i.this.hWu.getId())) {
                        i.this.hGm.AZ(i.this.hWu.getId());
                        if (i.this.hWt != null) {
                            long j = 0;
                            if (i.this.hWt.aeF() != null) {
                                j = i.this.hWt.aeF().channelId;
                            }
                            TiebaStatic.log(new am("c11921").l(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fus.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void pf(boolean z) {
                    if (i.this.hWt != null) {
                        long j = 0;
                        if (i.this.hWt.aeF() != null) {
                            j = i.this.hWt.aeF().channelId;
                        }
                        i.this.wv(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bT("tid", i.this.hWt.getTid()).l("fid", i.this.hWt.getFid()).l(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fus.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bUZ);
                    return true;
                }
            });
            this.fus.setThumbnail(videoInfo.thumbnail_url);
            this.fus.setVideoUrl(this.bUZ, bgVar.getTid());
            this.fus.setFid(str);
            this.fus.Cf(bgVar.getTitle());
            this.fus.a(hWV);
            this.fus.bvq();
            this.fus.show();
        }
    }

    public void BF(String str) {
        if (this.hWq != null) {
            this.hWq.eAB = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.hWr != null) {
            this.hWr.a(postData, bgVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.hWK = dVar;
    }

    public void aB(bg bgVar) {
        this.hWu = bgVar;
    }

    public void BG(String str) {
        this.hWv = str;
        if (this.fus != null) {
            this.fus.BG(this.hWv);
        }
    }

    public void startPlay() {
        if (this.fus != null) {
            if (com.baidu.adp.lib.util.j.jU() && !this.hWQ && !com.baidu.tieba.video.g.cqQ().cqR()) {
                this.hWH.setVisibility(0);
                this.hWH.setData(this.hWp);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bUZ) && this.hWt != null && this.hWt.adM() != null) {
                TiebaStatic.log(new am("c12619").bT("obj_locate", "pb").bT("tid", this.hWt.getTid()));
                this.bUZ = this.hWt.adM().video_url;
            }
            this.fus.i(this.bUZ, this.hWt == null ? "" : this.hWt.getTid(), this.hWG);
            wv("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bWW() {
        if (this.fus != null) {
            this.fus.bWW();
        }
    }

    public void destroy() {
        if (this.fus != null) {
            this.fus.destroy();
        }
        if (this.hWn != null) {
            this.hWn.clearAnimation();
        }
        if (this.hWr != null) {
            this.hWr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fqt);
    }

    public void onPause() {
        if (this.fus != null) {
            if (this.fus.pg()) {
                this.hWw = true;
                this.fus.stopPlay();
            } else if (this.fus.getCurrentState() == 3) {
                this.hWw = false;
            } else if (this.fus.getCurrentState() == 0 || this.fus.getCurrentState() == 1) {
                this.hWw = true;
                this.fus.stopPlay();
            } else {
                this.hWw = false;
                this.fus.stopPlay();
            }
            if (this.hWM != null) {
                this.hWM.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fus != null && this.hWw) {
            this.fus.caH();
        }
    }

    private void bWX() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.T(true);
            dVar.V(false);
            dVar.Y(16908290).X(153).U(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hGm.getActivity());
                    if (i.this.hWP == null) {
                        try {
                            i.this.hWP = BitmapFactory.decodeResource(i.this.hGm.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hWP);
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
                    i.this.hWO = null;
                    if (i.this.hWP != null && !i.this.hWP.isRecycled()) {
                        i.this.hWP.recycle();
                    }
                    i.this.hWP = null;
                }
            });
            this.hWO = dVar.hL();
            this.hWO.o(this.hGm.getActivity());
        }
    }

    public boolean rz(int i) {
        if (this.fus == null) {
            return false;
        }
        return this.fus.yo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(String str) {
        if (this.hWp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hWp.video_md5, "", str, this.hWq);
            }
        }
    }

    public void bWY() {
        if (this.hWm != null) {
            this.hWm.oW(this.hGm.bQE());
        }
    }

    public void bVP() {
        if (this.hWm != null) {
            this.hWm.bVP();
        }
    }

    public void xI(int i) {
        if (this.hWm != null) {
            this.hWm.xI(i);
        }
        if (this.hWM != null) {
            this.hWM.onChangeSkinType(i);
        }
        if (this.hWr != null) {
            this.hWr.iW(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bXb()) {
                    this.hWz = i;
                    if (this.hWz == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.xO(i.this.aHP().getHeight());
                            }
                        }, 100L);
                    }
                    bWZ();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (aHP().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWn.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hWS = false;
                    if (this.hWE != aHP().getHeight()) {
                        this.hWn.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hGm.getActivity()), Math.min(this.hWE, aHP().getHeight() + i)));
                        this.fus.bIn();
                    }
                } else if (l.af(this.hGm.getActivity()) * 0.5625d != aHP().getHeight()) {
                    this.hWn.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hGm.getActivity()), (int) Math.max(l.af(this.hGm.getActivity()) * 0.5625d, aHP().getHeight() + i)));
                    this.fus.bIn();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bXe()) {
                int bottom = childAt.getBottom() - aHP().getBottom();
                if (childAt.getHeight() == 0 || aHP().getHeight() == 0) {
                    bottom = 0;
                }
                xN(bottom);
            } else {
                xN((-this.hWE) + 2);
            }
        }
        if (!bXb() && this.hWL) {
            if (this.hWz == 1) {
                this.hWR = true;
                xO(aHP().getHeight());
            } else if (this.hWz == 2) {
                this.hWR = true;
                int y = (int) aHP().getY();
                if (this.hWA == y) {
                    xO(aHP().getHeight());
                } else {
                    this.hWA = y;
                    xO(aHP().getHeight());
                }
                if (i == 0 && this.hWD) {
                    this.hWD = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bWW();
                        }
                    }, 100L);
                }
            } else if (this.hWz == 0) {
                if (this.hWR || !"nani_midpage".equals(this.hGm.bRc())) {
                    xO(aHP().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(int i) {
        xP(i);
        bWZ();
    }

    public void oK(boolean z) {
        this.hWS = z;
    }

    private void xP(int i) {
        if (this.hWr != null) {
            if (i == 0) {
                i = this.hWE;
            }
            float f = this.hWE - i;
            float f2 = f > this.hWB ? 0.0f : 1.0f - (f / this.hWB);
            if (this.hWS) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hWr.bWQ().setVisibility(8);
            } else {
                this.hWr.bWQ().setVisibility(0);
            }
            this.hWr.aN(f2);
        }
    }

    public void bWZ() {
        if (this.hWr != null) {
            if (bXb()) {
                this.hGm.bRe().bUY();
            } else if (this.hWr.bWQ().getVisibility() == 0) {
                this.hGm.bRe().bUY();
                this.hWs = true;
            } else if (this.hWs) {
                this.hGm.bRe().oJ(false);
                this.hWs = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXa() {
        return aHP().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hWy = false;
        if (this.fus != null && this.hWn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWn.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fNI != null && this.fNI.isShowing()) {
                    this.fNI.tK();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hWO != null) {
                    this.hWO.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hWy = true;
                this.hWn.setLayoutParams(layoutParams);
                this.hGm.bRe().bUY();
                this.hWs = true;
            } else {
                e(this.hWp);
                bWY();
                this.hWy = false;
                this.hWm.oV(true);
            }
            this.fus.a(this.hGm.getPageContext(), configuration);
        }
    }

    public boolean bXb() {
        return this.hWy;
    }

    public void q(long j, int i) {
        if (this.hWr != null && j > 0) {
            this.hWr.w(i, j);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.hWr != null) {
            this.hWr.P(onClickListener);
        }
    }

    public View aHP() {
        return this.hWl;
    }

    public boolean bVh() {
        if (aHP() == null) {
            return false;
        }
        return aHP().getBottom() > l.ah(aHP().getContext()) - l.g(aHP().getContext(), R.dimen.ds50);
    }

    public void bXc() {
        this.hWD = true;
    }

    public void bXd() {
        if (this.fus != null) {
            this.fus.pausePlay();
        }
    }

    public View bXe() {
        return this.mEmptyView;
    }
}
