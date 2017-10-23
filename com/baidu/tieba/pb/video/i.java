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
    private com.baidu.tieba.play.n bKr;
    private com.baidu.tieba.play.c cud;
    private x cug;
    private PbActivity eDo;
    private RelativeLayout eSX;
    private com.baidu.tieba.pb.pb.main.view.c eSY;
    private CustomFrameLayout eSZ;
    private c.InterfaceC0120c eTa;
    private g eTc;
    private boolean eTd;
    private bh eTe;
    private bh eTf;
    private String eTg;
    private float eTm;
    private int eTp;
    private double eTq;
    private c.InterfaceC0120c eTr;
    private com.baidu.tieba.pb.view.c eTt;
    private com.baidu.adp.lib.guide.c eTv;
    private Bitmap eTw;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aXe = null;
    private VideoInfo eTb = null;
    private boolean eTh = false;
    private int eTi = 0;
    private boolean eTj = false;
    private int eTk = 0;
    private int eTl = 0;
    private boolean eTn = false;
    private boolean eTo = false;
    private boolean eTs = true;
    private c.a eTu = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.jV(false);
        }
    };
    private c.k eTx = new c.k() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.k
        public void aUm() {
            if (i.this.eDo.checkUpIsLogin()) {
                i.this.eDo.aOP();
                if (i.this.eDo.aOd() != null && i.this.eDo.aOd().getPbData() != null && i.this.eDo.aOd().getPbData().aNs() != null) {
                    com.baidu.tieba.pb.data.l aNs = i.this.eDo.aOd().getPbData().aNs();
                    if (i.this.eTt == null) {
                        i.this.eTt = new com.baidu.tieba.pb.view.c(i.this.eDo.getActivity());
                        i.this.eTt.setFloatingHuajiAninationListener(i.this.eTu);
                    }
                    i.this.eTt.jX(!aNs.aNA());
                }
            }
        }
    };
    private Animation.AnimationListener dUK = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aSL();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private c.d eTy = new c.d() { // from class: com.baidu.tieba.pb.video.i.3
        @Override // com.baidu.tieba.play.c.d
        public void jW(boolean z) {
            i.this.ky(z ? "1" : "2");
        }
    };
    private t.a dXz = new t.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.t.a
        public void Lz() {
        }
    };
    private c.g eTz = new c.g() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.g
        public void ait() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jV(boolean z) {
        if (this.eDo.aOd() != null && this.eDo.aOd().getPbData() != null && this.eDo.aOd().getPbData().aNs() != null) {
            com.baidu.tieba.pb.data.l aNs = this.eDo.aOd().getPbData().aNs();
            View findViewById = this.eDo.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aNs.aNA() || z) {
                this.eDo.f(findViewById, 2, false);
                TiebaStatic.log(this.eDo.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aNs.aNA() ? 0 : 1));
            } else if (aNs.aNA()) {
                if (aNs.eyR == 1 || aNs.eyR == 3 || aNs.eyR == 4) {
                    this.eDo.f(findViewById, 2, true);
                    TiebaStatic.log(this.eDo.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aNs.aNA() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo) {
        this.eTm = 0.0f;
        this.eDo = pbActivity;
        this.eSY = cVar;
        this.eTm = com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ad = com.baidu.adp.lib.util.l.ad(this.eDo.getActivity());
        Rect t = aw.t(this.eDo.getPageContext().getPageActivity());
        int af = t.height() <= 0 ? com.baidu.adp.lib.util.l.af(this.eDo.getActivity()) : t.height();
        int i = (int) (ad * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eTq = (intValue2 * 1.0d) / intValue;
            if (this.eTq > 0.5625d) {
                i = Math.min((ad * intValue2) / intValue, af);
            }
        }
        this.eTp = i;
        this.eSZ.setLayoutParams(new RelativeLayout.LayoutParams(ad, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eSX = (RelativeLayout) LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eSZ = (CustomFrameLayout) this.eSX.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cud = new com.baidu.tieba.play.c(this.eDo.getPageContext(), this.eSZ);
        this.cud.a(this.eTx);
        this.cud.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.11
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
                        i.this.eDo.getListView().smoothScrollBy(((int) (motionEvent.getY() - i.this.mLastY)) * (-2), 1);
                        i.this.mLastY = motionEvent.getY();
                        return false;
                    default:
                        return false;
                }
            }
        });
        if (intValue > 0) {
            if (this.eTq >= 1.0d) {
                this.cud.lu(false);
            } else {
                this.cud.lu(true);
            }
            this.eTn = ((float) b) + this.eTm > ((float) com.baidu.adp.lib.util.l.af(this.eDo.getActivity()));
            if (this.eTn) {
                if (this.eTc == null) {
                    this.eTc = new g(this.eDo.getPageContext(), this.eSZ);
                    this.eTc.G(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.jV(true);
                        }
                    });
                }
                this.eDo.aOc().aRD();
                this.eTd = true;
            }
        }
        aUe();
        this.mEmptyView = new View(this.eDo);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.eTp));
        if (this.eSY != null && this.eSY.mNavigationBar != null) {
            this.eSY.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eSY.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.eSY.mNavigationBar.setStatusBarVisibility(8);
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eDo.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eTa == null) {
            this.eTa = new c.InterfaceC0120c() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.InterfaceC0120c
                public void eP(boolean z) {
                    if (i.this.aUh() && i.this.eSY != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eSY.aSG().clearAnimation();
                        i.this.aUf();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dUK);
                            i.this.eSY.aSG().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0120c
                public void ais() {
                    if (i.this.aUh()) {
                        i.this.aSL();
                    }
                }
            };
        }
        a(this.eTa);
        this.eTi = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bh bhVar, String str) {
        if (videoInfo != null && this.cud != null && bhVar != null) {
            this.eTb = videoInfo;
            this.eTe = bhVar;
            this.aXe = videoInfo.video_url;
            this.cud.stopPlay();
            this.cud.lr(true);
            this.bKr = new com.baidu.tieba.play.n(this.eDo.getActivity());
            this.cug = new x();
            this.cug.mLocate = "pb";
            this.cug.cyL = bhVar.getTid();
            this.cug.ayT = str;
            this.cug.mUid = TbadkCoreApplication.getCurrentAccount();
            this.cug.mSource = bhVar.Zv;
            this.cug.fxO = bhVar.Zw;
            this.cug.fxP = this.eDo.aOa();
            this.cug.fxQ = bhVar.Zx;
            this.cug.fxR = videoInfo.video_md5;
            x bez = this.cug.bez();
            bez.mLocate = "6";
            this.bKr.setVideoStatsData(bez);
            this.cud.getVideoView().setBusiness(this.bKr);
            if (this.cud.aEo()) {
                this.cud.aEm();
            }
            this.cud.b(this.eTr);
            this.eTg = null;
            this.eTf = null;
            this.cud.pr(this.eTg);
            this.cud.aEi().setOnDragingListener(this.dXz);
            this.cud.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.15
                @Override // com.baidu.tieba.play.c.b
                public void aip() {
                    i.this.eDo.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eTs = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aio() {
                    i.this.eDo.setSwipeBackEnabled(false);
                    i.this.eTs = false;
                }
            });
            this.cud.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.f
                public void aUn() {
                    if (i.this.eDo != null && i.this.eTf != null && !StringUtils.isNull(i.this.eTf.getId())) {
                        i.this.eDo.oJ(i.this.eTf.getId());
                        if (i.this.eTe != null) {
                            long j = 0;
                            if (i.this.eTe.ss() != null) {
                                j = i.this.eTe.ss().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cud.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void eQ(boolean z) {
                    if (i.this.eTe != null) {
                        long j = 0;
                        if (i.this.eTe.ss() != null) {
                            j = i.this.eTe.ss().channelId;
                        }
                        i.this.ky(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ac("tid", i.this.eTe.getTid()).f("fid", i.this.eTe.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cud.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aXe);
                    return true;
                }
            });
            this.cud.nj(videoInfo.thumbnail_url);
            this.cud.bS(videoInfo.play_count.intValue());
            this.cud.bN(this.aXe, bhVar.getTid());
            this.cud.setVideoTitle(bhVar.getTitle());
            this.cud.a(this.eTz);
            this.cud.aqA();
            this.cud.show();
        }
    }

    public void pq(String str) {
        if (this.cug != null) {
            this.cug.ayT = str;
        }
    }

    public void b(PostData postData, bh bhVar, com.baidu.tieba.pb.data.l lVar) {
        if (this.eTc != null) {
            this.eTc.a(postData, bhVar, lVar);
        }
    }

    public void a(c.InterfaceC0120c interfaceC0120c) {
        this.eTr = interfaceC0120c;
    }

    public void ac(bh bhVar) {
        this.eTf = bhVar;
    }

    public void pr(String str) {
        this.eTg = str;
        if (this.cud != null) {
            this.cud.pr(this.eTg);
        }
    }

    public void startPlay() {
        if (this.cud != null) {
            this.cud.a(this.aXe, this.eTe == null ? "" : this.eTe.getTid(), this.eTy);
        }
    }

    public void aUd() {
        if (this.cud != null) {
            this.cud.aUd();
        }
    }

    public void destroy() {
        if (this.cud != null) {
            this.cud.destroy();
        }
        if (this.eSZ != null) {
            this.eSZ.clearAnimation();
        }
        if (this.eTc != null) {
            this.eTc.onDestroy();
        }
    }

    public void onPause() {
        if (this.cud != null) {
            if (this.cud.bdU()) {
                this.eTh = true;
                this.cud.pausePlay();
            } else if (this.cud.bea() == 3) {
                this.eTh = false;
            } else {
                this.eTh = false;
                this.cud.pausePlay();
            }
            if (this.eTt != null) {
                this.eTt.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cud != null && this.eTh) {
            this.cud.aEr();
        }
    }

    private void aUe() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eDo.getActivity());
                    if (i.this.eTw == null) {
                        try {
                            i.this.eTw = BitmapFactory.decodeResource(i.this.eDo.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eTw);
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
                    i.this.eTv = null;
                    if (i.this.eTw != null && !i.this.eTw.isRecycled()) {
                        i.this.eTw.recycle();
                    }
                    i.this.eTw = null;
                }
            });
            this.eTv = dVar.eY();
            this.eTv.k(this.eDo.getActivity());
        }
    }

    public boolean jl(int i) {
        if (this.cud == null) {
            return false;
        }
        return this.cud.rL(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(String str) {
        if (this.eTb != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.eTb.video_md5, "", str, this.cug);
            }
        }
    }

    public void aUf() {
        if (this.eSY != null) {
            this.eSY.jJ(this.eDo.aOO());
        }
    }

    public void aSL() {
        if (this.eSY != null) {
            this.eSY.aSL();
        }
    }

    public void pG(int i) {
        if (this.eSY != null) {
            this.eSY.pG(i);
        }
        if (this.eTt != null) {
            this.eTt.onChangeSkinType(i);
        }
        if (this.eTc != null) {
            this.eTc.dD(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aUi()) {
                    this.eTk = i;
                    if (this.eTk == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.pN(i.this.aUj().getHeight());
                            }
                        }, 100L);
                    }
                    aUg();
                    return;
                }
                return;
        }
    }

    private void pM(int i) {
        if (aUj().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSZ.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.eTp != aUj().getHeight()) {
                        this.eSZ.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ad(this.eDo.getActivity()), Math.min(this.eTp, aUj().getHeight() + i)));
                        this.cud.aEm();
                    }
                } else if (com.baidu.adp.lib.util.l.ad(this.eDo.getActivity()) * 0.5625d != aUj().getHeight()) {
                    this.eSZ.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ad(this.eDo.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ad(this.eDo.getActivity()) * 0.5625d, aUj().getHeight() + i)));
                    this.cud.aEm();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aUl()) {
                int bottom = childAt.getBottom() - aUj().getBottom();
                if (childAt.getHeight() == 0 || aUj().getHeight() == 0) {
                    bottom = 0;
                }
                pM(bottom);
            } else {
                pM((-this.eTp) + 2);
            }
        }
        if (!aUi() && this.eTs) {
            if (this.eTk == 1) {
                pN(aUj().getHeight());
            } else if (this.eTk == 2) {
                int y = (int) aUj().getY();
                if (this.eTl == y) {
                    pN(aUj().getHeight());
                } else {
                    this.eTl = y;
                    pN(aUj().getHeight());
                }
                if (i == 0 && this.eTo) {
                    this.eTo = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aUd();
                        }
                    }, 100L);
                }
            } else if (this.eTk == 0) {
                if (this.cud.bdU()) {
                    int height = aUj().getHeight() - Math.abs((int) aUj().getY());
                    return;
                }
                int y2 = (int) aUj().getY();
                pN(aUj().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(int i) {
        pO(i);
        pP(i);
        aUg();
    }

    private void pO(int i) {
        if (i <= 0) {
            this.cud.lu(false);
        } else if (this.eTq >= 1.0d) {
            this.cud.lu(false);
        } else {
            this.cud.lu(true);
        }
    }

    private void pP(int i) {
        if (this.eTc != null) {
            if (i == 0) {
                i = this.eTp;
            }
            float f = this.eTp - i;
            float f2 = f > this.eTm ? 0.0f : 1.0f - (f / this.eTm);
            if (f2 == 0.0f) {
                this.eTc.aTZ().setVisibility(8);
            } else {
                this.eTc.aTZ().setVisibility(0);
            }
            this.eTc.Y(f2);
        }
    }

    public void aUg() {
        if (this.eTc != null) {
            if (aUi()) {
                this.eDo.aOc().aRD();
            } else if (this.eTc.aTZ().getVisibility() == 0) {
                this.eDo.aOc().aRD();
                this.eTd = true;
            } else if (this.eTd) {
                this.eDo.aOc().hg(false);
                this.eTd = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUh() {
        return aUj().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.eTj = false;
        if (this.cud != null && this.eSZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSZ.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eTv != null) {
                    this.eTv.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eTj = true;
                this.eSZ.setLayoutParams(layoutParams);
                this.eDo.aOc().aRD();
                this.eTd = true;
            } else {
                b(this.eTb);
                aUf();
                this.eTj = false;
                this.eSY.setTitleVisibility(true);
            }
            this.cud.a(this.eDo.getPageContext(), configuration);
        }
    }

    public boolean aUi() {
        return this.eTj;
    }

    public void w(long j, int i) {
        if (this.eTc != null && j > 0) {
            this.eTc.k(i, j);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.eTc != null) {
            this.eTc.F(onClickListener);
        }
    }

    public View aUj() {
        return this.eSX;
    }

    public boolean aRP() {
        if (aUj() == null) {
            return false;
        }
        return aUj().getBottom() > com.baidu.adp.lib.util.l.af(aUj().getContext()) - com.baidu.adp.lib.util.l.f(aUj().getContext(), d.f.ds50);
    }

    public void aUk() {
        this.eTo = true;
    }

    public View aUl() {
        return this.mEmptyView;
    }
}
