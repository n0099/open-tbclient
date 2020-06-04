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
    private boolean Yr;
    private Runnable Yx;
    private TbImageView aii;
    private String ais;
    private int currentState;
    private w eBq;
    private QuickVideoView.b eBz;
    private g.InterfaceC0705g eKA;
    private g.a eKw;
    private g.f eKx;
    private int eOY;
    private QuickVideoView fbX;
    private VideoLoadingProgressView.a gEj;
    private View gGN;
    private TextView gnU;
    private g hxU;
    private View jaC;
    private ImageView jaL;
    private CallStateReceiver jbh;
    private g.b jbk;
    private Runnable jbl;
    private CustomMessageListener jbq;
    private VideoControllerView.b jdl;
    private i kGP;
    private PbVideoWifiTipLayout kcC;
    private boolean kcL;
    private boolean kcr;
    private boolean kyA;
    private boolean kyB;
    private boolean kyC;
    private boolean kyF;
    private boolean kyG;
    private boolean kyH;
    private Runnable kyN;
    private QuickVideoView.a kyP;
    private ProgressBar kya;
    private TextView kyd;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void tv(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.eOY = 50;
        this.mSkinType = 3;
        this.Yr = false;
        this.mStartPosition = 0;
        this.kyA = true;
        this.kyB = false;
        this.kyC = false;
        this.currentState = -1;
        this.kcr = false;
        this.eKx = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hxU = gVar;
                PushDialogVideoView.this.eBq.cRz();
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bKZ();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yr = true;
                    PushDialogVideoView.this.jaC.setVisibility(8);
                    PushDialogVideoView.this.gGN.setVisibility(8);
                    PushDialogVideoView.this.eBq.cRA();
                    PushDialogVideoView.this.aii.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kyH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jaC.setVisibility(0);
                PushDialogVideoView.this.kya.setVisibility(8);
                PushDialogVideoView.this.kya.setProgress(PushDialogVideoView.this.kya.getMax());
                if (PushDialogVideoView.this.fbX == null || PushDialogVideoView.this.fbX.getDuration() > 150000) {
                    PushDialogVideoView.this.tq(false);
                } else {
                    PushDialogVideoView.this.kyd.setVisibility(0);
                }
                x.cRE().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fbX.setRecoveryState(3);
                if (PushDialogVideoView.this.fbX != null && PushDialogVideoView.this.fbX.getDuration() <= 150000) {
                    PushDialogVideoView.this.eW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ais);
                }
            }
        };
        this.jbk = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.gGN.setVisibility(0);
                PushDialogVideoView.this.eBq.cRB();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fbX.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kyF = true;
                }
                PushDialogVideoView.this.kyH = false;
                return true;
            }
        };
        this.jbl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gGN.setVisibility(0);
                PushDialogVideoView.this.eBq.cRB();
            }
        };
        this.eKA = new g.InterfaceC0705g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kyB) {
                    e.ld().postDelayed(PushDialogVideoView.this.kyN, 200L);
                }
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbX == null || !PushDialogVideoView.this.kyB) {
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 200L);
                    PushDialogVideoView.this.kyB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fbX.getCurrentPosition()) {
                    PushDialogVideoView.this.kyB = false;
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
                } else {
                    e.ld().postDelayed(PushDialogVideoView.this.kyN, 200L);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kyH = false;
                e.ld().removeCallbacks(PushDialogVideoView.this.Yx);
                e.ld().removeCallbacks(PushDialogVideoView.this.jbl);
            }
        };
        this.jbq = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.avT();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fbX != null && PushDialogVideoView.this.fbX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fbX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fbX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jdl != null) {
                                PushDialogVideoView.this.jdl.pg(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eOY - (duration % PushDialogVideoView.this.eOY));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jdl = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pg(int i) {
                int duration;
                if (PushDialogVideoView.this.fbX != null && (duration = PushDialogVideoView.this.fbX.getDuration()) > 0 && PushDialogVideoView.this.kya != null) {
                    PushDialogVideoView.this.kya.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kyP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQF() {
                PushDialogVideoView.this.eBq.startLoading();
                PushDialogVideoView.this.aii.setVisibility(0);
                PushDialogVideoView.this.jaL.setVisibility(8);
                PushDialogVideoView.this.kyd.setVisibility(8);
                PushDialogVideoView.this.gGN.setVisibility(8);
                e.ld().removeCallbacks(PushDialogVideoView.this.jbl);
                e.ld().postDelayed(PushDialogVideoView.this.jbl, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOY = 50;
        this.mSkinType = 3;
        this.Yr = false;
        this.mStartPosition = 0;
        this.kyA = true;
        this.kyB = false;
        this.kyC = false;
        this.currentState = -1;
        this.kcr = false;
        this.eKx = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hxU = gVar;
                PushDialogVideoView.this.eBq.cRz();
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bKZ();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yr = true;
                    PushDialogVideoView.this.jaC.setVisibility(8);
                    PushDialogVideoView.this.gGN.setVisibility(8);
                    PushDialogVideoView.this.eBq.cRA();
                    PushDialogVideoView.this.aii.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kyH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jaC.setVisibility(0);
                PushDialogVideoView.this.kya.setVisibility(8);
                PushDialogVideoView.this.kya.setProgress(PushDialogVideoView.this.kya.getMax());
                if (PushDialogVideoView.this.fbX == null || PushDialogVideoView.this.fbX.getDuration() > 150000) {
                    PushDialogVideoView.this.tq(false);
                } else {
                    PushDialogVideoView.this.kyd.setVisibility(0);
                }
                x.cRE().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fbX.setRecoveryState(3);
                if (PushDialogVideoView.this.fbX != null && PushDialogVideoView.this.fbX.getDuration() <= 150000) {
                    PushDialogVideoView.this.eW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ais);
                }
            }
        };
        this.jbk = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.gGN.setVisibility(0);
                PushDialogVideoView.this.eBq.cRB();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fbX.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kyF = true;
                }
                PushDialogVideoView.this.kyH = false;
                return true;
            }
        };
        this.jbl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gGN.setVisibility(0);
                PushDialogVideoView.this.eBq.cRB();
            }
        };
        this.eKA = new g.InterfaceC0705g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kyB) {
                    e.ld().postDelayed(PushDialogVideoView.this.kyN, 200L);
                }
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbX == null || !PushDialogVideoView.this.kyB) {
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 200L);
                    PushDialogVideoView.this.kyB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fbX.getCurrentPosition()) {
                    PushDialogVideoView.this.kyB = false;
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
                } else {
                    e.ld().postDelayed(PushDialogVideoView.this.kyN, 200L);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kyH = false;
                e.ld().removeCallbacks(PushDialogVideoView.this.Yx);
                e.ld().removeCallbacks(PushDialogVideoView.this.jbl);
            }
        };
        this.jbq = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.avT();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fbX != null && PushDialogVideoView.this.fbX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fbX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fbX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jdl != null) {
                                PushDialogVideoView.this.jdl.pg(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eOY - (duration % PushDialogVideoView.this.eOY));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jdl = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pg(int i) {
                int duration;
                if (PushDialogVideoView.this.fbX != null && (duration = PushDialogVideoView.this.fbX.getDuration()) > 0 && PushDialogVideoView.this.kya != null) {
                    PushDialogVideoView.this.kya.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kyP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQF() {
                PushDialogVideoView.this.eBq.startLoading();
                PushDialogVideoView.this.aii.setVisibility(0);
                PushDialogVideoView.this.jaL.setVisibility(8);
                PushDialogVideoView.this.kyd.setVisibility(8);
                PushDialogVideoView.this.gGN.setVisibility(8);
                e.ld().removeCallbacks(PushDialogVideoView.this.jbl);
                e.ld().postDelayed(PushDialogVideoView.this.jbl, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOY = 50;
        this.mSkinType = 3;
        this.Yr = false;
        this.mStartPosition = 0;
        this.kyA = true;
        this.kyB = false;
        this.kyC = false;
        this.currentState = -1;
        this.kcr = false;
        this.eKx = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hxU = gVar;
                PushDialogVideoView.this.eBq.cRz();
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bKZ();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yr = true;
                    PushDialogVideoView.this.jaC.setVisibility(8);
                    PushDialogVideoView.this.gGN.setVisibility(8);
                    PushDialogVideoView.this.eBq.cRA();
                    PushDialogVideoView.this.aii.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kyH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jaC.setVisibility(0);
                PushDialogVideoView.this.kya.setVisibility(8);
                PushDialogVideoView.this.kya.setProgress(PushDialogVideoView.this.kya.getMax());
                if (PushDialogVideoView.this.fbX == null || PushDialogVideoView.this.fbX.getDuration() > 150000) {
                    PushDialogVideoView.this.tq(false);
                } else {
                    PushDialogVideoView.this.kyd.setVisibility(0);
                }
                x.cRE().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fbX.setRecoveryState(3);
                if (PushDialogVideoView.this.fbX != null && PushDialogVideoView.this.fbX.getDuration() <= 150000) {
                    PushDialogVideoView.this.eW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ais);
                }
            }
        };
        this.jbk = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.gGN.setVisibility(0);
                PushDialogVideoView.this.eBq.cRB();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fbX.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kyF = true;
                }
                PushDialogVideoView.this.kyH = false;
                return true;
            }
        };
        this.jbl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gGN.setVisibility(0);
                PushDialogVideoView.this.eBq.cRB();
            }
        };
        this.eKA = new g.InterfaceC0705g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kyB) {
                    e.ld().postDelayed(PushDialogVideoView.this.kyN, 200L);
                }
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbX == null || !PushDialogVideoView.this.kyB) {
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 200L);
                    PushDialogVideoView.this.kyB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fbX.getCurrentPosition()) {
                    PushDialogVideoView.this.kyB = false;
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
                } else {
                    e.ld().postDelayed(PushDialogVideoView.this.kyN, 200L);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kyH = false;
                e.ld().removeCallbacks(PushDialogVideoView.this.Yx);
                e.ld().removeCallbacks(PushDialogVideoView.this.jbl);
            }
        };
        this.jbq = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.avT();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fbX != null && PushDialogVideoView.this.fbX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fbX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fbX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jdl != null) {
                                PushDialogVideoView.this.jdl.pg(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eOY - (duration % PushDialogVideoView.this.eOY));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jdl = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pg(int i2) {
                int duration;
                if (PushDialogVideoView.this.fbX != null && (duration = PushDialogVideoView.this.fbX.getDuration()) > 0 && PushDialogVideoView.this.kya != null) {
                    PushDialogVideoView.this.kya.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kyP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQF() {
                PushDialogVideoView.this.eBq.startLoading();
                PushDialogVideoView.this.aii.setVisibility(0);
                PushDialogVideoView.this.jaL.setVisibility(8);
                PushDialogVideoView.this.kyd.setVisibility(8);
                PushDialogVideoView.this.gGN.setVisibility(8);
                e.ld().removeCallbacks(PushDialogVideoView.this.jbl);
                e.ld().postDelayed(PushDialogVideoView.this.jbl, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fbX = (QuickVideoView) findViewById(R.id.videoView);
        this.eBq = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eBq.setLoadingAnimationListener(this.gEj);
        this.kya = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.kya.setMax(this.mWidth);
        this.kya.setProgress(0);
        this.jaC = findViewById(R.id.black_mask);
        this.gGN = findViewById(R.id.layout_error);
        this.jaL = (ImageView) findViewById(R.id.img_play);
        this.kyd = (TextView) findViewById(R.id.txt_replay);
        this.gnU = (TextView) findViewById(R.id.push_dialog_video_time);
        this.aii = (TbImageView) findViewById(R.id.video_thumbnail);
        this.kcC = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.aii.setDefaultErrorResource(0);
        this.aii.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jbh = new CallStateReceiver();
        this.jbh.register(context);
        this.gGN.setOnClickListener(this);
        this.kyd.setOnClickListener(this);
        this.kcC.setOnPlayClickListener(this);
        this.kcC.setFreeClickListener(this);
        setOnClickListener(this);
        this.fbX.setOnPreparedListener(this.eKx);
        this.fbX.setOnCompletionListener(this.eKw);
        this.fbX.setOnErrorListener(this.jbk);
        this.fbX.setOnSeekCompleteListener(this.eKA);
        this.fbX.setOnSurfaceDestroyedListener(this.eBz);
        this.fbX.setOnRecoveryCallback(this.kyP);
        onChangeSkinType();
    }

    public void onPause() {
        if (pO()) {
            this.kcr = true;
            avT();
        } else if (getCurrentState() == 3) {
            this.kcr = false;
        } else {
            this.kcr = false;
            avT();
        }
    }

    public void onResume() {
        if (this.kcr) {
            avU();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jbq);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.kGP = iVar;
        this.gnU.setText(aq.stringForVideoTime(this.kGP.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ais = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.fbX.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKZ() {
        if (this.fbX != null && this.hxU != null) {
            if (this.kyH) {
                this.fbX.start();
                this.kyH = false;
            }
            e.ld().removeCallbacks(this.Yx);
            e.ld().postDelayed(this.Yx, 20L);
            e.ld().removeCallbacks(this.jbl);
            if (this.fbX.cRa()) {
                this.currentState = 1;
                this.fbX.setRecoveryState(1);
            }
            if (this.hxU != null) {
                this.mStartPosition = x.cRE().KB(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.fbX != null) {
                        this.fbX.BM(this.mStartPosition);
                    } else {
                        this.hxU.seekTo(this.mStartPosition);
                    }
                    if (!this.kyG) {
                        showProgress();
                        e.ld().removeCallbacks(this.Yx);
                    }
                    this.kyB = true;
                }
            }
        }
    }

    public void cKA() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fbX.isPlaying()) {
            avT();
        } else if (this.Yr) {
            avU();
        } else {
            cQt();
        }
    }

    public void setPauseState() {
        this.eBq.cRB();
        this.jaL.setVisibility(0);
        this.kyd.setVisibility(8);
        this.currentState = 2;
        this.fbX.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.kyC) {
            eX(str, str2);
        } else {
            eW(str, str2);
        }
        if (aVar != null) {
            aVar.tv(z);
        }
    }

    public void eW(String str, String str2) {
        cQu();
        this.kyH = true;
        this.currentState = 0;
        this.fbX.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.fbX.setVideoPath(str, str2);
        this.eBq.startLoading();
        this.aii.setVisibility(0);
        this.jaL.setVisibility(8);
        this.kyd.setVisibility(8);
        this.gGN.setVisibility(8);
        e.ld().removeCallbacks(this.jbl);
        e.ld().postDelayed(this.jbl, 60000L);
    }

    public void eX(String str, String str2) {
        cQu();
        this.kyH = true;
        this.currentState = 0;
        this.fbX.setRecoveryState(0);
        this.eBq.startLoading();
        this.aii.setVisibility(0);
        this.jaL.setVisibility(8);
        this.kyd.setVisibility(8);
        this.gGN.setVisibility(8);
        e.ld().removeCallbacks(this.jbl);
        e.ld().postDelayed(this.jbl, 60000L);
    }

    public void avU() {
        this.currentState = 1;
        this.fbX.setRecoveryState(1);
        this.fbX.start();
        this.aii.setVisibility(8);
        this.jaC.setVisibility(8);
        this.eBq.cRB();
        showProgress();
        this.jaL.setVisibility(8);
        this.kyd.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.kyF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ais)) {
            this.kyF = false;
            this.kyG = true;
            eW(this.mVideoUrl, this.ais);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.fbX != null) {
            this.fbX.setNeedRecovery(z);
        }
    }

    public void avT() {
        if (this.fbX.isPlaying() && this.kyA) {
            cQs();
        }
        this.fbX.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fbX.isPlaying() && this.kyA) {
            cQs();
        }
        this.currentState = 5;
        this.fbX.setRecoveryState(5);
        e.ld().removeCallbacks(this.Yx);
        e.ld().removeCallbacks(this.jbl);
        this.fbX.stopPlayback();
        this.Yr = false;
        this.kyH = false;
        this.mStartPosition = 0;
        cho();
    }

    public void cQs() {
        x.cRE().bw(this.mVideoUrl, this.fbX.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(boolean z) {
        this.jaC.setVisibility(0);
        this.jaL.setVisibility(0);
        this.kyd.setVisibility(8);
        this.eBq.cRB();
        this.kya.setVisibility(8);
        this.gGN.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.aii.setVisibility(z ? 0 : 8);
    }

    public void cho() {
        tq(true);
    }

    public boolean pO() {
        if (this.fbX == null) {
            return false;
        }
        return this.fbX.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fbX == null) {
            return 0;
        }
        return this.fbX.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fbX != null) {
            this.kya.setVisibility(0);
            this.eOY = ((this.fbX.getDuration() / 200) / 50) * 50;
            if (this.eOY < 50) {
                this.eOY = 50;
            } else if (this.eOY > 500) {
                this.eOY = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eOY - (this.fbX.getCurrentPosition() % this.eOY));
        }
    }

    private void cQt() {
        a(this.mVideoUrl, this.ais, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cQu();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.kyC = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.kcL && !com.baidu.tieba.video.g.dhZ().dia()) {
            this.kcC.setVisibility(0);
            this.kcC.setData(this.kGP.getDuration(), this.kGP.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cQu() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dhZ().fs(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.aii.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gGN) {
            cQt();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").ag("obj_locate", 2).dh("tid", this.ais));
            cKA();
        } else if (view == this.kyd) {
            eW(this.mVideoUrl, this.ais);
        } else if (view == this.kcC.getTvPlay()) {
            this.kcL = true;
            this.kcC.setVisibility(8);
            eW(this.mVideoUrl, this.ais);
        } else if (view == this.kcC.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.ld().removeCallbacks(this.Yx);
        e.ld().removeCallbacks(this.jbl);
        e.ld().removeCallbacks(this.kyN);
        this.mHandler.removeMessages(1);
        this.jbh.unregister(getContext());
    }
}
