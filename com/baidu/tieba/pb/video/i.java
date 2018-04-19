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
    private n bkR;
    private com.baidu.tieba.play.c daY;
    private PbActivity fgM;
    private int fwB;
    private double fwC;
    private long fwD;
    private PbVideoWifiTipLayout fwE;
    private c.InterfaceC0201c fwF;
    private PbFullScreenFloatingHuajiAninationView fwH;
    private com.baidu.adp.lib.guide.c fwJ;
    private Bitmap fwK;
    private boolean fwL;
    private int fwN;
    private RelativeLayout fwi;
    private com.baidu.tieba.pb.pb.main.view.b fwj;
    private CustomFrameLayout fwk;
    private c.InterfaceC0201c fwl;
    private y fwn;
    private g fwo;
    private boolean fwp;
    private bd fwq;
    private bd fwr;
    private String fws;
    private float fwy;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String baI = null;
    private VideoInfo fwm = null;
    private boolean fwt = false;
    private int fwu = 0;
    private boolean fwv = false;
    private int fww = 0;
    private int fwx = 0;
    private boolean fwz = false;
    private boolean fwA = false;
    private boolean fwG = true;
    private PbFullScreenFloatingHuajiAninationView.a fwI = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.kL(false);
        }
    };
    private c.l fwM = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void bcA() {
            if (i.this.fgM.checkUpIsLogin()) {
                i.this.fgM.aXz();
                if (i.this.fgM.aWx() != null && i.this.fgM.aWx().getPbData() != null && i.this.fgM.aWx().getPbData().aVO() != null) {
                    j aVO = i.this.fgM.aWx().getPbData().aVO();
                    if (i.this.fwH == null) {
                        i.this.fwH = new PbFullScreenFloatingHuajiAninationView(i.this.fgM.getActivity());
                        i.this.fwH.setFloatingHuajiAninationListener(i.this.fwI);
                    }
                    i.this.fwH.kN(!aVO.aVW());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.daY != null) {
                    i.this.daY.bfY();
                }
                if (com.baidu.adp.lib.util.j.gP() && com.baidu.adp.lib.util.j.gR() && i.this.daY != null && i.this.daY.bga() && i.this.fwm != null && i.this.fwm.video_length.intValue() > 0 && i.this.fwm.video_duration.intValue() > 0) {
                    float intValue = i.this.fwm.video_length.intValue() * (1.0f - ((i.this.daY.getCurrentPosition() * 1.0f) / (i.this.fwm.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fgM.getPageContext().getPageActivity(), String.format(i.this.fgM.getPageContext().getString(d.k.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener exA = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
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
    private VideoControllerView.a ezz = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Ng() {
        }
    };
    private c.h fwO = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void ara() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kL(boolean z) {
        if (this.fgM.aWx() != null && this.fgM.aWx().getPbData() != null && this.fgM.aWx().getPbData().aVO() != null) {
            j aVO = this.fgM.aWx().getPbData().aVO();
            View findViewById = this.fgM.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aVO.aVW() || z) {
                this.fgM.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fgM.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVO.aVW() ? 0 : 1));
            } else if (aVO.aVW()) {
                if (aVO.fcG == 1 || aVO.fcG == 3 || aVO.fcG == 4) {
                    this.fgM.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fgM.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVO.aVW() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fwy = 0.0f;
        this.fgM = pbActivity;
        this.fwj = bVar;
        this.fwy = l.e(this.fgM.getActivity(), d.e.ds240);
        this.fwD = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int af = l.af(this.fgM.getActivity());
        Rect u = ay.u(this.fgM.getPageContext().getPageActivity());
        int ah = u.height() <= 0 ? l.ah(this.fgM.getActivity()) : u.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fwC = (intValue2 * 1.0d) / intValue;
            if (this.fwC > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.fwB = i;
        this.fwk.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fwi = (RelativeLayout) LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.video_pb_container_layout, (ViewGroup) null);
        this.fwk = (CustomFrameLayout) this.fwi.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.daY = new com.baidu.tieba.play.c(this.fgM.getPageContext(), this.fwk, true);
        this.daY.a(this.fwM);
        this.daY.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fgM.xj() != null && i.this.fgM.xj().getChildCount() > 0 && i.this.fgM.xj().getChildAt(0) == i.this.bcy()) {
                            i.this.fwN = i.this.bcy().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fwN = 0;
                        break;
                    case 2:
                        if (i.this.fgM.xj() != null && i.this.fgM.xj().getChildCount() > 0 && i.this.fgM.xj().getChildAt(0) == i.this.bcy()) {
                            i.this.fgM.xj().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fwN);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fwC >= 1.0d) {
                this.daY.K(false, true);
            } else {
                this.daY.K(true, false);
            }
            this.fwz = ((float) b) + this.fwy > ((float) l.ah(this.fgM.getActivity()));
            if (this.fwz) {
                if (this.fwo == null) {
                    this.fwo = new g(this.fgM.getPageContext(), this.fwk);
                    this.fwo.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            i.this.kL(true);
                        }
                    });
                }
                this.fgM.aWO().baA();
                this.fwp = true;
            }
        }
        bcr();
        this.mEmptyView = new View(this.fgM);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fwB));
        if (this.fwj != null && this.fwj.mNavigationBar != null) {
            this.fwj.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fwj.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fwj.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fwE = (PbVideoWifiTipLayout) this.fwi.findViewById(d.g.layout_wifi_tip);
        this.fwE.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.fwL = true;
                i.this.fwE.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fgM.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fwl == null) {
            this.fwl = new c.InterfaceC0201c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (i.this.bcu() && i.this.fwj != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fwj.bbf().clearAnimation();
                        i.this.bcs();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.exA);
                            i.this.fwj.bbf().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void aqZ() {
                    if (i.this.bcu()) {
                        i.this.bbl();
                    }
                }
            };
        }
        a(this.fwl);
        this.fwu = UtilHelper.getLightStatusBarHeight() + l.e(this.fgM.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.daY != null && bdVar != null) {
            this.fwm = videoInfo;
            this.fwq = bdVar;
            this.baI = videoInfo.video_url;
            this.daY.stopPlay();
            this.daY.ln(true);
            this.bkR = new n(this.fgM.getActivity());
            this.fwn = new y();
            this.fwn.mLocate = "pb";
            this.fwn.aNu = bdVar.getTid();
            this.fwn.crJ = str;
            this.fwn.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fwn.mSource = bdVar.mRecomSource;
            this.fwn.fQN = bdVar.mRecomWeight;
            this.fwn.fQO = this.fgM.aWM();
            this.fwn.fQP = bdVar.mRecomAbTag;
            this.fwn.fQQ = videoInfo.video_md5;
            y bhc = this.fwn.bhc();
            bhc.mLocate = "6";
            this.bkR.setVideoStatsData(bhc);
            this.daY.getVideoView().setBusiness(this.bkR);
            if (this.daY.aLA()) {
                this.daY.aLy();
            }
            this.daY.b(this.fwF);
            this.fws = null;
            this.fwr = null;
            this.daY.qU(this.fws);
            this.daY.aLu().setOnDragingListener(this.ezz);
            this.daY.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                    i.this.fgM.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fwG = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    i.this.fgM.setSwipeBackEnabled(false);
                    i.this.fwG = false;
                }
            });
            this.daY.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bcz() {
                    if (i.this.fgM != null && i.this.fwr != null && !StringUtils.isNull(i.this.fwr.getId())) {
                        i.this.fgM.qr(i.this.fwr.getId());
                        if (i.this.fwq != null) {
                            long j = 0;
                            if (i.this.fwq.sQ() != null) {
                                j = i.this.fwq.sQ().channelId;
                            }
                            TiebaStatic.log(new al("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.daY.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void kM(boolean z) {
                    if (i.this.fwq != null) {
                        long j = 0;
                        if (i.this.fwq.sQ() != null) {
                            j = i.this.fwq.sQ().channelId;
                        }
                        i.this.lO(z ? "1" : "2");
                        TiebaStatic.log(new al("c10795").ac("tid", i.this.fwq.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fwq.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.daY.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.baI);
                    return true;
                }
            });
            this.daY.oz(videoInfo.thumbnail_url);
            this.daY.bK(this.baI, bdVar.getTid());
            this.daY.rn(bdVar.getTitle());
            this.daY.a(this.fwO);
            this.daY.ayA();
            this.daY.show();
        }
    }

    public void qT(String str) {
        if (this.fwn != null) {
            this.fwn.crJ = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.fwo != null) {
            this.fwo.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0201c interfaceC0201c) {
        this.fwF = interfaceC0201c;
    }

    public void aj(bd bdVar) {
        this.fwr = bdVar;
    }

    public void qU(String str) {
        this.fws = str;
        if (this.daY != null) {
            this.daY.qU(this.fws);
        }
    }

    public void startPlay() {
        if (this.daY != null) {
            if (com.baidu.adp.lib.util.j.gR() && !this.fwL && !com.baidu.tieba.video.f.bvW().bvX()) {
                this.fwE.setVisibility(0);
                this.fwE.setData(this.fwm);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.baI) && this.fwq != null && this.fwq.sh() != null) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "pb").ac("tid", this.fwq.getTid()));
                this.baI = this.fwq.sh().video_url;
            }
            this.daY.b(this.baI, this.fwq == null ? "" : this.fwq.getTid(), this.fwD);
            lO("2");
        }
    }

    public void bcq() {
        if (this.daY != null) {
            this.daY.bcq();
        }
    }

    public void destroy() {
        if (this.daY != null) {
            this.daY.destroy();
        }
        if (this.fwk != null) {
            this.fwk.clearAnimation();
        }
        if (this.fwo != null) {
            this.fwo.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.daY != null) {
            if (this.daY.bga()) {
                this.fwt = true;
                this.daY.pausePlay();
            } else if (this.daY.bgh() == 3) {
                this.fwt = false;
            } else {
                this.fwt = false;
                this.daY.pausePlay();
            }
            if (this.fwH != null) {
                this.fwH.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.daY != null && this.fwt) {
            this.daY.aLD();
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
                    ImageView imageView = new ImageView(i.this.fgM.getActivity());
                    if (i.this.fwK == null) {
                        try {
                            i.this.fwK = BitmapFactory.decodeResource(i.this.fgM.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fwK);
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
                    i.this.fwJ = null;
                    if (i.this.fwK != null && !i.this.fwK.isRecycled()) {
                        i.this.fwK.recycle();
                    }
                    i.this.fwK = null;
                }
            });
            this.fwJ = dVar.eH();
            this.fwJ.m(this.fgM.getActivity());
        }
    }

    public boolean kq(int i) {
        if (this.daY == null) {
            return false;
        }
        return this.daY.rn(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(String str) {
        if (this.fwm != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fwm.video_md5, "", str, this.fwn);
            }
        }
    }

    public void bcs() {
        if (this.fwj != null) {
            this.fwj.kB(this.fgM.aXy());
        }
    }

    public void bbl() {
        if (this.fwj != null) {
            this.fwj.bbl();
        }
    }

    public void qF(int i) {
        if (this.fwj != null) {
            this.fwj.qF(i);
        }
        if (this.fwH != null) {
            this.fwH.onChangeSkinType(i);
        }
        if (this.fwo != null) {
            this.fwo.dz(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bcv()) {
                    this.fww = i;
                    if (this.fww == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qM(i.this.bcw().getHeight());
                            }
                        }, 100L);
                    }
                    bct();
                    return;
                }
                return;
        }
    }

    private void qL(int i) {
        if (bcw().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwk.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fwB != bcw().getHeight()) {
                        this.fwk.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.fgM.getActivity()), Math.min(this.fwB, bcw().getHeight() + i)));
                        this.daY.aLy();
                    }
                } else if (l.af(this.fgM.getActivity()) * 0.5625d != bcw().getHeight()) {
                    this.fwk.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.fgM.getActivity()), (int) Math.max(l.af(this.fgM.getActivity()) * 0.5625d, bcw().getHeight() + i)));
                    this.daY.aLy();
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
                qL(bottom);
            } else {
                qL((-this.fwB) + 2);
            }
        }
        if (!bcv() && this.fwG) {
            if (this.fww == 1) {
                qM(bcw().getHeight());
            } else if (this.fww == 2) {
                int y = (int) bcw().getY();
                if (this.fwx == y) {
                    qM(bcw().getHeight());
                } else {
                    this.fwx = y;
                    qM(bcw().getHeight());
                }
                if (i == 0 && this.fwA) {
                    this.fwA = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bcq();
                        }
                    }, 100L);
                }
            } else if (this.fww == 0) {
                qM(bcw().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(int i) {
        qN(i);
        bct();
    }

    private void qN(int i) {
        if (this.fwo != null) {
            if (i == 0) {
                i = this.fwB;
            }
            float f = this.fwB - i;
            float f2 = f > this.fwy ? 0.0f : 1.0f - (f / this.fwy);
            if (f2 == 0.0f) {
                this.fwo.bcm().setVisibility(8);
            } else {
                this.fwo.bcm().setVisibility(0);
            }
            this.fwo.ah(f2);
        }
    }

    public void bct() {
        if (this.fwo != null) {
            if (bcv()) {
                this.fgM.aWO().baA();
            } else if (this.fwo.bcm().getVisibility() == 0) {
                this.fgM.aWO().baA();
                this.fwp = true;
            } else if (this.fwp) {
                this.fgM.aWO().kn(false);
                this.fwp = false;
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
        this.fwv = false;
        if (this.daY != null && this.fwk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwk.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fwJ != null) {
                    this.fwJ.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fwv = true;
                this.fwk.setLayoutParams(layoutParams);
                this.fgM.aWO().baA();
                this.fwp = true;
            } else {
                b(this.fwm);
                bcs();
                this.fwv = false;
                this.fwj.kA(true);
            }
            this.daY.a(this.fgM.getPageContext(), configuration);
        }
    }

    public boolean bcv() {
        return this.fwv;
    }

    public void z(long j, int i) {
        if (this.fwo != null && j > 0) {
            this.fwo.n(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fwo != null) {
            this.fwo.J(onClickListener);
        }
    }

    public View bcw() {
        return this.fwi;
    }

    public boolean baJ() {
        if (bcw() == null) {
            return false;
        }
        return bcw().getBottom() > l.ah(bcw().getContext()) - l.e(bcw().getContext(), d.e.ds50);
    }

    public void bcx() {
        this.fwA = true;
    }

    public View bcy() {
        return this.mEmptyView;
    }
}
