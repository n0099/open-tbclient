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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private boolean BD;
    private Runnable BJ;
    private QuickVideoView.b cTC;
    private x cTt;
    private String cln;
    private String cma;
    private int currentState;
    private g.a dcS;
    private g.f dcT;
    private g.InterfaceC0493g dcW;
    private int dhR;
    private g dqC;
    private QuickVideoView dvG;
    private VideoLoadingProgressView.a eMc;
    private View eOI;
    private TextView ewn;
    private ImageView hfG;
    private TbImageView hfH;
    private View hfx;
    private CallStateReceiver hgc;
    private g.b hgf;
    private Runnable hgg;
    private CustomMessageListener hgl;
    private VideoControllerView.b hih;
    private f iDk;
    private boolean idF;
    private PbVideoWifiTipLayout idQ;
    private boolean idZ;
    private boolean ivA;
    private boolean ivB;
    private boolean ivC;
    private boolean ivF;
    private boolean ivG;
    private boolean ivH;
    private Runnable ivN;
    private QuickVideoView.a ivP;
    private ProgressBar ivb;
    private TextView ive;
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
        this.dhR = 50;
        this.mSkinType = 3;
        this.BD = false;
        this.mStartPosition = 0;
        this.ivA = true;
        this.ivB = false;
        this.ivC = false;
        this.currentState = -1;
        this.idF = false;
        this.dcT = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dqC = gVar;
                PushDialogVideoView.this.cTt.ccL();
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bab();
            }
        };
        this.BJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dvG.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.BD = true;
                    PushDialogVideoView.this.hfx.setVisibility(8);
                    PushDialogVideoView.this.eOI.setVisibility(8);
                    PushDialogVideoView.this.cTt.ccM();
                    PushDialogVideoView.this.hfH.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.fZ().postDelayed(PushDialogVideoView.this.BJ, 20L);
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.BD = false;
                PushDialogVideoView.this.ivH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hfx.setVisibility(0);
                PushDialogVideoView.this.ivb.setVisibility(8);
                PushDialogVideoView.this.ivb.setProgress(PushDialogVideoView.this.ivb.getMax());
                if (PushDialogVideoView.this.dvG == null || PushDialogVideoView.this.dvG.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.ive.setVisibility(0);
                }
                y.ccR().remove(PushDialogVideoView.this.cln);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dvG.setRecoveryState(3);
                if (PushDialogVideoView.this.dvG != null && PushDialogVideoView.this.dvG.getDuration() <= 150000) {
                    PushDialogVideoView.this.cm(PushDialogVideoView.this.cln, PushDialogVideoView.this.cma);
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eOI.setVisibility(0);
                PushDialogVideoView.this.cTt.ccN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dvG.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.ivF = true;
                }
                PushDialogVideoView.this.ivH = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eOI.setVisibility(0);
                PushDialogVideoView.this.cTt.ccN();
            }
        };
        this.dcW = new g.InterfaceC0493g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0493g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ivB) {
                    e.fZ().postDelayed(PushDialogVideoView.this.ivN, 200L);
                }
            }
        };
        this.ivN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dvG == null || !PushDialogVideoView.this.ivB) {
                    e.fZ().postDelayed(PushDialogVideoView.this.BJ, 200L);
                    PushDialogVideoView.this.ivB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dvG.getCurrentPosition()) {
                    PushDialogVideoView.this.ivB = false;
                    e.fZ().postDelayed(PushDialogVideoView.this.BJ, 20L);
                } else {
                    e.fZ().postDelayed(PushDialogVideoView.this.ivN, 200L);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.BD = false;
                PushDialogVideoView.this.ivH = false;
                e.fZ().removeCallbacks(PushDialogVideoView.this.BJ);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgg);
            }
        };
        this.hgl = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dvG != null && PushDialogVideoView.this.dvG.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dvG.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dvG.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hih != null) {
                                PushDialogVideoView.this.hih.lD(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dhR - (duration % PushDialogVideoView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hih = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lD(int i) {
                int duration;
                if (PushDialogVideoView.this.dvG != null && (duration = PushDialogVideoView.this.dvG.getDuration()) > 0 && PushDialogVideoView.this.ivb != null) {
                    PushDialogVideoView.this.ivb.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ivP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbX() {
                PushDialogVideoView.this.cTt.startLoading();
                PushDialogVideoView.this.hfH.setVisibility(0);
                PushDialogVideoView.this.hfG.setVisibility(8);
                PushDialogVideoView.this.ive.setVisibility(8);
                PushDialogVideoView.this.eOI.setVisibility(8);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgg);
                e.fZ().postDelayed(PushDialogVideoView.this.hgg, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhR = 50;
        this.mSkinType = 3;
        this.BD = false;
        this.mStartPosition = 0;
        this.ivA = true;
        this.ivB = false;
        this.ivC = false;
        this.currentState = -1;
        this.idF = false;
        this.dcT = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dqC = gVar;
                PushDialogVideoView.this.cTt.ccL();
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bab();
            }
        };
        this.BJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dvG.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.BD = true;
                    PushDialogVideoView.this.hfx.setVisibility(8);
                    PushDialogVideoView.this.eOI.setVisibility(8);
                    PushDialogVideoView.this.cTt.ccM();
                    PushDialogVideoView.this.hfH.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.fZ().postDelayed(PushDialogVideoView.this.BJ, 20L);
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.BD = false;
                PushDialogVideoView.this.ivH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hfx.setVisibility(0);
                PushDialogVideoView.this.ivb.setVisibility(8);
                PushDialogVideoView.this.ivb.setProgress(PushDialogVideoView.this.ivb.getMax());
                if (PushDialogVideoView.this.dvG == null || PushDialogVideoView.this.dvG.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.ive.setVisibility(0);
                }
                y.ccR().remove(PushDialogVideoView.this.cln);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dvG.setRecoveryState(3);
                if (PushDialogVideoView.this.dvG != null && PushDialogVideoView.this.dvG.getDuration() <= 150000) {
                    PushDialogVideoView.this.cm(PushDialogVideoView.this.cln, PushDialogVideoView.this.cma);
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eOI.setVisibility(0);
                PushDialogVideoView.this.cTt.ccN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dvG.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.ivF = true;
                }
                PushDialogVideoView.this.ivH = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eOI.setVisibility(0);
                PushDialogVideoView.this.cTt.ccN();
            }
        };
        this.dcW = new g.InterfaceC0493g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0493g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ivB) {
                    e.fZ().postDelayed(PushDialogVideoView.this.ivN, 200L);
                }
            }
        };
        this.ivN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dvG == null || !PushDialogVideoView.this.ivB) {
                    e.fZ().postDelayed(PushDialogVideoView.this.BJ, 200L);
                    PushDialogVideoView.this.ivB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dvG.getCurrentPosition()) {
                    PushDialogVideoView.this.ivB = false;
                    e.fZ().postDelayed(PushDialogVideoView.this.BJ, 20L);
                } else {
                    e.fZ().postDelayed(PushDialogVideoView.this.ivN, 200L);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.BD = false;
                PushDialogVideoView.this.ivH = false;
                e.fZ().removeCallbacks(PushDialogVideoView.this.BJ);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgg);
            }
        };
        this.hgl = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dvG != null && PushDialogVideoView.this.dvG.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dvG.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dvG.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hih != null) {
                                PushDialogVideoView.this.hih.lD(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dhR - (duration % PushDialogVideoView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hih = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lD(int i) {
                int duration;
                if (PushDialogVideoView.this.dvG != null && (duration = PushDialogVideoView.this.dvG.getDuration()) > 0 && PushDialogVideoView.this.ivb != null) {
                    PushDialogVideoView.this.ivb.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ivP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbX() {
                PushDialogVideoView.this.cTt.startLoading();
                PushDialogVideoView.this.hfH.setVisibility(0);
                PushDialogVideoView.this.hfG.setVisibility(8);
                PushDialogVideoView.this.ive.setVisibility(8);
                PushDialogVideoView.this.eOI.setVisibility(8);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgg);
                e.fZ().postDelayed(PushDialogVideoView.this.hgg, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhR = 50;
        this.mSkinType = 3;
        this.BD = false;
        this.mStartPosition = 0;
        this.ivA = true;
        this.ivB = false;
        this.ivC = false;
        this.currentState = -1;
        this.idF = false;
        this.dcT = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dqC = gVar;
                PushDialogVideoView.this.cTt.ccL();
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bab();
            }
        };
        this.BJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dvG.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.BD = true;
                    PushDialogVideoView.this.hfx.setVisibility(8);
                    PushDialogVideoView.this.eOI.setVisibility(8);
                    PushDialogVideoView.this.cTt.ccM();
                    PushDialogVideoView.this.hfH.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.fZ().postDelayed(PushDialogVideoView.this.BJ, 20L);
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.BD = false;
                PushDialogVideoView.this.ivH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hfx.setVisibility(0);
                PushDialogVideoView.this.ivb.setVisibility(8);
                PushDialogVideoView.this.ivb.setProgress(PushDialogVideoView.this.ivb.getMax());
                if (PushDialogVideoView.this.dvG == null || PushDialogVideoView.this.dvG.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.ive.setVisibility(0);
                }
                y.ccR().remove(PushDialogVideoView.this.cln);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dvG.setRecoveryState(3);
                if (PushDialogVideoView.this.dvG != null && PushDialogVideoView.this.dvG.getDuration() <= 150000) {
                    PushDialogVideoView.this.cm(PushDialogVideoView.this.cln, PushDialogVideoView.this.cma);
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eOI.setVisibility(0);
                PushDialogVideoView.this.cTt.ccN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dvG.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.ivF = true;
                }
                PushDialogVideoView.this.ivH = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eOI.setVisibility(0);
                PushDialogVideoView.this.cTt.ccN();
            }
        };
        this.dcW = new g.InterfaceC0493g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0493g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ivB) {
                    e.fZ().postDelayed(PushDialogVideoView.this.ivN, 200L);
                }
            }
        };
        this.ivN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dvG == null || !PushDialogVideoView.this.ivB) {
                    e.fZ().postDelayed(PushDialogVideoView.this.BJ, 200L);
                    PushDialogVideoView.this.ivB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dvG.getCurrentPosition()) {
                    PushDialogVideoView.this.ivB = false;
                    e.fZ().postDelayed(PushDialogVideoView.this.BJ, 20L);
                } else {
                    e.fZ().postDelayed(PushDialogVideoView.this.ivN, 200L);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.BD = false;
                PushDialogVideoView.this.ivH = false;
                e.fZ().removeCallbacks(PushDialogVideoView.this.BJ);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgg);
            }
        };
        this.hgl = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dvG != null && PushDialogVideoView.this.dvG.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dvG.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dvG.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hih != null) {
                                PushDialogVideoView.this.hih.lD(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dhR - (duration % PushDialogVideoView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hih = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lD(int i2) {
                int duration;
                if (PushDialogVideoView.this.dvG != null && (duration = PushDialogVideoView.this.dvG.getDuration()) > 0 && PushDialogVideoView.this.ivb != null) {
                    PushDialogVideoView.this.ivb.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.ivP = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbX() {
                PushDialogVideoView.this.cTt.startLoading();
                PushDialogVideoView.this.hfH.setVisibility(0);
                PushDialogVideoView.this.hfG.setVisibility(8);
                PushDialogVideoView.this.ive.setVisibility(8);
                PushDialogVideoView.this.eOI.setVisibility(8);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgg);
                e.fZ().postDelayed(PushDialogVideoView.this.hgg, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dvG = (QuickVideoView) findViewById(R.id.videoView);
        this.cTt = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cTt.setLoadingAnimationListener(this.eMc);
        this.ivb = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.ivb.setMax(this.mWidth);
        this.ivb.setProgress(0);
        this.hfx = findViewById(R.id.black_mask);
        this.eOI = findViewById(R.id.layout_error);
        this.hfG = (ImageView) findViewById(R.id.img_play);
        this.ive = (TextView) findViewById(R.id.txt_replay);
        this.ewn = (TextView) findViewById(R.id.push_dialog_video_time);
        this.hfH = (TbImageView) findViewById(R.id.video_thumbnail);
        this.idQ = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.hfH.setDefaultErrorResource(0);
        this.hfH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hgc = new CallStateReceiver();
        this.hgc.register(context);
        this.eOI.setOnClickListener(this);
        this.ive.setOnClickListener(this);
        this.idQ.setOnPlayClickListener(this);
        this.idQ.setFreeClickListener(this);
        setOnClickListener(this);
        this.dvG.setOnPreparedListener(this.dcT);
        this.dvG.setOnCompletionListener(this.dcS);
        this.dvG.setOnErrorListener(this.hgf);
        this.dvG.setOnSeekCompleteListener(this.dcW);
        this.dvG.setOnSurfaceDestroyedListener(this.cTC);
        this.dvG.setOnRecoveryCallback(this.ivP);
        onChangeSkinType();
    }

    public void onPause() {
        if (kx()) {
            this.idF = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.idF = false;
        } else {
            this.idF = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.idF) {
            bIK();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hgl);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.iDk = fVar;
        this.ewn.setText(aq.stringForVideoTime(this.iDk.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.cln = str;
        this.cma = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dvG.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.dvG != null && this.dqC != null) {
            if (this.ivH) {
                this.dvG.start();
                this.ivH = false;
            }
            e.fZ().removeCallbacks(this.BJ);
            e.fZ().postDelayed(this.BJ, 20L);
            e.fZ().removeCallbacks(this.hgg);
            if (this.dvG.cco()) {
                this.currentState = 1;
                this.dvG.setRecoveryState(1);
            }
            if (this.dqC != null) {
                this.mStartPosition = y.ccR().BS(this.cln);
                if (this.mStartPosition != 0) {
                    if (this.dvG != null) {
                        this.dvG.xG(this.mStartPosition);
                    } else {
                        this.dqC.seekTo(this.mStartPosition);
                    }
                    if (!this.ivG) {
                        showProgress();
                        e.fZ().removeCallbacks(this.BJ);
                    }
                    this.ivB = true;
                }
            }
        }
    }

    public void bXU() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dvG.isPlaying()) {
            pausePlay();
        } else if (this.BD) {
            bIK();
        } else {
            cbL();
        }
    }

    public void setPauseState() {
        this.cTt.ccN();
        this.hfG.setVisibility(0);
        this.ive.setVisibility(8);
        this.currentState = 2;
        this.dvG.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.ivC) {
            dF(str, str2);
        } else {
            cm(str, str2);
        }
        if (aVar != null) {
            aVar.pP(z);
        }
    }

    public void cm(String str, String str2) {
        cbM();
        this.ivH = true;
        this.currentState = 0;
        this.dvG.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dvG.setVideoPath(str, str2);
        this.cTt.startLoading();
        this.hfH.setVisibility(0);
        this.hfG.setVisibility(8);
        this.ive.setVisibility(8);
        this.eOI.setVisibility(8);
        e.fZ().removeCallbacks(this.hgg);
        e.fZ().postDelayed(this.hgg, 60000L);
    }

    public void dF(String str, String str2) {
        cbM();
        this.ivH = true;
        this.currentState = 0;
        this.dvG.setRecoveryState(0);
        this.cTt.startLoading();
        this.hfH.setVisibility(0);
        this.hfG.setVisibility(8);
        this.ive.setVisibility(8);
        this.eOI.setVisibility(8);
        e.fZ().removeCallbacks(this.hgg);
        e.fZ().postDelayed(this.hgg, 60000L);
    }

    public void bIK() {
        this.currentState = 1;
        this.dvG.setRecoveryState(1);
        this.dvG.start();
        this.hfH.setVisibility(8);
        this.hfx.setVisibility(8);
        this.cTt.ccN();
        showProgress();
        this.hfG.setVisibility(8);
        this.ive.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.ivF && !StringUtils.isNull(this.cln) && !StringUtils.isNull(this.cma)) {
            this.ivF = false;
            this.ivG = true;
            cm(this.cln, this.cma);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dvG != null) {
            this.dvG.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dvG.isPlaying() && this.ivA) {
            cbK();
        }
        this.dvG.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dvG.isPlaying() && this.ivA) {
            cbK();
        }
        this.currentState = 5;
        this.dvG.setRecoveryState(5);
        e.fZ().removeCallbacks(this.BJ);
        e.fZ().removeCallbacks(this.hgg);
        this.dvG.stopPlayback();
        this.BD = false;
        this.ivH = false;
        this.mStartPosition = 0;
        bvK();
    }

    public void cbK() {
        y.ccR().bd(this.cln, this.dvG.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(boolean z) {
        this.hfx.setVisibility(0);
        this.hfG.setVisibility(0);
        this.ive.setVisibility(8);
        this.cTt.ccN();
        this.ivb.setVisibility(8);
        this.eOI.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.hfH.setVisibility(z ? 0 : 8);
    }

    public void bvK() {
        pK(true);
    }

    public boolean kx() {
        if (this.dvG == null) {
            return false;
        }
        return this.dvG.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dvG == null) {
            return 0;
        }
        return this.dvG.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dvG != null) {
            this.ivb.setVisibility(0);
            this.dhR = ((this.dvG.getDuration() / 200) / 50) * 50;
            if (this.dhR < 50) {
                this.dhR = 50;
            } else if (this.dhR > 500) {
                this.dhR = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dhR - (this.dvG.getCurrentPosition() % this.dhR));
        }
    }

    private void cbL() {
        a(this.cln, this.cma, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cbM();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.ivC = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.idZ && !com.baidu.tieba.video.g.csB().csC()) {
            this.idQ.setVisibility(0);
            this.idQ.setData(this.iDk.getDuration(), this.iDk.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cbM() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.csB().ef(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.hfH.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eOI) {
            cbL();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").O("obj_locate", 2).bS("tid", this.cma));
            bXU();
        } else if (view == this.ive) {
            cm(this.cln, this.cma);
        } else if (view == this.idQ.getTvPlay()) {
            this.idZ = true;
            this.idQ.setVisibility(8);
            cm(this.cln, this.cma);
        } else if (view == this.idQ.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.fZ().removeCallbacks(this.BJ);
        e.fZ().removeCallbacks(this.hgg);
        e.fZ().removeCallbacks(this.ivN);
        this.mHandler.removeMessages(1);
        this.hgc.unregister(getContext());
    }
}
