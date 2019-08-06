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
    private boolean SK;
    private Runnable SS;
    private String bWU;
    private String bWh;
    private x cJU;
    private QuickVideoView.b cKd;
    private g.InterfaceC0393g cTA;
    private g.a cTw;
    private g.f cTx;
    private int cXE;
    private int currentState;
    private g dgn;
    private QuickVideoView dnB;
    private VideoLoadingProgressView.a eCD;
    private View eFk;
    private TextView eiR;
    private CallStateReceiver hgU;
    private g.b hgX;
    private Runnable hgY;
    private View hgp;
    private ImageView hgy;
    private TbImageView hgz;
    private CustomMessageListener hhd;
    private VideoControllerView.b hiZ;
    private f iDn;
    private boolean idN;
    private PbVideoWifiTipLayout idY;
    private boolean ieh;
    private boolean ivO;
    private boolean ivP;
    private boolean ivQ;
    private boolean ivT;
    private boolean ivU;
    private boolean ivV;
    private ProgressBar ivp;
    private TextView ivs;
    private Runnable iwb;
    private QuickVideoView.a iwd;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void qe(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.cXE = 50;
        this.mSkinType = 3;
        this.SK = false;
        this.mStartPosition = 0;
        this.ivO = true;
        this.ivP = false;
        this.ivQ = false;
        this.currentState = -1;
        this.idN = false;
        this.cTx = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dgn = gVar;
                PushDialogVideoView.this.cJU.ceY();
            }
        };
        this.eCD = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aZw();
            }
        };
        this.SS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnB.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SK = true;
                    PushDialogVideoView.this.hgp.setVisibility(8);
                    PushDialogVideoView.this.eFk.setVisibility(8);
                    PushDialogVideoView.this.cJU.ceZ();
                    PushDialogVideoView.this.hgz.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.ivV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hgp.setVisibility(0);
                PushDialogVideoView.this.ivp.setVisibility(8);
                PushDialogVideoView.this.ivp.setProgress(PushDialogVideoView.this.ivp.getMax());
                if (PushDialogVideoView.this.dnB == null || PushDialogVideoView.this.dnB.getDuration() > 150000) {
                    PushDialogVideoView.this.pZ(false);
                } else {
                    PushDialogVideoView.this.ivs.setVisibility(0);
                }
                y.cfe().remove(PushDialogVideoView.this.bWh);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dnB.setRecoveryState(3);
                if (PushDialogVideoView.this.dnB != null && PushDialogVideoView.this.dnB.getDuration() <= 150000) {
                    PushDialogVideoView.this.cs(PushDialogVideoView.this.bWh, PushDialogVideoView.this.bWU);
                }
            }
        };
        this.hgX = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eFk.setVisibility(0);
                PushDialogVideoView.this.cJU.cfa();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dnB.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.ivT = true;
                }
                PushDialogVideoView.this.ivV = false;
                return true;
            }
        };
        this.hgY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eFk.setVisibility(0);
                PushDialogVideoView.this.cJU.cfa();
            }
        };
        this.cTA = new g.InterfaceC0393g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ivP) {
                    e.iK().postDelayed(PushDialogVideoView.this.iwb, 200L);
                }
            }
        };
        this.iwb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnB == null || !PushDialogVideoView.this.ivP) {
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 200L);
                    PushDialogVideoView.this.ivP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dnB.getCurrentPosition()) {
                    PushDialogVideoView.this.ivP = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iwb, 200L);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.ivV = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SS);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgY);
            }
        };
        this.hhd = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dnB != null && PushDialogVideoView.this.dnB.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dnB.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dnB.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hiZ != null) {
                                PushDialogVideoView.this.hiZ.mv(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cXE - (duration % PushDialogVideoView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiZ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mv(int i) {
                int duration;
                if (PushDialogVideoView.this.dnB != null && (duration = PushDialogVideoView.this.dnB.getDuration()) > 0 && PushDialogVideoView.this.ivp != null) {
                    PushDialogVideoView.this.ivp.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iwd = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cei() {
                PushDialogVideoView.this.cJU.startLoading();
                PushDialogVideoView.this.hgz.setVisibility(0);
                PushDialogVideoView.this.hgy.setVisibility(8);
                PushDialogVideoView.this.ivs.setVisibility(8);
                PushDialogVideoView.this.eFk.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgY);
                e.iK().postDelayed(PushDialogVideoView.this.hgY, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXE = 50;
        this.mSkinType = 3;
        this.SK = false;
        this.mStartPosition = 0;
        this.ivO = true;
        this.ivP = false;
        this.ivQ = false;
        this.currentState = -1;
        this.idN = false;
        this.cTx = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dgn = gVar;
                PushDialogVideoView.this.cJU.ceY();
            }
        };
        this.eCD = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aZw();
            }
        };
        this.SS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnB.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SK = true;
                    PushDialogVideoView.this.hgp.setVisibility(8);
                    PushDialogVideoView.this.eFk.setVisibility(8);
                    PushDialogVideoView.this.cJU.ceZ();
                    PushDialogVideoView.this.hgz.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.ivV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hgp.setVisibility(0);
                PushDialogVideoView.this.ivp.setVisibility(8);
                PushDialogVideoView.this.ivp.setProgress(PushDialogVideoView.this.ivp.getMax());
                if (PushDialogVideoView.this.dnB == null || PushDialogVideoView.this.dnB.getDuration() > 150000) {
                    PushDialogVideoView.this.pZ(false);
                } else {
                    PushDialogVideoView.this.ivs.setVisibility(0);
                }
                y.cfe().remove(PushDialogVideoView.this.bWh);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dnB.setRecoveryState(3);
                if (PushDialogVideoView.this.dnB != null && PushDialogVideoView.this.dnB.getDuration() <= 150000) {
                    PushDialogVideoView.this.cs(PushDialogVideoView.this.bWh, PushDialogVideoView.this.bWU);
                }
            }
        };
        this.hgX = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eFk.setVisibility(0);
                PushDialogVideoView.this.cJU.cfa();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dnB.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.ivT = true;
                }
                PushDialogVideoView.this.ivV = false;
                return true;
            }
        };
        this.hgY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eFk.setVisibility(0);
                PushDialogVideoView.this.cJU.cfa();
            }
        };
        this.cTA = new g.InterfaceC0393g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ivP) {
                    e.iK().postDelayed(PushDialogVideoView.this.iwb, 200L);
                }
            }
        };
        this.iwb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnB == null || !PushDialogVideoView.this.ivP) {
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 200L);
                    PushDialogVideoView.this.ivP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dnB.getCurrentPosition()) {
                    PushDialogVideoView.this.ivP = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iwb, 200L);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.ivV = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SS);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgY);
            }
        };
        this.hhd = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dnB != null && PushDialogVideoView.this.dnB.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dnB.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dnB.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hiZ != null) {
                                PushDialogVideoView.this.hiZ.mv(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cXE - (duration % PushDialogVideoView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiZ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mv(int i) {
                int duration;
                if (PushDialogVideoView.this.dnB != null && (duration = PushDialogVideoView.this.dnB.getDuration()) > 0 && PushDialogVideoView.this.ivp != null) {
                    PushDialogVideoView.this.ivp.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iwd = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cei() {
                PushDialogVideoView.this.cJU.startLoading();
                PushDialogVideoView.this.hgz.setVisibility(0);
                PushDialogVideoView.this.hgy.setVisibility(8);
                PushDialogVideoView.this.ivs.setVisibility(8);
                PushDialogVideoView.this.eFk.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgY);
                e.iK().postDelayed(PushDialogVideoView.this.hgY, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXE = 50;
        this.mSkinType = 3;
        this.SK = false;
        this.mStartPosition = 0;
        this.ivO = true;
        this.ivP = false;
        this.ivQ = false;
        this.currentState = -1;
        this.idN = false;
        this.cTx = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dgn = gVar;
                PushDialogVideoView.this.cJU.ceY();
            }
        };
        this.eCD = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aZw();
            }
        };
        this.SS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnB.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SK = true;
                    PushDialogVideoView.this.hgp.setVisibility(8);
                    PushDialogVideoView.this.eFk.setVisibility(8);
                    PushDialogVideoView.this.cJU.ceZ();
                    PushDialogVideoView.this.hgz.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.ivV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hgp.setVisibility(0);
                PushDialogVideoView.this.ivp.setVisibility(8);
                PushDialogVideoView.this.ivp.setProgress(PushDialogVideoView.this.ivp.getMax());
                if (PushDialogVideoView.this.dnB == null || PushDialogVideoView.this.dnB.getDuration() > 150000) {
                    PushDialogVideoView.this.pZ(false);
                } else {
                    PushDialogVideoView.this.ivs.setVisibility(0);
                }
                y.cfe().remove(PushDialogVideoView.this.bWh);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dnB.setRecoveryState(3);
                if (PushDialogVideoView.this.dnB != null && PushDialogVideoView.this.dnB.getDuration() <= 150000) {
                    PushDialogVideoView.this.cs(PushDialogVideoView.this.bWh, PushDialogVideoView.this.bWU);
                }
            }
        };
        this.hgX = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eFk.setVisibility(0);
                PushDialogVideoView.this.cJU.cfa();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dnB.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.ivT = true;
                }
                PushDialogVideoView.this.ivV = false;
                return true;
            }
        };
        this.hgY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eFk.setVisibility(0);
                PushDialogVideoView.this.cJU.cfa();
            }
        };
        this.cTA = new g.InterfaceC0393g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ivP) {
                    e.iK().postDelayed(PushDialogVideoView.this.iwb, 200L);
                }
            }
        };
        this.iwb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnB == null || !PushDialogVideoView.this.ivP) {
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 200L);
                    PushDialogVideoView.this.ivP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dnB.getCurrentPosition()) {
                    PushDialogVideoView.this.ivP = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iwb, 200L);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.ivV = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SS);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgY);
            }
        };
        this.hhd = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dnB != null && PushDialogVideoView.this.dnB.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dnB.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dnB.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hiZ != null) {
                                PushDialogVideoView.this.hiZ.mv(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cXE - (duration % PushDialogVideoView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiZ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mv(int i2) {
                int duration;
                if (PushDialogVideoView.this.dnB != null && (duration = PushDialogVideoView.this.dnB.getDuration()) > 0 && PushDialogVideoView.this.ivp != null) {
                    PushDialogVideoView.this.ivp.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iwd = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cei() {
                PushDialogVideoView.this.cJU.startLoading();
                PushDialogVideoView.this.hgz.setVisibility(0);
                PushDialogVideoView.this.hgy.setVisibility(8);
                PushDialogVideoView.this.ivs.setVisibility(8);
                PushDialogVideoView.this.eFk.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgY);
                e.iK().postDelayed(PushDialogVideoView.this.hgY, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.af(context) - l.g(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dnB = (QuickVideoView) findViewById(R.id.videoView);
        this.cJU = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cJU.setLoadingAnimationListener(this.eCD);
        this.ivp = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.ivp.setMax(this.mWidth);
        this.ivp.setProgress(0);
        this.hgp = findViewById(R.id.black_mask);
        this.eFk = findViewById(R.id.layout_error);
        this.hgy = (ImageView) findViewById(R.id.img_play);
        this.ivs = (TextView) findViewById(R.id.txt_replay);
        this.eiR = (TextView) findViewById(R.id.push_dialog_video_time);
        this.hgz = (TbImageView) findViewById(R.id.video_thumbnail);
        this.idY = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.hgz.setDefaultErrorResource(0);
        this.hgz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hgU = new CallStateReceiver();
        this.hgU.register(context);
        this.eFk.setOnClickListener(this);
        this.ivs.setOnClickListener(this);
        this.idY.setOnPlayClickListener(this);
        this.idY.setFreeClickListener(this);
        setOnClickListener(this);
        this.dnB.setOnPreparedListener(this.cTx);
        this.dnB.setOnCompletionListener(this.cTw);
        this.dnB.setOnErrorListener(this.hgX);
        this.dnB.setOnSeekCompleteListener(this.cTA);
        this.dnB.setOnSurfaceDestroyedListener(this.cKd);
        this.dnB.setOnRecoveryCallback(this.iwd);
        onChangeSkinType();
    }

    public void onPause() {
        if (pB()) {
            this.idN = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.idN = false;
        } else {
            this.idN = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.idN) {
            bLq();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hhd);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.iDn = fVar;
        this.eiR.setText(aq.is(this.iDn.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bWh = str;
        this.bWU = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dnB.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (this.dnB != null && this.dgn != null) {
            if (this.ivV) {
                this.dnB.start();
                this.ivV = false;
            }
            e.iK().removeCallbacks(this.SS);
            e.iK().postDelayed(this.SS, 20L);
            e.iK().removeCallbacks(this.hgY);
            if (this.dnB.ceA()) {
                this.currentState = 1;
                this.dnB.setRecoveryState(1);
            }
            if (this.dgn != null) {
                this.mStartPosition = y.cfe().Da(this.bWh);
                if (this.mStartPosition != 0) {
                    if (this.dnB != null) {
                        this.dnB.yZ(this.mStartPosition);
                    } else {
                        this.dgn.seekTo(this.mStartPosition);
                    }
                    if (!this.ivU) {
                        showProgress();
                        e.iK().removeCallbacks(this.SS);
                    }
                    this.ivP = true;
                }
            }
        }
    }

    public void cag() {
        if (!j.kc()) {
            l.E(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dnB.isPlaying()) {
            pausePlay();
        } else if (this.SK) {
            bLq();
        } else {
            cdV();
        }
    }

    public void setPauseState() {
        this.cJU.cfa();
        this.hgy.setVisibility(0);
        this.ivs.setVisibility(8);
        this.currentState = 2;
        this.dnB.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.ivQ) {
            dR(str, str2);
        } else {
            cs(str, str2);
        }
        if (aVar != null) {
            aVar.qe(z);
        }
    }

    public void cs(String str, String str2) {
        cdW();
        this.ivV = true;
        this.currentState = 0;
        this.dnB.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dnB.setVideoPath(str, str2);
        this.cJU.startLoading();
        this.hgz.setVisibility(0);
        this.hgy.setVisibility(8);
        this.ivs.setVisibility(8);
        this.eFk.setVisibility(8);
        e.iK().removeCallbacks(this.hgY);
        e.iK().postDelayed(this.hgY, 60000L);
    }

    public void dR(String str, String str2) {
        cdW();
        this.ivV = true;
        this.currentState = 0;
        this.dnB.setRecoveryState(0);
        this.cJU.startLoading();
        this.hgz.setVisibility(0);
        this.hgy.setVisibility(8);
        this.ivs.setVisibility(8);
        this.eFk.setVisibility(8);
        e.iK().removeCallbacks(this.hgY);
        e.iK().postDelayed(this.hgY, 60000L);
    }

    public void bLq() {
        this.currentState = 1;
        this.dnB.setRecoveryState(1);
        this.dnB.start();
        this.hgz.setVisibility(8);
        this.hgp.setVisibility(8);
        this.cJU.cfa();
        showProgress();
        this.hgy.setVisibility(8);
        this.ivs.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kc() && this.ivT && !StringUtils.isNull(this.bWh) && !StringUtils.isNull(this.bWU)) {
            this.ivT = false;
            this.ivU = true;
            cs(this.bWh, this.bWU);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dnB != null) {
            this.dnB.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dnB.isPlaying() && this.ivO) {
            cdU();
        }
        this.dnB.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dnB.isPlaying() && this.ivO) {
            cdU();
        }
        this.currentState = 5;
        this.dnB.setRecoveryState(5);
        e.iK().removeCallbacks(this.SS);
        e.iK().removeCallbacks(this.hgY);
        this.dnB.cey();
        this.SK = false;
        this.ivV = false;
        this.mStartPosition = 0;
        byn();
    }

    public void cdU() {
        y.cfe().bg(this.bWh, this.dnB.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        this.hgp.setVisibility(0);
        this.hgy.setVisibility(0);
        this.ivs.setVisibility(8);
        this.cJU.cfa();
        this.ivp.setVisibility(8);
        this.eFk.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.hgz.setVisibility(z ? 0 : 8);
    }

    public void byn() {
        pZ(true);
    }

    public boolean pB() {
        if (this.dnB == null) {
            return false;
        }
        return this.dnB.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dnB == null) {
            return 0;
        }
        return this.dnB.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dnB != null) {
            this.ivp.setVisibility(0);
            this.cXE = ((this.dnB.getDuration() / 200) / 50) * 50;
            if (this.cXE < 50) {
                this.cXE = 50;
            } else if (this.cXE > 500) {
                this.cXE = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXE - (this.dnB.getCurrentPosition() % this.cXE));
        }
    }

    private void cdV() {
        a(this.bWh, this.bWU, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cdW();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.ivQ = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.ke() && !this.ieh && !com.baidu.tieba.video.g.cua().cub()) {
            this.idY.setVisibility(0);
            this.idY.setData(this.iDn.getDuration(), this.iDn.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void cdW() {
        if (j.ke()) {
            com.baidu.tieba.video.g.cua().ep(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.hgz.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFk) {
            cdV();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 2).bT("tid", this.bWU));
            cag();
        } else if (view == this.ivs) {
            cs(this.bWh, this.bWU);
        } else if (view == this.idY.getTvPlay()) {
            this.ieh = true;
            this.idY.setVisibility(8);
            cs(this.bWh, this.bWU);
        } else if (view == this.idY.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.iK().removeCallbacks(this.SS);
        e.iK().removeCallbacks(this.hgY);
        e.iK().removeCallbacks(this.iwb);
        this.mHandler.removeMessages(1);
        this.hgU.unregister(getContext());
    }
}
