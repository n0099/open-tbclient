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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private n bBi;
    private com.baidu.tieba.play.c dxj;
    private PbActivity fFd;
    private RelativeLayout fUI;
    private com.baidu.tieba.pb.pb.main.view.b fUJ;
    private CustomFrameLayout fUK;
    private c.d fUL;
    private y fUN;
    private g fUO;
    private boolean fUP;
    private bb fUQ;
    private bb fUR;
    private String fUS;
    private float fUY;
    private int fVb;
    private double fVc;
    private float fVd;
    private long fVe;
    private PbVideoWifiTipLayout fVf;
    private int fVg;
    private c.d fVh;
    private PbFullScreenFloatingHuajiAninationView fVj;
    private com.baidu.adp.lib.guide.c fVl;
    private Bitmap fVm;
    private boolean fVn;
    private boolean fVp;
    private int fVr;
    private View mEmptyView;
    private Handler mHandler;
    private static VideoControllerView.a fba = new VideoControllerView.a() { // from class: com.baidu.tieba.pb.video.i.6
        @Override // com.baidu.tieba.play.VideoControllerView.a
        public void Tb() {
        }
    };
    private static c.i fVs = new c.i() { // from class: com.baidu.tieba.pb.video.i.7
        @Override // com.baidu.tieba.play.c.i
        public void ayw() {
        }
    };
    private String avN = null;
    private VideoInfo fUM = null;
    private boolean fUT = false;
    private int fUU = 0;
    private boolean fUV = false;
    private int fUW = 0;
    private int fUX = 0;
    private boolean fUZ = false;
    private boolean fVa = false;
    private boolean fVi = true;
    private PbFullScreenFloatingHuajiAninationView.a fVk = new PbFullScreenFloatingHuajiAninationView.a() { // from class: com.baidu.tieba.pb.video.i.1
        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.a
        public void onAnimationEnd() {
            i.this.lk(false);
        }
    };
    private boolean fVo = false;
    private c.m fVq = new c.m() { // from class: com.baidu.tieba.pb.video.i.10
        @Override // com.baidu.tieba.play.c.m
        public boolean biX() {
            if (i.this.fFd.checkUpIsLogin()) {
                i.this.fFd.bdR();
                if (i.this.fFd.bcO() == null || i.this.fFd.bcO().getPbData() == null || i.this.fFd.bcO().getPbData().bch() == null) {
                    return false;
                }
                com.baidu.tieba.pb.data.i bch = i.this.fFd.bcO().getPbData().bch();
                if (i.this.fVj == null) {
                    i.this.fVj = new PbFullScreenFloatingHuajiAninationView(i.this.fFd.getActivity());
                    i.this.fVj.setFloatingHuajiAninationListener(i.this.fVk);
                }
                i.this.fVj.lm(bch.bcn() ? false : true);
                return true;
            }
            return true;
        }

        @Override // com.baidu.tieba.play.c.m
        public boolean biY() {
            return false;
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pb.video.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (i.this.dxj != null) {
                    i.this.dxj.setNetworkChange();
                }
                if (j.kK() && j.kM() && i.this.dxj != null && i.this.dxj.bmu() && i.this.fUM != null && i.this.fUM.video_length.intValue() > 0 && i.this.fUM.video_duration.intValue() > 0) {
                    float intValue = i.this.fUM.video_length.intValue() * (1.0f - ((i.this.dxj.getCurrentPosition() * 1.0f) / (i.this.fUM.video_duration.intValue() * 1000)));
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    if ((intValue * 1.0f) / 1048576.0f >= 0.1d) {
                        l.showToast(i.this.fFd.getPageContext().getPageActivity(), String.format(i.this.fFd.getPageContext().getString(e.j.pb_video_net_change_tip), decimalFormat.format((intValue * 1.0f) / 1048576.0f)));
                    }
                }
            }
        }
    };
    private Animation.AnimationListener eZc = new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.video.i.15
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            i.this.bhK();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lk(boolean z) {
        if (this.fFd != null) {
            this.fFd.bdh();
        }
    }

    public i(PbActivity pbActivity, com.baidu.tieba.pb.pb.main.view.b bVar, VideoInfo videoInfo, long j) {
        this.fUY = 0.0f;
        this.fFd = pbActivity;
        this.fUJ = bVar;
        this.fUY = l.h(this.fFd.getActivity(), e.C0141e.ds240);
        this.fVe = j;
        f(videoInfo);
        initData();
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
    }

    private int e(VideoInfo videoInfo) {
        int aO = l.aO(this.fFd.getActivity());
        Rect w = az.w(this.fFd.getPageContext().getPageActivity());
        int aQ = w.height() <= 0 ? l.aQ(this.fFd.getActivity()) : w.height();
        int i = (int) (aO * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            this.fVc = (intValue2 * 1.0d) / intValue;
            if (this.fVc > 0.5625d) {
                i = Math.min((aO * intValue2) / intValue, aQ);
            }
        }
        this.fVb = i;
        this.fUK.setLayoutParams(new RelativeLayout.LayoutParams(aO, i));
        return i;
    }

    private void f(VideoInfo videoInfo) {
        this.fUI = (RelativeLayout) LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.video_pb_container_layout, (ViewGroup) null);
        this.fUK = (CustomFrameLayout) this.fUI.findViewById(e.g.pb_video_container);
        int e = e(videoInfo);
        int intValue = videoInfo.video_width.intValue();
        this.dxj = new com.baidu.tieba.play.c(this.fFd.getPageContext(), this.fUK, true);
        this.dxj.a(this.fVq);
        this.dxj.lS(false);
        this.dxj.a(new c.k() { // from class: com.baidu.tieba.pb.video.i.12
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
                        i.this.fVd = motionEvent.getY();
                        if (i.this.fFd.getListView() != null && i.this.fFd.getListView().getChildCount() > 0 && i.this.fFd.getListView().getChildAt(0) == i.this.biW()) {
                            i.this.fVr = i.this.biW().getTop();
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        i.this.fVd = 0.0f;
                        i.this.fVr = 0;
                        break;
                    case 2:
                        if (i.this.fFd.getListView() != null && i.this.fFd.getListView().getChildCount() > 0 && i.this.fFd.getListView().getChildAt(0) == i.this.biW()) {
                            i.this.fFd.getListView().setSelectionFromTop(0, ((int) (motionEvent.getY() - i.this.fVd)) + i.this.fVr);
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        if (intValue > 0) {
            if (this.fVc >= 1.0d) {
                this.dxj.P(false, true);
            } else {
                this.dxj.P(true, false);
            }
            this.fUZ = ((float) e) + this.fUY > ((float) l.aQ(this.fFd.getActivity()));
            if (this.fUZ) {
                if (this.fUO == null) {
                    this.fUO = new g(this.fFd.getPageContext(), this.fUK);
                }
                this.fFd.bdf().bgT();
                this.fUP = true;
            }
        }
        biO();
        this.mEmptyView = new View(this.fFd);
        this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fVb));
        if (this.fUJ != null && this.fUJ.mNavigationBar != null) {
            this.fUJ.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.fUJ.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            this.fUJ.mNavigationBar.setStatusBarVisibility(com.baidu.tbadk.core.util.g.zm() ? 0 : 8);
        }
        this.fVf = (PbVideoWifiTipLayout) this.fUI.findViewById(e.g.layout_wifi_tip);
        this.fVf.setOnPlayClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.i.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.fVn = true;
                i.this.fVf.setVisibility(8);
                i.this.startPlay();
                TiebaStatic.log("c12618");
            }
        });
    }

    private void initData() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.fFd.getActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.fUL == null) {
            this.fUL = new c.d() { // from class: com.baidu.tieba.pb.video.i.14
                @Override // com.baidu.tieba.play.c.d
                public void gr(boolean z) {
                    if (i.this.biR() && i.this.fUJ != null) {
                        loadAnimation.setAnimationListener(null);
                        i.this.fUJ.bhE().clearAnimation();
                        i.this.biP();
                        if (z) {
                            loadAnimation.setAnimationListener(i.this.eZc);
                            i.this.fUJ.bhE().startAnimation(loadAnimation);
                        }
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void ayv() {
                    if (i.this.biR()) {
                        i.this.bhK();
                    }
                }
            };
        }
        a(this.fUL);
        this.fUU = UtilHelper.getLightStatusBarHeight() + l.h(this.fFd.getActivity(), e.C0141e.ds98);
        this.mHandler = new Handler();
    }

    public void a(VideoInfo videoInfo, bb bbVar, String str) {
        if (videoInfo != null && this.dxj != null && bbVar != null) {
            this.fUM = videoInfo;
            this.fUQ = bbVar;
            this.avN = videoInfo.video_url;
            this.dxj.stopPlay();
            this.dxj.setIsNeedRecoveryVideoPlayer(true);
            this.bBi = new n(this.fFd.getActivity());
            this.fUN = new y();
            this.fUN.mLocate = "pb";
            this.fUN.aZG = bbVar.getTid();
            this.fUN.cHI = str;
            this.fUN.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fUN.mSource = bbVar.mRecomSource;
            this.fUN.goV = bbVar.mRecomWeight;
            this.fUN.goW = this.fFd.bdd();
            this.fUN.goX = bbVar.mRecomAbTag;
            this.fUN.goY = videoInfo.video_md5;
            y bnA = this.fUN.bnA();
            bnA.mLocate = Constants.VIA_SHARE_TYPE_INFO;
            this.bBi.setVideoStatsData(bnA);
            this.dxj.getVideoView().setBusiness(this.bBi);
            if (this.dxj.aUp()) {
                this.dxj.aUn();
            }
            this.dxj.b(this.fVh);
            this.fUS = null;
            this.fUR = null;
            this.dxj.sp(this.fUS);
            this.dxj.aUj().setOnDragingListener(fba);
            this.dxj.a(new c.InterfaceC0224c() { // from class: com.baidu.tieba.pb.video.i.16
                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ays() {
                    i.this.fFd.setSwipeBackEnabled(true);
                    i.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.fVg > 0) {
                                i.this.rA(i.this.fVg);
                                i.this.rB(i.this.fVg);
                                i.this.fVg = 0;
                            }
                            i.this.fVi = true;
                        }
                    }, 200L);
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0224c
                public void ayr() {
                    i.this.fFd.setSwipeBackEnabled(false);
                    i.this.fVi = false;
                    i.this.fVg = i.this.biT().getHeight();
                }
            });
            this.dxj.a(new c.h() { // from class: com.baidu.tieba.pb.video.i.17
                @Override // com.baidu.tieba.play.c.h
                public void biZ() {
                    if (i.this.fFd != null && i.this.fUR != null && !StringUtils.isNull(i.this.fUR.getId())) {
                        i.this.fFd.rL(i.this.fUR.getId());
                        if (i.this.fUQ != null) {
                            long j = 0;
                            if (i.this.fUQ.xp() != null) {
                                j = i.this.fUQ.xp().channelId;
                            }
                            TiebaStatic.log(new am("c11921").g(VideoPlayActivityConfig.OBJ_ID, j));
                        }
                    }
                }
            });
            this.dxj.a(new c.j() { // from class: com.baidu.tieba.pb.video.i.2
                @Override // com.baidu.tieba.play.c.j
                public void ll(boolean z) {
                    if (i.this.fUQ != null) {
                        long j = 0;
                        if (i.this.fUQ.xp() != null) {
                            j = i.this.fUQ.xp().channelId;
                        }
                        i.this.nc(z ? "1" : "2");
                        TiebaStatic.log(new am("c10795").al("tid", i.this.fUQ.getTid()).g(ImageViewerConfig.FORUM_ID, i.this.fUQ.getFid()).g(VideoPlayActivityConfig.OBJ_ID, j));
                    }
                }
            });
            this.dxj.a(new g.b() { // from class: com.baidu.tieba.pb.video.i.3
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", i.this.avN);
                    return true;
                }
            });
            this.dxj.setThumbnail(videoInfo.thumbnail_url);
            this.dxj.setVideoUrl(this.avN, bbVar.getTid());
            this.dxj.setFid(str);
            this.dxj.sK(bbVar.getTitle());
            this.dxj.a(fVs);
            this.dxj.aHp();
            this.dxj.show();
        }
    }

    public void so(String str) {
        if (this.fUN != null) {
            this.fUN.cHI = str;
        }
    }

    public void b(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        if (this.fUO != null) {
            this.fUO.a(postData, bbVar, iVar);
        }
    }

    public void a(c.d dVar) {
        this.fVh = dVar;
    }

    public void as(bb bbVar) {
        this.fUR = bbVar;
    }

    public void sp(String str) {
        this.fUS = str;
        if (this.dxj != null) {
            this.dxj.sp(this.fUS);
        }
    }

    public void startPlay() {
        if (this.dxj != null) {
            if (j.kM() && !this.fVn && !com.baidu.tieba.video.g.bCZ().bDa()) {
                this.fVf.setVisibility(0);
                this.fVf.setData(this.fUM);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.avN) && this.fUQ != null && this.fUQ.wE() != null) {
                TiebaStatic.log(new am("c12619").al("obj_locate", "pb").al("tid", this.fUQ.getTid()));
                this.avN = this.fUQ.wE().video_url;
            }
            this.dxj.b(this.avN, this.fUQ == null ? "" : this.fUQ.getTid(), this.fVe);
            nc("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void biN() {
        if (this.dxj != null) {
            this.dxj.biN();
        }
    }

    public void destroy() {
        if (this.dxj != null) {
            this.dxj.destroy();
        }
        if (this.fUK != null) {
            this.fUK.clearAnimation();
        }
        if (this.fUO != null) {
            this.fUO.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
    }

    public void onPause() {
        if (this.dxj != null) {
            if (this.dxj.bmu()) {
                this.fUT = true;
                this.dxj.stopPlay();
            } else if (this.dxj.getCurrentState() == 3) {
                this.fUT = false;
            } else if (this.dxj.getCurrentState() == 0 || this.dxj.getCurrentState() == 1) {
                this.fUT = true;
                this.dxj.stopPlay();
            } else {
                this.fUT = false;
                this.dxj.stopPlay();
            }
            if (this.fVj != null) {
                this.fVj.stopAnimation();
            }
        }
    }

    public void onResume() {
        if (this.dxj != null && this.fUT) {
            this.dxj.aUr();
        }
    }

    private void biO() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_video_pb_double_tap_tips", false)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_video_pb_double_tap_tips", true);
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.N(true);
            dVar.P(false);
            dVar.ag(16908290).af(153).O(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.pb.video.i.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    ImageView imageView = new ImageView(i.this.fFd.getActivity());
                    if (i.this.fVm == null) {
                        try {
                            i.this.fVm = BitmapFactory.decodeResource(i.this.fFd.getResources(), e.f.live_video_guide_like);
                            imageView.setImageBitmap(i.this.fVm);
                        } catch (Throwable th) {
                        }
                    }
                    return imageView;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iC() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int iD() {
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
            dVar.b(new d.a() { // from class: com.baidu.tieba.pb.video.i.5
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    i.this.fVl = null;
                    if (i.this.fVm != null && !i.this.fVm.isRecycled()) {
                        i.this.fVm.recycle();
                    }
                    i.this.fVm = null;
                }
            });
            this.fVl = dVar.iE();
            this.fVl.o(this.fFd.getActivity());
        }
    }

    public boolean lo(int i) {
        if (this.dxj == null) {
            return false;
        }
        return this.dxj.sb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(String str) {
        if (this.fUM != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fUM.video_md5, "", str, this.fUN);
            }
        }
    }

    public void biP() {
        if (this.fUJ != null) {
            this.fUJ.lc(this.fFd.bcE());
        }
    }

    public void bhK() {
        if (this.fUJ != null) {
            this.fUJ.bhK();
        }
    }

    public void rv(int i) {
        if (this.fUJ != null) {
            this.fUJ.rv(i);
        }
        if (this.fVj != null) {
            this.fVj.onChangeSkinType(i);
        }
        if (this.fUO != null) {
            this.fUO.dQ(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
            case 1:
            default:
                if (!biS()) {
                    this.fUW = i;
                    if (this.fUW == 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.8
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.rB(i.this.biT().getHeight());
                            }
                        }, 100L);
                    }
                    biQ();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(int i) {
        if (biT().getHeight() + i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fUK.getLayoutParams();
            if ((layoutParams.width != -1 || layoutParams.height != -1) && i != 0) {
                if (i > 0) {
                    this.fVp = false;
                    if (this.fVb != biT().getHeight()) {
                        this.fUK.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fFd.getActivity()), Math.min(this.fVb, biT().getHeight() + i)));
                        this.dxj.aUn();
                    }
                } else if (l.aO(this.fFd.getActivity()) * 0.5625d != biT().getHeight()) {
                    this.fUK.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(this.fFd.getActivity()), (int) Math.max(l.aO(this.fFd.getActivity()) * 0.5625d, biT().getHeight() + i)));
                    this.dxj.aUn();
                }
            }
        }
    }

    public void b(AbsListView absListView, int i) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == biW()) {
                int bottom = childAt.getBottom() - biT().getBottom();
                if (childAt.getHeight() == 0 || biT().getHeight() == 0) {
                    bottom = 0;
                }
                rA(bottom);
            } else {
                rA((-this.fVb) + 2);
            }
        }
        if (!biS() && this.fVi) {
            if (this.fUW == 1) {
                this.fVo = true;
                rB(biT().getHeight());
            } else if (this.fUW == 2) {
                this.fVo = true;
                int y = (int) biT().getY();
                if (this.fUX == y) {
                    rB(biT().getHeight());
                } else {
                    this.fUX = y;
                    rB(biT().getHeight());
                }
                if (i == 0 && this.fVa) {
                    this.fVa = false;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.video.i.9
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.biN();
                        }
                    }, 100L);
                }
            } else if (this.fUW == 0) {
                if (this.fVo || !"nani_midpage".equals(this.fFd.bdd())) {
                    rB(biT().getHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(int i) {
        rC(i);
        biQ();
    }

    public void kO(boolean z) {
        this.fVp = z;
    }

    private void rC(int i) {
        if (this.fUO != null) {
            if (i == 0) {
                i = this.fVb;
            }
            float f = this.fVb - i;
            float f2 = f > this.fUY ? 0.0f : 1.0f - (f / this.fUY);
            if (this.fVp) {
                f2 = 0.0f;
            }
            if (f2 == 0.0f) {
                this.fUO.biJ().setVisibility(8);
            } else {
                this.fUO.biJ().setVisibility(0);
            }
            this.fUO.at(f2);
        }
    }

    public void biQ() {
        if (this.fUO != null) {
            if (biS()) {
                this.fFd.bdf().bgT();
            } else if (this.fUO.biJ().getVisibility() == 0) {
                this.fFd.bdf().bgT();
                this.fUP = true;
            } else if (this.fUP) {
                this.fFd.bdf().kN(false);
                this.fUP = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean biR() {
        return biT().getY() >= 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        this.fUV = false;
        if (this.dxj != null && this.fUK != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fUK.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                if (this.fVl != null) {
                    this.fVl.dismiss();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.fUV = true;
                this.fUK.setLayoutParams(layoutParams);
                this.fFd.bdf().bgT();
                this.fUP = true;
            } else {
                e(this.fUM);
                biP();
                this.fUV = false;
                this.fUJ.lb(true);
            }
            this.dxj.a(this.fFd.getPageContext(), configuration);
        }
    }

    public boolean biS() {
        return this.fUV;
    }

    public void n(long j, int i) {
        if (this.fUO != null && j > 0) {
            this.fUO.l(i, j);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.fUO != null) {
            this.fUO.L(onClickListener);
        }
    }

    public View biT() {
        return this.fUI;
    }

    public boolean bhc() {
        if (biT() == null) {
            return false;
        }
        return biT().getBottom() > l.aQ(biT().getContext()) - l.h(biT().getContext(), e.C0141e.ds50);
    }

    public void biU() {
        this.fVa = true;
    }

    public void biV() {
        if (this.dxj != null) {
            this.dxj.pausePlay();
        }
    }

    public View biW() {
        return this.mEmptyView;
    }
}
