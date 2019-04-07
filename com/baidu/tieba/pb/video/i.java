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
    private static VideoControllerView.a gKw = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void awI() {
        }
    };
    private static c.i hEU = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void beQ() {
        }
    };
    private float Qm;
    private boolean XB;
    private n dbh;
    private com.baidu.tieba.play.c fee;
    private com.baidu.mcn.c fwR;
    private float hEA;
    private int hED;
    private double hEE;
    private long hEF;
    private PbVideoWifiTipLayout hEG;
    private int hEH;
    private c.d hEJ;
    private PbFullScreenFloatingHuajiAninationView hEL;
    private com.baidu.adp.lib.guide.c hEN;
    private Bitmap hEO;
    private boolean hEP;
    private boolean hER;
    private int hET;
    private RelativeLayout hEk;
    private com.baidu.tieba.pb.pb.main.view.b hEl;
    private CustomFrameLayout hEm;
    private c.d hEn;
    private z hEp;
    private g hEq;
    private boolean hEr;
    private bg hEs;
    private bg hEt;
    private String hEu;
    private PbActivity hoJ;
    private View mEmptyView;
    private Handler mHandler;
    private String bNn = null;
    private VideoInfo hEo = null;
    private boolean hEv = false;
    private int hEw = 0;
    private boolean hEx = false;
    private int hEy = 0;
    private int hEz = 0;
    private boolean hEB = false;
    private boolean hEC = false;
    private long startPosition = -1;
    private c.p hEI = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bPm() {
            if (i.this.hoJ != null && i.this.hoJ.bIX() != null && i.this.hoJ.bIX().getPbData() != null) {
                PostData bId = i.this.hoJ.bIX().getPbData().bId();
                if (bId == null && v.S(i.this.hoJ.bIX().getPbData().bHY()) > 1) {
                    bId = (PostData) v.c(i.this.hoJ.bIX().getPbData().bHY(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hoJ.bIX().getPbData(), bId, 1, 1, 4);
            }
        }
    };
    private boolean hEK = true;
    private PbFullScreenFloatingHuajiAninationView.a hEM = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.op(false);
        }
    };
    private boolean hEQ = false;
    private c.m hES = new c.m() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // com.baidu.tieba.play.c.m
        public boolean bPo() {
            if (i.this.hEE < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hoJ.checkUpIsLogin()) {
                i.this.hoJ.bJZ();
                if (i.this.hoJ.bIX() == null || i.this.hoJ.bIX().getPbData() == null || i.this.hoJ.bIX().getPbData().bIt() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bIt = i.this.hoJ.bIX().getPbData().bIt();
                if (i.this.hEL == null) {
                    i.this.hEL = new PbFullScreenFloatingHuajiAninationView(i.this.hoJ.getActivity());
                    i.this.hEL.setFloatingHuajiAninationListener(i.this.hEM);
                }
                i.this.hEL.or(bIt.bIx() ? false : true);
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
                if (i.this.fee != null) {
                    i.this.fee.setNetworkChange();
                }
                if (j.la() && i.this.fee != null && i.this.fee.ql() && i.this.hEo != null && i.this.hEo.video_length.intValue() > 0 && i.this.hEo.video_duration.intValue() > 0) {
                    float intValue = i.this.hEo.video_length.intValue() * (1.0f - ((i.this.fee.getCurrentPosition() * 1.0f) / (i.this.hEo.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hoJ.getPageContext().getPageActivity(), String.format(i.this.hoJ.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gIx = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.20
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bNW();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (this.hoJ != null) {
            this.hoJ.bJp();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.hEA = 0.0f;
        this.hoJ = pbActivity;
        this.hEl = bVar;
        this.hEA = l.h(this.hoJ.getActivity(), d.e.ds240);
        this.hEF = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fwR = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.hoJ.getActivity());
        Rect W = bb.W(this.hoJ.getPageContext().getPageActivity());
        int aQ = W.height() <= 0 ? l.aQ(this.hoJ.getActivity()) : W.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hEE = (intValue2 * 1.0d) / intValue;
            if (this.hEE > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.hED = i;
        this.hEm.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    public boolean bPb() {
        return this.hEE >= 1.0d;
    }

    public int bPc() {
        return this.hED;
    }

    private void f(VideoInfo videoInfo) {
        this.hEk = (RelativeLayout) LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.hEm = (CustomFrameLayout) this.hEk.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        this.XB = ((double) this.hED) <= (((double) l.aO(this.hoJ.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fee = new com.baidu.tieba.play.c((TbPageContext<?>) this.hoJ.getPageContext(), (View) this.hEm, true);
        this.fee.a(this.hES);
        this.fee.oY(false);
        this.fee.a(this.hEI);
        this.fee.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.16
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (UtilHelper.isOnePlus6()) {
            this.fee.oP(false);
        }
        this.fee.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.17
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
                        if (i.this.hoJ.getListView() != null && i.this.hoJ.getListView().getChildCount() > 0 && i.this.hoJ.getListView().getChildAt(0) == i.this.bPl()) {
                            i.this.hET = i.this.bPl().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Qm = 0.0f;
                        i.this.hET = 0;
                        break;
                    case 2:
                        if (i.this.hoJ.getListView() != null && i.this.hoJ.getListView().getChildCount() > 0 && i.this.hoJ.getListView().getChildAt(0) == i.this.bPl()) {
                            i.this.hoJ.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Qm)) + i.this.hET);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hEE >= 1.0d) {
                this.fee.ac(false, true);
            } else {
                this.fee.ac(true, false);
            }
            this.hEB = ((float) e) + this.hEA > ((float) l.aQ(this.hoJ.getActivity()));
            if (this.hEB) {
                if (this.hEq == null) {
                    this.hEq = new g(this.hoJ.getPageContext(), this.hEm);
                }
                this.hoJ.bJn().bNg();
                this.hEr = true;
            }
        }
        bPe();
        this.mEmptyView = new View(this.hoJ);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hED));
        if (this.hEl != null && this.hEl.mNavigationBar != null) {
            this.hEl.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hEl.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.hEl.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.abZ() ? 0 : 8);
        }
        this.hEG = (PbVideoWifiTipLayout) this.hEk.findViewById(d.g.layout_wifi_tip);
        this.hEG.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hEP = true;
                i.this.hEG.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fwR != null) {
            this.fwR.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hoJ.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hEn == null) {
            this.hEn = new c.d() { // from class: com.baidu.tieba.pb.video.i.19
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (i.this.bPh() && i.this.hEl != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hEl.bNQ().clearAnimation();
                        i.this.bPf();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gIx);
                            i.this.hEl.bNQ().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void beP() {
                    if (i.this.bPh()) {
                        i.this.bNW();
                    }
                }
            };
        }
        a(this.hEn);
        this.hEw = UtilHelper.getLightStatusBarHeight() + l.h(this.hoJ.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fee != null && bgVar != null) {
            this.hEo = videoInfo;
            this.hEs = bgVar;
            this.bNn = videoInfo.video_url;
            this.fee.stopPlay();
            this.fee.setIsNeedRecoveryVideoPlayer(true);
            this.dbh = new n(this.hoJ.getActivity());
            this.hEp = new z();
            this.hEp.mLocate = "pb";
            this.hEp.ctw = bgVar.getTid();
            this.hEp.ekM = str;
            this.hEp.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hEp.mSource = bgVar.mRecomSource;
            this.hEp.hYy = bgVar.mRecomWeight;
            this.hEp.hYz = this.hoJ.bJl();
            this.hEp.hYA = bgVar.mRecomAbTag;
            this.hEp.hYB = videoInfo.video_md5;
            z bTS = this.hEp.bTS();
            bTS.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dbh.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cT = com.baidu.mcn.b.sX().cT(mcnAdInfo.jump_url);
                        if (i.this.XB && !cT && !i.this.hEx) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fwR.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeP = mcnAdInfo.card_title;
                                    aVar.aeQ = mcnAdInfo.button_title;
                                    aVar.aeR = mcnAdInfo.jump_url;
                                    aVar.aeO = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeS = 4;
                                    if (z2) {
                                        i.this.fwR.b(aVar, (ViewGroup) i.this.fee.bSV());
                                    } else {
                                        i.this.fwR.a(aVar, (ViewGroup) i.this.fee.bSV());
                                    }
                                }
                            } else if (i.this.fwR.isShowing()) {
                                i.this.fwR.dismiss();
                            }
                        }
                    }
                }
            });
            this.dbh.setVideoStatsData(bTS);
            this.fee.getVideoView().setBusiness(this.dbh);
            if (this.fee.bAF()) {
                this.fee.bAD();
            }
            this.fee.b(this.hEJ);
            this.hEu = null;
            this.hEt = null;
            this.fee.Aq(this.hEu);
            this.fee.bAz().setOnDragingListener(gKw);
            this.fee.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    i.this.hoJ.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hEH > 0) {
                                i.this.wH(i.this.hEH);
                                i.this.wI(i.this.hEH);
                                i.this.hEH = 0;
                            }
                            i.this.hEK = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    i.this.hoJ.setSwipeBackEnabled(false);
                    i.this.hEK = false;
                    i.this.hEH = i.this.aBz().getHeight();
                }
            });
            this.fee.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bPn() {
                    if (i.this.hoJ != null && i.this.hEt != null && !StringUtils.isNull(i.this.hEt.getId())) {
                        i.this.hoJ.zJ(i.this.hEt.getId());
                        if (i.this.hEs != null) {
                            long j = 0;
                            if (i.this.hEs.ZY() != null) {
                                j = i.this.hEs.ZY().channelId;
                            }
                            TiebaStatic.log(new am("c11921").k(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fee.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void oq(boolean z) {
                    if (i.this.hEs != null) {
                        long j = 0;
                        if (i.this.hEs.ZY() != null) {
                            j = i.this.hEs.ZY().channelId;
                        }
                        i.this.vb(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bJ("tid", i.this.hEs.getTid()).k(ImageViewerConfig.FORUM_ID, i.this.hEs.getFid()).k(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fee.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bNn);
                    return true;
                }
            });
            this.fee.setThumbnail(videoInfo.thumbnail_url);
            this.fee.setVideoUrl(this.bNn, bgVar.getTid());
            this.fee.setFid(str);
            this.fee.AN(bgVar.getTitle());
            this.fee.a(hEU);
            this.fee.bnN();
            this.fee.show();
        }
    }

    public void Ap(String str) {
        if (this.hEp != null) {
            this.hEp.ekM = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.hEq != null) {
            this.hEq.a(postData, bgVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.hEJ = dVar;
    }

    public void aD(bg bgVar) {
        this.hEt = bgVar;
    }

    public void Aq(String str) {
        this.hEu = str;
        if (this.fee != null) {
            this.fee.Aq(this.hEu);
        }
    }

    public void startPlay() {
        if (this.fee != null) {
            if (com.baidu.adp.lib.util.j.la() && !this.hEP && !com.baidu.tieba.video.g.ciN().ciO()) {
                this.hEG.setVisibility(0);
                this.hEG.setData(this.hEo);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bNn) && this.hEs != null && this.hEs.Zf() != null) {
                TiebaStatic.log(new am("c12619").bJ("obj_locate", "pb").bJ("tid", this.hEs.getTid()));
                this.bNn = this.hEs.Zf().video_url;
            }
            this.fee.h(this.bNn, this.hEs == null ? "" : this.hEs.getTid(), this.hEF);
            vb("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bPd() {
        if (this.fee != null) {
            this.fee.bPd();
        }
    }

    public void destroy() {
        if (this.fee != null) {
            this.fee.destroy();
        }
        if (this.hEm != null) {
            this.hEm.clearAnimation();
        }
        if (this.hEq != null) {
            this.hEq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.fee != null) {
            if (this.fee.ql()) {
                this.hEv = true;
                this.fee.stopPlay();
            } else if (this.fee.getCurrentState() == 3) {
                this.hEv = false;
            } else if (this.fee.getCurrentState() == 0 || this.fee.getCurrentState() == 1) {
                this.hEv = true;
                this.fee.stopPlay();
            } else {
                this.hEv = false;
                this.fee.stopPlay();
            }
            if (this.hEL != null) {
                this.hEL.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fee != null && this.hEv) {
            this.fee.bSH();
        }
    }

    private void bPe() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.ad(false);
            dVar.af(16908290).ae(153).ac(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hoJ.getActivity());
                    if (i.this.hEO == null) {
                        try {
                            i.this.hEO = BitmapFactory.decodeResource(i.this.hoJ.getResources(), d.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hEO);
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
                    i.this.hEN = null;
                    if (i.this.hEO != null && !i.this.hEO.isRecycled()) {
                        i.this.hEO.recycle();
                    }
                    i.this.hEO = null;
                }
            });
            this.hEN = dVar.iT();
            this.hEN.o(this.hoJ.getActivity());
        }
    }

    public boolean qs(int i) {
        if (this.fee == null) {
            return false;
        }
        return this.fee.xh(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(String str) {
        if (this.hEo != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hEo.video_md5, "", str, this.hEp);
            }
        }
    }

    public void bPf() {
        if (this.hEl != null) {
            this.hEl.oh(this.hoJ.bIN());
        }
    }

    public void bNW() {
        if (this.hEl != null) {
            this.hEl.bNW();
        }
    }

    public void wC(int i) {
        if (this.hEl != null) {
            this.hEl.wC(i);
        }
        if (this.hEL != null) {
            this.hEL.onChangeSkinType(i);
        }
        if (this.hEq != null) {
            this.hEq.ii(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bPi()) {
                    this.hEy = i;
                    if (this.hEy == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.wI(i.this.aBz().getHeight());
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
    public void wH(int i) {
        if (aBz().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEm.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hER = false;
                    if (this.hED != aBz().getHeight()) {
                        this.hEm.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hoJ.getActivity()), Math.min(this.hED, aBz().getHeight() + i)));
                        this.fee.bAD();
                    }
                } else if (l.aO(this.hoJ.getActivity()) * 0.5625d != aBz().getHeight()) {
                    this.hEm.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hoJ.getActivity()), (int) Math.max(l.aO(this.hoJ.getActivity()) * 0.5625d, aBz().getHeight() + i)));
                    this.fee.bAD();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bPl()) {
                int bottom = childAt.getBottom() - aBz().getBottom();
                if (childAt.getHeight() == 0 || aBz().getHeight() == 0) {
                    bottom = 0;
                }
                wH(bottom);
            } else {
                wH((-this.hED) + 2);
            }
        }
        if (!bPi() && this.hEK) {
            if (this.hEy == 1) {
                this.hEQ = true;
                wI(aBz().getHeight());
            } else if (this.hEy == 2) {
                this.hEQ = true;
                int y = (int) aBz().getY();
                if (this.hEz == y) {
                    wI(aBz().getHeight());
                } else {
                    this.hEz = y;
                    wI(aBz().getHeight());
                }
                if (i == 0 && this.hEC) {
                    this.hEC = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bPd();
                        }
                    }, 100L);
                }
            } else if (this.hEy == 0) {
                if (this.hEQ || !"nani_midpage".equals(this.hoJ.bJl())) {
                    wI(aBz().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(int i) {
        wJ(i);
        bPg();
    }

    public void nV(boolean z) {
        this.hER = z;
    }

    private void wJ(int i) {
        if (this.hEq != null) {
            if (i == 0) {
                i = this.hED;
            }
            float f = this.hED - i;
            float f2 = f > this.hEA ? 0.0f : 1.0f - (f / this.hEA);
            if (this.hER) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hEq.bOX().setVisibility(8);
            } else {
                this.hEq.bOX().setVisibility(0);
            }
            this.hEq.aJ(f2);
        }
    }

    public void bPg() {
        if (this.hEq != null) {
            if (bPi()) {
                this.hoJ.bJn().bNg();
            } else if (this.hEq.bOX().getVisibility() == 0) {
                this.hoJ.bJn().bNg();
                this.hEr = true;
            } else if (this.hEr) {
                this.hoJ.bJn().nU(false);
                this.hEr = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPh() {
        return aBz().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.hEx = false;
        if (this.fee != null && this.hEm != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEm.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fwR != null && this.fwR.isShowing()) {
                    this.fwR.sY();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hEN != null) {
                    this.hEN.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hEx = true;
                this.hEm.setLayoutParams(layoutParams);
                this.hoJ.bJn().bNg();
                this.hEr = true;
            } else {
                e(this.hEo);
                bPf();
                this.hEx = false;
                this.hEl.og(true);
            }
            this.fee.a(this.hoJ.getPageContext(), configuration);
        }
    }

    public boolean bPi() {
        return this.hEx;
    }

    public void s(long j, int i) {
        if (this.hEq != null && j > 0) {
            this.hEq.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.hEq != null) {
            this.hEq.N(onClickListener);
        }
    }

    public View aBz() {
        return this.hEk;
    }

    public boolean bNp() {
        if (aBz() == null) {
            return false;
        }
        return aBz().getBottom() > l.aQ(aBz().getContext()) - l.h(aBz().getContext(), d.e.ds50);
    }

    public void bPj() {
        this.hEC = true;
    }

    public void bPk() {
        if (this.fee != null) {
            this.fee.pausePlay();
        }
    }

    public View bPl() {
        return this.mEmptyView;
    }
}
