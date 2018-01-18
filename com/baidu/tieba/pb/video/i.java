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
    private n bYJ;
    private com.baidu.tieba.play.c dEQ;
    private PbActivity fJw;
    private bd fYA;
    private bd fYB;
    private String fYC;
    private float fYI;
    private int fYL;
    private double fYM;
    private long fYN;
    private PbVideoWifiTipLayout fYO;
    private c.InterfaceC0148c fYP;
    private com.baidu.tieba.pb.view.c fYR;
    private com.baidu.adp.lib.guide.c fYT;
    private Bitmap fYU;
    private boolean fYV;
    private int fYX;
    private RelativeLayout fYs;
    private com.baidu.tieba.pb.pb.main.view.c fYt;
    private CustomFrameLayout fYu;
    private c.InterfaceC0148c fYv;
    private aa fYx;
    private g fYy;
    private boolean fYz;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bOE = null;
    private VideoInfo fYw = null;
    private boolean fYD = false;
    private int fYE = 0;
    private boolean fYF = false;
    private int fYG = 0;
    private int fYH = 0;
    private boolean fYJ = false;
    private boolean fYK = false;
    private boolean fYQ = true;
    private c.a fYS = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.kY(false);
        }
    };
    private c.k fYW = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void bfV() {
            if (i.this.fJw.checkUpIsLogin()) {
                i.this.fJw.baU();
                if (i.this.fJw.aZO() != null && i.this.fJw.aZO().getPbData() != null && i.this.fJw.aZO().getPbData().aZc() != null) {
                    l aZc = i.this.fJw.aZO().getPbData().aZc();
                    if (i.this.fYR == null) {
                        i.this.fYR = new com.baidu.tieba.pb.view.c(i.this.fJw.getActivity());
                        i.this.fYR.setFloatingHuajiAninationListener(i.this.fYS);
                    }
                    i.this.fYR.la(!aZc.aZn());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dEQ != null) {
                    i.this.dEQ.bjG();
                }
                if (j.oI() && j.oK() && i.this.dEQ != null && i.this.dEQ.bjI() && i.this.fYw != null && i.this.fYw.video_length.intValue() > 0 && i.this.fYw.video_duration.intValue() > 0) {
                    float intValue = i.this.fYw.video_length.intValue() * (1.0f - ((i.this.dEQ.getCurrentPosition() * 1.0f) / (i.this.fYw.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(i.this.fJw.getPageContext().getPageActivity(), String.format(i.this.fJw.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eXg = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.beI();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private v.a eZV = new v.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.v.a
        public void TL() {
        }
    };
    private c.g fYY = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void avE() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kY(boolean z) {
        if (this.fJw.aZO() != null && this.fJw.aZO().getPbData() != null && this.fJw.aZO().getPbData().aZc() != null) {
            l aZc = this.fJw.aZO().getPbData().aZc();
            View findViewById = this.fJw.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aZc.aZn() || z) {
                this.fJw.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fJw.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZc.aZn() ? 0 : 1));
            } else if (aZc.aZn()) {
                if (aZc.fEf == 1 || aZc.fEf == 3 || aZc.fEf == 4) {
                    this.fJw.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fJw.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZc.aZn() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fYI = 0.0f;
        this.fJw = pbActivity;
        this.fYt = cVar;
        this.fYI = com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds240);
        this.fYN = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ao = com.baidu.adp.lib.util.l.ao(this.fJw.getActivity());
        Rect t = aw.t(this.fJw.getPageContext().getPageActivity());
        int aq = t.height() <= 0 ? com.baidu.adp.lib.util.l.aq(this.fJw.getActivity()) : t.height();
        int i = (int) (ao * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fYM = (intValue2 * 1.0d) / intValue;
            if (this.fYM > 0.5625d) {
                i = Math.min((ao * intValue2) / intValue, aq);
            }
        }
        this.fYL = i;
        this.fYu.setLayoutParams(new RelativeLayout.LayoutParams(ao, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fYs = (RelativeLayout) LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fYu = (CustomFrameLayout) this.fYs.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dEQ = new com.baidu.tieba.play.c(this.fJw.getPageContext(), this.fYu, true);
        this.dEQ.a(this.fYW);
        this.dEQ.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fJw.getListView() != null && i.this.fJw.getListView().getChildCount() > 0 && i.this.fJw.getListView().getChildAt(0) == i.this.bfT()) {
                            i.this.fYX = i.this.bfT().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fYX = 0;
                        break;
                    case 2:
                        if (i.this.fJw.getListView() != null && i.this.fJw.getListView().getChildCount() > 0 && i.this.fJw.getListView().getChildAt(0) == i.this.bfT()) {
                            i.this.fJw.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fYX);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fYM >= 1.0d) {
                this.dEQ.lA(false);
            } else {
                this.dEQ.lA(true);
            }
            this.fYJ = ((float) b) + this.fYI > ((float) com.baidu.adp.lib.util.l.aq(this.fJw.getActivity()));
            if (this.fYJ) {
                if (this.fYy == null) {
                    this.fYy = new g(this.fJw.getPageContext(), this.fYu);
                    this.fYy.J(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kY(true);
                        }
                    });
                }
                this.fJw.bah().bdX();
                this.fYz = true;
            }
        }
        bfM();
        this.mEmptyView = new View(this.fJw);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fYL));
        if (this.fYt != null && this.fYt.mNavigationBar != null) {
            this.fYt.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fYt.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fYt.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fYO = (PbVideoWifiTipLayout) this.fYs.findViewById(d.g.layout_wifi_tip);
        this.fYO.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fYV = true;
                i.this.fYO.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fJw.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fYv == null) {
            this.fYv = new c.InterfaceC0148c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0148c
                public void fS(boolean z) {
                    if (i.this.bfP() && i.this.fYt != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fYt.beC().clearAnimation();
                        i.this.bfN();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eXg);
                            i.this.fYt.beC().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0148c
                public void avD() {
                    if (i.this.bfP()) {
                        i.this.beI();
                    }
                }
            };
        }
        a(this.fYv);
        this.fYE = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dEQ != null && bdVar != null) {
            this.fYw = videoInfo;
            this.fYA = bdVar;
            this.bOE = videoInfo.video_url;
            this.dEQ.stopPlay();
            this.dEQ.lx(true);
            this.bYJ = new n(this.fJw.getActivity());
            this.fYx = new aa();
            this.fYx.mLocate = "pb";
            this.fYx.bAT = bdVar.getTid();
            this.fYx.cWM = str;
            this.fYx.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fYx.mSource = bdVar.mRecomSource;
            this.fYx.gtW = bdVar.mRecomWeight;
            this.fYx.gtX = this.fJw.baf();
            this.fYx.gtY = bdVar.mRecomAbTag;
            this.fYx.gtZ = videoInfo.video_md5;
            aa bkI = this.fYx.bkI();
            bkI.mLocate = "6";
            this.bYJ.setVideoStatsData(bkI);
            this.dEQ.getVideoView().setBusiness(this.bYJ);
            if (this.dEQ.aOJ()) {
                this.dEQ.aOH();
            }
            this.dEQ.b(this.fYP);
            this.fYC = null;
            this.fYB = null;
            this.dEQ.qA(this.fYC);
            this.dEQ.aOD().setOnDragingListener(this.eZV);
            this.dEQ.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void avA() {
                    i.this.fJw.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fYQ = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void avz() {
                    i.this.fJw.setSwipeBackEnabled(false);
                    i.this.fYQ = false;
                }
            });
            this.dEQ.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void bfU() {
                    if (i.this.fJw != null && i.this.fYB != null && !StringUtils.isNull(i.this.fYB.getId())) {
                        i.this.fJw.pV(i.this.fYB.getId());
                        if (i.this.fYA != null) {
                            long j = 0;
                            if (i.this.fYA.zU() != null) {
                                j = i.this.fYA.zU().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.dEQ.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void kZ(boolean z) {
                    if (i.this.fYA != null) {
                        long j = 0;
                        if (i.this.fYA.zU() != null) {
                            j = i.this.fYA.zU().channelId;
                        }
                        i.this.lu(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").ab("tid", i.this.fYA.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fYA.getFid()).f("obj_id", j));
                    }
                }
            });
            this.dEQ.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bOE);
                    return true;
                }
            });
            this.dEQ.ob(videoInfo.thumbnail_url);
            this.dEQ.bL(this.bOE, bdVar.getTid());
            this.dEQ.qS(bdVar.getTitle());
            this.dEQ.a(this.fYY);
            this.dEQ.aCd();
            this.dEQ.show();
        }
    }

    public void qz(String str) {
        if (this.fYx != null) {
            this.fYx.cWM = str;
        }
    }

    public void b(PostData postData, bd bdVar, l lVar) {
        if (this.fYy != null) {
            this.fYy.a(postData, bdVar, lVar);
        }
    }

    public void a(c.InterfaceC0148c interfaceC0148c) {
        this.fYP = interfaceC0148c;
    }

    public void ae(bd bdVar) {
        this.fYB = bdVar;
    }

    public void qA(String str) {
        this.fYC = str;
        if (this.dEQ != null) {
            this.dEQ.qA(this.fYC);
        }
    }

    public void startPlay() {
        if (this.dEQ != null) {
            if (j.oK() && !this.fYV) {
                this.fYO.setVisibility(0);
                this.fYO.setData(this.fYw);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bOE) && this.fYA != null && this.fYA.zk() != null) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "pb").ab("tid", this.fYA.getTid()));
                this.bOE = this.fYA.zk().video_url;
            }
            this.dEQ.b(this.bOE, this.fYA == null ? "" : this.fYA.getTid(), this.fYN);
            lu("2");
        }
    }

    public void bfL() {
        if (this.dEQ != null) {
            this.dEQ.bfL();
        }
    }

    public void destroy() {
        if (this.dEQ != null) {
            this.dEQ.destroy();
        }
        if (this.fYu != null) {
            this.fYu.clearAnimation();
        }
        if (this.fYy != null) {
            this.fYy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dEQ != null) {
            if (this.dEQ.bjI()) {
                this.fYD = true;
                this.dEQ.pausePlay();
            } else if (this.dEQ.bjO() == 3) {
                this.fYD = false;
            } else {
                this.fYD = false;
                this.dEQ.pausePlay();
            }
            if (this.fYR != null) {
                this.fYR.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dEQ != null && this.fYD) {
            this.dEQ.aOM();
        }
    }

    private void bfM() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.af(true);
            dVar.ah(false);
            dVar.cX(16908290).cW(153).ag(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fJw.getActivity());
                    if (i.this.fYU == null) {
                        try {
                            i.this.fYU = BitmapFactory.decodeResource(i.this.fJw.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fYU);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int mA() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int mB() {
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
                    i.this.fYT = null;
                    if (i.this.fYU != null && !i.this.fYU.isRecycled()) {
                        i.this.fYU.recycle();
                    }
                    i.this.fYU = null;
                }
            });
            this.fYT = dVar.mC();
            this.fYT.k(this.fJw.getActivity());
        }
    }

    public boolean ne(int i) {
        if (this.dEQ == null) {
            return false;
        }
        return this.dEQ.tR(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu(String str) {
        if (this.fYw != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fYw.video_md5, "", str, this.fYx);
            }
        }
    }

    public void bfN() {
        if (this.fYt != null) {
            this.fYt.kO(this.fJw.baT());
        }
    }

    public void beI() {
        if (this.fYt != null) {
            this.fYt.beI();
        }
    }

    public void tf(int i) {
        if (this.fYt != null) {
            this.fYt.tf(i);
        }
        if (this.fYR != null) {
            this.fYR.onChangeSkinType(i);
        }
        if (this.fYy != null) {
            this.fYy.gz(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bfQ()) {
                    this.fYG = i;
                    if (this.fYG == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tl(i.this.bfR().getHeight());
                            }
                        }, 100L);
                    }
                    bfO();
                    return;
                }
                return;
        }
    }

    private void tk(int i) {
        if (bfR().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYu.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fYL != bfR().getHeight()) {
                        this.fYu.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ao(this.fJw.getActivity()), Math.min(this.fYL, bfR().getHeight() + i)));
                        this.dEQ.aOH();
                    }
                } else if (com.baidu.adp.lib.util.l.ao(this.fJw.getActivity()) * 0.5625d != bfR().getHeight()) {
                    this.fYu.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ao(this.fJw.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ao(this.fJw.getActivity()) * 0.5625d, bfR().getHeight() + i)));
                    this.dEQ.aOH();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bfT()) {
                int bottom = childAt.getBottom() - bfR().getBottom();
                if (childAt.getHeight() == 0 || bfR().getHeight() == 0) {
                    bottom = 0;
                }
                tk(bottom);
            } else {
                tk((-this.fYL) + 2);
            }
        }
        if (!bfQ() && this.fYQ) {
            if (this.fYG == 1) {
                tl(bfR().getHeight());
            } else if (this.fYG == 2) {
                int y = (int) bfR().getY();
                if (this.fYH == y) {
                    tl(bfR().getHeight());
                } else {
                    this.fYH = y;
                    tl(bfR().getHeight());
                }
                if (i == 0 && this.fYK) {
                    this.fYK = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bfL();
                        }
                    }, 100L);
                }
            } else if (this.fYG == 0) {
                tl(bfR().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        tm(i);
        bfO();
    }

    private void tm(int i) {
        if (this.fYy != null) {
            if (i == 0) {
                i = this.fYL;
            }
            float f = this.fYL - i;
            float f2 = f > this.fYI ? 0.0f : 1.0f - (f / this.fYI);
            if (f2 == 0.0f) {
                this.fYy.bfH().setVisibility(8);
            } else {
                this.fYy.bfH().setVisibility(0);
            }
            this.fYy.an(f2);
        }
    }

    public void bfO() {
        if (this.fYy != null) {
            if (bfQ()) {
                this.fJw.bah().bdX();
            } else if (this.fYy.bfH().getVisibility() == 0) {
                this.fJw.bah().bdX();
                this.fYz = true;
            } else if (this.fYz) {
                this.fJw.bah().kA(false);
                this.fYz = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfP() {
        return bfR().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fYF = false;
        if (this.dEQ != null && this.fYu != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYu.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.fYT != null) {
                    this.fYT.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fYF = true;
                this.fYu.setLayoutParams(layoutParams);
                this.fJw.bah().bdX();
                this.fYz = true;
            } else {
                b(this.fYw);
                bfN();
                this.fYF = false;
                this.fYt.kN(true);
            }
            this.dEQ.a(this.fJw.getPageContext(), configuration);
        }
    }

    public boolean bfQ() {
        return this.fYF;
    }

    public void y(long j, int i) {
        if (this.fYy != null && j > 0) {
            this.fYy.j(i, j);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.fYy != null) {
            this.fYy.I(onClickListener);
        }
    }

    public View bfR() {
        return this.fYs;
    }

    public boolean bei() {
        if (bfR() == null) {
            return false;
        }
        return bfR().getBottom() > com.baidu.adp.lib.util.l.aq(bfR().getContext()) - com.baidu.adp.lib.util.l.s(bfR().getContext(), d.e.ds50);
    }

    public void bfS() {
        this.fYK = true;
    }

    public View bfT() {
        return this.mEmptyView;
    }
}
