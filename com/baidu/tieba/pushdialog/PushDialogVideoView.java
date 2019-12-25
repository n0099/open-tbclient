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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.x;
/* loaded from: classes5.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean Ej;
    private Runnable Ep;
    private String OC;
    private TbImageView Os;
    private int currentState;
    private w dHM;
    private QuickVideoView.b dHV;
    private g.a dQN;
    private g.f dQO;
    private g.InterfaceC0577g dQR;
    private int dVE;
    private g eaB;
    private QuickVideoView egI;
    private VideoLoadingProgressView.a fDS;
    private View fGw;
    private TextView fnN;
    private View hTB;
    private ImageView hTK;
    private CallStateReceiver hUf;
    private g.b hUi;
    private Runnable hUj;
    private CustomMessageListener hUo;
    private VideoControllerView.b hWi;
    private boolean iSC;
    private PbVideoWifiTipLayout iSN;
    private boolean iSW;
    private boolean jpA;
    private boolean jpB;
    private boolean jpC;
    private boolean jpF;
    private boolean jpG;
    private boolean jpH;
    private Runnable jpN;
    private QuickVideoView.a jpP;
    private ProgressBar jpb;
    private TextView jpe;
    private i jxE;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void rx(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.dVE = 50;
        this.mSkinType = 3;
        this.Ej = false;
        this.mStartPosition = 0;
        this.jpA = true;
        this.jpB = false;
        this.jpC = false;
        this.currentState = -1;
        this.iSC = false;
        this.dQO = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eaB = gVar;
                PushDialogVideoView.this.dHM.cwI();
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bsf();
            }
        };
        this.Ep = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egI.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ej = true;
                    PushDialogVideoView.this.hTB.setVisibility(8);
                    PushDialogVideoView.this.fGw.setVisibility(8);
                    PushDialogVideoView.this.dHM.cwJ();
                    PushDialogVideoView.this.Os.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gy().postDelayed(PushDialogVideoView.this.Ep, 20L);
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ej = false;
                PushDialogVideoView.this.jpH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hTB.setVisibility(0);
                PushDialogVideoView.this.jpb.setVisibility(8);
                PushDialogVideoView.this.jpb.setProgress(PushDialogVideoView.this.jpb.getMax());
                if (PushDialogVideoView.this.egI == null || PushDialogVideoView.this.egI.getDuration() > 150000) {
                    PushDialogVideoView.this.rs(false);
                } else {
                    PushDialogVideoView.this.jpe.setVisibility(0);
                }
                x.cwN().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.egI.setRecoveryState(3);
                if (PushDialogVideoView.this.egI != null && PushDialogVideoView.this.egI.getDuration() <= 150000) {
                    PushDialogVideoView.this.dX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.OC);
                }
            }
        };
        this.hUi = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fGw.setVisibility(0);
                PushDialogVideoView.this.dHM.cwK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.egI.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jpF = true;
                }
                PushDialogVideoView.this.jpH = false;
                return true;
            }
        };
        this.hUj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fGw.setVisibility(0);
                PushDialogVideoView.this.dHM.cwK();
            }
        };
        this.dQR = new g.InterfaceC0577g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jpB) {
                    e.gy().postDelayed(PushDialogVideoView.this.jpN, 200L);
                }
            }
        };
        this.jpN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egI == null || !PushDialogVideoView.this.jpB) {
                    e.gy().postDelayed(PushDialogVideoView.this.Ep, 200L);
                    PushDialogVideoView.this.jpB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.egI.getCurrentPosition()) {
                    PushDialogVideoView.this.jpB = false;
                    e.gy().postDelayed(PushDialogVideoView.this.Ep, 20L);
                } else {
                    e.gy().postDelayed(PushDialogVideoView.this.jpN, 200L);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ej = false;
                PushDialogVideoView.this.jpH = false;
                e.gy().removeCallbacks(PushDialogVideoView.this.Ep);
                e.gy().removeCallbacks(PushDialogVideoView.this.hUj);
            }
        };
        this.hUo = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.egI != null && PushDialogVideoView.this.egI.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.egI.getCurrentPosition();
                            int duration = PushDialogVideoView.this.egI.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hWi != null) {
                                PushDialogVideoView.this.hWi.nR(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dVE - (duration % PushDialogVideoView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hWi = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i) {
                int duration;
                if (PushDialogVideoView.this.egI != null && (duration = PushDialogVideoView.this.egI.getDuration()) > 0 && PushDialogVideoView.this.jpb != null) {
                    PushDialogVideoView.this.jpb.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jpP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cvP() {
                PushDialogVideoView.this.dHM.startLoading();
                PushDialogVideoView.this.Os.setVisibility(0);
                PushDialogVideoView.this.hTK.setVisibility(8);
                PushDialogVideoView.this.jpe.setVisibility(8);
                PushDialogVideoView.this.fGw.setVisibility(8);
                e.gy().removeCallbacks(PushDialogVideoView.this.hUj);
                e.gy().postDelayed(PushDialogVideoView.this.hUj, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVE = 50;
        this.mSkinType = 3;
        this.Ej = false;
        this.mStartPosition = 0;
        this.jpA = true;
        this.jpB = false;
        this.jpC = false;
        this.currentState = -1;
        this.iSC = false;
        this.dQO = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eaB = gVar;
                PushDialogVideoView.this.dHM.cwI();
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bsf();
            }
        };
        this.Ep = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egI.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ej = true;
                    PushDialogVideoView.this.hTB.setVisibility(8);
                    PushDialogVideoView.this.fGw.setVisibility(8);
                    PushDialogVideoView.this.dHM.cwJ();
                    PushDialogVideoView.this.Os.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gy().postDelayed(PushDialogVideoView.this.Ep, 20L);
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ej = false;
                PushDialogVideoView.this.jpH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hTB.setVisibility(0);
                PushDialogVideoView.this.jpb.setVisibility(8);
                PushDialogVideoView.this.jpb.setProgress(PushDialogVideoView.this.jpb.getMax());
                if (PushDialogVideoView.this.egI == null || PushDialogVideoView.this.egI.getDuration() > 150000) {
                    PushDialogVideoView.this.rs(false);
                } else {
                    PushDialogVideoView.this.jpe.setVisibility(0);
                }
                x.cwN().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.egI.setRecoveryState(3);
                if (PushDialogVideoView.this.egI != null && PushDialogVideoView.this.egI.getDuration() <= 150000) {
                    PushDialogVideoView.this.dX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.OC);
                }
            }
        };
        this.hUi = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fGw.setVisibility(0);
                PushDialogVideoView.this.dHM.cwK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.egI.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jpF = true;
                }
                PushDialogVideoView.this.jpH = false;
                return true;
            }
        };
        this.hUj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fGw.setVisibility(0);
                PushDialogVideoView.this.dHM.cwK();
            }
        };
        this.dQR = new g.InterfaceC0577g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jpB) {
                    e.gy().postDelayed(PushDialogVideoView.this.jpN, 200L);
                }
            }
        };
        this.jpN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egI == null || !PushDialogVideoView.this.jpB) {
                    e.gy().postDelayed(PushDialogVideoView.this.Ep, 200L);
                    PushDialogVideoView.this.jpB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.egI.getCurrentPosition()) {
                    PushDialogVideoView.this.jpB = false;
                    e.gy().postDelayed(PushDialogVideoView.this.Ep, 20L);
                } else {
                    e.gy().postDelayed(PushDialogVideoView.this.jpN, 200L);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ej = false;
                PushDialogVideoView.this.jpH = false;
                e.gy().removeCallbacks(PushDialogVideoView.this.Ep);
                e.gy().removeCallbacks(PushDialogVideoView.this.hUj);
            }
        };
        this.hUo = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.egI != null && PushDialogVideoView.this.egI.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.egI.getCurrentPosition();
                            int duration = PushDialogVideoView.this.egI.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hWi != null) {
                                PushDialogVideoView.this.hWi.nR(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dVE - (duration % PushDialogVideoView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hWi = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i) {
                int duration;
                if (PushDialogVideoView.this.egI != null && (duration = PushDialogVideoView.this.egI.getDuration()) > 0 && PushDialogVideoView.this.jpb != null) {
                    PushDialogVideoView.this.jpb.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jpP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cvP() {
                PushDialogVideoView.this.dHM.startLoading();
                PushDialogVideoView.this.Os.setVisibility(0);
                PushDialogVideoView.this.hTK.setVisibility(8);
                PushDialogVideoView.this.jpe.setVisibility(8);
                PushDialogVideoView.this.fGw.setVisibility(8);
                e.gy().removeCallbacks(PushDialogVideoView.this.hUj);
                e.gy().postDelayed(PushDialogVideoView.this.hUj, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVE = 50;
        this.mSkinType = 3;
        this.Ej = false;
        this.mStartPosition = 0;
        this.jpA = true;
        this.jpB = false;
        this.jpC = false;
        this.currentState = -1;
        this.iSC = false;
        this.dQO = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eaB = gVar;
                PushDialogVideoView.this.dHM.cwI();
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bsf();
            }
        };
        this.Ep = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egI.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Ej = true;
                    PushDialogVideoView.this.hTB.setVisibility(8);
                    PushDialogVideoView.this.fGw.setVisibility(8);
                    PushDialogVideoView.this.dHM.cwJ();
                    PushDialogVideoView.this.Os.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gy().postDelayed(PushDialogVideoView.this.Ep, 20L);
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Ej = false;
                PushDialogVideoView.this.jpH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hTB.setVisibility(0);
                PushDialogVideoView.this.jpb.setVisibility(8);
                PushDialogVideoView.this.jpb.setProgress(PushDialogVideoView.this.jpb.getMax());
                if (PushDialogVideoView.this.egI == null || PushDialogVideoView.this.egI.getDuration() > 150000) {
                    PushDialogVideoView.this.rs(false);
                } else {
                    PushDialogVideoView.this.jpe.setVisibility(0);
                }
                x.cwN().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.egI.setRecoveryState(3);
                if (PushDialogVideoView.this.egI != null && PushDialogVideoView.this.egI.getDuration() <= 150000) {
                    PushDialogVideoView.this.dX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.OC);
                }
            }
        };
        this.hUi = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.fGw.setVisibility(0);
                PushDialogVideoView.this.dHM.cwK();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.egI.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jpF = true;
                }
                PushDialogVideoView.this.jpH = false;
                return true;
            }
        };
        this.hUj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fGw.setVisibility(0);
                PushDialogVideoView.this.dHM.cwK();
            }
        };
        this.dQR = new g.InterfaceC0577g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jpB) {
                    e.gy().postDelayed(PushDialogVideoView.this.jpN, 200L);
                }
            }
        };
        this.jpN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egI == null || !PushDialogVideoView.this.jpB) {
                    e.gy().postDelayed(PushDialogVideoView.this.Ep, 200L);
                    PushDialogVideoView.this.jpB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.egI.getCurrentPosition()) {
                    PushDialogVideoView.this.jpB = false;
                    e.gy().postDelayed(PushDialogVideoView.this.Ep, 20L);
                } else {
                    e.gy().postDelayed(PushDialogVideoView.this.jpN, 200L);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Ej = false;
                PushDialogVideoView.this.jpH = false;
                e.gy().removeCallbacks(PushDialogVideoView.this.Ep);
                e.gy().removeCallbacks(PushDialogVideoView.this.hUj);
            }
        };
        this.hUo = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.egI != null && PushDialogVideoView.this.egI.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.egI.getCurrentPosition();
                            int duration = PushDialogVideoView.this.egI.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hWi != null) {
                                PushDialogVideoView.this.hWi.nR(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dVE - (duration % PushDialogVideoView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hWi = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i2) {
                int duration;
                if (PushDialogVideoView.this.egI != null && (duration = PushDialogVideoView.this.egI.getDuration()) > 0 && PushDialogVideoView.this.jpb != null) {
                    PushDialogVideoView.this.jpb.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jpP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cvP() {
                PushDialogVideoView.this.dHM.startLoading();
                PushDialogVideoView.this.Os.setVisibility(0);
                PushDialogVideoView.this.hTK.setVisibility(8);
                PushDialogVideoView.this.jpe.setVisibility(8);
                PushDialogVideoView.this.fGw.setVisibility(8);
                e.gy().removeCallbacks(PushDialogVideoView.this.hUj);
                e.gy().postDelayed(PushDialogVideoView.this.hUj, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.egI = (QuickVideoView) findViewById(R.id.videoView);
        this.dHM = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dHM.setLoadingAnimationListener(this.fDS);
        this.jpb = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.jpb.setMax(this.mWidth);
        this.jpb.setProgress(0);
        this.hTB = findViewById(R.id.black_mask);
        this.fGw = findViewById(R.id.layout_error);
        this.hTK = (ImageView) findViewById(R.id.img_play);
        this.jpe = (TextView) findViewById(R.id.txt_replay);
        this.fnN = (TextView) findViewById(R.id.push_dialog_video_time);
        this.Os = (TbImageView) findViewById(R.id.video_thumbnail);
        this.iSN = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.Os.setDefaultErrorResource(0);
        this.Os.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hUf = new CallStateReceiver();
        this.hUf.register(context);
        this.fGw.setOnClickListener(this);
        this.jpe.setOnClickListener(this);
        this.iSN.setOnPlayClickListener(this);
        this.iSN.setFreeClickListener(this);
        setOnClickListener(this);
        this.egI.setOnPreparedListener(this.dQO);
        this.egI.setOnCompletionListener(this.dQN);
        this.egI.setOnErrorListener(this.hUi);
        this.egI.setOnSeekCompleteListener(this.dQR);
        this.egI.setOnSurfaceDestroyedListener(this.dHV);
        this.egI.setOnRecoveryCallback(this.jpP);
        onChangeSkinType();
    }

    public void onPause() {
        if (kO()) {
            this.iSC = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iSC = false;
        } else {
            this.iSC = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iSC) {
            ahr();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hUo);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.jxE = iVar;
        this.fnN.setText(aq.stringForVideoTime(this.jxE.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.OC = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.egI.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsf() {
        if (this.egI != null && this.eaB != null) {
            if (this.jpH) {
                this.egI.start();
                this.jpH = false;
            }
            e.gy().removeCallbacks(this.Ep);
            e.gy().postDelayed(this.Ep, 20L);
            e.gy().removeCallbacks(this.hUj);
            if (this.egI.cwj()) {
                this.currentState = 1;
                this.egI.setRecoveryState(1);
            }
            if (this.eaB != null) {
                this.mStartPosition = x.cwN().GF(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.egI != null) {
                        this.egI.Ad(this.mStartPosition);
                    } else {
                        this.eaB.seekTo(this.mStartPosition);
                    }
                    if (!this.jpG) {
                        showProgress();
                        e.gy().removeCallbacks(this.Ep);
                    }
                    this.jpB = true;
                }
            }
        }
    }

    public void cpL() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.egI.isPlaying()) {
            pausePlay();
        } else if (this.Ej) {
            ahr();
        } else {
            cvD();
        }
    }

    public void setPauseState() {
        this.dHM.cwK();
        this.hTK.setVisibility(0);
        this.jpe.setVisibility(8);
        this.currentState = 2;
        this.egI.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.jpC) {
            dY(str, str2);
        } else {
            dX(str, str2);
        }
        if (aVar != null) {
            aVar.rx(z);
        }
    }

    public void dX(String str, String str2) {
        cvE();
        this.jpH = true;
        this.currentState = 0;
        this.egI.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.egI.setVideoPath(str, str2);
        this.dHM.startLoading();
        this.Os.setVisibility(0);
        this.hTK.setVisibility(8);
        this.jpe.setVisibility(8);
        this.fGw.setVisibility(8);
        e.gy().removeCallbacks(this.hUj);
        e.gy().postDelayed(this.hUj, 60000L);
    }

    public void dY(String str, String str2) {
        cvE();
        this.jpH = true;
        this.currentState = 0;
        this.egI.setRecoveryState(0);
        this.dHM.startLoading();
        this.Os.setVisibility(0);
        this.hTK.setVisibility(8);
        this.jpe.setVisibility(8);
        this.fGw.setVisibility(8);
        e.gy().removeCallbacks(this.hUj);
        e.gy().postDelayed(this.hUj, 60000L);
    }

    public void ahr() {
        this.currentState = 1;
        this.egI.setRecoveryState(1);
        this.egI.start();
        this.Os.setVisibility(8);
        this.hTB.setVisibility(8);
        this.dHM.cwK();
        showProgress();
        this.hTK.setVisibility(8);
        this.jpe.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.jpF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.OC)) {
            this.jpF = false;
            this.jpG = true;
            dX(this.mVideoUrl, this.OC);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.egI != null) {
            this.egI.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.egI.isPlaying() && this.jpA) {
            cvC();
        }
        this.egI.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.egI.isPlaying() && this.jpA) {
            cvC();
        }
        this.currentState = 5;
        this.egI.setRecoveryState(5);
        e.gy().removeCallbacks(this.Ep);
        e.gy().removeCallbacks(this.hUj);
        this.egI.stopPlayback();
        this.Ej = false;
        this.jpH = false;
        this.mStartPosition = 0;
        bNb();
    }

    public void cvC() {
        x.cwN().bm(this.mVideoUrl, this.egI.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(boolean z) {
        this.hTB.setVisibility(0);
        this.hTK.setVisibility(0);
        this.jpe.setVisibility(8);
        this.dHM.cwK();
        this.jpb.setVisibility(8);
        this.fGw.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.Os.setVisibility(z ? 0 : 8);
    }

    public void bNb() {
        rs(true);
    }

    public boolean kO() {
        if (this.egI == null) {
            return false;
        }
        return this.egI.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.egI == null) {
            return 0;
        }
        return this.egI.getCurrentPosition();
    }

    public void showProgress() {
        if (this.egI != null) {
            this.jpb.setVisibility(0);
            this.dVE = ((this.egI.getDuration() / 200) / 50) * 50;
            if (this.dVE < 50) {
                this.dVE = 50;
            } else if (this.dVE > 500) {
                this.dVE = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVE - (this.egI.getCurrentPosition() % this.dVE));
        }
    }

    private void cvD() {
        a(this.mVideoUrl, this.OC, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cvE();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.jpC = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.iSW && !com.baidu.tieba.video.g.cMD().cME()) {
            this.iSN.setVisibility(0);
            this.iSN.setData(this.jxE.getDuration(), this.jxE.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cvE() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.cMD().fx(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.Os.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGw) {
            cvD();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 2).cp("tid", this.OC));
            cpL();
        } else if (view == this.jpe) {
            dX(this.mVideoUrl, this.OC);
        } else if (view == this.iSN.getTvPlay()) {
            this.iSW = true;
            this.iSN.setVisibility(8);
            dX(this.mVideoUrl, this.OC);
        } else if (view == this.iSN.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.gy().removeCallbacks(this.Ep);
        e.gy().removeCallbacks(this.hUj);
        e.gy().removeCallbacks(this.jpN);
        this.mHandler.removeMessages(1);
        this.hUf.unregister(getContext());
    }
}
