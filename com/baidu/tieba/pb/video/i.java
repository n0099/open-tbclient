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
    private static VideoControllerView.a gKK = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void awM() {
        }
    };
    private static c.i hFo = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void beT() {
        }
    };
    private float Ql;
    private boolean XA;
    private n dbi;
    private com.baidu.tieba.play.c fes;
    private com.baidu.mcn.c fxf;
    private RelativeLayout hEE;
    private com.baidu.tieba.pb.pb.main.view.b hEF;
    private CustomFrameLayout hEG;
    private c.d hEH;
    private z hEJ;
    private g hEK;
    private boolean hEL;
    private bg hEM;
    private bg hEN;
    private String hEO;
    private float hEU;
    private int hEX;
    private double hEY;
    private long hEZ;
    private PbVideoWifiTipLayout hFa;
    private int hFb;
    private c.d hFd;
    private PbFullScreenFloatingHuajiAninationView hFf;
    private com.baidu.adp.lib.guide.c hFh;
    private Bitmap hFi;
    private boolean hFj;
    private boolean hFl;
    private int hFn;
    private PbActivity hpd;
    private View mEmptyView;
    private Handler mHandler;
    private String bNk = null;
    private VideoInfo hEI = null;
    private boolean hEP = false;
    private int hEQ = 0;
    private boolean hER = false;
    private int hES = 0;
    private int hET = 0;
    private boolean hEV = false;
    private boolean hEW = false;
    private long startPosition = -1;
    private c.p hFc = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bPn() {
            if (i.this.hpd != null && i.this.hpd.bJb() != null && i.this.hpd.bJb().getPbData() != null) {
                PostData bIh = i.this.hpd.bJb().getPbData().bIh();
                if (bIh == null && v.S(i.this.hpd.bJb().getPbData().bIc()) > 1) {
                    bIh = (PostData) v.c(i.this.hpd.bJb().getPbData().bIc(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hpd.bJb().getPbData(), bIh, 1, 1, 4);
            }
        }
    };
    private boolean hFe = true;
    private PbFullScreenFloatingHuajiAninationView.a hFg = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.op(false);
        }
    };
    private boolean hFk = false;
    private c.m hFm = new c.m() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // com.baidu.tieba.play.c.m
        public boolean bPp() {
            if (i.this.hEY < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hpd.checkUpIsLogin()) {
                i.this.hpd.bKd();
                if (i.this.hpd.bJb() == null || i.this.hpd.bJb().getPbData() == null || i.this.hpd.bJb().getPbData().bIx() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bIx = i.this.hpd.bJb().getPbData().bIx();
                if (i.this.hFf == null) {
                    i.this.hFf = new PbFullScreenFloatingHuajiAninationView(i.this.hpd.getActivity());
                    i.this.hFf.setFloatingHuajiAninationListener(i.this.hFg);
                }
                i.this.hFf.or(bIx.bIB() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bPq() {
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
                if (j.la() && i.this.fes != null && i.this.fes.ql() && i.this.hEI != null && i.this.hEI.video_length.intValue() > 0 && i.this.hEI.video_duration.intValue() > 0) {
                    float intValue = i.this.hEI.video_length.intValue() * (1.0f - ((i.this.fes.getCurrentPosition() * 1.0f) / (i.this.hEI.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hpd.getPageContext().getPageActivity(), String.format(i.this.hpd.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gIL = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.20
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bNZ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (this.hpd != null) {
            this.hpd.bJt();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.hEU = 0.0f;
        this.hpd = pbActivity;
        this.hEF = bVar;
        this.hEU = l.h(this.hpd.getActivity(), d.e.ds240);
        this.hEZ = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fxf = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.hpd.getActivity());
        Rect W = bb.W(this.hpd.getPageContext().getPageActivity());
        int aQ = W.height() <= 0 ? l.aQ(this.hpd.getActivity()) : W.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hEY = (intValue2 * 1.0d) / intValue;
            if (this.hEY > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.hEX = i;
        this.hEG.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.hEE = (RelativeLayout) LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.hEG = (CustomFrameLayout) this.hEE.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        this.XA = ((double) this.hEX) <= (((double) l.aO(this.hpd.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fes = new com.baidu.tieba.play.c((TbPageContext<?>) this.hpd.getPageContext(), (View) this.hEG, true);
        this.fes.a(this.hFm);
        this.fes.oY(false);
        this.fes.a(this.hFc);
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
                        if (i.this.hpd.getListView() != null && i.this.hpd.getListView().getChildCount() > 0 && i.this.hpd.getListView().getChildAt(0) == i.this.bPm()) {
                            i.this.hFn = i.this.bPm().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Ql = 0.0f;
                        i.this.hFn = 0;
                        break;
                    case 2:
                        if (i.this.hpd.getListView() != null && i.this.hpd.getListView().getChildCount() > 0 && i.this.hpd.getListView().getChildAt(0) == i.this.bPm()) {
                            i.this.hpd.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Ql)) + i.this.hFn);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hEY >= 1.0d) {
                this.fes.ae(false, true);
            } else {
                this.fes.ae(true, false);
            }
            this.hEV = ((float) e) + this.hEU > ((float) l.aQ(this.hpd.getActivity()));
            if (this.hEV) {
                if (this.hEK == null) {
                    this.hEK = new g(this.hpd.getPageContext(), this.hEG);
                }
                this.hpd.bJr().bNj();
                this.hEL = true;
            }
        }
        bPf();
        this.mEmptyView = new View(this.hpd);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hEX));
        if (this.hEF != null && this.hEF.mNavigationBar != null) {
            this.hEF.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hEF.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.hEF.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.acc() ? 0 : 8);
        }
        this.hFa = (PbVideoWifiTipLayout) this.hEE.findViewById(d.g.layout_wifi_tip);
        this.hFa.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hFj = true;
                i.this.hFa.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fxf != null) {
            this.fxf.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hpd.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hEH == null) {
            this.hEH = new c.d() { // from class: com.baidu.tieba.pb.video.i.19
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (i.this.bPi() && i.this.hEF != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hEF.bNT().clearAnimation();
                        i.this.bPg();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gIL);
                            i.this.hEF.bNT().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void beS() {
                    if (i.this.bPi()) {
                        i.this.bNZ();
                    }
                }
            };
        }
        a(this.hEH);
        this.hEQ = UtilHelper.getLightStatusBarHeight() + l.h(this.hpd.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fes != null && bgVar != null) {
            this.hEI = videoInfo;
            this.hEM = bgVar;
            this.bNk = videoInfo.video_url;
            this.fes.stopPlay();
            this.fes.setIsNeedRecoveryVideoPlayer(true);
            this.dbi = new n(this.hpd.getActivity());
            this.hEJ = new z();
            this.hEJ.mLocate = "pb";
            this.hEJ.ctx = bgVar.getTid();
            this.hEJ.ele = str;
            this.hEJ.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hEJ.mSource = bgVar.mRecomSource;
            this.hEJ.hYS = bgVar.mRecomWeight;
            this.hEJ.hYT = this.hpd.bJp();
            this.hEJ.hYU = bgVar.mRecomAbTag;
            this.hEJ.hYV = videoInfo.video_md5;
            z bTU = this.hEJ.bTU();
            bTU.mLocate = Constants.VIA_SHARE_TYPE_INFO;
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
                        if (i.this.XA && !cR && !i.this.hER) {
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
                                        i.this.fxf.b(aVar, (ViewGroup) i.this.fes.bSX());
                                    } else {
                                        i.this.fxf.a(aVar, (ViewGroup) i.this.fes.bSX());
                                    }
                                }
                            } else if (i.this.fxf.isShowing()) {
                                i.this.fxf.dismiss();
                            }
                        }
                    }
                }
            });
            this.dbi.setVideoStatsData(bTU);
            this.fes.getVideoView().setBusiness(this.dbi);
            if (this.fes.bAJ()) {
                this.fes.bAH();
            }
            this.fes.b(this.hFd);
            this.hEO = null;
            this.hEN = null;
            this.fes.At(this.hEO);
            this.fes.bAD().setOnDragingListener(gKK);
            this.fes.a(new c.InterfaceC0294c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0294c
                public void qk() {
                    i.this.hpd.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hFb > 0) {
                                i.this.wL(i.this.hFb);
                                i.this.wM(i.this.hFb);
                                i.this.hFb = 0;
                            }
                            i.this.hFe = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0294c
                public void qj() {
                    i.this.hpd.setSwipeBackEnabled(false);
                    i.this.hFe = false;
                    i.this.hFb = i.this.aBD().getHeight();
                }
            });
            this.fes.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bPo() {
                    if (i.this.hpd != null && i.this.hEN != null && !StringUtils.isNull(i.this.hEN.getId())) {
                        i.this.hpd.zM(i.this.hEN.getId());
                        if (i.this.hEM != null) {
                            long j = 0;
                            if (i.this.hEM.aab() != null) {
                                j = i.this.hEM.aab().channelId;
                            }
                            TiebaStatic.log(new am("c11921").k(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fes.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void oq(boolean z) {
                    if (i.this.hEM != null) {
                        long j = 0;
                        if (i.this.hEM.aab() != null) {
                            j = i.this.hEM.aab().channelId;
                        }
                        i.this.ve(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bJ("tid", i.this.hEM.getTid()).k(ImageViewerConfig.FORUM_ID, i.this.hEM.getFid()).k(VideoPlayActivityConfig.OBJ_ID, j));
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
            this.fes.AQ(bgVar.getTitle());
            this.fes.a(hFo);
            this.fes.bnR();
            this.fes.show();
        }
    }

    public void As(String str) {
        if (this.hEJ != null) {
            this.hEJ.ele = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.hEK != null) {
            this.hEK.a(postData, bgVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.hFd = dVar;
    }

    public void aE(bg bgVar) {
        this.hEN = bgVar;
    }

    public void At(String str) {
        this.hEO = str;
        if (this.fes != null) {
            this.fes.At(this.hEO);
        }
    }

    public void startPlay() {
        if (this.fes != null) {
            if (com.baidu.adp.lib.util.j.la() && !this.hFj && !com.baidu.tieba.video.g.ciM().ciN()) {
                this.hFa.setVisibility(0);
                this.hFa.setData(this.hEI);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bNk) && this.hEM != null && this.hEM.Zi() != null) {
                TiebaStatic.log(new am("c12619").bJ("obj_locate", "pb").bJ("tid", this.hEM.getTid()));
                this.bNk = this.hEM.Zi().video_url;
            }
            this.fes.h(this.bNk, this.hEM == null ? "" : this.hEM.getTid(), this.hEZ);
            ve("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bPe() {
        if (this.fes != null) {
            this.fes.bPe();
        }
    }

    public void destroy() {
        if (this.fes != null) {
            this.fes.destroy();
        }
        if (this.hEG != null) {
            this.hEG.clearAnimation();
        }
        if (this.hEK != null) {
            this.hEK.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.fes != null) {
            if (this.fes.ql()) {
                this.hEP = true;
                this.fes.stopPlay();
            } else if (this.fes.getCurrentState() == 3) {
                this.hEP = false;
            } else if (this.fes.getCurrentState() == 0 || this.fes.getCurrentState() == 1) {
                this.hEP = true;
                this.fes.stopPlay();
            } else {
                this.hEP = false;
                this.fes.stopPlay();
            }
            if (this.hFf != null) {
                this.hFf.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fes != null && this.hEP) {
            this.fes.bSJ();
        }
    }

    private void bPf() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ag(16908290).af(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hpd.getActivity());
                    if (i.this.hFi == null) {
                        try {
                            i.this.hFi = BitmapFactory.decodeResource(i.this.hpd.getResources(), d.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hFi);
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
                    i.this.hFh = null;
                    if (i.this.hFi != null && !i.this.hFi.isRecycled()) {
                        i.this.hFi.recycle();
                    }
                    i.this.hFi = null;
                }
            });
            this.hFh = dVar.iT();
            this.hFh.o(this.hpd.getActivity());
        }
    }

    public boolean qw(int i) {
        if (this.fes == null) {
            return false;
        }
        return this.fes.xl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(String str) {
        if (this.hEI != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hEI.video_md5, "", str, this.hEJ);
            }
        }
    }

    public void bPg() {
        if (this.hEF != null) {
            this.hEF.oh(this.hpd.bIR());
        }
    }

    public void bNZ() {
        if (this.hEF != null) {
            this.hEF.bNZ();
        }
    }

    public void wG(int i) {
        if (this.hEF != null) {
            this.hEF.wG(i);
        }
        if (this.hFf != null) {
            this.hFf.onChangeSkinType(i);
        }
        if (this.hEK != null) {
            this.hEK.ij(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bPj()) {
                    this.hES = i;
                    if (this.hES == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.wM(i.this.aBD().getHeight());
                            }
                        }, 100L);
                    }
                    bPh();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        if (aBD().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEG.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hFl = false;
                    if (this.hEX != aBD().getHeight()) {
                        this.hEG.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hpd.getActivity()), Math.min(this.hEX, aBD().getHeight() + i)));
                        this.fes.bAH();
                    }
                } else if (l.aO(this.hpd.getActivity()) * 0.5625d != aBD().getHeight()) {
                    this.hEG.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hpd.getActivity()), (int) Math.max(l.aO(this.hpd.getActivity()) * 0.5625d, aBD().getHeight() + i)));
                    this.fes.bAH();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bPm()) {
                int bottom = childAt.getBottom() - aBD().getBottom();
                if (childAt.getHeight() == 0 || aBD().getHeight() == 0) {
                    bottom = 0;
                }
                wL(bottom);
            } else {
                wL((-this.hEX) + 2);
            }
        }
        if (!bPj() && this.hFe) {
            if (this.hES == 1) {
                this.hFk = true;
                wM(aBD().getHeight());
            } else if (this.hES == 2) {
                this.hFk = true;
                int y = (int) aBD().getY();
                if (this.hET == y) {
                    wM(aBD().getHeight());
                } else {
                    this.hET = y;
                    wM(aBD().getHeight());
                }
                if (i == 0 && this.hEW) {
                    this.hEW = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bPe();
                        }
                    }, 100L);
                }
            } else if (this.hES == 0) {
                if (this.hFk || !"nani_midpage".equals(this.hpd.bJp())) {
                    wM(aBD().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(int i) {
        wN(i);
        bPh();
    }

    public void nV(boolean z) {
        this.hFl = z;
    }

    private void wN(int i) {
        if (this.hEK != null) {
            if (i == 0) {
                i = this.hEX;
            }
            float f = this.hEX - i;
            float f2 = f > this.hEU ? 0.0f : 1.0f - (f / this.hEU);
            if (this.hFl) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hEK.bPa().setVisibility(8);
            } else {
                this.hEK.bPa().setVisibility(0);
            }
            this.hEK.aJ(f2);
        }
    }

    public void bPh() {
        if (this.hEK != null) {
            if (bPj()) {
                this.hpd.bJr().bNj();
            } else if (this.hEK.bPa().getVisibility() == 0) {
                this.hpd.bJr().bNj();
                this.hEL = true;
            } else if (this.hEL) {
                this.hpd.bJr().nU(false);
                this.hEL = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPi() {
        return aBD().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hER = false;
        if (this.fes != null && this.hEG != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEG.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fxf != null && this.fxf.isShowing()) {
                    this.fxf.sZ();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hFh != null) {
                    this.hFh.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hER = true;
                this.hEG.setLayoutParams(layoutParams);
                this.hpd.bJr().bNj();
                this.hEL = true;
            } else {
                e(this.hEI);
                bPg();
                this.hER = false;
                this.hEF.og(true);
            }
            this.fes.a(this.hpd.getPageContext(), configuration);
        }
    }

    public boolean bPj() {
        return this.hER;
    }

    public void s(long j, int i) {
        if (this.hEK != null && j > 0) {
            this.hEK.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.hEK != null) {
            this.hEK.N(onClickListener);
        }
    }

    public View aBD() {
        return this.hEE;
    }

    public boolean bNs() {
        if (aBD() == null) {
            return false;
        }
        return aBD().getBottom() > l.aQ(aBD().getContext()) - l.h(aBD().getContext(), d.e.ds50);
    }

    public void bPk() {
        this.hEW = true;
    }

    public void bPl() {
        if (this.fes != null) {
            this.fes.pausePlay();
        }
    }

    public View bPm() {
        return this.mEmptyView;
    }
}
