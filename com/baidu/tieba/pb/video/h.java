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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
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
    private static VideoControllerView.a iNu = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bgF() {
        }
    };
    private static c.i jJV = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bRe() {
        }
    };
    private float UZ;
    private boolean adl;
    private n ePc;
    private com.baidu.tieba.play.c hdZ;
    private com.baidu.mcn.c hyX;
    private float jJB;
    private int jJE;
    private double jJF;
    private long jJG;
    private PbVideoWifiTipLayout jJH;
    private int jJI;
    private c.d jJK;
    private PbFullScreenFloatingHuajiAninationView jJM;
    private com.baidu.adp.lib.guide.c jJO;
    private Bitmap jJP;
    private boolean jJQ;
    private boolean jJS;
    private int jJU;
    private RelativeLayout jJl;
    private com.baidu.tieba.pb.pb.main.view.c jJm;
    private CustomFrameLayout jJn;
    private c.d jJo;
    private y jJq;
    private f jJr;
    private boolean jJs;
    private bj jJt;
    private bj jJu;
    private String jJv;
    private PbFragment jpS;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo jJp = null;
    private boolean jJw = false;
    private int jJx = 0;
    private boolean jJy = false;
    private int jJz = 0;
    private int jJA = 0;
    private boolean jJC = false;
    private boolean jJD = false;
    private long startPosition = -1;
    private int gFC = 0;
    private c.p jJJ = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cDv() {
            if (h.this.jpS != null && h.this.jpS.cwD() != null && h.this.jpS.cwD().getPbData() != null) {
                PostData cvB = h.this.jpS.cwD().getPbData().cvB();
                if (cvB == null && v.getCount(h.this.jpS.cwD().getPbData().cvw()) > 1) {
                    cvB = (PostData) v.getItem(h.this.jpS.cwD().getPbData().cvw(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.jpS.cwD().getPbData(), cvB, 1, 1, 4);
            }
        }
    };
    private boolean jJL = true;
    private PbFullScreenFloatingHuajiAninationView.a jJN = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.rY(false);
        }
    };
    private boolean jJR = false;
    private c.m jJT = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cDx() {
            if (h.this.jJF < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.jpS.checkUpIsLogin()) {
                h.this.jpS.cyf();
                if (h.this.jpS.cwD() == null || h.this.jpS.cwD().getPbData() == null || h.this.jpS.cwD().getPbData().cvP() == null) {
                    return false;
                }
                k cvP = h.this.jpS.cwD().getPbData().cvP();
                if (h.this.jJM == null) {
                    h.this.jJM = new PbFullScreenFloatingHuajiAninationView(h.this.jpS.getActivity());
                    h.this.jJM.setFloatingHuajiAninationListener(h.this.jJN);
                }
                h.this.jJM.sn(cvP.cwe() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cDy() {
            return false;
        }
    };
    private CustomMessageListener MI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hdZ != null) {
                    h.this.hdZ.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hdZ != null && h.this.hdZ.pI() && h.this.jJp != null && h.this.jJp.video_length.intValue() > 0 && h.this.jJp.video_duration.intValue() > 0) {
                    float intValue = h.this.jJp.video_length.intValue() * (1.0f - ((h.this.hdZ.getCurrentPosition() * 1.0f) / (h.this.jJp.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.jpS.getPageContext().getPageActivity(), String.format(h.this.jpS.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener iLv = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cCi();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gZO = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.jJp != null) {
                h.this.f(h.this.jJp);
                h.this.hdZ.cJr();
                h.this.hdZ.cnB();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.jJE;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(boolean z) {
        if (this.jpS != null) {
            this.jpS.cxx();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.jJB = 0.0f;
        this.jpS = pbFragment;
        this.jJm = cVar;
        this.jJB = l.getDimens(this.jpS.getActivity(), R.dimen.ds240);
        this.jJG = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.MI);
        this.gZO.setTag(pbFragment.getUniqueId());
        this.gZO.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gZO);
        this.hyX = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.jJn.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.jpS.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.jpS.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.jpS.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.jpS.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.jJF = (intValue2 * 1.0d) / intValue;
            if (this.jJF > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.jJE = i;
        this.jJn.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean brK() {
        return this.jJF >= 1.0d;
    }

    public int cBO() {
        return this.jJE;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.jJl = (RelativeLayout) LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.jJn = (CustomFrameLayout) this.jJl.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.adl = ((double) this.jJE) <= (((double) l.getEquipmentWidth(this.jpS.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hdZ = new com.baidu.tieba.play.c(this.jpS.getPageContext(), this.jJn, true, com.baidu.tbadk.a.b.sV("cyber_player_test") || com.baidu.tbadk.a.b.sU("cyber_player_test") ? 1 : 0);
        this.hdZ.a(this.jJT);
        this.hdZ.sW(false);
        this.hdZ.a(this.jJJ);
        this.hdZ.AS(am.kB(R.drawable.pic_use_header_60_n));
        this.hdZ.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.jpS.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.jpS.getBaseFragmentActivity())) {
            this.hdZ.sN(false);
        }
        this.hdZ.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.UZ = motionEvent.getY();
                        if (h.this.jpS.getListView() != null && h.this.jpS.getListView().getChildCount() > 0 && h.this.jpS.getListView().getChildAt(0) == h.this.cDu()) {
                            h.this.jJU = h.this.cDu().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.UZ = 0.0f;
                        h.this.jJU = 0;
                        break;
                    case 2:
                        if (h.this.jpS.getListView() != null && h.this.jpS.getListView().getChildCount() > 0 && h.this.jpS.getListView().getChildAt(0) == h.this.cDu()) {
                            h.this.jpS.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.UZ)) + h.this.jJU);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.jJF >= 1.0d) {
                this.hdZ.ak(false, true);
            } else {
                this.hdZ.ak(true, false);
            }
            this.jJC = ((float) f) + this.jJB > ((float) l.getEquipmentHeight(this.jpS.getActivity()));
            if (this.jJC) {
                if (this.jJr == null) {
                    this.jJr = new f(this.jpS.getPageContext(), this.jJn);
                }
                this.jpS.cxv().cBk();
                this.jJs = true;
            }
        }
        cDp();
        this.mEmptyView = new View(this.jpS.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jJE));
        if (this.jJm != null && this.jJm.mNavigationBar != null) {
            this.jJm.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.jJm.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.jJm.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aOf() && !TbSingleton.getInstance().isNotchScreen(this.jpS.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jpS.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.jJH = (PbVideoWifiTipLayout) this.jJl.findViewById(R.id.layout_wifi_tip);
        this.jJH.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.jJQ = true;
                h.this.jJH.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.hyX != null) {
            this.hyX.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.jpS.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.jJo == null) {
            this.jJo = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void mR(boolean z) {
                    if (h.this.cDs() && h.this.jJm != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.jJm.cCb().clearAnimation();
                        h.this.cDq();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.iLv);
                            h.this.jJm.cCb().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bRd() {
                    if (h.this.cDs()) {
                        h.this.cCi();
                    }
                }
            };
        }
        a(this.jJo);
        this.jJx = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jpS.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.hdZ != null && bjVar != null) {
            this.jJp = videoInfo;
            this.jJt = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hdZ.stopPlay();
            this.hdZ.setIsNeedRecoveryVideoPlayer(true);
            this.ePc = new n(this.jpS.getActivity());
            this.jJq = new y();
            this.jJq.mLocate = "pb";
            this.jJq.ahL = bjVar.getTid();
            this.jJq.eQf = str;
            this.jJq.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.jpS.jub)) {
                    this.jJq.dol = this.jpS.jub;
                }
                this.jJq.kip = this.jpS.jua + "";
            } else {
                this.jJq.kip = this.jpS.cxs();
            }
            ax cyh = this.jpS.cyh();
            if (cyh != null) {
                cyh.b(this.jJq);
            }
            this.jJq.kis = videoInfo.video_md5;
            y cKs = this.jJq.cKs();
            cKs.mLocate = "6";
            this.startPosition = -1L;
            this.ePc.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean fu = com.baidu.mcn.b.JF().fu(mcnAdInfo.jump_url);
                        if (h.this.adl && !fu && !h.this.jJy) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.hyX.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.bhg = mcnAdInfo.card_title;
                                    aVar.bhh = mcnAdInfo.button_title;
                                    aVar.bhi = mcnAdInfo.jump_url;
                                    aVar.bhf = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.bhj = 4;
                                    if (z2) {
                                        h.this.hyX.b(aVar, (ViewGroup) h.this.hdZ.cJq());
                                    } else {
                                        h.this.hyX.a(aVar, (ViewGroup) h.this.hdZ.cJq());
                                    }
                                }
                            } else if (h.this.hyX.isShowing()) {
                                h.this.hyX.dismiss();
                            }
                        }
                    }
                }
            });
            this.ePc.setVideoStatsData(cKs);
            this.hdZ.cIZ().setBusiness(this.ePc);
            if (this.hdZ.cnD()) {
                this.hdZ.cnB();
            }
            this.hdZ.b(this.jJK);
            this.jJv = null;
            this.jJu = null;
            this.hdZ.Ie(this.jJv);
            this.hdZ.cnx().setOnDragingListener(iNu);
            this.hdZ.a(new c.InterfaceC0629c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pH() {
                    h.this.jpS.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.jJI > 0) {
                                h.this.Ab(h.this.jJI);
                                h.this.Ac(h.this.jJI);
                                h.this.jJI = 0;
                            }
                            h.this.jJL = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0629c
                public void pG() {
                    h.this.jpS.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.jJL = false;
                    h.this.jJI = h.this.blG().getHeight();
                }
            });
            this.hdZ.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cDw() {
                    if (h.this.jpS != null && h.this.jJu != null && !StringUtils.isNull(h.this.jJu.getId())) {
                        h.this.jpS.Hw(h.this.jJu.getId());
                    }
                }
            });
            this.hdZ.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void rZ(boolean z) {
                    if (h.this.jJt != null) {
                        h.this.CU(z ? "1" : "2");
                    }
                }
            });
            this.hdZ.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hdZ.setThumbnail(videoInfo.thumbnail_url);
            this.hdZ.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.hdZ.setFid(str);
            this.hdZ.IF(bjVar.getTitle());
            this.hdZ.a(jJV);
            this.hdZ.caH();
            this.hdZ.show();
        }
    }

    public void Id(String str) {
        if (this.jJq != null) {
            this.jJq.eQf = str;
        }
    }

    public void b(PostData postData, bj bjVar, k kVar) {
        if (this.jJr != null) {
            this.jJr.a(postData, bjVar, kVar);
        }
    }

    public void a(c.d dVar) {
        this.jJK = dVar;
    }

    public void aM(bj bjVar) {
        this.jJu = bjVar;
    }

    public void Ie(String str) {
        this.jJv = str;
        if (this.hdZ != null) {
            this.hdZ.Ie(this.jJv);
        }
    }

    public void startPlay() {
        if (this.hdZ != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.jJQ && !com.baidu.tieba.video.g.day().daz()) {
                this.jJH.setVisibility(0);
                this.jJH.setData(this.jJp);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.jJt != null && this.jJt.aKV() != null) {
                TiebaStatic.log(new an("c12619").cI("obj_locate", "pb").cI("tid", this.jJt.getTid()));
                this.mVideoUrl = this.jJt.aKV().video_url;
            }
            this.hdZ.ev(this.mVideoUrl, this.jJt == null ? "" : this.jJt.getTid());
            CU("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cDo() {
        if (this.hdZ != null) {
            this.hdZ.cDo();
        }
    }

    public void destroy() {
        if (this.hdZ != null) {
            this.hdZ.destroy();
        }
        if (this.jJn != null) {
            this.jJn.clearAnimation();
        }
        if (this.jJr != null) {
            this.jJr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.MI);
        MessageManager.getInstance().unRegisterListener(this.gZO);
    }

    public void onPause() {
        if (this.hdZ != null) {
            if (this.hdZ.pI()) {
                this.jJw = true;
                this.hdZ.stopPlay();
            } else if (this.hdZ.getCurrentState() == 3) {
                this.jJw = false;
            } else if (this.hdZ.getCurrentState() == 0 || this.hdZ.getCurrentState() == 1) {
                this.jJw = true;
                this.hdZ.stopPlay();
            } else {
                this.jJw = false;
                this.hdZ.stopPlay();
            }
            if (this.jJM != null) {
                this.jJM.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hdZ != null && this.jJw) {
            this.hdZ.cJd();
        }
    }

    private void cDp() {
        if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ad(true);
            dVar.af(false);
            dVar.Z(16908290).Y(Opcodes.IFEQ).ae(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.jpS.getActivity());
                    if (h.this.jJP == null) {
                        try {
                            h.this.jJP = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.jJP);
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
                    h.this.jJO = null;
                    if (h.this.jJP != null && !h.this.jJP.isRecycled()) {
                        h.this.jJP.recycle();
                    }
                    h.this.jJP = null;
                }
            });
            this.jJO = dVar.km();
            this.jJO.showOnDecorView(this.jpS.getActivity());
        }
    }

    public boolean tF(int i) {
        if (this.hdZ == null) {
            return false;
        }
        return this.hdZ.AU(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU(String str) {
        if (this.jJp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.jJp.video_md5, "", str, this.jJq);
            }
        }
    }

    public void cDq() {
        if (this.jJm != null) {
            this.jJm.rP(this.jpS.cwt());
        }
    }

    public void cCi() {
        if (this.jJm != null) {
            this.jJm.cCi();
        }
    }

    public void zQ(int i) {
        if (this.jJm != null) {
            this.jJm.zQ(i);
        }
        if (this.jJM != null) {
            this.jJM.onChangeSkinType(i);
        }
        if (this.jJr != null) {
            this.jJr.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cDt()) {
                    this.jJz = i;
                    if (this.jJz == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.Ac(h.this.blG().getHeight());
                            }
                        }, 100L);
                    }
                    cDr();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab(int i) {
        if (blG().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJn.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.jJS = false;
                    if (this.jJE != blG().getHeight()) {
                        this.jJn.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jpS.getActivity()), Math.min(this.jJE, blG().getHeight() + i)));
                        this.hdZ.cnB();
                    }
                } else if (l.getEquipmentWidth(this.jpS.getActivity()) * 0.5625d != blG().getHeight()) {
                    this.jJn.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jpS.getActivity()), (int) Math.max(l.getEquipmentWidth(this.jpS.getActivity()) * 0.5625d, blG().getHeight() + i)));
                    this.hdZ.cnB();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cDu()) {
                int bottom = childAt.getBottom() - blG().getBottom();
                if (childAt.getHeight() == 0 || blG().getHeight() == 0) {
                    bottom = 0;
                }
                Ab(bottom);
            } else {
                Ab((-this.jJE) + 2);
            }
        }
        if (!cDt() && this.jJL) {
            if (this.jJz == 1) {
                this.jJR = true;
                Ac(blG().getHeight());
            } else if (this.jJz == 2) {
                this.jJR = true;
                int y = (int) blG().getY();
                if (this.jJA == y) {
                    Ac(blG().getHeight());
                } else {
                    this.jJA = y;
                    Ac(blG().getHeight());
                }
                if (i == 0 && this.jJD) {
                    this.jJD = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cDo();
                        }
                    }, 100L);
                }
            } else if (this.jJz == 0) {
                if (this.jJR || !"nani_midpage".equals(this.jpS.cxs())) {
                    Ac(blG().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ac(int i) {
        Ad(i);
        cDr();
    }

    public void rC(boolean z) {
        this.jJS = z;
    }

    private void Ad(int i) {
        if (this.jJr != null) {
            if (this.jJt != null && this.jJt.aMA()) {
                this.jJr.cDm().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.jJE;
            }
            float f = this.jJE - i;
            float f2 = f > this.jJB ? 0.0f : 1.0f - (f / this.jJB);
            if (this.jJS) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.jJr.cDm().setVisibility(8);
            } else {
                this.jJr.cDm().setVisibility(0);
            }
            this.jJr.ao(f2);
        }
    }

    public void cDr() {
        if (this.jJr != null) {
            if (cDt()) {
                this.jpS.cxv().cBk();
            } else if (this.jJr.cDm().getVisibility() == 0) {
                this.jpS.cxv().cBk();
                this.jJs = true;
            } else if (this.jJs) {
                this.jpS.cxv().rB(false);
                this.jJs = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDs() {
        return blG().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jJy = false;
        if (this.hdZ != null && this.jJn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJn.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.hyX != null && this.hyX.isShowing()) {
                    this.hyX.JG();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.jJO != null) {
                    this.jJO.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jJy = true;
                this.jJn.setLayoutParams(layoutParams);
                this.jpS.cxv().cBk();
                this.jJs = true;
            } else {
                f(this.jJp);
                cDq();
                this.jJy = false;
                this.jJm.rO(true);
            }
            this.hdZ.a(this.jpS.getPageContext(), configuration);
        }
    }

    public boolean cDt() {
        return this.jJy;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.jJr != null) {
            this.jJr.S(onClickListener);
        }
    }

    public View blG() {
        return this.jJl;
    }

    public boolean cBt() {
        if (blG() == null) {
            return false;
        }
        return blG().getBottom() > l.getEquipmentHeight(blG().getContext()) - l.getDimens(blG().getContext(), R.dimen.ds50);
    }

    public void cBM() {
        this.jJD = true;
    }

    public View cDu() {
        return this.mEmptyView;
    }
}
