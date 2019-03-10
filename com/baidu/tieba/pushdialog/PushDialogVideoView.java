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
    private boolean UF;
    private Runnable UL;
    private String bNk;
    private x cAk;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.InterfaceC0295g cJM;
    private int cNO;
    private String ctx;
    private int currentState;
    private TextView dUq;
    private QuickVideoView dbg;
    private g ehP;
    private VideoLoadingProgressView.a eib;
    private View ekJ;
    private CallStateReceiver gIF;
    private g.b gII;
    private Runnable gIJ;
    private CustomMessageListener gIO;
    private View gIa;
    private ImageView gIj;
    private TbImageView gIk;
    private VideoControllerView.b gKJ;
    private boolean hEP;
    private PbVideoWifiTipLayout hFa;
    private boolean hFj;
    private TextView hVC;
    private boolean hVY;
    private boolean hVZ;
    private ProgressBar hVz;
    private boolean hWa;
    private boolean hWd;
    private boolean hWe;
    private boolean hWf;
    private Runnable hWl;
    private QuickVideoView.a hWn;
    private f idF;
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
        this.cNO = 50;
        this.mSkinType = 3;
        this.UF = false;
        this.mStartPosition = 0;
        this.hVY = true;
        this.hVZ = false;
        this.hWa = false;
        this.currentState = -1;
        this.hEP = false;
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehP = gVar;
                PushDialogVideoView.this.cAk.bTN();
            }
        };
        this.eib = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQo();
            }
        };
        this.UL = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UF = true;
                    PushDialogVideoView.this.gIa.setVisibility(8);
                    PushDialogVideoView.this.ekJ.setVisibility(8);
                    PushDialogVideoView.this.cAk.bTO();
                    PushDialogVideoView.this.gIk.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UL, 20L);
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UF = false;
                PushDialogVideoView.this.hWf = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gIa.setVisibility(0);
                PushDialogVideoView.this.hVz.setVisibility(8);
                PushDialogVideoView.this.hVz.setProgress(PushDialogVideoView.this.hVz.getMax());
                if (PushDialogVideoView.this.dbg == null || PushDialogVideoView.this.dbg.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVC.setVisibility(0);
                }
                y.bTT().remove(PushDialogVideoView.this.bNk);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbg.setRecoveryState(3);
                if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNk, PushDialogVideoView.this.ctx);
                }
            }
        };
        this.gII = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ekJ.setVisibility(0);
                PushDialogVideoView.this.cAk.bTP();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbg.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hWd = true;
                }
                PushDialogVideoView.this.hWf = false;
                return true;
            }
        };
        this.gIJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekJ.setVisibility(0);
                PushDialogVideoView.this.cAk.bTP();
            }
        };
        this.cJM = new g.InterfaceC0295g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVZ) {
                    e.jH().postDelayed(PushDialogVideoView.this.hWl, 200L);
                }
            }
        };
        this.hWl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg == null || !PushDialogVideoView.this.hVZ) {
                    e.jH().postDelayed(PushDialogVideoView.this.UL, 200L);
                    PushDialogVideoView.this.hVZ = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbg.getCurrentPosition()) {
                    PushDialogVideoView.this.hVZ = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UL, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hWl, 200L);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UF = false;
                PushDialogVideoView.this.hWf = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UL);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIJ);
            }
        };
        this.gIO = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbg.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbg.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKJ != null) {
                                PushDialogVideoView.this.gKJ.lz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNO - (duration % PushDialogVideoView.this.cNO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKJ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lz(int i) {
                int duration;
                if (PushDialogVideoView.this.dbg != null && (duration = PushDialogVideoView.this.dbg.getDuration()) > 0 && PushDialogVideoView.this.hVz != null) {
                    PushDialogVideoView.this.hVz.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hWn = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSY() {
                PushDialogVideoView.this.cAk.startLoading();
                PushDialogVideoView.this.gIk.setVisibility(0);
                PushDialogVideoView.this.gIj.setVisibility(8);
                PushDialogVideoView.this.hVC.setVisibility(8);
                PushDialogVideoView.this.ekJ.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIJ);
                e.jH().postDelayed(PushDialogVideoView.this.gIJ, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNO = 50;
        this.mSkinType = 3;
        this.UF = false;
        this.mStartPosition = 0;
        this.hVY = true;
        this.hVZ = false;
        this.hWa = false;
        this.currentState = -1;
        this.hEP = false;
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehP = gVar;
                PushDialogVideoView.this.cAk.bTN();
            }
        };
        this.eib = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQo();
            }
        };
        this.UL = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UF = true;
                    PushDialogVideoView.this.gIa.setVisibility(8);
                    PushDialogVideoView.this.ekJ.setVisibility(8);
                    PushDialogVideoView.this.cAk.bTO();
                    PushDialogVideoView.this.gIk.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UL, 20L);
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UF = false;
                PushDialogVideoView.this.hWf = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gIa.setVisibility(0);
                PushDialogVideoView.this.hVz.setVisibility(8);
                PushDialogVideoView.this.hVz.setProgress(PushDialogVideoView.this.hVz.getMax());
                if (PushDialogVideoView.this.dbg == null || PushDialogVideoView.this.dbg.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVC.setVisibility(0);
                }
                y.bTT().remove(PushDialogVideoView.this.bNk);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbg.setRecoveryState(3);
                if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNk, PushDialogVideoView.this.ctx);
                }
            }
        };
        this.gII = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ekJ.setVisibility(0);
                PushDialogVideoView.this.cAk.bTP();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbg.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hWd = true;
                }
                PushDialogVideoView.this.hWf = false;
                return true;
            }
        };
        this.gIJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekJ.setVisibility(0);
                PushDialogVideoView.this.cAk.bTP();
            }
        };
        this.cJM = new g.InterfaceC0295g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVZ) {
                    e.jH().postDelayed(PushDialogVideoView.this.hWl, 200L);
                }
            }
        };
        this.hWl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg == null || !PushDialogVideoView.this.hVZ) {
                    e.jH().postDelayed(PushDialogVideoView.this.UL, 200L);
                    PushDialogVideoView.this.hVZ = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbg.getCurrentPosition()) {
                    PushDialogVideoView.this.hVZ = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UL, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hWl, 200L);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UF = false;
                PushDialogVideoView.this.hWf = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UL);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIJ);
            }
        };
        this.gIO = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbg.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbg.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKJ != null) {
                                PushDialogVideoView.this.gKJ.lz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNO - (duration % PushDialogVideoView.this.cNO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKJ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lz(int i) {
                int duration;
                if (PushDialogVideoView.this.dbg != null && (duration = PushDialogVideoView.this.dbg.getDuration()) > 0 && PushDialogVideoView.this.hVz != null) {
                    PushDialogVideoView.this.hVz.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hWn = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSY() {
                PushDialogVideoView.this.cAk.startLoading();
                PushDialogVideoView.this.gIk.setVisibility(0);
                PushDialogVideoView.this.gIj.setVisibility(8);
                PushDialogVideoView.this.hVC.setVisibility(8);
                PushDialogVideoView.this.ekJ.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIJ);
                e.jH().postDelayed(PushDialogVideoView.this.gIJ, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNO = 50;
        this.mSkinType = 3;
        this.UF = false;
        this.mStartPosition = 0;
        this.hVY = true;
        this.hVZ = false;
        this.hWa = false;
        this.currentState = -1;
        this.hEP = false;
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehP = gVar;
                PushDialogVideoView.this.cAk.bTN();
            }
        };
        this.eib = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQo();
            }
        };
        this.UL = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UF = true;
                    PushDialogVideoView.this.gIa.setVisibility(8);
                    PushDialogVideoView.this.ekJ.setVisibility(8);
                    PushDialogVideoView.this.cAk.bTO();
                    PushDialogVideoView.this.gIk.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UL, 20L);
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UF = false;
                PushDialogVideoView.this.hWf = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gIa.setVisibility(0);
                PushDialogVideoView.this.hVz.setVisibility(8);
                PushDialogVideoView.this.hVz.setProgress(PushDialogVideoView.this.hVz.getMax());
                if (PushDialogVideoView.this.dbg == null || PushDialogVideoView.this.dbg.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVC.setVisibility(0);
                }
                y.bTT().remove(PushDialogVideoView.this.bNk);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbg.setRecoveryState(3);
                if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNk, PushDialogVideoView.this.ctx);
                }
            }
        };
        this.gII = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.ekJ.setVisibility(0);
                PushDialogVideoView.this.cAk.bTP();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbg.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hWd = true;
                }
                PushDialogVideoView.this.hWf = false;
                return true;
            }
        };
        this.gIJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ekJ.setVisibility(0);
                PushDialogVideoView.this.cAk.bTP();
            }
        };
        this.cJM = new g.InterfaceC0295g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVZ) {
                    e.jH().postDelayed(PushDialogVideoView.this.hWl, 200L);
                }
            }
        };
        this.hWl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg == null || !PushDialogVideoView.this.hVZ) {
                    e.jH().postDelayed(PushDialogVideoView.this.UL, 200L);
                    PushDialogVideoView.this.hVZ = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbg.getCurrentPosition()) {
                    PushDialogVideoView.this.hVZ = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UL, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hWl, 200L);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UF = false;
                PushDialogVideoView.this.hWf = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UL);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIJ);
            }
        };
        this.gIO = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dbg.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dbg.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.gKJ != null) {
                                PushDialogVideoView.this.gKJ.lz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cNO - (duration % PushDialogVideoView.this.cNO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKJ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lz(int i2) {
                int duration;
                if (PushDialogVideoView.this.dbg != null && (duration = PushDialogVideoView.this.dbg.getDuration()) > 0 && PushDialogVideoView.this.hVz != null) {
                    PushDialogVideoView.this.hVz.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hWn = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSY() {
                PushDialogVideoView.this.cAk.startLoading();
                PushDialogVideoView.this.gIk.setVisibility(0);
                PushDialogVideoView.this.gIj.setVisibility(8);
                PushDialogVideoView.this.hVC.setVisibility(8);
                PushDialogVideoView.this.ekJ.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIJ);
                e.jH().postDelayed(PushDialogVideoView.this.gIJ, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, d.e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dbg = (QuickVideoView) findViewById(d.g.videoView);
        this.cAk = new x((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.eib);
        this.hVz = (ProgressBar) findViewById(d.g.pgrBottomProgress);
        this.hVz.setMax(this.mWidth);
        this.hVz.setProgress(0);
        this.gIa = findViewById(d.g.black_mask);
        this.ekJ = findViewById(d.g.layout_error);
        this.gIj = (ImageView) findViewById(d.g.img_play);
        this.hVC = (TextView) findViewById(d.g.txt_replay);
        this.dUq = (TextView) findViewById(d.g.push_dialog_video_time);
        this.gIk = (TbImageView) findViewById(d.g.video_thumbnail);
        this.hFa = (PbVideoWifiTipLayout) findViewById(d.g.layout_wifi_tip);
        this.gIk.setDefaultErrorResource(0);
        this.gIk.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.gIF = new CallStateReceiver();
        this.gIF.register(context);
        this.ekJ.setOnClickListener(this);
        this.hVC.setOnClickListener(this);
        this.hFa.setOnPlayClickListener(this);
        this.hFa.setFreeClickListener(this);
        setOnClickListener(this);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gII);
        this.dbg.setOnSeekCompleteListener(this.cJM);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnRecoveryCallback(this.hWn);
        onChangeSkinType();
    }

    public void onPause() {
        if (ql()) {
            this.hEP = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hEP = false;
        } else {
            this.hEP = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hEP) {
            bAL();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gIO);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.idF = fVar;
        this.dUq.setText(ap.hz(this.idF.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bNk = str;
        this.ctx = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dbg.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.dbg != null && this.ehP != null) {
            if (this.hWf) {
                this.dbg.start();
                this.hWf = false;
            }
            e.jH().removeCallbacks(this.UL);
            e.jH().postDelayed(this.UL, 20L);
            e.jH().removeCallbacks(this.gIJ);
            if (this.dbg.bTp()) {
                this.currentState = 1;
                this.dbg.setRecoveryState(1);
            }
            if (this.ehP != null) {
                this.mStartPosition = y.bTT().AV(this.bNk);
                if (this.mStartPosition != 0) {
                    if (this.dbg != null) {
                        this.dbg.xp(this.mStartPosition);
                    } else {
                        this.ehP.seekTo(this.mStartPosition);
                    }
                    if (!this.hWe) {
                        showProgress();
                        e.jH().removeCallbacks(this.UL);
                    }
                    this.hVZ = true;
                }
            }
        }
    }

    public void bPe() {
        if (!j.kY()) {
            l.S(getContext(), getContext().getString(d.j.neterror));
        } else if (this.dbg.isPlaying()) {
            pausePlay();
        } else if (this.UF) {
            bAL();
        } else {
            bSM();
        }
    }

    public void setPauseState() {
        this.cAk.bTP();
        this.gIj.setVisibility(0);
        this.hVC.setVisibility(8);
        this.currentState = 2;
        this.dbg.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.hWa) {
            dD(str, str2);
        } else {
            cf(str, str2);
        }
        if (aVar != null) {
            aVar.pa(z);
        }
    }

    public void cf(String str, String str2) {
        bSN();
        this.hWf = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbg.setVideoPath(str, str2);
        this.cAk.startLoading();
        this.gIk.setVisibility(0);
        this.gIj.setVisibility(8);
        this.hVC.setVisibility(8);
        this.ekJ.setVisibility(8);
        e.jH().removeCallbacks(this.gIJ);
        e.jH().postDelayed(this.gIJ, 60000L);
    }

    public void dD(String str, String str2) {
        bSN();
        this.hWf = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        this.cAk.startLoading();
        this.gIk.setVisibility(0);
        this.gIj.setVisibility(8);
        this.hVC.setVisibility(8);
        this.ekJ.setVisibility(8);
        e.jH().removeCallbacks(this.gIJ);
        e.jH().postDelayed(this.gIJ, 60000L);
    }

    public void bAL() {
        this.currentState = 1;
        this.dbg.setRecoveryState(1);
        this.dbg.start();
        this.gIk.setVisibility(8);
        this.gIa.setVisibility(8);
        this.cAk.bTP();
        showProgress();
        this.gIj.setVisibility(8);
        this.hVC.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kY() && this.hWd && !StringUtils.isNull(this.bNk) && !StringUtils.isNull(this.ctx)) {
            this.hWd = false;
            this.hWe = true;
            cf(this.bNk, this.ctx);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbg != null) {
            this.dbg.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dbg.isPlaying() && this.hVY) {
            bSL();
        }
        this.dbg.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dbg.isPlaying() && this.hVY) {
            bSL();
        }
        this.currentState = 5;
        this.dbg.setRecoveryState(5);
        e.jH().removeCallbacks(this.UL);
        e.jH().removeCallbacks(this.gIJ);
        this.dbg.stopPlayback();
        this.UF = false;
        this.hWf = false;
        this.mStartPosition = 0;
        bnR();
    }

    public void bSL() {
        y.bTT().bj(this.bNk, this.dbg.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        this.gIa.setVisibility(0);
        this.gIj.setVisibility(0);
        this.hVC.setVisibility(8);
        this.cAk.bTP();
        this.hVz.setVisibility(8);
        this.ekJ.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gIk.setVisibility(z ? 0 : 8);
    }

    public void bnR() {
        oU(true);
    }

    public boolean ql() {
        if (this.dbg == null) {
            return false;
        }
        return this.dbg.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dbg == null) {
            return 0;
        }
        return this.dbg.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dbg != null) {
            this.hVz.setVisibility(0);
            this.cNO = ((this.dbg.getDuration() / 200) / 50) * 50;
            if (this.cNO < 50) {
                this.cNO = 50;
            } else if (this.cNO > 500) {
                this.cNO = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNO - (this.dbg.getCurrentPosition() % this.cNO));
        }
    }

    private void bSM() {
        a(this.bNk, this.ctx, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bSN();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.hWa = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.la() && !this.hFj && !com.baidu.tieba.video.g.ciM().ciN()) {
            this.hFa.setVisibility(0);
            this.hFa.setData(this.idF.getDuration(), this.idF.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bSN() {
        if (j.la()) {
            com.baidu.tieba.video.g.ciM().ey(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gIk.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekJ) {
            bSM();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 2).bJ("tid", this.ctx));
            bPe();
        } else if (view == this.hVC) {
            cf(this.bNk, this.ctx);
        } else if (view == this.hFa.getTvPlay()) {
            this.hFj = true;
            this.hFa.setVisibility(8);
            cf(this.bNk, this.ctx);
        } else if (view == this.hFa.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.jH().removeCallbacks(this.UL);
        e.jH().removeCallbacks(this.gIJ);
        e.jH().removeCallbacks(this.hWl);
        this.mHandler.removeMessages(1);
        this.gIF.unregister(getContext());
    }
}
