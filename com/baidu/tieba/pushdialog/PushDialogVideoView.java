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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.j;
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
import com.baidu.tieba.video.h;
/* loaded from: classes8.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean YV;
    private Runnable Zb;
    private TbImageView ajE;
    private String ajO;
    private int currentState;
    private w eKZ;
    private QuickVideoView.b eLi;
    private g.a eUI;
    private g.f eUJ;
    private g.InterfaceC0721g eUM;
    private int eZj;
    private QuickVideoView fnh;
    private TextView gAK;
    private VideoLoadingProgressView.a gQZ;
    private View gTN;
    private g hKR;
    private View jrM;
    private ImageView jrV;
    private CustomMessageListener jsA;
    private CallStateReceiver jsr;
    private g.b jsu;
    private Runnable jsv;
    private VideoControllerView.b juu;
    private ProgressBar kRX;
    private boolean kSC;
    private boolean kSD;
    private boolean kSE;
    private Runnable kSK;
    private QuickVideoView.a kSM;
    private TextView kSa;
    private boolean kSx;
    private boolean kSy;
    private boolean kSz;
    private boolean kwe;
    private PbVideoWifiTipLayout kwp;
    private boolean kwy;
    private j laM;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void tJ(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.eZj = 50;
        this.mSkinType = 3;
        this.YV = false;
        this.mStartPosition = 0;
        this.kSx = true;
        this.kSy = false;
        this.kSz = false;
        this.currentState = -1;
        this.kwe = false;
        this.eUJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hKR = gVar;
                PushDialogVideoView.this.eKZ.cVR();
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bOi();
            }
        };
        this.Zb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fnh.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.YV = true;
                    PushDialogVideoView.this.jrM.setVisibility(8);
                    PushDialogVideoView.this.gTN.setVisibility(8);
                    PushDialogVideoView.this.eKZ.cVS();
                    PushDialogVideoView.this.ajE.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lt().postDelayed(PushDialogVideoView.this.Zb, 20L);
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.YV = false;
                PushDialogVideoView.this.kSE = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jrM.setVisibility(0);
                PushDialogVideoView.this.kRX.setVisibility(8);
                PushDialogVideoView.this.kRX.setProgress(PushDialogVideoView.this.kRX.getMax());
                if (PushDialogVideoView.this.fnh == null || PushDialogVideoView.this.fnh.getDuration() > 150000) {
                    PushDialogVideoView.this.tE(false);
                } else {
                    PushDialogVideoView.this.kSa.setVisibility(0);
                }
                x.cVW().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fnh.setRecoveryState(3);
                if (PushDialogVideoView.this.fnh != null && PushDialogVideoView.this.fnh.getDuration() <= 150000) {
                    PushDialogVideoView.this.fd(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ajO);
                }
            }
        };
        this.jsu = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.gTN.setVisibility(0);
                PushDialogVideoView.this.eKZ.cVT();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fnh.setRecoveryState(4);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kSC = true;
                }
                PushDialogVideoView.this.kSE = false;
                return true;
            }
        };
        this.jsv = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gTN.setVisibility(0);
                PushDialogVideoView.this.eKZ.cVT();
            }
        };
        this.eUM = new g.InterfaceC0721g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kSy) {
                    e.lt().postDelayed(PushDialogVideoView.this.kSK, 200L);
                }
            }
        };
        this.kSK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fnh == null || !PushDialogVideoView.this.kSy) {
                    e.lt().postDelayed(PushDialogVideoView.this.Zb, 200L);
                    PushDialogVideoView.this.kSy = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fnh.getCurrentPosition()) {
                    PushDialogVideoView.this.kSy = false;
                    e.lt().postDelayed(PushDialogVideoView.this.Zb, 20L);
                } else {
                    e.lt().postDelayed(PushDialogVideoView.this.kSK, 200L);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.YV = false;
                PushDialogVideoView.this.kSE = false;
                e.lt().removeCallbacks(PushDialogVideoView.this.Zb);
                e.lt().removeCallbacks(PushDialogVideoView.this.jsv);
            }
        };
        this.jsA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.awZ();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fnh != null && PushDialogVideoView.this.fnh.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fnh.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fnh.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.juu != null) {
                                PushDialogVideoView.this.juu.pF(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eZj - (duration % PushDialogVideoView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.juu = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pF(int i) {
                int duration;
                if (PushDialogVideoView.this.fnh != null && (duration = PushDialogVideoView.this.fnh.getDuration()) > 0 && PushDialogVideoView.this.kRX != null) {
                    PushDialogVideoView.this.kRX.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kSM = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cUX() {
                PushDialogVideoView.this.eKZ.startLoading();
                PushDialogVideoView.this.ajE.setVisibility(0);
                PushDialogVideoView.this.jrV.setVisibility(8);
                PushDialogVideoView.this.kSa.setVisibility(8);
                PushDialogVideoView.this.gTN.setVisibility(8);
                e.lt().removeCallbacks(PushDialogVideoView.this.jsv);
                e.lt().postDelayed(PushDialogVideoView.this.jsv, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZj = 50;
        this.mSkinType = 3;
        this.YV = false;
        this.mStartPosition = 0;
        this.kSx = true;
        this.kSy = false;
        this.kSz = false;
        this.currentState = -1;
        this.kwe = false;
        this.eUJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hKR = gVar;
                PushDialogVideoView.this.eKZ.cVR();
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bOi();
            }
        };
        this.Zb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fnh.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.YV = true;
                    PushDialogVideoView.this.jrM.setVisibility(8);
                    PushDialogVideoView.this.gTN.setVisibility(8);
                    PushDialogVideoView.this.eKZ.cVS();
                    PushDialogVideoView.this.ajE.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lt().postDelayed(PushDialogVideoView.this.Zb, 20L);
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.YV = false;
                PushDialogVideoView.this.kSE = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jrM.setVisibility(0);
                PushDialogVideoView.this.kRX.setVisibility(8);
                PushDialogVideoView.this.kRX.setProgress(PushDialogVideoView.this.kRX.getMax());
                if (PushDialogVideoView.this.fnh == null || PushDialogVideoView.this.fnh.getDuration() > 150000) {
                    PushDialogVideoView.this.tE(false);
                } else {
                    PushDialogVideoView.this.kSa.setVisibility(0);
                }
                x.cVW().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fnh.setRecoveryState(3);
                if (PushDialogVideoView.this.fnh != null && PushDialogVideoView.this.fnh.getDuration() <= 150000) {
                    PushDialogVideoView.this.fd(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ajO);
                }
            }
        };
        this.jsu = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.gTN.setVisibility(0);
                PushDialogVideoView.this.eKZ.cVT();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fnh.setRecoveryState(4);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kSC = true;
                }
                PushDialogVideoView.this.kSE = false;
                return true;
            }
        };
        this.jsv = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gTN.setVisibility(0);
                PushDialogVideoView.this.eKZ.cVT();
            }
        };
        this.eUM = new g.InterfaceC0721g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kSy) {
                    e.lt().postDelayed(PushDialogVideoView.this.kSK, 200L);
                }
            }
        };
        this.kSK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fnh == null || !PushDialogVideoView.this.kSy) {
                    e.lt().postDelayed(PushDialogVideoView.this.Zb, 200L);
                    PushDialogVideoView.this.kSy = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fnh.getCurrentPosition()) {
                    PushDialogVideoView.this.kSy = false;
                    e.lt().postDelayed(PushDialogVideoView.this.Zb, 20L);
                } else {
                    e.lt().postDelayed(PushDialogVideoView.this.kSK, 200L);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.YV = false;
                PushDialogVideoView.this.kSE = false;
                e.lt().removeCallbacks(PushDialogVideoView.this.Zb);
                e.lt().removeCallbacks(PushDialogVideoView.this.jsv);
            }
        };
        this.jsA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.awZ();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fnh != null && PushDialogVideoView.this.fnh.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fnh.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fnh.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.juu != null) {
                                PushDialogVideoView.this.juu.pF(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eZj - (duration % PushDialogVideoView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.juu = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pF(int i) {
                int duration;
                if (PushDialogVideoView.this.fnh != null && (duration = PushDialogVideoView.this.fnh.getDuration()) > 0 && PushDialogVideoView.this.kRX != null) {
                    PushDialogVideoView.this.kRX.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kSM = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cUX() {
                PushDialogVideoView.this.eKZ.startLoading();
                PushDialogVideoView.this.ajE.setVisibility(0);
                PushDialogVideoView.this.jrV.setVisibility(8);
                PushDialogVideoView.this.kSa.setVisibility(8);
                PushDialogVideoView.this.gTN.setVisibility(8);
                e.lt().removeCallbacks(PushDialogVideoView.this.jsv);
                e.lt().postDelayed(PushDialogVideoView.this.jsv, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZj = 50;
        this.mSkinType = 3;
        this.YV = false;
        this.mStartPosition = 0;
        this.kSx = true;
        this.kSy = false;
        this.kSz = false;
        this.currentState = -1;
        this.kwe = false;
        this.eUJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hKR = gVar;
                PushDialogVideoView.this.eKZ.cVR();
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bOi();
            }
        };
        this.Zb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fnh.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.YV = true;
                    PushDialogVideoView.this.jrM.setVisibility(8);
                    PushDialogVideoView.this.gTN.setVisibility(8);
                    PushDialogVideoView.this.eKZ.cVS();
                    PushDialogVideoView.this.ajE.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.lt().postDelayed(PushDialogVideoView.this.Zb, 20L);
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.YV = false;
                PushDialogVideoView.this.kSE = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jrM.setVisibility(0);
                PushDialogVideoView.this.kRX.setVisibility(8);
                PushDialogVideoView.this.kRX.setProgress(PushDialogVideoView.this.kRX.getMax());
                if (PushDialogVideoView.this.fnh == null || PushDialogVideoView.this.fnh.getDuration() > 150000) {
                    PushDialogVideoView.this.tE(false);
                } else {
                    PushDialogVideoView.this.kSa.setVisibility(0);
                }
                x.cVW().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fnh.setRecoveryState(3);
                if (PushDialogVideoView.this.fnh != null && PushDialogVideoView.this.fnh.getDuration() <= 150000) {
                    PushDialogVideoView.this.fd(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ajO);
                }
            }
        };
        this.jsu = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.gTN.setVisibility(0);
                PushDialogVideoView.this.eKZ.cVT();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fnh.setRecoveryState(4);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kSC = true;
                }
                PushDialogVideoView.this.kSE = false;
                return true;
            }
        };
        this.jsv = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gTN.setVisibility(0);
                PushDialogVideoView.this.eKZ.cVT();
            }
        };
        this.eUM = new g.InterfaceC0721g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kSy) {
                    e.lt().postDelayed(PushDialogVideoView.this.kSK, 200L);
                }
            }
        };
        this.kSK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fnh == null || !PushDialogVideoView.this.kSy) {
                    e.lt().postDelayed(PushDialogVideoView.this.Zb, 200L);
                    PushDialogVideoView.this.kSy = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fnh.getCurrentPosition()) {
                    PushDialogVideoView.this.kSy = false;
                    e.lt().postDelayed(PushDialogVideoView.this.Zb, 20L);
                } else {
                    e.lt().postDelayed(PushDialogVideoView.this.kSK, 200L);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.YV = false;
                PushDialogVideoView.this.kSE = false;
                e.lt().removeCallbacks(PushDialogVideoView.this.Zb);
                e.lt().removeCallbacks(PushDialogVideoView.this.jsv);
            }
        };
        this.jsA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.awZ();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fnh != null && PushDialogVideoView.this.fnh.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fnh.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fnh.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.juu != null) {
                                PushDialogVideoView.this.juu.pF(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eZj - (duration % PushDialogVideoView.this.eZj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.juu = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pF(int i2) {
                int duration;
                if (PushDialogVideoView.this.fnh != null && (duration = PushDialogVideoView.this.fnh.getDuration()) > 0 && PushDialogVideoView.this.kRX != null) {
                    PushDialogVideoView.this.kRX.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kSM = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cUX() {
                PushDialogVideoView.this.eKZ.startLoading();
                PushDialogVideoView.this.ajE.setVisibility(0);
                PushDialogVideoView.this.jrV.setVisibility(8);
                PushDialogVideoView.this.kSa.setVisibility(8);
                PushDialogVideoView.this.gTN.setVisibility(8);
                e.lt().removeCallbacks(PushDialogVideoView.this.jsv);
                e.lt().postDelayed(PushDialogVideoView.this.jsv, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fnh = (QuickVideoView) findViewById(R.id.videoView);
        this.eKZ = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eKZ.setLoadingAnimationListener(this.gQZ);
        this.kRX = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.kRX.setMax(this.mWidth);
        this.kRX.setProgress(0);
        this.jrM = findViewById(R.id.black_mask);
        this.gTN = findViewById(R.id.layout_error);
        this.jrV = (ImageView) findViewById(R.id.img_play);
        this.kSa = (TextView) findViewById(R.id.txt_replay);
        this.gAK = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ajE = (TbImageView) findViewById(R.id.video_thumbnail);
        this.kwp = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ajE.setDefaultErrorResource(0);
        this.ajE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jsr = new CallStateReceiver();
        this.jsr.register(context);
        this.gTN.setOnClickListener(this);
        this.kSa.setOnClickListener(this);
        this.kwp.setOnPlayClickListener(this);
        this.kwp.setFreeClickListener(this);
        setOnClickListener(this);
        this.fnh.setOnPreparedListener(this.eUJ);
        this.fnh.setOnCompletionListener(this.eUI);
        this.fnh.setOnErrorListener(this.jsu);
        this.fnh.setOnSeekCompleteListener(this.eUM);
        this.fnh.setOnSurfaceDestroyedListener(this.eLi);
        this.fnh.setOnRecoveryCallback(this.kSM);
        onChangeSkinType();
    }

    public void onPause() {
        if (qf()) {
            this.kwe = true;
            awZ();
        } else if (getCurrentState() == 3) {
            this.kwe = false;
        } else {
            this.kwe = false;
            awZ();
        }
    }

    public void onResume() {
        if (this.kwe) {
            axa();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jsA);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.laM = jVar;
        this.gAK.setText(ar.stringForVideoTime(this.laM.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ajO = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.fnh.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        if (this.fnh != null && this.hKR != null) {
            if (this.kSE) {
                this.fnh.start();
                this.kSE = false;
            }
            e.lt().removeCallbacks(this.Zb);
            e.lt().postDelayed(this.Zb, 20L);
            e.lt().removeCallbacks(this.jsv);
            if (this.fnh.cVs()) {
                this.currentState = 1;
                this.fnh.setRecoveryState(1);
            }
            if (this.hKR != null) {
                this.mStartPosition = x.cVW().Lc(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.fnh != null) {
                        this.fnh.CO(this.mStartPosition);
                    } else {
                        this.hKR.seekTo(this.mStartPosition);
                    }
                    if (!this.kSD) {
                        showProgress();
                        e.lt().removeCallbacks(this.Zb);
                    }
                    this.kSy = true;
                }
            }
        }
    }

    public void cOS() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fnh.isPlaying()) {
            awZ();
        } else if (this.YV) {
            axa();
        } else {
            cUL();
        }
    }

    public void setPauseState() {
        this.eKZ.cVT();
        this.jrV.setVisibility(0);
        this.kSa.setVisibility(8);
        this.currentState = 2;
        this.fnh.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.kSz) {
            fe(str, str2);
        } else {
            fd(str, str2);
        }
        if (aVar != null) {
            aVar.tJ(z);
        }
    }

    public void fd(String str, String str2) {
        cUM();
        this.kSE = true;
        this.currentState = 0;
        this.fnh.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.fnh.setVideoPath(str, str2);
        this.eKZ.startLoading();
        this.ajE.setVisibility(0);
        this.jrV.setVisibility(8);
        this.kSa.setVisibility(8);
        this.gTN.setVisibility(8);
        e.lt().removeCallbacks(this.jsv);
        e.lt().postDelayed(this.jsv, 60000L);
    }

    public void fe(String str, String str2) {
        cUM();
        this.kSE = true;
        this.currentState = 0;
        this.fnh.setRecoveryState(0);
        this.eKZ.startLoading();
        this.ajE.setVisibility(0);
        this.jrV.setVisibility(8);
        this.kSa.setVisibility(8);
        this.gTN.setVisibility(8);
        e.lt().removeCallbacks(this.jsv);
        e.lt().postDelayed(this.jsv, 60000L);
    }

    public void axa() {
        this.currentState = 1;
        this.fnh.setRecoveryState(1);
        this.fnh.start();
        this.ajE.setVisibility(8);
        this.jrM.setVisibility(8);
        this.eKZ.cVT();
        showProgress();
        this.jrV.setVisibility(8);
        this.kSa.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.kSC && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ajO)) {
            this.kSC = false;
            this.kSD = true;
            fd(this.mVideoUrl, this.ajO);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.fnh != null) {
            this.fnh.setNeedRecovery(z);
        }
    }

    public void awZ() {
        if (this.fnh.isPlaying() && this.kSx) {
            cUK();
        }
        this.fnh.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fnh.isPlaying() && this.kSx) {
            cUK();
        }
        this.currentState = 5;
        this.fnh.setRecoveryState(5);
        e.lt().removeCallbacks(this.Zb);
        e.lt().removeCallbacks(this.jsv);
        this.fnh.stopPlayback();
        this.YV = false;
        this.kSE = false;
        this.mStartPosition = 0;
        clb();
    }

    public void cUK() {
        x.cVW().bv(this.mVideoUrl, this.fnh.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE(boolean z) {
        this.jrM.setVisibility(0);
        this.jrV.setVisibility(0);
        this.kSa.setVisibility(8);
        this.eKZ.cVT();
        this.kRX.setVisibility(8);
        this.gTN.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ajE.setVisibility(z ? 0 : 8);
    }

    public void clb() {
        tE(true);
    }

    public boolean qf() {
        if (this.fnh == null) {
            return false;
        }
        return this.fnh.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fnh == null) {
            return 0;
        }
        return this.fnh.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fnh != null) {
            this.kRX.setVisibility(0);
            this.eZj = ((this.fnh.getDuration() / 200) / 50) * 50;
            if (this.eZj < 50) {
                this.eZj = 50;
            } else if (this.eZj > 500) {
                this.eZj = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eZj - (this.fnh.getCurrentPosition() % this.eZj));
        }
    }

    private void cUL() {
        a(this.mVideoUrl, this.ajO, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cUM();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.kSz = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kwy && !h.dmo().dmp()) {
            this.kwp.setVisibility(0);
            this.kwp.setData(this.laM.getDuration(), this.laM.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cUM() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            h.dmo().fs(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.ajE.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTN) {
            cUL();
        } else if (view == this) {
            TiebaStatic.log(new ao("c13199").ag("obj_locate", 2).dk("tid", this.ajO));
            cOS();
        } else if (view == this.kSa) {
            fd(this.mVideoUrl, this.ajO);
        } else if (view == this.kwp.getTvPlay()) {
            this.kwy = true;
            this.kwp.setVisibility(8);
            fd(this.mVideoUrl, this.ajO);
        } else if (view == this.kwp.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.lt().removeCallbacks(this.Zb);
        e.lt().removeCallbacks(this.jsv);
        e.lt().removeCallbacks(this.kSK);
        this.mHandler.removeMessages(1);
        this.jsr.unregister(getContext());
    }
}
