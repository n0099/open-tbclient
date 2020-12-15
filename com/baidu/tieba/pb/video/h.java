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
import com.alibaba.fastjson.asm.Opcodes;
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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes22.dex */
public class h {
    private static VideoControllerView.a kWr = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bMJ() {
        }
    };
    private static c.i lZU = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cFc() {
        }
    };
    private boolean agX;
    private com.baidu.tieba.play.c jae;
    private com.baidu.mcn.c jyZ;
    private PbFragment lDI;
    private float lZA;
    private int lZD;
    private double lZE;
    private long lZF;
    private PbVideoWifiTipLayout lZG;
    private int lZH;
    private c.d lZJ;
    private PbFullScreenFloatingHuajiAninationView lZL;
    private com.baidu.adp.lib.guide.c lZN;
    private Bitmap lZO;
    private boolean lZP;
    private boolean lZR;
    private int lZT;
    private RelativeLayout lZk;
    private com.baidu.tieba.pb.pb.main.view.c lZl;
    private CustomFrameLayout lZm;
    private c.d lZn;
    private o lZp;
    private f lZq;
    private boolean lZr;
    private by lZs;
    private by lZt;
    private String lZu;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo lZo = null;
    private boolean lZv = false;
    private int lZw = 0;
    private boolean lZx = false;
    private int lZy = 0;
    private int lZz = 0;
    private boolean lZB = false;
    private boolean lZC = false;
    private long startPosition = -1;
    private int izV = 0;
    private c.p lZI = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void dvw() {
            if (h.this.lDI != null && h.this.lDI.dol() != null && h.this.lDI.dol().getPbData() != null) {
                PostData dnd = h.this.lDI.dol().getPbData().dnd();
                if (dnd == null && y.getCount(h.this.lDI.dol().getPbData().dmW()) > 1) {
                    dnd = (PostData) y.getItem(h.this.lDI.dol().getPbData().dmW(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.lDI.dol().getPbData(), dnd, 1, 1, 4);
            }
        }
    };
    private boolean lZK = true;
    private PbFullScreenFloatingHuajiAninationView.a lZM = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.vW(false);
        }
    };
    private boolean lZQ = false;
    private c.m lZS = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dvy() {
            if (h.this.lZE >= 1.0d) {
                if (h.this.lDI.checkUpIsLogin()) {
                    h.this.lDI.dpM();
                    if (h.this.lDI.dol() == null || h.this.lDI.dol().getPbData() == null || h.this.lDI.dol().getPbData().dnu() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dnu = h.this.lDI.dol().getPbData().dnu();
                    if (h.this.lZL == null) {
                        h.this.lZL = new PbFullScreenFloatingHuajiAninationView(h.this.lDI.getActivity());
                        h.this.lZL.setFloatingHuajiAninationListener(h.this.lZM);
                    }
                    h.this.lZL.wm(dnu.dnP() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dvz() {
            return false;
        }
    };
    private CustomMessageListener PN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.jae != null) {
                    h.this.jae.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.jae != null && h.this.jae.rM() && h.this.lZo != null && h.this.lZo.video_length.intValue() > 0 && h.this.lZo.video_duration.intValue() > 0) {
                    float intValue = h.this.lZo.video_length.intValue() * (1.0f - ((h.this.jae.getCurrentPosition() * 1.0f) / (h.this.lZo.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.lDI.getPageContext().getPageActivity(), String.format(h.this.lDI.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kUu = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.due();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.lZo != null) {
                h.this.f(h.this.lZo);
                h.this.jae.dBJ();
                h.this.jae.dew();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.lZD;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(boolean z) {
        if (this.lDI != null) {
            this.lDI.dpe();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.lZA = 0.0f;
        this.lDI = pbFragment;
        this.lZl = cVar;
        this.lZA = l.getDimens(this.lDI.getActivity(), R.dimen.ds240);
        this.lZF = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.PN);
        this.iUM.setTag(pbFragment.getUniqueId());
        this.iUM.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iUM);
        this.jyZ = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lZm.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lDI.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lDI.getActivity());
        Rect visibilityRegion = bg.getVisibilityRegion(this.lDI.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lDI.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.lZE = (intValue2 * 1.0d) / intValue;
            if (this.lZE > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.lZD = i;
        this.lZm.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean cak() {
        return this.lZE >= 1.0d;
    }

    public int dtJ() {
        return this.lZD;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lZk = (RelativeLayout) LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lZm = (CustomFrameLayout) this.lZk.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.agX = ((double) this.lZD) <= (((double) l.getEquipmentWidth(this.lDI.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.jae = new com.baidu.tieba.play.c(this.lDI.getPageContext(), this.lZm, true);
        this.jae.setStageType("2002");
        this.jae.a(this.lZS);
        this.jae.wY(false);
        this.jae.a(this.lZI);
        this.jae.ID(ap.pS(R.drawable.pic_use_header_40_n));
        this.jae.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lDI.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lDI.getBaseFragmentActivity())) {
            this.jae.wP(false);
        }
        this.jae.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        h.this.mLastY = motionEvent.getY();
                        if (h.this.lDI.getListView() != null && h.this.lDI.getListView().getChildCount() > 0 && h.this.lDI.getListView().getChildAt(0) == h.this.dvv()) {
                            h.this.lZT = h.this.dvv().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.lZT = 0;
                        break;
                    case 2:
                        if (h.this.lDI.getListView() != null && h.this.lDI.getListView().getChildCount() > 0 && h.this.lDI.getListView().getChildAt(0) == h.this.dvv()) {
                            h.this.lDI.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.lZT);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.lZE >= 1.0d) {
                this.jae.av(false, true);
            } else {
                this.jae.av(true, false);
            }
            this.lZB = ((float) f) + this.lZA > ((float) l.getEquipmentHeight(this.lDI.getActivity()));
            if (this.lZB) {
                if (this.lZq == null) {
                    this.lZq = new f(this.lDI.getPageContext(), this.lZm);
                }
                this.lDI.dpc().dtb();
                this.lZr = true;
            }
        }
        dvq();
        this.mEmptyView = new View(this.lDI.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.lZD));
        if (this.lZl != null && this.lZl.mNavigationBar != null) {
            this.lZl.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lZl.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lZl.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bsY() && !TbSingleton.getInstance().isNotchScreen(this.lDI.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lDI.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.lZG = (PbVideoWifiTipLayout) this.lZk.findViewById(R.id.layout_wifi_tip);
        this.lZG.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.lZP = true;
                h.this.lZG.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jyZ != null) {
            this.jyZ.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lDI.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lZn == null) {
            this.lZn = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void qu(boolean z) {
                    if (h.this.dvt() && h.this.lZl != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.lZl.dtW().clearAnimation();
                        h.this.dvr();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.kUu);
                            h.this.lZl.dtW().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cFb() {
                    if (h.this.dvt()) {
                        h.this.due();
                    }
                }
            };
        }
        a(this.lZn);
        this.lZw = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lDI.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final by byVar, final String str) {
        if (videoInfo != null && this.jae != null && byVar != null) {
            this.lZo = videoInfo;
            this.lZs = byVar;
            this.mVideoUrl = videoInfo.video_url;
            this.jae.stopPlay();
            this.lZp = new o();
            this.lZp.mLocate = "pb";
            this.lZp.amY = byVar.getTid();
            this.lZp.fFV = str;
            this.lZp.mUid = TbadkCoreApplication.getCurrentAccount();
            if (byVar.isBjh()) {
                if (!StringUtils.isNull(this.lDI.lIz)) {
                    this.lZp.eGn = this.lDI.lIz;
                }
                this.lZp.mys = this.lDI.lIy + "";
            } else {
                this.lZp.mys = this.lDI.doZ();
            }
            bh dpO = this.lDI.dpO();
            if (dpO != null) {
                dpO.a(this.lZp);
            }
            this.lZp.myv = videoInfo.video_md5;
            o dCb = this.lZp.dCb();
            dCb.mLocate = "6";
            this.startPosition = -1L;
            if (this.jae.getVideoView() != null && this.jae.getVideoView().getMediaProgressObserver() != null) {
                this.jae.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ci(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean jK = com.baidu.mcn.b.abJ().jK(mcnAdInfo.jump_url);
                            if (h.this.agX && !jK && !h.this.lZx) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.jyZ.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.cbD = mcnAdInfo.card_title;
                                        aVar.cbE = mcnAdInfo.button_title;
                                        aVar.cbF = mcnAdInfo.jump_url;
                                        aVar.cbC = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = byVar.getTid();
                                        aVar.cbG = 4;
                                        if (z2) {
                                            h.this.jyZ.b(aVar, (ViewGroup) h.this.jae.dBI());
                                        } else {
                                            h.this.jyZ.a(aVar, (ViewGroup) h.this.jae.dBI());
                                        }
                                    }
                                } else if (h.this.jyZ.isShowing()) {
                                    h.this.jyZ.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.jae.getVideoView().setVideoStatData(dCb);
            if (this.jae.dey()) {
                this.jae.dew();
            }
            this.jae.b(this.lZJ);
            this.lZu = null;
            this.lZt = null;
            this.jae.QO(this.lZu);
            this.jae.des().setOnDragingListener(kWr);
            this.jae.a(new c.InterfaceC0845c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rL() {
                    h.this.lDI.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.lZH > 0) {
                                h.this.HM(h.this.lZH);
                                h.this.HN(h.this.lZH);
                                h.this.lZH = 0;
                            }
                            h.this.lZK = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0845c
                public void rK() {
                    h.this.lDI.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.lZK = false;
                    h.this.lZH = h.this.bSt().getHeight();
                }
            });
            this.jae.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dvx() {
                    if (h.this.lDI != null && h.this.lZt != null && !StringUtils.isNull(h.this.lZt.getId())) {
                        h.this.lDI.Qd(h.this.lZt.getId());
                    }
                }
            });
            this.jae.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void vX(boolean z) {
                    if (h.this.lZs != null) {
                        h.this.KN(z ? "1" : "2");
                    }
                }
            });
            this.jae.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.jae.setThumbnail(videoInfo.thumbnail_url);
            this.jae.setVideoUrl(this.mVideoUrl, byVar.getTid());
            this.jae.setFid(str);
            this.jae.Rn(byVar.getTitle());
            this.jae.a(lZU);
            this.jae.cRp();
            this.jae.show();
        }
    }

    public void QN(String str) {
        if (this.lZp != null) {
            this.lZp.fFV = str;
        }
    }

    public void b(PostData postData, by byVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lZq != null) {
            this.lZq.a(postData, byVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.lZJ = dVar;
    }

    public void aO(by byVar) {
        this.lZt = byVar;
    }

    public void QO(String str) {
        this.lZu = str;
        if (this.jae != null) {
            this.jae.QO(this.lZu);
        }
    }

    public void startPlay() {
        if (this.jae != null) {
            if (j.isMobileNet() && !this.lZP && !com.baidu.tieba.video.g.dTM().dTN()) {
                this.lZG.setVisibility(0);
                this.lZG.setData(this.lZo);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lZs != null && this.lZs.bph() != null) {
                TiebaStatic.log(new ar("c12619").dY("obj_locate", "pb").dY("tid", this.lZs.getTid()));
                this.mVideoUrl = this.lZs.bph().video_url;
            }
            this.jae.gb(this.mVideoUrl, this.lZs == null ? "" : this.lZs.getTid());
            KN("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dvp() {
        if (this.jae != null) {
            this.jae.dvp();
        }
    }

    public void destroy() {
        if (this.jae != null) {
            this.jae.destroy();
        }
        if (this.lZm != null) {
            this.lZm.clearAnimation();
        }
        if (this.lZq != null) {
            this.lZq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.PN);
        MessageManager.getInstance().unRegisterListener(this.iUM);
    }

    public void onPause() {
        if (this.jae != null) {
            if (this.jae.rM()) {
                this.lZv = true;
                this.jae.stopPlay();
            } else if (this.jae.getCurrentState() == 3) {
                this.lZv = false;
            } else if (this.jae.getCurrentState() == 0 || this.jae.getCurrentState() == 1) {
                this.lZv = true;
                this.jae.stopPlay();
            } else {
                this.lZv = false;
                this.jae.stopPlay();
            }
            if (this.lZL != null) {
                this.lZL.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.jae != null && this.lZv) {
            this.jae.dBv();
        }
    }

    private void dvq() {
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ac(true);
            dVar.ae(false);
            dVar.ao(16908290).an(Opcodes.IFEQ).ad(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.lDI.getActivity());
                    if (h.this.lZO == null) {
                        try {
                            h.this.lZO = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.lZO);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getAnchor() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getFitPosition() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.h.8
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    h.this.lZN = null;
                    if (h.this.lZO != null && !h.this.lZO.isRecycled()) {
                        h.this.lZO.recycle();
                    }
                    h.this.lZO = null;
                }
            });
            this.lZN = dVar.mi();
            this.lZN.showOnDecorView(this.lDI.getActivity());
        }
    }

    public boolean Ap(int i) {
        if (this.jae == null) {
            return false;
        }
        return this.jae.IF(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN(String str) {
        if (this.lZo != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.lZo.video_md5, "", str, this.lZp, this.jae.getVideoView().getPcdnState());
            }
        }
    }

    public void dvr() {
        if (this.lZl != null) {
            this.lZl.vN(this.lDI.dod());
        }
    }

    public void due() {
        if (this.lZl != null) {
            this.lZl.due();
        }
    }

    public void Hz(int i) {
        if (this.lZl != null) {
            this.lZl.Hz(i);
        }
        if (this.lZL != null) {
            this.lZL.onChangeSkinType(i);
        }
        if (this.lZq != null) {
            this.lZq.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dvu()) {
                    this.lZy = i;
                    if (this.lZy == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.HN(h.this.bSt().getHeight());
                            }
                        }, 100L);
                    }
                    dvs();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM(int i) {
        if (bSt().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZm.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.lZR = false;
                    if (this.lZD != bSt().getHeight()) {
                        this.lZm.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lDI.getActivity()), Math.min(this.lZD, bSt().getHeight() + i)));
                        this.jae.dew();
                    }
                } else if (l.getEquipmentWidth(this.lDI.getActivity()) * 0.5625d != bSt().getHeight()) {
                    this.lZm.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lDI.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lDI.getActivity()) * 0.5625d, bSt().getHeight() + i)));
                    this.jae.dew();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dvv()) {
                int bottom = childAt.getBottom() - bSt().getBottom();
                if (childAt.getHeight() == 0 || bSt().getHeight() == 0) {
                    bottom = 0;
                }
                HM(bottom);
            } else {
                HM((-this.lZD) + 2);
            }
        }
        if (!dvu() && this.lZK) {
            if (this.lZy == 1) {
                this.lZQ = true;
                HN(bSt().getHeight());
            } else if (this.lZy == 2) {
                this.lZQ = true;
                int y = (int) bSt().getY();
                if (this.lZz == y) {
                    HN(bSt().getHeight());
                } else {
                    this.lZz = y;
                    HN(bSt().getHeight());
                }
                if (i == 0 && this.lZC) {
                    this.lZC = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dvp();
                        }
                    }, 100L);
                }
            } else if (this.lZy == 0) {
                if (this.lZQ || !"nani_midpage".equals(this.lDI.doZ())) {
                    HN(bSt().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN(int i) {
        HO(i);
        dvs();
    }

    public void vz(boolean z) {
        this.lZR = z;
    }

    private void HO(int i) {
        if (this.lZq != null) {
            if (this.lZs != null && this.lZs.bnz()) {
                this.lZq.dvn().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.lZD;
            }
            float f = this.lZD - i;
            float f2 = f > this.lZA ? 0.0f : 1.0f - (f / this.lZA);
            if (this.lZR) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lZq.dvn().setVisibility(8);
            } else {
                this.lZq.dvn().setVisibility(0);
            }
            this.lZq.aP(f2);
        }
    }

    public void dvs() {
        if (this.lZq != null) {
            if (dvu()) {
                this.lDI.dpc().dtb();
            } else if (this.lZq.dvn().getVisibility() == 0) {
                this.lDI.dpc().dtb();
                this.lZr = true;
            } else if (this.lZr) {
                this.lDI.dpc().vy(false);
                this.lZr = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvt() {
        return bSt().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.lZx = false;
        if (this.jae != null && this.lZm != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZm.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jyZ != null && this.jyZ.isShowing()) {
                    this.jyZ.abK();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.lZN != null) {
                    this.lZN.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.lZx = true;
                this.lZm.setLayoutParams(layoutParams);
                this.lDI.dpc().dtb();
                this.lZr = true;
            } else {
                f(this.lZo);
                dvr();
                this.lZx = false;
                this.lZl.vM(true);
            }
            this.jae.a(this.lDI.getPageContext(), configuration);
        }
    }

    public boolean dvu() {
        return this.lZx;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lZq != null) {
            this.lZq.V(onClickListener);
        }
    }

    public View bSt() {
        return this.lZk;
    }

    public boolean dtk() {
        if (bSt() == null) {
            return false;
        }
        return bSt().getBottom() > l.getEquipmentHeight(bSt().getContext()) - l.getDimens(bSt().getContext(), R.dimen.ds50);
    }

    public void dtH() {
        this.lZC = true;
    }

    public View dvv() {
        return this.mEmptyView;
    }
}
