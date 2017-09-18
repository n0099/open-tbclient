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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.c;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.s;
import com.baidu.tieba.play.w;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tieba.play.m bLi;
    private com.baidu.tieba.play.c ctL;
    private w ctO;
    private PbActivity eHK;
    private com.baidu.adp.lib.guide.c eZA;
    private Bitmap eZB;
    private RelativeLayout eZc;
    private com.baidu.tieba.pb.pb.main.view.c eZd;
    private CustomFrameLayout eZe;
    private c.InterfaceC0118c eZf;
    private g eZh;
    private boolean eZi;
    private bj eZj;
    private bj eZk;
    private String eZl;
    private float eZr;
    private int eZu;
    private double eZv;
    private c.InterfaceC0118c eZw;
    private com.baidu.tieba.pb.view.c eZy;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aVD = null;
    private VideoInfo eZg = null;
    private boolean eZm = false;
    private int eZn = 0;
    private boolean eZo = false;
    private int eZp = 0;
    private int eZq = 0;
    private boolean eZs = false;
    private boolean eZt = false;
    private boolean eZx = true;
    private c.a eZz = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kh(false);
        }
    };
    private c.k eZC = new c.k() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.k
        public void aWi() {
            if (i.this.eHK.checkUpIsLogin()) {
                i.this.eHK.aQZ();
                if (i.this.eHK.aQn() != null && i.this.eHK.aQn().getPbData() != null && i.this.eHK.aQn().getPbData().aPE() != null) {
                    com.baidu.tieba.pb.data.l aPE = i.this.eHK.aQn().getPbData().aPE();
                    if (i.this.eZy == null) {
                        i.this.eZy = new com.baidu.tieba.pb.view.c(i.this.eHK.getActivity());
                        i.this.eZy.setFloatingHuajiAninationListener(i.this.eZz);
                    }
                    i.this.eZy.kj(!aPE.aPL());
                }
            }
        }
    };
    private Animation.AnimationListener dYQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aUH();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private c.d eZD = new c.d() { // from class: com.baidu.tieba.pb.video.i.3
        @Override // com.baidu.tieba.play.c.d
        public void ki(boolean z) {
            i.this.kE(z ? "1" : "2");
        }
    };
    private s.a ebE = new s.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.s.a
        public void Lo() {
        }
    };
    private c.g eZE = new c.g() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.g
        public void aiv() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(boolean z) {
        if (this.eHK.aQn() != null && this.eHK.aQn().getPbData() != null && this.eHK.aQn().getPbData().aPE() != null) {
            com.baidu.tieba.pb.data.l aPE = this.eHK.aQn().getPbData().aPE();
            View findViewById = this.eHK.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aPE.aPL() || z) {
                this.eHK.f(findViewById, 2, false);
                TiebaStatic.log(this.eHK.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPE.aPL() ? 0 : 1));
            } else if (aPE.aPL()) {
                if (aPE.eFJ == 1 || aPE.eFJ == 3 || aPE.eFJ == 4) {
                    this.eHK.f(findViewById, 2, true);
                    TiebaStatic.log(this.eHK.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPE.aPL() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo) {
        this.eZr = 0.0f;
        this.eHK = pbActivity;
        this.eZd = cVar;
        this.eZr = com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ae = com.baidu.adp.lib.util.k.ae(this.eHK.getActivity());
        Rect s = aw.s(this.eHK.getPageContext().getPageActivity());
        int af = s.height() <= 0 ? com.baidu.adp.lib.util.k.af(this.eHK.getActivity()) : s.height();
        int i = (int) (ae * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eZv = (intValue2 * 1.0d) / intValue;
            if (this.eZv > 0.5625d) {
                i = Math.min((ae * intValue2) / intValue, af);
            }
        }
        this.eZu = i;
        this.eZe.setLayoutParams(new RelativeLayout.LayoutParams(ae, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eZc = (RelativeLayout) LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eZe = (CustomFrameLayout) this.eZc.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.ctL = new com.baidu.tieba.play.c(this.eHK.getPageContext(), this.eZe);
        this.ctL.a(this.eZC);
        this.ctL.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.11
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
                        return false;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        return false;
                    case 2:
                        i.this.eHK.getListView().smoothScrollBy(((int) (motionEvent.getY() - i.this.mLastY)) * (-2), 1);
                        i.this.mLastY = motionEvent.getY();
                        return false;
                    default:
                        return false;
                }
            }
        });
        if (intValue > 0) {
            if (this.eZv >= 1.0d) {
                this.ctL.lC(false);
            } else {
                this.ctL.lC(true);
            }
            this.eZs = ((float) b) + this.eZr > ((float) com.baidu.adp.lib.util.k.af(this.eHK.getActivity()));
            if (this.eZs) {
                if (this.eZh == null) {
                    this.eZh = new g(this.eHK.getPageContext(), this.eZe);
                    this.eZh.E(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kh(true);
                        }
                    });
                }
                this.eHK.aQm().aTA();
                this.eZi = true;
            }
        }
        aWa();
        this.mEmptyView = new View(this.eHK);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.eZu));
        if (this.eZd != null && this.eZd.mNavigationBar != null) {
            this.eZd.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eZd.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.eZd.mNavigationBar.setStatusBarVisibility(8);
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eHK.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eZf == null) {
            this.eZf = new c.InterfaceC0118c() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.InterfaceC0118c
                public void eX(boolean z) {
                    if (i.this.aWd() && i.this.eZd != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eZd.aUC().clearAnimation();
                        i.this.aWb();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dYQ);
                            i.this.eZd.aUC().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0118c
                public void aiu() {
                    if (i.this.aWd()) {
                        i.this.aUH();
                    }
                }
            };
        }
        a(this.eZf);
        this.eZn = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bj bjVar, String str) {
        if (videoInfo != null && this.ctL != null && bjVar != null) {
            this.eZg = videoInfo;
            this.eZj = bjVar;
            this.aVD = videoInfo.video_url;
            this.ctL.stopPlay();
            this.ctL.lz(true);
            this.bLi = new com.baidu.tieba.play.m(this.eHK.getActivity());
            this.ctO = new w();
            this.ctO.mLocate = "pb";
            this.ctO.bHy = bjVar.getTid();
            this.ctO.azL = str;
            this.ctO.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ctO.mSource = bjVar.ZH;
            this.ctO.fBO = bjVar.ZI;
            this.ctO.fBP = this.eHK.aQk();
            if (bjVar.sF() != null && bjVar.sF().channelId > 0) {
                this.ctO.VU = bjVar.sF().channelId + "";
            } else {
                this.ctO.VU = "0";
            }
            this.ctO.fBQ = bjVar.ZJ;
            this.ctO.fBR = videoInfo.video_md5;
            this.bLi.setVideoStatsData(this.ctO);
            this.ctL.getVideoView().setBusiness(this.bLi);
            if (this.ctL.aFD()) {
                this.ctL.aFB();
            }
            this.ctL.b(this.eZw);
            this.eZl = null;
            this.eZk = null;
            this.ctL.pJ(this.eZl);
            this.ctL.aFx().setOnDragingListener(this.ebE);
            this.ctL.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.15
                @Override // com.baidu.tieba.play.c.b
                public void air() {
                    i.this.eHK.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eZx = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aiq() {
                    i.this.eHK.setSwipeBackEnabled(false);
                    i.this.eZx = false;
                }
            });
            this.ctL.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.f
                public void aWj() {
                    if (i.this.eHK != null && i.this.eZk != null && !StringUtils.isNull(i.this.eZk.getId())) {
                        i.this.eHK.pg(i.this.eZk.getId());
                        if (i.this.eZj != null) {
                            long j = 0;
                            if (i.this.eZj.sF() != null) {
                                j = i.this.eZj.sF().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.ctL.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void eY(boolean z) {
                    if (i.this.eZj != null) {
                        long j = 0;
                        if (i.this.eZj.sF() != null) {
                            j = i.this.eZj.sF().channelId;
                        }
                        i.this.kE(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ad("tid", i.this.eZj.getTid()).f("fid", i.this.eZj.getFid()).f("obj_id", j));
                    }
                }
            });
            this.ctL.a(new f.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.f.b
                public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                    TiebaStatic.log(new ak("c12029").r("verrno", i).r("extra", i2));
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aVD);
                    return true;
                }
            });
            this.ctL.nG(videoInfo.thumbnail_url);
            this.ctL.bU(videoInfo.play_count.intValue());
            this.ctL.setVideoUrl(this.aVD);
            this.ctL.qB(bjVar.getTitle());
            this.ctL.a(this.eZE);
            this.ctL.arZ();
            this.ctL.show();
        }
    }

    public void pI(String str) {
        if (this.ctO != null) {
            this.ctO.azL = str;
        }
    }

    public void b(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        if (this.eZh != null) {
            this.eZh.a(postData, bjVar, lVar);
        }
    }

    public void a(c.InterfaceC0118c interfaceC0118c) {
        this.eZw = interfaceC0118c;
    }

    public void ah(bj bjVar) {
        this.eZk = bjVar;
    }

    public void pJ(String str) {
        this.eZl = str;
        if (this.ctL != null) {
            this.ctL.pJ(this.eZl);
        }
    }

    public void startPlay() {
        if (this.ctL != null) {
            this.ctL.a(this.aVD, this.eZD);
        }
    }

    public void aVZ() {
        if (this.ctL != null) {
            this.ctL.aVZ();
        }
    }

    public void destroy() {
        if (this.ctL != null) {
            this.ctL.destroy();
        }
        if (this.eZe != null) {
            this.eZe.clearAnimation();
        }
        if (this.eZh != null) {
            this.eZh.onDestroy();
        }
    }

    public void onPause() {
        if (this.ctL != null) {
            if (this.ctL.bfz()) {
                this.eZm = true;
                this.ctL.pausePlay();
            } else if (this.ctL.bfF() == 3) {
                this.eZm = false;
            } else {
                this.eZm = false;
                this.ctL.pausePlay();
            }
            if (this.eZy != null) {
                this.eZy.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.ctL != null && this.eZm) {
            this.ctL.aFG();
        }
    }

    private void aWa() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eHK.getActivity());
                    if (i.this.eZB == null) {
                        try {
                            i.this.eZB = BitmapFactory.decodeResource(i.this.eHK.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eZB);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eX() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eY() {
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
                public void fa() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.eZA = null;
                    if (i.this.eZB != null && !i.this.eZB.isRecycled()) {
                        i.this.eZB.recycle();
                    }
                    i.this.eZB = null;
                }
            });
            this.eZA = dVar.eZ();
            this.eZA.k(this.eHK.getActivity());
        }
    }

    public boolean je(int i) {
        if (this.ctL == null) {
            return false;
        }
        return this.ctL.rM(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(String str) {
        if (this.eZg != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.k.a(this.eZg.video_md5, "", str, this.ctO);
            }
        }
    }

    public void aWb() {
        if (this.eZd != null) {
            this.eZd.jV(this.eHK.aQY());
        }
    }

    public void aUH() {
        if (this.eZd != null) {
            this.eZd.aUH();
        }
    }

    public void pM(int i) {
        if (this.eZd != null) {
            this.eZd.pM(i);
        }
        if (this.eZy != null) {
            this.eZy.onChangeSkinType(i);
        }
        if (this.eZh != null) {
            this.eZh.du(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aWe()) {
                    this.eZp = i;
                    if (this.eZp == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.pT(i.this.aWf().getHeight());
                            }
                        }, 100L);
                    }
                    aWc();
                    return;
                }
                return;
        }
    }

    private void pS(int i) {
        if (aWf().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZe.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.eZu != aWf().getHeight()) {
                        this.eZe.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.ae(this.eHK.getActivity()), Math.min(this.eZu, aWf().getHeight() + i)));
                        this.ctL.aFB();
                    }
                } else if (com.baidu.adp.lib.util.k.ae(this.eHK.getActivity()) * 0.5625d != aWf().getHeight()) {
                    this.eZe.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.ae(this.eHK.getActivity()), (int) Math.max(com.baidu.adp.lib.util.k.ae(this.eHK.getActivity()) * 0.5625d, aWf().getHeight() + i)));
                    this.ctL.aFB();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aWh()) {
                int bottom = childAt.getBottom() - aWf().getBottom();
                if (childAt.getHeight() == 0 || aWf().getHeight() == 0) {
                    bottom = 0;
                }
                pS(bottom);
            } else {
                pS((-this.eZu) + 2);
            }
        }
        if (!aWe() && this.eZx) {
            if (this.eZp == 1) {
                pT(aWf().getHeight());
            } else if (this.eZp == 2) {
                int y = (int) aWf().getY();
                if (this.eZq == y) {
                    pT(aWf().getHeight());
                } else {
                    this.eZq = y;
                    pT(aWf().getHeight());
                }
                if (i == 0 && this.eZt) {
                    this.eZt = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aVZ();
                        }
                    }, 100L);
                }
            } else if (this.eZp == 0) {
                if (this.ctL.bfz()) {
                    int height = aWf().getHeight() - Math.abs((int) aWf().getY());
                    return;
                }
                int y2 = (int) aWf().getY();
                pT(aWf().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(int i) {
        pU(i);
        pV(i);
        aWc();
    }

    private void pU(int i) {
        if (i <= 0) {
            this.ctL.lC(false);
        } else if (this.eZv >= 1.0d) {
            this.ctL.lC(false);
        } else {
            this.ctL.lC(true);
        }
    }

    private void pV(int i) {
        if (this.eZh != null) {
            if (i == 0) {
                i = this.eZu;
            }
            float f = this.eZu - i;
            float f2 = f > this.eZr ? 0.0f : 1.0f - (f / this.eZr);
            if (f2 == 0.0f) {
                this.eZh.aVV().setVisibility(8);
            } else {
                this.eZh.aVV().setVisibility(0);
            }
            this.eZh.W(f2);
        }
    }

    public void aWc() {
        if (this.eZh != null) {
            if (aWe()) {
                this.eHK.aQm().aTA();
            } else if (this.eZh.aVV().getVisibility() == 0) {
                this.eHK.aQm().aTA();
                this.eZi = true;
            } else if (this.eZi) {
                this.eHK.aQm().hu(false);
                this.eZi = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWd() {
        return aWf().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.eZo = false;
        if (this.ctL != null && this.eZe != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZe.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eZA != null) {
                    this.eZA.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eZo = true;
                this.eZe.setLayoutParams(layoutParams);
                this.eHK.aQm().aTA();
                this.eZi = true;
            } else {
                b(this.eZg);
                aWb();
                this.eZo = false;
                this.eZd.setTitleVisibility(true);
            }
            this.ctL.a(this.eHK.getPageContext(), configuration);
        }
    }

    public boolean aWe() {
        return this.eZo;
    }

    public void w(long j, int i) {
        if (this.eZh != null && j > 0) {
            this.eZh.k(i, j);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.eZh != null) {
            this.eZh.D(onClickListener);
        }
    }

    public View aWf() {
        return this.eZc;
    }

    public boolean aTK() {
        return this.eZs;
    }

    public void aWg() {
        this.eZt = true;
    }

    public View aWh() {
        return this.mEmptyView;
    }
}
