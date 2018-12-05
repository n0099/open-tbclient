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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class i {
    private static VideoControllerView.a fqU = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Wm() {
        }
    };
    private static c.i glh = new c.i() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.i
        public void aCX() {
        }
    };
    private n bOp;
    private com.baidu.tieba.play.c dMY;
    private PbActivity fUU;
    private CustomFrameLayout gkA;
    private c.d gkB;
    private z gkD;
    private g gkE;
    private boolean gkF;
    private bb gkG;
    private bb gkH;
    private String gkI;
    private float gkO;
    private int gkR;
    private double gkS;
    private long gkT;
    private PbVideoWifiTipLayout gkU;
    private int gkV;
    private c.d gkW;
    private PbFullScreenFloatingHuajiAninationView gkY;
    private RelativeLayout gky;
    private com.baidu.tieba.pb.pb.main.view.b gkz;
    private com.baidu.adp.lib.guide.c gla;
    private Bitmap glb;
    private boolean glc;
    private boolean gle;
    private int glg;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aEN = null;
    private VideoInfo gkC = null;
    private boolean gkJ = false;
    private int gkK = 0;
    private boolean gkL = false;
    private int gkM = 0;
    private int gkN = 0;
    private boolean gkP = false;
    private boolean gkQ = false;
    private boolean gkX = true;
    private PbFullScreenFloatingHuajiAninationView.a gkZ = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lP(false);
        }
    };
    private boolean gld = false;
    private c.m glf = new c.m() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.m
        public boolean bny() {
            if (i.this.fUU.checkUpIsLogin()) {
                i.this.fUU.bir();
                if (i.this.fUU.bho() == null || i.this.fUU.bho().getPbData() == null || i.this.fUU.bho().getPbData().bgI() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bgI = i.this.fUU.bho().getPbData().bgI();
                if (i.this.gkY == null) {
                    i.this.gkY = new PbFullScreenFloatingHuajiAninationView(i.this.fUU.getActivity());
                    i.this.gkY.setFloatingHuajiAninationListener(i.this.gkZ);
                }
                i.this.gkY.lR(bgI.bgO() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bnz() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.kV()) {
                    i.this.dMY.stopPlay();
                    i.this.dMY.mu(true);
                    return;
                }
                if (i.this.dMY != null) {
                    i.this.dMY.setNetworkChange();
                }
                if (j.kX() && i.this.dMY != null && i.this.dMY.bqW() && i.this.gkC != null && i.this.gkC.video_length.intValue() > 0 && i.this.gkC.video_duration.intValue() > 0) {
                    float intValue = i.this.gkC.video_length.intValue() * (1.0f - ((i.this.dMY.getCurrentPosition() * 1.0f) / (i.this.gkC.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fUU.getPageContext().getPageActivity(), String.format(i.this.fUU.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener foV = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bmm();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(boolean z) {
        if (this.fUU != null) {
            this.fUU.bhH();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.gkO = 0.0f;
        this.fUU = pbActivity;
        this.gkz = bVar;
        this.gkO = l.h(this.fUU.getActivity(), e.C0210e.ds240);
        this.gkT = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fUU.getActivity());
        Rect y = az.y(this.fUU.getPageContext().getPageActivity());
        int aQ = y.height() <= 0 ? l.aQ(this.fUU.getActivity()) : y.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gkS = (intValue2 * 1.0d) / intValue;
            if (this.gkS > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.gkR = i;
        this.gkA.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.gky = (RelativeLayout) LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gkA = (CustomFrameLayout) this.gky.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dMY = new com.baidu.tieba.play.c((TbPageContext<?>) this.fUU.getPageContext(), (View) this.gkA, true);
        this.dMY.a(this.glf);
        this.dMY.mx(false);
        this.dMY.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.12
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
                        if (i.this.fUU.getListView() != null && i.this.fUU.getListView().getChildCount() > 0 && i.this.fUU.getListView().getChildAt(0) == i.this.bnx()) {
                            i.this.glg = i.this.bnx().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.glg = 0;
                        break;
                    case 2:
                        if (i.this.fUU.getListView() != null && i.this.fUU.getListView().getChildCount() > 0 && i.this.fUU.getListView().getChildAt(0) == i.this.bnx()) {
                            i.this.fUU.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.glg);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gkS >= 1.0d) {
                this.dMY.S(false, true);
            } else {
                this.dMY.S(true, false);
            }
            this.gkP = ((float) e) + this.gkO > ((float) l.aQ(this.fUU.getActivity()));
            if (this.gkP) {
                if (this.gkE == null) {
                    this.gkE = new g(this.fUU.getPageContext(), this.gkA);
                }
                this.fUU.bhF().blv();
                this.gkF = true;
            }
        }
        bnp();
        this.mEmptyView = new View(this.fUU);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gkR));
        if (this.gkz != null && this.gkz.mNavigationBar != null) {
            this.gkz.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gkz.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gkz.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.CF() ? 0 : 8);
        }
        this.gkU = (PbVideoWifiTipLayout) this.gky.findViewById(e.g.layout_wifi_tip);
        this.gkU.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.glc = true;
                i.this.gkU.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fUU.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gkB == null) {
            this.gkB = new c.d() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.c.d
                public void gU(boolean z) {
                    if (i.this.bns() && i.this.gkz != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gkz.bmg().clearAnimation();
                        i.this.bnq();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.foV);
                            i.this.gkz.bmg().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aCW() {
                    if (i.this.bns()) {
                        i.this.bmm();
                    }
                }
            };
        }
        a(this.gkB);
        this.gkK = UtilHelper.getLightStatusBarHeight() + l.h(this.fUU.getActivity(), e.C0210e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dMY != null && bbVar != null) {
            this.gkC = videoInfo;
            this.gkG = bbVar;
            this.aEN = videoInfo.video_url;
            this.dMY.stopPlay();
            this.dMY.setIsNeedRecoveryVideoPlayer(true);
            this.bOp = new n(this.fUU.getActivity());
            this.gkD = new z();
            this.gkD.mLocate = "pb";
            this.gkD.biw = bbVar.getTid();
            this.gkD.cXO = str;
            this.gkD.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gkD.mSource = bbVar.mRecomSource;
            this.gkD.gEO = bbVar.mRecomWeight;
            this.gkD.gEP = this.fUU.bhD();
            this.gkD.gEQ = bbVar.mRecomAbTag;
            this.gkD.gER = videoInfo.video_md5;
            z bse = this.gkD.bse();
            bse.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bOp.setVideoStatsData(bse);
            this.dMY.getVideoView().setBusiness(this.bOp);
            if (this.dMY.aYR()) {
                this.dMY.aYP();
            }
            this.dMY.b(this.gkW);
            this.gkI = null;
            this.gkH = null;
            this.dMY.tt(this.gkI);
            this.dMY.aYL().setOnDragingListener(fqU);
            this.dMY.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YR() {
                    i.this.fUU.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.gkV > 0) {
                                i.this.sK(i.this.gkV);
                                i.this.sL(i.this.gkV);
                                i.this.gkV = 0;
                            }
                            i.this.gkX = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YQ() {
                    i.this.fUU.setSwipeBackEnabled(false);
                    i.this.gkX = false;
                    i.this.gkV = i.this.bnu().getHeight();
                }
            });
            this.dMY.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void bnA() {
                    if (i.this.fUU != null && i.this.gkH != null && !StringUtils.isNull(i.this.gkH.getId())) {
                        i.this.fUU.sP(i.this.gkH.getId());
                        if (i.this.gkG != null) {
                            long j = 0;
                            if (i.this.gkG.AJ() != null) {
                                j = i.this.gkG.AJ().channelId;
                            }
                            TiebaStatic.log(new am("c11921").i(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dMY.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.j
                public void lQ(boolean z) {
                    if (i.this.gkG != null) {
                        long j = 0;
                        if (i.this.gkG.AJ() != null) {
                            j = i.this.gkG.AJ().channelId;
                        }
                        i.this.oe(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").aA("tid", i.this.gkG.getTid()).i(ImageViewerConfig.FORUM_ID, i.this.gkG.getFid()).i(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dMY.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aEN);
                    return true;
                }
            });
            this.dMY.setThumbnail(videoInfo.thumbnail_url);
            this.dMY.setVideoUrl(this.aEN, bbVar.getTid());
            this.dMY.setFid(str);
            this.dMY.tR(bbVar.getTitle());
            this.dMY.a(glh);
            this.dMY.aLX();
            this.dMY.show();
        }
    }

    public void ts(String str) {
        if (this.gkD != null) {
            this.gkD.cXO = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.gkE != null) {
            this.gkE.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.gkW = dVar;
    }

    public void as(bb bbVar) {
        this.gkH = bbVar;
    }

    public void tt(String str) {
        this.gkI = str;
        if (this.dMY != null) {
            this.dMY.tt(this.gkI);
        }
    }

    public void startPlay() {
        if (this.dMY != null) {
            if (j.kX() && !this.glc && !com.baidu.tieba.video.g.bHR().bHS()) {
                this.gkU.setVisibility(0);
                this.gkU.setData(this.gkC);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aEN) && this.gkG != null && this.gkG.zY() != null) {
                TiebaStatic.log(new am("c12619").aA("obj_locate", "pb").aA("tid", this.gkG.getTid()));
                this.aEN = this.gkG.zY().video_url;
            }
            this.dMY.c(this.aEN, this.gkG == null ? "" : this.gkG.getTid(), this.gkT);
            oe("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bno() {
        if (this.dMY != null) {
            this.dMY.bno();
        }
    }

    public void destroy() {
        if (this.dMY != null) {
            this.dMY.destroy();
        }
        if (this.gkA != null) {
            this.gkA.clearAnimation();
        }
        if (this.gkE != null) {
            this.gkE.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dMY != null) {
            if (this.dMY.bqW()) {
                this.gkJ = true;
                this.dMY.stopPlay();
            } else if (this.dMY.getCurrentState() == 3) {
                this.gkJ = false;
            } else if (this.dMY.getCurrentState() == 0 || this.dMY.getCurrentState() == 1) {
                this.gkJ = true;
                this.dMY.stopPlay();
            } else {
                this.gkJ = false;
                this.dMY.stopPlay();
            }
            if (this.gkY != null) {
                this.gkY.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dMY != null && this.gkJ) {
            this.dMY.bqT();
        }
    }

    private void bnp() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ax(16908290).aw(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fUU.getActivity());
                    if (i.this.glb == null) {
                        try {
                            i.this.glb = BitmapFactory.decodeResource(i.this.fUU.getResources(), e.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.glb);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iR() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iS() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.gla = null;
                    if (i.this.glb != null && !i.this.glb.isRecycled()) {
                        i.this.glb.recycle();
                    }
                    i.this.glb = null;
                }
            });
            this.gla = dVar.iT();
            this.gla.o(this.fUU.getActivity());
        }
    }

    public boolean mu(int i) {
        if (this.dMY == null) {
            return false;
        }
        return this.dMY.tl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(String str) {
        if (this.gkC != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gkC.video_md5, "", str, this.gkD);
            }
        }
    }

    public void bnq() {
        if (this.gkz != null) {
            this.gkz.lH(this.fUU.bhe());
        }
    }

    public void bmm() {
        if (this.gkz != null) {
            this.gkz.bmm();
        }
    }

    public void sF(int i) {
        if (this.gkz != null) {
            this.gkz.sF(i);
        }
        if (this.gkY != null) {
            this.gkY.onChangeSkinType(i);
        }
        if (this.gkE != null) {
            this.gkE.eC(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bnt()) {
                    this.gkM = i;
                    if (this.gkM == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.sL(i.this.bnu().getHeight());
                            }
                        }, 100L);
                    }
                    bnr();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(int i) {
        if (bnu().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkA.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.gle = false;
                    if (this.gkR != bnu().getHeight()) {
                        this.gkA.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fUU.getActivity()), Math.min(this.gkR, bnu().getHeight() + i)));
                        this.dMY.aYP();
                    }
                } else if (l.aO(this.fUU.getActivity()) * 0.5625d != bnu().getHeight()) {
                    this.gkA.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fUU.getActivity()), (int) Math.max(l.aO(this.fUU.getActivity()) * 0.5625d, bnu().getHeight() + i)));
                    this.dMY.aYP();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bnx()) {
                int bottom = childAt.getBottom() - bnu().getBottom();
                if (childAt.getHeight() == 0 || bnu().getHeight() == 0) {
                    bottom = 0;
                }
                sK(bottom);
            } else {
                sK((-this.gkR) + 2);
            }
        }
        if (!bnt() && this.gkX) {
            if (this.gkM == 1) {
                this.gld = true;
                sL(bnu().getHeight());
            } else if (this.gkM == 2) {
                this.gld = true;
                int y = (int) bnu().getY();
                if (this.gkN == y) {
                    sL(bnu().getHeight());
                } else {
                    this.gkN = y;
                    sL(bnu().getHeight());
                }
                if (i == 0 && this.gkQ) {
                    this.gkQ = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bno();
                        }
                    }, 100L);
                }
            } else if (this.gkM == 0) {
                if (this.gld || !"nani_midpage".equals(this.fUU.bhD())) {
                    sL(bnu().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(int i) {
        sM(i);
        bnr();
    }

    public void lt(boolean z) {
        this.gle = z;
    }

    private void sM(int i) {
        if (this.gkE != null) {
            if (i == 0) {
                i = this.gkR;
            }
            float f = this.gkR - i;
            float f2 = f > this.gkO ? 0.0f : 1.0f - (f / this.gkO);
            if (this.gle) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.gkE.bnk().setVisibility(8);
            } else {
                this.gkE.bnk().setVisibility(0);
            }
            this.gkE.aw(f2);
        }
    }

    public void bnr() {
        if (this.gkE != null) {
            if (bnt()) {
                this.fUU.bhF().blv();
            } else if (this.gkE.bnk().getVisibility() == 0) {
                this.fUU.bhF().blv();
                this.gkF = true;
            } else if (this.gkF) {
                this.fUU.bhF().ls(false);
                this.gkF = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bns() {
        return bnu().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.gkL = false;
        if (this.dMY != null && this.gkA != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkA.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gla != null) {
                    this.gla.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gkL = true;
                this.gkA.setLayoutParams(layoutParams);
                this.fUU.bhF().blv();
                this.gkF = true;
            } else {
                e(this.gkC);
                bnq();
                this.gkL = false;
                this.gkz.lG(true);
            }
            this.dMY.a(this.fUU.getPageContext(), configuration);
        }
    }

    public boolean bnt() {
        return this.gkL;
    }

    public void n(long j, int i) {
        if (this.gkE != null && j > 0) {
            this.gkE.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.gkE != null) {
            this.gkE.N(onClickListener);
        }
    }

    public View bnu() {
        return this.gky;
    }

    public boolean blE() {
        if (bnu() == null) {
            return false;
        }
        return bnu().getBottom() > l.aQ(bnu().getContext()) - l.h(bnu().getContext(), e.C0210e.ds50);
    }

    public void bnv() {
        this.gkQ = true;
    }

    public void bnw() {
        if (this.dMY != null) {
            this.dMY.pausePlay();
        }
    }

    public View bnx() {
        return this.mEmptyView;
    }
}
