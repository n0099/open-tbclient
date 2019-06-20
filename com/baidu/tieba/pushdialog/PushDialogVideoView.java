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
    private boolean Sr;
    private Runnable Sx;
    private String bVM;
    private String bVa;
    private QuickVideoView.b cIC;
    private x cIt;
    private g.a cRT;
    private g.f cRU;
    private g.InterfaceC0388g cRX;
    private int cWb;
    private int currentState;
    private g deD;
    private QuickVideoView dlM;
    private View eAh;
    private TextView eeg;
    private VideoLoadingProgressView.a exy;
    private CallStateReceiver gZQ;
    private g.b gZT;
    private Runnable gZU;
    private CustomMessageListener gZZ;
    private View gZl;
    private ImageView gZu;
    private TbImageView gZv;
    private boolean hWA;
    private PbVideoWifiTipLayout hWL;
    private boolean hWU;
    private VideoControllerView.b hbU;
    private ProgressBar inW;
    private TextView inZ;
    private boolean ioA;
    private boolean ioB;
    private boolean ioC;
    private Runnable ioI;
    private QuickVideoView.a ioK;
    private boolean iov;
    private boolean iow;
    private boolean iox;
    private f ivS;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void pP(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.cWb = 50;
        this.mSkinType = 3;
        this.Sr = false;
        this.mStartPosition = 0;
        this.iov = true;
        this.iow = false;
        this.iox = false;
        this.currentState = -1;
        this.hWA = false;
        this.cRU = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deD = gVar;
                PushDialogVideoView.this.cIt.cbQ();
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXx();
            }
        };
        this.Sx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Sr = true;
                    PushDialogVideoView.this.gZl.setVisibility(8);
                    PushDialogVideoView.this.eAh.setVisibility(8);
                    PushDialogVideoView.this.cIt.cbR();
                    PushDialogVideoView.this.gZv.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sx, 20L);
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Sr = false;
                PushDialogVideoView.this.ioC = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZl.setVisibility(0);
                PushDialogVideoView.this.inW.setVisibility(8);
                PushDialogVideoView.this.inW.setProgress(PushDialogVideoView.this.inW.getMax());
                if (PushDialogVideoView.this.dlM == null || PushDialogVideoView.this.dlM.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.inZ.setVisibility(0);
                }
                y.cbW().remove(PushDialogVideoView.this.bVa);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlM.setRecoveryState(3);
                if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bVa, PushDialogVideoView.this.bVM);
                }
            }
        };
        this.gZT = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIt.cbS();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlM.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.ioA = true;
                }
                PushDialogVideoView.this.ioC = false;
                return true;
            }
        };
        this.gZU = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIt.cbS();
            }
        };
        this.cRX = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iow) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioI, 200L);
                }
            }
        };
        this.ioI = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM == null || !PushDialogVideoView.this.iow) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sx, 200L);
                    PushDialogVideoView.this.iow = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlM.getCurrentPosition()) {
                    PushDialogVideoView.this.iow = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sx, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioI, 200L);
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Sr = false;
                PushDialogVideoView.this.ioC = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sx);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZU);
            }
        };
        this.gZZ = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                            if (PushDialogVideoView.this.hbU != null) {
                                PushDialogVideoView.this.hbU.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cWb - (duration % PushDialogVideoView.this.cWb));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbU = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i) {
                int duration;
                if (PushDialogVideoView.this.dlM != null && (duration = PushDialogVideoView.this.dlM.getDuration()) > 0 && PushDialogVideoView.this.inW != null) {
                    PushDialogVideoView.this.inW.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioK = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbb() {
                PushDialogVideoView.this.cIt.startLoading();
                PushDialogVideoView.this.gZv.setVisibility(0);
                PushDialogVideoView.this.gZu.setVisibility(8);
                PushDialogVideoView.this.inZ.setVisibility(8);
                PushDialogVideoView.this.eAh.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZU);
                e.iB().postDelayed(PushDialogVideoView.this.gZU, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWb = 50;
        this.mSkinType = 3;
        this.Sr = false;
        this.mStartPosition = 0;
        this.iov = true;
        this.iow = false;
        this.iox = false;
        this.currentState = -1;
        this.hWA = false;
        this.cRU = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deD = gVar;
                PushDialogVideoView.this.cIt.cbQ();
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXx();
            }
        };
        this.Sx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Sr = true;
                    PushDialogVideoView.this.gZl.setVisibility(8);
                    PushDialogVideoView.this.eAh.setVisibility(8);
                    PushDialogVideoView.this.cIt.cbR();
                    PushDialogVideoView.this.gZv.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sx, 20L);
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Sr = false;
                PushDialogVideoView.this.ioC = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZl.setVisibility(0);
                PushDialogVideoView.this.inW.setVisibility(8);
                PushDialogVideoView.this.inW.setProgress(PushDialogVideoView.this.inW.getMax());
                if (PushDialogVideoView.this.dlM == null || PushDialogVideoView.this.dlM.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.inZ.setVisibility(0);
                }
                y.cbW().remove(PushDialogVideoView.this.bVa);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlM.setRecoveryState(3);
                if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bVa, PushDialogVideoView.this.bVM);
                }
            }
        };
        this.gZT = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIt.cbS();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlM.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.ioA = true;
                }
                PushDialogVideoView.this.ioC = false;
                return true;
            }
        };
        this.gZU = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIt.cbS();
            }
        };
        this.cRX = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iow) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioI, 200L);
                }
            }
        };
        this.ioI = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM == null || !PushDialogVideoView.this.iow) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sx, 200L);
                    PushDialogVideoView.this.iow = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlM.getCurrentPosition()) {
                    PushDialogVideoView.this.iow = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sx, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioI, 200L);
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Sr = false;
                PushDialogVideoView.this.ioC = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sx);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZU);
            }
        };
        this.gZZ = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                            if (PushDialogVideoView.this.hbU != null) {
                                PushDialogVideoView.this.hbU.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cWb - (duration % PushDialogVideoView.this.cWb));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbU = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i) {
                int duration;
                if (PushDialogVideoView.this.dlM != null && (duration = PushDialogVideoView.this.dlM.getDuration()) > 0 && PushDialogVideoView.this.inW != null) {
                    PushDialogVideoView.this.inW.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioK = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbb() {
                PushDialogVideoView.this.cIt.startLoading();
                PushDialogVideoView.this.gZv.setVisibility(0);
                PushDialogVideoView.this.gZu.setVisibility(8);
                PushDialogVideoView.this.inZ.setVisibility(8);
                PushDialogVideoView.this.eAh.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZU);
                e.iB().postDelayed(PushDialogVideoView.this.gZU, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWb = 50;
        this.mSkinType = 3;
        this.Sr = false;
        this.mStartPosition = 0;
        this.iov = true;
        this.iow = false;
        this.iox = false;
        this.currentState = -1;
        this.hWA = false;
        this.cRU = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.deD = gVar;
                PushDialogVideoView.this.cIt.cbQ();
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aXx();
            }
        };
        this.Sx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Sr = true;
                    PushDialogVideoView.this.gZl.setVisibility(8);
                    PushDialogVideoView.this.eAh.setVisibility(8);
                    PushDialogVideoView.this.cIt.cbR();
                    PushDialogVideoView.this.gZv.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iB().postDelayed(PushDialogVideoView.this.Sx, 20L);
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Sr = false;
                PushDialogVideoView.this.ioC = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gZl.setVisibility(0);
                PushDialogVideoView.this.inW.setVisibility(8);
                PushDialogVideoView.this.inW.setProgress(PushDialogVideoView.this.inW.getMax());
                if (PushDialogVideoView.this.dlM == null || PushDialogVideoView.this.dlM.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.inZ.setVisibility(0);
                }
                y.cbW().remove(PushDialogVideoView.this.bVa);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dlM.setRecoveryState(3);
                if (PushDialogVideoView.this.dlM != null && PushDialogVideoView.this.dlM.getDuration() <= 150000) {
                    PushDialogVideoView.this.cr(PushDialogVideoView.this.bVa, PushDialogVideoView.this.bVM);
                }
            }
        };
        this.gZT = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIt.cbS();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dlM.setRecoveryState(4);
                if (!j.jS()) {
                    PushDialogVideoView.this.ioA = true;
                }
                PushDialogVideoView.this.ioC = false;
                return true;
            }
        };
        this.gZU = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eAh.setVisibility(0);
                PushDialogVideoView.this.cIt.cbS();
            }
        };
        this.cRX = new g.InterfaceC0388g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iow) {
                    e.iB().postDelayed(PushDialogVideoView.this.ioI, 200L);
                }
            }
        };
        this.ioI = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dlM == null || !PushDialogVideoView.this.iow) {
                    e.iB().postDelayed(PushDialogVideoView.this.Sx, 200L);
                    PushDialogVideoView.this.iow = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dlM.getCurrentPosition()) {
                    PushDialogVideoView.this.iow = false;
                    e.iB().postDelayed(PushDialogVideoView.this.Sx, 20L);
                } else {
                    e.iB().postDelayed(PushDialogVideoView.this.ioI, 200L);
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Sr = false;
                PushDialogVideoView.this.ioC = false;
                e.iB().removeCallbacks(PushDialogVideoView.this.Sx);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZU);
            }
        };
        this.gZZ = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                            if (PushDialogVideoView.this.hbU != null) {
                                PushDialogVideoView.this.hbU.mn(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cWb - (duration % PushDialogVideoView.this.cWb));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hbU = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mn(int i2) {
                int duration;
                if (PushDialogVideoView.this.dlM != null && (duration = PushDialogVideoView.this.dlM.getDuration()) > 0 && PushDialogVideoView.this.inW != null) {
                    PushDialogVideoView.this.inW.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ioK = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbb() {
                PushDialogVideoView.this.cIt.startLoading();
                PushDialogVideoView.this.gZv.setVisibility(0);
                PushDialogVideoView.this.gZu.setVisibility(8);
                PushDialogVideoView.this.inZ.setVisibility(8);
                PushDialogVideoView.this.eAh.setVisibility(8);
                e.iB().removeCallbacks(PushDialogVideoView.this.gZU);
                e.iB().postDelayed(PushDialogVideoView.this.gZU, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.af(context) - l.g(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dlM = (QuickVideoView) findViewById(R.id.videoView);
        this.cIt = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cIt.setLoadingAnimationListener(this.exy);
        this.inW = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.inW.setMax(this.mWidth);
        this.inW.setProgress(0);
        this.gZl = findViewById(R.id.black_mask);
        this.eAh = findViewById(R.id.layout_error);
        this.gZu = (ImageView) findViewById(R.id.img_play);
        this.inZ = (TextView) findViewById(R.id.txt_replay);
        this.eeg = (TextView) findViewById(R.id.push_dialog_video_time);
        this.gZv = (TbImageView) findViewById(R.id.video_thumbnail);
        this.hWL = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.gZv.setDefaultErrorResource(0);
        this.gZv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gZQ = new CallStateReceiver();
        this.gZQ.register(context);
        this.eAh.setOnClickListener(this);
        this.inZ.setOnClickListener(this);
        this.hWL.setOnPlayClickListener(this);
        this.hWL.setFreeClickListener(this);
        setOnClickListener(this);
        this.dlM.setOnPreparedListener(this.cRU);
        this.dlM.setOnCompletionListener(this.cRT);
        this.dlM.setOnErrorListener(this.gZT);
        this.dlM.setOnSeekCompleteListener(this.cRX);
        this.dlM.setOnSurfaceDestroyedListener(this.cIC);
        this.dlM.setOnRecoveryCallback(this.ioK);
        onChangeSkinType();
    }

    public void onPause() {
        if (pg()) {
            this.hWA = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hWA = false;
        } else {
            this.hWA = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hWA) {
            bIv();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gZZ);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.ivS = fVar;
        this.eeg.setText(ap.im(this.ivS.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bVa = str;
        this.bVM = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dlM.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.dlM != null && this.deD != null) {
            if (this.ioC) {
                this.dlM.start();
                this.ioC = false;
            }
            e.iB().removeCallbacks(this.Sx);
            e.iB().postDelayed(this.Sx, 20L);
            e.iB().removeCallbacks(this.gZU);
            if (this.dlM.cbs()) {
                this.currentState = 1;
                this.dlM.setRecoveryState(1);
            }
            if (this.deD != null) {
                this.mStartPosition = y.cbW().Cm(this.bVa);
                if (this.mStartPosition != 0) {
                    if (this.dlM != null) {
                        this.dlM.ys(this.mStartPosition);
                    } else {
                        this.deD.seekTo(this.mStartPosition);
                    }
                    if (!this.ioB) {
                        showProgress();
                        e.iB().removeCallbacks(this.Sx);
                    }
                    this.iow = true;
                }
            }
        }
    }

    public void bXa() {
        if (!j.jS()) {
            l.E(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dlM.isPlaying()) {
            pausePlay();
        } else if (this.Sr) {
            bIv();
        } else {
            caO();
        }
    }

    public void setPauseState() {
        this.cIt.cbS();
        this.gZu.setVisibility(0);
        this.inZ.setVisibility(8);
        this.currentState = 2;
        this.dlM.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.iox) {
            dQ(str, str2);
        } else {
            cr(str, str2);
        }
        if (aVar != null) {
            aVar.pP(z);
        }
    }

    public void cr(String str, String str2) {
        caP();
        this.ioC = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dlM.setVideoPath(str, str2);
        this.cIt.startLoading();
        this.gZv.setVisibility(0);
        this.gZu.setVisibility(8);
        this.inZ.setVisibility(8);
        this.eAh.setVisibility(8);
        e.iB().removeCallbacks(this.gZU);
        e.iB().postDelayed(this.gZU, 60000L);
    }

    public void dQ(String str, String str2) {
        caP();
        this.ioC = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        this.cIt.startLoading();
        this.gZv.setVisibility(0);
        this.gZu.setVisibility(8);
        this.inZ.setVisibility(8);
        this.eAh.setVisibility(8);
        e.iB().removeCallbacks(this.gZU);
        e.iB().postDelayed(this.gZU, 60000L);
    }

    public void bIv() {
        this.currentState = 1;
        this.dlM.setRecoveryState(1);
        this.dlM.start();
        this.gZv.setVisibility(8);
        this.gZl.setVisibility(8);
        this.cIt.cbS();
        showProgress();
        this.gZu.setVisibility(8);
        this.inZ.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.jS() && this.ioA && !StringUtils.isNull(this.bVa) && !StringUtils.isNull(this.bVM)) {
            this.ioA = false;
            this.ioB = true;
            cr(this.bVa, this.bVM);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dlM != null) {
            this.dlM.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dlM.isPlaying() && this.iov) {
            caN();
        }
        this.dlM.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dlM.isPlaying() && this.iov) {
            caN();
        }
        this.currentState = 5;
        this.dlM.setRecoveryState(5);
        e.iB().removeCallbacks(this.Sx);
        e.iB().removeCallbacks(this.gZU);
        this.dlM.stopPlayback();
        this.Sr = false;
        this.ioC = false;
        this.mStartPosition = 0;
        bvu();
    }

    public void caN() {
        y.cbW().bf(this.bVa, this.dlM.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(boolean z) {
        this.gZl.setVisibility(0);
        this.gZu.setVisibility(0);
        this.inZ.setVisibility(8);
        this.cIt.cbS();
        this.inW.setVisibility(8);
        this.eAh.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gZv.setVisibility(z ? 0 : 8);
    }

    public void bvu() {
        pK(true);
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
            this.inW.setVisibility(0);
            this.cWb = ((this.dlM.getDuration() / 200) / 50) * 50;
            if (this.cWb < 50) {
                this.cWb = 50;
            } else if (this.cWb > 500) {
                this.cWb = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cWb - (this.dlM.getCurrentPosition() % this.cWb));
        }
    }

    private void caO() {
        a(this.bVa, this.bVM, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        caP();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.iox = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.jU() && !this.hWU && !com.baidu.tieba.video.g.cqT().cqU()) {
            this.hWL.setVisibility(0);
            this.hWL.setData(this.ivS.getDuration(), this.ivS.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void caP() {
        if (j.jU()) {
            com.baidu.tieba.video.g.cqT().en(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gZv.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAh) {
            caO();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").P("obj_locate", 2).bT("tid", this.bVM));
            bXa();
        } else if (view == this.inZ) {
            cr(this.bVa, this.bVM);
        } else if (view == this.hWL.getTvPlay()) {
            this.hWU = true;
            this.hWL.setVisibility(8);
            cr(this.bVa, this.bVM);
        } else if (view == this.hWL.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.iB().removeCallbacks(this.Sx);
        e.iB().removeCallbacks(this.gZU);
        e.iB().removeCallbacks(this.ioI);
        this.mHandler.removeMessages(1);
        this.gZQ.unregister(getContext());
    }
}
