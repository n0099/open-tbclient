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
/* loaded from: classes8.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean XY;
    private Runnable Ye;
    private TbImageView ahB;
    private String ahL;
    private int currentState;
    private int eAi;
    private g eFh;
    private QuickVideoView ePa;
    private QuickVideoView.b emE;
    private w emv;
    private g.a evE;
    private g.f evF;
    private g.InterfaceC0630g evI;
    private TextView fYK;
    private VideoLoadingProgressView.a gpc;
    private View grH;
    private View iKL;
    private ImageView iKU;
    private CallStateReceiver iLp;
    private g.b iLs;
    private Runnable iLt;
    private CustomMessageListener iLy;
    private VideoControllerView.b iNt;
    private PbVideoWifiTipLayout jJH;
    private boolean jJQ;
    private boolean jJw;
    private boolean kfA;
    private boolean kfB;
    private boolean kfC;
    private boolean kfF;
    private boolean kfG;
    private boolean kfH;
    private Runnable kfN;
    private QuickVideoView.a kfP;
    private ProgressBar kfa;
    private TextView kfd;
    private i knI;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void sX(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.eAi = 50;
        this.mSkinType = 3;
        this.XY = false;
        this.mStartPosition = 0;
        this.kfA = true;
        this.kfB = false;
        this.kfC = false;
        this.currentState = -1;
        this.jJw = false;
        this.evF = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eFh = gVar;
                PushDialogVideoView.this.emv.cKm();
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bEF();
            }
        };
        this.Ye = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePa.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.XY = true;
                    PushDialogVideoView.this.iKL.setVisibility(8);
                    PushDialogVideoView.this.grH.setVisibility(8);
                    PushDialogVideoView.this.emv.cKn();
                    PushDialogVideoView.this.ahB.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lb().postDelayed(PushDialogVideoView.this.Ye, 20L);
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.XY = false;
                PushDialogVideoView.this.kfH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iKL.setVisibility(0);
                PushDialogVideoView.this.kfa.setVisibility(8);
                PushDialogVideoView.this.kfa.setProgress(PushDialogVideoView.this.kfa.getMax());
                if (PushDialogVideoView.this.ePa == null || PushDialogVideoView.this.ePa.getDuration() > 150000) {
                    PushDialogVideoView.this.sS(false);
                } else {
                    PushDialogVideoView.this.kfd.setVisibility(0);
                }
                x.cKr().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ePa.setRecoveryState(3);
                if (PushDialogVideoView.this.ePa != null && PushDialogVideoView.this.ePa.getDuration() <= 150000) {
                    PushDialogVideoView.this.ev(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ahL);
                }
            }
        };
        this.iLs = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.grH.setVisibility(0);
                PushDialogVideoView.this.emv.cKo();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ePa.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kfF = true;
                }
                PushDialogVideoView.this.kfH = false;
                return true;
            }
        };
        this.iLt = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.grH.setVisibility(0);
                PushDialogVideoView.this.emv.cKo();
            }
        };
        this.evI = new g.InterfaceC0630g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kfB) {
                    e.lb().postDelayed(PushDialogVideoView.this.kfN, 200L);
                }
            }
        };
        this.kfN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePa == null || !PushDialogVideoView.this.kfB) {
                    e.lb().postDelayed(PushDialogVideoView.this.Ye, 200L);
                    PushDialogVideoView.this.kfB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ePa.getCurrentPosition()) {
                    PushDialogVideoView.this.kfB = false;
                    e.lb().postDelayed(PushDialogVideoView.this.Ye, 20L);
                } else {
                    e.lb().postDelayed(PushDialogVideoView.this.kfN, 200L);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.XY = false;
                PushDialogVideoView.this.kfH = false;
                e.lb().removeCallbacks(PushDialogVideoView.this.Ye);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLt);
            }
        };
        this.iLy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.asn();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.ePa != null && PushDialogVideoView.this.ePa.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ePa.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ePa.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.iNt != null) {
                                PushDialogVideoView.this.iNt.ox(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eAi - (duration % PushDialogVideoView.this.eAi));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iNt = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i) {
                int duration;
                if (PushDialogVideoView.this.ePa != null && (duration = PushDialogVideoView.this.ePa.getDuration()) > 0 && PushDialogVideoView.this.kfa != null) {
                    PushDialogVideoView.this.kfa.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kfP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJs() {
                PushDialogVideoView.this.emv.startLoading();
                PushDialogVideoView.this.ahB.setVisibility(0);
                PushDialogVideoView.this.iKU.setVisibility(8);
                PushDialogVideoView.this.kfd.setVisibility(8);
                PushDialogVideoView.this.grH.setVisibility(8);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLt);
                e.lb().postDelayed(PushDialogVideoView.this.iLt, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAi = 50;
        this.mSkinType = 3;
        this.XY = false;
        this.mStartPosition = 0;
        this.kfA = true;
        this.kfB = false;
        this.kfC = false;
        this.currentState = -1;
        this.jJw = false;
        this.evF = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eFh = gVar;
                PushDialogVideoView.this.emv.cKm();
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bEF();
            }
        };
        this.Ye = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePa.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.XY = true;
                    PushDialogVideoView.this.iKL.setVisibility(8);
                    PushDialogVideoView.this.grH.setVisibility(8);
                    PushDialogVideoView.this.emv.cKn();
                    PushDialogVideoView.this.ahB.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lb().postDelayed(PushDialogVideoView.this.Ye, 20L);
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.XY = false;
                PushDialogVideoView.this.kfH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iKL.setVisibility(0);
                PushDialogVideoView.this.kfa.setVisibility(8);
                PushDialogVideoView.this.kfa.setProgress(PushDialogVideoView.this.kfa.getMax());
                if (PushDialogVideoView.this.ePa == null || PushDialogVideoView.this.ePa.getDuration() > 150000) {
                    PushDialogVideoView.this.sS(false);
                } else {
                    PushDialogVideoView.this.kfd.setVisibility(0);
                }
                x.cKr().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ePa.setRecoveryState(3);
                if (PushDialogVideoView.this.ePa != null && PushDialogVideoView.this.ePa.getDuration() <= 150000) {
                    PushDialogVideoView.this.ev(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ahL);
                }
            }
        };
        this.iLs = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.grH.setVisibility(0);
                PushDialogVideoView.this.emv.cKo();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ePa.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kfF = true;
                }
                PushDialogVideoView.this.kfH = false;
                return true;
            }
        };
        this.iLt = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.grH.setVisibility(0);
                PushDialogVideoView.this.emv.cKo();
            }
        };
        this.evI = new g.InterfaceC0630g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kfB) {
                    e.lb().postDelayed(PushDialogVideoView.this.kfN, 200L);
                }
            }
        };
        this.kfN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePa == null || !PushDialogVideoView.this.kfB) {
                    e.lb().postDelayed(PushDialogVideoView.this.Ye, 200L);
                    PushDialogVideoView.this.kfB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ePa.getCurrentPosition()) {
                    PushDialogVideoView.this.kfB = false;
                    e.lb().postDelayed(PushDialogVideoView.this.Ye, 20L);
                } else {
                    e.lb().postDelayed(PushDialogVideoView.this.kfN, 200L);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.XY = false;
                PushDialogVideoView.this.kfH = false;
                e.lb().removeCallbacks(PushDialogVideoView.this.Ye);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLt);
            }
        };
        this.iLy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.asn();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.ePa != null && PushDialogVideoView.this.ePa.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ePa.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ePa.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.iNt != null) {
                                PushDialogVideoView.this.iNt.ox(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eAi - (duration % PushDialogVideoView.this.eAi));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iNt = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i) {
                int duration;
                if (PushDialogVideoView.this.ePa != null && (duration = PushDialogVideoView.this.ePa.getDuration()) > 0 && PushDialogVideoView.this.kfa != null) {
                    PushDialogVideoView.this.kfa.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kfP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJs() {
                PushDialogVideoView.this.emv.startLoading();
                PushDialogVideoView.this.ahB.setVisibility(0);
                PushDialogVideoView.this.iKU.setVisibility(8);
                PushDialogVideoView.this.kfd.setVisibility(8);
                PushDialogVideoView.this.grH.setVisibility(8);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLt);
                e.lb().postDelayed(PushDialogVideoView.this.iLt, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAi = 50;
        this.mSkinType = 3;
        this.XY = false;
        this.mStartPosition = 0;
        this.kfA = true;
        this.kfB = false;
        this.kfC = false;
        this.currentState = -1;
        this.jJw = false;
        this.evF = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eFh = gVar;
                PushDialogVideoView.this.emv.cKm();
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bEF();
            }
        };
        this.Ye = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePa.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.XY = true;
                    PushDialogVideoView.this.iKL.setVisibility(8);
                    PushDialogVideoView.this.grH.setVisibility(8);
                    PushDialogVideoView.this.emv.cKn();
                    PushDialogVideoView.this.ahB.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lb().postDelayed(PushDialogVideoView.this.Ye, 20L);
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.XY = false;
                PushDialogVideoView.this.kfH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iKL.setVisibility(0);
                PushDialogVideoView.this.kfa.setVisibility(8);
                PushDialogVideoView.this.kfa.setProgress(PushDialogVideoView.this.kfa.getMax());
                if (PushDialogVideoView.this.ePa == null || PushDialogVideoView.this.ePa.getDuration() > 150000) {
                    PushDialogVideoView.this.sS(false);
                } else {
                    PushDialogVideoView.this.kfd.setVisibility(0);
                }
                x.cKr().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ePa.setRecoveryState(3);
                if (PushDialogVideoView.this.ePa != null && PushDialogVideoView.this.ePa.getDuration() <= 150000) {
                    PushDialogVideoView.this.ev(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ahL);
                }
            }
        };
        this.iLs = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.grH.setVisibility(0);
                PushDialogVideoView.this.emv.cKo();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ePa.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kfF = true;
                }
                PushDialogVideoView.this.kfH = false;
                return true;
            }
        };
        this.iLt = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.grH.setVisibility(0);
                PushDialogVideoView.this.emv.cKo();
            }
        };
        this.evI = new g.InterfaceC0630g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kfB) {
                    e.lb().postDelayed(PushDialogVideoView.this.kfN, 200L);
                }
            }
        };
        this.kfN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePa == null || !PushDialogVideoView.this.kfB) {
                    e.lb().postDelayed(PushDialogVideoView.this.Ye, 200L);
                    PushDialogVideoView.this.kfB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ePa.getCurrentPosition()) {
                    PushDialogVideoView.this.kfB = false;
                    e.lb().postDelayed(PushDialogVideoView.this.Ye, 20L);
                } else {
                    e.lb().postDelayed(PushDialogVideoView.this.kfN, 200L);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.XY = false;
                PushDialogVideoView.this.kfH = false;
                e.lb().removeCallbacks(PushDialogVideoView.this.Ye);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLt);
            }
        };
        this.iLy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.asn();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.ePa != null && PushDialogVideoView.this.ePa.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ePa.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ePa.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.iNt != null) {
                                PushDialogVideoView.this.iNt.ox(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eAi - (duration % PushDialogVideoView.this.eAi));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iNt = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i2) {
                int duration;
                if (PushDialogVideoView.this.ePa != null && (duration = PushDialogVideoView.this.ePa.getDuration()) > 0 && PushDialogVideoView.this.kfa != null) {
                    PushDialogVideoView.this.kfa.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kfP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJs() {
                PushDialogVideoView.this.emv.startLoading();
                PushDialogVideoView.this.ahB.setVisibility(0);
                PushDialogVideoView.this.iKU.setVisibility(8);
                PushDialogVideoView.this.kfd.setVisibility(8);
                PushDialogVideoView.this.grH.setVisibility(8);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLt);
                e.lb().postDelayed(PushDialogVideoView.this.iLt, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.ePa = (QuickVideoView) findViewById(R.id.videoView);
        this.emv = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.emv.setLoadingAnimationListener(this.gpc);
        this.kfa = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.kfa.setMax(this.mWidth);
        this.kfa.setProgress(0);
        this.iKL = findViewById(R.id.black_mask);
        this.grH = findViewById(R.id.layout_error);
        this.iKU = (ImageView) findViewById(R.id.img_play);
        this.kfd = (TextView) findViewById(R.id.txt_replay);
        this.fYK = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ahB = (TbImageView) findViewById(R.id.video_thumbnail);
        this.jJH = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ahB.setDefaultErrorResource(0);
        this.ahB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.iLp = new CallStateReceiver();
        this.iLp.register(context);
        this.grH.setOnClickListener(this);
        this.kfd.setOnClickListener(this);
        this.jJH.setOnPlayClickListener(this);
        this.jJH.setFreeClickListener(this);
        setOnClickListener(this);
        this.ePa.setOnPreparedListener(this.evF);
        this.ePa.setOnCompletionListener(this.evE);
        this.ePa.setOnErrorListener(this.iLs);
        this.ePa.setOnSeekCompleteListener(this.evI);
        this.ePa.setOnSurfaceDestroyedListener(this.emE);
        this.ePa.setOnRecoveryCallback(this.kfP);
        onChangeSkinType();
    }

    public void onPause() {
        if (pI()) {
            this.jJw = true;
            asn();
        } else if (getCurrentState() == 3) {
            this.jJw = false;
        } else {
            this.jJw = false;
            asn();
        }
    }

    public void onResume() {
        if (this.jJw) {
            aso();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.iLy);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.knI = iVar;
        this.fYK.setText(aq.stringForVideoTime(this.knI.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ahL = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.ePa.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.ePa != null && this.eFh != null) {
            if (this.kfH) {
                this.ePa.start();
                this.kfH = false;
            }
            e.lb().removeCallbacks(this.Ye);
            e.lb().postDelayed(this.Ye, 20L);
            e.lb().removeCallbacks(this.iLt);
            if (this.ePa.cJN()) {
                this.currentState = 1;
                this.ePa.setRecoveryState(1);
            }
            if (this.eFh != null) {
                this.mStartPosition = x.cKr().IL(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.ePa != null) {
                        this.ePa.Ba(this.mStartPosition);
                    } else {
                        this.eFh.seekTo(this.mStartPosition);
                    }
                    if (!this.kfG) {
                        showProgress();
                        e.lb().removeCallbacks(this.Ye);
                    }
                    this.kfB = true;
                }
            }
        }
    }

    public void cDo() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.ePa.isPlaying()) {
            asn();
        } else if (this.XY) {
            aso();
        } else {
            cJg();
        }
    }

    public void setPauseState() {
        this.emv.cKo();
        this.iKU.setVisibility(0);
        this.kfd.setVisibility(8);
        this.currentState = 2;
        this.ePa.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.kfC) {
            ew(str, str2);
        } else {
            ev(str, str2);
        }
        if (aVar != null) {
            aVar.sX(z);
        }
    }

    public void ev(String str, String str2) {
        cJh();
        this.kfH = true;
        this.currentState = 0;
        this.ePa.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.ePa.setVideoPath(str, str2);
        this.emv.startLoading();
        this.ahB.setVisibility(0);
        this.iKU.setVisibility(8);
        this.kfd.setVisibility(8);
        this.grH.setVisibility(8);
        e.lb().removeCallbacks(this.iLt);
        e.lb().postDelayed(this.iLt, 60000L);
    }

    public void ew(String str, String str2) {
        cJh();
        this.kfH = true;
        this.currentState = 0;
        this.ePa.setRecoveryState(0);
        this.emv.startLoading();
        this.ahB.setVisibility(0);
        this.iKU.setVisibility(8);
        this.kfd.setVisibility(8);
        this.grH.setVisibility(8);
        e.lb().removeCallbacks(this.iLt);
        e.lb().postDelayed(this.iLt, 60000L);
    }

    public void aso() {
        this.currentState = 1;
        this.ePa.setRecoveryState(1);
        this.ePa.start();
        this.ahB.setVisibility(8);
        this.iKL.setVisibility(8);
        this.emv.cKo();
        showProgress();
        this.iKU.setVisibility(8);
        this.kfd.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.kfF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ahL)) {
            this.kfF = false;
            this.kfG = true;
            ev(this.mVideoUrl, this.ahL);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.ePa != null) {
            this.ePa.setNeedRecovery(z);
        }
    }

    public void asn() {
        if (this.ePa.isPlaying() && this.kfA) {
            cJf();
        }
        this.ePa.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.ePa.isPlaying() && this.kfA) {
            cJf();
        }
        this.currentState = 5;
        this.ePa.setRecoveryState(5);
        e.lb().removeCallbacks(this.Ye);
        e.lb().removeCallbacks(this.iLt);
        this.ePa.stopPlayback();
        this.XY = false;
        this.kfH = false;
        this.mStartPosition = 0;
        caH();
    }

    public void cJf() {
        x.cKr().bv(this.mVideoUrl, this.ePa.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        this.iKL.setVisibility(0);
        this.iKU.setVisibility(0);
        this.kfd.setVisibility(8);
        this.emv.cKo();
        this.kfa.setVisibility(8);
        this.grH.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ahB.setVisibility(z ? 0 : 8);
    }

    public void caH() {
        sS(true);
    }

    public boolean pI() {
        if (this.ePa == null) {
            return false;
        }
        return this.ePa.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ePa == null) {
            return 0;
        }
        return this.ePa.getCurrentPosition();
    }

    public void showProgress() {
        if (this.ePa != null) {
            this.kfa.setVisibility(0);
            this.eAi = ((this.ePa.getDuration() / 200) / 50) * 50;
            if (this.eAi < 50) {
                this.eAi = 50;
            } else if (this.eAi > 500) {
                this.eAi = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eAi - (this.ePa.getCurrentPosition() % this.eAi));
        }
    }

    private void cJg() {
        a(this.mVideoUrl, this.ahL, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cJh();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.kfC = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.jJQ && !com.baidu.tieba.video.g.day().daz()) {
            this.jJH.setVisibility(0);
            this.jJH.setData(this.knI.getDuration(), this.knI.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cJh() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.day().fp(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.ahB.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.grH) {
            cJg();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").af("obj_locate", 2).cI("tid", this.ahL));
            cDo();
        } else if (view == this.kfd) {
            ev(this.mVideoUrl, this.ahL);
        } else if (view == this.jJH.getTvPlay()) {
            this.jJQ = true;
            this.jJH.setVisibility(8);
            ev(this.mVideoUrl, this.ahL);
        } else if (view == this.jJH.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.lb().removeCallbacks(this.Ye);
        e.lb().removeCallbacks(this.iLt);
        e.lb().removeCallbacks(this.kfN);
        this.mHandler.removeMessages(1);
        this.iLp.unregister(getContext());
    }
}
