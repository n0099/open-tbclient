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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.e;
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
    private String aEN;
    private int bBQ;
    private QuickVideoView bOn;
    private String biw;
    private x boR;
    private QuickVideoView.b bpa;
    private g.a bxI;
    private g.f bxJ;
    private g.InterfaceC0298g bxM;
    private TextView cFc;
    private VideoLoadingProgressView.a cUK;
    private g cUy;
    private ImageView cXo;
    private View cXs;
    private int currentState;
    private CallStateReceiver foO;
    private Runnable foR;
    private g.b foS;
    private Runnable foT;
    private CustomMessageListener foY;
    private View foj;
    private TbImageView fos;
    private boolean fox;
    private VideoControllerView.b fqT;
    private TextView gBB;
    private boolean gBW;
    private boolean gBX;
    private boolean gBY;
    private ProgressBar gBy;
    private boolean gCb;
    private boolean gCc;
    private boolean gCd;
    private Runnable gCi;
    private QuickVideoView.a gCk;
    private f gIe;
    private boolean gkJ;
    private PbVideoWifiTipLayout gkU;
    private boolean glc;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void mz(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.bBQ = 50;
        this.mSkinType = 3;
        this.fox = false;
        this.mStartPosition = 0;
        this.gBW = true;
        this.gBX = false;
        this.gBY = false;
        this.currentState = -1;
        this.gkJ = false;
        this.bxJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cUy = gVar;
                PushDialogVideoView.this.boR.brW();
            }
        };
        this.cUK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.apl();
            }
        };
        this.foR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fox = true;
                    PushDialogVideoView.this.foj.setVisibility(8);
                    PushDialogVideoView.this.cXs.setVisibility(8);
                    PushDialogVideoView.this.boR.brX();
                    PushDialogVideoView.this.fos.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.foR, 20L);
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fox = false;
                PushDialogVideoView.this.gCd = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.foj.setVisibility(0);
                PushDialogVideoView.this.gBy.setVisibility(8);
                PushDialogVideoView.this.gBy.setProgress(PushDialogVideoView.this.gBy.getMax());
                if (PushDialogVideoView.this.bOn == null || PushDialogVideoView.this.bOn.getDuration() > 150000) {
                    PushDialogVideoView.this.mt(false);
                } else {
                    PushDialogVideoView.this.gBB.setVisibility(0);
                }
                y.bsc().remove(PushDialogVideoView.this.aEN);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bOn.setRecoveryState(3);
                if (PushDialogVideoView.this.bOn != null && PushDialogVideoView.this.bOn.getDuration() <= 150000) {
                    PushDialogVideoView.this.aZ(PushDialogVideoView.this.aEN, PushDialogVideoView.this.biw);
                }
            }
        };
        this.foS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cXs.setVisibility(0);
                PushDialogVideoView.this.boR.brY();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bOn.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gCb = true;
                }
                PushDialogVideoView.this.gCd = false;
                return true;
            }
        };
        this.foT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cXs.setVisibility(0);
                PushDialogVideoView.this.boR.brY();
            }
        };
        this.bxM = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gBX) {
                    e.jG().postDelayed(PushDialogVideoView.this.gCi, 200L);
                }
            }
        };
        this.gCi = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOn == null || !PushDialogVideoView.this.gBX) {
                    e.jG().postDelayed(PushDialogVideoView.this.foR, 200L);
                    PushDialogVideoView.this.gBX = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bOn.getCurrentPosition()) {
                    PushDialogVideoView.this.gBX = false;
                    e.jG().postDelayed(PushDialogVideoView.this.foR, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gCi, 200L);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fox = false;
                PushDialogVideoView.this.gCd = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.foR);
                e.jG().removeCallbacks(PushDialogVideoView.this.foT);
            }
        };
        this.foY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bOn != null && PushDialogVideoView.this.bOn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bOn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bOn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fqT != null) {
                                PushDialogVideoView.this.fqT.hI(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bBQ - (duration % PushDialogVideoView.this.bBQ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fqT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hI(int i) {
                int duration;
                if (PushDialogVideoView.this.bOn != null && (duration = PushDialogVideoView.this.bOn.getDuration()) > 0 && PushDialogVideoView.this.gBy != null) {
                    PushDialogVideoView.this.gBy.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gCk = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bri() {
                PushDialogVideoView.this.boR.startLoading();
                PushDialogVideoView.this.fos.setVisibility(0);
                PushDialogVideoView.this.cXo.setVisibility(8);
                PushDialogVideoView.this.gBB.setVisibility(8);
                PushDialogVideoView.this.cXs.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.foT);
                e.jG().postDelayed(PushDialogVideoView.this.foT, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBQ = 50;
        this.mSkinType = 3;
        this.fox = false;
        this.mStartPosition = 0;
        this.gBW = true;
        this.gBX = false;
        this.gBY = false;
        this.currentState = -1;
        this.gkJ = false;
        this.bxJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cUy = gVar;
                PushDialogVideoView.this.boR.brW();
            }
        };
        this.cUK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.apl();
            }
        };
        this.foR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fox = true;
                    PushDialogVideoView.this.foj.setVisibility(8);
                    PushDialogVideoView.this.cXs.setVisibility(8);
                    PushDialogVideoView.this.boR.brX();
                    PushDialogVideoView.this.fos.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.foR, 20L);
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fox = false;
                PushDialogVideoView.this.gCd = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.foj.setVisibility(0);
                PushDialogVideoView.this.gBy.setVisibility(8);
                PushDialogVideoView.this.gBy.setProgress(PushDialogVideoView.this.gBy.getMax());
                if (PushDialogVideoView.this.bOn == null || PushDialogVideoView.this.bOn.getDuration() > 150000) {
                    PushDialogVideoView.this.mt(false);
                } else {
                    PushDialogVideoView.this.gBB.setVisibility(0);
                }
                y.bsc().remove(PushDialogVideoView.this.aEN);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bOn.setRecoveryState(3);
                if (PushDialogVideoView.this.bOn != null && PushDialogVideoView.this.bOn.getDuration() <= 150000) {
                    PushDialogVideoView.this.aZ(PushDialogVideoView.this.aEN, PushDialogVideoView.this.biw);
                }
            }
        };
        this.foS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cXs.setVisibility(0);
                PushDialogVideoView.this.boR.brY();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bOn.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gCb = true;
                }
                PushDialogVideoView.this.gCd = false;
                return true;
            }
        };
        this.foT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cXs.setVisibility(0);
                PushDialogVideoView.this.boR.brY();
            }
        };
        this.bxM = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gBX) {
                    e.jG().postDelayed(PushDialogVideoView.this.gCi, 200L);
                }
            }
        };
        this.gCi = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOn == null || !PushDialogVideoView.this.gBX) {
                    e.jG().postDelayed(PushDialogVideoView.this.foR, 200L);
                    PushDialogVideoView.this.gBX = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bOn.getCurrentPosition()) {
                    PushDialogVideoView.this.gBX = false;
                    e.jG().postDelayed(PushDialogVideoView.this.foR, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gCi, 200L);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fox = false;
                PushDialogVideoView.this.gCd = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.foR);
                e.jG().removeCallbacks(PushDialogVideoView.this.foT);
            }
        };
        this.foY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bOn != null && PushDialogVideoView.this.bOn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bOn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bOn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fqT != null) {
                                PushDialogVideoView.this.fqT.hI(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bBQ - (duration % PushDialogVideoView.this.bBQ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fqT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hI(int i) {
                int duration;
                if (PushDialogVideoView.this.bOn != null && (duration = PushDialogVideoView.this.bOn.getDuration()) > 0 && PushDialogVideoView.this.gBy != null) {
                    PushDialogVideoView.this.gBy.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gCk = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bri() {
                PushDialogVideoView.this.boR.startLoading();
                PushDialogVideoView.this.fos.setVisibility(0);
                PushDialogVideoView.this.cXo.setVisibility(8);
                PushDialogVideoView.this.gBB.setVisibility(8);
                PushDialogVideoView.this.cXs.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.foT);
                e.jG().postDelayed(PushDialogVideoView.this.foT, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBQ = 50;
        this.mSkinType = 3;
        this.fox = false;
        this.mStartPosition = 0;
        this.gBW = true;
        this.gBX = false;
        this.gBY = false;
        this.currentState = -1;
        this.gkJ = false;
        this.bxJ = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cUy = gVar;
                PushDialogVideoView.this.boR.brW();
            }
        };
        this.cUK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.apl();
            }
        };
        this.foR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fox = true;
                    PushDialogVideoView.this.foj.setVisibility(8);
                    PushDialogVideoView.this.cXs.setVisibility(8);
                    PushDialogVideoView.this.boR.brX();
                    PushDialogVideoView.this.fos.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.foR, 20L);
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fox = false;
                PushDialogVideoView.this.gCd = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.foj.setVisibility(0);
                PushDialogVideoView.this.gBy.setVisibility(8);
                PushDialogVideoView.this.gBy.setProgress(PushDialogVideoView.this.gBy.getMax());
                if (PushDialogVideoView.this.bOn == null || PushDialogVideoView.this.bOn.getDuration() > 150000) {
                    PushDialogVideoView.this.mt(false);
                } else {
                    PushDialogVideoView.this.gBB.setVisibility(0);
                }
                y.bsc().remove(PushDialogVideoView.this.aEN);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bOn.setRecoveryState(3);
                if (PushDialogVideoView.this.bOn != null && PushDialogVideoView.this.bOn.getDuration() <= 150000) {
                    PushDialogVideoView.this.aZ(PushDialogVideoView.this.aEN, PushDialogVideoView.this.biw);
                }
            }
        };
        this.foS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.cXs.setVisibility(0);
                PushDialogVideoView.this.boR.brY();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bOn.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gCb = true;
                }
                PushDialogVideoView.this.gCd = false;
                return true;
            }
        };
        this.foT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cXs.setVisibility(0);
                PushDialogVideoView.this.boR.brY();
            }
        };
        this.bxM = new g.InterfaceC0298g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gBX) {
                    e.jG().postDelayed(PushDialogVideoView.this.gCi, 200L);
                }
            }
        };
        this.gCi = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bOn == null || !PushDialogVideoView.this.gBX) {
                    e.jG().postDelayed(PushDialogVideoView.this.foR, 200L);
                    PushDialogVideoView.this.gBX = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bOn.getCurrentPosition()) {
                    PushDialogVideoView.this.gBX = false;
                    e.jG().postDelayed(PushDialogVideoView.this.foR, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gCi, 200L);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fox = false;
                PushDialogVideoView.this.gCd = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.foR);
                e.jG().removeCallbacks(PushDialogVideoView.this.foT);
            }
        };
        this.foY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bOn != null && PushDialogVideoView.this.bOn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bOn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bOn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fqT != null) {
                                PushDialogVideoView.this.fqT.hI(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bBQ - (duration % PushDialogVideoView.this.bBQ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fqT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hI(int i2) {
                int duration;
                if (PushDialogVideoView.this.bOn != null && (duration = PushDialogVideoView.this.bOn.getDuration()) > 0 && PushDialogVideoView.this.gBy != null) {
                    PushDialogVideoView.this.gBy.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gCk = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bri() {
                PushDialogVideoView.this.boR.startLoading();
                PushDialogVideoView.this.fos.setVisibility(0);
                PushDialogVideoView.this.cXo.setVisibility(8);
                PushDialogVideoView.this.gBB.setVisibility(8);
                PushDialogVideoView.this.cXs.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.foT);
                e.jG().postDelayed(PushDialogVideoView.this.foT, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0210e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bOn = (QuickVideoView) findViewById(e.g.videoView);
        this.boR = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.boR.setLoadingAnimationListener(this.cUK);
        this.gBy = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.gBy.setMax(this.mWidth);
        this.gBy.setProgress(0);
        this.foj = findViewById(e.g.black_mask);
        this.cXs = findViewById(e.g.layout_error);
        this.cXo = (ImageView) findViewById(e.g.img_play);
        this.gBB = (TextView) findViewById(e.g.txt_replay);
        this.cFc = (TextView) findViewById(e.g.push_dialog_video_time);
        this.fos = (TbImageView) findViewById(e.g.video_thumbnail);
        this.gkU = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.fos.setDefaultErrorResource(0);
        this.fos.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.foO = new CallStateReceiver();
        this.foO.register(context);
        this.cXs.setOnClickListener(this);
        this.gBB.setOnClickListener(this);
        this.gkU.setOnPlayClickListener(this);
        this.gkU.setFreeClickListener(this);
        setOnClickListener(this);
        this.bOn.setOnPreparedListener(this.bxJ);
        this.bOn.setOnCompletionListener(this.bxI);
        this.bOn.setOnErrorListener(this.foS);
        this.bOn.setOnSeekCompleteListener(this.bxM);
        this.bOn.setOnSurfaceDestroyedListener(this.bpa);
        this.bOn.setOnRecoveryCallback(this.gCk);
        onChangeSkinType();
    }

    public void onPause() {
        if (bqV()) {
            this.gkJ = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.gkJ = false;
        } else {
            this.gkJ = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.gkJ) {
            aYS();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.foY);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gIe = fVar;
        this.cFc.setText(ao.dV(this.gIe.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.aEN = str;
        this.biw = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bOn.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        if (this.bOn != null && this.cUy != null) {
            if (this.gCd) {
                this.bOn.start();
                this.gCd = false;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.foR, 20L);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
            if (this.bOn.bry()) {
                this.currentState = 1;
                this.bOn.setRecoveryState(1);
            }
            if (this.cUy != null) {
                this.mStartPosition = y.bsc().tW(this.aEN);
                if (this.mStartPosition != 0) {
                    if (this.bOn != null) {
                        this.bOn.to(this.mStartPosition);
                    } else {
                        this.cUy.seekTo(this.mStartPosition);
                    }
                    if (!this.gCc) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
                    }
                    this.gBX = true;
                }
            }
        }
    }

    public void bnn() {
        if (!j.kV()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bOn.isPlaying()) {
            pausePlay();
        } else if (this.fox) {
            aYS();
        } else {
            bqW();
        }
    }

    public void setPauseState() {
        this.boR.brY();
        this.cXo.setVisibility(0);
        this.gBB.setVisibility(8);
        this.currentState = 2;
        this.bOn.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gBY) {
            cs(str, str2);
        } else {
            aZ(str, str2);
        }
        if (aVar != null) {
            aVar.mz(z);
        }
    }

    public void aZ(String str, String str2) {
        bqX();
        this.gCd = true;
        this.currentState = 0;
        this.bOn.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bOn.setVideoPath(str, str2);
        this.boR.startLoading();
        this.fos.setVisibility(0);
        this.cXo.setVisibility(8);
        this.gBB.setVisibility(8);
        this.cXs.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.foT, 60000L);
    }

    public void cs(String str, String str2) {
        bqX();
        this.gCd = true;
        this.currentState = 0;
        this.bOn.setRecoveryState(0);
        this.boR.startLoading();
        this.fos.setVisibility(0);
        this.cXo.setVisibility(8);
        this.gBB.setVisibility(8);
        this.cXs.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.foT, 60000L);
    }

    public void aYS() {
        this.currentState = 1;
        this.bOn.setRecoveryState(1);
        this.bOn.start();
        this.fos.setVisibility(8);
        this.foj.setVisibility(8);
        this.boR.brY();
        showProgress();
        this.cXo.setVisibility(8);
        this.gBB.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kV() && this.gCb && !StringUtils.isNull(this.aEN) && !StringUtils.isNull(this.biw)) {
            this.gCb = false;
            this.gCc = true;
            aZ(this.aEN, this.biw);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bOn != null) {
            this.bOn.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bOn.isPlaying() && this.gBW) {
            bqU();
        }
        this.bOn.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bOn.isPlaying() && this.gBW) {
            bqU();
        }
        this.currentState = 5;
        this.bOn.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        this.bOn.stopPlayback();
        this.fox = false;
        this.gCd = false;
        this.mStartPosition = 0;
        aLW();
    }

    public void bqU() {
        y.bsc().aN(this.aEN, this.bOn.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt(boolean z) {
        this.foj.setVisibility(0);
        this.cXo.setVisibility(0);
        this.gBB.setVisibility(8);
        this.boR.brY();
        this.gBy.setVisibility(8);
        this.cXs.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.fos.setVisibility(z ? 0 : 8);
    }

    public void aLW() {
        mt(true);
    }

    public boolean bqV() {
        if (this.bOn == null) {
            return false;
        }
        return this.bOn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bOn == null) {
            return 0;
        }
        return this.bOn.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bOn != null) {
            this.gBy.setVisibility(0);
            this.bBQ = ((this.bOn.getDuration() / 200) / 50) * 50;
            if (this.bBQ < 50) {
                this.bBQ = 50;
            } else if (this.bBQ > 500) {
                this.bBQ = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bBQ - (this.bOn.getCurrentPosition() % this.bBQ));
        }
    }

    private void bqW() {
        a(this.aEN, this.biw, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bqX();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gBY = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kX() && !this.glc && !com.baidu.tieba.video.g.bHQ().bHR()) {
            this.gkU.setVisibility(0);
            this.gkU.setData(this.gIe.getDuration(), this.gIe.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bqX() {
        if (j.kX()) {
            com.baidu.tieba.video.g.bHQ().dc(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.fos.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cXs) {
            bqW();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 2).aA("tid", this.biw));
            bnn();
        } else if (view == this.gBB) {
            aZ(this.aEN, this.biw);
        } else if (view == this.gkU.getTvPlay()) {
            this.glc = true;
            this.gkU.setVisibility(8);
            aZ(this.aEN, this.biw);
        } else if (view == this.gkU.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCi);
        this.mHandler.removeMessages(1);
        this.foO.unregister(getContext());
    }
}
