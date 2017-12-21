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
    private n blr;
    private com.baidu.tieba.play.c cLk;
    private PbActivity eVu;
    private RelativeLayout fjV;
    private com.baidu.tieba.pb.pb.main.view.c fjW;
    private CustomFrameLayout fjX;
    private c.InterfaceC0136c fjY;
    private int fkA;
    private y fka;
    private g fkb;
    private boolean fkc;
    private bd fkd;
    private bd fke;
    private String fkf;
    private float fkl;
    private int fko;
    private double fkp;
    private long fkq;
    private PbVideoWifiTipLayout fkr;
    private c.InterfaceC0136c fks;
    private com.baidu.tieba.pb.view.c fku;
    private com.baidu.adp.lib.guide.c fkw;
    private Bitmap fkx;
    private boolean fky;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String baM = null;
    private VideoInfo fjZ = null;
    private boolean fkg = false;
    private int fkh = 0;
    private boolean fki = false;
    private int fkj = 0;
    private int fkk = 0;
    private boolean fkm = false;
    private boolean fkn = false;
    private boolean fkt = true;
    private c.a fkv = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kt(false);
        }
    };
    private c.k fkz = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void aYE() {
            if (i.this.eVu.checkUpIsLogin()) {
                i.this.eVu.aTE();
                if (i.this.eVu.aSx() != null && i.this.eVu.aSx().getPbData() != null && i.this.eVu.aSx().getPbData().aRM() != null) {
                    l aRM = i.this.eVu.aSx().getPbData().aRM();
                    if (i.this.fku == null) {
                        i.this.fku = new com.baidu.tieba.pb.view.c(i.this.eVu.getActivity());
                        i.this.fku.setFloatingHuajiAninationListener(i.this.fkv);
                    }
                    i.this.fku.kv(!aRM.aRW());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.cLk != null) {
                    i.this.cLk.biT();
                }
                if (j.hh() && j.hj() && i.this.cLk != null && i.this.cLk.biV() && i.this.fjZ != null && i.this.fjZ.video_length.intValue() > 0 && i.this.fjZ.video_duration.intValue() > 0) {
                    float intValue = i.this.fjZ.video_length.intValue() * (1.0f - ((i.this.cLk.getCurrentPosition() * 1.0f) / (i.this.fjZ.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(i.this.eVu.getPageContext().getPageActivity(), String.format(i.this.eVu.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener ejB = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
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
    private u.a emo = new u.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.u.a
        public void My() {
        }
    };
    private c.g fkB = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void amU() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(boolean z) {
        if (this.eVu.aSx() != null && this.eVu.aSx().getPbData() != null && this.eVu.aSx().getPbData().aRM() != null) {
            l aRM = this.eVu.aSx().getPbData().aRM();
            View findViewById = this.eVu.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aRM.aRW() || z) {
                this.eVu.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.eVu.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRM.aRW() ? 0 : 1));
            } else if (aRM.aRW()) {
                if (aRM.eQf == 1 || aRM.eQf == 3 || aRM.eQf == 4) {
                    this.eVu.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.eVu.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRM.aRW() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fkl = 0.0f;
        this.eVu = pbActivity;
        this.fjW = cVar;
        this.fkl = com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds240);
        this.fkq = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ac = com.baidu.adp.lib.util.l.ac(this.eVu.getActivity());
        Rect t = aw.t(this.eVu.getPageContext().getPageActivity());
        int ae = t.height() <= 0 ? com.baidu.adp.lib.util.l.ae(this.eVu.getActivity()) : t.height();
        int i = (int) (ac * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fkp = (intValue2 * 1.0d) / intValue;
            if (this.fkp > 0.5625d) {
                i = Math.min((ac * intValue2) / intValue, ae);
            }
        }
        this.fko = i;
        this.fjX.setLayoutParams(new RelativeLayout.LayoutParams(ac, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fjV = (RelativeLayout) LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fjX = (CustomFrameLayout) this.fjV.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.cLk = new com.baidu.tieba.play.c(this.eVu.getPageContext(), this.fjX);
        this.cLk.a(this.fkz);
        this.cLk.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.eVu.getListView() != null && i.this.eVu.getListView().getChildCount() > 0 && i.this.eVu.getListView().getChildAt(0) == i.this.aYC()) {
                            i.this.fkA = i.this.aYC().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fkA = 0;
                        break;
                    case 2:
                        if (i.this.eVu.getListView() != null && i.this.eVu.getListView().getChildCount() > 0 && i.this.eVu.getListView().getChildAt(0) == i.this.aYC()) {
                            i.this.eVu.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fkA);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fkp >= 1.0d) {
                this.cLk.lU(false);
            } else {
                this.cLk.lU(true);
            }
            this.fkm = ((float) b) + this.fkl > ((float) com.baidu.adp.lib.util.l.ae(this.eVu.getActivity()));
            if (this.fkm) {
                if (this.fkb == null) {
                    this.fkb = new g(this.eVu.getPageContext(), this.fjX);
                    this.fkb.I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kt(true);
                        }
                    });
                }
                this.eVu.aSR().aWE();
                this.fkc = true;
            }
        }
        aYv();
        this.mEmptyView = new View(this.eVu);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fko));
        if (this.fjW != null && this.fjW.mNavigationBar != null) {
            this.fjW.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fjW.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fjW.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fkr = (PbVideoWifiTipLayout) this.fjV.findViewById(d.g.layout_wifi_tip);
        this.fkr.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fky = true;
                i.this.fkr.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.eVu.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fjY == null) {
            this.fjY = new c.InterfaceC0136c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0136c
                public void fi(boolean z) {
                    if (i.this.aYy() && i.this.fjW != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fjW.aXj().clearAnimation();
                        i.this.aYw();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.ejB);
                            i.this.fjW.aXj().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0136c
                public void amT() {
                    if (i.this.aYy()) {
                        i.this.aXo();
                    }
                }
            };
        }
        a(this.fjY);
        this.fkh = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.cLk != null && bdVar != null) {
            this.fjZ = videoInfo;
            this.fkd = bdVar;
            this.baM = videoInfo.video_url;
            this.cLk.stopPlay();
            this.cLk.lR(true);
            this.blr = new n(this.eVu.getActivity());
            this.fka = new y();
            this.fka.mLocate = "pb";
            this.fka.aMX = bdVar.getTid();
            this.fka.aAv = str;
            this.fka.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fka.mSource = bdVar.aag;
            this.fka.fRo = bdVar.aah;
            this.fka.fRp = this.eVu.aSP();
            this.fka.fRq = bdVar.aai;
            this.fka.fRr = videoInfo.video_md5;
            y bjL = this.fka.bjL();
            bjL.mLocate = "6";
            this.blr.setVideoStatsData(bjL);
            this.cLk.getVideoView().setBusiness(this.blr);
            if (this.cLk.aHE()) {
                this.cLk.aHC();
            }
            this.cLk.b(this.fks);
            this.fkf = null;
            this.fke = null;
            this.cLk.qn(this.fkf);
            this.cLk.aHy().setOnDragingListener(this.emo);
            this.cLk.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void amQ() {
                    i.this.eVu.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fkt = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void amP() {
                    i.this.eVu.setSwipeBackEnabled(false);
                    i.this.fkt = false;
                }
            });
            this.cLk.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void aYD() {
                    if (i.this.eVu != null && i.this.fke != null && !StringUtils.isNull(i.this.fke.getId())) {
                        i.this.eVu.pI(i.this.fke.getId());
                        if (i.this.fkd != null) {
                            long j = 0;
                            if (i.this.fkd.sA() != null) {
                                j = i.this.fkd.sA().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.cLk.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void ku(boolean z) {
                    if (i.this.fkd != null) {
                        long j = 0;
                        if (i.this.fkd.sA() != null) {
                            j = i.this.fkd.sA().channelId;
                        }
                        i.this.le(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ac("tid", i.this.fkd.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fkd.getFid()).f("obj_id", j));
                    }
                }
            });
            this.cLk.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), ISapiAccount.SAPI_ACCOUNT_EXTRA, Integer.valueOf(i2), "url", i.this.baM);
                    return true;
                }
            });
            this.cLk.nP(videoInfo.thumbnail_url);
            this.cLk.bP(this.baM, bdVar.getTid());
            this.cLk.rm(bdVar.getTitle());
            this.cLk.a(this.fkB);
            this.cLk.auW();
            this.cLk.show();
        }
    }

    public void qm(String str) {
        if (this.fka != null) {
            this.fka.aAv = str;
        }
    }

    public void b(PostData postData, bd bdVar, l lVar) {
        if (this.fkb != null) {
            this.fkb.a(postData, bdVar, lVar);
        }
    }

    public void a(c.InterfaceC0136c interfaceC0136c) {
        this.fks = interfaceC0136c;
    }

    public void af(bd bdVar) {
        this.fke = bdVar;
    }

    public void qn(String str) {
        this.fkf = str;
        if (this.cLk != null) {
            this.cLk.qn(this.fkf);
        }
    }

    public void startPlay() {
        if (this.cLk != null) {
            if (j.hj() && !this.fky) {
                this.fkr.setVisibility(0);
                this.fkr.setData(this.fjZ);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.baM) && this.fkd != null && this.fkd.rN() != null) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "pb").ac("tid", this.fkd.getTid()));
                this.baM = this.fkd.rN().video_url;
            }
            this.cLk.c(this.baM, this.fkd == null ? "" : this.fkd.getTid(), this.fkq);
            le("2");
        }
    }

    public void aYu() {
        if (this.cLk != null) {
            this.cLk.aYu();
        }
    }

    public void destroy() {
        if (this.cLk != null) {
            this.cLk.destroy();
        }
        if (this.fjX != null) {
            this.fjX.clearAnimation();
        }
        if (this.fkb != null) {
            this.fkb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.cLk != null) {
            if (this.cLk.biV()) {
                this.fkg = true;
                this.cLk.pausePlay();
            } else if (this.cLk.bjb() == 3) {
                this.fkg = false;
            } else {
                this.fkg = false;
                this.cLk.pausePlay();
            }
            if (this.fku != null) {
                this.fku.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.cLk != null && this.fkg) {
            this.cLk.aHH();
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
                    ImageView imageView = new ImageView(i.this.eVu.getActivity());
                    if (i.this.fkx == null) {
                        try {
                            i.this.fkx = BitmapFactory.decodeResource(i.this.eVu.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fkx);
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
                    i.this.fkw = null;
                    if (i.this.fkx != null && !i.this.fkx.isRecycled()) {
                        i.this.fkx.recycle();
                    }
                    i.this.fkx = null;
                }
            });
            this.fkw = dVar.eY();
            this.fkw.k(this.eVu.getActivity());
        }
    }

    public boolean ka(int i) {
        if (this.cLk == null) {
            return false;
        }
        return this.cLk.sw(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(String str) {
        if (this.fjZ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fjZ.video_md5, "", str, this.fka);
            }
        }
    }

    public void aYw() {
        if (this.fjW != null) {
            this.fjW.ki(this.eVu.aTD());
        }
    }

    public void aXo() {
        if (this.fjW != null) {
            this.fjW.aXo();
        }
    }

    public void qt(int i) {
        if (this.fjW != null) {
            this.fjW.qt(i);
        }
        if (this.fku != null) {
            this.fku.onChangeSkinType(i);
        }
        if (this.fkb != null) {
            this.fkb.dE(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!aYz()) {
                    this.fkj = i;
                    if (this.fkj == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjX.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fko != aYA().getHeight()) {
                        this.fjX.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eVu.getActivity()), Math.min(this.fko, aYA().getHeight() + i)));
                        this.cLk.aHC();
                    }
                } else if (com.baidu.adp.lib.util.l.ac(this.eVu.getActivity()) * 0.5625d != aYA().getHeight()) {
                    this.fjX.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ac(this.eVu.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ac(this.eVu.getActivity()) * 0.5625d, aYA().getHeight() + i)));
                    this.cLk.aHC();
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
                qy((-this.fko) + 2);
            }
        }
        if (!aYz() && this.fkt) {
            if (this.fkj == 1) {
                qz(aYA().getHeight());
            } else if (this.fkj == 2) {
                int y = (int) aYA().getY();
                if (this.fkk == y) {
                    qz(aYA().getHeight());
                } else {
                    this.fkk = y;
                    qz(aYA().getHeight());
                }
                if (i == 0 && this.fkn) {
                    this.fkn = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.aYu();
                        }
                    }, 100L);
                }
            } else if (this.fkj == 0) {
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
        if (this.fkb != null) {
            if (i == 0) {
                i = this.fko;
            }
            float f = this.fko - i;
            float f2 = f > this.fkl ? 0.0f : 1.0f - (f / this.fkl);
            if (f2 == 0.0f) {
                this.fkb.aYq().setVisibility(8);
            } else {
                this.fkb.aYq().setVisibility(0);
            }
            this.fkb.Y(f2);
        }
    }

    public void aYx() {
        if (this.fkb != null) {
            if (aYz()) {
                this.eVu.aSR().aWE();
            } else if (this.fkb.aYq().getVisibility() == 0) {
                this.eVu.aSR().aWE();
                this.fkc = true;
            } else if (this.fkc) {
                this.eVu.aSR().jW(false);
                this.fkc = false;
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
        this.fki = false;
        if (this.cLk != null && this.fjX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjX.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.fkw != null) {
                    this.fkw.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fki = true;
                this.fjX.setLayoutParams(layoutParams);
                this.eVu.aSR().aWE();
                this.fkc = true;
            } else {
                b(this.fjZ);
                aYw();
                this.fki = false;
                this.fjW.setTitleVisibility(true);
            }
            this.cLk.a(this.eVu.getPageContext(), configuration);
        }
    }

    public boolean aYz() {
        return this.fki;
    }

    public void y(long j, int i) {
        if (this.fkb != null && j > 0) {
            this.fkb.l(i, j);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fkb != null) {
            this.fkb.H(onClickListener);
        }
    }

    public View aYA() {
        return this.fjV;
    }

    public boolean aWQ() {
        if (aYA() == null) {
            return false;
        }
        return aYA().getBottom() > com.baidu.adp.lib.util.l.ae(aYA().getContext()) - com.baidu.adp.lib.util.l.f(aYA().getContext(), d.e.ds50);
    }

    public void aYB() {
        this.fkn = true;
    }

    public View aYC() {
        return this.mEmptyView;
    }
}
