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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
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
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private n blg;
    private com.baidu.tieba.play.c dcc;
    private PbActivity fhQ;
    private float fxB;
    private int fxE;
    private double fxF;
    private long fxG;
    private PbVideoWifiTipLayout fxH;
    private c.InterfaceC0201c fxI;
    private PbFullScreenFloatingHuajiAninationView fxK;
    private com.baidu.adp.lib.guide.c fxM;
    private Bitmap fxN;
    private boolean fxO;
    private int fxQ;
    private RelativeLayout fxl;
    private com.baidu.tieba.pb.pb.main.view.b fxm;
    private CustomFrameLayout fxn;
    private c.InterfaceC0201c fxo;
    private y fxq;
    private g fxr;
    private boolean fxs;
    private bd fxt;
    private bd fxu;
    private String fxv;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String baJ = null;
    private VideoInfo fxp = null;
    private boolean fxw = false;
    private int fxx = 0;
    private boolean fxy = false;
    private int fxz = 0;
    private int fxA = 0;
    private boolean fxC = false;
    private boolean fxD = false;
    private boolean fxJ = true;
    private PbFullScreenFloatingHuajiAninationView.a fxL = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.kM(false);
        }
    };
    private c.l fxP = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void bcA() {
            if (i.this.fhQ.checkUpIsLogin()) {
                i.this.fhQ.aXz();
                if (i.this.fhQ.aWx() != null && i.this.fhQ.aWx().getPbData() != null && i.this.fhQ.aWx().getPbData().aVO() != null) {
                    j aVO = i.this.fhQ.aWx().getPbData().aVO();
                    if (i.this.fxK == null) {
                        i.this.fxK = new PbFullScreenFloatingHuajiAninationView(i.this.fhQ.getActivity());
                        i.this.fxK.setFloatingHuajiAninationListener(i.this.fxL);
                    }
                    i.this.fxK.kO(!aVO.aVW());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dcc != null) {
                    i.this.dcc.bfY();
                }
                if (com.baidu.adp.lib.util.j.gP() && com.baidu.adp.lib.util.j.gR() && i.this.dcc != null && i.this.dcc.bga() && i.this.fxp != null && i.this.fxp.video_length.intValue() > 0 && i.this.fxp.video_duration.intValue() > 0) {
                    float intValue = i.this.fxp.video_length.intValue() * (1.0f - ((i.this.dcc.getCurrentPosition() * 1.0f) / (i.this.fxp.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fhQ.getPageContext().getPageActivity(), String.format(i.this.fhQ.getPageContext().getString(d.k.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eyG = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bbl();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private VideoControllerView.a eAE = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Ne() {
        }
    };
    private c.h fxR = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void aqZ() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(boolean z) {
        if (this.fhQ.aWx() != null && this.fhQ.aWx().getPbData() != null && this.fhQ.aWx().getPbData().aVO() != null) {
            j aVO = this.fhQ.aWx().getPbData().aVO();
            View findViewById = this.fhQ.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aVO.aVW() || z) {
                this.fhQ.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fhQ.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVO.aVW() ? 0 : 1));
            } else if (aVO.aVW()) {
                if (aVO.fdK == 1 || aVO.fdK == 3 || aVO.fdK == 4) {
                    this.fhQ.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fhQ.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVO.aVW() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fxB = 0.0f;
        this.fhQ = pbActivity;
        this.fxm = bVar;
        this.fxB = l.e(this.fhQ.getActivity(), d.e.ds240);
        this.fxG = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int af = l.af(this.fhQ.getActivity());
        Rect u = ay.u(this.fhQ.getPageContext().getPageActivity());
        int ah = u.height() <= 0 ? l.ah(this.fhQ.getActivity()) : u.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fxF = (intValue2 * 1.0d) / intValue;
            if (this.fxF > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.fxE = i;
        this.fxn.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fxl = (RelativeLayout) LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.video_pb_container_layout, (ViewGroup) null);
        this.fxn = (CustomFrameLayout) this.fxl.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dcc = new com.baidu.tieba.play.c(this.fhQ.getPageContext(), this.fxn, true);
        this.dcc.a(this.fxP);
        this.dcc.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // com.baidu.tieba.play.c.j
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.j
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.j
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.fhQ.xi() != null && i.this.fhQ.xi().getChildCount() > 0 && i.this.fhQ.xi().getChildAt(0) == i.this.bcy()) {
                            i.this.fxQ = i.this.bcy().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fxQ = 0;
                        break;
                    case 2:
                        if (i.this.fhQ.xi() != null && i.this.fhQ.xi().getChildCount() > 0 && i.this.fhQ.xi().getChildAt(0) == i.this.bcy()) {
                            i.this.fhQ.xi().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fxQ);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fxF >= 1.0d) {
                this.dcc.K(false, true);
            } else {
                this.dcc.K(true, false);
            }
            this.fxC = ((float) b) + this.fxB > ((float) l.ah(this.fhQ.getActivity()));
            if (this.fxC) {
                if (this.fxr == null) {
                    this.fxr = new g(this.fhQ.getPageContext(), this.fxn);
                    this.fxr.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            i.this.kM(true);
                        }
                    });
                }
                this.fhQ.aWO().baA();
                this.fxs = true;
            }
        }
        bcr();
        this.mEmptyView = new View(this.fhQ);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fxE));
        if (this.fxm != null && this.fxm.mNavigationBar != null) {
            this.fxm.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fxm.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fxm.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fxH = (PbVideoWifiTipLayout) this.fxl.findViewById(d.g.layout_wifi_tip);
        this.fxH.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.fxO = true;
                i.this.fxH.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fhQ.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fxo == null) {
            this.fxo = new c.InterfaceC0201c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fH(boolean z) {
                    if (i.this.bcu() && i.this.fxm != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fxm.bbf().clearAnimation();
                        i.this.bcs();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eyG);
                            i.this.fxm.bbf().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqY() {
                    if (i.this.bcu()) {
                        i.this.bbl();
                    }
                }
            };
        }
        a(this.fxo);
        this.fxx = UtilHelper.getLightStatusBarHeight() + l.e(this.fhQ.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dcc != null && bdVar != null) {
            this.fxp = videoInfo;
            this.fxt = bdVar;
            this.baJ = videoInfo.video_url;
            this.dcc.stopPlay();
            this.dcc.lo(true);
            this.blg = new n(this.fhQ.getActivity());
            this.fxq = new y();
            this.fxq.mLocate = "pb";
            this.fxq.aNv = bdVar.getTid();
            this.fxq.csP = str;
            this.fxq.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fxq.mSource = bdVar.mRecomSource;
            this.fxq.fRQ = bdVar.mRecomWeight;
            this.fxq.fRR = this.fhQ.aWM();
            this.fxq.fRS = bdVar.mRecomAbTag;
            this.fxq.fRT = videoInfo.video_md5;
            y bhc = this.fxq.bhc();
            bhc.mLocate = "6";
            this.blg.setVideoStatsData(bhc);
            this.dcc.getVideoView().setBusiness(this.blg);
            if (this.dcc.aLz()) {
                this.dcc.aLx();
            }
            this.dcc.b(this.fxI);
            this.fxv = null;
            this.fxu = null;
            this.dcc.qX(this.fxv);
            this.dcc.aLt().setOnDragingListener(this.eAE);
            this.dcc.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    i.this.fhQ.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fxJ = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqU() {
                    i.this.fhQ.setSwipeBackEnabled(false);
                    i.this.fxJ = false;
                }
            });
            this.dcc.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bcz() {
                    if (i.this.fhQ != null && i.this.fxu != null && !StringUtils.isNull(i.this.fxu.getId())) {
                        i.this.fhQ.qu(i.this.fxu.getId());
                        if (i.this.fxt != null) {
                            long j = 0;
                            if (i.this.fxt.sP() != null) {
                                j = i.this.fxt.sP().channelId;
                            }
                            TiebaStatic.log(new al("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dcc.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void kN(boolean z) {
                    if (i.this.fxt != null) {
                        long j = 0;
                        if (i.this.fxt.sP() != null) {
                            j = i.this.fxt.sP().channelId;
                        }
                        i.this.lR(z ? "1" : "2");
                        TiebaStatic.log(new al("c10795").ac("tid", i.this.fxt.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fxt.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dcc.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.baJ);
                    return true;
                }
            });
            this.dcc.oC(videoInfo.thumbnail_url);
            this.dcc.bK(this.baJ, bdVar.getTid());
            this.dcc.rq(bdVar.getTitle());
            this.dcc.a(this.fxR);
            this.dcc.ayy();
            this.dcc.show();
        }
    }

    public void qW(String str) {
        if (this.fxq != null) {
            this.fxq.csP = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.fxr != null) {
            this.fxr.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0201c interfaceC0201c) {
        this.fxI = interfaceC0201c;
    }

    public void aj(bd bdVar) {
        this.fxu = bdVar;
    }

    public void qX(String str) {
        this.fxv = str;
        if (this.dcc != null) {
            this.dcc.qX(this.fxv);
        }
    }

    public void startPlay() {
        if (this.dcc != null) {
            if (com.baidu.adp.lib.util.j.gR() && !this.fxO && !com.baidu.tieba.video.f.bvU().bvV()) {
                this.fxH.setVisibility(0);
                this.fxH.setData(this.fxp);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.baJ) && this.fxt != null && this.fxt.sg() != null) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "pb").ac("tid", this.fxt.getTid()));
                this.baJ = this.fxt.sg().video_url;
            }
            this.dcc.b(this.baJ, this.fxt == null ? "" : this.fxt.getTid(), this.fxG);
            lR("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bcq() {
        if (this.dcc != null) {
            this.dcc.bcq();
        }
    }

    public void destroy() {
        if (this.dcc != null) {
            this.dcc.destroy();
        }
        if (this.fxn != null) {
            this.fxn.clearAnimation();
        }
        if (this.fxr != null) {
            this.fxr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dcc != null) {
            if (this.dcc.bga()) {
                this.fxw = true;
                this.dcc.pausePlay();
            } else if (this.dcc.bgh() == 3) {
                this.fxw = false;
            } else {
                this.fxw = false;
                this.dcc.pausePlay();
            }
            if (this.fxK != null) {
                this.fxK.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dcc != null && this.fxw) {
            this.dcc.aLC();
        }
    }

    private void bcr() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.C(true);
            dVar.E(false);
            dVar.X(16908290).W(153).D(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fhQ.getActivity());
                    if (i.this.fxN == null) {
                        try {
                            i.this.fxN = BitmapFactory.decodeResource(i.this.fhQ.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fxN);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eF() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eG() {
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
                    i.this.fxM = null;
                    if (i.this.fxN != null && !i.this.fxN.isRecycled()) {
                        i.this.fxN.recycle();
                    }
                    i.this.fxN = null;
                }
            });
            this.fxM = dVar.eH();
            this.fxM.m(this.fhQ.getActivity());
        }
    }

    public boolean kp(int i) {
        if (this.dcc == null) {
            return false;
        }
        return this.dcc.rm(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(String str) {
        if (this.fxp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fxp.video_md5, "", str, this.fxq);
            }
        }
    }

    public void bcs() {
        if (this.fxm != null) {
            this.fxm.kC(this.fhQ.aXy());
        }
    }

    public void bbl() {
        if (this.fxm != null) {
            this.fxm.bbl();
        }
    }

    public void qE(int i) {
        if (this.fxm != null) {
            this.fxm.qE(i);
        }
        if (this.fxK != null) {
            this.fxK.onChangeSkinType(i);
        }
        if (this.fxr != null) {
            this.fxr.dA(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bcv()) {
                    this.fxz = i;
                    if (this.fxz == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qL(i.this.bcw().getHeight());
                            }
                        }, 100L);
                    }
                    bct();
                    return;
                }
                return;
        }
    }

    private void qK(int i) {
        if (bcw().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxn.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fxE != bcw().getHeight()) {
                        this.fxn.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.fhQ.getActivity()), Math.min(this.fxE, bcw().getHeight() + i)));
                        this.dcc.aLx();
                    }
                } else if (l.af(this.fhQ.getActivity()) * 0.5625d != bcw().getHeight()) {
                    this.fxn.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.fhQ.getActivity()), (int) Math.max(l.af(this.fhQ.getActivity()) * 0.5625d, bcw().getHeight() + i)));
                    this.dcc.aLx();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bcy()) {
                int bottom = childAt.getBottom() - bcw().getBottom();
                if (childAt.getHeight() == 0 || bcw().getHeight() == 0) {
                    bottom = 0;
                }
                qK(bottom);
            } else {
                qK((-this.fxE) + 2);
            }
        }
        if (!bcv() && this.fxJ) {
            if (this.fxz == 1) {
                qL(bcw().getHeight());
            } else if (this.fxz == 2) {
                int y = (int) bcw().getY();
                if (this.fxA == y) {
                    qL(bcw().getHeight());
                } else {
                    this.fxA = y;
                    qL(bcw().getHeight());
                }
                if (i == 0 && this.fxD) {
                    this.fxD = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bcq();
                        }
                    }, 100L);
                }
            } else if (this.fxz == 0) {
                qL(bcw().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qL(int i) {
        qM(i);
        bct();
    }

    private void qM(int i) {
        if (this.fxr != null) {
            if (i == 0) {
                i = this.fxE;
            }
            float f = this.fxE - i;
            float f2 = f > this.fxB ? 0.0f : 1.0f - (f / this.fxB);
            if (f2 == 0.0f) {
                this.fxr.bcm().setVisibility(8);
            } else {
                this.fxr.bcm().setVisibility(0);
            }
            this.fxr.ah(f2);
        }
    }

    public void bct() {
        if (this.fxr != null) {
            if (bcv()) {
                this.fhQ.aWO().baA();
            } else if (this.fxr.bcm().getVisibility() == 0) {
                this.fhQ.aWO().baA();
                this.fxs = true;
            } else if (this.fxs) {
                this.fhQ.aWO().ko(false);
                this.fxs = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bcu() {
        return bcw().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fxy = false;
        if (this.dcc != null && this.fxn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxn.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fxM != null) {
                    this.fxM.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fxy = true;
                this.fxn.setLayoutParams(layoutParams);
                this.fhQ.aWO().baA();
                this.fxs = true;
            } else {
                b(this.fxp);
                bcs();
                this.fxy = false;
                this.fxm.kB(true);
            }
            this.dcc.a(this.fhQ.getPageContext(), configuration);
        }
    }

    public boolean bcv() {
        return this.fxy;
    }

    public void y(long j, int i) {
        if (this.fxr != null && j > 0) {
            this.fxr.l(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fxr != null) {
            this.fxr.J(onClickListener);
        }
    }

    public View bcw() {
        return this.fxl;
    }

    public boolean baJ() {
        if (bcw() == null) {
            return false;
        }
        return bcw().getBottom() > l.ah(bcw().getContext()) - l.e(bcw().getContext(), d.e.ds50);
    }

    public void bcx() {
        this.fxD = true;
    }

    public View bcy() {
        return this.mEmptyView;
    }
}
