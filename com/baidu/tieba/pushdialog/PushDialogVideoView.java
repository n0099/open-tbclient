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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.e;
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
    private String aFr;
    private int bCH;
    private QuickVideoView bPc;
    private String bjn;
    private x bpJ;
    private QuickVideoView.b bpS;
    private g.a byA;
    private g.f byB;
    private g.InterfaceC0298g byE;
    private TextView cGO;
    private g cYa;
    private VideoLoadingProgressView.a cYm;
    private int currentState;
    private ImageView daS;
    private View daW;
    private View frX;
    private CallStateReceiver fsC;
    private Runnable fsF;
    private g.b fsG;
    private Runnable fsH;
    private CustomMessageListener fsM;
    private TbImageView fsg;
    private boolean fsl;
    private VideoControllerView.b fuH;
    private boolean gFS;
    private boolean gFT;
    private boolean gFU;
    private boolean gFX;
    private boolean gFY;
    private boolean gFZ;
    private ProgressBar gFu;
    private TextView gFx;
    private Runnable gGe;
    private QuickVideoView.a gGg;
    private f gMa;
    private boolean goE;
    private PbVideoWifiTipLayout goP;
    private boolean goY;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void mC(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.bCH = 50;
        this.mSkinType = 3;
        this.fsl = false;
        this.mStartPosition = 0;
        this.gFS = true;
        this.gFT = false;
        this.gFU = false;
        this.currentState = -1;
        this.goE = false;
        this.byB = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cYa = gVar;
                PushDialogVideoView.this.bpJ.btr();
            }
        };
        this.cYm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqx();
            }
        };
        this.fsF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPc.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fsl = true;
                    PushDialogVideoView.this.frX.setVisibility(8);
                    PushDialogVideoView.this.daW.setVisibility(8);
                    PushDialogVideoView.this.bpJ.bts();
                    PushDialogVideoView.this.fsg.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fsF, 20L);
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fsl = false;
                PushDialogVideoView.this.gFZ = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frX.setVisibility(0);
                PushDialogVideoView.this.gFu.setVisibility(8);
                PushDialogVideoView.this.gFu.setProgress(PushDialogVideoView.this.gFu.getMax());
                if (PushDialogVideoView.this.bPc == null || PushDialogVideoView.this.bPc.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gFx.setVisibility(0);
                }
                y.btx().remove(PushDialogVideoView.this.aFr);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bPc.setRecoveryState(3);
                if (PushDialogVideoView.this.bPc != null && PushDialogVideoView.this.bPc.getDuration() <= 150000) {
                    PushDialogVideoView.this.ba(PushDialogVideoView.this.aFr, PushDialogVideoView.this.bjn);
                }
            }
        };
        this.fsG = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.daW.setVisibility(0);
                PushDialogVideoView.this.bpJ.btt();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bPc.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gFX = true;
                }
                PushDialogVideoView.this.gFZ = false;
                return true;
            }
        };
        this.fsH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.daW.setVisibility(0);
                PushDialogVideoView.this.bpJ.btt();
            }
        };
        this.byE = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gFT) {
                    e.jG().postDelayed(PushDialogVideoView.this.gGe, 200L);
                }
            }
        };
        this.gGe = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPc == null || !PushDialogVideoView.this.gFT) {
                    e.jG().postDelayed(PushDialogVideoView.this.fsF, 200L);
                    PushDialogVideoView.this.gFT = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bPc.getCurrentPosition()) {
                    PushDialogVideoView.this.gFT = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fsF, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gGe, 200L);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fsl = false;
                PushDialogVideoView.this.gFZ = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fsF);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsH);
            }
        };
        this.fsM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bPc != null && PushDialogVideoView.this.bPc.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bPc.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bPc.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fuH != null) {
                                PushDialogVideoView.this.fuH.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bCH - (duration % PushDialogVideoView.this.bCH));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fuH = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i) {
                int duration;
                if (PushDialogVideoView.this.bPc != null && (duration = PushDialogVideoView.this.bPc.getDuration()) > 0 && PushDialogVideoView.this.gFu != null) {
                    PushDialogVideoView.this.gFu.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gGg = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bsD() {
                PushDialogVideoView.this.bpJ.startLoading();
                PushDialogVideoView.this.fsg.setVisibility(0);
                PushDialogVideoView.this.daS.setVisibility(8);
                PushDialogVideoView.this.gFx.setVisibility(8);
                PushDialogVideoView.this.daW.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsH);
                e.jG().postDelayed(PushDialogVideoView.this.fsH, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCH = 50;
        this.mSkinType = 3;
        this.fsl = false;
        this.mStartPosition = 0;
        this.gFS = true;
        this.gFT = false;
        this.gFU = false;
        this.currentState = -1;
        this.goE = false;
        this.byB = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cYa = gVar;
                PushDialogVideoView.this.bpJ.btr();
            }
        };
        this.cYm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqx();
            }
        };
        this.fsF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPc.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fsl = true;
                    PushDialogVideoView.this.frX.setVisibility(8);
                    PushDialogVideoView.this.daW.setVisibility(8);
                    PushDialogVideoView.this.bpJ.bts();
                    PushDialogVideoView.this.fsg.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fsF, 20L);
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fsl = false;
                PushDialogVideoView.this.gFZ = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frX.setVisibility(0);
                PushDialogVideoView.this.gFu.setVisibility(8);
                PushDialogVideoView.this.gFu.setProgress(PushDialogVideoView.this.gFu.getMax());
                if (PushDialogVideoView.this.bPc == null || PushDialogVideoView.this.bPc.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gFx.setVisibility(0);
                }
                y.btx().remove(PushDialogVideoView.this.aFr);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bPc.setRecoveryState(3);
                if (PushDialogVideoView.this.bPc != null && PushDialogVideoView.this.bPc.getDuration() <= 150000) {
                    PushDialogVideoView.this.ba(PushDialogVideoView.this.aFr, PushDialogVideoView.this.bjn);
                }
            }
        };
        this.fsG = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.daW.setVisibility(0);
                PushDialogVideoView.this.bpJ.btt();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bPc.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gFX = true;
                }
                PushDialogVideoView.this.gFZ = false;
                return true;
            }
        };
        this.fsH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.daW.setVisibility(0);
                PushDialogVideoView.this.bpJ.btt();
            }
        };
        this.byE = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gFT) {
                    e.jG().postDelayed(PushDialogVideoView.this.gGe, 200L);
                }
            }
        };
        this.gGe = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPc == null || !PushDialogVideoView.this.gFT) {
                    e.jG().postDelayed(PushDialogVideoView.this.fsF, 200L);
                    PushDialogVideoView.this.gFT = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bPc.getCurrentPosition()) {
                    PushDialogVideoView.this.gFT = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fsF, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gGe, 200L);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fsl = false;
                PushDialogVideoView.this.gFZ = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fsF);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsH);
            }
        };
        this.fsM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bPc != null && PushDialogVideoView.this.bPc.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bPc.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bPc.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fuH != null) {
                                PushDialogVideoView.this.fuH.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bCH - (duration % PushDialogVideoView.this.bCH));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fuH = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i) {
                int duration;
                if (PushDialogVideoView.this.bPc != null && (duration = PushDialogVideoView.this.bPc.getDuration()) > 0 && PushDialogVideoView.this.gFu != null) {
                    PushDialogVideoView.this.gFu.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gGg = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bsD() {
                PushDialogVideoView.this.bpJ.startLoading();
                PushDialogVideoView.this.fsg.setVisibility(0);
                PushDialogVideoView.this.daS.setVisibility(8);
                PushDialogVideoView.this.gFx.setVisibility(8);
                PushDialogVideoView.this.daW.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsH);
                e.jG().postDelayed(PushDialogVideoView.this.fsH, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCH = 50;
        this.mSkinType = 3;
        this.fsl = false;
        this.mStartPosition = 0;
        this.gFS = true;
        this.gFT = false;
        this.gFU = false;
        this.currentState = -1;
        this.goE = false;
        this.byB = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cYa = gVar;
                PushDialogVideoView.this.bpJ.btr();
            }
        };
        this.cYm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqx();
            }
        };
        this.fsF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPc.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fsl = true;
                    PushDialogVideoView.this.frX.setVisibility(8);
                    PushDialogVideoView.this.daW.setVisibility(8);
                    PushDialogVideoView.this.bpJ.bts();
                    PushDialogVideoView.this.fsg.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fsF, 20L);
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fsl = false;
                PushDialogVideoView.this.gFZ = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frX.setVisibility(0);
                PushDialogVideoView.this.gFu.setVisibility(8);
                PushDialogVideoView.this.gFu.setProgress(PushDialogVideoView.this.gFu.getMax());
                if (PushDialogVideoView.this.bPc == null || PushDialogVideoView.this.bPc.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gFx.setVisibility(0);
                }
                y.btx().remove(PushDialogVideoView.this.aFr);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bPc.setRecoveryState(3);
                if (PushDialogVideoView.this.bPc != null && PushDialogVideoView.this.bPc.getDuration() <= 150000) {
                    PushDialogVideoView.this.ba(PushDialogVideoView.this.aFr, PushDialogVideoView.this.bjn);
                }
            }
        };
        this.fsG = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.daW.setVisibility(0);
                PushDialogVideoView.this.bpJ.btt();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bPc.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gFX = true;
                }
                PushDialogVideoView.this.gFZ = false;
                return true;
            }
        };
        this.fsH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.daW.setVisibility(0);
                PushDialogVideoView.this.bpJ.btt();
            }
        };
        this.byE = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gFT) {
                    e.jG().postDelayed(PushDialogVideoView.this.gGe, 200L);
                }
            }
        };
        this.gGe = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPc == null || !PushDialogVideoView.this.gFT) {
                    e.jG().postDelayed(PushDialogVideoView.this.fsF, 200L);
                    PushDialogVideoView.this.gFT = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bPc.getCurrentPosition()) {
                    PushDialogVideoView.this.gFT = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fsF, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gGe, 200L);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fsl = false;
                PushDialogVideoView.this.gFZ = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fsF);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsH);
            }
        };
        this.fsM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bPc != null && PushDialogVideoView.this.bPc.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bPc.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bPc.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fuH != null) {
                                PushDialogVideoView.this.fuH.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bCH - (duration % PushDialogVideoView.this.bCH));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fuH = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i2) {
                int duration;
                if (PushDialogVideoView.this.bPc != null && (duration = PushDialogVideoView.this.bPc.getDuration()) > 0 && PushDialogVideoView.this.gFu != null) {
                    PushDialogVideoView.this.gFu.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gGg = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bsD() {
                PushDialogVideoView.this.bpJ.startLoading();
                PushDialogVideoView.this.fsg.setVisibility(0);
                PushDialogVideoView.this.daS.setVisibility(8);
                PushDialogVideoView.this.gFx.setVisibility(8);
                PushDialogVideoView.this.daW.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsH);
                e.jG().postDelayed(PushDialogVideoView.this.fsH, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0210e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bPc = (QuickVideoView) findViewById(e.g.videoView);
        this.bpJ = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bpJ.setLoadingAnimationListener(this.cYm);
        this.gFu = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.gFu.setMax(this.mWidth);
        this.gFu.setProgress(0);
        this.frX = findViewById(e.g.black_mask);
        this.daW = findViewById(e.g.layout_error);
        this.daS = (ImageView) findViewById(e.g.img_play);
        this.gFx = (TextView) findViewById(e.g.txt_replay);
        this.cGO = (TextView) findViewById(e.g.push_dialog_video_time);
        this.fsg = (TbImageView) findViewById(e.g.video_thumbnail);
        this.goP = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.fsg.setDefaultErrorResource(0);
        this.fsg.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.fsC = new CallStateReceiver();
        this.fsC.register(context);
        this.daW.setOnClickListener(this);
        this.gFx.setOnClickListener(this);
        this.goP.setOnPlayClickListener(this);
        this.goP.setFreeClickListener(this);
        setOnClickListener(this);
        this.bPc.setOnPreparedListener(this.byB);
        this.bPc.setOnCompletionListener(this.byA);
        this.bPc.setOnErrorListener(this.fsG);
        this.bPc.setOnSeekCompleteListener(this.byE);
        this.bPc.setOnSurfaceDestroyedListener(this.bpS);
        this.bPc.setOnRecoveryCallback(this.gGg);
        onChangeSkinType();
    }

    public void onPause() {
        if (bsq()) {
            this.goE = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.goE = false;
        } else {
            this.goE = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.goE) {
            bag();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.fsM);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gMa = fVar;
        this.cGO.setText(ao.dV(this.gMa.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.aFr = str;
        this.bjn = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bPc.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        if (this.bPc != null && this.cYa != null) {
            if (this.gFZ) {
                this.bPc.start();
                this.gFZ = false;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fsF, 20L);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
            if (this.bPc.bsT()) {
                this.currentState = 1;
                this.bPc.setRecoveryState(1);
            }
            if (this.cYa != null) {
                this.mStartPosition = y.btx().up(this.aFr);
                if (this.mStartPosition != 0) {
                    if (this.bPc != null) {
                        this.bPc.tF(this.mStartPosition);
                    } else {
                        this.cYa.seekTo(this.mStartPosition);
                    }
                    if (!this.gFY) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
                    }
                    this.gFT = true;
                }
            }
        }
    }

    public void boH() {
        if (!j.kV()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bPc.isPlaying()) {
            pausePlay();
        } else if (this.fsl) {
            bag();
        } else {
            bsr();
        }
    }

    public void setPauseState() {
        this.bpJ.btt();
        this.daS.setVisibility(0);
        this.gFx.setVisibility(8);
        this.currentState = 2;
        this.bPc.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gFU) {
            ct(str, str2);
        } else {
            ba(str, str2);
        }
        if (aVar != null) {
            aVar.mC(z);
        }
    }

    public void ba(String str, String str2) {
        bss();
        this.gFZ = true;
        this.currentState = 0;
        this.bPc.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bPc.setVideoPath(str, str2);
        this.bpJ.startLoading();
        this.fsg.setVisibility(0);
        this.daS.setVisibility(8);
        this.gFx.setVisibility(8);
        this.daW.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fsH, 60000L);
    }

    public void ct(String str, String str2) {
        bss();
        this.gFZ = true;
        this.currentState = 0;
        this.bPc.setRecoveryState(0);
        this.bpJ.startLoading();
        this.fsg.setVisibility(0);
        this.daS.setVisibility(8);
        this.gFx.setVisibility(8);
        this.daW.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fsH, 60000L);
    }

    public void bag() {
        this.currentState = 1;
        this.bPc.setRecoveryState(1);
        this.bPc.start();
        this.fsg.setVisibility(8);
        this.frX.setVisibility(8);
        this.bpJ.btt();
        showProgress();
        this.daS.setVisibility(8);
        this.gFx.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kV() && this.gFX && !StringUtils.isNull(this.aFr) && !StringUtils.isNull(this.bjn)) {
            this.gFX = false;
            this.gFY = true;
            ba(this.aFr, this.bjn);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bPc != null) {
            this.bPc.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bPc.isPlaying() && this.gFS) {
            bsp();
        }
        this.bPc.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bPc.isPlaying() && this.gFS) {
            bsp();
        }
        this.currentState = 5;
        this.bPc.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        this.bPc.stopPlayback();
        this.fsl = false;
        this.gFZ = false;
        this.mStartPosition = 0;
        aNk();
    }

    public void bsp() {
        y.btx().aO(this.aFr, this.bPc.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        this.frX.setVisibility(0);
        this.daS.setVisibility(0);
        this.gFx.setVisibility(8);
        this.bpJ.btt();
        this.gFu.setVisibility(8);
        this.daW.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.fsg.setVisibility(z ? 0 : 8);
    }

    public void aNk() {
        mw(true);
    }

    public boolean bsq() {
        if (this.bPc == null) {
            return false;
        }
        return this.bPc.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bPc == null) {
            return 0;
        }
        return this.bPc.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bPc != null) {
            this.gFu.setVisibility(0);
            this.bCH = ((this.bPc.getDuration() / 200) / 50) * 50;
            if (this.bCH < 50) {
                this.bCH = 50;
            } else if (this.bCH > 500) {
                this.bCH = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bCH - (this.bPc.getCurrentPosition() % this.bCH));
        }
    }

    private void bsr() {
        a(this.aFr, this.bjn, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bss();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gFU = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kX() && !this.goY && !com.baidu.tieba.video.g.bJp().bJq()) {
            this.goP.setVisibility(0);
            this.goP.setData(this.gMa.getDuration(), this.gMa.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bss() {
        if (j.kX()) {
            com.baidu.tieba.video.g.bJp().dc(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.fsg.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.daW) {
            bsr();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").y("obj_locate", 2).aB("tid", this.bjn));
            boH();
        } else if (view == this.gFx) {
            ba(this.aFr, this.bjn);
        } else if (view == this.goP.getTvPlay()) {
            this.goY = true;
            this.goP.setVisibility(8);
            ba(this.aFr, this.bjn);
        } else if (view == this.goP.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGe);
        this.mHandler.removeMessages(1);
        this.fsC.unregister(getContext());
    }
}
