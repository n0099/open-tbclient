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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class h {
    private static VideoControllerView.a kIX = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bJa() {
        }
    };
    private static c.i lLU = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cAL() {
        }
    };
    private boolean afY;
    private com.baidu.tieba.play.c iPl;
    private com.baidu.mcn.c jlu;
    private float lLA;
    private int lLD;
    private double lLE;
    private long lLF;
    private PbVideoWifiTipLayout lLG;
    private int lLH;
    private c.d lLJ;
    private PbFullScreenFloatingHuajiAninationView lLL;
    private com.baidu.adp.lib.guide.c lLN;
    private Bitmap lLO;
    private boolean lLP;
    private boolean lLR;
    private int lLT;
    private RelativeLayout lLk;
    private com.baidu.tieba.pb.pb.main.view.c lLl;
    private CustomFrameLayout lLm;
    private c.d lLn;
    private o lLp;
    private f lLq;
    private boolean lLr;
    private bx lLs;
    private bx lLt;
    private String lLu;
    private PbFragment lpX;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo lLo = null;
    private boolean lLv = false;
    private int lLw = 0;
    private boolean lLx = false;
    private int lLy = 0;
    private int lLz = 0;
    private boolean lLB = false;
    private boolean lLC = false;
    private long startPosition = -1;
    private int ipb = 0;
    private c.p lLI = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void dqc() {
            if (h.this.lpX != null && h.this.lpX.diV() != null && h.this.lpX.diV().getPbData() != null) {
                PostData dhQ = h.this.lpX.diV().getPbData().dhQ();
                if (dhQ == null && y.getCount(h.this.lpX.diV().getPbData().dhJ()) > 1) {
                    dhQ = (PostData) y.getItem(h.this.lpX.diV().getPbData().dhJ(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.lpX.diV().getPbData(), dhQ, 1, 1, 4);
            }
        }
    };
    private boolean lLK = true;
    private PbFullScreenFloatingHuajiAninationView.a lLM = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.vt(false);
        }
    };
    private boolean lLQ = false;
    private c.m lLS = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dqe() {
            if (h.this.lLE >= 1.0d) {
                if (h.this.lpX.checkUpIsLogin()) {
                    h.this.lpX.dkw();
                    if (h.this.lpX.diV() == null || h.this.lpX.diV().getPbData() == null || h.this.lpX.diV().getPbData().dig() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dig = h.this.lpX.diV().getPbData().dig();
                    if (h.this.lLL == null) {
                        h.this.lLL = new PbFullScreenFloatingHuajiAninationView(h.this.lpX.getActivity());
                        h.this.lLL.setFloatingHuajiAninationListener(h.this.lLM);
                    }
                    h.this.lLL.vI(dig.diz() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dqf() {
            return false;
        }
    };
    private CustomMessageListener OQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.iPl != null) {
                    h.this.iPl.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.iPl != null && h.this.iPl.rK() && h.this.lLo != null && h.this.lLo.video_length.intValue() > 0 && h.this.lLo.video_duration.intValue() > 0) {
                    float intValue = h.this.lLo.video_length.intValue() * (1.0f - ((h.this.iPl.getCurrentPosition() * 1.0f) / (h.this.lLo.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.lpX.getPageContext().getPageActivity(), String.format(h.this.lpX.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kHa = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.doM();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener iJS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.lLo != null) {
                h.this.f(h.this.lLo);
                h.this.iPl.dwq();
                h.this.iPl.cZk();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.lLD;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(boolean z) {
        if (this.lpX != null) {
            this.lpX.djO();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.lLA = 0.0f;
        this.lpX = pbFragment;
        this.lLl = cVar;
        this.lLA = l.getDimens(this.lpX.getActivity(), R.dimen.ds240);
        this.lLF = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.OQ);
        this.iJS.setTag(pbFragment.getUniqueId());
        this.iJS.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iJS);
        this.jlu = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lLm.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lpX.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lpX.getActivity());
        Rect visibilityRegion = bg.getVisibilityRegion(this.lpX.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lpX.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.lLE = (intValue2 * 1.0d) / intValue;
            if (this.lLE > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.lLD = i;
        this.lLm.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bWv() {
        return this.lLE >= 1.0d;
    }

    public int dor() {
        return this.lLD;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lLk = (RelativeLayout) LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lLm = (CustomFrameLayout) this.lLk.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afY = ((double) this.lLD) <= (((double) l.getEquipmentWidth(this.lpX.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.iPl = new com.baidu.tieba.play.c(this.lpX.getPageContext(), this.lLm, true);
        this.iPl.setStageType("2002");
        this.iPl.a(this.lLS);
        this.iPl.wu(false);
        this.iPl.a(this.lLI);
        this.iPl.HM(ap.ps(R.drawable.pic_use_header_40_n));
        this.iPl.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lpX.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lpX.getBaseFragmentActivity())) {
            this.iPl.wl(false);
        }
        this.iPl.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.lpX.getListView() != null && h.this.lpX.getListView().getChildCount() > 0 && h.this.lpX.getListView().getChildAt(0) == h.this.dqb()) {
                            h.this.lLT = h.this.dqb().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.lLT = 0;
                        break;
                    case 2:
                        if (h.this.lpX.getListView() != null && h.this.lpX.getListView().getChildCount() > 0 && h.this.lpX.getListView().getChildAt(0) == h.this.dqb()) {
                            h.this.lpX.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.lLT);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.lLE >= 1.0d) {
                this.iPl.av(false, true);
            } else {
                this.iPl.av(true, false);
            }
            this.lLB = ((float) f) + this.lLA > ((float) l.getEquipmentHeight(this.lpX.getActivity()));
            if (this.lLB) {
                if (this.lLq == null) {
                    this.lLq = new f(this.lpX.getPageContext(), this.lLm);
                }
                this.lpX.djM().dnK();
                this.lLr = true;
            }
        }
        dpW();
        this.mEmptyView = new View(this.lpX.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.lLD));
        if (this.lLl != null && this.lLl.mNavigationBar != null) {
            this.lLl.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lLl.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lLl.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bpE() && !TbSingleton.getInstance().isNotchScreen(this.lpX.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lpX.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.lLG = (PbVideoWifiTipLayout) this.lLk.findViewById(R.id.layout_wifi_tip);
        this.lLG.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.lLP = true;
                h.this.lLG.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jlu != null) {
            this.jlu.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lpX.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lLn == null) {
            this.lLn = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void pX(boolean z) {
                    if (h.this.dpZ() && h.this.lLl != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.lLl.doE().clearAnimation();
                        h.this.dpX();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.kHa);
                            h.this.lLl.doE().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cAK() {
                    if (h.this.dpZ()) {
                        h.this.doM();
                    }
                }
            };
        }
        a(this.lLn);
        this.lLw = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lpX.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bx bxVar, final String str) {
        if (videoInfo != null && this.iPl != null && bxVar != null) {
            this.lLo = videoInfo;
            this.lLs = bxVar;
            this.mVideoUrl = videoInfo.video_url;
            this.iPl.stopPlay();
            this.lLp = new o();
            this.lLp.mLocate = "pb";
            this.lLp.alZ = bxVar.getTid();
            this.lLp.fyg = str;
            this.lLp.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bxVar.isBjh()) {
                if (!StringUtils.isNull(this.lpX.luK)) {
                    this.lLp.ezo = this.lpX.luK;
                }
                this.lLp.mkm = this.lpX.luJ + "";
            } else {
                this.lLp.mkm = this.lpX.djJ();
            }
            com.baidu.tbadk.core.data.bg dky = this.lpX.dky();
            if (dky != null) {
                dky.a(this.lLp);
            }
            this.lLp.mkp = videoInfo.video_md5;
            o dwI = this.lLp.dwI();
            dwI.mLocate = "6";
            this.startPosition = -1L;
            if (this.iPl.getVideoView() != null && this.iPl.getVideoView().getMediaProgressObserver() != null) {
                this.iPl.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ce(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean jg = com.baidu.mcn.b.Zg().jg(mcnAdInfo.jump_url);
                            if (h.this.afY && !jg && !h.this.lLx) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.jlu.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bWo = mcnAdInfo.card_title;
                                        aVar.bWp = mcnAdInfo.button_title;
                                        aVar.bWq = mcnAdInfo.jump_url;
                                        aVar.bWn = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bxVar.getTid();
                                        aVar.bWr = 4;
                                        if (z2) {
                                            h.this.jlu.b(aVar, (ViewGroup) h.this.iPl.dwp());
                                        } else {
                                            h.this.jlu.a(aVar, (ViewGroup) h.this.iPl.dwp());
                                        }
                                    }
                                } else if (h.this.jlu.isShowing()) {
                                    h.this.jlu.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.iPl.getVideoView().setVideoStatData(dwI);
            if (this.iPl.cZm()) {
                this.iPl.cZk();
            }
            this.iPl.b(this.lLJ);
            this.lLu = null;
            this.lLt = null;
            this.iPl.PF(this.lLu);
            this.iPl.cZg().setOnDragingListener(kIX);
            this.iPl.a(new c.InterfaceC0829c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rJ() {
                    h.this.lpX.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.lLH > 0) {
                                h.this.GV(h.this.lLH);
                                h.this.GW(h.this.lLH);
                                h.this.lLH = 0;
                            }
                            h.this.lLK = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0829c
                public void rI() {
                    h.this.lpX.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.lLK = false;
                    h.this.lLH = h.this.bOH().getHeight();
                }
            });
            this.iPl.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dqd() {
                    if (h.this.lpX != null && h.this.lLt != null && !StringUtils.isNull(h.this.lLt.getId())) {
                        h.this.lpX.OV(h.this.lLt.getId());
                    }
                }
            });
            this.iPl.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void vu(boolean z) {
                    if (h.this.lLs != null) {
                        h.this.JW(z ? "1" : "2");
                    }
                }
            });
            this.iPl.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.iPl.setThumbnail(videoInfo.thumbnail_url);
            this.iPl.setVideoUrl(this.mVideoUrl, bxVar.getTid());
            this.iPl.setFid(str);
            this.iPl.Qe(bxVar.getTitle());
            this.iPl.a(lLU);
            this.iPl.cMa();
            this.iPl.show();
        }
    }

    public void PE(String str) {
        if (this.lLp != null) {
            this.lLp.fyg = str;
        }
    }

    public void b(PostData postData, bx bxVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lLq != null) {
            this.lLq.a(postData, bxVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.lLJ = dVar;
    }

    public void aO(bx bxVar) {
        this.lLt = bxVar;
    }

    public void PF(String str) {
        this.lLu = str;
        if (this.iPl != null) {
            this.iPl.PF(this.lLu);
        }
    }

    public void startPlay() {
        if (this.iPl != null) {
            if (j.isMobileNet() && !this.lLP && !com.baidu.tieba.video.g.dOt().dOu()) {
                this.lLG.setVisibility(0);
                this.lLG.setData(this.lLo);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lLs != null && this.lLs.blU() != null) {
                TiebaStatic.log(new ar("c12619").dR("obj_locate", "pb").dR("tid", this.lLs.getTid()));
                this.mVideoUrl = this.lLs.blU().video_url;
            }
            this.iPl.fW(this.mVideoUrl, this.lLs == null ? "" : this.lLs.getTid());
            JW("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dpV() {
        if (this.iPl != null) {
            this.iPl.dpV();
        }
    }

    public void destroy() {
        if (this.iPl != null) {
            this.iPl.destroy();
        }
        if (this.lLm != null) {
            this.lLm.clearAnimation();
        }
        if (this.lLq != null) {
            this.lLq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.OQ);
        MessageManager.getInstance().unRegisterListener(this.iJS);
    }

    public void onPause() {
        if (this.iPl != null) {
            if (this.iPl.rK()) {
                this.lLv = true;
                this.iPl.stopPlay();
            } else if (this.iPl.getCurrentState() == 3) {
                this.lLv = false;
            } else if (this.iPl.getCurrentState() == 0 || this.iPl.getCurrentState() == 1) {
                this.lLv = true;
                this.iPl.stopPlay();
            } else {
                this.lLv = false;
                this.iPl.stopPlay();
            }
            if (this.lLL != null) {
                this.lLL.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.iPl != null && this.lLv) {
            this.iPl.dwc();
        }
    }

    private void dpW() {
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.al(16908290).ak(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.lpX.getActivity());
                    if (h.this.lLO == null) {
                        try {
                            h.this.lLO = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.lLO);
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
                    h.this.lLN = null;
                    if (h.this.lLO != null && !h.this.lLO.isRecycled()) {
                        h.this.lLO.recycle();
                    }
                    h.this.lLO = null;
                }
            });
            this.lLN = dVar.mi();
            this.lLN.showOnDecorView(this.lpX.getActivity());
        }
    }

    public boolean zK(int i) {
        if (this.iPl == null) {
            return false;
        }
        return this.iPl.HO(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW(String str) {
        if (this.lLo != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.lLo.video_md5, "", str, this.lLp, this.iPl.getVideoView().getPcdnState());
            }
        }
    }

    public void dpX() {
        if (this.lLl != null) {
            this.lLl.vk(this.lpX.diN());
        }
    }

    public void doM() {
        if (this.lLl != null) {
            this.lLl.doM();
        }
    }

    public void GJ(int i) {
        if (this.lLl != null) {
            this.lLl.GJ(i);
        }
        if (this.lLL != null) {
            this.lLL.onChangeSkinType(i);
        }
        if (this.lLq != null) {
            this.lLq.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dqa()) {
                    this.lLy = i;
                    if (this.lLy == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.GW(h.this.bOH().getHeight());
                            }
                        }, 100L);
                    }
                    dpY();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV(int i) {
        if (bOH().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lLm.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.lLR = false;
                    if (this.lLD != bOH().getHeight()) {
                        this.lLm.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lpX.getActivity()), Math.min(this.lLD, bOH().getHeight() + i)));
                        this.iPl.cZk();
                    }
                } else if (l.getEquipmentWidth(this.lpX.getActivity()) * 0.5625d != bOH().getHeight()) {
                    this.lLm.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lpX.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lpX.getActivity()) * 0.5625d, bOH().getHeight() + i)));
                    this.iPl.cZk();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dqb()) {
                int bottom = childAt.getBottom() - bOH().getBottom();
                if (childAt.getHeight() == 0 || bOH().getHeight() == 0) {
                    bottom = 0;
                }
                GV(bottom);
            } else {
                GV((-this.lLD) + 2);
            }
        }
        if (!dqa() && this.lLK) {
            if (this.lLy == 1) {
                this.lLQ = true;
                GW(bOH().getHeight());
            } else if (this.lLy == 2) {
                this.lLQ = true;
                int y = (int) bOH().getY();
                if (this.lLz == y) {
                    GW(bOH().getHeight());
                } else {
                    this.lLz = y;
                    GW(bOH().getHeight());
                }
                if (i == 0 && this.lLC) {
                    this.lLC = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dpV();
                        }
                    }, 100L);
                }
            } else if (this.lLy == 0) {
                if (this.lLQ || !"nani_midpage".equals(this.lpX.djJ())) {
                    GW(bOH().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW(int i) {
        GX(i);
        dpY();
    }

    public void uW(boolean z) {
        this.lLR = z;
    }

    private void GX(int i) {
        if (this.lLq != null) {
            if (this.lLs != null && this.lLs.bkm()) {
                this.lLq.dpT().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.lLD;
            }
            float f = this.lLD - i;
            float f2 = f > this.lLA ? 0.0f : 1.0f - (f / this.lLA);
            if (this.lLR) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lLq.dpT().setVisibility(8);
            } else {
                this.lLq.dpT().setVisibility(0);
            }
            this.lLq.aO(f2);
        }
    }

    public void dpY() {
        if (this.lLq != null) {
            if (dqa()) {
                this.lpX.djM().dnK();
            } else if (this.lLq.dpT().getVisibility() == 0) {
                this.lpX.djM().dnK();
                this.lLr = true;
            } else if (this.lLr) {
                this.lpX.djM().uV(false);
                this.lLr = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpZ() {
        return bOH().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.lLx = false;
        if (this.iPl != null && this.lLm != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lLm.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jlu != null && this.jlu.isShowing()) {
                    this.jlu.Zh();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.lLN != null) {
                    this.lLN.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.lLx = true;
                this.lLm.setLayoutParams(layoutParams);
                this.lpX.djM().dnK();
                this.lLr = true;
            } else {
                f(this.lLo);
                dpX();
                this.lLx = false;
                this.lLl.vj(true);
            }
            this.iPl.a(this.lpX.getPageContext(), configuration);
        }
    }

    public boolean dqa() {
        return this.lLx;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lLq != null) {
            this.lLq.V(onClickListener);
        }
    }

    public View bOH() {
        return this.lLk;
    }

    public boolean dnT() {
        if (bOH() == null) {
            return false;
        }
        return bOH().getBottom() > l.getEquipmentHeight(bOH().getContext()) - l.getDimens(bOH().getContext(), R.dimen.ds50);
    }

    public void dop() {
        this.lLC = true;
    }

    public View dqb() {
        return this.mEmptyView;
    }
}
