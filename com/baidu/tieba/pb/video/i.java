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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
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
    private static VideoControllerView.a ePO = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Rb() {
        }
    };
    private static c.h fNn = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void avI() {
        }
    };
    private n buL;
    private com.baidu.tieba.play.c doe;
    private RelativeLayout fMH;
    private com.baidu.tieba.pb.pb.main.view.b fMI;
    private CustomFrameLayout fMJ;
    private c.InterfaceC0219c fMK;
    private y fMM;
    private g fMN;
    private boolean fMO;
    private bc fMP;
    private bc fMQ;
    private String fMR;
    private float fMX;
    private int fNa;
    private double fNb;
    private long fNc;
    private PbVideoWifiTipLayout fNd;
    private c.InterfaceC0219c fNe;
    private PbFullScreenFloatingHuajiAninationView fNg;
    private com.baidu.adp.lib.guide.c fNi;
    private Bitmap fNj;
    private boolean fNk;
    private int fNm;
    private PbActivity fxh;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bcS = null;
    private VideoInfo fML = null;
    private boolean fMS = false;
    private int fMT = 0;
    private boolean fMU = false;
    private int fMV = 0;
    private int fMW = 0;
    private boolean fMY = false;
    private boolean fMZ = false;
    private boolean fNf = true;
    private PbFullScreenFloatingHuajiAninationView.a fNh = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lc(false);
        }
    };
    private c.l fNl = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void big() {
            if (i.this.fxh.checkUpIsLogin()) {
                i.this.fxh.bdc();
                if (i.this.fxh.bca() != null && i.this.fxh.bca().getPbData() != null && i.this.fxh.bca().getPbData().bbs() != null) {
                    j bbs = i.this.fxh.bca().getPbData().bbs();
                    if (i.this.fNg == null) {
                        i.this.fNg = new PbFullScreenFloatingHuajiAninationView(i.this.fxh.getActivity());
                        i.this.fNg.setFloatingHuajiAninationListener(i.this.fNh);
                    }
                    i.this.fNg.le(!bbs.bbA());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.doe != null) {
                    i.this.doe.blA();
                }
                if (com.baidu.adp.lib.util.j.jD() && com.baidu.adp.lib.util.j.jF() && i.this.doe != null && i.this.doe.blC() && i.this.fML != null && i.this.fML.video_length.intValue() > 0 && i.this.fML.video_duration.intValue() > 0) {
                    float intValue = i.this.fML.video_length.intValue() * (1.0f - ((i.this.doe.getCurrentPosition() * 1.0f) / (i.this.fML.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fxh.getPageContext().getPageActivity(), String.format(i.this.fxh.getPageContext().getString(d.k.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eNQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bgS();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lc(boolean z) {
        if (this.fxh.bca() != null && this.fxh.bca().getPbData() != null && this.fxh.bca().getPbData().bbs() != null) {
            j bbs = this.fxh.bca().getPbData().bbs();
            View findViewById = this.fxh.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!bbs.bbA() || z) {
                this.fxh.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fxh.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, bbs.bbA() ? 0 : 1));
            } else if (bbs.bbA()) {
                if (bbs.fta == 1 || bbs.fta == 3 || bbs.fta == 4) {
                    this.fxh.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fxh.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, bbs.bbA() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fMX = 0.0f;
        this.fxh = pbActivity;
        this.fMI = bVar;
        this.fMX = l.e(this.fxh.getActivity(), d.e.ds240);
        this.fNc = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int ah = l.ah(this.fxh.getActivity());
        Rect t = ba.t(this.fxh.getPageContext().getPageActivity());
        int aj = t.height() <= 0 ? l.aj(this.fxh.getActivity()) : t.height();
        int i = (int) (ah * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fNb = (intValue2 * 1.0d) / intValue;
            if (this.fNb > 0.5625d) {
                i = Math.min((ah * intValue2) / intValue, aj);
            }
        }
        this.fNa = i;
        this.fMJ.setLayoutParams(new RelativeLayout.LayoutParams(ah, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.fMH = (RelativeLayout) LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.video_pb_container_layout, (ViewGroup) null);
        this.fMJ = (CustomFrameLayout) this.fMH.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.doe = new com.baidu.tieba.play.c(this.fxh.getPageContext(), this.fMJ, true);
        this.doe.a(this.fNl);
        this.doe.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
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
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.fxh.getListView() != null && i.this.fxh.getListView().getChildCount() > 0 && i.this.fxh.getListView().getChildAt(0) == i.this.bie()) {
                            i.this.fNm = i.this.bie().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fNm = 0;
                        break;
                    case 2:
                        if (i.this.fxh.getListView() != null && i.this.fxh.getListView().getChildCount() > 0 && i.this.fxh.getListView().getChildAt(0) == i.this.bie()) {
                            i.this.fxh.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fNm);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fNb >= 1.0d) {
                this.doe.N(false, true);
            } else {
                this.doe.N(true, false);
            }
            this.fMY = ((float) e) + this.fMX > ((float) l.aj(this.fxh.getActivity()));
            if (this.fMY) {
                if (this.fMN == null) {
                    this.fMN = new g(this.fxh.getPageContext(), this.fMJ);
                    this.fMN.O(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.lc(true);
                        }
                    });
                }
                this.fxh.bcr().bgg();
                this.fMO = true;
            }
        }
        bhX();
        this.mEmptyView = new View(this.fxh);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fNa));
        if (this.fMI != null && this.fMI.mNavigationBar != null) {
            this.fMI.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fMI.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fMI.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.yo() ? 0 : 8);
        }
        this.fNd = (PbVideoWifiTipLayout) this.fMH.findViewById(d.g.layout_wifi_tip);
        this.fNd.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fNk = true;
                i.this.fNd.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fxh.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fMK == null) {
            this.fMK = new c.InterfaceC0219c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void fS(boolean z) {
                    if (i.this.bia() && i.this.fMI != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fMI.bgM().clearAnimation();
                        i.this.bhY();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eNQ);
                            i.this.fMI.bgM().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void avH() {
                    if (i.this.bia()) {
                        i.this.bgS();
                    }
                }
            };
        }
        a(this.fMK);
        this.fMT = UtilHelper.getLightStatusBarHeight() + l.e(this.fxh.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bc bcVar, String str) {
        if (videoInfo != null && this.doe != null && bcVar != null) {
            this.fML = videoInfo;
            this.fMP = bcVar;
            this.bcS = videoInfo.video_url;
            this.doe.stopPlay();
            this.doe.lE(true);
            this.buL = new n(this.fxh.getActivity());
            this.fMM = new y();
            this.fMM.mLocate = "pb";
            this.fMM.aWo = bcVar.getTid();
            this.fMM.czo = str;
            this.fMM.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fMM.mSource = bcVar.mRecomSource;
            this.fMM.ghd = bcVar.mRecomWeight;
            this.fMM.ghe = this.fxh.bcp();
            this.fMM.ghf = bcVar.mRecomAbTag;
            this.fMM.ghg = videoInfo.video_md5;
            y bmE = this.fMM.bmE();
            bmE.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.buL.setVideoStatsData(bmE);
            this.doe.getVideoView().setBusiness(this.buL);
            if (this.doe.aRc()) {
                this.doe.aRa();
            }
            this.doe.b(this.fNe);
            this.fMR = null;
            this.fMQ = null;
            this.doe.rM(this.fMR);
            this.doe.aQW().setOnDragingListener(ePO);
            this.doe.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void avE() {
                    i.this.fxh.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fNf = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void avD() {
                    i.this.fxh.setSwipeBackEnabled(false);
                    i.this.fNf = false;
                }
            });
            this.doe.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bif() {
                    if (i.this.fxh != null && i.this.fMQ != null && !StringUtils.isNull(i.this.fMQ.getId())) {
                        i.this.fxh.rh(i.this.fMQ.getId());
                        if (i.this.fMP != null) {
                            long j = 0;
                            if (i.this.fMP.ww() != null) {
                                j = i.this.fMP.ww().channelId;
                            }
                            TiebaStatic.log(new an("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.doe.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void ld(boolean z) {
                    if (i.this.fMP != null) {
                        long j = 0;
                        if (i.this.fMP.ww() != null) {
                            j = i.this.fMP.ww().channelId;
                        }
                        i.this.my(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").ah("tid", i.this.fMP.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fMP.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.doe.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bcS);
                    return true;
                }
            });
            this.doe.pr(videoInfo.thumbnail_url);
            this.doe.bW(this.bcS, bcVar.getTid());
            this.doe.sg(bcVar.getTitle());
            this.doe.a(fNn);
            this.doe.aEd();
            this.doe.show();
        }
    }

    public void rL(String str) {
        if (this.fMM != null) {
            this.fMM.czo = str;
        }
    }

    public void b(PostData postData, bc bcVar, j jVar) {
        if (this.fMN != null) {
            this.fMN.a(postData, bcVar, jVar);
        }
    }

    public void a(c.InterfaceC0219c interfaceC0219c) {
        this.fNe = interfaceC0219c;
    }

    public void aq(bc bcVar) {
        this.fMQ = bcVar;
    }

    public void rM(String str) {
        this.fMR = str;
        if (this.doe != null) {
            this.doe.rM(this.fMR);
        }
    }

    public void startPlay() {
        if (this.doe != null) {
            if (com.baidu.adp.lib.util.j.jF() && !this.fNk && !com.baidu.tieba.video.f.bBB().bBC()) {
                this.fNd.setVisibility(0);
                this.fNd.setData(this.fML);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bcS) && this.fMP != null && this.fMP.vN() != null) {
                TiebaStatic.log(new an("c12619").ah("obj_locate", "pb").ah("tid", this.fMP.getTid()));
                this.bcS = this.fMP.vN().video_url;
            }
            this.doe.b(this.bcS, this.fMP == null ? "" : this.fMP.getTid(), this.fNc);
            my("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bhW() {
        if (this.doe != null) {
            this.doe.bhW();
        }
    }

    public void destroy() {
        if (this.doe != null) {
            this.doe.destroy();
        }
        if (this.fMJ != null) {
            this.fMJ.clearAnimation();
        }
        if (this.fMN != null) {
            this.fMN.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.doe != null) {
            if (this.doe.blC()) {
                this.fMS = true;
                this.doe.pausePlay();
            } else if (this.doe.blJ() == 3) {
                this.fMS = false;
            } else {
                this.fMS = false;
                this.doe.pausePlay();
            }
            if (this.fNg != null) {
                this.fNg.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.doe != null && this.fMS) {
            this.doe.aRf();
        }
    }

    private void bhX() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.Y(16908290).X(153).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fxh.getActivity());
                    if (i.this.fNj == null) {
                        try {
                            i.this.fNj = BitmapFactory.decodeResource(i.this.fxh.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fNj);
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
                    i.this.fNi = null;
                    if (i.this.fNj != null && !i.this.fNj.isRecycled()) {
                        i.this.fNj.recycle();
                    }
                    i.this.fNj = null;
                }
            });
            this.fNi = dVar.hy();
            this.fNi.l(this.fxh.getActivity());
        }
    }

    public boolean kB(int i) {
        if (this.doe == null) {
            return false;
        }
        return this.doe.rH(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (this.fML != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fML.video_md5, "", str, this.fMM);
            }
        }
    }

    public void bhY() {
        if (this.fMI != null) {
            this.fMI.kS(this.fxh.bdb());
        }
    }

    public void bgS() {
        if (this.fMI != null) {
            this.fMI.bgS();
        }
    }

    public void qY(int i) {
        if (this.fMI != null) {
            this.fMI.qY(i);
        }
        if (this.fNg != null) {
            this.fNg.onChangeSkinType(i);
        }
        if (this.fMN != null) {
            this.fMN.dD(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bib()) {
                    this.fMV = i;
                    if (this.fMV == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.rf(i.this.bic().getHeight());
                            }
                        }, 100L);
                    }
                    bhZ();
                    return;
                }
                return;
        }
    }

    private void re(int i) {
        if (bic().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMJ.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fNa != bic().getHeight()) {
                        this.fMJ.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.fxh.getActivity()), Math.min(this.fNa, bic().getHeight() + i)));
                        this.doe.aRa();
                    }
                } else if (l.ah(this.fxh.getActivity()) * 0.5625d != bic().getHeight()) {
                    this.fMJ.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.fxh.getActivity()), (int) Math.max(l.ah(this.fxh.getActivity()) * 0.5625d, bic().getHeight() + i)));
                    this.doe.aRa();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bie()) {
                int bottom = childAt.getBottom() - bic().getBottom();
                if (childAt.getHeight() == 0 || bic().getHeight() == 0) {
                    bottom = 0;
                }
                re(bottom);
            } else {
                re((-this.fNa) + 2);
            }
        }
        if (!bib() && this.fNf) {
            if (this.fMV == 1) {
                rf(bic().getHeight());
            } else if (this.fMV == 2) {
                int y = (int) bic().getY();
                if (this.fMW == y) {
                    rf(bic().getHeight());
                } else {
                    this.fMW = y;
                    rf(bic().getHeight());
                }
                if (i == 0 && this.fMZ) {
                    this.fMZ = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bhW();
                        }
                    }, 100L);
                }
            } else if (this.fMV == 0) {
                rf(bic().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rf(int i) {
        rg(i);
        bhZ();
    }

    private void rg(int i) {
        if (this.fMN != null) {
            if (i == 0) {
                i = this.fNa;
            }
            float f = this.fNa - i;
            float f2 = f > this.fMX ? 0.0f : 1.0f - (f / this.fMX);
            if (f2 == 0.0f) {
                this.fMN.bhS().setVisibility(8);
            } else {
                this.fMN.bhS().setVisibility(0);
            }
            this.fMN.ar(f2);
        }
    }

    public void bhZ() {
        if (this.fMN != null) {
            if (bib()) {
                this.fxh.bcr().bgg();
            } else if (this.fMN.bhS().getVisibility() == 0) {
                this.fxh.bcr().bgg();
                this.fMO = true;
            } else if (this.fMO) {
                this.fxh.bcr().kE(false);
                this.fMO = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bia() {
        return bic().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fMU = false;
        if (this.doe != null && this.fMJ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMJ.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fNi != null) {
                    this.fNi.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fMU = true;
                this.fMJ.setLayoutParams(layoutParams);
                this.fxh.bcr().bgg();
                this.fMO = true;
            } else {
                e(this.fML);
                bhY();
                this.fMU = false;
                this.fMI.kR(true);
            }
            this.doe.a(this.fxh.getPageContext(), configuration);
        }
    }

    public boolean bib() {
        return this.fMU;
    }

    public void y(long j, int i) {
        if (this.fMN != null && j > 0) {
            this.fMN.l(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fMN != null) {
            this.fMN.N(onClickListener);
        }
    }

    public View bic() {
        return this.fMH;
    }

    public boolean bgp() {
        if (bic() == null) {
            return false;
        }
        return bic().getBottom() > l.aj(bic().getContext()) - l.e(bic().getContext(), d.e.ds50);
    }

    public void bid() {
        this.fMZ = true;
    }

    public View bie() {
        return this.mEmptyView;
    }
}
