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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tieba.pb.data.l;
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
/* loaded from: classes6.dex */
public class h {
    private static VideoControllerView.a hWj = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aVM() {
        }
    };
    private static c.i iTb = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bDK() {
        }
    };
    private float Bi;
    private boolean JL;
    private n egK;
    private com.baidu.mcn.c gIr;
    private com.baidu.tieba.play.c goM;
    private bj iSA;
    private String iSB;
    private float iSH;
    private int iSK;
    private double iSL;
    private long iSM;
    private PbVideoWifiTipLayout iSN;
    private int iSO;
    private c.d iSQ;
    private PbFullScreenFloatingHuajiAninationView iSS;
    private com.baidu.adp.lib.guide.c iSU;
    private Bitmap iSV;
    private boolean iSW;
    private boolean iSY;
    private RelativeLayout iSr;
    private com.baidu.tieba.pb.pb.main.view.c iSs;
    private CustomFrameLayout iSt;
    private c.d iSu;
    private y iSw;
    private f iSx;
    private boolean iSy;
    private bj iSz;
    private int iTa;
    private PbFragment iyA;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo iSv = null;
    private boolean iSC = false;
    private int iSD = 0;
    private boolean iSE = false;
    private int iSF = 0;
    private int iSG = 0;
    private boolean iSI = false;
    private boolean iSJ = false;
    private long startPosition = -1;
    private int fSQ = 0;
    private c.p iSP = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cpS() {
            if (h.this.iyA != null && h.this.iyA.ciU() != null && h.this.iyA.ciU().getPbData() != null) {
                PostData chR = h.this.iyA.ciU().getPbData().chR();
                if (chR == null && v.getCount(h.this.iyA.ciU().getPbData().chM()) > 1) {
                    chR = (PostData) v.getItem(h.this.iyA.ciU().getPbData().chM(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.iyA.ciU().getPbData(), chR, 1, 1, 4);
            }
        }
    };
    private boolean iSR = true;
    private PbFullScreenFloatingHuajiAninationView.a iST = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.qA(false);
        }
    };
    private boolean iSX = false;
    private c.m iSZ = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cpU() {
            if (h.this.iSL < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.iyA.checkUpIsLogin()) {
                h.this.iyA.ckz();
                if (h.this.iyA.ciU() == null || h.this.iyA.ciU().getPbData() == null || h.this.iyA.ciU().getPbData().cig() == null) {
                    return false;
                }
                l cig = h.this.iyA.ciU().getPbData().cig();
                if (h.this.iSS == null) {
                    h.this.iSS = new PbFullScreenFloatingHuajiAninationView(h.this.iyA.getActivity());
                    h.this.iSS.setFloatingHuajiAninationListener(h.this.iST);
                }
                h.this.iSS.qL(cig.ciu() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cpV() {
            return false;
        }
    };
    private CustomMessageListener tA = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.goM != null) {
                    h.this.goM.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.goM != null && h.this.goM.kO() && h.this.iSv != null && h.this.iSv.video_length.intValue() > 0 && h.this.iSv.video_duration.intValue() > 0) {
                    float intValue = h.this.iSv.video_length.intValue() * (1.0f - ((h.this.goM.getCurrentPosition() * 1.0f) / (h.this.iSv.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(h.this.iyA.getPageContext().getPageActivity(), String.format(h.this.iyA.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hUl = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.coF();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gkx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.iSv != null) {
                h.this.f(h.this.iSv);
                h.this.goM.cvO();
                h.this.goM.bZU();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.iSK;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void qA(boolean z) {
        if (this.iyA != null) {
            this.iyA.cjR();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.iSH = 0.0f;
        this.iyA = pbFragment;
        this.iSs = cVar;
        this.iSH = com.baidu.adp.lib.util.l.getDimens(this.iyA.getActivity(), R.dimen.ds240);
        this.iSM = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.tA);
        this.gkx.setTag(pbFragment.getUniqueId());
        this.gkx.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gkx);
        this.gIr = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.iSt.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity());
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.iyA.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? com.baidu.adp.lib.util.l.getEquipmentHeight(this.iyA.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.iSL = (intValue2 * 1.0d) / intValue;
            if (this.iSL > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.iSK = i;
        this.iSt.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bfB() {
        return this.iSL >= 1.0d;
    }

    public int col() {
        return this.iSK;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.iSr = (RelativeLayout) LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.iSt = (CustomFrameLayout) this.iSr.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.JL = ((double) this.iSK) <= (((double) com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.goM = new com.baidu.tieba.play.c(this.iyA.getPageContext(), this.iSt, true, com.baidu.tbadk.a.b.rp("cyber_player_test") ? 1 : 0);
        this.goM.a(this.iSZ);
        this.goM.rw(false);
        this.goM.a(this.iSP);
        this.goM.zX(am.kd(R.drawable.pic_use_header_60_n));
        this.goM.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.iyA.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.iyA.getBaseFragmentActivity())) {
            this.goM.rn(false);
        }
        this.goM.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.Bi = motionEvent.getY();
                        if (h.this.iyA.getListView() != null && h.this.iyA.getListView().getChildCount() > 0 && h.this.iyA.getListView().getChildAt(0) == h.this.cpR()) {
                            h.this.iTa = h.this.cpR().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.Bi = 0.0f;
                        h.this.iTa = 0;
                        break;
                    case 2:
                        if (h.this.iyA.getListView() != null && h.this.iyA.getListView().getChildCount() > 0 && h.this.iyA.getListView().getChildAt(0) == h.this.cpR()) {
                            h.this.iyA.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.Bi)) + h.this.iTa);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.iSL >= 1.0d) {
                this.goM.ah(false, true);
            } else {
                this.goM.ah(true, false);
            }
            this.iSI = ((float) f) + this.iSH > ((float) com.baidu.adp.lib.util.l.getEquipmentHeight(this.iyA.getActivity()));
            if (this.iSI) {
                if (this.iSx == null) {
                    this.iSx = new f(this.iyA.getPageContext(), this.iSt);
                }
                this.iyA.cjP().cnH();
                this.iSy = true;
            }
        }
        cpM();
        this.mEmptyView = new View(this.iyA.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.iSK));
        if (this.iSs != null && this.iSs.mNavigationBar != null) {
            this.iSs.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iSs.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iSs.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aDi() && !TbSingleton.getInstance().isNotchScreen(this.iyA.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iyA.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.iSN = (PbVideoWifiTipLayout) this.iSr.findViewById(R.id.layout_wifi_tip);
        this.iSN.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.iSW = true;
                h.this.iSN.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.gIr != null) {
            this.gIr.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.iyA.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.iSu == null) {
            this.iSu = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void lu(boolean z) {
                    if (h.this.cpP() && h.this.iSs != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.iSs.cox().clearAnimation();
                        h.this.cpN();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.hUl);
                            h.this.iSs.cox().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bDJ() {
                    if (h.this.cpP()) {
                        h.this.coF();
                    }
                }
            };
        }
        a(this.iSu);
        this.iSD = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iyA.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.goM != null && bjVar != null) {
            this.iSv = videoInfo;
            this.iSz = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.goM.stopPlay();
            this.goM.setIsNeedRecoveryVideoPlayer(true);
            this.egK = new n(this.iyA.getActivity());
            this.iSw = new y();
            this.iSw.mLocate = "pb";
            this.iSw.OC = bjVar.getTid();
            this.iSw.fGQ = str;
            this.iSw.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.iyA.iCX)) {
                    this.iSw.cKC = this.iyA.iCX;
                }
                this.iSw.jsk = this.iyA.iCW + "";
            } else {
                this.iSw.jsk = this.iyA.cjM();
            }
            ax ckB = this.iyA.ckB();
            if (ckB != null) {
                ckB.b(this.iSw);
            }
            this.iSw.jsl = videoInfo.video_md5;
            y cwO = this.iSw.cwO();
            cwO.mLocate = "6";
            this.startPosition = -1L;
            this.egK.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean ej = com.baidu.mcn.b.AS().ej(mcnAdInfo.jump_url);
                        if (h.this.JL && !ej && !h.this.iSE) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.gIr.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aGm = mcnAdInfo.card_title;
                                    aVar.aGn = mcnAdInfo.button_title;
                                    aVar.aGo = mcnAdInfo.jump_url;
                                    aVar.aGl = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.aGp = 4;
                                    if (z2) {
                                        h.this.gIr.b(aVar, (ViewGroup) h.this.goM.cvN());
                                    } else {
                                        h.this.gIr.a(aVar, (ViewGroup) h.this.goM.cvN());
                                    }
                                }
                            } else if (h.this.gIr.isShowing()) {
                                h.this.gIr.dismiss();
                            }
                        }
                    }
                }
            });
            this.egK.setVideoStatsData(cwO);
            this.goM.cvw().setBusiness(this.egK);
            if (this.goM.bZW()) {
                this.goM.bZU();
            }
            this.goM.b(this.iSQ);
            this.iSB = null;
            this.iSA = null;
            this.goM.FX(this.iSB);
            this.goM.bZQ().setOnDragingListener(hWj);
            this.goM.a(new c.InterfaceC0576c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kN() {
                    h.this.iyA.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.iSO > 0) {
                                h.this.zh(h.this.iSO);
                                h.this.zi(h.this.iSO);
                                h.this.iSO = 0;
                            }
                            h.this.iSR = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0576c
                public void kM() {
                    h.this.iyA.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.iSR = false;
                    h.this.iSO = h.this.aZU().getHeight();
                }
            });
            this.goM.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cpT() {
                    if (h.this.iyA != null && h.this.iSA != null && !StringUtils.isNull(h.this.iSA.getId())) {
                        h.this.iyA.Fp(h.this.iSA.getId());
                    }
                }
            });
            this.goM.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void qB(boolean z) {
                    if (h.this.iSz != null) {
                        h.this.AI(z ? "1" : "2");
                    }
                }
            });
            this.goM.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.goM.setThumbnail(videoInfo.thumbnail_url);
            this.goM.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.goM.setFid(str);
            this.goM.Gz(bjVar.getTitle());
            this.goM.a(iTb);
            this.goM.bNb();
            this.goM.show();
        }
    }

    public void FW(String str) {
        if (this.iSw != null) {
            this.iSw.fGQ = str;
        }
    }

    public void b(PostData postData, bj bjVar, l lVar) {
        if (this.iSx != null) {
            this.iSx.a(postData, bjVar, lVar);
        }
    }

    public void a(c.d dVar) {
        this.iSQ = dVar;
    }

    public void aG(bj bjVar) {
        this.iSA = bjVar;
    }

    public void FX(String str) {
        this.iSB = str;
        if (this.goM != null) {
            this.goM.FX(this.iSB);
        }
    }

    public void startPlay() {
        if (this.goM != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.iSW && !com.baidu.tieba.video.g.cMD().cME()) {
                this.iSN.setVisibility(0);
                this.iSN.setData(this.iSv);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.iSz != null && this.iSz.azV() != null) {
                TiebaStatic.log(new an("c12619").cp("obj_locate", "pb").cp("tid", this.iSz.getTid()));
                this.mVideoUrl = this.iSz.azV().video_url;
            }
            this.goM.dX(this.mVideoUrl, this.iSz == null ? "" : this.iSz.getTid());
            AI("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cpL() {
        if (this.goM != null) {
            this.goM.cpL();
        }
    }

    public void destroy() {
        if (this.goM != null) {
            this.goM.destroy();
        }
        if (this.iSt != null) {
            this.iSt.clearAnimation();
        }
        if (this.iSx != null) {
            this.iSx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.tA);
        MessageManager.getInstance().unRegisterListener(this.gkx);
    }

    public void onPause() {
        if (this.goM != null) {
            if (this.goM.kO()) {
                this.iSC = true;
                this.goM.stopPlay();
            } else if (this.goM.getCurrentState() == 3) {
                this.iSC = false;
            } else if (this.goM.getCurrentState() == 0 || this.goM.getCurrentState() == 1) {
                this.iSC = true;
                this.goM.stopPlay();
            } else {
                this.iSC = false;
                this.goM.stopPlay();
            }
            if (this.iSS != null) {
                this.iSS.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.goM != null && this.iSC) {
            this.goM.cvA();
        }
    }

    private void cpM() {
        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.K(16908290).J(153).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.iyA.getActivity());
                    if (h.this.iSV == null) {
                        try {
                            h.this.iSV = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.iSV);
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
                    h.this.iSU = null;
                    if (h.this.iSV != null && !h.this.iSV.isRecycled()) {
                        h.this.iSV.recycle();
                    }
                    h.this.iSV = null;
                }
            });
            this.iSU = dVar.fI();
            this.iSU.showOnDecorView(this.iyA.getActivity());
        }
    }

    public boolean sU(int i) {
        if (this.goM == null) {
            return false;
        }
        return this.goM.zY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(String str) {
        if (this.iSv != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iSv.video_md5, "", str, this.iSw);
            }
        }
    }

    public void cpN() {
        if (this.iSs != null) {
            this.iSs.qq(this.iyA.ciJ());
        }
    }

    public void coF() {
        if (this.iSs != null) {
            this.iSs.coF();
        }
    }

    public void yW(int i) {
        if (this.iSs != null) {
            this.iSs.yW(i);
        }
        if (this.iSS != null) {
            this.iSS.onChangeSkinType(i);
        }
        if (this.iSx != null) {
            this.iSx.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cpQ()) {
                    this.iSF = i;
                    if (this.iSF == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.zi(h.this.aZU().getHeight());
                            }
                        }, 100L);
                    }
                    cpO();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        if (aZU().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iSt.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.iSY = false;
                    if (this.iSK != aZU().getHeight()) {
                        this.iSt.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity()), Math.min(this.iSK, aZU().getHeight() + i)));
                        this.goM.bZU();
                    }
                } else if (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity()) * 0.5625d != aZU().getHeight()) {
                    this.iSt.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getActivity()) * 0.5625d, aZU().getHeight() + i)));
                    this.goM.bZU();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cpR()) {
                int bottom = childAt.getBottom() - aZU().getBottom();
                if (childAt.getHeight() == 0 || aZU().getHeight() == 0) {
                    bottom = 0;
                }
                zh(bottom);
            } else {
                zh((-this.iSK) + 2);
            }
        }
        if (!cpQ() && this.iSR) {
            if (this.iSF == 1) {
                this.iSX = true;
                zi(aZU().getHeight());
            } else if (this.iSF == 2) {
                this.iSX = true;
                int y = (int) aZU().getY();
                if (this.iSG == y) {
                    zi(aZU().getHeight());
                } else {
                    this.iSG = y;
                    zi(aZU().getHeight());
                }
                if (i == 0 && this.iSJ) {
                    this.iSJ = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cpL();
                        }
                    }, 100L);
                }
            } else if (this.iSF == 0) {
                if (this.iSX || !"nani_midpage".equals(this.iyA.cjM())) {
                    zi(aZU().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(int i) {
        zj(i);
        cpO();
    }

    public void qd(boolean z) {
        this.iSY = z;
    }

    private void zj(int i) {
        if (this.iSx != null) {
            if (this.iSz != null && this.iSz.aBC()) {
                this.iSx.cpJ().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.iSK;
            }
            float f = this.iSK - i;
            float f2 = f > this.iSH ? 0.0f : 1.0f - (f / this.iSH);
            if (this.iSY) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.iSx.cpJ().setVisibility(8);
            } else {
                this.iSx.cpJ().setVisibility(0);
            }
            this.iSx.aG(f2);
        }
    }

    public void cpO() {
        if (this.iSx != null) {
            if (cpQ()) {
                this.iyA.cjP().cnH();
            } else if (this.iSx.cpJ().getVisibility() == 0) {
                this.iyA.cjP().cnH();
                this.iSy = true;
            } else if (this.iSy) {
                this.iyA.cjP().qc(false);
                this.iSy = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cpP() {
        return aZU().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iSE = false;
        if (this.goM != null && this.iSt != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iSt.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.gIr != null && this.gIr.isShowing()) {
                    this.gIr.AT();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.iSU != null) {
                    this.iSU.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iSE = true;
                this.iSt.setLayoutParams(layoutParams);
                this.iyA.cjP().cnH();
                this.iSy = true;
            } else {
                f(this.iSv);
                cpN();
                this.iSE = false;
                this.iSs.qp(true);
            }
            this.goM.a(this.iyA.getPageContext(), configuration);
        }
    }

    public boolean cpQ() {
        return this.iSE;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.iSx != null) {
            this.iSx.S(onClickListener);
        }
    }

    public View aZU() {
        return this.iSr;
    }

    public boolean cnQ() {
        if (aZU() == null) {
            return false;
        }
        return aZU().getBottom() > com.baidu.adp.lib.util.l.getEquipmentHeight(aZU().getContext()) - com.baidu.adp.lib.util.l.getDimens(aZU().getContext(), R.dimen.ds50);
    }

    public void coj() {
        this.iSJ = true;
    }

    public View cpR() {
        return this.mEmptyView;
    }
}
