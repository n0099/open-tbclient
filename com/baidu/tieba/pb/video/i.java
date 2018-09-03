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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private static VideoControllerView.a eTF = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Rn() {
        }
    };
    private static c.h fNw = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void awm() {
        }
    };
    private n bvt;
    private com.baidu.tieba.play.c dqV;
    private RelativeLayout fMO;
    private com.baidu.tieba.pb.pb.main.view.b fMP;
    private CustomFrameLayout fMQ;
    private c.InterfaceC0218c fMR;
    private y fMT;
    private g fMU;
    private boolean fMV;
    private bb fMW;
    private bb fMX;
    private String fMY;
    private float fNe;
    private int fNh;
    private double fNi;
    private float fNj;
    private long fNk;
    private PbVideoWifiTipLayout fNl;
    private c.InterfaceC0218c fNm;
    private PbFullScreenFloatingHuajiAninationView fNo;
    private com.baidu.adp.lib.guide.c fNq;
    private Bitmap fNr;
    private boolean fNs;
    private int fNv;
    private PbActivity fxm;
    private View mEmptyView;
    private Handler mHandler;
    private String bdb = null;
    private VideoInfo fMS = null;
    private boolean fMZ = false;
    private int fNa = 0;
    private boolean fNb = false;
    private int fNc = 0;
    private int fNd = 0;
    private boolean fNf = false;
    private boolean fNg = false;
    private boolean fNn = true;
    private PbFullScreenFloatingHuajiAninationView.a fNp = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.kO(false);
        }
    };
    private boolean fNt = false;
    private c.l fNu = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void bgu() {
            if (i.this.fxm.checkUpIsLogin()) {
                i.this.fxm.bbq();
                if (i.this.fxm.bao() != null && i.this.fxm.bao().getPbData() != null && i.this.fxm.bao().getPbData().aZG() != null) {
                    j aZG = i.this.fxm.bao().getPbData().aZG();
                    if (i.this.fNo == null) {
                        i.this.fNo = new PbFullScreenFloatingHuajiAninationView(i.this.fxm.getActivity());
                        i.this.fNo.setFloatingHuajiAninationListener(i.this.fNp);
                    }
                    i.this.fNo.kQ(!aZG.aZO());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dqV != null) {
                    i.this.dqV.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.jE() && com.baidu.adp.lib.util.j.jG() && i.this.dqV != null && i.this.dqV.bjR() && i.this.fMS != null && i.this.fMS.video_length.intValue() > 0 && i.this.fMS.video_duration.intValue() > 0) {
                    float intValue = i.this.fMS.video_length.intValue() * (1.0f - ((i.this.dqV.getCurrentPosition() * 1.0f) / (i.this.fMS.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fxm.getPageContext().getPageActivity(), String.format(i.this.fxm.getPageContext().getString(f.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eRH = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bfg();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(boolean z) {
        if (this.fxm.bao() != null && this.fxm.bao().getPbData() != null && this.fxm.bao().getPbData().aZG() != null) {
            j aZG = this.fxm.bao().getPbData().aZG();
            View findViewById = this.fxm.getActivity().findViewById(f.g.view_main_thread_praise_state);
            if (!aZG.aZO() || z) {
                this.fxm.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fxm.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZG.aZO() ? 0 : 1));
            } else if (aZG.aZO()) {
                if (aZG.ftf == 1 || aZG.ftf == 3 || aZG.ftf == 4) {
                    this.fxm.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fxm.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZG.aZO() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fNe = 0.0f;
        this.fxm = pbActivity;
        this.fMP = bVar;
        this.fNe = l.f(this.fxm.getActivity(), f.e.ds240);
        this.fNk = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int ah = l.ah(this.fxm.getActivity());
        Rect t = ba.t(this.fxm.getPageContext().getPageActivity());
        int aj = t.height() <= 0 ? l.aj(this.fxm.getActivity()) : t.height();
        int i = (int) (ah * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fNi = (intValue2 * 1.0d) / intValue;
            if (this.fNi > 0.5625d) {
                i = Math.min((ah * intValue2) / intValue, aj);
            }
        }
        this.fNh = i;
        this.fMQ.setLayoutParams(new RelativeLayout.LayoutParams(ah, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.fMO = (RelativeLayout) LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.video_pb_container_layout, (ViewGroup) null);
        this.fMQ = (CustomFrameLayout) this.fMO.findViewById(f.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dqV = new com.baidu.tieba.play.c(this.fxm.getPageContext(), this.fMQ, true);
        this.dqV.a(this.fNu);
        this.dqV.lt(false);
        this.dqV.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // com.baidu.tieba.play.c.j
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.j
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.j
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.fNj = motionEvent.getY();
                        if (i.this.fxm.getListView() != null && i.this.fxm.getListView().getChildCount() > 0 && i.this.fxm.getListView().getChildAt(0) == i.this.bgs()) {
                            i.this.fNv = i.this.bgs().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.fNj = 0.0f;
                        i.this.fNv = 0;
                        break;
                    case 2:
                        if (i.this.fxm.getListView() != null && i.this.fxm.getListView().getChildCount() > 0 && i.this.fxm.getListView().getChildAt(0) == i.this.bgs()) {
                            i.this.fxm.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.fNj)) + i.this.fNv);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fNi >= 1.0d) {
                this.dqV.N(false, true);
            } else {
                this.dqV.N(true, false);
            }
            this.fNf = ((float) e) + this.fNe > ((float) l.aj(this.fxm.getActivity()));
            if (this.fNf) {
                if (this.fMU == null) {
                    this.fMU = new g(this.fxm.getPageContext(), this.fMQ);
                    this.fMU.M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kO(true);
                        }
                    });
                }
                this.fxm.baF().beu();
                this.fMV = true;
            }
        }
        bgl();
        this.mEmptyView = new View(this.fxm);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fNh));
        if (this.fMP != null && this.fMP.mNavigationBar != null) {
            this.fMP.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fMP.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fMP.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.yf() ? 0 : 8);
        }
        this.fNl = (PbVideoWifiTipLayout) this.fMO.findViewById(f.g.layout_wifi_tip);
        this.fNl.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fNs = true;
                i.this.fNl.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fxm.getActivity(), f.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fMR == null) {
            this.fMR = new c.InterfaceC0218c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void fU(boolean z) {
                    if (i.this.bgo() && i.this.fMP != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fMP.bfa().clearAnimation();
                        i.this.bgm();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eRH);
                            i.this.fMP.bfa().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awl() {
                    if (i.this.bgo()) {
                        i.this.bfg();
                    }
                }
            };
        }
        a(this.fMR);
        this.fNa = UtilHelper.getLightStatusBarHeight() + l.f(this.fxm.getActivity(), f.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dqV != null && bbVar != null) {
            this.fMS = videoInfo;
            this.fMW = bbVar;
            this.bdb = videoInfo.video_url;
            this.dqV.stopPlay();
            this.dqV.setIsNeedRecoveryVideoPlayer(true);
            this.bvt = new n(this.fxm.getActivity());
            this.fMT = new y();
            this.fMT.mLocate = "pb";
            this.fMT.aWq = bbVar.getTid();
            this.fMT.cBR = str;
            this.fMT.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fMT.mSource = bbVar.mRecomSource;
            this.fMT.ghC = bbVar.mRecomWeight;
            this.fMT.ghD = this.fxm.baD();
            this.fMT.ghE = bbVar.mRecomAbTag;
            this.fMT.ghF = videoInfo.video_md5;
            y bkU = this.fMT.bkU();
            bkU.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bvt.setVideoStatsData(bkU);
            this.dqV.getVideoView().setBusiness(this.bvt);
            if (this.dqV.aSb()) {
                this.dqV.aRZ();
            }
            this.dqV.b(this.fNm);
            this.fMY = null;
            this.fMX = null;
            this.dqV.rJ(this.fMY);
            this.dqV.aRV().setOnDragingListener(eTF);
            this.dqV.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void awi() {
                    i.this.fxm.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fNn = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void awh() {
                    i.this.fxm.setSwipeBackEnabled(false);
                    i.this.fNn = false;
                }
            });
            this.dqV.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bgt() {
                    if (i.this.fxm != null && i.this.fMX != null && !StringUtils.isNull(i.this.fMX.getId())) {
                        i.this.fxm.re(i.this.fMX.getId());
                        if (i.this.fMW != null) {
                            long j = 0;
                            if (i.this.fMW.wk() != null) {
                                j = i.this.fMW.wk().channelId;
                            }
                            TiebaStatic.log(new an("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dqV.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void kP(boolean z) {
                    if (i.this.fMW != null) {
                        long j = 0;
                        if (i.this.fMW.wk() != null) {
                            j = i.this.fMW.wk().channelId;
                        }
                        i.this.mz(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").ae("tid", i.this.fMW.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fMW.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dqV.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bdb);
                    return true;
                }
            });
            this.dqV.setThumbnail(videoInfo.thumbnail_url);
            this.dqV.setVideoUrl(this.bdb, bbVar.getTid());
            this.dqV.sd(bbVar.getTitle());
            this.dqV.a(fNw);
            this.dqV.aFa();
            this.dqV.show();
        }
    }

    public void rI(String str) {
        if (this.fMT != null) {
            this.fMT.cBR = str;
        }
    }

    public void b(PostData postData, bb bbVar, j jVar) {
        if (this.fMU != null) {
            this.fMU.a(postData, bbVar, jVar);
        }
    }

    public void a(c.InterfaceC0218c interfaceC0218c) {
        this.fNm = interfaceC0218c;
    }

    public void ar(bb bbVar) {
        this.fMX = bbVar;
    }

    public void rJ(String str) {
        this.fMY = str;
        if (this.dqV != null) {
            this.dqV.rJ(this.fMY);
        }
    }

    public void startPlay() {
        if (this.dqV != null) {
            if (com.baidu.adp.lib.util.j.jG() && !this.fNs && !com.baidu.tieba.video.g.bAk().bAl()) {
                this.fNl.setVisibility(0);
                this.fNl.setData(this.fMS);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bdb) && this.fMW != null && this.fMW.vB() != null) {
                TiebaStatic.log(new an("c12619").ae("obj_locate", "pb").ae("tid", this.fMW.getTid()));
                this.bdb = this.fMW.vB().video_url;
            }
            this.dqV.b(this.bdb, this.fMW == null ? "" : this.fMW.getTid(), this.fNk);
            mz("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bgk() {
        if (this.dqV != null) {
            this.dqV.bgk();
        }
    }

    public void destroy() {
        if (this.dqV != null) {
            this.dqV.destroy();
        }
        if (this.fMQ != null) {
            this.fMQ.clearAnimation();
        }
        if (this.fMU != null) {
            this.fMU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dqV != null) {
            if (this.dqV.bjR()) {
                this.fMZ = true;
                this.dqV.pausePlay();
            } else if (this.dqV.getCurrentState() == 3) {
                this.fMZ = false;
            } else {
                this.fMZ = false;
                this.dqV.pausePlay();
            }
            if (this.fNo != null) {
                this.fNo.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dqV != null && this.fMZ) {
            this.dqV.aSd();
        }
    }

    private void bgl() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.D(true);
            dVar.F(false);
            dVar.Y(16908290).X(153).E(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fxm.getActivity());
                    if (i.this.fNr == null) {
                        try {
                            i.this.fNr = BitmapFactory.decodeResource(i.this.fxm.getResources(), f.C0146f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fNr);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hw() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hx() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fNq = null;
                    if (i.this.fNr != null && !i.this.fNr.isRecycled()) {
                        i.this.fNr.recycle();
                    }
                    i.this.fNr = null;
                }
            });
            this.fNq = dVar.hy();
            this.fNq.k(this.fxm.getActivity());
        }
    }

    public boolean kL(int i) {
        if (this.dqV == null) {
            return false;
        }
        return this.dqV.rE(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(String str) {
        if (this.fMS != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fMS.video_md5, "", str, this.fMT);
            }
        }
    }

    public void bgm() {
        if (this.fMP != null) {
            this.fMP.kE(this.fxm.bbp());
        }
    }

    public void bfg() {
        if (this.fMP != null) {
            this.fMP.bfg();
        }
    }

    public void qV(int i) {
        if (this.fMP != null) {
            this.fMP.qV(i);
        }
        if (this.fNo != null) {
            this.fNo.onChangeSkinType(i);
        }
        if (this.fMU != null) {
            this.fMU.dF(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bgp()) {
                    this.fNc = i;
                    if (this.fNc == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.rc(i.this.bgq().getHeight());
                            }
                        }, 100L);
                    }
                    bgn();
                    return;
                }
                return;
        }
    }

    private void rb(int i) {
        if (bgq().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMQ.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fNh != bgq().getHeight()) {
                        this.fMQ.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.fxm.getActivity()), Math.min(this.fNh, bgq().getHeight() + i)));
                        this.dqV.aRZ();
                    }
                } else if (l.ah(this.fxm.getActivity()) * 0.5625d != bgq().getHeight()) {
                    this.fMQ.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.fxm.getActivity()), (int) Math.max(l.ah(this.fxm.getActivity()) * 0.5625d, bgq().getHeight() + i)));
                    this.dqV.aRZ();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bgs()) {
                int bottom = childAt.getBottom() - bgq().getBottom();
                if (childAt.getHeight() == 0 || bgq().getHeight() == 0) {
                    bottom = 0;
                }
                rb(bottom);
            } else {
                rb((-this.fNh) + 2);
            }
        }
        if (!bgp() && this.fNn) {
            if (this.fNc == 1) {
                this.fNt = true;
                rc(bgq().getHeight());
            } else if (this.fNc == 2) {
                this.fNt = true;
                int y = (int) bgq().getY();
                if (this.fNd == y) {
                    rc(bgq().getHeight());
                } else {
                    this.fNd = y;
                    rc(bgq().getHeight());
                }
                if (i == 0 && this.fNg) {
                    this.fNg = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bgk();
                        }
                    }, 100L);
                }
            } else if (this.fNc == 0) {
                if (this.fNt || !"nani_midpage".equals(this.fxm.baD())) {
                    rc(bgq().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(int i) {
        rd(i);
        bgn();
    }

    private void rd(int i) {
        if (this.fMU != null) {
            if (i == 0) {
                i = this.fNh;
            }
            float f = this.fNh - i;
            float f2 = f > this.fNe ? 0.0f : 1.0f - (f / this.fNe);
            if (f2 == 0.0f) {
                this.fMU.bgg().setVisibility(8);
            } else {
                this.fMU.bgg().setVisibility(0);
            }
            this.fMU.ar(f2);
        }
    }

    public void bgn() {
        if (this.fMU != null) {
            if (bgp()) {
                this.fxm.baF().beu();
            } else if (this.fMU.bgg().getVisibility() == 0) {
                this.fxm.baF().beu();
                this.fMV = true;
            } else if (this.fMV) {
                this.fxm.baF().kq(false);
                this.fMV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgo() {
        return bgq().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fNb = false;
        if (this.dqV != null && this.fMQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMQ.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fNq != null) {
                    this.fNq.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fNb = true;
                this.fMQ.setLayoutParams(layoutParams);
                this.fxm.baF().beu();
                this.fMV = true;
            } else {
                e(this.fMS);
                bgm();
                this.fNb = false;
                this.fMP.kD(true);
            }
            this.dqV.a(this.fxm.getPageContext(), configuration);
        }
    }

    public boolean bgp() {
        return this.fNb;
    }

    public void k(long j, int i) {
        if (this.fMU != null && j > 0) {
            this.fMU.l(i, j);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.fMU != null) {
            this.fMU.L(onClickListener);
        }
    }

    public View bgq() {
        return this.fMO;
    }

    public boolean beD() {
        if (bgq() == null) {
            return false;
        }
        return bgq().getBottom() > l.aj(bgq().getContext()) - l.f(bgq().getContext(), f.e.ds50);
    }

    public void bgr() {
        this.fNg = true;
    }

    public View bgs() {
        return this.mEmptyView;
    }
}
