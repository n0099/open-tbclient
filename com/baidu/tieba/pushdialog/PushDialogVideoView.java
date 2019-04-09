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
    private boolean UH;
    private Runnable UN;
    private String bNo;
    private x cAk;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.InterfaceC0369g cJM;
    private int cNO;
    private String ctx;
    private int currentState;
    private TextView dTG;
    private QuickVideoView dbg;
    private VideoLoadingProgressView.a ehK;
    private g ehy;
    private View eks;
    private View gHN;
    private ImageView gHW;
    private TbImageView gHX;
    private CustomMessageListener gIB;
    private CallStateReceiver gIs;
    private g.b gIv;
    private Runnable gIw;
    private VideoControllerView.b gKw;
    private PbVideoWifiTipLayout hEH;
    private boolean hEQ;
    private boolean hEw;
    private boolean hVF;
    private boolean hVG;
    private boolean hVH;
    private boolean hVK;
    private boolean hVL;
    private boolean hVM;
    private Runnable hVS;
    private QuickVideoView.a hVU;
    private ProgressBar hVg;
    private TextView hVj;
    private f idj;
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
        this.UH = false;
        this.mStartPosition = 0;
        this.hVF = true;
        this.hVG = false;
        this.hVH = false;
        this.currentState = -1;
        this.hEw = false;
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehy = gVar;
                PushDialogVideoView.this.cAk.bTL();
            }
        };
        this.ehK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQl();
            }
        };
        this.UN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UH = true;
                    PushDialogVideoView.this.gHN.setVisibility(8);
                    PushDialogVideoView.this.eks.setVisibility(8);
                    PushDialogVideoView.this.cAk.bTM();
                    PushDialogVideoView.this.gHX.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UN, 20L);
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UH = false;
                PushDialogVideoView.this.hVM = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHN.setVisibility(0);
                PushDialogVideoView.this.hVg.setVisibility(8);
                PushDialogVideoView.this.hVg.setProgress(PushDialogVideoView.this.hVg.getMax());
                if (PushDialogVideoView.this.dbg == null || PushDialogVideoView.this.dbg.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVj.setVisibility(0);
                }
                y.bTR().remove(PushDialogVideoView.this.bNo);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbg.setRecoveryState(3);
                if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNo, PushDialogVideoView.this.ctx);
                }
            }
        };
        this.gIv = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eks.setVisibility(0);
                PushDialogVideoView.this.cAk.bTN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbg.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVK = true;
                }
                PushDialogVideoView.this.hVM = false;
                return true;
            }
        };
        this.gIw = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eks.setVisibility(0);
                PushDialogVideoView.this.cAk.bTN();
            }
        };
        this.cJM = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVG) {
                    e.jH().postDelayed(PushDialogVideoView.this.hVS, 200L);
                }
            }
        };
        this.hVS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg == null || !PushDialogVideoView.this.hVG) {
                    e.jH().postDelayed(PushDialogVideoView.this.UN, 200L);
                    PushDialogVideoView.this.hVG = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbg.getCurrentPosition()) {
                    PushDialogVideoView.this.hVG = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UN, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hVS, 200L);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UH = false;
                PushDialogVideoView.this.hVM = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UN);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIw);
            }
        };
        this.gIB = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                            if (PushDialogVideoView.this.gKw != null) {
                                PushDialogVideoView.this.gKw.ly(duration);
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
        this.gKw = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ly(int i) {
                int duration;
                if (PushDialogVideoView.this.dbg != null && (duration = PushDialogVideoView.this.dbg.getDuration()) > 0 && PushDialogVideoView.this.hVg != null) {
                    PushDialogVideoView.this.hVg.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hVU = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSW() {
                PushDialogVideoView.this.cAk.startLoading();
                PushDialogVideoView.this.gHX.setVisibility(0);
                PushDialogVideoView.this.gHW.setVisibility(8);
                PushDialogVideoView.this.hVj.setVisibility(8);
                PushDialogVideoView.this.eks.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIw);
                e.jH().postDelayed(PushDialogVideoView.this.gIw, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNO = 50;
        this.mSkinType = 3;
        this.UH = false;
        this.mStartPosition = 0;
        this.hVF = true;
        this.hVG = false;
        this.hVH = false;
        this.currentState = -1;
        this.hEw = false;
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehy = gVar;
                PushDialogVideoView.this.cAk.bTL();
            }
        };
        this.ehK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQl();
            }
        };
        this.UN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UH = true;
                    PushDialogVideoView.this.gHN.setVisibility(8);
                    PushDialogVideoView.this.eks.setVisibility(8);
                    PushDialogVideoView.this.cAk.bTM();
                    PushDialogVideoView.this.gHX.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UN, 20L);
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UH = false;
                PushDialogVideoView.this.hVM = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHN.setVisibility(0);
                PushDialogVideoView.this.hVg.setVisibility(8);
                PushDialogVideoView.this.hVg.setProgress(PushDialogVideoView.this.hVg.getMax());
                if (PushDialogVideoView.this.dbg == null || PushDialogVideoView.this.dbg.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVj.setVisibility(0);
                }
                y.bTR().remove(PushDialogVideoView.this.bNo);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbg.setRecoveryState(3);
                if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNo, PushDialogVideoView.this.ctx);
                }
            }
        };
        this.gIv = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eks.setVisibility(0);
                PushDialogVideoView.this.cAk.bTN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbg.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVK = true;
                }
                PushDialogVideoView.this.hVM = false;
                return true;
            }
        };
        this.gIw = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eks.setVisibility(0);
                PushDialogVideoView.this.cAk.bTN();
            }
        };
        this.cJM = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVG) {
                    e.jH().postDelayed(PushDialogVideoView.this.hVS, 200L);
                }
            }
        };
        this.hVS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg == null || !PushDialogVideoView.this.hVG) {
                    e.jH().postDelayed(PushDialogVideoView.this.UN, 200L);
                    PushDialogVideoView.this.hVG = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbg.getCurrentPosition()) {
                    PushDialogVideoView.this.hVG = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UN, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hVS, 200L);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UH = false;
                PushDialogVideoView.this.hVM = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UN);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIw);
            }
        };
        this.gIB = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                            if (PushDialogVideoView.this.gKw != null) {
                                PushDialogVideoView.this.gKw.ly(duration);
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
        this.gKw = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ly(int i) {
                int duration;
                if (PushDialogVideoView.this.dbg != null && (duration = PushDialogVideoView.this.dbg.getDuration()) > 0 && PushDialogVideoView.this.hVg != null) {
                    PushDialogVideoView.this.hVg.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hVU = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSW() {
                PushDialogVideoView.this.cAk.startLoading();
                PushDialogVideoView.this.gHX.setVisibility(0);
                PushDialogVideoView.this.gHW.setVisibility(8);
                PushDialogVideoView.this.hVj.setVisibility(8);
                PushDialogVideoView.this.eks.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIw);
                e.jH().postDelayed(PushDialogVideoView.this.gIw, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNO = 50;
        this.mSkinType = 3;
        this.UH = false;
        this.mStartPosition = 0;
        this.hVF = true;
        this.hVG = false;
        this.hVH = false;
        this.currentState = -1;
        this.hEw = false;
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.ehy = gVar;
                PushDialogVideoView.this.cAk.bTL();
            }
        };
        this.ehK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aQl();
            }
        };
        this.UN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.UH = true;
                    PushDialogVideoView.this.gHN.setVisibility(8);
                    PushDialogVideoView.this.eks.setVisibility(8);
                    PushDialogVideoView.this.cAk.bTM();
                    PushDialogVideoView.this.gHX.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jH().postDelayed(PushDialogVideoView.this.UN, 20L);
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.UH = false;
                PushDialogVideoView.this.hVM = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.gHN.setVisibility(0);
                PushDialogVideoView.this.hVg.setVisibility(8);
                PushDialogVideoView.this.hVg.setProgress(PushDialogVideoView.this.hVg.getMax());
                if (PushDialogVideoView.this.dbg == null || PushDialogVideoView.this.dbg.getDuration() > 150000) {
                    PushDialogVideoView.this.oU(false);
                } else {
                    PushDialogVideoView.this.hVj.setVisibility(0);
                }
                y.bTR().remove(PushDialogVideoView.this.bNo);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dbg.setRecoveryState(3);
                if (PushDialogVideoView.this.dbg != null && PushDialogVideoView.this.dbg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cf(PushDialogVideoView.this.bNo, PushDialogVideoView.this.ctx);
                }
            }
        };
        this.gIv = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eks.setVisibility(0);
                PushDialogVideoView.this.cAk.bTN();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dbg.setRecoveryState(4);
                if (!j.kY()) {
                    PushDialogVideoView.this.hVK = true;
                }
                PushDialogVideoView.this.hVM = false;
                return true;
            }
        };
        this.gIw = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eks.setVisibility(0);
                PushDialogVideoView.this.cAk.bTN();
            }
        };
        this.cJM = new g.InterfaceC0369g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (PushDialogVideoView.this.hVG) {
                    e.jH().postDelayed(PushDialogVideoView.this.hVS, 200L);
                }
            }
        };
        this.hVS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dbg == null || !PushDialogVideoView.this.hVG) {
                    e.jH().postDelayed(PushDialogVideoView.this.UN, 200L);
                    PushDialogVideoView.this.hVG = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dbg.getCurrentPosition()) {
                    PushDialogVideoView.this.hVG = false;
                    e.jH().postDelayed(PushDialogVideoView.this.UN, 20L);
                } else {
                    e.jH().postDelayed(PushDialogVideoView.this.hVS, 200L);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.UH = false;
                PushDialogVideoView.this.hVM = false;
                e.jH().removeCallbacks(PushDialogVideoView.this.UN);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIw);
            }
        };
        this.gIB = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                            if (PushDialogVideoView.this.gKw != null) {
                                PushDialogVideoView.this.gKw.ly(duration);
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
        this.gKw = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ly(int i2) {
                int duration;
                if (PushDialogVideoView.this.dbg != null && (duration = PushDialogVideoView.this.dbg.getDuration()) > 0 && PushDialogVideoView.this.hVg != null) {
                    PushDialogVideoView.this.hVg.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.hVU = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bSW() {
                PushDialogVideoView.this.cAk.startLoading();
                PushDialogVideoView.this.gHX.setVisibility(0);
                PushDialogVideoView.this.gHW.setVisibility(8);
                PushDialogVideoView.this.hVj.setVisibility(8);
                PushDialogVideoView.this.eks.setVisibility(8);
                e.jH().removeCallbacks(PushDialogVideoView.this.gIw);
                e.jH().postDelayed(PushDialogVideoView.this.gIw, 60000L);
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
        this.cAk.setLoadingAnimationListener(this.ehK);
        this.hVg = (ProgressBar) findViewById(d.g.pgrBottomProgress);
        this.hVg.setMax(this.mWidth);
        this.hVg.setProgress(0);
        this.gHN = findViewById(d.g.black_mask);
        this.eks = findViewById(d.g.layout_error);
        this.gHW = (ImageView) findViewById(d.g.img_play);
        this.hVj = (TextView) findViewById(d.g.txt_replay);
        this.dTG = (TextView) findViewById(d.g.push_dialog_video_time);
        this.gHX = (TbImageView) findViewById(d.g.video_thumbnail);
        this.hEH = (PbVideoWifiTipLayout) findViewById(d.g.layout_wifi_tip);
        this.gHX.setDefaultErrorResource(0);
        this.gHX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.gIs = new CallStateReceiver();
        this.gIs.register(context);
        this.eks.setOnClickListener(this);
        this.hVj.setOnClickListener(this);
        this.hEH.setOnPlayClickListener(this);
        this.hEH.setFreeClickListener(this);
        setOnClickListener(this);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gIv);
        this.dbg.setOnSeekCompleteListener(this.cJM);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnRecoveryCallback(this.hVU);
        onChangeSkinType();
    }

    public void onPause() {
        if (ql()) {
            this.hEw = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.hEw = false;
        } else {
            this.hEw = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.hEw) {
            bAH();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.gIB);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.idj = fVar;
        this.dTG.setText(ap.hy(this.idj.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bNo = str;
        this.ctx = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dbg.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        if (this.dbg != null && this.ehy != null) {
            if (this.hVM) {
                this.dbg.start();
                this.hVM = false;
            }
            e.jH().removeCallbacks(this.UN);
            e.jH().postDelayed(this.UN, 20L);
            e.jH().removeCallbacks(this.gIw);
            if (this.dbg.bTn()) {
                this.currentState = 1;
                this.dbg.setRecoveryState(1);
            }
            if (this.ehy != null) {
                this.mStartPosition = y.bTR().AS(this.bNo);
                if (this.mStartPosition != 0) {
                    if (this.dbg != null) {
                        this.dbg.xl(this.mStartPosition);
                    } else {
                        this.ehy.seekTo(this.mStartPosition);
                    }
                    if (!this.hVL) {
                        showProgress();
                        e.jH().removeCallbacks(this.UN);
                    }
                    this.hVG = true;
                }
            }
        }
    }

    public void bPd() {
        if (!j.kY()) {
            l.S(getContext(), getContext().getString(d.j.neterror));
        } else if (this.dbg.isPlaying()) {
            pausePlay();
        } else if (this.UH) {
            bAH();
        } else {
            bSK();
        }
    }

    public void setPauseState() {
        this.cAk.bTN();
        this.gHW.setVisibility(0);
        this.hVj.setVisibility(8);
        this.currentState = 2;
        this.dbg.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.hVH) {
            dE(str, str2);
        } else {
            cf(str, str2);
        }
        if (aVar != null) {
            aVar.pa(z);
        }
    }

    public void cf(String str, String str2) {
        bSL();
        this.hVM = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbg.setVideoPath(str, str2);
        this.cAk.startLoading();
        this.gHX.setVisibility(0);
        this.gHW.setVisibility(8);
        this.hVj.setVisibility(8);
        this.eks.setVisibility(8);
        e.jH().removeCallbacks(this.gIw);
        e.jH().postDelayed(this.gIw, 60000L);
    }

    public void dE(String str, String str2) {
        bSL();
        this.hVM = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        this.cAk.startLoading();
        this.gHX.setVisibility(0);
        this.gHW.setVisibility(8);
        this.hVj.setVisibility(8);
        this.eks.setVisibility(8);
        e.jH().removeCallbacks(this.gIw);
        e.jH().postDelayed(this.gIw, 60000L);
    }

    public void bAH() {
        this.currentState = 1;
        this.dbg.setRecoveryState(1);
        this.dbg.start();
        this.gHX.setVisibility(8);
        this.gHN.setVisibility(8);
        this.cAk.bTN();
        showProgress();
        this.gHW.setVisibility(8);
        this.hVj.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kY() && this.hVK && !StringUtils.isNull(this.bNo) && !StringUtils.isNull(this.ctx)) {
            this.hVK = false;
            this.hVL = true;
            cf(this.bNo, this.ctx);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbg != null) {
            this.dbg.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dbg.isPlaying() && this.hVF) {
            bSJ();
        }
        this.dbg.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dbg.isPlaying() && this.hVF) {
            bSJ();
        }
        this.currentState = 5;
        this.dbg.setRecoveryState(5);
        e.jH().removeCallbacks(this.UN);
        e.jH().removeCallbacks(this.gIw);
        this.dbg.stopPlayback();
        this.UH = false;
        this.hVM = false;
        this.mStartPosition = 0;
        bnN();
    }

    public void bSJ() {
        y.bTR().bj(this.bNo, this.dbg.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        this.gHN.setVisibility(0);
        this.gHW.setVisibility(0);
        this.hVj.setVisibility(8);
        this.cAk.bTN();
        this.hVg.setVisibility(8);
        this.eks.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.gHX.setVisibility(z ? 0 : 8);
    }

    public void bnN() {
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
            this.hVg.setVisibility(0);
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

    private void bSK() {
        a(this.bNo, this.ctx, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bSL();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.hVH = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.la() && !this.hEQ && !com.baidu.tieba.video.g.ciN().ciO()) {
            this.hEH.setVisibility(0);
            this.hEH.setData(this.idj.getDuration(), this.idj.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bSL() {
        if (j.la()) {
            com.baidu.tieba.video.g.ciN().ex(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.gHX.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eks) {
            bSK();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").T("obj_locate", 2).bJ("tid", this.ctx));
            bPd();
        } else if (view == this.hVj) {
            cf(this.bNo, this.ctx);
        } else if (view == this.hEH.getTvPlay()) {
            this.hEQ = true;
            this.hEH.setVisibility(8);
            cf(this.bNo, this.ctx);
        } else if (view == this.hEH.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.jH().removeCallbacks(this.UN);
        e.jH().removeCallbacks(this.gIw);
        e.jH().removeCallbacks(this.hVS);
        this.mHandler.removeMessages(1);
        this.gIs.unregister(getContext());
    }
}
