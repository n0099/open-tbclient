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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private static VideoControllerView.a eLY = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void QE() {
        }
    };
    private static c.h fJl = new c.h() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.h
        public void ave() {
        }
    };
    private n btk;
    private com.baidu.tieba.play.c dls;
    private RelativeLayout fIF;
    private com.baidu.tieba.pb.pb.main.view.b fIG;
    private CustomFrameLayout fIH;
    private c.InterfaceC0217c fII;
    private y fIK;
    private g fIL;
    private boolean fIM;
    private bd fIN;
    private bd fIO;
    private String fIP;
    private float fIV;
    private int fIY;
    private double fIZ;
    private long fJa;
    private PbVideoWifiTipLayout fJb;
    private c.InterfaceC0217c fJc;
    private PbFullScreenFloatingHuajiAninationView fJe;
    private com.baidu.adp.lib.guide.c fJg;
    private Bitmap fJh;
    private boolean fJi;
    private int fJk;
    private PbActivity ftp;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String biU = null;
    private VideoInfo fIJ = null;
    private boolean fIQ = false;
    private int fIR = 0;
    private boolean fIS = false;
    private int fIT = 0;
    private int fIU = 0;
    private boolean fIW = false;
    private boolean fIX = false;
    private boolean fJd = true;
    private PbFullScreenFloatingHuajiAninationView.a fJf = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.kS(false);
        }
    };
    private c.l fJj = new c.l() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.play.c.l
        public void bhA() {
            if (i.this.ftp.checkUpIsLogin()) {
                i.this.ftp.bcv();
                if (i.this.ftp.bbt() != null && i.this.ftp.bbt().getPbData() != null && i.this.ftp.bbt().getPbData().baK() != null) {
                    j baK = i.this.ftp.bbt().getPbData().baK();
                    if (i.this.fJe == null) {
                        i.this.fJe = new PbFullScreenFloatingHuajiAninationView(i.this.ftp.getActivity());
                        i.this.fJe.setFloatingHuajiAninationListener(i.this.fJf);
                    }
                    i.this.fJe.kU(!baK.baS());
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dls != null) {
                    i.this.dls.bkW();
                }
                if (com.baidu.adp.lib.util.j.jD() && com.baidu.adp.lib.util.j.jF() && i.this.dls != null && i.this.dls.bkY() && i.this.fIJ != null && i.this.fIJ.video_length.intValue() > 0 && i.this.fIJ.video_duration.intValue() > 0) {
                    float intValue = i.this.fIJ.video_length.intValue() * (1.0f - ((i.this.dls.getCurrentPosition() * 1.0f) / (i.this.fIJ.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.ftp.getPageContext().getPageActivity(), String.format(i.this.ftp.getPageContext().getString(d.k.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eKa = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bgk();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kS(boolean z) {
        if (this.ftp.bbt() != null && this.ftp.bbt().getPbData() != null && this.ftp.bbt().getPbData().baK() != null) {
            j baK = this.ftp.bbt().getPbData().baK();
            View findViewById = this.ftp.getActivity().findViewById(d.g.view_main_thread_praise_state);
            if (!baK.baS() || z) {
                this.ftp.a(findViewById, 2, false, 2);
                TiebaStatic.log(this.ftp.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, baK.baS() ? 0 : 1));
            } else if (baK.baS()) {
                if (baK.fpg == 1 || baK.fpg == 3 || baK.fpg == 4) {
                    this.ftp.a(findViewById, 2, true, 2);
                    TiebaStatic.log(this.ftp.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, baK.baS() ? 0 : 1));
                }
            }
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fIV = 0.0f;
        this.ftp = pbActivity;
        this.fIG = bVar;
        this.fIV = l.e(this.ftp.getActivity(), d.e.ds240);
        this.fJa = j;
        c(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int b(VideoInfo videoInfo) {
        int ah = l.ah(this.ftp.getActivity());
        Rect t = az.t(this.ftp.getPageContext().getPageActivity());
        int aj = t.height() <= 0 ? l.aj(this.ftp.getActivity()) : t.height();
        int i = (int) (ah * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fIZ = (intValue2 * 1.0d) / intValue;
            if (this.fIZ > 0.5625d) {
                i = Math.min((ah * intValue2) / intValue, aj);
            }
        }
        this.fIY = i;
        this.fIH.setLayoutParams(new RelativeLayout.LayoutParams(ah, i));
        return i;
    }

    private void c(VideoInfo videoInfo) {
        this.fIF = (RelativeLayout) LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.video_pb_container_layout, (ViewGroup) null);
        this.fIH = (CustomFrameLayout) this.fIF.findViewById(d.g.pb_video_container);
        int b = b(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dls = new com.baidu.tieba.play.c(this.ftp.getPageContext(), this.fIH, true);
        this.dls.a(this.fJj);
        this.dls.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // com.baidu.tieba.play.c.j
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.j
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.j
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.ftp.getListView() != null && i.this.ftp.getListView().getChildCount() > 0 && i.this.ftp.getListView().getChildAt(0) == i.this.bhy()) {
                            i.this.fJk = i.this.bhy().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.fJk = 0;
                        break;
                    case 2:
                        if (i.this.ftp.getListView() != null && i.this.ftp.getListView().getChildCount() > 0 && i.this.ftp.getListView().getChildAt(0) == i.this.bhy()) {
                            i.this.ftp.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.fJk);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fIZ >= 1.0d) {
                this.dls.K(false, true);
            } else {
                this.dls.K(true, false);
            }
            this.fIW = ((float) b) + this.fIV > ((float) l.aj(this.ftp.getActivity()));
            if (this.fIW) {
                if (this.fIL == null) {
                    this.fIL = new g(this.ftp.getPageContext(), this.fIH);
                    this.fIL.K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.14
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            i.this.kS(true);
                        }
                    });
                }
                this.ftp.bbK().bfy();
                this.fIM = true;
            }
        }
        bhr();
        this.mEmptyView = new View(this.ftp);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fIY));
        if (this.fIG != null && this.fIG.mNavigationBar != null) {
            this.fIG.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fIG.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fIG.mNavigationBar.setStatusBarVisibility(8);
        }
        this.fJb = (PbVideoWifiTipLayout) this.fIF.findViewById(d.g.layout_wifi_tip);
        this.fJb.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fJi = true;
                i.this.fJb.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.ftp.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fII == null) {
            this.fII = new c.InterfaceC0217c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void fM(boolean z) {
                    if (i.this.bhu() && i.this.fIG != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fIG.bge().clearAnimation();
                        i.this.bhs();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eKa);
                            i.this.fIG.bge().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0217c
                public void avd() {
                    if (i.this.bhu()) {
                        i.this.bgk();
                    }
                }
            };
        }
        a(this.fII);
        this.fIR = UtilHelper.getLightStatusBarHeight() + l.e(this.ftp.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bd bdVar, String str) {
        if (videoInfo != null && this.dls != null && bdVar != null) {
            this.fIJ = videoInfo;
            this.fIN = bdVar;
            this.biU = videoInfo.video_url;
            this.dls.stopPlay();
            this.dls.lu(true);
            this.btk = new n(this.ftp.getActivity());
            this.fIK = new y();
            this.fIK.mLocate = "pb";
            this.fIK.aVt = bdVar.getTid();
            this.fIK.cBu = str;
            this.fIK.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fIK.mSource = bdVar.mRecomSource;
            this.fIK.gdc = bdVar.mRecomWeight;
            this.fIK.gdd = this.ftp.bbI();
            this.fIK.gde = bdVar.mRecomAbTag;
            this.fIK.gdf = videoInfo.video_md5;
            y bma = this.fIK.bma();
            bma.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.btk.setVideoStatsData(bma);
            this.dls.getVideoView().setBusiness(this.btk);
            if (this.dls.aQw()) {
                this.dls.aQu();
            }
            this.dls.b(this.fJc);
            this.fIP = null;
            this.fIO = null;
            this.dls.rN(this.fIP);
            this.dls.aQq().setOnDragingListener(eLY);
            this.dls.a(new c.b() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.b
                public void ava() {
                    i.this.ftp.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.fJd = true;
                        }
                    }, 50L);
                }

                @Override // com.baidu.tieba.play.c.b
                public void auZ() {
                    i.this.ftp.setSwipeBackEnabled(false);
                    i.this.fJd = false;
                }
            });
            this.dls.a(new c.g() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.g
                public void bhz() {
                    if (i.this.ftp != null && i.this.fIO != null && !StringUtils.isNull(i.this.fIO.getId())) {
                        i.this.ftp.ri(i.this.fIO.getId());
                        if (i.this.fIN != null) {
                            long j = 0;
                            if (i.this.fIN.wm() != null) {
                                j = i.this.fIN.wm().channelId;
                            }
                            TiebaStatic.log(new am("c11921").f(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dls.a(new c.i() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.i
                public void kT(boolean z) {
                    if (i.this.fIN != null) {
                        long j = 0;
                        if (i.this.fIN.wm() != null) {
                            j = i.this.fIN.wm().channelId;
                        }
                        i.this.my(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").ah("tid", i.this.fIN.getTid()).f(ImageViewerConfig.FORUM_ID, i.this.fIN.getFid()).f(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dls.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.biU);
                    return true;
                }
            });
            this.dls.pq(videoInfo.thumbnail_url);
            this.dls.bS(this.biU, bdVar.getTid());
            this.dls.sh(bdVar.getTitle());
            this.dls.a(fJl);
            this.dls.aDt();
            this.dls.show();
        }
    }

    public void rM(String str) {
        if (this.fIK != null) {
            this.fIK.cBu = str;
        }
    }

    public void b(PostData postData, bd bdVar, j jVar) {
        if (this.fIL != null) {
            this.fIL.a(postData, bdVar, jVar);
        }
    }

    public void a(c.InterfaceC0217c interfaceC0217c) {
        this.fJc = interfaceC0217c;
    }

    public void al(bd bdVar) {
        this.fIO = bdVar;
    }

    public void rN(String str) {
        this.fIP = str;
        if (this.dls != null) {
            this.dls.rN(this.fIP);
        }
    }

    public void startPlay() {
        if (this.dls != null) {
            if (com.baidu.adp.lib.util.j.jF() && !this.fJi && !com.baidu.tieba.video.f.bBb().bBc()) {
                this.fJb.setVisibility(0);
                this.fJb.setData(this.fIJ);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.biU) && this.fIN != null && this.fIN.vD() != null) {
                TiebaStatic.log(new am("c12619").ah("obj_locate", "pb").ah("tid", this.fIN.getTid()));
                this.biU = this.fIN.vD().video_url;
            }
            this.dls.b(this.biU, this.fIN == null ? "" : this.fIN.getTid(), this.fJa);
            my("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bhq() {
        if (this.dls != null) {
            this.dls.bhq();
        }
    }

    public void destroy() {
        if (this.dls != null) {
            this.dls.destroy();
        }
        if (this.fIH != null) {
            this.fIH.clearAnimation();
        }
        if (this.fIL != null) {
            this.fIL.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dls != null) {
            if (this.dls.bkY()) {
                this.fIQ = true;
                this.dls.pausePlay();
            } else if (this.dls.blf() == 3) {
                this.fIQ = false;
            } else {
                this.fIQ = false;
                this.dls.pausePlay();
            }
            if (this.fJe != null) {
                this.fJe.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dls != null && this.fIQ) {
            this.dls.aQz();
        }
    }

    private void bhr() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.G(false);
            dVar.Y(16908290).X(153).F(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.ftp.getActivity());
                    if (i.this.fJh == null) {
                        try {
                            i.this.fJh = BitmapFactory.decodeResource(i.this.ftp.getResources(), d.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fJh);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hw() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hx() {
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
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fJg = null;
                    if (i.this.fJh != null && !i.this.fJh.isRecycled()) {
                        i.this.fJh.recycle();
                    }
                    i.this.fJh = null;
                }
            });
            this.fJg = dVar.hy();
            this.fJg.l(this.ftp.getActivity());
        }
    }

    public boolean ku(int i) {
        if (this.dls == null) {
            return false;
        }
        return this.dls.ry(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (this.fIJ != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fIJ.video_md5, "", str, this.fIK);
            }
        }
    }

    public void bhs() {
        if (this.fIG != null) {
            this.fIG.kI(this.ftp.bcu());
        }
    }

    public void bgk() {
        if (this.fIG != null) {
            this.fIG.bgk();
        }
    }

    public void qQ(int i) {
        if (this.fIG != null) {
            this.fIG.qQ(i);
        }
        if (this.fJe != null) {
            this.fJe.onChangeSkinType(i);
        }
        if (this.fIL != null) {
            this.fIL.dC(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bhv()) {
                    this.fIT = i;
                    if (this.fIT == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.qX(i.this.bhw().getHeight());
                            }
                        }, 100L);
                    }
                    bht();
                    return;
                }
                return;
        }
    }

    private void qW(int i) {
        if (bhw().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIH.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    if (this.fIY != bhw().getHeight()) {
                        this.fIH.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.ftp.getActivity()), Math.min(this.fIY, bhw().getHeight() + i)));
                        this.dls.aQu();
                    }
                } else if (l.ah(this.ftp.getActivity()) * 0.5625d != bhw().getHeight()) {
                    this.fIH.setLayoutParams(new RelativeLayout.LayoutParams(l.ah(this.ftp.getActivity()), (int) Math.max(l.ah(this.ftp.getActivity()) * 0.5625d, bhw().getHeight() + i)));
                    this.dls.aQu();
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
                qW(bottom);
            } else {
                qW((-this.fIY) + 2);
            }
        }
        if (!bhv() && this.fJd) {
            if (this.fIT == 1) {
                qX(bhw().getHeight());
            } else if (this.fIT == 2) {
                int y = (int) bhw().getY();
                if (this.fIU == y) {
                    qX(bhw().getHeight());
                } else {
                    this.fIU = y;
                    qX(bhw().getHeight());
                }
                if (i == 0 && this.fIX) {
                    this.fIX = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bhq();
                        }
                    }, 100L);
                }
            } else if (this.fIT == 0) {
                qX(bhw().getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        qY(i);
        bht();
    }

    private void qY(int i) {
        if (this.fIL != null) {
            if (i == 0) {
                i = this.fIY;
            }
            float f = this.fIY - i;
            float f2 = f > this.fIV ? 0.0f : 1.0f - (f / this.fIV);
            if (f2 == 0.0f) {
                this.fIL.bhm().setVisibility(8);
            } else {
                this.fIL.bhm().setVisibility(0);
            }
            this.fIL.ar(f2);
        }
    }

    public void bht() {
        if (this.fIL != null) {
            if (bhv()) {
                this.ftp.bbK().bfy();
            } else if (this.fIL.bhm().getVisibility() == 0) {
                this.ftp.bbK().bfy();
                this.fIM = true;
            } else if (this.fIM) {
                this.ftp.bbK().ku(false);
                this.fIM = false;
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
        this.fIS = false;
        if (this.dls != null && this.fIH != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIH.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fJg != null) {
                    this.fJg.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fIS = true;
                this.fIH.setLayoutParams(layoutParams);
                this.ftp.bbK().bfy();
                this.fIM = true;
            } else {
                b(this.fIJ);
                bhs();
                this.fIS = false;
                this.fIG.kH(true);
            }
            this.dls.a(this.ftp.getPageContext(), configuration);
        }
    }

    public boolean bhv() {
        return this.fIS;
    }

    public void y(long j, int i) {
        if (this.fIL != null && j > 0) {
            this.fIL.l(i, j);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fIL != null) {
            this.fIL.J(onClickListener);
        }
    }

    public View bhw() {
        return this.fIF;
    }

    public boolean bfH() {
        if (bhw() == null) {
            return false;
        }
        return bhw().getBottom() > l.aj(bhw().getContext()) - l.e(bhw().getContext(), d.e.ds50);
    }

    public void bhx() {
        this.fIX = true;
    }

    public View bhy() {
        return this.mEmptyView;
    }
}
