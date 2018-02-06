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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
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
    private n cba;
    private com.baidu.tieba.play.c dIp;
    private PbActivity fNb;
    private RelativeLayout gbU;
    private com.baidu.tieba.pb.pb.main.view.c gbV;
    private CustomFrameLayout gbW;
    private c.InterfaceC0218c gbX;
    private aa gbZ;
    private g gca;
    private boolean gcb;
    private bd gcc;
    private bd gcd;
    private String gce;
    private float gck;
    private int gcn;
    private double gco;
    private long gcp;
    private PbVideoWifiTipLayout gcq;
    private c.InterfaceC0218c gcr;
    private com.baidu.tieba.pb.view.c gct;
    private com.baidu.adp.lib.guide.c gcv;
    private Bitmap gcw;
    private boolean gcx;
    private int gcz;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bQV = null;
    private VideoInfo gbY = null;
    private boolean gcf = false;
    private int gcg = 0;
    private boolean gch = false;
    private int gci = 0;
    private int gcj = 0;
    private boolean gcl = false;
    private boolean gcm = false;
    private boolean gcs = true;
    private c.a gcu = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.lj(false);
        }
    };
    private c.k gcy = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void bhA() {
            if (i.this.fNb.checkUpIsLogin()) {
                i.this.fNb.bcB();
                if (i.this.fNb.bbA() != null && i.this.fNb.bbA().getPbData() != null && i.this.fNb.bbA().getPbData().baQ() != null) {
                    j baQ = i.this.fNb.bbA().getPbData().baQ();
                    if (i.this.gct == null) {
                        i.this.gct = new com.baidu.tieba.pb.view.c(i.this.fNb.getActivity());
                        i.this.gct.setFloatingHuajiAninationListener(i.this.gcu);
                    }
                    i.this.gct.ll(!baQ.baX());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dIp != null) {
                    i.this.dIp.bkU();
                }
                if (com.baidu.adp.lib.util.j.oJ() && com.baidu.adp.lib.util.j.oL() && i.this.dIp != null && i.this.dIp.bkW() && i.this.gbY != null && i.this.gbY.video_length.intValue() > 0 && i.this.gbY.video_duration.intValue() > 0) {
                    float intValue = i.this.gbY.video_length.intValue() * (1.0f - ((i.this.dIp.getCurrentPosition() * 1.0f) / (i.this.gbY.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fNb.getPageContext().getPageActivity(), String.format(i.this.fNb.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fcQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bgn();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private v.a feJ = new v.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.v.a
        public void UF() {
        }
    };
    private c.g gcA = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void awG() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (this.fNb.bbA() != null && this.fNb.bbA().getPbData() != null && this.fNb.bbA().getPbData().baQ() != null) {
            j baQ = this.fNb.bbA().getPbData().baQ();
            View findViewById = this.fNb.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!baQ.baX() || z) {
                this.fNb.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fNb.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baQ.baX() ? 0 : 1));
            } else if (baQ.baX()) {
                if (baQ.fHX == 1 || baQ.fHX == 3 || baQ.fHX == 4) {
                    this.fNb.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fNb.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baQ.baX() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.gck = 0.0f;
        this.fNb = pbActivity;
        this.gbV = cVar;
        this.gck = l.t(this.fNb.getActivity(), d.e.ds240);
        this.gcp = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ao = l.ao(this.fNb.getActivity());
        Rect u = ax.u(this.fNb.getPageContext().getPageActivity());
        int aq = u.height() <= 0 ? l.aq(this.fNb.getActivity()) : u.height();
        int i = (int) (ao * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gco = (intValue2 * 1.0d) / intValue;
            if (this.gco > 0.5625d) {
                i = Math.min((ao * intValue2) / intValue, aq);
            }
        }
        this.gcn = i;
        this.gbW.setLayoutParams(new RelativeLayout.LayoutParams(ao, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.gbU = (RelativeLayout) LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.gbW = (CustomFrameLayout) this.gbU.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dIp = new com.baidu.tieba.play.c(this.fNb.getPageContext(), this.gbW, true);
        this.dIp.a(this.gcy);
        this.dIp.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fNb.getListView() != null && i.this.fNb.getListView().getChildCount() > 0 && i.this.fNb.getListView().getChildAt(0) == i.this.bhy()) {
                            i.this.gcz = i.this.bhy().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gcz = 0;
                        break;
                    case 2:
                        if (i.this.fNb.getListView() != null && i.this.fNb.getListView().getChildCount() > 0 && i.this.fNb.getListView().getChildAt(0) == i.this.bhy()) {
                            i.this.fNb.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gcz);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gco >= 1.0d) {
                this.dIp.Q(false, true);
            } else {
                this.dIp.Q(true, false);
            }
            this.gcl = ((float) b) + this.gck > ((float) l.aq(this.fNb.getActivity()));
            if (this.gcl) {
                if (this.gca == null) {
                    this.gca = new g(this.fNb.getPageContext(), this.gbW);
                    this.gca.J(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.lj(true);
                        }
                    });
                }
                this.fNb.bbR().bfE();
                this.gcb = true;
            }
        }
        bhr();
        this.mEmptyView = new View(this.fNb);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gcn));
        if (this.gbV != null && this.gbV.mNavigationBar != null) {
            this.gbV.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gbV.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gbV.mNavigationBar.setStatusBarVisibility(8);
        }
        this.gcq = (PbVideoWifiTipLayout) this.gbU.findViewById(d.g.layout_wifi_tip);
        this.gcq.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gcx = true;
                i.this.gcq.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fNb.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gbX == null) {
            this.gbX = new c.InterfaceC0218c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void gc(boolean z) {
                    if (i.this.bhu() && i.this.gbV != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gbV.bgh().clearAnimation();
                        i.this.bhs();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fcQ);
                            i.this.gbV.bgh().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0218c
                public void awF() {
                    if (i.this.bhu()) {
                        i.this.bgn();
                    }
                }
            };
        }
        a(this.gbX);
        this.gcg = UtilHelper.getLightStatusBarHeight() + l.t(this.fNb.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dIp != null && bdVar != null) {
            this.gbY = videoInfo;
            this.gcc = bdVar;
            this.bQV = videoInfo.video_url;
            this.dIp.stopPlay();
            this.dIp.lI(true);
            this.cba = new n(this.fNb.getActivity());
            this.gbZ = new aa();
            this.gbZ.mLocate = "pb";
            this.gbZ.bDf = bdVar.getTid();
            this.gbZ.cZU = str;
            this.gbZ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gbZ.mSource = bdVar.mRecomSource;
            this.gbZ.gvX = bdVar.mRecomWeight;
            this.gbZ.gvY = this.fNb.bbP();
            this.gbZ.gvZ = bdVar.mRecomAbTag;
            this.gbZ.gwa = videoInfo.video_md5;
            aa blW = this.gbZ.blW();
            blW.mLocate = "6";
            this.cba.setVideoStatsData(blW);
            this.dIp.getVideoView().setBusiness(this.cba);
            if (this.dIp.aQB()) {
                this.dIp.aQz();
            }
            this.dIp.b(this.gcr);
            this.gce = null;
            this.gcd = null;
            this.dIp.qO(this.gce);
            this.dIp.aQv().setOnDragingListener(this.feJ);
            this.dIp.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void awC() {
                    i.this.fNb.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.gcs = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void awB() {
                    i.this.fNb.setSwipeBackEnabled(false);
                    i.this.gcs = false;
                }
            });
            this.dIp.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void bhz() {
                    if (i.this.fNb != null && i.this.gcd != null && !StringUtils.isNull(i.this.gcd.getId())) {
                        i.this.fNb.ql(i.this.gcd.getId());
                        if (i.this.gcc != null) {
                            long j = 0;
                            if (i.this.gcc.Ao() != null) {
                                j = i.this.gcc.Ao().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.dIp.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void lk(boolean z) {
                    if (i.this.gcc != null) {
                        long j = 0;
                        if (i.this.gcc.Ao() != null) {
                            j = i.this.gcc.Ao().channelId;
                        }
                        i.this.lL(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ab("tid", i.this.gcc.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.gcc.getFid()).f("obj_id", j));
                    }
                }
            });
            this.dIp.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bQV);
                    return true;
                }
            });
            this.dIp.ov(videoInfo.thumbnail_url);
            this.dIp.bK(this.bQV, bdVar.getTid());
            this.dIp.rg(bdVar.getTitle());
            this.dIp.a(this.gcA);
            this.dIp.aDC();
            this.dIp.show();
        }
    }

    public void qN(String str) {
        if (this.gbZ != null) {
            this.gbZ.cZU = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.gca != null) {
            this.gca.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0218c interfaceC0218c) {
        this.gcr = interfaceC0218c;
    }

    public void ah(bd bdVar) {
        this.gcd = bdVar;
    }

    public void qO(String str) {
        this.gce = str;
        if (this.dIp != null) {
            this.dIp.qO(this.gce);
        }
    }

    public void startPlay() {
        if (this.dIp != null) {
            if (com.baidu.adp.lib.util.j.oL() && !this.gcx) {
                this.gcq.setVisibility(0);
                this.gcq.setData(this.gbY);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bQV) && this.gcc != null && this.gcc.zF() != null) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "pb").ab("tid", this.gcc.getTid()));
                this.bQV = this.gcc.zF().video_url;
            }
            this.dIp.b(this.bQV, this.gcc == null ? "" : this.gcc.getTid(), this.gcp);
            lL("2");
        }
    }

    public void bhq() {
        if (this.dIp != null) {
            this.dIp.bhq();
        }
    }

    public void destroy() {
        if (this.dIp != null) {
            this.dIp.destroy();
        }
        if (this.gbW != null) {
            this.gbW.clearAnimation();
        }
        if (this.gca != null) {
            this.gca.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dIp != null) {
            if (this.dIp.bkW()) {
                this.gcf = true;
                this.dIp.pausePlay();
            } else if (this.dIp.blc() == 3) {
                this.gcf = false;
            } else {
                this.gcf = false;
                this.dIp.pausePlay();
            }
            if (this.gct != null) {
                this.gct.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dIp != null && this.gcf) {
            this.dIp.aQE();
        }
    }

    private void bhr() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.aj(true);
            dVar.al(false);
            dVar.cX(16908290).cW(153).ak(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fNb.getActivity());
                    if (i.this.gcw == null) {
                        try {
                            i.this.gcw = BitmapFactory.decodeResource(i.this.fNb.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.gcw);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int mB() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int mC() {
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
                    i.this.gcv = null;
                    if (i.this.gcw != null && !i.this.gcw.isRecycled()) {
                        i.this.gcw.recycle();
                    }
                    i.this.gcw = null;
                }
            });
            this.gcv = dVar.mD();
            this.gcv.m(this.fNb.getActivity());
        }
    }

    public boolean nc(int i) {
        if (this.dIp == null) {
            return false;
        }
        return this.dIp.tP(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.gbY != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gbY.video_md5, "", str, this.gbZ);
            }
        }
    }

    public void bhs() {
        if (this.gbV != null) {
            this.gbV.kZ(this.fNb.bcA());
        }
    }

    public void bgn() {
        if (this.gbV != null) {
            this.gbV.bgn();
        }
    }

    public void tj(int i) {
        if (this.gbV != null) {
            this.gbV.tj(i);
        }
        if (this.gct != null) {
            this.gct.onChangeSkinType(i);
        }
        if (this.gca != null) {
            this.gca.gB(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bhv()) {
                    this.gci = i;
                    if (this.gci == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tp(i.this.bhw().getHeight());
                            }
                        }, 100L);
                    }
                    bht();
                    return;
                }
                return;
        }
    }

    private void to(int i) {
        if (bhw().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbW.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.gcn != bhw().getHeight()) {
                        this.gbW.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(this.fNb.getActivity()), Math.min(this.gcn, bhw().getHeight() + i)));
                        this.dIp.aQz();
                    }
                } else if (l.ao(this.fNb.getActivity()) * 0.5625d != bhw().getHeight()) {
                    this.gbW.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(this.fNb.getActivity()), (int) Math.max(l.ao(this.fNb.getActivity()) * 0.5625d, bhw().getHeight() + i)));
                    this.dIp.aQz();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bhy()) {
                int bottom = childAt.getBottom() - bhw().getBottom();
                if (childAt.getHeight() == 0 || bhw().getHeight() == 0) {
                    bottom = 0;
                }
                to(bottom);
            } else {
                to((-this.gcn) + 2);
            }
        }
        if (!bhv() && this.gcs) {
            if (this.gci == 1) {
                tp(bhw().getHeight());
            } else if (this.gci == 2) {
                int y = (int) bhw().getY();
                if (this.gcj == y) {
                    tp(bhw().getHeight());
                } else {
                    this.gcj = y;
                    tp(bhw().getHeight());
                }
                if (i == 0 && this.gcm) {
                    this.gcm = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bhq();
                        }
                    }, 100L);
                }
            } else if (this.gci == 0) {
                tp(bhw().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp(int i) {
        tq(i);
        bht();
    }

    private void tq(int i) {
        if (this.gca != null) {
            if (i == 0) {
                i = this.gcn;
            }
            float f = this.gcn - i;
            float f2 = f > this.gck ? 0.0f : 1.0f - (f / this.gck);
            if (f2 == 0.0f) {
                this.gca.bhm().setVisibility(8);
            } else {
                this.gca.bhm().setVisibility(0);
            }
            this.gca.at(f2);
        }
    }

    public void bht() {
        if (this.gca != null) {
            if (bhv()) {
                this.fNb.bbR().bfE();
            } else if (this.gca.bhm().getVisibility() == 0) {
                this.fNb.bbR().bfE();
                this.gcb = true;
            } else if (this.gcb) {
                this.fNb.bbR().kM(false);
                this.gcb = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhu() {
        return bhw().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.gch = false;
        if (this.dIp != null && this.gbW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbW.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gcv != null) {
                    this.gcv.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gch = true;
                this.gbW.setLayoutParams(layoutParams);
                this.fNb.bbR().bfE();
                this.gcb = true;
            } else {
                b(this.gbY);
                bhs();
                this.gch = false;
                this.gbV.kY(true);
            }
            this.dIp.a(this.fNb.getPageContext(), configuration);
        }
    }

    public boolean bhv() {
        return this.gch;
    }

    public void y(long j, int i) {
        if (this.gca != null && j > 0) {
            this.gca.i(i, j);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.gca != null) {
            this.gca.I(onClickListener);
        }
    }

    public View bhw() {
        return this.gbU;
    }

    public boolean bfN() {
        if (bhw() == null) {
            return false;
        }
        return bhw().getBottom() > l.aq(bhw().getContext()) - l.t(bhw().getContext(), d.e.ds50);
    }

    public void bhx() {
        this.gcm = true;
    }

    public View bhy() {
        return this.mEmptyView;
    }
}
