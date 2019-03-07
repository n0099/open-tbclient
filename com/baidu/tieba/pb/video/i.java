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
import android.widget.SeekBar;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class i {
    private static VideoControllerView.a gKJ = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void awL() {
        }
    };
    private static c.i hFn = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void beS() {
        }
    };
    private float Ql;
    private boolean XA;
    private n dbi;
    private com.baidu.tieba.play.c fes;
    private com.baidu.mcn.c fxf;
    private RelativeLayout hED;
    private com.baidu.tieba.pb.pb.main.view.b hEE;
    private CustomFrameLayout hEF;
    private c.d hEG;
    private z hEI;
    private g hEJ;
    private boolean hEK;
    private bg hEL;
    private bg hEM;
    private String hEN;
    private float hET;
    private int hEW;
    private double hEX;
    private long hEY;
    private PbVideoWifiTipLayout hEZ;
    private int hFa;
    private c.d hFc;
    private PbFullScreenFloatingHuajiAninationView hFe;
    private com.baidu.adp.lib.guide.c hFg;
    private Bitmap hFh;
    private boolean hFi;
    private boolean hFk;
    private int hFm;
    private PbActivity hpc;
    private View mEmptyView;
    private Handler mHandler;
    private String bNk = null;
    private VideoInfo hEH = null;
    private boolean hEO = false;
    private int hEP = 0;
    private boolean hEQ = false;
    private int hER = 0;
    private int hES = 0;
    private boolean hEU = false;
    private boolean hEV = false;
    private long startPosition = -1;
    private c.p hFb = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bPm() {
            if (i.this.hpc != null && i.this.hpc.bJa() != null && i.this.hpc.bJa().getPbData() != null) {
                PostData bIg = i.this.hpc.bJa().getPbData().bIg();
                if (bIg == null && v.S(i.this.hpc.bJa().getPbData().bIb()) > 1) {
                    bIg = (PostData) v.c(i.this.hpc.bJa().getPbData().bIb(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hpc.bJa().getPbData(), bIg, 1, 1, 4);
            }
        }
    };
    private boolean hFd = true;
    private PbFullScreenFloatingHuajiAninationView.a hFf = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.op(false);
        }
    };
    private boolean hFj = false;
    private c.m hFl = new c.m() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // com.baidu.tieba.play.c.m
        public boolean bPo() {
            if (i.this.hEX < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hpc.checkUpIsLogin()) {
                i.this.hpc.bKc();
                if (i.this.hpc.bJa() == null || i.this.hpc.bJa().getPbData() == null || i.this.hpc.bJa().getPbData().bIw() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bIw = i.this.hpc.bJa().getPbData().bIw();
                if (i.this.hFe == null) {
                    i.this.hFe = new PbFullScreenFloatingHuajiAninationView(i.this.hpc.getActivity());
                    i.this.hFe.setFloatingHuajiAninationListener(i.this.hFf);
                }
                i.this.hFe.or(bIw.bIA() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bPp() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY()) {
                if (i.this.fes != null) {
                    i.this.fes.setNetworkChange();
                }
                if (j.la() && i.this.fes != null && i.this.fes.ql() && i.this.hEH != null && i.this.hEH.video_length.intValue() > 0 && i.this.hEH.video_duration.intValue() > 0) {
                    float intValue = i.this.hEH.video_length.intValue() * (1.0f - ((i.this.fes.getCurrentPosition() * 1.0f) / (i.this.hEH.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hpc.getPageContext().getPageActivity(), String.format(i.this.hpc.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gIK = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.20
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bNY();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (this.hpc != null) {
            this.hpc.bJs();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.hET = 0.0f;
        this.hpc = pbActivity;
        this.hEE = bVar;
        this.hET = l.h(this.hpc.getActivity(), d.e.ds240);
        this.hEY = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fxf = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.hpc.getActivity());
        Rect W = bb.W(this.hpc.getPageContext().getPageActivity());
        int aQ = W.height() <= 0 ? l.aQ(this.hpc.getActivity()) : W.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hEX = (intValue2 * 1.0d) / intValue;
            if (this.hEX > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.hEW = i;
        this.hEF.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.hED = (RelativeLayout) LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.hEF = (CustomFrameLayout) this.hED.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        this.XA = ((double) this.hEW) <= (((double) l.aO(this.hpc.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fes = new com.baidu.tieba.play.c((TbPageContext<?>) this.hpc.getPageContext(), (View) this.hEF, true);
        this.fes.a(this.hFl);
        this.fes.oY(false);
        this.fes.a(this.hFb);
        this.fes.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.16
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (UtilHelper.isOnePlus6()) {
            this.fes.oP(false);
        }
        this.fes.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.17
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
                        i.this.Ql = motionEvent.getY();
                        if (i.this.hpc.getListView() != null && i.this.hpc.getListView().getChildCount() > 0 && i.this.hpc.getListView().getChildAt(0) == i.this.bPl()) {
                            i.this.hFm = i.this.bPl().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Ql = 0.0f;
                        i.this.hFm = 0;
                        break;
                    case 2:
                        if (i.this.hpc.getListView() != null && i.this.hpc.getListView().getChildCount() > 0 && i.this.hpc.getListView().getChildAt(0) == i.this.bPl()) {
                            i.this.hpc.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Ql)) + i.this.hFm);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hEX >= 1.0d) {
                this.fes.ae(false, true);
            } else {
                this.fes.ae(true, false);
            }
            this.hEU = ((float) e) + this.hET > ((float) l.aQ(this.hpc.getActivity()));
            if (this.hEU) {
                if (this.hEJ == null) {
                    this.hEJ = new g(this.hpc.getPageContext(), this.hEF);
                }
                this.hpc.bJq().bNi();
                this.hEK = true;
            }
        }
        bPe();
        this.mEmptyView = new View(this.hpc);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hEW));
        if (this.hEE != null && this.hEE.mNavigationBar != null) {
            this.hEE.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hEE.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.hEE.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.acc() ? 0 : 8);
        }
        this.hEZ = (PbVideoWifiTipLayout) this.hED.findViewById(d.g.layout_wifi_tip);
        this.hEZ.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hFi = true;
                i.this.hEZ.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fxf != null) {
            this.fxf.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hpc.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hEG == null) {
            this.hEG = new c.d() { // from class: com.baidu.tieba.pb.video.i.19
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (i.this.bPh() && i.this.hEE != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hEE.bNS().clearAnimation();
                        i.this.bPf();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gIK);
                            i.this.hEE.bNS().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void beR() {
                    if (i.this.bPh()) {
                        i.this.bNY();
                    }
                }
            };
        }
        a(this.hEG);
        this.hEP = UtilHelper.getLightStatusBarHeight() + l.h(this.hpc.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fes != null && bgVar != null) {
            this.hEH = videoInfo;
            this.hEL = bgVar;
            this.bNk = videoInfo.video_url;
            this.fes.stopPlay();
            this.fes.setIsNeedRecoveryVideoPlayer(true);
            this.dbi = new n(this.hpc.getActivity());
            this.hEI = new z();
            this.hEI.mLocate = "pb";
            this.hEI.ctx = bgVar.getTid();
            this.hEI.ele = str;
            this.hEI.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hEI.mSource = bgVar.mRecomSource;
            this.hEI.hYR = bgVar.mRecomWeight;
            this.hEI.hYS = this.hpc.bJo();
            this.hEI.hYT = bgVar.mRecomAbTag;
            this.hEI.hYU = videoInfo.video_md5;
            z bTT = this.hEI.bTT();
            bTT.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dbi.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cR = com.baidu.mcn.b.sY().cR(mcnAdInfo.jump_url);
                        if (i.this.XA && !cR && !i.this.hEQ) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fxf.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeJ = mcnAdInfo.card_title;
                                    aVar.aeK = mcnAdInfo.button_title;
                                    aVar.aeL = mcnAdInfo.jump_url;
                                    aVar.aeI = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeM = 4;
                                    if (z2) {
                                        i.this.fxf.b(aVar, (ViewGroup) i.this.fes.bSW());
                                    } else {
                                        i.this.fxf.a(aVar, (ViewGroup) i.this.fes.bSW());
                                    }
                                }
                            } else if (i.this.fxf.isShowing()) {
                                i.this.fxf.dismiss();
                            }
                        }
                    }
                }
            });
            this.dbi.setVideoStatsData(bTT);
            this.fes.getVideoView().setBusiness(this.dbi);
            if (this.fes.bAI()) {
                this.fes.bAG();
            }
            this.fes.b(this.hFc);
            this.hEN = null;
            this.hEM = null;
            this.fes.As(this.hEN);
            this.fes.bAC().setOnDragingListener(gKJ);
            this.fes.a(new c.InterfaceC0294c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0294c
                public void qk() {
                    i.this.hpc.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hFa > 0) {
                                i.this.wL(i.this.hFa);
                                i.this.wM(i.this.hFa);
                                i.this.hFa = 0;
                            }
                            i.this.hFd = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0294c
                public void qj() {
                    i.this.hpc.setSwipeBackEnabled(false);
                    i.this.hFd = false;
                    i.this.hFa = i.this.aBC().getHeight();
                }
            });
            this.fes.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bPn() {
                    if (i.this.hpc != null && i.this.hEM != null && !StringUtils.isNull(i.this.hEM.getId())) {
                        i.this.hpc.zL(i.this.hEM.getId());
                        if (i.this.hEL != null) {
                            long j = 0;
                            if (i.this.hEL.aab() != null) {
                                j = i.this.hEL.aab().channelId;
                            }
                            TiebaStatic.log(new am("c11921").k(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fes.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void oq(boolean z) {
                    if (i.this.hEL != null) {
                        long j = 0;
                        if (i.this.hEL.aab() != null) {
                            j = i.this.hEL.aab().channelId;
                        }
                        i.this.vd(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bJ("tid", i.this.hEL.getTid()).k(ImageViewerConfig.FORUM_ID, i.this.hEL.getFid()).k(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fes.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bNk);
                    return true;
                }
            });
            this.fes.setThumbnail(videoInfo.thumbnail_url);
            this.fes.setVideoUrl(this.bNk, bgVar.getTid());
            this.fes.setFid(str);
            this.fes.AP(bgVar.getTitle());
            this.fes.a(hFn);
            this.fes.bnQ();
            this.fes.show();
        }
    }

    public void Ar(String str) {
        if (this.hEI != null) {
            this.hEI.ele = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.hEJ != null) {
            this.hEJ.a(postData, bgVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.hFc = dVar;
    }

    public void aE(bg bgVar) {
        this.hEM = bgVar;
    }

    public void As(String str) {
        this.hEN = str;
        if (this.fes != null) {
            this.fes.As(this.hEN);
        }
    }

    public void startPlay() {
        if (this.fes != null) {
            if (com.baidu.adp.lib.util.j.la() && !this.hFi && !com.baidu.tieba.video.g.ciC().ciD()) {
                this.hEZ.setVisibility(0);
                this.hEZ.setData(this.hEH);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bNk) && this.hEL != null && this.hEL.Zi() != null) {
                TiebaStatic.log(new am("c12619").bJ("obj_locate", "pb").bJ("tid", this.hEL.getTid()));
                this.bNk = this.hEL.Zi().video_url;
            }
            this.fes.h(this.bNk, this.hEL == null ? "" : this.hEL.getTid(), this.hEY);
            vd("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bPd() {
        if (this.fes != null) {
            this.fes.bPd();
        }
    }

    public void destroy() {
        if (this.fes != null) {
            this.fes.destroy();
        }
        if (this.hEF != null) {
            this.hEF.clearAnimation();
        }
        if (this.hEJ != null) {
            this.hEJ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.fes != null) {
            if (this.fes.ql()) {
                this.hEO = true;
                this.fes.stopPlay();
            } else if (this.fes.getCurrentState() == 3) {
                this.hEO = false;
            } else if (this.fes.getCurrentState() == 0 || this.fes.getCurrentState() == 1) {
                this.hEO = true;
                this.fes.stopPlay();
            } else {
                this.hEO = false;
                this.fes.stopPlay();
            }
            if (this.hFe != null) {
                this.hFe.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fes != null && this.hEO) {
            this.fes.bSI();
        }
    }

    private void bPe() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ag(16908290).af(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hpc.getActivity());
                    if (i.this.hFh == null) {
                        try {
                            i.this.hFh = BitmapFactory.decodeResource(i.this.hpc.getResources(), d.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hFh);
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.8
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.hFg = null;
                    if (i.this.hFh != null && !i.this.hFh.isRecycled()) {
                        i.this.hFh.recycle();
                    }
                    i.this.hFh = null;
                }
            });
            this.hFg = dVar.iT();
            this.hFg.o(this.hpc.getActivity());
        }
    }

    public boolean qw(int i) {
        if (this.fes == null) {
            return false;
        }
        return this.fes.xl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vd(String str) {
        if (this.hEH != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hEH.video_md5, "", str, this.hEI);
            }
        }
    }

    public void bPf() {
        if (this.hEE != null) {
            this.hEE.oh(this.hpc.bIQ());
        }
    }

    public void bNY() {
        if (this.hEE != null) {
            this.hEE.bNY();
        }
    }

    public void wG(int i) {
        if (this.hEE != null) {
            this.hEE.wG(i);
        }
        if (this.hFe != null) {
            this.hFe.onChangeSkinType(i);
        }
        if (this.hEJ != null) {
            this.hEJ.ij(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bPi()) {
                    this.hER = i;
                    if (this.hER == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.wM(i.this.aBC().getHeight());
                            }
                        }, 100L);
                    }
                    bPg();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        if (aBC().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEF.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hFk = false;
                    if (this.hEW != aBC().getHeight()) {
                        this.hEF.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hpc.getActivity()), Math.min(this.hEW, aBC().getHeight() + i)));
                        this.fes.bAG();
                    }
                } else if (l.aO(this.hpc.getActivity()) * 0.5625d != aBC().getHeight()) {
                    this.hEF.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hpc.getActivity()), (int) Math.max(l.aO(this.hpc.getActivity()) * 0.5625d, aBC().getHeight() + i)));
                    this.fes.bAG();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bPl()) {
                int bottom = childAt.getBottom() - aBC().getBottom();
                if (childAt.getHeight() == 0 || aBC().getHeight() == 0) {
                    bottom = 0;
                }
                wL(bottom);
            } else {
                wL((-this.hEW) + 2);
            }
        }
        if (!bPi() && this.hFd) {
            if (this.hER == 1) {
                this.hFj = true;
                wM(aBC().getHeight());
            } else if (this.hER == 2) {
                this.hFj = true;
                int y = (int) aBC().getY();
                if (this.hES == y) {
                    wM(aBC().getHeight());
                } else {
                    this.hES = y;
                    wM(aBC().getHeight());
                }
                if (i == 0 && this.hEV) {
                    this.hEV = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bPd();
                        }
                    }, 100L);
                }
            } else if (this.hER == 0) {
                if (this.hFj || !"nani_midpage".equals(this.hpc.bJo())) {
                    wM(aBC().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(int i) {
        wN(i);
        bPg();
    }

    public void nV(boolean z) {
        this.hFk = z;
    }

    private void wN(int i) {
        if (this.hEJ != null) {
            if (i == 0) {
                i = this.hEW;
            }
            float f = this.hEW - i;
            float f2 = f > this.hET ? 0.0f : 1.0f - (f / this.hET);
            if (this.hFk) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hEJ.bOZ().setVisibility(8);
            } else {
                this.hEJ.bOZ().setVisibility(0);
            }
            this.hEJ.aJ(f2);
        }
    }

    public void bPg() {
        if (this.hEJ != null) {
            if (bPi()) {
                this.hpc.bJq().bNi();
            } else if (this.hEJ.bOZ().getVisibility() == 0) {
                this.hpc.bJq().bNi();
                this.hEK = true;
            } else if (this.hEK) {
                this.hpc.bJq().nU(false);
                this.hEK = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPh() {
        return aBC().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hEQ = false;
        if (this.fes != null && this.hEF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEF.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fxf != null && this.fxf.isShowing()) {
                    this.fxf.sZ();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hFg != null) {
                    this.hFg.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hEQ = true;
                this.hEF.setLayoutParams(layoutParams);
                this.hpc.bJq().bNi();
                this.hEK = true;
            } else {
                e(this.hEH);
                bPf();
                this.hEQ = false;
                this.hEE.og(true);
            }
            this.fes.a(this.hpc.getPageContext(), configuration);
        }
    }

    public boolean bPi() {
        return this.hEQ;
    }

    public void s(long j, int i) {
        if (this.hEJ != null && j > 0) {
            this.hEJ.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.hEJ != null) {
            this.hEJ.N(onClickListener);
        }
    }

    public View aBC() {
        return this.hED;
    }

    public boolean bNr() {
        if (aBC() == null) {
            return false;
        }
        return aBC().getBottom() > l.aQ(aBC().getContext()) - l.h(aBC().getContext(), d.e.ds50);
    }

    public void bPj() {
        this.hEV = true;
    }

    public void bPk() {
        if (this.fes != null) {
            this.fes.pausePlay();
        }
    }

    public View bPl() {
        return this.mEmptyView;
    }
}
