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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.c;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private n blm;
    private com.baidu.tieba.play.c cKW;
    private PbActivity eUm;
    private RelativeLayout fiS;
    private com.baidu.tieba.pb.pb.main.view.c fiT;
    private CustomFrameLayout fiU;
    private c.InterfaceC0122c fiV;
    private y fiX;
    private g fiY;
    private boolean fiZ;
    private bd fja;
    private bd fjb;
    private String fjc;
    private float fji;
    private int fjl;
    private double fjm;
    private long fjn;
    private PbVideoWifiTipLayout fjo;
    private c.InterfaceC0122c fjp;
    private com.baidu.tieba.pb.view.c fjr;
    private com.baidu.adp.lib.guide.c fjt;
    private Bitmap fju;
    private boolean fjv;
    private int fjx;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String baH = null;
    private VideoInfo fiW = null;
    private boolean fjd = false;
    private int fje = 0;
    private boolean fjf = false;
    private int fjg = 0;
    private int fjh = 0;
    private boolean fjj = false;
    private boolean fjk = false;
    private boolean fjq = true;
    private c.a fjs = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.ks(false);
        }
    };
    private c.k fjw = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void aYw() {
            if (i.this.eUm.checkUpIsLogin()) {
                i.this.eUm.aTv();
                if (i.this.eUm.aSo() != null && i.this.eUm.aSo().getPbData() != null && i.this.eUm.aSo().getPbData().aRD() != null) {
                    l aRD = i.this.eUm.aSo().getPbData().aRD();
                    if (i.this.fjr == null) {
                        i.this.fjr = new com.baidu.tieba.pb.view.c(i.this.eUm.getActivity());
                        i.this.fjr.setFloatingHuajiAninationListener(i.this.fjs);
                    }
                    i.this.fjr.ku(!aRD.aRN());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.cKW != null) {
                    i.this.cKW.biL();
                }
                if (j.hh() && j.hj() && i.this.cKW != null && i.this.cKW.biN() && i.this.fiW != null && i.this.fiW.video_length.intValue() > 0 && i.this.fiW.video_duration.intValue() > 0) {
                    float intValue = i.this.fiW.video_length.intValue() * (1.0f - ((i.this.cKW.getCurrentPosition() * 1.0f) / (i.this.fiW.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(i.this.eUm.getPageContext().getPageActivity(), String.format(i.this.eUm.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eis = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aXg();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private u.a elf = new u.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.u.a
        public void My() {
        }
    };
    private c.g fjy = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void amL() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(boolean z) {
        if (this.eUm.aSo() != null && this.eUm.aSo().getPbData() != null && this.eUm.aSo().getPbData().aRD() != null) {
            l aRD = this.eUm.aSo().getPbData().aRD();
            View findViewById = this.eUm.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aRD.aRN() || z) {
                this.eUm.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.eUm.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRD.aRN() ? 0 : 1));
            } else if (aRD.aRN()) {
                if (aRD.eOX == 1 || aRD.eOX == 3 || aRD.eOX == 4) {
                    this.eUm.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.eUm.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRD.aRN() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fji = 0.0f;
        this.eUm = pbActivity;
        this.fiT = cVar;
        this.fji = com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds240);
        this.fjn = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ac = com.baidu.adp.lib.util.l.ac(this.eUm.getActivity());
        Rect t = aw.t(this.eUm.getPageContext().getPageActivity());
        int ae = t.height() <= 0 ? com.baidu.adp.lib.util.l.ae(this.eUm.getActivity()) : t.height();
        int i = (int) (ac * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fjm = (intValue2 * 1.0d) / intValue;
            if (this.fjm > 0.5625d) {
                i = Math.min((ac * intValue2) / intValue, ae);
            }
        }
        this.fjl = i;
        this.fiU.setLayoutParams(new RelativeLayout.LayoutParams(ac, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fiS = (RelativeLayout) LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fiU = (CustomFrameLayout) this.fiS.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cKW = new com.baidu.tieba.play.c(this.eUm.getPageContext(), this.fiU);
        this.cKW.a(this.fjw);
        this.cKW.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.eUm.getListView() != null && i.this.eUm.getListView().getChildCount() > 0 && i.this.eUm.getListView().getChildAt(0) == i.this.aYu()) {
                            i.this.fjx = i.this.aYu().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fjx = 0;
                        break;
                    case 2:
                        if (i.this.eUm.getListView() != null && i.this.eUm.getListView().getChildCount() > 0 && i.this.eUm.getListView().getChildAt(0) == i.this.aYu()) {
                            i.this.eUm.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fjx);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fjm >= 1.0d) {
                this.cKW.lT(false);
            } else {
                this.cKW.lT(true);
            }
            this.fjj = ((float) b) + this.fji > ((float) com.baidu.adp.lib.util.l.ae(this.eUm.getActivity()));
            if (this.fjj) {
                if (this.fiY == null) {
                    this.fiY = new g(this.eUm.getPageContext(), this.fiU);
                    this.fiY.I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.ks(true);
                        }
                    });
                }
                this.eUm.aSI().aWv();
                this.fiZ = true;
            }
        }
        aYn();
        this.mEmptyView = new View(this.eUm);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fjl));
        if (this.fiT != null && this.fiT.mNavigationBar != null) {
            this.fiT.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fiT.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fiT.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fjo = (PbVideoWifiTipLayout) this.fiS.findViewById(d.g.layout_wifi_tip);
        this.fjo.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fjv = true;
                i.this.fjo.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eUm.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fiV == null) {
            this.fiV = new c.InterfaceC0122c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0122c
                public void fh(boolean z) {
                    if (i.this.aYq() && i.this.fiT != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fiT.aXb().clearAnimation();
                        i.this.aYo();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eis);
                            i.this.fiT.aXb().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0122c
                public void amK() {
                    if (i.this.aYq()) {
                        i.this.aXg();
                    }
                }
            };
        }
        a(this.fiV);
        this.fje = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.cKW != null && bdVar != null) {
            this.fiW = videoInfo;
            this.fja = bdVar;
            this.baH = videoInfo.video_url;
            this.cKW.stopPlay();
            this.cKW.lQ(true);
            this.blm = new n(this.eUm.getActivity());
            this.fiX = new y();
            this.fiX.mLocate = "pb";
            this.fiX.aMR = bdVar.getTid();
            this.fiX.aAn = str;
            this.fiX.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fiX.mSource = bdVar.aaj;
            this.fiX.fQq = bdVar.aak;
            this.fiX.fQr = this.eUm.aSG();
            this.fiX.fQs = bdVar.aal;
            this.fiX.fQt = videoInfo.video_md5;
            y bjD = this.fiX.bjD();
            bjD.mLocate = "6";
            this.blm.setVideoStatsData(bjD);
            this.cKW.getVideoView().setBusiness(this.blm);
            if (this.cKW.aHv()) {
                this.cKW.aHt();
            }
            this.cKW.b(this.fjp);
            this.fjc = null;
            this.fjb = null;
            this.cKW.qn(this.fjc);
            this.cKW.aHp().setOnDragingListener(this.elf);
            this.cKW.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void amH() {
                    i.this.eUm.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fjq = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void amG() {
                    i.this.eUm.setSwipeBackEnabled(false);
                    i.this.fjq = false;
                }
            });
            this.cKW.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void aYv() {
                    if (i.this.eUm != null && i.this.fjb != null && !StringUtils.isNull(i.this.fjb.getId())) {
                        i.this.eUm.pI(i.this.fjb.getId());
                        if (i.this.fja != null) {
                            long j = 0;
                            if (i.this.fja.sC() != null) {
                                j = i.this.fja.sC().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cKW.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void kt(boolean z) {
                    if (i.this.fja != null) {
                        long j = 0;
                        if (i.this.fja.sC() != null) {
                            j = i.this.fja.sC().channelId;
                        }
                        i.this.lf(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ac("tid", i.this.fja.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fja.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cKW.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.baH);
                    return true;
                }
            });
            this.cKW.nP(videoInfo.thumbnail_url);
            this.cKW.bO(this.baH, bdVar.getTid());
            this.cKW.rm(bdVar.getTitle());
            this.cKW.a(this.fjy);
            this.cKW.auN();
            this.cKW.show();
        }
    }

    public void qm(String str) {
        if (this.fiX != null) {
            this.fiX.aAn = str;
        }
    }

    public void b(PostData postData, bd bdVar, l lVar) {
        if (this.fiY != null) {
            this.fiY.a(postData, bdVar, lVar);
        }
    }

    public void a(c.InterfaceC0122c interfaceC0122c) {
        this.fjp = interfaceC0122c;
    }

    public void ad(bd bdVar) {
        this.fjb = bdVar;
    }

    public void qn(String str) {
        this.fjc = str;
        if (this.cKW != null) {
            this.cKW.qn(this.fjc);
        }
    }

    public void startPlay() {
        if (this.cKW != null) {
            if (j.hj() && !this.fjv) {
                this.fjo.setVisibility(0);
                this.fjo.setData(this.fiW);
                TiebaStatic.log("c12622");
                return;
            }
            this.cKW.d(this.baH, this.fja == null ? "" : this.fja.getTid(), this.fjn);
            lf("2");
        }
    }

    public void aYm() {
        if (this.cKW != null) {
            this.cKW.aYm();
        }
    }

    public void destroy() {
        if (this.cKW != null) {
            this.cKW.destroy();
        }
        if (this.fiU != null) {
            this.fiU.clearAnimation();
        }
        if (this.fiY != null) {
            this.fiY.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.cKW != null) {
            if (this.cKW.biN()) {
                this.fjd = true;
                this.cKW.pausePlay();
            } else if (this.cKW.biT() == 3) {
                this.fjd = false;
            } else {
                this.fjd = false;
                this.cKW.pausePlay();
            }
            if (this.fjr != null) {
                this.fjr.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cKW != null && this.fjd) {
            this.cKW.aHy();
        }
    }

    private void aYn() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eUm.getActivity());
                    if (i.this.fju == null) {
                        try {
                            i.this.fju = BitmapFactory.decodeResource(i.this.eUm.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fju);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eW() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eX() {
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
                public void eZ() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fjt = null;
                    if (i.this.fju != null && !i.this.fju.isRecycled()) {
                        i.this.fju.recycle();
                    }
                    i.this.fju = null;
                }
            });
            this.fjt = dVar.eY();
            this.fjt.k(this.eUm.getActivity());
        }
    }

    public boolean jY(int i) {
        if (this.cKW == null) {
            return false;
        }
        return this.cKW.sp(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(String str) {
        if (this.fiW != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fiW.video_md5, "", str, this.fiX);
            }
        }
    }

    public void aYo() {
        if (this.fiT != null) {
            this.fiT.kh(this.eUm.aTu());
        }
    }

    public void aXg() {
        if (this.fiT != null) {
            this.fiT.aXg();
        }
    }

    public void qm(int i) {
        if (this.fiT != null) {
            this.fiT.qm(i);
        }
        if (this.fjr != null) {
            this.fjr.onChangeSkinType(i);
        }
        if (this.fiY != null) {
            this.fiY.dE(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aYr()) {
                    this.fjg = i;
                    if (this.fjg == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qs(i.this.aYs().getHeight());
                            }
                        }, 100L);
                    }
                    aYp();
                    return;
                }
                return;
        }
    }

    private void qr(int i) {
        if (aYs().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiU.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fjl != aYs().getHeight()) {
                        this.fiU.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eUm.getActivity()), Math.min(this.fjl, aYs().getHeight() + i)));
                        this.cKW.aHt();
                    }
                } else if (com.baidu.adp.lib.util.l.ac(this.eUm.getActivity()) * 0.5625d != aYs().getHeight()) {
                    this.fiU.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eUm.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ac(this.eUm.getActivity()) * 0.5625d, aYs().getHeight() + i)));
                    this.cKW.aHt();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aYu()) {
                int bottom = childAt.getBottom() - aYs().getBottom();
                if (childAt.getHeight() == 0 || aYs().getHeight() == 0) {
                    bottom = 0;
                }
                qr(bottom);
            } else {
                qr((-this.fjl) + 2);
            }
        }
        if (!aYr() && this.fjq) {
            if (this.fjg == 1) {
                qs(aYs().getHeight());
            } else if (this.fjg == 2) {
                int y = (int) aYs().getY();
                if (this.fjh == y) {
                    qs(aYs().getHeight());
                } else {
                    this.fjh = y;
                    qs(aYs().getHeight());
                }
                if (i == 0 && this.fjk) {
                    this.fjk = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aYm();
                        }
                    }, 100L);
                }
            } else if (this.fjg == 0) {
                qs(aYs().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qs(int i) {
        qt(i);
        aYp();
    }

    private void qt(int i) {
        if (this.fiY != null) {
            if (i == 0) {
                i = this.fjl;
            }
            float f = this.fjl - i;
            float f2 = f > this.fji ? 0.0f : 1.0f - (f / this.fji);
            if (f2 == 0.0f) {
                this.fiY.aYi().setVisibility(8);
            } else {
                this.fiY.aYi().setVisibility(0);
            }
            this.fiY.Y(f2);
        }
    }

    public void aYp() {
        if (this.fiY != null) {
            if (aYr()) {
                this.eUm.aSI().aWv();
            } else if (this.fiY.aYi().getVisibility() == 0) {
                this.eUm.aSI().aWv();
                this.fiZ = true;
            } else if (this.fiZ) {
                this.eUm.aSI().jV(false);
                this.fiZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYq() {
        return aYs().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fjf = false;
        if (this.cKW != null && this.fiU != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiU.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.fjt != null) {
                    this.fjt.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fjf = true;
                this.fiU.setLayoutParams(layoutParams);
                this.eUm.aSI().aWv();
                this.fiZ = true;
            } else {
                b(this.fiW);
                aYo();
                this.fjf = false;
                this.fiT.setTitleVisibility(true);
            }
            this.cKW.a(this.eUm.getPageContext(), configuration);
        }
    }

    public boolean aYr() {
        return this.fjf;
    }

    public void y(long j, int i) {
        if (this.fiY != null && j > 0) {
            this.fiY.l(i, j);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fiY != null) {
            this.fiY.H(onClickListener);
        }
    }

    public View aYs() {
        return this.fiS;
    }

    public boolean aWH() {
        if (aYs() == null) {
            return false;
        }
        return aYs().getBottom() > com.baidu.adp.lib.util.l.ae(aYs().getContext()) - com.baidu.adp.lib.util.l.f(aYs().getContext(), d.e.ds50);
    }

    public void aYt() {
        this.fjk = true;
    }

    public View aYu() {
        return this.mEmptyView;
    }
}
