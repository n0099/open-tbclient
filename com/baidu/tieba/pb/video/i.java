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
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private n bRX;
    private com.baidu.tieba.play.c cBz;
    private PbActivity eMh;
    private RelativeLayout fbD;
    private com.baidu.tieba.pb.pb.main.view.c fbE;
    private CustomFrameLayout fbF;
    private c.InterfaceC0120c fbG;
    private x fbI;
    private g fbJ;
    private boolean fbK;
    private bh fbL;
    private bh fbM;
    private String fbN;
    private float fbT;
    private int fbW;
    private double fbX;
    private c.InterfaceC0120c fbY;
    private com.baidu.tieba.pb.view.c fca;
    private com.baidu.adp.lib.guide.c fcc;
    private Bitmap fcd;
    private int fcf;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aXu = null;
    private VideoInfo fbH = null;
    private boolean fbO = false;
    private int fbP = 0;
    private boolean fbQ = false;
    private int fbR = 0;
    private int fbS = 0;
    private boolean fbU = false;
    private boolean fbV = false;
    private boolean fbZ = true;
    private c.a fcb = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.jO(false);
        }
    };
    private c.k fce = new c.k() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.k
        public void aXo() {
            if (i.this.eMh.checkUpIsLogin()) {
                i.this.eMh.aRW();
                if (i.this.eMh.aQS() != null && i.this.eMh.aQS().getPbData() != null && i.this.eMh.aQS().getPbData().aQk() != null) {
                    l aQk = i.this.eMh.aQS().getPbData().aQk();
                    if (i.this.fca == null) {
                        i.this.fca = new com.baidu.tieba.pb.view.c(i.this.eMh.getActivity());
                        i.this.fca.setFloatingHuajiAninationListener(i.this.fcb);
                    }
                    i.this.fca.jR(!aQk.aQt());
                }
            }
        }
    };
    private Animation.AnimationListener ecx = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aVZ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private c.d fcg = new c.d() { // from class: com.baidu.tieba.pb.video.i.3
        @Override // com.baidu.tieba.play.c.d
        public void jP(boolean z) {
            i.this.kV(z ? "1" : "2");
        }
    };
    private t.a efk = new t.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.t.a
        public void LI() {
        }
    };
    private c.g fch = new c.g() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.g
        public void akB() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(boolean z) {
        if (this.eMh.aQS() != null && this.eMh.aQS().getPbData() != null && this.eMh.aQS().getPbData().aQk() != null) {
            l aQk = this.eMh.aQS().getPbData().aQk();
            View findViewById = this.eMh.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aQk.aQt() || z) {
                this.eMh.f(findViewById, 2, false);
                TiebaStatic.log(this.eMh.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQk.aQt() ? 0 : 1));
            } else if (aQk.aQt()) {
                if (aQk.eGT == 1 || aQk.eGT == 3 || aQk.eGT == 4) {
                    this.eMh.f(findViewById, 2, true);
                    TiebaStatic.log(this.eMh.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQk.aQt() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo) {
        this.fbT = 0.0f;
        this.eMh = pbActivity;
        this.fbE = cVar;
        this.fbT = com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ac = com.baidu.adp.lib.util.l.ac(this.eMh.getActivity());
        Rect t = aw.t(this.eMh.getPageContext().getPageActivity());
        int ae = t.height() <= 0 ? com.baidu.adp.lib.util.l.ae(this.eMh.getActivity()) : t.height();
        int i = (int) (ac * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fbX = (intValue2 * 1.0d) / intValue;
            if (this.fbX > 0.5625d) {
                i = Math.min((ac * intValue2) / intValue, ae);
            }
        }
        this.fbW = i;
        this.fbF.setLayoutParams(new RelativeLayout.LayoutParams(ac, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fbD = (RelativeLayout) LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fbF = (CustomFrameLayout) this.fbD.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cBz = new com.baidu.tieba.play.c(this.eMh.getPageContext(), this.fbF);
        this.cBz.a(this.fce);
        this.cBz.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.11
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
                        if (i.this.eMh.getListView() != null && i.this.eMh.getListView().getChildCount() > 0 && i.this.eMh.getListView().getChildAt(0) == i.this.aXn()) {
                            i.this.fcf = i.this.aXn().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fcf = 0;
                        break;
                    case 2:
                        if (i.this.eMh.getListView() != null && i.this.eMh.getListView().getChildCount() > 0 && i.this.eMh.getListView().getChildAt(0) == i.this.aXn()) {
                            i.this.eMh.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fcf);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fbX >= 1.0d) {
                this.cBz.lo(false);
            } else {
                this.cBz.lo(true);
            }
            this.fbU = ((float) b) + this.fbT > ((float) com.baidu.adp.lib.util.l.ae(this.eMh.getActivity()));
            if (this.fbU) {
                if (this.fbJ == null) {
                    this.fbJ = new g(this.eMh.getPageContext(), this.fbF);
                    this.fbJ.H(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.jO(true);
                        }
                    });
                }
                this.eMh.aRk().aUM();
                this.fbK = true;
            }
        }
        aXg();
        this.mEmptyView = new View(this.eMh);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fbW));
        if (this.fbE != null && this.fbE.mNavigationBar != null) {
            this.fbE.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fbE.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fbE.mNavigationBar.setStatusBarVisibility(8);
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eMh.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fbG == null) {
            this.fbG = new c.InterfaceC0120c() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.InterfaceC0120c
                public void eL(boolean z) {
                    if (i.this.aXj() && i.this.fbE != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fbE.aVU().clearAnimation();
                        i.this.aXh();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.ecx);
                            i.this.fbE.aVU().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0120c
                public void akA() {
                    if (i.this.aXj()) {
                        i.this.aVZ();
                    }
                }
            };
        }
        a(this.fbG);
        this.fbP = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bh bhVar, String str) {
        if (videoInfo != null && this.cBz != null && bhVar != null) {
            this.fbH = videoInfo;
            this.fbL = bhVar;
            this.aXu = videoInfo.video_url;
            this.cBz.stopPlay();
            this.cBz.ll(true);
            this.bRX = new n(this.eMh.getActivity());
            this.fbI = new x();
            this.fbI.mLocate = "pb";
            this.fbI.aMi = bhVar.getTid();
            this.fbI.azE = str;
            this.fbI.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fbI.mSource = bhVar.ZQ;
            this.fbI.fGF = bhVar.ZR;
            this.fbI.fGG = this.eMh.aRi();
            this.fbI.fGH = bhVar.ZS;
            this.fbI.fGI = videoInfo.video_md5;
            x bhL = this.fbI.bhL();
            bhL.mLocate = "6";
            this.bRX.setVideoStatsData(bhL);
            this.cBz.getVideoView().setBusiness(this.bRX);
            if (this.cBz.aGJ()) {
                this.cBz.aGH();
            }
            this.cBz.b(this.fbY);
            this.fbN = null;
            this.fbM = null;
            this.cBz.pW(this.fbN);
            this.cBz.aGD().setOnDragingListener(this.efk);
            this.cBz.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.15
                @Override // com.baidu.tieba.play.c.b
                public void akx() {
                    i.this.eMh.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fbZ = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void akw() {
                    i.this.eMh.setSwipeBackEnabled(false);
                    i.this.fbZ = false;
                }
            });
            this.cBz.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.f
                public void aXp() {
                    if (i.this.eMh != null && i.this.fbM != null && !StringUtils.isNull(i.this.fbM.getId())) {
                        i.this.eMh.pp(i.this.fbM.getId());
                        if (i.this.fbL != null) {
                            long j = 0;
                            if (i.this.fbL.sz() != null) {
                                j = i.this.fbL.sz().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cBz.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void jQ(boolean z) {
                    if (i.this.fbL != null) {
                        long j = 0;
                        if (i.this.fbL.sz() != null) {
                            j = i.this.fbL.sz().channelId;
                        }
                        i.this.kV(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ac("tid", i.this.fbL.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fbL.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cBz.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aXu);
                    return true;
                }
            });
            this.cBz.nE(videoInfo.thumbnail_url);
            this.cBz.bJ(this.aXu, bhVar.getTid());
            this.cBz.setVideoTitle(bhVar.getTitle());
            this.cBz.a(this.fch);
            this.cBz.asW();
            this.cBz.show();
        }
    }

    public void pV(String str) {
        if (this.fbI != null) {
            this.fbI.azE = str;
        }
    }

    public void b(PostData postData, bh bhVar, l lVar) {
        if (this.fbJ != null) {
            this.fbJ.a(postData, bhVar, lVar);
        }
    }

    public void a(c.InterfaceC0120c interfaceC0120c) {
        this.fbY = interfaceC0120c;
    }

    public void ac(bh bhVar) {
        this.fbM = bhVar;
    }

    public void pW(String str) {
        this.fbN = str;
        if (this.cBz != null) {
            this.cBz.pW(this.fbN);
        }
    }

    public void startPlay() {
        if (this.cBz != null) {
            this.cBz.a(this.aXu, this.fbL == null ? "" : this.fbL.getTid(), this.fcg);
        }
    }

    public void aXf() {
        if (this.cBz != null) {
            this.cBz.aXf();
        }
    }

    public void destroy() {
        if (this.cBz != null) {
            this.cBz.destroy();
        }
        if (this.fbF != null) {
            this.fbF.clearAnimation();
        }
        if (this.fbJ != null) {
            this.fbJ.onDestroy();
        }
    }

    public void onPause() {
        if (this.cBz != null) {
            if (this.cBz.bhc()) {
                this.fbO = true;
                this.cBz.pausePlay();
            } else if (this.cBz.bhi() == 3) {
                this.fbO = false;
            } else {
                this.fbO = false;
                this.cBz.pausePlay();
            }
            if (this.fca != null) {
                this.fca.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cBz != null && this.fbO) {
            this.cBz.aGM();
        }
    }

    private void aXg() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eMh.getActivity());
                    if (i.this.fcd == null) {
                        try {
                            i.this.fcd = BitmapFactory.decodeResource(i.this.eMh.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fcd);
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.d.a
                public void eZ() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fcc = null;
                    if (i.this.fcd != null && !i.this.fcd.isRecycled()) {
                        i.this.fcd.recycle();
                    }
                    i.this.fcd = null;
                }
            });
            this.fcc = dVar.eY();
            this.fcc.k(this.eMh.getActivity());
        }
    }

    public boolean jB(int i) {
        if (this.cBz == null) {
            return false;
        }
        return this.cBz.sb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(String str) {
        if (this.fbH != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fbH.video_md5, "", str, this.fbI);
            }
        }
    }

    public void aXh() {
        if (this.fbE != null) {
            this.fbE.jD(this.eMh.aRV());
        }
    }

    public void aVZ() {
        if (this.fbE != null) {
            this.fbE.aVZ();
        }
    }

    public void qa(int i) {
        if (this.fbE != null) {
            this.fbE.qa(i);
        }
        if (this.fca != null) {
            this.fca.onChangeSkinType(i);
        }
        if (this.fbJ != null) {
            this.fbJ.dE(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aXk()) {
                    this.fbR = i;
                    if (this.fbR == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qg(i.this.aXl().getHeight());
                            }
                        }, 100L);
                    }
                    aXi();
                    return;
                }
                return;
        }
    }

    private void qf(int i) {
        if (aXl().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fbF.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fbW != aXl().getHeight()) {
                        this.fbF.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eMh.getActivity()), Math.min(this.fbW, aXl().getHeight() + i)));
                        this.cBz.aGH();
                    }
                } else if (com.baidu.adp.lib.util.l.ac(this.eMh.getActivity()) * 0.5625d != aXl().getHeight()) {
                    this.fbF.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eMh.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ac(this.eMh.getActivity()) * 0.5625d, aXl().getHeight() + i)));
                    this.cBz.aGH();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aXn()) {
                int bottom = childAt.getBottom() - aXl().getBottom();
                if (childAt.getHeight() == 0 || aXl().getHeight() == 0) {
                    bottom = 0;
                }
                qf(bottom);
            } else {
                qf((-this.fbW) + 2);
            }
        }
        if (!aXk() && this.fbZ) {
            if (this.fbR == 1) {
                qg(aXl().getHeight());
            } else if (this.fbR == 2) {
                int y = (int) aXl().getY();
                if (this.fbS == y) {
                    qg(aXl().getHeight());
                } else {
                    this.fbS = y;
                    qg(aXl().getHeight());
                }
                if (i == 0 && this.fbV) {
                    this.fbV = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aXf();
                        }
                    }, 100L);
                }
            } else if (this.fbR == 0) {
                qg(aXl().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        qh(i);
        aXi();
    }

    private void qh(int i) {
        if (this.fbJ != null) {
            if (i == 0) {
                i = this.fbW;
            }
            float f = this.fbW - i;
            float f2 = f > this.fbT ? 0.0f : 1.0f - (f / this.fbT);
            if (f2 == 0.0f) {
                this.fbJ.aXb().setVisibility(8);
            } else {
                this.fbJ.aXb().setVisibility(0);
            }
            this.fbJ.X(f2);
        }
    }

    public void aXi() {
        if (this.fbJ != null) {
            if (aXk()) {
                this.eMh.aRk().aUM();
            } else if (this.fbJ.aXb().getVisibility() == 0) {
                this.eMh.aRk().aUM();
                this.fbK = true;
            } else if (this.fbK) {
                this.eMh.aRk().hc(false);
                this.fbK = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXj() {
        return aXl().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fbQ = false;
        if (this.cBz != null && this.fbF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fbF.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fcc != null) {
                    this.fcc.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fbQ = true;
                this.fbF.setLayoutParams(layoutParams);
                this.eMh.aRk().aUM();
                this.fbK = true;
            } else {
                b(this.fbH);
                aXh();
                this.fbQ = false;
                this.fbE.setTitleVisibility(true);
            }
            this.cBz.a(this.eMh.getPageContext(), configuration);
        }
    }

    public boolean aXk() {
        return this.fbQ;
    }

    public void y(long j, int i) {
        if (this.fbJ != null && j > 0) {
            this.fbJ.l(i, j);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.fbJ != null) {
            this.fbJ.G(onClickListener);
        }
    }

    public View aXl() {
        return this.fbD;
    }

    public boolean aUY() {
        if (aXl() == null) {
            return false;
        }
        return aXl().getBottom() > com.baidu.adp.lib.util.l.ae(aXl().getContext()) - com.baidu.adp.lib.util.l.f(aXl().getContext(), d.e.ds50);
    }

    public void aXm() {
        this.fbV = true;
    }

    public View aXn() {
        return this.mEmptyView;
    }
}
