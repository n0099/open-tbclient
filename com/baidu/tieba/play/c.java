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
    private static int hgb;
    private static CallStateReceiver hgc;
    private boolean BD;
    private int BE;
    private Runnable BJ;
    protected boolean BP;
    private View aqi;
    private Animation ayN;
    private QuickVideoView.b cTC;
    private x cTt;
    private TbPageContext<?> ceu;
    private String cln;
    private String cma;
    private int currentState;
    private g.a dcS;
    private g.f dcT;
    private g.e dcV;
    private g.InterfaceC0498g dcW;
    private SeekBar.OnSeekBarChangeListener dhY;
    private com.baidu.tieba.play.o dpP;
    private VideoLoadingProgressView.a eMc;
    protected View eOI;
    private String ePc;
    private Animation fAx;
    private ImageView hfC;
    private View hfD;
    private View hfF;
    private TbImageView hfH;
    private g.f hfI;
    private ImageView hfK;
    private TextView hfL;
    private View hfP;
    private View hfQ;
    private TextView hfR;
    private SeekBar hfS;
    private ImageView hfT;
    private ImageView hfU;
    private int hfV;
    private int hfW;
    private int hfX;
    private int hfZ;
    public View hfu;
    private VideoListMediaControllerView hfw;
    private View hfx;
    private FrameLayout hfy;
    protected FrameLayout.LayoutParams hfz;
    private int hga;
    private boolean hgd;
    private g.b hgf;
    protected Runnable hgg;
    private Animation.AnimationListener hgi;
    private Animation.AnimationListener hgj;
    private Runnable hgk;
    private CustomMessageListener hgl;
    private VideoControllerView.b hih;
    private String idE;
    private p idS;
    private i iee;
    private int iuY;
    private boolean iuZ;
    private boolean ivA;
    private boolean ivB;
    private boolean ivC;
    private TextView ivD;
    private boolean ivE;
    private boolean ivF;
    private boolean ivG;
    private boolean ivH;
    private int ivI;
    private boolean ivJ;
    private boolean ivK;
    private boolean ivL;
    private boolean ivM;
    private Runnable ivN;
    private Runnable ivO;
    private QuickVideoView.a ivP;
    protected com.baidu.tieba.play.a.a iva;
    private ProgressBar ivb;
    private View ivc;
    private SwitchImageView ivd;
    private TextView ive;
    private TextView ivf;
    private TextView ivg;
    private g.a ivh;
    private g.b ivi;
    private boolean ivj;
    private boolean ivk;
    private View.OnClickListener ivl;
    protected InterfaceC0497c ivm;
    private d ivn;
    private long ivo;
    private o ivp;
    private h ivq;
    private j ivr;
    private k ivs;
    private m ivt;
    private a ivu;
    private n ivv;
    private l ivw;
    private f ivx;
    private g ivy;
    private boolean ivz;
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
        void bmm();

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
        void bYe();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bmn();
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
        void bmk();

        void bml();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bYf();

        boolean bYg();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aHw();

        void aHx();

        void aHy();

        void lT(int i);

        void onPrepared();

        void onStarted();

        void qL();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bYd();
    }

    public c(Activity activity, View view, boolean z) {
        this.iuY = 0;
        this.BE = 100;
        this.iuZ = false;
        this.BP = false;
        this.BD = false;
        this.ivj = false;
        this.ivk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hfW = 0;
        this.hfX = 0;
        this.ivo = 60000L;
        this.hfZ = 0;
        this.hgd = false;
        this.ivz = true;
        this.ivA = true;
        this.ivB = false;
        this.ivC = false;
        this.idE = null;
        this.currentState = -1;
        this.ivE = false;
        this.ivJ = true;
        this.ivL = false;
        this.ivM = false;
        this.dcT = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hfw != null && c.this.iva != null && c.this.iva.getDuration() > 0) {
                    c.this.hfw.aB(0, c.this.iva.getDuration());
                }
                c.this.bab();
                if (c.this.ivp != null) {
                    c.this.ivp.onPrepared();
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.kM();
                    return false;
                }
                return false;
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bab();
            }
        };
        this.BJ = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.BJ);
                if (c.this.hfH.getVisibility() != 8) {
                    if (c.this.iva.getCurrentPosition() > c.this.BE) {
                        c.this.kM();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 20L);
                    }
                }
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.iva != null) {
                    int duration = c.this.iva.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.BD = false;
                        c.this.ivH = false;
                        c.this.mStartPosition = 0;
                        c.this.bIy();
                        c.this.hfx.setVisibility(0);
                        c.this.ivb.setProgress(c.this.ivb.getMax());
                        c.this.BE = 100;
                        if (c.this.ivh != null) {
                            c.this.ivh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cby()) {
                            ((QuickVideoView) c.this.iva).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.pK(false);
                            c.this.pL(true);
                        } else {
                            c.this.cbS();
                            c.this.ive.setVisibility(0);
                        }
                        if (!c.this.BP && duration <= 150000) {
                            if (!c.this.ivE) {
                                if (c.this.ivr != null) {
                                    c.this.ivr.ph(true);
                                }
                                c.this.y(c.this.cln, c.this.cma, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cby()) {
                                    ((QuickVideoView) c.this.iva).setRecoveryState(5);
                                }
                                c.this.iva.pause();
                                c.this.iva.seekTo(0);
                            }
                        }
                        if (c.this.ivp != null) {
                            c.this.ivp.lT(c.this.ivb.getMax());
                            c.this.ivp.qL();
                        }
                    }
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.eOI.setVisibility(0);
                c.this.cTt.ccN();
                c.this.currentState = 4;
                if (c.this.cby()) {
                    ((QuickVideoView) c.this.iva).setRecoveryState(4);
                }
                if (c.this.ivi != null) {
                    c.this.ivi.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.ivF = true;
                }
                if (c.this.ivp != null) {
                    c.this.ivp.aHx();
                }
                c.this.ivH = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iva == null || !c.this.iva.isPlaying()) {
                    c.this.eOI.setVisibility(0);
                    c.this.cTt.ccN();
                    if (c.this.ivp != null) {
                        c.this.ivp.aHx();
                    }
                }
            }
        };
        this.dcW = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.ivB) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivN, 200L);
                }
            }
        };
        this.ivN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iva == null || !c.this.ivB) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 200L);
                    c.this.ivB = false;
                } else if (c.this.mStartPosition != c.this.iva.getCurrentPosition()) {
                    c.this.ivB = false;
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 20L);
                } else {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivN, 200L);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.BD = false;
                if (c.this.ivk) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivO, 300L);
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.BJ);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgg);
            }
        };
        this.ivO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ivH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.idS != null) {
                    c.this.idS.bYd();
                }
                if (view2.getId() != c.this.eOI.getId()) {
                    if (view2.getId() != c.this.ivd.getId()) {
                        if (view2.getId() == c.this.ivf.getId()) {
                            if (c.this.ivq != null) {
                                c.this.ivq.bYe();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ive.getId()) {
                            if (c.this.ivr != null) {
                                c.this.ivr.ph(false);
                            }
                            c.this.cm(c.this.cln, c.this.cma);
                            return;
                        } else if (view2.getId() == c.this.hfC.getId()) {
                            int i2 = c.this.ivk ? 1 : 2;
                            if (c.this.BP) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cma).bS("fid", c.this.ePc).O("obj_type", i2).O("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cma).bS("fid", c.this.ePc).O("obj_type", i2).O("obj_source", 1));
                            }
                            if (c.this.ivw != null) {
                                c.this.ivw.bml();
                            }
                            if (c.this.cbC()) {
                                if (c.this.BP) {
                                    c.this.cbG();
                                } else {
                                    c.this.cbF();
                                }
                                c.this.pH(c.this.BP);
                                return;
                            }
                            c.this.vt();
                            return;
                        } else if (view2.getId() != c.this.hfK.getId()) {
                            if (c.this.ivl != null) {
                                c.this.ivl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.ivw != null) {
                                c.this.ivw.bml();
                            }
                            if (c.this.cbC()) {
                                c.this.cbG();
                                c.this.pH(false);
                                return;
                            }
                            c.this.vt();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.bXU();
                    c.this.cbU();
                    if (c.this.currentState != 1) {
                        c.this.cbQ();
                        c.this.cbR();
                    } else {
                        c.this.bIP();
                    }
                    if (c.this.ivu != null) {
                        c.this.ivu.kL(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.iva.stopPlayback();
                c.this.BD = false;
                c.this.cbL();
            }
        };
        this.hgi = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hgj = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hgk = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bIM();
            }
        };
        this.hgl = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hih = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lD(int i2) {
                int duration;
                if (c.this.iva != null && (duration = c.this.iva.getDuration()) > 0 && c.this.ivb != null) {
                    c.this.ivb.setProgress((int) ((i2 * c.this.hfu.getWidth()) / duration));
                    if (c.this.ivp != null) {
                        c.this.ivp.lT((c.this.iva.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dhY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cbQ();
                c.this.pL(false);
                if (c.this.ivu != null) {
                    c.this.ivu.kL(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bIC() != null) {
                    c.this.vn(c.this.bIC().getSeekPosition());
                    if (!c.this.bIL()) {
                        c.this.cbL();
                    } else {
                        c.this.bIK();
                        if (c.this.iee != null) {
                            c.this.iee.bmn();
                        }
                    }
                }
                c.this.pL(true);
                c.this.cbP();
                if (c.this.ivu != null) {
                    c.this.ivu.kL(true);
                }
                if (c.this.ivv != null) {
                    c.this.ivv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.ivP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbX() {
                if (!c.this.ivE) {
                    c.this.cTt.startLoading();
                    c.this.hfH.setVisibility(0);
                    c.this.ivd.setVisibility(8);
                    c.this.ivf.setVisibility(8);
                    c.this.ive.setVisibility(8);
                    c.this.ivg.setVisibility(8);
                    c.this.eOI.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgg);
                    if (c.this.ivo > 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.hgg, c.this.ivo);
                    }
                }
            }
        };
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.ivJ = z;
            this.hfF = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.iuY = 0;
        this.BE = 100;
        this.iuZ = false;
        this.BP = false;
        this.BD = false;
        this.ivj = false;
        this.ivk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hfW = 0;
        this.hfX = 0;
        this.ivo = 60000L;
        this.hfZ = 0;
        this.hgd = false;
        this.ivz = true;
        this.ivA = true;
        this.ivB = false;
        this.ivC = false;
        this.idE = null;
        this.currentState = -1;
        this.ivE = false;
        this.ivJ = true;
        this.ivL = false;
        this.ivM = false;
        this.dcT = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hfw != null && c.this.iva != null && c.this.iva.getDuration() > 0) {
                    c.this.hfw.aB(0, c.this.iva.getDuration());
                }
                c.this.bab();
                if (c.this.ivp != null) {
                    c.this.ivp.onPrepared();
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.kM();
                    return false;
                }
                return false;
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bab();
            }
        };
        this.BJ = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.BJ);
                if (c.this.hfH.getVisibility() != 8) {
                    if (c.this.iva.getCurrentPosition() > c.this.BE) {
                        c.this.kM();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 20L);
                    }
                }
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.iva != null) {
                    int duration = c.this.iva.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.BD = false;
                        c.this.ivH = false;
                        c.this.mStartPosition = 0;
                        c.this.bIy();
                        c.this.hfx.setVisibility(0);
                        c.this.ivb.setProgress(c.this.ivb.getMax());
                        c.this.BE = 100;
                        if (c.this.ivh != null) {
                            c.this.ivh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cby()) {
                            ((QuickVideoView) c.this.iva).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.pK(false);
                            c.this.pL(true);
                        } else {
                            c.this.cbS();
                            c.this.ive.setVisibility(0);
                        }
                        if (!c.this.BP && duration <= 150000) {
                            if (!c.this.ivE) {
                                if (c.this.ivr != null) {
                                    c.this.ivr.ph(true);
                                }
                                c.this.y(c.this.cln, c.this.cma, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cby()) {
                                    ((QuickVideoView) c.this.iva).setRecoveryState(5);
                                }
                                c.this.iva.pause();
                                c.this.iva.seekTo(0);
                            }
                        }
                        if (c.this.ivp != null) {
                            c.this.ivp.lT(c.this.ivb.getMax());
                            c.this.ivp.qL();
                        }
                    }
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.eOI.setVisibility(0);
                c.this.cTt.ccN();
                c.this.currentState = 4;
                if (c.this.cby()) {
                    ((QuickVideoView) c.this.iva).setRecoveryState(4);
                }
                if (c.this.ivi != null) {
                    c.this.ivi.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.ivF = true;
                }
                if (c.this.ivp != null) {
                    c.this.ivp.aHx();
                }
                c.this.ivH = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iva == null || !c.this.iva.isPlaying()) {
                    c.this.eOI.setVisibility(0);
                    c.this.cTt.ccN();
                    if (c.this.ivp != null) {
                        c.this.ivp.aHx();
                    }
                }
            }
        };
        this.dcW = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.ivB) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivN, 200L);
                }
            }
        };
        this.ivN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iva == null || !c.this.ivB) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 200L);
                    c.this.ivB = false;
                } else if (c.this.mStartPosition != c.this.iva.getCurrentPosition()) {
                    c.this.ivB = false;
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 20L);
                } else {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivN, 200L);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.BD = false;
                if (c.this.ivk) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivO, 300L);
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.BJ);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgg);
            }
        };
        this.ivO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ivH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.idS != null) {
                    c.this.idS.bYd();
                }
                if (view2.getId() != c.this.eOI.getId()) {
                    if (view2.getId() != c.this.ivd.getId()) {
                        if (view2.getId() == c.this.ivf.getId()) {
                            if (c.this.ivq != null) {
                                c.this.ivq.bYe();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ive.getId()) {
                            if (c.this.ivr != null) {
                                c.this.ivr.ph(false);
                            }
                            c.this.cm(c.this.cln, c.this.cma);
                            return;
                        } else if (view2.getId() == c.this.hfC.getId()) {
                            int i2 = c.this.ivk ? 1 : 2;
                            if (c.this.BP) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cma).bS("fid", c.this.ePc).O("obj_type", i2).O("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cma).bS("fid", c.this.ePc).O("obj_type", i2).O("obj_source", 1));
                            }
                            if (c.this.ivw != null) {
                                c.this.ivw.bml();
                            }
                            if (c.this.cbC()) {
                                if (c.this.BP) {
                                    c.this.cbG();
                                } else {
                                    c.this.cbF();
                                }
                                c.this.pH(c.this.BP);
                                return;
                            }
                            c.this.vt();
                            return;
                        } else if (view2.getId() != c.this.hfK.getId()) {
                            if (c.this.ivl != null) {
                                c.this.ivl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.ivw != null) {
                                c.this.ivw.bml();
                            }
                            if (c.this.cbC()) {
                                c.this.cbG();
                                c.this.pH(false);
                                return;
                            }
                            c.this.vt();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.bXU();
                    c.this.cbU();
                    if (c.this.currentState != 1) {
                        c.this.cbQ();
                        c.this.cbR();
                    } else {
                        c.this.bIP();
                    }
                    if (c.this.ivu != null) {
                        c.this.ivu.kL(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.iva.stopPlayback();
                c.this.BD = false;
                c.this.cbL();
            }
        };
        this.hgi = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hgj = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hgk = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bIM();
            }
        };
        this.hgl = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hih = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lD(int i2) {
                int duration;
                if (c.this.iva != null && (duration = c.this.iva.getDuration()) > 0 && c.this.ivb != null) {
                    c.this.ivb.setProgress((int) ((i2 * c.this.hfu.getWidth()) / duration));
                    if (c.this.ivp != null) {
                        c.this.ivp.lT((c.this.iva.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dhY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cbQ();
                c.this.pL(false);
                if (c.this.ivu != null) {
                    c.this.ivu.kL(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bIC() != null) {
                    c.this.vn(c.this.bIC().getSeekPosition());
                    if (!c.this.bIL()) {
                        c.this.cbL();
                    } else {
                        c.this.bIK();
                        if (c.this.iee != null) {
                            c.this.iee.bmn();
                        }
                    }
                }
                c.this.pL(true);
                c.this.cbP();
                if (c.this.ivu != null) {
                    c.this.ivu.kL(true);
                }
                if (c.this.ivv != null) {
                    c.this.ivv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.ivP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbX() {
                if (!c.this.ivE) {
                    c.this.cTt.startLoading();
                    c.this.hfH.setVisibility(0);
                    c.this.ivd.setVisibility(8);
                    c.this.ivf.setVisibility(8);
                    c.this.ive.setVisibility(8);
                    c.this.ivg.setVisibility(8);
                    c.this.eOI.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgg);
                    if (c.this.ivo > 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.hgg, c.this.ivo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.ceu = tbPageContext;
            this.mRootView = view;
            this.ivJ = z;
            this.hfF = view;
            this.mActivity = this.ceu.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.iuY = 0;
        this.BE = 100;
        this.iuZ = false;
        this.BP = false;
        this.BD = false;
        this.ivj = false;
        this.ivk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hfW = 0;
        this.hfX = 0;
        this.ivo = 60000L;
        this.hfZ = 0;
        this.hgd = false;
        this.ivz = true;
        this.ivA = true;
        this.ivB = false;
        this.ivC = false;
        this.idE = null;
        this.currentState = -1;
        this.ivE = false;
        this.ivJ = true;
        this.ivL = false;
        this.ivM = false;
        this.dcT = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hfw != null && c.this.iva != null && c.this.iva.getDuration() > 0) {
                    c.this.hfw.aB(0, c.this.iva.getDuration());
                }
                c.this.bab();
                if (c.this.ivp != null) {
                    c.this.ivp.onPrepared();
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.kM();
                    return false;
                }
                return false;
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bab();
            }
        };
        this.BJ = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.BJ);
                if (c.this.hfH.getVisibility() != 8) {
                    if (c.this.iva.getCurrentPosition() > c.this.BE) {
                        c.this.kM();
                    } else {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 20L);
                    }
                }
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.iva != null) {
                    int duration = c.this.iva.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.BD = false;
                        c.this.ivH = false;
                        c.this.mStartPosition = 0;
                        c.this.bIy();
                        c.this.hfx.setVisibility(0);
                        c.this.ivb.setProgress(c.this.ivb.getMax());
                        c.this.BE = 100;
                        if (c.this.ivh != null) {
                            c.this.ivh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cby()) {
                            ((QuickVideoView) c.this.iva).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.pK(false);
                            c.this.pL(true);
                        } else {
                            c.this.cbS();
                            c.this.ive.setVisibility(0);
                        }
                        if (!c.this.BP && duration <= 150000) {
                            if (!c.this.ivE) {
                                if (c.this.ivr != null) {
                                    c.this.ivr.ph(true);
                                }
                                c.this.y(c.this.cln, c.this.cma, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cby()) {
                                    ((QuickVideoView) c.this.iva).setRecoveryState(5);
                                }
                                c.this.iva.pause();
                                c.this.iva.seekTo(0);
                            }
                        }
                        if (c.this.ivp != null) {
                            c.this.ivp.lT(c.this.ivb.getMax());
                            c.this.ivp.qL();
                        }
                    }
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.eOI.setVisibility(0);
                c.this.cTt.ccN();
                c.this.currentState = 4;
                if (c.this.cby()) {
                    ((QuickVideoView) c.this.iva).setRecoveryState(4);
                }
                if (c.this.ivi != null) {
                    c.this.ivi.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.ivF = true;
                }
                if (c.this.ivp != null) {
                    c.this.ivp.aHx();
                }
                c.this.ivH = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iva == null || !c.this.iva.isPlaying()) {
                    c.this.eOI.setVisibility(0);
                    c.this.cTt.ccN();
                    if (c.this.ivp != null) {
                        c.this.ivp.aHx();
                    }
                }
            }
        };
        this.dcW = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.ivB) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivN, 200L);
                }
            }
        };
        this.ivN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iva == null || !c.this.ivB) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 200L);
                    c.this.ivB = false;
                } else if (c.this.mStartPosition != c.this.iva.getCurrentPosition()) {
                    c.this.ivB = false;
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.BJ, 20L);
                } else {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivN, 200L);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.BD = false;
                if (c.this.ivk) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.ivO, 300L);
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.BJ);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgg);
            }
        };
        this.ivO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ivH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.idS != null) {
                    c.this.idS.bYd();
                }
                if (view2.getId() != c.this.eOI.getId()) {
                    if (view2.getId() != c.this.ivd.getId()) {
                        if (view2.getId() == c.this.ivf.getId()) {
                            if (c.this.ivq != null) {
                                c.this.ivq.bYe();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ive.getId()) {
                            if (c.this.ivr != null) {
                                c.this.ivr.ph(false);
                            }
                            c.this.cm(c.this.cln, c.this.cma);
                            return;
                        } else if (view2.getId() == c.this.hfC.getId()) {
                            int i22 = c.this.ivk ? 1 : 2;
                            if (c.this.BP) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cma).bS("fid", c.this.ePc).O("obj_type", i22).O("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bS("tid", c.this.cma).bS("fid", c.this.ePc).O("obj_type", i22).O("obj_source", 1));
                            }
                            if (c.this.ivw != null) {
                                c.this.ivw.bml();
                            }
                            if (c.this.cbC()) {
                                if (c.this.BP) {
                                    c.this.cbG();
                                } else {
                                    c.this.cbF();
                                }
                                c.this.pH(c.this.BP);
                                return;
                            }
                            c.this.vt();
                            return;
                        } else if (view2.getId() != c.this.hfK.getId()) {
                            if (c.this.ivl != null) {
                                c.this.ivl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.ivw != null) {
                                c.this.ivw.bml();
                            }
                            if (c.this.cbC()) {
                                c.this.cbG();
                                c.this.pH(false);
                                return;
                            }
                            c.this.vt();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.bXU();
                    c.this.cbU();
                    if (c.this.currentState != 1) {
                        c.this.cbQ();
                        c.this.cbR();
                    } else {
                        c.this.bIP();
                    }
                    if (c.this.ivu != null) {
                        c.this.ivu.kL(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.iva.stopPlayback();
                c.this.BD = false;
                c.this.cbL();
            }
        };
        this.hgi = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hgj = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hgk = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bIM();
            }
        };
        this.hgl = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hih = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lD(int i22) {
                int duration;
                if (c.this.iva != null && (duration = c.this.iva.getDuration()) > 0 && c.this.ivb != null) {
                    c.this.ivb.setProgress((int) ((i22 * c.this.hfu.getWidth()) / duration));
                    if (c.this.ivp != null) {
                        c.this.ivp.lT((c.this.iva.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dhY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cbQ();
                c.this.pL(false);
                if (c.this.ivu != null) {
                    c.this.ivu.kL(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bIC() != null) {
                    c.this.vn(c.this.bIC().getSeekPosition());
                    if (!c.this.bIL()) {
                        c.this.cbL();
                    } else {
                        c.this.bIK();
                        if (c.this.iee != null) {
                            c.this.iee.bmn();
                        }
                    }
                }
                c.this.pL(true);
                c.this.cbP();
                if (c.this.ivu != null) {
                    c.this.ivu.kL(true);
                }
                if (c.this.ivv != null) {
                    c.this.ivv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.ivP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbX() {
                if (!c.this.ivE) {
                    c.this.cTt.startLoading();
                    c.this.hfH.setVisibility(0);
                    c.this.ivd.setVisibility(8);
                    c.this.ivf.setVisibility(8);
                    c.this.ive.setVisibility(8);
                    c.this.ivg.setVisibility(8);
                    c.this.eOI.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(c.this.hgg);
                    if (c.this.ivo > 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(c.this.hgg, c.this.ivo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.ceu = tbPageContext;
            this.mRootView = view;
            this.ivJ = z;
            this.hfF = view;
            this.mActivity = this.ceu.getPageActivity();
            this.iuY = i2;
            init();
        }
    }

    public void init() {
        this.hfu = ak(this.mActivity);
        this.hfu.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hfu);
        }
        this.iva = com.baidu.tieba.play.a.b.x(this.mActivity, this.iuY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hfu).addView(this.iva.getView(), 0);
        this.iva.getView().setLayoutParams(layoutParams);
        this.cTt = new x((ViewGroup) this.hfu.findViewById(R.id.auto_video_loading_container));
        this.cTt.setLoadingAnimationListener(this.eMc);
        this.hfw = (VideoListMediaControllerView) this.hfu.findViewById(R.id.media_controller);
        this.hfw.setPlayer(this.iva);
        this.ivb = (ProgressBar) this.hfu.findViewById(R.id.pgrBottomProgress);
        this.ivb.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.ivb.setProgress(0);
        this.hfw.setOnSeekBarChangeListener(this.dhY);
        this.hfw.setOnProgressUpdatedListener(this.hih);
        this.hfx = this.hfu.findViewById(R.id.black_mask);
        this.eOI = this.hfu.findViewById(R.id.layout_error);
        this.eOI.setOnClickListener(this.mOnClickListener);
        this.ivD = (TextView) this.hfu.findViewById(R.id.auto_video_error_tips);
        this.hfy = (FrameLayout) this.hfu.findViewById(R.id.danmu_container);
        this.hfC = (ImageView) this.hfu.findViewById(R.id.img_full_screen);
        this.hfC.setOnClickListener(this.mOnClickListener);
        this.hfD = this.hfu.findViewById(R.id.layout_media_controller);
        this.ivc = this.hfu.findViewById(R.id.time_show_controller);
        this.iva.setContinuePlayEnable(true);
        this.iva.setOnPreparedListener(this.dcT);
        this.iva.setOnCompletionListener(this.dcS);
        this.iva.setOnErrorListener(this.hgf);
        this.iva.setOnSeekCompleteListener(this.dcW);
        this.iva.setOnOutInfoListener(this.dcV);
        this.iva.setOnSurfaceDestroyedListener(this.cTC);
        if (cby()) {
            ((QuickVideoView) this.iva).setOnRecoveryCallback(this.ivP);
        }
        this.ivd = (SwitchImageView) this.hfu.findViewById(R.id.img_play_controller);
        this.ivd.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.ivd.setState(0);
        this.ivd.setOnClickListener(this.mOnClickListener);
        this.ive = (TextView) this.hfu.findViewById(R.id.txt_replay);
        this.ive.setOnClickListener(this.mOnClickListener);
        this.ivf = (TextView) this.hfu.findViewById(R.id.txt_playnext);
        this.ivf.setOnClickListener(this.mOnClickListener);
        this.ivg = (TextView) this.hfu.findViewById(R.id.txt_next_video_title);
        this.hfH = (TbImageView) this.hfu.findViewById(R.id.video_thumbnail);
        this.hfH.setDefaultErrorResource(0);
        this.hfH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hfK = (ImageView) this.hfu.findViewById(R.id.img_exit);
        this.hfK.setOnClickListener(this.mOnClickListener);
        this.hfL = (TextView) this.hfu.findViewById(R.id.video_title);
        this.aqi = this.hfu.findViewById(R.id.layout_title);
        this.aqi.setVisibility(8);
        this.fAx = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.ayN = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hfV = this.mAudioManager.getStreamMaxVolume(3);
        this.hga = this.mAudioManager.getStreamVolume(3);
        hgb = 100 / this.hfV;
        this.hfu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.ivs != null) {
                    c.this.ivs.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.BD) {
                        if (c.this.mStatus == 1 && c.this.hfX != 0) {
                            c.this.b(c.this.hfX == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hfX = 0;
                            c.this.hfW = 0;
                        }
                        if (!c.this.iva.isPlaying()) {
                            c.this.ivf.setVisibility(8);
                            c.this.ive.setVisibility(8);
                            c.this.ivg.setVisibility(8);
                        }
                    }
                    c.this.bIy();
                    if (c.this.ivs != null) {
                        c.this.ivs.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.dpP = new com.baidu.tieba.play.o(this.mActivity);
        if (this.ivJ) {
            this.dpP.start();
        }
        this.hfZ = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hgc == null) {
            hgc = new CallStateReceiver();
        }
        hgc.register(this.mActivity);
        cbz();
        MessageManager.getInstance().registerListener(this.hgl);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hgl);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public boolean cby() {
        return this.iuY == 0 && (this.iva instanceof QuickVideoView);
    }

    public void cbz() {
        if (this.ivz) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hfu.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hfu.setSystemUiVisibility(0);
    }

    public void pF(boolean z) {
        this.ivz = z;
        cbz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIy() {
        this.mStatus = 0;
        if (this.hfP != null && this.hfP.getParent() != null && (this.hfP.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hfP.getParent()).removeView(this.hfP);
                this.hfP = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hfQ != null && this.hfQ.getParent() != null && (this.hfQ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hfQ.getParent()).removeView(this.hfQ);
                this.hfQ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bIz() {
        if (this.mStatus == 1) {
            if (this.hfP == null && this.hfu != null && (this.hfu instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hfu, true);
                this.hfP = this.hfu.findViewById(R.id.lay_jindu);
                this.hfR = (TextView) this.hfP.findViewById(R.id.show_time);
                this.hfU = (ImageView) this.hfP.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hfQ == null && this.hfu != null && (this.hfu instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hfu, true);
            this.hfQ = this.hfu.findViewById(R.id.lay_voice);
            this.hfT = (ImageView) this.hfQ.findViewById(R.id.arrow_voice_icon);
            this.hfS = (SeekBar) this.hfQ.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.ivl = onClickListener;
    }

    public void pG(boolean z) {
        this.ivk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.ivs != null) {
                c.this.ivs.onStart();
            }
            if (c.this.BP && c.this.BD) {
                if (c.this.mStatus == 1) {
                    c.this.cbS();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aq(f2);
                    }
                } else {
                    if (c.this.BP) {
                        c.this.bIB();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hfW = c.this.iva.getCurrentPosition();
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
            if (!c.this.ivK) {
                if (c.this.ivt != null && c.this.ivt.bYf()) {
                    return true;
                }
                c.this.bXU();
                c.this.cbU();
                if (c.this.iva.isPlaying()) {
                    c.this.cbP();
                } else {
                    c.this.cbQ();
                }
                if (c.this.ivu != null) {
                    c.this.ivu.kL(c.this.iva.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.ivK) {
                if (c.this.BD) {
                    if (c.this.ivt != null && c.this.ivt.bYg()) {
                        return true;
                    }
                    c.this.cbO();
                    if (c.this.iva.isPlaying()) {
                        c.this.cbP();
                    } else {
                        c.this.cbQ();
                    }
                    if (c.this.ivu != null) {
                        c.this.ivu.kL(c.this.iva.isPlaying());
                    }
                } else {
                    c.this.bXU();
                    c.this.cbU();
                    if (c.this.currentState != 1) {
                        c.this.cbQ();
                        c.this.cbR();
                    } else {
                        c.this.bIP();
                    }
                    if (c.this.ivu != null) {
                        c.this.ivu.kL(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hfu.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hfu.setSystemUiVisibility(4);
        } else {
            this.hfu.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f2) {
        if (!this.BD) {
            this.mStatus = 0;
            return;
        }
        bIz();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hgb == 0) {
            if (f2 > 0.0f && this.hga < this.hfV) {
                this.hga++;
            }
            if (f2 < 0.0f && this.hga > 0) {
                this.hga--;
            }
        }
        if (this.mProgress > 0) {
            this.hfT.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hfT.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hga, 0);
        this.hfS.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hfW -= 1000;
                this.hfX = 1;
            } else {
                this.hfW += 1000;
                this.hfX = 2;
            }
            if (this.hfW < 0) {
                this.hfW = 0;
            } else if (this.hfW > this.iva.getDuration()) {
                this.hfW = this.iva.getDuration();
            }
        }
        bIz();
        String xI = this.hfw.xI(this.hfW);
        if (f2 > 0.0f) {
            this.hfU.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hfU.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(xI)) {
            this.hfR.setText(new StringBuilder().append(xI).append("/").append(this.hfw.xI(this.iva.getDuration())));
        }
        this.hfw.setCurrentDuration(this.hfW, z ? false : true);
        cbS();
        cbH();
    }

    protected View ak(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.cln = str;
        this.cma = str2;
    }

    public void cbA() {
        if (this.iva != null) {
            this.iva.cbA();
        }
    }

    public void setFid(String str) {
        this.ePc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.iva != null && this.hfw != null) {
            this.hfw.showProgress();
            this.mStartPosition = y.ccR().BS(this.cln);
            if (this.ivH) {
                this.iva.setVolume(1.0f, 1.0f);
                this.iva.start();
                this.ivH = false;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.BJ);
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.BJ, 20L);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgg);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ivO);
                if (this.iva.cco()) {
                    this.currentState = 1;
                    if (cby()) {
                        ((QuickVideoView) this.iva).setRecoveryState(1);
                    }
                    cbS();
                }
                this.mStartPosition = y.ccR().BS(this.cln);
                this.hfw.setPlayer(this.iva);
                if (this.mStartPosition != 0) {
                    this.ivB = true;
                }
                if (!this.ivG) {
                    this.hfw.showProgress();
                }
                if (!this.ivk && this.iva.getDuration() <= 0) {
                    bIC().setVisibility(4);
                }
            }
            this.BE = (this.mStartPosition <= 100 || this.iva.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM() {
        if (this.hfH.getVisibility() != 8 || !this.BD) {
            this.BD = true;
            this.hfx.setVisibility(8);
            this.eOI.setVisibility(8);
            this.cTt.ccM();
            this.hfH.setVisibility(8);
            cbT();
            long duration = this.iva.getDuration() / 1000;
            String str = this.cma;
            this.hfw.showProgress();
            this.ivb.setVisibility(0);
            if (this.hfI != null && cby()) {
                this.hfI.onPrepared(((QuickVideoView) this.iva).getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.ivc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivc.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.ivc.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.ivc.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.ivc.setLayoutParams(layoutParams);
        }
    }

    public void bXU() {
        if (this.iva.isPlaying()) {
            pausePlay();
            if (this.ivy != null) {
                this.ivy.onPause();
            }
            if (this.ivp != null) {
                this.ivp.aHw();
            }
        } else if (this.BD) {
            bIK();
            if (this.iee != null) {
                this.iee.bmn();
            }
            if (this.ivp != null) {
                this.ivp.aHy();
            }
        } else {
            cbL();
        }
    }

    public boolean cbB() {
        return this.hgd;
    }

    public void vt() {
        this.hgd = true;
        if (this.dpP != null) {
            this.dpP.vt();
        }
    }

    public boolean cbC() {
        return this.iva != null && this.iva.getView().getHeight() > this.iva.getView().getWidth();
    }

    public void cbD() {
        pH(false);
        cbG();
    }

    public boolean xC(int i2) {
        switch (i2) {
            case 4:
                if (this.BP) {
                    if (cbC()) {
                        pH(false);
                        cbG();
                    } else {
                        vt();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hfV <= 0 || this.hfS == null) {
                    return false;
                }
                this.hga = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hga * 100.0d) / this.hfV);
                this.hfS.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cby()) {
            return (QuickVideoView) this.iva;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cbE() {
        return this.iva;
    }

    public VideoListMediaControllerView bIC() {
        return this.hfw;
    }

    public void show() {
        this.hfu.setVisibility(0);
    }

    public void bIG() {
        if (this.hfF != null) {
            ViewGroup.LayoutParams layoutParams = this.hfF.getLayoutParams();
            this.hfz = (FrameLayout.LayoutParams) this.hfu.getLayoutParams();
            this.hfz.width = layoutParams.width;
            this.hfz.height = layoutParams.height;
            this.hfz.topMargin = 0;
            this.hfu.setLayoutParams(this.hfz);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hgd) {
            if (this.BP) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hgd = false;
        }
        if (configuration.orientation == 2) {
            cbF();
        } else {
            cbG();
        }
        cbH();
        bIK();
        cbU();
        bIP();
        if (this.ivu != null) {
            this.ivu.kL(true);
        }
    }

    protected void cbF() {
        this.BP = true;
        int statusBarHeight = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.getStatusBarHeight(this.mActivity) : 0;
        if (cbC()) {
            this.hfu.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hfu.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - statusBarHeight, this.mScreenWidth));
        }
        h(this.mActivity, true);
        this.aqi.setVisibility(0);
        this.hfK.setVisibility(0);
        this.hfL.setVisibility(0);
        this.hfy.setVisibility(8);
        this.cTt.ccN();
        this.hfH.setVisibility(8);
        this.hfC.setImageResource(R.drawable.icon_video_narrow_white);
        vk(this.hfZ);
        bIB();
        if (this.ivm != null) {
            this.ivm.kv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbG() {
        this.BP = false;
        if (this.hfz != null) {
            this.hfu.setLayoutParams(this.hfz);
        }
        h(this.mActivity, false);
        this.aqi.setVisibility(8);
        this.hfy.setVisibility(0);
        this.cTt.ccN();
        this.hfH.setVisibility(8);
        this.hfC.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hfw != null && (this.hfw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfw.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hfw.setLayoutParams(layoutParams);
        }
        this.hfu.setSystemUiVisibility(0);
        cbz();
        if (this.ivm != null) {
            this.ivm.kw();
        }
    }

    public void cbH() {
        if (this.iva != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.BP) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.ivb.setMax(equipmentWidth);
            int duration = this.iva.getDuration();
            if (duration > 0) {
                if (this.ive.getVisibility() == 0) {
                    this.ivb.setProgress(this.ivb.getMax());
                } else {
                    this.ivb.setProgress((int) ((this.iva.getCurrentPositionSync() * this.ivb.getMax()) / duration));
                }
            }
        }
    }

    private void vk(int i2) {
        if (this.hfw != null && (this.hfw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfw.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hfw.setLayoutParams(layoutParams);
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

    public boolean bII() {
        return !this.BP;
    }

    public void a(g.f fVar) {
        this.hfI = fVar;
    }

    public void a(g.a aVar) {
        this.ivh = aVar;
    }

    public void a(g.b bVar) {
        this.ivi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.ivC) {
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
        cbM();
        this.ivH = true;
        this.currentState = 0;
        if (cby()) {
            ((QuickVideoView) this.iva).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.iva.setVideoPath(str, str2);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgg);
        if (this.ivo > 0) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.hgg, this.ivo);
        }
        if (this.ivp != null) {
            this.ivp.onStarted();
        }
        this.cTt.startLoading();
        pI(z);
    }

    public void cm(String str, String str2) {
        y(str, str2, true);
    }

    public void dF(String str, String str2) {
        cbM();
        this.ivH = true;
        this.currentState = 0;
        if (cby()) {
            ((QuickVideoView) this.iva).setRecoveryState(0);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgg);
        if (this.ivo > 0) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.hgg, this.ivo);
        }
        if (this.ivp != null) {
            this.ivp.onStarted();
        }
        this.cTt.startLoading();
        pI(true);
    }

    public void cbI() {
        bIK();
        this.ivb.setVisibility(0);
    }

    public void bIK() {
        if (this.iva != null && this.hfw != null) {
            this.BD = true;
            this.currentState = 1;
            if (cby()) {
                ((QuickVideoView) this.iva).setRecoveryState(1);
            }
            this.iva.bIK();
            this.mStartPosition = y.ccR().BS(this.cln);
            this.ivB = true;
            this.BE = (this.mStartPosition <= 100 || this.iva.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.cTt.ccN();
            pI(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.ivF && !StringUtils.isNull(this.cln) && !StringUtils.isNull(this.cma)) {
            this.ivF = false;
            this.ivG = true;
            cm(this.cln, this.cma);
        }
    }

    private void pI(boolean z) {
        if (z) {
            this.hfH.setVisibility(0);
            cbS();
            this.ivb.setProgress(0);
        } else {
            this.hfH.setVisibility(8);
            cbS();
        }
        this.hfw.showProgress();
        this.hfx.setVisibility(8);
        this.ivf.setVisibility(8);
        this.ive.setVisibility(8);
        this.ivg.setVisibility(8);
        this.eOI.setVisibility(8);
    }

    private void cbJ() {
        this.cTt.ccN();
        this.ivf.setVisibility(8);
        this.ive.setVisibility(8);
        this.ivg.setVisibility(8);
        cbU();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.iva instanceof QuickVideoView) {
            ((QuickVideoView) this.iva).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.iva.pause();
        this.currentState = 2;
        if (cby()) {
            ((QuickVideoView) this.iva).setRecoveryState(2);
        }
        cbJ();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cby()) {
            ((QuickVideoView) this.iva).setRecoveryState(5);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.BJ);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgg);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ivO);
        this.iva.stopPlayback();
        this.BD = false;
        this.ivH = false;
        this.mStartPosition = 0;
        bvK();
    }

    public void cbK() {
        if (this.iva.getDuration() >= this.iva.getCurrentPosition()) {
            y.ccR().bd(this.cln, this.iva.getCurrentPosition());
        }
    }

    public void pJ(boolean z) {
        this.ivA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(boolean z) {
        if (this.hfD != null) {
            this.hfx.setVisibility(0);
            this.ivf.setVisibility(8);
            this.ive.setVisibility(8);
            this.ivg.setVisibility(8);
            this.cTt.ccN();
            cbS();
            this.ivb.setVisibility(8);
            this.eOI.setVisibility(8);
            this.hfw.aDR();
            this.hfH.setVisibility(z ? 0 : 8);
        }
    }

    public void bvK() {
        pK(true);
    }

    public boolean kx() {
        if (this.iva == null) {
            return false;
        }
        return this.iva.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.iva == null) {
            return 0;
        }
        return this.iva.getCurrentPosition();
    }

    public void a(k kVar) {
        this.ivs = kVar;
    }

    public void a(j jVar) {
        this.ivr = jVar;
    }

    public void a(i iVar) {
        this.iee = iVar;
    }

    public void a(g gVar) {
        this.ivy = gVar;
    }

    public void a(h hVar) {
        this.ivq = hVar;
    }

    public void Bn(String str) {
        this.idE = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbL() {
        a(this.cln, this.cma, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.ivn = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cbM();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.csB().csC()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.ivC = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ivx != null) {
                    this.ivx.kh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.nn(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cbN();
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
                aVar.b(this.ceu).akM();
                return;
            } else if (this.ivx != null) {
                this.ivx.kh(true);
                return;
            } else {
                if (!this.iuZ) {
                    this.iuZ = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.ivw != null) {
            this.ivw.bmk();
        }
    }

    private void cbM() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.csB().ef(this.mActivity);
        }
    }

    public void cbN() {
        com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.hfH.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgk);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.BJ);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgg);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ivN);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ivO);
        this.dpP.stop();
        hgc.unregister(this.mActivity);
    }

    public void BN(String str) {
        this.hfL.setText(str);
    }

    public boolean bIL() {
        return this.BD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbO() {
        if (this.hfD != null) {
            if (this.ivj) {
                cbS();
            } else {
                cbR();
            }
        }
    }

    public void bIP() {
        cbR();
        cbP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgk);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.hgk, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbQ() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgk);
    }

    public void cbR() {
        if (this.hfD != null && !this.ivj && !this.ivL) {
            pL(true);
            bIO();
            this.hfD.setVisibility(0);
            this.ivc.setVisibility(0);
            this.ivb.setVisibility(8);
            this.ivj = true;
            if (this.ivn != null) {
                this.ivn.ki(false);
            }
        }
    }

    public void bIM() {
        if (this.hfD != null && this.ivj) {
            pL(false);
            bIO();
            this.hfD.setVisibility(8);
            this.ivc.setVisibility(8);
            this.ivb.setVisibility(0);
            this.fAx.setAnimationListener(this.hgi);
            this.hfD.startAnimation(this.fAx);
            this.ivj = false;
            if (this.ivn != null) {
                this.ivn.bmm();
            }
        }
    }

    public void cbS() {
        if (this.hfD != null && this.ivj) {
            this.ayN.cancel();
            this.fAx.cancel();
            pL(false);
            bIO();
            this.hfD.setVisibility(8);
            this.ivc.setVisibility(8);
            this.ivb.setVisibility(0);
            this.ivj = false;
            if (this.ivn != null) {
                this.ivn.bmm();
            }
        }
    }

    private void bIO() {
        if (this.hfD != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hgk);
            this.ayN.setAnimationListener(null);
            this.fAx.setAnimationListener(null);
            this.hfD.clearAnimation();
        }
    }

    private void cbT() {
        if (this.hfD != null) {
            this.ayN.setAnimationListener(null);
            this.fAx.setAnimationListener(null);
            this.hfD.clearAnimation();
        }
    }

    public void pL(boolean z) {
        cbU();
        if (z) {
            this.ivd.setVisibility(0);
        } else {
            this.ivd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbU() {
        if (this.currentState == 1) {
            this.ivd.setState(1);
        } else {
            this.ivd.setState(0);
        }
    }

    public void a(InterfaceC0497c interfaceC0497c) {
        this.ivm = interfaceC0497c;
    }

    public void vn(int i2) {
        this.mStartPosition = i2;
    }

    public void ag(boolean z, boolean z2) {
        if (this.dpP != null) {
            if (this.hfC != null) {
                this.hfC.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hfw != null && (this.hfw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfw.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hfw.setLayoutParams(layoutParams);
            }
            this.dpP.aK(z);
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
        this.ivK = z;
    }

    public void a(m mVar) {
        this.ivt = mVar;
    }

    public void a(a aVar) {
        this.ivu = aVar;
    }

    public void a(n nVar) {
        this.ivv = nVar;
    }

    public void a(l lVar) {
        this.ivw = lVar;
    }

    public void a(f fVar) {
        this.ivx = fVar;
    }

    public void pN(boolean z) {
        this.ivE = z;
    }

    public void pO(boolean z) {
        this.ivk = z;
        if (z) {
            this.iva.setPageTypeForPerfStat("middle");
        } else {
            this.iva.setPageTypeForPerfStat("pb");
        }
    }

    public void xD(int i2) {
        this.ivI = i2;
    }

    public View cbV() {
        return this.hfu;
    }

    public void a(o oVar) {
        this.ivp = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.iva != null) {
            this.iva.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.idS = pVar;
    }

    public void cbW() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ceu.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.ceu.getPageActivity());
    }
}
