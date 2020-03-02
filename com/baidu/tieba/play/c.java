package com.baidu.tieba.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int hZI;
    private static CallStateReceiver hZJ;
    private boolean EI;
    private int EJ;
    private Runnable EO;
    protected boolean EV;
    private TbImageView OY;
    private String Pj;
    private View aCY;
    private Animation aLx;
    private TbPageContext<?> cVh;
    private int currentState;
    private w dMb;
    private QuickVideoView.b dMk;
    private g.a dVc;
    private g.f dVd;
    private g.e dVf;
    private g.InterfaceC0590g dVg;
    private SeekBar.OnSeekBarChangeListener dZZ;
    private com.baidu.tieba.play.o eek;
    private String emb;
    private VideoLoadingProgressView.a fJB;
    protected View fMf;
    private Animation guf;
    private ImageView hZA;
    private ImageView hZB;
    private int hZC;
    private int hZD;
    private int hZE;
    private int hZG;
    private int hZH;
    private boolean hZK;
    private g.b hZM;
    protected Runnable hZN;
    private Animation.AnimationListener hZP;
    private Animation.AnimationListener hZQ;
    private Runnable hZR;
    private CustomMessageListener hZS;
    public View hZc;
    private VideoListMediaControllerView hZe;
    private View hZf;
    private FrameLayout hZg;
    protected FrameLayout.LayoutParams hZh;
    private ImageView hZk;
    private View hZl;
    private View hZn;
    private g.f hZp;
    private ImageView hZr;
    private TextView hZs;
    private View hZw;
    private View hZx;
    private TextView hZy;
    private SeekBar hZz;
    private String iXA;
    private p iXO;
    private i iYa;
    private VideoControllerView.b ibM;
    private TextView jtA;
    private int jtB;
    private g.a jtC;
    private g.b jtD;
    private boolean jtE;
    private boolean jtF;
    private View.OnClickListener jtG;
    protected InterfaceC0589c jtH;
    private d jtI;
    private long jtJ;
    private o jtK;
    private h jtL;
    private j jtM;
    private k jtN;
    private m jtO;
    private a jtP;
    private n jtQ;
    private l jtR;
    private f jtS;
    private g jtT;
    private boolean jtU;
    private boolean jtV;
    private boolean jtW;
    private boolean jtX;
    private TextView jtY;
    private boolean jtZ;
    private boolean jtt;
    protected com.baidu.tieba.play.a.a jtu;
    private ProgressBar jtv;
    private View jtw;
    private SwitchImageView jtx;
    private TextView jty;
    private TextView jtz;
    private boolean jua;
    private boolean jub;
    private boolean juc;
    private int jud;
    private boolean jue;
    private boolean juf;
    private boolean jug;
    private boolean juh;
    private Runnable jui;
    private Runnable juj;
    private QuickVideoView.a juk;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    protected View.OnClickListener mOnClickListener;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mStartPosition;
    private int mStatus;
    private int mVideoType;
    private String mVideoUrl;

    /* loaded from: classes.dex */
    public interface a {
        void ml(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0589c {
        void lc();

        void ld();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bGp();

        void lI(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void rN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void lH(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void csu();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bGq();
    }

    /* loaded from: classes.dex */
    public interface j {
        void qP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bGn();

        void bGo();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean csv();

        boolean csw();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Ao(int i);

        void cyu();

        void cyv();

        void onPaused();

        void onPrepared();

        void onStarted();

        void tW();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cst();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jtt = false;
        this.EV = false;
        this.EI = false;
        this.jtE = false;
        this.jtF = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hZD = 0;
        this.hZE = 0;
        this.jtJ = 60000L;
        this.hZG = 0;
        this.hZK = false;
        this.jtU = true;
        this.jtV = true;
        this.jtW = false;
        this.jtX = false;
        this.iXA = null;
        this.currentState = -1;
        this.jtZ = false;
        this.jue = true;
        this.jug = false;
        this.juh = false;
        this.dVd = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hZe != null && c.this.jtu != null && c.this.jtu.getDuration() > 0) {
                    c.this.hZe.aZ(0, c.this.jtu.getDuration());
                }
                c.this.buN();
                if (c.this.jtK != null) {
                    c.this.jtK.onPrepared();
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buN();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OY.getVisibility() != 8) {
                    if (c.this.jtu.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jtu != null) {
                    int duration = c.this.jtu.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.juc = false;
                        c.this.mStartPosition = 0;
                        c.this.ccy();
                        c.this.hZf.setVisibility(0);
                        c.this.jtv.setProgress(c.this.jtv.getMax());
                        c.this.EJ = 100;
                        if (c.this.jtC != null) {
                            c.this.jtC.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cxW()) {
                            ((QuickVideoView) c.this.jtu).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rI(false);
                            c.this.rJ(true);
                        } else {
                            c.this.cyo();
                            c.this.jty.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jtZ) {
                                if (c.this.jtM != null) {
                                    c.this.jtM.qP(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pj, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cxW()) {
                                    ((QuickVideoView) c.this.jtu).setRecoveryState(5);
                                }
                                c.this.jtu.pause();
                                c.this.jtu.seekTo(0);
                            }
                        }
                        if (c.this.jtK != null) {
                            c.this.jtK.Ao(c.this.jtv.getMax());
                            c.this.jtK.tW();
                        }
                    }
                }
            }
        };
        this.hZM = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.fMf.setVisibility(0);
                c.this.dMb.czp();
                c.this.currentState = 4;
                if (c.this.cxW()) {
                    ((QuickVideoView) c.this.jtu).setRecoveryState(4);
                }
                if (c.this.jtD != null) {
                    c.this.jtD.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jua = true;
                }
                if (c.this.jtK != null) {
                    c.this.jtK.cyu();
                }
                c.this.juc = false;
                return true;
            }
        };
        this.hZN = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtu == null || !c.this.jtu.isPlaying()) {
                    c.this.fMf.setVisibility(0);
                    c.this.dMb.czp();
                    if (c.this.jtK != null) {
                        c.this.jtK.cyu();
                    }
                }
            }
        };
        this.dVg = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jtW) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jui, 200L);
                }
            }
        };
        this.jui = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtu == null || !c.this.jtW) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jtW = false;
                } else if (c.this.mStartPosition != c.this.jtu.getCurrentPosition()) {
                    c.this.jtW = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jui, 200L);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jtF) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juj, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZN);
            }
        };
        this.juj = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.juc = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iXO != null) {
                    c.this.iXO.cst();
                }
                if (view2.getId() != c.this.fMf.getId()) {
                    if (view2.getId() != c.this.jtx.getId()) {
                        if (view2.getId() == c.this.jtz.getId()) {
                            if (c.this.jtL != null) {
                                c.this.jtL.csu();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jty.getId()) {
                            if (c.this.jtM != null) {
                                c.this.jtM.qP(false);
                            }
                            c.this.ei(c.this.mVideoUrl, c.this.Pj);
                            return;
                        } else if (view2.getId() == c.this.hZk.getId()) {
                            int i2 = c.this.jtF ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emb).X("obj_type", i2).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emb).X("obj_type", i2).X("obj_source", 1));
                            }
                            if (c.this.jtR != null) {
                                c.this.jtR.bGo();
                            }
                            if (c.this.cxY()) {
                                if (c.this.EV) {
                                    c.this.cyc();
                                } else {
                                    c.this.cyb();
                                }
                                c.this.rF(c.this.EV);
                                return;
                            }
                            c.this.Aa();
                            return;
                        } else if (view2.getId() != c.this.hZr.getId()) {
                            if (c.this.jtG != null) {
                                c.this.jtG.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jtR != null) {
                                c.this.jtR.bGo();
                            }
                            if (c.this.cxY()) {
                                c.this.cyc();
                                c.this.rF(false);
                                return;
                            }
                            c.this.Aa();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csm();
                    c.this.cyq();
                    if (c.this.currentState != 1) {
                        c.this.cym();
                        c.this.cyn();
                    } else {
                        c.this.ccO();
                    }
                    if (c.this.jtP != null) {
                        c.this.jtP.ml(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jtu.stopPlayback();
                c.this.EI = false;
                c.this.cyh();
            }
        };
        this.hZP = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hZQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hZR = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.ccL();
            }
        };
        this.hZS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.ibM = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i2) {
                int duration;
                if (c.this.jtu != null && (duration = c.this.jtu.getDuration()) > 0 && c.this.jtv != null) {
                    c.this.jtv.setProgress((int) ((i2 * c.this.hZc.getWidth()) / duration));
                    if (c.this.jtK != null) {
                        c.this.jtK.Ao((c.this.jtu.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dZZ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cym();
                c.this.rJ(false);
                if (c.this.jtP != null) {
                    c.this.jtP.ml(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccC() != null) {
                    c.this.xA(c.this.ccC().getSeekPosition());
                    if (!c.this.ccK()) {
                        c.this.cyh();
                    } else {
                        c.this.aka();
                        if (c.this.iYa != null) {
                            c.this.iYa.bGq();
                        }
                    }
                }
                c.this.rJ(true);
                c.this.cyl();
                if (c.this.jtP != null) {
                    c.this.jtP.ml(true);
                }
                if (c.this.jtQ != null) {
                    c.this.jtQ.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.juk = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyt() {
                if (!c.this.jtZ) {
                    c.this.dMb.startLoading();
                    c.this.OY.setVisibility(0);
                    c.this.jtx.setVisibility(8);
                    c.this.jtz.setVisibility(8);
                    c.this.jty.setVisibility(8);
                    c.this.jtA.setVisibility(8);
                    c.this.fMf.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZN);
                    if (c.this.jtJ > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hZN, c.this.jtJ);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVh = tbPageContext;
            this.mRootView = view;
            this.jue = z;
            this.hZn = view;
            this.mActivity = this.cVh.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jtt = false;
        this.EV = false;
        this.EI = false;
        this.jtE = false;
        this.jtF = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hZD = 0;
        this.hZE = 0;
        this.jtJ = 60000L;
        this.hZG = 0;
        this.hZK = false;
        this.jtU = true;
        this.jtV = true;
        this.jtW = false;
        this.jtX = false;
        this.iXA = null;
        this.currentState = -1;
        this.jtZ = false;
        this.jue = true;
        this.jug = false;
        this.juh = false;
        this.dVd = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hZe != null && c.this.jtu != null && c.this.jtu.getDuration() > 0) {
                    c.this.hZe.aZ(0, c.this.jtu.getDuration());
                }
                c.this.buN();
                if (c.this.jtK != null) {
                    c.this.jtK.onPrepared();
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buN();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OY.getVisibility() != 8) {
                    if (c.this.jtu.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jtu != null) {
                    int duration = c.this.jtu.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.juc = false;
                        c.this.mStartPosition = 0;
                        c.this.ccy();
                        c.this.hZf.setVisibility(0);
                        c.this.jtv.setProgress(c.this.jtv.getMax());
                        c.this.EJ = 100;
                        if (c.this.jtC != null) {
                            c.this.jtC.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cxW()) {
                            ((QuickVideoView) c.this.jtu).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rI(false);
                            c.this.rJ(true);
                        } else {
                            c.this.cyo();
                            c.this.jty.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jtZ) {
                                if (c.this.jtM != null) {
                                    c.this.jtM.qP(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pj, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cxW()) {
                                    ((QuickVideoView) c.this.jtu).setRecoveryState(5);
                                }
                                c.this.jtu.pause();
                                c.this.jtu.seekTo(0);
                            }
                        }
                        if (c.this.jtK != null) {
                            c.this.jtK.Ao(c.this.jtv.getMax());
                            c.this.jtK.tW();
                        }
                    }
                }
            }
        };
        this.hZM = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.fMf.setVisibility(0);
                c.this.dMb.czp();
                c.this.currentState = 4;
                if (c.this.cxW()) {
                    ((QuickVideoView) c.this.jtu).setRecoveryState(4);
                }
                if (c.this.jtD != null) {
                    c.this.jtD.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jua = true;
                }
                if (c.this.jtK != null) {
                    c.this.jtK.cyu();
                }
                c.this.juc = false;
                return true;
            }
        };
        this.hZN = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtu == null || !c.this.jtu.isPlaying()) {
                    c.this.fMf.setVisibility(0);
                    c.this.dMb.czp();
                    if (c.this.jtK != null) {
                        c.this.jtK.cyu();
                    }
                }
            }
        };
        this.dVg = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jtW) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jui, 200L);
                }
            }
        };
        this.jui = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtu == null || !c.this.jtW) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jtW = false;
                } else if (c.this.mStartPosition != c.this.jtu.getCurrentPosition()) {
                    c.this.jtW = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jui, 200L);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jtF) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juj, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZN);
            }
        };
        this.juj = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.juc = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iXO != null) {
                    c.this.iXO.cst();
                }
                if (view2.getId() != c.this.fMf.getId()) {
                    if (view2.getId() != c.this.jtx.getId()) {
                        if (view2.getId() == c.this.jtz.getId()) {
                            if (c.this.jtL != null) {
                                c.this.jtL.csu();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jty.getId()) {
                            if (c.this.jtM != null) {
                                c.this.jtM.qP(false);
                            }
                            c.this.ei(c.this.mVideoUrl, c.this.Pj);
                            return;
                        } else if (view2.getId() == c.this.hZk.getId()) {
                            int i22 = c.this.jtF ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emb).X("obj_type", i22).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emb).X("obj_type", i22).X("obj_source", 1));
                            }
                            if (c.this.jtR != null) {
                                c.this.jtR.bGo();
                            }
                            if (c.this.cxY()) {
                                if (c.this.EV) {
                                    c.this.cyc();
                                } else {
                                    c.this.cyb();
                                }
                                c.this.rF(c.this.EV);
                                return;
                            }
                            c.this.Aa();
                            return;
                        } else if (view2.getId() != c.this.hZr.getId()) {
                            if (c.this.jtG != null) {
                                c.this.jtG.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jtR != null) {
                                c.this.jtR.bGo();
                            }
                            if (c.this.cxY()) {
                                c.this.cyc();
                                c.this.rF(false);
                                return;
                            }
                            c.this.Aa();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csm();
                    c.this.cyq();
                    if (c.this.currentState != 1) {
                        c.this.cym();
                        c.this.cyn();
                    } else {
                        c.this.ccO();
                    }
                    if (c.this.jtP != null) {
                        c.this.jtP.ml(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jtu.stopPlayback();
                c.this.EI = false;
                c.this.cyh();
            }
        };
        this.hZP = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hZQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hZR = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.ccL();
            }
        };
        this.hZS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.ibM = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i22) {
                int duration;
                if (c.this.jtu != null && (duration = c.this.jtu.getDuration()) > 0 && c.this.jtv != null) {
                    c.this.jtv.setProgress((int) ((i22 * c.this.hZc.getWidth()) / duration));
                    if (c.this.jtK != null) {
                        c.this.jtK.Ao((c.this.jtu.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dZZ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cym();
                c.this.rJ(false);
                if (c.this.jtP != null) {
                    c.this.jtP.ml(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccC() != null) {
                    c.this.xA(c.this.ccC().getSeekPosition());
                    if (!c.this.ccK()) {
                        c.this.cyh();
                    } else {
                        c.this.aka();
                        if (c.this.iYa != null) {
                            c.this.iYa.bGq();
                        }
                    }
                }
                c.this.rJ(true);
                c.this.cyl();
                if (c.this.jtP != null) {
                    c.this.jtP.ml(true);
                }
                if (c.this.jtQ != null) {
                    c.this.jtQ.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.juk = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyt() {
                if (!c.this.jtZ) {
                    c.this.dMb.startLoading();
                    c.this.OY.setVisibility(0);
                    c.this.jtx.setVisibility(8);
                    c.this.jtz.setVisibility(8);
                    c.this.jty.setVisibility(8);
                    c.this.jtA.setVisibility(8);
                    c.this.fMf.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZN);
                    if (c.this.jtJ > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hZN, c.this.jtJ);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVh = tbPageContext;
            this.mRootView = view;
            this.jue = z;
            this.hZn = view;
            this.mActivity = this.cVh.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.hZc = ar(this.mActivity);
        this.hZc.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hZc);
        }
        this.jtu = com.baidu.tieba.play.a.b.F(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hZc).addView(this.jtu.getView(), 0);
        this.jtu.getView().setLayoutParams(layoutParams);
        this.dMb = new w((ViewGroup) this.hZc.findViewById(R.id.auto_video_loading_container));
        this.dMb.setLoadingAnimationListener(this.fJB);
        this.hZe = (VideoListMediaControllerView) this.hZc.findViewById(R.id.media_controller);
        this.hZe.setPlayer(this.jtu);
        this.jtv = (ProgressBar) this.hZc.findViewById(R.id.pgrBottomProgress);
        this.jtv.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.jtv.setProgress(0);
        this.hZe.setOnSeekBarChangeListener(this.dZZ);
        this.hZe.setOnProgressUpdatedListener(this.ibM);
        this.hZf = this.hZc.findViewById(R.id.black_mask);
        this.fMf = this.hZc.findViewById(R.id.layout_error);
        this.fMf.setOnClickListener(this.mOnClickListener);
        this.jtY = (TextView) this.hZc.findViewById(R.id.auto_video_error_tips);
        this.hZg = (FrameLayout) this.hZc.findViewById(R.id.danmu_container);
        this.hZk = (ImageView) this.hZc.findViewById(R.id.img_full_screen);
        this.hZk.setOnClickListener(this.mOnClickListener);
        this.hZl = this.hZc.findViewById(R.id.layout_media_controller);
        this.jtw = this.hZc.findViewById(R.id.time_show_controller);
        this.jtu.setContinuePlayEnable(true);
        this.jtu.setOnPreparedListener(this.dVd);
        this.jtu.setOnCompletionListener(this.dVc);
        this.jtu.setOnErrorListener(this.hZM);
        this.jtu.setOnSeekCompleteListener(this.dVg);
        this.jtu.setOnOutInfoListener(this.dVf);
        this.jtu.setOnSurfaceDestroyedListener(this.dMk);
        if (cxW()) {
            ((QuickVideoView) this.jtu).setOnRecoveryCallback(this.juk);
        }
        this.jtx = (SwitchImageView) this.hZc.findViewById(R.id.img_play_controller);
        this.jtx.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.jtx.setState(0);
        this.jtx.setOnClickListener(this.mOnClickListener);
        this.jty = (TextView) this.hZc.findViewById(R.id.txt_replay);
        this.jty.setOnClickListener(this.mOnClickListener);
        this.jtz = (TextView) this.hZc.findViewById(R.id.txt_playnext);
        this.jtz.setOnClickListener(this.mOnClickListener);
        this.jtA = (TextView) this.hZc.findViewById(R.id.txt_next_video_title);
        this.OY = (TbImageView) this.hZc.findViewById(R.id.video_thumbnail);
        this.OY.setDefaultErrorResource(0);
        this.OY.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hZr = (ImageView) this.hZc.findViewById(R.id.img_exit);
        this.hZr.setOnClickListener(this.mOnClickListener);
        this.hZs = (TextView) this.hZc.findViewById(R.id.video_title);
        this.aCY = this.hZc.findViewById(R.id.layout_title);
        this.aCY.setVisibility(8);
        this.guf = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aLx = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hZC = this.mAudioManager.getStreamMaxVolume(3);
        this.hZH = this.mAudioManager.getStreamVolume(3);
        hZI = 100 / this.hZC;
        this.hZc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.jtN != null) {
                    c.this.jtN.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.EI) {
                        if (c.this.mStatus == 1 && c.this.hZE != 0) {
                            c.this.b(c.this.hZE == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hZE = 0;
                            c.this.hZD = 0;
                        }
                        if (!c.this.jtu.isPlaying()) {
                            c.this.jtz.setVisibility(8);
                            c.this.jty.setVisibility(8);
                            c.this.jtA.setVisibility(8);
                        }
                    }
                    c.this.ccy();
                    if (c.this.jtN != null) {
                        c.this.jtN.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eek = new com.baidu.tieba.play.o(this.mActivity);
        if (this.jue) {
            this.eek.start();
        }
        this.hZG = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hZJ == null) {
            hZJ = new CallStateReceiver();
        }
        hZJ.register(this.mActivity);
        cxX();
        MessageManager.getInstance().registerListener(this.hZS);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hZS);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Ak(int i2) {
        if (this.OY != null) {
            this.OY.setDefaultBgResource(i2);
        }
    }

    public boolean cxW() {
        return this.mVideoType == 0 && (this.jtu instanceof QuickVideoView);
    }

    public void cxX() {
        if (this.jtU) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hZc.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hZc.setSystemUiVisibility(0);
    }

    public void rD(boolean z) {
        this.jtU = z;
        cxX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccy() {
        this.mStatus = 0;
        if (this.hZw != null && this.hZw.getParent() != null && (this.hZw.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hZw.getParent()).removeView(this.hZw);
                this.hZw = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hZx != null && this.hZx.getParent() != null && (this.hZx.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hZx.getParent()).removeView(this.hZx);
                this.hZx = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ccz() {
        if (this.mStatus == 1) {
            if (this.hZw == null && this.hZc != null && (this.hZc instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hZc, true);
                this.hZw = this.hZc.findViewById(R.id.lay_jindu);
                this.hZy = (TextView) this.hZw.findViewById(R.id.show_time);
                this.hZB = (ImageView) this.hZw.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hZx == null && this.hZc != null && (this.hZc instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hZc, true);
            this.hZx = this.hZc.findViewById(R.id.lay_voice);
            this.hZA = (ImageView) this.hZx.findViewById(R.id.arrow_voice_icon);
            this.hZz = (SeekBar) this.hZx.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jtG = onClickListener;
    }

    public void rE(boolean z) {
        this.jtF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.jtN != null) {
                c.this.jtN.onStart();
            }
            if (c.this.EV && c.this.EI) {
                if (c.this.mStatus == 1) {
                    c.this.cyo();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aC(f2);
                    }
                } else {
                    if (c.this.EV) {
                        c.this.ccB();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hZD = c.this.jtu.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aC(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.juf) {
                if (c.this.jtO != null && c.this.jtO.csv()) {
                    return true;
                }
                c.this.csm();
                c.this.cyq();
                if (c.this.jtu.isPlaying()) {
                    c.this.cyl();
                } else {
                    c.this.cym();
                }
                if (c.this.jtP != null) {
                    c.this.jtP.ml(c.this.jtu.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.juf) {
                if (c.this.EI) {
                    if (c.this.jtO != null && c.this.jtO.csw()) {
                        return true;
                    }
                    c.this.cyk();
                    if (c.this.jtu.isPlaying()) {
                        c.this.cyl();
                    } else {
                        c.this.cym();
                    }
                    if (c.this.jtP != null) {
                        c.this.jtP.ml(c.this.jtu.isPlaying());
                    }
                } else {
                    c.this.csm();
                    c.this.cyq();
                    if (c.this.currentState != 1) {
                        c.this.cym();
                        c.this.cyn();
                    } else {
                        c.this.ccO();
                    }
                    if (c.this.jtP != null) {
                        c.this.jtP.ml(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZc.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZc.setSystemUiVisibility(4);
        } else {
            this.hZc.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(float f2) {
        if (!this.EI) {
            this.mStatus = 0;
            return;
        }
        ccz();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hZI == 0) {
            if (f2 > 0.0f && this.hZH < this.hZC) {
                this.hZH++;
            }
            if (f2 < 0.0f && this.hZH > 0) {
                this.hZH--;
            }
        }
        if (this.mProgress > 0) {
            this.hZA.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hZA.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hZH, 0);
        this.hZz.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hZD -= 1000;
                this.hZE = 1;
            } else {
                this.hZD += 1000;
                this.hZE = 2;
            }
            if (this.hZD < 0) {
                this.hZD = 0;
            } else if (this.hZD > this.jtu.getDuration()) {
                this.hZD = this.jtu.getDuration();
            }
        }
        ccz();
        String Au = this.hZe.Au(this.hZD);
        if (f2 > 0.0f) {
            this.hZB.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hZB.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Au)) {
            this.hZy.setText(new StringBuilder().append(Au).append("/").append(this.hZe.Au(this.jtu.getDuration())));
        }
        this.hZe.setCurrentDuration(this.hZD, z ? false : true);
        cyo();
        cyd();
    }

    protected View ar(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Al(int i2) {
        this.jtB = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pj = str2;
    }

    public void setFid(String str) {
        this.emb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        if (this.jtu != null && this.hZe != null) {
            this.hZe.showProgress();
            this.mStartPosition = x.czs().Hd(this.mVideoUrl);
            if (this.juc) {
                this.jtu.setVolume(1.0f, 1.0f);
                this.jtu.start();
                this.juc = false;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.EO, 20L);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZN);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juj);
                if (this.jtu.cyO()) {
                    this.currentState = 1;
                    if (cxW()) {
                        ((QuickVideoView) this.jtu).setRecoveryState(1);
                    }
                    cyo();
                }
                this.mStartPosition = x.czs().Hd(this.mVideoUrl);
                this.hZe.setPlayer(this.jtu);
                if (this.mStartPosition != 0) {
                    this.jtW = true;
                }
                if (!this.jub) {
                    this.hZe.showProgress();
                }
                if (!this.jtF && this.jtu.getDuration() <= 0) {
                    ccC().setVisibility(4);
                }
            }
            this.EJ = (this.mStartPosition <= 100 || this.jtu.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (this.OY.getVisibility() != 8 || !this.EI) {
            this.EI = true;
            this.hZf.setVisibility(8);
            this.fMf.setVisibility(8);
            this.dMb.czo();
            this.OY.setVisibility(8);
            cyp();
            long duration = this.jtu.getDuration() / 1000;
            String str = this.Pj;
            this.hZe.showProgress();
            this.jtv.setVisibility(0);
            if (this.hZp != null && cxW()) {
                this.hZp.onPrepared(((QuickVideoView) this.jtu).getPlayer());
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", PraiseDataPassUtil.KEY_FROM_OS);
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    private static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    protected void rF(boolean z) {
        if (hasNavBar(this.mActivity) && (this.jtw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jtw.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.jtw.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.jtw.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.jtw.setLayoutParams(layoutParams);
        }
    }

    public void csm() {
        if (this.jtu.isPlaying()) {
            pausePlay();
            if (this.jtT != null) {
                this.jtT.onPause();
            }
            if (this.jtK != null) {
                this.jtK.onPaused();
            }
        } else if (this.EI) {
            aka();
            if (this.iYa != null) {
                this.iYa.bGq();
            }
            if (this.jtK != null) {
                this.jtK.cyv();
            }
        } else {
            cyh();
        }
    }

    public void Aa() {
        this.hZK = true;
        if (this.eek != null) {
            this.eek.Aa();
        }
    }

    public boolean cxY() {
        return this.jtu != null && this.jtu.getView().getHeight() > this.jtu.getView().getWidth();
    }

    public void cxZ() {
        rF(false);
        cyc();
    }

    public boolean Am(int i2) {
        switch (i2) {
            case 4:
                if (this.EV) {
                    if (cxY()) {
                        rF(false);
                        cyc();
                    } else {
                        Aa();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hZC <= 0 || this.hZz == null) {
                    return false;
                }
                this.hZH = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hZH * 100.0d) / this.hZC);
                this.hZz.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cxW()) {
            return (QuickVideoView) this.jtu;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cya() {
        return this.jtu;
    }

    public VideoListMediaControllerView ccC() {
        return this.hZe;
    }

    public void show() {
        this.hZc.setVisibility(0);
    }

    public void ccG() {
        if (this.hZn != null) {
            ViewGroup.LayoutParams layoutParams = this.hZn.getLayoutParams();
            this.hZh = (FrameLayout.LayoutParams) this.hZc.getLayoutParams();
            this.hZh.width = layoutParams.width;
            this.hZh.height = layoutParams.height;
            this.hZh.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.hZc.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.hZc.setLayoutParams(this.hZh);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hZK) {
            if (this.EV) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hZK = false;
        }
        if (configuration.orientation == 2) {
            cyb();
        } else {
            cyc();
        }
        cyd();
        if (this.mActivity == com.baidu.adp.base.a.eH().currentActivity()) {
            aka();
        }
        cyq();
        ccO();
        if (this.jtP != null) {
            this.jtP.ml(true);
        }
    }

    protected void cyb() {
        this.EV = true;
        if (cxY()) {
            this.hZc.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hZc.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.aCY.setVisibility(0);
        this.hZr.setVisibility(0);
        this.hZs.setVisibility(0);
        this.hZg.setVisibility(8);
        this.dMb.czp();
        this.OY.setVisibility(8);
        this.hZk.setImageResource(R.drawable.icon_video_narrow_white);
        xx(this.hZG);
        ccB();
        if (this.jtH != null) {
            this.jtH.lc();
        }
    }

    protected void cyc() {
        this.EV = false;
        if (this.hZh != null) {
            this.hZc.setLayoutParams(this.hZh);
        }
        g(this.mActivity, false);
        this.aCY.setVisibility(8);
        this.hZg.setVisibility(0);
        this.dMb.czp();
        this.OY.setVisibility(8);
        this.hZk.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hZe != null && (this.hZe.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZe.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hZe.setLayoutParams(layoutParams);
        }
        this.hZc.setSystemUiVisibility(0);
        cxX();
        if (this.jtH != null) {
            this.jtH.ld();
        }
    }

    public void cyd() {
        if (this.jtu != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.EV) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.jtv.setMax(equipmentWidth);
            int duration = this.jtu.getDuration();
            if (duration > 0) {
                if (this.jty.getVisibility() == 0) {
                    this.jtv.setProgress(this.jtv.getMax());
                } else {
                    this.jtv.setProgress((int) ((this.jtu.getCurrentPositionSync() * this.jtv.getMax()) / duration));
                }
            }
        }
    }

    private void xx(int i2) {
        if (this.hZe != null && (this.hZe.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZe.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hZe.setLayoutParams(layoutParams);
        }
    }

    private void g(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            activity.getWindow().clearFlags(512);
        }
    }

    public boolean ccI() {
        return !this.EV;
    }

    public void a(g.f fVar) {
        this.hZp = fVar;
    }

    public void a(g.a aVar) {
        this.jtC = aVar;
    }

    public void a(g.b bVar) {
        this.jtD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.jtX) {
            ej(str, str2);
        } else {
            ei(str, str2);
        }
        if (eVar != null) {
            eVar.rN(z);
        }
    }

    public void eh(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, boolean z) {
        cyi();
        this.juc = true;
        this.currentState = 0;
        if (cxW()) {
            ((QuickVideoView) this.jtu).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.jtu.setVideoDuration(this.jtB);
        this.jtu.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZN);
        if (this.jtJ > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hZN, this.jtJ);
        }
        if (this.jtK != null) {
            this.jtK.onStarted();
        }
        this.dMb.startLoading();
        rG(z);
    }

    public void ei(String str, String str2) {
        z(str, str2, true);
    }

    public void ej(String str, String str2) {
        cyi();
        this.juc = true;
        this.currentState = 0;
        if (cxW()) {
            ((QuickVideoView) this.jtu).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZN);
        if (this.jtJ > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hZN, this.jtJ);
        }
        if (this.jtK != null) {
            this.jtK.onStarted();
        }
        this.dMb.startLoading();
        rG(true);
    }

    public void cye() {
        aka();
        this.jtv.setVisibility(0);
    }

    public void aka() {
        if (this.jtu != null && this.hZe != null) {
            this.EI = true;
            this.currentState = 1;
            if (cxW()) {
                ((QuickVideoView) this.jtu).setRecoveryState(1);
            }
            this.jtu.a(null);
            this.mStartPosition = x.czs().Hd(this.mVideoUrl);
            this.jtW = true;
            this.EJ = (this.mStartPosition <= 100 || this.jtu.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.dMb.czp();
            rG(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.jua && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pj)) {
            this.jua = false;
            this.jub = true;
            ei(this.mVideoUrl, this.Pj);
        }
    }

    private void rG(boolean z) {
        if (z) {
            this.OY.setVisibility(0);
            cyo();
            this.jtv.setProgress(0);
        } else {
            this.OY.setVisibility(8);
            cyo();
        }
        this.hZe.showProgress();
        this.hZf.setVisibility(8);
        this.jtz.setVisibility(8);
        this.jty.setVisibility(8);
        this.jtA.setVisibility(8);
        this.fMf.setVisibility(8);
    }

    private void cyf() {
        this.dMb.czp();
        this.jtz.setVisibility(8);
        this.jty.setVisibility(8);
        this.jtA.setVisibility(8);
        cyq();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.jtu instanceof QuickVideoView) {
            ((QuickVideoView) this.jtu).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.jtu.pause();
        this.currentState = 2;
        if (cxW()) {
            ((QuickVideoView) this.jtu).setRecoveryState(2);
        }
        cyf();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cxW()) {
            ((QuickVideoView) this.jtu).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZN);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juj);
        this.jtu.stopPlayback();
        this.EI = false;
        this.juc = false;
        this.mStartPosition = 0;
        bPO();
    }

    public void cyg() {
        if (this.jtu.getDuration() >= this.jtu.getCurrentPosition()) {
            x.czs().bl(this.mVideoUrl, this.jtu.getCurrentPosition());
        }
    }

    public void rH(boolean z) {
        this.jtV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(boolean z) {
        if (this.hZl != null) {
            this.hZf.setVisibility(0);
            this.jtz.setVisibility(8);
            this.jty.setVisibility(8);
            this.jtA.setVisibility(8);
            this.dMb.czp();
            cyo();
            this.jtv.setVisibility(8);
            this.fMf.setVisibility(8);
            this.hZe.akj();
            this.OY.setVisibility(z ? 0 : 8);
        }
    }

    public void bPO() {
        rI(true);
    }

    public boolean le() {
        if (this.jtu == null) {
            return false;
        }
        return this.jtu.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.jtu == null) {
            return 0;
        }
        return this.jtu.getCurrentPosition();
    }

    public void a(k kVar) {
        this.jtN = kVar;
    }

    public void a(j jVar) {
        this.jtM = jVar;
    }

    public void a(i iVar) {
        this.iYa = iVar;
    }

    public void a(g gVar) {
        this.jtT = gVar;
    }

    public void a(h hVar) {
        this.jtL = hVar;
    }

    public void Gw(String str) {
        this.iXA = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        a(this.mVideoUrl, this.Pj, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.jtI = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cyi();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPh().cPi()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.jtX = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.jtS != null) {
                    this.jtS.lH(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.sS(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cyj();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(R.string.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.cVh).aEC();
                return;
            } else if (this.jtS != null) {
                this.jtS.lH(true);
                return;
            } else {
                if (!this.jtt) {
                    this.jtt = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.jtR != null) {
            this.jtR.bGn();
        }
    }

    private void cyi() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPh().fy(this.mActivity);
        }
    }

    public void cyj() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.OY.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZR);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZN);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jui);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juj);
        this.eek.stop();
        hZJ.unregister(this.mActivity);
    }

    public void GX(String str) {
        this.hZs.setText(str);
    }

    public boolean ccK() {
        return this.EI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyk() {
        if (this.hZl != null) {
            if (this.jtE) {
                cyo();
            } else {
                cyn();
            }
        }
    }

    public void ccO() {
        cyn();
        cyl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyl() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZR);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.hZR, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cym() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZR);
    }

    public void cyn() {
        if (this.hZl != null && !this.jtE && !this.jug) {
            rJ(true);
            ccN();
            this.hZl.setVisibility(0);
            this.jtw.setVisibility(0);
            this.jtv.setVisibility(8);
            this.jtE = true;
            if (this.jtI != null) {
                this.jtI.lI(false);
            }
        }
    }

    public void ccL() {
        if (this.hZl != null && this.jtE) {
            rJ(false);
            ccN();
            this.hZl.setVisibility(8);
            this.jtw.setVisibility(8);
            this.jtv.setVisibility(0);
            this.guf.setAnimationListener(this.hZP);
            this.hZl.startAnimation(this.guf);
            this.jtE = false;
            if (this.jtI != null) {
                this.jtI.bGp();
            }
        }
    }

    public void cyo() {
        if (this.hZl != null && this.jtE) {
            this.aLx.cancel();
            this.guf.cancel();
            rJ(false);
            ccN();
            this.hZl.setVisibility(8);
            this.jtw.setVisibility(8);
            this.jtv.setVisibility(0);
            this.jtE = false;
            if (this.jtI != null) {
                this.jtI.bGp();
            }
        }
    }

    private void ccN() {
        if (this.hZl != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZR);
            this.aLx.setAnimationListener(null);
            this.guf.setAnimationListener(null);
            this.hZl.clearAnimation();
        }
    }

    private void cyp() {
        if (this.hZl != null) {
            this.aLx.setAnimationListener(null);
            this.guf.setAnimationListener(null);
            this.hZl.clearAnimation();
        }
    }

    public void rJ(boolean z) {
        cyq();
        if (z) {
            this.jtx.setVisibility(0);
        } else {
            this.jtx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyq() {
        if (this.currentState == 1) {
            this.jtx.setState(1);
        } else {
            this.jtx.setState(0);
        }
    }

    public void a(InterfaceC0589c interfaceC0589c) {
        this.jtH = interfaceC0589c;
    }

    public void xA(int i2) {
        this.mStartPosition = i2;
    }

    public void aj(boolean z, boolean z2) {
        if (this.eek != null) {
            if (this.hZk != null) {
                this.hZk.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hZe != null && (this.hZe.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZe.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hZe.setLayoutParams(layoutParams);
            }
            this.eek.bn(z);
        }
    }

    public int getScreenHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            if (context.getResources() != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().orientation == 2) {
                i2 = displayMetrics.widthPixels;
            } else {
                i2 = displayMetrics.heightPixels;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
        }
        return i2;
    }

    public static int getVirtualBarHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        return i2;
    }

    public int getCurrentState() {
        return this.currentState;
    }

    public void rK(boolean z) {
        this.juf = z;
    }

    public void a(m mVar) {
        this.jtO = mVar;
    }

    public void a(a aVar) {
        this.jtP = aVar;
    }

    public void a(n nVar) {
        this.jtQ = nVar;
    }

    public void a(l lVar) {
        this.jtR = lVar;
    }

    public void a(f fVar) {
        this.jtS = fVar;
    }

    public void rL(boolean z) {
        this.jtZ = z;
    }

    public void rM(boolean z) {
        this.jtF = z;
    }

    public void An(int i2) {
        this.jud = i2;
    }

    public View cyr() {
        return this.hZc;
    }

    public void a(p pVar) {
        this.iXO = pVar;
    }

    public void cys() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVh.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cVh.getPageActivity());
    }
}
