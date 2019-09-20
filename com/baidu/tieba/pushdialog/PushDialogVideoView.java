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
    private boolean SJ;
    private Runnable SR;
    private String bXN;
    private String bXa;
    private x cKK;
    private QuickVideoView.b cKT;
    private g.a cUp;
    private g.f cUq;
    private g.InterfaceC0404g cUt;
    private int cZk;
    private int currentState;
    private g dhY;
    private QuickVideoView dpn;
    private VideoLoadingProgressView.a eEm;
    private View eGT;
    private TextView ekB;
    private CallStateReceiver hiP;
    private g.b hiS;
    private Runnable hiT;
    private CustomMessageListener hiY;
    private View hik;
    private ImageView hit;
    private TbImageView hiu;
    private VideoControllerView.b hkT;
    private f iFF;
    private boolean ifM;
    private PbVideoWifiTipLayout ifX;
    private boolean igg;
    private boolean ixP;
    private boolean ixQ;
    private boolean ixR;
    private boolean ixU;
    private boolean ixV;
    private boolean ixW;
    private ProgressBar ixq;
    private TextView ixt;
    private Runnable iyc;
    private QuickVideoView.a iye;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void qh(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.cZk = 50;
        this.mSkinType = 3;
        this.SJ = false;
        this.mStartPosition = 0;
        this.ixP = true;
        this.ixQ = false;
        this.ixR = false;
        this.currentState = -1;
        this.ifM = false;
        this.cUq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dhY = gVar;
                PushDialogVideoView.this.cKK.cfM();
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.baa();
            }
        };
        this.SR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dpn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SJ = true;
                    PushDialogVideoView.this.hik.setVisibility(8);
                    PushDialogVideoView.this.eGT.setVisibility(8);
                    PushDialogVideoView.this.cKK.cfN();
                    PushDialogVideoView.this.hiu.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SR, 20L);
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SJ = false;
                PushDialogVideoView.this.ixW = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hik.setVisibility(0);
                PushDialogVideoView.this.ixq.setVisibility(8);
                PushDialogVideoView.this.ixq.setProgress(PushDialogVideoView.this.ixq.getMax());
                if (PushDialogVideoView.this.dpn == null || PushDialogVideoView.this.dpn.getDuration() > 150000) {
                    PushDialogVideoView.this.qc(false);
                } else {
                    PushDialogVideoView.this.ixt.setVisibility(0);
                }
                y.cfS().remove(PushDialogVideoView.this.bXa);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dpn.setRecoveryState(3);
                if (PushDialogVideoView.this.dpn != null && PushDialogVideoView.this.dpn.getDuration() <= 150000) {
                    PushDialogVideoView.this.ct(PushDialogVideoView.this.bXa, PushDialogVideoView.this.bXN);
                }
            }
        };
        this.hiS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eGT.setVisibility(0);
                PushDialogVideoView.this.cKK.cfO();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dpn.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.ixU = true;
                }
                PushDialogVideoView.this.ixW = false;
                return true;
            }
        };
        this.hiT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eGT.setVisibility(0);
                PushDialogVideoView.this.cKK.cfO();
            }
        };
        this.cUt = new g.InterfaceC0404g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ixQ) {
                    e.iK().postDelayed(PushDialogVideoView.this.iyc, 200L);
                }
            }
        };
        this.iyc = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dpn == null || !PushDialogVideoView.this.ixQ) {
                    e.iK().postDelayed(PushDialogVideoView.this.SR, 200L);
                    PushDialogVideoView.this.ixQ = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dpn.getCurrentPosition()) {
                    PushDialogVideoView.this.ixQ = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SR, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iyc, 200L);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SJ = false;
                PushDialogVideoView.this.ixW = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SR);
                e.iK().removeCallbacks(PushDialogVideoView.this.hiT);
            }
        };
        this.hiY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dpn != null && PushDialogVideoView.this.dpn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dpn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dpn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hkT != null) {
                                PushDialogVideoView.this.hkT.mz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cZk - (duration % PushDialogVideoView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hkT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mz(int i) {
                int duration;
                if (PushDialogVideoView.this.dpn != null && (duration = PushDialogVideoView.this.dpn.getDuration()) > 0 && PushDialogVideoView.this.ixq != null) {
                    PushDialogVideoView.this.ixq.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iye = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void ceX() {
                PushDialogVideoView.this.cKK.startLoading();
                PushDialogVideoView.this.hiu.setVisibility(0);
                PushDialogVideoView.this.hit.setVisibility(8);
                PushDialogVideoView.this.ixt.setVisibility(8);
                PushDialogVideoView.this.eGT.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hiT);
                e.iK().postDelayed(PushDialogVideoView.this.hiT, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZk = 50;
        this.mSkinType = 3;
        this.SJ = false;
        this.mStartPosition = 0;
        this.ixP = true;
        this.ixQ = false;
        this.ixR = false;
        this.currentState = -1;
        this.ifM = false;
        this.cUq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dhY = gVar;
                PushDialogVideoView.this.cKK.cfM();
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.baa();
            }
        };
        this.SR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dpn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SJ = true;
                    PushDialogVideoView.this.hik.setVisibility(8);
                    PushDialogVideoView.this.eGT.setVisibility(8);
                    PushDialogVideoView.this.cKK.cfN();
                    PushDialogVideoView.this.hiu.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SR, 20L);
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SJ = false;
                PushDialogVideoView.this.ixW = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hik.setVisibility(0);
                PushDialogVideoView.this.ixq.setVisibility(8);
                PushDialogVideoView.this.ixq.setProgress(PushDialogVideoView.this.ixq.getMax());
                if (PushDialogVideoView.this.dpn == null || PushDialogVideoView.this.dpn.getDuration() > 150000) {
                    PushDialogVideoView.this.qc(false);
                } else {
                    PushDialogVideoView.this.ixt.setVisibility(0);
                }
                y.cfS().remove(PushDialogVideoView.this.bXa);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dpn.setRecoveryState(3);
                if (PushDialogVideoView.this.dpn != null && PushDialogVideoView.this.dpn.getDuration() <= 150000) {
                    PushDialogVideoView.this.ct(PushDialogVideoView.this.bXa, PushDialogVideoView.this.bXN);
                }
            }
        };
        this.hiS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eGT.setVisibility(0);
                PushDialogVideoView.this.cKK.cfO();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dpn.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.ixU = true;
                }
                PushDialogVideoView.this.ixW = false;
                return true;
            }
        };
        this.hiT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eGT.setVisibility(0);
                PushDialogVideoView.this.cKK.cfO();
            }
        };
        this.cUt = new g.InterfaceC0404g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ixQ) {
                    e.iK().postDelayed(PushDialogVideoView.this.iyc, 200L);
                }
            }
        };
        this.iyc = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dpn == null || !PushDialogVideoView.this.ixQ) {
                    e.iK().postDelayed(PushDialogVideoView.this.SR, 200L);
                    PushDialogVideoView.this.ixQ = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dpn.getCurrentPosition()) {
                    PushDialogVideoView.this.ixQ = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SR, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iyc, 200L);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SJ = false;
                PushDialogVideoView.this.ixW = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SR);
                e.iK().removeCallbacks(PushDialogVideoView.this.hiT);
            }
        };
        this.hiY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dpn != null && PushDialogVideoView.this.dpn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dpn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dpn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hkT != null) {
                                PushDialogVideoView.this.hkT.mz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cZk - (duration % PushDialogVideoView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hkT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mz(int i) {
                int duration;
                if (PushDialogVideoView.this.dpn != null && (duration = PushDialogVideoView.this.dpn.getDuration()) > 0 && PushDialogVideoView.this.ixq != null) {
                    PushDialogVideoView.this.ixq.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iye = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void ceX() {
                PushDialogVideoView.this.cKK.startLoading();
                PushDialogVideoView.this.hiu.setVisibility(0);
                PushDialogVideoView.this.hit.setVisibility(8);
                PushDialogVideoView.this.ixt.setVisibility(8);
                PushDialogVideoView.this.eGT.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hiT);
                e.iK().postDelayed(PushDialogVideoView.this.hiT, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZk = 50;
        this.mSkinType = 3;
        this.SJ = false;
        this.mStartPosition = 0;
        this.ixP = true;
        this.ixQ = false;
        this.ixR = false;
        this.currentState = -1;
        this.ifM = false;
        this.cUq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dhY = gVar;
                PushDialogVideoView.this.cKK.cfM();
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.baa();
            }
        };
        this.SR = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dpn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SJ = true;
                    PushDialogVideoView.this.hik.setVisibility(8);
                    PushDialogVideoView.this.eGT.setVisibility(8);
                    PushDialogVideoView.this.cKK.cfN();
                    PushDialogVideoView.this.hiu.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SR, 20L);
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SJ = false;
                PushDialogVideoView.this.ixW = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hik.setVisibility(0);
                PushDialogVideoView.this.ixq.setVisibility(8);
                PushDialogVideoView.this.ixq.setProgress(PushDialogVideoView.this.ixq.getMax());
                if (PushDialogVideoView.this.dpn == null || PushDialogVideoView.this.dpn.getDuration() > 150000) {
                    PushDialogVideoView.this.qc(false);
                } else {
                    PushDialogVideoView.this.ixt.setVisibility(0);
                }
                y.cfS().remove(PushDialogVideoView.this.bXa);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dpn.setRecoveryState(3);
                if (PushDialogVideoView.this.dpn != null && PushDialogVideoView.this.dpn.getDuration() <= 150000) {
                    PushDialogVideoView.this.ct(PushDialogVideoView.this.bXa, PushDialogVideoView.this.bXN);
                }
            }
        };
        this.hiS = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eGT.setVisibility(0);
                PushDialogVideoView.this.cKK.cfO();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dpn.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.ixU = true;
                }
                PushDialogVideoView.this.ixW = false;
                return true;
            }
        };
        this.hiT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eGT.setVisibility(0);
                PushDialogVideoView.this.cKK.cfO();
            }
        };
        this.cUt = new g.InterfaceC0404g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                if (PushDialogVideoView.this.ixQ) {
                    e.iK().postDelayed(PushDialogVideoView.this.iyc, 200L);
                }
            }
        };
        this.iyc = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dpn == null || !PushDialogVideoView.this.ixQ) {
                    e.iK().postDelayed(PushDialogVideoView.this.SR, 200L);
                    PushDialogVideoView.this.ixQ = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dpn.getCurrentPosition()) {
                    PushDialogVideoView.this.ixQ = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SR, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iyc, 200L);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SJ = false;
                PushDialogVideoView.this.ixW = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SR);
                e.iK().removeCallbacks(PushDialogVideoView.this.hiT);
            }
        };
        this.hiY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dpn != null && PushDialogVideoView.this.dpn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dpn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dpn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hkT != null) {
                                PushDialogVideoView.this.hkT.mz(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cZk - (duration % PushDialogVideoView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hkT = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void mz(int i2) {
                int duration;
                if (PushDialogVideoView.this.dpn != null && (duration = PushDialogVideoView.this.dpn.getDuration()) > 0 && PushDialogVideoView.this.ixq != null) {
                    PushDialogVideoView.this.ixq.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iye = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void ceX() {
                PushDialogVideoView.this.cKK.startLoading();
                PushDialogVideoView.this.hiu.setVisibility(0);
                PushDialogVideoView.this.hit.setVisibility(8);
                PushDialogVideoView.this.ixt.setVisibility(8);
                PushDialogVideoView.this.eGT.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hiT);
                e.iK().postDelayed(PushDialogVideoView.this.hiT, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.af(context) - l.g(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dpn = (QuickVideoView) findViewById(R.id.videoView);
        this.cKK = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cKK.setLoadingAnimationListener(this.eEm);
        this.ixq = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.ixq.setMax(this.mWidth);
        this.ixq.setProgress(0);
        this.hik = findViewById(R.id.black_mask);
        this.eGT = findViewById(R.id.layout_error);
        this.hit = (ImageView) findViewById(R.id.img_play);
        this.ixt = (TextView) findViewById(R.id.txt_replay);
        this.ekB = (TextView) findViewById(R.id.push_dialog_video_time);
        this.hiu = (TbImageView) findViewById(R.id.video_thumbnail);
        this.ifX = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.hiu.setDefaultErrorResource(0);
        this.hiu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hiP = new CallStateReceiver();
        this.hiP.register(context);
        this.eGT.setOnClickListener(this);
        this.ixt.setOnClickListener(this);
        this.ifX.setOnPlayClickListener(this);
        this.ifX.setFreeClickListener(this);
        setOnClickListener(this);
        this.dpn.setOnPreparedListener(this.cUq);
        this.dpn.setOnCompletionListener(this.cUp);
        this.dpn.setOnErrorListener(this.hiS);
        this.dpn.setOnSeekCompleteListener(this.cUt);
        this.dpn.setOnSurfaceDestroyedListener(this.cKT);
        this.dpn.setOnRecoveryCallback(this.iye);
        onChangeSkinType();
    }

    public void onPause() {
        if (pC()) {
            this.ifM = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.ifM = false;
        } else {
            this.ifM = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.ifM) {
            bMd();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hiY);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.iFF = fVar;
        this.ekB.setText(aq.it(this.iFF.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bXa = str;
        this.bXN = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dpn.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baa() {
        if (this.dpn != null && this.dhY != null) {
            if (this.ixW) {
                this.dpn.start();
                this.ixW = false;
            }
            e.iK().removeCallbacks(this.SR);
            e.iK().postDelayed(this.SR, 20L);
            e.iK().removeCallbacks(this.hiT);
            if (this.dpn.cfo()) {
                this.currentState = 1;
                this.dpn.setRecoveryState(1);
            }
            if (this.dhY != null) {
                this.mStartPosition = y.cfS().Dz(this.bXa);
                if (this.mStartPosition != 0) {
                    if (this.dpn != null) {
                        this.dpn.zc(this.mStartPosition);
                    } else {
                        this.dhY.seekTo(this.mStartPosition);
                    }
                    if (!this.ixV) {
                        showProgress();
                        e.iK().removeCallbacks(this.SR);
                    }
                    this.ixQ = true;
                }
            }
        }
    }

    public void caU() {
        if (!j.kc()) {
            l.E(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dpn.isPlaying()) {
            pausePlay();
        } else if (this.SJ) {
            bMd();
        } else {
            ceL();
        }
    }

    public void setPauseState() {
        this.cKK.cfO();
        this.hit.setVisibility(0);
        this.ixt.setVisibility(8);
        this.currentState = 2;
        this.dpn.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.ixR) {
            dT(str, str2);
        } else {
            ct(str, str2);
        }
        if (aVar != null) {
            aVar.qh(z);
        }
    }

    public void ct(String str, String str2) {
        ceM();
        this.ixW = true;
        this.currentState = 0;
        this.dpn.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dpn.setVideoPath(str, str2);
        this.cKK.startLoading();
        this.hiu.setVisibility(0);
        this.hit.setVisibility(8);
        this.ixt.setVisibility(8);
        this.eGT.setVisibility(8);
        e.iK().removeCallbacks(this.hiT);
        e.iK().postDelayed(this.hiT, 60000L);
    }

    public void dT(String str, String str2) {
        ceM();
        this.ixW = true;
        this.currentState = 0;
        this.dpn.setRecoveryState(0);
        this.cKK.startLoading();
        this.hiu.setVisibility(0);
        this.hit.setVisibility(8);
        this.ixt.setVisibility(8);
        this.eGT.setVisibility(8);
        e.iK().removeCallbacks(this.hiT);
        e.iK().postDelayed(this.hiT, 60000L);
    }

    public void bMd() {
        this.currentState = 1;
        this.dpn.setRecoveryState(1);
        this.dpn.start();
        this.hiu.setVisibility(8);
        this.hik.setVisibility(8);
        this.cKK.cfO();
        showProgress();
        this.hit.setVisibility(8);
        this.ixt.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kc() && this.ixU && !StringUtils.isNull(this.bXa) && !StringUtils.isNull(this.bXN)) {
            this.ixU = false;
            this.ixV = true;
            ct(this.bXa, this.bXN);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dpn != null) {
            this.dpn.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dpn.isPlaying() && this.ixP) {
            ceK();
        }
        this.dpn.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dpn.isPlaying() && this.ixP) {
            ceK();
        }
        this.currentState = 5;
        this.dpn.setRecoveryState(5);
        e.iK().removeCallbacks(this.SR);
        e.iK().removeCallbacks(this.hiT);
        this.dpn.stopPlayback();
        this.SJ = false;
        this.ixW = false;
        this.mStartPosition = 0;
        bzb();
    }

    public void ceK() {
        y.cfS().bi(this.bXa, this.dpn.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
        this.hik.setVisibility(0);
        this.hit.setVisibility(0);
        this.ixt.setVisibility(8);
        this.cKK.cfO();
        this.ixq.setVisibility(8);
        this.eGT.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.hiu.setVisibility(z ? 0 : 8);
    }

    public void bzb() {
        qc(true);
    }

    public boolean pC() {
        if (this.dpn == null) {
            return false;
        }
        return this.dpn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dpn == null) {
            return 0;
        }
        return this.dpn.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dpn != null) {
            this.ixq.setVisibility(0);
            this.cZk = ((this.dpn.getDuration() / 200) / 50) * 50;
            if (this.cZk < 50) {
                this.cZk = 50;
            } else if (this.cZk > 500) {
                this.cZk = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cZk - (this.dpn.getCurrentPosition() % this.cZk));
        }
    }

    private void ceL() {
        a(this.bXa, this.bXN, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        ceM();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.ixR = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.ke() && !this.igg && !com.baidu.tieba.video.g.cuO().cuP()) {
            this.ifX.setVisibility(0);
            this.ifX.setData(this.iFF.getDuration(), this.iFF.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void ceM() {
        if (j.ke()) {
            com.baidu.tieba.video.g.cuO().eq(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.hiu.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGT) {
            ceL();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 2).bT("tid", this.bXN));
            caU();
        } else if (view == this.ixt) {
            ct(this.bXa, this.bXN);
        } else if (view == this.ifX.getTvPlay()) {
            this.igg = true;
            this.ifX.setVisibility(8);
            ct(this.bXa, this.bXN);
        } else if (view == this.ifX.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.iK().removeCallbacks(this.SR);
        e.iK().removeCallbacks(this.hiT);
        e.iK().removeCallbacks(this.iyc);
        this.mHandler.removeMessages(1);
        this.hiP.unregister(getContext());
    }
}
