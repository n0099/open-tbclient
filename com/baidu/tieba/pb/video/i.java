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
    private static VideoControllerView.a ftN = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Wo() {
        }
    };
    private static c.i gnY = new c.i() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.i
        public void aDM() {
        }
    };
    private n bOs;
    private com.baidu.tieba.play.c dPM;
    private PbActivity fXM;
    private float gnF;
    private int gnI;
    private double gnJ;
    private long gnK;
    private PbVideoWifiTipLayout gnL;
    private int gnM;
    private c.d gnN;
    private PbFullScreenFloatingHuajiAninationView gnP;
    private com.baidu.adp.lib.guide.c gnR;
    private Bitmap gnS;
    private boolean gnT;
    private boolean gnV;
    private int gnX;
    private RelativeLayout gnp;
    private com.baidu.tieba.pb.pb.main.view.b gnq;
    private CustomFrameLayout gnr;
    private c.d gns;
    private z gnu;
    private g gnv;
    private boolean gnw;
    private bb gnx;
    private bb gny;
    private String gnz;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String aEO = null;
    private VideoInfo gnt = null;
    private boolean gnA = false;
    private int gnB = 0;
    private boolean gnC = false;
    private int gnD = 0;
    private int gnE = 0;
    private boolean gnG = false;
    private boolean gnH = false;
    private boolean gnO = true;
    private PbFullScreenFloatingHuajiAninationView.a gnQ = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lS(false);
        }
    };
    private boolean gnU = false;
    private c.m gnW = new c.m() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.m
        public boolean boj() {
            if (i.this.fXM.checkUpIsLogin()) {
                i.this.fXM.bjc();
                if (i.this.fXM.bhZ() == null || i.this.fXM.bhZ().getPbData() == null || i.this.fXM.bhZ().getPbData().bht() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bht = i.this.fXM.bhZ().getPbData().bht();
                if (i.this.gnP == null) {
                    i.this.gnP = new PbFullScreenFloatingHuajiAninationView(i.this.fXM.getActivity());
                    i.this.gnP.setFloatingHuajiAninationListener(i.this.gnQ);
                }
                i.this.gnP.lU(bht.bhz() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bok() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.kV()) {
                    i.this.dPM.stopPlay();
                    i.this.dPM.mx(true);
                    return;
                }
                if (i.this.dPM != null) {
                    i.this.dPM.setNetworkChange();
                }
                if (j.kX() && i.this.dPM != null && i.this.dPM.brH() && i.this.gnt != null && i.this.gnt.video_length.intValue() > 0 && i.this.gnt.video_duration.intValue() > 0) {
                    float intValue = i.this.gnt.video_length.intValue() * (1.0f - ((i.this.dPM.getCurrentPosition() * 1.0f) / (i.this.gnt.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fXM.getPageContext().getPageActivity(), String.format(i.this.fXM.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener frO = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bmX();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.fXM != null) {
            this.fXM.bis();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.gnF = 0.0f;
        this.fXM = pbActivity;
        this.gnq = bVar;
        this.gnF = l.h(this.fXM.getActivity(), e.C0210e.ds240);
        this.gnK = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fXM.getActivity());
        Rect y = az.y(this.fXM.getPageContext().getPageActivity());
        int aQ = y.height() <= 0 ? l.aQ(this.fXM.getActivity()) : y.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.gnJ = (intValue2 * 1.0d) / intValue;
            if (this.gnJ > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.gnI = i;
        this.gnr.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.gnp = (RelativeLayout) LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.gnr = (CustomFrameLayout) this.gnp.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dPM = new com.baidu.tieba.play.c((TbPageContext<?>) this.fXM.getPageContext(), (View) this.gnr, true);
        this.dPM.a(this.gnW);
        this.dPM.mA(false);
        this.dPM.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.12
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
                        if (i.this.fXM.getListView() != null && i.this.fXM.getListView().getChildCount() > 0 && i.this.fXM.getListView().getChildAt(0) == i.this.boi()) {
                            i.this.gnX = i.this.boi().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.gnX = 0;
                        break;
                    case 2:
                        if (i.this.fXM.getListView() != null && i.this.fXM.getListView().getChildCount() > 0 && i.this.fXM.getListView().getChildAt(0) == i.this.boi()) {
                            i.this.fXM.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.gnX);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.gnJ >= 1.0d) {
                this.dPM.S(false, true);
            } else {
                this.dPM.S(true, false);
            }
            this.gnG = ((float) e) + this.gnF > ((float) l.aQ(this.fXM.getActivity()));
            if (this.gnG) {
                if (this.gnv == null) {
                    this.gnv = new g(this.fXM.getPageContext(), this.gnr);
                }
                this.fXM.biq().bmg();
                this.gnw = true;
            }
        }
        boa();
        this.mEmptyView = new View(this.fXM);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.gnI));
        if (this.gnq != null && this.gnq.mNavigationBar != null) {
            this.gnq.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.gnq.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.gnq.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.CF() ? 0 : 8);
        }
        this.gnL = (PbVideoWifiTipLayout) this.gnp.findViewById(e.g.layout_wifi_tip);
        this.gnL.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.gnT = true;
                i.this.gnL.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fXM.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.gns == null) {
            this.gns = new c.d() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.c.d
                public void gX(boolean z) {
                    if (i.this.bod() && i.this.gnq != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.gnq.bmR().clearAnimation();
                        i.this.bob();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.frO);
                            i.this.gnq.bmR().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void aDL() {
                    if (i.this.bod()) {
                        i.this.bmX();
                    }
                }
            };
        }
        a(this.gns);
        this.gnB = UtilHelper.getLightStatusBarHeight() + l.h(this.fXM.getActivity(), e.C0210e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dPM != null && bbVar != null) {
            this.gnt = videoInfo;
            this.gnx = bbVar;
            this.aEO = videoInfo.video_url;
            this.dPM.stopPlay();
            this.dPM.setIsNeedRecoveryVideoPlayer(true);
            this.bOs = new n(this.fXM.getActivity());
            this.gnu = new z();
            this.gnu.mLocate = "pb";
            this.gnu.biz = bbVar.getTid();
            this.gnu.daG = str;
            this.gnu.mUid = TbadkCoreApplication.getCurrentAccount();
            this.gnu.mSource = bbVar.mRecomSource;
            this.gnu.gHF = bbVar.mRecomWeight;
            this.gnu.gHG = this.fXM.bio();
            this.gnu.gHH = bbVar.mRecomAbTag;
            this.gnu.gHI = videoInfo.video_md5;
            z bsP = this.gnu.bsP();
            bsP.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bOs.setVideoStatsData(bsP);
            this.dPM.getVideoView().setBusiness(this.bOs);
            if (this.dPM.aZE()) {
                this.dPM.aZC();
            }
            this.dPM.b(this.gnN);
            this.gnz = null;
            this.gny = null;
            this.dPM.tw(this.gnz);
            this.dPM.aZy().setOnDragingListener(ftN);
            this.dPM.a(new c.InterfaceC0297c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YT() {
                    i.this.fXM.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.gnM > 0) {
                                i.this.sX(i.this.gnM);
                                i.this.sY(i.this.gnM);
                                i.this.gnM = 0;
                            }
                            i.this.gnO = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0297c
                public void YS() {
                    i.this.fXM.setSwipeBackEnabled(false);
                    i.this.gnO = false;
                    i.this.gnM = i.this.bof().getHeight();
                }
            });
            this.dPM.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void bol() {
                    if (i.this.fXM != null && i.this.gny != null && !StringUtils.isNull(i.this.gny.getId())) {
                        i.this.fXM.sS(i.this.gny.getId());
                        if (i.this.gnx != null) {
                            long j = 0;
                            if (i.this.gnx.AJ() != null) {
                                j = i.this.gnx.AJ().channelId;
                            }
                            TiebaStatic.log(new am("c11921").i(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dPM.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.j
                public void lT(boolean z) {
                    if (i.this.gnx != null) {
                        long j = 0;
                        if (i.this.gnx.AJ() != null) {
                            j = i.this.gnx.AJ().channelId;
                        }
                        i.this.oi(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").aA("tid", i.this.gnx.getTid()).i(ImageViewerConfig.FORUM_ID, i.this.gnx.getFid()).i(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dPM.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.aEO);
                    return true;
                }
            });
            this.dPM.setThumbnail(videoInfo.thumbnail_url);
            this.dPM.setVideoUrl(this.aEO, bbVar.getTid());
            this.dPM.setFid(str);
            this.dPM.tU(bbVar.getTitle());
            this.dPM.a(gnY);
            this.dPM.aMK();
            this.dPM.show();
        }
    }

    public void tv(String str) {
        if (this.gnu != null) {
            this.gnu.daG = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.gnv != null) {
            this.gnv.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.gnN = dVar;
    }

    public void as(bb bbVar) {
        this.gny = bbVar;
    }

    public void tw(String str) {
        this.gnz = str;
        if (this.dPM != null) {
            this.dPM.tw(this.gnz);
        }
    }

    public void startPlay() {
        if (this.dPM != null) {
            if (j.kX() && !this.gnT && !com.baidu.tieba.video.g.bIG().bIH()) {
                this.gnL.setVisibility(0);
                this.gnL.setData(this.gnt);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.aEO) && this.gnx != null && this.gnx.zY() != null) {
                TiebaStatic.log(new am("c12619").aA("obj_locate", "pb").aA("tid", this.gnx.getTid()));
                this.aEO = this.gnx.zY().video_url;
            }
            this.dPM.c(this.aEO, this.gnx == null ? "" : this.gnx.getTid(), this.gnK);
            oi("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bnZ() {
        if (this.dPM != null) {
            this.dPM.bnZ();
        }
    }

    public void destroy() {
        if (this.dPM != null) {
            this.dPM.destroy();
        }
        if (this.gnr != null) {
            this.gnr.clearAnimation();
        }
        if (this.gnv != null) {
            this.gnv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dPM != null) {
            if (this.dPM.brH()) {
                this.gnA = true;
                this.dPM.stopPlay();
            } else if (this.dPM.getCurrentState() == 3) {
                this.gnA = false;
            } else if (this.dPM.getCurrentState() == 0 || this.dPM.getCurrentState() == 1) {
                this.gnA = true;
                this.dPM.stopPlay();
            } else {
                this.gnA = false;
                this.dPM.stopPlay();
            }
            if (this.gnP != null) {
                this.gnP.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dPM != null && this.gnA) {
            this.dPM.brE();
        }
    }

    private void boa() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ax(16908290).aw(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fXM.getActivity());
                    if (i.this.gnS == null) {
                        try {
                            i.this.gnS = BitmapFactory.decodeResource(i.this.fXM.getResources(), e.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.gnS);
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.gnR = null;
                    if (i.this.gnS != null && !i.this.gnS.isRecycled()) {
                        i.this.gnS.recycle();
                    }
                    i.this.gnS = null;
                }
            });
            this.gnR = dVar.iT();
            this.gnR.o(this.fXM.getActivity());
        }
    }

    public boolean mH(int i) {
        if (this.dPM == null) {
            return false;
        }
        return this.dPM.ty(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(String str) {
        if (this.gnt != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.gnt.video_md5, "", str, this.gnu);
            }
        }
    }

    public void bob() {
        if (this.gnq != null) {
            this.gnq.lK(this.fXM.bhP());
        }
    }

    public void bmX() {
        if (this.gnq != null) {
            this.gnq.bmX();
        }
    }

    public void sS(int i) {
        if (this.gnq != null) {
            this.gnq.sS(i);
        }
        if (this.gnP != null) {
            this.gnP.onChangeSkinType(i);
        }
        if (this.gnv != null) {
            this.gnv.eD(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!boe()) {
                    this.gnD = i;
                    if (this.gnD == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.sY(i.this.bof().getHeight());
                            }
                        }, 100L);
                    }
                    boc();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sX(int i) {
        if (bof().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnr.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.gnV = false;
                    if (this.gnI != bof().getHeight()) {
                        this.gnr.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fXM.getActivity()), Math.min(this.gnI, bof().getHeight() + i)));
                        this.dPM.aZC();
                    }
                } else if (l.aO(this.fXM.getActivity()) * 0.5625d != bof().getHeight()) {
                    this.gnr.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fXM.getActivity()), (int) Math.max(l.aO(this.fXM.getActivity()) * 0.5625d, bof().getHeight() + i)));
                    this.dPM.aZC();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == boi()) {
                int bottom = childAt.getBottom() - bof().getBottom();
                if (childAt.getHeight() == 0 || bof().getHeight() == 0) {
                    bottom = 0;
                }
                sX(bottom);
            } else {
                sX((-this.gnI) + 2);
            }
        }
        if (!boe() && this.gnO) {
            if (this.gnD == 1) {
                this.gnU = true;
                sY(bof().getHeight());
            } else if (this.gnD == 2) {
                this.gnU = true;
                int y = (int) bof().getY();
                if (this.gnE == y) {
                    sY(bof().getHeight());
                } else {
                    this.gnE = y;
                    sY(bof().getHeight());
                }
                if (i == 0 && this.gnH) {
                    this.gnH = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bnZ();
                        }
                    }, 100L);
                }
            } else if (this.gnD == 0) {
                if (this.gnU || !"nani_midpage".equals(this.fXM.bio())) {
                    sY(bof().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sY(int i) {
        sZ(i);
        boc();
    }

    public void lw(boolean z) {
        this.gnV = z;
    }

    private void sZ(int i) {
        if (this.gnv != null) {
            if (i == 0) {
                i = this.gnI;
            }
            float f = this.gnI - i;
            float f2 = f > this.gnF ? 0.0f : 1.0f - (f / this.gnF);
            if (this.gnV) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.gnv.bnV().setVisibility(8);
            } else {
                this.gnv.bnV().setVisibility(0);
            }
            this.gnv.aw(f2);
        }
    }

    public void boc() {
        if (this.gnv != null) {
            if (boe()) {
                this.fXM.biq().bmg();
            } else if (this.gnv.bnV().getVisibility() == 0) {
                this.fXM.biq().bmg();
                this.gnw = true;
            } else if (this.gnw) {
                this.fXM.biq().lv(false);
                this.gnw = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bod() {
        return bof().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.gnC = false;
        if (this.dPM != null && this.gnr != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnr.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.gnR != null) {
                    this.gnR.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.gnC = true;
                this.gnr.setLayoutParams(layoutParams);
                this.fXM.biq().bmg();
                this.gnw = true;
            } else {
                e(this.gnt);
                bob();
                this.gnC = false;
                this.gnq.lJ(true);
            }
            this.dPM.a(this.fXM.getPageContext(), configuration);
        }
    }

    public boolean boe() {
        return this.gnC;
    }

    public void n(long j, int i) {
        if (this.gnv != null && j > 0) {
            this.gnv.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.gnv != null) {
            this.gnv.N(onClickListener);
        }
    }

    public View bof() {
        return this.gnp;
    }

    public boolean bmp() {
        if (bof() == null) {
            return false;
        }
        return bof().getBottom() > l.aQ(bof().getContext()) - l.h(bof().getContext(), e.C0210e.ds50);
    }

    public void bog() {
        this.gnH = true;
    }

    public void boh() {
        if (this.dPM != null) {
            this.dPM.pausePlay();
        }
    }

    public View boi() {
        return this.mEmptyView;
    }
}
