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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
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
    private static VideoControllerView.a hja = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aDi() {
        }
    };
    private static c.i iem = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void boz() {
        }
    };
    private float Ok;
    private boolean VM;
    private n dnD;
    private com.baidu.tieba.play.c fAd;
    private com.baidu.mcn.c fTy;
    private PbActivity hNx;
    private RelativeLayout idC;
    private com.baidu.tieba.pb.pb.main.view.c idD;
    private CustomFrameLayout idE;
    private c.d idF;
    private z idH;
    private g idI;
    private boolean idJ;
    private bh idK;
    private bh idL;
    private String idM;
    private float idS;
    private int idV;
    private double idW;
    private long idX;
    private PbVideoWifiTipLayout idY;
    private int idZ;
    private c.d ieb;
    private PbFullScreenFloatingHuajiAninationView ied;
    private com.baidu.adp.lib.guide.c ief;
    private Bitmap ieg;
    private boolean ieh;
    private boolean iej;
    private int iel;
    private View mEmptyView;
    private Handler mHandler;
    private String bWh = null;
    private VideoInfo idG = null;
    private boolean idN = false;
    private int idO = 0;
    private boolean idP = false;
    private int idQ = 0;
    private int idR = 0;
    private boolean idT = false;
    private boolean idU = false;
    private long startPosition = -1;
    private int faN = 0;
    private c.p iea = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void cap() {
            if (i.this.hNx != null && i.this.hNx.bTR() != null && i.this.hNx.bTR().getPbData() != null) {
                PostData bSS = i.this.hNx.bTR().getPbData().bSS();
                if (bSS == null && v.Z(i.this.hNx.bTR().getPbData().bSN()) > 1) {
                    bSS = (PostData) v.c(i.this.hNx.bTR().getPbData().bSN(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hNx.bTR().getPbData(), bSS, 1, 1, 4);
            }
        }
    };
    private boolean iec = true;
    private PbFullScreenFloatingHuajiAninationView.a iee = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pt(false);
        }
    };
    private boolean iei = false;
    private c.m iek = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean car() {
            if (i.this.idW < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hNx.checkUpIsLogin()) {
                i.this.hNx.bUV();
                if (i.this.hNx.bTR() == null || i.this.hNx.bTR().getPbData() == null || i.this.hNx.bTR().getPbData().bTi() == null) {
                    return false;
                }
                j bTi = i.this.hNx.bTR().getPbData().bTi();
                if (i.this.ied == null) {
                    i.this.ied = new PbFullScreenFloatingHuajiAninationView(i.this.hNx.getActivity());
                    i.this.ied.setFloatingHuajiAninationListener(i.this.iee);
                }
                i.this.ied.pw(bTi.bTr() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cas() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.kc()) {
                if (i.this.fAd != null) {
                    i.this.fAd.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.ke() && i.this.fAd != null && i.this.fAd.pB() && i.this.idG != null && i.this.idG.video_length.intValue() > 0 && i.this.idG.video_duration.intValue() > 0) {
                    float intValue = i.this.idG.video_length.intValue() * (1.0f - ((i.this.fAd.getCurrentPosition() * 1.0f) / (i.this.idG.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hNx.getPageContext().getPageActivity(), String.format(i.this.hNx.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hha = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bYY();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fvR = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.idG != null) {
                i.this.e(i.this.idG);
                i.this.fAd.ceh();
                i.this.fAd.bLm();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.idV;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (this.hNx != null) {
            this.hNx.bUl();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.idS = 0.0f;
        this.hNx = pbActivity;
        this.idD = cVar;
        this.idS = l.g(this.hNx.getActivity(), R.dimen.ds240);
        this.idX = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fvR.setTag(pbActivity.getUniqueId());
        this.fvR.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fvR);
        this.fTy = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int af = l.af(this.hNx.getActivity());
        Rect ab = bc.ab(this.hNx.getPageContext().getPageActivity());
        int ah = ab.height() <= 0 ? l.ah(this.hNx.getActivity()) : ab.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.idW = (intValue2 * 1.0d) / intValue;
            if (this.idW > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.idV = i;
        this.idE.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    public boolean cae() {
        return this.idW >= 1.0d;
    }

    public int caf() {
        return this.idV;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.idC = (RelativeLayout) LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.idE = (CustomFrameLayout) this.idC.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.VM = ((double) this.idV) <= (((double) l.af(this.hNx.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fAd = new com.baidu.tieba.play.c((TbPageContext<?>) this.hNx.getPageContext(), (View) this.idE, true);
        this.fAd.a(this.iek);
        this.fAd.qd(false);
        this.fAd.a(this.iea);
        this.fAd.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hNx) || TbSingleton.getInstance().isCutoutScreen(this.hNx)) {
            this.fAd.pU(false);
        }
        this.fAd.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        i.this.Ok = motionEvent.getY();
                        if (i.this.hNx.getListView() != null && i.this.hNx.getListView().getChildCount() > 0 && i.this.hNx.getListView().getChildAt(0) == i.this.cao()) {
                            i.this.iel = i.this.cao().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Ok = 0.0f;
                        i.this.iel = 0;
                        break;
                    case 2:
                        if (i.this.hNx.getListView() != null && i.this.hNx.getListView().getChildCount() > 0 && i.this.hNx.getListView().getChildAt(0) == i.this.cao()) {
                            i.this.hNx.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Ok)) + i.this.iel);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.idW >= 1.0d) {
                this.fAd.ag(false, true);
            } else {
                this.fAd.ag(true, false);
            }
            this.idT = ((float) e) + this.idS > ((float) l.ah(this.hNx.getActivity()));
            if (this.idT) {
                if (this.idI == null) {
                    this.idI = new g(this.hNx.getPageContext(), this.idE);
                }
                this.hNx.bUj().bYh();
                this.idJ = true;
            }
        }
        cah();
        this.mEmptyView = new View(this.hNx);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.idV));
        if (this.idD != null && this.idD.mNavigationBar != null) {
            this.idD.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.idD.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.idD.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aia() && !TbSingleton.getInstance().isNotchScreen(this.hNx) && !TbSingleton.getInstance().isCutoutScreen(this.hNx)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.idY = (PbVideoWifiTipLayout) this.idC.findViewById(R.id.layout_wifi_tip);
        this.idY.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.ieh = true;
                i.this.idY.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fTy != null) {
            this.fTy.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hNx.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.idF == null) {
            this.idF = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ks(boolean z) {
                    if (i.this.cak() && i.this.idD != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.idD.bYS().clearAnimation();
                        i.this.cai();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.hha);
                            i.this.idD.bYS().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void boy() {
                    if (i.this.cak()) {
                        i.this.bYY();
                    }
                }
            };
        }
        a(this.idF);
        this.idO = UtilHelper.getLightStatusBarHeight() + l.g(this.hNx.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bh bhVar, final String str) {
        if (videoInfo != null && this.fAd != null && bhVar != null) {
            this.idG = videoInfo;
            this.idK = bhVar;
            this.bWh = videoInfo.video_url;
            this.fAd.stopPlay();
            this.fAd.setIsNeedRecoveryVideoPlayer(true);
            this.dnD = new n(this.hNx.getActivity());
            this.idH = new z();
            this.idH.mLocate = "pb";
            this.idH.bWU = bhVar.getTid();
            this.idH.eFF = str;
            this.idH.mUid = TbadkCoreApplication.getCurrentAccount();
            this.idH.iyD = this.hNx.bUg();
            av bUX = this.hNx.bUX();
            if (bUX != null) {
                bUX.b(this.idH);
            }
            this.idH.iyF = videoInfo.video_md5;
            z cff = this.idH.cff();
            cff.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dnD.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cJ = com.baidu.mcn.b.uj().cJ(mcnAdInfo.jump_url);
                        if (i.this.VM && !cJ && !i.this.idP) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fTy.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aft = mcnAdInfo.card_title;
                                    aVar.afu = mcnAdInfo.button_title;
                                    aVar.afv = mcnAdInfo.jump_url;
                                    aVar.afs = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bhVar.getTid();
                                    aVar.afw = 4;
                                    if (z2) {
                                        i.this.fTy.b(aVar, (ViewGroup) i.this.fAd.ceg());
                                    } else {
                                        i.this.fTy.a(aVar, (ViewGroup) i.this.fAd.ceg());
                                    }
                                }
                            } else if (i.this.fTy.isShowing()) {
                                i.this.fTy.dismiss();
                            }
                        }
                    }
                }
            });
            this.dnD.setVideoStatsData(cff);
            this.fAd.getVideoView().setBusiness(this.dnD);
            if (this.fAd.bLo()) {
                this.fAd.bLm();
            }
            this.fAd.b(this.ieb);
            this.idM = null;
            this.idL = null;
            this.fAd.Cv(this.idM);
            this.fAd.bLi().setOnDragingListener(hja);
            this.fAd.a(new c.InterfaceC0392c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pA() {
                    i.this.hNx.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.idZ > 0) {
                                i.this.yt(i.this.idZ);
                                i.this.yu(i.this.idZ);
                                i.this.idZ = 0;
                            }
                            i.this.iec = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0392c
                public void pz() {
                    i.this.hNx.setSwipeBackEnabled(false);
                    i.this.iec = false;
                    i.this.idZ = i.this.aJu().getHeight();
                }
            });
            this.fAd.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void caq() {
                    if (i.this.hNx != null && i.this.idL != null && !StringUtils.isNull(i.this.idL.getId())) {
                        i.this.hNx.BO(i.this.idL.getId());
                        if (i.this.idK != null) {
                            long j = 0;
                            if (i.this.idK.afI() != null) {
                                j = i.this.idK.afI().channelId;
                            }
                            TiebaStatic.log(new an("c11921").l(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fAd.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void pu(boolean z) {
                    if (i.this.idK != null) {
                        long j = 0;
                        if (i.this.idK.afI() != null) {
                            j = i.this.idK.afI().channelId;
                        }
                        i.this.xa(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").bT("tid", i.this.idK.getTid()).l("fid", i.this.idK.getFid()).l(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fAd.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bWh);
                    return true;
                }
            });
            this.fAd.setThumbnail(videoInfo.thumbnail_url);
            this.fAd.setVideoUrl(this.bWh, bhVar.getTid());
            this.fAd.setFid(str);
            this.fAd.CV(bhVar.getTitle());
            this.fAd.a(iem);
            this.fAd.byn();
            this.fAd.show();
        }
    }

    public void Cu(String str) {
        if (this.idH != null) {
            this.idH.eFF = str;
        }
    }

    public void b(PostData postData, bh bhVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.idI != null) {
            this.idI.a(postData, bhVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.ieb = dVar;
    }

    public void aC(bh bhVar) {
        this.idL = bhVar;
    }

    public void Cv(String str) {
        this.idM = str;
        if (this.fAd != null) {
            this.fAd.Cv(this.idM);
        }
    }

    public void startPlay() {
        if (this.fAd != null) {
            if (com.baidu.adp.lib.util.j.ke() && !this.ieh && !com.baidu.tieba.video.g.cua().cub()) {
                this.idY.setVisibility(0);
                this.idY.setData(this.idG);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bWh) && this.idK != null && this.idK.aeP() != null) {
                TiebaStatic.log(new an("c12619").bT("obj_locate", "pb").bT("tid", this.idK.getTid()));
                this.bWh = this.idK.aeP().video_url;
            }
            this.fAd.i(this.bWh, this.idK == null ? "" : this.idK.getTid(), this.idX);
            xa("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void cag() {
        if (this.fAd != null) {
            this.fAd.cag();
        }
    }

    public void destroy() {
        if (this.fAd != null) {
            this.fAd.destroy();
        }
        if (this.idE != null) {
            this.idE.clearAnimation();
        }
        if (this.idI != null) {
            this.idI.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fvR);
    }

    public void onPause() {
        if (this.fAd != null) {
            if (this.fAd.pB()) {
                this.idN = true;
                this.fAd.stopPlay();
            } else if (this.fAd.getCurrentState() == 3) {
                this.idN = false;
            } else if (this.fAd.getCurrentState() == 0 || this.fAd.getCurrentState() == 1) {
                this.idN = true;
                this.fAd.stopPlay();
            } else {
                this.idN = false;
                this.fAd.stopPlay();
            }
            if (this.ied != null) {
                this.ied.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fAd != null && this.idN) {
            this.fAd.cdS();
        }
    }

    private void cah() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.T(true);
            dVar.V(false);
            dVar.Y(16908290).X(153).U(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hNx.getActivity());
                    if (i.this.ieg == null) {
                        try {
                            i.this.ieg = BitmapFactory.decodeResource(i.this.hNx.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.ieg);
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
                    i.this.ief = null;
                    if (i.this.ieg != null && !i.this.ieg.isRecycled()) {
                        i.this.ieg.recycle();
                    }
                    i.this.ieg = null;
                }
            });
            this.ief = dVar.hV();
            this.ief.r(this.hNx.getActivity());
        }
    }

    public boolean rT(int i) {
        if (this.fAd == null) {
            return false;
        }
        return this.fAd.yV(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(String str) {
        if (this.idG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.idG.video_md5, "", str, this.idH);
            }
        }
    }

    public void cai() {
        if (this.idD != null) {
            this.idD.pl(this.hNx.bTH());
        }
    }

    public void bYY() {
        if (this.idD != null) {
            this.idD.bYY();
        }
    }

    public void yo(int i) {
        if (this.idD != null) {
            this.idD.yo(i);
        }
        if (this.ied != null) {
            this.ied.onChangeSkinType(i);
        }
        if (this.idI != null) {
            this.idI.jd(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cal()) {
                    this.idQ = i;
                    if (this.idQ == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.yu(i.this.aJu().getHeight());
                            }
                        }, 100L);
                    }
                    caj();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(int i) {
        if (aJu().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idE.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iej = false;
                    if (this.idV != aJu().getHeight()) {
                        this.idE.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hNx.getActivity()), Math.min(this.idV, aJu().getHeight() + i)));
                        this.fAd.bLm();
                    }
                } else if (l.af(this.hNx.getActivity()) * 0.5625d != aJu().getHeight()) {
                    this.idE.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hNx.getActivity()), (int) Math.max(l.af(this.hNx.getActivity()) * 0.5625d, aJu().getHeight() + i)));
                    this.fAd.bLm();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cao()) {
                int bottom = childAt.getBottom() - aJu().getBottom();
                if (childAt.getHeight() == 0 || aJu().getHeight() == 0) {
                    bottom = 0;
                }
                yt(bottom);
            } else {
                yt((-this.idV) + 2);
            }
        }
        if (!cal() && this.iec) {
            if (this.idQ == 1) {
                this.iei = true;
                yu(aJu().getHeight());
            } else if (this.idQ == 2) {
                this.iei = true;
                int y = (int) aJu().getY();
                if (this.idR == y) {
                    yu(aJu().getHeight());
                } else {
                    this.idR = y;
                    yu(aJu().getHeight());
                }
                if (i == 0 && this.idU) {
                    this.idU = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.cag();
                        }
                    }, 100L);
                }
            } else if (this.idQ == 0) {
                if (this.iei || !"nani_midpage".equals(this.hNx.bUg())) {
                    yu(aJu().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(int i) {
        yv(i);
        caj();
    }

    public void oZ(boolean z) {
        this.iej = z;
    }

    private void yv(int i) {
        if (this.idI != null) {
            if (i == 0) {
                i = this.idV;
            }
            float f = this.idV - i;
            float f2 = f > this.idS ? 0.0f : 1.0f - (f / this.idS);
            if (this.iej) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.idI.caa().setVisibility(8);
            } else {
                this.idI.caa().setVisibility(0);
            }
            this.idI.aO(f2);
        }
    }

    public void caj() {
        if (this.idI != null) {
            if (cal()) {
                this.hNx.bUj().bYh();
            } else if (this.idI.caa().getVisibility() == 0) {
                this.hNx.bUj().bYh();
                this.idJ = true;
            } else if (this.idJ) {
                this.hNx.bUj().oY(false);
                this.idJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cak() {
        return aJu().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.idP = false;
        if (this.fAd != null && this.idE != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idE.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fTy != null && this.fTy.isShowing()) {
                    this.fTy.uk();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.ief != null) {
                    this.ief.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.idP = true;
                this.idE.setLayoutParams(layoutParams);
                this.hNx.bUj().bYh();
                this.idJ = true;
            } else {
                e(this.idG);
                cai();
                this.idP = false;
                this.idD.pk(true);
            }
            this.fAd.a(this.hNx.getPageContext(), configuration);
        }
    }

    public boolean cal() {
        return this.idP;
    }

    public void q(long j, int i) {
        if (this.idI != null && j > 0) {
            this.idI.w(i, j);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.idI != null) {
            this.idI.R(onClickListener);
        }
    }

    public View aJu() {
        return this.idC;
    }

    public boolean bYq() {
        if (aJu() == null) {
            return false;
        }
        return aJu().getBottom() > l.ah(aJu().getContext()) - l.g(aJu().getContext(), R.dimen.ds50);
    }

    public void cam() {
        this.idU = true;
    }

    public void can() {
        if (this.fAd != null) {
            this.fAd.pausePlay();
        }
    }

    public View cao() {
        return this.mEmptyView;
    }
}
