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
import com.baidu.tieba.R;
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
    private boolean Ss;
    private Runnable Sy;
    private String bUZ;
    private String bVL;
    private QuickVideoView.b cIB;
    private x cIs;
    private g.a cRR;
    private g.f cRS;
    private g.InterfaceC0388g cRV;
    private int cVZ;
    private int currentState;
    private g deB;
    private QuickVideoView dlL;
    private View eAg;
    private TextView eef;
    private VideoLoadingProgressView.a exx;
    private CallStateReceiver gZM;
    private g.b gZP;
    private Runnable gZQ;
    private CustomMessageListener gZV;
    private View gZh;
    private ImageView gZq;
    private TbImageView gZr;
    private PbVideoWifiTipLayout hWH;
    private boolean hWQ;
    private boolean hWw;
    private VideoControllerView.b hbQ;
    private ProgressBar inS;
    private TextView inV;
    private Runnable ioE;
    private QuickVideoView.a ioG;
    private boolean ior;
    private boolean ios;
    private boolean iot;
    private boolean iow;
    private boolean iox;
    private boolean ioy;
    private f ivO;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void pO(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.cVZ = 50;
        this.mSkinType = 3;
        this.Ss = false;
        this.mStartPosition = 0;
        this.ior = true;
        this.ios = false;
        this.iot = false;
        this.currentState = -1;
        this.hWw = false;
        this.cRS = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deB = gVar;
                PushDialogVideoView.this.cIs.cbM();
            }
        };
        this.exx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXu();
            }
        };
        this.Sy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlL.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ss = true;
                    PushDialogVideoView.this.gZh.setVisibility(8);
                    PushDialogVideoView.this.eAg.setVisibility(8);
                    PushDialogVideoView.this.cIs.cbN();
                    PushDialogVideoView.this.gZr.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioy = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZh.setVisibility(0);
                PushDialogVideoView.this.inS.setVisibility(8);
                PushDialogVideoView.this.inS.setProgress(PushDialogVideoView.this.inS.getMax());
                if (PushDialogVideoView.this.dlL == null || PushDialogVideoView.this.dlL.getDuration() > 150000) {
                    PushDialogVideoView.this.pJ(false);
                } else {
                    PushDialogVideoView.this.inV.setVisibility(0);
                }
                y.cbS().remove(PushDialogVideoView.this.bUZ);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlL.setRecoveryState(3);
                if (PushDialogVideoView.this.dlL != null && PushDialogVideoView.this.dlL.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bUZ, PushDialogVideoView.this.bVL);
                }
            }
        };
        this.gZP = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eAg.setVisibility(0);
                PushDialogVideoView.this.cIs.cbO();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlL.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.iow = true;
                }
                PushDialogVideoView.this.ioy = false;
                return true;
            }
        };
        this.gZQ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAg.setVisibility(0);
                PushDialogVideoView.this.cIs.cbO();
            }
        };
        this.cRV = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ios) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioE, 200L);
                }
            }
        };
        this.ioE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlL == null || !PushDialogVideoView.this.ios) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 200L);
                    PushDialogVideoView.this.ios = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlL.getCurrentPosition()) {
                    PushDialogVideoView.this.ios = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioE, 200L);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioy = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sy);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZQ);
            }
        };
        this.gZV = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dlL != null && PushDialogVideoView.this.dlL.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dlL.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dlL.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hbQ != null) {
                                PushDialogVideoView.this.hbQ.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cVZ - (duration % PushDialogVideoView.this.cVZ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbQ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i) {
                int duration;
                if (PushDialogVideoView.this.dlL != null && (duration = PushDialogVideoView.this.dlL.getDuration()) > 0 && PushDialogVideoView.this.inS != null) {
                    PushDialogVideoView.this.inS.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioG = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void caX() {
                PushDialogVideoView.this.cIs.startLoading();
                PushDialogVideoView.this.gZr.setVisibility(0);
                PushDialogVideoView.this.gZq.setVisibility(8);
                PushDialogVideoView.this.inV.setVisibility(8);
                PushDialogVideoView.this.eAg.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZQ);
                e.iB().postDelayed(PushDialogVideoView.this.gZQ, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVZ = 50;
        this.mSkinType = 3;
        this.Ss = false;
        this.mStartPosition = 0;
        this.ior = true;
        this.ios = false;
        this.iot = false;
        this.currentState = -1;
        this.hWw = false;
        this.cRS = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deB = gVar;
                PushDialogVideoView.this.cIs.cbM();
            }
        };
        this.exx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXu();
            }
        };
        this.Sy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlL.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ss = true;
                    PushDialogVideoView.this.gZh.setVisibility(8);
                    PushDialogVideoView.this.eAg.setVisibility(8);
                    PushDialogVideoView.this.cIs.cbN();
                    PushDialogVideoView.this.gZr.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioy = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZh.setVisibility(0);
                PushDialogVideoView.this.inS.setVisibility(8);
                PushDialogVideoView.this.inS.setProgress(PushDialogVideoView.this.inS.getMax());
                if (PushDialogVideoView.this.dlL == null || PushDialogVideoView.this.dlL.getDuration() > 150000) {
                    PushDialogVideoView.this.pJ(false);
                } else {
                    PushDialogVideoView.this.inV.setVisibility(0);
                }
                y.cbS().remove(PushDialogVideoView.this.bUZ);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlL.setRecoveryState(3);
                if (PushDialogVideoView.this.dlL != null && PushDialogVideoView.this.dlL.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bUZ, PushDialogVideoView.this.bVL);
                }
            }
        };
        this.gZP = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eAg.setVisibility(0);
                PushDialogVideoView.this.cIs.cbO();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlL.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.iow = true;
                }
                PushDialogVideoView.this.ioy = false;
                return true;
            }
        };
        this.gZQ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAg.setVisibility(0);
                PushDialogVideoView.this.cIs.cbO();
            }
        };
        this.cRV = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ios) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioE, 200L);
                }
            }
        };
        this.ioE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlL == null || !PushDialogVideoView.this.ios) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 200L);
                    PushDialogVideoView.this.ios = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlL.getCurrentPosition()) {
                    PushDialogVideoView.this.ios = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioE, 200L);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioy = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sy);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZQ);
            }
        };
        this.gZV = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dlL != null && PushDialogVideoView.this.dlL.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dlL.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dlL.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hbQ != null) {
                                PushDialogVideoView.this.hbQ.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cVZ - (duration % PushDialogVideoView.this.cVZ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbQ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i) {
                int duration;
                if (PushDialogVideoView.this.dlL != null && (duration = PushDialogVideoView.this.dlL.getDuration()) > 0 && PushDialogVideoView.this.inS != null) {
                    PushDialogVideoView.this.inS.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioG = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void caX() {
                PushDialogVideoView.this.cIs.startLoading();
                PushDialogVideoView.this.gZr.setVisibility(0);
                PushDialogVideoView.this.gZq.setVisibility(8);
                PushDialogVideoView.this.inV.setVisibility(8);
                PushDialogVideoView.this.eAg.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZQ);
                e.iB().postDelayed(PushDialogVideoView.this.gZQ, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVZ = 50;
        this.mSkinType = 3;
        this.Ss = false;
        this.mStartPosition = 0;
        this.ior = true;
        this.ios = false;
        this.iot = false;
        this.currentState = -1;
        this.hWw = false;
        this.cRS = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deB = gVar;
                PushDialogVideoView.this.cIs.cbM();
            }
        };
        this.exx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXu();
            }
        };
        this.Sy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlL.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ss = true;
                    PushDialogVideoView.this.gZh.setVisibility(8);
                    PushDialogVideoView.this.eAg.setVisibility(8);
                    PushDialogVideoView.this.cIs.cbN();
                    PushDialogVideoView.this.gZr.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioy = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZh.setVisibility(0);
                PushDialogVideoView.this.inS.setVisibility(8);
                PushDialogVideoView.this.inS.setProgress(PushDialogVideoView.this.inS.getMax());
                if (PushDialogVideoView.this.dlL == null || PushDialogVideoView.this.dlL.getDuration() > 150000) {
                    PushDialogVideoView.this.pJ(false);
                } else {
                    PushDialogVideoView.this.inV.setVisibility(0);
                }
                y.cbS().remove(PushDialogVideoView.this.bUZ);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlL.setRecoveryState(3);
                if (PushDialogVideoView.this.dlL != null && PushDialogVideoView.this.dlL.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bUZ, PushDialogVideoView.this.bVL);
                }
            }
        };
        this.gZP = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eAg.setVisibility(0);
                PushDialogVideoView.this.cIs.cbO();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlL.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.iow = true;
                }
                PushDialogVideoView.this.ioy = false;
                return true;
            }
        };
        this.gZQ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAg.setVisibility(0);
                PushDialogVideoView.this.cIs.cbO();
            }
        };
        this.cRV = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ios) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioE, 200L);
                }
            }
        };
        this.ioE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlL == null || !PushDialogVideoView.this.ios) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 200L);
                    PushDialogVideoView.this.ios = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlL.getCurrentPosition()) {
                    PushDialogVideoView.this.ios = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioE, 200L);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioy = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sy);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZQ);
            }
        };
        this.gZV = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dlL != null && PushDialogVideoView.this.dlL.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dlL.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dlL.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hbQ != null) {
                                PushDialogVideoView.this.hbQ.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cVZ - (duration % PushDialogVideoView.this.cVZ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbQ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i2) {
                int duration;
                if (PushDialogVideoView.this.dlL != null && (duration = PushDialogVideoView.this.dlL.getDuration()) > 0 && PushDialogVideoView.this.inS != null) {
                    PushDialogVideoView.this.inS.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioG = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void caX() {
                PushDialogVideoView.this.cIs.startLoading();
                PushDialogVideoView.this.gZr.setVisibility(0);
                PushDialogVideoView.this.gZq.setVisibility(8);
                PushDialogVideoView.this.inV.setVisibility(8);
                PushDialogVideoView.this.eAg.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZQ);
                e.iB().postDelayed(PushDialogVideoView.this.gZQ, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.af(context) - l.g(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dlL = (QuickVideoView) findViewById(R.id.videoView);
        this.cIs = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cIs.setLoadingAnimationListener(this.exx);
        this.inS = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.inS.setMax(this.mWidth);
        this.inS.setProgress(0);
        this.gZh = findViewById(R.id.black_mask);
        this.eAg = findViewById(R.id.layout_error);
        this.gZq = (ImageView) findViewById(R.id.img_play);
        this.inV = (TextView) findViewById(R.id.txt_replay);
        this.eef = (TextView) findViewById(R.id.push_dialog_video_time);
        this.gZr = (TbImageView) findViewById(R.id.video_thumbnail);
        this.hWH = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.gZr.setDefaultErrorResource(0);
        this.gZr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gZM = new CallStateReceiver();
        this.gZM.register(context);
        this.eAg.setOnClickListener(this);
        this.inV.setOnClickListener(this);
        this.hWH.setOnPlayClickListener(this);
        this.hWH.setFreeClickListener(this);
        setOnClickListener(this);
        this.dlL.setOnPreparedListener(this.cRS);
        this.dlL.setOnCompletionListener(this.cRR);
        this.dlL.setOnErrorListener(this.gZP);
        this.dlL.setOnSeekCompleteListener(this.cRV);
        this.dlL.setOnSurfaceDestroyedListener(this.cIB);
        this.dlL.setOnRecoveryCallback(this.ioG);
        onChangeSkinType();
    }

    public void onPause() {
        if (pg()) {
            this.hWw = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hWw = false;
        } else {
            this.hWw = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hWw) {
            bIr();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gZV);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.ivO = fVar;
        this.eef.setText(ap.im(this.ivO.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bUZ = str;
        this.bVL = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dlL.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        if (this.dlL != null && this.deB != null) {
            if (this.ioy) {
                this.dlL.start();
                this.ioy = false;
            }
            e.iB().removeCallbacks(this.Sy);
            e.iB().postDelayed(this.Sy, 20L);
            e.iB().removeCallbacks(this.gZQ);
            if (this.dlL.cbo()) {
                this.currentState = 1;
                this.dlL.setRecoveryState(1);
            }
            if (this.deB != null) {
                this.mStartPosition = y.cbS().Ck(this.bUZ);
                if (this.mStartPosition != 0) {
                    if (this.dlL != null) {
                        this.dlL.ys(this.mStartPosition);
                    } else {
                        this.deB.seekTo(this.mStartPosition);
                    }
                    if (!this.iox) {
                        showProgress();
                        e.iB().removeCallbacks(this.Sy);
                    }
                    this.ios = true;
                }
            }
        }
    }

    public void bWW() {
        if (!j.jS()) {
            l.E(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dlL.isPlaying()) {
            pausePlay();
        } else if (this.Ss) {
            bIr();
        } else {
            caK();
        }
    }

    public void setPauseState() {
        this.cIs.cbO();
        this.gZq.setVisibility(0);
        this.inV.setVisibility(8);
        this.currentState = 2;
        this.dlL.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.iot) {
            dQ(str, str2);
        } else {
            cr(str, str2);
        }
        if (aVar != null) {
            aVar.pO(z);
        }
    }

    public void cr(String str, String str2) {
        caL();
        this.ioy = true;
        this.currentState = 0;
        this.dlL.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dlL.setVideoPath(str, str2);
        this.cIs.startLoading();
        this.gZr.setVisibility(0);
        this.gZq.setVisibility(8);
        this.inV.setVisibility(8);
        this.eAg.setVisibility(8);
        e.iB().removeCallbacks(this.gZQ);
        e.iB().postDelayed(this.gZQ, 60000L);
    }

    public void dQ(String str, String str2) {
        caL();
        this.ioy = true;
        this.currentState = 0;
        this.dlL.setRecoveryState(0);
        this.cIs.startLoading();
        this.gZr.setVisibility(0);
        this.gZq.setVisibility(8);
        this.inV.setVisibility(8);
        this.eAg.setVisibility(8);
        e.iB().removeCallbacks(this.gZQ);
        e.iB().postDelayed(this.gZQ, 60000L);
    }

    public void bIr() {
        this.currentState = 1;
        this.dlL.setRecoveryState(1);
        this.dlL.start();
        this.gZr.setVisibility(8);
        this.gZh.setVisibility(8);
        this.cIs.cbO();
        showProgress();
        this.gZq.setVisibility(8);
        this.inV.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.jS() && this.iow && !StringUtils.isNull(this.bUZ) && !StringUtils.isNull(this.bVL)) {
            this.iow = false;
            this.iox = true;
            cr(this.bUZ, this.bVL);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dlL != null) {
            this.dlL.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dlL.isPlaying() && this.ior) {
            caJ();
        }
        this.dlL.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dlL.isPlaying() && this.ior) {
            caJ();
        }
        this.currentState = 5;
        this.dlL.setRecoveryState(5);
        e.iB().removeCallbacks(this.Sy);
        e.iB().removeCallbacks(this.gZQ);
        this.dlL.stopPlayback();
        this.Ss = false;
        this.ioy = false;
        this.mStartPosition = 0;
        bvq();
    }

    public void caJ() {
        y.cbS().bf(this.bUZ, this.dlL.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(boolean z) {
        this.gZh.setVisibility(0);
        this.gZq.setVisibility(0);
        this.inV.setVisibility(8);
        this.cIs.cbO();
        this.inS.setVisibility(8);
        this.eAg.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gZr.setVisibility(z ? 0 : 8);
    }

    public void bvq() {
        pJ(true);
    }

    public boolean pg() {
        if (this.dlL == null) {
            return false;
        }
        return this.dlL.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dlL == null) {
            return 0;
        }
        return this.dlL.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dlL != null) {
            this.inS.setVisibility(0);
            this.cVZ = ((this.dlL.getDuration() / 200) / 50) * 50;
            if (this.cVZ < 50) {
                this.cVZ = 50;
            } else if (this.cVZ > 500) {
                this.cVZ = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cVZ - (this.dlL.getCurrentPosition() % this.cVZ));
        }
    }

    private void caK() {
        a(this.bUZ, this.bVL, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        caL();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.iot = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.jU() && !this.hWQ && !com.baidu.tieba.video.g.cqQ().cqR()) {
            this.hWH.setVisibility(0);
            this.hWH.setData(this.ivO.getDuration(), this.ivO.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void caL() {
        if (j.jU()) {
            com.baidu.tieba.video.g.cqQ().en(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gZr.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAg) {
            caK();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 2).bT("tid", this.bVL));
            bWW();
        } else if (view == this.inV) {
            cr(this.bUZ, this.bVL);
        } else if (view == this.hWH.getTvPlay()) {
            this.hWQ = true;
            this.hWH.setVisibility(8);
            cr(this.bUZ, this.bVL);
        } else if (view == this.hWH.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.iB().removeCallbacks(this.Sy);
        e.iB().removeCallbacks(this.gZQ);
        e.iB().removeCallbacks(this.ioE);
        this.mHandler.removeMessages(1);
        this.gZM.unregister(getContext());
    }
}
