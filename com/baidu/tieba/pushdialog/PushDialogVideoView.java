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
    private String bWO;
    private String bWb;
    private x cJN;
    private QuickVideoView.b cJW;
    private g.a cTp;
    private g.f cTq;
    private g.InterfaceC0393g cTt;
    private int cXx;
    private int currentState;
    private g dgg;
    private QuickVideoView dnu;
    private VideoLoadingProgressView.a eCw;
    private View eFd;
    private TextView eiK;
    private ImageView hfG;
    private TbImageView hfH;
    private View hfx;
    private CallStateReceiver hgc;
    private g.b hgf;
    private Runnable hgg;
    private CustomMessageListener hgl;
    private VideoControllerView.b hih;
    private f iCj;
    private boolean icN;
    private PbVideoWifiTipLayout icY;
    private boolean idh;
    private boolean iuL;
    private boolean iuM;
    private boolean iuN;
    private boolean iuQ;
    private boolean iuR;
    private boolean iuS;
    private Runnable iuY;
    private ProgressBar ium;
    private TextView iup;
    private QuickVideoView.a iva;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void qd(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.cXx = 50;
        this.mSkinType = 3;
        this.SK = false;
        this.mStartPosition = 0;
        this.iuL = true;
        this.iuM = false;
        this.iuN = false;
        this.currentState = -1;
        this.icN = false;
        this.cTq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dgg = gVar;
                PushDialogVideoView.this.cJN.ceG();
            }
        };
        this.eCw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aZu();
            }
        };
        this.SS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnu.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SK = true;
                    PushDialogVideoView.this.hfx.setVisibility(8);
                    PushDialogVideoView.this.eFd.setVisibility(8);
                    PushDialogVideoView.this.cJN.ceH();
                    PushDialogVideoView.this.hfH.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.iuS = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hfx.setVisibility(0);
                PushDialogVideoView.this.ium.setVisibility(8);
                PushDialogVideoView.this.ium.setProgress(PushDialogVideoView.this.ium.getMax());
                if (PushDialogVideoView.this.dnu == null || PushDialogVideoView.this.dnu.getDuration() > 150000) {
                    PushDialogVideoView.this.pY(false);
                } else {
                    PushDialogVideoView.this.iup.setVisibility(0);
                }
                y.ceM().remove(PushDialogVideoView.this.bWb);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dnu.setRecoveryState(3);
                if (PushDialogVideoView.this.dnu != null && PushDialogVideoView.this.dnu.getDuration() <= 150000) {
                    PushDialogVideoView.this.cs(PushDialogVideoView.this.bWb, PushDialogVideoView.this.bWO);
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eFd.setVisibility(0);
                PushDialogVideoView.this.cJN.ceI();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dnu.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.iuQ = true;
                }
                PushDialogVideoView.this.iuS = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eFd.setVisibility(0);
                PushDialogVideoView.this.cJN.ceI();
            }
        };
        this.cTt = new g.InterfaceC0393g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iuM) {
                    e.iK().postDelayed(PushDialogVideoView.this.iuY, 200L);
                }
            }
        };
        this.iuY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnu == null || !PushDialogVideoView.this.iuM) {
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 200L);
                    PushDialogVideoView.this.iuM = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dnu.getCurrentPosition()) {
                    PushDialogVideoView.this.iuM = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iuY, 200L);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.iuS = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SS);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgg);
            }
        };
        this.hgl = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dnu != null && PushDialogVideoView.this.dnu.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dnu.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dnu.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hih != null) {
                                PushDialogVideoView.this.hih.mu(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cXx - (duration % PushDialogVideoView.this.cXx));
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
            public void mu(int i) {
                int duration;
                if (PushDialogVideoView.this.dnu != null && (duration = PushDialogVideoView.this.dnu.getDuration()) > 0 && PushDialogVideoView.this.ium != null) {
                    PushDialogVideoView.this.ium.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iva = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cdQ() {
                PushDialogVideoView.this.cJN.startLoading();
                PushDialogVideoView.this.hfH.setVisibility(0);
                PushDialogVideoView.this.hfG.setVisibility(8);
                PushDialogVideoView.this.iup.setVisibility(8);
                PushDialogVideoView.this.eFd.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgg);
                e.iK().postDelayed(PushDialogVideoView.this.hgg, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXx = 50;
        this.mSkinType = 3;
        this.SK = false;
        this.mStartPosition = 0;
        this.iuL = true;
        this.iuM = false;
        this.iuN = false;
        this.currentState = -1;
        this.icN = false;
        this.cTq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dgg = gVar;
                PushDialogVideoView.this.cJN.ceG();
            }
        };
        this.eCw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aZu();
            }
        };
        this.SS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnu.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SK = true;
                    PushDialogVideoView.this.hfx.setVisibility(8);
                    PushDialogVideoView.this.eFd.setVisibility(8);
                    PushDialogVideoView.this.cJN.ceH();
                    PushDialogVideoView.this.hfH.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.iuS = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hfx.setVisibility(0);
                PushDialogVideoView.this.ium.setVisibility(8);
                PushDialogVideoView.this.ium.setProgress(PushDialogVideoView.this.ium.getMax());
                if (PushDialogVideoView.this.dnu == null || PushDialogVideoView.this.dnu.getDuration() > 150000) {
                    PushDialogVideoView.this.pY(false);
                } else {
                    PushDialogVideoView.this.iup.setVisibility(0);
                }
                y.ceM().remove(PushDialogVideoView.this.bWb);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dnu.setRecoveryState(3);
                if (PushDialogVideoView.this.dnu != null && PushDialogVideoView.this.dnu.getDuration() <= 150000) {
                    PushDialogVideoView.this.cs(PushDialogVideoView.this.bWb, PushDialogVideoView.this.bWO);
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.eFd.setVisibility(0);
                PushDialogVideoView.this.cJN.ceI();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dnu.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.iuQ = true;
                }
                PushDialogVideoView.this.iuS = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eFd.setVisibility(0);
                PushDialogVideoView.this.cJN.ceI();
            }
        };
        this.cTt = new g.InterfaceC0393g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iuM) {
                    e.iK().postDelayed(PushDialogVideoView.this.iuY, 200L);
                }
            }
        };
        this.iuY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnu == null || !PushDialogVideoView.this.iuM) {
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 200L);
                    PushDialogVideoView.this.iuM = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dnu.getCurrentPosition()) {
                    PushDialogVideoView.this.iuM = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iuY, 200L);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.iuS = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SS);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgg);
            }
        };
        this.hgl = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dnu != null && PushDialogVideoView.this.dnu.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dnu.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dnu.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hih != null) {
                                PushDialogVideoView.this.hih.mu(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cXx - (duration % PushDialogVideoView.this.cXx));
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
            public void mu(int i) {
                int duration;
                if (PushDialogVideoView.this.dnu != null && (duration = PushDialogVideoView.this.dnu.getDuration()) > 0 && PushDialogVideoView.this.ium != null) {
                    PushDialogVideoView.this.ium.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iva = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cdQ() {
                PushDialogVideoView.this.cJN.startLoading();
                PushDialogVideoView.this.hfH.setVisibility(0);
                PushDialogVideoView.this.hfG.setVisibility(8);
                PushDialogVideoView.this.iup.setVisibility(8);
                PushDialogVideoView.this.eFd.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgg);
                e.iK().postDelayed(PushDialogVideoView.this.hgg, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXx = 50;
        this.mSkinType = 3;
        this.SK = false;
        this.mStartPosition = 0;
        this.iuL = true;
        this.iuM = false;
        this.iuN = false;
        this.currentState = -1;
        this.icN = false;
        this.cTq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.dgg = gVar;
                PushDialogVideoView.this.cJN.ceG();
            }
        };
        this.eCw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aZu();
            }
        };
        this.SS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnu.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.SK = true;
                    PushDialogVideoView.this.hfx.setVisibility(8);
                    PushDialogVideoView.this.eFd.setVisibility(8);
                    PushDialogVideoView.this.cJN.ceH();
                    PushDialogVideoView.this.hfH.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.iuS = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hfx.setVisibility(0);
                PushDialogVideoView.this.ium.setVisibility(8);
                PushDialogVideoView.this.ium.setProgress(PushDialogVideoView.this.ium.getMax());
                if (PushDialogVideoView.this.dnu == null || PushDialogVideoView.this.dnu.getDuration() > 150000) {
                    PushDialogVideoView.this.pY(false);
                } else {
                    PushDialogVideoView.this.iup.setVisibility(0);
                }
                y.ceM().remove(PushDialogVideoView.this.bWb);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dnu.setRecoveryState(3);
                if (PushDialogVideoView.this.dnu != null && PushDialogVideoView.this.dnu.getDuration() <= 150000) {
                    PushDialogVideoView.this.cs(PushDialogVideoView.this.bWb, PushDialogVideoView.this.bWO);
                }
            }
        };
        this.hgf = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.eFd.setVisibility(0);
                PushDialogVideoView.this.cJN.ceI();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dnu.setRecoveryState(4);
                if (!j.kc()) {
                    PushDialogVideoView.this.iuQ = true;
                }
                PushDialogVideoView.this.iuS = false;
                return true;
            }
        };
        this.hgg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.eFd.setVisibility(0);
                PushDialogVideoView.this.cJN.ceI();
            }
        };
        this.cTt = new g.InterfaceC0393g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iuM) {
                    e.iK().postDelayed(PushDialogVideoView.this.iuY, 200L);
                }
            }
        };
        this.iuY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dnu == null || !PushDialogVideoView.this.iuM) {
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 200L);
                    PushDialogVideoView.this.iuM = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dnu.getCurrentPosition()) {
                    PushDialogVideoView.this.iuM = false;
                    e.iK().postDelayed(PushDialogVideoView.this.SS, 20L);
                } else {
                    e.iK().postDelayed(PushDialogVideoView.this.iuY, 200L);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.SK = false;
                PushDialogVideoView.this.iuS = false;
                e.iK().removeCallbacks(PushDialogVideoView.this.SS);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgg);
            }
        };
        this.hgl = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dnu != null && PushDialogVideoView.this.dnu.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dnu.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dnu.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hih != null) {
                                PushDialogVideoView.this.hih.mu(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.cXx - (duration % PushDialogVideoView.this.cXx));
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
            public void mu(int i2) {
                int duration;
                if (PushDialogVideoView.this.dnu != null && (duration = PushDialogVideoView.this.dnu.getDuration()) > 0 && PushDialogVideoView.this.ium != null) {
                    PushDialogVideoView.this.ium.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iva = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cdQ() {
                PushDialogVideoView.this.cJN.startLoading();
                PushDialogVideoView.this.hfH.setVisibility(0);
                PushDialogVideoView.this.hfG.setVisibility(8);
                PushDialogVideoView.this.iup.setVisibility(8);
                PushDialogVideoView.this.eFd.setVisibility(8);
                e.iK().removeCallbacks(PushDialogVideoView.this.hgg);
                e.iK().postDelayed(PushDialogVideoView.this.hgg, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.af(context) - l.g(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dnu = (QuickVideoView) findViewById(R.id.videoView);
        this.cJN = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cJN.setLoadingAnimationListener(this.eCw);
        this.ium = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.ium.setMax(this.mWidth);
        this.ium.setProgress(0);
        this.hfx = findViewById(R.id.black_mask);
        this.eFd = findViewById(R.id.layout_error);
        this.hfG = (ImageView) findViewById(R.id.img_play);
        this.iup = (TextView) findViewById(R.id.txt_replay);
        this.eiK = (TextView) findViewById(R.id.push_dialog_video_time);
        this.hfH = (TbImageView) findViewById(R.id.video_thumbnail);
        this.icY = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.hfH.setDefaultErrorResource(0);
        this.hfH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hgc = new CallStateReceiver();
        this.hgc.register(context);
        this.eFd.setOnClickListener(this);
        this.iup.setOnClickListener(this);
        this.icY.setOnPlayClickListener(this);
        this.icY.setFreeClickListener(this);
        setOnClickListener(this);
        this.dnu.setOnPreparedListener(this.cTq);
        this.dnu.setOnCompletionListener(this.cTp);
        this.dnu.setOnErrorListener(this.hgf);
        this.dnu.setOnSeekCompleteListener(this.cTt);
        this.dnu.setOnSurfaceDestroyedListener(this.cJW);
        this.dnu.setOnRecoveryCallback(this.iva);
        onChangeSkinType();
    }

    public void onPause() {
        if (pB()) {
            this.icN = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.icN = false;
        } else {
            this.icN = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.icN) {
            bLc();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hgl);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.iCj = fVar;
        this.eiK.setText(aq.is(this.iCj.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bWb = str;
        this.bWO = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dnu.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        if (this.dnu != null && this.dgg != null) {
            if (this.iuS) {
                this.dnu.start();
                this.iuS = false;
            }
            e.iK().removeCallbacks(this.SS);
            e.iK().postDelayed(this.SS, 20L);
            e.iK().removeCallbacks(this.hgg);
            if (this.dnu.cei()) {
                this.currentState = 1;
                this.dnu.setRecoveryState(1);
            }
            if (this.dgg != null) {
                this.mStartPosition = y.ceM().CZ(this.bWb);
                if (this.mStartPosition != 0) {
                    if (this.dnu != null) {
                        this.dnu.yX(this.mStartPosition);
                    } else {
                        this.dgg.seekTo(this.mStartPosition);
                    }
                    if (!this.iuR) {
                        showProgress();
                        e.iK().removeCallbacks(this.SS);
                    }
                    this.iuM = true;
                }
            }
        }
    }

    public void bZP() {
        if (!j.kc()) {
            l.E(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dnu.isPlaying()) {
            pausePlay();
        } else if (this.SK) {
            bLc();
        } else {
            cdD();
        }
    }

    public void setPauseState() {
        this.cJN.ceI();
        this.hfG.setVisibility(0);
        this.iup.setVisibility(8);
        this.currentState = 2;
        this.dnu.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.iuN) {
            dR(str, str2);
        } else {
            cs(str, str2);
        }
        if (aVar != null) {
            aVar.qd(z);
        }
    }

    public void cs(String str, String str2) {
        cdE();
        this.iuS = true;
        this.currentState = 0;
        this.dnu.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dnu.setVideoPath(str, str2);
        this.cJN.startLoading();
        this.hfH.setVisibility(0);
        this.hfG.setVisibility(8);
        this.iup.setVisibility(8);
        this.eFd.setVisibility(8);
        e.iK().removeCallbacks(this.hgg);
        e.iK().postDelayed(this.hgg, 60000L);
    }

    public void dR(String str, String str2) {
        cdE();
        this.iuS = true;
        this.currentState = 0;
        this.dnu.setRecoveryState(0);
        this.cJN.startLoading();
        this.hfH.setVisibility(0);
        this.hfG.setVisibility(8);
        this.iup.setVisibility(8);
        this.eFd.setVisibility(8);
        e.iK().removeCallbacks(this.hgg);
        e.iK().postDelayed(this.hgg, 60000L);
    }

    public void bLc() {
        this.currentState = 1;
        this.dnu.setRecoveryState(1);
        this.dnu.start();
        this.hfH.setVisibility(8);
        this.hfx.setVisibility(8);
        this.cJN.ceI();
        showProgress();
        this.hfG.setVisibility(8);
        this.iup.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kc() && this.iuQ && !StringUtils.isNull(this.bWb) && !StringUtils.isNull(this.bWO)) {
            this.iuQ = false;
            this.iuR = true;
            cs(this.bWb, this.bWO);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dnu != null) {
            this.dnu.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dnu.isPlaying() && this.iuL) {
            cdC();
        }
        this.dnu.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dnu.isPlaying() && this.iuL) {
            cdC();
        }
        this.currentState = 5;
        this.dnu.setRecoveryState(5);
        e.iK().removeCallbacks(this.SS);
        e.iK().removeCallbacks(this.hgg);
        this.dnu.ceg();
        this.SK = false;
        this.iuS = false;
        this.mStartPosition = 0;
        bxZ();
    }

    public void cdC() {
        y.ceM().bg(this.bWb, this.dnu.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(boolean z) {
        this.hfx.setVisibility(0);
        this.hfG.setVisibility(0);
        this.iup.setVisibility(8);
        this.cJN.ceI();
        this.ium.setVisibility(8);
        this.eFd.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.hfH.setVisibility(z ? 0 : 8);
    }

    public void bxZ() {
        pY(true);
    }

    public boolean pB() {
        if (this.dnu == null) {
            return false;
        }
        return this.dnu.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dnu == null) {
            return 0;
        }
        return this.dnu.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dnu != null) {
            this.ium.setVisibility(0);
            this.cXx = ((this.dnu.getDuration() / 200) / 50) * 50;
            if (this.cXx < 50) {
                this.cXx = 50;
            } else if (this.cXx > 500) {
                this.cXx = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXx - (this.dnu.getCurrentPosition() % this.cXx));
        }
    }

    private void cdD() {
        a(this.bWb, this.bWO, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cdE();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.iuN = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.ke() && !this.idh && !com.baidu.tieba.video.g.ctE().ctF()) {
            this.icY.setVisibility(0);
            this.icY.setData(this.iCj.getDuration(), this.iCj.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void cdE() {
        if (j.ke()) {
            com.baidu.tieba.video.g.ctE().eo(getContext());
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
        if (view == this.eFd) {
            cdD();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").P("obj_locate", 2).bT("tid", this.bWO));
            bZP();
        } else if (view == this.iup) {
            cs(this.bWb, this.bWO);
        } else if (view == this.icY.getTvPlay()) {
            this.idh = true;
            this.icY.setVisibility(8);
            cs(this.bWb, this.bWO);
        } else if (view == this.icY.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.iK().removeCallbacks(this.hgg);
        e.iK().removeCallbacks(this.iuY);
        this.mHandler.removeMessages(1);
        this.hgc.unregister(getContext());
    }
}
