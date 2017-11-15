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
    private n bSk;
    private com.baidu.tieba.play.c cBS;
    private PbActivity eMB;
    private RelativeLayout fbY;
    private com.baidu.tieba.pb.pb.main.view.c fbZ;
    private int fcB;
    private CustomFrameLayout fca;
    private c.InterfaceC0122c fcb;
    private x fcd;
    private g fce;
    private boolean fcf;
    private bh fcg;
    private bh fch;
    private String fci;
    private float fco;
    private int fcr;
    private double fcs;
    private long fct;
    private c.InterfaceC0122c fcu;
    private com.baidu.tieba.pb.view.c fcw;
    private com.baidu.adp.lib.guide.c fcy;
    private Bitmap fcz;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aXD = null;
    private VideoInfo fcc = null;
    private boolean fcj = false;
    private int fck = 0;
    private boolean fcl = false;
    private int fcm = 0;
    private int fcn = 0;
    private boolean fcp = false;
    private boolean fcq = false;
    private boolean fcv = true;
    private c.a fcx = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.jU(false);
        }
    };
    private c.k fcA = new c.k() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.k
        public void aXw() {
            if (i.this.eMB.checkUpIsLogin()) {
                i.this.eMB.aSe();
                if (i.this.eMB.aRa() != null && i.this.eMB.aRa().getPbData() != null && i.this.eMB.aRa().getPbData().aQs() != null) {
                    l aQs = i.this.eMB.aRa().getPbData().aQs();
                    if (i.this.fcw == null) {
                        i.this.fcw = new com.baidu.tieba.pb.view.c(i.this.eMB.getActivity());
                        i.this.fcw.setFloatingHuajiAninationListener(i.this.fcx);
                    }
                    i.this.fcw.jX(!aQs.aQB());
                }
            }
        }
    };
    private Animation.AnimationListener ecB = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aWh();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private c.d fcC = new c.d() { // from class: com.baidu.tieba.pb.video.i.3
        @Override // com.baidu.tieba.play.c.d
        public void jV(boolean z) {
            i.this.kW(z ? "1" : "2");
        }
    };
    private t.a efo = new t.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.t.a
        public void LT() {
        }
    };
    private c.g fcD = new c.g() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.g
        public void akP() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jU(boolean z) {
        if (this.eMB.aRa() != null && this.eMB.aRa().getPbData() != null && this.eMB.aRa().getPbData().aQs() != null) {
            l aQs = this.eMB.aRa().getPbData().aQs();
            View findViewById = this.eMB.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aQs.aQB() || z) {
                this.eMB.f(findViewById, 2, false);
                TiebaStatic.log(this.eMB.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQs.aQB() ? 0 : 1));
            } else if (aQs.aQB()) {
                if (aQs.eHn == 1 || aQs.eHn == 3 || aQs.eHn == 4) {
                    this.eMB.f(findViewById, 2, true);
                    TiebaStatic.log(this.eMB.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQs.aQB() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fco = 0.0f;
        this.eMB = pbActivity;
        this.fbZ = cVar;
        this.fco = com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds240);
        this.fct = j;
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ac = com.baidu.adp.lib.util.l.ac(this.eMB.getActivity());
        Rect t = aw.t(this.eMB.getPageContext().getPageActivity());
        int ae = t.height() <= 0 ? com.baidu.adp.lib.util.l.ae(this.eMB.getActivity()) : t.height();
        int i = (int) (ac * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fcs = (intValue2 * 1.0d) / intValue;
            if (this.fcs > 0.5625d) {
                i = Math.min((ac * intValue2) / intValue, ae);
            }
        }
        this.fcr = i;
        this.fca.setLayoutParams(new RelativeLayout.LayoutParams(ac, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fbY = (RelativeLayout) LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fca = (CustomFrameLayout) this.fbY.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cBS = new com.baidu.tieba.play.c(this.eMB.getPageContext(), this.fca);
        this.cBS.a(this.fcA);
        this.cBS.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.11
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
                        if (i.this.eMB.getListView() != null && i.this.eMB.getListView().getChildCount() > 0 && i.this.eMB.getListView().getChildAt(0) == i.this.aXv()) {
                            i.this.fcB = i.this.aXv().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fcB = 0;
                        break;
                    case 2:
                        if (i.this.eMB.getListView() != null && i.this.eMB.getListView().getChildCount() > 0 && i.this.eMB.getListView().getChildAt(0) == i.this.aXv()) {
                            i.this.eMB.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fcB);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fcs >= 1.0d) {
                this.cBS.lu(false);
            } else {
                this.cBS.lu(true);
            }
            this.fcp = ((float) b) + this.fco > ((float) com.baidu.adp.lib.util.l.ae(this.eMB.getActivity()));
            if (this.fcp) {
                if (this.fce == null) {
                    this.fce = new g(this.eMB.getPageContext(), this.fca);
                    this.fce.H(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.jU(true);
                        }
                    });
                }
                this.eMB.aRs().aUU();
                this.fcf = true;
            }
        }
        aXo();
        this.mEmptyView = new View(this.eMB);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fcr));
        if (this.fbZ != null && this.fbZ.mNavigationBar != null) {
            this.fbZ.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fbZ.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fbZ.mNavigationBar.setStatusBarVisibility(8);
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eMB.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fcb == null) {
            this.fcb = new c.InterfaceC0122c() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.InterfaceC0122c
                public void eQ(boolean z) {
                    if (i.this.aXr() && i.this.fbZ != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fbZ.aWc().clearAnimation();
                        i.this.aXp();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.ecB);
                            i.this.fbZ.aWc().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0122c
                public void akO() {
                    if (i.this.aXr()) {
                        i.this.aWh();
                    }
                }
            };
        }
        a(this.fcb);
        this.fck = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bh bhVar, String str) {
        if (videoInfo != null && this.cBS != null && bhVar != null) {
            this.fcc = videoInfo;
            this.fcg = bhVar;
            this.aXD = videoInfo.video_url;
            this.cBS.stopPlay();
            this.cBS.lr(true);
            this.bSk = new n(this.eMB.getActivity());
            this.fcd = new x();
            this.fcd.mLocate = "pb";
            this.fcd.aMq = bhVar.getTid();
            this.fcd.azM = str;
            this.fcd.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fcd.mSource = bhVar.ZQ;
            this.fcd.fHk = bhVar.ZR;
            this.fcd.fHl = this.eMB.aRq();
            this.fcd.fHm = bhVar.ZS;
            this.fcd.fHn = videoInfo.video_md5;
            x bhT = this.fcd.bhT();
            bhT.mLocate = "6";
            this.bSk.setVideoStatsData(bhT);
            this.cBS.getVideoView().setBusiness(this.bSk);
            if (this.cBS.aGN()) {
                this.cBS.aGL();
            }
            this.cBS.b(this.fcu);
            this.fci = null;
            this.fch = null;
            this.cBS.qa(this.fci);
            this.cBS.aGH().setOnDragingListener(this.efo);
            this.cBS.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.15
                @Override // com.baidu.tieba.play.c.b
                public void akL() {
                    i.this.eMB.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fcv = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void akK() {
                    i.this.eMB.setSwipeBackEnabled(false);
                    i.this.fcv = false;
                }
            });
            this.cBS.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.f
                public void aXx() {
                    if (i.this.eMB != null && i.this.fch != null && !StringUtils.isNull(i.this.fch.getId())) {
                        i.this.eMB.pt(i.this.fch.getId());
                        if (i.this.fcg != null) {
                            long j = 0;
                            if (i.this.fcg.sz() != null) {
                                j = i.this.fcg.sz().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cBS.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void jW(boolean z) {
                    if (i.this.fcg != null) {
                        long j = 0;
                        if (i.this.fcg.sz() != null) {
                            j = i.this.fcg.sz().channelId;
                        }
                        i.this.kW(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ac("tid", i.this.fcg.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fcg.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cBS.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aXD);
                    return true;
                }
            });
            this.cBS.nG(videoInfo.thumbnail_url);
            this.cBS.bK(this.aXD, bhVar.getTid());
            this.cBS.setVideoTitle(bhVar.getTitle());
            this.cBS.a(this.fcD);
            this.cBS.atn();
            this.cBS.show();
        }
    }

    public void pZ(String str) {
        if (this.fcd != null) {
            this.fcd.azM = str;
        }
    }

    public void b(PostData postData, bh bhVar, l lVar) {
        if (this.fce != null) {
            this.fce.a(postData, bhVar, lVar);
        }
    }

    public void a(c.InterfaceC0122c interfaceC0122c) {
        this.fcu = interfaceC0122c;
    }

    public void ac(bh bhVar) {
        this.fch = bhVar;
    }

    public void qa(String str) {
        this.fci = str;
        if (this.cBS != null) {
            this.cBS.qa(this.fci);
        }
    }

    public void startPlay() {
        if (this.cBS != null) {
            this.cBS.a(this.aXD, this.fcg == null ? "" : this.fcg.getTid(), this.fcC, this.fct);
        }
    }

    public void aXn() {
        if (this.cBS != null) {
            this.cBS.aXn();
        }
    }

    public void destroy() {
        if (this.cBS != null) {
            this.cBS.destroy();
        }
        if (this.fca != null) {
            this.fca.clearAnimation();
        }
        if (this.fce != null) {
            this.fce.onDestroy();
        }
    }

    public void onPause() {
        if (this.cBS != null) {
            if (this.cBS.bhk()) {
                this.fcj = true;
                this.cBS.pausePlay();
            } else if (this.cBS.bhq() == 3) {
                this.fcj = false;
            } else {
                this.fcj = false;
                this.cBS.pausePlay();
            }
            if (this.fcw != null) {
                this.fcw.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cBS != null && this.fcj) {
            this.cBS.aGQ();
        }
    }

    private void aXo() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eMB.getActivity());
                    if (i.this.fcz == null) {
                        try {
                            i.this.fcz = BitmapFactory.decodeResource(i.this.eMB.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fcz);
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
                    i.this.fcy = null;
                    if (i.this.fcz != null && !i.this.fcz.isRecycled()) {
                        i.this.fcz.recycle();
                    }
                    i.this.fcz = null;
                }
            });
            this.fcy = dVar.eY();
            this.fcy.k(this.eMB.getActivity());
        }
    }

    public boolean jA(int i) {
        if (this.cBS == null) {
            return false;
        }
        return this.cBS.sc(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(String str) {
        if (this.fcc != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fcc.video_md5, "", str, this.fcd);
            }
        }
    }

    public void aXp() {
        if (this.fbZ != null) {
            this.fbZ.jJ(this.eMB.aSd());
        }
    }

    public void aWh() {
        if (this.fbZ != null) {
            this.fbZ.aWh();
        }
    }

    public void qb(int i) {
        if (this.fbZ != null) {
            this.fbZ.qb(i);
        }
        if (this.fcw != null) {
            this.fcw.onChangeSkinType(i);
        }
        if (this.fce != null) {
            this.fce.dD(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aXs()) {
                    this.fcm = i;
                    if (this.fcm == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qh(i.this.aXt().getHeight());
                            }
                        }, 100L);
                    }
                    aXq();
                    return;
                }
                return;
        }
    }

    private void qg(int i) {
        if (aXt().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fca.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fcr != aXt().getHeight()) {
                        this.fca.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eMB.getActivity()), Math.min(this.fcr, aXt().getHeight() + i)));
                        this.cBS.aGL();
                    }
                } else if (com.baidu.adp.lib.util.l.ac(this.eMB.getActivity()) * 0.5625d != aXt().getHeight()) {
                    this.fca.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eMB.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ac(this.eMB.getActivity()) * 0.5625d, aXt().getHeight() + i)));
                    this.cBS.aGL();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aXv()) {
                int bottom = childAt.getBottom() - aXt().getBottom();
                if (childAt.getHeight() == 0 || aXt().getHeight() == 0) {
                    bottom = 0;
                }
                qg(bottom);
            } else {
                qg((-this.fcr) + 2);
            }
        }
        if (!aXs() && this.fcv) {
            if (this.fcm == 1) {
                qh(aXt().getHeight());
            } else if (this.fcm == 2) {
                int y = (int) aXt().getY();
                if (this.fcn == y) {
                    qh(aXt().getHeight());
                } else {
                    this.fcn = y;
                    qh(aXt().getHeight());
                }
                if (i == 0 && this.fcq) {
                    this.fcq = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aXn();
                        }
                    }, 100L);
                }
            } else if (this.fcm == 0) {
                qh(aXt().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(int i) {
        qi(i);
        aXq();
    }

    private void qi(int i) {
        if (this.fce != null) {
            if (i == 0) {
                i = this.fcr;
            }
            float f = this.fcr - i;
            float f2 = f > this.fco ? 0.0f : 1.0f - (f / this.fco);
            if (f2 == 0.0f) {
                this.fce.aXj().setVisibility(8);
            } else {
                this.fce.aXj().setVisibility(0);
            }
            this.fce.X(f2);
        }
    }

    public void aXq() {
        if (this.fce != null) {
            if (aXs()) {
                this.eMB.aRs().aUU();
            } else if (this.fce.aXj().getVisibility() == 0) {
                this.eMB.aRs().aUU();
                this.fcf = true;
            } else if (this.fcf) {
                this.eMB.aRs().hi(false);
                this.fcf = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXr() {
        return aXt().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fcl = false;
        if (this.cBS != null && this.fca != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fca.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fcy != null) {
                    this.fcy.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fcl = true;
                this.fca.setLayoutParams(layoutParams);
                this.eMB.aRs().aUU();
                this.fcf = true;
            } else {
                b(this.fcc);
                aXp();
                this.fcl = false;
                this.fbZ.setTitleVisibility(true);
            }
            this.cBS.a(this.eMB.getPageContext(), configuration);
        }
    }

    public boolean aXs() {
        return this.fcl;
    }

    public void y(long j, int i) {
        if (this.fce != null && j > 0) {
            this.fce.l(i, j);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.fce != null) {
            this.fce.G(onClickListener);
        }
    }

    public View aXt() {
        return this.fbY;
    }

    public boolean aVg() {
        if (aXt() == null) {
            return false;
        }
        return aXt().getBottom() > com.baidu.adp.lib.util.l.ae(aXt().getContext()) - com.baidu.adp.lib.util.l.f(aXt().getContext(), d.e.ds50);
    }

    public void aXu() {
        this.fcq = true;
    }

    public View aXv() {
        return this.mEmptyView;
    }
}
