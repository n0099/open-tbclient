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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.c;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.v;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private n bYC;
    private com.baidu.tieba.play.c dAp;
    private PbActivity fHW;
    private RelativeLayout fWR;
    private com.baidu.tieba.pb.pb.main.view.c fWS;
    private CustomFrameLayout fWT;
    private c.InterfaceC0149c fWU;
    private aa fWW;
    private g fWX;
    private boolean fWY;
    private be fWZ;
    private be fXa;
    private String fXb;
    private float fXh;
    private int fXk;
    private double fXl;
    private long fXm;
    private PbVideoWifiTipLayout fXn;
    private c.InterfaceC0149c fXo;
    private com.baidu.tieba.pb.view.c fXq;
    private com.baidu.adp.lib.guide.c fXs;
    private Bitmap fXt;
    private boolean fXu;
    private int fXw;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bOw = null;
    private VideoInfo fWV = null;
    private boolean fXc = false;
    private int fXd = 0;
    private boolean fXe = false;
    private int fXf = 0;
    private int fXg = 0;
    private boolean fXi = false;
    private boolean fXj = false;
    private boolean fXp = true;
    private c.a fXr = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kW(false);
        }
    };
    private c.k fXv = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void bfU() {
            if (i.this.fHW.checkUpIsLogin()) {
                i.this.fHW.baQ();
                if (i.this.fHW.aZK() != null && i.this.fHW.aZK().getPbData() != null && i.this.fHW.aZK().getPbData().aYY() != null) {
                    l aYY = i.this.fHW.aZK().getPbData().aYY();
                    if (i.this.fXq == null) {
                        i.this.fXq = new com.baidu.tieba.pb.view.c(i.this.fHW.getActivity());
                        i.this.fXq.setFloatingHuajiAninationListener(i.this.fXr);
                    }
                    i.this.fXq.kY(!aYY.aZj());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dAp != null) {
                    i.this.dAp.bqn();
                }
                if (j.oI() && j.oK() && i.this.dAp != null && i.this.dAp.bqp() && i.this.fWV != null && i.this.fWV.video_length.intValue() > 0 && i.this.fWV.video_duration.intValue() > 0) {
                    float intValue = i.this.fWV.video_length.intValue() * (1.0f - ((i.this.dAp.getCurrentPosition() * 1.0f) / (i.this.fWV.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(i.this.fHW.getPageContext().getPageActivity(), String.format(i.this.fHW.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eVG = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.beE();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private v.a eYu = new v.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.v.a
        public void TX() {
        }
    };
    private c.g fXx = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void auB() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (this.fHW.aZK() != null && this.fHW.aZK().getPbData() != null && this.fHW.aZK().getPbData().aYY() != null) {
            l aYY = this.fHW.aZK().getPbData().aYY();
            View findViewById = this.fHW.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aYY.aZj() || z) {
                this.fHW.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fHW.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aYY.aZj() ? 0 : 1));
            } else if (aYY.aZj()) {
                if (aYY.fCF == 1 || aYY.fCF == 3 || aYY.fCF == 4) {
                    this.fHW.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fHW.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aYY.aZj() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fXh = 0.0f;
        this.fHW = pbActivity;
        this.fWS = cVar;
        this.fXh = com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds240);
        this.fXm = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ao = com.baidu.adp.lib.util.l.ao(this.fHW.getActivity());
        Rect t = aw.t(this.fHW.getPageContext().getPageActivity());
        int aq = t.height() <= 0 ? com.baidu.adp.lib.util.l.aq(this.fHW.getActivity()) : t.height();
        int i = (int) (ao * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fXl = (intValue2 * 1.0d) / intValue;
            if (this.fXl > 0.5625d) {
                i = Math.min((ao * intValue2) / intValue, aq);
            }
        }
        this.fXk = i;
        this.fWT.setLayoutParams(new RelativeLayout.LayoutParams(ao, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fWR = (RelativeLayout) LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fWT = (CustomFrameLayout) this.fWR.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dAp = new com.baidu.tieba.play.c(this.fHW.getPageContext(), this.fWT, true);
        this.dAp.a(this.fXv);
        this.dAp.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // com.baidu.tieba.play.c.i
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.i
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.i
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.fHW.getListView() != null && i.this.fHW.getListView().getChildCount() > 0 && i.this.fHW.getListView().getChildAt(0) == i.this.bfS()) {
                            i.this.fXw = i.this.bfS().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fXw = 0;
                        break;
                    case 2:
                        if (i.this.fHW.getListView() != null && i.this.fHW.getListView().getChildCount() > 0 && i.this.fHW.getListView().getChildAt(0) == i.this.bfS()) {
                            i.this.fHW.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fXw);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fXl >= 1.0d) {
                this.dAp.my(false);
            } else {
                this.dAp.my(true);
            }
            this.fXi = ((float) b) + this.fXh > ((float) com.baidu.adp.lib.util.l.aq(this.fHW.getActivity()));
            if (this.fXi) {
                if (this.fWX == null) {
                    this.fWX = new g(this.fHW.getPageContext(), this.fWT);
                    this.fWX.I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kW(true);
                        }
                    });
                }
                this.fHW.bad().bdT();
                this.fWY = true;
            }
        }
        bfL();
        this.mEmptyView = new View(this.fHW);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fXk));
        if (this.fWS != null && this.fWS.mNavigationBar != null) {
            this.fWS.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fWS.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fWS.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fXn = (PbVideoWifiTipLayout) this.fWR.findViewById(d.g.layout_wifi_tip);
        this.fXn.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fXu = true;
                i.this.fXn.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fHW.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fWU == null) {
            this.fWU = new c.InterfaceC0149c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0149c
                public void fO(boolean z) {
                    if (i.this.bfO() && i.this.fWS != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fWS.bey().clearAnimation();
                        i.this.bfM();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eVG);
                            i.this.fWS.bey().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0149c
                public void auA() {
                    if (i.this.bfO()) {
                        i.this.beE();
                    }
                }
            };
        }
        a(this.fWU);
        this.fXd = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, be beVar, String str) {
        if (videoInfo != null && this.dAp != null && beVar != null) {
            this.fWV = videoInfo;
            this.fWZ = beVar;
            this.bOw = videoInfo.video_url;
            this.dAp.stopPlay();
            this.dAp.mv(true);
            this.bYC = new n(this.fHW.getActivity());
            this.fWW = new aa();
            this.fWW.mLocate = "pb";
            this.fWW.bAK = beVar.getTid();
            this.fWW.cSk = str;
            this.fWW.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fWW.mSource = beVar.mRecomSource;
            this.fWW.gEP = beVar.mRecomWeight;
            this.fWW.gEQ = this.fHW.bab();
            this.fWW.gER = beVar.mRecomAbTag;
            this.fWW.gES = videoInfo.video_md5;
            aa brp = this.fWW.brp();
            brp.mLocate = "6";
            this.bYC.setVideoStatsData(brp);
            this.dAp.getVideoView().setBusiness(this.bYC);
            if (this.dAp.aOE()) {
                this.dAp.aOC();
            }
            this.dAp.b(this.fXo);
            this.fXb = null;
            this.fXa = null;
            this.dAp.qy(this.fXb);
            this.dAp.aOy().setOnDragingListener(this.eYu);
            this.dAp.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void aux() {
                    i.this.fHW.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fXp = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void auw() {
                    i.this.fHW.setSwipeBackEnabled(false);
                    i.this.fXp = false;
                }
            });
            this.dAp.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void bfT() {
                    if (i.this.fHW != null && i.this.fXa != null && !StringUtils.isNull(i.this.fXa.getId())) {
                        i.this.fHW.pS(i.this.fXa.getId());
                        if (i.this.fWZ != null) {
                            long j = 0;
                            if (i.this.fWZ.Ac() != null) {
                                j = i.this.fWZ.Ac().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.dAp.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void kX(boolean z) {
                    if (i.this.fWZ != null) {
                        long j = 0;
                        if (i.this.fWZ.Ac() != null) {
                            j = i.this.fWZ.Ac().channelId;
                        }
                        i.this.lm(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ab("tid", i.this.fWZ.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fWZ.getFid()).f("obj_id", j));
                    }
                }
            });
            this.dAp.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bOw);
                    return true;
                }
            });
            this.dAp.nY(videoInfo.thumbnail_url);
            this.dAp.bP(this.bOw, beVar.getTid());
            this.dAp.ry(beVar.getTitle());
            this.dAp.a(this.fXx);
            this.dAp.aBY();
            this.dAp.show();
        }
    }

    public void qx(String str) {
        if (this.fWW != null) {
            this.fWW.cSk = str;
        }
    }

    public void b(PostData postData, be beVar, l lVar) {
        if (this.fWX != null) {
            this.fWX.a(postData, beVar, lVar);
        }
    }

    public void a(c.InterfaceC0149c interfaceC0149c) {
        this.fXo = interfaceC0149c;
    }

    public void ae(be beVar) {
        this.fXa = beVar;
    }

    public void qy(String str) {
        this.fXb = str;
        if (this.dAp != null) {
            this.dAp.qy(this.fXb);
        }
    }

    public void startPlay() {
        if (this.dAp != null) {
            if (j.oK() && !this.fXu) {
                this.fXn.setVisibility(0);
                this.fXn.setData(this.fWV);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bOw) && this.fWZ != null && this.fWZ.zp() != null) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "pb").ab("tid", this.fWZ.getTid()));
                this.bOw = this.fWZ.zp().video_url;
            }
            this.dAp.c(this.bOw, this.fWZ == null ? "" : this.fWZ.getTid(), this.fXm);
            lm("2");
        }
    }

    public void bfK() {
        if (this.dAp != null) {
            this.dAp.bfK();
        }
    }

    public void destroy() {
        if (this.dAp != null) {
            this.dAp.destroy();
        }
        if (this.fWT != null) {
            this.fWT.clearAnimation();
        }
        if (this.fWX != null) {
            this.fWX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dAp != null) {
            if (this.dAp.bqp()) {
                this.fXc = true;
                this.dAp.pausePlay();
            } else if (this.dAp.bqv() == 3) {
                this.fXc = false;
            } else {
                this.fXc = false;
                this.dAp.pausePlay();
            }
            if (this.fXq != null) {
                this.fXq.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dAp != null && this.fXc) {
            this.dAp.aOH();
        }
    }

    private void bfL() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.af(true);
            dVar.ah(false);
            dVar.cX(16908290).cW(153).ag(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fHW.getActivity());
                    if (i.this.fXt == null) {
                        try {
                            i.this.fXt = BitmapFactory.decodeResource(i.this.fHW.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fXt);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int mA() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int mB() {
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
                public void bL() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fXs = null;
                    if (i.this.fXt != null && !i.this.fXt.isRecycled()) {
                        i.this.fXt.recycle();
                    }
                    i.this.fXt = null;
                }
            });
            this.fXs = dVar.mC();
            this.fXs.k(this.fHW.getActivity());
        }
    }

    public boolean nb(int i) {
        if (this.dAp == null) {
            return false;
        }
        return this.dAp.vq(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(String str) {
        if (this.fWV != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fWV.video_md5, "", str, this.fWW);
            }
        }
    }

    public void bfM() {
        if (this.fWS != null) {
            this.fWS.kL(this.fHW.baP());
        }
    }

    public void beE() {
        if (this.fWS != null) {
            this.fWS.beE();
        }
    }

    public void tn(int i) {
        if (this.fWS != null) {
            this.fWS.tn(i);
        }
        if (this.fXq != null) {
            this.fXq.onChangeSkinType(i);
        }
        if (this.fWX != null) {
            this.fWX.gC(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bfP()) {
                    this.fXf = i;
                    if (this.fXf == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tt(i.this.bfQ().getHeight());
                            }
                        }, 100L);
                    }
                    bfN();
                    return;
                }
                return;
        }
    }

    private void ts(int i) {
        if (bfQ().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWT.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fXk != bfQ().getHeight()) {
                        this.fWT.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ao(this.fHW.getActivity()), Math.min(this.fXk, bfQ().getHeight() + i)));
                        this.dAp.aOC();
                    }
                } else if (com.baidu.adp.lib.util.l.ao(this.fHW.getActivity()) * 0.5625d != bfQ().getHeight()) {
                    this.fWT.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ao(this.fHW.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ao(this.fHW.getActivity()) * 0.5625d, bfQ().getHeight() + i)));
                    this.dAp.aOC();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bfS()) {
                int bottom = childAt.getBottom() - bfQ().getBottom();
                if (childAt.getHeight() == 0 || bfQ().getHeight() == 0) {
                    bottom = 0;
                }
                ts(bottom);
            } else {
                ts((-this.fXk) + 2);
            }
        }
        if (!bfP() && this.fXp) {
            if (this.fXf == 1) {
                tt(bfQ().getHeight());
            } else if (this.fXf == 2) {
                int y = (int) bfQ().getY();
                if (this.fXg == y) {
                    tt(bfQ().getHeight());
                } else {
                    this.fXg = y;
                    tt(bfQ().getHeight());
                }
                if (i == 0 && this.fXj) {
                    this.fXj = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bfK();
                        }
                    }, 100L);
                }
            } else if (this.fXf == 0) {
                tt(bfQ().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i) {
        tu(i);
        bfN();
    }

    private void tu(int i) {
        if (this.fWX != null) {
            if (i == 0) {
                i = this.fXk;
            }
            float f = this.fXk - i;
            float f2 = f > this.fXh ? 0.0f : 1.0f - (f / this.fXh);
            if (f2 == 0.0f) {
                this.fWX.bfG().setVisibility(8);
            } else {
                this.fWX.bfG().setVisibility(0);
            }
            this.fWX.ao(f2);
        }
    }

    public void bfN() {
        if (this.fWX != null) {
            if (bfP()) {
                this.fHW.bad().bdT();
            } else if (this.fWX.bfG().getVisibility() == 0) {
                this.fHW.bad().bdT();
                this.fWY = true;
            } else if (this.fWY) {
                this.fHW.bad().ky(false);
                this.fWY = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfO() {
        return bfQ().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fXe = false;
        if (this.dAp != null && this.fWT != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWT.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.fXs != null) {
                    this.fXs.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fXe = true;
                this.fWT.setLayoutParams(layoutParams);
                this.fHW.bad().bdT();
                this.fWY = true;
            } else {
                b(this.fWV);
                bfM();
                this.fXe = false;
                this.fWS.setTitleVisibility(true);
            }
            this.dAp.a(this.fHW.getPageContext(), configuration);
        }
    }

    public boolean bfP() {
        return this.fXe;
    }

    public void y(long j, int i) {
        if (this.fWX != null && j > 0) {
            this.fWX.l(i, j);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fWX != null) {
            this.fWX.H(onClickListener);
        }
    }

    public View bfQ() {
        return this.fWR;
    }

    public boolean bee() {
        if (bfQ() == null) {
            return false;
        }
        return bfQ().getBottom() > com.baidu.adp.lib.util.l.aq(bfQ().getContext()) - com.baidu.adp.lib.util.l.s(bfQ().getContext(), d.e.ds50);
    }

    public void bfR() {
        this.fXj = true;
    }

    public View bfS() {
        return this.mEmptyView;
    }
}
