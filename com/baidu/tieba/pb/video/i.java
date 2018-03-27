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
    private n caR;
    private com.baidu.tieba.play.c dIi;
    private PbActivity fNg;
    private RelativeLayout gbZ;
    private com.baidu.adp.lib.guide.c gcA;
    private Bitmap gcB;
    private boolean gcC;
    private int gcE;
    private com.baidu.tieba.pb.pb.main.view.c gca;
    private CustomFrameLayout gcb;
    private c.InterfaceC0219c gcc;
    private aa gce;
    private g gcf;
    private boolean gcg;
    private bd gch;
    private bd gci;
    private String gcj;
    private float gcp;
    private int gcs;
    private double gct;
    private long gcu;
    private PbVideoWifiTipLayout gcv;
    private c.InterfaceC0219c gcw;
    private com.baidu.tieba.pb.view.c gcy;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bQL = null;
    private VideoInfo gcd = null;
    private boolean gck = false;
    private int gcl = 0;
    private boolean gcm = false;
    private int gcn = 0;
    private int gco = 0;
    private boolean gcq = false;
    private boolean gcr = false;
    private boolean gcx = true;
    private c.a gcz = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.lo(false);
        }
    };
    private c.k gcD = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void bhA() {
            if (i.this.fNg.checkUpIsLogin()) {
                i.this.fNg.bcB();
                if (i.this.fNg.bbA() != null && i.this.fNg.bbA().getPbData() != null && i.this.fNg.bbA().getPbData().baQ() != null) {
                    j baQ = i.this.fNg.bbA().getPbData().baQ();
                    if (i.this.gcy == null) {
                        i.this.gcy = new com.baidu.tieba.pb.view.c(i.this.fNg.getActivity());
                        i.this.gcy.setFloatingHuajiAninationListener(i.this.gcz);
                    }
                    i.this.gcy.lq(!baQ.baX());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dIi != null) {
                    i.this.dIi.bkU();
                }
                if (com.baidu.adp.lib.util.j.oJ() && com.baidu.adp.lib.util.j.oL() && i.this.dIi != null && i.this.dIi.bkW() && i.this.gcd != null && i.this.gcd.video_length.intValue() > 0 && i.this.gcd.video_duration.intValue() > 0) {
                    float intValue = i.this.gcd.video_length.intValue() * (1.0f - ((i.this.dIi.getCurrentPosition() * 1.0f) / (i.this.gcd.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fNg.getPageContext().getPageActivity(), String.format(i.this.fNg.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fcS = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
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
    private v.a feL = new v.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.v.a
        public void UF() {
        }
    };
    private c.g gcF = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void awH() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(boolean z) {
        if (this.fNg.bbA() != null && this.fNg.bbA().getPbData() != null && this.fNg.bbA().getPbData().baQ() != null) {
            j baQ = this.fNg.bbA().getPbData().baQ();
            View findViewById = this.fNg.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!baQ.baX() || z) {
                this.fNg.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fNg.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baQ.baX() ? 0 : 1));
            } else if (baQ.baX()) {
                if (baQ.fIc == 1 || baQ.fIc == 3 || baQ.fIc == 4) {
                    this.fNg.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fNg.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baQ.baX() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.gcp = 0.0f;
        this.fNg = pbActivity;
        this.gca = cVar;
        this.gcp = l.t(this.fNg.getActivity(), d.e.ds240);
        this.gcu = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ao = l.ao(this.fNg.getActivity());
        Rect u = ax.u(this.fNg.getPageContext().getPageActivity());
        int aq = u.height() <= 0 ? l.aq(this.fNg.getActivity()) : u.height();
        int i = (int) (ao * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gct = (intValue2 * 1.0d) / intValue;
            if (this.gct > 0.5625d) {
                i = Math.min((ao * intValue2) / intValue, aq);
            }
        }
        this.gcs = i;
        this.gcb.setLayoutParams(new RelativeLayout.LayoutParams(ao, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.gbZ = (RelativeLayout) LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.gcb = (CustomFrameLayout) this.gbZ.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dIi = new com.baidu.tieba.play.c(this.fNg.getPageContext(), this.gcb, true);
        this.dIi.a(this.gcD);
        this.dIi.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fNg.getListView() != null && i.this.fNg.getListView().getChildCount() > 0 && i.this.fNg.getListView().getChildAt(0) == i.this.bhy()) {
                            i.this.gcE = i.this.bhy().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gcE = 0;
                        break;
                    case 2:
                        if (i.this.fNg.getListView() != null && i.this.fNg.getListView().getChildCount() > 0 && i.this.fNg.getListView().getChildAt(0) == i.this.bhy()) {
                            i.this.fNg.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gcE);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gct >= 1.0d) {
                this.dIi.Q(false, true);
            } else {
                this.dIi.Q(true, false);
            }
            this.gcq = ((float) b) + this.gcp > ((float) l.aq(this.fNg.getActivity()));
            if (this.gcq) {
                if (this.gcf == null) {
                    this.gcf = new g(this.fNg.getPageContext(), this.gcb);
                    this.gcf.J(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.lo(true);
                        }
                    });
                }
                this.fNg.bbR().bfE();
                this.gcg = true;
            }
        }
        bhr();
        this.mEmptyView = new View(this.fNg);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gcs));
        if (this.gca != null && this.gca.mNavigationBar != null) {
            this.gca.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gca.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gca.mNavigationBar.setStatusBarVisibility(8);
        }
        this.gcv = (PbVideoWifiTipLayout) this.gbZ.findViewById(d.g.layout_wifi_tip);
        this.gcv.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gcC = true;
                i.this.gcv.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fNg.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gcc == null) {
            this.gcc = new c.InterfaceC0219c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void gc(boolean z) {
                    if (i.this.bhu() && i.this.gca != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gca.bgh().clearAnimation();
                        i.this.bhs();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fcS);
                            i.this.gca.bgh().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void awG() {
                    if (i.this.bhu()) {
                        i.this.bgn();
                    }
                }
            };
        }
        a(this.gcc);
        this.gcl = UtilHelper.getLightStatusBarHeight() + l.t(this.fNg.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dIi != null && bdVar != null) {
            this.gcd = videoInfo;
            this.gch = bdVar;
            this.bQL = videoInfo.video_url;
            this.dIi.stopPlay();
            this.dIi.lN(true);
            this.caR = new n(this.fNg.getActivity());
            this.gce = new aa();
            this.gce.mLocate = "pb";
            this.gce.bCV = bdVar.getTid();
            this.gce.cZL = str;
            this.gce.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gce.mSource = bdVar.mRecomSource;
            this.gce.gwc = bdVar.mRecomWeight;
            this.gce.gwd = this.fNg.bbP();
            this.gce.gwe = bdVar.mRecomAbTag;
            this.gce.gwf = videoInfo.video_md5;
            aa blW = this.gce.blW();
            blW.mLocate = "6";
            this.caR.setVideoStatsData(blW);
            this.dIi.getVideoView().setBusiness(this.caR);
            if (this.dIi.aQB()) {
                this.dIi.aQz();
            }
            this.dIi.b(this.gcw);
            this.gcj = null;
            this.gci = null;
            this.dIi.qO(this.gcj);
            this.dIi.aQv().setOnDragingListener(this.feL);
            this.dIi.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void awD() {
                    i.this.fNg.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.gcx = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void awC() {
                    i.this.fNg.setSwipeBackEnabled(false);
                    i.this.gcx = false;
                }
            });
            this.dIi.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void bhz() {
                    if (i.this.fNg != null && i.this.gci != null && !StringUtils.isNull(i.this.gci.getId())) {
                        i.this.fNg.ql(i.this.gci.getId());
                        if (i.this.gch != null) {
                            long j = 0;
                            if (i.this.gch.Ao() != null) {
                                j = i.this.gch.Ao().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.dIi.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void lp(boolean z) {
                    if (i.this.gch != null) {
                        long j = 0;
                        if (i.this.gch.Ao() != null) {
                            j = i.this.gch.Ao().channelId;
                        }
                        i.this.lL(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ab("tid", i.this.gch.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.gch.getFid()).f("obj_id", j));
                    }
                }
            });
            this.dIi.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bQL);
                    return true;
                }
            });
            this.dIi.ov(videoInfo.thumbnail_url);
            this.dIi.bK(this.bQL, bdVar.getTid());
            this.dIi.rg(bdVar.getTitle());
            this.dIi.a(this.gcF);
            this.dIi.aDC();
            this.dIi.show();
        }
    }

    public void qN(String str) {
        if (this.gce != null) {
            this.gce.cZL = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.gcf != null) {
            this.gcf.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0219c interfaceC0219c) {
        this.gcw = interfaceC0219c;
    }

    public void ah(bd bdVar) {
        this.gci = bdVar;
    }

    public void qO(String str) {
        this.gcj = str;
        if (this.dIi != null) {
            this.dIi.qO(this.gcj);
        }
    }

    public void startPlay() {
        if (this.dIi != null) {
            if (com.baidu.adp.lib.util.j.oL() && !this.gcC) {
                this.gcv.setVisibility(0);
                this.gcv.setData(this.gcd);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bQL) && this.gch != null && this.gch.zF() != null) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "pb").ab("tid", this.gch.getTid()));
                this.bQL = this.gch.zF().video_url;
            }
            this.dIi.b(this.bQL, this.gch == null ? "" : this.gch.getTid(), this.gcu);
            lL("2");
        }
    }

    public void bhq() {
        if (this.dIi != null) {
            this.dIi.bhq();
        }
    }

    public void destroy() {
        if (this.dIi != null) {
            this.dIi.destroy();
        }
        if (this.gcb != null) {
            this.gcb.clearAnimation();
        }
        if (this.gcf != null) {
            this.gcf.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dIi != null) {
            if (this.dIi.bkW()) {
                this.gck = true;
                this.dIi.pausePlay();
            } else if (this.dIi.blc() == 3) {
                this.gck = false;
            } else {
                this.gck = false;
                this.dIi.pausePlay();
            }
            if (this.gcy != null) {
                this.gcy.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dIi != null && this.gck) {
            this.dIi.aQE();
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
                    ImageView imageView = new ImageView(i.this.fNg.getActivity());
                    if (i.this.gcB == null) {
                        try {
                            i.this.gcB = BitmapFactory.decodeResource(i.this.fNg.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.gcB);
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
                    i.this.gcA = null;
                    if (i.this.gcB != null && !i.this.gcB.isRecycled()) {
                        i.this.gcB.recycle();
                    }
                    i.this.gcB = null;
                }
            });
            this.gcA = dVar.mD();
            this.gcA.m(this.fNg.getActivity());
        }
    }

    public boolean nc(int i) {
        if (this.dIi == null) {
            return false;
        }
        return this.dIi.tQ(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.gcd != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gcd.video_md5, "", str, this.gce);
            }
        }
    }

    public void bhs() {
        if (this.gca != null) {
            this.gca.le(this.fNg.bcA());
        }
    }

    public void bgn() {
        if (this.gca != null) {
            this.gca.bgn();
        }
    }

    public void tk(int i) {
        if (this.gca != null) {
            this.gca.tk(i);
        }
        if (this.gcy != null) {
            this.gcy.onChangeSkinType(i);
        }
        if (this.gcf != null) {
            this.gcf.gB(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bhv()) {
                    this.gcn = i;
                    if (this.gcn == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tq(i.this.bhw().getHeight());
                            }
                        }, 100L);
                    }
                    bht();
                    return;
                }
                return;
        }
    }

    private void tp(int i) {
        if (bhw().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gcb.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.gcs != bhw().getHeight()) {
                        this.gcb.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(this.fNg.getActivity()), Math.min(this.gcs, bhw().getHeight() + i)));
                        this.dIi.aQz();
                    }
                } else if (l.ao(this.fNg.getActivity()) * 0.5625d != bhw().getHeight()) {
                    this.gcb.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(this.fNg.getActivity()), (int) Math.max(l.ao(this.fNg.getActivity()) * 0.5625d, bhw().getHeight() + i)));
                    this.dIi.aQz();
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
                tp(bottom);
            } else {
                tp((-this.gcs) + 2);
            }
        }
        if (!bhv() && this.gcx) {
            if (this.gcn == 1) {
                tq(bhw().getHeight());
            } else if (this.gcn == 2) {
                int y = (int) bhw().getY();
                if (this.gco == y) {
                    tq(bhw().getHeight());
                } else {
                    this.gco = y;
                    tq(bhw().getHeight());
                }
                if (i == 0 && this.gcr) {
                    this.gcr = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bhq();
                        }
                    }, 100L);
                }
            } else if (this.gcn == 0) {
                tq(bhw().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(int i) {
        tr(i);
        bht();
    }

    private void tr(int i) {
        if (this.gcf != null) {
            if (i == 0) {
                i = this.gcs;
            }
            float f = this.gcs - i;
            float f2 = f > this.gcp ? 0.0f : 1.0f - (f / this.gcp);
            if (f2 == 0.0f) {
                this.gcf.bhm().setVisibility(8);
            } else {
                this.gcf.bhm().setVisibility(0);
            }
            this.gcf.at(f2);
        }
    }

    public void bht() {
        if (this.gcf != null) {
            if (bhv()) {
                this.fNg.bbR().bfE();
            } else if (this.gcf.bhm().getVisibility() == 0) {
                this.fNg.bbR().bfE();
                this.gcg = true;
            } else if (this.gcg) {
                this.fNg.bbR().kR(false);
                this.gcg = false;
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
        this.gcm = false;
        if (this.dIi != null && this.gcb != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gcb.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gcA != null) {
                    this.gcA.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gcm = true;
                this.gcb.setLayoutParams(layoutParams);
                this.fNg.bbR().bfE();
                this.gcg = true;
            } else {
                b(this.gcd);
                bhs();
                this.gcm = false;
                this.gca.ld(true);
            }
            this.dIi.a(this.fNg.getPageContext(), configuration);
        }
    }

    public boolean bhv() {
        return this.gcm;
    }

    public void y(long j, int i) {
        if (this.gcf != null && j > 0) {
            this.gcf.i(i, j);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.gcf != null) {
            this.gcf.I(onClickListener);
        }
    }

    public View bhw() {
        return this.gbZ;
    }

    public boolean bfN() {
        if (bhw() == null) {
            return false;
        }
        return bhw().getBottom() > l.aq(bhw().getContext()) - l.t(bhw().getContext(), d.e.ds50);
    }

    public void bhx() {
        this.gcr = true;
    }

    public View bhy() {
        return this.mEmptyView;
    }
}
