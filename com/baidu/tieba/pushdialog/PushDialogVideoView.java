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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.f;
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
/* loaded from: classes3.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private String aWq;
    private int avP;
    private w bcX;
    private String bdb;
    private QuickVideoView.b bdh;
    private g.a bjM;
    private g.f bjN;
    private g.InterfaceC0219g bjQ;
    private int bnO;
    private QuickVideoView bvr;
    private ImageView cBp;
    private View cBt;
    private TextView clG;
    private g cyB;
    private VideoLoadingProgressView.a cyM;
    private View eQV;
    private CallStateReceiver eRA;
    private Runnable eRD;
    private g.b eRE;
    private Runnable eRF;
    private CustomMessageListener eRK;
    private TbImageView eRe;
    private boolean eRj;
    private VideoControllerView.b eTE;
    private boolean fMZ;
    private PbVideoWifiTipLayout fNl;
    private boolean fNs;
    private boolean geN;
    private boolean geO;
    private boolean geP;
    private boolean geS;
    private boolean geT;
    private boolean geU;
    private Runnable geX;
    private QuickVideoView.a geZ;
    private ProgressBar get;
    private TextView gew;
    private f gkU;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void lu(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.bnO = 50;
        this.mSkinType = 3;
        this.eRj = false;
        this.mStartPosition = 0;
        this.geN = true;
        this.geO = false;
        this.geP = false;
        this.avP = -1;
        this.fMZ = false;
        this.bjN = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cyB = gVar;
                PushDialogVideoView.this.bcX.bkN();
            }
        };
        this.cyM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aiK();
            }
        };
        this.eRD = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvr.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eRj = true;
                    PushDialogVideoView.this.eQV.setVisibility(8);
                    PushDialogVideoView.this.cBt.setVisibility(8);
                    PushDialogVideoView.this.bcX.bkO();
                    PushDialogVideoView.this.eRe.setVisibility(8);
                    if (PushDialogVideoView.this.avP == 1 || PushDialogVideoView.this.avP == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.in().postDelayed(PushDialogVideoView.this.eRD, 20L);
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eRj = false;
                PushDialogVideoView.this.geU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eQV.setVisibility(0);
                PushDialogVideoView.this.get.setVisibility(8);
                PushDialogVideoView.this.get.setProgress(PushDialogVideoView.this.get.getMax());
                if (PushDialogVideoView.this.bvr == null || PushDialogVideoView.this.bvr.getDuration() > 150000) {
                    PushDialogVideoView.this.lr(false);
                } else {
                    PushDialogVideoView.this.gew.setVisibility(0);
                }
                x.bkT().remove(PushDialogVideoView.this.bdb);
                PushDialogVideoView.this.avP = 3;
                PushDialogVideoView.this.bvr.setRecoveryState(3);
                if (PushDialogVideoView.this.bvr != null && PushDialogVideoView.this.bvr.getDuration() <= 150000) {
                    PushDialogVideoView.this.bS(PushDialogVideoView.this.bdb, PushDialogVideoView.this.aWq);
                }
            }
        };
        this.eRE = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cBt.setVisibility(0);
                PushDialogVideoView.this.bcX.bkP();
                PushDialogVideoView.this.avP = 4;
                PushDialogVideoView.this.bvr.setRecoveryState(4);
                if (!j.jE()) {
                    PushDialogVideoView.this.geS = true;
                }
                PushDialogVideoView.this.geU = false;
                return true;
            }
        };
        this.eRF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cBt.setVisibility(0);
                PushDialogVideoView.this.bcX.bkP();
            }
        };
        this.bjQ = new g.InterfaceC0219g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (PushDialogVideoView.this.geO) {
                    e.in().postDelayed(PushDialogVideoView.this.geX, 200L);
                }
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvr == null || !PushDialogVideoView.this.geO) {
                    e.in().postDelayed(PushDialogVideoView.this.eRD, 200L);
                    PushDialogVideoView.this.geO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bvr.getCurrentPosition()) {
                    PushDialogVideoView.this.geO = false;
                    e.in().postDelayed(PushDialogVideoView.this.eRD, 20L);
                } else {
                    e.in().postDelayed(PushDialogVideoView.this.geX, 200L);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eRj = false;
                PushDialogVideoView.this.geU = false;
                e.in().removeCallbacks(PushDialogVideoView.this.eRD);
                e.in().removeCallbacks(PushDialogVideoView.this.eRF);
            }
        };
        this.eRK = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bvr != null && PushDialogVideoView.this.bvr.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bvr.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bvr.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.eTE != null) {
                                PushDialogVideoView.this.eTE.gz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bnO - (duration % PushDialogVideoView.this.bnO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eTE = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gz(int i) {
                int duration;
                if (PushDialogVideoView.this.bvr != null && (duration = PushDialogVideoView.this.bvr.getDuration()) > 0 && PushDialogVideoView.this.get != null) {
                    PushDialogVideoView.this.get.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.geZ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bka() {
                PushDialogVideoView.this.bcX.startLoading();
                PushDialogVideoView.this.eRe.setVisibility(0);
                PushDialogVideoView.this.cBp.setVisibility(8);
                PushDialogVideoView.this.gew.setVisibility(8);
                PushDialogVideoView.this.cBt.setVisibility(8);
                e.in().removeCallbacks(PushDialogVideoView.this.eRF);
                e.in().postDelayed(PushDialogVideoView.this.eRF, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnO = 50;
        this.mSkinType = 3;
        this.eRj = false;
        this.mStartPosition = 0;
        this.geN = true;
        this.geO = false;
        this.geP = false;
        this.avP = -1;
        this.fMZ = false;
        this.bjN = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cyB = gVar;
                PushDialogVideoView.this.bcX.bkN();
            }
        };
        this.cyM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aiK();
            }
        };
        this.eRD = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvr.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eRj = true;
                    PushDialogVideoView.this.eQV.setVisibility(8);
                    PushDialogVideoView.this.cBt.setVisibility(8);
                    PushDialogVideoView.this.bcX.bkO();
                    PushDialogVideoView.this.eRe.setVisibility(8);
                    if (PushDialogVideoView.this.avP == 1 || PushDialogVideoView.this.avP == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.in().postDelayed(PushDialogVideoView.this.eRD, 20L);
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eRj = false;
                PushDialogVideoView.this.geU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eQV.setVisibility(0);
                PushDialogVideoView.this.get.setVisibility(8);
                PushDialogVideoView.this.get.setProgress(PushDialogVideoView.this.get.getMax());
                if (PushDialogVideoView.this.bvr == null || PushDialogVideoView.this.bvr.getDuration() > 150000) {
                    PushDialogVideoView.this.lr(false);
                } else {
                    PushDialogVideoView.this.gew.setVisibility(0);
                }
                x.bkT().remove(PushDialogVideoView.this.bdb);
                PushDialogVideoView.this.avP = 3;
                PushDialogVideoView.this.bvr.setRecoveryState(3);
                if (PushDialogVideoView.this.bvr != null && PushDialogVideoView.this.bvr.getDuration() <= 150000) {
                    PushDialogVideoView.this.bS(PushDialogVideoView.this.bdb, PushDialogVideoView.this.aWq);
                }
            }
        };
        this.eRE = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cBt.setVisibility(0);
                PushDialogVideoView.this.bcX.bkP();
                PushDialogVideoView.this.avP = 4;
                PushDialogVideoView.this.bvr.setRecoveryState(4);
                if (!j.jE()) {
                    PushDialogVideoView.this.geS = true;
                }
                PushDialogVideoView.this.geU = false;
                return true;
            }
        };
        this.eRF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cBt.setVisibility(0);
                PushDialogVideoView.this.bcX.bkP();
            }
        };
        this.bjQ = new g.InterfaceC0219g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (PushDialogVideoView.this.geO) {
                    e.in().postDelayed(PushDialogVideoView.this.geX, 200L);
                }
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvr == null || !PushDialogVideoView.this.geO) {
                    e.in().postDelayed(PushDialogVideoView.this.eRD, 200L);
                    PushDialogVideoView.this.geO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bvr.getCurrentPosition()) {
                    PushDialogVideoView.this.geO = false;
                    e.in().postDelayed(PushDialogVideoView.this.eRD, 20L);
                } else {
                    e.in().postDelayed(PushDialogVideoView.this.geX, 200L);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eRj = false;
                PushDialogVideoView.this.geU = false;
                e.in().removeCallbacks(PushDialogVideoView.this.eRD);
                e.in().removeCallbacks(PushDialogVideoView.this.eRF);
            }
        };
        this.eRK = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bvr != null && PushDialogVideoView.this.bvr.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bvr.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bvr.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.eTE != null) {
                                PushDialogVideoView.this.eTE.gz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bnO - (duration % PushDialogVideoView.this.bnO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eTE = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gz(int i) {
                int duration;
                if (PushDialogVideoView.this.bvr != null && (duration = PushDialogVideoView.this.bvr.getDuration()) > 0 && PushDialogVideoView.this.get != null) {
                    PushDialogVideoView.this.get.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.geZ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bka() {
                PushDialogVideoView.this.bcX.startLoading();
                PushDialogVideoView.this.eRe.setVisibility(0);
                PushDialogVideoView.this.cBp.setVisibility(8);
                PushDialogVideoView.this.gew.setVisibility(8);
                PushDialogVideoView.this.cBt.setVisibility(8);
                e.in().removeCallbacks(PushDialogVideoView.this.eRF);
                e.in().postDelayed(PushDialogVideoView.this.eRF, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnO = 50;
        this.mSkinType = 3;
        this.eRj = false;
        this.mStartPosition = 0;
        this.geN = true;
        this.geO = false;
        this.geP = false;
        this.avP = -1;
        this.fMZ = false;
        this.bjN = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cyB = gVar;
                PushDialogVideoView.this.bcX.bkN();
            }
        };
        this.cyM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aiK();
            }
        };
        this.eRD = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvr.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eRj = true;
                    PushDialogVideoView.this.eQV.setVisibility(8);
                    PushDialogVideoView.this.cBt.setVisibility(8);
                    PushDialogVideoView.this.bcX.bkO();
                    PushDialogVideoView.this.eRe.setVisibility(8);
                    if (PushDialogVideoView.this.avP == 1 || PushDialogVideoView.this.avP == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.in().postDelayed(PushDialogVideoView.this.eRD, 20L);
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eRj = false;
                PushDialogVideoView.this.geU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eQV.setVisibility(0);
                PushDialogVideoView.this.get.setVisibility(8);
                PushDialogVideoView.this.get.setProgress(PushDialogVideoView.this.get.getMax());
                if (PushDialogVideoView.this.bvr == null || PushDialogVideoView.this.bvr.getDuration() > 150000) {
                    PushDialogVideoView.this.lr(false);
                } else {
                    PushDialogVideoView.this.gew.setVisibility(0);
                }
                x.bkT().remove(PushDialogVideoView.this.bdb);
                PushDialogVideoView.this.avP = 3;
                PushDialogVideoView.this.bvr.setRecoveryState(3);
                if (PushDialogVideoView.this.bvr != null && PushDialogVideoView.this.bvr.getDuration() <= 150000) {
                    PushDialogVideoView.this.bS(PushDialogVideoView.this.bdb, PushDialogVideoView.this.aWq);
                }
            }
        };
        this.eRE = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.cBt.setVisibility(0);
                PushDialogVideoView.this.bcX.bkP();
                PushDialogVideoView.this.avP = 4;
                PushDialogVideoView.this.bvr.setRecoveryState(4);
                if (!j.jE()) {
                    PushDialogVideoView.this.geS = true;
                }
                PushDialogVideoView.this.geU = false;
                return true;
            }
        };
        this.eRF = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cBt.setVisibility(0);
                PushDialogVideoView.this.bcX.bkP();
            }
        };
        this.bjQ = new g.InterfaceC0219g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (PushDialogVideoView.this.geO) {
                    e.in().postDelayed(PushDialogVideoView.this.geX, 200L);
                }
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvr == null || !PushDialogVideoView.this.geO) {
                    e.in().postDelayed(PushDialogVideoView.this.eRD, 200L);
                    PushDialogVideoView.this.geO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bvr.getCurrentPosition()) {
                    PushDialogVideoView.this.geO = false;
                    e.in().postDelayed(PushDialogVideoView.this.eRD, 20L);
                } else {
                    e.in().postDelayed(PushDialogVideoView.this.geX, 200L);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eRj = false;
                PushDialogVideoView.this.geU = false;
                e.in().removeCallbacks(PushDialogVideoView.this.eRD);
                e.in().removeCallbacks(PushDialogVideoView.this.eRF);
            }
        };
        this.eRK = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bvr != null && PushDialogVideoView.this.bvr.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bvr.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bvr.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.eTE != null) {
                                PushDialogVideoView.this.eTE.gz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bnO - (duration % PushDialogVideoView.this.bnO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eTE = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gz(int i2) {
                int duration;
                if (PushDialogVideoView.this.bvr != null && (duration = PushDialogVideoView.this.bvr.getDuration()) > 0 && PushDialogVideoView.this.get != null) {
                    PushDialogVideoView.this.get.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.geZ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bka() {
                PushDialogVideoView.this.bcX.startLoading();
                PushDialogVideoView.this.eRe.setVisibility(0);
                PushDialogVideoView.this.cBp.setVisibility(8);
                PushDialogVideoView.this.gew.setVisibility(8);
                PushDialogVideoView.this.cBt.setVisibility(8);
                e.in().removeCallbacks(PushDialogVideoView.this.eRF);
                e.in().postDelayed(PushDialogVideoView.this.eRF, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.ah(context) - l.f(context, f.e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bvr = (QuickVideoView) findViewById(f.g.videoView);
        this.bcX = new w((ViewGroup) findViewById(f.g.auto_video_loading_container));
        this.bcX.setLoadingAnimationListener(this.cyM);
        this.get = (ProgressBar) findViewById(f.g.pgrBottomProgress);
        this.get.setMax(this.mWidth);
        this.get.setProgress(0);
        this.eQV = findViewById(f.g.black_mask);
        this.cBt = findViewById(f.g.layout_error);
        this.cBp = (ImageView) findViewById(f.g.img_play);
        this.gew = (TextView) findViewById(f.g.txt_replay);
        this.clG = (TextView) findViewById(f.g.push_dialog_video_time);
        this.eRe = (TbImageView) findViewById(f.g.video_thumbnail);
        this.fNl = (PbVideoWifiTipLayout) findViewById(f.g.layout_wifi_tip);
        this.eRe.setDefaultErrorResource(0);
        this.eRe.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.eRA = new CallStateReceiver();
        this.eRA.register(context);
        this.cBt.setOnClickListener(this);
        this.gew.setOnClickListener(this);
        this.fNl.setOnPlayClickListener(this);
        this.fNl.setFreeClickListener(this);
        setOnClickListener(this);
        this.bvr.setOnPreparedListener(this.bjN);
        this.bvr.setOnCompletionListener(this.bjM);
        this.bvr.setOnErrorListener(this.eRE);
        this.bvr.setOnSeekCompleteListener(this.bjQ);
        this.bvr.setOnSurfaceDestroyedListener(this.bdh);
        this.bvr.setOnRecoveryCallback(this.geZ);
        onChangeSkinType();
    }

    public void onPause() {
        if (bjR()) {
            this.fMZ = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.fMZ = false;
        } else {
            this.fMZ = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.fMZ) {
            aSd();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.eRK);
    }

    public void setTbRichTextVideoInfo(com.baidu.tbadk.widget.richText.f fVar) {
        this.gkU = fVar;
        this.clG.setText(ap.da(this.gkU.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bdb = str;
        this.aWq = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bvr.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.avP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.bvr != null && this.cyB != null) {
            if (this.geU) {
                this.bvr.start();
                this.geU = false;
            }
            e.in().removeCallbacks(this.eRD);
            e.in().postDelayed(this.eRD, 20L);
            e.in().removeCallbacks(this.eRF);
            if (this.bvr.bkr()) {
                this.avP = 1;
                this.bvr.setRecoveryState(1);
            }
            if (this.cyB != null) {
                this.mStartPosition = x.bkT().sh(this.bdb);
                if (this.mStartPosition != 0) {
                    if (this.bvr != null) {
                        this.bvr.rH(this.mStartPosition);
                    } else {
                        this.cyB.seekTo(this.mStartPosition);
                    }
                    if (!this.geT) {
                        showProgress();
                        e.in().removeCallbacks(this.eRD);
                    }
                    this.geO = true;
                }
            }
        }
    }

    public void bgk() {
        if (!j.jE()) {
            l.F(getContext(), getContext().getString(f.j.neterror));
        } else if (this.bvr.isPlaying()) {
            pausePlay();
        } else if (this.eRj) {
            aSd();
        } else {
            bjS();
        }
    }

    public void setPauseState() {
        this.bcX.bkP();
        this.cBp.setVisibility(0);
        this.gew.setVisibility(8);
        this.avP = 2;
        this.bvr.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.geP) {
            bT(str, str2);
        } else {
            bS(str, str2);
        }
        if (aVar != null) {
            aVar.lu(z);
        }
    }

    public void bS(String str, String str2) {
        bjT();
        this.geU = true;
        this.avP = 0;
        this.bvr.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bvr.setVideoPath(str, str2);
        this.bcX.startLoading();
        this.eRe.setVisibility(0);
        this.cBp.setVisibility(8);
        this.gew.setVisibility(8);
        this.cBt.setVisibility(8);
        e.in().removeCallbacks(this.eRF);
        e.in().postDelayed(this.eRF, 60000L);
    }

    public void bT(String str, String str2) {
        bjT();
        this.geU = true;
        this.avP = 0;
        this.bvr.setRecoveryState(0);
        this.bcX.startLoading();
        this.eRe.setVisibility(0);
        this.cBp.setVisibility(8);
        this.gew.setVisibility(8);
        this.cBt.setVisibility(8);
        e.in().removeCallbacks(this.eRF);
        e.in().postDelayed(this.eRF, 60000L);
    }

    public void aSd() {
        this.avP = 1;
        this.bvr.setRecoveryState(1);
        this.bvr.start();
        this.eRe.setVisibility(8);
        this.eQV.setVisibility(8);
        this.bcX.bkP();
        showProgress();
        this.cBp.setVisibility(8);
        this.gew.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.jE() && this.geS && !StringUtils.isNull(this.bdb) && !StringUtils.isNull(this.aWq)) {
            this.geS = false;
            this.geT = true;
            bS(this.bdb, this.aWq);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bvr != null) {
            this.bvr.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bvr.isPlaying() && this.geN) {
            bjQ();
        }
        this.bvr.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bvr.isPlaying() && this.geN) {
            bjQ();
        }
        this.avP = 5;
        this.bvr.setRecoveryState(5);
        e.in().removeCallbacks(this.eRD);
        e.in().removeCallbacks(this.eRF);
        this.bvr.stopPlayback();
        this.eRj = false;
        this.geU = false;
        this.mStartPosition = 0;
        aFa();
    }

    public void bjQ() {
        x.bkT().aD(this.bdb, this.bvr.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        this.eQV.setVisibility(0);
        this.cBp.setVisibility(0);
        this.gew.setVisibility(8);
        this.bcX.bkP();
        this.get.setVisibility(8);
        this.cBt.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.eRe.setVisibility(z ? 0 : 8);
    }

    public void aFa() {
        lr(true);
    }

    public boolean bjR() {
        if (this.bvr == null) {
            return false;
        }
        return this.bvr.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bvr == null) {
            return 0;
        }
        return this.bvr.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bvr != null) {
            this.get.setVisibility(0);
            this.bnO = ((this.bvr.getDuration() / 200) / 50) * 50;
            if (this.bnO < 50) {
                this.bnO = 50;
            } else if (this.bnO > 500) {
                this.bnO = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnO - (this.bvr.getCurrentPosition() % this.bnO));
        }
    }

    private void bjS() {
        a(this.bdb, this.aWq, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bjT();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.geP = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.jG() && !this.fNs && !com.baidu.tieba.video.g.bAk().bAl()) {
            this.fNl.setVisibility(0);
            this.fNl.setData(this.gkU.getDuration(), this.gkU.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bjT() {
        if (j.jG()) {
            com.baidu.tieba.video.g.bAk().ck(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.eRe.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBt) {
            bjS();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").r("obj_locate", 2).ae("tid", this.aWq));
            bgk();
        } else if (view == this.gew) {
            bS(this.bdb, this.aWq);
        } else if (view == this.fNl.getTvPlay()) {
            this.fNs = true;
            this.fNl.setVisibility(8);
            bS(this.bdb, this.aWq);
        } else if (view == this.fNl.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.in().removeCallbacks(this.eRD);
        e.in().removeCallbacks(this.eRF);
        e.in().removeCallbacks(this.geX);
        this.mHandler.removeMessages(1);
        this.eRA.unregister(getContext());
    }
}
