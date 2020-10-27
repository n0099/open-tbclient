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
    private static VideoControllerView.a kCO = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.h.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void bHi() {
        }
    };
    private static c.i lFG = new c.i() { // from class: com.baidu.tieba.pb.video.h.10
        @Override // com.baidu.tieba.play.c.i
        public void cyH() {
        }
    };
    private boolean afT;
    private com.baidu.tieba.play.c iIB;
    private com.baidu.mcn.c jeM;
    private RelativeLayout lEW;
    private com.baidu.tieba.pb.pb.main.view.c lEX;
    private CustomFrameLayout lEY;
    private c.d lEZ;
    private Bitmap lFA;
    private boolean lFB;
    private boolean lFD;
    private int lFF;
    private o lFb;
    private f lFc;
    private boolean lFd;
    private bw lFe;
    private bw lFf;
    private String lFg;
    private float lFm;
    private int lFp;
    private double lFq;
    private long lFr;
    private PbVideoWifiTipLayout lFs;
    private int lFt;
    private c.d lFv;
    private PbFullScreenFloatingHuajiAninationView lFx;
    private com.baidu.adp.lib.guide.c lFz;
    private PbFragment ljH;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String mVideoUrl = null;
    private VideoInfo lFa = null;
    private boolean lFh = false;
    private int lFi = 0;
    private boolean lFj = false;
    private int lFk = 0;
    private int lFl = 0;
    private boolean lFn = false;
    private boolean lFo = false;
    private long startPosition = -1;
    private int iio = 0;
    private c.p lFu = new c.p() { // from class: com.baidu.tieba.pb.video.h.1
        @Override // com.baidu.tieba.play.c.p
        public void doa() {
            if (h.this.ljH != null && h.this.ljH.dgX() != null && h.this.ljH.dgX().getPbData() != null) {
                PostData dfR = h.this.ljH.dgX().getPbData().dfR();
                if (dfR == null && y.getCount(h.this.ljH.dgX().getPbData().dfK()) > 1) {
                    dfR = (PostData) y.getItem(h.this.ljH.dgX().getPbData().dfK(), 0);
                }
                com.baidu.tieba.pb.c.a.a(h.this.ljH.dgX().getPbData(), dfR, 1, 1, 4);
            }
        }
    };
    private boolean lFw = true;
    private PbFullScreenFloatingHuajiAninationView.a lFy = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.h.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            h.this.vh(false);
        }
    };
    private boolean lFC = false;
    private c.m lFE = new c.m() { // from class: com.baidu.tieba.pb.video.h.15
        @Override // com.baidu.tieba.play.c.m
        public boolean doc() {
            if (h.this.lFq >= 1.0d) {
                if (h.this.ljH.checkUpIsLogin()) {
                    h.this.ljH.dix();
                    if (h.this.ljH.dgX() == null || h.this.ljH.dgX().getPbData() == null || h.this.ljH.dgX().getPbData().dgh() == null) {
                        return false;
                    }
                    com.baidu.tieba.pb.data.o dgh = h.this.ljH.dgX().getPbData().dgh();
                    if (h.this.lFx == null) {
                        h.this.lFx = new PbFullScreenFloatingHuajiAninationView(h.this.ljH.getActivity());
                        h.this.lFx.setFloatingHuajiAninationListener(h.this.lFy);
                    }
                    h.this.lFx.vw(dgh.dgA() ? false : true);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean dod() {
            return false;
        }
    };
    private CustomMessageListener OQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.h.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (h.this.iIB != null) {
                    h.this.iIB.setNetworkChange();
                }
                if (j.isMobileNet() && h.this.iIB != null && h.this.iIB.rK() && h.this.lFa != null && h.this.lFa.video_length.intValue() > 0 && h.this.lFa.video_duration.intValue() > 0) {
                    float intValue = h.this.lFa.video_length.intValue() * (1.0f - ((h.this.iIB.getCurrentPosition() * 1.0f) / (h.this.lFa.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(h.this.ljH.getPageContext().getPageActivity(), String.format(h.this.ljH.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener kAR = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.h.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            h.this.dmJ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener iDh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.h.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (h.this.lFa != null) {
                h.this.f(h.this.lFa);
                h.this.iIB.duo();
                h.this.iIB.cXn();
                if (h.this.mEmptyView != null && h.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.mEmptyView.getLayoutParams();
                    layoutParams.height = h.this.lFp;
                    h.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(boolean z) {
        if (this.ljH != null) {
            this.ljH.dhP();
        }
    }

    public h(PbFragment pbFragment, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.lFm = 0.0f;
        this.ljH = pbFragment;
        this.lEX = cVar;
        this.lFm = l.getDimens(this.ljH.getActivity(), R.dimen.ds240);
        this.lFr = j;
        g(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.OQ);
        this.iDh.setTag(pbFragment.getUniqueId());
        this.iDh.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iDh);
        this.jeM = new com.baidu.mcn.c(pbFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.lEY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return l.getEquipmentWidth(this.ljH.getActivity());
        }
        int equipmentWidth = l.getEquipmentWidth(this.ljH.getActivity());
        Rect visibilityRegion = bf.getVisibilityRegion(this.ljH.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.ljH.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.lFq = (intValue2 * 1.0d) / intValue;
            if (this.lFq > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.lFp = i;
        this.lEY.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean bUC() {
        return this.lFq >= 1.0d;
    }

    public int dmp() {
        return this.lFp;
    }

    private void g(VideoInfo videoInfo) {
        int i = 0;
        this.lEW = (RelativeLayout) LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.lEY = (CustomFrameLayout) this.lEW.findViewById(R.id.pb_video_container);
        int f = f(videoInfo);
        this.afT = ((double) this.lFp) <= (((double) l.getEquipmentWidth(this.ljH.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.iIB = new com.baidu.tieba.play.c(this.ljH.getPageContext(), this.lEY, true);
        this.iIB.setStageType("2002");
        this.iIB.a(this.lFE);
        this.iIB.wi(false);
        this.iIB.a(this.lFu);
        this.iIB.Hb(ap.oM(R.drawable.pic_use_header_60_n));
        this.iIB.a(new c.n() { // from class: com.baidu.tieba.pb.video.h.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                h.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.ljH.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.ljH.getBaseFragmentActivity())) {
            this.iIB.vZ(false);
        }
        this.iIB.a(new c.k() { // from class: com.baidu.tieba.pb.video.h.18
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
                        if (h.this.ljH.getListView() != null && h.this.ljH.getListView().getChildCount() > 0 && h.this.ljH.getListView().getChildAt(0) == h.this.dnZ()) {
                            h.this.lFF = h.this.dnZ().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        h.this.mLastY = 0.0f;
                        h.this.lFF = 0;
                        break;
                    case 2:
                        if (h.this.ljH.getListView() != null && h.this.ljH.getListView().getChildCount() > 0 && h.this.ljH.getListView().getChildAt(0) == h.this.dnZ()) {
                            h.this.ljH.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - h.this.mLastY)) + h.this.lFF);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.lFq >= 1.0d) {
                this.iIB.ay(false, true);
            } else {
                this.iIB.ay(true, false);
            }
            this.lFn = ((float) f) + this.lFm > ((float) l.getEquipmentHeight(this.ljH.getActivity()));
            if (this.lFn) {
                if (this.lFc == null) {
                    this.lFc = new f(this.ljH.getPageContext(), this.lEY);
                }
                this.ljH.dhN().dlI();
                this.lFd = true;
            }
        }
        dnU();
        this.mEmptyView = new View(this.ljH.getContext());
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.lFp));
        if (this.lEX != null && this.lEX.mNavigationBar != null) {
            this.lEX.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.lEX.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.lEX.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.bnR() && !TbSingleton.getInstance().isNotchScreen(this.ljH.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.ljH.getBaseFragmentActivity())) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.lFs = (PbVideoWifiTipLayout) this.lEW.findViewById(R.id.layout_wifi_tip);
        this.lFs.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.h.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.lFB = true;
                h.this.lFs.setVisibility(8);
                h.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.jeM != null) {
            this.jeM.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.ljH.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.lEZ == null) {
            this.lEZ = new c.d() { // from class: com.baidu.tieba.pb.video.h.20
                @Override // com.baidu.tieba.play.c.d
                public void pL(boolean z) {
                    if (h.this.dnX() && h.this.lEX != null) {
                        loadAnimation.setAnimationListener(null);
                        h.this.lEX.dmC().clearAnimation();
                        h.this.dnV();
                        if (z) {
                            loadAnimation.setAnimationListener(h.this.kAR);
                            h.this.lEX.dmC().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void cyG() {
                    if (h.this.dnX()) {
                        h.this.dmJ();
                    }
                }
            };
        }
        a(this.lEZ);
        this.lFi = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ljH.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bw bwVar, final String str) {
        if (videoInfo != null && this.iIB != null && bwVar != null) {
            this.lFa = videoInfo;
            this.lFe = bwVar;
            this.mVideoUrl = videoInfo.video_url;
            this.iIB.stopPlay();
            this.lFb = new o();
            this.lFb.mLocate = "pb";
            this.lFb.alT = bwVar.getTid();
            this.lFb.fsZ = str;
            this.lFb.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.isBjh()) {
                if (!StringUtils.isNull(this.ljH.lox)) {
                    this.lFb.eve = this.ljH.lox;
                }
                this.lFb.mdU = this.ljH.lov + "";
            } else {
                this.lFb.mdU = this.ljH.dhK();
            }
            com.baidu.tbadk.core.data.bf diz = this.ljH.diz();
            if (diz != null) {
                diz.a(this.lFb);
            }
            this.lFb.mdX = videoInfo.video_md5;
            o duG = this.lFb.duG();
            duG.mLocate = "6";
            this.startPosition = -1L;
            if (this.iIB.getVideoView() != null && this.iIB.getVideoView().getMediaProgressObserver() != null) {
                this.iIB.getVideoView().getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.pb.video.h.2
                    @Override // com.baidu.tieba.play.f.b
                    public void cc(int i, int i2) {
                        boolean z = true;
                        if (h.this.startPosition <= 0) {
                            h.this.startPosition = i2;
                        }
                        McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                        if (mcnAdInfo != null) {
                            boolean iZ = com.baidu.mcn.b.Xq().iZ(mcnAdInfo.jump_url);
                            if (h.this.afT && !iZ && !h.this.lFj) {
                                boolean z2 = h.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                                if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                    z = false;
                                }
                                if (z) {
                                    if (!h.this.jeM.isShowing()) {
                                        com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                        aVar.bSo = mcnAdInfo.card_title;
                                        aVar.bSp = mcnAdInfo.button_title;
                                        aVar.bSq = mcnAdInfo.jump_url;
                                        aVar.bSn = mcnAdInfo.pic_url;
                                        aVar.fid = str;
                                        aVar.tid = bwVar.getTid();
                                        aVar.bSr = 4;
                                        if (z2) {
                                            h.this.jeM.b(aVar, (ViewGroup) h.this.iIB.dun());
                                        } else {
                                            h.this.jeM.a(aVar, (ViewGroup) h.this.iIB.dun());
                                        }
                                    }
                                } else if (h.this.jeM.isShowing()) {
                                    h.this.jeM.dismiss();
                                }
                            }
                        }
                    }
                });
            }
            this.iIB.getVideoView().setVideoStatData(duG);
            if (this.iIB.cXp()) {
                this.iIB.cXn();
            }
            this.iIB.b(this.lFv);
            this.lFg = null;
            this.lFf = null;
            this.iIB.PS(this.lFg);
            this.iIB.cXj().setOnDragingListener(kCO);
            this.iIB.a(new c.InterfaceC0812c() { // from class: com.baidu.tieba.pb.video.h.3
                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rJ() {
                    h.this.ljH.getBaseFragmentActivity().setSwipeBackEnabled(true);
                    h.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.lFt > 0) {
                                h.this.Gk(h.this.lFt);
                                h.this.Gl(h.this.lFt);
                                h.this.lFt = 0;
                            }
                            h.this.lFw = true;
                        }
                    }, 200L);
                    h.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0812c
                public void rI() {
                    h.this.ljH.getBaseFragmentActivity().setSwipeBackEnabled(false);
                    h.this.lFw = false;
                    h.this.lFt = h.this.bMO().getHeight();
                }
            });
            this.iIB.a(new c.h() { // from class: com.baidu.tieba.pb.video.h.4
                @Override // com.baidu.tieba.play.c.h
                public void dob() {
                    if (h.this.ljH != null && h.this.lFf != null && !StringUtils.isNull(h.this.lFf.getId())) {
                        h.this.ljH.Pi(h.this.lFf.getId());
                    }
                }
            });
            this.iIB.a(new c.j() { // from class: com.baidu.tieba.pb.video.h.5
                @Override // com.baidu.tieba.play.c.j
                public void vi(boolean z) {
                    if (h.this.lFe != null) {
                        h.this.Ke(z ? "1" : "2");
                    }
                }
            });
            this.iIB.a(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pb.video.h.6
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i, int i2, Object obj) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", h.this.mVideoUrl);
                    return true;
                }
            });
            this.iIB.setThumbnail(videoInfo.thumbnail_url);
            this.iIB.setVideoUrl(this.mVideoUrl, bwVar.getTid());
            this.iIB.setFid(str);
            this.iIB.Qs(bwVar.getTitle());
            this.iIB.a(lFG);
            this.iIB.cJS();
            this.iIB.show();
        }
    }

    public void PR(String str) {
        if (this.lFb != null) {
            this.lFb.fsZ = str;
        }
    }

    public void b(PostData postData, bw bwVar, com.baidu.tieba.pb.data.o oVar) {
        if (this.lFc != null) {
            this.lFc.a(postData, bwVar, oVar);
        }
    }

    public void a(c.d dVar) {
        this.lFv = dVar;
    }

    public void aM(bw bwVar) {
        this.lFf = bwVar;
    }

    public void PS(String str) {
        this.lFg = str;
        if (this.iIB != null) {
            this.iIB.PS(this.lFg);
        }
    }

    public void startPlay() {
        if (this.iIB != null) {
            if (j.isMobileNet() && !this.lFB && !com.baidu.tieba.video.g.dLS().dLT()) {
                this.lFs.setVisibility(0);
                this.lFs.setData(this.lFa);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.mVideoUrl) && this.lFe != null && this.lFe.bks() != null) {
                TiebaStatic.log(new aq("c12619").dR("obj_locate", "pb").dR("tid", this.lFe.getTid()));
                this.mVideoUrl = this.lFe.bks().video_url;
            }
            this.iIB.fW(this.mVideoUrl, this.lFe == null ? "" : this.lFe.getTid());
            Ke("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void dnT() {
        if (this.iIB != null) {
            this.iIB.dnT();
        }
    }

    public void destroy() {
        if (this.iIB != null) {
            this.iIB.destroy();
        }
        if (this.lEY != null) {
            this.lEY.clearAnimation();
        }
        if (this.lFc != null) {
            this.lFc.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.OQ);
        MessageManager.getInstance().unRegisterListener(this.iDh);
    }

    public void onPause() {
        if (this.iIB != null) {
            if (this.iIB.rK()) {
                this.lFh = true;
                this.iIB.stopPlay();
            } else if (this.iIB.getCurrentState() == 3) {
                this.lFh = false;
            } else if (this.iIB.getCurrentState() == 0 || this.iIB.getCurrentState() == 1) {
                this.lFh = true;
                this.iIB.stopPlay();
            } else {
                this.lFh = false;
                this.iIB.stopPlay();
            }
            if (this.lFx != null) {
                this.lFx.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.iIB != null && this.lFh) {
            this.iIB.dua();
        }
    }

    private void dnU() {
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.ag(false);
            dVar.al(16908290).ak(Opcodes.IFEQ).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.h.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(h.this.ljH.getActivity());
                    if (h.this.lFA == null) {
                        try {
                            h.this.lFA = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(h.this.lFA);
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
                    h.this.lFz = null;
                    if (h.this.lFA != null && !h.this.lFA.isRecycled()) {
                        h.this.lFA.recycle();
                    }
                    h.this.lFA = null;
                }
            });
            this.lFz = dVar.mi();
            this.lFz.showOnDecorView(this.ljH.getActivity());
        }
    }

    public boolean yZ(int i) {
        if (this.iIB == null) {
            return false;
        }
        return this.iIB.Hd(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke(String str) {
        if (this.lFa != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.h.a(this.lFa.video_md5, "", str, this.lFb, this.iIB.getVideoView().getPcdnState());
            }
        }
    }

    public void dnV() {
        if (this.lEX != null) {
            this.lEX.uY(this.ljH.dgO());
        }
    }

    public void dmJ() {
        if (this.lEX != null) {
            this.lEX.dmJ();
        }
    }

    public void FY(int i) {
        if (this.lEX != null) {
            this.lEX.FY(i);
        }
        if (this.lFx != null) {
            this.lFx.onChangeSkinType(i);
        }
        if (this.lFc != null) {
            this.lFc.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!dnY()) {
                    this.lFk = i;
                    if (this.lFk == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.11
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.Gl(h.this.bMO().getHeight());
                            }
                        }, 100L);
                    }
                    dnW();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk(int i) {
        if (bMO().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEY.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.lFD = false;
                    if (this.lFp != bMO().getHeight()) {
                        this.lEY.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.ljH.getActivity()), Math.min(this.lFp, bMO().getHeight() + i)));
                        this.iIB.cXn();
                    }
                } else if (l.getEquipmentWidth(this.ljH.getActivity()) * 0.5625d != bMO().getHeight()) {
                    this.lEY.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.ljH.getActivity()), (int) Math.max(l.getEquipmentWidth(this.ljH.getActivity()) * 0.5625d, bMO().getHeight() + i)));
                    this.iIB.cXn();
                }
            }
        }
    }

    public void c(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == dnZ()) {
                int bottom = childAt.getBottom() - bMO().getBottom();
                if (childAt.getHeight() == 0 || bMO().getHeight() == 0) {
                    bottom = 0;
                }
                Gk(bottom);
            } else {
                Gk((-this.lFp) + 2);
            }
        }
        if (!dnY() && this.lFw) {
            if (this.lFk == 1) {
                this.lFC = true;
                Gl(bMO().getHeight());
            } else if (this.lFk == 2) {
                this.lFC = true;
                int y = (int) bMO().getY();
                if (this.lFl == y) {
                    Gl(bMO().getHeight());
                } else {
                    this.lFl = y;
                    Gl(bMO().getHeight());
                }
                if (i == 0 && this.lFo) {
                    this.lFo = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.h.13
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.dnT();
                        }
                    }, 100L);
                }
            } else if (this.lFk == 0) {
                if (this.lFC || !"nani_midpage".equals(this.ljH.dhK())) {
                    Gl(bMO().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gl(int i) {
        Gm(i);
        dnW();
    }

    public void uK(boolean z) {
        this.lFD = z;
    }

    private void Gm(int i) {
        if (this.lFc != null) {
            if (this.lFe != null && this.lFe.biK()) {
                this.lFc.dnR().setVisibility(8);
                return;
            }
            if (i == 0) {
                i = this.lFp;
            }
            float f = this.lFp - i;
            float f2 = f > this.lFm ? 0.0f : 1.0f - (f / this.lFm);
            if (this.lFD) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.lFc.dnR().setVisibility(8);
            } else {
                this.lFc.dnR().setVisibility(0);
            }
            this.lFc.aF(f2);
        }
    }

    public void dnW() {
        if (this.lFc != null) {
            if (dnY()) {
                this.ljH.dhN().dlI();
            } else if (this.lFc.dnR().getVisibility() == 0) {
                this.ljH.dhN().dlI();
                this.lFd = true;
            } else if (this.lFd) {
                this.ljH.dhN().uJ(false);
                this.lFd = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dnX() {
        return bMO().getY() >= 0.0f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.lFj = false;
        if (this.iIB != null && this.lEY != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEY.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.jeM != null && this.jeM.isShowing()) {
                    this.jeM.Xr();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.lFz != null) {
                    this.lFz.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.lFj = true;
                this.lEY.setLayoutParams(layoutParams);
                this.ljH.dhN().dlI();
                this.lFd = true;
            } else {
                f(this.lFa);
                dnV();
                this.lFj = false;
                this.lEX.uX(true);
            }
            this.iIB.a(this.ljH.getPageContext(), configuration);
        }
    }

    public boolean dnY() {
        return this.lFj;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lFc != null) {
            this.lFc.V(onClickListener);
        }
    }

    public View bMO() {
        return this.lEW;
    }

    public boolean dlR() {
        if (bMO() == null) {
            return false;
        }
        return bMO().getBottom() > l.getEquipmentHeight(bMO().getContext()) - l.getDimens(bMO().getContext(), R.dimen.ds50);
    }

    public void dmn() {
        this.lFo = true;
    }

    public View dnZ() {
        return this.mEmptyView;
    }
}
