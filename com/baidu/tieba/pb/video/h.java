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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bf;
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
    private static VideoControllerView.a kII = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bJH() {
        }
    };
    private static c.i lLC = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cBi() {
        }
    };
    private boolean afT;
    private com.baidu.tieba.play.c iOy;
    private com.baidu.mcn.c jkK;
    private RelativeLayout lKS;
    private com.baidu.tieba.pb.pb.main.view.c lKT;
    private CustomFrameLayout lKU;
    private c.d lKV;
    private o lKX;
    private f lKY;
    private boolean lKZ;
    private int lLB;
    private bw lLa;
    private bw lLb;
    private String lLc;
    private float lLi;
    private int lLl;
    private double lLm;
    private long lLn;
    private PbVideoWifiTipLayout lLo;
    private int lLp;
    private c.d lLr;
    private PbFullScreenFloatingHuajiAninationView lLt;
    private com.baidu.adp.lib.guide.c lLv;
    private Bitmap lLw;
    private boolean lLx;
    private boolean lLz;
    private PbFragment lpI;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo lKW = null;
    private boolean lLd = false;
    private int lLe = 0;
    private boolean lLf = false;
    private int lLg = 0;
    private int lLh = 0;
    private boolean lLj = false;
    private boolean lLk = false;
    private long startPosition = -1;
    private int ion = 0;
    private c.p lLq = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void dqC() {
            if (h.this.lpI != null && h.this.lpI.djz() != null && h.this.lpI.djz().getPbData() != null) {
                PostData dit = h.this.lpI.djz().getPbData().dit();
                if (dit == null && y.getCount(h.this.lpI.djz().getPbData().dim()) > 1) {
                    dit = (PostData) y.getItem(h.this.lpI.djz().getPbData().dim(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.lpI.djz().getPbData(), dit, 1, 1, 4);
            }
        }
    };
    private boolean lLs = true;
    private PbFullScreenFloatingHuajiAninationView.a lLu = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.vq(false);
        }
    };
    private boolean lLy = false;
    private c.m lLA = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean dqE() {
            if (h.this.lLm >= 1.0d) {
                if (h.this.lpI.checkUpIsLogin()) {
                    h.this.lpI.dkZ();
                    if (h.this.lpI.djz() == null || h.this.lpI.djz().getPbData() == null || h.this.lpI.djz().getPbData().diJ() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o diJ = h.this.lpI.djz().getPbData().diJ();
                    if (h.this.lLt == null) {
                        h.this.lLt = new PbFullScreenFloatingHuajiAninationView(h.this.lpI.getActivity());
                        h.this.lLt.setFloatingHuajiAninationListener(h.this.lLu);
                    }
                    h.this.lLt.vF(diJ.djc() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dqF() {
            return false;
        }
    };
    private CustomMessageListener OQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.iOy != null) {
                    h.this.iOy.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.iOy != null && h.this.iOy.rK() && h.this.lKW != null && h.this.lKW.video_length.intValue() > 0 && h.this.lKW.video_duration.intValue() > 0) {
                    float intValue = h.this.lKW.video_length.intValue() * (1.0f - ((h.this.iOy.getCurrentPosition() * 1.0f) / (h.this.lKW.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.lpI.getPageContext().getPageActivity(), String.format(h.this.lpI.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kGL = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.dpm();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.lKW != null) {
                h.this.f(h.this.lKW);
                h.this.iOy.dwQ();
                h.this.iOy.cZO();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.lLl;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(boolean z) {
        if (this.lpI != null) {
            this.lpI.dkr();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.lLi = 0.0f;
        this.lpI = pbFragment;
        this.lKT = cVar;
        this.lLi = l.getDimens(this.lpI.getActivity(), R.dimen.ds240);
        this.lLn = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.OQ);
        this.iJe.setTag(pbFragment.getUniqueId());
        this.iJe.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iJe);
        this.jkK = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lKU.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.lpI.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.lpI.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.lpI.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.lpI.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.lLm = (intValue2 * 1.0d) / intValue;
            if (this.lLm > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.lLl = i;
        this.lKU.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bXc() {
        return this.lLm >= 1.0d;
    }

    public int doS() {
        return this.lLl;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lKS = (RelativeLayout) LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lKU = (CustomFrameLayout) this.lKS.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afT = ((double) this.lLl) <= (((double) l.getEquipmentWidth(this.lpI.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.iOy = new com.baidu.tieba.play.c(this.lpI.getPageContext(), this.lKU, true);
        this.iOy.setStageType("2002");
        this.iOy.a(this.lLA);
        this.iOy.wr(false);
        this.iOy.a(this.lLq);
        this.iOy.Ho(ap.oW(R.drawable.pic_use_header_60_n));
        this.iOy.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.lpI.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.lpI.getBaseFragmentActivity())) {
            this.iOy.wi(false);
        }
        this.iOy.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.lpI.getListView() != null && h.this.lpI.getListView().getChildCount() > 0 && h.this.lpI.getListView().getChildAt(0) == h.this.dqB()) {
                            h.this.lLB = h.this.dqB().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.lLB = 0;
                        break;
                    case 2:
                        if (h.this.lpI.getListView() != null && h.this.lpI.getListView().getChildCount() > 0 && h.this.lpI.getListView().getChildAt(0) == h.this.dqB()) {
                            h.this.lpI.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.lLB);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.lLm >= 1.0d) {
                this.iOy.ay(false, true);
            } else {
                this.iOy.ay(true, false);
            }
            this.lLj = ((float) f) + this.lLi > ((float) l.getEquipmentHeight(this.lpI.getActivity()));
            if (this.lLj) {
                if (this.lKY == null) {
                    this.lKY = new f(this.lpI.getPageContext(), this.lKU);
                }
                this.lpI.dkp().dol();
                this.lKZ = true;
            }
        }
        dqw();
        this.mEmptyView = new View(this.lpI.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.lLl));
        if (this.lKT != null && this.lKT.mNavigationBar != null) {
            this.lKT.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lKT.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lKT.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bqr() && !TbSingleton.getInstance().isNotchScreen(this.lpI.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lpI.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.lLo = (PbVideoWifiTipLayout) this.lKS.findViewById(R.id.layout_wifi_tip);
        this.lLo.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.lLx = true;
                h.this.lLo.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jkK != null) {
            this.jkK.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.lpI.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lKV == null) {
            this.lKV = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void pU(boolean z) {
                    if (h.this.dqz() && h.this.lKT != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.lKT.dpf().clearAnimation();
                        h.this.dqx();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.kGL);
                            h.this.lKT.dpf().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cBh() {
                    if (h.this.dqz()) {
                        h.this.dpm();
                    }
                }
            };
        }
        a(this.lKV);
        this.lLe = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.lpI.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bw bwVar, final String str) {
        if (videoInfo != null && this.iOy != null && bwVar != null) {
            this.lKW = videoInfo;
            this.lLa = bwVar;
            this.mVideoUrl = videoInfo.video_url;
            this.iOy.stopPlay();
            this.lKX = new o();
            this.lKX.mLocate = "pb";
            this.lKX.alT = bwVar.getTid();
            this.lKX.fyR = str;
            this.lKX.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.isBjh()) {
                if (!StringUtils.isNull(this.lpI.luu)) {
                    this.lKX.eAX = this.lpI.luu;
                }
                this.lKX.mjT = this.lpI.lut + "";
            } else {
                this.lKX.mjT = this.lpI.dkm();
            }
            com.baidu.tbadk.core.data.bf dlb = this.lpI.dlb();
            if (dlb != null) {
                dlb.a(this.lKX);
            }
            this.lKX.mjW = videoInfo.video_md5;
            o dxi = this.lKX.dxi();
            dxi.mLocate = "6";
            this.startPosition = -1L;
            if (this.iOy.getVideoView() != null && this.iOy.getVideoView().getMediaProgressObserver() != null) {
                this.iOy.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void ce(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean jm = com.baidu.mcn.b.ZP().jm(mcnAdInfo.jump_url);
                            if (h.this.afT && !jm && !h.this.lLf) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.jkK.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bXY = mcnAdInfo.card_title;
                                        aVar.bXZ = mcnAdInfo.button_title;
                                        aVar.bYa = mcnAdInfo.jump_url;
                                        aVar.bXX = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bwVar.getTid();
                                        aVar.bYb = 4;
                                        if (z2) {
                                            h.this.jkK.b(aVar, (ViewGroup) h.this.iOy.dwP());
                                        } else {
                                            h.this.jkK.a(aVar, (ViewGroup) h.this.iOy.dwP());
                                        }
                                    }
                                } else if (h.this.jkK.isShowing()) {
                                    h.this.jkK.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.iOy.getVideoView().setVideoStatData(dxi);
            if (this.iOy.cZQ()) {
                this.iOy.cZO();
            }
            this.iOy.b(this.lLr);
            this.lLc = null;
            this.lLb = null;
            this.iOy.Qj(this.lLc);
            this.iOy.cZK().setOnDragingListener(kII);
            this.iOy.a(new c.InterfaceC0827c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rJ() {
                    h.this.lpI.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.lLp > 0) {
                                h.this.Gx(h.this.lLp);
                                h.this.Gy(h.this.lLp);
                                h.this.lLp = 0;
                            }
                            h.this.lLs = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0827c
                public void rI() {
                    h.this.lpI.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.lLs = false;
                    h.this.lLp = h.this.bPo().getHeight();
                }
            });
            this.iOy.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dqD() {
                    if (h.this.lpI != null && h.this.lLb != null && !StringUtils.isNull(h.this.lLb.getId())) {
                        h.this.lpI.Pz(h.this.lLb.getId());
                    }
                }
            });
            this.iOy.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void vr(boolean z) {
                    if (h.this.lLa != null) {
                        h.this.Kv(z ? "1" : "2");
                    }
                }
            });
            this.iOy.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.iOy.setThumbnail(videoInfo.thumbnail_url);
            this.iOy.setVideoUrl(this.mVideoUrl, bwVar.getTid());
            this.iOy.setFid(str);
            this.iOy.QJ(bwVar.getTitle());
            this.iOy.a(lLC);
            this.iOy.cMt();
            this.iOy.show();
        }
    }

    public void Qi(String str) {
        if (this.lKX != null) {
            this.lKX.fyR = str;
        }
    }

    public void b(PostData postData, bw bwVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lKY != null) {
            this.lKY.a(postData, bwVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.lLr = dVar;
    }

    public void aM(bw bwVar) {
        this.lLb = bwVar;
    }

    public void Qj(String str) {
        this.lLc = str;
        if (this.iOy != null) {
            this.iOy.Qj(this.lLc);
        }
    }

    public void startPlay() {
        if (this.iOy != null) {
            if (j.isMobileNet() && !this.lLx && !com.baidu.tieba.video.g.dOu().dOv()) {
                this.lLo.setVisibility(0);
                this.lLo.setData(this.lKW);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lLa != null && this.lLa.bmS() != null) {
                TiebaStatic.log(new aq("c12619").dR("obj_locate", "pb").dR("tid", this.lLa.getTid()));
                this.mVideoUrl = this.lLa.bmS().video_url;
            }
            this.iOy.fW(this.mVideoUrl, this.lLa == null ? "" : this.lLa.getTid());
            Kv("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dqv() {
        if (this.iOy != null) {
            this.iOy.dqv();
        }
    }

    public void destroy() {
        if (this.iOy != null) {
            this.iOy.destroy();
        }
        if (this.lKU != null) {
            this.lKU.clearAnimation();
        }
        if (this.lKY != null) {
            this.lKY.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.OQ);
        MessageManager.getInstance().unRegisterListener(this.iJe);
    }

    public void onPause() {
        if (this.iOy != null) {
            if (this.iOy.rK()) {
                this.lLd = true;
                this.iOy.stopPlay();
            } else if (this.iOy.getCurrentState() == 3) {
                this.lLd = false;
            } else if (this.iOy.getCurrentState() == 0 || this.iOy.getCurrentState() == 1) {
                this.lLd = true;
                this.iOy.stopPlay();
            } else {
                this.lLd = false;
                this.iOy.stopPlay();
            }
            if (this.lLt != null) {
                this.lLt.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.iOy != null && this.lLd) {
            this.iOy.dwC();
        }
    }

    private void dqw() {
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.al(16908290).ak(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.lpI.getActivity());
                    if (h.this.lLw == null) {
                        try {
                            h.this.lLw = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.lLw);
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
                    h.this.lLv = null;
                    if (h.this.lLw != null && !h.this.lLw.isRecycled()) {
                        h.this.lLw.recycle();
                    }
                    h.this.lLw = null;
                }
            });
            this.lLv = dVar.mi();
            this.lLv.showOnDecorView(this.lpI.getActivity());
        }
    }

    public boolean zm(int i) {
        if (this.iOy == null) {
            return false;
        }
        return this.iOy.Hq(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv(String str) {
        if (this.lKW != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.lKW.video_md5, "", str, this.lKX, this.iOy.getVideoView().getPcdnState());
            }
        }
    }

    public void dqx() {
        if (this.lKT != null) {
            this.lKT.vh(this.lpI.djq());
        }
    }

    public void dpm() {
        if (this.lKT != null) {
            this.lKT.dpm();
        }
    }

    public void Gl(int i) {
        if (this.lKT != null) {
            this.lKT.Gl(i);
        }
        if (this.lLt != null) {
            this.lLt.onChangeSkinType(i);
        }
        if (this.lKY != null) {
            this.lKY.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dqA()) {
                    this.lLg = i;
                    if (this.lLg == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.Gy(h.this.bPo().getHeight());
                            }
                        }, 100L);
                    }
                    dqy();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gx(int i) {
        if (bPo().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lKU.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.lLz = false;
                    if (this.lLl != bPo().getHeight()) {
                        this.lKU.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lpI.getActivity()), Math.min(this.lLl, bPo().getHeight() + i)));
                        this.iOy.cZO();
                    }
                } else if (l.getEquipmentWidth(this.lpI.getActivity()) * 0.5625d != bPo().getHeight()) {
                    this.lKU.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.lpI.getActivity()), (int) Math.max(l.getEquipmentWidth(this.lpI.getActivity()) * 0.5625d, bPo().getHeight() + i)));
                    this.iOy.cZO();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dqB()) {
                int bottom = childAt.getBottom() - bPo().getBottom();
                if (childAt.getHeight() == 0 || bPo().getHeight() == 0) {
                    bottom = 0;
                }
                Gx(bottom);
            } else {
                Gx((-this.lLl) + 2);
            }
        }
        if (!dqA() && this.lLs) {
            if (this.lLg == 1) {
                this.lLy = true;
                Gy(bPo().getHeight());
            } else if (this.lLg == 2) {
                this.lLy = true;
                int y = (int) bPo().getY();
                if (this.lLh == y) {
                    Gy(bPo().getHeight());
                } else {
                    this.lLh = y;
                    Gy(bPo().getHeight());
                }
                if (i == 0 && this.lLk) {
                    this.lLk = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dqv();
                        }
                    }, 100L);
                }
            } else if (this.lLg == 0) {
                if (this.lLy || !"nani_midpage".equals(this.lpI.dkm())) {
                    Gy(bPo().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gy(int i) {
        Gz(i);
        dqy();
    }

    public void uT(boolean z) {
        this.lLz = z;
    }

    private void Gz(int i) {
        if (this.lKY != null) {
            if (this.lLa != null && this.lLa.blk()) {
                this.lKY.dqt().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.lLl;
            }
            float f = this.lLl - i;
            float f2 = f > this.lLi ? 0.0f : 1.0f - (f / this.lLi);
            if (this.lLz) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lKY.dqt().setVisibility(8);
            } else {
                this.lKY.dqt().setVisibility(0);
            }
            this.lKY.aH(f2);
        }
    }

    public void dqy() {
        if (this.lKY != null) {
            if (dqA()) {
                this.lpI.dkp().dol();
            } else if (this.lKY.dqt().getVisibility() == 0) {
                this.lpI.dkp().dol();
                this.lKZ = true;
            } else if (this.lKZ) {
                this.lpI.dkp().uS(false);
                this.lKZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dqz() {
        return bPo().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.lLf = false;
        if (this.iOy != null && this.lKU != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lKU.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jkK != null && this.jkK.isShowing()) {
                    this.jkK.ZQ();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.lLv != null) {
                    this.lLv.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.lLf = true;
                this.lKU.setLayoutParams(layoutParams);
                this.lpI.dkp().dol();
                this.lKZ = true;
            } else {
                f(this.lKW);
                dqx();
                this.lLf = false;
                this.lKT.vg(true);
            }
            this.iOy.a(this.lpI.getPageContext(), configuration);
        }
    }

    public boolean dqA() {
        return this.lLf;
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.lKY != null) {
            this.lKY.W(onClickListener);
        }
    }

    public View bPo() {
        return this.lKS;
    }

    public boolean dou() {
        if (bPo() == null) {
            return false;
        }
        return bPo().getBottom() > l.getEquipmentHeight(bPo().getContext()) - l.getDimens(bPo().getContext(), R.dimen.ds50);
    }

    public void doQ() {
        this.lLk = true;
    }

    public View dqB() {
        return this.mEmptyView;
    }
}
