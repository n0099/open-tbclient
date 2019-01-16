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
    private static VideoControllerView.a fuH = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void WL() {
        }
    };
    private static c.i gpc = new c.i() { // from class: com.baidu.tieba.pb.video.i.8
        @Override // com.baidu.tieba.play.c.i
        public void aEj() {
        }
    };
    private n bPd;
    private com.baidu.tieba.play.c dQv;
    private PbActivity fYJ;
    private bb goA;
    private bb goB;
    private String goC;
    private float goI;
    private int goL;
    private double goM;
    private long goN;
    private PbVideoWifiTipLayout goO;
    private int goP;
    private c.d goR;
    private PbFullScreenFloatingHuajiAninationView goT;
    private com.baidu.adp.lib.guide.c goV;
    private Bitmap goW;
    private boolean goX;
    private boolean goZ;
    private RelativeLayout gos;
    private com.baidu.tieba.pb.pb.main.view.b got;
    private CustomFrameLayout gou;
    private c.d gov;
    private z gox;
    private g goy;
    private boolean goz;
    private int gpb;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aFq = null;
    private VideoInfo gow = null;
    private boolean goD = false;
    private int goE = 0;
    private boolean goF = false;
    private int goG = 0;
    private int goH = 0;
    private boolean goJ = false;
    private boolean goK = false;
    private c.o goQ = new c.o() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.o
        public void boR() {
            if (i.this.fYJ != null && i.this.fYJ.biD() != null && i.this.fYJ.biD().getPbData() != null) {
                PostData bhG = i.this.fYJ.biD().getPbData().bhG();
                if (bhG == null && v.H(i.this.fYJ.biD().getPbData().bhB()) > 1) {
                    bhG = (PostData) v.d(i.this.fYJ.biD().getPbData().bhB(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.fYJ.biD().getPbData(), bhG, 1, 1, 4);
            }
        }
    };
    private boolean goS = true;
    private PbFullScreenFloatingHuajiAninationView.a goU = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.11
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lS(false);
        }
    };
    private boolean goY = false;
    private c.m gpa = new c.m() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.play.c.m
        public boolean boT() {
            if (i.this.fYJ.checkUpIsLogin()) {
                i.this.fYJ.bjG();
                if (i.this.fYJ.biD() == null || i.this.fYJ.biD().getPbData() == null || i.this.fYJ.biD().getPbData().bhX() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bhX = i.this.fYJ.biD().getPbData().bhX();
                if (i.this.goT == null) {
                    i.this.goT = new PbFullScreenFloatingHuajiAninationView(i.this.fYJ.getActivity());
                    i.this.goT.setFloatingHuajiAninationListener(i.this.goU);
                }
                i.this.goT.lU(bhX.bid() ? false : true);
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
                    i.this.dQv.stopPlay();
                    i.this.dQv.mx(true);
                    return;
                }
                if (i.this.dQv != null) {
                    i.this.dQv.setNetworkChange();
                }
                if (j.kX() && i.this.dQv != null && i.this.dQv.bsq() && i.this.gow != null && i.this.gow.video_length.intValue() > 0 && i.this.gow.video_duration.intValue() > 0) {
                    float intValue = i.this.gow.video_length.intValue() * (1.0f - ((i.this.dQv.getCurrentPosition() * 1.0f) / (i.this.gow.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fYJ.getPageContext().getPageActivity(), String.format(i.this.fYJ.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener fsI = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.17
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
        if (this.fYJ != null) {
            this.fYJ.biW();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.goI = 0.0f;
        this.fYJ = pbActivity;
        this.got = bVar;
        this.goI = l.h(this.fYJ.getActivity(), e.C0210e.ds240);
        this.goN = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fYJ.getActivity());
        Rect z = az.z(this.fYJ.getPageContext().getPageActivity());
        int aQ = z.height() <= 0 ? l.aQ(this.fYJ.getActivity()) : z.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.goM = (intValue2 * 1.0d) / intValue;
            if (this.goM > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.goL = i;
        this.gou.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.gos = (RelativeLayout) LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gou = (CustomFrameLayout) this.gos.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dQv = new com.baidu.tieba.play.c((TbPageContext<?>) this.fYJ.getPageContext(), (View) this.gou, true);
        this.dQv.a(this.gpa);
        this.dQv.mA(false);
        this.dQv.a(this.goQ);
        this.dQv.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.14
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
                        if (i.this.fYJ.getListView() != null && i.this.fYJ.getListView().getChildCount() > 0 && i.this.fYJ.getListView().getChildAt(0) == i.this.boQ()) {
                            i.this.gpb = i.this.boQ().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gpb = 0;
                        break;
                    case 2:
                        if (i.this.fYJ.getListView() != null && i.this.fYJ.getListView().getChildCount() > 0 && i.this.fYJ.getListView().getChildAt(0) == i.this.boQ()) {
                            i.this.fYJ.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gpb);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.goM >= 1.0d) {
                this.dQv.S(false, true);
            } else {
                this.dQv.S(true, false);
            }
            this.goJ = ((float) e) + this.goI > ((float) l.aQ(this.fYJ.getActivity()));
            if (this.goJ) {
                if (this.goy == null) {
                    this.goy = new g(this.fYJ.getPageContext(), this.gou);
                }
                this.fYJ.biU().bmO();
                this.goz = true;
            }
        }
        boI();
        this.mEmptyView = new View(this.fYJ);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.goL));
        if (this.got != null && this.got.mNavigationBar != null) {
            this.got.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.got.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.got.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.CS() ? 0 : 8);
        }
        this.goO = (PbVideoWifiTipLayout) this.gos.findViewById(e.g.layout_wifi_tip);
        this.goO.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.goX = true;
                i.this.goO.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fYJ.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gov == null) {
            this.gov = new c.d() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.d
                public void ha(boolean z) {
                    if (i.this.boL() && i.this.got != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.got.bnz().clearAnimation();
                        i.this.boJ();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.fsI);
                            i.this.got.bnz().startAnimation(loadAnimation);
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
        a(this.gov);
        this.goE = UtilHelper.getLightStatusBarHeight() + l.h(this.fYJ.getActivity(), e.C0210e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dQv != null && bbVar != null) {
            this.gow = videoInfo;
            this.goA = bbVar;
            this.aFq = videoInfo.video_url;
            this.dQv.stopPlay();
            this.dQv.setIsNeedRecoveryVideoPlayer(true);
            this.bPd = new n(this.fYJ.getActivity());
            this.gox = new z();
            this.gox.mLocate = "pb";
            this.gox.bjm = bbVar.getTid();
            this.gox.dbr = str;
            this.gox.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gox.mSource = bbVar.mRecomSource;
            this.gox.gIJ = bbVar.mRecomWeight;
            this.gox.gIK = this.fYJ.biS();
            this.gox.gIL = bbVar.mRecomAbTag;
            this.gox.gIM = videoInfo.video_md5;
            z bty = this.gox.bty();
            bty.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bPd.setVideoStatsData(bty);
            this.dQv.getVideoView().setBusiness(this.bPd);
            if (this.dQv.bae()) {
                this.dQv.bac();
            }
            this.dQv.b(this.goR);
            this.goC = null;
            this.goB = null;
            this.dQv.tM(this.goC);
            this.dQv.aZY().setOnDragingListener(fuH);
            this.dQv.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.pb.video.i.18
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zq() {
                    i.this.fYJ.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.goP > 0) {
                                i.this.tb(i.this.goP);
                                i.this.tc(i.this.goP);
                                i.this.goP = 0;
                            }
                            i.this.goS = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void Zp() {
                    i.this.fYJ.setSwipeBackEnabled(false);
                    i.this.goS = false;
                    i.this.goP = i.this.boN().getHeight();
                }
            });
            this.dQv.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.h
                public void boS() {
                    if (i.this.fYJ != null && i.this.goB != null && !StringUtils.isNull(i.this.goB.getId())) {
                        i.this.fYJ.ti(i.this.goB.getId());
                        if (i.this.goA != null) {
                            long j = 0;
                            if (i.this.goA.AW() != null) {
                                j = i.this.goA.AW().channelId;
                            }
                            TiebaStatic.log(new am("c11921").i(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dQv.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.j
                public void lT(boolean z) {
                    if (i.this.goA != null) {
                        long j = 0;
                        if (i.this.goA.AW() != null) {
                            j = i.this.goA.AW().channelId;
                        }
                        i.this.oz(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").aB("tid", i.this.goA.getTid()).i(ImageViewerConfig.FORUM_ID, i.this.goA.getFid()).i(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dQv.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aFq);
                    return true;
                }
            });
            this.dQv.setThumbnail(videoInfo.thumbnail_url);
            this.dQv.setVideoUrl(this.aFq, bbVar.getTid());
            this.dQv.setFid(str);
            this.dQv.uk(bbVar.getTitle());
            this.dQv.a(gpc);
            this.dQv.aNk();
            this.dQv.show();
        }
    }

    public void tL(String str) {
        if (this.gox != null) {
            this.gox.dbr = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.goy != null) {
            this.goy.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.goR = dVar;
    }

    public void as(bb bbVar) {
        this.goB = bbVar;
    }

    public void tM(String str) {
        this.goC = str;
        if (this.dQv != null) {
            this.dQv.tM(this.goC);
        }
    }

    public void startPlay() {
        if (this.dQv != null) {
            if (j.kX() && !this.goX && !com.baidu.tieba.video.g.bJp().bJq()) {
                this.goO.setVisibility(0);
                this.goO.setData(this.gow);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aFq) && this.goA != null && this.goA.Al() != null) {
                TiebaStatic.log(new am("c12619").aB("obj_locate", "pb").aB("tid", this.goA.getTid()));
                this.aFq = this.goA.Al().video_url;
            }
            this.dQv.c(this.aFq, this.goA == null ? "" : this.goA.getTid(), this.goN);
            oz("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void boH() {
        if (this.dQv != null) {
            this.dQv.boH();
        }
    }

    public void destroy() {
        if (this.dQv != null) {
            this.dQv.destroy();
        }
        if (this.gou != null) {
            this.gou.clearAnimation();
        }
        if (this.goy != null) {
            this.goy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dQv != null) {
            if (this.dQv.bsq()) {
                this.goD = true;
                this.dQv.stopPlay();
            } else if (this.dQv.getCurrentState() == 3) {
                this.goD = false;
            } else if (this.dQv.getCurrentState() == 0 || this.dQv.getCurrentState() == 1) {
                this.goD = true;
                this.dQv.stopPlay();
            } else {
                this.goD = false;
                this.dQv.stopPlay();
            }
            if (this.goT != null) {
                this.goT.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dQv != null && this.goD) {
            this.dQv.bsn();
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
                    ImageView imageView = new ImageView(i.this.fYJ.getActivity());
                    if (i.this.goW == null) {
                        try {
                            i.this.goW = BitmapFactory.decodeResource(i.this.fYJ.getResources(), e.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.goW);
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
                    i.this.goV = null;
                    if (i.this.goW != null && !i.this.goW.isRecycled()) {
                        i.this.goW.recycle();
                    }
                    i.this.goW = null;
                }
            });
            this.goV = dVar.iT();
            this.goV.o(this.fYJ.getActivity());
        }
    }

    public boolean mI(int i) {
        if (this.dQv == null) {
            return false;
        }
        return this.dQv.tC(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(String str) {
        if (this.gow != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gow.video_md5, "", str, this.gox);
            }
        }
    }

    public void boJ() {
        if (this.got != null) {
            this.got.lK(this.fYJ.bit());
        }
    }

    public void bnF() {
        if (this.got != null) {
            this.got.bnF();
        }
    }

    public void sW(int i) {
        if (this.got != null) {
            this.got.sW(i);
        }
        if (this.goT != null) {
            this.goT.onChangeSkinType(i);
        }
        if (this.goy != null) {
            this.goy.eD(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!boM()) {
                    this.goG = i;
                    if (this.goG == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gou.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.goZ = false;
                    if (this.goL != boN().getHeight()) {
                        this.gou.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fYJ.getActivity()), Math.min(this.goL, boN().getHeight() + i)));
                        this.dQv.bac();
                    }
                } else if (l.aO(this.fYJ.getActivity()) * 0.5625d != boN().getHeight()) {
                    this.gou.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fYJ.getActivity()), (int) Math.max(l.aO(this.fYJ.getActivity()) * 0.5625d, boN().getHeight() + i)));
                    this.dQv.bac();
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
                tb((-this.goL) + 2);
            }
        }
        if (!boM() && this.goS) {
            if (this.goG == 1) {
                this.goY = true;
                tc(boN().getHeight());
            } else if (this.goG == 2) {
                this.goY = true;
                int y = (int) boN().getY();
                if (this.goH == y) {
                    tc(boN().getHeight());
                } else {
                    this.goH = y;
                    tc(boN().getHeight());
                }
                if (i == 0 && this.goK) {
                    this.goK = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.boH();
                        }
                    }, 100L);
                }
            } else if (this.goG == 0) {
                if (this.goY || !"nani_midpage".equals(this.fYJ.biS())) {
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
        this.goZ = z;
    }

    private void td(int i) {
        if (this.goy != null) {
            if (i == 0) {
                i = this.goL;
            }
            float f = this.goL - i;
            float f2 = f > this.goI ? 0.0f : 1.0f - (f / this.goI);
            if (this.goZ) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.goy.boD().setVisibility(8);
            } else {
                this.goy.boD().setVisibility(0);
            }
            this.goy.aw(f2);
        }
    }

    public void boK() {
        if (this.goy != null) {
            if (boM()) {
                this.fYJ.biU().bmO();
            } else if (this.goy.boD().getVisibility() == 0) {
                this.fYJ.biU().bmO();
                this.goz = true;
            } else if (this.goz) {
                this.fYJ.biU().lv(false);
                this.goz = false;
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
        this.goF = false;
        if (this.dQv != null && this.gou != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gou.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.goV != null) {
                    this.goV.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.goF = true;
                this.gou.setLayoutParams(layoutParams);
                this.fYJ.biU().bmO();
                this.goz = true;
            } else {
                e(this.gow);
                boJ();
                this.goF = false;
                this.got.lJ(true);
            }
            this.dQv.a(this.fYJ.getPageContext(), configuration);
        }
    }

    public boolean boM() {
        return this.goF;
    }

    public void n(long j, int i) {
        if (this.goy != null && j > 0) {
            this.goy.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.goy != null) {
            this.goy.N(onClickListener);
        }
    }

    public View boN() {
        return this.gos;
    }

    public boolean bmX() {
        if (boN() == null) {
            return false;
        }
        return boN().getBottom() > l.aQ(boN().getContext()) - l.h(boN().getContext(), e.C0210e.ds50);
    }

    public void boO() {
        this.goK = true;
    }

    public void boP() {
        if (this.dQv != null) {
            this.dQv.pausePlay();
        }
    }

    public View boQ() {
        return this.mEmptyView;
    }
}
