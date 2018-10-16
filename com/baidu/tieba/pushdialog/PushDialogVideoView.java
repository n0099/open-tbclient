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
    private String aAy;
    private QuickVideoView bJN;
    private String beh;
    private x bkI;
    private QuickVideoView.b bkR;
    private g.InterfaceC0259g btC;
    private g.a bty;
    private g.f btz;
    private int bxI;
    private TextView cAc;
    private g cML;
    private VideoLoadingProgressView.a cMX;
    private ImageView cPB;
    private View cPF;
    private int currentState;
    private View ffX;
    private CallStateReceiver fgC;
    private Runnable fgF;
    private g.b fgG;
    private Runnable fgH;
    private CustomMessageListener fgM;
    private TbImageView fgg;
    private boolean fgl;
    private VideoControllerView.b fiI;
    private PbVideoWifiTipLayout gcF;
    private boolean gcN;
    private boolean gct;
    private boolean gtF;
    private boolean gtG;
    private boolean gtH;
    private boolean gtK;
    private boolean gtL;
    private boolean gtM;
    private Runnable gtR;
    private QuickVideoView.a gtT;
    private ProgressBar gth;
    private TextView gtk;
    private f gzM;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void ml(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.bxI = 50;
        this.mSkinType = 3;
        this.fgl = false;
        this.mStartPosition = 0;
        this.gtF = true;
        this.gtG = false;
        this.gtH = false;
        this.currentState = -1;
        this.gct = false;
        this.btz = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cML = gVar;
                PushDialogVideoView.this.bkI.bqI();
            }
        };
        this.cMX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.anW();
            }
        };
        this.fgF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bJN.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fgl = true;
                    PushDialogVideoView.this.ffX.setVisibility(8);
                    PushDialogVideoView.this.cPF.setVisibility(8);
                    PushDialogVideoView.this.bkI.bqJ();
                    PushDialogVideoView.this.fgg.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jI().postDelayed(PushDialogVideoView.this.fgF, 20L);
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fgl = false;
                PushDialogVideoView.this.gtM = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.ffX.setVisibility(0);
                PushDialogVideoView.this.gth.setVisibility(8);
                PushDialogVideoView.this.gth.setProgress(PushDialogVideoView.this.gth.getMax());
                if (PushDialogVideoView.this.bJN == null || PushDialogVideoView.this.bJN.getDuration() > 150000) {
                    PushDialogVideoView.this.mf(false);
                } else {
                    PushDialogVideoView.this.gtk.setVisibility(0);
                }
                y.bqO().remove(PushDialogVideoView.this.aAy);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bJN.setRecoveryState(3);
                if (PushDialogVideoView.this.bJN != null && PushDialogVideoView.this.bJN.getDuration() <= 150000) {
                    PushDialogVideoView.this.aW(PushDialogVideoView.this.aAy, PushDialogVideoView.this.beh);
                }
            }
        };
        this.fgG = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cPF.setVisibility(0);
                PushDialogVideoView.this.bkI.bqK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bJN.setRecoveryState(4);
                if (!j.kX()) {
                    PushDialogVideoView.this.gtK = true;
                }
                PushDialogVideoView.this.gtM = false;
                return true;
            }
        };
        this.fgH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cPF.setVisibility(0);
                PushDialogVideoView.this.bkI.bqK();
            }
        };
        this.btC = new g.InterfaceC0259g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gtG) {
                    e.jI().postDelayed(PushDialogVideoView.this.gtR, 200L);
                }
            }
        };
        this.gtR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bJN == null || !PushDialogVideoView.this.gtG) {
                    e.jI().postDelayed(PushDialogVideoView.this.fgF, 200L);
                    PushDialogVideoView.this.gtG = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bJN.getCurrentPosition()) {
                    PushDialogVideoView.this.gtG = false;
                    e.jI().postDelayed(PushDialogVideoView.this.fgF, 20L);
                } else {
                    e.jI().postDelayed(PushDialogVideoView.this.gtR, 200L);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fgl = false;
                PushDialogVideoView.this.gtM = false;
                e.jI().removeCallbacks(PushDialogVideoView.this.fgF);
                e.jI().removeCallbacks(PushDialogVideoView.this.fgH);
            }
        };
        this.fgM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bJN != null && PushDialogVideoView.this.bJN.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bJN.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bJN.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fiI != null) {
                                PushDialogVideoView.this.fiI.hh(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bxI - (duration % PushDialogVideoView.this.bxI));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fiI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hh(int i) {
                int duration;
                if (PushDialogVideoView.this.bJN != null && (duration = PushDialogVideoView.this.bJN.getDuration()) > 0 && PushDialogVideoView.this.gth != null) {
                    PushDialogVideoView.this.gth.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gtT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bpU() {
                PushDialogVideoView.this.bkI.startLoading();
                PushDialogVideoView.this.fgg.setVisibility(0);
                PushDialogVideoView.this.cPB.setVisibility(8);
                PushDialogVideoView.this.gtk.setVisibility(8);
                PushDialogVideoView.this.cPF.setVisibility(8);
                e.jI().removeCallbacks(PushDialogVideoView.this.fgH);
                e.jI().postDelayed(PushDialogVideoView.this.fgH, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxI = 50;
        this.mSkinType = 3;
        this.fgl = false;
        this.mStartPosition = 0;
        this.gtF = true;
        this.gtG = false;
        this.gtH = false;
        this.currentState = -1;
        this.gct = false;
        this.btz = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cML = gVar;
                PushDialogVideoView.this.bkI.bqI();
            }
        };
        this.cMX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.anW();
            }
        };
        this.fgF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bJN.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fgl = true;
                    PushDialogVideoView.this.ffX.setVisibility(8);
                    PushDialogVideoView.this.cPF.setVisibility(8);
                    PushDialogVideoView.this.bkI.bqJ();
                    PushDialogVideoView.this.fgg.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jI().postDelayed(PushDialogVideoView.this.fgF, 20L);
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fgl = false;
                PushDialogVideoView.this.gtM = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.ffX.setVisibility(0);
                PushDialogVideoView.this.gth.setVisibility(8);
                PushDialogVideoView.this.gth.setProgress(PushDialogVideoView.this.gth.getMax());
                if (PushDialogVideoView.this.bJN == null || PushDialogVideoView.this.bJN.getDuration() > 150000) {
                    PushDialogVideoView.this.mf(false);
                } else {
                    PushDialogVideoView.this.gtk.setVisibility(0);
                }
                y.bqO().remove(PushDialogVideoView.this.aAy);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bJN.setRecoveryState(3);
                if (PushDialogVideoView.this.bJN != null && PushDialogVideoView.this.bJN.getDuration() <= 150000) {
                    PushDialogVideoView.this.aW(PushDialogVideoView.this.aAy, PushDialogVideoView.this.beh);
                }
            }
        };
        this.fgG = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cPF.setVisibility(0);
                PushDialogVideoView.this.bkI.bqK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bJN.setRecoveryState(4);
                if (!j.kX()) {
                    PushDialogVideoView.this.gtK = true;
                }
                PushDialogVideoView.this.gtM = false;
                return true;
            }
        };
        this.fgH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cPF.setVisibility(0);
                PushDialogVideoView.this.bkI.bqK();
            }
        };
        this.btC = new g.InterfaceC0259g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gtG) {
                    e.jI().postDelayed(PushDialogVideoView.this.gtR, 200L);
                }
            }
        };
        this.gtR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bJN == null || !PushDialogVideoView.this.gtG) {
                    e.jI().postDelayed(PushDialogVideoView.this.fgF, 200L);
                    PushDialogVideoView.this.gtG = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bJN.getCurrentPosition()) {
                    PushDialogVideoView.this.gtG = false;
                    e.jI().postDelayed(PushDialogVideoView.this.fgF, 20L);
                } else {
                    e.jI().postDelayed(PushDialogVideoView.this.gtR, 200L);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fgl = false;
                PushDialogVideoView.this.gtM = false;
                e.jI().removeCallbacks(PushDialogVideoView.this.fgF);
                e.jI().removeCallbacks(PushDialogVideoView.this.fgH);
            }
        };
        this.fgM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bJN != null && PushDialogVideoView.this.bJN.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bJN.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bJN.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fiI != null) {
                                PushDialogVideoView.this.fiI.hh(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bxI - (duration % PushDialogVideoView.this.bxI));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fiI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hh(int i) {
                int duration;
                if (PushDialogVideoView.this.bJN != null && (duration = PushDialogVideoView.this.bJN.getDuration()) > 0 && PushDialogVideoView.this.gth != null) {
                    PushDialogVideoView.this.gth.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gtT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bpU() {
                PushDialogVideoView.this.bkI.startLoading();
                PushDialogVideoView.this.fgg.setVisibility(0);
                PushDialogVideoView.this.cPB.setVisibility(8);
                PushDialogVideoView.this.gtk.setVisibility(8);
                PushDialogVideoView.this.cPF.setVisibility(8);
                e.jI().removeCallbacks(PushDialogVideoView.this.fgH);
                e.jI().postDelayed(PushDialogVideoView.this.fgH, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxI = 50;
        this.mSkinType = 3;
        this.fgl = false;
        this.mStartPosition = 0;
        this.gtF = true;
        this.gtG = false;
        this.gtH = false;
        this.currentState = -1;
        this.gct = false;
        this.btz = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cML = gVar;
                PushDialogVideoView.this.bkI.bqI();
            }
        };
        this.cMX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.anW();
            }
        };
        this.fgF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bJN.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fgl = true;
                    PushDialogVideoView.this.ffX.setVisibility(8);
                    PushDialogVideoView.this.cPF.setVisibility(8);
                    PushDialogVideoView.this.bkI.bqJ();
                    PushDialogVideoView.this.fgg.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jI().postDelayed(PushDialogVideoView.this.fgF, 20L);
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fgl = false;
                PushDialogVideoView.this.gtM = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.ffX.setVisibility(0);
                PushDialogVideoView.this.gth.setVisibility(8);
                PushDialogVideoView.this.gth.setProgress(PushDialogVideoView.this.gth.getMax());
                if (PushDialogVideoView.this.bJN == null || PushDialogVideoView.this.bJN.getDuration() > 150000) {
                    PushDialogVideoView.this.mf(false);
                } else {
                    PushDialogVideoView.this.gtk.setVisibility(0);
                }
                y.bqO().remove(PushDialogVideoView.this.aAy);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bJN.setRecoveryState(3);
                if (PushDialogVideoView.this.bJN != null && PushDialogVideoView.this.bJN.getDuration() <= 150000) {
                    PushDialogVideoView.this.aW(PushDialogVideoView.this.aAy, PushDialogVideoView.this.beh);
                }
            }
        };
        this.fgG = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.cPF.setVisibility(0);
                PushDialogVideoView.this.bkI.bqK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bJN.setRecoveryState(4);
                if (!j.kX()) {
                    PushDialogVideoView.this.gtK = true;
                }
                PushDialogVideoView.this.gtM = false;
                return true;
            }
        };
        this.fgH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cPF.setVisibility(0);
                PushDialogVideoView.this.bkI.bqK();
            }
        };
        this.btC = new g.InterfaceC0259g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gtG) {
                    e.jI().postDelayed(PushDialogVideoView.this.gtR, 200L);
                }
            }
        };
        this.gtR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bJN == null || !PushDialogVideoView.this.gtG) {
                    e.jI().postDelayed(PushDialogVideoView.this.fgF, 200L);
                    PushDialogVideoView.this.gtG = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bJN.getCurrentPosition()) {
                    PushDialogVideoView.this.gtG = false;
                    e.jI().postDelayed(PushDialogVideoView.this.fgF, 20L);
                } else {
                    e.jI().postDelayed(PushDialogVideoView.this.gtR, 200L);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fgl = false;
                PushDialogVideoView.this.gtM = false;
                e.jI().removeCallbacks(PushDialogVideoView.this.fgF);
                e.jI().removeCallbacks(PushDialogVideoView.this.fgH);
            }
        };
        this.fgM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bJN != null && PushDialogVideoView.this.bJN.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bJN.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bJN.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fiI != null) {
                                PushDialogVideoView.this.fiI.hh(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bxI - (duration % PushDialogVideoView.this.bxI));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fiI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hh(int i2) {
                int duration;
                if (PushDialogVideoView.this.bJN != null && (duration = PushDialogVideoView.this.bJN.getDuration()) > 0 && PushDialogVideoView.this.gth != null) {
                    PushDialogVideoView.this.gth.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gtT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bpU() {
                PushDialogVideoView.this.bkI.startLoading();
                PushDialogVideoView.this.fgg.setVisibility(0);
                PushDialogVideoView.this.cPB.setVisibility(8);
                PushDialogVideoView.this.gtk.setVisibility(8);
                PushDialogVideoView.this.cPF.setVisibility(8);
                e.jI().removeCallbacks(PushDialogVideoView.this.fgH);
                e.jI().postDelayed(PushDialogVideoView.this.fgH, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0175e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bJN = (QuickVideoView) findViewById(e.g.videoView);
        this.bkI = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bkI.setLoadingAnimationListener(this.cMX);
        this.gth = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.gth.setMax(this.mWidth);
        this.gth.setProgress(0);
        this.ffX = findViewById(e.g.black_mask);
        this.cPF = findViewById(e.g.layout_error);
        this.cPB = (ImageView) findViewById(e.g.img_play);
        this.gtk = (TextView) findViewById(e.g.txt_replay);
        this.cAc = (TextView) findViewById(e.g.push_dialog_video_time);
        this.fgg = (TbImageView) findViewById(e.g.video_thumbnail);
        this.gcF = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.fgg.setDefaultErrorResource(0);
        this.fgg.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.fgC = new CallStateReceiver();
        this.fgC.register(context);
        this.cPF.setOnClickListener(this);
        this.gtk.setOnClickListener(this);
        this.gcF.setOnPlayClickListener(this);
        this.gcF.setFreeClickListener(this);
        setOnClickListener(this);
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnCompletionListener(this.bty);
        this.bJN.setOnErrorListener(this.fgG);
        this.bJN.setOnSeekCompleteListener(this.btC);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        this.bJN.setOnRecoveryCallback(this.gtT);
        onChangeSkinType();
    }

    public void onPause() {
        if (bpH()) {
            this.gct = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.gct = false;
        } else {
            this.gct = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.gct) {
            aXE();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.fgM);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gzM = fVar;
        this.cAc.setText(ao.dt(this.gzM.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.aAy = str;
        this.beh = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bJN.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        if (this.bJN != null && this.cML != null) {
            if (this.gtM) {
                this.bJN.start();
                this.gtM = false;
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgF);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.fgF, 20L);
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgH);
            if (this.bJN.bqk()) {
                this.currentState = 1;
                this.bJN.setRecoveryState(1);
            }
            if (this.cML != null) {
                this.mStartPosition = y.bqO().tp(this.aAy);
                if (this.mStartPosition != 0) {
                    if (this.bJN != null) {
                        this.bJN.sB(this.mStartPosition);
                    } else {
                        this.cML.seekTo(this.mStartPosition);
                    }
                    if (!this.gtL) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgF);
                    }
                    this.gtG = true;
                }
            }
        }
    }

    public void blZ() {
        if (!j.kX()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bJN.isPlaying()) {
            pausePlay();
        } else if (this.fgl) {
            aXE();
        } else {
            bpI();
        }
    }

    public void setPauseState() {
        this.bkI.bqK();
        this.cPB.setVisibility(0);
        this.gtk.setVisibility(8);
        this.currentState = 2;
        this.bJN.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gtH) {
            cn(str, str2);
        } else {
            aW(str, str2);
        }
        if (aVar != null) {
            aVar.ml(z);
        }
    }

    public void aW(String str, String str2) {
        bpJ();
        this.gtM = true;
        this.currentState = 0;
        this.bJN.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bJN.setVideoPath(str, str2);
        this.bkI.startLoading();
        this.fgg.setVisibility(0);
        this.cPB.setVisibility(8);
        this.gtk.setVisibility(8);
        this.cPF.setVisibility(8);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgH);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.fgH, 60000L);
    }

    public void cn(String str, String str2) {
        bpJ();
        this.gtM = true;
        this.currentState = 0;
        this.bJN.setRecoveryState(0);
        this.bkI.startLoading();
        this.fgg.setVisibility(0);
        this.cPB.setVisibility(8);
        this.gtk.setVisibility(8);
        this.cPF.setVisibility(8);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgH);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.fgH, 60000L);
    }

    public void aXE() {
        this.currentState = 1;
        this.bJN.setRecoveryState(1);
        this.bJN.start();
        this.fgg.setVisibility(8);
        this.ffX.setVisibility(8);
        this.bkI.bqK();
        showProgress();
        this.cPB.setVisibility(8);
        this.gtk.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kX() && this.gtK && !StringUtils.isNull(this.aAy) && !StringUtils.isNull(this.beh)) {
            this.gtK = false;
            this.gtL = true;
            aW(this.aAy, this.beh);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bJN != null) {
            this.bJN.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bJN.isPlaying() && this.gtF) {
            bpG();
        }
        this.bJN.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bJN.isPlaying() && this.gtF) {
            bpG();
        }
        this.currentState = 5;
        this.bJN.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgF);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgH);
        this.bJN.stopPlayback();
        this.fgl = false;
        this.gtM = false;
        this.mStartPosition = 0;
        aKH();
    }

    public void bpG() {
        y.bqO().aM(this.aAy, this.bJN.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(boolean z) {
        this.ffX.setVisibility(0);
        this.cPB.setVisibility(0);
        this.gtk.setVisibility(8);
        this.bkI.bqK();
        this.gth.setVisibility(8);
        this.cPF.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.fgg.setVisibility(z ? 0 : 8);
    }

    public void aKH() {
        mf(true);
    }

    public boolean bpH() {
        if (this.bJN == null) {
            return false;
        }
        return this.bJN.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bJN == null) {
            return 0;
        }
        return this.bJN.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bJN != null) {
            this.gth.setVisibility(0);
            this.bxI = ((this.bJN.getDuration() / 200) / 50) * 50;
            if (this.bxI < 50) {
                this.bxI = 50;
            } else if (this.bxI > 500) {
                this.bxI = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bxI - (this.bJN.getCurrentPosition() % this.bxI));
        }
    }

    private void bpI() {
        a(this.aAy, this.beh, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bpJ();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gtH = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kZ() && !this.gcN && !com.baidu.tieba.video.g.bGn().bGo()) {
            this.gcF.setVisibility(0);
            this.gcF.setData(this.gzM.getDuration(), this.gzM.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bpJ() {
        if (j.kZ()) {
            com.baidu.tieba.video.g.bGn().dd(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.fgg.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cPF) {
            bpI();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 2).ax("tid", this.beh));
            blZ();
        } else if (view == this.gtk) {
            aW(this.aAy, this.beh);
        } else if (view == this.gcF.getTvPlay()) {
            this.gcN = true;
            this.gcF.setVisibility(8);
            aW(this.aAy, this.beh);
        } else if (view == this.gcF.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgF);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgH);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gtR);
        this.mHandler.removeMessages(1);
        this.fgC.unregister(getContext());
    }
}
