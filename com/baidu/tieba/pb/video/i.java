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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.c;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tieba.play.n bKD;
    private com.baidu.tieba.play.c cup;
    private x cus;
    private PbActivity eDC;
    private float eTA;
    private int eTD;
    private double eTE;
    private c.InterfaceC0120c eTF;
    private com.baidu.tieba.pb.view.c eTH;
    private com.baidu.adp.lib.guide.c eTJ;
    private Bitmap eTK;
    private RelativeLayout eTl;
    private com.baidu.tieba.pb.pb.main.view.c eTm;
    private CustomFrameLayout eTn;
    private c.InterfaceC0120c eTo;
    private g eTq;
    private boolean eTr;
    private bh eTs;
    private bh eTt;
    private String eTu;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aXr = null;
    private VideoInfo eTp = null;
    private boolean eTv = false;
    private int eTw = 0;
    private boolean eTx = false;
    private int eTy = 0;
    private int eTz = 0;
    private boolean eTB = false;
    private boolean eTC = false;
    private boolean eTG = true;
    private c.a eTI = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.jW(false);
        }
    };
    private c.k eTL = new c.k() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.k
        public void aUr() {
            if (i.this.eDC.checkUpIsLogin()) {
                i.this.eDC.aOU();
                if (i.this.eDC.aOi() != null && i.this.eDC.aOi().getPbData() != null && i.this.eDC.aOi().getPbData().aNx() != null) {
                    com.baidu.tieba.pb.data.l aNx = i.this.eDC.aOi().getPbData().aNx();
                    if (i.this.eTH == null) {
                        i.this.eTH = new com.baidu.tieba.pb.view.c(i.this.eDC.getActivity());
                        i.this.eTH.setFloatingHuajiAninationListener(i.this.eTI);
                    }
                    i.this.eTH.jY(!aNx.aNF());
                }
            }
        }
    };
    private Animation.AnimationListener dUY = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aSQ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private c.d eTM = new c.d() { // from class: com.baidu.tieba.pb.video.i.3
        @Override // com.baidu.tieba.play.c.d
        public void jX(boolean z) {
            i.this.kA(z ? "1" : "2");
        }
    };
    private t.a dXN = new t.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.t.a
        public void LF() {
        }
    };
    private c.g eTN = new c.g() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.g
        public void aiy() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(boolean z) {
        if (this.eDC.aOi() != null && this.eDC.aOi().getPbData() != null && this.eDC.aOi().getPbData().aNx() != null) {
            com.baidu.tieba.pb.data.l aNx = this.eDC.aOi().getPbData().aNx();
            View findViewById = this.eDC.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aNx.aNF() || z) {
                this.eDC.f(findViewById, 2, false);
                TiebaStatic.log(this.eDC.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aNx.aNF() ? 0 : 1));
            } else if (aNx.aNF()) {
                if (aNx.ezf == 1 || aNx.ezf == 3 || aNx.ezf == 4) {
                    this.eDC.f(findViewById, 2, true);
                    TiebaStatic.log(this.eDC.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aNx.aNF() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo) {
        this.eTA = 0.0f;
        this.eDC = pbActivity;
        this.eTm = cVar;
        this.eTA = com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ad = com.baidu.adp.lib.util.l.ad(this.eDC.getActivity());
        Rect s = aw.s(this.eDC.getPageContext().getPageActivity());
        int af = s.height() <= 0 ? com.baidu.adp.lib.util.l.af(this.eDC.getActivity()) : s.height();
        int i = (int) (ad * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eTE = (intValue2 * 1.0d) / intValue;
            if (this.eTE > 0.5625d) {
                i = Math.min((ad * intValue2) / intValue, af);
            }
        }
        this.eTD = i;
        this.eTn.setLayoutParams(new RelativeLayout.LayoutParams(ad, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eTl = (RelativeLayout) LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eTn = (CustomFrameLayout) this.eTl.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cup = new com.baidu.tieba.play.c(this.eDC.getPageContext(), this.eTn);
        this.cup.a(this.eTL);
        this.cup.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.11
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
                        i.this.eDC.getListView().smoothScrollBy(((int) (motionEvent.getY() - i.this.mLastY)) * (-2), 1);
                        i.this.mLastY = motionEvent.getY();
                        return false;
                    default:
                        return false;
                }
            }
        });
        if (intValue > 0) {
            if (this.eTE >= 1.0d) {
                this.cup.lv(false);
            } else {
                this.cup.lv(true);
            }
            this.eTB = ((float) b) + this.eTA > ((float) com.baidu.adp.lib.util.l.af(this.eDC.getActivity()));
            if (this.eTB) {
                if (this.eTq == null) {
                    this.eTq = new g(this.eDC.getPageContext(), this.eTn);
                    this.eTq.G(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.jW(true);
                        }
                    });
                }
                this.eDC.aOh().aRI();
                this.eTr = true;
            }
        }
        aUj();
        this.mEmptyView = new View(this.eDC);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.eTD));
        if (this.eTm != null && this.eTm.mNavigationBar != null) {
            this.eTm.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eTm.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.eTm.mNavigationBar.setStatusBarVisibility(8);
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eDC.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eTo == null) {
            this.eTo = new c.InterfaceC0120c() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.InterfaceC0120c
                public void eQ(boolean z) {
                    if (i.this.aUm() && i.this.eTm != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eTm.aSL().clearAnimation();
                        i.this.aUk();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dUY);
                            i.this.eTm.aSL().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0120c
                public void aix() {
                    if (i.this.aUm()) {
                        i.this.aSQ();
                    }
                }
            };
        }
        a(this.eTo);
        this.eTw = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bh bhVar, String str) {
        if (videoInfo != null && this.cup != null && bhVar != null) {
            this.eTp = videoInfo;
            this.eTs = bhVar;
            this.aXr = videoInfo.video_url;
            this.cup.stopPlay();
            this.cup.ls(true);
            this.bKD = new com.baidu.tieba.play.n(this.eDC.getActivity());
            this.cus = new x();
            this.cus.mLocate = "pb";
            this.cus.cyX = bhVar.getTid();
            this.cus.azf = str;
            this.cus.mUid = TbadkCoreApplication.getCurrentAccount();
            this.cus.mSource = bhVar.ZH;
            this.cus.fyd = bhVar.ZI;
            this.cus.fye = this.eDC.aOf();
            this.cus.fyf = bhVar.ZJ;
            this.cus.fyg = videoInfo.video_md5;
            x beF = this.cus.beF();
            beF.mLocate = "6";
            this.bKD.setVideoStatsData(beF);
            this.cup.getVideoView().setBusiness(this.bKD);
            if (this.cup.aEt()) {
                this.cup.aEr();
            }
            this.cup.b(this.eTF);
            this.eTu = null;
            this.eTt = null;
            this.cup.ps(this.eTu);
            this.cup.aEn().setOnDragingListener(this.dXN);
            this.cup.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.15
                @Override // com.baidu.tieba.play.c.b
                public void aiu() {
                    i.this.eDC.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eTG = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void ait() {
                    i.this.eDC.setSwipeBackEnabled(false);
                    i.this.eTG = false;
                }
            });
            this.cup.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.f
                public void aUs() {
                    if (i.this.eDC != null && i.this.eTt != null && !StringUtils.isNull(i.this.eTt.getId())) {
                        i.this.eDC.oK(i.this.eTt.getId());
                        if (i.this.eTs != null) {
                            long j = 0;
                            if (i.this.eTs.sz() != null) {
                                j = i.this.eTs.sz().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cup.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void eR(boolean z) {
                    if (i.this.eTs != null) {
                        long j = 0;
                        if (i.this.eTs.sz() != null) {
                            j = i.this.eTs.sz().channelId;
                        }
                        i.this.kA(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ad("tid", i.this.eTs.getTid()).f("fid", i.this.eTs.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cup.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aXr);
                    return true;
                }
            });
            this.cup.nk(videoInfo.thumbnail_url);
            this.cup.bR(videoInfo.play_count.intValue());
            this.cup.bO(this.aXr, bhVar.getTid());
            this.cup.setVideoTitle(bhVar.getTitle());
            this.cup.a(this.eTN);
            this.cup.aqF();
            this.cup.show();
        }
    }

    public void pr(String str) {
        if (this.cus != null) {
            this.cus.azf = str;
        }
    }

    public void b(PostData postData, bh bhVar, com.baidu.tieba.pb.data.l lVar) {
        if (this.eTq != null) {
            this.eTq.a(postData, bhVar, lVar);
        }
    }

    public void a(c.InterfaceC0120c interfaceC0120c) {
        this.eTF = interfaceC0120c;
    }

    public void ac(bh bhVar) {
        this.eTt = bhVar;
    }

    public void ps(String str) {
        this.eTu = str;
        if (this.cup != null) {
            this.cup.ps(this.eTu);
        }
    }

    public void startPlay() {
        if (this.cup != null) {
            this.cup.a(this.aXr, this.eTs == null ? "" : this.eTs.getTid(), this.eTM);
        }
    }

    public void aUi() {
        if (this.cup != null) {
            this.cup.aUi();
        }
    }

    public void destroy() {
        if (this.cup != null) {
            this.cup.destroy();
        }
        if (this.eTn != null) {
            this.eTn.clearAnimation();
        }
        if (this.eTq != null) {
            this.eTq.onDestroy();
        }
    }

    public void onPause() {
        if (this.cup != null) {
            if (this.cup.bea()) {
                this.eTv = true;
                this.cup.pausePlay();
            } else if (this.cup.beg() == 3) {
                this.eTv = false;
            } else {
                this.eTv = false;
                this.cup.pausePlay();
            }
            if (this.eTH != null) {
                this.eTH.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cup != null && this.eTv) {
            this.cup.aEw();
        }
    }

    private void aUj() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eDC.getActivity());
                    if (i.this.eTK == null) {
                        try {
                            i.this.eTK = BitmapFactory.decodeResource(i.this.eDC.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eTK);
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
                    i.this.eTJ = null;
                    if (i.this.eTK != null && !i.this.eTK.isRecycled()) {
                        i.this.eTK.recycle();
                    }
                    i.this.eTK = null;
                }
            });
            this.eTJ = dVar.eY();
            this.eTJ.k(this.eDC.getActivity());
        }
    }

    public boolean jm(int i) {
        if (this.cup == null) {
            return false;
        }
        return this.cup.rM(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA(String str) {
        if (this.eTp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.eTp.video_md5, "", str, this.cus);
            }
        }
    }

    public void aUk() {
        if (this.eTm != null) {
            this.eTm.jK(this.eDC.aOT());
        }
    }

    public void aSQ() {
        if (this.eTm != null) {
            this.eTm.aSQ();
        }
    }

    public void pH(int i) {
        if (this.eTm != null) {
            this.eTm.pH(i);
        }
        if (this.eTH != null) {
            this.eTH.onChangeSkinType(i);
        }
        if (this.eTq != null) {
            this.eTq.dE(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aUn()) {
                    this.eTy = i;
                    if (this.eTy == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.pO(i.this.aUo().getHeight());
                            }
                        }, 100L);
                    }
                    aUl();
                    return;
                }
                return;
        }
    }

    private void pN(int i) {
        if (aUo().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eTn.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.eTD != aUo().getHeight()) {
                        this.eTn.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ad(this.eDC.getActivity()), Math.min(this.eTD, aUo().getHeight() + i)));
                        this.cup.aEr();
                    }
                } else if (com.baidu.adp.lib.util.l.ad(this.eDC.getActivity()) * 0.5625d != aUo().getHeight()) {
                    this.eTn.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ad(this.eDC.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ad(this.eDC.getActivity()) * 0.5625d, aUo().getHeight() + i)));
                    this.cup.aEr();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aUq()) {
                int bottom = childAt.getBottom() - aUo().getBottom();
                if (childAt.getHeight() == 0 || aUo().getHeight() == 0) {
                    bottom = 0;
                }
                pN(bottom);
            } else {
                pN((-this.eTD) + 2);
            }
        }
        if (!aUn() && this.eTG) {
            if (this.eTy == 1) {
                pO(aUo().getHeight());
            } else if (this.eTy == 2) {
                int y = (int) aUo().getY();
                if (this.eTz == y) {
                    pO(aUo().getHeight());
                } else {
                    this.eTz = y;
                    pO(aUo().getHeight());
                }
                if (i == 0 && this.eTC) {
                    this.eTC = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aUi();
                        }
                    }, 100L);
                }
            } else if (this.eTy == 0) {
                if (this.cup.bea()) {
                    int height = aUo().getHeight() - Math.abs((int) aUo().getY());
                    return;
                }
                int y2 = (int) aUo().getY();
                pO(aUo().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(int i) {
        pP(i);
        pQ(i);
        aUl();
    }

    private void pP(int i) {
        if (i <= 0) {
            this.cup.lv(false);
        } else if (this.eTE >= 1.0d) {
            this.cup.lv(false);
        } else {
            this.cup.lv(true);
        }
    }

    private void pQ(int i) {
        if (this.eTq != null) {
            if (i == 0) {
                i = this.eTD;
            }
            float f = this.eTD - i;
            float f2 = f > this.eTA ? 0.0f : 1.0f - (f / this.eTA);
            if (f2 == 0.0f) {
                this.eTq.aUe().setVisibility(8);
            } else {
                this.eTq.aUe().setVisibility(0);
            }
            this.eTq.Y(f2);
        }
    }

    public void aUl() {
        if (this.eTq != null) {
            if (aUn()) {
                this.eDC.aOh().aRI();
            } else if (this.eTq.aUe().getVisibility() == 0) {
                this.eDC.aOh().aRI();
                this.eTr = true;
            } else if (this.eTr) {
                this.eDC.aOh().hh(false);
                this.eTr = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUm() {
        return aUo().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.eTx = false;
        if (this.cup != null && this.eTn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eTn.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eTJ != null) {
                    this.eTJ.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eTx = true;
                this.eTn.setLayoutParams(layoutParams);
                this.eDC.aOh().aRI();
                this.eTr = true;
            } else {
                b(this.eTp);
                aUk();
                this.eTx = false;
                this.eTm.setTitleVisibility(true);
            }
            this.cup.a(this.eDC.getPageContext(), configuration);
        }
    }

    public boolean aUn() {
        return this.eTx;
    }

    public void w(long j, int i) {
        if (this.eTq != null && j > 0) {
            this.eTq.k(i, j);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.eTq != null) {
            this.eTq.F(onClickListener);
        }
    }

    public View aUo() {
        return this.eTl;
    }

    public boolean aRU() {
        if (aUo() == null) {
            return false;
        }
        return aUo().getBottom() > com.baidu.adp.lib.util.l.af(aUo().getContext()) - com.baidu.adp.lib.util.l.f(aUo().getContext(), d.f.ds50);
    }

    public void aUp() {
        this.eTC = true;
    }

    public View aUq() {
        return this.mEmptyView;
    }
}
