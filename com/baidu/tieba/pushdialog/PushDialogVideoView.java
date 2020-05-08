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
    private boolean Yb;
    private Runnable Yh;
    private TbImageView ahE;
    private String ahO;
    private int currentState;
    private int eAn;
    private g eFm;
    private QuickVideoView ePf;
    private w emA;
    private QuickVideoView.b emJ;
    private g.a evJ;
    private g.f evK;
    private g.InterfaceC0651g evN;
    private TextView fYP;
    private VideoLoadingProgressView.a gpi;
    private View grN;
    private View iKP;
    private ImageView iKY;
    private CustomMessageListener iLC;
    private CallStateReceiver iLt;
    private g.b iLw;
    private Runnable iLx;
    private VideoControllerView.b iNx;
    private boolean jJA;
    private PbVideoWifiTipLayout jJL;
    private boolean jJU;
    private boolean kfE;
    private boolean kfF;
    private boolean kfG;
    private boolean kfJ;
    private boolean kfK;
    private boolean kfL;
    private Runnable kfR;
    private QuickVideoView.a kfT;
    private ProgressBar kfe;
    private TextView kfh;
    private i knM;
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
        this.eAn = 50;
        this.mSkinType = 3;
        this.Yb = false;
        this.mStartPosition = 0;
        this.kfE = true;
        this.kfF = false;
        this.kfG = false;
        this.currentState = -1;
        this.jJA = false;
        this.evK = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eFm = gVar;
                PushDialogVideoView.this.emA.cKj();
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bED();
            }
        };
        this.Yh = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePf.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yb = true;
                    PushDialogVideoView.this.iKP.setVisibility(8);
                    PushDialogVideoView.this.grN.setVisibility(8);
                    PushDialogVideoView.this.emA.cKk();
                    PushDialogVideoView.this.ahE.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lb().postDelayed(PushDialogVideoView.this.Yh, 20L);
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yb = false;
                PushDialogVideoView.this.kfL = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iKP.setVisibility(0);
                PushDialogVideoView.this.kfe.setVisibility(8);
                PushDialogVideoView.this.kfe.setProgress(PushDialogVideoView.this.kfe.getMax());
                if (PushDialogVideoView.this.ePf == null || PushDialogVideoView.this.ePf.getDuration() > 150000) {
                    PushDialogVideoView.this.sS(false);
                } else {
                    PushDialogVideoView.this.kfh.setVisibility(0);
                }
                x.cKo().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ePf.setRecoveryState(3);
                if (PushDialogVideoView.this.ePf != null && PushDialogVideoView.this.ePf.getDuration() <= 150000) {
                    PushDialogVideoView.this.ev(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ahO);
                }
            }
        };
        this.iLw = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.grN.setVisibility(0);
                PushDialogVideoView.this.emA.cKl();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ePf.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kfJ = true;
                }
                PushDialogVideoView.this.kfL = false;
                return true;
            }
        };
        this.iLx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.grN.setVisibility(0);
                PushDialogVideoView.this.emA.cKl();
            }
        };
        this.evN = new g.InterfaceC0651g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kfF) {
                    e.lb().postDelayed(PushDialogVideoView.this.kfR, 200L);
                }
            }
        };
        this.kfR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePf == null || !PushDialogVideoView.this.kfF) {
                    e.lb().postDelayed(PushDialogVideoView.this.Yh, 200L);
                    PushDialogVideoView.this.kfF = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ePf.getCurrentPosition()) {
                    PushDialogVideoView.this.kfF = false;
                    e.lb().postDelayed(PushDialogVideoView.this.Yh, 20L);
                } else {
                    e.lb().postDelayed(PushDialogVideoView.this.kfR, 200L);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yb = false;
                PushDialogVideoView.this.kfL = false;
                e.lb().removeCallbacks(PushDialogVideoView.this.Yh);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLx);
            }
        };
        this.iLC = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.asl();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.ePf != null && PushDialogVideoView.this.ePf.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ePf.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ePf.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.iNx != null) {
                                PushDialogVideoView.this.iNx.ox(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eAn - (duration % PushDialogVideoView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iNx = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i) {
                int duration;
                if (PushDialogVideoView.this.ePf != null && (duration = PushDialogVideoView.this.ePf.getDuration()) > 0 && PushDialogVideoView.this.kfe != null) {
                    PushDialogVideoView.this.kfe.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kfT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJp() {
                PushDialogVideoView.this.emA.startLoading();
                PushDialogVideoView.this.ahE.setVisibility(0);
                PushDialogVideoView.this.iKY.setVisibility(8);
                PushDialogVideoView.this.kfh.setVisibility(8);
                PushDialogVideoView.this.grN.setVisibility(8);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLx);
                e.lb().postDelayed(PushDialogVideoView.this.iLx, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAn = 50;
        this.mSkinType = 3;
        this.Yb = false;
        this.mStartPosition = 0;
        this.kfE = true;
        this.kfF = false;
        this.kfG = false;
        this.currentState = -1;
        this.jJA = false;
        this.evK = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eFm = gVar;
                PushDialogVideoView.this.emA.cKj();
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bED();
            }
        };
        this.Yh = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePf.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yb = true;
                    PushDialogVideoView.this.iKP.setVisibility(8);
                    PushDialogVideoView.this.grN.setVisibility(8);
                    PushDialogVideoView.this.emA.cKk();
                    PushDialogVideoView.this.ahE.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lb().postDelayed(PushDialogVideoView.this.Yh, 20L);
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yb = false;
                PushDialogVideoView.this.kfL = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iKP.setVisibility(0);
                PushDialogVideoView.this.kfe.setVisibility(8);
                PushDialogVideoView.this.kfe.setProgress(PushDialogVideoView.this.kfe.getMax());
                if (PushDialogVideoView.this.ePf == null || PushDialogVideoView.this.ePf.getDuration() > 150000) {
                    PushDialogVideoView.this.sS(false);
                } else {
                    PushDialogVideoView.this.kfh.setVisibility(0);
                }
                x.cKo().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ePf.setRecoveryState(3);
                if (PushDialogVideoView.this.ePf != null && PushDialogVideoView.this.ePf.getDuration() <= 150000) {
                    PushDialogVideoView.this.ev(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ahO);
                }
            }
        };
        this.iLw = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.grN.setVisibility(0);
                PushDialogVideoView.this.emA.cKl();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ePf.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kfJ = true;
                }
                PushDialogVideoView.this.kfL = false;
                return true;
            }
        };
        this.iLx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.grN.setVisibility(0);
                PushDialogVideoView.this.emA.cKl();
            }
        };
        this.evN = new g.InterfaceC0651g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kfF) {
                    e.lb().postDelayed(PushDialogVideoView.this.kfR, 200L);
                }
            }
        };
        this.kfR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePf == null || !PushDialogVideoView.this.kfF) {
                    e.lb().postDelayed(PushDialogVideoView.this.Yh, 200L);
                    PushDialogVideoView.this.kfF = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ePf.getCurrentPosition()) {
                    PushDialogVideoView.this.kfF = false;
                    e.lb().postDelayed(PushDialogVideoView.this.Yh, 20L);
                } else {
                    e.lb().postDelayed(PushDialogVideoView.this.kfR, 200L);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yb = false;
                PushDialogVideoView.this.kfL = false;
                e.lb().removeCallbacks(PushDialogVideoView.this.Yh);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLx);
            }
        };
        this.iLC = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.asl();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.ePf != null && PushDialogVideoView.this.ePf.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ePf.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ePf.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.iNx != null) {
                                PushDialogVideoView.this.iNx.ox(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eAn - (duration % PushDialogVideoView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iNx = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i) {
                int duration;
                if (PushDialogVideoView.this.ePf != null && (duration = PushDialogVideoView.this.ePf.getDuration()) > 0 && PushDialogVideoView.this.kfe != null) {
                    PushDialogVideoView.this.kfe.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kfT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJp() {
                PushDialogVideoView.this.emA.startLoading();
                PushDialogVideoView.this.ahE.setVisibility(0);
                PushDialogVideoView.this.iKY.setVisibility(8);
                PushDialogVideoView.this.kfh.setVisibility(8);
                PushDialogVideoView.this.grN.setVisibility(8);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLx);
                e.lb().postDelayed(PushDialogVideoView.this.iLx, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAn = 50;
        this.mSkinType = 3;
        this.Yb = false;
        this.mStartPosition = 0;
        this.kfE = true;
        this.kfF = false;
        this.kfG = false;
        this.currentState = -1;
        this.jJA = false;
        this.evK = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eFm = gVar;
                PushDialogVideoView.this.emA.cKj();
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bED();
            }
        };
        this.Yh = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePf.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yb = true;
                    PushDialogVideoView.this.iKP.setVisibility(8);
                    PushDialogVideoView.this.grN.setVisibility(8);
                    PushDialogVideoView.this.emA.cKk();
                    PushDialogVideoView.this.ahE.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lb().postDelayed(PushDialogVideoView.this.Yh, 20L);
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yb = false;
                PushDialogVideoView.this.kfL = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iKP.setVisibility(0);
                PushDialogVideoView.this.kfe.setVisibility(8);
                PushDialogVideoView.this.kfe.setProgress(PushDialogVideoView.this.kfe.getMax());
                if (PushDialogVideoView.this.ePf == null || PushDialogVideoView.this.ePf.getDuration() > 150000) {
                    PushDialogVideoView.this.sS(false);
                } else {
                    PushDialogVideoView.this.kfh.setVisibility(0);
                }
                x.cKo().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ePf.setRecoveryState(3);
                if (PushDialogVideoView.this.ePf != null && PushDialogVideoView.this.ePf.getDuration() <= 150000) {
                    PushDialogVideoView.this.ev(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ahO);
                }
            }
        };
        this.iLw = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.grN.setVisibility(0);
                PushDialogVideoView.this.emA.cKl();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ePf.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kfJ = true;
                }
                PushDialogVideoView.this.kfL = false;
                return true;
            }
        };
        this.iLx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.grN.setVisibility(0);
                PushDialogVideoView.this.emA.cKl();
            }
        };
        this.evN = new g.InterfaceC0651g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kfF) {
                    e.lb().postDelayed(PushDialogVideoView.this.kfR, 200L);
                }
            }
        };
        this.kfR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ePf == null || !PushDialogVideoView.this.kfF) {
                    e.lb().postDelayed(PushDialogVideoView.this.Yh, 200L);
                    PushDialogVideoView.this.kfF = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ePf.getCurrentPosition()) {
                    PushDialogVideoView.this.kfF = false;
                    e.lb().postDelayed(PushDialogVideoView.this.Yh, 20L);
                } else {
                    e.lb().postDelayed(PushDialogVideoView.this.kfR, 200L);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yb = false;
                PushDialogVideoView.this.kfL = false;
                e.lb().removeCallbacks(PushDialogVideoView.this.Yh);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLx);
            }
        };
        this.iLC = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.asl();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.ePf != null && PushDialogVideoView.this.ePf.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ePf.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ePf.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.iNx != null) {
                                PushDialogVideoView.this.iNx.ox(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eAn - (duration % PushDialogVideoView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iNx = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i2) {
                int duration;
                if (PushDialogVideoView.this.ePf != null && (duration = PushDialogVideoView.this.ePf.getDuration()) > 0 && PushDialogVideoView.this.kfe != null) {
                    PushDialogVideoView.this.kfe.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kfT = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJp() {
                PushDialogVideoView.this.emA.startLoading();
                PushDialogVideoView.this.ahE.setVisibility(0);
                PushDialogVideoView.this.iKY.setVisibility(8);
                PushDialogVideoView.this.kfh.setVisibility(8);
                PushDialogVideoView.this.grN.setVisibility(8);
                e.lb().removeCallbacks(PushDialogVideoView.this.iLx);
                e.lb().postDelayed(PushDialogVideoView.this.iLx, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.ePf = (QuickVideoView) findViewById(R.id.videoView);
        this.emA = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.emA.setLoadingAnimationListener(this.gpi);
        this.kfe = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.kfe.setMax(this.mWidth);
        this.kfe.setProgress(0);
        this.iKP = findViewById(R.id.black_mask);
        this.grN = findViewById(R.id.layout_error);
        this.iKY = (ImageView) findViewById(R.id.img_play);
        this.kfh = (TextView) findViewById(R.id.txt_replay);
        this.fYP = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ahE = (TbImageView) findViewById(R.id.video_thumbnail);
        this.jJL = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ahE.setDefaultErrorResource(0);
        this.ahE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.iLt = new CallStateReceiver();
        this.iLt.register(context);
        this.grN.setOnClickListener(this);
        this.kfh.setOnClickListener(this);
        this.jJL.setOnPlayClickListener(this);
        this.jJL.setFreeClickListener(this);
        setOnClickListener(this);
        this.ePf.setOnPreparedListener(this.evK);
        this.ePf.setOnCompletionListener(this.evJ);
        this.ePf.setOnErrorListener(this.iLw);
        this.ePf.setOnSeekCompleteListener(this.evN);
        this.ePf.setOnSurfaceDestroyedListener(this.emJ);
        this.ePf.setOnRecoveryCallback(this.kfT);
        onChangeSkinType();
    }

    public void onPause() {
        if (pI()) {
            this.jJA = true;
            asl();
        } else if (getCurrentState() == 3) {
            this.jJA = false;
        } else {
            this.jJA = false;
            asl();
        }
    }

    public void onResume() {
        if (this.jJA) {
            asn();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.iLC);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.knM = iVar;
        this.fYP.setText(aq.stringForVideoTime(this.knM.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ahO = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.ePf.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bED() {
        if (this.ePf != null && this.eFm != null) {
            if (this.kfL) {
                this.ePf.start();
                this.kfL = false;
            }
            e.lb().removeCallbacks(this.Yh);
            e.lb().postDelayed(this.Yh, 20L);
            e.lb().removeCallbacks(this.iLx);
            if (this.ePf.cJK()) {
                this.currentState = 1;
                this.ePf.setRecoveryState(1);
            }
            if (this.eFm != null) {
                this.mStartPosition = x.cKo().IO(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.ePf != null) {
                        this.ePf.Ba(this.mStartPosition);
                    } else {
                        this.eFm.seekTo(this.mStartPosition);
                    }
                    if (!this.kfK) {
                        showProgress();
                        e.lb().removeCallbacks(this.Yh);
                    }
                    this.kfF = true;
                }
            }
        }
    }

    public void cDl() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.ePf.isPlaying()) {
            asl();
        } else if (this.Yb) {
            asn();
        } else {
            cJd();
        }
    }

    public void setPauseState() {
        this.emA.cKl();
        this.iKY.setVisibility(0);
        this.kfh.setVisibility(8);
        this.currentState = 2;
        this.ePf.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.kfG) {
            ew(str, str2);
        } else {
            ev(str, str2);
        }
        if (aVar != null) {
            aVar.sX(z);
        }
    }

    public void ev(String str, String str2) {
        cJe();
        this.kfL = true;
        this.currentState = 0;
        this.ePf.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.ePf.setVideoPath(str, str2);
        this.emA.startLoading();
        this.ahE.setVisibility(0);
        this.iKY.setVisibility(8);
        this.kfh.setVisibility(8);
        this.grN.setVisibility(8);
        e.lb().removeCallbacks(this.iLx);
        e.lb().postDelayed(this.iLx, 60000L);
    }

    public void ew(String str, String str2) {
        cJe();
        this.kfL = true;
        this.currentState = 0;
        this.ePf.setRecoveryState(0);
        this.emA.startLoading();
        this.ahE.setVisibility(0);
        this.iKY.setVisibility(8);
        this.kfh.setVisibility(8);
        this.grN.setVisibility(8);
        e.lb().removeCallbacks(this.iLx);
        e.lb().postDelayed(this.iLx, 60000L);
    }

    public void asn() {
        this.currentState = 1;
        this.ePf.setRecoveryState(1);
        this.ePf.start();
        this.ahE.setVisibility(8);
        this.iKP.setVisibility(8);
        this.emA.cKl();
        showProgress();
        this.iKY.setVisibility(8);
        this.kfh.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.kfJ && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ahO)) {
            this.kfJ = false;
            this.kfK = true;
            ev(this.mVideoUrl, this.ahO);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.ePf != null) {
            this.ePf.setNeedRecovery(z);
        }
    }

    public void asl() {
        if (this.ePf.isPlaying() && this.kfE) {
            cJc();
        }
        this.ePf.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.ePf.isPlaying() && this.kfE) {
            cJc();
        }
        this.currentState = 5;
        this.ePf.setRecoveryState(5);
        e.lb().removeCallbacks(this.Yh);
        e.lb().removeCallbacks(this.iLx);
        this.ePf.stopPlayback();
        this.Yb = false;
        this.kfL = false;
        this.mStartPosition = 0;
        caF();
    }

    public void cJc() {
        x.cKo().bv(this.mVideoUrl, this.ePf.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        this.iKP.setVisibility(0);
        this.iKY.setVisibility(0);
        this.kfh.setVisibility(8);
        this.emA.cKl();
        this.kfe.setVisibility(8);
        this.grN.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ahE.setVisibility(z ? 0 : 8);
    }

    public void caF() {
        sS(true);
    }

    public boolean pI() {
        if (this.ePf == null) {
            return false;
        }
        return this.ePf.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ePf == null) {
            return 0;
        }
        return this.ePf.getCurrentPosition();
    }

    public void showProgress() {
        if (this.ePf != null) {
            this.kfe.setVisibility(0);
            this.eAn = ((this.ePf.getDuration() / 200) / 50) * 50;
            if (this.eAn < 50) {
                this.eAn = 50;
            } else if (this.eAn > 500) {
                this.eAn = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eAn - (this.ePf.getCurrentPosition() % this.eAn));
        }
    }

    private void cJd() {
        a(this.mVideoUrl, this.ahO, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cJe();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.kfG = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.jJU && !com.baidu.tieba.video.g.dav().daw()) {
            this.jJL.setVisibility(0);
            this.jJL.setData(this.knM.getDuration(), this.knM.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cJe() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dav().fd(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.ahE.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.grN) {
            cJd();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").af("obj_locate", 2).cI("tid", this.ahO));
            cDl();
        } else if (view == this.kfh) {
            ev(this.mVideoUrl, this.ahO);
        } else if (view == this.jJL.getTvPlay()) {
            this.jJU = true;
            this.jJL.setVisibility(8);
            ev(this.mVideoUrl, this.ahO);
        } else if (view == this.jJL.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.lb().removeCallbacks(this.Yh);
        e.lb().removeCallbacks(this.iLx);
        e.lb().removeCallbacks(this.kfR);
        this.mHandler.removeMessages(1);
        this.iLt.unregister(getContext());
    }
}
