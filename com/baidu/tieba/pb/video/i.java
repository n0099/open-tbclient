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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
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
    private static VideoControllerView.a hkU = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aDM() {
        }
    };
    private static c.i igl = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bpk() {
        }
    };
    private boolean VL;
    private n dpp;
    private com.baidu.tieba.play.c fBQ;
    private com.baidu.mcn.c fVp;
    private PbActivity hPu;
    private RelativeLayout ifB;
    private com.baidu.tieba.pb.pb.main.view.c ifC;
    private CustomFrameLayout ifD;
    private c.d ifE;
    private z ifG;
    private g ifH;
    private boolean ifI;
    private bh ifJ;
    private bh ifK;
    private String ifL;
    private float ifR;
    private int ifU;
    private double ifV;
    private long ifW;
    private PbVideoWifiTipLayout ifX;
    private int ifY;
    private c.d iga;
    private PbFullScreenFloatingHuajiAninationView igc;
    private com.baidu.adp.lib.guide.c ige;
    private Bitmap igf;
    private boolean igg;
    private boolean igi;
    private int igk;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bXa = null;
    private VideoInfo ifF = null;
    private boolean ifM = false;
    private int ifN = 0;
    private boolean ifO = false;
    private int ifP = 0;
    private int ifQ = 0;
    private boolean ifS = false;
    private boolean ifT = false;
    private long startPosition = -1;
    private int fct = 0;
    private c.p ifZ = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void cbd() {
            if (i.this.hPu != null && i.this.hPu.bUE() != null && i.this.hPu.bUE().getPbData() != null) {
                PostData bTF = i.this.hPu.bUE().getPbData().bTF();
                if (bTF == null && v.Z(i.this.hPu.bUE().getPbData().bTA()) > 1) {
                    bTF = (PostData) v.c(i.this.hPu.bUE().getPbData().bTA(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hPu.bUE().getPbData(), bTF, 1, 1, 4);
            }
        }
    };
    private boolean igb = true;
    private PbFullScreenFloatingHuajiAninationView.a igd = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.px(false);
        }
    };
    private boolean igh = false;
    private c.m igj = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cbf() {
            if (i.this.ifV < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hPu.checkUpIsLogin()) {
                i.this.hPu.bVI();
                if (i.this.hPu.bUE() == null || i.this.hPu.bUE().getPbData() == null || i.this.hPu.bUE().getPbData().bTV() == null) {
                    return false;
                }
                j bTV = i.this.hPu.bUE().getPbData().bTV();
                if (i.this.igc == null) {
                    i.this.igc = new PbFullScreenFloatingHuajiAninationView(i.this.hPu.getActivity());
                    i.this.igc.setFloatingHuajiAninationListener(i.this.igd);
                }
                i.this.igc.pA(bTV.bUe() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cbg() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.kc()) {
                if (i.this.fBQ != null) {
                    i.this.fBQ.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.ke() && i.this.fBQ != null && i.this.fBQ.pC() && i.this.ifF != null && i.this.ifF.video_length.intValue() > 0 && i.this.ifF.video_duration.intValue() > 0) {
                    float intValue = i.this.ifF.video_length.intValue() * (1.0f - ((i.this.fBQ.getCurrentPosition() * 1.0f) / (i.this.ifF.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hPu.getPageContext().getPageActivity(), String.format(i.this.hPu.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hiV = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bZM();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fxE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.ifF != null) {
                i.this.e(i.this.ifF);
                i.this.fBQ.ceW();
                i.this.fBQ.bLZ();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.ifU;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void px(boolean z) {
        if (this.hPu != null) {
            this.hPu.bUY();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.ifR = 0.0f;
        this.hPu = pbActivity;
        this.ifC = cVar;
        this.ifR = l.g(this.hPu.getActivity(), R.dimen.ds240);
        this.ifW = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fxE.setTag(pbActivity.getUniqueId());
        this.fxE.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fxE);
        this.fVp = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int af = l.af(this.hPu.getActivity());
        Rect ab = bb.ab(this.hPu.getPageContext().getPageActivity());
        int ah = ab.height() <= 0 ? l.ah(this.hPu.getActivity()) : ab.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.ifV = (intValue2 * 1.0d) / intValue;
            if (this.ifV > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.ifU = i;
        this.ifD.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    public boolean caS() {
        return this.ifV >= 1.0d;
    }

    public int caT() {
        return this.ifU;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.ifB = (RelativeLayout) LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.ifD = (CustomFrameLayout) this.ifB.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.VL = ((double) this.ifU) <= (((double) l.af(this.hPu.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fBQ = new com.baidu.tieba.play.c(this.hPu.getPageContext(), this.ifD, true, com.baidu.tbadk.a.b.ly("cyber_player_test") ? 1 : 0);
        this.fBQ.a(this.igj);
        this.fBQ.qg(false);
        this.fBQ.a(this.ifZ);
        this.fBQ.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hPu) || TbSingleton.getInstance().isCutoutScreen(this.hPu)) {
            this.fBQ.pX(false);
        }
        this.fBQ.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.hPu.getListView() != null && i.this.hPu.getListView().getChildCount() > 0 && i.this.hPu.getListView().getChildAt(0) == i.this.cbc()) {
                            i.this.igk = i.this.cbc().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.igk = 0;
                        break;
                    case 2:
                        if (i.this.hPu.getListView() != null && i.this.hPu.getListView().getChildCount() > 0 && i.this.hPu.getListView().getChildAt(0) == i.this.cbc()) {
                            i.this.hPu.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.igk);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.ifV >= 1.0d) {
                this.fBQ.ae(false, true);
            } else {
                this.fBQ.ae(true, false);
            }
            this.ifS = ((float) e) + this.ifR > ((float) l.ah(this.hPu.getActivity()));
            if (this.ifS) {
                if (this.ifH == null) {
                    this.ifH = new g(this.hPu.getPageContext(), this.ifD);
                }
                this.hPu.bUW().bYU();
                this.ifI = true;
            }
        }
        caV();
        this.mEmptyView = new View(this.hPu);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.ifU));
        if (this.ifC != null && this.ifC.mNavigationBar != null) {
            this.ifC.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.ifC.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.ifC.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aie() && !TbSingleton.getInstance().isNotchScreen(this.hPu) && !TbSingleton.getInstance().isCutoutScreen(this.hPu)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.ifX = (PbVideoWifiTipLayout) this.ifB.findViewById(R.id.layout_wifi_tip);
        this.ifX.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.igg = true;
                i.this.ifX.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fVp != null) {
            this.fVp.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hPu.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.ifE == null) {
            this.ifE = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void kv(boolean z) {
                    if (i.this.caY() && i.this.ifC != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.ifC.bZF().clearAnimation();
                        i.this.caW();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.hiV);
                            i.this.ifC.bZF().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bpj() {
                    if (i.this.caY()) {
                        i.this.bZM();
                    }
                }
            };
        }
        a(this.ifE);
        this.ifN = UtilHelper.getLightStatusBarHeight() + l.g(this.hPu.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bh bhVar, final String str) {
        if (videoInfo != null && this.fBQ != null && bhVar != null) {
            this.ifF = videoInfo;
            this.ifJ = bhVar;
            this.bXa = videoInfo.video_url;
            this.fBQ.stopPlay();
            this.fBQ.setIsNeedRecoveryVideoPlayer(true);
            this.dpp = new n(this.hPu.getActivity());
            this.ifG = new z();
            this.ifG.mLocate = "pb";
            this.ifG.bXN = bhVar.getTid();
            this.ifG.eHo = str;
            this.ifG.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ifG.iAF = this.hPu.bUT();
            av bVK = this.hPu.bVK();
            if (bVK != null) {
                bVK.b(this.ifG);
            }
            this.ifG.iAH = videoInfo.video_md5;
            z cfT = this.ifG.cfT();
            cfT.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dpp.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cJ = com.baidu.mcn.b.uj().cJ(mcnAdInfo.jump_url);
                        if (i.this.VL && !cJ && !i.this.ifO) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fVp.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aft = mcnAdInfo.card_title;
                                    aVar.afu = mcnAdInfo.button_title;
                                    aVar.afv = mcnAdInfo.jump_url;
                                    aVar.afs = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bhVar.getTid();
                                    aVar.afw = 4;
                                    if (z2) {
                                        i.this.fVp.b(aVar, (ViewGroup) i.this.fBQ.ceV());
                                    } else {
                                        i.this.fVp.a(aVar, (ViewGroup) i.this.fBQ.ceV());
                                    }
                                }
                            } else if (i.this.fVp.isShowing()) {
                                i.this.fVp.dismiss();
                            }
                        }
                    }
                }
            });
            this.dpp.setVideoStatsData(cfT);
            this.fBQ.ceE().setBusiness(this.dpp);
            if (this.fBQ.bMb()) {
                this.fBQ.bLZ();
            }
            this.fBQ.b(this.iga);
            this.ifL = null;
            this.ifK = null;
            this.fBQ.CU(this.ifL);
            this.fBQ.bLV().setOnDragingListener(hkU);
            this.fBQ.a(new c.InterfaceC0403c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pB() {
                    i.this.hPu.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.ifY > 0) {
                                i.this.yw(i.this.ifY);
                                i.this.yx(i.this.ifY);
                                i.this.ifY = 0;
                            }
                            i.this.igb = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0403c
                public void pA() {
                    i.this.hPu.setSwipeBackEnabled(false);
                    i.this.igb = false;
                    i.this.ifY = i.this.aJY().getHeight();
                }
            });
            this.fBQ.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void cbe() {
                    if (i.this.hPu != null && i.this.ifK != null && !StringUtils.isNull(i.this.ifK.getId())) {
                        i.this.hPu.Cn(i.this.ifK.getId());
                        if (i.this.ifJ != null) {
                            long j = 0;
                            if (i.this.ifJ.afM() != null) {
                                j = i.this.ifJ.afM().channelId;
                            }
                            TiebaStatic.log(new an("c11921").n(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fBQ.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void py(boolean z) {
                    if (i.this.ifJ != null) {
                        long j = 0;
                        if (i.this.ifJ.afM() != null) {
                            j = i.this.ifJ.afM().channelId;
                        }
                        i.this.xz(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").bT("tid", i.this.ifJ.getTid()).n("fid", i.this.ifJ.getFid()).n(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fBQ.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bXa);
                    return true;
                }
            });
            this.fBQ.setThumbnail(videoInfo.thumbnail_url);
            this.fBQ.setVideoUrl(this.bXa, bhVar.getTid());
            this.fBQ.setFid(str);
            this.fBQ.Du(bhVar.getTitle());
            this.fBQ.a(igl);
            this.fBQ.bzb();
            this.fBQ.show();
        }
    }

    public void CT(String str) {
        if (this.ifG != null) {
            this.ifG.eHo = str;
        }
    }

    public void b(PostData postData, bh bhVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.ifH != null) {
            this.ifH.a(postData, bhVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.iga = dVar;
    }

    public void aD(bh bhVar) {
        this.ifK = bhVar;
    }

    public void CU(String str) {
        this.ifL = str;
        if (this.fBQ != null) {
            this.fBQ.CU(this.ifL);
        }
    }

    public void startPlay() {
        if (this.fBQ != null) {
            if (com.baidu.adp.lib.util.j.ke() && !this.igg && !com.baidu.tieba.video.g.cuO().cuP()) {
                this.ifX.setVisibility(0);
                this.ifX.setData(this.ifF);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bXa) && this.ifJ != null && this.ifJ.aeT() != null) {
                TiebaStatic.log(new an("c12619").bT("obj_locate", "pb").bT("tid", this.ifJ.getTid()));
                this.bXa = this.ifJ.aeT().video_url;
            }
            this.fBQ.ct(this.bXa, this.ifJ == null ? "" : this.ifJ.getTid());
            xz("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void caU() {
        if (this.fBQ != null) {
            this.fBQ.caU();
        }
    }

    public void destroy() {
        if (this.fBQ != null) {
            this.fBQ.destroy();
        }
        if (this.ifD != null) {
            this.ifD.clearAnimation();
        }
        if (this.ifH != null) {
            this.ifH.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fxE);
    }

    public void onPause() {
        if (this.fBQ != null) {
            if (this.fBQ.pC()) {
                this.ifM = true;
                this.fBQ.stopPlay();
            } else if (this.fBQ.getCurrentState() == 3) {
                this.ifM = false;
            } else if (this.fBQ.getCurrentState() == 0 || this.fBQ.getCurrentState() == 1) {
                this.ifM = true;
                this.fBQ.stopPlay();
            } else {
                this.ifM = false;
                this.fBQ.stopPlay();
            }
            if (this.igc != null) {
                this.igc.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fBQ != null && this.ifM) {
            this.fBQ.ceI();
        }
    }

    private void caV() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.T(true);
            dVar.V(false);
            dVar.Y(16908290).X(153).U(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hPu.getActivity());
                    if (i.this.igf == null) {
                        try {
                            i.this.igf = BitmapFactory.decodeResource(i.this.hPu.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.igf);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hT() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hU() {
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
                    i.this.ige = null;
                    if (i.this.igf != null && !i.this.igf.isRecycled()) {
                        i.this.igf.recycle();
                    }
                    i.this.igf = null;
                }
            });
            this.ige = dVar.hV();
            this.ige.r(this.hPu.getActivity());
        }
    }

    public boolean rW(int i) {
        if (this.fBQ == null) {
            return false;
        }
        return this.fBQ.yY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(String str) {
        if (this.ifF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.ifF.video_md5, "", str, this.ifG);
            }
        }
    }

    public void caW() {
        if (this.ifC != null) {
            this.ifC.pp(this.hPu.bUu());
        }
    }

    public void bZM() {
        if (this.ifC != null) {
            this.ifC.bZM();
        }
    }

    public void yr(int i) {
        if (this.ifC != null) {
            this.ifC.yr(i);
        }
        if (this.igc != null) {
            this.igc.onChangeSkinType(i);
        }
        if (this.ifH != null) {
            this.ifH.jg(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!caZ()) {
                    this.ifP = i;
                    if (this.ifP == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.yx(i.this.aJY().getHeight());
                            }
                        }, 100L);
                    }
                    caX();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (aJY().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifD.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.igi = false;
                    if (this.ifU != aJY().getHeight()) {
                        this.ifD.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hPu.getActivity()), Math.min(this.ifU, aJY().getHeight() + i)));
                        this.fBQ.bLZ();
                    }
                } else if (l.af(this.hPu.getActivity()) * 0.5625d != aJY().getHeight()) {
                    this.ifD.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hPu.getActivity()), (int) Math.max(l.af(this.hPu.getActivity()) * 0.5625d, aJY().getHeight() + i)));
                    this.fBQ.bLZ();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cbc()) {
                int bottom = childAt.getBottom() - aJY().getBottom();
                if (childAt.getHeight() == 0 || aJY().getHeight() == 0) {
                    bottom = 0;
                }
                yw(bottom);
            } else {
                yw((-this.ifU) + 2);
            }
        }
        if (!caZ() && this.igb) {
            if (this.ifP == 1) {
                this.igh = true;
                yx(aJY().getHeight());
            } else if (this.ifP == 2) {
                this.igh = true;
                int y = (int) aJY().getY();
                if (this.ifQ == y) {
                    yx(aJY().getHeight());
                } else {
                    this.ifQ = y;
                    yx(aJY().getHeight());
                }
                if (i == 0 && this.ifT) {
                    this.ifT = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.caU();
                        }
                    }, 100L);
                }
            } else if (this.ifP == 0) {
                if (this.igh || !"nani_midpage".equals(this.hPu.bUT())) {
                    yx(aJY().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        yy(i);
        caX();
    }

    public void pd(boolean z) {
        this.igi = z;
    }

    private void yy(int i) {
        if (this.ifH != null) {
            if (i == 0) {
                i = this.ifU;
            }
            float f = this.ifU - i;
            float f2 = f > this.ifR ? 0.0f : 1.0f - (f / this.ifR);
            if (this.igi) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.ifH.caO().setVisibility(8);
            } else {
                this.ifH.caO().setVisibility(0);
            }
            this.ifH.aP(f2);
        }
    }

    public void caX() {
        if (this.ifH != null) {
            if (caZ()) {
                this.hPu.bUW().bYU();
            } else if (this.ifH.caO().getVisibility() == 0) {
                this.hPu.bUW().bYU();
                this.ifI = true;
            } else if (this.ifI) {
                this.hPu.bUW().pc(false);
                this.ifI = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caY() {
        return aJY().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.ifO = false;
        if (this.fBQ != null && this.ifD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifD.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fVp != null && this.fVp.isShowing()) {
                    this.fVp.uk();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.ige != null) {
                    this.ige.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.ifO = true;
                this.ifD.setLayoutParams(layoutParams);
                this.hPu.bUW().bYU();
                this.ifI = true;
            } else {
                e(this.ifF);
                caW();
                this.ifO = false;
                this.ifC.po(true);
            }
            this.fBQ.a(this.hPu.getPageContext(), configuration);
        }
    }

    public boolean caZ() {
        return this.ifO;
    }

    public void q(long j, int i) {
        if (this.ifH != null && j > 0) {
            this.ifH.w(i, j);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.ifH != null) {
            this.ifH.R(onClickListener);
        }
    }

    public View aJY() {
        return this.ifB;
    }

    public boolean bZd() {
        if (aJY() == null) {
            return false;
        }
        return aJY().getBottom() > l.ah(aJY().getContext()) - l.g(aJY().getContext(), R.dimen.ds50);
    }

    public void cba() {
        this.ifT = true;
    }

    public void cbb() {
        if (this.fBQ != null) {
            this.fBQ.pausePlay();
        }
    }

    public View cbc() {
        return this.mEmptyView;
    }
}
