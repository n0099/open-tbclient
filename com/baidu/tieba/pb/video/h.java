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
    private static VideoControllerView.a iNy = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bgD() {
        }
    };
    private static c.i jJZ = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void bRd() {
        }
    };
    private float Vc;
    private boolean ado;
    private n ePh;
    private com.baidu.tieba.play.c hef;
    private com.baidu.mcn.c hzd;
    private float jJF;
    private int jJI;
    private double jJJ;
    private long jJK;
    private PbVideoWifiTipLayout jJL;
    private int jJM;
    private c.d jJO;
    private PbFullScreenFloatingHuajiAninationView jJQ;
    private com.baidu.adp.lib.guide.c jJS;
    private Bitmap jJT;
    private boolean jJU;
    private boolean jJW;
    private int jJY;
    private RelativeLayout jJp;
    private com.baidu.tieba.pb.pb.main.view.c jJq;
    private CustomFrameLayout jJr;
    private c.d jJs;
    private y jJu;
    private f jJv;
    private boolean jJw;
    private bj jJx;
    private bj jJy;
    private String jJz;
    private PbFragment jpW;
    private View mEmptyView;
    private Handler mHandler;
    private String mVideoUrl = null;
    private VideoInfo jJt = null;
    private boolean jJA = false;
    private int jJB = 0;
    private boolean jJC = false;
    private int jJD = 0;
    private int jJE = 0;
    private boolean jJG = false;
    private boolean jJH = false;
    private long startPosition = -1;
    private int gFI = 0;
    private c.p jJN = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void cDt() {
            if (h.this.jpW != null && h.this.jpW.cwB() != null && h.this.jpW.cwB().getPbData() != null) {
                PostData cvz = h.this.jpW.cwB().getPbData().cvz();
                if (cvz == null && v.getCount(h.this.jpW.cwB().getPbData().cvu()) > 1) {
                    cvz = (PostData) v.getItem(h.this.jpW.cwB().getPbData().cvu(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.jpW.cwB().getPbData(), cvz, 1, 1, 4);
            }
        }
    };
    private boolean jJP = true;
    private PbFullScreenFloatingHuajiAninationView.a jJR = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.rY(false);
        }
    };
    private boolean jJV = false;
    private c.m jJX = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean cDv() {
            if (h.this.jJJ < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (h.this.jpW.checkUpIsLogin()) {
                h.this.jpW.cyd();
                if (h.this.jpW.cwB() == null || h.this.jpW.cwB().getPbData() == null || h.this.jpW.cwB().getPbData().cvN() == null) {
                    return false;
                }
                k cvN = h.this.jpW.cwB().getPbData().cvN();
                if (h.this.jJQ == null) {
                    h.this.jJQ = new PbFullScreenFloatingHuajiAninationView(h.this.jpW.getActivity());
                    h.this.jJQ.setFloatingHuajiAninationListener(h.this.jJR);
                }
                h.this.jJQ.sn(cvN.cwc() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cDw() {
            return false;
        }
    };
    private CustomMessageListener MO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.hef != null) {
                    h.this.hef.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.hef != null && h.this.hef.pI() && h.this.jJt != null && h.this.jJt.video_length.intValue() > 0 && h.this.jJt.video_duration.intValue() > 0) {
                    float intValue = h.this.jJt.video_length.intValue() * (1.0f - ((h.this.hef.getCurrentPosition() * 1.0f) / (h.this.jJt.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.jpW.getPageContext().getPageActivity(), String.format(h.this.jpW.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener iLz = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.cCg();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener gZU = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.jJt != null) {
                h.this.f(h.this.jJt);
                h.this.hef.cJp();
                h.this.hef.cnz();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.jJI;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(boolean z) {
        if (this.jpW != null) {
            this.jpW.cxv();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.jJF = 0.0f;
        this.jpW = pbFragment;
        this.jJq = cVar;
        this.jJF = l.getDimens(this.jpW.getActivity(), R.dimen.ds240);
        this.jJK = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.MO);
        this.gZU.setTag(pbFragment.getUniqueId());
        this.gZU.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gZU);
        this.hzd = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.jJr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.jpW.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.jpW.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.jpW.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.jpW.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.jJJ = (intValue2 * 1.0d) / intValue;
            if (this.jJJ > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.jJI = i;
        this.jJr.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean brI() {
        return this.jJJ >= 1.0d;
    }

    public int cBM() {
        return this.jJI;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.jJp = (RelativeLayout) LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.jJr = (CustomFrameLayout) this.jJp.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.ado = ((double) this.jJI) <= (((double) l.getEquipmentWidth(this.jpW.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.hef = new com.baidu.tieba.play.c(this.jpW.getPageContext(), this.jJr, true, com.baidu.tbadk.a.b.sY("cyber_player_test") || com.baidu.tbadk.a.b.sX("cyber_player_test") ? 1 : 0);
        this.hef.a(this.jJX);
        this.hef.sW(false);
        this.hef.a(this.jJN);
        this.hef.AS(am.kB(R.drawable.pic_use_header_60_n));
        this.hef.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.jpW.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.jpW.getBaseFragmentActivity())) {
            this.hef.sN(false);
        }
        this.hef.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.Vc = motionEvent.getY();
                        if (h.this.jpW.getListView() != null && h.this.jpW.getListView().getChildCount() > 0 && h.this.jpW.getListView().getChildAt(0) == h.this.cDs()) {
                            h.this.jJY = h.this.cDs().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.Vc = 0.0f;
                        h.this.jJY = 0;
                        break;
                    case 2:
                        if (h.this.jpW.getListView() != null && h.this.jpW.getListView().getChildCount() > 0 && h.this.jpW.getListView().getChildAt(0) == h.this.cDs()) {
                            h.this.jpW.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.Vc)) + h.this.jJY);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.jJJ >= 1.0d) {
                this.hef.ak(false, true);
            } else {
                this.hef.ak(true, false);
            }
            this.jJG = ((float) f) + this.jJF > ((float) l.getEquipmentHeight(this.jpW.getActivity()));
            if (this.jJG) {
                if (this.jJv == null) {
                    this.jJv = new f(this.jpW.getPageContext(), this.jJr);
                }
                this.jpW.cxt().cBi();
                this.jJw = true;
            }
        }
        cDn();
        this.mEmptyView = new View(this.jpW.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jJI));
        if (this.jJq != null && this.jJq.mNavigationBar != null) {
            this.jJq.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.jJq.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.jJq.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.aOd() && !TbSingleton.getInstance().isNotchScreen(this.jpW.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jpW.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.jJL = (PbVideoWifiTipLayout) this.jJp.findViewById(R.id.layout_wifi_tip);
        this.jJL.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.jJU = true;
                h.this.jJL.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.hzd != null) {
            this.hzd.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.jpW.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.jJs == null) {
            this.jJs = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void mR(boolean z) {
                    if (h.this.cDq() && h.this.jJq != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.jJq.cBZ().clearAnimation();
                        h.this.cDo();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.iLz);
                            h.this.jJq.cBZ().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bRc() {
                    if (h.this.cDq()) {
                        h.this.cCg();
                    }
                }
            };
        }
        a(this.jJs);
        this.jJB = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jpW.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bj bjVar, final String str) {
        if (videoInfo != null && this.hef != null && bjVar != null) {
            this.jJt = videoInfo;
            this.jJx = bjVar;
            this.mVideoUrl = videoInfo.video_url;
            this.hef.stopPlay();
            this.hef.setIsNeedRecoveryVideoPlayer(true);
            this.ePh = new n(this.jpW.getActivity());
            this.jJu = new y();
            this.jJu.mLocate = "pb";
            this.jJu.ahO = bjVar.getTid();
            this.jJu.eQk = str;
            this.jJu.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.isBjh()) {
                if (!StringUtils.isNull(this.jpW.juf)) {
                    this.jJu.dop = this.jpW.juf;
                }
                this.jJu.kit = this.jpW.jue + "";
            } else {
                this.jJu.kit = this.jpW.cxq();
            }
            ax cyf = this.jpW.cyf();
            if (cyf != null) {
                cyf.b(this.jJu);
            }
            this.jJu.kiw = videoInfo.video_md5;
            y cKq = this.jJu.cKq();
            cKq.mLocate = "6";
            this.startPosition = -1L;
            this.ePh.a(new j.b() { // from class: com.baidu.tieba.pb.video.h.2
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    boolean z = true;
                    if (h.this.startPosition <= 0) {
                        h.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean fu = com.baidu.mcn.b.JE().fu(mcnAdInfo.jump_url);
                        if (h.this.ado && !fu && !h.this.jJC) {
                            boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!h.this.hzd.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.bhl = mcnAdInfo.card_title;
                                    aVar.bhm = mcnAdInfo.button_title;
                                    aVar.bhn = mcnAdInfo.jump_url;
                                    aVar.bhk = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bjVar.getTid();
                                    aVar.bho = 4;
                                    if (z2) {
                                        h.this.hzd.b(aVar, (ViewGroup) h.this.hef.cJo());
                                    } else {
                                        h.this.hzd.a(aVar, (ViewGroup) h.this.hef.cJo());
                                    }
                                }
                            } else if (h.this.hzd.isShowing()) {
                                h.this.hzd.dismiss();
                            }
                        }
                    }
                }
            });
            this.ePh.setVideoStatsData(cKq);
            this.hef.cIX().setBusiness(this.ePh);
            if (this.hef.cnB()) {
                this.hef.cnz();
            }
            this.hef.b(this.jJO);
            this.jJz = null;
            this.jJy = null;
            this.hef.Ih(this.jJz);
            this.hef.cnv().setOnDragingListener(iNy);
            this.hef.a(new c.InterfaceC0650c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pH() {
                    h.this.jpW.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.jJM > 0) {
                                h.this.Ab(h.this.jJM);
                                h.this.Ac(h.this.jJM);
                                h.this.jJM = 0;
                            }
                            h.this.jJP = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0650c
                public void pG() {
                    h.this.jpW.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.jJP = false;
                    h.this.jJM = h.this.blE().getHeight();
                }
            });
            this.hef.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void cDu() {
                    if (h.this.jpW != null && h.this.jJy != null && !StringUtils.isNull(h.this.jJy.getId())) {
                        h.this.jpW.Hz(h.this.jJy.getId());
                    }
                }
            });
            this.hef.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void rZ(boolean z) {
                    if (h.this.jJx != null) {
                        h.this.CX(z ? "1" : "2");
                    }
                }
            });
            this.hef.a(new g.b() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.hef.setThumbnail(videoInfo.thumbnail_url);
            this.hef.setVideoUrl(this.mVideoUrl, bjVar.getTid());
            this.hef.setFid(str);
            this.hef.II(bjVar.getTitle());
            this.hef.a(jJZ);
            this.hef.caG();
            this.hef.show();
        }
    }

    public void Ig(String str) {
        if (this.jJu != null) {
            this.jJu.eQk = str;
        }
    }

    public void b(PostData postData, bj bjVar, k kVar) {
        if (this.jJv != null) {
            this.jJv.a(postData, bjVar, kVar);
        }
    }

    public void a(c.d dVar) {
        this.jJO = dVar;
    }

    public void aM(bj bjVar) {
        this.jJy = bjVar;
    }

    public void Ih(String str) {
        this.jJz = str;
        if (this.hef != null) {
            this.hef.Ih(this.jJz);
        }
    }

    public void startPlay() {
        if (this.hef != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.jJU && !com.baidu.tieba.video.g.daw().dax()) {
                this.jJL.setVisibility(0);
                this.jJL.setData(this.jJt);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.jJx != null && this.jJx.aKT() != null) {
                TiebaStatic.log(new an("c12619").cI("obj_locate", "pb").cI("tid", this.jJx.getTid()));
                this.mVideoUrl = this.jJx.aKT().video_url;
            }
            this.hef.ev(this.mVideoUrl, this.jJx == null ? "" : this.jJx.getTid());
            CX("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void cDm() {
        if (this.hef != null) {
            this.hef.cDm();
        }
    }

    public void destroy() {
        if (this.hef != null) {
            this.hef.destroy();
        }
        if (this.jJr != null) {
            this.jJr.clearAnimation();
        }
        if (this.jJv != null) {
            this.jJv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.MO);
        MessageManager.getInstance().unRegisterListener(this.gZU);
    }

    public void onPause() {
        if (this.hef != null) {
            if (this.hef.pI()) {
                this.jJA = true;
                this.hef.stopPlay();
            } else if (this.hef.getCurrentState() == 3) {
                this.jJA = false;
            } else if (this.hef.getCurrentState() == 0 || this.hef.getCurrentState() == 1) {
                this.jJA = true;
                this.hef.stopPlay();
            } else {
                this.jJA = false;
                this.hef.stopPlay();
            }
            if (this.jJQ != null) {
                this.jJQ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.hef != null && this.jJA) {
            this.hef.cJb();
        }
    }

    private void cDn() {
        if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ad(true);
            dVar.af(false);
            dVar.Z(16908290).Y(Opcodes.IFEQ).ae(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.jpW.getActivity());
                    if (h.this.jJT == null) {
                        try {
                            h.this.jJT = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.jJT);
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
                    h.this.jJS = null;
                    if (h.this.jJT != null && !h.this.jJT.isRecycled()) {
                        h.this.jJT.recycle();
                    }
                    h.this.jJT = null;
                }
            });
            this.jJS = dVar.km();
            this.jJS.showOnDecorView(this.jpW.getActivity());
        }
    }

    public boolean tF(int i) {
        if (this.hef == null) {
            return false;
        }
        return this.hef.AU(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CX(String str) {
        if (this.jJt != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.jJt.video_md5, "", str, this.jJu);
            }
        }
    }

    public void cDo() {
        if (this.jJq != null) {
            this.jJq.rP(this.jpW.cwr());
        }
    }

    public void cCg() {
        if (this.jJq != null) {
            this.jJq.cCg();
        }
    }

    public void zQ(int i) {
        if (this.jJq != null) {
            this.jJq.zQ(i);
        }
        if (this.jJQ != null) {
            this.jJQ.onChangeSkinType(i);
        }
        if (this.jJv != null) {
            this.jJv.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!cDr()) {
                    this.jJD = i;
                    if (this.jJD == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.Ac(h.this.blE().getHeight());
                            }
                        }, 100L);
                    }
                    cDp();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab(int i) {
        if (blE().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJr.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.jJW = false;
                    if (this.jJI != blE().getHeight()) {
                        this.jJr.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jpW.getActivity()), Math.min(this.jJI, blE().getHeight() + i)));
                        this.hef.cnz();
                    }
                } else if (l.getEquipmentWidth(this.jpW.getActivity()) * 0.5625d != blE().getHeight()) {
                    this.jJr.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.jpW.getActivity()), (int) Math.max(l.getEquipmentWidth(this.jpW.getActivity()) * 0.5625d, blE().getHeight() + i)));
                    this.hef.cnz();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == cDs()) {
                int bottom = childAt.getBottom() - blE().getBottom();
                if (childAt.getHeight() == 0 || blE().getHeight() == 0) {
                    bottom = 0;
                }
                Ab(bottom);
            } else {
                Ab((-this.jJI) + 2);
            }
        }
        if (!cDr() && this.jJP) {
            if (this.jJD == 1) {
                this.jJV = true;
                Ac(blE().getHeight());
            } else if (this.jJD == 2) {
                this.jJV = true;
                int y = (int) blE().getY();
                if (this.jJE == y) {
                    Ac(blE().getHeight());
                } else {
                    this.jJE = y;
                    Ac(blE().getHeight());
                }
                if (i == 0 && this.jJH) {
                    this.jJH = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.cDm();
                        }
                    }, 100L);
                }
            } else if (this.jJD == 0) {
                if (this.jJV || !"nani_midpage".equals(this.jpW.cxq())) {
                    Ac(blE().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ac(int i) {
        Ad(i);
        cDp();
    }

    public void rC(boolean z) {
        this.jJW = z;
    }

    private void Ad(int i) {
        if (this.jJv != null) {
            if (this.jJx != null && this.jJx.aMy()) {
                this.jJv.cDk().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.jJI;
            }
            float f = this.jJI - i;
            float f2 = f > this.jJF ? 0.0f : 1.0f - (f / this.jJF);
            if (this.jJW) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.jJv.cDk().setVisibility(8);
            } else {
                this.jJv.cDk().setVisibility(0);
            }
            this.jJv.ao(f2);
        }
    }

    public void cDp() {
        if (this.jJv != null) {
            if (cDr()) {
                this.jpW.cxt().cBi();
            } else if (this.jJv.cDk().getVisibility() == 0) {
                this.jpW.cxt().cBi();
                this.jJw = true;
            } else if (this.jJw) {
                this.jpW.cxt().rB(false);
                this.jJw = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDq() {
        return blE().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jJC = false;
        if (this.hef != null && this.jJr != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJr.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.hzd != null && this.hzd.isShowing()) {
                    this.hzd.JF();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.jJS != null) {
                    this.jJS.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jJC = true;
                this.jJr.setLayoutParams(layoutParams);
                this.jpW.cxt().cBi();
                this.jJw = true;
            } else {
                f(this.jJt);
                cDo();
                this.jJC = false;
                this.jJq.rO(true);
            }
            this.hef.a(this.jpW.getPageContext(), configuration);
        }
    }

    public boolean cDr() {
        return this.jJC;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.jJv != null) {
            this.jJv.S(onClickListener);
        }
    }

    public View blE() {
        return this.jJp;
    }

    public boolean cBr() {
        if (blE() == null) {
            return false;
        }
        return blE().getBottom() > l.getEquipmentHeight(blE().getContext()) - l.getDimens(blE().getContext(), R.dimen.ds50);
    }

    public void cBK() {
        this.jJH = true;
    }

    public View cDs() {
        return this.mEmptyView;
    }
}
