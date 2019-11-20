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
    private static VideoControllerView.a hii = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.9
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void aDT() {
        }
    };
    private static c.i iee = new c.i() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.i
        public void bmn() {
        }
    };
    private boolean Fa;
    private n dvI;
    private com.baidu.tieba.play.c fAq;
    private com.baidu.mcn.c fTS;
    private PbActivity hNh;
    private g idA;
    private boolean idB;
    private bh idC;
    private bh idD;
    private String idE;
    private float idK;
    private int idN;
    private double idO;
    private long idP;
    private PbVideoWifiTipLayout idQ;
    private int idR;
    private c.d idT;
    private PbFullScreenFloatingHuajiAninationView idV;
    private com.baidu.adp.lib.guide.c idX;
    private Bitmap idY;
    private boolean idZ;
    private RelativeLayout idu;
    private com.baidu.tieba.pb.pb.main.view.c idv;
    private CustomFrameLayout idw;
    private c.d idx;
    private z idz;
    private boolean ieb;
    private int ied;
    private View mEmptyView;
    private Handler mHandler;
    private float mLastY;
    private String cln = null;
    private VideoInfo idy = null;
    private boolean idF = false;
    private int idG = 0;
    private boolean idH = false;
    private int idI = 0;
    private int idJ = 0;
    private boolean idL = false;
    private boolean idM = false;
    private long startPosition = -1;
    private int fen = 0;
    private c.p idS = new c.p() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.play.c.p
        public void bYd() {
            if (i.this.hNh != null && i.this.hNh.bRD() != null && i.this.hNh.bRD().getPbData() != null) {
                PostData bQE = i.this.hNh.bRD().getPbData().bQE();
                if (bQE == null && v.getCount(i.this.hNh.bRD().getPbData().bQz()) > 1) {
                    bQE = (PostData) v.getItem(i.this.hNh.bRD().getPbData().bQz(), 0);
                }
                com.baidu.tieba.pb.c.a.a(i.this.hNh.bRD().getPbData(), bQE, 1, 1, 4);
            }
        }
    };
    private boolean idU = true;
    private PbFullScreenFloatingHuajiAninationView.a idW = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.12
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.pg(false);
        }
    };
    private boolean iea = false;
    private c.m iec = new c.m() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // com.baidu.tieba.play.c.m
        public boolean bYf() {
            if (i.this.idO < 1.0d || !TbSingleton.getInstance().isVideoEnterMiddlePage()) {
                return false;
            }
            if (i.this.hNh.checkUpIsLogin()) {
                i.this.hNh.bSH();
                if (i.this.hNh.bRD() == null || i.this.hNh.bRD().getPbData() == null || i.this.hNh.bRD().getPbData().bQU() == null) {
                    return false;
                }
                j bQU = i.this.hNh.bRD().getPbData().bQU();
                if (i.this.idV == null) {
                    i.this.idV = new PbFullScreenFloatingHuajiAninationView(i.this.hNh.getActivity());
                    i.this.idV.setFloatingHuajiAninationListener(i.this.idW);
                }
                i.this.idV.pj(bQU.bRd() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean bYg() {
            return false;
        }
    };
    private CustomMessageListener qJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pb.video.i.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (i.this.fAq != null) {
                    i.this.fAq.setNetworkChange();
                }
                if (com.baidu.adp.lib.util.j.isMobileNet() && i.this.fAq != null && i.this.fAq.kx() && i.this.idy != null && i.this.idy.video_length.intValue() > 0 && i.this.idy.video_duration.intValue() > 0) {
                    float intValue = i.this.idy.video_length.intValue() * (1.0f - ((i.this.fAq.getCurrentPosition() * 1.0f) / (i.this.idy.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.hNh.getPageContext().getPageActivity(), String.format(i.this.hNh.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
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
            i.this.bWM();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private CustomMessageListener fwb = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.pb.video.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.idy != null) {
                i.this.e(i.this.idy);
                i.this.fAq.cbW();
                i.this.fAq.bIG();
                if (i.this.mEmptyView != null && i.this.mEmptyView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = i.this.mEmptyView.getLayoutParams();
                    layoutParams.height = i.this.idN;
                    i.this.mEmptyView.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void pg(boolean z) {
        if (this.hNh != null) {
            this.hNh.bRX();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.c cVar, VideoInfo videoInfo, long j) {
        this.idK = 0.0f;
        this.hNh = pbActivity;
        this.idv = cVar;
        this.idK = l.getDimens(this.hNh.getActivity(), R.dimen.ds240);
        this.idP = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.qJ);
        this.fwb.setTag(pbActivity.getUniqueId());
        this.fwb.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fwb);
        this.fTS = new com.baidu.mcn.c(pbActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(VideoInfo videoInfo) {
        int equipmentWidth = l.getEquipmentWidth(this.hNh.getActivity());
        Rect visibilityRegion = bb.getVisibilityRegion(this.hNh.getPageContext().getPageActivity());
        int equipmentHeight = visibilityRegion.height() <= 0 ? l.getEquipmentHeight(this.hNh.getActivity()) : visibilityRegion.height();
        int i = (int) (equipmentWidth * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.idO = (intValue2 * 1.0d) / intValue;
            if (this.idO > 0.5625d) {
                i = Math.min((equipmentWidth * intValue2) / intValue, equipmentHeight);
            }
        }
        this.idN = i;
        this.idw.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, i));
        return i;
    }

    public boolean aOf() {
        return this.idO >= 1.0d;
    }

    public int bXT() {
        return this.idN;
    }

    private void f(VideoInfo videoInfo) {
        int i = 0;
        this.idu = (RelativeLayout) LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.idw = (CustomFrameLayout) this.idu.findViewById(R.id.pb_video_container);
        int e = e(videoInfo);
        this.Fa = ((double) this.idN) <= (((double) l.getEquipmentWidth(this.hNh.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        this.fAq = new com.baidu.tieba.play.c(this.hNh.getPageContext(), this.idw, true, com.baidu.tbadk.a.b.mb("cyber_player_test") ? 1 : 0);
        this.fAq.a(this.iec);
        this.fAq.pO(false);
        this.fAq.a(this.idS);
        this.fAq.a(new c.n() { // from class: com.baidu.tieba.pb.video.i.17
            @Override // com.baidu.tieba.play.c.n
            public void onStopTrackingTouch(SeekBar seekBar) {
                i.this.startPosition = -1L;
            }
        });
        if (TbSingleton.getInstance().isNotchScreen(this.hNh) || TbSingleton.getInstance().isCutoutScreen(this.hNh)) {
            this.fAq.pF(false);
        }
        this.fAq.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.18
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
                        if (i.this.hNh.getListView() != null && i.this.hNh.getListView().getChildCount() > 0 && i.this.hNh.getListView().getChildAt(0) == i.this.bYc()) {
                            i.this.ied = i.this.bYc().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.mLastY = 0.0f;
                        i.this.ied = 0;
                        break;
                    case 2:
                        if (i.this.hNh.getListView() != null && i.this.hNh.getListView().getChildCount() > 0 && i.this.hNh.getListView().getChildAt(0) == i.this.bYc()) {
                            i.this.hNh.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.mLastY)) + i.this.ied);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.idO >= 1.0d) {
                this.fAq.ag(false, true);
            } else {
                this.fAq.ag(true, false);
            }
            this.idL = ((float) e) + this.idK > ((float) l.getEquipmentHeight(this.hNh.getActivity()));
            if (this.idL) {
                if (this.idA == null) {
                    this.idA = new g(this.hNh.getPageContext(), this.idw);
                }
                this.hNh.bRV().bVU();
                this.idB = true;
            }
        }
        bXV();
        this.mEmptyView = new View(this.hNh);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.idN));
        if (this.idv != null && this.idv.mNavigationBar != null) {
            this.idv.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.idv.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar = this.idv.mNavigationBar;
            if (!com.baidu.tbadk.core.util.g.alW() && !TbSingleton.getInstance().isNotchScreen(this.hNh) && !TbSingleton.getInstance().isCutoutScreen(this.hNh)) {
                i = 8;
            }
            navigationBar.setStatusBarVisibility(i);
        }
        this.idQ = (PbVideoWifiTipLayout) this.idu.findViewById(R.id.layout_wifi_tip);
        this.idQ.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.idZ = true;
                i.this.idQ.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
        if (this.fTS != null) {
            this.fTS.reset();
        }
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.hNh.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.idx == null) {
            this.idx = new c.d() { // from class: com.baidu.tieba.pb.video.i.20
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (i.this.bXY() && i.this.idv != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.idv.bWF().clearAnimation();
                        i.this.bXW();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.hgi);
                            i.this.idv.bWF().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmm() {
                    if (i.this.bXY()) {
                        i.this.bWM();
                    }
                }
            };
        }
        a(this.idx);
        this.idG = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hNh.getActivity(), R.dimen.ds98);
        this.mHandler = new Handler();
    }

    public void a(final VideoInfo videoInfo, final bh bhVar, final String str) {
        if (videoInfo != null && this.fAq != null && bhVar != null) {
            this.idy = videoInfo;
            this.idC = bhVar;
            this.cln = videoInfo.video_url;
            this.fAq.stopPlay();
            this.fAq.setIsNeedRecoveryVideoPlayer(true);
            this.dvI = new n(this.hNh.getActivity());
            this.idz = new z();
            this.idz.mLocate = "pb";
            this.idz.cma = bhVar.getTid();
            this.idz.ePc = str;
            this.idz.mUid = TbadkCoreApplication.getCurrentAccount();
            this.idz.iyl = this.hNh.bRS();
            av bSJ = this.hNh.bSJ();
            if (bSJ != null) {
                bSJ.b(this.idz);
            }
            this.idz.iyn = videoInfo.video_md5;
            z ccS = this.idz.ccS();
            ccS.mLocate = "6";
            this.startPosition = -1L;
            this.dvI.a(new j.b() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    boolean z = true;
                    if (i.this.startPosition <= 0) {
                        i.this.startPosition = i2;
                    }
                    McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
                    if (mcnAdInfo != null) {
                        boolean du = com.baidu.mcn.b.ze().du(mcnAdInfo.jump_url);
                        if (i.this.Fa && !du && !i.this.idH) {
                            boolean z2 = i.this.startPosition >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                            if (i2 < mcnAdInfo.ad_start_time.longValue() * 1000 || i2 >= mcnAdInfo.ad_end_time.longValue() * 1000) {
                                z = false;
                            }
                            if (z) {
                                if (!i.this.fTS.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.ayz = mcnAdInfo.card_title;
                                    aVar.ayA = mcnAdInfo.button_title;
                                    aVar.ayB = mcnAdInfo.jump_url;
                                    aVar.ayy = mcnAdInfo.pic_url;
                                    aVar.fid = str;
                                    aVar.tid = bhVar.getTid();
                                    aVar.ayC = 4;
                                    if (z2) {
                                        i.this.fTS.b(aVar, (ViewGroup) i.this.fAq.cbV());
                                    } else {
                                        i.this.fTS.a(aVar, (ViewGroup) i.this.fAq.cbV());
                                    }
                                }
                            } else if (i.this.fTS.isShowing()) {
                                i.this.fTS.dismiss();
                            }
                        }
                    }
                }
            });
            this.dvI.setVideoStatsData(ccS);
            this.fAq.cbE().setBusiness(this.dvI);
            if (this.fAq.bII()) {
                this.fAq.bIG();
            }
            this.fAq.b(this.idT);
            this.idE = null;
            this.idD = null;
            this.fAq.Bn(this.idE);
            this.fAq.bIC().setOnDragingListener(hii);
            this.fAq.a(new c.InterfaceC0497c() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kw() {
                    i.this.hNh.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.idR > 0) {
                                i.this.xb(i.this.idR);
                                i.this.xc(i.this.idR);
                                i.this.idR = 0;
                            }
                            i.this.idU = true;
                        }
                    }, 200L);
                    i.this.startPosition = -1L;
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0497c
                public void kv() {
                    i.this.hNh.setSwipeBackEnabled(false);
                    i.this.idU = false;
                    i.this.idR = i.this.aJw().getHeight();
                }
            });
            this.fAq.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.tieba.play.c.h
                public void bYe() {
                    if (i.this.hNh != null && i.this.idD != null && !StringUtils.isNull(i.this.idD.getId())) {
                        i.this.hNh.AG(i.this.idD.getId());
                        if (i.this.idC != null) {
                            long j = 0;
                            if (i.this.idC.ajN() != null) {
                                j = i.this.idC.ajN().channelId;
                            }
                            TiebaStatic.log(new an("c11921").p("obj_id", j));
                        }
                    }
                }
            });
            this.fAq.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.tieba.play.c.j
                public void ph(boolean z) {
                    if (i.this.idC != null) {
                        long j = 0;
                        if (i.this.idC.ajN() != null) {
                            j = i.this.idC.ajN().channelId;
                        }
                        i.this.vR(z ? "1" : "2");
                        TiebaStatic.log(new an("c10795").bS("tid", i.this.idC.getTid()).p("fid", i.this.idC.getFid()).p("obj_id", j));
                    }
                }
            });
            this.fAq.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.cln);
                    return true;
                }
            });
            this.fAq.setThumbnail(videoInfo.thumbnail_url);
            this.fAq.setVideoUrl(this.cln, bhVar.getTid());
            this.fAq.setFid(str);
            this.fAq.BN(bhVar.getTitle());
            this.fAq.a(iee);
            this.fAq.bvK();
            this.fAq.show();
        }
    }

    public void Bm(String str) {
        if (this.idz != null) {
            this.idz.ePc = str;
        }
    }

    public void b(PostData postData, bh bhVar, com.baidu.tieba.pb.data.j jVar) {
        if (this.idA != null) {
            this.idA.a(postData, bhVar, jVar);
        }
    }

    public void a(c.d dVar) {
        this.idT = dVar;
    }

    public void aB(bh bhVar) {
        this.idD = bhVar;
    }

    public void Bn(String str) {
        this.idE = str;
        if (this.fAq != null) {
            this.fAq.Bn(this.idE);
        }
    }

    public void startPlay() {
        if (this.fAq != null) {
            if (com.baidu.adp.lib.util.j.isMobileNet() && !this.idZ && !com.baidu.tieba.video.g.csB().csC()) {
                this.idQ.setVisibility(0);
                this.idQ.setData(this.idy);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.cln) && this.idC != null && this.idC.aiV() != null) {
                TiebaStatic.log(new an("c12619").bS("obj_locate", "pb").bS("tid", this.idC.getTid()));
                this.cln = this.idC.aiV().video_url;
            }
            this.fAq.cm(this.cln, this.idC == null ? "" : this.idC.getTid());
            vR("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
    }

    public void bXU() {
        if (this.fAq != null) {
            this.fAq.bXU();
        }
    }

    public void destroy() {
        if (this.fAq != null) {
            this.fAq.destroy();
        }
        if (this.idw != null) {
            this.idw.clearAnimation();
        }
        if (this.idA != null) {
            this.idA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.qJ);
        MessageManager.getInstance().unRegisterListener(this.fwb);
    }

    public void onPause() {
        if (this.fAq != null) {
            if (this.fAq.kx()) {
                this.idF = true;
                this.fAq.stopPlay();
            } else if (this.fAq.getCurrentState() == 3) {
                this.idF = false;
            } else if (this.fAq.getCurrentState() == 0 || this.fAq.getCurrentState() == 1) {
                this.idF = true;
                this.fAq.stopPlay();
            } else {
                this.idF = false;
                this.fAq.stopPlay();
            }
            if (this.idV != null) {
                this.idV.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.fAq != null && this.idF) {
            this.fAq.cbI();
        }
    }

    private void bXV() {
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, false)) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_VIDEO_PB_DOUBLE_TAP_TIPS, true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.A(true);
            dVar.C(false);
            dVar.J(16908290).I(153).B(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.7
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.hNh.getActivity());
                    if (i.this.idY == null) {
                        try {
                            i.this.idY = BitmapFactory.decodeResource(i.this.hNh.getResources(), R.drawable.pb_video_guide_like);
                            imageView.setImageBitmap(i.this.idY);
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
                    i.this.idX = null;
                    if (i.this.idY != null && !i.this.idY.isRecycled()) {
                        i.this.idY.recycle();
                    }
                    i.this.idY = null;
                }
            });
            this.idX = dVar.fu();
            this.idX.showOnDecorView(this.hNh.getActivity());
        }
    }

    public boolean qO(int i) {
        if (this.fAq == null) {
            return false;
        }
        return this.fAq.xC(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.idy != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.idy.video_md5, "", str, this.idz);
            }
        }
    }

    public void bXW() {
        if (this.idv != null) {
            this.idv.oY(this.hNh.bRt());
        }
    }

    public void bWM() {
        if (this.idv != null) {
            this.idv.bWM();
        }
    }

    public void wW(int i) {
        if (this.idv != null) {
            this.idv.wW(i);
        }
        if (this.idV != null) {
            this.idV.onChangeSkinType(i);
        }
        if (this.idA != null) {
            this.idA.onChangeSkin(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!bXZ()) {
                    this.idI = i;
                    if (this.idI == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.11
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.xc(i.this.aJw().getHeight());
                            }
                        }, 100L);
                    }
                    bXX();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb(int i) {
        if (aJw().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idw.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.ieb = false;
                    if (this.idN != aJw().getHeight()) {
                        this.idw.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.hNh.getActivity()), Math.min(this.idN, aJw().getHeight() + i)));
                        this.fAq.bIG();
                    }
                } else if (l.getEquipmentWidth(this.hNh.getActivity()) * 0.5625d != aJw().getHeight()) {
                    this.idw.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.hNh.getActivity()), (int) Math.max(l.getEquipmentWidth(this.hNh.getActivity()) * 0.5625d, aJw().getHeight() + i)));
                    this.fAq.bIG();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == bYc()) {
                int bottom = childAt.getBottom() - aJw().getBottom();
                if (childAt.getHeight() == 0 || aJw().getHeight() == 0) {
                    bottom = 0;
                }
                xb(bottom);
            } else {
                xb((-this.idN) + 2);
            }
        }
        if (!bXZ() && this.idU) {
            if (this.idI == 1) {
                this.iea = true;
                xc(aJw().getHeight());
            } else if (this.idI == 2) {
                this.iea = true;
                int y = (int) aJw().getY();
                if (this.idJ == y) {
                    xc(aJw().getHeight());
                } else {
                    this.idJ = y;
                    xc(aJw().getHeight());
                }
                if (i == 0 && this.idM) {
                    this.idM = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.13
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.bXU();
                        }
                    }, 100L);
                }
            } else if (this.idI == 0) {
                if (this.iea || !"nani_midpage".equals(this.hNh.bRS())) {
                    xc(aJw().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(int i) {
        xd(i);
        bXX();
    }

    public void oM(boolean z) {
        this.ieb = z;
    }

    private void xd(int i) {
        if (this.idA != null) {
            if (i == 0) {
                i = this.idN;
            }
            float f = this.idN - i;
            float f2 = f > this.idK ? 0.0f : 1.0f - (f / this.idK);
            if (this.ieb) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.idA.bXP().setVisibility(8);
            } else {
                this.idA.bXP().setVisibility(0);
            }
            this.idA.as(f2);
        }
    }

    public void bXX() {
        if (this.idA != null) {
            if (bXZ()) {
                this.hNh.bRV().bVU();
            } else if (this.idA.bXP().getVisibility() == 0) {
                this.hNh.bRV().bVU();
                this.idB = true;
            } else if (this.idB) {
                this.hNh.bRV().oL(false);
                this.idB = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXY() {
        return aJw().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.idH = false;
        if (this.fAq != null && this.idw != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idw.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                if (this.fTS != null && this.fTS.isShowing()) {
                    this.fTS.zf();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS));
                if (this.idX != null) {
                    this.idX.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.idH = true;
                this.idw.setLayoutParams(layoutParams);
                this.hNh.bRV().bVU();
                this.idB = true;
            } else {
                e(this.idy);
                bXW();
                this.idH = false;
                this.idv.oX(true);
            }
            this.fAq.a(this.hNh.getPageContext(), configuration);
        }
    }

    public boolean bXZ() {
        return this.idH;
    }

    public void r(long j, int i) {
        if (this.idA != null && j > 0) {
            this.idA.u(i, j);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.idA != null) {
            this.idA.S(onClickListener);
        }
    }

    public View aJw() {
        return this.idu;
    }

    public boolean bWd() {
        if (aJw() == null) {
            return false;
        }
        return aJw().getBottom() > l.getEquipmentHeight(aJw().getContext()) - l.getDimens(aJw().getContext(), R.dimen.ds50);
    }

    public void bYa() {
        this.idM = true;
    }

    public void bYb() {
        if (this.fAq != null) {
            this.fAq.pausePlay();
        }
    }

    public View bYc() {
        return this.mEmptyView;
    }
}
