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
    private static VideoControllerView.a gKx = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void awI() {
        }
    };
    private static c.i hEV = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void beQ() {
        }
    };
    private float Qm;
    private boolean XC;
    private n dbi;
    private com.baidu.tieba.play.c fee;
    private com.baidu.mcn.c fwR;
    private float hEB;
    private int hEE;
    private double hEF;
    private long hEG;
    private PbVideoWifiTipLayout hEH;
    private int hEI;
    private c.d hEK;
    private PbFullScreenFloatingHuajiAninationView hEM;
    private com.baidu.adp.lib.guide.c hEO;
    private Bitmap hEP;
    private boolean hEQ;
    private boolean hES;
    private int hEU;
    private RelativeLayout hEl;
    private com.baidu.tieba.pb.pb.main.view.b hEm;
    private CustomFrameLayout hEn;
    private c.d hEo;
    private z hEq;
    private g hEr;
    private boolean hEs;
    private bg hEt;
    private bg hEu;
    private String hEv;
    private PbActivity hoK;
    private View mEmptyView;
    private Handler mHandler;
    private String bNo = null;
    private VideoInfo hEp = null;
    private boolean hEw = false;
    private int hEx = 0;
    private boolean hEy = false;
    private int hEz = 0;
    private int hEA = 0;
    private boolean hEC = false;
    private boolean hED = false;
    private long startPosition = -1;
    private c.p hEJ = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bPm() {
            if (i.this.hoK != null && i.this.hoK.bIX() != null && i.this.hoK.bIX().getPbData() != null) {
                PostData bId = i.this.hoK.bIX().getPbData().bId();
                if (bId == null && v.S(i.this.hoK.bIX().getPbData().bHY()) > 1) {
                    bId = (PostData) v.c(i.this.hoK.bIX().getPbData().bHY(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hoK.bIX().getPbData(), bId, 1, 1, 4);
            }
        }
    };
    private boolean hEL = true;
    private PbFullScreenFloatingHuajiAninationView.a hEN = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.op(false);
        }
    };
    private boolean hER = false;
    private c.m hET = new c.m() { // from class: com.baidu.tieba.pb.video.i.14
        @Override // com.baidu.tieba.play.c.m
        public boolean bPo() {
            if (i.this.hEF < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hoK.checkUpIsLogin()) {
                i.this.hoK.bJZ();
                if (i.this.hoK.bIX() == null || i.this.hoK.bIX().getPbData() == null || i.this.hoK.bIX().getPbData().bIt() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bIt = i.this.hoK.bIX().getPbData().bIt();
                if (i.this.hEM == null) {
                    i.this.hEM = new PbFullScreenFloatingHuajiAninationView(i.this.hoK.getActivity());
                    i.this.hEM.setFloatingHuajiAninationListener(i.this.hEN);
                }
                i.this.hEM.or(bIt.bIx() ? false : true);
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
                if (j.la() && i.this.fee != null && i.this.fee.ql() && i.this.hEp != null && i.this.hEp.video_length.intValue() > 0 && i.this.hEp.video_duration.intValue() > 0) {
                    float intValue = i.this.hEp.video_length.intValue() * (1.0f - ((i.this.fee.getCurrentPosition() * 1.0f) / (i.this.hEp.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hoK.getPageContext().getPageActivity(), String.format(i.this.hoK.getPageContext().getString(d.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener gIy = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.20
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
        if (this.hoK != null) {
            this.hoK.bJp();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.hEB = 0.0f;
        this.hoK = pbActivity;
        this.hEm = bVar;
        this.hEB = l.h(this.hoK.getActivity(), d.e.ds240);
        this.hEG = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fwR = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.hoK.getActivity());
        Rect W = bb.W(this.hoK.getPageContext().getPageActivity());
        int aQ = W.height() <= 0 ? l.aQ(this.hoK.getActivity()) : W.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.hEF = (intValue2 * 1.0d) / intValue;
            if (this.hEF > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.hEE = i;
        this.hEn.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    public boolean bPb() {
        return this.hEF >= 1.0d;
    }

    public int bPc() {
        return this.hEE;
    }

    private void f(VideoInfo videoInfo) {
        this.hEl = (RelativeLayout) LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.video_pb_container_layout, (ViewGroup) null);
        this.hEn = (CustomFrameLayout) this.hEl.findViewById(d.g.pb_video_container);
        int e = e(videoInfo);
        this.XC = ((double) this.hEE) <= (((double) l.aO(this.hoK.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fee = new com.baidu.tieba.play.c((TbPageContext<?>) this.hoK.getPageContext(), (View) this.hEn, true);
        this.fee.a(this.hET);
        this.fee.oY(false);
        this.fee.a(this.hEJ);
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
                        if (i.this.hoK.getListView() != null && i.this.hoK.getListView().getChildCount() > 0 && i.this.hoK.getListView().getChildAt(0) == i.this.bPl()) {
                            i.this.hEU = i.this.bPl().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Qm = 0.0f;
                        i.this.hEU = 0;
                        break;
                    case 2:
                        if (i.this.hoK.getListView() != null && i.this.hoK.getListView().getChildCount() > 0 && i.this.hoK.getListView().getChildAt(0) == i.this.bPl()) {
                            i.this.hoK.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Qm)) + i.this.hEU);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.hEF >= 1.0d) {
                this.fee.ac(false, true);
            } else {
                this.fee.ac(true, false);
            }
            this.hEC = ((float) e) + this.hEB > ((float) l.aQ(this.hoK.getActivity()));
            if (this.hEC) {
                if (this.hEr == null) {
                    this.hEr = new g(this.hoK.getPageContext(), this.hEn);
                }
                this.hoK.bJn().bNg();
                this.hEs = true;
            }
        }
        bPe();
        this.mEmptyView = new View(this.hoK);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.hEE));
        if (this.hEm != null && this.hEm.mNavigationBar != null) {
            this.hEm.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.hEm.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.hEm.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.abZ() ? 0 : 8);
        }
        this.hEH = (PbVideoWifiTipLayout) this.hEl.findViewById(d.g.layout_wifi_tip);
        this.hEH.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.hEQ = true;
                i.this.hEH.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fwR != null) {
            this.fwR.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hoK.getActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.hEo == null) {
            this.hEo = new c.d() { // from class: com.baidu.tieba.pb.video.i.19
                @Override // com.baidu.tieba.play.c.d
                public void jy(boolean z) {
                    if (i.this.bPh() && i.this.hEm != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.hEm.bNQ().clearAnimation();
                        i.this.bPf();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.gIy);
                            i.this.hEm.bNQ().startAnimation(loadAnimation);
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
        a(this.hEo);
        this.hEx = UtilHelper.getLightStatusBarHeight() + l.h(this.hoK.getActivity(), d.e.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fee != null && bgVar != null) {
            this.hEp = videoInfo;
            this.hEt = bgVar;
            this.bNo = videoInfo.video_url;
            this.fee.stopPlay();
            this.fee.setIsNeedRecoveryVideoPlayer(true);
            this.dbi = new n(this.hoK.getActivity());
            this.hEq = new z();
            this.hEq.mLocate = "pb";
            this.hEq.ctx = bgVar.getTid();
            this.hEq.ekN = str;
            this.hEq.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hEq.mSource = bgVar.mRecomSource;
            this.hEq.hYz = bgVar.mRecomWeight;
            this.hEq.hYA = this.hoK.bJl();
            this.hEq.hYB = bgVar.mRecomAbTag;
            this.hEq.hYC = videoInfo.video_md5;
            z bTS = this.hEq.bTS();
            bTS.mLocate = Constants.VIA_SHARE_TYPE_INFO;
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
                        boolean cT = com.baidu.mcn.b.sX().cT(mcnAdInfo.jump_url);
                        if (i.this.XC && !cT && !i.this.hEy) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fwR.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeQ = mcnAdInfo.card_title;
                                    aVar.aeR = mcnAdInfo.button_title;
                                    aVar.aeS = mcnAdInfo.jump_url;
                                    aVar.aeP = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.aeT = 4;
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
            this.dbi.setVideoStatsData(bTS);
            this.fee.getVideoView().setBusiness(this.dbi);
            if (this.fee.bAF()) {
                this.fee.bAD();
            }
            this.fee.b(this.hEK);
            this.hEv = null;
            this.hEu = null;
            this.fee.Aq(this.hEv);
            this.fee.bAz().setOnDragingListener(gKx);
            this.fee.a(new c.InterfaceC0368c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qk() {
                    i.this.hoK.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.hEI > 0) {
                                i.this.wH(i.this.hEI);
                                i.this.wI(i.this.hEI);
                                i.this.hEI = 0;
                            }
                            i.this.hEL = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0368c
                public void qj() {
                    i.this.hoK.setSwipeBackEnabled(false);
                    i.this.hEL = false;
                    i.this.hEI = i.this.aBz().getHeight();
                }
            });
            this.fee.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bPn() {
                    if (i.this.hoK != null && i.this.hEu != null && !StringUtils.isNull(i.this.hEu.getId())) {
                        i.this.hoK.zJ(i.this.hEu.getId());
                        if (i.this.hEt != null) {
                            long j = 0;
                            if (i.this.hEt.ZY() != null) {
                                j = i.this.hEt.ZY().channelId;
                            }
                            TiebaStatic.log(new am("c11921").k(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fee.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void oq(boolean z) {
                    if (i.this.hEt != null) {
                        long j = 0;
                        if (i.this.hEt.ZY() != null) {
                            j = i.this.hEt.ZY().channelId;
                        }
                        i.this.vb(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").bJ("tid", i.this.hEt.getTid()).k(ImageViewerConfig.FORUM_ID, i.this.hEt.getFid()).k(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fee.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bNo);
                    return true;
                }
            });
            this.fee.setThumbnail(videoInfo.thumbnail_url);
            this.fee.setVideoUrl(this.bNo, bgVar.getTid());
            this.fee.setFid(str);
            this.fee.AN(bgVar.getTitle());
            this.fee.a(hEV);
            this.fee.bnN();
            this.fee.show();
        }
    }

    public void Ap(String str) {
        if (this.hEq != null) {
            this.hEq.ekN = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.hEr != null) {
            this.hEr.a(postData, bgVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.hEK = dVar;
    }

    public void aD(bg bgVar) {
        this.hEu = bgVar;
    }

    public void Aq(String str) {
        this.hEv = str;
        if (this.fee != null) {
            this.fee.Aq(this.hEv);
        }
    }

    public void startPlay() {
        if (this.fee != null) {
            if (com.baidu.adp.lib.util.j.la() && !this.hEQ && !com.baidu.tieba.video.g.ciN().ciO()) {
                this.hEH.setVisibility(0);
                this.hEH.setData(this.hEp);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bNo) && this.hEt != null && this.hEt.Zf() != null) {
                TiebaStatic.log(new am("c12619").bJ("obj_locate", "pb").bJ("tid", this.hEt.getTid()));
                this.bNo = this.hEt.Zf().video_url;
            }
            this.fee.h(this.bNo, this.hEt == null ? "" : this.hEt.getTid(), this.hEG);
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
        if (this.hEn != null) {
            this.hEn.clearAnimation();
        }
        if (this.hEr != null) {
            this.hEr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.fee != null) {
            if (this.fee.ql()) {
                this.hEw = true;
                this.fee.stopPlay();
            } else if (this.fee.getCurrentState() == 3) {
                this.hEw = false;
            } else if (this.fee.getCurrentState() == 0 || this.fee.getCurrentState() == 1) {
                this.hEw = true;
                this.fee.stopPlay();
            } else {
                this.hEw = false;
                this.fee.stopPlay();
            }
            if (this.hEM != null) {
                this.hEM.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fee != null && this.hEw) {
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
                    ImageView imageView = new ImageView(i.this.hoK.getActivity());
                    if (i.this.hEP == null) {
                        try {
                            i.this.hEP = BitmapFactory.decodeResource(i.this.hoK.getResources(), d.f.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.hEP);
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
                    i.this.hEO = null;
                    if (i.this.hEP != null && !i.this.hEP.isRecycled()) {
                        i.this.hEP.recycle();
                    }
                    i.this.hEP = null;
                }
            });
            this.hEO = dVar.iT();
            this.hEO.o(this.hoK.getActivity());
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
        if (this.hEp != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.hEp.video_md5, "", str, this.hEq);
            }
        }
    }

    public void bPf() {
        if (this.hEm != null) {
            this.hEm.oh(this.hoK.bIN());
        }
    }

    public void bNW() {
        if (this.hEm != null) {
            this.hEm.bNW();
        }
    }

    public void wC(int i) {
        if (this.hEm != null) {
            this.hEm.wC(i);
        }
        if (this.hEM != null) {
            this.hEM.onChangeSkinType(i);
        }
        if (this.hEr != null) {
            this.hEr.ii(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bPi()) {
                    this.hEz = i;
                    if (this.hEz == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEn.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.hES = false;
                    if (this.hEE != aBz().getHeight()) {
                        this.hEn.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hoK.getActivity()), Math.min(this.hEE, aBz().getHeight() + i)));
                        this.fee.bAD();
                    }
                } else if (l.aO(this.hoK.getActivity()) * 0.5625d != aBz().getHeight()) {
                    this.hEn.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.hoK.getActivity()), (int) Math.max(l.aO(this.hoK.getActivity()) * 0.5625d, aBz().getHeight() + i)));
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
                wH((-this.hEE) + 2);
            }
        }
        if (!bPi() && this.hEL) {
            if (this.hEz == 1) {
                this.hER = true;
                wI(aBz().getHeight());
            } else if (this.hEz == 2) {
                this.hER = true;
                int y = (int) aBz().getY();
                if (this.hEA == y) {
                    wI(aBz().getHeight());
                } else {
                    this.hEA = y;
                    wI(aBz().getHeight());
                }
                if (i == 0 && this.hED) {
                    this.hED = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bPd();
                        }
                    }, 100L);
                }
            } else if (this.hEz == 0) {
                if (this.hER || !"nani_midpage".equals(this.hoK.bJl())) {
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
        this.hES = z;
    }

    private void wJ(int i) {
        if (this.hEr != null) {
            if (i == 0) {
                i = this.hEE;
            }
            float f = this.hEE - i;
            float f2 = f > this.hEB ? 0.0f : 1.0f - (f / this.hEB);
            if (this.hES) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.hEr.bOX().setVisibility(8);
            } else {
                this.hEr.bOX().setVisibility(0);
            }
            this.hEr.aJ(f2);
        }
    }

    public void bPg() {
        if (this.hEr != null) {
            if (bPi()) {
                this.hoK.bJn().bNg();
            } else if (this.hEr.bOX().getVisibility() == 0) {
                this.hoK.bJn().bNg();
                this.hEs = true;
            } else if (this.hEs) {
                this.hoK.bJn().nU(false);
                this.hEs = false;
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
        this.hEy = false;
        if (this.fee != null && this.hEn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEn.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fwR != null && this.fwR.isShowing()) {
                    this.fwR.sY();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.hEO != null) {
                    this.hEO.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.hEy = true;
                this.hEn.setLayoutParams(layoutParams);
                this.hoK.bJn().bNg();
                this.hEs = true;
            } else {
                e(this.hEp);
                bPf();
                this.hEy = false;
                this.hEm.og(true);
            }
            this.fee.a(this.hoK.getPageContext(), configuration);
        }
    }

    public boolean bPi() {
        return this.hEy;
    }

    public void s(long j, int i) {
        if (this.hEr != null && j > 0) {
            this.hEr.o(i, j);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.hEr != null) {
            this.hEr.N(onClickListener);
        }
    }

    public View aBz() {
        return this.hEl;
    }

    public boolean bNp() {
        if (aBz() == null) {
            return false;
        }
        return aBz().getBottom() > l.aQ(aBz().getContext()) - l.h(aBz().getContext(), d.e.ds50);
    }

    public void bPj() {
        this.hED = true;
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
