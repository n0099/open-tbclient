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
    private static int hZG;
    private static CallStateReceiver hZH;
    private boolean EI;
    private int EJ;
    private Runnable EO;
    protected boolean EV;
    private TbImageView OY;
    private String Pj;
    private View aCX;
    private Animation aLw;
    private TbPageContext<?> cVg;
    private int currentState;
    private w dMa;
    private QuickVideoView.b dMj;
    private g.a dVb;
    private g.f dVc;
    private g.e dVe;
    private g.InterfaceC0590g dVf;
    private SeekBar.OnSeekBarChangeListener dZY;
    private com.baidu.tieba.play.o eej;
    private String ema;
    private VideoLoadingProgressView.a fJz;
    protected View fMd;
    private Animation gud;
    private int hZA;
    private int hZB;
    private int hZC;
    private int hZE;
    private int hZF;
    private boolean hZI;
    private g.b hZK;
    protected Runnable hZL;
    private Animation.AnimationListener hZN;
    private Animation.AnimationListener hZO;
    private Runnable hZP;
    private CustomMessageListener hZQ;
    public View hZa;
    private VideoListMediaControllerView hZc;
    private View hZd;
    private FrameLayout hZe;
    protected FrameLayout.LayoutParams hZf;
    private ImageView hZi;
    private View hZj;
    private View hZl;
    private g.f hZn;
    private ImageView hZp;
    private TextView hZq;
    private View hZu;
    private View hZv;
    private TextView hZw;
    private SeekBar hZx;
    private ImageView hZy;
    private ImageView hZz;
    private p iXM;
    private i iXY;
    private String iXy;
    private VideoControllerView.b ibK;
    private g.a jtA;
    private g.b jtB;
    private boolean jtC;
    private boolean jtD;
    private View.OnClickListener jtE;
    protected InterfaceC0589c jtF;
    private d jtG;
    private long jtH;
    private o jtI;
    private h jtJ;
    private j jtK;
    private k jtL;
    private m jtM;
    private a jtN;
    private n jtO;
    private l jtP;
    private f jtQ;
    private g jtR;
    private boolean jtS;
    private boolean jtT;
    private boolean jtU;
    private boolean jtV;
    private TextView jtW;
    private boolean jtX;
    private boolean jtY;
    private boolean jtZ;
    private boolean jtr;
    protected com.baidu.tieba.play.a.a jts;
    private ProgressBar jtt;
    private View jtu;
    private SwitchImageView jtv;
    private TextView jtw;
    private TextView jtx;
    private TextView jty;
    private int jtz;
    private boolean jua;
    private int jub;
    private boolean juc;
    private boolean jud;
    private boolean jue;
    private boolean juf;
    private Runnable jug;
    private Runnable juh;
    private QuickVideoView.a jui;
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
        void bGn();

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
        void css();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bGo();
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
        void bGl();

        void bGm();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cst();

        boolean csu();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Ao(int i);

        void cys();

        void cyt();

        void onPaused();

        void onPrepared();

        void onStarted();

        void tW();
    }

    /* loaded from: classes.dex */
    public interface p {
        void csr();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jtr = false;
        this.EV = false;
        this.EI = false;
        this.jtC = false;
        this.jtD = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hZB = 0;
        this.hZC = 0;
        this.jtH = 60000L;
        this.hZE = 0;
        this.hZI = false;
        this.jtS = true;
        this.jtT = true;
        this.jtU = false;
        this.jtV = false;
        this.iXy = null;
        this.currentState = -1;
        this.jtX = false;
        this.juc = true;
        this.jue = false;
        this.juf = false;
        this.dVc = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hZc != null && c.this.jts != null && c.this.jts.getDuration() > 0) {
                    c.this.hZc.aZ(0, c.this.jts.getDuration());
                }
                c.this.buL();
                if (c.this.jtI != null) {
                    c.this.jtI.onPrepared();
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buL();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OY.getVisibility() != 8) {
                    if (c.this.jts.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jts != null) {
                    int duration = c.this.jts.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.jua = false;
                        c.this.mStartPosition = 0;
                        c.this.ccw();
                        c.this.hZd.setVisibility(0);
                        c.this.jtt.setProgress(c.this.jtt.getMax());
                        c.this.EJ = 100;
                        if (c.this.jtA != null) {
                            c.this.jtA.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cxU()) {
                            ((QuickVideoView) c.this.jts).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rI(false);
                            c.this.rJ(true);
                        } else {
                            c.this.cym();
                            c.this.jtw.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jtX) {
                                if (c.this.jtK != null) {
                                    c.this.jtK.qP(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pj, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cxU()) {
                                    ((QuickVideoView) c.this.jts).setRecoveryState(5);
                                }
                                c.this.jts.pause();
                                c.this.jts.seekTo(0);
                            }
                        }
                        if (c.this.jtI != null) {
                            c.this.jtI.Ao(c.this.jtt.getMax());
                            c.this.jtI.tW();
                        }
                    }
                }
            }
        };
        this.hZK = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.fMd.setVisibility(0);
                c.this.dMa.czn();
                c.this.currentState = 4;
                if (c.this.cxU()) {
                    ((QuickVideoView) c.this.jts).setRecoveryState(4);
                }
                if (c.this.jtB != null) {
                    c.this.jtB.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jtY = true;
                }
                if (c.this.jtI != null) {
                    c.this.jtI.cys();
                }
                c.this.jua = false;
                return true;
            }
        };
        this.hZL = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jts == null || !c.this.jts.isPlaying()) {
                    c.this.fMd.setVisibility(0);
                    c.this.dMa.czn();
                    if (c.this.jtI != null) {
                        c.this.jtI.cys();
                    }
                }
            }
        };
        this.dVf = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jtU) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jug, 200L);
                }
            }
        };
        this.jug = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jts == null || !c.this.jtU) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jtU = false;
                } else if (c.this.mStartPosition != c.this.jts.getCurrentPosition()) {
                    c.this.jtU = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jug, 200L);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jtD) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juh, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZL);
            }
        };
        this.juh = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jua = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iXM != null) {
                    c.this.iXM.csr();
                }
                if (view2.getId() != c.this.fMd.getId()) {
                    if (view2.getId() != c.this.jtv.getId()) {
                        if (view2.getId() == c.this.jtx.getId()) {
                            if (c.this.jtJ != null) {
                                c.this.jtJ.css();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jtw.getId()) {
                            if (c.this.jtK != null) {
                                c.this.jtK.qP(false);
                            }
                            c.this.ei(c.this.mVideoUrl, c.this.Pj);
                            return;
                        } else if (view2.getId() == c.this.hZi.getId()) {
                            int i2 = c.this.jtD ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.ema).X("obj_type", i2).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.ema).X("obj_type", i2).X("obj_source", 1));
                            }
                            if (c.this.jtP != null) {
                                c.this.jtP.bGm();
                            }
                            if (c.this.cxW()) {
                                if (c.this.EV) {
                                    c.this.cya();
                                } else {
                                    c.this.cxZ();
                                }
                                c.this.rF(c.this.EV);
                                return;
                            }
                            c.this.zY();
                            return;
                        } else if (view2.getId() != c.this.hZp.getId()) {
                            if (c.this.jtE != null) {
                                c.this.jtE.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jtP != null) {
                                c.this.jtP.bGm();
                            }
                            if (c.this.cxW()) {
                                c.this.cya();
                                c.this.rF(false);
                                return;
                            }
                            c.this.zY();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csk();
                    c.this.cyo();
                    if (c.this.currentState != 1) {
                        c.this.cyk();
                        c.this.cyl();
                    } else {
                        c.this.ccM();
                    }
                    if (c.this.jtN != null) {
                        c.this.jtN.ml(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jts.stopPlayback();
                c.this.EI = false;
                c.this.cyf();
            }
        };
        this.hZN = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hZO = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hZP = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.ccJ();
            }
        };
        this.hZQ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.ibK = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i2) {
                int duration;
                if (c.this.jts != null && (duration = c.this.jts.getDuration()) > 0 && c.this.jtt != null) {
                    c.this.jtt.setProgress((int) ((i2 * c.this.hZa.getWidth()) / duration));
                    if (c.this.jtI != null) {
                        c.this.jtI.Ao((c.this.jts.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dZY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cyk();
                c.this.rJ(false);
                if (c.this.jtN != null) {
                    c.this.jtN.ml(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccA() != null) {
                    c.this.xA(c.this.ccA().getSeekPosition());
                    if (!c.this.ccI()) {
                        c.this.cyf();
                    } else {
                        c.this.ajY();
                        if (c.this.iXY != null) {
                            c.this.iXY.bGo();
                        }
                    }
                }
                c.this.rJ(true);
                c.this.cyj();
                if (c.this.jtN != null) {
                    c.this.jtN.ml(true);
                }
                if (c.this.jtO != null) {
                    c.this.jtO.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jui = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyr() {
                if (!c.this.jtX) {
                    c.this.dMa.startLoading();
                    c.this.OY.setVisibility(0);
                    c.this.jtv.setVisibility(8);
                    c.this.jtx.setVisibility(8);
                    c.this.jtw.setVisibility(8);
                    c.this.jty.setVisibility(8);
                    c.this.fMd.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZL);
                    if (c.this.jtH > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hZL, c.this.jtH);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVg = tbPageContext;
            this.mRootView = view;
            this.juc = z;
            this.hZl = view;
            this.mActivity = this.cVg.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jtr = false;
        this.EV = false;
        this.EI = false;
        this.jtC = false;
        this.jtD = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hZB = 0;
        this.hZC = 0;
        this.jtH = 60000L;
        this.hZE = 0;
        this.hZI = false;
        this.jtS = true;
        this.jtT = true;
        this.jtU = false;
        this.jtV = false;
        this.iXy = null;
        this.currentState = -1;
        this.jtX = false;
        this.juc = true;
        this.jue = false;
        this.juf = false;
        this.dVc = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hZc != null && c.this.jts != null && c.this.jts.getDuration() > 0) {
                    c.this.hZc.aZ(0, c.this.jts.getDuration());
                }
                c.this.buL();
                if (c.this.jtI != null) {
                    c.this.jtI.onPrepared();
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buL();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OY.getVisibility() != 8) {
                    if (c.this.jts.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jts != null) {
                    int duration = c.this.jts.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.jua = false;
                        c.this.mStartPosition = 0;
                        c.this.ccw();
                        c.this.hZd.setVisibility(0);
                        c.this.jtt.setProgress(c.this.jtt.getMax());
                        c.this.EJ = 100;
                        if (c.this.jtA != null) {
                            c.this.jtA.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cxU()) {
                            ((QuickVideoView) c.this.jts).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rI(false);
                            c.this.rJ(true);
                        } else {
                            c.this.cym();
                            c.this.jtw.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jtX) {
                                if (c.this.jtK != null) {
                                    c.this.jtK.qP(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pj, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cxU()) {
                                    ((QuickVideoView) c.this.jts).setRecoveryState(5);
                                }
                                c.this.jts.pause();
                                c.this.jts.seekTo(0);
                            }
                        }
                        if (c.this.jtI != null) {
                            c.this.jtI.Ao(c.this.jtt.getMax());
                            c.this.jtI.tW();
                        }
                    }
                }
            }
        };
        this.hZK = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.fMd.setVisibility(0);
                c.this.dMa.czn();
                c.this.currentState = 4;
                if (c.this.cxU()) {
                    ((QuickVideoView) c.this.jts).setRecoveryState(4);
                }
                if (c.this.jtB != null) {
                    c.this.jtB.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jtY = true;
                }
                if (c.this.jtI != null) {
                    c.this.jtI.cys();
                }
                c.this.jua = false;
                return true;
            }
        };
        this.hZL = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jts == null || !c.this.jts.isPlaying()) {
                    c.this.fMd.setVisibility(0);
                    c.this.dMa.czn();
                    if (c.this.jtI != null) {
                        c.this.jtI.cys();
                    }
                }
            }
        };
        this.dVf = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jtU) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jug, 200L);
                }
            }
        };
        this.jug = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jts == null || !c.this.jtU) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jtU = false;
                } else if (c.this.mStartPosition != c.this.jts.getCurrentPosition()) {
                    c.this.jtU = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jug, 200L);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jtD) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.juh, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZL);
            }
        };
        this.juh = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jua = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iXM != null) {
                    c.this.iXM.csr();
                }
                if (view2.getId() != c.this.fMd.getId()) {
                    if (view2.getId() != c.this.jtv.getId()) {
                        if (view2.getId() == c.this.jtx.getId()) {
                            if (c.this.jtJ != null) {
                                c.this.jtJ.css();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jtw.getId()) {
                            if (c.this.jtK != null) {
                                c.this.jtK.qP(false);
                            }
                            c.this.ei(c.this.mVideoUrl, c.this.Pj);
                            return;
                        } else if (view2.getId() == c.this.hZi.getId()) {
                            int i22 = c.this.jtD ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.ema).X("obj_type", i22).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cy("tid", c.this.Pj).cy("fid", c.this.ema).X("obj_type", i22).X("obj_source", 1));
                            }
                            if (c.this.jtP != null) {
                                c.this.jtP.bGm();
                            }
                            if (c.this.cxW()) {
                                if (c.this.EV) {
                                    c.this.cya();
                                } else {
                                    c.this.cxZ();
                                }
                                c.this.rF(c.this.EV);
                                return;
                            }
                            c.this.zY();
                            return;
                        } else if (view2.getId() != c.this.hZp.getId()) {
                            if (c.this.jtE != null) {
                                c.this.jtE.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jtP != null) {
                                c.this.jtP.bGm();
                            }
                            if (c.this.cxW()) {
                                c.this.cya();
                                c.this.rF(false);
                                return;
                            }
                            c.this.zY();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csk();
                    c.this.cyo();
                    if (c.this.currentState != 1) {
                        c.this.cyk();
                        c.this.cyl();
                    } else {
                        c.this.ccM();
                    }
                    if (c.this.jtN != null) {
                        c.this.jtN.ml(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jts.stopPlayback();
                c.this.EI = false;
                c.this.cyf();
            }
        };
        this.hZN = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hZO = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hZP = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.ccJ();
            }
        };
        this.hZQ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.ibK = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i22) {
                int duration;
                if (c.this.jts != null && (duration = c.this.jts.getDuration()) > 0 && c.this.jtt != null) {
                    c.this.jtt.setProgress((int) ((i22 * c.this.hZa.getWidth()) / duration));
                    if (c.this.jtI != null) {
                        c.this.jtI.Ao((c.this.jts.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dZY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cyk();
                c.this.rJ(false);
                if (c.this.jtN != null) {
                    c.this.jtN.ml(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccA() != null) {
                    c.this.xA(c.this.ccA().getSeekPosition());
                    if (!c.this.ccI()) {
                        c.this.cyf();
                    } else {
                        c.this.ajY();
                        if (c.this.iXY != null) {
                            c.this.iXY.bGo();
                        }
                    }
                }
                c.this.rJ(true);
                c.this.cyj();
                if (c.this.jtN != null) {
                    c.this.jtN.ml(true);
                }
                if (c.this.jtO != null) {
                    c.this.jtO.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jui = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyr() {
                if (!c.this.jtX) {
                    c.this.dMa.startLoading();
                    c.this.OY.setVisibility(0);
                    c.this.jtv.setVisibility(8);
                    c.this.jtx.setVisibility(8);
                    c.this.jtw.setVisibility(8);
                    c.this.jty.setVisibility(8);
                    c.this.fMd.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.hZL);
                    if (c.this.jtH > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.hZL, c.this.jtH);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVg = tbPageContext;
            this.mRootView = view;
            this.juc = z;
            this.hZl = view;
            this.mActivity = this.cVg.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.hZa = ar(this.mActivity);
        this.hZa.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hZa);
        }
        this.jts = com.baidu.tieba.play.a.b.F(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hZa).addView(this.jts.getView(), 0);
        this.jts.getView().setLayoutParams(layoutParams);
        this.dMa = new w((ViewGroup) this.hZa.findViewById(R.id.auto_video_loading_container));
        this.dMa.setLoadingAnimationListener(this.fJz);
        this.hZc = (VideoListMediaControllerView) this.hZa.findViewById(R.id.media_controller);
        this.hZc.setPlayer(this.jts);
        this.jtt = (ProgressBar) this.hZa.findViewById(R.id.pgrBottomProgress);
        this.jtt.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.jtt.setProgress(0);
        this.hZc.setOnSeekBarChangeListener(this.dZY);
        this.hZc.setOnProgressUpdatedListener(this.ibK);
        this.hZd = this.hZa.findViewById(R.id.black_mask);
        this.fMd = this.hZa.findViewById(R.id.layout_error);
        this.fMd.setOnClickListener(this.mOnClickListener);
        this.jtW = (TextView) this.hZa.findViewById(R.id.auto_video_error_tips);
        this.hZe = (FrameLayout) this.hZa.findViewById(R.id.danmu_container);
        this.hZi = (ImageView) this.hZa.findViewById(R.id.img_full_screen);
        this.hZi.setOnClickListener(this.mOnClickListener);
        this.hZj = this.hZa.findViewById(R.id.layout_media_controller);
        this.jtu = this.hZa.findViewById(R.id.time_show_controller);
        this.jts.setContinuePlayEnable(true);
        this.jts.setOnPreparedListener(this.dVc);
        this.jts.setOnCompletionListener(this.dVb);
        this.jts.setOnErrorListener(this.hZK);
        this.jts.setOnSeekCompleteListener(this.dVf);
        this.jts.setOnOutInfoListener(this.dVe);
        this.jts.setOnSurfaceDestroyedListener(this.dMj);
        if (cxU()) {
            ((QuickVideoView) this.jts).setOnRecoveryCallback(this.jui);
        }
        this.jtv = (SwitchImageView) this.hZa.findViewById(R.id.img_play_controller);
        this.jtv.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.jtv.setState(0);
        this.jtv.setOnClickListener(this.mOnClickListener);
        this.jtw = (TextView) this.hZa.findViewById(R.id.txt_replay);
        this.jtw.setOnClickListener(this.mOnClickListener);
        this.jtx = (TextView) this.hZa.findViewById(R.id.txt_playnext);
        this.jtx.setOnClickListener(this.mOnClickListener);
        this.jty = (TextView) this.hZa.findViewById(R.id.txt_next_video_title);
        this.OY = (TbImageView) this.hZa.findViewById(R.id.video_thumbnail);
        this.OY.setDefaultErrorResource(0);
        this.OY.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hZp = (ImageView) this.hZa.findViewById(R.id.img_exit);
        this.hZp.setOnClickListener(this.mOnClickListener);
        this.hZq = (TextView) this.hZa.findViewById(R.id.video_title);
        this.aCX = this.hZa.findViewById(R.id.layout_title);
        this.aCX.setVisibility(8);
        this.gud = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aLw = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hZA = this.mAudioManager.getStreamMaxVolume(3);
        this.hZF = this.mAudioManager.getStreamVolume(3);
        hZG = 100 / this.hZA;
        this.hZa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.jtL != null) {
                    c.this.jtL.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.EI) {
                        if (c.this.mStatus == 1 && c.this.hZC != 0) {
                            c.this.b(c.this.hZC == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hZC = 0;
                            c.this.hZB = 0;
                        }
                        if (!c.this.jts.isPlaying()) {
                            c.this.jtx.setVisibility(8);
                            c.this.jtw.setVisibility(8);
                            c.this.jty.setVisibility(8);
                        }
                    }
                    c.this.ccw();
                    if (c.this.jtL != null) {
                        c.this.jtL.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eej = new com.baidu.tieba.play.o(this.mActivity);
        if (this.juc) {
            this.eej.start();
        }
        this.hZE = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hZH == null) {
            hZH = new CallStateReceiver();
        }
        hZH.register(this.mActivity);
        cxV();
        MessageManager.getInstance().registerListener(this.hZQ);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hZQ);
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

    public boolean cxU() {
        return this.mVideoType == 0 && (this.jts instanceof QuickVideoView);
    }

    public void cxV() {
        if (this.jtS) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hZa.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hZa.setSystemUiVisibility(0);
    }

    public void rD(boolean z) {
        this.jtS = z;
        cxV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccw() {
        this.mStatus = 0;
        if (this.hZu != null && this.hZu.getParent() != null && (this.hZu.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hZu.getParent()).removeView(this.hZu);
                this.hZu = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hZv != null && this.hZv.getParent() != null && (this.hZv.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hZv.getParent()).removeView(this.hZv);
                this.hZv = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ccx() {
        if (this.mStatus == 1) {
            if (this.hZu == null && this.hZa != null && (this.hZa instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hZa, true);
                this.hZu = this.hZa.findViewById(R.id.lay_jindu);
                this.hZw = (TextView) this.hZu.findViewById(R.id.show_time);
                this.hZz = (ImageView) this.hZu.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hZv == null && this.hZa != null && (this.hZa instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hZa, true);
            this.hZv = this.hZa.findViewById(R.id.lay_voice);
            this.hZy = (ImageView) this.hZv.findViewById(R.id.arrow_voice_icon);
            this.hZx = (SeekBar) this.hZv.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jtE = onClickListener;
    }

    public void rE(boolean z) {
        this.jtD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.jtL != null) {
                c.this.jtL.onStart();
            }
            if (c.this.EV && c.this.EI) {
                if (c.this.mStatus == 1) {
                    c.this.cym();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aC(f2);
                    }
                } else {
                    if (c.this.EV) {
                        c.this.ccz();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hZB = c.this.jts.getCurrentPosition();
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
            if (!c.this.jud) {
                if (c.this.jtM != null && c.this.jtM.cst()) {
                    return true;
                }
                c.this.csk();
                c.this.cyo();
                if (c.this.jts.isPlaying()) {
                    c.this.cyj();
                } else {
                    c.this.cyk();
                }
                if (c.this.jtN != null) {
                    c.this.jtN.ml(c.this.jts.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.jud) {
                if (c.this.EI) {
                    if (c.this.jtM != null && c.this.jtM.csu()) {
                        return true;
                    }
                    c.this.cyi();
                    if (c.this.jts.isPlaying()) {
                        c.this.cyj();
                    } else {
                        c.this.cyk();
                    }
                    if (c.this.jtN != null) {
                        c.this.jtN.ml(c.this.jts.isPlaying());
                    }
                } else {
                    c.this.csk();
                    c.this.cyo();
                    if (c.this.currentState != 1) {
                        c.this.cyk();
                        c.this.cyl();
                    } else {
                        c.this.ccM();
                    }
                    if (c.this.jtN != null) {
                        c.this.jtN.ml(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccz() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZa.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZa.setSystemUiVisibility(4);
        } else {
            this.hZa.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(float f2) {
        if (!this.EI) {
            this.mStatus = 0;
            return;
        }
        ccx();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hZG == 0) {
            if (f2 > 0.0f && this.hZF < this.hZA) {
                this.hZF++;
            }
            if (f2 < 0.0f && this.hZF > 0) {
                this.hZF--;
            }
        }
        if (this.mProgress > 0) {
            this.hZy.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hZy.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hZF, 0);
        this.hZx.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hZB -= 1000;
                this.hZC = 1;
            } else {
                this.hZB += 1000;
                this.hZC = 2;
            }
            if (this.hZB < 0) {
                this.hZB = 0;
            } else if (this.hZB > this.jts.getDuration()) {
                this.hZB = this.jts.getDuration();
            }
        }
        ccx();
        String Au = this.hZc.Au(this.hZB);
        if (f2 > 0.0f) {
            this.hZz.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hZz.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Au)) {
            this.hZw.setText(new StringBuilder().append(Au).append("/").append(this.hZc.Au(this.jts.getDuration())));
        }
        this.hZc.setCurrentDuration(this.hZB, z ? false : true);
        cym();
        cyb();
    }

    protected View ar(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Al(int i2) {
        this.jtz = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pj = str2;
    }

    public void setFid(String str) {
        this.ema = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        if (this.jts != null && this.hZc != null) {
            this.hZc.showProgress();
            this.mStartPosition = x.czq().Hd(this.mVideoUrl);
            if (this.jua) {
                this.jts.setVolume(1.0f, 1.0f);
                this.jts.start();
                this.jua = false;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.EO, 20L);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZL);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juh);
                if (this.jts.cyM()) {
                    this.currentState = 1;
                    if (cxU()) {
                        ((QuickVideoView) this.jts).setRecoveryState(1);
                    }
                    cym();
                }
                this.mStartPosition = x.czq().Hd(this.mVideoUrl);
                this.hZc.setPlayer(this.jts);
                if (this.mStartPosition != 0) {
                    this.jtU = true;
                }
                if (!this.jtZ) {
                    this.hZc.showProgress();
                }
                if (!this.jtD && this.jts.getDuration() <= 0) {
                    ccA().setVisibility(4);
                }
            }
            this.EJ = (this.mStartPosition <= 100 || this.jts.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (this.OY.getVisibility() != 8 || !this.EI) {
            this.EI = true;
            this.hZd.setVisibility(8);
            this.fMd.setVisibility(8);
            this.dMa.czm();
            this.OY.setVisibility(8);
            cyn();
            long duration = this.jts.getDuration() / 1000;
            String str = this.Pj;
            this.hZc.showProgress();
            this.jtt.setVisibility(0);
            if (this.hZn != null && cxU()) {
                this.hZn.onPrepared(((QuickVideoView) this.jts).getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.jtu.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jtu.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.jtu.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.jtu.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.jtu.setLayoutParams(layoutParams);
        }
    }

    public void csk() {
        if (this.jts.isPlaying()) {
            pausePlay();
            if (this.jtR != null) {
                this.jtR.onPause();
            }
            if (this.jtI != null) {
                this.jtI.onPaused();
            }
        } else if (this.EI) {
            ajY();
            if (this.iXY != null) {
                this.iXY.bGo();
            }
            if (this.jtI != null) {
                this.jtI.cyt();
            }
        } else {
            cyf();
        }
    }

    public void zY() {
        this.hZI = true;
        if (this.eej != null) {
            this.eej.zY();
        }
    }

    public boolean cxW() {
        return this.jts != null && this.jts.getView().getHeight() > this.jts.getView().getWidth();
    }

    public void cxX() {
        rF(false);
        cya();
    }

    public boolean Am(int i2) {
        switch (i2) {
            case 4:
                if (this.EV) {
                    if (cxW()) {
                        rF(false);
                        cya();
                    } else {
                        zY();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hZA <= 0 || this.hZx == null) {
                    return false;
                }
                this.hZF = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hZF * 100.0d) / this.hZA);
                this.hZx.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cxU()) {
            return (QuickVideoView) this.jts;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cxY() {
        return this.jts;
    }

    public VideoListMediaControllerView ccA() {
        return this.hZc;
    }

    public void show() {
        this.hZa.setVisibility(0);
    }

    public void ccE() {
        if (this.hZl != null) {
            ViewGroup.LayoutParams layoutParams = this.hZl.getLayoutParams();
            this.hZf = (FrameLayout.LayoutParams) this.hZa.getLayoutParams();
            this.hZf.width = layoutParams.width;
            this.hZf.height = layoutParams.height;
            this.hZf.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.hZa.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.hZa.setLayoutParams(this.hZf);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hZI) {
            if (this.EV) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hZI = false;
        }
        if (configuration.orientation == 2) {
            cxZ();
        } else {
            cya();
        }
        cyb();
        if (this.mActivity == com.baidu.adp.base.a.eH().currentActivity()) {
            ajY();
        }
        cyo();
        ccM();
        if (this.jtN != null) {
            this.jtN.ml(true);
        }
    }

    protected void cxZ() {
        this.EV = true;
        if (cxW()) {
            this.hZa.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hZa.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.aCX.setVisibility(0);
        this.hZp.setVisibility(0);
        this.hZq.setVisibility(0);
        this.hZe.setVisibility(8);
        this.dMa.czn();
        this.OY.setVisibility(8);
        this.hZi.setImageResource(R.drawable.icon_video_narrow_white);
        xx(this.hZE);
        ccz();
        if (this.jtF != null) {
            this.jtF.lc();
        }
    }

    protected void cya() {
        this.EV = false;
        if (this.hZf != null) {
            this.hZa.setLayoutParams(this.hZf);
        }
        g(this.mActivity, false);
        this.aCX.setVisibility(8);
        this.hZe.setVisibility(0);
        this.dMa.czn();
        this.OY.setVisibility(8);
        this.hZi.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hZc != null && (this.hZc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZc.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hZc.setLayoutParams(layoutParams);
        }
        this.hZa.setSystemUiVisibility(0);
        cxV();
        if (this.jtF != null) {
            this.jtF.ld();
        }
    }

    public void cyb() {
        if (this.jts != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.EV) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.jtt.setMax(equipmentWidth);
            int duration = this.jts.getDuration();
            if (duration > 0) {
                if (this.jtw.getVisibility() == 0) {
                    this.jtt.setProgress(this.jtt.getMax());
                } else {
                    this.jtt.setProgress((int) ((this.jts.getCurrentPositionSync() * this.jtt.getMax()) / duration));
                }
            }
        }
    }

    private void xx(int i2) {
        if (this.hZc != null && (this.hZc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZc.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hZc.setLayoutParams(layoutParams);
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

    public boolean ccG() {
        return !this.EV;
    }

    public void a(g.f fVar) {
        this.hZn = fVar;
    }

    public void a(g.a aVar) {
        this.jtA = aVar;
    }

    public void a(g.b bVar) {
        this.jtB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.jtV) {
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
        cyg();
        this.jua = true;
        this.currentState = 0;
        if (cxU()) {
            ((QuickVideoView) this.jts).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.jts.setVideoDuration(this.jtz);
        this.jts.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZL);
        if (this.jtH > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hZL, this.jtH);
        }
        if (this.jtI != null) {
            this.jtI.onStarted();
        }
        this.dMa.startLoading();
        rG(z);
    }

    public void ei(String str, String str2) {
        z(str, str2, true);
    }

    public void ej(String str, String str2) {
        cyg();
        this.jua = true;
        this.currentState = 0;
        if (cxU()) {
            ((QuickVideoView) this.jts).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZL);
        if (this.jtH > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hZL, this.jtH);
        }
        if (this.jtI != null) {
            this.jtI.onStarted();
        }
        this.dMa.startLoading();
        rG(true);
    }

    public void cyc() {
        ajY();
        this.jtt.setVisibility(0);
    }

    public void ajY() {
        if (this.jts != null && this.hZc != null) {
            this.EI = true;
            this.currentState = 1;
            if (cxU()) {
                ((QuickVideoView) this.jts).setRecoveryState(1);
            }
            this.jts.a(null);
            this.mStartPosition = x.czq().Hd(this.mVideoUrl);
            this.jtU = true;
            this.EJ = (this.mStartPosition <= 100 || this.jts.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.dMa.czn();
            rG(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.jtY && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pj)) {
            this.jtY = false;
            this.jtZ = true;
            ei(this.mVideoUrl, this.Pj);
        }
    }

    private void rG(boolean z) {
        if (z) {
            this.OY.setVisibility(0);
            cym();
            this.jtt.setProgress(0);
        } else {
            this.OY.setVisibility(8);
            cym();
        }
        this.hZc.showProgress();
        this.hZd.setVisibility(8);
        this.jtx.setVisibility(8);
        this.jtw.setVisibility(8);
        this.jty.setVisibility(8);
        this.fMd.setVisibility(8);
    }

    private void cyd() {
        this.dMa.czn();
        this.jtx.setVisibility(8);
        this.jtw.setVisibility(8);
        this.jty.setVisibility(8);
        cyo();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.jts instanceof QuickVideoView) {
            ((QuickVideoView) this.jts).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.jts.pause();
        this.currentState = 2;
        if (cxU()) {
            ((QuickVideoView) this.jts).setRecoveryState(2);
        }
        cyd();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cxU()) {
            ((QuickVideoView) this.jts).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZL);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juh);
        this.jts.stopPlayback();
        this.EI = false;
        this.jua = false;
        this.mStartPosition = 0;
        bPM();
    }

    public void cye() {
        if (this.jts.getDuration() >= this.jts.getCurrentPosition()) {
            x.czq().bl(this.mVideoUrl, this.jts.getCurrentPosition());
        }
    }

    public void rH(boolean z) {
        this.jtT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(boolean z) {
        if (this.hZj != null) {
            this.hZd.setVisibility(0);
            this.jtx.setVisibility(8);
            this.jtw.setVisibility(8);
            this.jty.setVisibility(8);
            this.dMa.czn();
            cym();
            this.jtt.setVisibility(8);
            this.fMd.setVisibility(8);
            this.hZc.akh();
            this.OY.setVisibility(z ? 0 : 8);
        }
    }

    public void bPM() {
        rI(true);
    }

    public boolean le() {
        if (this.jts == null) {
            return false;
        }
        return this.jts.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.jts == null) {
            return 0;
        }
        return this.jts.getCurrentPosition();
    }

    public void a(k kVar) {
        this.jtL = kVar;
    }

    public void a(j jVar) {
        this.jtK = jVar;
    }

    public void a(i iVar) {
        this.iXY = iVar;
    }

    public void a(g gVar) {
        this.jtR = gVar;
    }

    public void a(h hVar) {
        this.jtJ = hVar;
    }

    public void Gw(String str) {
        this.iXy = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyf() {
        a(this.mVideoUrl, this.Pj, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.jtG = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cyg();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPf().cPg()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.jtV = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.jtQ != null) {
                    this.jtQ.lH(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.sS(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cyh();
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
                aVar.b(this.cVg).aEA();
                return;
            } else if (this.jtQ != null) {
                this.jtQ.lH(true);
                return;
            } else {
                if (!this.jtr) {
                    this.jtr = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.jtP != null) {
            this.jtP.bGl();
        }
    }

    private void cyg() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPf().fy(this.mActivity);
        }
    }

    public void cyh() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.OY.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZP);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZL);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jug);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juh);
        this.eej.stop();
        hZH.unregister(this.mActivity);
    }

    public void GX(String str) {
        this.hZq.setText(str);
    }

    public boolean ccI() {
        return this.EI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        if (this.hZj != null) {
            if (this.jtC) {
                cym();
            } else {
                cyl();
            }
        }
    }

    public void ccM() {
        cyl();
        cyj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyj() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZP);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.hZP, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyk() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZP);
    }

    public void cyl() {
        if (this.hZj != null && !this.jtC && !this.jue) {
            rJ(true);
            ccL();
            this.hZj.setVisibility(0);
            this.jtu.setVisibility(0);
            this.jtt.setVisibility(8);
            this.jtC = true;
            if (this.jtG != null) {
                this.jtG.lI(false);
            }
        }
    }

    public void ccJ() {
        if (this.hZj != null && this.jtC) {
            rJ(false);
            ccL();
            this.hZj.setVisibility(8);
            this.jtu.setVisibility(8);
            this.jtt.setVisibility(0);
            this.gud.setAnimationListener(this.hZN);
            this.hZj.startAnimation(this.gud);
            this.jtC = false;
            if (this.jtG != null) {
                this.jtG.bGn();
            }
        }
    }

    public void cym() {
        if (this.hZj != null && this.jtC) {
            this.aLw.cancel();
            this.gud.cancel();
            rJ(false);
            ccL();
            this.hZj.setVisibility(8);
            this.jtu.setVisibility(8);
            this.jtt.setVisibility(0);
            this.jtC = false;
            if (this.jtG != null) {
                this.jtG.bGn();
            }
        }
    }

    private void ccL() {
        if (this.hZj != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZP);
            this.aLw.setAnimationListener(null);
            this.gud.setAnimationListener(null);
            this.hZj.clearAnimation();
        }
    }

    private void cyn() {
        if (this.hZj != null) {
            this.aLw.setAnimationListener(null);
            this.gud.setAnimationListener(null);
            this.hZj.clearAnimation();
        }
    }

    public void rJ(boolean z) {
        cyo();
        if (z) {
            this.jtv.setVisibility(0);
        } else {
            this.jtv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyo() {
        if (this.currentState == 1) {
            this.jtv.setState(1);
        } else {
            this.jtv.setState(0);
        }
    }

    public void a(InterfaceC0589c interfaceC0589c) {
        this.jtF = interfaceC0589c;
    }

    public void xA(int i2) {
        this.mStartPosition = i2;
    }

    public void aj(boolean z, boolean z2) {
        if (this.eej != null) {
            if (this.hZi != null) {
                this.hZi.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hZc != null && (this.hZc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZc.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hZc.setLayoutParams(layoutParams);
            }
            this.eej.bn(z);
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
        this.jud = z;
    }

    public void a(m mVar) {
        this.jtM = mVar;
    }

    public void a(a aVar) {
        this.jtN = aVar;
    }

    public void a(n nVar) {
        this.jtO = nVar;
    }

    public void a(l lVar) {
        this.jtP = lVar;
    }

    public void a(f fVar) {
        this.jtQ = fVar;
    }

    public void rL(boolean z) {
        this.jtX = z;
    }

    public void rM(boolean z) {
        this.jtD = z;
    }

    public void An(int i2) {
        this.jub = i2;
    }

    public View cyp() {
        return this.hZa;
    }

    public void a(p pVar) {
        this.iXM = pVar;
    }

    public void cyq() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVg.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cVg.getPageActivity());
    }
}
