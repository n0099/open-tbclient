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
    private w eBf;
    private QuickVideoView.b eBo;
    private g.a eKl;
    private g.f eKm;
    private g.InterfaceC0704g eKp;
    private int eON;
    private QuickVideoView fbM;
    private VideoLoadingProgressView.a gDY;
    private View gGC;
    private TextView gnJ;
    private g hxJ;
    private View iZP;
    private ImageView iZY;
    private CustomMessageListener jaD;
    private CallStateReceiver jau;
    private g.b jax;
    private Runnable jay;
    private VideoControllerView.b jcy;
    private i kFH;
    private boolean kbF;
    private boolean kbl;
    private PbVideoWifiTipLayout kbw;
    private ProgressBar kwU;
    private TextView kwX;
    private boolean kxA;
    private boolean kxB;
    private Runnable kxH;
    private QuickVideoView.a kxJ;
    private boolean kxu;
    private boolean kxv;
    private boolean kxw;
    private boolean kxz;
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
        this.eON = 50;
        this.mSkinType = 3;
        this.Yr = false;
        this.mStartPosition = 0;
        this.kxu = true;
        this.kxv = false;
        this.kxw = false;
        this.currentState = -1;
        this.kbl = false;
        this.eKm = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hxJ = gVar;
                PushDialogVideoView.this.eBf.cRj();
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bKX();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yr = true;
                    PushDialogVideoView.this.iZP.setVisibility(8);
                    PushDialogVideoView.this.gGC.setVisibility(8);
                    PushDialogVideoView.this.eBf.cRk();
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
        this.eKl = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kxB = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iZP.setVisibility(0);
                PushDialogVideoView.this.kwU.setVisibility(8);
                PushDialogVideoView.this.kwU.setProgress(PushDialogVideoView.this.kwU.getMax());
                if (PushDialogVideoView.this.fbM == null || PushDialogVideoView.this.fbM.getDuration() > 150000) {
                    PushDialogVideoView.this.tq(false);
                } else {
                    PushDialogVideoView.this.kwX.setVisibility(0);
                }
                x.cRo().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fbM.setRecoveryState(3);
                if (PushDialogVideoView.this.fbM != null && PushDialogVideoView.this.fbM.getDuration() <= 150000) {
                    PushDialogVideoView.this.eW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ais);
                }
            }
        };
        this.jax = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.gGC.setVisibility(0);
                PushDialogVideoView.this.eBf.cRl();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fbM.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kxz = true;
                }
                PushDialogVideoView.this.kxB = false;
                return true;
            }
        };
        this.jay = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gGC.setVisibility(0);
                PushDialogVideoView.this.eBf.cRl();
            }
        };
        this.eKp = new g.InterfaceC0704g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kxv) {
                    e.ld().postDelayed(PushDialogVideoView.this.kxH, 200L);
                }
            }
        };
        this.kxH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbM == null || !PushDialogVideoView.this.kxv) {
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 200L);
                    PushDialogVideoView.this.kxv = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fbM.getCurrentPosition()) {
                    PushDialogVideoView.this.kxv = false;
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
                } else {
                    e.ld().postDelayed(PushDialogVideoView.this.kxH, 200L);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kxB = false;
                e.ld().removeCallbacks(PushDialogVideoView.this.Yx);
                e.ld().removeCallbacks(PushDialogVideoView.this.jay);
            }
        };
        this.jaD = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.fbM != null && PushDialogVideoView.this.fbM.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fbM.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fbM.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jcy != null) {
                                PushDialogVideoView.this.jcy.pe(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eON - (duration % PushDialogVideoView.this.eON));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jcy = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pe(int i) {
                int duration;
                if (PushDialogVideoView.this.fbM != null && (duration = PushDialogVideoView.this.fbM.getDuration()) > 0 && PushDialogVideoView.this.kwU != null) {
                    PushDialogVideoView.this.kwU.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kxJ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQp() {
                PushDialogVideoView.this.eBf.startLoading();
                PushDialogVideoView.this.aii.setVisibility(0);
                PushDialogVideoView.this.iZY.setVisibility(8);
                PushDialogVideoView.this.kwX.setVisibility(8);
                PushDialogVideoView.this.gGC.setVisibility(8);
                e.ld().removeCallbacks(PushDialogVideoView.this.jay);
                e.ld().postDelayed(PushDialogVideoView.this.jay, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eON = 50;
        this.mSkinType = 3;
        this.Yr = false;
        this.mStartPosition = 0;
        this.kxu = true;
        this.kxv = false;
        this.kxw = false;
        this.currentState = -1;
        this.kbl = false;
        this.eKm = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hxJ = gVar;
                PushDialogVideoView.this.eBf.cRj();
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bKX();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yr = true;
                    PushDialogVideoView.this.iZP.setVisibility(8);
                    PushDialogVideoView.this.gGC.setVisibility(8);
                    PushDialogVideoView.this.eBf.cRk();
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
        this.eKl = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kxB = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iZP.setVisibility(0);
                PushDialogVideoView.this.kwU.setVisibility(8);
                PushDialogVideoView.this.kwU.setProgress(PushDialogVideoView.this.kwU.getMax());
                if (PushDialogVideoView.this.fbM == null || PushDialogVideoView.this.fbM.getDuration() > 150000) {
                    PushDialogVideoView.this.tq(false);
                } else {
                    PushDialogVideoView.this.kwX.setVisibility(0);
                }
                x.cRo().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fbM.setRecoveryState(3);
                if (PushDialogVideoView.this.fbM != null && PushDialogVideoView.this.fbM.getDuration() <= 150000) {
                    PushDialogVideoView.this.eW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ais);
                }
            }
        };
        this.jax = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.gGC.setVisibility(0);
                PushDialogVideoView.this.eBf.cRl();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fbM.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kxz = true;
                }
                PushDialogVideoView.this.kxB = false;
                return true;
            }
        };
        this.jay = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gGC.setVisibility(0);
                PushDialogVideoView.this.eBf.cRl();
            }
        };
        this.eKp = new g.InterfaceC0704g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kxv) {
                    e.ld().postDelayed(PushDialogVideoView.this.kxH, 200L);
                }
            }
        };
        this.kxH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbM == null || !PushDialogVideoView.this.kxv) {
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 200L);
                    PushDialogVideoView.this.kxv = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fbM.getCurrentPosition()) {
                    PushDialogVideoView.this.kxv = false;
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
                } else {
                    e.ld().postDelayed(PushDialogVideoView.this.kxH, 200L);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kxB = false;
                e.ld().removeCallbacks(PushDialogVideoView.this.Yx);
                e.ld().removeCallbacks(PushDialogVideoView.this.jay);
            }
        };
        this.jaD = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.fbM != null && PushDialogVideoView.this.fbM.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fbM.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fbM.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jcy != null) {
                                PushDialogVideoView.this.jcy.pe(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eON - (duration % PushDialogVideoView.this.eON));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jcy = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pe(int i) {
                int duration;
                if (PushDialogVideoView.this.fbM != null && (duration = PushDialogVideoView.this.fbM.getDuration()) > 0 && PushDialogVideoView.this.kwU != null) {
                    PushDialogVideoView.this.kwU.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kxJ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQp() {
                PushDialogVideoView.this.eBf.startLoading();
                PushDialogVideoView.this.aii.setVisibility(0);
                PushDialogVideoView.this.iZY.setVisibility(8);
                PushDialogVideoView.this.kwX.setVisibility(8);
                PushDialogVideoView.this.gGC.setVisibility(8);
                e.ld().removeCallbacks(PushDialogVideoView.this.jay);
                e.ld().postDelayed(PushDialogVideoView.this.jay, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eON = 50;
        this.mSkinType = 3;
        this.Yr = false;
        this.mStartPosition = 0;
        this.kxu = true;
        this.kxv = false;
        this.kxw = false;
        this.currentState = -1;
        this.kbl = false;
        this.eKm = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.hxJ = gVar;
                PushDialogVideoView.this.eBf.cRj();
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bKX();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbM.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Yr = true;
                    PushDialogVideoView.this.iZP.setVisibility(8);
                    PushDialogVideoView.this.gGC.setVisibility(8);
                    PushDialogVideoView.this.eBf.cRk();
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
        this.eKl = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kxB = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iZP.setVisibility(0);
                PushDialogVideoView.this.kwU.setVisibility(8);
                PushDialogVideoView.this.kwU.setProgress(PushDialogVideoView.this.kwU.getMax());
                if (PushDialogVideoView.this.fbM == null || PushDialogVideoView.this.fbM.getDuration() > 150000) {
                    PushDialogVideoView.this.tq(false);
                } else {
                    PushDialogVideoView.this.kwX.setVisibility(0);
                }
                x.cRo().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.fbM.setRecoveryState(3);
                if (PushDialogVideoView.this.fbM != null && PushDialogVideoView.this.fbM.getDuration() <= 150000) {
                    PushDialogVideoView.this.eW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ais);
                }
            }
        };
        this.jax = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.gGC.setVisibility(0);
                PushDialogVideoView.this.eBf.cRl();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.fbM.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.kxz = true;
                }
                PushDialogVideoView.this.kxB = false;
                return true;
            }
        };
        this.jay = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gGC.setVisibility(0);
                PushDialogVideoView.this.eBf.cRl();
            }
        };
        this.eKp = new g.InterfaceC0704g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(g gVar) {
                if (PushDialogVideoView.this.kxv) {
                    e.ld().postDelayed(PushDialogVideoView.this.kxH, 200L);
                }
            }
        };
        this.kxH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fbM == null || !PushDialogVideoView.this.kxv) {
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 200L);
                    PushDialogVideoView.this.kxv = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fbM.getCurrentPosition()) {
                    PushDialogVideoView.this.kxv = false;
                    e.ld().postDelayed(PushDialogVideoView.this.Yx, 20L);
                } else {
                    e.ld().postDelayed(PushDialogVideoView.this.kxH, 200L);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Yr = false;
                PushDialogVideoView.this.kxB = false;
                e.ld().removeCallbacks(PushDialogVideoView.this.Yx);
                e.ld().removeCallbacks(PushDialogVideoView.this.jay);
            }
        };
        this.jaD = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.fbM != null && PushDialogVideoView.this.fbM.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fbM.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fbM.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jcy != null) {
                                PushDialogVideoView.this.jcy.pe(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eON - (duration % PushDialogVideoView.this.eON));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jcy = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pe(int i2) {
                int duration;
                if (PushDialogVideoView.this.fbM != null && (duration = PushDialogVideoView.this.fbM.getDuration()) > 0 && PushDialogVideoView.this.kwU != null) {
                    PushDialogVideoView.this.kwU.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.kxJ = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQp() {
                PushDialogVideoView.this.eBf.startLoading();
                PushDialogVideoView.this.aii.setVisibility(0);
                PushDialogVideoView.this.iZY.setVisibility(8);
                PushDialogVideoView.this.kwX.setVisibility(8);
                PushDialogVideoView.this.gGC.setVisibility(8);
                e.ld().removeCallbacks(PushDialogVideoView.this.jay);
                e.ld().postDelayed(PushDialogVideoView.this.jay, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fbM = (QuickVideoView) findViewById(R.id.videoView);
        this.eBf = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eBf.setLoadingAnimationListener(this.gDY);
        this.kwU = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.kwU.setMax(this.mWidth);
        this.kwU.setProgress(0);
        this.iZP = findViewById(R.id.black_mask);
        this.gGC = findViewById(R.id.layout_error);
        this.iZY = (ImageView) findViewById(R.id.img_play);
        this.kwX = (TextView) findViewById(R.id.txt_replay);
        this.gnJ = (TextView) findViewById(R.id.push_dialog_video_time);
        this.aii = (TbImageView) findViewById(R.id.video_thumbnail);
        this.kbw = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.aii.setDefaultErrorResource(0);
        this.aii.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jau = new CallStateReceiver();
        this.jau.register(context);
        this.gGC.setOnClickListener(this);
        this.kwX.setOnClickListener(this);
        this.kbw.setOnPlayClickListener(this);
        this.kbw.setFreeClickListener(this);
        setOnClickListener(this);
        this.fbM.setOnPreparedListener(this.eKm);
        this.fbM.setOnCompletionListener(this.eKl);
        this.fbM.setOnErrorListener(this.jax);
        this.fbM.setOnSeekCompleteListener(this.eKp);
        this.fbM.setOnSurfaceDestroyedListener(this.eBo);
        this.fbM.setOnRecoveryCallback(this.kxJ);
        onChangeSkinType();
    }

    public void onPause() {
        if (pO()) {
            this.kbl = true;
            avT();
        } else if (getCurrentState() == 3) {
            this.kbl = false;
        } else {
            this.kbl = false;
            avT();
        }
    }

    public void onResume() {
        if (this.kbl) {
            avU();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jaD);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.kFH = iVar;
        this.gnJ.setText(aq.stringForVideoTime(this.kFH.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ais = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.fbM.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        if (this.fbM != null && this.hxJ != null) {
            if (this.kxB) {
                this.fbM.start();
                this.kxB = false;
            }
            e.ld().removeCallbacks(this.Yx);
            e.ld().postDelayed(this.Yx, 20L);
            e.ld().removeCallbacks(this.jay);
            if (this.fbM.cQK()) {
                this.currentState = 1;
                this.fbM.setRecoveryState(1);
            }
            if (this.hxJ != null) {
                this.mStartPosition = x.cRo().KA(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.fbM != null) {
                        this.fbM.BK(this.mStartPosition);
                    } else {
                        this.hxJ.seekTo(this.mStartPosition);
                    }
                    if (!this.kxA) {
                        showProgress();
                        e.ld().removeCallbacks(this.Yx);
                    }
                    this.kxv = true;
                }
            }
        }
    }

    public void cKk() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fbM.isPlaying()) {
            avT();
        } else if (this.Yr) {
            avU();
        } else {
            cQd();
        }
    }

    public void setPauseState() {
        this.eBf.cRl();
        this.iZY.setVisibility(0);
        this.kwX.setVisibility(8);
        this.currentState = 2;
        this.fbM.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.kxw) {
            eX(str, str2);
        } else {
            eW(str, str2);
        }
        if (aVar != null) {
            aVar.tv(z);
        }
    }

    public void eW(String str, String str2) {
        cQe();
        this.kxB = true;
        this.currentState = 0;
        this.fbM.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.fbM.setVideoPath(str, str2);
        this.eBf.startLoading();
        this.aii.setVisibility(0);
        this.iZY.setVisibility(8);
        this.kwX.setVisibility(8);
        this.gGC.setVisibility(8);
        e.ld().removeCallbacks(this.jay);
        e.ld().postDelayed(this.jay, 60000L);
    }

    public void eX(String str, String str2) {
        cQe();
        this.kxB = true;
        this.currentState = 0;
        this.fbM.setRecoveryState(0);
        this.eBf.startLoading();
        this.aii.setVisibility(0);
        this.iZY.setVisibility(8);
        this.kwX.setVisibility(8);
        this.gGC.setVisibility(8);
        e.ld().removeCallbacks(this.jay);
        e.ld().postDelayed(this.jay, 60000L);
    }

    public void avU() {
        this.currentState = 1;
        this.fbM.setRecoveryState(1);
        this.fbM.start();
        this.aii.setVisibility(8);
        this.iZP.setVisibility(8);
        this.eBf.cRl();
        showProgress();
        this.iZY.setVisibility(8);
        this.kwX.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.kxz && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ais)) {
            this.kxz = false;
            this.kxA = true;
            eW(this.mVideoUrl, this.ais);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.fbM != null) {
            this.fbM.setNeedRecovery(z);
        }
    }

    public void avT() {
        if (this.fbM.isPlaying() && this.kxu) {
            cQc();
        }
        this.fbM.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fbM.isPlaying() && this.kxu) {
            cQc();
        }
        this.currentState = 5;
        this.fbM.setRecoveryState(5);
        e.ld().removeCallbacks(this.Yx);
        e.ld().removeCallbacks(this.jay);
        this.fbM.stopPlayback();
        this.Yr = false;
        this.kxB = false;
        this.mStartPosition = 0;
        chf();
    }

    public void cQc() {
        x.cRo().bw(this.mVideoUrl, this.fbM.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(boolean z) {
        this.iZP.setVisibility(0);
        this.iZY.setVisibility(0);
        this.kwX.setVisibility(8);
        this.eBf.cRl();
        this.kwU.setVisibility(8);
        this.gGC.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.aii.setVisibility(z ? 0 : 8);
    }

    public void chf() {
        tq(true);
    }

    public boolean pO() {
        if (this.fbM == null) {
            return false;
        }
        return this.fbM.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fbM == null) {
            return 0;
        }
        return this.fbM.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fbM != null) {
            this.kwU.setVisibility(0);
            this.eON = ((this.fbM.getDuration() / 200) / 50) * 50;
            if (this.eON < 50) {
                this.eON = 50;
            } else if (this.eON > 500) {
                this.eON = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eON - (this.fbM.getCurrentPosition() % this.eON));
        }
    }

    private void cQd() {
        a(this.mVideoUrl, this.ais, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cQe();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.kxw = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.kbF && !com.baidu.tieba.video.g.dhK().dhL()) {
            this.kbw.setVisibility(0);
            this.kbw.setData(this.kFH.getDuration(), this.kFH.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cQe() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dhK().fs(getContext());
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
        if (view == this.gGC) {
            cQd();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").ag("obj_locate", 2).dh("tid", this.ais));
            cKk();
        } else if (view == this.kwX) {
            eW(this.mVideoUrl, this.ais);
        } else if (view == this.kbw.getTvPlay()) {
            this.kbF = true;
            this.kbw.setVisibility(8);
            eW(this.mVideoUrl, this.ais);
        } else if (view == this.kbw.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.ld().removeCallbacks(this.jay);
        e.ld().removeCallbacks(this.kxH);
        this.mHandler.removeMessages(1);
        this.jau.unregister(getContext());
    }
}
