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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
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
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class i {
    private static VideoControllerView.a hii = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aDg() {
        }
    };
    private static c.i idn = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bom() {
        }
    };
    private float Ok;
    private boolean VM;
    private n dnw;
    private com.baidu.mcn.c fSI;
    private com.baidu.tieba.play.c fzp;
    private PbActivity hMD;
    private RelativeLayout icC;
    private com.baidu.tieba.pb.pb.main.view.c icD;
    private CustomFrameLayout icE;
    private c.d icF;
    private z icH;
    private g icI;
    private boolean icJ;
    private bg icK;
    private bg icL;
    private String icM;
    private float icS;
    private int icV;
    private double icW;
    private long icX;
    private PbVideoWifiTipLayout icY;
    private int icZ;
    private c.d idb;
    private PbFullScreenFloatingHuajiAninationView idd;
    private com.baidu.adp.lib.guide.c idf;
    private Bitmap idg;
    private boolean idh;
    private boolean idj;
    private int idm;
    private View mEmptyView;
    private Handler mHandler;
    private String bWb = null;
    private VideoInfo icG = null;
    private boolean icN = false;
    private int icO = 0;
    private boolean icP = false;
    private int icQ = 0;
    private int icR = 0;
    private boolean icT = false;
    private boolean icU = false;
    private long startPosition = -1;
    private int faz = 0;
    private c.p ida = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bZY() {
            if (i.this.hMD != null && i.this.hMD.bTD() != null && i.this.hMD.bTD().getPbData() != null) {
                PostData bSE = i.this.hMD.bTD().getPbData().bSE();
                if (bSE == null && v.Z(i.this.hMD.bTD().getPbData().bSz()) > 1) {
                    bSE = (PostData) v.c(i.this.hMD.bTD().getPbData().bSz(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hMD.bTD().getPbData(), bSE, 1, 1, 4);
            }
        }
    };
    private boolean idc = true;
    private PbFullScreenFloatingHuajiAninationView.a ide = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pt(false);
        }
    };
    private boolean idi = false;
    private c.m idk = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean caa() {
            if (i.this.icW < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hMD.checkUpIsLogin()) {
                i.this.hMD.bUG();
                if (i.this.hMD.bTD() == null || i.this.hMD.bTD().getPbData() == null || i.this.hMD.bTD().getPbData().bSU() == null) {
                    return false;
                }
                j bSU = i.this.hMD.bTD().getPbData().bSU();
                if (i.this.idd == null) {
                    i.this.idd = new PbFullScreenFloatingHuajiAninationView(i.this.hMD.getActivity());
                    i.this.idd.setFloatingHuajiAninationListener(i.this.ide);
                }
                i.this.idd.pv(bSU.bTd() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean cab() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.kc()) {
                if (i.this.fzp != null) {
                    i.this.fzp.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.ke() && i.this.fzp != null && i.this.fzp.pB() && i.this.icG != null && i.this.icG.video_length.intValue() > 0 && i.this.icG.video_duration.intValue() > 0) {
                    float intValue = i.this.icG.video_length.intValue() * (1.0f - ((i.this.fzp.getCurrentPosition() * 1.0f) / (i.this.icG.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hMD.getPageContext().getPageActivity(), String.format(i.this.hMD.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener hgi = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.21
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bYH();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.icG != null) {
                i.this.e(i.this.icG);
                i.this.fzp.cdP();
                i.this.fzp.bKY();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.icV;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (this.hMD != null) {
            this.hMD.bTW();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.icS = 0.0f;
        this.hMD = pbActivity;
        this.icD = cVar;
        this.icS = l.g(this.hMD.getActivity(), R.dimen.ds240);
        this.icX = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.fvs.setTag(pbActivity.getUniqueId());
        this.fvs.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fvs);
        this.fSI = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int af = l.af(this.hMD.getActivity());
        Rect ab = bc.ab(this.hMD.getPageContext().getPageActivity());
        int ah = ab.height() <= 0 ? l.ah(this.hMD.getActivity()) : ab.height();
        int i = (int) (af * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.icW = (intValue2 * 1.0d) / intValue;
            if (this.icW > 0.5625d) {
                i = Math.min((af * intValue2) / intValue, ah);
            }
        }
        this.icV = i;
        this.icE.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        return i;
    }

    public boolean bZN() {
        return this.icW >= 1.0d;
    }

    public int bZO() {
        return this.icV;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.icC = (RelativeLayout) LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.icE = (CustomFrameLayout) this.icC.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.VM = ((double) this.icV) <= (((double) l.af(this.hMD.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fzp = new com.baidu.tieba.play.c((TbPageContext<?>) this.hMD.getPageContext(), (View) this.icE, true);
        this.fzp.a(this.idk);
        this.fzp.qc(false);
        this.fzp.a(this.ida);
        this.fzp.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hMD) || TbSingleton.getInstance().isCutoutScreen(this.hMD)) {
            this.fzp.pT(false);
        }
        this.fzp.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        i.this.Ok = motionEvent.getY();
                        if (i.this.hMD.getListView() != null && i.this.hMD.getListView().getChildCount() > 0 && i.this.hMD.getListView().getChildAt(0) == i.this.bZX()) {
                            i.this.idm = i.this.bZX().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.Ok = 0.0f;
                        i.this.idm = 0;
                        break;
                    case 2:
                        if (i.this.hMD.getListView() != null && i.this.hMD.getListView().getChildCount() > 0 && i.this.hMD.getListView().getChildAt(0) == i.this.bZX()) {
                            i.this.hMD.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.Ok)) + i.this.idm);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.icW >= 1.0d) {
                this.fzp.ag(false, true);
            } else {
                this.fzp.ag(true, false);
            }
            this.icT = ((float) e) + this.icS > ((float) l.ah(this.hMD.getActivity()));
            if (this.icT) {
                if (this.icI == null) {
                    this.icI = new g(this.hMD.getPageContext(), this.icE);
                }
                this.hMD.bTU().bXQ();
                this.icJ = true;
            }
        }
        bZQ();
        this.mEmptyView = new View(this.hMD);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.icV));
        if (this.icD != null && this.icD.mNavigationBar != null) {
            this.icD.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.icD.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.icD.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.ahY() && !TbSingleton.getInstance().isNotchScreen(this.hMD) && !TbSingleton.getInstance().isCutoutScreen(this.hMD)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.icY = (PbVideoWifiTipLayout) this.icC.findViewById(R.id.layout_wifi_tip);
        this.icY.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.idh = true;
                i.this.icY.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fSI != null) {
            this.fSI.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hMD.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.icF == null) {
            this.icF = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ks(boolean z) {
                    if (i.this.bZT() && i.this.icD != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.icD.bYB().clearAnimation();
                        i.this.bZR();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.hgi);
                            i.this.icD.bYB().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bol() {
                    if (i.this.bZT()) {
                        i.this.bYH();
                    }
                }
            };
        }
        a(this.icF);
        this.icO = UtilHelper.getLightStatusBarHeight() + l.g(this.hMD.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bg bgVar, final String str) {
        if (videoInfo != null && this.fzp != null && bgVar != null) {
            this.icG = videoInfo;
            this.icK = bgVar;
            this.bWb = videoInfo.video_url;
            this.fzp.stopPlay();
            this.fzp.setIsNeedRecoveryVideoPlayer(true);
            this.dnw = new n(this.hMD.getActivity());
            this.icH = new z();
            this.icH.mLocate = "pb";
            this.icH.bWO = bgVar.getTid();
            this.icH.eFy = str;
            this.icH.mUid = TbadkCoreApplication.getCurrentAccount();
            this.icH.mSource = bgVar.mRecomSource;
            this.icH.ixz = bgVar.mRecomWeight;
            this.icH.ixA = this.hMD.bTS();
            this.icH.ixB = bgVar.mRecomAbTag;
            this.icH.ixC = videoInfo.video_md5;
            z ceN = this.icH.ceN();
            ceN.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.startPosition = -1L;
            this.dnw.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean cJ = com.baidu.mcn.b.uj().cJ(mcnAdInfo.jump_url);
                        if (i.this.VM && !cJ && !i.this.icP) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fSI.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aft = mcnAdInfo.card_title;
                                    aVar.afu = mcnAdInfo.button_title;
                                    aVar.afv = mcnAdInfo.jump_url;
                                    aVar.afs = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bgVar.getTid();
                                    aVar.afw = 4;
                                    if (z2) {
                                        i.this.fSI.b(aVar, (ViewGroup) i.this.fzp.cdO());
                                    } else {
                                        i.this.fSI.a(aVar, (ViewGroup) i.this.fzp.cdO());
                                    }
                                }
                            } else if (i.this.fSI.isShowing()) {
                                i.this.fSI.dismiss();
                            }
                        }
                    }
                }
            });
            this.dnw.setVideoStatsData(ceN);
            this.fzp.getVideoView().setBusiness(this.dnw);
            if (this.fzp.bLa()) {
                this.fzp.bKY();
            }
            this.fzp.b(this.idb);
            this.icM = null;
            this.icL = null;
            this.fzp.Cu(this.icM);
            this.fzp.bKU().setOnDragingListener(hii);
            this.fzp.a(new c.InterfaceC0386c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pA() {
                    i.this.hMD.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.icZ > 0) {
                                i.this.yr(i.this.icZ);
                                i.this.ys(i.this.icZ);
                                i.this.icZ = 0;
                            }
                            i.this.idc = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0386c
                public void pz() {
                    i.this.hMD.setSwipeBackEnabled(false);
                    i.this.idc = false;
                    i.this.icZ = i.this.aJs().getHeight();
                }
            });
            this.fzp.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bZZ() {
                    if (i.this.hMD != null && i.this.icL != null && !StringUtils.isNull(i.this.icL.getId())) {
                        i.this.hMD.BN(i.this.icL.getId());
                        if (i.this.icK != null) {
                            long j = 0;
                            if (i.this.icK.afH() != null) {
                                j = i.this.icK.afH().channelId;
                            }
                            TiebaStatic.log(new an("c11921").l(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.fzp.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void pu(boolean z) {
                    if (i.this.icK != null) {
                        long j = 0;
                        if (i.this.icK.afH() != null) {
                            j = i.this.icK.afH().channelId;
                        }
                        i.this.wZ(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").bT("tid", i.this.icK.getTid()).l("fid", i.this.icK.getFid()).l(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.fzp.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.bWb);
                    return true;
                }
            });
            this.fzp.setThumbnail(videoInfo.thumbnail_url);
            this.fzp.setVideoUrl(this.bWb, bgVar.getTid());
            this.fzp.setFid(str);
            this.fzp.CU(bgVar.getTitle());
            this.fzp.a(idn);
            this.fzp.bxZ();
            this.fzp.show();
        }
    }

    public void Ct(String str) {
        if (this.icH != null) {
            this.icH.eFy = str;
        }
    }

    public void b(PostData postData, bg bgVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.icI != null) {
            this.icI.a(postData, bgVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.idb = dVar;
    }

    public void aB(bg bgVar) {
        this.icL = bgVar;
    }

    public void Cu(String str) {
        this.icM = str;
        if (this.fzp != null) {
            this.fzp.Cu(this.icM);
        }
    }

    public void startPlay() {
        if (this.fzp != null) {
            if (com.baidu.adp.lib.util.j.ke() && !this.idh && !com.baidu.tieba.video.g.ctE().ctF()) {
                this.icY.setVisibility(0);
                this.icY.setData(this.icG);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.bWb) && this.icK != null && this.icK.aeO() != null) {
                TiebaStatic.log(new an("c12619").bT("obj_locate", "pb").bT("tid", this.icK.getTid()));
                this.bWb = this.icK.aeO().video_url;
            }
            this.fzp.i(this.bWb, this.icK == null ? "" : this.icK.getTid(), this.icX);
            wZ("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void bZP() {
        if (this.fzp != null) {
            this.fzp.bZP();
        }
    }

    public void destroy() {
        if (this.fzp != null) {
            this.fzp.destroy();
        }
        if (this.icE != null) {
            this.icE.clearAnimation();
        }
        if (this.icI != null) {
            this.icI.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fvs);
    }

    public void onPause() {
        if (this.fzp != null) {
            if (this.fzp.pB()) {
                this.icN = true;
                this.fzp.stopPlay();
            } else if (this.fzp.getCurrentState() == 3) {
                this.icN = false;
            } else if (this.fzp.getCurrentState() == 0 || this.fzp.getCurrentState() == 1) {
                this.icN = true;
                this.fzp.stopPlay();
            } else {
                this.icN = false;
                this.fzp.stopPlay();
            }
            if (this.idd != null) {
                this.idd.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fzp != null && this.icN) {
            this.fzp.cdA();
        }
    }

    private void bZQ() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.T(true);
            dVar.V(false);
            dVar.Y(16908290).X(153).U(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hMD.getActivity());
                    if (i.this.idg == null) {
                        try {
                            i.this.idg = BitmapFactory.decodeResource(i.this.hMD.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.idg);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hT() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int hU() {
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
                    i.this.idf = null;
                    if (i.this.idg != null && !i.this.idg.isRecycled()) {
                        i.this.idg.recycle();
                    }
                    i.this.idg = null;
                }
            });
            this.idf = dVar.hV();
            this.idf.r(this.hMD.getActivity());
        }
    }

    public boolean rR(int i) {
        if (this.fzp == null) {
            return false;
        }
        return this.fzp.yT(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(String str) {
        if (this.icG != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.icG.video_md5, "", str, this.icH);
            }
        }
    }

    public void bZR() {
        if (this.icD != null) {
            this.icD.pl(this.hMD.bTt());
        }
    }

    public void bYH() {
        if (this.icD != null) {
            this.icD.bYH();
        }
    }

    public void ym(int i) {
        if (this.icD != null) {
            this.icD.ym(i);
        }
        if (this.idd != null) {
            this.idd.onChangeSkinType(i);
        }
        if (this.icI != null) {
            this.icI.jc(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bZU()) {
                    this.icQ = i;
                    if (this.icQ == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ys(i.this.aJs().getHeight());
                            }
                        }, 100L);
                    }
                    bZS();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr(int i) {
        if (aJs().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.icE.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.idj = false;
                    if (this.icV != aJs().getHeight()) {
                        this.icE.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hMD.getActivity()), Math.min(this.icV, aJs().getHeight() + i)));
                        this.fzp.bKY();
                    }
                } else if (l.af(this.hMD.getActivity()) * 0.5625d != aJs().getHeight()) {
                    this.icE.setLayoutParams(new RelativeLayout.LayoutParams(l.af(this.hMD.getActivity()), (int) Math.max(l.af(this.hMD.getActivity()) * 0.5625d, aJs().getHeight() + i)));
                    this.fzp.bKY();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bZX()) {
                int bottom = childAt.getBottom() - aJs().getBottom();
                if (childAt.getHeight() == 0 || aJs().getHeight() == 0) {
                    bottom = 0;
                }
                yr(bottom);
            } else {
                yr((-this.icV) + 2);
            }
        }
        if (!bZU() && this.idc) {
            if (this.icQ == 1) {
                this.idi = true;
                ys(aJs().getHeight());
            } else if (this.icQ == 2) {
                this.idi = true;
                int y = (int) aJs().getY();
                if (this.icR == y) {
                    ys(aJs().getHeight());
                } else {
                    this.icR = y;
                    ys(aJs().getHeight());
                }
                if (i == 0 && this.icU) {
                    this.icU = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bZP();
                        }
                    }, 100L);
                }
            } else if (this.icQ == 0) {
                if (this.idi || !"nani_midpage".equals(this.hMD.bTS())) {
                    ys(aJs().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(int i) {
        yt(i);
        bZS();
    }

    public void oZ(boolean z) {
        this.idj = z;
    }

    private void yt(int i) {
        if (this.icI != null) {
            if (i == 0) {
                i = this.icV;
            }
            float f = this.icV - i;
            float f2 = f > this.icS ? 0.0f : 1.0f - (f / this.icS);
            if (this.idj) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.icI.bZJ().setVisibility(8);
            } else {
                this.icI.bZJ().setVisibility(0);
            }
            this.icI.aO(f2);
        }
    }

    public void bZS() {
        if (this.icI != null) {
            if (bZU()) {
                this.hMD.bTU().bXQ();
            } else if (this.icI.bZJ().getVisibility() == 0) {
                this.hMD.bTU().bXQ();
                this.icJ = true;
            } else if (this.icJ) {
                this.hMD.bTU().oY(false);
                this.icJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZT() {
        return aJs().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.icP = false;
        if (this.fzp != null && this.icE != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.icE.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fSI != null && this.fSI.isShowing()) {
                    this.fSI.uk();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.idf != null) {
                    this.idf.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.icP = true;
                this.icE.setLayoutParams(layoutParams);
                this.hMD.bTU().bXQ();
                this.icJ = true;
            } else {
                e(this.icG);
                bZR();
                this.icP = false;
                this.icD.pk(true);
            }
            this.fzp.a(this.hMD.getPageContext(), configuration);
        }
    }

    public boolean bZU() {
        return this.icP;
    }

    public void q(long j, int i) {
        if (this.icI != null && j > 0) {
            this.icI.w(i, j);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.icI != null) {
            this.icI.R(onClickListener);
        }
    }

    public View aJs() {
        return this.icC;
    }

    public boolean bXZ() {
        if (aJs() == null) {
            return false;
        }
        return aJs().getBottom() > l.ah(aJs().getContext()) - l.g(aJs().getContext(), R.dimen.ds50);
    }

    public void bZV() {
        this.icU = true;
    }

    public void bZW() {
        if (this.fzp != null) {
            this.fzp.pausePlay();
        }
    }

    public View bZX() {
        return this.mEmptyView;
    }
}
