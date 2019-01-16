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
    private String aFq;
    private int bCG;
    private QuickVideoView bPb;
    private String bjm;
    private x bpI;
    private QuickVideoView.b bpR;
    private g.f byA;
    private g.InterfaceC0298g byD;
    private g.a byz;
    private TextView cGN;
    private g cXZ;
    private VideoLoadingProgressView.a cYl;
    private int currentState;
    private ImageView daR;
    private View daV;
    private View frW;
    private CallStateReceiver fsB;
    private Runnable fsE;
    private g.b fsF;
    private Runnable fsG;
    private CustomMessageListener fsL;
    private TbImageView fsf;
    private boolean fsk;
    private VideoControllerView.b fuG;
    private boolean gFR;
    private boolean gFS;
    private boolean gFT;
    private boolean gFW;
    private boolean gFX;
    private boolean gFY;
    private ProgressBar gFt;
    private TextView gFw;
    private Runnable gGd;
    private QuickVideoView.a gGf;
    private f gLZ;
    private boolean goD;
    private PbVideoWifiTipLayout goO;
    private boolean goX;
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
        this.bCG = 50;
        this.mSkinType = 3;
        this.fsk = false;
        this.mStartPosition = 0;
        this.gFR = true;
        this.gFS = false;
        this.gFT = false;
        this.currentState = -1;
        this.goD = false;
        this.byA = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cXZ = gVar;
                PushDialogVideoView.this.bpI.btr();
            }
        };
        this.cYl = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqx();
            }
        };
        this.fsE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPb.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fsk = true;
                    PushDialogVideoView.this.frW.setVisibility(8);
                    PushDialogVideoView.this.daV.setVisibility(8);
                    PushDialogVideoView.this.bpI.bts();
                    PushDialogVideoView.this.fsf.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fsE, 20L);
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fsk = false;
                PushDialogVideoView.this.gFY = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frW.setVisibility(0);
                PushDialogVideoView.this.gFt.setVisibility(8);
                PushDialogVideoView.this.gFt.setProgress(PushDialogVideoView.this.gFt.getMax());
                if (PushDialogVideoView.this.bPb == null || PushDialogVideoView.this.bPb.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gFw.setVisibility(0);
                }
                y.btx().remove(PushDialogVideoView.this.aFq);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bPb.setRecoveryState(3);
                if (PushDialogVideoView.this.bPb != null && PushDialogVideoView.this.bPb.getDuration() <= 150000) {
                    PushDialogVideoView.this.ba(PushDialogVideoView.this.aFq, PushDialogVideoView.this.bjm);
                }
            }
        };
        this.fsF = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.daV.setVisibility(0);
                PushDialogVideoView.this.bpI.btt();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bPb.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gFW = true;
                }
                PushDialogVideoView.this.gFY = false;
                return true;
            }
        };
        this.fsG = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.daV.setVisibility(0);
                PushDialogVideoView.this.bpI.btt();
            }
        };
        this.byD = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gFS) {
                    e.jG().postDelayed(PushDialogVideoView.this.gGd, 200L);
                }
            }
        };
        this.gGd = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPb == null || !PushDialogVideoView.this.gFS) {
                    e.jG().postDelayed(PushDialogVideoView.this.fsE, 200L);
                    PushDialogVideoView.this.gFS = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bPb.getCurrentPosition()) {
                    PushDialogVideoView.this.gFS = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fsE, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gGd, 200L);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fsk = false;
                PushDialogVideoView.this.gFY = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fsE);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsG);
            }
        };
        this.fsL = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bPb != null && PushDialogVideoView.this.bPb.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bPb.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bPb.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fuG != null) {
                                PushDialogVideoView.this.fuG.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bCG - (duration % PushDialogVideoView.this.bCG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fuG = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i) {
                int duration;
                if (PushDialogVideoView.this.bPb != null && (duration = PushDialogVideoView.this.bPb.getDuration()) > 0 && PushDialogVideoView.this.gFt != null) {
                    PushDialogVideoView.this.gFt.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gGf = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bsD() {
                PushDialogVideoView.this.bpI.startLoading();
                PushDialogVideoView.this.fsf.setVisibility(0);
                PushDialogVideoView.this.daR.setVisibility(8);
                PushDialogVideoView.this.gFw.setVisibility(8);
                PushDialogVideoView.this.daV.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsG);
                e.jG().postDelayed(PushDialogVideoView.this.fsG, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCG = 50;
        this.mSkinType = 3;
        this.fsk = false;
        this.mStartPosition = 0;
        this.gFR = true;
        this.gFS = false;
        this.gFT = false;
        this.currentState = -1;
        this.goD = false;
        this.byA = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cXZ = gVar;
                PushDialogVideoView.this.bpI.btr();
            }
        };
        this.cYl = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqx();
            }
        };
        this.fsE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPb.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fsk = true;
                    PushDialogVideoView.this.frW.setVisibility(8);
                    PushDialogVideoView.this.daV.setVisibility(8);
                    PushDialogVideoView.this.bpI.bts();
                    PushDialogVideoView.this.fsf.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fsE, 20L);
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fsk = false;
                PushDialogVideoView.this.gFY = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frW.setVisibility(0);
                PushDialogVideoView.this.gFt.setVisibility(8);
                PushDialogVideoView.this.gFt.setProgress(PushDialogVideoView.this.gFt.getMax());
                if (PushDialogVideoView.this.bPb == null || PushDialogVideoView.this.bPb.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gFw.setVisibility(0);
                }
                y.btx().remove(PushDialogVideoView.this.aFq);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bPb.setRecoveryState(3);
                if (PushDialogVideoView.this.bPb != null && PushDialogVideoView.this.bPb.getDuration() <= 150000) {
                    PushDialogVideoView.this.ba(PushDialogVideoView.this.aFq, PushDialogVideoView.this.bjm);
                }
            }
        };
        this.fsF = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.daV.setVisibility(0);
                PushDialogVideoView.this.bpI.btt();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bPb.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gFW = true;
                }
                PushDialogVideoView.this.gFY = false;
                return true;
            }
        };
        this.fsG = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.daV.setVisibility(0);
                PushDialogVideoView.this.bpI.btt();
            }
        };
        this.byD = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gFS) {
                    e.jG().postDelayed(PushDialogVideoView.this.gGd, 200L);
                }
            }
        };
        this.gGd = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPb == null || !PushDialogVideoView.this.gFS) {
                    e.jG().postDelayed(PushDialogVideoView.this.fsE, 200L);
                    PushDialogVideoView.this.gFS = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bPb.getCurrentPosition()) {
                    PushDialogVideoView.this.gFS = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fsE, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gGd, 200L);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fsk = false;
                PushDialogVideoView.this.gFY = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fsE);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsG);
            }
        };
        this.fsL = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bPb != null && PushDialogVideoView.this.bPb.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bPb.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bPb.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fuG != null) {
                                PushDialogVideoView.this.fuG.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bCG - (duration % PushDialogVideoView.this.bCG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fuG = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i) {
                int duration;
                if (PushDialogVideoView.this.bPb != null && (duration = PushDialogVideoView.this.bPb.getDuration()) > 0 && PushDialogVideoView.this.gFt != null) {
                    PushDialogVideoView.this.gFt.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gGf = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bsD() {
                PushDialogVideoView.this.bpI.startLoading();
                PushDialogVideoView.this.fsf.setVisibility(0);
                PushDialogVideoView.this.daR.setVisibility(8);
                PushDialogVideoView.this.gFw.setVisibility(8);
                PushDialogVideoView.this.daV.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsG);
                e.jG().postDelayed(PushDialogVideoView.this.fsG, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCG = 50;
        this.mSkinType = 3;
        this.fsk = false;
        this.mStartPosition = 0;
        this.gFR = true;
        this.gFS = false;
        this.gFT = false;
        this.currentState = -1;
        this.goD = false;
        this.byA = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cXZ = gVar;
                PushDialogVideoView.this.bpI.btr();
            }
        };
        this.cYl = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqx();
            }
        };
        this.fsE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPb.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fsk = true;
                    PushDialogVideoView.this.frW.setVisibility(8);
                    PushDialogVideoView.this.daV.setVisibility(8);
                    PushDialogVideoView.this.bpI.bts();
                    PushDialogVideoView.this.fsf.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fsE, 20L);
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fsk = false;
                PushDialogVideoView.this.gFY = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frW.setVisibility(0);
                PushDialogVideoView.this.gFt.setVisibility(8);
                PushDialogVideoView.this.gFt.setProgress(PushDialogVideoView.this.gFt.getMax());
                if (PushDialogVideoView.this.bPb == null || PushDialogVideoView.this.bPb.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gFw.setVisibility(0);
                }
                y.btx().remove(PushDialogVideoView.this.aFq);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bPb.setRecoveryState(3);
                if (PushDialogVideoView.this.bPb != null && PushDialogVideoView.this.bPb.getDuration() <= 150000) {
                    PushDialogVideoView.this.ba(PushDialogVideoView.this.aFq, PushDialogVideoView.this.bjm);
                }
            }
        };
        this.fsF = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.daV.setVisibility(0);
                PushDialogVideoView.this.bpI.btt();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bPb.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gFW = true;
                }
                PushDialogVideoView.this.gFY = false;
                return true;
            }
        };
        this.fsG = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.daV.setVisibility(0);
                PushDialogVideoView.this.bpI.btt();
            }
        };
        this.byD = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gFS) {
                    e.jG().postDelayed(PushDialogVideoView.this.gGd, 200L);
                }
            }
        };
        this.gGd = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bPb == null || !PushDialogVideoView.this.gFS) {
                    e.jG().postDelayed(PushDialogVideoView.this.fsE, 200L);
                    PushDialogVideoView.this.gFS = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bPb.getCurrentPosition()) {
                    PushDialogVideoView.this.gFS = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fsE, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gGd, 200L);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fsk = false;
                PushDialogVideoView.this.gFY = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fsE);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsG);
            }
        };
        this.fsL = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bPb != null && PushDialogVideoView.this.bPb.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bPb.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bPb.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fuG != null) {
                                PushDialogVideoView.this.fuG.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bCG - (duration % PushDialogVideoView.this.bCG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fuG = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i2) {
                int duration;
                if (PushDialogVideoView.this.bPb != null && (duration = PushDialogVideoView.this.bPb.getDuration()) > 0 && PushDialogVideoView.this.gFt != null) {
                    PushDialogVideoView.this.gFt.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gGf = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bsD() {
                PushDialogVideoView.this.bpI.startLoading();
                PushDialogVideoView.this.fsf.setVisibility(0);
                PushDialogVideoView.this.daR.setVisibility(8);
                PushDialogVideoView.this.gFw.setVisibility(8);
                PushDialogVideoView.this.daV.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fsG);
                e.jG().postDelayed(PushDialogVideoView.this.fsG, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0210e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bPb = (QuickVideoView) findViewById(e.g.videoView);
        this.bpI = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bpI.setLoadingAnimationListener(this.cYl);
        this.gFt = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.gFt.setMax(this.mWidth);
        this.gFt.setProgress(0);
        this.frW = findViewById(e.g.black_mask);
        this.daV = findViewById(e.g.layout_error);
        this.daR = (ImageView) findViewById(e.g.img_play);
        this.gFw = (TextView) findViewById(e.g.txt_replay);
        this.cGN = (TextView) findViewById(e.g.push_dialog_video_time);
        this.fsf = (TbImageView) findViewById(e.g.video_thumbnail);
        this.goO = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.fsf.setDefaultErrorResource(0);
        this.fsf.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.fsB = new CallStateReceiver();
        this.fsB.register(context);
        this.daV.setOnClickListener(this);
        this.gFw.setOnClickListener(this);
        this.goO.setOnPlayClickListener(this);
        this.goO.setFreeClickListener(this);
        setOnClickListener(this);
        this.bPb.setOnPreparedListener(this.byA);
        this.bPb.setOnCompletionListener(this.byz);
        this.bPb.setOnErrorListener(this.fsF);
        this.bPb.setOnSeekCompleteListener(this.byD);
        this.bPb.setOnSurfaceDestroyedListener(this.bpR);
        this.bPb.setOnRecoveryCallback(this.gGf);
        onChangeSkinType();
    }

    public void onPause() {
        if (bsq()) {
            this.goD = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.goD = false;
        } else {
            this.goD = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.goD) {
            bag();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.fsL);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gLZ = fVar;
        this.cGN.setText(ao.dV(this.gLZ.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.aFq = str;
        this.bjm = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bPb.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        if (this.bPb != null && this.cXZ != null) {
            if (this.gFY) {
                this.bPb.start();
                this.gFY = false;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fsE, 20L);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
            if (this.bPb.bsT()) {
                this.currentState = 1;
                this.bPb.setRecoveryState(1);
            }
            if (this.cXZ != null) {
                this.mStartPosition = y.btx().up(this.aFq);
                if (this.mStartPosition != 0) {
                    if (this.bPb != null) {
                        this.bPb.tF(this.mStartPosition);
                    } else {
                        this.cXZ.seekTo(this.mStartPosition);
                    }
                    if (!this.gFX) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
                    }
                    this.gFS = true;
                }
            }
        }
    }

    public void boH() {
        if (!j.kV()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bPb.isPlaying()) {
            pausePlay();
        } else if (this.fsk) {
            bag();
        } else {
            bsr();
        }
    }

    public void setPauseState() {
        this.bpI.btt();
        this.daR.setVisibility(0);
        this.gFw.setVisibility(8);
        this.currentState = 2;
        this.bPb.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gFT) {
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
        this.gFY = true;
        this.currentState = 0;
        this.bPb.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bPb.setVideoPath(str, str2);
        this.bpI.startLoading();
        this.fsf.setVisibility(0);
        this.daR.setVisibility(8);
        this.gFw.setVisibility(8);
        this.daV.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fsG, 60000L);
    }

    public void ct(String str, String str2) {
        bss();
        this.gFY = true;
        this.currentState = 0;
        this.bPb.setRecoveryState(0);
        this.bpI.startLoading();
        this.fsf.setVisibility(0);
        this.daR.setVisibility(8);
        this.gFw.setVisibility(8);
        this.daV.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fsG, 60000L);
    }

    public void bag() {
        this.currentState = 1;
        this.bPb.setRecoveryState(1);
        this.bPb.start();
        this.fsf.setVisibility(8);
        this.frW.setVisibility(8);
        this.bpI.btt();
        showProgress();
        this.daR.setVisibility(8);
        this.gFw.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kV() && this.gFW && !StringUtils.isNull(this.aFq) && !StringUtils.isNull(this.bjm)) {
            this.gFW = false;
            this.gFX = true;
            ba(this.aFq, this.bjm);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bPb != null) {
            this.bPb.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bPb.isPlaying() && this.gFR) {
            bsp();
        }
        this.bPb.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bPb.isPlaying() && this.gFR) {
            bsp();
        }
        this.currentState = 5;
        this.bPb.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        this.bPb.stopPlayback();
        this.fsk = false;
        this.gFY = false;
        this.mStartPosition = 0;
        aNk();
    }

    public void bsp() {
        y.btx().aO(this.aFq, this.bPb.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        this.frW.setVisibility(0);
        this.daR.setVisibility(0);
        this.gFw.setVisibility(8);
        this.bpI.btt();
        this.gFt.setVisibility(8);
        this.daV.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.fsf.setVisibility(z ? 0 : 8);
    }

    public void aNk() {
        mw(true);
    }

    public boolean bsq() {
        if (this.bPb == null) {
            return false;
        }
        return this.bPb.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bPb == null) {
            return 0;
        }
        return this.bPb.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bPb != null) {
            this.gFt.setVisibility(0);
            this.bCG = ((this.bPb.getDuration() / 200) / 50) * 50;
            if (this.bCG < 50) {
                this.bCG = 50;
            } else if (this.bCG > 500) {
                this.bCG = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bCG - (this.bPb.getCurrentPosition() % this.bCG));
        }
    }

    private void bsr() {
        a(this.aFq, this.bjm, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bss();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gFT = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kX() && !this.goX && !com.baidu.tieba.video.g.bJp().bJq()) {
            this.goO.setVisibility(0);
            this.goO.setData(this.gLZ.getDuration(), this.gLZ.getFileSize());
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
        this.fsf.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.daV) {
            bsr();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").y("obj_locate", 2).aB("tid", this.bjm));
            boH();
        } else if (view == this.gFw) {
            ba(this.aFq, this.bjm);
        } else if (view == this.goO.getTvPlay()) {
            this.goX = true;
            this.goO.setVisibility(8);
            ba(this.aFq, this.bjm);
        } else if (view == this.goO.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGd);
        this.mHandler.removeMessages(1);
        this.fsB.unregister(getContext());
    }
}
