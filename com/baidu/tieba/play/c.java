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
    private static int hXI;
    private static CallStateReceiver hXJ;
    protected boolean EA;
    private boolean Eo;
    private int Ep;
    private Runnable Eu;
    private String OG;
    private TbImageView Ow;
    private Animation aHr;
    private View ayH;
    private TbPageContext<?> cRe;
    private int currentState;
    private w dHV;
    private QuickVideoView.b dIe;
    private g.a dQW;
    private g.f dQX;
    private g.e dQZ;
    private g.InterfaceC0582g dRa;
    private SeekBar.OnSeekBarChangeListener dVU;
    private com.baidu.tieba.play.o eag;
    private VideoLoadingProgressView.a fHc;
    protected View fJG;
    private String fKa;
    private Animation gsc;
    private ImageView hXA;
    private ImageView hXB;
    private int hXC;
    private int hXD;
    private int hXE;
    private int hXG;
    private int hXH;
    private boolean hXK;
    private g.b hXM;
    protected Runnable hXN;
    private Animation.AnimationListener hXP;
    private Animation.AnimationListener hXQ;
    private Runnable hXR;
    private CustomMessageListener hXS;
    public View hXc;
    private VideoListMediaControllerView hXe;
    private View hXf;
    private FrameLayout hXg;
    protected FrameLayout.LayoutParams hXh;
    private ImageView hXk;
    private View hXl;
    private View hXn;
    private g.f hXp;
    private ImageView hXr;
    private TextView hXs;
    private View hXw;
    private View hXx;
    private TextView hXy;
    private SeekBar hXz;
    private VideoControllerView.b hZM;
    private i iWE;
    private String iWe;
    private p iWs;
    private boolean jsA;
    protected com.baidu.tieba.play.a.a jsB;
    private ProgressBar jsC;
    private View jsD;
    private SwitchImageView jsE;
    private TextView jsF;
    private TextView jsG;
    private TextView jsH;
    private g.a jsI;
    private g.b jsJ;
    private boolean jsK;
    private boolean jsL;
    private View.OnClickListener jsM;
    protected InterfaceC0581c jsN;
    private d jsO;
    private long jsP;
    private o jsQ;
    private h jsR;
    private j jsS;
    private k jsT;
    private m jsU;
    private a jsV;
    private n jsW;
    private l jsX;
    private f jsY;
    private g jsZ;
    private boolean jta;
    private boolean jtb;
    private boolean jtc;
    private boolean jtd;
    private TextView jte;
    private boolean jtf;
    private boolean jtg;
    private boolean jth;
    private boolean jti;
    private int jtj;
    private boolean jtk;
    private boolean jtl;
    private boolean jtm;
    private boolean jtn;
    private Runnable jto;
    private Runnable jtp;
    private QuickVideoView.a jtq;
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
        void mj(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0581c {
        void kN();

        void kO();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bEL();

        void lF(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void rK(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void lE(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cra();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bEM();
    }

    /* loaded from: classes.dex */
    public interface j {
        void qN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bEJ();

        void bEK();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean crb();

        boolean crc();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Af(int i);

        void cwX();

        void cwY();

        void onPaused();

        void onPrepared();

        void onStarted();

        void sK();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cqZ();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.Ep = 100;
        this.jsA = false;
        this.EA = false;
        this.Eo = false;
        this.jsK = false;
        this.jsL = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hXD = 0;
        this.hXE = 0;
        this.jsP = 60000L;
        this.hXG = 0;
        this.hXK = false;
        this.jta = true;
        this.jtb = true;
        this.jtc = false;
        this.jtd = false;
        this.iWe = null;
        this.currentState = -1;
        this.jtf = false;
        this.jtk = true;
        this.jtm = false;
        this.jtn = false;
        this.dQX = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hXe != null && c.this.jsB != null && c.this.jsB.getDuration() > 0) {
                    c.this.hXe.aZ(0, c.this.jsB.getDuration());
                }
                c.this.bth();
                if (c.this.jsQ != null) {
                    c.this.jsQ.onPrepared();
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.le();
                    return false;
                }
                return false;
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bth();
            }
        };
        this.Eu = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.Eu);
                if (c.this.Ow.getVisibility() != 8) {
                    if (c.this.jsB.getCurrentPosition() > c.this.Ep) {
                        c.this.le();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.Eu, 20L);
                    }
                }
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jsB != null) {
                    int duration = c.this.jsB.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Eo = false;
                        c.this.jti = false;
                        c.this.mStartPosition = 0;
                        c.this.caV();
                        c.this.hXf.setVisibility(0);
                        c.this.jsC.setProgress(c.this.jsC.getMax());
                        c.this.Ep = 100;
                        if (c.this.jsI != null) {
                            c.this.jsI.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cwz()) {
                            ((QuickVideoView) c.this.jsB).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rF(false);
                            c.this.rG(true);
                        } else {
                            c.this.cwR();
                            c.this.jsF.setVisibility(0);
                        }
                        if (!c.this.EA && duration <= 150000) {
                            if (!c.this.jtf) {
                                if (c.this.jsS != null) {
                                    c.this.jsS.qN(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.OG, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cwz()) {
                                    ((QuickVideoView) c.this.jsB).setRecoveryState(5);
                                }
                                c.this.jsB.pause();
                                c.this.jsB.seekTo(0);
                            }
                        }
                        if (c.this.jsQ != null) {
                            c.this.jsQ.Af(c.this.jsC.getMax());
                            c.this.jsQ.sK();
                        }
                    }
                }
            }
        };
        this.hXM = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.fJG.setVisibility(0);
                c.this.dHV.cxR();
                c.this.currentState = 4;
                if (c.this.cwz()) {
                    ((QuickVideoView) c.this.jsB).setRecoveryState(4);
                }
                if (c.this.jsJ != null) {
                    c.this.jsJ.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jtg = true;
                }
                if (c.this.jsQ != null) {
                    c.this.jsQ.cwX();
                }
                c.this.jti = false;
                return true;
            }
        };
        this.hXN = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jsB == null || !c.this.jsB.isPlaying()) {
                    c.this.fJG.setVisibility(0);
                    c.this.dHV.cxR();
                    if (c.this.jsQ != null) {
                        c.this.jsQ.cwX();
                    }
                }
            }
        };
        this.dRa = new g.InterfaceC0582g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jtc) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jto, 200L);
                }
            }
        };
        this.jto = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jsB == null || !c.this.jtc) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.Eu, 200L);
                    c.this.jtc = false;
                } else if (c.this.mStartPosition != c.this.jsB.getCurrentPosition()) {
                    c.this.jtc = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.Eu, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jto, 200L);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Eo = false;
                if (c.this.jsL) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jtp, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.Eu);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hXN);
            }
        };
        this.jtp = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jti = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iWs != null) {
                    c.this.iWs.cqZ();
                }
                if (view2.getId() != c.this.fJG.getId()) {
                    if (view2.getId() != c.this.jsE.getId()) {
                        if (view2.getId() == c.this.jsG.getId()) {
                            if (c.this.jsR != null) {
                                c.this.jsR.cra();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jsF.getId()) {
                            if (c.this.jsS != null) {
                                c.this.jsS.qN(false);
                            }
                            c.this.dZ(c.this.mVideoUrl, c.this.OG);
                            return;
                        } else if (view2.getId() == c.this.hXk.getId()) {
                            int i2 = c.this.jsL ? 1 : 2;
                            if (c.this.EA) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OG).cp("fid", c.this.fKa).Z("obj_type", i2).Z("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OG).cp("fid", c.this.fKa).Z("obj_type", i2).Z("obj_source", 1));
                            }
                            if (c.this.jsX != null) {
                                c.this.jsX.bEK();
                            }
                            if (c.this.cwB()) {
                                if (c.this.EA) {
                                    c.this.cwF();
                                } else {
                                    c.this.cwE();
                                }
                                c.this.rC(c.this.EA);
                                return;
                            }
                            c.this.xH();
                            return;
                        } else if (view2.getId() != c.this.hXr.getId()) {
                            if (c.this.jsM != null) {
                                c.this.jsM.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jsX != null) {
                                c.this.jsX.bEK();
                            }
                            if (c.this.cwB()) {
                                c.this.cwF();
                                c.this.rC(false);
                                return;
                            }
                            c.this.xH();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cqS();
                    c.this.cwT();
                    if (c.this.currentState != 1) {
                        c.this.cwP();
                        c.this.cwQ();
                    } else {
                        c.this.cbl();
                    }
                    if (c.this.jsV != null) {
                        c.this.jsV.mj(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jsB.stopPlayback();
                c.this.Eo = false;
                c.this.cwK();
            }
        };
        this.hXP = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hXQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hXR = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cbi();
            }
        };
        this.hXS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hZM = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i2) {
                int duration;
                if (c.this.jsB != null && (duration = c.this.jsB.getDuration()) > 0 && c.this.jsC != null) {
                    c.this.jsC.setProgress((int) ((i2 * c.this.hXc.getWidth()) / duration));
                    if (c.this.jsQ != null) {
                        c.this.jsQ.Af((c.this.jsB.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dVU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cwP();
                c.this.rG(false);
                if (c.this.jsV != null) {
                    c.this.jsV.mj(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.caZ() != null) {
                    c.this.xu(c.this.caZ().getSeekPosition());
                    if (!c.this.cbh()) {
                        c.this.cwK();
                    } else {
                        c.this.ahK();
                        if (c.this.iWE != null) {
                            c.this.iWE.bEM();
                        }
                    }
                }
                c.this.rG(true);
                c.this.cwO();
                if (c.this.jsV != null) {
                    c.this.jsV.mj(true);
                }
                if (c.this.jsW != null) {
                    c.this.jsW.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jtq = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cwW() {
                if (!c.this.jtf) {
                    c.this.dHV.startLoading();
                    c.this.Ow.setVisibility(0);
                    c.this.jsE.setVisibility(8);
                    c.this.jsG.setVisibility(8);
                    c.this.jsF.setVisibility(8);
                    c.this.jsH.setVisibility(8);
                    c.this.fJG.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hXN);
                    if (c.this.jsP > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hXN, c.this.jsP);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cRe = tbPageContext;
            this.mRootView = view;
            this.jtk = z;
            this.hXn = view;
            this.mActivity = this.cRe.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.Ep = 100;
        this.jsA = false;
        this.EA = false;
        this.Eo = false;
        this.jsK = false;
        this.jsL = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hXD = 0;
        this.hXE = 0;
        this.jsP = 60000L;
        this.hXG = 0;
        this.hXK = false;
        this.jta = true;
        this.jtb = true;
        this.jtc = false;
        this.jtd = false;
        this.iWe = null;
        this.currentState = -1;
        this.jtf = false;
        this.jtk = true;
        this.jtm = false;
        this.jtn = false;
        this.dQX = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hXe != null && c.this.jsB != null && c.this.jsB.getDuration() > 0) {
                    c.this.hXe.aZ(0, c.this.jsB.getDuration());
                }
                c.this.bth();
                if (c.this.jsQ != null) {
                    c.this.jsQ.onPrepared();
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.le();
                    return false;
                }
                return false;
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bth();
            }
        };
        this.Eu = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.Eu);
                if (c.this.Ow.getVisibility() != 8) {
                    if (c.this.jsB.getCurrentPosition() > c.this.Ep) {
                        c.this.le();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.Eu, 20L);
                    }
                }
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jsB != null) {
                    int duration = c.this.jsB.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Eo = false;
                        c.this.jti = false;
                        c.this.mStartPosition = 0;
                        c.this.caV();
                        c.this.hXf.setVisibility(0);
                        c.this.jsC.setProgress(c.this.jsC.getMax());
                        c.this.Ep = 100;
                        if (c.this.jsI != null) {
                            c.this.jsI.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cwz()) {
                            ((QuickVideoView) c.this.jsB).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rF(false);
                            c.this.rG(true);
                        } else {
                            c.this.cwR();
                            c.this.jsF.setVisibility(0);
                        }
                        if (!c.this.EA && duration <= 150000) {
                            if (!c.this.jtf) {
                                if (c.this.jsS != null) {
                                    c.this.jsS.qN(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.OG, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cwz()) {
                                    ((QuickVideoView) c.this.jsB).setRecoveryState(5);
                                }
                                c.this.jsB.pause();
                                c.this.jsB.seekTo(0);
                            }
                        }
                        if (c.this.jsQ != null) {
                            c.this.jsQ.Af(c.this.jsC.getMax());
                            c.this.jsQ.sK();
                        }
                    }
                }
            }
        };
        this.hXM = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.fJG.setVisibility(0);
                c.this.dHV.cxR();
                c.this.currentState = 4;
                if (c.this.cwz()) {
                    ((QuickVideoView) c.this.jsB).setRecoveryState(4);
                }
                if (c.this.jsJ != null) {
                    c.this.jsJ.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jtg = true;
                }
                if (c.this.jsQ != null) {
                    c.this.jsQ.cwX();
                }
                c.this.jti = false;
                return true;
            }
        };
        this.hXN = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jsB == null || !c.this.jsB.isPlaying()) {
                    c.this.fJG.setVisibility(0);
                    c.this.dHV.cxR();
                    if (c.this.jsQ != null) {
                        c.this.jsQ.cwX();
                    }
                }
            }
        };
        this.dRa = new g.InterfaceC0582g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jtc) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jto, 200L);
                }
            }
        };
        this.jto = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jsB == null || !c.this.jtc) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.Eu, 200L);
                    c.this.jtc = false;
                } else if (c.this.mStartPosition != c.this.jsB.getCurrentPosition()) {
                    c.this.jtc = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.Eu, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jto, 200L);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Eo = false;
                if (c.this.jsL) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jtp, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.Eu);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hXN);
            }
        };
        this.jtp = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jti = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iWs != null) {
                    c.this.iWs.cqZ();
                }
                if (view2.getId() != c.this.fJG.getId()) {
                    if (view2.getId() != c.this.jsE.getId()) {
                        if (view2.getId() == c.this.jsG.getId()) {
                            if (c.this.jsR != null) {
                                c.this.jsR.cra();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jsF.getId()) {
                            if (c.this.jsS != null) {
                                c.this.jsS.qN(false);
                            }
                            c.this.dZ(c.this.mVideoUrl, c.this.OG);
                            return;
                        } else if (view2.getId() == c.this.hXk.getId()) {
                            int i22 = c.this.jsL ? 1 : 2;
                            if (c.this.EA) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OG).cp("fid", c.this.fKa).Z("obj_type", i22).Z("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OG).cp("fid", c.this.fKa).Z("obj_type", i22).Z("obj_source", 1));
                            }
                            if (c.this.jsX != null) {
                                c.this.jsX.bEK();
                            }
                            if (c.this.cwB()) {
                                if (c.this.EA) {
                                    c.this.cwF();
                                } else {
                                    c.this.cwE();
                                }
                                c.this.rC(c.this.EA);
                                return;
                            }
                            c.this.xH();
                            return;
                        } else if (view2.getId() != c.this.hXr.getId()) {
                            if (c.this.jsM != null) {
                                c.this.jsM.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jsX != null) {
                                c.this.jsX.bEK();
                            }
                            if (c.this.cwB()) {
                                c.this.cwF();
                                c.this.rC(false);
                                return;
                            }
                            c.this.xH();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cqS();
                    c.this.cwT();
                    if (c.this.currentState != 1) {
                        c.this.cwP();
                        c.this.cwQ();
                    } else {
                        c.this.cbl();
                    }
                    if (c.this.jsV != null) {
                        c.this.jsV.mj(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jsB.stopPlayback();
                c.this.Eo = false;
                c.this.cwK();
            }
        };
        this.hXP = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hXQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hXR = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cbi();
            }
        };
        this.hXS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hZM = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i22) {
                int duration;
                if (c.this.jsB != null && (duration = c.this.jsB.getDuration()) > 0 && c.this.jsC != null) {
                    c.this.jsC.setProgress((int) ((i22 * c.this.hXc.getWidth()) / duration));
                    if (c.this.jsQ != null) {
                        c.this.jsQ.Af((c.this.jsB.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dVU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cwP();
                c.this.rG(false);
                if (c.this.jsV != null) {
                    c.this.jsV.mj(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.caZ() != null) {
                    c.this.xu(c.this.caZ().getSeekPosition());
                    if (!c.this.cbh()) {
                        c.this.cwK();
                    } else {
                        c.this.ahK();
                        if (c.this.iWE != null) {
                            c.this.iWE.bEM();
                        }
                    }
                }
                c.this.rG(true);
                c.this.cwO();
                if (c.this.jsV != null) {
                    c.this.jsV.mj(true);
                }
                if (c.this.jsW != null) {
                    c.this.jsW.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jtq = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cwW() {
                if (!c.this.jtf) {
                    c.this.dHV.startLoading();
                    c.this.Ow.setVisibility(0);
                    c.this.jsE.setVisibility(8);
                    c.this.jsG.setVisibility(8);
                    c.this.jsF.setVisibility(8);
                    c.this.jsH.setVisibility(8);
                    c.this.fJG.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hXN);
                    if (c.this.jsP > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hXN, c.this.jsP);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cRe = tbPageContext;
            this.mRootView = view;
            this.jtk = z;
            this.hXn = view;
            this.mActivity = this.cRe.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.hXc = aq(this.mActivity);
        this.hXc.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hXc);
        }
        this.jsB = com.baidu.tieba.play.a.b.F(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hXc).addView(this.jsB.getView(), 0);
        this.jsB.getView().setLayoutParams(layoutParams);
        this.dHV = new w((ViewGroup) this.hXc.findViewById(R.id.auto_video_loading_container));
        this.dHV.setLoadingAnimationListener(this.fHc);
        this.hXe = (VideoListMediaControllerView) this.hXc.findViewById(R.id.media_controller);
        this.hXe.setPlayer(this.jsB);
        this.jsC = (ProgressBar) this.hXc.findViewById(R.id.pgrBottomProgress);
        this.jsC.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.jsC.setProgress(0);
        this.hXe.setOnSeekBarChangeListener(this.dVU);
        this.hXe.setOnProgressUpdatedListener(this.hZM);
        this.hXf = this.hXc.findViewById(R.id.black_mask);
        this.fJG = this.hXc.findViewById(R.id.layout_error);
        this.fJG.setOnClickListener(this.mOnClickListener);
        this.jte = (TextView) this.hXc.findViewById(R.id.auto_video_error_tips);
        this.hXg = (FrameLayout) this.hXc.findViewById(R.id.danmu_container);
        this.hXk = (ImageView) this.hXc.findViewById(R.id.img_full_screen);
        this.hXk.setOnClickListener(this.mOnClickListener);
        this.hXl = this.hXc.findViewById(R.id.layout_media_controller);
        this.jsD = this.hXc.findViewById(R.id.time_show_controller);
        this.jsB.setContinuePlayEnable(true);
        this.jsB.setOnPreparedListener(this.dQX);
        this.jsB.setOnCompletionListener(this.dQW);
        this.jsB.setOnErrorListener(this.hXM);
        this.jsB.setOnSeekCompleteListener(this.dRa);
        this.jsB.setOnOutInfoListener(this.dQZ);
        this.jsB.setOnSurfaceDestroyedListener(this.dIe);
        if (cwz()) {
            ((QuickVideoView) this.jsB).setOnRecoveryCallback(this.jtq);
        }
        this.jsE = (SwitchImageView) this.hXc.findViewById(R.id.img_play_controller);
        this.jsE.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.jsE.setState(0);
        this.jsE.setOnClickListener(this.mOnClickListener);
        this.jsF = (TextView) this.hXc.findViewById(R.id.txt_replay);
        this.jsF.setOnClickListener(this.mOnClickListener);
        this.jsG = (TextView) this.hXc.findViewById(R.id.txt_playnext);
        this.jsG.setOnClickListener(this.mOnClickListener);
        this.jsH = (TextView) this.hXc.findViewById(R.id.txt_next_video_title);
        this.Ow = (TbImageView) this.hXc.findViewById(R.id.video_thumbnail);
        this.Ow.setDefaultErrorResource(0);
        this.Ow.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hXr = (ImageView) this.hXc.findViewById(R.id.img_exit);
        this.hXr.setOnClickListener(this.mOnClickListener);
        this.hXs = (TextView) this.hXc.findViewById(R.id.video_title);
        this.ayH = this.hXc.findViewById(R.id.layout_title);
        this.ayH.setVisibility(8);
        this.gsc = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aHr = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hXC = this.mAudioManager.getStreamMaxVolume(3);
        this.hXH = this.mAudioManager.getStreamVolume(3);
        hXI = 100 / this.hXC;
        this.hXc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.jsT != null) {
                    c.this.jsT.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Eo) {
                        if (c.this.mStatus == 1 && c.this.hXE != 0) {
                            c.this.b(c.this.hXE == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hXE = 0;
                            c.this.hXD = 0;
                        }
                        if (!c.this.jsB.isPlaying()) {
                            c.this.jsG.setVisibility(8);
                            c.this.jsF.setVisibility(8);
                            c.this.jsH.setVisibility(8);
                        }
                    }
                    c.this.caV();
                    if (c.this.jsT != null) {
                        c.this.jsT.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eag = new com.baidu.tieba.play.o(this.mActivity);
        if (this.jtk) {
            this.eag.start();
        }
        this.hXG = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hXJ == null) {
            hXJ = new CallStateReceiver();
        }
        hXJ.register(this.mActivity);
        cwA();
        MessageManager.getInstance().registerListener(this.hXS);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hXS);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Ac(int i2) {
        if (this.Ow != null) {
            this.Ow.setDefaultBgResource(i2);
        }
    }

    public boolean cwz() {
        return this.mVideoType == 0 && (this.jsB instanceof QuickVideoView);
    }

    public void cwA() {
        if (this.jta) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hXc.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hXc.setSystemUiVisibility(0);
    }

    public void rA(boolean z) {
        this.jta = z;
        cwA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caV() {
        this.mStatus = 0;
        if (this.hXw != null && this.hXw.getParent() != null && (this.hXw.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hXw.getParent()).removeView(this.hXw);
                this.hXw = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hXx != null && this.hXx.getParent() != null && (this.hXx.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hXx.getParent()).removeView(this.hXx);
                this.hXx = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void caW() {
        if (this.mStatus == 1) {
            if (this.hXw == null && this.hXc != null && (this.hXc instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hXc, true);
                this.hXw = this.hXc.findViewById(R.id.lay_jindu);
                this.hXy = (TextView) this.hXw.findViewById(R.id.show_time);
                this.hXB = (ImageView) this.hXw.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hXx == null && this.hXc != null && (this.hXc instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hXc, true);
            this.hXx = this.hXc.findViewById(R.id.lay_voice);
            this.hXA = (ImageView) this.hXx.findViewById(R.id.arrow_voice_icon);
            this.hXz = (SeekBar) this.hXx.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jsM = onClickListener;
    }

    public void rB(boolean z) {
        this.jsL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.jsT != null) {
                c.this.jsT.onStart();
            }
            if (c.this.EA && c.this.Eo) {
                if (c.this.mStatus == 1) {
                    c.this.cwR();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aD(f2);
                    }
                } else {
                    if (c.this.EA) {
                        c.this.caY();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hXD = c.this.jsB.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aD(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.jtl) {
                if (c.this.jsU != null && c.this.jsU.crb()) {
                    return true;
                }
                c.this.cqS();
                c.this.cwT();
                if (c.this.jsB.isPlaying()) {
                    c.this.cwO();
                } else {
                    c.this.cwP();
                }
                if (c.this.jsV != null) {
                    c.this.jsV.mj(c.this.jsB.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.jtl) {
                if (c.this.Eo) {
                    if (c.this.jsU != null && c.this.jsU.crc()) {
                        return true;
                    }
                    c.this.cwN();
                    if (c.this.jsB.isPlaying()) {
                        c.this.cwO();
                    } else {
                        c.this.cwP();
                    }
                    if (c.this.jsV != null) {
                        c.this.jsV.mj(c.this.jsB.isPlaying());
                    }
                } else {
                    c.this.cqS();
                    c.this.cwT();
                    if (c.this.currentState != 1) {
                        c.this.cwP();
                        c.this.cwQ();
                    } else {
                        c.this.cbl();
                    }
                    if (c.this.jsV != null) {
                        c.this.jsV.mj(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caY() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hXc.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hXc.setSystemUiVisibility(4);
        } else {
            this.hXc.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(float f2) {
        if (!this.Eo) {
            this.mStatus = 0;
            return;
        }
        caW();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hXI == 0) {
            if (f2 > 0.0f && this.hXH < this.hXC) {
                this.hXH++;
            }
            if (f2 < 0.0f && this.hXH > 0) {
                this.hXH--;
            }
        }
        if (this.mProgress > 0) {
            this.hXA.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hXA.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hXH, 0);
        this.hXz.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hXD -= 1000;
                this.hXE = 1;
            } else {
                this.hXD += 1000;
                this.hXE = 2;
            }
            if (this.hXD < 0) {
                this.hXD = 0;
            } else if (this.hXD > this.jsB.getDuration()) {
                this.hXD = this.jsB.getDuration();
            }
        }
        caW();
        String Ak = this.hXe.Ak(this.hXD);
        if (f2 > 0.0f) {
            this.hXB.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hXB.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Ak)) {
            this.hXy.setText(new StringBuilder().append(Ak).append("/").append(this.hXe.Ak(this.jsB.getDuration())));
        }
        this.hXe.setCurrentDuration(this.hXD, z ? false : true);
        cwR();
        cwG();
    }

    protected View aq(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.OG = str2;
    }

    public void setFid(String str) {
        this.fKa = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bth() {
        if (this.jsB != null && this.hXe != null) {
            this.hXe.showProgress();
            this.mStartPosition = x.cxU().GP(this.mVideoUrl);
            if (this.jti) {
                this.jsB.setVolume(1.0f, 1.0f);
                this.jsB.start();
                this.jti = false;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.Eu);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.Eu, 20L);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXN);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jtp);
                if (this.jsB.cxq()) {
                    this.currentState = 1;
                    if (cwz()) {
                        ((QuickVideoView) this.jsB).setRecoveryState(1);
                    }
                    cwR();
                }
                this.mStartPosition = x.cxU().GP(this.mVideoUrl);
                this.hXe.setPlayer(this.jsB);
                if (this.mStartPosition != 0) {
                    this.jtc = true;
                }
                if (!this.jth) {
                    this.hXe.showProgress();
                }
                if (!this.jsL && this.jsB.getDuration() <= 0) {
                    caZ().setVisibility(4);
                }
            }
            this.Ep = (this.mStartPosition <= 100 || this.jsB.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        if (this.Ow.getVisibility() != 8 || !this.Eo) {
            this.Eo = true;
            this.hXf.setVisibility(8);
            this.fJG.setVisibility(8);
            this.dHV.cxQ();
            this.Ow.setVisibility(8);
            cwS();
            long duration = this.jsB.getDuration() / 1000;
            String str = this.OG;
            this.hXe.showProgress();
            this.jsC.setVisibility(0);
            if (this.hXp != null && cwz()) {
                this.hXp.onPrepared(((QuickVideoView) this.jsB).getPlayer());
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

    protected void rC(boolean z) {
        if (hasNavBar(this.mActivity) && (this.jsD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsD.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.jsD.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.jsD.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.jsD.setLayoutParams(layoutParams);
        }
    }

    public void cqS() {
        if (this.jsB.isPlaying()) {
            pausePlay();
            if (this.jsZ != null) {
                this.jsZ.onPause();
            }
            if (this.jsQ != null) {
                this.jsQ.onPaused();
            }
        } else if (this.Eo) {
            ahK();
            if (this.iWE != null) {
                this.iWE.bEM();
            }
            if (this.jsQ != null) {
                this.jsQ.cwY();
            }
        } else {
            cwK();
        }
    }

    public void xH() {
        this.hXK = true;
        if (this.eag != null) {
            this.eag.xH();
        }
    }

    public boolean cwB() {
        return this.jsB != null && this.jsB.getView().getHeight() > this.jsB.getView().getWidth();
    }

    public void cwC() {
        rC(false);
        cwF();
    }

    public boolean Ad(int i2) {
        switch (i2) {
            case 4:
                if (this.EA) {
                    if (cwB()) {
                        rC(false);
                        cwF();
                    } else {
                        xH();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hXC <= 0 || this.hXz == null) {
                    return false;
                }
                this.hXH = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hXH * 100.0d) / this.hXC);
                this.hXz.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cwz()) {
            return (QuickVideoView) this.jsB;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cwD() {
        return this.jsB;
    }

    public VideoListMediaControllerView caZ() {
        return this.hXe;
    }

    public void show() {
        this.hXc.setVisibility(0);
    }

    public void cbd() {
        if (this.hXn != null) {
            ViewGroup.LayoutParams layoutParams = this.hXn.getLayoutParams();
            this.hXh = (FrameLayout.LayoutParams) this.hXc.getLayoutParams();
            this.hXh.width = layoutParams.width;
            this.hXh.height = layoutParams.height;
            this.hXh.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.hXc.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.hXc.setLayoutParams(this.hXh);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hXK) {
            if (this.EA) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hXK = false;
        }
        if (configuration.orientation == 2) {
            cwE();
        } else {
            cwF();
        }
        cwG();
        ahK();
        cwT();
        cbl();
        if (this.jsV != null) {
            this.jsV.mj(true);
        }
    }

    protected void cwE() {
        this.EA = true;
        if (cwB()) {
            this.hXc.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hXc.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.ayH.setVisibility(0);
        this.hXr.setVisibility(0);
        this.hXs.setVisibility(0);
        this.hXg.setVisibility(8);
        this.dHV.cxR();
        this.Ow.setVisibility(8);
        this.hXk.setImageResource(R.drawable.icon_video_narrow_white);
        xr(this.hXG);
        caY();
        if (this.jsN != null) {
            this.jsN.kN();
        }
    }

    protected void cwF() {
        this.EA = false;
        if (this.hXh != null) {
            this.hXc.setLayoutParams(this.hXh);
        }
        g(this.mActivity, false);
        this.ayH.setVisibility(8);
        this.hXg.setVisibility(0);
        this.dHV.cxR();
        this.Ow.setVisibility(8);
        this.hXk.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hXe != null && (this.hXe.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXe.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hXe.setLayoutParams(layoutParams);
        }
        this.hXc.setSystemUiVisibility(0);
        cwA();
        if (this.jsN != null) {
            this.jsN.kO();
        }
    }

    public void cwG() {
        if (this.jsB != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.EA) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.jsC.setMax(equipmentWidth);
            int duration = this.jsB.getDuration();
            if (duration > 0) {
                if (this.jsF.getVisibility() == 0) {
                    this.jsC.setProgress(this.jsC.getMax());
                } else {
                    this.jsC.setProgress((int) ((this.jsB.getCurrentPositionSync() * this.jsC.getMax()) / duration));
                }
            }
        }
    }

    private void xr(int i2) {
        if (this.hXe != null && (this.hXe.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXe.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hXe.setLayoutParams(layoutParams);
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

    public boolean cbf() {
        return !this.EA;
    }

    public void a(g.f fVar) {
        this.hXp = fVar;
    }

    public void a(g.a aVar) {
        this.jsI = aVar;
    }

    public void a(g.b bVar) {
        this.jsJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.jtd) {
            ea(str, str2);
        } else {
            dZ(str, str2);
        }
        if (eVar != null) {
            eVar.rK(z);
        }
    }

    public void dY(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, boolean z) {
        cwL();
        this.jti = true;
        this.currentState = 0;
        if (cwz()) {
            ((QuickVideoView) this.jsB).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.jsB.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXN);
        if (this.jsP > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hXN, this.jsP);
        }
        if (this.jsQ != null) {
            this.jsQ.onStarted();
        }
        this.dHV.startLoading();
        rD(z);
    }

    public void dZ(String str, String str2) {
        y(str, str2, true);
    }

    public void ea(String str, String str2) {
        cwL();
        this.jti = true;
        this.currentState = 0;
        if (cwz()) {
            ((QuickVideoView) this.jsB).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXN);
        if (this.jsP > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hXN, this.jsP);
        }
        if (this.jsQ != null) {
            this.jsQ.onStarted();
        }
        this.dHV.startLoading();
        rD(true);
    }

    public void cwH() {
        ahK();
        this.jsC.setVisibility(0);
    }

    public void ahK() {
        if (this.jsB != null && this.hXe != null) {
            this.Eo = true;
            this.currentState = 1;
            if (cwz()) {
                ((QuickVideoView) this.jsB).setRecoveryState(1);
            }
            this.jsB.a(null);
            this.mStartPosition = x.cxU().GP(this.mVideoUrl);
            this.jtc = true;
            this.Ep = (this.mStartPosition <= 100 || this.jsB.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.dHV.cxR();
            rD(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.jtg && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.OG)) {
            this.jtg = false;
            this.jth = true;
            dZ(this.mVideoUrl, this.OG);
        }
    }

    private void rD(boolean z) {
        if (z) {
            this.Ow.setVisibility(0);
            cwR();
            this.jsC.setProgress(0);
        } else {
            this.Ow.setVisibility(8);
            cwR();
        }
        this.hXe.showProgress();
        this.hXf.setVisibility(8);
        this.jsG.setVisibility(8);
        this.jsF.setVisibility(8);
        this.jsH.setVisibility(8);
        this.fJG.setVisibility(8);
    }

    private void cwI() {
        this.dHV.cxR();
        this.jsG.setVisibility(8);
        this.jsF.setVisibility(8);
        this.jsH.setVisibility(8);
        cwT();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.jsB instanceof QuickVideoView) {
            ((QuickVideoView) this.jsB).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.jsB.pause();
        this.currentState = 2;
        if (cwz()) {
            ((QuickVideoView) this.jsB).setRecoveryState(2);
        }
        cwI();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cwz()) {
            ((QuickVideoView) this.jsB).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.Eu);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXN);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jtp);
        this.jsB.stopPlayback();
        this.Eo = false;
        this.jti = false;
        this.mStartPosition = 0;
        bOk();
    }

    public void cwJ() {
        if (this.jsB.getDuration() >= this.jsB.getCurrentPosition()) {
            x.cxU().bn(this.mVideoUrl, this.jsB.getCurrentPosition());
        }
    }

    public void rE(boolean z) {
        this.jtb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rF(boolean z) {
        if (this.hXl != null) {
            this.hXf.setVisibility(0);
            this.jsG.setVisibility(8);
            this.jsF.setVisibility(8);
            this.jsH.setVisibility(8);
            this.dHV.cxR();
            cwR();
            this.jsC.setVisibility(8);
            this.fJG.setVisibility(8);
            this.hXe.ahT();
            this.Ow.setVisibility(z ? 0 : 8);
        }
    }

    public void bOk() {
        rF(true);
    }

    public boolean kP() {
        if (this.jsB == null) {
            return false;
        }
        return this.jsB.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.jsB == null) {
            return 0;
        }
        return this.jsB.getCurrentPosition();
    }

    public void a(k kVar) {
        this.jsT = kVar;
    }

    public void a(j jVar) {
        this.jsS = jVar;
    }

    public void a(i iVar) {
        this.iWE = iVar;
    }

    public void a(g gVar) {
        this.jsZ = gVar;
    }

    public void a(h hVar) {
        this.jsR = hVar;
    }

    public void Gh(String str) {
        this.iWe = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwK() {
        a(this.mVideoUrl, this.OG, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.jsO = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cwL();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cNI().cNJ()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.jtd = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.jsY != null) {
                    this.jsY.lE(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.sC(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cwM();
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
                aVar.b(this.cRe).aCp();
                return;
            } else if (this.jsY != null) {
                this.jsY.lE(true);
                return;
            } else {
                if (!this.jsA) {
                    this.jsA = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.jsX != null) {
            this.jsX.bEJ();
        }
    }

    private void cwL() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cNI().fy(this.mActivity);
        }
    }

    public void cwM() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.Ow.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXR);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.Eu);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXN);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jto);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jtp);
        this.eag.stop();
        hXJ.unregister(this.mActivity);
    }

    public void GJ(String str) {
        this.hXs.setText(str);
    }

    public boolean cbh() {
        return this.Eo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwN() {
        if (this.hXl != null) {
            if (this.jsK) {
                cwR();
            } else {
                cwQ();
            }
        }
    }

    public void cbl() {
        cwQ();
        cwO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwO() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXR);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.hXR, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwP() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXR);
    }

    public void cwQ() {
        if (this.hXl != null && !this.jsK && !this.jtm) {
            rG(true);
            cbk();
            this.hXl.setVisibility(0);
            this.jsD.setVisibility(0);
            this.jsC.setVisibility(8);
            this.jsK = true;
            if (this.jsO != null) {
                this.jsO.lF(false);
            }
        }
    }

    public void cbi() {
        if (this.hXl != null && this.jsK) {
            rG(false);
            cbk();
            this.hXl.setVisibility(8);
            this.jsD.setVisibility(8);
            this.jsC.setVisibility(0);
            this.gsc.setAnimationListener(this.hXP);
            this.hXl.startAnimation(this.gsc);
            this.jsK = false;
            if (this.jsO != null) {
                this.jsO.bEL();
            }
        }
    }

    public void cwR() {
        if (this.hXl != null && this.jsK) {
            this.aHr.cancel();
            this.gsc.cancel();
            rG(false);
            cbk();
            this.hXl.setVisibility(8);
            this.jsD.setVisibility(8);
            this.jsC.setVisibility(0);
            this.jsK = false;
            if (this.jsO != null) {
                this.jsO.bEL();
            }
        }
    }

    private void cbk() {
        if (this.hXl != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hXR);
            this.aHr.setAnimationListener(null);
            this.gsc.setAnimationListener(null);
            this.hXl.clearAnimation();
        }
    }

    private void cwS() {
        if (this.hXl != null) {
            this.aHr.setAnimationListener(null);
            this.gsc.setAnimationListener(null);
            this.hXl.clearAnimation();
        }
    }

    public void rG(boolean z) {
        cwT();
        if (z) {
            this.jsE.setVisibility(0);
        } else {
            this.jsE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwT() {
        if (this.currentState == 1) {
            this.jsE.setState(1);
        } else {
            this.jsE.setState(0);
        }
    }

    public void a(InterfaceC0581c interfaceC0581c) {
        this.jsN = interfaceC0581c;
    }

    public void xu(int i2) {
        this.mStartPosition = i2;
    }

    public void ah(boolean z, boolean z2) {
        if (this.eag != null) {
            if (this.hXk != null) {
                this.hXk.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hXe != null && (this.hXe.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXe.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hXe.setLayoutParams(layoutParams);
            }
            this.eag.bf(z);
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

    public void rH(boolean z) {
        this.jtl = z;
    }

    public void a(m mVar) {
        this.jsU = mVar;
    }

    public void a(a aVar) {
        this.jsV = aVar;
    }

    public void a(n nVar) {
        this.jsW = nVar;
    }

    public void a(l lVar) {
        this.jsX = lVar;
    }

    public void a(f fVar) {
        this.jsY = fVar;
    }

    public void rI(boolean z) {
        this.jtf = z;
    }

    public void rJ(boolean z) {
        this.jsL = z;
        if (z) {
            this.jsB.setPageTypeForPerfStat("middle");
        } else {
            this.jsB.setPageTypeForPerfStat("pb");
        }
    }

    public void Ae(int i2) {
        this.jtj = i2;
    }

    public View cwU() {
        return this.hXc;
    }

    public void a(p pVar) {
        this.iWs = pVar;
    }

    public void cwV() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cRe.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cRe.getPageActivity());
    }
}
