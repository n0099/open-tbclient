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
    private com.baidu.tieba.play.m bKr;
    private com.baidu.tieba.play.c csS;
    private w csV;
    private PbActivity eGQ;
    private int eYA;
    private double eYB;
    private c.InterfaceC0119c eYC;
    private com.baidu.tieba.pb.view.c eYE;
    private com.baidu.adp.lib.guide.c eYG;
    private Bitmap eYH;
    private RelativeLayout eYi;
    private com.baidu.tieba.pb.pb.main.view.c eYj;
    private CustomFrameLayout eYk;
    private c.InterfaceC0119c eYl;
    private g eYn;
    private boolean eYo;
    private bj eYp;
    private bj eYq;
    private String eYr;
    private float eYx;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aVG = null;
    private VideoInfo eYm = null;
    private boolean eYs = false;
    private int eYt = 0;
    private boolean eYu = false;
    private int eYv = 0;
    private int eYw = 0;
    private boolean eYy = false;
    private boolean eYz = false;
    private boolean eYD = true;
    private c.a eYF = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kg(false);
        }
    };
    private c.k eYI = new c.k() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.k
        public void aVX() {
            if (i.this.eGQ.checkUpIsLogin()) {
                i.this.eGQ.aQO();
                if (i.this.eGQ.aQc() != null && i.this.eGQ.aQc().getPbData() != null && i.this.eGQ.aQc().getPbData().aPt() != null) {
                    com.baidu.tieba.pb.data.l aPt = i.this.eGQ.aQc().getPbData().aPt();
                    if (i.this.eYE == null) {
                        i.this.eYE = new com.baidu.tieba.pb.view.c(i.this.eGQ.getActivity());
                        i.this.eYE.setFloatingHuajiAninationListener(i.this.eYF);
                    }
                    i.this.eYE.ki(!aPt.aPA());
                }
            }
        }
    };
    private Animation.AnimationListener dXW = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aUw();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private c.d eYJ = new c.d() { // from class: com.baidu.tieba.pb.video.i.3
        @Override // com.baidu.tieba.play.c.d
        public void kh(boolean z) {
            i.this.kC(z ? "1" : "2");
        }
    };
    private s.a eaK = new s.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.s.a
        public void Lo() {
        }
    };
    private c.g eYK = new c.g() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.g
        public void aik() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(boolean z) {
        if (this.eGQ.aQc() != null && this.eGQ.aQc().getPbData() != null && this.eGQ.aQc().getPbData().aPt() != null) {
            com.baidu.tieba.pb.data.l aPt = this.eGQ.aQc().getPbData().aPt();
            View findViewById = this.eGQ.getActivity().findViewById(d.h.view_main_thread_praise_state);
            if (!aPt.aPA() || z) {
                this.eGQ.f(findViewById, 2, false);
                TiebaStatic.log(this.eGQ.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPt.aPA() ? 0 : 1));
            } else if (aPt.aPA()) {
                if (aPt.eEP == 1 || aPt.eEP == 3 || aPt.eEP == 4) {
                    this.eGQ.f(findViewById, 2, true);
                    TiebaStatic.log(this.eGQ.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPt.aPA() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo) {
        this.eYx = 0.0f;
        this.eGQ = pbActivity;
        this.eYj = cVar;
        this.eYx = com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds240);
        c(videoInfo);
        initData();
    }

    private int b(VideoInfo videoInfo) {
        int ad = com.baidu.adp.lib.util.k.ad(this.eGQ.getActivity());
        Rect s = aw.s(this.eGQ.getPageContext().getPageActivity());
        int ae = s.height() <= 0 ? com.baidu.adp.lib.util.k.ae(this.eGQ.getActivity()) : s.height();
        int i = (int) (ad * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.eYB = (intValue2 * 1.0d) / intValue;
            if (this.eYB > 0.5625d) {
                i = Math.min((ad * intValue2) / intValue, ae);
            }
        }
        this.eYA = i;
        this.eYk.setLayoutParams(new RelativeLayout.LayoutParams(ad, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.eYi = (RelativeLayout) LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.video_pb_container_layout, (ViewGroup) null);
        this.eYk = (CustomFrameLayout) this.eYi.findViewById(d.h.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.csS = new com.baidu.tieba.play.c(this.eGQ.getPageContext(), this.eYk);
        this.csS.a(this.eYI);
        this.csS.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.11
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
                        i.this.eGQ.getListView().smoothScrollBy(((int) (motionEvent.getY() - i.this.mLastY)) * (-2), 1);
                        i.this.mLastY = motionEvent.getY();
                        return false;
                    default:
                        return false;
                }
            }
        });
        if (intValue > 0) {
            if (this.eYB >= 1.0d) {
                this.csS.lB(false);
            } else {
                this.csS.lB(true);
            }
            this.eYy = ((float) b) + this.eYx > ((float) com.baidu.adp.lib.util.k.ae(this.eGQ.getActivity()));
            if (this.eYy) {
                if (this.eYn == null) {
                    this.eYn = new g(this.eGQ.getPageContext(), this.eYk);
                    this.eYn.E(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kg(true);
                        }
                    });
                }
                this.eGQ.aQb().aTp();
                this.eYo = true;
            }
        }
        aVP();
        this.mEmptyView = new View(this.eGQ);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.eYA));
        if (this.eYj != null && this.eYj.mNavigationBar != null) {
            this.eYj.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.eYj.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.eYj.mNavigationBar.setStatusBarVisibility(8);
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eGQ.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.eYl == null) {
            this.eYl = new c.InterfaceC0119c() { // from class: com.baidu.tieba.pb.video.i.13
                @Override // com.baidu.tieba.play.c.InterfaceC0119c
                public void eW(boolean z) {
                    if (i.this.aVS() && i.this.eYj != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.eYj.aUr().clearAnimation();
                        i.this.aVQ();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.dXW);
                            i.this.eYj.aUr().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0119c
                public void aij() {
                    if (i.this.aVS()) {
                        i.this.aUw();
                    }
                }
            };
        }
        a(this.eYl);
        this.eYt = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bj bjVar, String str) {
        if (videoInfo != null && this.csS != null && bjVar != null) {
            this.eYm = videoInfo;
            this.eYp = bjVar;
            this.aVG = videoInfo.video_url;
            this.csS.stopPlay();
            this.csS.ly(true);
            this.bKr = new com.baidu.tieba.play.m(this.eGQ.getActivity());
            this.csV = new w();
            this.csV.mLocate = "pb";
            this.csV.bGH = bjVar.getTid();
            this.csV.azO = str;
            this.csV.mUid = TbadkCoreApplication.getCurrentAccount();
            this.csV.mSource = bjVar.ZH;
            this.csV.fAV = bjVar.ZI;
            this.csV.fAW = this.eGQ.aPZ();
            if (bjVar.sF() != null && bjVar.sF().channelId > 0) {
                this.csV.VU = bjVar.sF().channelId + "";
            } else {
                this.csV.VU = "0";
            }
            this.csV.fAX = bjVar.ZJ;
            this.csV.fAY = videoInfo.video_md5;
            this.bKr.setVideoStatsData(this.csV);
            this.csS.getVideoView().setBusiness(this.bKr);
            if (this.csS.aFs()) {
                this.csS.aFq();
            }
            this.csS.b(this.eYC);
            this.eYr = null;
            this.eYq = null;
            this.csS.pH(this.eYr);
            this.csS.aFm().setOnDragingListener(this.eaK);
            this.csS.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.15
                @Override // com.baidu.tieba.play.c.b
                public void aig() {
                    i.this.eGQ.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.eYD = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void aif() {
                    i.this.eGQ.setSwipeBackEnabled(false);
                    i.this.eYD = false;
                }
            });
            this.csS.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.f
                public void aVY() {
                    if (i.this.eGQ != null && i.this.eYq != null && !StringUtils.isNull(i.this.eYq.getId())) {
                        i.this.eGQ.pe(i.this.eYq.getId());
                        if (i.this.eYp != null) {
                            long j = 0;
                            if (i.this.eYp.sF() != null) {
                                j = i.this.eYp.sF().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.csS.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void eX(boolean z) {
                    if (i.this.eYp != null) {
                        long j = 0;
                        if (i.this.eYp.sF() != null) {
                            j = i.this.eYp.sF().channelId;
                        }
                        i.this.kC(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ad("tid", i.this.eYp.getTid()).f("fid", i.this.eYp.getFid()).f("obj_id", j));
                    }
                }
            });
            this.csS.a(new f.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.f.b
                public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                    TiebaStatic.log(new ak("c12029").r("verrno", i).r("extra", i2));
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aVG);
                    return true;
                }
            });
            this.csS.nE(videoInfo.thumbnail_url);
            this.csS.bU(videoInfo.play_count.intValue());
            this.csS.setVideoUrl(this.aVG);
            this.csS.qz(bjVar.getTitle());
            this.csS.a(this.eYK);
            this.csS.arO();
            this.csS.show();
        }
    }

    public void pG(String str) {
        if (this.csV != null) {
            this.csV.azO = str;
        }
    }

    public void b(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        if (this.eYn != null) {
            this.eYn.a(postData, bjVar, lVar);
        }
    }

    public void a(c.InterfaceC0119c interfaceC0119c) {
        this.eYC = interfaceC0119c;
    }

    public void ah(bj bjVar) {
        this.eYq = bjVar;
    }

    public void pH(String str) {
        this.eYr = str;
        if (this.csS != null) {
            this.csS.pH(this.eYr);
        }
    }

    public void startPlay() {
        if (this.csS != null) {
            this.csS.a(this.aVG, this.eYJ);
        }
    }

    public void aVO() {
        if (this.csS != null) {
            this.csS.aVO();
        }
    }

    public void destroy() {
        if (this.csS != null) {
            this.csS.destroy();
        }
        if (this.eYk != null) {
            this.eYk.clearAnimation();
        }
        if (this.eYn != null) {
            this.eYn.onDestroy();
        }
    }

    public void onPause() {
        if (this.csS != null) {
            if (this.csS.bfo()) {
                this.eYs = true;
                this.csS.pausePlay();
            } else if (this.csS.bfu() == 3) {
                this.eYs = false;
            } else {
                this.eYs = false;
                this.csS.pausePlay();
            }
            if (this.eYE != null) {
                this.eYE.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.csS != null && this.eYs) {
            this.csS.aFv();
        }
    }

    private void aVP() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ae(16908290).ad(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eGQ.getActivity());
                    if (i.this.eYH == null) {
                        try {
                            i.this.eYH = BitmapFactory.decodeResource(i.this.eGQ.getResources(), d.g.live_video_guide_like);
                            imageView.setImageBitmap(i.this.eYH);
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
                    i.this.eYG = null;
                    if (i.this.eYH != null && !i.this.eYH.isRecycled()) {
                        i.this.eYH.recycle();
                    }
                    i.this.eYH = null;
                }
            });
            this.eYG = dVar.eZ();
            this.eYG.k(this.eGQ.getActivity());
        }
    }

    public boolean jc(int i) {
        if (this.csS == null) {
            return false;
        }
        return this.csS.rK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kC(String str) {
        if (this.eYm != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.k.a(this.eYm.video_md5, "", str, this.csV);
            }
        }
    }

    public void aVQ() {
        if (this.eYj != null) {
            this.eYj.jU(this.eGQ.aQN());
        }
    }

    public void aUw() {
        if (this.eYj != null) {
            this.eYj.aUw();
        }
    }

    public void pK(int i) {
        if (this.eYj != null) {
            this.eYj.pK(i);
        }
        if (this.eYE != null) {
            this.eYE.onChangeSkinType(i);
        }
        if (this.eYn != null) {
            this.eYn.du(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aVT()) {
                    this.eYv = i;
                    if (this.eYv == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.pR(i.this.aVU().getHeight());
                            }
                        }, 100L);
                    }
                    aVR();
                    return;
                }
                return;
        }
    }

    private void pQ(int i) {
        if (aVU().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYk.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.eYA != aVU().getHeight()) {
                        this.eYk.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.ad(this.eGQ.getActivity()), Math.min(this.eYA, aVU().getHeight() + i)));
                        this.csS.aFq();
                    }
                } else if (com.baidu.adp.lib.util.k.ad(this.eGQ.getActivity()) * 0.5625d != aVU().getHeight()) {
                    this.eYk.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.k.ad(this.eGQ.getActivity()), (int) Math.max(com.baidu.adp.lib.util.k.ad(this.eGQ.getActivity()) * 0.5625d, aVU().getHeight() + i)));
                    this.csS.aFq();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aVW()) {
                int bottom = childAt.getBottom() - aVU().getBottom();
                if (childAt.getHeight() == 0 || aVU().getHeight() == 0) {
                    bottom = 0;
                }
                pQ(bottom);
            } else {
                pQ((-this.eYA) + 2);
            }
        }
        if (!aVT() && this.eYD) {
            if (this.eYv == 1) {
                pR(aVU().getHeight());
            } else if (this.eYv == 2) {
                int y = (int) aVU().getY();
                if (this.eYw == y) {
                    pR(aVU().getHeight());
                } else {
                    this.eYw = y;
                    pR(aVU().getHeight());
                }
                if (i == 0 && this.eYz) {
                    this.eYz = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aVO();
                        }
                    }, 100L);
                }
            } else if (this.eYv == 0) {
                if (this.csS.bfo()) {
                    int height = aVU().getHeight() - Math.abs((int) aVU().getY());
                    return;
                }
                int y2 = (int) aVU().getY();
                pR(aVU().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(int i) {
        pS(i);
        pT(i);
        aVR();
    }

    private void pS(int i) {
        if (i <= 0) {
            this.csS.lB(false);
        } else if (this.eYB >= 1.0d) {
            this.csS.lB(false);
        } else {
            this.csS.lB(true);
        }
    }

    private void pT(int i) {
        if (this.eYn != null) {
            if (i == 0) {
                i = this.eYA;
            }
            float f = this.eYA - i;
            float f2 = f > this.eYx ? 0.0f : 1.0f - (f / this.eYx);
            if (f2 == 0.0f) {
                this.eYn.aVK().setVisibility(8);
            } else {
                this.eYn.aVK().setVisibility(0);
            }
            this.eYn.W(f2);
        }
    }

    public void aVR() {
        if (this.eYn != null) {
            if (aVT()) {
                this.eGQ.aQb().aTp();
            } else if (this.eYn.aVK().getVisibility() == 0) {
                this.eGQ.aQb().aTp();
                this.eYo = true;
            } else if (this.eYo) {
                this.eGQ.aQb().ht(false);
                this.eYo = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVS() {
        return aVU().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.eYu = false;
        if (this.csS != null && this.eYk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYk.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.eYG != null) {
                    this.eYG.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.eYu = true;
                this.eYk.setLayoutParams(layoutParams);
                this.eGQ.aQb().aTp();
                this.eYo = true;
            } else {
                b(this.eYm);
                aVQ();
                this.eYu = false;
                this.eYj.setTitleVisibility(true);
            }
            this.csS.a(this.eGQ.getPageContext(), configuration);
        }
    }

    public boolean aVT() {
        return this.eYu;
    }

    public void w(long j, int i) {
        if (this.eYn != null && j > 0) {
            this.eYn.k(i, j);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.eYn != null) {
            this.eYn.D(onClickListener);
        }
    }

    public View aVU() {
        return this.eYi;
    }

    public boolean aTz() {
        return this.eYy;
    }

    public void aVV() {
        this.eYz = true;
    }

    public View aVW() {
        return this.mEmptyView;
    }
}
