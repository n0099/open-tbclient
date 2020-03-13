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
    private static int hZU;
    private static CallStateReceiver hZV;
    private boolean EI;
    private int EJ;
    private Runnable EO;
    protected boolean EV;
    private TbImageView OY;
    private String Pj;
    private View aCZ;
    private Animation aLy;
    private TbPageContext<?> cVi;
    private int currentState;
    private w dMo;
    private QuickVideoView.b dMx;
    private g.a dVp;
    private g.f dVq;
    private g.e dVs;
    private g.InterfaceC0590g dVt;
    private SeekBar.OnSeekBarChangeListener eam;
    private com.baidu.tieba.play.o eex;
    private String emo;
    private VideoLoadingProgressView.a fJO;
    protected View fMs;
    private Animation gur;
    private g.f hZB;
    private ImageView hZD;
    private TextView hZE;
    private View hZI;
    private View hZJ;
    private TextView hZK;
    private SeekBar hZL;
    private ImageView hZM;
    private ImageView hZN;
    private int hZO;
    private int hZP;
    private int hZQ;
    private int hZS;
    private int hZT;
    private boolean hZW;
    private g.b hZY;
    protected Runnable hZZ;
    public View hZo;
    private VideoListMediaControllerView hZq;
    private View hZr;
    private FrameLayout hZs;
    protected FrameLayout.LayoutParams hZt;
    private ImageView hZw;
    private View hZx;
    private View hZz;
    private String iXM;
    private p iYa;
    private i iYm;
    private Animation.AnimationListener iab;
    private Animation.AnimationListener iac;
    private Runnable iad;
    private CustomMessageListener iae;
    private VideoControllerView.b ibY;
    private boolean jtF;
    protected com.baidu.tieba.play.a.a jtG;
    private ProgressBar jtH;
    private View jtI;
    private SwitchImageView jtJ;
    private TextView jtK;
    private TextView jtL;
    private TextView jtM;
    private int jtN;
    private g.a jtO;
    private g.b jtP;
    private boolean jtQ;
    private boolean jtR;
    private View.OnClickListener jtS;
    protected InterfaceC0589c jtT;
    private d jtU;
    private long jtV;
    private o jtW;
    private h jtX;
    private j jtY;
    private k jtZ;
    private m jua;
    private a jub;
    private n juc;
    private l jud;
    private f jue;
    private g juf;
    private boolean jug;
    private boolean juh;
    private boolean jui;
    private boolean juj;
    private TextView juk;
    private boolean jul;
    private boolean jum;
    private boolean jun;
    private boolean juo;
    private int jup;
    private boolean juq;
    private boolean jur;
    private boolean jus;
    private boolean jut;
    private Runnable juu;
    private Runnable juv;
    private QuickVideoView.a juw;
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
        void bGq();

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
        void csv();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bGr();
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
        void bGo();

        void bGp();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean csw();

        boolean csx();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Ao(int i);

        void cyv();

        void cyw();

        void onPaused();

        void onPrepared();

        void onStarted();

        void tW();
    }

    /* loaded from: classes.dex */
    public interface p {
        void csu();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jtF = false;
        this.EV = false;
        this.EI = false;
        this.jtQ = false;
        this.jtR = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hZP = 0;
        this.hZQ = 0;
        this.jtV = 60000L;
        this.hZS = 0;
        this.hZW = false;
        this.jug = true;
        this.juh = true;
        this.jui = false;
        this.juj = false;
        this.iXM = null;
        this.currentState = -1;
        this.jul = false;
        this.juq = true;
        this.jus = false;
        this.jut = false;
        this.dVq = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hZq != null && c.this.jtG != null && c.this.jtG.getDuration() > 0) {
                    c.this.hZq.aZ(0, c.this.jtG.getDuration());
                }
                c.this.buO();
                if (c.this.jtW != null) {
                    c.this.jtW.onPrepared();
                }
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buO();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OY.getVisibility() != 8) {
                    if (c.this.jtG.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jtG != null) {
                    int duration = c.this.jtG.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.juo = false;
                        c.this.mStartPosition = 0;
                        c.this.ccz();
                        c.this.hZr.setVisibility(0);
                        c.this.jtH.setProgress(c.this.jtH.getMax());
                        c.this.EJ = 100;
                        if (c.this.jtO != null) {
                            c.this.jtO.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cxX()) {
                            ((QuickVideoView) c.this.jtG).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rI(false);
                            c.this.rJ(true);
                        } else {
                            c.this.cyp();
                            c.this.jtK.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jul) {
                                if (c.this.jtY != null) {
                                    c.this.jtY.qP(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pj, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cxX()) {
                                    ((QuickVideoView) c.this.jtG).setRecoveryState(5);
                                }
                                c.this.jtG.pause();
                                c.this.jtG.seekTo(0);
                            }
                        }
                        if (c.this.jtW != null) {
                            c.this.jtW.Ao(c.this.jtH.getMax());
                            c.this.jtW.tW();
                        }
                    }
                }
            }
        };
        this.hZY = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.fMs.setVisibility(0);
                c.this.dMo.czq();
                c.this.currentState = 4;
                if (c.this.cxX()) {
                    ((QuickVideoView) c.this.jtG).setRecoveryState(4);
                }
                if (c.this.jtP != null) {
                    c.this.jtP.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jum = true;
                }
                if (c.this.jtW != null) {
                    c.this.jtW.cyv();
                }
                c.this.juo = false;
                return true;
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtG == null || !c.this.jtG.isPlaying()) {
                    c.this.fMs.setVisibility(0);
                    c.this.dMo.czq();
                    if (c.this.jtW != null) {
                        c.this.jtW.cyv();
                    }
                }
            }
        };
        this.dVt = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jui) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juu, 200L);
                }
            }
        };
        this.juu = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtG == null || !c.this.jui) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jui = false;
                } else if (c.this.mStartPosition != c.this.jtG.getCurrentPosition()) {
                    c.this.jui = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juu, 200L);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jtR) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juv, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZZ);
            }
        };
        this.juv = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.juo = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iYa != null) {
                    c.this.iYa.csu();
                }
                if (view2.getId() != c.this.fMs.getId()) {
                    if (view2.getId() != c.this.jtJ.getId()) {
                        if (view2.getId() == c.this.jtL.getId()) {
                            if (c.this.jtX != null) {
                                c.this.jtX.csv();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jtK.getId()) {
                            if (c.this.jtY != null) {
                                c.this.jtY.qP(false);
                            }
                            c.this.ei(c.this.mVideoUrl, c.this.Pj);
                            return;
                        } else if (view2.getId() == c.this.hZw.getId()) {
                            int i2 = c.this.jtR ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emo).X("obj_type", i2).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emo).X("obj_type", i2).X("obj_source", 1));
                            }
                            if (c.this.jud != null) {
                                c.this.jud.bGp();
                            }
                            if (c.this.cxZ()) {
                                if (c.this.EV) {
                                    c.this.cyd();
                                } else {
                                    c.this.cyc();
                                }
                                c.this.rF(c.this.EV);
                                return;
                            }
                            c.this.Aa();
                            return;
                        } else if (view2.getId() != c.this.hZD.getId()) {
                            if (c.this.jtS != null) {
                                c.this.jtS.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jud != null) {
                                c.this.jud.bGp();
                            }
                            if (c.this.cxZ()) {
                                c.this.cyd();
                                c.this.rF(false);
                                return;
                            }
                            c.this.Aa();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csn();
                    c.this.cyr();
                    if (c.this.currentState != 1) {
                        c.this.cyn();
                        c.this.cyo();
                    } else {
                        c.this.ccP();
                    }
                    if (c.this.jub != null) {
                        c.this.jub.ml(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jtG.stopPlayback();
                c.this.EI = false;
                c.this.cyi();
            }
        };
        this.iab = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.iac = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.iad = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.ccM();
            }
        };
        this.iae = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.ibY = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i2) {
                int duration;
                if (c.this.jtG != null && (duration = c.this.jtG.getDuration()) > 0 && c.this.jtH != null) {
                    c.this.jtH.setProgress((int) ((i2 * c.this.hZo.getWidth()) / duration));
                    if (c.this.jtW != null) {
                        c.this.jtW.Ao((c.this.jtG.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eam = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cyn();
                c.this.rJ(false);
                if (c.this.jub != null) {
                    c.this.jub.ml(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccD() != null) {
                    c.this.xA(c.this.ccD().getSeekPosition());
                    if (!c.this.ccL()) {
                        c.this.cyi();
                    } else {
                        c.this.aka();
                        if (c.this.iYm != null) {
                            c.this.iYm.bGr();
                        }
                    }
                }
                c.this.rJ(true);
                c.this.cym();
                if (c.this.jub != null) {
                    c.this.jub.ml(true);
                }
                if (c.this.juc != null) {
                    c.this.juc.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.juw = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyu() {
                if (!c.this.jul) {
                    c.this.dMo.startLoading();
                    c.this.OY.setVisibility(0);
                    c.this.jtJ.setVisibility(8);
                    c.this.jtL.setVisibility(8);
                    c.this.jtK.setVisibility(8);
                    c.this.jtM.setVisibility(8);
                    c.this.fMs.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZZ);
                    if (c.this.jtV > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hZZ, c.this.jtV);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVi = tbPageContext;
            this.mRootView = view;
            this.juq = z;
            this.hZz = view;
            this.mActivity = this.cVi.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jtF = false;
        this.EV = false;
        this.EI = false;
        this.jtQ = false;
        this.jtR = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hZP = 0;
        this.hZQ = 0;
        this.jtV = 60000L;
        this.hZS = 0;
        this.hZW = false;
        this.jug = true;
        this.juh = true;
        this.jui = false;
        this.juj = false;
        this.iXM = null;
        this.currentState = -1;
        this.jul = false;
        this.juq = true;
        this.jus = false;
        this.jut = false;
        this.dVq = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hZq != null && c.this.jtG != null && c.this.jtG.getDuration() > 0) {
                    c.this.hZq.aZ(0, c.this.jtG.getDuration());
                }
                c.this.buO();
                if (c.this.jtW != null) {
                    c.this.jtW.onPrepared();
                }
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buO();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OY.getVisibility() != 8) {
                    if (c.this.jtG.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jtG != null) {
                    int duration = c.this.jtG.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.juo = false;
                        c.this.mStartPosition = 0;
                        c.this.ccz();
                        c.this.hZr.setVisibility(0);
                        c.this.jtH.setProgress(c.this.jtH.getMax());
                        c.this.EJ = 100;
                        if (c.this.jtO != null) {
                            c.this.jtO.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cxX()) {
                            ((QuickVideoView) c.this.jtG).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rI(false);
                            c.this.rJ(true);
                        } else {
                            c.this.cyp();
                            c.this.jtK.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jul) {
                                if (c.this.jtY != null) {
                                    c.this.jtY.qP(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pj, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cxX()) {
                                    ((QuickVideoView) c.this.jtG).setRecoveryState(5);
                                }
                                c.this.jtG.pause();
                                c.this.jtG.seekTo(0);
                            }
                        }
                        if (c.this.jtW != null) {
                            c.this.jtW.Ao(c.this.jtH.getMax());
                            c.this.jtW.tW();
                        }
                    }
                }
            }
        };
        this.hZY = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.fMs.setVisibility(0);
                c.this.dMo.czq();
                c.this.currentState = 4;
                if (c.this.cxX()) {
                    ((QuickVideoView) c.this.jtG).setRecoveryState(4);
                }
                if (c.this.jtP != null) {
                    c.this.jtP.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jum = true;
                }
                if (c.this.jtW != null) {
                    c.this.jtW.cyv();
                }
                c.this.juo = false;
                return true;
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtG == null || !c.this.jtG.isPlaying()) {
                    c.this.fMs.setVisibility(0);
                    c.this.dMo.czq();
                    if (c.this.jtW != null) {
                        c.this.jtW.cyv();
                    }
                }
            }
        };
        this.dVt = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jui) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juu, 200L);
                }
            }
        };
        this.juu = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jtG == null || !c.this.jui) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jui = false;
                } else if (c.this.mStartPosition != c.this.jtG.getCurrentPosition()) {
                    c.this.jui = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juu, 200L);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jtR) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juv, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZZ);
            }
        };
        this.juv = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.juo = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iYa != null) {
                    c.this.iYa.csu();
                }
                if (view2.getId() != c.this.fMs.getId()) {
                    if (view2.getId() != c.this.jtJ.getId()) {
                        if (view2.getId() == c.this.jtL.getId()) {
                            if (c.this.jtX != null) {
                                c.this.jtX.csv();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jtK.getId()) {
                            if (c.this.jtY != null) {
                                c.this.jtY.qP(false);
                            }
                            c.this.ei(c.this.mVideoUrl, c.this.Pj);
                            return;
                        } else if (view2.getId() == c.this.hZw.getId()) {
                            int i22 = c.this.jtR ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emo).X("obj_type", i22).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.emo).X("obj_type", i22).X("obj_source", 1));
                            }
                            if (c.this.jud != null) {
                                c.this.jud.bGp();
                            }
                            if (c.this.cxZ()) {
                                if (c.this.EV) {
                                    c.this.cyd();
                                } else {
                                    c.this.cyc();
                                }
                                c.this.rF(c.this.EV);
                                return;
                            }
                            c.this.Aa();
                            return;
                        } else if (view2.getId() != c.this.hZD.getId()) {
                            if (c.this.jtS != null) {
                                c.this.jtS.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jud != null) {
                                c.this.jud.bGp();
                            }
                            if (c.this.cxZ()) {
                                c.this.cyd();
                                c.this.rF(false);
                                return;
                            }
                            c.this.Aa();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csn();
                    c.this.cyr();
                    if (c.this.currentState != 1) {
                        c.this.cyn();
                        c.this.cyo();
                    } else {
                        c.this.ccP();
                    }
                    if (c.this.jub != null) {
                        c.this.jub.ml(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jtG.stopPlayback();
                c.this.EI = false;
                c.this.cyi();
            }
        };
        this.iab = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.iac = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.iad = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.ccM();
            }
        };
        this.iae = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.ibY = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i22) {
                int duration;
                if (c.this.jtG != null && (duration = c.this.jtG.getDuration()) > 0 && c.this.jtH != null) {
                    c.this.jtH.setProgress((int) ((i22 * c.this.hZo.getWidth()) / duration));
                    if (c.this.jtW != null) {
                        c.this.jtW.Ao((c.this.jtG.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eam = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cyn();
                c.this.rJ(false);
                if (c.this.jub != null) {
                    c.this.jub.ml(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccD() != null) {
                    c.this.xA(c.this.ccD().getSeekPosition());
                    if (!c.this.ccL()) {
                        c.this.cyi();
                    } else {
                        c.this.aka();
                        if (c.this.iYm != null) {
                            c.this.iYm.bGr();
                        }
                    }
                }
                c.this.rJ(true);
                c.this.cym();
                if (c.this.jub != null) {
                    c.this.jub.ml(true);
                }
                if (c.this.juc != null) {
                    c.this.juc.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.juw = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyu() {
                if (!c.this.jul) {
                    c.this.dMo.startLoading();
                    c.this.OY.setVisibility(0);
                    c.this.jtJ.setVisibility(8);
                    c.this.jtL.setVisibility(8);
                    c.this.jtK.setVisibility(8);
                    c.this.jtM.setVisibility(8);
                    c.this.fMs.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZZ);
                    if (c.this.jtV > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hZZ, c.this.jtV);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVi = tbPageContext;
            this.mRootView = view;
            this.juq = z;
            this.hZz = view;
            this.mActivity = this.cVi.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.hZo = at(this.mActivity);
        this.hZo.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hZo);
        }
        this.jtG = com.baidu.tieba.play.a.b.F(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hZo).addView(this.jtG.getView(), 0);
        this.jtG.getView().setLayoutParams(layoutParams);
        this.dMo = new w((ViewGroup) this.hZo.findViewById(R.id.auto_video_loading_container));
        this.dMo.setLoadingAnimationListener(this.fJO);
        this.hZq = (VideoListMediaControllerView) this.hZo.findViewById(R.id.media_controller);
        this.hZq.setPlayer(this.jtG);
        this.jtH = (ProgressBar) this.hZo.findViewById(R.id.pgrBottomProgress);
        this.jtH.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.jtH.setProgress(0);
        this.hZq.setOnSeekBarChangeListener(this.eam);
        this.hZq.setOnProgressUpdatedListener(this.ibY);
        this.hZr = this.hZo.findViewById(R.id.black_mask);
        this.fMs = this.hZo.findViewById(R.id.layout_error);
        this.fMs.setOnClickListener(this.mOnClickListener);
        this.juk = (TextView) this.hZo.findViewById(R.id.auto_video_error_tips);
        this.hZs = (FrameLayout) this.hZo.findViewById(R.id.danmu_container);
        this.hZw = (ImageView) this.hZo.findViewById(R.id.img_full_screen);
        this.hZw.setOnClickListener(this.mOnClickListener);
        this.hZx = this.hZo.findViewById(R.id.layout_media_controller);
        this.jtI = this.hZo.findViewById(R.id.time_show_controller);
        this.jtG.setContinuePlayEnable(true);
        this.jtG.setOnPreparedListener(this.dVq);
        this.jtG.setOnCompletionListener(this.dVp);
        this.jtG.setOnErrorListener(this.hZY);
        this.jtG.setOnSeekCompleteListener(this.dVt);
        this.jtG.setOnOutInfoListener(this.dVs);
        this.jtG.setOnSurfaceDestroyedListener(this.dMx);
        if (cxX()) {
            ((QuickVideoView) this.jtG).setOnRecoveryCallback(this.juw);
        }
        this.jtJ = (SwitchImageView) this.hZo.findViewById(R.id.img_play_controller);
        this.jtJ.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.jtJ.setState(0);
        this.jtJ.setOnClickListener(this.mOnClickListener);
        this.jtK = (TextView) this.hZo.findViewById(R.id.txt_replay);
        this.jtK.setOnClickListener(this.mOnClickListener);
        this.jtL = (TextView) this.hZo.findViewById(R.id.txt_playnext);
        this.jtL.setOnClickListener(this.mOnClickListener);
        this.jtM = (TextView) this.hZo.findViewById(R.id.txt_next_video_title);
        this.OY = (TbImageView) this.hZo.findViewById(R.id.video_thumbnail);
        this.OY.setDefaultErrorResource(0);
        this.OY.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hZD = (ImageView) this.hZo.findViewById(R.id.img_exit);
        this.hZD.setOnClickListener(this.mOnClickListener);
        this.hZE = (TextView) this.hZo.findViewById(R.id.video_title);
        this.aCZ = this.hZo.findViewById(R.id.layout_title);
        this.aCZ.setVisibility(8);
        this.gur = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aLy = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hZO = this.mAudioManager.getStreamMaxVolume(3);
        this.hZT = this.mAudioManager.getStreamVolume(3);
        hZU = 100 / this.hZO;
        this.hZo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.jtZ != null) {
                    c.this.jtZ.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.EI) {
                        if (c.this.mStatus == 1 && c.this.hZQ != 0) {
                            c.this.b(c.this.hZQ == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hZQ = 0;
                            c.this.hZP = 0;
                        }
                        if (!c.this.jtG.isPlaying()) {
                            c.this.jtL.setVisibility(8);
                            c.this.jtK.setVisibility(8);
                            c.this.jtM.setVisibility(8);
                        }
                    }
                    c.this.ccz();
                    if (c.this.jtZ != null) {
                        c.this.jtZ.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eex = new com.baidu.tieba.play.o(this.mActivity);
        if (this.juq) {
            this.eex.start();
        }
        this.hZS = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hZV == null) {
            hZV = new CallStateReceiver();
        }
        hZV.register(this.mActivity);
        cxY();
        MessageManager.getInstance().registerListener(this.iae);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.iae);
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

    public boolean cxX() {
        return this.mVideoType == 0 && (this.jtG instanceof QuickVideoView);
    }

    public void cxY() {
        if (this.jug) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hZo.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hZo.setSystemUiVisibility(0);
    }

    public void rD(boolean z) {
        this.jug = z;
        cxY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccz() {
        this.mStatus = 0;
        if (this.hZI != null && this.hZI.getParent() != null && (this.hZI.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hZI.getParent()).removeView(this.hZI);
                this.hZI = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hZJ != null && this.hZJ.getParent() != null && (this.hZJ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hZJ.getParent()).removeView(this.hZJ);
                this.hZJ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ccA() {
        if (this.mStatus == 1) {
            if (this.hZI == null && this.hZo != null && (this.hZo instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hZo, true);
                this.hZI = this.hZo.findViewById(R.id.lay_jindu);
                this.hZK = (TextView) this.hZI.findViewById(R.id.show_time);
                this.hZN = (ImageView) this.hZI.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hZJ == null && this.hZo != null && (this.hZo instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hZo, true);
            this.hZJ = this.hZo.findViewById(R.id.lay_voice);
            this.hZM = (ImageView) this.hZJ.findViewById(R.id.arrow_voice_icon);
            this.hZL = (SeekBar) this.hZJ.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jtS = onClickListener;
    }

    public void rE(boolean z) {
        this.jtR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.jtZ != null) {
                c.this.jtZ.onStart();
            }
            if (c.this.EV && c.this.EI) {
                if (c.this.mStatus == 1) {
                    c.this.cyp();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aC(f2);
                    }
                } else {
                    if (c.this.EV) {
                        c.this.ccC();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hZP = c.this.jtG.getCurrentPosition();
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
            if (!c.this.jur) {
                if (c.this.jua != null && c.this.jua.csw()) {
                    return true;
                }
                c.this.csn();
                c.this.cyr();
                if (c.this.jtG.isPlaying()) {
                    c.this.cym();
                } else {
                    c.this.cyn();
                }
                if (c.this.jub != null) {
                    c.this.jub.ml(c.this.jtG.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.jur) {
                if (c.this.EI) {
                    if (c.this.jua != null && c.this.jua.csx()) {
                        return true;
                    }
                    c.this.cyl();
                    if (c.this.jtG.isPlaying()) {
                        c.this.cym();
                    } else {
                        c.this.cyn();
                    }
                    if (c.this.jub != null) {
                        c.this.jub.ml(c.this.jtG.isPlaying());
                    }
                } else {
                    c.this.csn();
                    c.this.cyr();
                    if (c.this.currentState != 1) {
                        c.this.cyn();
                        c.this.cyo();
                    } else {
                        c.this.ccP();
                    }
                    if (c.this.jub != null) {
                        c.this.jub.ml(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccC() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZo.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZo.setSystemUiVisibility(4);
        } else {
            this.hZo.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(float f2) {
        if (!this.EI) {
            this.mStatus = 0;
            return;
        }
        ccA();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hZU == 0) {
            if (f2 > 0.0f && this.hZT < this.hZO) {
                this.hZT++;
            }
            if (f2 < 0.0f && this.hZT > 0) {
                this.hZT--;
            }
        }
        if (this.mProgress > 0) {
            this.hZM.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hZM.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hZT, 0);
        this.hZL.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hZP -= 1000;
                this.hZQ = 1;
            } else {
                this.hZP += 1000;
                this.hZQ = 2;
            }
            if (this.hZP < 0) {
                this.hZP = 0;
            } else if (this.hZP > this.jtG.getDuration()) {
                this.hZP = this.jtG.getDuration();
            }
        }
        ccA();
        String Au = this.hZq.Au(this.hZP);
        if (f2 > 0.0f) {
            this.hZN.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hZN.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Au)) {
            this.hZK.setText(new StringBuilder().append(Au).append("/").append(this.hZq.Au(this.jtG.getDuration())));
        }
        this.hZq.setCurrentDuration(this.hZP, z ? false : true);
        cyp();
        cye();
    }

    protected View at(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Al(int i2) {
        this.jtN = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pj = str2;
    }

    public void setFid(String str) {
        this.emo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.jtG != null && this.hZq != null) {
            this.hZq.showProgress();
            this.mStartPosition = x.czt().He(this.mVideoUrl);
            if (this.juo) {
                this.jtG.setVolume(1.0f, 1.0f);
                this.jtG.start();
                this.juo = false;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.EO, 20L);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZZ);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juv);
                if (this.jtG.cyP()) {
                    this.currentState = 1;
                    if (cxX()) {
                        ((QuickVideoView) this.jtG).setRecoveryState(1);
                    }
                    cyp();
                }
                this.mStartPosition = x.czt().He(this.mVideoUrl);
                this.hZq.setPlayer(this.jtG);
                if (this.mStartPosition != 0) {
                    this.jui = true;
                }
                if (!this.jun) {
                    this.hZq.showProgress();
                }
                if (!this.jtR && this.jtG.getDuration() <= 0) {
                    ccD().setVisibility(4);
                }
            }
            this.EJ = (this.mStartPosition <= 100 || this.jtG.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (this.OY.getVisibility() != 8 || !this.EI) {
            this.EI = true;
            this.hZr.setVisibility(8);
            this.fMs.setVisibility(8);
            this.dMo.czp();
            this.OY.setVisibility(8);
            cyq();
            long duration = this.jtG.getDuration() / 1000;
            String str = this.Pj;
            this.hZq.showProgress();
            this.jtH.setVisibility(0);
            if (this.hZB != null && cxX()) {
                this.hZB.onPrepared(((QuickVideoView) this.jtG).getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.jtI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jtI.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.jtI.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.jtI.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.jtI.setLayoutParams(layoutParams);
        }
    }

    public void csn() {
        if (this.jtG.isPlaying()) {
            pausePlay();
            if (this.juf != null) {
                this.juf.onPause();
            }
            if (this.jtW != null) {
                this.jtW.onPaused();
            }
        } else if (this.EI) {
            aka();
            if (this.iYm != null) {
                this.iYm.bGr();
            }
            if (this.jtW != null) {
                this.jtW.cyw();
            }
        } else {
            cyi();
        }
    }

    public void Aa() {
        this.hZW = true;
        if (this.eex != null) {
            this.eex.Aa();
        }
    }

    public boolean cxZ() {
        return this.jtG != null && this.jtG.getView().getHeight() > this.jtG.getView().getWidth();
    }

    public void cya() {
        rF(false);
        cyd();
    }

    public boolean Am(int i2) {
        switch (i2) {
            case 4:
                if (this.EV) {
                    if (cxZ()) {
                        rF(false);
                        cyd();
                    } else {
                        Aa();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hZO <= 0 || this.hZL == null) {
                    return false;
                }
                this.hZT = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hZT * 100.0d) / this.hZO);
                this.hZL.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cxX()) {
            return (QuickVideoView) this.jtG;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cyb() {
        return this.jtG;
    }

    public VideoListMediaControllerView ccD() {
        return this.hZq;
    }

    public void show() {
        this.hZo.setVisibility(0);
    }

    public void ccH() {
        if (this.hZz != null) {
            ViewGroup.LayoutParams layoutParams = this.hZz.getLayoutParams();
            this.hZt = (FrameLayout.LayoutParams) this.hZo.getLayoutParams();
            this.hZt.width = layoutParams.width;
            this.hZt.height = layoutParams.height;
            this.hZt.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.hZo.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.hZo.setLayoutParams(this.hZt);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hZW) {
            if (this.EV) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hZW = false;
        }
        if (configuration.orientation == 2) {
            cyc();
        } else {
            cyd();
        }
        cye();
        if (this.mActivity == com.baidu.adp.base.a.eH().currentActivity()) {
            aka();
        }
        cyr();
        ccP();
        if (this.jub != null) {
            this.jub.ml(true);
        }
    }

    protected void cyc() {
        this.EV = true;
        if (cxZ()) {
            this.hZo.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hZo.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.aCZ.setVisibility(0);
        this.hZD.setVisibility(0);
        this.hZE.setVisibility(0);
        this.hZs.setVisibility(8);
        this.dMo.czq();
        this.OY.setVisibility(8);
        this.hZw.setImageResource(R.drawable.icon_video_narrow_white);
        xx(this.hZS);
        ccC();
        if (this.jtT != null) {
            this.jtT.lc();
        }
    }

    protected void cyd() {
        this.EV = false;
        if (this.hZt != null) {
            this.hZo.setLayoutParams(this.hZt);
        }
        g(this.mActivity, false);
        this.aCZ.setVisibility(8);
        this.hZs.setVisibility(0);
        this.dMo.czq();
        this.OY.setVisibility(8);
        this.hZw.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hZq != null && (this.hZq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZq.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hZq.setLayoutParams(layoutParams);
        }
        this.hZo.setSystemUiVisibility(0);
        cxY();
        if (this.jtT != null) {
            this.jtT.ld();
        }
    }

    public void cye() {
        if (this.jtG != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.EV) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.jtH.setMax(equipmentWidth);
            int duration = this.jtG.getDuration();
            if (duration > 0) {
                if (this.jtK.getVisibility() == 0) {
                    this.jtH.setProgress(this.jtH.getMax());
                } else {
                    this.jtH.setProgress((int) ((this.jtG.getCurrentPositionSync() * this.jtH.getMax()) / duration));
                }
            }
        }
    }

    private void xx(int i2) {
        if (this.hZq != null && (this.hZq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZq.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hZq.setLayoutParams(layoutParams);
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

    public boolean ccJ() {
        return !this.EV;
    }

    public void a(g.f fVar) {
        this.hZB = fVar;
    }

    public void a(g.a aVar) {
        this.jtO = aVar;
    }

    public void a(g.b bVar) {
        this.jtP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.juj) {
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
        cyj();
        this.juo = true;
        this.currentState = 0;
        if (cxX()) {
            ((QuickVideoView) this.jtG).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.jtG.setVideoDuration(this.jtN);
        this.jtG.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZZ);
        if (this.jtV > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hZZ, this.jtV);
        }
        if (this.jtW != null) {
            this.jtW.onStarted();
        }
        this.dMo.startLoading();
        rG(z);
    }

    public void ei(String str, String str2) {
        z(str, str2, true);
    }

    public void ej(String str, String str2) {
        cyj();
        this.juo = true;
        this.currentState = 0;
        if (cxX()) {
            ((QuickVideoView) this.jtG).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZZ);
        if (this.jtV > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hZZ, this.jtV);
        }
        if (this.jtW != null) {
            this.jtW.onStarted();
        }
        this.dMo.startLoading();
        rG(true);
    }

    public void cyf() {
        aka();
        this.jtH.setVisibility(0);
    }

    public void aka() {
        if (this.jtG != null && this.hZq != null) {
            this.EI = true;
            this.currentState = 1;
            if (cxX()) {
                ((QuickVideoView) this.jtG).setRecoveryState(1);
            }
            this.jtG.a(null);
            this.mStartPosition = x.czt().He(this.mVideoUrl);
            this.jui = true;
            this.EJ = (this.mStartPosition <= 100 || this.jtG.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.dMo.czq();
            rG(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.jum && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pj)) {
            this.jum = false;
            this.jun = true;
            ei(this.mVideoUrl, this.Pj);
        }
    }

    private void rG(boolean z) {
        if (z) {
            this.OY.setVisibility(0);
            cyp();
            this.jtH.setProgress(0);
        } else {
            this.OY.setVisibility(8);
            cyp();
        }
        this.hZq.showProgress();
        this.hZr.setVisibility(8);
        this.jtL.setVisibility(8);
        this.jtK.setVisibility(8);
        this.jtM.setVisibility(8);
        this.fMs.setVisibility(8);
    }

    private void cyg() {
        this.dMo.czq();
        this.jtL.setVisibility(8);
        this.jtK.setVisibility(8);
        this.jtM.setVisibility(8);
        cyr();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.jtG instanceof QuickVideoView) {
            ((QuickVideoView) this.jtG).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.jtG.pause();
        this.currentState = 2;
        if (cxX()) {
            ((QuickVideoView) this.jtG).setRecoveryState(2);
        }
        cyg();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cxX()) {
            ((QuickVideoView) this.jtG).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZZ);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juv);
        this.jtG.stopPlayback();
        this.EI = false;
        this.juo = false;
        this.mStartPosition = 0;
        bPP();
    }

    public void cyh() {
        if (this.jtG.getDuration() >= this.jtG.getCurrentPosition()) {
            x.czt().bl(this.mVideoUrl, this.jtG.getCurrentPosition());
        }
    }

    public void rH(boolean z) {
        this.juh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(boolean z) {
        if (this.hZx != null) {
            this.hZr.setVisibility(0);
            this.jtL.setVisibility(8);
            this.jtK.setVisibility(8);
            this.jtM.setVisibility(8);
            this.dMo.czq();
            cyp();
            this.jtH.setVisibility(8);
            this.fMs.setVisibility(8);
            this.hZq.akj();
            this.OY.setVisibility(z ? 0 : 8);
        }
    }

    public void bPP() {
        rI(true);
    }

    public boolean le() {
        if (this.jtG == null) {
            return false;
        }
        return this.jtG.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.jtG == null) {
            return 0;
        }
        return this.jtG.getCurrentPosition();
    }

    public void a(k kVar) {
        this.jtZ = kVar;
    }

    public void a(j jVar) {
        this.jtY = jVar;
    }

    public void a(i iVar) {
        this.iYm = iVar;
    }

    public void a(g gVar) {
        this.juf = gVar;
    }

    public void a(h hVar) {
        this.jtX = hVar;
    }

    public void Gx(String str) {
        this.iXM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        a(this.mVideoUrl, this.Pj, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.jtU = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cyj();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPi().cPj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.juj = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.jue != null) {
                    this.jue.lH(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.sS(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cyk();
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
                aVar.b(this.cVi).aEC();
                return;
            } else if (this.jue != null) {
                this.jue.lH(true);
                return;
            } else {
                if (!this.jtF) {
                    this.jtF = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.jud != null) {
            this.jud.bGo();
        }
    }

    private void cyj() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPi().fy(this.mActivity);
        }
    }

    public void cyk() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.OY.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iad);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZZ);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juu);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juv);
        this.eex.stop();
        hZV.unregister(this.mActivity);
    }

    public void GY(String str) {
        this.hZE.setText(str);
    }

    public boolean ccL() {
        return this.EI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyl() {
        if (this.hZx != null) {
            if (this.jtQ) {
                cyp();
            } else {
                cyo();
            }
        }
    }

    public void ccP() {
        cyo();
        cym();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cym() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iad);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.iad, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyn() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iad);
    }

    public void cyo() {
        if (this.hZx != null && !this.jtQ && !this.jus) {
            rJ(true);
            ccO();
            this.hZx.setVisibility(0);
            this.jtI.setVisibility(0);
            this.jtH.setVisibility(8);
            this.jtQ = true;
            if (this.jtU != null) {
                this.jtU.lI(false);
            }
        }
    }

    public void ccM() {
        if (this.hZx != null && this.jtQ) {
            rJ(false);
            ccO();
            this.hZx.setVisibility(8);
            this.jtI.setVisibility(8);
            this.jtH.setVisibility(0);
            this.gur.setAnimationListener(this.iab);
            this.hZx.startAnimation(this.gur);
            this.jtQ = false;
            if (this.jtU != null) {
                this.jtU.bGq();
            }
        }
    }

    public void cyp() {
        if (this.hZx != null && this.jtQ) {
            this.aLy.cancel();
            this.gur.cancel();
            rJ(false);
            ccO();
            this.hZx.setVisibility(8);
            this.jtI.setVisibility(8);
            this.jtH.setVisibility(0);
            this.jtQ = false;
            if (this.jtU != null) {
                this.jtU.bGq();
            }
        }
    }

    private void ccO() {
        if (this.hZx != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iad);
            this.aLy.setAnimationListener(null);
            this.gur.setAnimationListener(null);
            this.hZx.clearAnimation();
        }
    }

    private void cyq() {
        if (this.hZx != null) {
            this.aLy.setAnimationListener(null);
            this.gur.setAnimationListener(null);
            this.hZx.clearAnimation();
        }
    }

    public void rJ(boolean z) {
        cyr();
        if (z) {
            this.jtJ.setVisibility(0);
        } else {
            this.jtJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyr() {
        if (this.currentState == 1) {
            this.jtJ.setState(1);
        } else {
            this.jtJ.setState(0);
        }
    }

    public void a(InterfaceC0589c interfaceC0589c) {
        this.jtT = interfaceC0589c;
    }

    public void xA(int i2) {
        this.mStartPosition = i2;
    }

    public void aj(boolean z, boolean z2) {
        if (this.eex != null) {
            if (this.hZw != null) {
                this.hZw.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hZq != null && (this.hZq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZq.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hZq.setLayoutParams(layoutParams);
            }
            this.eex.bn(z);
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
        this.jur = z;
    }

    public void a(m mVar) {
        this.jua = mVar;
    }

    public void a(a aVar) {
        this.jub = aVar;
    }

    public void a(n nVar) {
        this.juc = nVar;
    }

    public void a(l lVar) {
        this.jud = lVar;
    }

    public void a(f fVar) {
        this.jue = fVar;
    }

    public void rL(boolean z) {
        this.jul = z;
    }

    public void rM(boolean z) {
        this.jtR = z;
    }

    public void An(int i2) {
        this.jup = i2;
    }

    public View cys() {
        return this.hZo;
    }

    public void a(p pVar) {
        this.iYa = pVar;
    }

    public void cyt() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVi.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cVi.getPageActivity());
    }
}
