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
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
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
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class i {
    private static VideoControllerView.a hiZ = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aDV() {
        }
    };
    private static c.i ieV = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bmp() {
        }
    };
    private boolean FA;
    private n dwz;
    private com.baidu.tieba.play.c fBh;
    private com.baidu.mcn.c fUJ;
    private PbActivity hNY;
    private float ieB;
    private int ieE;
    private double ieF;
    private long ieG;
    private PbVideoWifiTipLayout ieH;
    private int ieI;
    private c.d ieK;
    private PbFullScreenFloatingHuajiAninationView ieM;
    private com.baidu.adp.lib.guide.c ieO;
    private Bitmap ieP;
    private boolean ieQ;
    private boolean ieS;
    private int ieU;
    private RelativeLayout iel;
    private com.baidu.tieba.pb.pb.main.view.c iem;
    private CustomFrameLayout ien;
    private c.d ieo;
    private z ieq;
    private g ier;
    private boolean ies;
    private bh iet;
    private bh ieu;
    private String iev;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String cmf = null;
    private VideoInfo iep = null;
    private boolean iew = false;
    private int iex = 0;
    private boolean iey = false;
    private int iez = 0;
    private int ieA = 0;
    private boolean ieC = false;
    private boolean ieD = false;
    private long startPosition = -1;
    private int ffe = 0;
    private c.p ieJ = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bYf() {
            if (i.this.hNY != null && i.this.hNY.bRF() != null && i.this.hNY.bRF().getPbData() != null) {
                PostData bQG = i.this.hNY.bRF().getPbData().bQG();
                if (bQG == null && v.getCount(i.this.hNY.bRF().getPbData().bQB()) > 1) {
                    bQG = (PostData) v.getItem(i.this.hNY.bRF().getPbData().bQB(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hNY.bRF().getPbData(), bQG, 1, 1, 4);
            }
        }
    };
    private boolean ieL = true;
    private PbFullScreenFloatingHuajiAninationView.a ieN = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pg(false);
        }
    };
    private boolean ieR = false;
    private c.m ieT = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean bYh() {
            if (i.this.ieF < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hNY.checkUpIsLogin()) {
                i.this.hNY.bSJ();
                if (i.this.hNY.bRF() == null || i.this.hNY.bRF().getPbData() == null || i.this.hNY.bRF().getPbData().bQW() == null) {
                    return false;
                }
                j bQW = i.this.hNY.bRF().getPbData().bQW();
                if (i.this.ieM == null) {
                    i.this.ieM = new PbFullScreenFloatingHuajiAninationView(i.this.hNY.getActivity());
                    i.this.ieM.setFloatingHuajiAninationListener(i.this.ieN);
                }
                i.this.ieM.pj(bQW.bRf() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bYi() {
            return false;
        }
    };
    private CustomMessageListener ri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (i.this.fBh != null) {
                    i.this.fBh.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.isMobileNet() && i.this.fBh != null && i.this.fBh.kx() && i.this.iep != null && i.this.iep.video_length.intValue() > 0 && i.this.iep.video_duration.intValue() > 0) {
                    float intValue = i.this.iep.video_length.intValue() * (1.0f - ((i.this.fBh.getCurrentPosition() * 1.0f) / (i.this.iep.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hNY.getPageContext().getPageActivity(), String.format(i.this.hNY.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hgZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bWO();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.iep != null) {
                i.this.e(i.this.iep);
                i.this.fBh.cbY();
                i.this.fBh.bII();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.ieE;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pg(boolean z) {
        if (this.hNY != null) {
            this.hNY.bRZ();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.ieB = 0.0f;
        this.hNY = pbActivity;
        this.iem = cVar;
        this.ieB = l.getDimens(this.hNY.getActivity(), R.dimen.ds240);
        this.ieG = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.ri);
        this.fwS.setTag(pbActivity.getUniqueId());
        this.fwS.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fwS);
        this.fUJ = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int equipmentWidth = l.getEquipmentWidth(this.hNY.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.hNY.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.hNY.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.ieF = (intValue2 * 1.0d) / intValue;
            if (this.ieF > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.ieE = i;
        this.ien.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean aOh() {
        return this.ieF >= 1.0d;
    }

    public int bXV() {
        return this.ieE;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.iel = (RelativeLayout) LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.ien = (CustomFrameLayout) this.iel.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.FA = ((double) this.ieE) <= (((double) l.getEquipmentWidth(this.hNY.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fBh = new com.baidu.tieba.play.c(this.hNY.getPageContext(), this.ien, true, com.baidu.tbadk.a.b.mb("cyber_player_test") ? 1 : 0);
        this.fBh.a(this.ieT);
        this.fBh.pO(false);
        this.fBh.a(this.ieJ);
        this.fBh.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hNY) || TbSingleton.getInstance().isCutoutScreen(this.hNY)) {
            this.fBh.pF(false);
        }
        this.fBh.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        if (i.this.hNY.getListView() != null && i.this.hNY.getListView().getChildCount() > 0 && i.this.hNY.getListView().getChildAt(0) == i.this.bYe()) {
                            i.this.ieU = i.this.bYe().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.ieU = 0;
                        break;
                    case 2:
                        if (i.this.hNY.getListView() != null && i.this.hNY.getListView().getChildCount() > 0 && i.this.hNY.getListView().getChildAt(0) == i.this.bYe()) {
                            i.this.hNY.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.ieU);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.ieF >= 1.0d) {
                this.fBh.ag(false, true);
            } else {
                this.fBh.ag(true, false);
            }
            this.ieC = ((float) e) + this.ieB > ((float) l.getEquipmentHeight(this.hNY.getActivity()));
            if (this.ieC) {
                if (this.ier == null) {
                    this.ier = new g(this.hNY.getPageContext(), this.ien);
                }
                this.hNY.bRX().bVW();
                this.ies = true;
            }
        }
        bXX();
        this.mEmptyView = new View(this.hNY);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.ieE));
        if (this.iem != null && this.iem.mNavigationBar != null) {
            this.iem.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.iem.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.iem.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.alY() && !TbSingleton.getInstance().isNotchScreen(this.hNY) && !TbSingleton.getInstance().isCutoutScreen(this.hNY)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.ieH = (PbVideoWifiTipLayout) this.iel.findViewById(R.id.layout_wifi_tip);
        this.ieH.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.ieQ = true;
                i.this.ieH.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fUJ != null) {
            this.fUJ.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hNY.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.ieo == null) {
            this.ieo = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (i.this.bYa() && i.this.iem != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.iem.bWH().clearAnimation();
                        i.this.bXY();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.hgZ);
                            i.this.iem.bWH().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmo() {
                    if (i.this.bYa()) {
                        i.this.bWO();
                    }
                }
            };
        }
        a(this.ieo);
        this.iex = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hNY.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bh bhVar, final String str) {
        if (videoInfo != null && this.fBh != null && bhVar != null) {
            this.iep = videoInfo;
            this.iet = bhVar;
            this.cmf = videoInfo.video_url;
            this.fBh.stopPlay();
            this.fBh.setIsNeedRecoveryVideoPlayer(true);
            this.dwz = new n(this.hNY.getActivity());
            this.ieq = new z();
            this.ieq.mLocate = "pb";
            this.ieq.cmS = bhVar.getTid();
            this.ieq.ePT = str;
            this.ieq.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ieq.izc = this.hNY.bRU();
            av bSL = this.hNY.bSL();
            if (bSL != null) {
                bSL.b(this.ieq);
            }
            this.ieq.ize = videoInfo.video_md5;
            z ccU = this.ieq.ccU();
            ccU.mLocate = "6";
            this.startPosition = -1L;
            this.dwz.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bj(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean du = com.baidu.mcn.b.zd().du(mcnAdInfo.jump_url);
                        if (i.this.FA && !du && !i.this.iey) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fUJ.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.ayR = mcnAdInfo.card_title;
                                    aVar.ayS = mcnAdInfo.button_title;
                                    aVar.ayT = mcnAdInfo.jump_url;
                                    aVar.ayQ = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bhVar.getTid();
                                    aVar.ayU = 4;
                                    if (z2) {
                                        i.this.fUJ.b(aVar, (ViewGroup) i.this.fBh.cbX());
                                    } else {
                                        i.this.fUJ.a(aVar, (ViewGroup) i.this.fBh.cbX());
                                    }
                                }
                            } else if (i.this.fUJ.isShowing()) {
                                i.this.fUJ.dismiss();
                            }
                        }
                    }
                }
            });
            this.dwz.setVideoStatsData(ccU);
            this.fBh.cbG().setBusiness(this.dwz);
            if (this.fBh.bIK()) {
                this.fBh.bII();
            }
            this.fBh.b(this.ieK);
            this.iev = null;
            this.ieu = null;
            this.fBh.Bn(this.iev);
            this.fBh.bIE().setOnDragingListener(hiZ);
            this.fBh.a(new c.InterfaceC0497c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kw() {
                    i.this.hNY.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.ieI > 0) {
                                i.this.xc(i.this.ieI);
                                i.this.xd(i.this.ieI);
                                i.this.ieI = 0;
                            }
                            i.this.ieL = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kv() {
                    i.this.hNY.setSwipeBackEnabled(false);
                    i.this.ieL = false;
                    i.this.ieI = i.this.aJy().getHeight();
                }
            });
            this.fBh.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bYg() {
                    if (i.this.hNY != null && i.this.ieu != null && !StringUtils.isNull(i.this.ieu.getId())) {
                        i.this.hNY.AG(i.this.ieu.getId());
                        if (i.this.iet != null) {
                            long j = 0;
                            if (i.this.iet.ajP() != null) {
                                j = i.this.iet.ajP().channelId;
                            }
                            TiebaStatic.log(new an("c11921").p("obj_id", j));
                        }
                    }
                }
            });
            this.fBh.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void ph(boolean z) {
                    if (i.this.iet != null) {
                        long j = 0;
                        if (i.this.iet.ajP() != null) {
                            j = i.this.iet.ajP().channelId;
                        }
                        i.this.vR(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").bS("tid", i.this.iet.getTid()).p("fid", i.this.iet.getFid()).p("obj_id", j));
                    }
                }
            });
            this.fBh.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.cmf);
                    return true;
                }
            });
            this.fBh.setThumbnail(videoInfo.thumbnail_url);
            this.fBh.setVideoUrl(this.cmf, bhVar.getTid());
            this.fBh.setFid(str);
            this.fBh.BN(bhVar.getTitle());
            this.fBh.a(ieV);
            this.fBh.bvM();
            this.fBh.show();
        }
    }

    public void Bm(String str) {
        if (this.ieq != null) {
            this.ieq.ePT = str;
        }
    }

    public void b(PostData postData, bh bhVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.ier != null) {
            this.ier.a(postData, bhVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.ieK = dVar;
    }

    public void aB(bh bhVar) {
        this.ieu = bhVar;
    }

    public void Bn(String str) {
        this.iev = str;
        if (this.fBh != null) {
            this.fBh.Bn(this.iev);
        }
    }

    public void startPlay() {
        if (this.fBh != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.ieQ && !com.baidu.tieba.video.g.csD().csE()) {
                this.ieH.setVisibility(0);
                this.ieH.setData(this.iep);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.cmf) && this.iet != null && this.iet.aiX() != null) {
                TiebaStatic.log(new an("c12619").bS("obj_locate", "pb").bS("tid", this.iet.getTid()));
                this.cmf = this.iet.aiX().video_url;
            }
            this.fBh.cm(this.cmf, this.iet == null ? "" : this.iet.getTid());
            vR("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void bXW() {
        if (this.fBh != null) {
            this.fBh.bXW();
        }
    }

    public void destroy() {
        if (this.fBh != null) {
            this.fBh.destroy();
        }
        if (this.ien != null) {
            this.ien.clearAnimation();
        }
        if (this.ier != null) {
            this.ier.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ri);
        MessageManager.getInstance().unRegisterListener(this.fwS);
    }

    public void onPause() {
        if (this.fBh != null) {
            if (this.fBh.kx()) {
                this.iew = true;
                this.fBh.stopPlay();
            } else if (this.fBh.getCurrentState() == 3) {
                this.iew = false;
            } else if (this.fBh.getCurrentState() == 0 || this.fBh.getCurrentState() == 1) {
                this.iew = true;
                this.fBh.stopPlay();
            } else {
                this.iew = false;
                this.fBh.stopPlay();
            }
            if (this.ieM != null) {
                this.ieM.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fBh != null && this.iew) {
            this.fBh.cbK();
        }
    }

    private void bXX() {
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.A(true);
            dVar.C(false);
            dVar.J(16908290).I(153).B(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hNY.getActivity());
                    if (i.this.ieP == null) {
                        try {
                            i.this.ieP = BitmapFactory.decodeResource(i.this.hNY.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.ieP);
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.8
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.ieO = null;
                    if (i.this.ieP != null && !i.this.ieP.isRecycled()) {
                        i.this.ieP.recycle();
                    }
                    i.this.ieP = null;
                }
            });
            this.ieO = dVar.fu();
            this.ieO.showOnDecorView(this.hNY.getActivity());
        }
    }

    public boolean qP(int i) {
        if (this.fBh == null) {
            return false;
        }
        return this.fBh.xD(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.iep != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.iep.video_md5, "", str, this.ieq);
            }
        }
    }

    public void bXY() {
        if (this.iem != null) {
            this.iem.oY(this.hNY.bRv());
        }
    }

    public void bWO() {
        if (this.iem != null) {
            this.iem.bWO();
        }
    }

    public void wX(int i) {
        if (this.iem != null) {
            this.iem.wX(i);
        }
        if (this.ieM != null) {
            this.ieM.onChangeSkinType(i);
        }
        if (this.ier != null) {
            this.ier.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bYb()) {
                    this.iez = i;
                    if (this.iez == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.xd(i.this.aJy().getHeight());
                            }
                        }, 100L);
                    }
                    bXZ();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(int i) {
        if (aJy().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ien.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.ieS = false;
                    if (this.ieE != aJy().getHeight()) {
                        this.ien.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.hNY.getActivity()), Math.min(this.ieE, aJy().getHeight() + i)));
                        this.fBh.bII();
                    }
                } else if (l.getEquipmentWidth(this.hNY.getActivity()) * 0.5625d != aJy().getHeight()) {
                    this.ien.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.hNY.getActivity()), (int) Math.max(l.getEquipmentWidth(this.hNY.getActivity()) * 0.5625d, aJy().getHeight() + i)));
                    this.fBh.bII();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bYe()) {
                int bottom = childAt.getBottom() - aJy().getBottom();
                if (childAt.getHeight() == 0 || aJy().getHeight() == 0) {
                    bottom = 0;
                }
                xc(bottom);
            } else {
                xc((-this.ieE) + 2);
            }
        }
        if (!bYb() && this.ieL) {
            if (this.iez == 1) {
                this.ieR = true;
                xd(aJy().getHeight());
            } else if (this.iez == 2) {
                this.ieR = true;
                int y = (int) aJy().getY();
                if (this.ieA == y) {
                    xd(aJy().getHeight());
                } else {
                    this.ieA = y;
                    xd(aJy().getHeight());
                }
                if (i == 0 && this.ieD) {
                    this.ieD = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bXW();
                        }
                    }, 100L);
                }
            } else if (this.iez == 0) {
                if (this.ieR || !"nani_midpage".equals(this.hNY.bRU())) {
                    xd(aJy().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        xe(i);
        bXZ();
    }

    public void oM(boolean z) {
        this.ieS = z;
    }

    private void xe(int i) {
        if (this.ier != null) {
            if (i == 0) {
                i = this.ieE;
            }
            float f = this.ieE - i;
            float f2 = f > this.ieB ? 0.0f : 1.0f - (f / this.ieB);
            if (this.ieS) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.ier.bXR().setVisibility(8);
            } else {
                this.ier.bXR().setVisibility(0);
            }
            this.ier.as(f2);
        }
    }

    public void bXZ() {
        if (this.ier != null) {
            if (bYb()) {
                this.hNY.bRX().bVW();
            } else if (this.ier.bXR().getVisibility() == 0) {
                this.hNY.bRX().bVW();
                this.ies = true;
            } else if (this.ies) {
                this.hNY.bRX().oL(false);
                this.ies = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYa() {
        return aJy().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.iey = false;
        if (this.fBh != null && this.ien != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ien.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fUJ != null && this.fUJ.isShowing()) {
                    this.fUJ.ze();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.ieO != null) {
                    this.ieO.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.iey = true;
                this.ien.setLayoutParams(layoutParams);
                this.hNY.bRX().bVW();
                this.ies = true;
            } else {
                e(this.iep);
                bXY();
                this.iey = false;
                this.iem.oX(true);
            }
            this.fBh.a(this.hNY.getPageContext(), configuration);
        }
    }

    public boolean bYb() {
        return this.iey;
    }

    public void r(long j, int i) {
        if (this.ier != null && j > 0) {
            this.ier.w(i, j);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.ier != null) {
            this.ier.S(onClickListener);
        }
    }

    public View aJy() {
        return this.iel;
    }

    public boolean bWf() {
        if (aJy() == null) {
            return false;
        }
        return aJy().getBottom() > l.getEquipmentHeight(aJy().getContext()) - l.getDimens(aJy().getContext(), R.dimen.ds50);
    }

    public void bYc() {
        this.ieD = true;
    }

    public void bYd() {
        if (this.fBh != null) {
            this.fBh.pausePlay();
        }
    }

    public View bYe() {
        return this.mEmptyView;
    }
}
