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
    private g.a cRS;
    private g.f cRT;
    private g.InterfaceC0388g cRW;
    private int cWa;
    private int currentState;
    private g deC;
    private QuickVideoView dlM;
    private View eAh;
    private TextView eeg;
    private VideoLoadingProgressView.a exy;
    private CallStateReceiver gZP;
    private g.b gZS;
    private Runnable gZT;
    private CustomMessageListener gZY;
    private View gZk;
    private ImageView gZt;
    private TbImageView gZu;
    private PbVideoWifiTipLayout hWK;
    private boolean hWT;
    private boolean hWz;
    private VideoControllerView.b hbT;
    private ProgressBar inV;
    private TextView inY;
    private boolean ioA;
    private boolean ioB;
    private Runnable ioH;
    private QuickVideoView.a ioJ;
    private boolean iou;
    private boolean iov;
    private boolean iow;
    private boolean ioz;
    private f ivR;
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
        this.cWa = 50;
        this.mSkinType = 3;
        this.Ss = false;
        this.mStartPosition = 0;
        this.iou = true;
        this.iov = false;
        this.iow = false;
        this.currentState = -1;
        this.hWz = false;
        this.cRT = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deC = gVar;
                PushDialogVideoView.this.cIs.cbP();
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXx();
            }
        };
        this.Sy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ss = true;
                    PushDialogVideoView.this.gZk.setVisibility(8);
                    PushDialogVideoView.this.eAh.setVisibility(8);
                    PushDialogVideoView.this.cIs.cbQ();
                    PushDialogVideoView.this.gZu.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioB = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZk.setVisibility(0);
                PushDialogVideoView.this.inV.setVisibility(8);
                PushDialogVideoView.this.inV.setProgress(PushDialogVideoView.this.inV.getMax());
                if (PushDialogVideoView.this.dlM == null || PushDialogVideoView.this.dlM.getDuration() > 150000) {
                    PushDialogVideoView.this.pJ(false);
                } else {
                    PushDialogVideoView.this.inY.setVisibility(0);
                }
                y.cbV().remove(PushDialogVideoView.this.bUZ);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlM.setRecoveryState(3);
                if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bUZ, PushDialogVideoView.this.bVL);
                }
            }
        };
        this.gZS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIs.cbR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlM.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.ioz = true;
                }
                PushDialogVideoView.this.ioB = false;
                return true;
            }
        };
        this.gZT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIs.cbR();
            }
        };
        this.cRW = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iov) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioH, 200L);
                }
            }
        };
        this.ioH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM == null || !PushDialogVideoView.this.iov) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 200L);
                    PushDialogVideoView.this.iov = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlM.getCurrentPosition()) {
                    PushDialogVideoView.this.iov = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioH, 200L);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioB = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sy);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZT);
            }
        };
        this.gZY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dlM.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dlM.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hbT != null) {
                                PushDialogVideoView.this.hbT.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cWa - (duration % PushDialogVideoView.this.cWa));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i) {
                int duration;
                if (PushDialogVideoView.this.dlM != null && (duration = PushDialogVideoView.this.dlM.getDuration()) > 0 && PushDialogVideoView.this.inV != null) {
                    PushDialogVideoView.this.inV.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioJ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cba() {
                PushDialogVideoView.this.cIs.startLoading();
                PushDialogVideoView.this.gZu.setVisibility(0);
                PushDialogVideoView.this.gZt.setVisibility(8);
                PushDialogVideoView.this.inY.setVisibility(8);
                PushDialogVideoView.this.eAh.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZT);
                e.iB().postDelayed(PushDialogVideoView.this.gZT, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWa = 50;
        this.mSkinType = 3;
        this.Ss = false;
        this.mStartPosition = 0;
        this.iou = true;
        this.iov = false;
        this.iow = false;
        this.currentState = -1;
        this.hWz = false;
        this.cRT = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deC = gVar;
                PushDialogVideoView.this.cIs.cbP();
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXx();
            }
        };
        this.Sy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ss = true;
                    PushDialogVideoView.this.gZk.setVisibility(8);
                    PushDialogVideoView.this.eAh.setVisibility(8);
                    PushDialogVideoView.this.cIs.cbQ();
                    PushDialogVideoView.this.gZu.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioB = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZk.setVisibility(0);
                PushDialogVideoView.this.inV.setVisibility(8);
                PushDialogVideoView.this.inV.setProgress(PushDialogVideoView.this.inV.getMax());
                if (PushDialogVideoView.this.dlM == null || PushDialogVideoView.this.dlM.getDuration() > 150000) {
                    PushDialogVideoView.this.pJ(false);
                } else {
                    PushDialogVideoView.this.inY.setVisibility(0);
                }
                y.cbV().remove(PushDialogVideoView.this.bUZ);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlM.setRecoveryState(3);
                if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bUZ, PushDialogVideoView.this.bVL);
                }
            }
        };
        this.gZS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIs.cbR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlM.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.ioz = true;
                }
                PushDialogVideoView.this.ioB = false;
                return true;
            }
        };
        this.gZT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIs.cbR();
            }
        };
        this.cRW = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iov) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioH, 200L);
                }
            }
        };
        this.ioH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM == null || !PushDialogVideoView.this.iov) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 200L);
                    PushDialogVideoView.this.iov = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlM.getCurrentPosition()) {
                    PushDialogVideoView.this.iov = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioH, 200L);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioB = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sy);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZT);
            }
        };
        this.gZY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dlM.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dlM.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hbT != null) {
                                PushDialogVideoView.this.hbT.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cWa - (duration % PushDialogVideoView.this.cWa));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i) {
                int duration;
                if (PushDialogVideoView.this.dlM != null && (duration = PushDialogVideoView.this.dlM.getDuration()) > 0 && PushDialogVideoView.this.inV != null) {
                    PushDialogVideoView.this.inV.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioJ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cba() {
                PushDialogVideoView.this.cIs.startLoading();
                PushDialogVideoView.this.gZu.setVisibility(0);
                PushDialogVideoView.this.gZt.setVisibility(8);
                PushDialogVideoView.this.inY.setVisibility(8);
                PushDialogVideoView.this.eAh.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZT);
                e.iB().postDelayed(PushDialogVideoView.this.gZT, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWa = 50;
        this.mSkinType = 3;
        this.Ss = false;
        this.mStartPosition = 0;
        this.iou = true;
        this.iov = false;
        this.iow = false;
        this.currentState = -1;
        this.hWz = false;
        this.cRT = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deC = gVar;
                PushDialogVideoView.this.cIs.cbP();
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXx();
            }
        };
        this.Sy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ss = true;
                    PushDialogVideoView.this.gZk.setVisibility(8);
                    PushDialogVideoView.this.eAh.setVisibility(8);
                    PushDialogVideoView.this.cIs.cbQ();
                    PushDialogVideoView.this.gZu.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioB = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZk.setVisibility(0);
                PushDialogVideoView.this.inV.setVisibility(8);
                PushDialogVideoView.this.inV.setProgress(PushDialogVideoView.this.inV.getMax());
                if (PushDialogVideoView.this.dlM == null || PushDialogVideoView.this.dlM.getDuration() > 150000) {
                    PushDialogVideoView.this.pJ(false);
                } else {
                    PushDialogVideoView.this.inY.setVisibility(0);
                }
                y.cbV().remove(PushDialogVideoView.this.bUZ);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlM.setRecoveryState(3);
                if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bUZ, PushDialogVideoView.this.bVL);
                }
            }
        };
        this.gZS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIs.cbR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlM.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.ioz = true;
                }
                PushDialogVideoView.this.ioB = false;
                return true;
            }
        };
        this.gZT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIs.cbR();
            }
        };
        this.cRW = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iov) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioH, 200L);
                }
            }
        };
        this.ioH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM == null || !PushDialogVideoView.this.iov) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 200L);
                    PushDialogVideoView.this.iov = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlM.getCurrentPosition()) {
                    PushDialogVideoView.this.iov = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sy, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioH, 200L);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ss = false;
                PushDialogVideoView.this.ioB = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sy);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZT);
            }
        };
        this.gZY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dlM.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dlM.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hbT != null) {
                                PushDialogVideoView.this.hbT.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cWa - (duration % PushDialogVideoView.this.cWa));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i2) {
                int duration;
                if (PushDialogVideoView.this.dlM != null && (duration = PushDialogVideoView.this.dlM.getDuration()) > 0 && PushDialogVideoView.this.inV != null) {
                    PushDialogVideoView.this.inV.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioJ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cba() {
                PushDialogVideoView.this.cIs.startLoading();
                PushDialogVideoView.this.gZu.setVisibility(0);
                PushDialogVideoView.this.gZt.setVisibility(8);
                PushDialogVideoView.this.inY.setVisibility(8);
                PushDialogVideoView.this.eAh.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZT);
                e.iB().postDelayed(PushDialogVideoView.this.gZT, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.af(context) - l.g(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dlM = (QuickVideoView) findViewById(R.id.videoView);
        this.cIs = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cIs.setLoadingAnimationListener(this.exy);
        this.inV = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.inV.setMax(this.mWidth);
        this.inV.setProgress(0);
        this.gZk = findViewById(R.id.black_mask);
        this.eAh = findViewById(R.id.layout_error);
        this.gZt = (ImageView) findViewById(R.id.img_play);
        this.inY = (TextView) findViewById(R.id.txt_replay);
        this.eeg = (TextView) findViewById(R.id.push_dialog_video_time);
        this.gZu = (TbImageView) findViewById(R.id.video_thumbnail);
        this.hWK = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.gZu.setDefaultErrorResource(0);
        this.gZu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gZP = new CallStateReceiver();
        this.gZP.register(context);
        this.eAh.setOnClickListener(this);
        this.inY.setOnClickListener(this);
        this.hWK.setOnPlayClickListener(this);
        this.hWK.setFreeClickListener(this);
        setOnClickListener(this);
        this.dlM.setOnPreparedListener(this.cRT);
        this.dlM.setOnCompletionListener(this.cRS);
        this.dlM.setOnErrorListener(this.gZS);
        this.dlM.setOnSeekCompleteListener(this.cRW);
        this.dlM.setOnSurfaceDestroyedListener(this.cIB);
        this.dlM.setOnRecoveryCallback(this.ioJ);
        onChangeSkinType();
    }

    public void onPause() {
        if (pg()) {
            this.hWz = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hWz = false;
        } else {
            this.hWz = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hWz) {
            bIu();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gZY);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.ivR = fVar;
        this.eeg.setText(ap.im(this.ivR.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bUZ = str;
        this.bVL = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dlM.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.dlM != null && this.deC != null) {
            if (this.ioB) {
                this.dlM.start();
                this.ioB = false;
            }
            e.iB().removeCallbacks(this.Sy);
            e.iB().postDelayed(this.Sy, 20L);
            e.iB().removeCallbacks(this.gZT);
            if (this.dlM.cbr()) {
                this.currentState = 1;
                this.dlM.setRecoveryState(1);
            }
            if (this.deC != null) {
                this.mStartPosition = y.cbV().Ck(this.bUZ);
                if (this.mStartPosition != 0) {
                    if (this.dlM != null) {
                        this.dlM.ys(this.mStartPosition);
                    } else {
                        this.deC.seekTo(this.mStartPosition);
                    }
                    if (!this.ioA) {
                        showProgress();
                        e.iB().removeCallbacks(this.Sy);
                    }
                    this.iov = true;
                }
            }
        }
    }

    public void bWZ() {
        if (!j.jS()) {
            l.E(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dlM.isPlaying()) {
            pausePlay();
        } else if (this.Ss) {
            bIu();
        } else {
            caN();
        }
    }

    public void setPauseState() {
        this.cIs.cbR();
        this.gZt.setVisibility(0);
        this.inY.setVisibility(8);
        this.currentState = 2;
        this.dlM.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.iow) {
            dQ(str, str2);
        } else {
            cr(str, str2);
        }
        if (aVar != null) {
            aVar.pO(z);
        }
    }

    public void cr(String str, String str2) {
        caO();
        this.ioB = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dlM.setVideoPath(str, str2);
        this.cIs.startLoading();
        this.gZu.setVisibility(0);
        this.gZt.setVisibility(8);
        this.inY.setVisibility(8);
        this.eAh.setVisibility(8);
        e.iB().removeCallbacks(this.gZT);
        e.iB().postDelayed(this.gZT, 60000L);
    }

    public void dQ(String str, String str2) {
        caO();
        this.ioB = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        this.cIs.startLoading();
        this.gZu.setVisibility(0);
        this.gZt.setVisibility(8);
        this.inY.setVisibility(8);
        this.eAh.setVisibility(8);
        e.iB().removeCallbacks(this.gZT);
        e.iB().postDelayed(this.gZT, 60000L);
    }

    public void bIu() {
        this.currentState = 1;
        this.dlM.setRecoveryState(1);
        this.dlM.start();
        this.gZu.setVisibility(8);
        this.gZk.setVisibility(8);
        this.cIs.cbR();
        showProgress();
        this.gZt.setVisibility(8);
        this.inY.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.jS() && this.ioz && !StringUtils.isNull(this.bUZ) && !StringUtils.isNull(this.bVL)) {
            this.ioz = false;
            this.ioA = true;
            cr(this.bUZ, this.bVL);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dlM != null) {
            this.dlM.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dlM.isPlaying() && this.iou) {
            caM();
        }
        this.dlM.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dlM.isPlaying() && this.iou) {
            caM();
        }
        this.currentState = 5;
        this.dlM.setRecoveryState(5);
        e.iB().removeCallbacks(this.Sy);
        e.iB().removeCallbacks(this.gZT);
        this.dlM.stopPlayback();
        this.Ss = false;
        this.ioB = false;
        this.mStartPosition = 0;
        bvt();
    }

    public void caM() {
        y.cbV().bf(this.bUZ, this.dlM.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(boolean z) {
        this.gZk.setVisibility(0);
        this.gZt.setVisibility(0);
        this.inY.setVisibility(8);
        this.cIs.cbR();
        this.inV.setVisibility(8);
        this.eAh.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gZu.setVisibility(z ? 0 : 8);
    }

    public void bvt() {
        pJ(true);
    }

    public boolean pg() {
        if (this.dlM == null) {
            return false;
        }
        return this.dlM.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dlM == null) {
            return 0;
        }
        return this.dlM.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dlM != null) {
            this.inV.setVisibility(0);
            this.cWa = ((this.dlM.getDuration() / 200) / 50) * 50;
            if (this.cWa < 50) {
                this.cWa = 50;
            } else if (this.cWa > 500) {
                this.cWa = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cWa - (this.dlM.getCurrentPosition() % this.cWa));
        }
    }

    private void caN() {
        a(this.bUZ, this.bVL, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        caO();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.iow = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.jU() && !this.hWT && !com.baidu.tieba.video.g.cqS().cqT()) {
            this.hWK.setVisibility(0);
            this.hWK.setData(this.ivR.getDuration(), this.ivR.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void caO() {
        if (j.jU()) {
            com.baidu.tieba.video.g.cqS().en(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gZu.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAh) {
            caN();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 2).bT("tid", this.bVL));
            bWZ();
        } else if (view == this.inY) {
            cr(this.bUZ, this.bVL);
        } else if (view == this.hWK.getTvPlay()) {
            this.hWT = true;
            this.hWK.setVisibility(8);
            cr(this.bUZ, this.bVL);
        } else if (view == this.hWK.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.iB().removeCallbacks(this.gZT);
        e.iB().removeCallbacks(this.ioH);
        this.mHandler.removeMessages(1);
        this.gZP.unregister(getContext());
    }
}
