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
    private n bYR;
    private com.baidu.tieba.play.c dFl;
    private PbActivity fJR;
    private RelativeLayout fYN;
    private com.baidu.tieba.pb.pb.main.view.c fYO;
    private CustomFrameLayout fYP;
    private c.InterfaceC0149c fYQ;
    private aa fYS;
    private g fYT;
    private boolean fYU;
    private bd fYV;
    private bd fYW;
    private String fYX;
    private float fZd;
    private int fZg;
    private double fZh;
    private long fZi;
    private PbVideoWifiTipLayout fZj;
    private c.InterfaceC0149c fZk;
    private com.baidu.tieba.pb.view.c fZm;
    private com.baidu.adp.lib.guide.c fZo;
    private Bitmap fZp;
    private boolean fZq;
    private int fZs;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String bON = null;
    private VideoInfo fYR = null;
    private boolean fYY = false;
    private int fYZ = 0;
    private boolean fZa = false;
    private int fZb = 0;
    private int fZc = 0;
    private boolean fZe = false;
    private boolean fZf = false;
    private boolean fZl = true;
    private c.a fZn = new c.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.c.a
        public void onAnimationEnd() {
            i.this.la(false);
        }
    };
    private c.k fZr = new c.k() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.k
        public void bga() {
            if (i.this.fJR.checkUpIsLogin()) {
                i.this.fJR.baZ();
                if (i.this.fJR.aZT() != null && i.this.fJR.aZT().getPbData() != null && i.this.fJR.aZT().getPbData().aZh() != null) {
                    l aZh = i.this.fJR.aZT().getPbData().aZh();
                    if (i.this.fZm == null) {
                        i.this.fZm = new com.baidu.tieba.pb.view.c(i.this.fJR.getActivity());
                        i.this.fZm.setFloatingHuajiAninationListener(i.this.fZn);
                    }
                    i.this.fZm.lc(!aZh.aZs());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dFl != null) {
                    i.this.dFl.bjH();
                }
                if (j.oJ() && j.oL() && i.this.dFl != null && i.this.dFl.bjJ() && i.this.fYR != null && i.this.fYR.video_length.intValue() > 0 && i.this.fYR.video_duration.intValue() > 0) {
                    float intValue = i.this.fYR.video_length.intValue() * (1.0f - ((i.this.dFl.getCurrentPosition() * 1.0f) / (i.this.fYR.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        com.baidu.adp.lib.util.l.showToast(i.this.fJR.getPageContext().getPageActivity(), String.format(i.this.fJR.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eXB = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.beN();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private v.a faq = new v.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.v.a
        public void TN() {
        }
    };
    private c.g fZt = new c.g() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.g
        public void avJ() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (this.fJR.aZT() != null && this.fJR.aZT().getPbData() != null && this.fJR.aZT().getPbData().aZh() != null) {
            l aZh = this.fJR.aZT().getPbData().aZh();
            View findViewById = this.fJR.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!aZh.aZs() || z) {
                this.fJR.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.fJR.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZh.aZs() ? 0 : 1));
            } else if (aZh.aZs()) {
                if (aZh.fEA == 1 || aZh.fEA == 3 || aZh.fEA == 4) {
                    this.fJR.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.fJR.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZh.aZs() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.fZd = 0.0f;
        this.fJR = pbActivity;
        this.fYO = cVar;
        this.fZd = com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds240);
        this.fZi = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ao = com.baidu.adp.lib.util.l.ao(this.fJR.getActivity());
        Rect t = aw.t(this.fJR.getPageContext().getPageActivity());
        int aq = t.height() <= 0 ? com.baidu.adp.lib.util.l.aq(this.fJR.getActivity()) : t.height();
        int i = (int) (ao * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fZh = (intValue2 * 1.0d) / intValue;
            if (this.fZh > 0.5625d) {
                i = Math.min((ao * intValue2) / intValue, aq);
            }
        }
        this.fZg = i;
        this.fYP.setLayoutParams(new RelativeLayout.LayoutParams(ao, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fYN = (RelativeLayout) LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.fYP = (CustomFrameLayout) this.fYN.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dFl = new com.baidu.tieba.play.c(this.fJR.getPageContext(), this.fYP, true);
        this.dFl.a(this.fZr);
        this.dFl.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.13
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
                        if (i.this.fJR.getListView() != null && i.this.fJR.getListView().getChildCount() > 0 && i.this.fJR.getListView().getChildAt(0) == i.this.bfY()) {
                            i.this.fZs = i.this.bfY().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fZs = 0;
                        break;
                    case 2:
                        if (i.this.fJR.getListView() != null && i.this.fJR.getListView().getChildCount() > 0 && i.this.fJR.getListView().getChildAt(0) == i.this.bfY()) {
                            i.this.fJR.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fZs);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fZh >= 1.0d) {
                this.dFl.lC(false);
            } else {
                this.dFl.lC(true);
            }
            this.fZe = ((float) b) + this.fZd > ((float) com.baidu.adp.lib.util.l.aq(this.fJR.getActivity()));
            if (this.fZe) {
                if (this.fYT == null) {
                    this.fYT = new g(this.fJR.getPageContext(), this.fYP);
                    this.fYT.J(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.la(true);
                        }
                    });
                }
                this.fJR.bam().bec();
                this.fYU = true;
            }
        }
        bfR();
        this.mEmptyView = new View(this.fJR);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fZg));
        if (this.fYO != null && this.fYO.mNavigationBar != null) {
            this.fYO.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fYO.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fYO.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fZj = (PbVideoWifiTipLayout) this.fYN.findViewById(d.g.layout_wifi_tip);
        this.fZj.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fZq = true;
                i.this.fZj.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fJR.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fYQ == null) {
            this.fYQ = new c.InterfaceC0149c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0149c
                public void fU(boolean z) {
                    if (i.this.bfU() && i.this.fYO != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fYO.beH().clearAnimation();
                        i.this.bfS();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eXB);
                            i.this.fYO.beH().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0149c
                public void avI() {
                    if (i.this.bfU()) {
                        i.this.beN();
                    }
                }
            };
        }
        a(this.fYQ);
        this.fYZ = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dFl != null && bdVar != null) {
            this.fYR = videoInfo;
            this.fYV = bdVar;
            this.bON = videoInfo.video_url;
            this.dFl.stopPlay();
            this.dFl.lz(true);
            this.bYR = new n(this.fJR.getActivity());
            this.fYS = new aa();
            this.fYS.mLocate = "pb";
            this.fYS.bBb = bdVar.getTid();
            this.fYS.cXh = str;
            this.fYS.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fYS.mSource = bdVar.mRecomSource;
            this.fYS.gur = bdVar.mRecomWeight;
            this.fYS.gus = this.fJR.bak();
            this.fYS.gut = bdVar.mRecomAbTag;
            this.fYS.guu = videoInfo.video_md5;
            aa bkJ = this.fYS.bkJ();
            bkJ.mLocate = "6";
            this.bYR.setVideoStatsData(bkJ);
            this.dFl.getVideoView().setBusiness(this.bYR);
            if (this.dFl.aOO()) {
                this.dFl.aOM();
            }
            this.dFl.b(this.fZk);
            this.fYX = null;
            this.fYW = null;
            this.dFl.qH(this.fYX);
            this.dFl.aOI().setOnDragingListener(this.faq);
            this.dFl.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void avF() {
                    i.this.fJR.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fZl = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void avE() {
                    i.this.fJR.setSwipeBackEnabled(false);
                    i.this.fZl = false;
                }
            });
            this.dFl.a(new c.f() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.f
                public void bfZ() {
                    if (i.this.fJR != null && i.this.fYW != null && !StringUtils.isNull(i.this.fYW.getId())) {
                        i.this.fJR.qc(i.this.fYW.getId());
                        if (i.this.fYV != null) {
                            long j = 0;
                            if (i.this.fYV.zV() != null) {
                                j = i.this.fYV.zV().channelId;
                            }
                            TiebaStatic.log(new ak("c11921").f("obj_id", j));
                        }
                    }
                }
            });
            this.dFl.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.h
                public void lb(boolean z) {
                    if (i.this.fYV != null) {
                        long j = 0;
                        if (i.this.fYV.zV() != null) {
                            j = i.this.fYV.zV().channelId;
                        }
                        i.this.lB(z ? "1" : "2");
                        TiebaStatic.log(new ak("c10795").aa("tid", i.this.fYV.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fYV.getFid()).f("obj_id", j));
                    }
                }
            });
            this.dFl.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bON);
                    return true;
                }
            });
            this.dFl.oj(videoInfo.thumbnail_url);
            this.dFl.bK(this.bON, bdVar.getTid());
            this.dFl.qZ(bdVar.getTitle());
            this.dFl.a(this.fZt);
            this.dFl.aCi();
            this.dFl.show();
        }
    }

    public void qG(String str) {
        if (this.fYS != null) {
            this.fYS.cXh = str;
        }
    }

    public void b(PostData postData, bd bdVar, l lVar) {
        if (this.fYT != null) {
            this.fYT.a(postData, bdVar, lVar);
        }
    }

    public void a(c.InterfaceC0149c interfaceC0149c) {
        this.fZk = interfaceC0149c;
    }

    public void ae(bd bdVar) {
        this.fYW = bdVar;
    }

    public void qH(String str) {
        this.fYX = str;
        if (this.dFl != null) {
            this.dFl.qH(this.fYX);
        }
    }

    public void startPlay() {
        if (this.dFl != null) {
            if (j.oL() && !this.fZq) {
                this.fZj.setVisibility(0);
                this.fZj.setData(this.fYR);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bON) && this.fYV != null && this.fYV.zl() != null) {
                TiebaStatic.log(new ak("c12619").aa("obj_locate", "pb").aa("tid", this.fYV.getTid()));
                this.bON = this.fYV.zl().video_url;
            }
            this.dFl.b(this.bON, this.fYV == null ? "" : this.fYV.getTid(), this.fZi);
            lB("2");
        }
    }

    public void bfQ() {
        if (this.dFl != null) {
            this.dFl.bfQ();
        }
    }

    public void destroy() {
        if (this.dFl != null) {
            this.dFl.destroy();
        }
        if (this.fYP != null) {
            this.fYP.clearAnimation();
        }
        if (this.fYT != null) {
            this.fYT.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dFl != null) {
            if (this.dFl.bjJ()) {
                this.fYY = true;
                this.dFl.pausePlay();
            } else if (this.dFl.bjP() == 3) {
                this.fYY = false;
            } else {
                this.fYY = false;
                this.dFl.pausePlay();
            }
            if (this.fZm != null) {
                this.fZm.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dFl != null && this.fYY) {
            this.dFl.aOR();
        }
    }

    private void bfR() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ag(true);
            dVar.ai(false);
            dVar.cX(16908290).cW(153).ah(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fJR.getActivity());
                    if (i.this.fZp == null) {
                        try {
                            i.this.fZp = BitmapFactory.decodeResource(i.this.fJR.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fZp);
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
                    i.this.fZo = null;
                    if (i.this.fZp != null && !i.this.fZp.isRecycled()) {
                        i.this.fZp.recycle();
                    }
                    i.this.fZp = null;
                }
            });
            this.fZo = dVar.mD();
            this.fZo.k(this.fJR.getActivity());
        }
    }

    public boolean ne(int i) {
        if (this.dFl == null) {
            return false;
        }
        return this.dFl.tR(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(String str) {
        if (this.fYR != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fYR.video_md5, "", str, this.fYS);
            }
        }
    }

    public void bfS() {
        if (this.fYO != null) {
            this.fYO.kQ(this.fJR.baY());
        }
    }

    public void beN() {
        if (this.fYO != null) {
            this.fYO.beN();
        }
    }

    public void tf(int i) {
        if (this.fYO != null) {
            this.fYO.tf(i);
        }
        if (this.fZm != null) {
            this.fZm.onChangeSkinType(i);
        }
        if (this.fYT != null) {
            this.fYT.gz(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bfV()) {
                    this.fZb = i;
                    if (this.fZb == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tl(i.this.bfW().getHeight());
                            }
                        }, 100L);
                    }
                    bfT();
                    return;
                }
                return;
        }
    }

    private void tk(int i) {
        if (bfW().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYP.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fZg != bfW().getHeight()) {
                        this.fYP.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ao(this.fJR.getActivity()), Math.min(this.fZg, bfW().getHeight() + i)));
                        this.dFl.aOM();
                    }
                } else if (com.baidu.adp.lib.util.l.ao(this.fJR.getActivity()) * 0.5625d != bfW().getHeight()) {
                    this.fYP.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ao(this.fJR.getActivity()), (int) Math.max(com.baidu.adp.lib.util.l.ao(this.fJR.getActivity()) * 0.5625d, bfW().getHeight() + i)));
                    this.dFl.aOM();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bfY()) {
                int bottom = childAt.getBottom() - bfW().getBottom();
                if (childAt.getHeight() == 0 || bfW().getHeight() == 0) {
                    bottom = 0;
                }
                tk(bottom);
            } else {
                tk((-this.fZg) + 2);
            }
        }
        if (!bfV() && this.fZl) {
            if (this.fZb == 1) {
                tl(bfW().getHeight());
            } else if (this.fZb == 2) {
                int y = (int) bfW().getY();
                if (this.fZc == y) {
                    tl(bfW().getHeight());
                } else {
                    this.fZc = y;
                    tl(bfW().getHeight());
                }
                if (i == 0 && this.fZf) {
                    this.fZf = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bfQ();
                        }
                    }, 100L);
                }
            } else if (this.fZb == 0) {
                tl(bfW().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        tm(i);
        bfT();
    }

    private void tm(int i) {
        if (this.fYT != null) {
            if (i == 0) {
                i = this.fZg;
            }
            float f = this.fZg - i;
            float f2 = f > this.fZd ? 0.0f : 1.0f - (f / this.fZd);
            if (f2 == 0.0f) {
                this.fYT.bfM().setVisibility(8);
            } else {
                this.fYT.bfM().setVisibility(0);
            }
            this.fYT.an(f2);
        }
    }

    public void bfT() {
        if (this.fYT != null) {
            if (bfV()) {
                this.fJR.bam().bec();
            } else if (this.fYT.bfM().getVisibility() == 0) {
                this.fJR.bam().bec();
                this.fYU = true;
            } else if (this.fYU) {
                this.fJR.bam().kC(false);
                this.fYU = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfU() {
        return bfW().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fZa = false;
        if (this.dFl != null && this.fYP != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYP.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.fZo != null) {
                    this.fZo.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fZa = true;
                this.fYP.setLayoutParams(layoutParams);
                this.fJR.bam().bec();
                this.fYU = true;
            } else {
                b(this.fYR);
                bfS();
                this.fZa = false;
                this.fYO.kP(true);
            }
            this.dFl.a(this.fJR.getPageContext(), configuration);
        }
    }

    public boolean bfV() {
        return this.fZa;
    }

    public void y(long j, int i) {
        if (this.fYT != null && j > 0) {
            this.fYT.j(i, j);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.fYT != null) {
            this.fYT.I(onClickListener);
        }
    }

    public View bfW() {
        return this.fYN;
    }

    public boolean ben() {
        if (bfW() == null) {
            return false;
        }
        return bfW().getBottom() > com.baidu.adp.lib.util.l.aq(bfW().getContext()) - com.baidu.adp.lib.util.l.s(bfW().getContext(), d.e.ds50);
    }

    public void bfX() {
        this.fZf = true;
    }

    public View bfY() {
        return this.mEmptyView;
    }
}
