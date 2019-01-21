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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class i {
    private static VideoControllerView.a fuI = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void WL() {
        }
    };
    private static c.i gpd = new c.i() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.i
        public void aEj() {
        }
    };
    private n bPe;
    private com.baidu.tieba.play.c dQw;
    private PbActivity fYK;
    private boolean goA;
    private bb goB;
    private bb goC;
    private String goD;
    private float goJ;
    private int goM;
    private double goN;
    private long goO;
    private PbVideoWifiTipLayout goP;
    private int goQ;
    private c.d goS;
    private PbFullScreenFloatingHuajiAninationView goU;
    private com.baidu.adp.lib.guide.c goW;
    private Bitmap goX;
    private boolean goY;
    private RelativeLayout got;
    private com.baidu.tieba.pb.pb.main.view.b gou;
    private CustomFrameLayout gov;
    private c.d gow;
    private z goy;
    private g goz;
    private boolean gpa;
    private int gpc;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aFr = null;
    private VideoInfo gox = null;
    private boolean goE = false;
    private int goF = 0;
    private boolean goG = false;
    private int goH = 0;
    private int goI = 0;
    private boolean goK = false;
    private boolean goL = false;
    private c.o goR = new c.o() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.o
        public void boR() {
            if (i.this.fYK != null && i.this.fYK.biD() != null && i.this.fYK.biD().getPbData() != null) {
                PostData bhG = i.this.fYK.biD().getPbData().bhG();
                if (bhG == null && v.H(i.this.fYK.biD().getPbData().bhB()) > 1) {
                    bhG = (PostData) v.d(i.this.fYK.biD().getPbData().bhB(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.fYK.biD().getPbData(), bhG, 1, 1, 4);
            }
        }
    };
    private boolean goT = true;
    private PbFullScreenFloatingHuajiAninationView.a goV = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lS(false);
        }
    };
    private boolean goZ = false;
    private c.m gpb = new c.m() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.play.c.m
        public boolean boT() {
            if (i.this.fYK.checkUpIsLogin()) {
                i.this.fYK.bjG();
                if (i.this.fYK.biD() == null || i.this.fYK.biD().getPbData() == null || i.this.fYK.biD().getPbData().bhX() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bhX = i.this.fYK.biD().getPbData().bhX();
                if (i.this.goU == null) {
                    i.this.goU = new PbFullScreenFloatingHuajiAninationView(i.this.fYK.getActivity());
                    i.this.goU.setFloatingHuajiAninationListener(i.this.goV);
                }
                i.this.goU.lU(bhX.bid() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean boU() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.kV()) {
                    i.this.dQw.stopPlay();
                    i.this.dQw.mx(true);
                    return;
                }
                if (i.this.dQw != null) {
                    i.this.dQw.setNetworkChange();
                }
                if (j.kX() && i.this.dQw != null && i.this.dQw.bsq() && i.this.gox != null && i.this.gox.video_length.intValue() > 0 && i.this.gox.video_duration.intValue() > 0) {
                    float intValue = i.this.gox.video_length.intValue() * (1.0f - ((i.this.dQw.getCurrentPosition() * 1.0f) / (i.this.gox.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fYK.getPageContext().getPageActivity(), String.format(i.this.fYK.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fsJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bnF();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.fYK != null) {
            this.fYK.biW();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.goJ = 0.0f;
        this.fYK = pbActivity;
        this.gou = bVar;
        this.goJ = l.h(this.fYK.getActivity(), e.C0210e.ds240);
        this.goO = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fYK.getActivity());
        Rect z = az.z(this.fYK.getPageContext().getPageActivity());
        int aQ = z.height() <= 0 ? l.aQ(this.fYK.getActivity()) : z.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.goN = (intValue2 * 1.0d) / intValue;
            if (this.goN > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.goM = i;
        this.gov.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.got = (RelativeLayout) LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gov = (CustomFrameLayout) this.got.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dQw = new com.baidu.tieba.play.c((TbPageContext<?>) this.fYK.getPageContext(), (View) this.gov, true);
        this.dQw.a(this.gpb);
        this.dQw.mA(false);
        this.dQw.a(this.goR);
        this.dQw.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.14
            @Override // com.baidu.tieba.play.c.k
            public void onStart() {
            }

            @Override // com.baidu.tieba.play.c.k
            public void onStop() {
            }

            @Override // com.baidu.tieba.play.c.k
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        i.this.mLastY = motionEvent.getY();
                        if (i.this.fYK.getListView() != null && i.this.fYK.getListView().getChildCount() > 0 && i.this.fYK.getListView().getChildAt(0) == i.this.boQ()) {
                            i.this.gpc = i.this.boQ().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gpc = 0;
                        break;
                    case 2:
                        if (i.this.fYK.getListView() != null && i.this.fYK.getListView().getChildCount() > 0 && i.this.fYK.getListView().getChildAt(0) == i.this.boQ()) {
                            i.this.fYK.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gpc);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.goN >= 1.0d) {
                this.dQw.S(false, true);
            } else {
                this.dQw.S(true, false);
            }
            this.goK = ((float) e) + this.goJ > ((float) l.aQ(this.fYK.getActivity()));
            if (this.goK) {
                if (this.goz == null) {
                    this.goz = new g(this.fYK.getPageContext(), this.gov);
                }
                this.fYK.biU().bmO();
                this.goA = true;
            }
        }
        boI();
        this.mEmptyView = new View(this.fYK);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.goM));
        if (this.gou != null && this.gou.mNavigationBar != null) {
            this.gou.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gou.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gou.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.CS() ? 0 : 8);
        }
        this.goP = (PbVideoWifiTipLayout) this.got.findViewById(e.g.layout_wifi_tip);
        this.goP.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.goY = true;
                i.this.goP.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fYK.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gow == null) {
            this.gow = new c.d() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.d
                public void ha(boolean z) {
                    if (i.this.boL() && i.this.gou != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gou.bnz().clearAnimation();
                        i.this.boJ();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fsJ);
                            i.this.gou.bnz().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aEi() {
                    if (i.this.boL()) {
                        i.this.bnF();
                    }
                }
            };
        }
        a(this.gow);
        this.goF = UtilHelper.getLightStatusBarHeight() + l.h(this.fYK.getActivity(), e.C0210e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dQw != null && bbVar != null) {
            this.gox = videoInfo;
            this.goB = bbVar;
            this.aFr = videoInfo.video_url;
            this.dQw.stopPlay();
            this.dQw.setIsNeedRecoveryVideoPlayer(true);
            this.bPe = new n(this.fYK.getActivity());
            this.goy = new z();
            this.goy.mLocate = "pb";
            this.goy.bjn = bbVar.getTid();
            this.goy.dbs = str;
            this.goy.mUid = TbadkCoreApplication.getCurrentAccount();
            this.goy.mSource = bbVar.mRecomSource;
            this.goy.gIK = bbVar.mRecomWeight;
            this.goy.gIL = this.fYK.biS();
            this.goy.gIM = bbVar.mRecomAbTag;
            this.goy.gIN = videoInfo.video_md5;
            z bty = this.goy.bty();
            bty.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bPe.setVideoStatsData(bty);
            this.dQw.getVideoView().setBusiness(this.bPe);
            if (this.dQw.bae()) {
                this.dQw.bac();
            }
            this.dQw.b(this.goS);
            this.goD = null;
            this.goC = null;
            this.dQw.tM(this.goD);
            this.dQw.aZY().setOnDragingListener(fuI);
            this.dQw.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                    i.this.fYK.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.goQ > 0) {
                                i.this.tb(i.this.goQ);
                                i.this.tc(i.this.goQ);
                                i.this.goQ = 0;
                            }
                            i.this.goT = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                    i.this.fYK.setSwipeBackEnabled(false);
                    i.this.goT = false;
                    i.this.goQ = i.this.boN().getHeight();
                }
            });
            this.dQw.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.h
                public void boS() {
                    if (i.this.fYK != null && i.this.goC != null && !StringUtils.isNull(i.this.goC.getId())) {
                        i.this.fYK.ti(i.this.goC.getId());
                        if (i.this.goB != null) {
                            long j = 0;
                            if (i.this.goB.AW() != null) {
                                j = i.this.goB.AW().channelId;
                            }
                            TiebaStatic.log(new am("c11921").i(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dQw.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.j
                public void lT(boolean z) {
                    if (i.this.goB != null) {
                        long j = 0;
                        if (i.this.goB.AW() != null) {
                            j = i.this.goB.AW().channelId;
                        }
                        i.this.oz(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").aB("tid", i.this.goB.getTid()).i(ImageViewerConfig.FORUM_ID, i.this.goB.getFid()).i(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dQw.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aFr);
                    return true;
                }
            });
            this.dQw.setThumbnail(videoInfo.thumbnail_url);
            this.dQw.setVideoUrl(this.aFr, bbVar.getTid());
            this.dQw.setFid(str);
            this.dQw.uk(bbVar.getTitle());
            this.dQw.a(gpd);
            this.dQw.aNk();
            this.dQw.show();
        }
    }

    public void tL(String str) {
        if (this.goy != null) {
            this.goy.dbs = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.goz != null) {
            this.goz.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.goS = dVar;
    }

    public void as(bb bbVar) {
        this.goC = bbVar;
    }

    public void tM(String str) {
        this.goD = str;
        if (this.dQw != null) {
            this.dQw.tM(this.goD);
        }
    }

    public void startPlay() {
        if (this.dQw != null) {
            if (j.kX() && !this.goY && !com.baidu.tieba.video.g.bJp().bJq()) {
                this.goP.setVisibility(0);
                this.goP.setData(this.gox);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aFr) && this.goB != null && this.goB.Al() != null) {
                TiebaStatic.log(new am("c12619").aB("obj_locate", "pb").aB("tid", this.goB.getTid()));
                this.aFr = this.goB.Al().video_url;
            }
            this.dQw.c(this.aFr, this.goB == null ? "" : this.goB.getTid(), this.goO);
            oz("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void boH() {
        if (this.dQw != null) {
            this.dQw.boH();
        }
    }

    public void destroy() {
        if (this.dQw != null) {
            this.dQw.destroy();
        }
        if (this.gov != null) {
            this.gov.clearAnimation();
        }
        if (this.goz != null) {
            this.goz.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dQw != null) {
            if (this.dQw.bsq()) {
                this.goE = true;
                this.dQw.stopPlay();
            } else if (this.dQw.getCurrentState() == 3) {
                this.goE = false;
            } else if (this.dQw.getCurrentState() == 0 || this.dQw.getCurrentState() == 1) {
                this.goE = true;
                this.dQw.stopPlay();
            } else {
                this.goE = false;
                this.dQw.stopPlay();
            }
            if (this.goU != null) {
                this.goU.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dQw != null && this.goE) {
            this.dQw.bsn();
        }
    }

    private void boI() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ax(16908290).aw(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fYK.getActivity());
                    if (i.this.goX == null) {
                        try {
                            i.this.goX = BitmapFactory.decodeResource(i.this.fYK.getResources(), e.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.goX);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iR() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iS() {
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
                    i.this.goW = null;
                    if (i.this.goX != null && !i.this.goX.isRecycled()) {
                        i.this.goX.recycle();
                    }
                    i.this.goX = null;
                }
            });
            this.goW = dVar.iT();
            this.goW.o(this.fYK.getActivity());
        }
    }

    public boolean mI(int i) {
        if (this.dQw == null) {
            return false;
        }
        return this.dQw.tC(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(String str) {
        if (this.gox != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gox.video_md5, "", str, this.goy);
            }
        }
    }

    public void boJ() {
        if (this.gou != null) {
            this.gou.lK(this.fYK.bit());
        }
    }

    public void bnF() {
        if (this.gou != null) {
            this.gou.bnF();
        }
    }

    public void sW(int i) {
        if (this.gou != null) {
            this.gou.sW(i);
        }
        if (this.goU != null) {
            this.goU.onChangeSkinType(i);
        }
        if (this.goz != null) {
            this.goz.eD(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!boM()) {
                    this.goH = i;
                    if (this.goH == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.tc(i.this.boN().getHeight());
                            }
                        }, 100L);
                    }
                    boK();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        if (boN().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gov.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.gpa = false;
                    if (this.goM != boN().getHeight()) {
                        this.gov.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fYK.getActivity()), Math.min(this.goM, boN().getHeight() + i)));
                        this.dQw.bac();
                    }
                } else if (l.aO(this.fYK.getActivity()) * 0.5625d != boN().getHeight()) {
                    this.gov.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fYK.getActivity()), (int) Math.max(l.aO(this.fYK.getActivity()) * 0.5625d, boN().getHeight() + i)));
                    this.dQw.bac();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == boQ()) {
                int bottom = childAt.getBottom() - boN().getBottom();
                if (childAt.getHeight() == 0 || boN().getHeight() == 0) {
                    bottom = 0;
                }
                tb(bottom);
            } else {
                tb((-this.goM) + 2);
            }
        }
        if (!boM() && this.goT) {
            if (this.goH == 1) {
                this.goZ = true;
                tc(boN().getHeight());
            } else if (this.goH == 2) {
                this.goZ = true;
                int y = (int) boN().getY();
                if (this.goI == y) {
                    tc(boN().getHeight());
                } else {
                    this.goI = y;
                    tc(boN().getHeight());
                }
                if (i == 0 && this.goL) {
                    this.goL = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.boH();
                        }
                    }, 100L);
                }
            } else if (this.goH == 0) {
                if (this.goZ || !"nani_midpage".equals(this.fYK.biS())) {
                    tc(boN().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
        td(i);
        boK();
    }

    public void lw(boolean z) {
        this.gpa = z;
    }

    private void td(int i) {
        if (this.goz != null) {
            if (i == 0) {
                i = this.goM;
            }
            float f = this.goM - i;
            float f2 = f > this.goJ ? 0.0f : 1.0f - (f / this.goJ);
            if (this.gpa) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.goz.boD().setVisibility(8);
            } else {
                this.goz.boD().setVisibility(0);
            }
            this.goz.aw(f2);
        }
    }

    public void boK() {
        if (this.goz != null) {
            if (boM()) {
                this.fYK.biU().bmO();
            } else if (this.goz.boD().getVisibility() == 0) {
                this.fYK.biU().bmO();
                this.goA = true;
            } else if (this.goA) {
                this.fYK.biU().lv(false);
                this.goA = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boL() {
        return boN().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.goG = false;
        if (this.dQw != null && this.gov != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gov.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.goW != null) {
                    this.goW.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.goG = true;
                this.gov.setLayoutParams(layoutParams);
                this.fYK.biU().bmO();
                this.goA = true;
            } else {
                e(this.gox);
                boJ();
                this.goG = false;
                this.gou.lJ(true);
            }
            this.dQw.a(this.fYK.getPageContext(), configuration);
        }
    }

    public boolean boM() {
        return this.goG;
    }

    public void n(long j, int i) {
        if (this.goz != null && j > 0) {
            this.goz.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.goz != null) {
            this.goz.N(onClickListener);
        }
    }

    public View boN() {
        return this.got;
    }

    public boolean bmX() {
        if (boN() == null) {
            return false;
        }
        return boN().getBottom() > l.aQ(boN().getContext()) - l.h(boN().getContext(), e.C0210e.ds50);
    }

    public void boO() {
        this.goL = true;
    }

    public void boP() {
        if (this.dQw != null) {
            this.dQw.pausePlay();
        }
    }

    public View boQ() {
        return this.mEmptyView;
    }
}
