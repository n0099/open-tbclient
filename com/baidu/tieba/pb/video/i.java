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
    private n caO;
    private com.baidu.tieba.play.c dId;
    private PbActivity fMQ;
    private RelativeLayout gbJ;
    private com.baidu.tieba.pb.pb.main.view.c gbK;
    private CustomFrameLayout gbL;
    private c.InterfaceC0219c gbM;
    private aa gbO;
    private g gbP;
    private boolean gbQ;
    private bd gbR;
    private bd gbS;
    private String gbT;
    private float gbZ;
    private int gcc;
    private double gcd;
    private long gce;
    private PbVideoWifiTipLayout gcf;
    private c.InterfaceC0219c gcg;
    private com.baidu.tieba.pb.view.c gci;
    private com.baidu.adp.lib.guide.c gck;
    private Bitmap gcl;
    private boolean gcm;
    private int gco;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bQI = null;
    private VideoInfo gbN = null;
    private boolean gbU = false;
    private int gbV = 0;
    private boolean gbW = false;
    private int gbX = 0;
    private int gbY = 0;
    private boolean gca = false;
    private boolean gcb = false;
    private boolean gch = true;
    private c.a gcj = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.lj(false);
        }
    };
    private c.k gcn = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void bhz() {
            if (i.this.fMQ.checkUpIsLogin()) {
                i.this.fMQ.bcA();
                if (i.this.fMQ.bbz() != null && i.this.fMQ.bbz().getPbData() != null && i.this.fMQ.bbz().getPbData().baP() != null) {
                    j baP = i.this.fMQ.bbz().getPbData().baP();
                    if (i.this.gci == null) {
                        i.this.gci = new com.baidu.tieba.pb.view.c(i.this.fMQ.getActivity());
                        i.this.gci.setFloatingHuajiAninationListener(i.this.gcj);
                    }
                    i.this.gci.ll(!baP.baW());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dId != null) {
                    i.this.dId.bkT();
                }
                if (com.baidu.adp.lib.util.j.oJ() && com.baidu.adp.lib.util.j.oL() && i.this.dId != null && i.this.dId.bkV() && i.this.gbN != null && i.this.gbN.video_length.intValue() > 0 && i.this.gbN.video_duration.intValue() > 0) {
                    float intValue = i.this.gbN.video_length.intValue() * (1.0f - ((i.this.dId.getCurrentPosition() * 1.0f) / (i.this.gbN.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fMQ.getPageContext().getPageActivity(), String.format(i.this.fMQ.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fcE = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bgm();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private v.a fex = new v.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.v.a
        public void UE() {
        }
    };
    private c.g gcp = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void awF() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (this.fMQ.bbz() != null && this.fMQ.bbz().getPbData() != null && this.fMQ.bbz().getPbData().baP() != null) {
            j baP = this.fMQ.bbz().getPbData().baP();
            View findViewById = this.fMQ.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!baP.baW() || z) {
                this.fMQ.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fMQ.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baP.baW() ? 0 : 1));
            } else if (baP.baW()) {
                if (baP.fHM == 1 || baP.fHM == 3 || baP.fHM == 4) {
                    this.fMQ.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fMQ.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baP.baW() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.gbZ = 0.0f;
        this.fMQ = pbActivity;
        this.gbK = cVar;
        this.gbZ = l.t(this.fMQ.getActivity(), d.e.ds240);
        this.gce = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ao = l.ao(this.fMQ.getActivity());
        Rect u = ax.u(this.fMQ.getPageContext().getPageActivity());
        int aq = u.height() <= 0 ? l.aq(this.fMQ.getActivity()) : u.height();
        int i = (int) (ao * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gcd = (intValue2 * 1.0d) / intValue;
            if (this.gcd > 0.5625d) {
                i = Math.min((ao * intValue2) / intValue, aq);
            }
        }
        this.gcc = i;
        this.gbL.setLayoutParams(new RelativeLayout.LayoutParams(ao, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.gbJ = (RelativeLayout) LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.gbL = (CustomFrameLayout) this.gbJ.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dId = new com.baidu.tieba.play.c(this.fMQ.getPageContext(), this.gbL, true);
        this.dId.a(this.gcn);
        this.dId.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fMQ.getListView() != null && i.this.fMQ.getListView().getChildCount() > 0 && i.this.fMQ.getListView().getChildAt(0) == i.this.bhx()) {
                            i.this.gco = i.this.bhx().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gco = 0;
                        break;
                    case 2:
                        if (i.this.fMQ.getListView() != null && i.this.fMQ.getListView().getChildCount() > 0 && i.this.fMQ.getListView().getChildAt(0) == i.this.bhx()) {
                            i.this.fMQ.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gco);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gcd >= 1.0d) {
                this.dId.Q(false, true);
            } else {
                this.dId.Q(true, false);
            }
            this.gca = ((float) b) + this.gbZ > ((float) l.aq(this.fMQ.getActivity()));
            if (this.gca) {
                if (this.gbP == null) {
                    this.gbP = new g(this.fMQ.getPageContext(), this.gbL);
                    this.gbP.J(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.lj(true);
                        }
                    });
                }
                this.fMQ.bbQ().bfD();
                this.gbQ = true;
            }
        }
        bhq();
        this.mEmptyView = new View(this.fMQ);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gcc));
        if (this.gbK != null && this.gbK.mNavigationBar != null) {
            this.gbK.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gbK.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gbK.mNavigationBar.setStatusBarVisibility(8);
        }
        this.gcf = (PbVideoWifiTipLayout) this.gbJ.findViewById(d.g.layout_wifi_tip);
        this.gcf.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gcm = true;
                i.this.gcf.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fMQ.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gbM == null) {
            this.gbM = new c.InterfaceC0219c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void gc(boolean z) {
                    if (i.this.bht() && i.this.gbK != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gbK.bgg().clearAnimation();
                        i.this.bhr();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fcE);
                            i.this.gbK.bgg().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0219c
                public void awE() {
                    if (i.this.bht()) {
                        i.this.bgm();
                    }
                }
            };
        }
        a(this.gbM);
        this.gbV = UtilHelper.getLightStatusBarHeight() + l.t(this.fMQ.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dId != null && bdVar != null) {
            this.gbN = videoInfo;
            this.gbR = bdVar;
            this.bQI = videoInfo.video_url;
            this.dId.stopPlay();
            this.dId.lI(true);
            this.caO = new n(this.fMQ.getActivity());
            this.gbO = new aa();
            this.gbO.mLocate = "pb";
            this.gbO.bCS = bdVar.getTid();
            this.gbO.cZI = str;
            this.gbO.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gbO.mSource = bdVar.mRecomSource;
            this.gbO.gvM = bdVar.mRecomWeight;
            this.gbO.gvN = this.fMQ.bbO();
            this.gbO.gvO = bdVar.mRecomAbTag;
            this.gbO.gvP = videoInfo.video_md5;
            aa blV = this.gbO.blV();
            blV.mLocate = "6";
            this.caO.setVideoStatsData(blV);
            this.dId.getVideoView().setBusiness(this.caO);
            if (this.dId.aQA()) {
                this.dId.aQy();
            }
            this.dId.b(this.gcg);
            this.gbT = null;
            this.gbS = null;
            this.dId.qO(this.gbT);
            this.dId.aQu().setOnDragingListener(this.fex);
            this.dId.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void awB() {
                    i.this.fMQ.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.gch = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void awA() {
                    i.this.fMQ.setSwipeBackEnabled(false);
                    i.this.gch = false;
                }
            });
            this.dId.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void bhy() {
                    if (i.this.fMQ != null && i.this.gbS != null && !StringUtils.isNull(i.this.gbS.getId())) {
                        i.this.fMQ.ql(i.this.gbS.getId());
                        if (i.this.gbR != null) {
                            long j = 0;
                            if (i.this.gbR.Ao() != null) {
                                j = i.this.gbR.Ao().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.dId.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void lk(boolean z) {
                    if (i.this.gbR != null) {
                        long j = 0;
                        if (i.this.gbR.Ao() != null) {
                            j = i.this.gbR.Ao().channelId;
                        }
                        i.this.lL(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ab("tid", i.this.gbR.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.gbR.getFid()).f("obj_id", j));
                    }
                }
            });
            this.dId.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bQI);
                    return true;
                }
            });
            this.dId.ov(videoInfo.thumbnail_url);
            this.dId.bK(this.bQI, bdVar.getTid());
            this.dId.rg(bdVar.getTitle());
            this.dId.a(this.gcp);
            this.dId.aDB();
            this.dId.show();
        }
    }

    public void qN(String str) {
        if (this.gbO != null) {
            this.gbO.cZI = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.gbP != null) {
            this.gbP.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0219c interfaceC0219c) {
        this.gcg = interfaceC0219c;
    }

    public void ah(bd bdVar) {
        this.gbS = bdVar;
    }

    public void qO(String str) {
        this.gbT = str;
        if (this.dId != null) {
            this.dId.qO(this.gbT);
        }
    }

    public void startPlay() {
        if (this.dId != null) {
            if (com.baidu.adp.lib.util.j.oL() && !this.gcm) {
                this.gcf.setVisibility(0);
                this.gcf.setData(this.gbN);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bQI) && this.gbR != null && this.gbR.zF() != null) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "pb").ab("tid", this.gbR.getTid()));
                this.bQI = this.gbR.zF().video_url;
            }
            this.dId.b(this.bQI, this.gbR == null ? "" : this.gbR.getTid(), this.gce);
            lL("2");
        }
    }

    public void bhp() {
        if (this.dId != null) {
            this.dId.bhp();
        }
    }

    public void destroy() {
        if (this.dId != null) {
            this.dId.destroy();
        }
        if (this.gbL != null) {
            this.gbL.clearAnimation();
        }
        if (this.gbP != null) {
            this.gbP.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dId != null) {
            if (this.dId.bkV()) {
                this.gbU = true;
                this.dId.pausePlay();
            } else if (this.dId.blb() == 3) {
                this.gbU = false;
            } else {
                this.gbU = false;
                this.dId.pausePlay();
            }
            if (this.gci != null) {
                this.gci.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dId != null && this.gbU) {
            this.dId.aQD();
        }
    }

    private void bhq() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.aj(true);
            dVar.al(false);
            dVar.cX(16908290).cW(153).ak(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fMQ.getActivity());
                    if (i.this.gcl == null) {
                        try {
                            i.this.gcl = BitmapFactory.decodeResource(i.this.fMQ.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.gcl);
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
                    i.this.gck = null;
                    if (i.this.gcl != null && !i.this.gcl.isRecycled()) {
                        i.this.gcl.recycle();
                    }
                    i.this.gcl = null;
                }
            });
            this.gck = dVar.mD();
            this.gck.m(this.fMQ.getActivity());
        }
    }

    public boolean nc(int i) {
        if (this.dId == null) {
            return false;
        }
        return this.dId.tQ(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.gbN != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gbN.video_md5, "", str, this.gbO);
            }
        }
    }

    public void bhr() {
        if (this.gbK != null) {
            this.gbK.kZ(this.fMQ.bcz());
        }
    }

    public void bgm() {
        if (this.gbK != null) {
            this.gbK.bgm();
        }
    }

    public void tk(int i) {
        if (this.gbK != null) {
            this.gbK.tk(i);
        }
        if (this.gci != null) {
            this.gci.onChangeSkinType(i);
        }
        if (this.gbP != null) {
            this.gbP.gB(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bhu()) {
                    this.gbX = i;
                    if (this.gbX == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tq(i.this.bhv().getHeight());
                            }
                        }, 100L);
                    }
                    bhs();
                    return;
                }
                return;
        }
    }

    private void tp(int i) {
        if (bhv().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbL.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.gcc != bhv().getHeight()) {
                        this.gbL.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(this.fMQ.getActivity()), Math.min(this.gcc, bhv().getHeight() + i)));
                        this.dId.aQy();
                    }
                } else if (l.ao(this.fMQ.getActivity()) * 0.5625d != bhv().getHeight()) {
                    this.gbL.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(this.fMQ.getActivity()), (int) Math.max(l.ao(this.fMQ.getActivity()) * 0.5625d, bhv().getHeight() + i)));
                    this.dId.aQy();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bhx()) {
                int bottom = childAt.getBottom() - bhv().getBottom();
                if (childAt.getHeight() == 0 || bhv().getHeight() == 0) {
                    bottom = 0;
                }
                tp(bottom);
            } else {
                tp((-this.gcc) + 2);
            }
        }
        if (!bhu() && this.gch) {
            if (this.gbX == 1) {
                tq(bhv().getHeight());
            } else if (this.gbX == 2) {
                int y = (int) bhv().getY();
                if (this.gbY == y) {
                    tq(bhv().getHeight());
                } else {
                    this.gbY = y;
                    tq(bhv().getHeight());
                }
                if (i == 0 && this.gcb) {
                    this.gcb = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bhp();
                        }
                    }, 100L);
                }
            } else if (this.gbX == 0) {
                tq(bhv().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(int i) {
        tr(i);
        bhs();
    }

    private void tr(int i) {
        if (this.gbP != null) {
            if (i == 0) {
                i = this.gcc;
            }
            float f = this.gcc - i;
            float f2 = f > this.gbZ ? 0.0f : 1.0f - (f / this.gbZ);
            if (f2 == 0.0f) {
                this.gbP.bhl().setVisibility(8);
            } else {
                this.gbP.bhl().setVisibility(0);
            }
            this.gbP.at(f2);
        }
    }

    public void bhs() {
        if (this.gbP != null) {
            if (bhu()) {
                this.fMQ.bbQ().bfD();
            } else if (this.gbP.bhl().getVisibility() == 0) {
                this.fMQ.bbQ().bfD();
                this.gbQ = true;
            } else if (this.gbQ) {
                this.fMQ.bbQ().kM(false);
                this.gbQ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bht() {
        return bhv().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.gbW = false;
        if (this.dId != null && this.gbL != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbL.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gck != null) {
                    this.gck.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gbW = true;
                this.gbL.setLayoutParams(layoutParams);
                this.fMQ.bbQ().bfD();
                this.gbQ = true;
            } else {
                b(this.gbN);
                bhr();
                this.gbW = false;
                this.gbK.kY(true);
            }
            this.dId.a(this.fMQ.getPageContext(), configuration);
        }
    }

    public boolean bhu() {
        return this.gbW;
    }

    public void y(long j, int i) {
        if (this.gbP != null && j > 0) {
            this.gbP.i(i, j);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.gbP != null) {
            this.gbP.I(onClickListener);
        }
    }

    public View bhv() {
        return this.gbJ;
    }

    public boolean bfM() {
        if (bhv() == null) {
            return false;
        }
        return bhv().getBottom() > l.aq(bhv().getContext()) - l.t(bhv().getContext(), d.e.ds50);
    }

    public void bhw() {
        this.gcb = true;
    }

    public View bhx() {
        return this.mEmptyView;
    }
}
