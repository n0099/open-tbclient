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
    private String aEO;
    private int bBT;
    private QuickVideoView bOq;
    private String biz;
    private x boU;
    private QuickVideoView.b bpd;
    private g.a bxL;
    private g.f bxM;
    private g.InterfaceC0298g bxP;
    private TextView cGc;
    private VideoLoadingProgressView.a cXA;
    private g cXo;
    private int currentState;
    private ImageView dae;
    private View dai;
    private CallStateReceiver frH;
    private Runnable frK;
    private g.b frL;
    private Runnable frM;
    private CustomMessageListener frR;
    private View frb;
    private TbImageView frk;
    private boolean frp;
    private VideoControllerView.b ftM;
    private boolean gEN;
    private boolean gEO;
    private boolean gEP;
    private boolean gES;
    private boolean gET;
    private boolean gEU;
    private Runnable gEZ;
    private ProgressBar gEp;
    private TextView gEs;
    private QuickVideoView.a gFb;
    private f gKV;
    private boolean gnA;
    private PbVideoWifiTipLayout gnL;
    private boolean gnT;
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
        this.bBT = 50;
        this.mSkinType = 3;
        this.frp = false;
        this.mStartPosition = 0;
        this.gEN = true;
        this.gEO = false;
        this.gEP = false;
        this.currentState = -1;
        this.gnA = false;
        this.bxM = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cXo = gVar;
                PushDialogVideoView.this.boU.bsI();
            }
        };
        this.cXA = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqa();
            }
        };
        this.frK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOq.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.frp = true;
                    PushDialogVideoView.this.frb.setVisibility(8);
                    PushDialogVideoView.this.dai.setVisibility(8);
                    PushDialogVideoView.this.boU.bsJ();
                    PushDialogVideoView.this.frk.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.frK, 20L);
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.frp = false;
                PushDialogVideoView.this.gEU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frb.setVisibility(0);
                PushDialogVideoView.this.gEp.setVisibility(8);
                PushDialogVideoView.this.gEp.setProgress(PushDialogVideoView.this.gEp.getMax());
                if (PushDialogVideoView.this.bOq == null || PushDialogVideoView.this.bOq.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gEs.setVisibility(0);
                }
                y.bsO().remove(PushDialogVideoView.this.aEO);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bOq.setRecoveryState(3);
                if (PushDialogVideoView.this.bOq != null && PushDialogVideoView.this.bOq.getDuration() <= 150000) {
                    PushDialogVideoView.this.aZ(PushDialogVideoView.this.aEO, PushDialogVideoView.this.biz);
                }
            }
        };
        this.frL = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.dai.setVisibility(0);
                PushDialogVideoView.this.boU.bsK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bOq.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gES = true;
                }
                PushDialogVideoView.this.gEU = false;
                return true;
            }
        };
        this.frM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.dai.setVisibility(0);
                PushDialogVideoView.this.boU.bsK();
            }
        };
        this.bxP = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gEO) {
                    e.jG().postDelayed(PushDialogVideoView.this.gEZ, 200L);
                }
            }
        };
        this.gEZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOq == null || !PushDialogVideoView.this.gEO) {
                    e.jG().postDelayed(PushDialogVideoView.this.frK, 200L);
                    PushDialogVideoView.this.gEO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bOq.getCurrentPosition()) {
                    PushDialogVideoView.this.gEO = false;
                    e.jG().postDelayed(PushDialogVideoView.this.frK, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gEZ, 200L);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.frp = false;
                PushDialogVideoView.this.gEU = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.frK);
                e.jG().removeCallbacks(PushDialogVideoView.this.frM);
            }
        };
        this.frR = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bOq != null && PushDialogVideoView.this.bOq.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bOq.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bOq.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ftM != null) {
                                PushDialogVideoView.this.ftM.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bBT - (duration % PushDialogVideoView.this.bBT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ftM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i) {
                int duration;
                if (PushDialogVideoView.this.bOq != null && (duration = PushDialogVideoView.this.bOq.getDuration()) > 0 && PushDialogVideoView.this.gEp != null) {
                    PushDialogVideoView.this.gEp.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gFb = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void brU() {
                PushDialogVideoView.this.boU.startLoading();
                PushDialogVideoView.this.frk.setVisibility(0);
                PushDialogVideoView.this.dae.setVisibility(8);
                PushDialogVideoView.this.gEs.setVisibility(8);
                PushDialogVideoView.this.dai.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.frM);
                e.jG().postDelayed(PushDialogVideoView.this.frM, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBT = 50;
        this.mSkinType = 3;
        this.frp = false;
        this.mStartPosition = 0;
        this.gEN = true;
        this.gEO = false;
        this.gEP = false;
        this.currentState = -1;
        this.gnA = false;
        this.bxM = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cXo = gVar;
                PushDialogVideoView.this.boU.bsI();
            }
        };
        this.cXA = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqa();
            }
        };
        this.frK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOq.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.frp = true;
                    PushDialogVideoView.this.frb.setVisibility(8);
                    PushDialogVideoView.this.dai.setVisibility(8);
                    PushDialogVideoView.this.boU.bsJ();
                    PushDialogVideoView.this.frk.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.frK, 20L);
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.frp = false;
                PushDialogVideoView.this.gEU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frb.setVisibility(0);
                PushDialogVideoView.this.gEp.setVisibility(8);
                PushDialogVideoView.this.gEp.setProgress(PushDialogVideoView.this.gEp.getMax());
                if (PushDialogVideoView.this.bOq == null || PushDialogVideoView.this.bOq.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gEs.setVisibility(0);
                }
                y.bsO().remove(PushDialogVideoView.this.aEO);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bOq.setRecoveryState(3);
                if (PushDialogVideoView.this.bOq != null && PushDialogVideoView.this.bOq.getDuration() <= 150000) {
                    PushDialogVideoView.this.aZ(PushDialogVideoView.this.aEO, PushDialogVideoView.this.biz);
                }
            }
        };
        this.frL = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.dai.setVisibility(0);
                PushDialogVideoView.this.boU.bsK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bOq.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gES = true;
                }
                PushDialogVideoView.this.gEU = false;
                return true;
            }
        };
        this.frM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.dai.setVisibility(0);
                PushDialogVideoView.this.boU.bsK();
            }
        };
        this.bxP = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gEO) {
                    e.jG().postDelayed(PushDialogVideoView.this.gEZ, 200L);
                }
            }
        };
        this.gEZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOq == null || !PushDialogVideoView.this.gEO) {
                    e.jG().postDelayed(PushDialogVideoView.this.frK, 200L);
                    PushDialogVideoView.this.gEO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bOq.getCurrentPosition()) {
                    PushDialogVideoView.this.gEO = false;
                    e.jG().postDelayed(PushDialogVideoView.this.frK, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gEZ, 200L);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.frp = false;
                PushDialogVideoView.this.gEU = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.frK);
                e.jG().removeCallbacks(PushDialogVideoView.this.frM);
            }
        };
        this.frR = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bOq != null && PushDialogVideoView.this.bOq.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bOq.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bOq.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ftM != null) {
                                PushDialogVideoView.this.ftM.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bBT - (duration % PushDialogVideoView.this.bBT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ftM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i) {
                int duration;
                if (PushDialogVideoView.this.bOq != null && (duration = PushDialogVideoView.this.bOq.getDuration()) > 0 && PushDialogVideoView.this.gEp != null) {
                    PushDialogVideoView.this.gEp.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gFb = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void brU() {
                PushDialogVideoView.this.boU.startLoading();
                PushDialogVideoView.this.frk.setVisibility(0);
                PushDialogVideoView.this.dae.setVisibility(8);
                PushDialogVideoView.this.gEs.setVisibility(8);
                PushDialogVideoView.this.dai.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.frM);
                e.jG().postDelayed(PushDialogVideoView.this.frM, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBT = 50;
        this.mSkinType = 3;
        this.frp = false;
        this.mStartPosition = 0;
        this.gEN = true;
        this.gEO = false;
        this.gEP = false;
        this.currentState = -1;
        this.gnA = false;
        this.bxM = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cXo = gVar;
                PushDialogVideoView.this.boU.bsI();
            }
        };
        this.cXA = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aqa();
            }
        };
        this.frK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOq.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.frp = true;
                    PushDialogVideoView.this.frb.setVisibility(8);
                    PushDialogVideoView.this.dai.setVisibility(8);
                    PushDialogVideoView.this.boU.bsJ();
                    PushDialogVideoView.this.frk.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.frK, 20L);
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.frp = false;
                PushDialogVideoView.this.gEU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.frb.setVisibility(0);
                PushDialogVideoView.this.gEp.setVisibility(8);
                PushDialogVideoView.this.gEp.setProgress(PushDialogVideoView.this.gEp.getMax());
                if (PushDialogVideoView.this.bOq == null || PushDialogVideoView.this.bOq.getDuration() > 150000) {
                    PushDialogVideoView.this.mw(false);
                } else {
                    PushDialogVideoView.this.gEs.setVisibility(0);
                }
                y.bsO().remove(PushDialogVideoView.this.aEO);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bOq.setRecoveryState(3);
                if (PushDialogVideoView.this.bOq != null && PushDialogVideoView.this.bOq.getDuration() <= 150000) {
                    PushDialogVideoView.this.aZ(PushDialogVideoView.this.aEO, PushDialogVideoView.this.biz);
                }
            }
        };
        this.frL = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.dai.setVisibility(0);
                PushDialogVideoView.this.boU.bsK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bOq.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gES = true;
                }
                PushDialogVideoView.this.gEU = false;
                return true;
            }
        };
        this.frM = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.dai.setVisibility(0);
                PushDialogVideoView.this.boU.bsK();
            }
        };
        this.bxP = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gEO) {
                    e.jG().postDelayed(PushDialogVideoView.this.gEZ, 200L);
                }
            }
        };
        this.gEZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOq == null || !PushDialogVideoView.this.gEO) {
                    e.jG().postDelayed(PushDialogVideoView.this.frK, 200L);
                    PushDialogVideoView.this.gEO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bOq.getCurrentPosition()) {
                    PushDialogVideoView.this.gEO = false;
                    e.jG().postDelayed(PushDialogVideoView.this.frK, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gEZ, 200L);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.frp = false;
                PushDialogVideoView.this.gEU = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.frK);
                e.jG().removeCallbacks(PushDialogVideoView.this.frM);
            }
        };
        this.frR = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bOq != null && PushDialogVideoView.this.bOq.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bOq.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bOq.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ftM != null) {
                                PushDialogVideoView.this.ftM.hJ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bBT - (duration % PushDialogVideoView.this.bBT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ftM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hJ(int i2) {
                int duration;
                if (PushDialogVideoView.this.bOq != null && (duration = PushDialogVideoView.this.bOq.getDuration()) > 0 && PushDialogVideoView.this.gEp != null) {
                    PushDialogVideoView.this.gEp.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gFb = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void brU() {
                PushDialogVideoView.this.boU.startLoading();
                PushDialogVideoView.this.frk.setVisibility(0);
                PushDialogVideoView.this.dae.setVisibility(8);
                PushDialogVideoView.this.gEs.setVisibility(8);
                PushDialogVideoView.this.dai.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.frM);
                e.jG().postDelayed(PushDialogVideoView.this.frM, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0210e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bOq = (QuickVideoView) findViewById(e.g.videoView);
        this.boU = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.boU.setLoadingAnimationListener(this.cXA);
        this.gEp = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.gEp.setMax(this.mWidth);
        this.gEp.setProgress(0);
        this.frb = findViewById(e.g.black_mask);
        this.dai = findViewById(e.g.layout_error);
        this.dae = (ImageView) findViewById(e.g.img_play);
        this.gEs = (TextView) findViewById(e.g.txt_replay);
        this.cGc = (TextView) findViewById(e.g.push_dialog_video_time);
        this.frk = (TbImageView) findViewById(e.g.video_thumbnail);
        this.gnL = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.frk.setDefaultErrorResource(0);
        this.frk.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.frH = new CallStateReceiver();
        this.frH.register(context);
        this.dai.setOnClickListener(this);
        this.gEs.setOnClickListener(this);
        this.gnL.setOnPlayClickListener(this);
        this.gnL.setFreeClickListener(this);
        setOnClickListener(this);
        this.bOq.setOnPreparedListener(this.bxM);
        this.bOq.setOnCompletionListener(this.bxL);
        this.bOq.setOnErrorListener(this.frL);
        this.bOq.setOnSeekCompleteListener(this.bxP);
        this.bOq.setOnSurfaceDestroyedListener(this.bpd);
        this.bOq.setOnRecoveryCallback(this.gFb);
        onChangeSkinType();
    }

    public void onPause() {
        if (brH()) {
            this.gnA = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.gnA = false;
        } else {
            this.gnA = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.gnA) {
            aZG();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.frR);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gKV = fVar;
        this.cGc.setText(ao.dV(this.gKV.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.aEO = str;
        this.biz = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bOq.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqa() {
        if (this.bOq != null && this.cXo != null) {
            if (this.gEU) {
                this.bOq.start();
                this.gEU = false;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.frK, 20L);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
            if (this.bOq.bsk()) {
                this.currentState = 1;
                this.bOq.setRecoveryState(1);
            }
            if (this.cXo != null) {
                this.mStartPosition = y.bsO().tZ(this.aEO);
                if (this.mStartPosition != 0) {
                    if (this.bOq != null) {
                        this.bOq.tB(this.mStartPosition);
                    } else {
                        this.cXo.seekTo(this.mStartPosition);
                    }
                    if (!this.gET) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
                    }
                    this.gEO = true;
                }
            }
        }
    }

    public void bnZ() {
        if (!j.kV()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bOq.isPlaying()) {
            pausePlay();
        } else if (this.frp) {
            aZG();
        } else {
            brI();
        }
    }

    public void setPauseState() {
        this.boU.bsK();
        this.dae.setVisibility(0);
        this.gEs.setVisibility(8);
        this.currentState = 2;
        this.bOq.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gEP) {
            cs(str, str2);
        } else {
            aZ(str, str2);
        }
        if (aVar != null) {
            aVar.mC(z);
        }
    }

    public void aZ(String str, String str2) {
        brJ();
        this.gEU = true;
        this.currentState = 0;
        this.bOq.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bOq.setVideoPath(str, str2);
        this.boU.startLoading();
        this.frk.setVisibility(0);
        this.dae.setVisibility(8);
        this.gEs.setVisibility(8);
        this.dai.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.frM, 60000L);
    }

    public void cs(String str, String str2) {
        brJ();
        this.gEU = true;
        this.currentState = 0;
        this.bOq.setRecoveryState(0);
        this.boU.startLoading();
        this.frk.setVisibility(0);
        this.dae.setVisibility(8);
        this.gEs.setVisibility(8);
        this.dai.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.frM, 60000L);
    }

    public void aZG() {
        this.currentState = 1;
        this.bOq.setRecoveryState(1);
        this.bOq.start();
        this.frk.setVisibility(8);
        this.frb.setVisibility(8);
        this.boU.bsK();
        showProgress();
        this.dae.setVisibility(8);
        this.gEs.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kV() && this.gES && !StringUtils.isNull(this.aEO) && !StringUtils.isNull(this.biz)) {
            this.gES = false;
            this.gET = true;
            aZ(this.aEO, this.biz);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bOq != null) {
            this.bOq.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bOq.isPlaying() && this.gEN) {
            brG();
        }
        this.bOq.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bOq.isPlaying() && this.gEN) {
            brG();
        }
        this.currentState = 5;
        this.bOq.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        this.bOq.stopPlayback();
        this.frp = false;
        this.gEU = false;
        this.mStartPosition = 0;
        aMK();
    }

    public void brG() {
        y.bsO().aO(this.aEO, this.bOq.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        this.frb.setVisibility(0);
        this.dae.setVisibility(0);
        this.gEs.setVisibility(8);
        this.boU.bsK();
        this.gEp.setVisibility(8);
        this.dai.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.frk.setVisibility(z ? 0 : 8);
    }

    public void aMK() {
        mw(true);
    }

    public boolean brH() {
        if (this.bOq == null) {
            return false;
        }
        return this.bOq.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bOq == null) {
            return 0;
        }
        return this.bOq.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bOq != null) {
            this.gEp.setVisibility(0);
            this.bBT = ((this.bOq.getDuration() / 200) / 50) * 50;
            if (this.bBT < 50) {
                this.bBT = 50;
            } else if (this.bBT > 500) {
                this.bBT = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bBT - (this.bOq.getCurrentPosition() % this.bBT));
        }
    }

    private void brI() {
        a(this.aEO, this.biz, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        brJ();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gEP = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kX() && !this.gnT && !com.baidu.tieba.video.g.bIG().bIH()) {
            this.gnL.setVisibility(0);
            this.gnL.setData(this.gKV.getDuration(), this.gKV.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void brJ() {
        if (j.kX()) {
            com.baidu.tieba.video.g.bIG().dc(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.frk.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dai) {
            brI();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 2).aA("tid", this.biz));
            bnZ();
        } else if (view == this.gEs) {
            aZ(this.aEO, this.biz);
        } else if (view == this.gnL.getTvPlay()) {
            this.gnT = true;
            this.gnL.setVisibility(8);
            aZ(this.aEO, this.biz);
        } else if (view == this.gnL.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gEZ);
        this.mHandler.removeMessages(1);
        this.frH.unregister(getContext());
    }
}
