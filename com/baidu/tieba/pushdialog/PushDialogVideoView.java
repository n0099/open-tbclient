package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.d;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.y;
/* loaded from: classes3.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean UG;
    private Runnable UM;
    private String bNl;
    private x cAh;
    private QuickVideoView.b cAq;
    private g.a cJF;
    private g.f cJG;
    private g.InterfaceC0369g cJJ;
    private int cNL;
    private String ctu;
    private int currentState;
    private TextView dUm;
    private QuickVideoView dbc;
    private g ehL;
    private VideoLoadingProgressView.a ehX;
    private View ekF;
    private View gHZ;
    private CallStateReceiver gIE;
    private g.b gIH;
    private Runnable gII;
    private CustomMessageListener gIN;
    private ImageView gIi;
    private TbImageView gIj;
    private VideoControllerView.b gKI;
    private boolean hEJ;
    private PbVideoWifiTipLayout hEU;
    private boolean hFd;
    private boolean hVS;
    private boolean hVT;
    private boolean hVU;
    private boolean hVX;
    private boolean hVY;
    private boolean hVZ;
    private ProgressBar hVt;
    private TextView hVw;
    private Runnable hWf;
    private QuickVideoView.a hWh;
    private f idz;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void pa(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.cNL = 50;
        this.mSkinType = 3;
        this.UG = false;
        this.mStartPosition = 0;
        this.hVS = true;
        this.hVT = false;
        this.hVU = false;
        this.currentState = -1;
        this.hEJ = false;
        this.cJG = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehL = gVar;
                PushDialogVideoView.this.cAh.bTP();
            }
        };
        this.ehX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQn();
            }
        };
        this.UM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbc.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UG = true;
                    PushDialogVideoView.this.gHZ.setVisibility(8);
                    PushDialogVideoView.this.ekF.setVisibility(8);
                    PushDialogVideoView.this.cAh.bTQ();
                    PushDialogVideoView.this.gIj.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVZ = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHZ.setVisibility(0);
                PushDialogVideoView.this.hVt.setVisibility(8);
                PushDialogVideoView.this.hVt.setProgress(PushDialogVideoView.this.hVt.getMax());
                if (PushDialogVideoView.this.dbc == null || PushDialogVideoView.this.dbc.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVw.setVisibility(0);
                }
                y.bTV().remove(PushDialogVideoView.this.bNl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbc.setRecoveryState(3);
                if (PushDialogVideoView.this.dbc != null && PushDialogVideoView.this.dbc.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNl, PushDialogVideoView.this.ctu);
                }
            }
        };
        this.gIH = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ekF.setVisibility(0);
                PushDialogVideoView.this.cAh.bTR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbc.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVX = true;
                }
                PushDialogVideoView.this.hVZ = false;
                return true;
            }
        };
        this.gII = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekF.setVisibility(0);
                PushDialogVideoView.this.cAh.bTR();
            }
        };
        this.cJJ = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVT) {
                    e.jH().postDelayed(PushDialogVideoView.this.hWf, 200L);
                }
            }
        };
        this.hWf = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbc == null || !PushDialogVideoView.this.hVT) {
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 200L);
                    PushDialogVideoView.this.hVT = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbc.getCurrentPosition()) {
                    PushDialogVideoView.this.hVT = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hWf, 200L);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVZ = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UM);
                e.jH().removeCallbacks(PushDialogVideoView.this.gII);
            }
        };
        this.gIN = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.pausePlay();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.dbc != null && PushDialogVideoView.this.dbc.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbc.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbc.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKI != null) {
                                PushDialogVideoView.this.gKI.lz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNL - (duration % PushDialogVideoView.this.cNL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lz(int i) {
                int duration;
                if (PushDialogVideoView.this.dbc != null && (duration = PushDialogVideoView.this.dbc.getDuration()) > 0 && PushDialogVideoView.this.hVt != null) {
                    PushDialogVideoView.this.hVt.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hWh = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bTa() {
                PushDialogVideoView.this.cAh.startLoading();
                PushDialogVideoView.this.gIj.setVisibility(0);
                PushDialogVideoView.this.gIi.setVisibility(8);
                PushDialogVideoView.this.hVw.setVisibility(8);
                PushDialogVideoView.this.ekF.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gII);
                e.jH().postDelayed(PushDialogVideoView.this.gII, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNL = 50;
        this.mSkinType = 3;
        this.UG = false;
        this.mStartPosition = 0;
        this.hVS = true;
        this.hVT = false;
        this.hVU = false;
        this.currentState = -1;
        this.hEJ = false;
        this.cJG = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehL = gVar;
                PushDialogVideoView.this.cAh.bTP();
            }
        };
        this.ehX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQn();
            }
        };
        this.UM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbc.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UG = true;
                    PushDialogVideoView.this.gHZ.setVisibility(8);
                    PushDialogVideoView.this.ekF.setVisibility(8);
                    PushDialogVideoView.this.cAh.bTQ();
                    PushDialogVideoView.this.gIj.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVZ = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHZ.setVisibility(0);
                PushDialogVideoView.this.hVt.setVisibility(8);
                PushDialogVideoView.this.hVt.setProgress(PushDialogVideoView.this.hVt.getMax());
                if (PushDialogVideoView.this.dbc == null || PushDialogVideoView.this.dbc.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVw.setVisibility(0);
                }
                y.bTV().remove(PushDialogVideoView.this.bNl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbc.setRecoveryState(3);
                if (PushDialogVideoView.this.dbc != null && PushDialogVideoView.this.dbc.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNl, PushDialogVideoView.this.ctu);
                }
            }
        };
        this.gIH = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ekF.setVisibility(0);
                PushDialogVideoView.this.cAh.bTR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbc.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVX = true;
                }
                PushDialogVideoView.this.hVZ = false;
                return true;
            }
        };
        this.gII = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekF.setVisibility(0);
                PushDialogVideoView.this.cAh.bTR();
            }
        };
        this.cJJ = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVT) {
                    e.jH().postDelayed(PushDialogVideoView.this.hWf, 200L);
                }
            }
        };
        this.hWf = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbc == null || !PushDialogVideoView.this.hVT) {
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 200L);
                    PushDialogVideoView.this.hVT = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbc.getCurrentPosition()) {
                    PushDialogVideoView.this.hVT = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hWf, 200L);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVZ = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UM);
                e.jH().removeCallbacks(PushDialogVideoView.this.gII);
            }
        };
        this.gIN = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.pausePlay();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.dbc != null && PushDialogVideoView.this.dbc.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbc.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbc.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKI != null) {
                                PushDialogVideoView.this.gKI.lz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNL - (duration % PushDialogVideoView.this.cNL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lz(int i) {
                int duration;
                if (PushDialogVideoView.this.dbc != null && (duration = PushDialogVideoView.this.dbc.getDuration()) > 0 && PushDialogVideoView.this.hVt != null) {
                    PushDialogVideoView.this.hVt.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hWh = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bTa() {
                PushDialogVideoView.this.cAh.startLoading();
                PushDialogVideoView.this.gIj.setVisibility(0);
                PushDialogVideoView.this.gIi.setVisibility(8);
                PushDialogVideoView.this.hVw.setVisibility(8);
                PushDialogVideoView.this.ekF.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gII);
                e.jH().postDelayed(PushDialogVideoView.this.gII, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNL = 50;
        this.mSkinType = 3;
        this.UG = false;
        this.mStartPosition = 0;
        this.hVS = true;
        this.hVT = false;
        this.hVU = false;
        this.currentState = -1;
        this.hEJ = false;
        this.cJG = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehL = gVar;
                PushDialogVideoView.this.cAh.bTP();
            }
        };
        this.ehX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQn();
            }
        };
        this.UM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbc.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UG = true;
                    PushDialogVideoView.this.gHZ.setVisibility(8);
                    PushDialogVideoView.this.ekF.setVisibility(8);
                    PushDialogVideoView.this.cAh.bTQ();
                    PushDialogVideoView.this.gIj.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVZ = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHZ.setVisibility(0);
                PushDialogVideoView.this.hVt.setVisibility(8);
                PushDialogVideoView.this.hVt.setProgress(PushDialogVideoView.this.hVt.getMax());
                if (PushDialogVideoView.this.dbc == null || PushDialogVideoView.this.dbc.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVw.setVisibility(0);
                }
                y.bTV().remove(PushDialogVideoView.this.bNl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbc.setRecoveryState(3);
                if (PushDialogVideoView.this.dbc != null && PushDialogVideoView.this.dbc.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNl, PushDialogVideoView.this.ctu);
                }
            }
        };
        this.gIH = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.ekF.setVisibility(0);
                PushDialogVideoView.this.cAh.bTR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbc.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVX = true;
                }
                PushDialogVideoView.this.hVZ = false;
                return true;
            }
        };
        this.gII = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekF.setVisibility(0);
                PushDialogVideoView.this.cAh.bTR();
            }
        };
        this.cJJ = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVT) {
                    e.jH().postDelayed(PushDialogVideoView.this.hWf, 200L);
                }
            }
        };
        this.hWf = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbc == null || !PushDialogVideoView.this.hVT) {
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 200L);
                    PushDialogVideoView.this.hVT = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbc.getCurrentPosition()) {
                    PushDialogVideoView.this.hVT = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hWf, 200L);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVZ = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UM);
                e.jH().removeCallbacks(PushDialogVideoView.this.gII);
            }
        };
        this.gIN = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.pausePlay();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.dbc != null && PushDialogVideoView.this.dbc.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbc.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbc.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKI != null) {
                                PushDialogVideoView.this.gKI.lz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNL - (duration % PushDialogVideoView.this.cNL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lz(int i2) {
                int duration;
                if (PushDialogVideoView.this.dbc != null && (duration = PushDialogVideoView.this.dbc.getDuration()) > 0 && PushDialogVideoView.this.hVt != null) {
                    PushDialogVideoView.this.hVt.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hWh = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bTa() {
                PushDialogVideoView.this.cAh.startLoading();
                PushDialogVideoView.this.gIj.setVisibility(0);
                PushDialogVideoView.this.gIi.setVisibility(8);
                PushDialogVideoView.this.hVw.setVisibility(8);
                PushDialogVideoView.this.ekF.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gII);
                e.jH().postDelayed(PushDialogVideoView.this.gII, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, d.e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dbc = (QuickVideoView) findViewById(d.g.videoView);
        this.cAh = new x((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.cAh.setLoadingAnimationListener(this.ehX);
        this.hVt = (ProgressBar) findViewById(d.g.pgrBottomProgress);
        this.hVt.setMax(this.mWidth);
        this.hVt.setProgress(0);
        this.gHZ = findViewById(d.g.black_mask);
        this.ekF = findViewById(d.g.layout_error);
        this.gIi = (ImageView) findViewById(d.g.img_play);
        this.hVw = (TextView) findViewById(d.g.txt_replay);
        this.dUm = (TextView) findViewById(d.g.push_dialog_video_time);
        this.gIj = (TbImageView) findViewById(d.g.video_thumbnail);
        this.hEU = (PbVideoWifiTipLayout) findViewById(d.g.layout_wifi_tip);
        this.gIj.setDefaultErrorResource(0);
        this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.gIE = new CallStateReceiver();
        this.gIE.register(context);
        this.ekF.setOnClickListener(this);
        this.hVw.setOnClickListener(this);
        this.hEU.setOnPlayClickListener(this);
        this.hEU.setFreeClickListener(this);
        setOnClickListener(this);
        this.dbc.setOnPreparedListener(this.cJG);
        this.dbc.setOnCompletionListener(this.cJF);
        this.dbc.setOnErrorListener(this.gIH);
        this.dbc.setOnSeekCompleteListener(this.cJJ);
        this.dbc.setOnSurfaceDestroyedListener(this.cAq);
        this.dbc.setOnRecoveryCallback(this.hWh);
        onChangeSkinType();
    }

    public void onPause() {
        if (ql()) {
            this.hEJ = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hEJ = false;
        } else {
            this.hEJ = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hEJ) {
            bAK();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gIN);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.idz = fVar;
        this.dUm.setText(ap.hz(this.idz.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bNl = str;
        this.ctu = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dbc.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQn() {
        if (this.dbc != null && this.ehL != null) {
            if (this.hVZ) {
                this.dbc.start();
                this.hVZ = false;
            }
            e.jH().removeCallbacks(this.UM);
            e.jH().postDelayed(this.UM, 20L);
            e.jH().removeCallbacks(this.gII);
            if (this.dbc.bTr()) {
                this.currentState = 1;
                this.dbc.setRecoveryState(1);
            }
            if (this.ehL != null) {
                this.mStartPosition = y.bTV().AT(this.bNl);
                if (this.mStartPosition != 0) {
                    if (this.dbc != null) {
                        this.dbc.xp(this.mStartPosition);
                    } else {
                        this.ehL.seekTo(this.mStartPosition);
                    }
                    if (!this.hVY) {
                        showProgress();
                        e.jH().removeCallbacks(this.UM);
                    }
                    this.hVT = true;
                }
            }
        }
    }

    public void bPg() {
        if (!j.kY()) {
            l.S(getContext(), getContext().getString(d.j.neterror));
        } else if (this.dbc.isPlaying()) {
            pausePlay();
        } else if (this.UG) {
            bAK();
        } else {
            bSO();
        }
    }

    public void setPauseState() {
        this.cAh.bTR();
        this.gIi.setVisibility(0);
        this.hVw.setVisibility(8);
        this.currentState = 2;
        this.dbc.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.hVU) {
            dD(str, str2);
        } else {
            cf(str, str2);
        }
        if (aVar != null) {
            aVar.pa(z);
        }
    }

    public void cf(String str, String str2) {
        bSP();
        this.hVZ = true;
        this.currentState = 0;
        this.dbc.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbc.setVideoPath(str, str2);
        this.cAh.startLoading();
        this.gIj.setVisibility(0);
        this.gIi.setVisibility(8);
        this.hVw.setVisibility(8);
        this.ekF.setVisibility(8);
        e.jH().removeCallbacks(this.gII);
        e.jH().postDelayed(this.gII, 60000L);
    }

    public void dD(String str, String str2) {
        bSP();
        this.hVZ = true;
        this.currentState = 0;
        this.dbc.setRecoveryState(0);
        this.cAh.startLoading();
        this.gIj.setVisibility(0);
        this.gIi.setVisibility(8);
        this.hVw.setVisibility(8);
        this.ekF.setVisibility(8);
        e.jH().removeCallbacks(this.gII);
        e.jH().postDelayed(this.gII, 60000L);
    }

    public void bAK() {
        this.currentState = 1;
        this.dbc.setRecoveryState(1);
        this.dbc.start();
        this.gIj.setVisibility(8);
        this.gHZ.setVisibility(8);
        this.cAh.bTR();
        showProgress();
        this.gIi.setVisibility(8);
        this.hVw.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kY() && this.hVX && !StringUtils.isNull(this.bNl) && !StringUtils.isNull(this.ctu)) {
            this.hVX = false;
            this.hVY = true;
            cf(this.bNl, this.ctu);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbc != null) {
            this.dbc.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dbc.isPlaying() && this.hVS) {
            bSN();
        }
        this.dbc.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dbc.isPlaying() && this.hVS) {
            bSN();
        }
        this.currentState = 5;
        this.dbc.setRecoveryState(5);
        e.jH().removeCallbacks(this.UM);
        e.jH().removeCallbacks(this.gII);
        this.dbc.stopPlayback();
        this.UG = false;
        this.hVZ = false;
        this.mStartPosition = 0;
        bnQ();
    }

    public void bSN() {
        y.bTV().bj(this.bNl, this.dbc.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        this.gHZ.setVisibility(0);
        this.gIi.setVisibility(0);
        this.hVw.setVisibility(8);
        this.cAh.bTR();
        this.hVt.setVisibility(8);
        this.ekF.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gIj.setVisibility(z ? 0 : 8);
    }

    public void bnQ() {
        oU(true);
    }

    public boolean ql() {
        if (this.dbc == null) {
            return false;
        }
        return this.dbc.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dbc == null) {
            return 0;
        }
        return this.dbc.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dbc != null) {
            this.hVt.setVisibility(0);
            this.cNL = ((this.dbc.getDuration() / 200) / 50) * 50;
            if (this.cNL < 50) {
                this.cNL = 50;
            } else if (this.cNL > 500) {
                this.cNL = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNL - (this.dbc.getCurrentPosition() % this.cNL));
        }
    }

    private void bSO() {
        a(this.bNl, this.ctu, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bSP();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.hVU = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.la() && !this.hFd && !com.baidu.tieba.video.g.ciP().ciQ()) {
            this.hEU.setVisibility(0);
            this.hEU.setData(this.idz.getDuration(), this.idz.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bSP() {
        if (j.la()) {
            com.baidu.tieba.video.g.ciP().ex(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gIj.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekF) {
            bSO();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 2).bJ("tid", this.ctu));
            bPg();
        } else if (view == this.hVw) {
            cf(this.bNl, this.ctu);
        } else if (view == this.hEU.getTvPlay()) {
            this.hFd = true;
            this.hEU.setVisibility(8);
            cf(this.bNl, this.ctu);
        } else if (view == this.hEU.getTvOpenFreeData() && this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
        }
    }

    public void onDestroy() {
        stopPlay();
        e.jH().removeCallbacks(this.UM);
        e.jH().removeCallbacks(this.gII);
        e.jH().removeCallbacks(this.hWf);
        this.mHandler.removeMessages(1);
        this.gIE.unregister(getContext());
    }
}
