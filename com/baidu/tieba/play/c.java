package com.baidu.tieba.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    private static int hiO;
    private static CallStateReceiver hiP;
    private boolean SJ;
    private int SK;
    private Runnable SR;
    protected boolean SX;
    private Animation afH;
    private String bXN;
    private String bXa;
    private x cKK;
    private QuickVideoView.b cKT;
    private g.a cUp;
    private g.f cUq;
    private g.e cUs;
    private g.InterfaceC0404g cUt;
    private SeekBar.OnSeekBarChangeListener cZr;
    private int currentState;
    private com.baidu.tieba.play.o dhl;
    private VideoLoadingProgressView.a eEm;
    private View eGO;
    protected View eGT;
    private String eHo;
    private Animation fBX;
    private View hiC;
    private View hiD;
    private TextView hiE;
    private SeekBar hiF;
    private ImageView hiG;
    private ImageView hiH;
    private int hiI;
    private int hiJ;
    private int hiK;
    private int hiM;
    private int hiN;
    private boolean hiQ;
    private g.b hiS;
    protected Runnable hiT;
    private Animation.AnimationListener hiV;
    private Animation.AnimationListener hiW;
    private Runnable hiX;
    private CustomMessageListener hiY;
    public View hih;
    private VideoListMediaControllerView hij;
    private View hik;
    private FrameLayout hil;
    protected FrameLayout.LayoutParams him;
    private ImageView hip;
    private View hiq;
    private View his;
    private TbImageView hiu;
    private g.f hiv;
    private ImageView hix;
    private TextView hiy;
    private VideoControllerView.b hkT;
    private String ifL;
    private p ifZ;
    private i igl;
    private View.OnClickListener ixA;
    protected InterfaceC0403c ixB;
    private d ixC;
    private long ixD;
    private o ixE;
    private h ixF;
    private j ixG;
    private k ixH;
    private m ixI;
    private a ixJ;
    private n ixK;
    private l ixL;
    private f ixM;
    private g ixN;
    private boolean ixO;
    private boolean ixP;
    private boolean ixQ;
    private boolean ixR;
    private TextView ixS;
    private boolean ixT;
    private boolean ixU;
    private boolean ixV;
    private boolean ixW;
    private int ixX;
    private boolean ixY;
    private boolean ixZ;
    private int ixn;
    private boolean ixo;
    protected com.baidu.tieba.play.a.a ixp;
    private ProgressBar ixq;
    private View ixr;
    private SwitchImageView ixs;
    private TextView ixt;
    private TextView ixu;
    private TextView ixv;
    private g.a ixw;
    private g.b ixx;
    private boolean ixy;
    private boolean ixz;
    private boolean iya;
    private boolean iyb;
    private Runnable iyc;
    private Runnable iyd;
    private QuickVideoView.a iye;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
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
        void kY(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0403c {
        void pA();

        void pB();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bpj();

        void kv(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void qh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void ku(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cbe();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bpk();
    }

    /* loaded from: classes.dex */
    public interface j {
        void py(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bph();

        void bpi();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cbf();

        boolean cbg();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aHl();

        void aHm();

        void aHn();

        void mS(int i);

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cbd();
    }

    public c(Activity activity, View view, boolean z) {
        this.ixn = 0;
        this.SK = 100;
        this.ixo = false;
        this.SX = false;
        this.SJ = false;
        this.ixy = false;
        this.ixz = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hiJ = 0;
        this.hiK = 0;
        this.ixD = 60000L;
        this.hiM = 0;
        this.hiQ = false;
        this.ixO = true;
        this.ixP = true;
        this.ixQ = false;
        this.ixR = false;
        this.ifL = null;
        this.currentState = -1;
        this.ixT = false;
        this.ixY = true;
        this.iya = false;
        this.iyb = false;
        this.cUq = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hij != null && c.this.ixp != null && c.this.ixp.getDuration() > 0) {
                    c.this.hij.aC(0, c.this.ixp.getDuration());
                }
                c.this.baa();
                if (c.this.ixE != null) {
                    c.this.ixE.onPrepared();
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.pS();
                    return false;
                }
                return false;
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.baa();
            }
        };
        this.SR = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SR);
                if (c.this.hiu.getVisibility() != 8) {
                    if (c.this.ixp.getCurrentPosition() > c.this.SK) {
                        c.this.pS();
                    } else {
                        com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 20L);
                    }
                }
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.ixp != null) {
                    int duration = c.this.ixp.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.SJ = false;
                        c.this.ixW = false;
                        c.this.mStartPosition = 0;
                        c.this.bLQ();
                        c.this.hik.setVisibility(0);
                        c.this.ixq.setProgress(c.this.ixq.getMax());
                        c.this.SK = 100;
                        if (c.this.ixw != null) {
                            c.this.ixw.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cey()) {
                            ((QuickVideoView) c.this.ixp).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.qc(false);
                            c.this.qd(true);
                        } else {
                            c.this.ceS();
                            c.this.ixt.setVisibility(0);
                        }
                        if (!c.this.SX && duration <= 150000) {
                            if (!c.this.ixT) {
                                if (c.this.ixG != null) {
                                    c.this.ixG.py(true);
                                }
                                c.this.y(c.this.bXa, c.this.bXN, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cey()) {
                                    ((QuickVideoView) c.this.ixp).setRecoveryState(5);
                                }
                                c.this.ixp.pause();
                                c.this.ixp.seekTo(0);
                            }
                        }
                        if (c.this.ixE != null) {
                            c.this.ixE.mS(c.this.ixq.getMax());
                            c.this.ixE.onPlayEnd();
                        }
                    }
                }
            }
        };
        this.hiS = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.eGT.setVisibility(0);
                c.this.cKK.cfO();
                c.this.currentState = 4;
                if (c.this.cey()) {
                    ((QuickVideoView) c.this.ixp).setRecoveryState(4);
                }
                if (c.this.ixx != null) {
                    c.this.ixx.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    c.this.ixU = true;
                }
                if (c.this.ixE != null) {
                    c.this.ixE.aHm();
                }
                c.this.ixW = false;
                return true;
            }
        };
        this.hiT = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ixp == null || !c.this.ixp.isPlaying()) {
                    c.this.eGT.setVisibility(0);
                    c.this.cKK.cfO();
                    if (c.this.ixE != null) {
                        c.this.ixE.aHm();
                    }
                }
            }
        };
        this.cUt = new g.InterfaceC0404g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.ixQ) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyc, 200L);
                }
            }
        };
        this.iyc = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ixp == null || !c.this.ixQ) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 200L);
                    c.this.ixQ = false;
                } else if (c.this.mStartPosition != c.this.ixp.getCurrentPosition()) {
                    c.this.ixQ = false;
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 20L);
                } else {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyc, 200L);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.SJ = false;
                if (c.this.ixz) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyd, 300L);
                }
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SR);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hiT);
            }
        };
        this.iyd = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ixW = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ifZ != null) {
                    c.this.ifZ.cbd();
                }
                if (view2.getId() != c.this.eGT.getId()) {
                    if (view2.getId() != c.this.ixs.getId()) {
                        if (view2.getId() == c.this.ixu.getId()) {
                            if (c.this.ixF != null) {
                                c.this.ixF.cbe();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ixt.getId()) {
                            if (c.this.ixG != null) {
                                c.this.ixG.py(false);
                            }
                            c.this.ct(c.this.bXa, c.this.bXN);
                            return;
                        } else if (view2.getId() == c.this.hip.getId()) {
                            int i2 = c.this.ixz ? 1 : 2;
                            if (c.this.SX) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bT("tid", c.this.bXN).bT("fid", c.this.eHo).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bT("tid", c.this.bXN).bT("fid", c.this.eHo).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                            }
                            if (c.this.ixL != null) {
                                c.this.ixL.bpi();
                            }
                            if (c.this.ceC()) {
                                if (c.this.SX) {
                                    c.this.ceG();
                                } else {
                                    c.this.ceF();
                                }
                                c.this.pZ(c.this.SX);
                                return;
                            }
                            c.this.bLU();
                            return;
                        } else if (view2.getId() != c.this.hix.getId()) {
                            if (c.this.ixA != null) {
                                c.this.ixA.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.ixL != null) {
                                c.this.ixL.bpi();
                            }
                            if (c.this.ceC()) {
                                c.this.ceG();
                                c.this.pZ(false);
                                return;
                            }
                            c.this.bLU();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.caU();
                    c.this.ceU();
                    if (c.this.currentState != 1) {
                        c.this.ceQ();
                        c.this.ceR();
                    } else {
                        c.this.bMi();
                    }
                    if (c.this.ixJ != null) {
                        c.this.ixJ.kY(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.ixp.stopPlayback();
                c.this.SJ = false;
                c.this.ceL();
            }
        };
        this.hiV = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hiW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hiX = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bMf();
            }
        };
        this.hiY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hkT = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mz(int i2) {
                int duration;
                if (c.this.ixp != null && (duration = c.this.ixp.getDuration()) > 0 && c.this.ixq != null) {
                    c.this.ixq.setProgress((int) ((i2 * c.this.hih.getWidth()) / duration));
                    if (c.this.ixE != null) {
                        c.this.ixE.mS((c.this.ixp.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.cZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.ceQ();
                c.this.qd(false);
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bLV() != null) {
                    c.this.wI(c.this.bLV().getSeekPosition());
                    if (!c.this.bMe()) {
                        c.this.ceL();
                    } else {
                        c.this.bMd();
                        if (c.this.igl != null) {
                            c.this.igl.bpk();
                        }
                    }
                }
                c.this.qd(true);
                c.this.ceP();
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(true);
                }
                if (c.this.ixK != null) {
                    c.this.ixK.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.iye = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void ceX() {
                if (!c.this.ixT) {
                    c.this.cKK.startLoading();
                    c.this.hiu.setVisibility(0);
                    c.this.ixs.setVisibility(8);
                    c.this.ixu.setVisibility(8);
                    c.this.ixt.setVisibility(8);
                    c.this.ixv.setVisibility(8);
                    c.this.eGT.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hiT);
                    if (c.this.ixD > 0) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(c.this.hiT, c.this.ixD);
                    }
                }
            }
        };
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.ixY = z;
            this.his = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.ixn = 0;
        this.SK = 100;
        this.ixo = false;
        this.SX = false;
        this.SJ = false;
        this.ixy = false;
        this.ixz = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hiJ = 0;
        this.hiK = 0;
        this.ixD = 60000L;
        this.hiM = 0;
        this.hiQ = false;
        this.ixO = true;
        this.ixP = true;
        this.ixQ = false;
        this.ixR = false;
        this.ifL = null;
        this.currentState = -1;
        this.ixT = false;
        this.ixY = true;
        this.iya = false;
        this.iyb = false;
        this.cUq = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hij != null && c.this.ixp != null && c.this.ixp.getDuration() > 0) {
                    c.this.hij.aC(0, c.this.ixp.getDuration());
                }
                c.this.baa();
                if (c.this.ixE != null) {
                    c.this.ixE.onPrepared();
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.pS();
                    return false;
                }
                return false;
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.baa();
            }
        };
        this.SR = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SR);
                if (c.this.hiu.getVisibility() != 8) {
                    if (c.this.ixp.getCurrentPosition() > c.this.SK) {
                        c.this.pS();
                    } else {
                        com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 20L);
                    }
                }
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.ixp != null) {
                    int duration = c.this.ixp.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.SJ = false;
                        c.this.ixW = false;
                        c.this.mStartPosition = 0;
                        c.this.bLQ();
                        c.this.hik.setVisibility(0);
                        c.this.ixq.setProgress(c.this.ixq.getMax());
                        c.this.SK = 100;
                        if (c.this.ixw != null) {
                            c.this.ixw.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cey()) {
                            ((QuickVideoView) c.this.ixp).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.qc(false);
                            c.this.qd(true);
                        } else {
                            c.this.ceS();
                            c.this.ixt.setVisibility(0);
                        }
                        if (!c.this.SX && duration <= 150000) {
                            if (!c.this.ixT) {
                                if (c.this.ixG != null) {
                                    c.this.ixG.py(true);
                                }
                                c.this.y(c.this.bXa, c.this.bXN, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cey()) {
                                    ((QuickVideoView) c.this.ixp).setRecoveryState(5);
                                }
                                c.this.ixp.pause();
                                c.this.ixp.seekTo(0);
                            }
                        }
                        if (c.this.ixE != null) {
                            c.this.ixE.mS(c.this.ixq.getMax());
                            c.this.ixE.onPlayEnd();
                        }
                    }
                }
            }
        };
        this.hiS = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.eGT.setVisibility(0);
                c.this.cKK.cfO();
                c.this.currentState = 4;
                if (c.this.cey()) {
                    ((QuickVideoView) c.this.ixp).setRecoveryState(4);
                }
                if (c.this.ixx != null) {
                    c.this.ixx.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    c.this.ixU = true;
                }
                if (c.this.ixE != null) {
                    c.this.ixE.aHm();
                }
                c.this.ixW = false;
                return true;
            }
        };
        this.hiT = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ixp == null || !c.this.ixp.isPlaying()) {
                    c.this.eGT.setVisibility(0);
                    c.this.cKK.cfO();
                    if (c.this.ixE != null) {
                        c.this.ixE.aHm();
                    }
                }
            }
        };
        this.cUt = new g.InterfaceC0404g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.ixQ) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyc, 200L);
                }
            }
        };
        this.iyc = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ixp == null || !c.this.ixQ) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 200L);
                    c.this.ixQ = false;
                } else if (c.this.mStartPosition != c.this.ixp.getCurrentPosition()) {
                    c.this.ixQ = false;
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 20L);
                } else {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyc, 200L);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.SJ = false;
                if (c.this.ixz) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyd, 300L);
                }
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SR);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hiT);
            }
        };
        this.iyd = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ixW = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ifZ != null) {
                    c.this.ifZ.cbd();
                }
                if (view2.getId() != c.this.eGT.getId()) {
                    if (view2.getId() != c.this.ixs.getId()) {
                        if (view2.getId() == c.this.ixu.getId()) {
                            if (c.this.ixF != null) {
                                c.this.ixF.cbe();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ixt.getId()) {
                            if (c.this.ixG != null) {
                                c.this.ixG.py(false);
                            }
                            c.this.ct(c.this.bXa, c.this.bXN);
                            return;
                        } else if (view2.getId() == c.this.hip.getId()) {
                            int i2 = c.this.ixz ? 1 : 2;
                            if (c.this.SX) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bT("tid", c.this.bXN).bT("fid", c.this.eHo).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bT("tid", c.this.bXN).bT("fid", c.this.eHo).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                            }
                            if (c.this.ixL != null) {
                                c.this.ixL.bpi();
                            }
                            if (c.this.ceC()) {
                                if (c.this.SX) {
                                    c.this.ceG();
                                } else {
                                    c.this.ceF();
                                }
                                c.this.pZ(c.this.SX);
                                return;
                            }
                            c.this.bLU();
                            return;
                        } else if (view2.getId() != c.this.hix.getId()) {
                            if (c.this.ixA != null) {
                                c.this.ixA.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.ixL != null) {
                                c.this.ixL.bpi();
                            }
                            if (c.this.ceC()) {
                                c.this.ceG();
                                c.this.pZ(false);
                                return;
                            }
                            c.this.bLU();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.caU();
                    c.this.ceU();
                    if (c.this.currentState != 1) {
                        c.this.ceQ();
                        c.this.ceR();
                    } else {
                        c.this.bMi();
                    }
                    if (c.this.ixJ != null) {
                        c.this.ixJ.kY(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.ixp.stopPlayback();
                c.this.SJ = false;
                c.this.ceL();
            }
        };
        this.hiV = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hiW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hiX = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bMf();
            }
        };
        this.hiY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hkT = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mz(int i2) {
                int duration;
                if (c.this.ixp != null && (duration = c.this.ixp.getDuration()) > 0 && c.this.ixq != null) {
                    c.this.ixq.setProgress((int) ((i2 * c.this.hih.getWidth()) / duration));
                    if (c.this.ixE != null) {
                        c.this.ixE.mS((c.this.ixp.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.cZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.ceQ();
                c.this.qd(false);
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bLV() != null) {
                    c.this.wI(c.this.bLV().getSeekPosition());
                    if (!c.this.bMe()) {
                        c.this.ceL();
                    } else {
                        c.this.bMd();
                        if (c.this.igl != null) {
                            c.this.igl.bpk();
                        }
                    }
                }
                c.this.qd(true);
                c.this.ceP();
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(true);
                }
                if (c.this.ixK != null) {
                    c.this.ixK.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.iye = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void ceX() {
                if (!c.this.ixT) {
                    c.this.cKK.startLoading();
                    c.this.hiu.setVisibility(0);
                    c.this.ixs.setVisibility(8);
                    c.this.ixu.setVisibility(8);
                    c.this.ixt.setVisibility(8);
                    c.this.ixv.setVisibility(8);
                    c.this.eGT.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hiT);
                    if (c.this.ixD > 0) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(c.this.hiT, c.this.ixD);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.ixY = z;
            this.his = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.ixn = 0;
        this.SK = 100;
        this.ixo = false;
        this.SX = false;
        this.SJ = false;
        this.ixy = false;
        this.ixz = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hiJ = 0;
        this.hiK = 0;
        this.ixD = 60000L;
        this.hiM = 0;
        this.hiQ = false;
        this.ixO = true;
        this.ixP = true;
        this.ixQ = false;
        this.ixR = false;
        this.ifL = null;
        this.currentState = -1;
        this.ixT = false;
        this.ixY = true;
        this.iya = false;
        this.iyb = false;
        this.cUq = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hij != null && c.this.ixp != null && c.this.ixp.getDuration() > 0) {
                    c.this.hij.aC(0, c.this.ixp.getDuration());
                }
                c.this.baa();
                if (c.this.ixE != null) {
                    c.this.ixE.onPrepared();
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.pS();
                    return false;
                }
                return false;
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.baa();
            }
        };
        this.SR = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SR);
                if (c.this.hiu.getVisibility() != 8) {
                    if (c.this.ixp.getCurrentPosition() > c.this.SK) {
                        c.this.pS();
                    } else {
                        com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 20L);
                    }
                }
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.ixp != null) {
                    int duration = c.this.ixp.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.SJ = false;
                        c.this.ixW = false;
                        c.this.mStartPosition = 0;
                        c.this.bLQ();
                        c.this.hik.setVisibility(0);
                        c.this.ixq.setProgress(c.this.ixq.getMax());
                        c.this.SK = 100;
                        if (c.this.ixw != null) {
                            c.this.ixw.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cey()) {
                            ((QuickVideoView) c.this.ixp).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.qc(false);
                            c.this.qd(true);
                        } else {
                            c.this.ceS();
                            c.this.ixt.setVisibility(0);
                        }
                        if (!c.this.SX && duration <= 150000) {
                            if (!c.this.ixT) {
                                if (c.this.ixG != null) {
                                    c.this.ixG.py(true);
                                }
                                c.this.y(c.this.bXa, c.this.bXN, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cey()) {
                                    ((QuickVideoView) c.this.ixp).setRecoveryState(5);
                                }
                                c.this.ixp.pause();
                                c.this.ixp.seekTo(0);
                            }
                        }
                        if (c.this.ixE != null) {
                            c.this.ixE.mS(c.this.ixq.getMax());
                            c.this.ixE.onPlayEnd();
                        }
                    }
                }
            }
        };
        this.hiS = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.eGT.setVisibility(0);
                c.this.cKK.cfO();
                c.this.currentState = 4;
                if (c.this.cey()) {
                    ((QuickVideoView) c.this.ixp).setRecoveryState(4);
                }
                if (c.this.ixx != null) {
                    c.this.ixx.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    c.this.ixU = true;
                }
                if (c.this.ixE != null) {
                    c.this.ixE.aHm();
                }
                c.this.ixW = false;
                return true;
            }
        };
        this.hiT = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ixp == null || !c.this.ixp.isPlaying()) {
                    c.this.eGT.setVisibility(0);
                    c.this.cKK.cfO();
                    if (c.this.ixE != null) {
                        c.this.ixE.aHm();
                    }
                }
            }
        };
        this.cUt = new g.InterfaceC0404g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.ixQ) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyc, 200L);
                }
            }
        };
        this.iyc = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ixp == null || !c.this.ixQ) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 200L);
                    c.this.ixQ = false;
                } else if (c.this.mStartPosition != c.this.ixp.getCurrentPosition()) {
                    c.this.ixQ = false;
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SR, 20L);
                } else {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyc, 200L);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.SJ = false;
                if (c.this.ixz) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iyd, 300L);
                }
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SR);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hiT);
            }
        };
        this.iyd = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ixW = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ifZ != null) {
                    c.this.ifZ.cbd();
                }
                if (view2.getId() != c.this.eGT.getId()) {
                    if (view2.getId() != c.this.ixs.getId()) {
                        if (view2.getId() == c.this.ixu.getId()) {
                            if (c.this.ixF != null) {
                                c.this.ixF.cbe();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.ixt.getId()) {
                            if (c.this.ixG != null) {
                                c.this.ixG.py(false);
                            }
                            c.this.ct(c.this.bXa, c.this.bXN);
                            return;
                        } else if (view2.getId() == c.this.hip.getId()) {
                            int i22 = c.this.ixz ? 1 : 2;
                            if (c.this.SX) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").bT("tid", c.this.bXN).bT("fid", c.this.eHo).P("obj_type", i22).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").bT("tid", c.this.bXN).bT("fid", c.this.eHo).P("obj_type", i22).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                            }
                            if (c.this.ixL != null) {
                                c.this.ixL.bpi();
                            }
                            if (c.this.ceC()) {
                                if (c.this.SX) {
                                    c.this.ceG();
                                } else {
                                    c.this.ceF();
                                }
                                c.this.pZ(c.this.SX);
                                return;
                            }
                            c.this.bLU();
                            return;
                        } else if (view2.getId() != c.this.hix.getId()) {
                            if (c.this.ixA != null) {
                                c.this.ixA.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.ixL != null) {
                                c.this.ixL.bpi();
                            }
                            if (c.this.ceC()) {
                                c.this.ceG();
                                c.this.pZ(false);
                                return;
                            }
                            c.this.bLU();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.caU();
                    c.this.ceU();
                    if (c.this.currentState != 1) {
                        c.this.ceQ();
                        c.this.ceR();
                    } else {
                        c.this.bMi();
                    }
                    if (c.this.ixJ != null) {
                        c.this.ixJ.kY(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.ixp.stopPlayback();
                c.this.SJ = false;
                c.this.ceL();
            }
        };
        this.hiV = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hiW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hiX = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bMf();
            }
        };
        this.hiY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hkT = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mz(int i22) {
                int duration;
                if (c.this.ixp != null && (duration = c.this.ixp.getDuration()) > 0 && c.this.ixq != null) {
                    c.this.ixq.setProgress((int) ((i22 * c.this.hih.getWidth()) / duration));
                    if (c.this.ixE != null) {
                        c.this.ixE.mS((c.this.ixp.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.cZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.ceQ();
                c.this.qd(false);
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bLV() != null) {
                    c.this.wI(c.this.bLV().getSeekPosition());
                    if (!c.this.bMe()) {
                        c.this.ceL();
                    } else {
                        c.this.bMd();
                        if (c.this.igl != null) {
                            c.this.igl.bpk();
                        }
                    }
                }
                c.this.qd(true);
                c.this.ceP();
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(true);
                }
                if (c.this.ixK != null) {
                    c.this.ixK.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.iye = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void ceX() {
                if (!c.this.ixT) {
                    c.this.cKK.startLoading();
                    c.this.hiu.setVisibility(0);
                    c.this.ixs.setVisibility(8);
                    c.this.ixu.setVisibility(8);
                    c.this.ixt.setVisibility(8);
                    c.this.ixv.setVisibility(8);
                    c.this.eGT.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hiT);
                    if (c.this.ixD > 0) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(c.this.hiT, c.this.ixD);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.ixY = z;
            this.his = view;
            this.mActivity = this.mContext.getPageActivity();
            this.ixn = i2;
            init();
        }
    }

    public void init() {
        this.hih = as(this.mActivity);
        this.hih.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hih);
        }
        this.ixp = com.baidu.tieba.play.a.b.y(this.mActivity, this.ixn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hih).addView(this.ixp.getView(), 0);
        this.ixp.getView().setLayoutParams(layoutParams);
        this.cKK = new x((ViewGroup) this.hih.findViewById(R.id.auto_video_loading_container));
        this.cKK.setLoadingAnimationListener(this.eEm);
        this.hij = (VideoListMediaControllerView) this.hih.findViewById(R.id.media_controller);
        this.hij.setPlayer(this.ixp);
        this.ixq = (ProgressBar) this.hih.findViewById(R.id.pgrBottomProgress);
        this.ixq.setMax(com.baidu.adp.lib.util.l.af(this.mActivity));
        this.ixq.setProgress(0);
        this.hij.setOnSeekBarChangeListener(this.cZr);
        this.hij.setOnProgressUpdatedListener(this.hkT);
        this.hik = this.hih.findViewById(R.id.black_mask);
        this.eGT = this.hih.findViewById(R.id.layout_error);
        this.eGT.setOnClickListener(this.mOnClickListener);
        this.ixS = (TextView) this.hih.findViewById(R.id.auto_video_error_tips);
        this.hil = (FrameLayout) this.hih.findViewById(R.id.danmu_container);
        this.hip = (ImageView) this.hih.findViewById(R.id.img_full_screen);
        this.hip.setOnClickListener(this.mOnClickListener);
        this.hiq = this.hih.findViewById(R.id.layout_media_controller);
        this.ixr = this.hih.findViewById(R.id.time_show_controller);
        this.ixp.setContinuePlayEnable(true);
        this.ixp.setOnPreparedListener(this.cUq);
        this.ixp.setOnCompletionListener(this.cUp);
        this.ixp.setOnErrorListener(this.hiS);
        this.ixp.setOnSeekCompleteListener(this.cUt);
        this.ixp.setOnOutInfoListener(this.cUs);
        this.ixp.setOnSurfaceDestroyedListener(this.cKT);
        if (cey()) {
            ((QuickVideoView) this.ixp).setOnRecoveryCallback(this.iye);
        }
        this.ixs = (SwitchImageView) this.hih.findViewById(R.id.img_play_controller);
        this.ixs.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.ixs.setState(0);
        this.ixs.setOnClickListener(this.mOnClickListener);
        this.ixt = (TextView) this.hih.findViewById(R.id.txt_replay);
        this.ixt.setOnClickListener(this.mOnClickListener);
        this.ixu = (TextView) this.hih.findViewById(R.id.txt_playnext);
        this.ixu.setOnClickListener(this.mOnClickListener);
        this.ixv = (TextView) this.hih.findViewById(R.id.txt_next_video_title);
        this.hiu = (TbImageView) this.hih.findViewById(R.id.video_thumbnail);
        this.hiu.setDefaultErrorResource(0);
        this.hiu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hix = (ImageView) this.hih.findViewById(R.id.img_exit);
        this.hix.setOnClickListener(this.mOnClickListener);
        this.hiy = (TextView) this.hih.findViewById(R.id.video_title);
        this.eGO = this.hih.findViewById(R.id.layout_title);
        this.eGO.setVisibility(8);
        this.fBX = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afH = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hiI = this.mAudioManager.getStreamMaxVolume(3);
        this.hiN = this.mAudioManager.getStreamVolume(3);
        hiO = 100 / this.hiI;
        this.hih.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.ixH != null) {
                    c.this.ixH.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.SJ) {
                        if (c.this.mStatus == 1 && c.this.hiK != 0) {
                            c.this.b(c.this.hiK == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hiK = 0;
                            c.this.hiJ = 0;
                        }
                        if (!c.this.ixp.isPlaying()) {
                            c.this.ixu.setVisibility(8);
                            c.this.ixt.setVisibility(8);
                            c.this.ixv.setVisibility(8);
                        }
                    }
                    c.this.bLQ();
                    if (c.this.ixH != null) {
                        c.this.ixH.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.dhl = new com.baidu.tieba.play.o(this.mActivity);
        if (this.ixY) {
            this.dhl.start();
        }
        this.hiM = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.ds16);
        if (hiP == null) {
            hiP = new CallStateReceiver();
        }
        hiP.register(this.mActivity);
        cez();
        MessageManager.getInstance().registerListener(this.hiY);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hiY);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public boolean cey() {
        return this.ixn == 0 && (this.ixp instanceof QuickVideoView);
    }

    public void cez() {
        if (this.ixO) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hih.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hih.setSystemUiVisibility(0);
    }

    public void pX(boolean z) {
        this.ixO = z;
        cez();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLQ() {
        this.mStatus = 0;
        if (this.hiC != null && this.hiC.getParent() != null && (this.hiC.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hiC.getParent()).removeView(this.hiC);
                this.hiC = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hiD != null && this.hiD.getParent() != null && (this.hiD.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hiD.getParent()).removeView(this.hiD);
                this.hiD = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bLR() {
        if (this.mStatus == 1) {
            if (this.hiC == null && this.hih != null && (this.hih instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hih, true);
                this.hiC = this.hih.findViewById(R.id.lay_jindu);
                this.hiE = (TextView) this.hiC.findViewById(R.id.show_time);
                this.hiH = (ImageView) this.hiC.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hiD == null && this.hih != null && (this.hih instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hih, true);
            this.hiD = this.hih.findViewById(R.id.lay_voice);
            this.hiG = (ImageView) this.hiD.findViewById(R.id.arrow_voice_icon);
            this.hiF = (SeekBar) this.hiD.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.ixA = onClickListener;
    }

    public void pY(boolean z) {
        this.ixz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.ixH != null) {
                c.this.ixH.onStart();
            }
            if (c.this.SX && c.this.SJ) {
                if (c.this.mStatus == 1) {
                    c.this.ceS();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aN(f2);
                    }
                } else {
                    if (c.this.SX) {
                        c.this.bLT();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hiJ = c.this.ixp.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aN(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.ixZ) {
                if (c.this.ixI != null && c.this.ixI.cbf()) {
                    return true;
                }
                c.this.caU();
                c.this.ceU();
                if (c.this.ixp.isPlaying()) {
                    c.this.ceP();
                } else {
                    c.this.ceQ();
                }
                if (c.this.ixJ != null) {
                    c.this.ixJ.kY(c.this.ixp.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.ixZ) {
                if (c.this.SJ) {
                    if (c.this.ixI != null && c.this.ixI.cbg()) {
                        return true;
                    }
                    c.this.ceO();
                    if (c.this.ixp.isPlaying()) {
                        c.this.ceP();
                    } else {
                        c.this.ceQ();
                    }
                    if (c.this.ixJ != null) {
                        c.this.ixJ.kY(c.this.ixp.isPlaying());
                    }
                } else {
                    c.this.caU();
                    c.this.ceU();
                    if (c.this.currentState != 1) {
                        c.this.ceQ();
                        c.this.ceR();
                    } else {
                        c.this.bMi();
                    }
                    if (c.this.ixJ != null) {
                        c.this.ixJ.kY(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hih.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hih.setSystemUiVisibility(4);
        } else {
            this.hih.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(float f2) {
        if (!this.SJ) {
            this.mStatus = 0;
            return;
        }
        bLR();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hiO == 0) {
            if (f2 > 0.0f && this.hiN < this.hiI) {
                this.hiN++;
            }
            if (f2 < 0.0f && this.hiN > 0) {
                this.hiN--;
            }
        }
        if (this.mProgress > 0) {
            this.hiG.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hiG.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hiN, 0);
        this.hiF.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hiJ += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.hiK = 1;
            } else {
                this.hiJ += 1000;
                this.hiK = 2;
            }
            if (this.hiJ < 0) {
                this.hiJ = 0;
            } else if (this.hiJ > this.ixp.getDuration()) {
                this.hiJ = this.ixp.getDuration();
            }
        }
        bLR();
        String ze = this.hij.ze(this.hiJ);
        if (f2 > 0.0f) {
            this.hiH.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hiH.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(ze)) {
            this.hiE.setText(new StringBuilder().append(ze).append("/").append(this.hij.ze(this.ixp.getDuration())));
        }
        this.hij.setCurrentDuration(this.hiJ, z ? false : true);
        ceS();
        ceH();
    }

    protected View as(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bXa = str;
        this.bXN = str2;
    }

    public void ceA() {
        if (this.ixp != null) {
            this.ixp.ceA();
        }
    }

    public void setFid(String str) {
        this.eHo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baa() {
        if (this.ixp != null && this.hij != null) {
            this.hij.showProgress();
            this.mStartPosition = y.cfS().Dz(this.bXa);
            if (this.ixW) {
                this.ixp.setVolume(1.0f, 1.0f);
                this.ixp.start();
                this.ixW = false;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SR);
                com.baidu.adp.lib.g.e.iK().postDelayed(this.SR, 20L);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiT);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyd);
                if (this.ixp.cfo()) {
                    this.currentState = 1;
                    if (cey()) {
                        ((QuickVideoView) this.ixp).setRecoveryState(1);
                    }
                    ceS();
                }
                this.mStartPosition = y.cfS().Dz(this.bXa);
                this.hij.setPlayer(this.ixp);
                if (this.mStartPosition != 0) {
                    this.ixQ = true;
                }
                if (!this.ixV) {
                    this.hij.showProgress();
                }
                if (!this.ixz && this.ixp.getDuration() <= 0) {
                    bLV().setVisibility(4);
                }
            }
            this.SK = (this.mStartPosition <= 100 || this.ixp.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.hiu.getVisibility() != 8 || !this.SJ) {
            this.SJ = true;
            this.hik.setVisibility(8);
            this.eGT.setVisibility(8);
            this.cKK.cfN();
            this.hiu.setVisibility(8);
            ceT();
            long duration = this.ixp.getDuration() / 1000;
            String str = this.bXN;
            this.hij.showProgress();
            this.ixq.setVisibility(0);
            if (this.hiv != null && cey()) {
                this.hiv.onPrepared(((QuickVideoView) this.ixp).getPlayer());
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

    protected void pZ(boolean z) {
        if (hasNavBar(this.mActivity) && (this.ixr.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixr.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.ixr.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.ixr.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.ixr.setLayoutParams(layoutParams);
        }
    }

    public void caU() {
        if (this.ixp.isPlaying()) {
            pausePlay();
            if (this.ixN != null) {
                this.ixN.onPause();
            }
            if (this.ixE != null) {
                this.ixE.aHl();
            }
        } else if (this.SJ) {
            bMd();
            if (this.igl != null) {
                this.igl.bpk();
            }
            if (this.ixE != null) {
                this.ixE.aHn();
            }
        } else {
            ceL();
        }
    }

    public boolean ceB() {
        return this.hiQ;
    }

    public void bLU() {
        this.hiQ = true;
        if (this.dhl != null) {
            this.dhl.bLU();
        }
    }

    public boolean ceC() {
        return this.ixp != null && this.ixp.getView().getHeight() > this.ixp.getView().getWidth();
    }

    public void ceD() {
        pZ(false);
        ceG();
    }

    public boolean yY(int i2) {
        switch (i2) {
            case 4:
                if (this.SX) {
                    if (ceC()) {
                        pZ(false);
                        ceG();
                    } else {
                        bLU();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hiI <= 0 || this.hiF == null) {
                    return false;
                }
                this.hiN = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hiN * 100.0d) / this.hiI);
                this.hiF.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cey()) {
            return (QuickVideoView) this.ixp;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a ceE() {
        return this.ixp;
    }

    public VideoListMediaControllerView bLV() {
        return this.hij;
    }

    public void show() {
        this.hih.setVisibility(0);
    }

    public void bLZ() {
        if (this.his != null) {
            ViewGroup.LayoutParams layoutParams = this.his.getLayoutParams();
            this.him = (FrameLayout.LayoutParams) this.hih.getLayoutParams();
            this.him.width = layoutParams.width;
            this.him.height = layoutParams.height;
            this.him.topMargin = 0;
            this.hih.setLayoutParams(this.him);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hiQ) {
            if (this.SX) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hiQ = false;
        }
        if (configuration.orientation == 2) {
            ceF();
        } else {
            ceG();
        }
        ceH();
        bMd();
        ceU();
        bMi();
        if (this.ixJ != null) {
            this.ixJ.kY(true);
        }
    }

    protected void ceF() {
        this.SX = true;
        int u = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.u(this.mActivity) : 0;
        if (ceC()) {
            this.hih.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hih.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - u, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.eGO.setVisibility(0);
        this.hix.setVisibility(0);
        this.hiy.setVisibility(0);
        this.hil.setVisibility(8);
        this.cKK.cfO();
        this.hiu.setVisibility(8);
        this.hip.setImageResource(R.drawable.icon_video_narrow_white);
        wF(this.hiM);
        bLT();
        if (this.ixB != null) {
            this.ixB.pA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceG() {
        this.SX = false;
        if (this.him != null) {
            this.hih.setLayoutParams(this.him);
        }
        g(this.mActivity, false);
        this.eGO.setVisibility(8);
        this.hil.setVisibility(0);
        this.cKK.cfO();
        this.hiu.setVisibility(8);
        this.hip.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hij != null && (this.hij.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hij.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hij.setLayoutParams(layoutParams);
        }
        this.hih.setSystemUiVisibility(0);
        cez();
        if (this.ixB != null) {
            this.ixB.pB();
        }
    }

    public void ceH() {
        if (this.ixp != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mActivity);
            if (this.SX) {
                af = com.baidu.adp.lib.util.l.ah(this.mActivity);
            }
            this.ixq.setMax(af);
            int duration = this.ixp.getDuration();
            if (duration > 0) {
                if (this.ixt.getVisibility() == 0) {
                    this.ixq.setProgress(this.ixq.getMax());
                } else {
                    this.ixq.setProgress((int) ((this.ixp.getCurrentPositionSync() * this.ixq.getMax()) / duration));
                }
            }
        }
    }

    private void wF(int i2) {
        if (this.hij != null && (this.hij.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hij.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hij.setLayoutParams(layoutParams);
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

    public boolean bMb() {
        return !this.SX;
    }

    public void a(g.f fVar) {
        this.hiv = fVar;
    }

    public void a(g.a aVar) {
        this.ixw = aVar;
    }

    public void a(g.b bVar) {
        this.ixx = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.ixR) {
            dT(str, str2);
        } else {
            ct(str, str2);
        }
        if (eVar != null) {
            eVar.qh(z);
        }
    }

    public void dS(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, boolean z) {
        ceM();
        this.ixW = true;
        this.currentState = 0;
        if (cey()) {
            ((QuickVideoView) this.ixp).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.ixp.setVideoPath(str, str2);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiT);
        if (this.ixD > 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.hiT, this.ixD);
        }
        if (this.ixE != null) {
            this.ixE.onStarted();
        }
        this.cKK.startLoading();
        qa(z);
    }

    public void ct(String str, String str2) {
        y(str, str2, true);
    }

    public void dT(String str, String str2) {
        ceM();
        this.ixW = true;
        this.currentState = 0;
        if (cey()) {
            ((QuickVideoView) this.ixp).setRecoveryState(0);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiT);
        if (this.ixD > 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.hiT, this.ixD);
        }
        if (this.ixE != null) {
            this.ixE.onStarted();
        }
        this.cKK.startLoading();
        qa(true);
    }

    public void ceI() {
        bMd();
        this.ixq.setVisibility(0);
    }

    public void bMd() {
        if (this.ixp != null && this.hij != null) {
            this.SJ = true;
            this.currentState = 1;
            if (cey()) {
                ((QuickVideoView) this.ixp).setRecoveryState(1);
            }
            this.ixp.bMd();
            this.mStartPosition = y.cfS().Dz(this.bXa);
            this.ixQ = true;
            this.SK = (this.mStartPosition <= 100 || this.ixp.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.cKK.cfO();
            qa(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kc() && this.ixU && !StringUtils.isNull(this.bXa) && !StringUtils.isNull(this.bXN)) {
            this.ixU = false;
            this.ixV = true;
            ct(this.bXa, this.bXN);
        }
    }

    private void qa(boolean z) {
        if (z) {
            this.hiu.setVisibility(0);
            ceS();
            this.ixq.setProgress(0);
        } else {
            this.hiu.setVisibility(8);
            ceS();
        }
        this.hij.showProgress();
        this.hik.setVisibility(8);
        this.ixu.setVisibility(8);
        this.ixt.setVisibility(8);
        this.ixv.setVisibility(8);
        this.eGT.setVisibility(8);
    }

    private void ceJ() {
        this.cKK.cfO();
        this.ixu.setVisibility(8);
        this.ixt.setVisibility(8);
        this.ixv.setVisibility(8);
        ceU();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.ixp instanceof QuickVideoView) {
            ((QuickVideoView) this.ixp).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.ixp.pause();
        this.currentState = 2;
        if (cey()) {
            ((QuickVideoView) this.ixp).setRecoveryState(2);
        }
        ceJ();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cey()) {
            ((QuickVideoView) this.ixp).setRecoveryState(5);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiT);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyd);
        this.ixp.stopPlayback();
        this.SJ = false;
        this.ixW = false;
        this.mStartPosition = 0;
        bzb();
    }

    public void ceK() {
        if (this.ixp.getDuration() >= this.ixp.getCurrentPosition()) {
            y.cfS().bi(this.bXa, this.ixp.getCurrentPosition());
        }
    }

    public void qb(boolean z) {
        this.ixP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
        if (this.hiq != null) {
            this.hik.setVisibility(0);
            this.ixu.setVisibility(8);
            this.ixt.setVisibility(8);
            this.ixv.setVisibility(8);
            this.cKK.cfO();
            ceS();
            this.ixq.setVisibility(8);
            this.eGT.setVisibility(8);
            this.hij.aDK();
            this.hiu.setVisibility(z ? 0 : 8);
        }
    }

    public void bzb() {
        qc(true);
    }

    public boolean pC() {
        if (this.ixp == null) {
            return false;
        }
        return this.ixp.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ixp == null) {
            return 0;
        }
        return this.ixp.getCurrentPosition();
    }

    public void a(k kVar) {
        this.ixH = kVar;
    }

    public void a(j jVar) {
        this.ixG = jVar;
    }

    public void a(i iVar) {
        this.igl = iVar;
    }

    public void a(g gVar) {
        this.ixN = gVar;
    }

    public void a(h hVar) {
        this.ixF = hVar;
    }

    public void CU(String str) {
        this.ifL = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceL() {
        a(this.bXa, this.bXN, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.ixC = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        ceM();
        if (com.baidu.adp.lib.util.j.ke() && !com.baidu.tieba.video.g.cuO().cuP()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.ahU().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.ixR = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ixM != null) {
                    this.ixM.ku(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.mQ(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.ceN();
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
                aVar.b(this.mContext).agO();
                return;
            } else if (this.ixM != null) {
                this.ixM.ku(true);
                return;
            } else {
                if (!this.ixo) {
                    this.ixo = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.ixL != null) {
            this.ixL.bph();
        }
    }

    private void ceM() {
        if (com.baidu.adp.lib.util.j.ke()) {
            com.baidu.tieba.video.g.cuO().eq(this.mActivity);
        }
    }

    public void ceN() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.hiu.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiX);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiT);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyc);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyd);
        this.dhl.stop();
        hiP.unregister(this.mActivity);
    }

    public void Du(String str) {
        this.hiy.setText(str);
    }

    public boolean bMe() {
        return this.SJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceO() {
        if (this.hiq != null) {
            if (this.ixy) {
                ceS();
            } else {
                ceR();
            }
        }
    }

    public void bMi() {
        ceR();
        ceP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceP() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiX);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.hiX, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceQ() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiX);
    }

    public void ceR() {
        if (this.hiq != null && !this.ixy && !this.iya) {
            qd(true);
            bMh();
            this.hiq.setVisibility(0);
            this.ixr.setVisibility(0);
            this.ixq.setVisibility(8);
            this.ixy = true;
            if (this.ixC != null) {
                this.ixC.kv(false);
            }
        }
    }

    public void bMf() {
        if (this.hiq != null && this.ixy) {
            qd(false);
            bMh();
            this.hiq.setVisibility(8);
            this.ixr.setVisibility(8);
            this.ixq.setVisibility(0);
            this.fBX.setAnimationListener(this.hiV);
            this.hiq.startAnimation(this.fBX);
            this.ixy = false;
            if (this.ixC != null) {
                this.ixC.bpj();
            }
        }
    }

    public void ceS() {
        if (this.hiq != null && this.ixy) {
            this.afH.cancel();
            this.fBX.cancel();
            qd(false);
            bMh();
            this.hiq.setVisibility(8);
            this.ixr.setVisibility(8);
            this.ixq.setVisibility(0);
            this.ixy = false;
            if (this.ixC != null) {
                this.ixC.bpj();
            }
        }
    }

    private void bMh() {
        if (this.hiq != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hiX);
            this.afH.setAnimationListener(null);
            this.fBX.setAnimationListener(null);
            this.hiq.clearAnimation();
        }
    }

    private void ceT() {
        if (this.hiq != null) {
            this.afH.setAnimationListener(null);
            this.fBX.setAnimationListener(null);
            this.hiq.clearAnimation();
        }
    }

    public void qd(boolean z) {
        ceU();
        if (z) {
            this.ixs.setVisibility(0);
        } else {
            this.ixs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        if (this.currentState == 1) {
            this.ixs.setState(1);
        } else {
            this.ixs.setState(0);
        }
    }

    public void a(InterfaceC0403c interfaceC0403c) {
        this.ixB = interfaceC0403c;
    }

    public void wI(int i2) {
        this.mStartPosition = i2;
    }

    public void ae(boolean z, boolean z2) {
        if (this.dhl != null) {
            if (this.hip != null) {
                this.hip.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hij != null && (this.hij.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hij.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds52);
                this.hij.setLayoutParams(layoutParams);
            }
            this.dhl.qj(z);
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
            return com.baidu.adp.lib.util.l.ah(context);
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

    public void qe(boolean z) {
        this.ixZ = z;
    }

    public void a(m mVar) {
        this.ixI = mVar;
    }

    public void a(a aVar) {
        this.ixJ = aVar;
    }

    public void a(n nVar) {
        this.ixK = nVar;
    }

    public void a(l lVar) {
        this.ixL = lVar;
    }

    public void a(f fVar) {
        this.ixM = fVar;
    }

    public void qf(boolean z) {
        this.ixT = z;
    }

    public void qg(boolean z) {
        this.ixz = z;
        if (z) {
            this.ixp.setPageTypeForPerfStat("middle");
        } else {
            this.ixp.setPageTypeForPerfStat("pb");
        }
    }

    public void yZ(int i2) {
        this.ixX = i2;
    }

    public View ceV() {
        return this.hih;
    }

    public void a(o oVar) {
        this.ixE = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.ixp != null) {
            this.ixp.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.ifZ = pVar;
    }

    public void ceW() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
    }
}
