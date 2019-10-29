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
    private static int hgS;
    private static CallStateReceiver hgT;
    private boolean Cd;
    private int Ce;
    private Runnable Cj;
    protected boolean Cp;
    private View aqA;
    private Animation azf;
    private x cUk;
    private QuickVideoView.b cUt;
    private TbPageContext<?> cfl;
    private String cmS;
    private String cmf;
    private int currentState;
    private g.a ddK;
    private g.f ddL;
    private g.e ddN;
    private g.InterfaceC0498g ddO;
    private SeekBar.OnSeekBarChangeListener diQ;
    private com.baidu.tieba.play.o dqG;
    private VideoLoadingProgressView.a eMT;
    private String ePT;
    protected View ePz;
    private Animation fBo;
    private ImageView hgB;
    private TextView hgC;
    private View hgG;
    private View hgH;
    private TextView hgI;
    private SeekBar hgJ;
    private ImageView hgK;
    private ImageView hgL;
    private int hgM;
    private int hgN;
    private int hgO;
    private int hgQ;
    private int hgR;
    private boolean hgU;
    private g.b hgW;
    protected Runnable hgX;
    private Animation.AnimationListener hgZ;
    public View hgl;
    private VideoListMediaControllerView hgn;
    private View hgo;
    private FrameLayout hgp;
    protected FrameLayout.LayoutParams hgq;
    private ImageView hgt;
    private View hgu;
    private View hgw;
    private TbImageView hgy;
    private g.f hgz;
    private Animation.AnimationListener hha;
    private Runnable hhb;
    private CustomMessageListener hhc;
    private VideoControllerView.b hiY;
    private p ieJ;
    private i ieV;
    private String iev;
    private int ivP;
    private boolean ivQ;
    protected com.baidu.tieba.play.a.a ivR;
    private ProgressBar ivS;
    private View ivT;
    private SwitchImageView ivU;
    private TextView ivV;
    private TextView ivW;
    private TextView ivX;
    private g.a ivY;
    private g.b ivZ;
    private boolean iwA;
    private boolean iwB;
    private boolean iwC;
    private boolean iwD;
    private Runnable iwE;
    private Runnable iwF;
    private QuickVideoView.a iwG;
    private boolean iwa;
    private boolean iwb;
    private View.OnClickListener iwc;
    protected InterfaceC0497c iwd;
    private d iwe;
    private long iwf;
    private o iwg;
    private h iwh;
    private j iwi;
    private k iwj;
    private m iwk;
    private a iwl;
    private n iwm;
    private l iwn;
    private f iwo;
    private g iwp;
    private boolean iwq;
    private boolean iwr;
    private boolean iws;
    private boolean iwt;
    private TextView iwu;
    private boolean iwv;
    private boolean iww;
    private boolean iwx;
    private boolean iwy;
    private int iwz;
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

    /* loaded from: classes.dex */
    public interface a {
        void kL(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0497c {
        void kv();

        void kw();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bmo();

        void ki(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void pP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void kh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void bYg();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bmp();
    }

    /* loaded from: classes.dex */
    public interface j {
        void ph(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bmm();

        void bmn();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bYh();

        boolean bYi();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aHA();

        void aHy();

        void aHz();

        void lU(int i);

        void onPrepared();

        void onStarted();

        void qK();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bYf();
    }

    public c(Activity activity, View view, boolean z) {
        this.ivP = 0;
        this.Ce = 100;
        this.ivQ = false;
        this.Cp = false;
        this.Cd = false;
        this.iwa = false;
        this.iwb = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hgN = 0;
        this.hgO = 0;
        this.iwf = 60000L;
        this.hgQ = 0;
        this.hgU = false;
        this.iwq = true;
        this.iwr = true;
        this.iws = false;
        this.iwt = false;
        this.iev = null;
        this.currentState = -1;
        this.iwv = false;
        this.iwA = true;
        this.iwC = false;
        this.iwD = false;
        this.ddL = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hgn != null && c.this.ivR != null && c.this.ivR.getDuration() > 0) {
                    c.this.hgn.aD(0, c.this.ivR.getDuration());
                }
                c.this.bad();
                if (c.this.iwg != null) {
                    c.this.iwg.onPrepared();
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.kM();
                    return false;
                }
                return false;
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bad();
            }
        };
        this.Cj = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.Cj);
                if (c.this.hgy.getVisibility() != 8) {
                    if (c.this.ivR.getCurrentPosition() > c.this.Ce) {
                        c.this.kM();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 20L);
                    }
                }
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.ivR != null) {
                    int duration = c.this.ivR.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Cd = false;
                        c.this.iwy = false;
                        c.this.mStartPosition = 0;
                        c.this.bIA();
                        c.this.hgo.setVisibility(0);
                        c.this.ivS.setProgress(c.this.ivS.getMax());
                        c.this.Ce = 100;
                        if (c.this.ivY != null) {
                            c.this.ivY.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cbA()) {
                            ((QuickVideoView) c.this.ivR).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.pK(false);
                            c.this.pL(true);
                        } else {
                            c.this.cbU();
                            c.this.ivV.setVisibility(0);
                        }
                        if (!c.this.Cp && duration <= 150000) {
                            if (!c.this.iwv) {
                                if (c.this.iwi != null) {
                                    c.this.iwi.ph(true);
                                }
                                c.this.y(c.this.cmf, c.this.cmS, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cbA()) {
                                    ((QuickVideoView) c.this.ivR).setRecoveryState(5);
                                }
                                c.this.ivR.pause();
                                c.this.ivR.seekTo(0);
                            }
                        }
                        if (c.this.iwg != null) {
                            c.this.iwg.lU(c.this.ivS.getMax());
                            c.this.iwg.qK();
                        }
                    }
                }
            }
        };
        this.hgW = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.ePz.setVisibility(0);
                c.this.cUk.ccP();
                c.this.currentState = 4;
                if (c.this.cbA()) {
                    ((QuickVideoView) c.this.ivR).setRecoveryState(4);
                }
                if (c.this.ivZ != null) {
                    c.this.ivZ.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.iww = true;
                }
                if (c.this.iwg != null) {
                    c.this.iwg.aHz();
                }
                c.this.iwy = false;
                return true;
            }
        };
        this.hgX = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ivR == null || !c.this.ivR.isPlaying()) {
                    c.this.ePz.setVisibility(0);
                    c.this.cUk.ccP();
                    if (c.this.iwg != null) {
                        c.this.iwg.aHz();
                    }
                }
            }
        };
        this.ddO = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.iws) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwE, 200L);
                }
            }
        };
        this.iwE = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ivR == null || !c.this.iws) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 200L);
                    c.this.iws = false;
                } else if (c.this.mStartPosition != c.this.ivR.getCurrentPosition()) {
                    c.this.iws = false;
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 20L);
                } else {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwE, 200L);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Cd = false;
                if (c.this.iwb) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwF, 300L);
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.Cj);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgX);
            }
        };
        this.iwF = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.iwy = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ieJ != null) {
                    c.this.ieJ.bYf();
                }
                if (view2.getId() != c.this.ePz.getId()) {
                    if (view2.getId() != c.this.ivU.getId()) {
                        if (view2.getId() == c.this.ivW.getId()) {
                            if (c.this.iwh != null) {
                                c.this.iwh.bYg();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ivV.getId()) {
                            if (c.this.iwi != null) {
                                c.this.iwi.ph(false);
                            }
                            c.this.cm(c.this.cmf, c.this.cmS);
                            return;
                        } else if (view2.getId() == c.this.hgt.getId()) {
                            int i2 = c.this.iwb ? 1 : 2;
                            if (c.this.Cp) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cmS).bS("fid", c.this.ePT).O("obj_type", i2).O("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cmS).bS("fid", c.this.ePT).O("obj_type", i2).O("obj_source", 1));
                            }
                            if (c.this.iwn != null) {
                                c.this.iwn.bmn();
                            }
                            if (c.this.cbE()) {
                                if (c.this.Cp) {
                                    c.this.cbI();
                                } else {
                                    c.this.cbH();
                                }
                                c.this.pH(c.this.Cp);
                                return;
                            }
                            c.this.vs();
                            return;
                        } else if (view2.getId() != c.this.hgB.getId()) {
                            if (c.this.iwc != null) {
                                c.this.iwc.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.iwn != null) {
                                c.this.iwn.bmn();
                            }
                            if (c.this.cbE()) {
                                c.this.cbI();
                                c.this.pH(false);
                                return;
                            }
                            c.this.vs();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.bXW();
                    c.this.cbW();
                    if (c.this.currentState != 1) {
                        c.this.cbS();
                        c.this.cbT();
                    } else {
                        c.this.bIR();
                    }
                    if (c.this.iwl != null) {
                        c.this.iwl.kL(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.ivR.stopPlayback();
                c.this.Cd = false;
                c.this.cbN();
            }
        };
        this.hgZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hha = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hhb = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bIO();
            }
        };
        this.hhc = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hiY = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lE(int i2) {
                int duration;
                if (c.this.ivR != null && (duration = c.this.ivR.getDuration()) > 0 && c.this.ivS != null) {
                    c.this.ivS.setProgress((int) ((i2 * c.this.hgl.getWidth()) / duration));
                    if (c.this.iwg != null) {
                        c.this.iwg.lU((c.this.ivR.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.diQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cbS();
                c.this.pL(false);
                if (c.this.iwl != null) {
                    c.this.iwl.kL(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bIE() != null) {
                    c.this.vo(c.this.bIE().getSeekPosition());
                    if (!c.this.bIN()) {
                        c.this.cbN();
                    } else {
                        c.this.bIM();
                        if (c.this.ieV != null) {
                            c.this.ieV.bmp();
                        }
                    }
                }
                c.this.pL(true);
                c.this.cbR();
                if (c.this.iwl != null) {
                    c.this.iwl.kL(true);
                }
                if (c.this.iwm != null) {
                    c.this.iwm.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.iwG = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbZ() {
                if (!c.this.iwv) {
                    c.this.cUk.startLoading();
                    c.this.hgy.setVisibility(0);
                    c.this.ivU.setVisibility(8);
                    c.this.ivW.setVisibility(8);
                    c.this.ivV.setVisibility(8);
                    c.this.ivX.setVisibility(8);
                    c.this.ePz.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgX);
                    if (c.this.iwf > 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.hgX, c.this.iwf);
                    }
                }
            }
        };
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.iwA = z;
            this.hgw = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.ivP = 0;
        this.Ce = 100;
        this.ivQ = false;
        this.Cp = false;
        this.Cd = false;
        this.iwa = false;
        this.iwb = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hgN = 0;
        this.hgO = 0;
        this.iwf = 60000L;
        this.hgQ = 0;
        this.hgU = false;
        this.iwq = true;
        this.iwr = true;
        this.iws = false;
        this.iwt = false;
        this.iev = null;
        this.currentState = -1;
        this.iwv = false;
        this.iwA = true;
        this.iwC = false;
        this.iwD = false;
        this.ddL = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hgn != null && c.this.ivR != null && c.this.ivR.getDuration() > 0) {
                    c.this.hgn.aD(0, c.this.ivR.getDuration());
                }
                c.this.bad();
                if (c.this.iwg != null) {
                    c.this.iwg.onPrepared();
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.kM();
                    return false;
                }
                return false;
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bad();
            }
        };
        this.Cj = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.Cj);
                if (c.this.hgy.getVisibility() != 8) {
                    if (c.this.ivR.getCurrentPosition() > c.this.Ce) {
                        c.this.kM();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 20L);
                    }
                }
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.ivR != null) {
                    int duration = c.this.ivR.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Cd = false;
                        c.this.iwy = false;
                        c.this.mStartPosition = 0;
                        c.this.bIA();
                        c.this.hgo.setVisibility(0);
                        c.this.ivS.setProgress(c.this.ivS.getMax());
                        c.this.Ce = 100;
                        if (c.this.ivY != null) {
                            c.this.ivY.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cbA()) {
                            ((QuickVideoView) c.this.ivR).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.pK(false);
                            c.this.pL(true);
                        } else {
                            c.this.cbU();
                            c.this.ivV.setVisibility(0);
                        }
                        if (!c.this.Cp && duration <= 150000) {
                            if (!c.this.iwv) {
                                if (c.this.iwi != null) {
                                    c.this.iwi.ph(true);
                                }
                                c.this.y(c.this.cmf, c.this.cmS, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cbA()) {
                                    ((QuickVideoView) c.this.ivR).setRecoveryState(5);
                                }
                                c.this.ivR.pause();
                                c.this.ivR.seekTo(0);
                            }
                        }
                        if (c.this.iwg != null) {
                            c.this.iwg.lU(c.this.ivS.getMax());
                            c.this.iwg.qK();
                        }
                    }
                }
            }
        };
        this.hgW = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.ePz.setVisibility(0);
                c.this.cUk.ccP();
                c.this.currentState = 4;
                if (c.this.cbA()) {
                    ((QuickVideoView) c.this.ivR).setRecoveryState(4);
                }
                if (c.this.ivZ != null) {
                    c.this.ivZ.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.iww = true;
                }
                if (c.this.iwg != null) {
                    c.this.iwg.aHz();
                }
                c.this.iwy = false;
                return true;
            }
        };
        this.hgX = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ivR == null || !c.this.ivR.isPlaying()) {
                    c.this.ePz.setVisibility(0);
                    c.this.cUk.ccP();
                    if (c.this.iwg != null) {
                        c.this.iwg.aHz();
                    }
                }
            }
        };
        this.ddO = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.iws) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwE, 200L);
                }
            }
        };
        this.iwE = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ivR == null || !c.this.iws) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 200L);
                    c.this.iws = false;
                } else if (c.this.mStartPosition != c.this.ivR.getCurrentPosition()) {
                    c.this.iws = false;
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 20L);
                } else {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwE, 200L);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Cd = false;
                if (c.this.iwb) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwF, 300L);
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.Cj);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgX);
            }
        };
        this.iwF = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.iwy = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ieJ != null) {
                    c.this.ieJ.bYf();
                }
                if (view2.getId() != c.this.ePz.getId()) {
                    if (view2.getId() != c.this.ivU.getId()) {
                        if (view2.getId() == c.this.ivW.getId()) {
                            if (c.this.iwh != null) {
                                c.this.iwh.bYg();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ivV.getId()) {
                            if (c.this.iwi != null) {
                                c.this.iwi.ph(false);
                            }
                            c.this.cm(c.this.cmf, c.this.cmS);
                            return;
                        } else if (view2.getId() == c.this.hgt.getId()) {
                            int i2 = c.this.iwb ? 1 : 2;
                            if (c.this.Cp) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cmS).bS("fid", c.this.ePT).O("obj_type", i2).O("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cmS).bS("fid", c.this.ePT).O("obj_type", i2).O("obj_source", 1));
                            }
                            if (c.this.iwn != null) {
                                c.this.iwn.bmn();
                            }
                            if (c.this.cbE()) {
                                if (c.this.Cp) {
                                    c.this.cbI();
                                } else {
                                    c.this.cbH();
                                }
                                c.this.pH(c.this.Cp);
                                return;
                            }
                            c.this.vs();
                            return;
                        } else if (view2.getId() != c.this.hgB.getId()) {
                            if (c.this.iwc != null) {
                                c.this.iwc.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.iwn != null) {
                                c.this.iwn.bmn();
                            }
                            if (c.this.cbE()) {
                                c.this.cbI();
                                c.this.pH(false);
                                return;
                            }
                            c.this.vs();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.bXW();
                    c.this.cbW();
                    if (c.this.currentState != 1) {
                        c.this.cbS();
                        c.this.cbT();
                    } else {
                        c.this.bIR();
                    }
                    if (c.this.iwl != null) {
                        c.this.iwl.kL(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.ivR.stopPlayback();
                c.this.Cd = false;
                c.this.cbN();
            }
        };
        this.hgZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hha = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hhb = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bIO();
            }
        };
        this.hhc = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hiY = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lE(int i2) {
                int duration;
                if (c.this.ivR != null && (duration = c.this.ivR.getDuration()) > 0 && c.this.ivS != null) {
                    c.this.ivS.setProgress((int) ((i2 * c.this.hgl.getWidth()) / duration));
                    if (c.this.iwg != null) {
                        c.this.iwg.lU((c.this.ivR.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.diQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cbS();
                c.this.pL(false);
                if (c.this.iwl != null) {
                    c.this.iwl.kL(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bIE() != null) {
                    c.this.vo(c.this.bIE().getSeekPosition());
                    if (!c.this.bIN()) {
                        c.this.cbN();
                    } else {
                        c.this.bIM();
                        if (c.this.ieV != null) {
                            c.this.ieV.bmp();
                        }
                    }
                }
                c.this.pL(true);
                c.this.cbR();
                if (c.this.iwl != null) {
                    c.this.iwl.kL(true);
                }
                if (c.this.iwm != null) {
                    c.this.iwm.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.iwG = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbZ() {
                if (!c.this.iwv) {
                    c.this.cUk.startLoading();
                    c.this.hgy.setVisibility(0);
                    c.this.ivU.setVisibility(8);
                    c.this.ivW.setVisibility(8);
                    c.this.ivV.setVisibility(8);
                    c.this.ivX.setVisibility(8);
                    c.this.ePz.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgX);
                    if (c.this.iwf > 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.hgX, c.this.iwf);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cfl = tbPageContext;
            this.mRootView = view;
            this.iwA = z;
            this.hgw = view;
            this.mActivity = this.cfl.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.ivP = 0;
        this.Ce = 100;
        this.ivQ = false;
        this.Cp = false;
        this.Cd = false;
        this.iwa = false;
        this.iwb = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hgN = 0;
        this.hgO = 0;
        this.iwf = 60000L;
        this.hgQ = 0;
        this.hgU = false;
        this.iwq = true;
        this.iwr = true;
        this.iws = false;
        this.iwt = false;
        this.iev = null;
        this.currentState = -1;
        this.iwv = false;
        this.iwA = true;
        this.iwC = false;
        this.iwD = false;
        this.ddL = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hgn != null && c.this.ivR != null && c.this.ivR.getDuration() > 0) {
                    c.this.hgn.aD(0, c.this.ivR.getDuration());
                }
                c.this.bad();
                if (c.this.iwg != null) {
                    c.this.iwg.onPrepared();
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.kM();
                    return false;
                }
                return false;
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bad();
            }
        };
        this.Cj = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.Cj);
                if (c.this.hgy.getVisibility() != 8) {
                    if (c.this.ivR.getCurrentPosition() > c.this.Ce) {
                        c.this.kM();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 20L);
                    }
                }
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.ivR != null) {
                    int duration = c.this.ivR.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Cd = false;
                        c.this.iwy = false;
                        c.this.mStartPosition = 0;
                        c.this.bIA();
                        c.this.hgo.setVisibility(0);
                        c.this.ivS.setProgress(c.this.ivS.getMax());
                        c.this.Ce = 100;
                        if (c.this.ivY != null) {
                            c.this.ivY.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cbA()) {
                            ((QuickVideoView) c.this.ivR).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.pK(false);
                            c.this.pL(true);
                        } else {
                            c.this.cbU();
                            c.this.ivV.setVisibility(0);
                        }
                        if (!c.this.Cp && duration <= 150000) {
                            if (!c.this.iwv) {
                                if (c.this.iwi != null) {
                                    c.this.iwi.ph(true);
                                }
                                c.this.y(c.this.cmf, c.this.cmS, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cbA()) {
                                    ((QuickVideoView) c.this.ivR).setRecoveryState(5);
                                }
                                c.this.ivR.pause();
                                c.this.ivR.seekTo(0);
                            }
                        }
                        if (c.this.iwg != null) {
                            c.this.iwg.lU(c.this.ivS.getMax());
                            c.this.iwg.qK();
                        }
                    }
                }
            }
        };
        this.hgW = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.ePz.setVisibility(0);
                c.this.cUk.ccP();
                c.this.currentState = 4;
                if (c.this.cbA()) {
                    ((QuickVideoView) c.this.ivR).setRecoveryState(4);
                }
                if (c.this.ivZ != null) {
                    c.this.ivZ.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.iww = true;
                }
                if (c.this.iwg != null) {
                    c.this.iwg.aHz();
                }
                c.this.iwy = false;
                return true;
            }
        };
        this.hgX = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ivR == null || !c.this.ivR.isPlaying()) {
                    c.this.ePz.setVisibility(0);
                    c.this.cUk.ccP();
                    if (c.this.iwg != null) {
                        c.this.iwg.aHz();
                    }
                }
            }
        };
        this.ddO = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.iws) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwE, 200L);
                }
            }
        };
        this.iwE = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ivR == null || !c.this.iws) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 200L);
                    c.this.iws = false;
                } else if (c.this.mStartPosition != c.this.ivR.getCurrentPosition()) {
                    c.this.iws = false;
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.Cj, 20L);
                } else {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwE, 200L);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Cd = false;
                if (c.this.iwb) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.iwF, 300L);
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.Cj);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgX);
            }
        };
        this.iwF = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.iwy = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ieJ != null) {
                    c.this.ieJ.bYf();
                }
                if (view2.getId() != c.this.ePz.getId()) {
                    if (view2.getId() != c.this.ivU.getId()) {
                        if (view2.getId() == c.this.ivW.getId()) {
                            if (c.this.iwh != null) {
                                c.this.iwh.bYg();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ivV.getId()) {
                            if (c.this.iwi != null) {
                                c.this.iwi.ph(false);
                            }
                            c.this.cm(c.this.cmf, c.this.cmS);
                            return;
                        } else if (view2.getId() == c.this.hgt.getId()) {
                            int i22 = c.this.iwb ? 1 : 2;
                            if (c.this.Cp) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cmS).bS("fid", c.this.ePT).O("obj_type", i22).O("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cmS).bS("fid", c.this.ePT).O("obj_type", i22).O("obj_source", 1));
                            }
                            if (c.this.iwn != null) {
                                c.this.iwn.bmn();
                            }
                            if (c.this.cbE()) {
                                if (c.this.Cp) {
                                    c.this.cbI();
                                } else {
                                    c.this.cbH();
                                }
                                c.this.pH(c.this.Cp);
                                return;
                            }
                            c.this.vs();
                            return;
                        } else if (view2.getId() != c.this.hgB.getId()) {
                            if (c.this.iwc != null) {
                                c.this.iwc.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.iwn != null) {
                                c.this.iwn.bmn();
                            }
                            if (c.this.cbE()) {
                                c.this.cbI();
                                c.this.pH(false);
                                return;
                            }
                            c.this.vs();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.bXW();
                    c.this.cbW();
                    if (c.this.currentState != 1) {
                        c.this.cbS();
                        c.this.cbT();
                    } else {
                        c.this.bIR();
                    }
                    if (c.this.iwl != null) {
                        c.this.iwl.kL(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.ivR.stopPlayback();
                c.this.Cd = false;
                c.this.cbN();
            }
        };
        this.hgZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hha = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hhb = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bIO();
            }
        };
        this.hhc = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hiY = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lE(int i22) {
                int duration;
                if (c.this.ivR != null && (duration = c.this.ivR.getDuration()) > 0 && c.this.ivS != null) {
                    c.this.ivS.setProgress((int) ((i22 * c.this.hgl.getWidth()) / duration));
                    if (c.this.iwg != null) {
                        c.this.iwg.lU((c.this.ivR.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.diQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cbS();
                c.this.pL(false);
                if (c.this.iwl != null) {
                    c.this.iwl.kL(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bIE() != null) {
                    c.this.vo(c.this.bIE().getSeekPosition());
                    if (!c.this.bIN()) {
                        c.this.cbN();
                    } else {
                        c.this.bIM();
                        if (c.this.ieV != null) {
                            c.this.ieV.bmp();
                        }
                    }
                }
                c.this.pL(true);
                c.this.cbR();
                if (c.this.iwl != null) {
                    c.this.iwl.kL(true);
                }
                if (c.this.iwm != null) {
                    c.this.iwm.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.iwG = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbZ() {
                if (!c.this.iwv) {
                    c.this.cUk.startLoading();
                    c.this.hgy.setVisibility(0);
                    c.this.ivU.setVisibility(8);
                    c.this.ivW.setVisibility(8);
                    c.this.ivV.setVisibility(8);
                    c.this.ivX.setVisibility(8);
                    c.this.ePz.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgX);
                    if (c.this.iwf > 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.hgX, c.this.iwf);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cfl = tbPageContext;
            this.mRootView = view;
            this.iwA = z;
            this.hgw = view;
            this.mActivity = this.cfl.getPageActivity();
            this.ivP = i2;
            init();
        }
    }

    public void init() {
        this.hgl = ak(this.mActivity);
        this.hgl.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hgl);
        }
        this.ivR = com.baidu.tieba.play.a.b.x(this.mActivity, this.ivP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hgl).addView(this.ivR.getView(), 0);
        this.ivR.getView().setLayoutParams(layoutParams);
        this.cUk = new x((ViewGroup) this.hgl.findViewById(R.id.auto_video_loading_container));
        this.cUk.setLoadingAnimationListener(this.eMT);
        this.hgn = (VideoListMediaControllerView) this.hgl.findViewById(R.id.media_controller);
        this.hgn.setPlayer(this.ivR);
        this.ivS = (ProgressBar) this.hgl.findViewById(R.id.pgrBottomProgress);
        this.ivS.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.ivS.setProgress(0);
        this.hgn.setOnSeekBarChangeListener(this.diQ);
        this.hgn.setOnProgressUpdatedListener(this.hiY);
        this.hgo = this.hgl.findViewById(R.id.black_mask);
        this.ePz = this.hgl.findViewById(R.id.layout_error);
        this.ePz.setOnClickListener(this.mOnClickListener);
        this.iwu = (TextView) this.hgl.findViewById(R.id.auto_video_error_tips);
        this.hgp = (FrameLayout) this.hgl.findViewById(R.id.danmu_container);
        this.hgt = (ImageView) this.hgl.findViewById(R.id.img_full_screen);
        this.hgt.setOnClickListener(this.mOnClickListener);
        this.hgu = this.hgl.findViewById(R.id.layout_media_controller);
        this.ivT = this.hgl.findViewById(R.id.time_show_controller);
        this.ivR.setContinuePlayEnable(true);
        this.ivR.setOnPreparedListener(this.ddL);
        this.ivR.setOnCompletionListener(this.ddK);
        this.ivR.setOnErrorListener(this.hgW);
        this.ivR.setOnSeekCompleteListener(this.ddO);
        this.ivR.setOnOutInfoListener(this.ddN);
        this.ivR.setOnSurfaceDestroyedListener(this.cUt);
        if (cbA()) {
            ((QuickVideoView) this.ivR).setOnRecoveryCallback(this.iwG);
        }
        this.ivU = (SwitchImageView) this.hgl.findViewById(R.id.img_play_controller);
        this.ivU.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.ivU.setState(0);
        this.ivU.setOnClickListener(this.mOnClickListener);
        this.ivV = (TextView) this.hgl.findViewById(R.id.txt_replay);
        this.ivV.setOnClickListener(this.mOnClickListener);
        this.ivW = (TextView) this.hgl.findViewById(R.id.txt_playnext);
        this.ivW.setOnClickListener(this.mOnClickListener);
        this.ivX = (TextView) this.hgl.findViewById(R.id.txt_next_video_title);
        this.hgy = (TbImageView) this.hgl.findViewById(R.id.video_thumbnail);
        this.hgy.setDefaultErrorResource(0);
        this.hgy.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hgB = (ImageView) this.hgl.findViewById(R.id.img_exit);
        this.hgB.setOnClickListener(this.mOnClickListener);
        this.hgC = (TextView) this.hgl.findViewById(R.id.video_title);
        this.aqA = this.hgl.findViewById(R.id.layout_title);
        this.aqA.setVisibility(8);
        this.fBo = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.azf = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hgM = this.mAudioManager.getStreamMaxVolume(3);
        this.hgR = this.mAudioManager.getStreamVolume(3);
        hgS = 100 / this.hgM;
        this.hgl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.iwj != null) {
                    c.this.iwj.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Cd) {
                        if (c.this.mStatus == 1 && c.this.hgO != 0) {
                            c.this.b(c.this.hgO == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hgO = 0;
                            c.this.hgN = 0;
                        }
                        if (!c.this.ivR.isPlaying()) {
                            c.this.ivW.setVisibility(8);
                            c.this.ivV.setVisibility(8);
                            c.this.ivX.setVisibility(8);
                        }
                    }
                    c.this.bIA();
                    if (c.this.iwj != null) {
                        c.this.iwj.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.dqG = new com.baidu.tieba.play.o(this.mActivity);
        if (this.iwA) {
            this.dqG.start();
        }
        this.hgQ = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hgT == null) {
            hgT = new CallStateReceiver();
        }
        hgT.register(this.mActivity);
        cbB();
        MessageManager.getInstance().registerListener(this.hhc);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hhc);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public boolean cbA() {
        return this.ivP == 0 && (this.ivR instanceof QuickVideoView);
    }

    public void cbB() {
        if (this.iwq) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hgl.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hgl.setSystemUiVisibility(0);
    }

    public void pF(boolean z) {
        this.iwq = z;
        cbB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        this.mStatus = 0;
        if (this.hgG != null && this.hgG.getParent() != null && (this.hgG.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hgG.getParent()).removeView(this.hgG);
                this.hgG = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hgH != null && this.hgH.getParent() != null && (this.hgH.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hgH.getParent()).removeView(this.hgH);
                this.hgH = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bIB() {
        if (this.mStatus == 1) {
            if (this.hgG == null && this.hgl != null && (this.hgl instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hgl, true);
                this.hgG = this.hgl.findViewById(R.id.lay_jindu);
                this.hgI = (TextView) this.hgG.findViewById(R.id.show_time);
                this.hgL = (ImageView) this.hgG.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hgH == null && this.hgl != null && (this.hgl instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hgl, true);
            this.hgH = this.hgl.findViewById(R.id.lay_voice);
            this.hgK = (ImageView) this.hgH.findViewById(R.id.arrow_voice_icon);
            this.hgJ = (SeekBar) this.hgH.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.iwc = onClickListener;
    }

    public void pG(boolean z) {
        this.iwb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.iwj != null) {
                c.this.iwj.onStart();
            }
            if (c.this.Cp && c.this.Cd) {
                if (c.this.mStatus == 1) {
                    c.this.cbU();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aq(f2);
                    }
                } else {
                    if (c.this.Cp) {
                        c.this.bID();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hgN = c.this.ivR.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aq(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.iwB) {
                if (c.this.iwk != null && c.this.iwk.bYh()) {
                    return true;
                }
                c.this.bXW();
                c.this.cbW();
                if (c.this.ivR.isPlaying()) {
                    c.this.cbR();
                } else {
                    c.this.cbS();
                }
                if (c.this.iwl != null) {
                    c.this.iwl.kL(c.this.ivR.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.iwB) {
                if (c.this.Cd) {
                    if (c.this.iwk != null && c.this.iwk.bYi()) {
                        return true;
                    }
                    c.this.cbQ();
                    if (c.this.ivR.isPlaying()) {
                        c.this.cbR();
                    } else {
                        c.this.cbS();
                    }
                    if (c.this.iwl != null) {
                        c.this.iwl.kL(c.this.ivR.isPlaying());
                    }
                } else {
                    c.this.bXW();
                    c.this.cbW();
                    if (c.this.currentState != 1) {
                        c.this.cbS();
                        c.this.cbT();
                    } else {
                        c.this.bIR();
                    }
                    if (c.this.iwl != null) {
                        c.this.iwl.kL(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bID() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hgl.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hgl.setSystemUiVisibility(4);
        } else {
            this.hgl.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f2) {
        if (!this.Cd) {
            this.mStatus = 0;
            return;
        }
        bIB();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hgS == 0) {
            if (f2 > 0.0f && this.hgR < this.hgM) {
                this.hgR++;
            }
            if (f2 < 0.0f && this.hgR > 0) {
                this.hgR--;
            }
        }
        if (this.mProgress > 0) {
            this.hgK.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hgK.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hgR, 0);
        this.hgJ.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hgN -= 1000;
                this.hgO = 1;
            } else {
                this.hgN += 1000;
                this.hgO = 2;
            }
            if (this.hgN < 0) {
                this.hgN = 0;
            } else if (this.hgN > this.ivR.getDuration()) {
                this.hgN = this.ivR.getDuration();
            }
        }
        bIB();
        String xJ = this.hgn.xJ(this.hgN);
        if (f2 > 0.0f) {
            this.hgL.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hgL.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(xJ)) {
            this.hgI.setText(new StringBuilder().append(xJ).append("/").append(this.hgn.xJ(this.ivR.getDuration())));
        }
        this.hgn.setCurrentDuration(this.hgN, z ? false : true);
        cbU();
        cbJ();
    }

    protected View ak(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.cmf = str;
        this.cmS = str2;
    }

    public void cbC() {
        if (this.ivR != null) {
            this.ivR.cbC();
        }
    }

    public void setFid(String str) {
        this.ePT = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        if (this.ivR != null && this.hgn != null) {
            this.hgn.showProgress();
            this.mStartPosition = y.ccT().BS(this.cmf);
            if (this.iwy) {
                this.ivR.setVolume(1.0f, 1.0f);
                this.ivR.start();
                this.iwy = false;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.Cj);
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.Cj, 20L);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgX);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwF);
                if (this.ivR.ccq()) {
                    this.currentState = 1;
                    if (cbA()) {
                        ((QuickVideoView) this.ivR).setRecoveryState(1);
                    }
                    cbU();
                }
                this.mStartPosition = y.ccT().BS(this.cmf);
                this.hgn.setPlayer(this.ivR);
                if (this.mStartPosition != 0) {
                    this.iws = true;
                }
                if (!this.iwx) {
                    this.hgn.showProgress();
                }
                if (!this.iwb && this.ivR.getDuration() <= 0) {
                    bIE().setVisibility(4);
                }
            }
            this.Ce = (this.mStartPosition <= 100 || this.ivR.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM() {
        if (this.hgy.getVisibility() != 8 || !this.Cd) {
            this.Cd = true;
            this.hgo.setVisibility(8);
            this.ePz.setVisibility(8);
            this.cUk.ccO();
            this.hgy.setVisibility(8);
            cbV();
            long duration = this.ivR.getDuration() / 1000;
            String str = this.cmS;
            this.hgn.showProgress();
            this.ivS.setVisibility(0);
            if (this.hgz != null && cbA()) {
                this.hgz.onPrepared(((QuickVideoView) this.ivR).getPlayer());
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
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

    protected void pH(boolean z) {
        if (hasNavBar(this.mActivity) && (this.ivT.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivT.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.ivT.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.ivT.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.ivT.setLayoutParams(layoutParams);
        }
    }

    public void bXW() {
        if (this.ivR.isPlaying()) {
            pausePlay();
            if (this.iwp != null) {
                this.iwp.onPause();
            }
            if (this.iwg != null) {
                this.iwg.aHy();
            }
        } else if (this.Cd) {
            bIM();
            if (this.ieV != null) {
                this.ieV.bmp();
            }
            if (this.iwg != null) {
                this.iwg.aHA();
            }
        } else {
            cbN();
        }
    }

    public boolean cbD() {
        return this.hgU;
    }

    public void vs() {
        this.hgU = true;
        if (this.dqG != null) {
            this.dqG.vs();
        }
    }

    public boolean cbE() {
        return this.ivR != null && this.ivR.getView().getHeight() > this.ivR.getView().getWidth();
    }

    public void cbF() {
        pH(false);
        cbI();
    }

    public boolean xD(int i2) {
        switch (i2) {
            case 4:
                if (this.Cp) {
                    if (cbE()) {
                        pH(false);
                        cbI();
                    } else {
                        vs();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hgM <= 0 || this.hgJ == null) {
                    return false;
                }
                this.hgR = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hgR * 100.0d) / this.hgM);
                this.hgJ.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cbA()) {
            return (QuickVideoView) this.ivR;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cbG() {
        return this.ivR;
    }

    public VideoListMediaControllerView bIE() {
        return this.hgn;
    }

    public void show() {
        this.hgl.setVisibility(0);
    }

    public void bII() {
        if (this.hgw != null) {
            ViewGroup.LayoutParams layoutParams = this.hgw.getLayoutParams();
            this.hgq = (FrameLayout.LayoutParams) this.hgl.getLayoutParams();
            this.hgq.width = layoutParams.width;
            this.hgq.height = layoutParams.height;
            this.hgq.topMargin = 0;
            this.hgl.setLayoutParams(this.hgq);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hgU) {
            if (this.Cp) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hgU = false;
        }
        if (configuration.orientation == 2) {
            cbH();
        } else {
            cbI();
        }
        cbJ();
        bIM();
        cbW();
        bIR();
        if (this.iwl != null) {
            this.iwl.kL(true);
        }
    }

    protected void cbH() {
        this.Cp = true;
        int statusBarHeight = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.getStatusBarHeight(this.mActivity) : 0;
        if (cbE()) {
            this.hgl.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hgl.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - statusBarHeight, this.mScreenWidth));
        }
        h(this.mActivity, true);
        this.aqA.setVisibility(0);
        this.hgB.setVisibility(0);
        this.hgC.setVisibility(0);
        this.hgp.setVisibility(8);
        this.cUk.ccP();
        this.hgy.setVisibility(8);
        this.hgt.setImageResource(R.drawable.icon_video_narrow_white);
        vl(this.hgQ);
        bID();
        if (this.iwd != null) {
            this.iwd.kv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbI() {
        this.Cp = false;
        if (this.hgq != null) {
            this.hgl.setLayoutParams(this.hgq);
        }
        h(this.mActivity, false);
        this.aqA.setVisibility(8);
        this.hgp.setVisibility(0);
        this.cUk.ccP();
        this.hgy.setVisibility(8);
        this.hgt.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hgn != null && (this.hgn.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgn.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hgn.setLayoutParams(layoutParams);
        }
        this.hgl.setSystemUiVisibility(0);
        cbB();
        if (this.iwd != null) {
            this.iwd.kw();
        }
    }

    public void cbJ() {
        if (this.ivR != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.Cp) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.ivS.setMax(equipmentWidth);
            int duration = this.ivR.getDuration();
            if (duration > 0) {
                if (this.ivV.getVisibility() == 0) {
                    this.ivS.setProgress(this.ivS.getMax());
                } else {
                    this.ivS.setProgress((int) ((this.ivR.getCurrentPositionSync() * this.ivS.getMax()) / duration));
                }
            }
        }
    }

    private void vl(int i2) {
        if (this.hgn != null && (this.hgn.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgn.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hgn.setLayoutParams(layoutParams);
        }
    }

    private void h(Activity activity, boolean z) {
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

    public boolean bIK() {
        return !this.Cp;
    }

    public void a(g.f fVar) {
        this.hgz = fVar;
    }

    public void a(g.a aVar) {
        this.ivY = aVar;
    }

    public void a(g.b bVar) {
        this.ivZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.iwt) {
            dF(str, str2);
        } else {
            cm(str, str2);
        }
        if (eVar != null) {
            eVar.pP(z);
        }
    }

    public void dE(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, boolean z) {
        cbO();
        this.iwy = true;
        this.currentState = 0;
        if (cbA()) {
            ((QuickVideoView) this.ivR).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.ivR.setVideoPath(str, str2);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgX);
        if (this.iwf > 0) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.hgX, this.iwf);
        }
        if (this.iwg != null) {
            this.iwg.onStarted();
        }
        this.cUk.startLoading();
        pI(z);
    }

    public void cm(String str, String str2) {
        y(str, str2, true);
    }

    public void dF(String str, String str2) {
        cbO();
        this.iwy = true;
        this.currentState = 0;
        if (cbA()) {
            ((QuickVideoView) this.ivR).setRecoveryState(0);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgX);
        if (this.iwf > 0) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.hgX, this.iwf);
        }
        if (this.iwg != null) {
            this.iwg.onStarted();
        }
        this.cUk.startLoading();
        pI(true);
    }

    public void cbK() {
        bIM();
        this.ivS.setVisibility(0);
    }

    public void bIM() {
        if (this.ivR != null && this.hgn != null) {
            this.Cd = true;
            this.currentState = 1;
            if (cbA()) {
                ((QuickVideoView) this.ivR).setRecoveryState(1);
            }
            this.ivR.bIM();
            this.mStartPosition = y.ccT().BS(this.cmf);
            this.iws = true;
            this.Ce = (this.mStartPosition <= 100 || this.ivR.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.cUk.ccP();
            pI(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.iww && !StringUtils.isNull(this.cmf) && !StringUtils.isNull(this.cmS)) {
            this.iww = false;
            this.iwx = true;
            cm(this.cmf, this.cmS);
        }
    }

    private void pI(boolean z) {
        if (z) {
            this.hgy.setVisibility(0);
            cbU();
            this.ivS.setProgress(0);
        } else {
            this.hgy.setVisibility(8);
            cbU();
        }
        this.hgn.showProgress();
        this.hgo.setVisibility(8);
        this.ivW.setVisibility(8);
        this.ivV.setVisibility(8);
        this.ivX.setVisibility(8);
        this.ePz.setVisibility(8);
    }

    private void cbL() {
        this.cUk.ccP();
        this.ivW.setVisibility(8);
        this.ivV.setVisibility(8);
        this.ivX.setVisibility(8);
        cbW();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.ivR instanceof QuickVideoView) {
            ((QuickVideoView) this.ivR).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.ivR.pause();
        this.currentState = 2;
        if (cbA()) {
            ((QuickVideoView) this.ivR).setRecoveryState(2);
        }
        cbL();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cbA()) {
            ((QuickVideoView) this.ivR).setRecoveryState(5);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.Cj);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgX);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwF);
        this.ivR.stopPlayback();
        this.Cd = false;
        this.iwy = false;
        this.mStartPosition = 0;
        bvM();
    }

    public void cbM() {
        if (this.ivR.getDuration() >= this.ivR.getCurrentPosition()) {
            y.ccT().bd(this.cmf, this.ivR.getCurrentPosition());
        }
    }

    public void pJ(boolean z) {
        this.iwr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(boolean z) {
        if (this.hgu != null) {
            this.hgo.setVisibility(0);
            this.ivW.setVisibility(8);
            this.ivV.setVisibility(8);
            this.ivX.setVisibility(8);
            this.cUk.ccP();
            cbU();
            this.ivS.setVisibility(8);
            this.ePz.setVisibility(8);
            this.hgn.aDT();
            this.hgy.setVisibility(z ? 0 : 8);
        }
    }

    public void bvM() {
        pK(true);
    }

    public boolean kx() {
        if (this.ivR == null) {
            return false;
        }
        return this.ivR.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ivR == null) {
            return 0;
        }
        return this.ivR.getCurrentPosition();
    }

    public void a(k kVar) {
        this.iwj = kVar;
    }

    public void a(j jVar) {
        this.iwi = jVar;
    }

    public void a(i iVar) {
        this.ieV = iVar;
    }

    public void a(g gVar) {
        this.iwp = gVar;
    }

    public void a(h hVar) {
        this.iwh = hVar;
    }

    public void Bn(String str) {
        this.iev = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbN() {
        a(this.cmf, this.cmS, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.iwe = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cbO();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.csD().csE()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.iwt = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.iwo != null) {
                    this.iwo.kh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.nn(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cbP();
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
                aVar.b(this.cfl).akO();
                return;
            } else if (this.iwo != null) {
                this.iwo.kh(true);
                return;
            } else {
                if (!this.ivQ) {
                    this.ivQ = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.iwn != null) {
            this.iwn.bmm();
        }
    }

    private void cbO() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.csD().ef(this.mActivity);
        }
    }

    public void cbP() {
        com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.hgy.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hhb);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.Cj);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgX);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwE);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwF);
        this.dqG.stop();
        hgT.unregister(this.mActivity);
    }

    public void BN(String str) {
        this.hgC.setText(str);
    }

    public boolean bIN() {
        return this.Cd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbQ() {
        if (this.hgu != null) {
            if (this.iwa) {
                cbU();
            } else {
                cbT();
            }
        }
    }

    public void bIR() {
        cbT();
        cbR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbR() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hhb);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.hhb, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbS() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hhb);
    }

    public void cbT() {
        if (this.hgu != null && !this.iwa && !this.iwC) {
            pL(true);
            bIQ();
            this.hgu.setVisibility(0);
            this.ivT.setVisibility(0);
            this.ivS.setVisibility(8);
            this.iwa = true;
            if (this.iwe != null) {
                this.iwe.ki(false);
            }
        }
    }

    public void bIO() {
        if (this.hgu != null && this.iwa) {
            pL(false);
            bIQ();
            this.hgu.setVisibility(8);
            this.ivT.setVisibility(8);
            this.ivS.setVisibility(0);
            this.fBo.setAnimationListener(this.hgZ);
            this.hgu.startAnimation(this.fBo);
            this.iwa = false;
            if (this.iwe != null) {
                this.iwe.bmo();
            }
        }
    }

    public void cbU() {
        if (this.hgu != null && this.iwa) {
            this.azf.cancel();
            this.fBo.cancel();
            pL(false);
            bIQ();
            this.hgu.setVisibility(8);
            this.ivT.setVisibility(8);
            this.ivS.setVisibility(0);
            this.iwa = false;
            if (this.iwe != null) {
                this.iwe.bmo();
            }
        }
    }

    private void bIQ() {
        if (this.hgu != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hhb);
            this.azf.setAnimationListener(null);
            this.fBo.setAnimationListener(null);
            this.hgu.clearAnimation();
        }
    }

    private void cbV() {
        if (this.hgu != null) {
            this.azf.setAnimationListener(null);
            this.fBo.setAnimationListener(null);
            this.hgu.clearAnimation();
        }
    }

    public void pL(boolean z) {
        cbW();
        if (z) {
            this.ivU.setVisibility(0);
        } else {
            this.ivU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbW() {
        if (this.currentState == 1) {
            this.ivU.setState(1);
        } else {
            this.ivU.setState(0);
        }
    }

    public void a(InterfaceC0497c interfaceC0497c) {
        this.iwd = interfaceC0497c;
    }

    public void vo(int i2) {
        this.mStartPosition = i2;
    }

    public void ag(boolean z, boolean z2) {
        if (this.dqG != null) {
            if (this.hgt != null) {
                this.hgt.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hgn != null && (this.hgn.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgn.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hgn.setLayoutParams(layoutParams);
            }
            this.dqG.aK(z);
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
            i2 = displayMetrics.heightPixels;
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

    public void pM(boolean z) {
        this.iwB = z;
    }

    public void a(m mVar) {
        this.iwk = mVar;
    }

    public void a(a aVar) {
        this.iwl = aVar;
    }

    public void a(n nVar) {
        this.iwm = nVar;
    }

    public void a(l lVar) {
        this.iwn = lVar;
    }

    public void a(f fVar) {
        this.iwo = fVar;
    }

    public void pN(boolean z) {
        this.iwv = z;
    }

    public void pO(boolean z) {
        this.iwb = z;
        if (z) {
            this.ivR.setPageTypeForPerfStat("middle");
        } else {
            this.ivR.setPageTypeForPerfStat("pb");
        }
    }

    public void xE(int i2) {
        this.iwz = i2;
    }

    public View cbX() {
        return this.hgl;
    }

    public void a(o oVar) {
        this.iwg = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.ivR != null) {
            this.ivR.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.ieJ = pVar;
    }

    public void cbY() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cfl.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cfl.getPageActivity());
    }
}
