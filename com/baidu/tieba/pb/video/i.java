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
    private static c.i hFi = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void beS() {
        }
    };
    private float Qm;
    private boolean XB;
    private n dbe;
    private com.baidu.tieba.play.c fer;
    private com.baidu.mcn.c fxe;
    private CustomFrameLayout hEA;
    private c.d hEB;
    private z hED;
    private g hEE;
    private boolean hEF;
    private bg hEG;
    private bg hEH;
    private String hEI;
    private float hEO;
    private int hER;
    private double hES;
    private long hET;
    private PbVideoWifiTipLayout hEU;
    private int hEV;
    private c.d hEX;
    private PbFullScreenFloatingHuajiAninationView hEZ;
    private RelativeLayout hEy;
    private com.baidu.tieba.pb.pb.main.view.b hEz;
    private com.baidu.adp.lib.guide.c hFb;
    private Bitmap hFc;
    private boolean hFd;
    private boolean hFf;
    private int hFh;
    private PbActivity hoW;
    private View mEmptyView;
    private Handler mHandler;
    private String bNl = null;
    private VideoInfo hEC = null;
    private boolean hEJ = false;
    private int hEK = 0;
    private boolean hEL = false;
    private int hEM = 0;
    private int hEN = 0;
    private boolean hEP = false;
    private boolean hEQ = false;
    private long startPosition = -1;
    private c.p hEW = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bPp() {
            if (i.this.hoW != null && i.this.hoW.bJa() != null && i.this.hoW.bJa().getPbData() != null) {
                PostData bIg = i.this.hoW.bJa().getPbData().bIg();
                if (bIg == null && v.S(i.this.hoW.bJa().getPbData().bIb()) > 1) {
                    bIg = (PostData) v.c(i.this.hoW.bJa().getPbData().bIb(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hoW.bJa().getPbData(), bIg, 1, 1, 4);
            }
        }
    };
    private boolean hEY = true;
    private PbFullScreenFloatingHuajiAninationView.a hFa = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.op(false);
        }
    };
    private boolean hFe = false;
    private c.m hFg = new c.m() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // com.baidu.tieba.play.c.m
        public boolean bPr() {
            if (i.this.hES < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hoW.checkUpIsLogin()) {
                i.this.hoW.bKc();
                if (i.this.hoW.bJa() == null || i.this.hoW.bJa().getPbData() == null || i.this.hoW.bJa().getPbData().bIw() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bIw = i.this.hoW.bJa().getPbData().bIw();
                if (i.this.hEZ == null) {
                    i.this.hEZ = new PbFullScreenFloatingHuajiAninationView(i.this.hoW.getActivity());
                    i.this.hEZ.setFloatingHuajiAninationListener(i.this.hFa);
                }
                i.this.hEZ.or(bIw.bIA() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bPs() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY()) {
                if (i.this.fer != null) {
                    i.this.fer.setNetworkChange();
                }
                if (j.la() && i.this.fer != null && i.this.fer.ql() && i.this.hEC != null && i.this.hEC.video_length.intValue() > 0 && i.this.hEC.video_duration.intValue() > 0) {
                    float intValue = i.this.hEC.video_length.intValue() * (1.0f - ((i.this.fer.getCurrentPosition() * 1.0f) / (i.this.hEC.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hoW.getPageContext().getPageActivity(), String.format(i.this.hoW.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
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
            i.this.bNZ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (this.hoW != null) {
            this.hoW.bJs();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.hEO = 0.0f;
        this.hoW = pbActivity;
        this.hEz = bVar;
        this.hEO = l.h(this.hoW.getActivity(), d.e.ds240);
        this.hET = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fxe = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.hoW.getActivity());
        Rect W = bb.W(this.hoW.getPageContext().getPageActivity());
        int aQ = W.height() <= 0 ? l.aQ(this.hoW.getActivity()) : W.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hES = (intValue2 * 1.0d) / intValue;
            if (this.hES > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.hER = i;
        this.hEA.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    public boolean bPe() {
        return this.hES >= 1.0d;
    }

    public int bPf() {
        return this.hER;
    }

    private void f(VideoInfo videoInfo) {
        this.hEy = (RelativeLayout) LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.hEA = (CustomFrameLayout) this.hEy.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        this.XB = ((double) this.hER) <= (((double) l.aO(this.hoW.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fer = new com.baidu.tieba.play.c((TbPageContext<?>) this.hoW.getPageContext(), (View) this.hEA, true);
        this.fer.a(this.hFg);
        this.fer.oY(false);
        this.fer.a(this.hEW);
        this.fer.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.16
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (UtilHelper.isOnePlus6()) {
            this.fer.oP(false);
        }
        this.fer.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.17
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
                        i.this.Qm = motionEvent.getY();
                        if (i.this.hoW.getListView() != null && i.this.hoW.getListView().getChildCount() > 0 && i.this.hoW.getListView().getChildAt(0) == i.this.bPo()) {
                            i.this.hFh = i.this.bPo().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Qm = 0.0f;
                        i.this.hFh = 0;
                        break;
                    case 2:
                        if (i.this.hoW.getListView() != null && i.this.hoW.getListView().getChildCount() > 0 && i.this.hoW.getListView().getChildAt(0) == i.this.bPo()) {
                            i.this.hoW.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Qm)) + i.this.hFh);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hES >= 1.0d) {
                this.fer.ae(false, true);
            } else {
                this.fer.ae(true, false);
            }
            this.hEP = ((float) e) + this.hEO > ((float) l.aQ(this.hoW.getActivity()));
            if (this.hEP) {
                if (this.hEE == null) {
                    this.hEE = new g(this.hoW.getPageContext(), this.hEA);
                }
                this.hoW.bJq().bNj();
                this.hEF = true;
            }
        }
        bPh();
        this.mEmptyView = new View(this.hoW);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hER));
        if (this.hEz != null && this.hEz.mNavigationBar != null) {
            this.hEz.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hEz.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.hEz.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.acc() ? 0 : 8);
        }
        this.hEU = (PbVideoWifiTipLayout) this.hEy.findViewById(d.g.layout_wifi_tip);
        this.hEU.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hFd = true;
                i.this.hEU.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fxe != null) {
            this.fxe.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hoW.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hEB == null) {
            this.hEB = new c.d() { // from class: com.baidu.tieba.pb.video.i.19
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (i.this.bPk() && i.this.hEz != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hEz.bNT().clearAnimation();
                        i.this.bPi();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gIK);
                            i.this.hEz.bNT().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void beR() {
                    if (i.this.bPk()) {
                        i.this.bNZ();
                    }
                }
            };
        }
        a(this.hEB);
        this.hEK = UtilHelper.getLightStatusBarHeight() + l.h(this.hoW.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fer != null && bgVar != null) {
            this.hEC = videoInfo;
            this.hEG = bgVar;
            this.bNl = videoInfo.video_url;
            this.fer.stopPlay();
            this.fer.setIsNeedRecoveryVideoPlayer(true);
            this.dbe = new n(this.hoW.getActivity());
            this.hED = new z();
            this.hED.mLocate = "pb";
            this.hED.ctu = bgVar.getTid();
            this.hED.ela = str;
            this.hED.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hED.mSource = bgVar.mRecomSource;
            this.hED.hYM = bgVar.mRecomWeight;
            this.hED.hYN = this.hoW.bJo();
            this.hED.hYO = bgVar.mRecomAbTag;
            this.hED.hYP = videoInfo.video_md5;
            z bTW = this.hED.bTW();
            bTW.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dbe.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cR = com.baidu.mcn.b.sY().cR(mcnAdInfo.jump_url);
                        if (i.this.XB && !cR && !i.this.hEL) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fxe.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeK = mcnAdInfo.card_title;
                                    aVar.aeL = mcnAdInfo.button_title;
                                    aVar.aeM = mcnAdInfo.jump_url;
                                    aVar.aeJ = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeN = 4;
                                    if (z2) {
                                        i.this.fxe.b(aVar, (ViewGroup) i.this.fer.bSZ());
                                    } else {
                                        i.this.fxe.a(aVar, (ViewGroup) i.this.fer.bSZ());
                                    }
                                }
                            } else if (i.this.fxe.isShowing()) {
                                i.this.fxe.dismiss();
                            }
                        }
                    }
                }
            });
            this.dbe.setVideoStatsData(bTW);
            this.fer.getVideoView().setBusiness(this.dbe);
            if (this.fer.bAI()) {
                this.fer.bAG();
            }
            this.fer.b(this.hEX);
            this.hEI = null;
            this.hEH = null;
            this.fer.Ar(this.hEI);
            this.fer.bAC().setOnDragingListener(gKJ);
            this.fer.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    i.this.hoW.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hEV > 0) {
                                i.this.wL(i.this.hEV);
                                i.this.wM(i.this.hEV);
                                i.this.hEV = 0;
                            }
                            i.this.hEY = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    i.this.hoW.setSwipeBackEnabled(false);
                    i.this.hEY = false;
                    i.this.hEV = i.this.aBC().getHeight();
                }
            });
            this.fer.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bPq() {
                    if (i.this.hoW != null && i.this.hEH != null && !StringUtils.isNull(i.this.hEH.getId())) {
                        i.this.hoW.zK(i.this.hEH.getId());
                        if (i.this.hEG != null) {
                            long j = 0;
                            if (i.this.hEG.aab() != null) {
                                j = i.this.hEG.aab().channelId;
                            }
                            TiebaStatic.log(new am("c11921").k(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fer.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void oq(boolean z) {
                    if (i.this.hEG != null) {
                        long j = 0;
                        if (i.this.hEG.aab() != null) {
                            j = i.this.hEG.aab().channelId;
                        }
                        i.this.vc(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bJ("tid", i.this.hEG.getTid()).k(ImageViewerConfig.FORUM_ID, i.this.hEG.getFid()).k(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fer.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bNl);
                    return true;
                }
            });
            this.fer.setThumbnail(videoInfo.thumbnail_url);
            this.fer.setVideoUrl(this.bNl, bgVar.getTid());
            this.fer.setFid(str);
            this.fer.AO(bgVar.getTitle());
            this.fer.a(hFi);
            this.fer.bnQ();
            this.fer.show();
        }
    }

    public void Aq(String str) {
        if (this.hED != null) {
            this.hED.ela = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.hEE != null) {
            this.hEE.a(postData, bgVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.hEX = dVar;
    }

    public void aE(bg bgVar) {
        this.hEH = bgVar;
    }

    public void Ar(String str) {
        this.hEI = str;
        if (this.fer != null) {
            this.fer.Ar(this.hEI);
        }
    }

    public void startPlay() {
        if (this.fer != null) {
            if (com.baidu.adp.lib.util.j.la() && !this.hFd && !com.baidu.tieba.video.g.ciP().ciQ()) {
                this.hEU.setVisibility(0);
                this.hEU.setData(this.hEC);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bNl) && this.hEG != null && this.hEG.Zi() != null) {
                TiebaStatic.log(new am("c12619").bJ("obj_locate", "pb").bJ("tid", this.hEG.getTid()));
                this.bNl = this.hEG.Zi().video_url;
            }
            this.fer.h(this.bNl, this.hEG == null ? "" : this.hEG.getTid(), this.hET);
            vc("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bPg() {
        if (this.fer != null) {
            this.fer.bPg();
        }
    }

    public void destroy() {
        if (this.fer != null) {
            this.fer.destroy();
        }
        if (this.hEA != null) {
            this.hEA.clearAnimation();
        }
        if (this.hEE != null) {
            this.hEE.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.fer != null) {
            if (this.fer.ql()) {
                this.hEJ = true;
                this.fer.stopPlay();
            } else if (this.fer.getCurrentState() == 3) {
                this.hEJ = false;
            } else if (this.fer.getCurrentState() == 0 || this.fer.getCurrentState() == 1) {
                this.hEJ = true;
                this.fer.stopPlay();
            } else {
                this.hEJ = false;
                this.fer.stopPlay();
            }
            if (this.hEZ != null) {
                this.hEZ.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fer != null && this.hEJ) {
            this.fer.bSL();
        }
    }

    private void bPh() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.ag(16908290).af(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hoW.getActivity());
                    if (i.this.hFc == null) {
                        try {
                            i.this.hFc = BitmapFactory.decodeResource(i.this.hoW.getResources(), d.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hFc);
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
                    i.this.hFb = null;
                    if (i.this.hFc != null && !i.this.hFc.isRecycled()) {
                        i.this.hFc.recycle();
                    }
                    i.this.hFc = null;
                }
            });
            this.hFb = dVar.iT();
            this.hFb.o(this.hoW.getActivity());
        }
    }

    public boolean qw(int i) {
        if (this.fer == null) {
            return false;
        }
        return this.fer.xl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(String str) {
        if (this.hEC != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hEC.video_md5, "", str, this.hED);
            }
        }
    }

    public void bPi() {
        if (this.hEz != null) {
            this.hEz.oh(this.hoW.bIQ());
        }
    }

    public void bNZ() {
        if (this.hEz != null) {
            this.hEz.bNZ();
        }
    }

    public void wG(int i) {
        if (this.hEz != null) {
            this.hEz.wG(i);
        }
        if (this.hEZ != null) {
            this.hEZ.onChangeSkinType(i);
        }
        if (this.hEE != null) {
            this.hEE.ij(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bPl()) {
                    this.hEM = i;
                    if (this.hEM == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.wM(i.this.aBC().getHeight());
                            }
                        }, 100L);
                    }
                    bPj();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        if (aBC().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEA.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hFf = false;
                    if (this.hER != aBC().getHeight()) {
                        this.hEA.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hoW.getActivity()), Math.min(this.hER, aBC().getHeight() + i)));
                        this.fer.bAG();
                    }
                } else if (l.aO(this.hoW.getActivity()) * 0.5625d != aBC().getHeight()) {
                    this.hEA.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hoW.getActivity()), (int) Math.max(l.aO(this.hoW.getActivity()) * 0.5625d, aBC().getHeight() + i)));
                    this.fer.bAG();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bPo()) {
                int bottom = childAt.getBottom() - aBC().getBottom();
                if (childAt.getHeight() == 0 || aBC().getHeight() == 0) {
                    bottom = 0;
                }
                wL(bottom);
            } else {
                wL((-this.hER) + 2);
            }
        }
        if (!bPl() && this.hEY) {
            if (this.hEM == 1) {
                this.hFe = true;
                wM(aBC().getHeight());
            } else if (this.hEM == 2) {
                this.hFe = true;
                int y = (int) aBC().getY();
                if (this.hEN == y) {
                    wM(aBC().getHeight());
                } else {
                    this.hEN = y;
                    wM(aBC().getHeight());
                }
                if (i == 0 && this.hEQ) {
                    this.hEQ = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bPg();
                        }
                    }, 100L);
                }
            } else if (this.hEM == 0) {
                if (this.hFe || !"nani_midpage".equals(this.hoW.bJo())) {
                    wM(aBC().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(int i) {
        wN(i);
        bPj();
    }

    public void nV(boolean z) {
        this.hFf = z;
    }

    private void wN(int i) {
        if (this.hEE != null) {
            if (i == 0) {
                i = this.hER;
            }
            float f = this.hER - i;
            float f2 = f > this.hEO ? 0.0f : 1.0f - (f / this.hEO);
            if (this.hFf) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hEE.bPa().setVisibility(8);
            } else {
                this.hEE.bPa().setVisibility(0);
            }
            this.hEE.aJ(f2);
        }
    }

    public void bPj() {
        if (this.hEE != null) {
            if (bPl()) {
                this.hoW.bJq().bNj();
            } else if (this.hEE.bPa().getVisibility() == 0) {
                this.hoW.bJq().bNj();
                this.hEF = true;
            } else if (this.hEF) {
                this.hoW.bJq().nU(false);
                this.hEF = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPk() {
        return aBC().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hEL = false;
        if (this.fer != null && this.hEA != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEA.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fxe != null && this.fxe.isShowing()) {
                    this.fxe.sZ();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hFb != null) {
                    this.hFb.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hEL = true;
                this.hEA.setLayoutParams(layoutParams);
                this.hoW.bJq().bNj();
                this.hEF = true;
            } else {
                e(this.hEC);
                bPi();
                this.hEL = false;
                this.hEz.og(true);
            }
            this.fer.a(this.hoW.getPageContext(), configuration);
        }
    }

    public boolean bPl() {
        return this.hEL;
    }

    public void s(long j, int i) {
        if (this.hEE != null && j > 0) {
            this.hEE.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.hEE != null) {
            this.hEE.N(onClickListener);
        }
    }

    public View aBC() {
        return this.hEy;
    }

    public boolean bNs() {
        if (aBC() == null) {
            return false;
        }
        return aBC().getBottom() > l.aQ(aBC().getContext()) - l.h(aBC().getContext(), d.e.ds50);
    }

    public void bPm() {
        this.hEQ = true;
    }

    public void bPn() {
        if (this.fer != null) {
            this.fer.pausePlay();
        }
    }

    public View bPo() {
        return this.mEmptyView;
    }
}
