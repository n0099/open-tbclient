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
    private com.baidu.tieba.play.c daV;
    private PbActivity fgJ;
    private long fwA;
    private PbVideoWifiTipLayout fwB;
    private c.InterfaceC0201c fwC;
    private PbFullScreenFloatingHuajiAninationView fwE;
    private com.baidu.adp.lib.guide.c fwG;
    private Bitmap fwH;
    private boolean fwI;
    private int fwK;
    private RelativeLayout fwf;
    private com.baidu.tieba.pb.pb.main.view.b fwg;
    private CustomFrameLayout fwh;
    private c.InterfaceC0201c fwi;
    private y fwk;
    private g fwl;
    private boolean fwm;
    private bd fwn;
    private bd fwo;
    private String fwp;
    private float fwv;
    private int fwy;
    private double fwz;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String baI = null;
    private VideoInfo fwj = null;
    private boolean fwq = false;
    private int fwr = 0;
    private boolean fws = false;
    private int fwt = 0;
    private int fwu = 0;
    private boolean fww = false;
    private boolean fwx = false;
    private boolean fwD = true;
    private PbFullScreenFloatingHuajiAninationView.a fwF = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.kL(false);
        }
    };
    private c.l fwJ = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void bcA() {
            if (i.this.fgJ.checkUpIsLogin()) {
                i.this.fgJ.aXz();
                if (i.this.fgJ.aWx() != null && i.this.fgJ.aWx().getPbData() != null && i.this.fgJ.aWx().getPbData().aVO() != null) {
                    j aVO = i.this.fgJ.aWx().getPbData().aVO();
                    if (i.this.fwE == null) {
                        i.this.fwE = new PbFullScreenFloatingHuajiAninationView(i.this.fgJ.getActivity());
                        i.this.fwE.setFloatingHuajiAninationListener(i.this.fwF);
                    }
                    i.this.fwE.kN(!aVO.aVW());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.daV != null) {
                    i.this.daV.bfY();
                }
                if (com.baidu.adp.lib.util.j.gP() && com.baidu.adp.lib.util.j.gR() && i.this.daV != null && i.this.daV.bga() && i.this.fwj != null && i.this.fwj.video_length.intValue() > 0 && i.this.fwj.video_duration.intValue() > 0) {
                    float intValue = i.this.fwj.video_length.intValue() * (1.0f - ((i.this.daV.getCurrentPosition() * 1.0f) / (i.this.fwj.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fgJ.getPageContext().getPageActivity(), String.format(i.this.fgJ.getPageContext().getString(d.k.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener exx = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
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
    private VideoControllerView.a ezw = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Ng() {
        }
    };
    private c.h fwL = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void ara() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kL(boolean z) {
        if (this.fgJ.aWx() != null && this.fgJ.aWx().getPbData() != null && this.fgJ.aWx().getPbData().aVO() != null) {
            j aVO = this.fgJ.aWx().getPbData().aVO();
            View findViewById = this.fgJ.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aVO.aVW() || z) {
                this.fgJ.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fgJ.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVO.aVW() ? 0 : 1));
            } else if (aVO.aVW()) {
                if (aVO.fcD == 1 || aVO.fcD == 3 || aVO.fcD == 4) {
                    this.fgJ.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fgJ.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVO.aVW() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fwv = 0.0f;
        this.fgJ = pbActivity;
        this.fwg = bVar;
        this.fwv = l.e(this.fgJ.getActivity(), d.e.ds240);
        this.fwA = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int af = l.af(this.fgJ.getActivity());
        Rect u = ay.u(this.fgJ.getPageContext().getPageActivity());
        int ah = u.height() <= 0 ? l.ah(this.fgJ.getActivity()) : u.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fwz = (intValue2 * 1.0d) / intValue;
            if (this.fwz > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.fwy = i;
        this.fwh.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fwf = (RelativeLayout) LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.video_pb_container_layout, (ViewGroup) null);
        this.fwh = (CustomFrameLayout) this.fwf.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.daV = new com.baidu.tieba.play.c(this.fgJ.getPageContext(), this.fwh, true);
        this.daV.a(this.fwJ);
        this.daV.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fgJ.xj() != null && i.this.fgJ.xj().getChildCount() > 0 && i.this.fgJ.xj().getChildAt(0) == i.this.bcy()) {
                            i.this.fwK = i.this.bcy().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fwK = 0;
                        break;
                    case 2:
                        if (i.this.fgJ.xj() != null && i.this.fgJ.xj().getChildCount() > 0 && i.this.fgJ.xj().getChildAt(0) == i.this.bcy()) {
                            i.this.fgJ.xj().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fwK);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fwz >= 1.0d) {
                this.daV.K(false, true);
            } else {
                this.daV.K(true, false);
            }
            this.fww = ((float) b) + this.fwv > ((float) l.ah(this.fgJ.getActivity()));
            if (this.fww) {
                if (this.fwl == null) {
                    this.fwl = new g(this.fgJ.getPageContext(), this.fwh);
                    this.fwl.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            i.this.kL(true);
                        }
                    });
                }
                this.fgJ.aWO().baA();
                this.fwm = true;
            }
        }
        bcr();
        this.mEmptyView = new View(this.fgJ);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fwy));
        if (this.fwg != null && this.fwg.mNavigationBar != null) {
            this.fwg.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fwg.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fwg.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fwB = (PbVideoWifiTipLayout) this.fwf.findViewById(d.g.layout_wifi_tip);
        this.fwB.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.fwI = true;
                i.this.fwB.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fgJ.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fwi == null) {
            this.fwi = new c.InterfaceC0201c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0201c
                public void fG(boolean z) {
                    if (i.this.bcu() && i.this.fwg != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fwg.bbf().clearAnimation();
                        i.this.bcs();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.exx);
                            i.this.fwg.bbf().startAnimation(loadAnimation);
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
        a(this.fwi);
        this.fwr = UtilHelper.getLightStatusBarHeight() + l.e(this.fgJ.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.daV != null && bdVar != null) {
            this.fwj = videoInfo;
            this.fwn = bdVar;
            this.baI = videoInfo.video_url;
            this.daV.stopPlay();
            this.daV.ln(true);
            this.bkR = new n(this.fgJ.getActivity());
            this.fwk = new y();
            this.fwk.mLocate = "pb";
            this.fwk.aNu = bdVar.getTid();
            this.fwk.crG = str;
            this.fwk.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fwk.mSource = bdVar.mRecomSource;
            this.fwk.fQK = bdVar.mRecomWeight;
            this.fwk.fQL = this.fgJ.aWM();
            this.fwk.fQM = bdVar.mRecomAbTag;
            this.fwk.fQN = videoInfo.video_md5;
            y bhc = this.fwk.bhc();
            bhc.mLocate = "6";
            this.bkR.setVideoStatsData(bhc);
            this.daV.getVideoView().setBusiness(this.bkR);
            if (this.daV.aLA()) {
                this.daV.aLy();
            }
            this.daV.b(this.fwC);
            this.fwp = null;
            this.fwo = null;
            this.daV.qU(this.fwp);
            this.daV.aLu().setOnDragingListener(this.ezw);
            this.daV.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void aqW() {
                    i.this.fgJ.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fwD = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aqV() {
                    i.this.fgJ.setSwipeBackEnabled(false);
                    i.this.fwD = false;
                }
            });
            this.daV.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bcz() {
                    if (i.this.fgJ != null && i.this.fwo != null && !StringUtils.isNull(i.this.fwo.getId())) {
                        i.this.fgJ.qr(i.this.fwo.getId());
                        if (i.this.fwn != null) {
                            long j = 0;
                            if (i.this.fwn.sQ() != null) {
                                j = i.this.fwn.sQ().channelId;
                            }
                            TiebaStatic.log(new al("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.daV.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void kM(boolean z) {
                    if (i.this.fwn != null) {
                        long j = 0;
                        if (i.this.fwn.sQ() != null) {
                            j = i.this.fwn.sQ().channelId;
                        }
                        i.this.lO(z ? "1" : "2");
                        TiebaStatic.log(new al("c10795").ac("tid", i.this.fwn.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fwn.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.daV.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.baI);
                    return true;
                }
            });
            this.daV.oz(videoInfo.thumbnail_url);
            this.daV.bK(this.baI, bdVar.getTid());
            this.daV.rn(bdVar.getTitle());
            this.daV.a(this.fwL);
            this.daV.ayA();
            this.daV.show();
        }
    }

    public void qT(String str) {
        if (this.fwk != null) {
            this.fwk.crG = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.fwl != null) {
            this.fwl.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0201c interfaceC0201c) {
        this.fwC = interfaceC0201c;
    }

    public void aj(bd bdVar) {
        this.fwo = bdVar;
    }

    public void qU(String str) {
        this.fwp = str;
        if (this.daV != null) {
            this.daV.qU(this.fwp);
        }
    }

    public void startPlay() {
        if (this.daV != null) {
            if (com.baidu.adp.lib.util.j.gR() && !this.fwI && !com.baidu.tieba.video.f.bvW().bvX()) {
                this.fwB.setVisibility(0);
                this.fwB.setData(this.fwj);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.baI) && this.fwn != null && this.fwn.sh() != null) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "pb").ac("tid", this.fwn.getTid()));
                this.baI = this.fwn.sh().video_url;
            }
            this.daV.b(this.baI, this.fwn == null ? "" : this.fwn.getTid(), this.fwA);
            lO("2");
        }
    }

    public void bcq() {
        if (this.daV != null) {
            this.daV.bcq();
        }
    }

    public void destroy() {
        if (this.daV != null) {
            this.daV.destroy();
        }
        if (this.fwh != null) {
            this.fwh.clearAnimation();
        }
        if (this.fwl != null) {
            this.fwl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.daV != null) {
            if (this.daV.bga()) {
                this.fwq = true;
                this.daV.pausePlay();
            } else if (this.daV.bgh() == 3) {
                this.fwq = false;
            } else {
                this.fwq = false;
                this.daV.pausePlay();
            }
            if (this.fwE != null) {
                this.fwE.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.daV != null && this.fwq) {
            this.daV.aLD();
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
                    ImageView imageView = new ImageView(i.this.fgJ.getActivity());
                    if (i.this.fwH == null) {
                        try {
                            i.this.fwH = BitmapFactory.decodeResource(i.this.fgJ.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fwH);
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
                    i.this.fwG = null;
                    if (i.this.fwH != null && !i.this.fwH.isRecycled()) {
                        i.this.fwH.recycle();
                    }
                    i.this.fwH = null;
                }
            });
            this.fwG = dVar.eH();
            this.fwG.m(this.fgJ.getActivity());
        }
    }

    public boolean kq(int i) {
        if (this.daV == null) {
            return false;
        }
        return this.daV.rn(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(String str) {
        if (this.fwj != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fwj.video_md5, "", str, this.fwk);
            }
        }
    }

    public void bcs() {
        if (this.fwg != null) {
            this.fwg.kB(this.fgJ.aXy());
        }
    }

    public void bbl() {
        if (this.fwg != null) {
            this.fwg.bbl();
        }
    }

    public void qF(int i) {
        if (this.fwg != null) {
            this.fwg.qF(i);
        }
        if (this.fwE != null) {
            this.fwE.onChangeSkinType(i);
        }
        if (this.fwl != null) {
            this.fwl.dz(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bcv()) {
                    this.fwt = i;
                    if (this.fwt == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwh.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fwy != bcw().getHeight()) {
                        this.fwh.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.fgJ.getActivity()), Math.min(this.fwy, bcw().getHeight() + i)));
                        this.daV.aLy();
                    }
                } else if (l.af(this.fgJ.getActivity()) * 0.5625d != bcw().getHeight()) {
                    this.fwh.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.fgJ.getActivity()), (int) Math.max(l.af(this.fgJ.getActivity()) * 0.5625d, bcw().getHeight() + i)));
                    this.daV.aLy();
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
                qL((-this.fwy) + 2);
            }
        }
        if (!bcv() && this.fwD) {
            if (this.fwt == 1) {
                qM(bcw().getHeight());
            } else if (this.fwt == 2) {
                int y = (int) bcw().getY();
                if (this.fwu == y) {
                    qM(bcw().getHeight());
                } else {
                    this.fwu = y;
                    qM(bcw().getHeight());
                }
                if (i == 0 && this.fwx) {
                    this.fwx = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bcq();
                        }
                    }, 100L);
                }
            } else if (this.fwt == 0) {
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
        if (this.fwl != null) {
            if (i == 0) {
                i = this.fwy;
            }
            float f = this.fwy - i;
            float f2 = f > this.fwv ? 0.0f : 1.0f - (f / this.fwv);
            if (f2 == 0.0f) {
                this.fwl.bcm().setVisibility(8);
            } else {
                this.fwl.bcm().setVisibility(0);
            }
            this.fwl.ah(f2);
        }
    }

    public void bct() {
        if (this.fwl != null) {
            if (bcv()) {
                this.fgJ.aWO().baA();
            } else if (this.fwl.bcm().getVisibility() == 0) {
                this.fgJ.aWO().baA();
                this.fwm = true;
            } else if (this.fwm) {
                this.fgJ.aWO().kn(false);
                this.fwm = false;
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
        this.fws = false;
        if (this.daV != null && this.fwh != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwh.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fwG != null) {
                    this.fwG.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fws = true;
                this.fwh.setLayoutParams(layoutParams);
                this.fgJ.aWO().baA();
                this.fwm = true;
            } else {
                b(this.fwj);
                bcs();
                this.fws = false;
                this.fwg.kA(true);
            }
            this.daV.a(this.fgJ.getPageContext(), configuration);
        }
    }

    public boolean bcv() {
        return this.fws;
    }

    public void z(long j, int i) {
        if (this.fwl != null && j > 0) {
            this.fwl.n(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fwl != null) {
            this.fwl.J(onClickListener);
        }
    }

    public View bcw() {
        return this.fwf;
    }

    public boolean baJ() {
        if (bcw() == null) {
            return false;
        }
        return bcw().getBottom() > l.ah(bcw().getContext()) - l.e(bcw().getContext(), d.e.ds50);
    }

    public void bcx() {
        this.fwx = true;
    }

    public View bcy() {
        return this.mEmptyView;
    }
}
