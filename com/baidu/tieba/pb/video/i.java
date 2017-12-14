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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
    private n bln;
    private com.baidu.tieba.play.c cLg;
    private PbActivity eVp;
    private RelativeLayout fjQ;
    private com.baidu.tieba.pb.pb.main.view.c fjR;
    private CustomFrameLayout fjS;
    private c.InterfaceC0137c fjT;
    private y fjV;
    private g fjW;
    private boolean fjX;
    private bd fjY;
    private bd fjZ;
    private String fka;
    private float fkg;
    private int fkj;
    private double fkk;
    private long fkl;
    private PbVideoWifiTipLayout fkm;
    private c.InterfaceC0137c fkn;
    private com.baidu.tieba.pb.view.c fkp;
    private com.baidu.adp.lib.guide.c fkr;
    private Bitmap fks;
    private boolean fkt;
    private int fkv;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String baI = null;
    private VideoInfo fjU = null;
    private boolean fkb = false;
    private int fkc = 0;
    private boolean fkd = false;
    private int fke = 0;
    private int fkf = 0;
    private boolean fkh = false;
    private boolean fki = false;
    private boolean fko = true;
    private c.a fkq = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kt(false);
        }
    };
    private c.k fku = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void aYE() {
            if (i.this.eVp.checkUpIsLogin()) {
                i.this.eVp.aTE();
                if (i.this.eVp.aSx() != null && i.this.eVp.aSx().getPbData() != null && i.this.eVp.aSx().getPbData().aRM() != null) {
                    l aRM = i.this.eVp.aSx().getPbData().aRM();
                    if (i.this.fkp == null) {
                        i.this.fkp = new com.baidu.tieba.pb.view.c(i.this.eVp.getActivity());
                        i.this.fkp.setFloatingHuajiAninationListener(i.this.fkq);
                    }
                    i.this.fkp.kv(!aRM.aRW());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.cLg != null) {
                    i.this.cLg.biT();
                }
                if (j.hh() && j.hj() && i.this.cLg != null && i.this.cLg.biV() && i.this.fjU != null && i.this.fjU.video_length.intValue() > 0 && i.this.fjU.video_duration.intValue() > 0) {
                    float intValue = i.this.fjU.video_length.intValue() * (1.0f - ((i.this.cLg.getCurrentPosition() * 1.0f) / (i.this.fjU.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(i.this.eVp.getPageContext().getPageActivity(), String.format(i.this.eVp.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener ejx = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.aXo();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private u.a emk = new u.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.u.a
        public void My() {
        }
    };
    private c.g fkw = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void amU() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(boolean z) {
        if (this.eVp.aSx() != null && this.eVp.aSx().getPbData() != null && this.eVp.aSx().getPbData().aRM() != null) {
            l aRM = this.eVp.aSx().getPbData().aRM();
            View findViewById = this.eVp.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aRM.aRW() || z) {
                this.eVp.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.eVp.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRM.aRW() ? 0 : 1));
            } else if (aRM.aRW()) {
                if (aRM.eQa == 1 || aRM.eQa == 3 || aRM.eQa == 4) {
                    this.eVp.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.eVp.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRM.aRW() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fkg = 0.0f;
        this.eVp = pbActivity;
        this.fjR = cVar;
        this.fkg = com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds240);
        this.fkl = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ac = com.baidu.adp.lib.util.l.ac(this.eVp.getActivity());
        Rect t = aw.t(this.eVp.getPageContext().getPageActivity());
        int ae = t.height() <= 0 ? com.baidu.adp.lib.util.l.ae(this.eVp.getActivity()) : t.height();
        int i = (int) (ac * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fkk = (intValue2 * 1.0d) / intValue;
            if (this.fkk > 0.5625d) {
                i = Math.min((ac * intValue2) / intValue, ae);
            }
        }
        this.fkj = i;
        this.fjS.setLayoutParams(new RelativeLayout.LayoutParams(ac, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fjQ = (RelativeLayout) LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fjS = (CustomFrameLayout) this.fjQ.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cLg = new com.baidu.tieba.play.c(this.eVp.getPageContext(), this.fjS);
        this.cLg.a(this.fku);
        this.cLg.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.eVp.getListView() != null && i.this.eVp.getListView().getChildCount() > 0 && i.this.eVp.getListView().getChildAt(0) == i.this.aYC()) {
                            i.this.fkv = i.this.aYC().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fkv = 0;
                        break;
                    case 2:
                        if (i.this.eVp.getListView() != null && i.this.eVp.getListView().getChildCount() > 0 && i.this.eVp.getListView().getChildAt(0) == i.this.aYC()) {
                            i.this.eVp.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fkv);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fkk >= 1.0d) {
                this.cLg.lU(false);
            } else {
                this.cLg.lU(true);
            }
            this.fkh = ((float) b) + this.fkg > ((float) com.baidu.adp.lib.util.l.ae(this.eVp.getActivity()));
            if (this.fkh) {
                if (this.fjW == null) {
                    this.fjW = new g(this.eVp.getPageContext(), this.fjS);
                    this.fjW.I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kt(true);
                        }
                    });
                }
                this.eVp.aSR().aWE();
                this.fjX = true;
            }
        }
        aYv();
        this.mEmptyView = new View(this.eVp);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fkj));
        if (this.fjR != null && this.fjR.mNavigationBar != null) {
            this.fjR.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fjR.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fjR.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fkm = (PbVideoWifiTipLayout) this.fjQ.findViewById(d.g.layout_wifi_tip);
        this.fkm.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fkt = true;
                i.this.fkm.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eVp.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fjT == null) {
            this.fjT = new c.InterfaceC0137c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0137c
                public void fi(boolean z) {
                    if (i.this.aYy() && i.this.fjR != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fjR.aXj().clearAnimation();
                        i.this.aYw();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.ejx);
                            i.this.fjR.aXj().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0137c
                public void amT() {
                    if (i.this.aYy()) {
                        i.this.aXo();
                    }
                }
            };
        }
        a(this.fjT);
        this.fkc = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.cLg != null && bdVar != null) {
            this.fjU = videoInfo;
            this.fjY = bdVar;
            this.baI = videoInfo.video_url;
            this.cLg.stopPlay();
            this.cLg.lR(true);
            this.bln = new n(this.eVp.getActivity());
            this.fjV = new y();
            this.fjV.mLocate = "pb";
            this.fjV.aMU = bdVar.getTid();
            this.fjV.aAs = str;
            this.fjV.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fjV.mSource = bdVar.aad;
            this.fjV.fRj = bdVar.aae;
            this.fjV.fRk = this.eVp.aSP();
            this.fjV.fRl = bdVar.aaf;
            this.fjV.fRm = videoInfo.video_md5;
            y bjL = this.fjV.bjL();
            bjL.mLocate = "6";
            this.bln.setVideoStatsData(bjL);
            this.cLg.getVideoView().setBusiness(this.bln);
            if (this.cLg.aHE()) {
                this.cLg.aHC();
            }
            this.cLg.b(this.fkn);
            this.fka = null;
            this.fjZ = null;
            this.cLg.qn(this.fka);
            this.cLg.aHy().setOnDragingListener(this.emk);
            this.cLg.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void amQ() {
                    i.this.eVp.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fko = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void amP() {
                    i.this.eVp.setSwipeBackEnabled(false);
                    i.this.fko = false;
                }
            });
            this.cLg.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void aYD() {
                    if (i.this.eVp != null && i.this.fjZ != null && !StringUtils.isNull(i.this.fjZ.getId())) {
                        i.this.eVp.pI(i.this.fjZ.getId());
                        if (i.this.fjY != null) {
                            long j = 0;
                            if (i.this.fjY.sA() != null) {
                                j = i.this.fjY.sA().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cLg.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void ku(boolean z) {
                    if (i.this.fjY != null) {
                        long j = 0;
                        if (i.this.fjY.sA() != null) {
                            j = i.this.fjY.sA().channelId;
                        }
                        i.this.le(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ac("tid", i.this.fjY.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fjY.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cLg.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), ISapiAccount.SAPI_ACCOUNT_EXTRA, Integer.valueOf(i2), "url", i.this.baI);
                    return true;
                }
            });
            this.cLg.nP(videoInfo.thumbnail_url);
            this.cLg.bP(this.baI, bdVar.getTid());
            this.cLg.rm(bdVar.getTitle());
            this.cLg.a(this.fkw);
            this.cLg.auW();
            this.cLg.show();
        }
    }

    public void qm(String str) {
        if (this.fjV != null) {
            this.fjV.aAs = str;
        }
    }

    public void b(PostData postData, bd bdVar, l lVar) {
        if (this.fjW != null) {
            this.fjW.a(postData, bdVar, lVar);
        }
    }

    public void a(c.InterfaceC0137c interfaceC0137c) {
        this.fkn = interfaceC0137c;
    }

    public void af(bd bdVar) {
        this.fjZ = bdVar;
    }

    public void qn(String str) {
        this.fka = str;
        if (this.cLg != null) {
            this.cLg.qn(this.fka);
        }
    }

    public void startPlay() {
        if (this.cLg != null) {
            if (j.hj() && !this.fkt) {
                this.fkm.setVisibility(0);
                this.fkm.setData(this.fjU);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.baI) && this.fjY != null && this.fjY.rN() != null) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "pb").ac("tid", this.fjY.getTid()));
                this.baI = this.fjY.rN().video_url;
            }
            this.cLg.c(this.baI, this.fjY == null ? "" : this.fjY.getTid(), this.fkl);
            le("2");
        }
    }

    public void aYu() {
        if (this.cLg != null) {
            this.cLg.aYu();
        }
    }

    public void destroy() {
        if (this.cLg != null) {
            this.cLg.destroy();
        }
        if (this.fjS != null) {
            this.fjS.clearAnimation();
        }
        if (this.fjW != null) {
            this.fjW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.cLg != null) {
            if (this.cLg.biV()) {
                this.fkb = true;
                this.cLg.pausePlay();
            } else if (this.cLg.bjb() == 3) {
                this.fkb = false;
            } else {
                this.fkb = false;
                this.cLg.pausePlay();
            }
            if (this.fkp != null) {
                this.fkp.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cLg != null && this.fkb) {
            this.cLg.aHH();
        }
    }

    private void aYv() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.z(true);
            dVar.B(false);
            dVar.ad(16908290).ac(153).A(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.eVp.getActivity());
                    if (i.this.fks == null) {
                        try {
                            i.this.fks = BitmapFactory.decodeResource(i.this.eVp.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fks);
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
                    i.this.fkr = null;
                    if (i.this.fks != null && !i.this.fks.isRecycled()) {
                        i.this.fks.recycle();
                    }
                    i.this.fks = null;
                }
            });
            this.fkr = dVar.eY();
            this.fkr.k(this.eVp.getActivity());
        }
    }

    public boolean ka(int i) {
        if (this.cLg == null) {
            return false;
        }
        return this.cLg.sw(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(String str) {
        if (this.fjU != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fjU.video_md5, "", str, this.fjV);
            }
        }
    }

    public void aYw() {
        if (this.fjR != null) {
            this.fjR.ki(this.eVp.aTD());
        }
    }

    public void aXo() {
        if (this.fjR != null) {
            this.fjR.aXo();
        }
    }

    public void qt(int i) {
        if (this.fjR != null) {
            this.fjR.qt(i);
        }
        if (this.fkp != null) {
            this.fkp.onChangeSkinType(i);
        }
        if (this.fjW != null) {
            this.fjW.dE(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aYz()) {
                    this.fke = i;
                    if (this.fke == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qz(i.this.aYA().getHeight());
                            }
                        }, 100L);
                    }
                    aYx();
                    return;
                }
                return;
        }
    }

    private void qy(int i) {
        if (aYA().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjS.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fkj != aYA().getHeight()) {
                        this.fjS.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eVp.getActivity()), Math.min(this.fkj, aYA().getHeight() + i)));
                        this.cLg.aHC();
                    }
                } else if (com.baidu.adp.lib.util.l.ac(this.eVp.getActivity()) * 0.5625d != aYA().getHeight()) {
                    this.fjS.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eVp.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ac(this.eVp.getActivity()) * 0.5625d, aYA().getHeight() + i)));
                    this.cLg.aHC();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == aYC()) {
                int bottom = childAt.getBottom() - aYA().getBottom();
                if (childAt.getHeight() == 0 || aYA().getHeight() == 0) {
                    bottom = 0;
                }
                qy(bottom);
            } else {
                qy((-this.fkj) + 2);
            }
        }
        if (!aYz() && this.fko) {
            if (this.fke == 1) {
                qz(aYA().getHeight());
            } else if (this.fke == 2) {
                int y = (int) aYA().getY();
                if (this.fkf == y) {
                    qz(aYA().getHeight());
                } else {
                    this.fkf = y;
                    qz(aYA().getHeight());
                }
                if (i == 0 && this.fki) {
                    this.fki = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aYu();
                        }
                    }, 100L);
                }
            } else if (this.fke == 0) {
                qz(aYA().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qz(int i) {
        qA(i);
        aYx();
    }

    private void qA(int i) {
        if (this.fjW != null) {
            if (i == 0) {
                i = this.fkj;
            }
            float f = this.fkj - i;
            float f2 = f > this.fkg ? 0.0f : 1.0f - (f / this.fkg);
            if (f2 == 0.0f) {
                this.fjW.aYq().setVisibility(8);
            } else {
                this.fjW.aYq().setVisibility(0);
            }
            this.fjW.Y(f2);
        }
    }

    public void aYx() {
        if (this.fjW != null) {
            if (aYz()) {
                this.eVp.aSR().aWE();
            } else if (this.fjW.aYq().getVisibility() == 0) {
                this.eVp.aSR().aWE();
                this.fjX = true;
            } else if (this.fjX) {
                this.eVp.aSR().jW(false);
                this.fjX = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYy() {
        return aYA().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fkd = false;
        if (this.cLg != null && this.fjS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjS.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.fkr != null) {
                    this.fkr.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fkd = true;
                this.fjS.setLayoutParams(layoutParams);
                this.eVp.aSR().aWE();
                this.fjX = true;
            } else {
                b(this.fjU);
                aYw();
                this.fkd = false;
                this.fjR.setTitleVisibility(true);
            }
            this.cLg.a(this.eVp.getPageContext(), configuration);
        }
    }

    public boolean aYz() {
        return this.fkd;
    }

    public void y(long j, int i) {
        if (this.fjW != null && j > 0) {
            this.fjW.l(i, j);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fjW != null) {
            this.fjW.H(onClickListener);
        }
    }

    public View aYA() {
        return this.fjQ;
    }

    public boolean aWQ() {
        if (aYA() == null) {
            return false;
        }
        return aYA().getBottom() > com.baidu.adp.lib.util.l.ae(aYA().getContext()) - com.baidu.adp.lib.util.l.f(aYA().getContext(), d.e.ds50);
    }

    public void aYB() {
        this.fki = true;
    }

    public View aYC() {
        return this.mEmptyView;
    }
}
