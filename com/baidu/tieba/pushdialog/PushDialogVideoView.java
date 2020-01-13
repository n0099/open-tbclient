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
/* loaded from: classes6.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean Eo;
    private Runnable Eu;
    private String OG;
    private TbImageView Ow;
    private int currentState;
    private w dHV;
    private QuickVideoView.b dIe;
    private g.a dQW;
    private g.f dQX;
    private g.InterfaceC0582g dRa;
    private int dVN;
    private g eaK;
    private QuickVideoView egS;
    private VideoLoadingProgressView.a fHc;
    private View fJG;
    private TextView fqW;
    private CallStateReceiver hXJ;
    private g.b hXM;
    private Runnable hXN;
    private CustomMessageListener hXS;
    private View hXf;
    private ImageView hXo;
    private VideoControllerView.b hZM;
    private boolean iWf;
    private PbVideoWifiTipLayout iWq;
    private boolean iWz;
    private i jBg;
    private ProgressBar jsC;
    private TextView jsF;
    private boolean jtb;
    private boolean jtc;
    private boolean jtd;
    private boolean jtg;
    private boolean jth;
    private boolean jti;
    private Runnable jto;
    private QuickVideoView.a jtq;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void rK(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.dVN = 50;
        this.mSkinType = 3;
        this.Eo = false;
        this.mStartPosition = 0;
        this.jtb = true;
        this.jtc = false;
        this.jtd = false;
        this.currentState = -1;
        this.iWf = false;
        this.dQX = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eaK = gVar;
                PushDialogVideoView.this.dHV.cxP();
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bth();
            }
        };
        this.Eu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egS.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Eo = true;
                    PushDialogVideoView.this.hXf.setVisibility(8);
                    PushDialogVideoView.this.fJG.setVisibility(8);
                    PushDialogVideoView.this.dHV.cxQ();
                    PushDialogVideoView.this.Ow.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.Eu, 20L);
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Eo = false;
                PushDialogVideoView.this.jti = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hXf.setVisibility(0);
                PushDialogVideoView.this.jsC.setVisibility(8);
                PushDialogVideoView.this.jsC.setProgress(PushDialogVideoView.this.jsC.getMax());
                if (PushDialogVideoView.this.egS == null || PushDialogVideoView.this.egS.getDuration() > 150000) {
                    PushDialogVideoView.this.rF(false);
                } else {
                    PushDialogVideoView.this.jsF.setVisibility(0);
                }
                x.cxU().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.egS.setRecoveryState(3);
                if (PushDialogVideoView.this.egS != null && PushDialogVideoView.this.egS.getDuration() <= 150000) {
                    PushDialogVideoView.this.dZ(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.OG);
                }
            }
        };
        this.hXM = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fJG.setVisibility(0);
                PushDialogVideoView.this.dHV.cxR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.egS.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jtg = true;
                }
                PushDialogVideoView.this.jti = false;
                return true;
            }
        };
        this.hXN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fJG.setVisibility(0);
                PushDialogVideoView.this.dHV.cxR();
            }
        };
        this.dRa = new g.InterfaceC0582g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtc) {
                    e.gx().postDelayed(PushDialogVideoView.this.jto, 200L);
                }
            }
        };
        this.jto = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egS == null || !PushDialogVideoView.this.jtc) {
                    e.gx().postDelayed(PushDialogVideoView.this.Eu, 200L);
                    PushDialogVideoView.this.jtc = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.egS.getCurrentPosition()) {
                    PushDialogVideoView.this.jtc = false;
                    e.gx().postDelayed(PushDialogVideoView.this.Eu, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jto, 200L);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Eo = false;
                PushDialogVideoView.this.jti = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.Eu);
                e.gx().removeCallbacks(PushDialogVideoView.this.hXN);
            }
        };
        this.hXS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.egS != null && PushDialogVideoView.this.egS.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.egS.getCurrentPosition();
                            int duration = PushDialogVideoView.this.egS.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hZM != null) {
                                PushDialogVideoView.this.hZM.nR(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dVN - (duration % PushDialogVideoView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hZM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i) {
                int duration;
                if (PushDialogVideoView.this.egS != null && (duration = PushDialogVideoView.this.egS.getDuration()) > 0 && PushDialogVideoView.this.jsC != null) {
                    PushDialogVideoView.this.jsC.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jtq = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cwW() {
                PushDialogVideoView.this.dHV.startLoading();
                PushDialogVideoView.this.Ow.setVisibility(0);
                PushDialogVideoView.this.hXo.setVisibility(8);
                PushDialogVideoView.this.jsF.setVisibility(8);
                PushDialogVideoView.this.fJG.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hXN);
                e.gx().postDelayed(PushDialogVideoView.this.hXN, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVN = 50;
        this.mSkinType = 3;
        this.Eo = false;
        this.mStartPosition = 0;
        this.jtb = true;
        this.jtc = false;
        this.jtd = false;
        this.currentState = -1;
        this.iWf = false;
        this.dQX = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eaK = gVar;
                PushDialogVideoView.this.dHV.cxP();
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bth();
            }
        };
        this.Eu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egS.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Eo = true;
                    PushDialogVideoView.this.hXf.setVisibility(8);
                    PushDialogVideoView.this.fJG.setVisibility(8);
                    PushDialogVideoView.this.dHV.cxQ();
                    PushDialogVideoView.this.Ow.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.Eu, 20L);
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Eo = false;
                PushDialogVideoView.this.jti = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hXf.setVisibility(0);
                PushDialogVideoView.this.jsC.setVisibility(8);
                PushDialogVideoView.this.jsC.setProgress(PushDialogVideoView.this.jsC.getMax());
                if (PushDialogVideoView.this.egS == null || PushDialogVideoView.this.egS.getDuration() > 150000) {
                    PushDialogVideoView.this.rF(false);
                } else {
                    PushDialogVideoView.this.jsF.setVisibility(0);
                }
                x.cxU().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.egS.setRecoveryState(3);
                if (PushDialogVideoView.this.egS != null && PushDialogVideoView.this.egS.getDuration() <= 150000) {
                    PushDialogVideoView.this.dZ(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.OG);
                }
            }
        };
        this.hXM = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fJG.setVisibility(0);
                PushDialogVideoView.this.dHV.cxR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.egS.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jtg = true;
                }
                PushDialogVideoView.this.jti = false;
                return true;
            }
        };
        this.hXN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fJG.setVisibility(0);
                PushDialogVideoView.this.dHV.cxR();
            }
        };
        this.dRa = new g.InterfaceC0582g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtc) {
                    e.gx().postDelayed(PushDialogVideoView.this.jto, 200L);
                }
            }
        };
        this.jto = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egS == null || !PushDialogVideoView.this.jtc) {
                    e.gx().postDelayed(PushDialogVideoView.this.Eu, 200L);
                    PushDialogVideoView.this.jtc = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.egS.getCurrentPosition()) {
                    PushDialogVideoView.this.jtc = false;
                    e.gx().postDelayed(PushDialogVideoView.this.Eu, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jto, 200L);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Eo = false;
                PushDialogVideoView.this.jti = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.Eu);
                e.gx().removeCallbacks(PushDialogVideoView.this.hXN);
            }
        };
        this.hXS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.egS != null && PushDialogVideoView.this.egS.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.egS.getCurrentPosition();
                            int duration = PushDialogVideoView.this.egS.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hZM != null) {
                                PushDialogVideoView.this.hZM.nR(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dVN - (duration % PushDialogVideoView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hZM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i) {
                int duration;
                if (PushDialogVideoView.this.egS != null && (duration = PushDialogVideoView.this.egS.getDuration()) > 0 && PushDialogVideoView.this.jsC != null) {
                    PushDialogVideoView.this.jsC.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jtq = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cwW() {
                PushDialogVideoView.this.dHV.startLoading();
                PushDialogVideoView.this.Ow.setVisibility(0);
                PushDialogVideoView.this.hXo.setVisibility(8);
                PushDialogVideoView.this.jsF.setVisibility(8);
                PushDialogVideoView.this.fJG.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hXN);
                e.gx().postDelayed(PushDialogVideoView.this.hXN, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVN = 50;
        this.mSkinType = 3;
        this.Eo = false;
        this.mStartPosition = 0;
        this.jtb = true;
        this.jtc = false;
        this.jtd = false;
        this.currentState = -1;
        this.iWf = false;
        this.dQX = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eaK = gVar;
                PushDialogVideoView.this.dHV.cxP();
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bth();
            }
        };
        this.Eu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egS.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Eo = true;
                    PushDialogVideoView.this.hXf.setVisibility(8);
                    PushDialogVideoView.this.fJG.setVisibility(8);
                    PushDialogVideoView.this.dHV.cxQ();
                    PushDialogVideoView.this.Ow.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.Eu, 20L);
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Eo = false;
                PushDialogVideoView.this.jti = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hXf.setVisibility(0);
                PushDialogVideoView.this.jsC.setVisibility(8);
                PushDialogVideoView.this.jsC.setProgress(PushDialogVideoView.this.jsC.getMax());
                if (PushDialogVideoView.this.egS == null || PushDialogVideoView.this.egS.getDuration() > 150000) {
                    PushDialogVideoView.this.rF(false);
                } else {
                    PushDialogVideoView.this.jsF.setVisibility(0);
                }
                x.cxU().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.egS.setRecoveryState(3);
                if (PushDialogVideoView.this.egS != null && PushDialogVideoView.this.egS.getDuration() <= 150000) {
                    PushDialogVideoView.this.dZ(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.OG);
                }
            }
        };
        this.hXM = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.fJG.setVisibility(0);
                PushDialogVideoView.this.dHV.cxR();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.egS.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jtg = true;
                }
                PushDialogVideoView.this.jti = false;
                return true;
            }
        };
        this.hXN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fJG.setVisibility(0);
                PushDialogVideoView.this.dHV.cxR();
            }
        };
        this.dRa = new g.InterfaceC0582g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtc) {
                    e.gx().postDelayed(PushDialogVideoView.this.jto, 200L);
                }
            }
        };
        this.jto = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.egS == null || !PushDialogVideoView.this.jtc) {
                    e.gx().postDelayed(PushDialogVideoView.this.Eu, 200L);
                    PushDialogVideoView.this.jtc = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.egS.getCurrentPosition()) {
                    PushDialogVideoView.this.jtc = false;
                    e.gx().postDelayed(PushDialogVideoView.this.Eu, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jto, 200L);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Eo = false;
                PushDialogVideoView.this.jti = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.Eu);
                e.gx().removeCallbacks(PushDialogVideoView.this.hXN);
            }
        };
        this.hXS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.egS != null && PushDialogVideoView.this.egS.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.egS.getCurrentPosition();
                            int duration = PushDialogVideoView.this.egS.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hZM != null) {
                                PushDialogVideoView.this.hZM.nR(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dVN - (duration % PushDialogVideoView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hZM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i2) {
                int duration;
                if (PushDialogVideoView.this.egS != null && (duration = PushDialogVideoView.this.egS.getDuration()) > 0 && PushDialogVideoView.this.jsC != null) {
                    PushDialogVideoView.this.jsC.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jtq = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cwW() {
                PushDialogVideoView.this.dHV.startLoading();
                PushDialogVideoView.this.Ow.setVisibility(0);
                PushDialogVideoView.this.hXo.setVisibility(8);
                PushDialogVideoView.this.jsF.setVisibility(8);
                PushDialogVideoView.this.fJG.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hXN);
                e.gx().postDelayed(PushDialogVideoView.this.hXN, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.egS = (QuickVideoView) findViewById(R.id.videoView);
        this.dHV = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dHV.setLoadingAnimationListener(this.fHc);
        this.jsC = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.jsC.setMax(this.mWidth);
        this.jsC.setProgress(0);
        this.hXf = findViewById(R.id.black_mask);
        this.fJG = findViewById(R.id.layout_error);
        this.hXo = (ImageView) findViewById(R.id.img_play);
        this.jsF = (TextView) findViewById(R.id.txt_replay);
        this.fqW = (TextView) findViewById(R.id.push_dialog_video_time);
        this.Ow = (TbImageView) findViewById(R.id.video_thumbnail);
        this.iWq = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.Ow.setDefaultErrorResource(0);
        this.Ow.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hXJ = new CallStateReceiver();
        this.hXJ.register(context);
        this.fJG.setOnClickListener(this);
        this.jsF.setOnClickListener(this);
        this.iWq.setOnPlayClickListener(this);
        this.iWq.setFreeClickListener(this);
        setOnClickListener(this);
        this.egS.setOnPreparedListener(this.dQX);
        this.egS.setOnCompletionListener(this.dQW);
        this.egS.setOnErrorListener(this.hXM);
        this.egS.setOnSeekCompleteListener(this.dRa);
        this.egS.setOnSurfaceDestroyedListener(this.dIe);
        this.egS.setOnRecoveryCallback(this.jtq);
        onChangeSkinType();
    }

    public void onPause() {
        if (kP()) {
            this.iWf = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iWf = false;
        } else {
            this.iWf = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iWf) {
            ahK();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hXS);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.jBg = iVar;
        this.fqW.setText(aq.stringForVideoTime(this.jBg.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.OG = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.egS.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bth() {
        if (this.egS != null && this.eaK != null) {
            if (this.jti) {
                this.egS.start();
                this.jti = false;
            }
            e.gx().removeCallbacks(this.Eu);
            e.gx().postDelayed(this.Eu, 20L);
            e.gx().removeCallbacks(this.hXN);
            if (this.egS.cxq()) {
                this.currentState = 1;
                this.egS.setRecoveryState(1);
            }
            if (this.eaK != null) {
                this.mStartPosition = x.cxU().GP(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.egS != null) {
                        this.egS.Ai(this.mStartPosition);
                    } else {
                        this.eaK.seekTo(this.mStartPosition);
                    }
                    if (!this.jth) {
                        showProgress();
                        e.gx().removeCallbacks(this.Eu);
                    }
                    this.jtc = true;
                }
            }
        }
    }

    public void cqS() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.egS.isPlaying()) {
            pausePlay();
        } else if (this.Eo) {
            ahK();
        } else {
            cwK();
        }
    }

    public void setPauseState() {
        this.dHV.cxR();
        this.hXo.setVisibility(0);
        this.jsF.setVisibility(8);
        this.currentState = 2;
        this.egS.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.jtd) {
            ea(str, str2);
        } else {
            dZ(str, str2);
        }
        if (aVar != null) {
            aVar.rK(z);
        }
    }

    public void dZ(String str, String str2) {
        cwL();
        this.jti = true;
        this.currentState = 0;
        this.egS.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.egS.setVideoPath(str, str2);
        this.dHV.startLoading();
        this.Ow.setVisibility(0);
        this.hXo.setVisibility(8);
        this.jsF.setVisibility(8);
        this.fJG.setVisibility(8);
        e.gx().removeCallbacks(this.hXN);
        e.gx().postDelayed(this.hXN, 60000L);
    }

    public void ea(String str, String str2) {
        cwL();
        this.jti = true;
        this.currentState = 0;
        this.egS.setRecoveryState(0);
        this.dHV.startLoading();
        this.Ow.setVisibility(0);
        this.hXo.setVisibility(8);
        this.jsF.setVisibility(8);
        this.fJG.setVisibility(8);
        e.gx().removeCallbacks(this.hXN);
        e.gx().postDelayed(this.hXN, 60000L);
    }

    public void ahK() {
        this.currentState = 1;
        this.egS.setRecoveryState(1);
        this.egS.start();
        this.Ow.setVisibility(8);
        this.hXf.setVisibility(8);
        this.dHV.cxR();
        showProgress();
        this.hXo.setVisibility(8);
        this.jsF.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.jtg && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.OG)) {
            this.jtg = false;
            this.jth = true;
            dZ(this.mVideoUrl, this.OG);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.egS != null) {
            this.egS.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.egS.isPlaying() && this.jtb) {
            cwJ();
        }
        this.egS.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.egS.isPlaying() && this.jtb) {
            cwJ();
        }
        this.currentState = 5;
        this.egS.setRecoveryState(5);
        e.gx().removeCallbacks(this.Eu);
        e.gx().removeCallbacks(this.hXN);
        this.egS.stopPlayback();
        this.Eo = false;
        this.jti = false;
        this.mStartPosition = 0;
        bOk();
    }

    public void cwJ() {
        x.cxU().bn(this.mVideoUrl, this.egS.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rF(boolean z) {
        this.hXf.setVisibility(0);
        this.hXo.setVisibility(0);
        this.jsF.setVisibility(8);
        this.dHV.cxR();
        this.jsC.setVisibility(8);
        this.fJG.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.Ow.setVisibility(z ? 0 : 8);
    }

    public void bOk() {
        rF(true);
    }

    public boolean kP() {
        if (this.egS == null) {
            return false;
        }
        return this.egS.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.egS == null) {
            return 0;
        }
        return this.egS.getCurrentPosition();
    }

    public void showProgress() {
        if (this.egS != null) {
            this.jsC.setVisibility(0);
            this.dVN = ((this.egS.getDuration() / 200) / 50) * 50;
            if (this.dVN < 50) {
                this.dVN = 50;
            } else if (this.dVN > 500) {
                this.dVN = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVN - (this.egS.getCurrentPosition() % this.dVN));
        }
    }

    private void cwK() {
        a(this.mVideoUrl, this.OG, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cwL();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.jtd = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.iWz && !com.baidu.tieba.video.g.cNI().cNJ()) {
            this.iWq.setVisibility(0);
            this.iWq.setData(this.jBg.getDuration(), this.jBg.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cwL() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.cNI().fy(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.Ow.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fJG) {
            cwK();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").Z("obj_locate", 2).cp("tid", this.OG));
            cqS();
        } else if (view == this.jsF) {
            dZ(this.mVideoUrl, this.OG);
        } else if (view == this.iWq.getTvPlay()) {
            this.iWz = true;
            this.iWq.setVisibility(8);
            dZ(this.mVideoUrl, this.OG);
        } else if (view == this.iWq.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.gx().removeCallbacks(this.Eu);
        e.gx().removeCallbacks(this.hXN);
        e.gx().removeCallbacks(this.jto);
        this.mHandler.removeMessages(1);
        this.hXJ.unregister(getContext());
    }
}
