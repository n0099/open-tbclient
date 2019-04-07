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
    private String bNn;
    private x cAj;
    private QuickVideoView.b cAs;
    private g.a cJH;
    private g.f cJI;
    private g.InterfaceC0369g cJL;
    private int cNN;
    private String ctw;
    private int currentState;
    private TextView dTF;
    private QuickVideoView dbf;
    private VideoLoadingProgressView.a ehJ;
    private g ehx;
    private View ekr;
    private View gHM;
    private ImageView gHV;
    private TbImageView gHW;
    private CustomMessageListener gIA;
    private CallStateReceiver gIr;
    private g.b gIu;
    private Runnable gIv;
    private VideoControllerView.b gKv;
    private PbVideoWifiTipLayout hEG;
    private boolean hEP;
    private boolean hEv;
    private boolean hVE;
    private boolean hVF;
    private boolean hVG;
    private boolean hVJ;
    private boolean hVK;
    private boolean hVL;
    private Runnable hVR;
    private QuickVideoView.a hVT;
    private ProgressBar hVf;
    private TextView hVi;
    private f idi;
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
        this.cNN = 50;
        this.mSkinType = 3;
        this.UG = false;
        this.mStartPosition = 0;
        this.hVE = true;
        this.hVF = false;
        this.hVG = false;
        this.currentState = -1;
        this.hEv = false;
        this.cJI = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehx = gVar;
                PushDialogVideoView.this.cAj.bTL();
            }
        };
        this.ehJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQl();
            }
        };
        this.UM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbf.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UG = true;
                    PushDialogVideoView.this.gHM.setVisibility(8);
                    PushDialogVideoView.this.ekr.setVisibility(8);
                    PushDialogVideoView.this.cAj.bTM();
                    PushDialogVideoView.this.gHW.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVL = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHM.setVisibility(0);
                PushDialogVideoView.this.hVf.setVisibility(8);
                PushDialogVideoView.this.hVf.setProgress(PushDialogVideoView.this.hVf.getMax());
                if (PushDialogVideoView.this.dbf == null || PushDialogVideoView.this.dbf.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVi.setVisibility(0);
                }
                y.bTR().remove(PushDialogVideoView.this.bNn);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbf.setRecoveryState(3);
                if (PushDialogVideoView.this.dbf != null && PushDialogVideoView.this.dbf.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNn, PushDialogVideoView.this.ctw);
                }
            }
        };
        this.gIu = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ekr.setVisibility(0);
                PushDialogVideoView.this.cAj.bTN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbf.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVJ = true;
                }
                PushDialogVideoView.this.hVL = false;
                return true;
            }
        };
        this.gIv = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekr.setVisibility(0);
                PushDialogVideoView.this.cAj.bTN();
            }
        };
        this.cJL = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVF) {
                    e.jH().postDelayed(PushDialogVideoView.this.hVR, 200L);
                }
            }
        };
        this.hVR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbf == null || !PushDialogVideoView.this.hVF) {
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 200L);
                    PushDialogVideoView.this.hVF = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbf.getCurrentPosition()) {
                    PushDialogVideoView.this.hVF = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hVR, 200L);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVL = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UM);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIv);
            }
        };
        this.gIA = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dbf != null && PushDialogVideoView.this.dbf.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbf.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbf.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKv != null) {
                                PushDialogVideoView.this.gKv.ly(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNN - (duration % PushDialogVideoView.this.cNN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKv = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ly(int i) {
                int duration;
                if (PushDialogVideoView.this.dbf != null && (duration = PushDialogVideoView.this.dbf.getDuration()) > 0 && PushDialogVideoView.this.hVf != null) {
                    PushDialogVideoView.this.hVf.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hVT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSW() {
                PushDialogVideoView.this.cAj.startLoading();
                PushDialogVideoView.this.gHW.setVisibility(0);
                PushDialogVideoView.this.gHV.setVisibility(8);
                PushDialogVideoView.this.hVi.setVisibility(8);
                PushDialogVideoView.this.ekr.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIv);
                e.jH().postDelayed(PushDialogVideoView.this.gIv, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNN = 50;
        this.mSkinType = 3;
        this.UG = false;
        this.mStartPosition = 0;
        this.hVE = true;
        this.hVF = false;
        this.hVG = false;
        this.currentState = -1;
        this.hEv = false;
        this.cJI = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehx = gVar;
                PushDialogVideoView.this.cAj.bTL();
            }
        };
        this.ehJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQl();
            }
        };
        this.UM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbf.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UG = true;
                    PushDialogVideoView.this.gHM.setVisibility(8);
                    PushDialogVideoView.this.ekr.setVisibility(8);
                    PushDialogVideoView.this.cAj.bTM();
                    PushDialogVideoView.this.gHW.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVL = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHM.setVisibility(0);
                PushDialogVideoView.this.hVf.setVisibility(8);
                PushDialogVideoView.this.hVf.setProgress(PushDialogVideoView.this.hVf.getMax());
                if (PushDialogVideoView.this.dbf == null || PushDialogVideoView.this.dbf.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVi.setVisibility(0);
                }
                y.bTR().remove(PushDialogVideoView.this.bNn);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbf.setRecoveryState(3);
                if (PushDialogVideoView.this.dbf != null && PushDialogVideoView.this.dbf.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNn, PushDialogVideoView.this.ctw);
                }
            }
        };
        this.gIu = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ekr.setVisibility(0);
                PushDialogVideoView.this.cAj.bTN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbf.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVJ = true;
                }
                PushDialogVideoView.this.hVL = false;
                return true;
            }
        };
        this.gIv = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekr.setVisibility(0);
                PushDialogVideoView.this.cAj.bTN();
            }
        };
        this.cJL = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVF) {
                    e.jH().postDelayed(PushDialogVideoView.this.hVR, 200L);
                }
            }
        };
        this.hVR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbf == null || !PushDialogVideoView.this.hVF) {
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 200L);
                    PushDialogVideoView.this.hVF = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbf.getCurrentPosition()) {
                    PushDialogVideoView.this.hVF = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hVR, 200L);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVL = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UM);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIv);
            }
        };
        this.gIA = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dbf != null && PushDialogVideoView.this.dbf.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbf.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbf.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKv != null) {
                                PushDialogVideoView.this.gKv.ly(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNN - (duration % PushDialogVideoView.this.cNN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKv = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ly(int i) {
                int duration;
                if (PushDialogVideoView.this.dbf != null && (duration = PushDialogVideoView.this.dbf.getDuration()) > 0 && PushDialogVideoView.this.hVf != null) {
                    PushDialogVideoView.this.hVf.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hVT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSW() {
                PushDialogVideoView.this.cAj.startLoading();
                PushDialogVideoView.this.gHW.setVisibility(0);
                PushDialogVideoView.this.gHV.setVisibility(8);
                PushDialogVideoView.this.hVi.setVisibility(8);
                PushDialogVideoView.this.ekr.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIv);
                e.jH().postDelayed(PushDialogVideoView.this.gIv, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNN = 50;
        this.mSkinType = 3;
        this.UG = false;
        this.mStartPosition = 0;
        this.hVE = true;
        this.hVF = false;
        this.hVG = false;
        this.currentState = -1;
        this.hEv = false;
        this.cJI = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehx = gVar;
                PushDialogVideoView.this.cAj.bTL();
            }
        };
        this.ehJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQl();
            }
        };
        this.UM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbf.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UG = true;
                    PushDialogVideoView.this.gHM.setVisibility(8);
                    PushDialogVideoView.this.ekr.setVisibility(8);
                    PushDialogVideoView.this.cAj.bTM();
                    PushDialogVideoView.this.gHW.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVL = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHM.setVisibility(0);
                PushDialogVideoView.this.hVf.setVisibility(8);
                PushDialogVideoView.this.hVf.setProgress(PushDialogVideoView.this.hVf.getMax());
                if (PushDialogVideoView.this.dbf == null || PushDialogVideoView.this.dbf.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVi.setVisibility(0);
                }
                y.bTR().remove(PushDialogVideoView.this.bNn);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbf.setRecoveryState(3);
                if (PushDialogVideoView.this.dbf != null && PushDialogVideoView.this.dbf.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNn, PushDialogVideoView.this.ctw);
                }
            }
        };
        this.gIu = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.ekr.setVisibility(0);
                PushDialogVideoView.this.cAj.bTN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbf.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVJ = true;
                }
                PushDialogVideoView.this.hVL = false;
                return true;
            }
        };
        this.gIv = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekr.setVisibility(0);
                PushDialogVideoView.this.cAj.bTN();
            }
        };
        this.cJL = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVF) {
                    e.jH().postDelayed(PushDialogVideoView.this.hVR, 200L);
                }
            }
        };
        this.hVR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbf == null || !PushDialogVideoView.this.hVF) {
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 200L);
                    PushDialogVideoView.this.hVF = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbf.getCurrentPosition()) {
                    PushDialogVideoView.this.hVF = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UM, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hVR, 200L);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UG = false;
                PushDialogVideoView.this.hVL = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UM);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIv);
            }
        };
        this.gIA = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dbf != null && PushDialogVideoView.this.dbf.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbf.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbf.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKv != null) {
                                PushDialogVideoView.this.gKv.ly(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNN - (duration % PushDialogVideoView.this.cNN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKv = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ly(int i2) {
                int duration;
                if (PushDialogVideoView.this.dbf != null && (duration = PushDialogVideoView.this.dbf.getDuration()) > 0 && PushDialogVideoView.this.hVf != null) {
                    PushDialogVideoView.this.hVf.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hVT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSW() {
                PushDialogVideoView.this.cAj.startLoading();
                PushDialogVideoView.this.gHW.setVisibility(0);
                PushDialogVideoView.this.gHV.setVisibility(8);
                PushDialogVideoView.this.hVi.setVisibility(8);
                PushDialogVideoView.this.ekr.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIv);
                e.jH().postDelayed(PushDialogVideoView.this.gIv, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, d.e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dbf = (QuickVideoView) findViewById(d.g.videoView);
        this.cAj = new x((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.cAj.setLoadingAnimationListener(this.ehJ);
        this.hVf = (ProgressBar) findViewById(d.g.pgrBottomProgress);
        this.hVf.setMax(this.mWidth);
        this.hVf.setProgress(0);
        this.gHM = findViewById(d.g.black_mask);
        this.ekr = findViewById(d.g.layout_error);
        this.gHV = (ImageView) findViewById(d.g.img_play);
        this.hVi = (TextView) findViewById(d.g.txt_replay);
        this.dTF = (TextView) findViewById(d.g.push_dialog_video_time);
        this.gHW = (TbImageView) findViewById(d.g.video_thumbnail);
        this.hEG = (PbVideoWifiTipLayout) findViewById(d.g.layout_wifi_tip);
        this.gHW.setDefaultErrorResource(0);
        this.gHW.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.gIr = new CallStateReceiver();
        this.gIr.register(context);
        this.ekr.setOnClickListener(this);
        this.hVi.setOnClickListener(this);
        this.hEG.setOnPlayClickListener(this);
        this.hEG.setFreeClickListener(this);
        setOnClickListener(this);
        this.dbf.setOnPreparedListener(this.cJI);
        this.dbf.setOnCompletionListener(this.cJH);
        this.dbf.setOnErrorListener(this.gIu);
        this.dbf.setOnSeekCompleteListener(this.cJL);
        this.dbf.setOnSurfaceDestroyedListener(this.cAs);
        this.dbf.setOnRecoveryCallback(this.hVT);
        onChangeSkinType();
    }

    public void onPause() {
        if (ql()) {
            this.hEv = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hEv = false;
        } else {
            this.hEv = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hEv) {
            bAH();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gIA);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.idi = fVar;
        this.dTF.setText(ap.hy(this.idi.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bNn = str;
        this.ctw = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dbf.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        if (this.dbf != null && this.ehx != null) {
            if (this.hVL) {
                this.dbf.start();
                this.hVL = false;
            }
            e.jH().removeCallbacks(this.UM);
            e.jH().postDelayed(this.UM, 20L);
            e.jH().removeCallbacks(this.gIv);
            if (this.dbf.bTn()) {
                this.currentState = 1;
                this.dbf.setRecoveryState(1);
            }
            if (this.ehx != null) {
                this.mStartPosition = y.bTR().AS(this.bNn);
                if (this.mStartPosition != 0) {
                    if (this.dbf != null) {
                        this.dbf.xl(this.mStartPosition);
                    } else {
                        this.ehx.seekTo(this.mStartPosition);
                    }
                    if (!this.hVK) {
                        showProgress();
                        e.jH().removeCallbacks(this.UM);
                    }
                    this.hVF = true;
                }
            }
        }
    }

    public void bPd() {
        if (!j.kY()) {
            l.S(getContext(), getContext().getString(d.j.neterror));
        } else if (this.dbf.isPlaying()) {
            pausePlay();
        } else if (this.UG) {
            bAH();
        } else {
            bSK();
        }
    }

    public void setPauseState() {
        this.cAj.bTN();
        this.gHV.setVisibility(0);
        this.hVi.setVisibility(8);
        this.currentState = 2;
        this.dbf.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.hVG) {
            dE(str, str2);
        } else {
            cf(str, str2);
        }
        if (aVar != null) {
            aVar.pa(z);
        }
    }

    public void cf(String str, String str2) {
        bSL();
        this.hVL = true;
        this.currentState = 0;
        this.dbf.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbf.setVideoPath(str, str2);
        this.cAj.startLoading();
        this.gHW.setVisibility(0);
        this.gHV.setVisibility(8);
        this.hVi.setVisibility(8);
        this.ekr.setVisibility(8);
        e.jH().removeCallbacks(this.gIv);
        e.jH().postDelayed(this.gIv, 60000L);
    }

    public void dE(String str, String str2) {
        bSL();
        this.hVL = true;
        this.currentState = 0;
        this.dbf.setRecoveryState(0);
        this.cAj.startLoading();
        this.gHW.setVisibility(0);
        this.gHV.setVisibility(8);
        this.hVi.setVisibility(8);
        this.ekr.setVisibility(8);
        e.jH().removeCallbacks(this.gIv);
        e.jH().postDelayed(this.gIv, 60000L);
    }

    public void bAH() {
        this.currentState = 1;
        this.dbf.setRecoveryState(1);
        this.dbf.start();
        this.gHW.setVisibility(8);
        this.gHM.setVisibility(8);
        this.cAj.bTN();
        showProgress();
        this.gHV.setVisibility(8);
        this.hVi.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kY() && this.hVJ && !StringUtils.isNull(this.bNn) && !StringUtils.isNull(this.ctw)) {
            this.hVJ = false;
            this.hVK = true;
            cf(this.bNn, this.ctw);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbf != null) {
            this.dbf.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dbf.isPlaying() && this.hVE) {
            bSJ();
        }
        this.dbf.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dbf.isPlaying() && this.hVE) {
            bSJ();
        }
        this.currentState = 5;
        this.dbf.setRecoveryState(5);
        e.jH().removeCallbacks(this.UM);
        e.jH().removeCallbacks(this.gIv);
        this.dbf.stopPlayback();
        this.UG = false;
        this.hVL = false;
        this.mStartPosition = 0;
        bnN();
    }

    public void bSJ() {
        y.bTR().bj(this.bNn, this.dbf.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        this.gHM.setVisibility(0);
        this.gHV.setVisibility(0);
        this.hVi.setVisibility(8);
        this.cAj.bTN();
        this.hVf.setVisibility(8);
        this.ekr.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gHW.setVisibility(z ? 0 : 8);
    }

    public void bnN() {
        oU(true);
    }

    public boolean ql() {
        if (this.dbf == null) {
            return false;
        }
        return this.dbf.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dbf == null) {
            return 0;
        }
        return this.dbf.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dbf != null) {
            this.hVf.setVisibility(0);
            this.cNN = ((this.dbf.getDuration() / 200) / 50) * 50;
            if (this.cNN < 50) {
                this.cNN = 50;
            } else if (this.cNN > 500) {
                this.cNN = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNN - (this.dbf.getCurrentPosition() % this.cNN));
        }
    }

    private void bSK() {
        a(this.bNn, this.ctw, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bSL();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.hVG = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.la() && !this.hEP && !com.baidu.tieba.video.g.ciN().ciO()) {
            this.hEG.setVisibility(0);
            this.hEG.setData(this.idi.getDuration(), this.idi.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bSL() {
        if (j.la()) {
            com.baidu.tieba.video.g.ciN().ex(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gHW.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekr) {
            bSK();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 2).bJ("tid", this.ctw));
            bPd();
        } else if (view == this.hVi) {
            cf(this.bNn, this.ctw);
        } else if (view == this.hEG.getTvPlay()) {
            this.hEP = true;
            this.hEG.setVisibility(8);
            cf(this.bNn, this.ctw);
        } else if (view == this.hEG.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.jH().removeCallbacks(this.gIv);
        e.jH().removeCallbacks(this.hVR);
        this.mHandler.removeMessages(1);
        this.gIr.unregister(getContext());
    }
}
