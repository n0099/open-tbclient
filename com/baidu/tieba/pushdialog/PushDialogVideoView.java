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
    private String aBn;
    private QuickVideoView bKy;
    private String beV;
    private QuickVideoView.b blC;
    private x blt;
    private g.a bul;
    private g.f bum;
    private g.InterfaceC0287g bup;
    private int byt;
    private TextView cBk;
    private g cNR;
    private VideoLoadingProgressView.a cOd;
    private ImageView cQH;
    private View cQL;
    private int currentState;
    private TbImageView fhA;
    private boolean fhF;
    private CallStateReceiver fhW;
    private Runnable fhZ;
    private View fhr;
    private g.b fia;
    private Runnable fib;
    private CustomMessageListener fih;
    private VideoControllerView.b fkc;
    private f gBo;
    private boolean gdR;
    private PbVideoWifiTipLayout gec;
    private boolean gek;
    private ProgressBar guI;
    private TextView guL;
    private boolean gvg;
    private boolean gvh;
    private boolean gvi;
    private boolean gvl;
    private boolean gvm;
    private boolean gvn;
    private Runnable gvs;
    private QuickVideoView.a gvu;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void mw(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.byt = 50;
        this.mSkinType = 3;
        this.fhF = false;
        this.mStartPosition = 0;
        this.gvg = true;
        this.gvh = false;
        this.gvi = false;
        this.currentState = -1;
        this.gdR = false;
        this.bum = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cNR = gVar;
                PushDialogVideoView.this.blt.bqe();
            }
        };
        this.cOd = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.any();
            }
        };
        this.fhZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bKy.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fhF = true;
                    PushDialogVideoView.this.fhr.setVisibility(8);
                    PushDialogVideoView.this.cQL.setVisibility(8);
                    PushDialogVideoView.this.blt.bqf();
                    PushDialogVideoView.this.fhA.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fhZ, 20L);
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fhF = false;
                PushDialogVideoView.this.gvn = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.fhr.setVisibility(0);
                PushDialogVideoView.this.guI.setVisibility(8);
                PushDialogVideoView.this.guI.setProgress(PushDialogVideoView.this.guI.getMax());
                if (PushDialogVideoView.this.bKy == null || PushDialogVideoView.this.bKy.getDuration() > 150000) {
                    PushDialogVideoView.this.mq(false);
                } else {
                    PushDialogVideoView.this.guL.setVisibility(0);
                }
                y.bqk().remove(PushDialogVideoView.this.aBn);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bKy.setRecoveryState(3);
                if (PushDialogVideoView.this.bKy != null && PushDialogVideoView.this.bKy.getDuration() <= 150000) {
                    PushDialogVideoView.this.aW(PushDialogVideoView.this.aBn, PushDialogVideoView.this.beV);
                }
            }
        };
        this.fia = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cQL.setVisibility(0);
                PushDialogVideoView.this.blt.bqg();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bKy.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gvl = true;
                }
                PushDialogVideoView.this.gvn = false;
                return true;
            }
        };
        this.fib = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cQL.setVisibility(0);
                PushDialogVideoView.this.blt.bqg();
            }
        };
        this.bup = new g.InterfaceC0287g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0287g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gvh) {
                    e.jG().postDelayed(PushDialogVideoView.this.gvs, 200L);
                }
            }
        };
        this.gvs = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bKy == null || !PushDialogVideoView.this.gvh) {
                    e.jG().postDelayed(PushDialogVideoView.this.fhZ, 200L);
                    PushDialogVideoView.this.gvh = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bKy.getCurrentPosition()) {
                    PushDialogVideoView.this.gvh = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fhZ, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gvs, 200L);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fhF = false;
                PushDialogVideoView.this.gvn = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fhZ);
                e.jG().removeCallbacks(PushDialogVideoView.this.fib);
            }
        };
        this.fih = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bKy != null && PushDialogVideoView.this.bKy.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bKy.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bKy.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fkc != null) {
                                PushDialogVideoView.this.fkc.hu(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.byt - (duration % PushDialogVideoView.this.byt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fkc = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hu(int i) {
                int duration;
                if (PushDialogVideoView.this.bKy != null && (duration = PushDialogVideoView.this.bKy.getDuration()) > 0 && PushDialogVideoView.this.guI != null) {
                    PushDialogVideoView.this.guI.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gvu = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bpq() {
                PushDialogVideoView.this.blt.startLoading();
                PushDialogVideoView.this.fhA.setVisibility(0);
                PushDialogVideoView.this.cQH.setVisibility(8);
                PushDialogVideoView.this.guL.setVisibility(8);
                PushDialogVideoView.this.cQL.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fib);
                e.jG().postDelayed(PushDialogVideoView.this.fib, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.byt = 50;
        this.mSkinType = 3;
        this.fhF = false;
        this.mStartPosition = 0;
        this.gvg = true;
        this.gvh = false;
        this.gvi = false;
        this.currentState = -1;
        this.gdR = false;
        this.bum = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cNR = gVar;
                PushDialogVideoView.this.blt.bqe();
            }
        };
        this.cOd = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.any();
            }
        };
        this.fhZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bKy.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fhF = true;
                    PushDialogVideoView.this.fhr.setVisibility(8);
                    PushDialogVideoView.this.cQL.setVisibility(8);
                    PushDialogVideoView.this.blt.bqf();
                    PushDialogVideoView.this.fhA.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fhZ, 20L);
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fhF = false;
                PushDialogVideoView.this.gvn = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.fhr.setVisibility(0);
                PushDialogVideoView.this.guI.setVisibility(8);
                PushDialogVideoView.this.guI.setProgress(PushDialogVideoView.this.guI.getMax());
                if (PushDialogVideoView.this.bKy == null || PushDialogVideoView.this.bKy.getDuration() > 150000) {
                    PushDialogVideoView.this.mq(false);
                } else {
                    PushDialogVideoView.this.guL.setVisibility(0);
                }
                y.bqk().remove(PushDialogVideoView.this.aBn);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bKy.setRecoveryState(3);
                if (PushDialogVideoView.this.bKy != null && PushDialogVideoView.this.bKy.getDuration() <= 150000) {
                    PushDialogVideoView.this.aW(PushDialogVideoView.this.aBn, PushDialogVideoView.this.beV);
                }
            }
        };
        this.fia = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cQL.setVisibility(0);
                PushDialogVideoView.this.blt.bqg();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bKy.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gvl = true;
                }
                PushDialogVideoView.this.gvn = false;
                return true;
            }
        };
        this.fib = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cQL.setVisibility(0);
                PushDialogVideoView.this.blt.bqg();
            }
        };
        this.bup = new g.InterfaceC0287g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0287g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gvh) {
                    e.jG().postDelayed(PushDialogVideoView.this.gvs, 200L);
                }
            }
        };
        this.gvs = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bKy == null || !PushDialogVideoView.this.gvh) {
                    e.jG().postDelayed(PushDialogVideoView.this.fhZ, 200L);
                    PushDialogVideoView.this.gvh = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bKy.getCurrentPosition()) {
                    PushDialogVideoView.this.gvh = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fhZ, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gvs, 200L);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fhF = false;
                PushDialogVideoView.this.gvn = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fhZ);
                e.jG().removeCallbacks(PushDialogVideoView.this.fib);
            }
        };
        this.fih = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bKy != null && PushDialogVideoView.this.bKy.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bKy.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bKy.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fkc != null) {
                                PushDialogVideoView.this.fkc.hu(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.byt - (duration % PushDialogVideoView.this.byt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fkc = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hu(int i) {
                int duration;
                if (PushDialogVideoView.this.bKy != null && (duration = PushDialogVideoView.this.bKy.getDuration()) > 0 && PushDialogVideoView.this.guI != null) {
                    PushDialogVideoView.this.guI.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gvu = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bpq() {
                PushDialogVideoView.this.blt.startLoading();
                PushDialogVideoView.this.fhA.setVisibility(0);
                PushDialogVideoView.this.cQH.setVisibility(8);
                PushDialogVideoView.this.guL.setVisibility(8);
                PushDialogVideoView.this.cQL.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fib);
                e.jG().postDelayed(PushDialogVideoView.this.fib, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.byt = 50;
        this.mSkinType = 3;
        this.fhF = false;
        this.mStartPosition = 0;
        this.gvg = true;
        this.gvh = false;
        this.gvi = false;
        this.currentState = -1;
        this.gdR = false;
        this.bum = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cNR = gVar;
                PushDialogVideoView.this.blt.bqe();
            }
        };
        this.cOd = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.any();
            }
        };
        this.fhZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bKy.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.fhF = true;
                    PushDialogVideoView.this.fhr.setVisibility(8);
                    PushDialogVideoView.this.cQL.setVisibility(8);
                    PushDialogVideoView.this.blt.bqf();
                    PushDialogVideoView.this.fhA.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jG().postDelayed(PushDialogVideoView.this.fhZ, 20L);
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.fhF = false;
                PushDialogVideoView.this.gvn = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.fhr.setVisibility(0);
                PushDialogVideoView.this.guI.setVisibility(8);
                PushDialogVideoView.this.guI.setProgress(PushDialogVideoView.this.guI.getMax());
                if (PushDialogVideoView.this.bKy == null || PushDialogVideoView.this.bKy.getDuration() > 150000) {
                    PushDialogVideoView.this.mq(false);
                } else {
                    PushDialogVideoView.this.guL.setVisibility(0);
                }
                y.bqk().remove(PushDialogVideoView.this.aBn);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bKy.setRecoveryState(3);
                if (PushDialogVideoView.this.bKy != null && PushDialogVideoView.this.bKy.getDuration() <= 150000) {
                    PushDialogVideoView.this.aW(PushDialogVideoView.this.aBn, PushDialogVideoView.this.beV);
                }
            }
        };
        this.fia = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.cQL.setVisibility(0);
                PushDialogVideoView.this.blt.bqg();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bKy.setRecoveryState(4);
                if (!j.kV()) {
                    PushDialogVideoView.this.gvl = true;
                }
                PushDialogVideoView.this.gvn = false;
                return true;
            }
        };
        this.fib = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cQL.setVisibility(0);
                PushDialogVideoView.this.blt.bqg();
            }
        };
        this.bup = new g.InterfaceC0287g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0287g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gvh) {
                    e.jG().postDelayed(PushDialogVideoView.this.gvs, 200L);
                }
            }
        };
        this.gvs = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bKy == null || !PushDialogVideoView.this.gvh) {
                    e.jG().postDelayed(PushDialogVideoView.this.fhZ, 200L);
                    PushDialogVideoView.this.gvh = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bKy.getCurrentPosition()) {
                    PushDialogVideoView.this.gvh = false;
                    e.jG().postDelayed(PushDialogVideoView.this.fhZ, 20L);
                } else {
                    e.jG().postDelayed(PushDialogVideoView.this.gvs, 200L);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.fhF = false;
                PushDialogVideoView.this.gvn = false;
                e.jG().removeCallbacks(PushDialogVideoView.this.fhZ);
                e.jG().removeCallbacks(PushDialogVideoView.this.fib);
            }
        };
        this.fih = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bKy != null && PushDialogVideoView.this.bKy.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bKy.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bKy.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.fkc != null) {
                                PushDialogVideoView.this.fkc.hu(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.byt - (duration % PushDialogVideoView.this.byt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fkc = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void hu(int i2) {
                int duration;
                if (PushDialogVideoView.this.bKy != null && (duration = PushDialogVideoView.this.bKy.getDuration()) > 0 && PushDialogVideoView.this.guI != null) {
                    PushDialogVideoView.this.guI.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gvu = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bpq() {
                PushDialogVideoView.this.blt.startLoading();
                PushDialogVideoView.this.fhA.setVisibility(0);
                PushDialogVideoView.this.cQH.setVisibility(8);
                PushDialogVideoView.this.guL.setVisibility(8);
                PushDialogVideoView.this.cQL.setVisibility(8);
                e.jG().removeCallbacks(PushDialogVideoView.this.fib);
                e.jG().postDelayed(PushDialogVideoView.this.fib, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0200e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bKy = (QuickVideoView) findViewById(e.g.videoView);
        this.blt = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.blt.setLoadingAnimationListener(this.cOd);
        this.guI = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.guI.setMax(this.mWidth);
        this.guI.setProgress(0);
        this.fhr = findViewById(e.g.black_mask);
        this.cQL = findViewById(e.g.layout_error);
        this.cQH = (ImageView) findViewById(e.g.img_play);
        this.guL = (TextView) findViewById(e.g.txt_replay);
        this.cBk = (TextView) findViewById(e.g.push_dialog_video_time);
        this.fhA = (TbImageView) findViewById(e.g.video_thumbnail);
        this.gec = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.fhA.setDefaultErrorResource(0);
        this.fhA.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.fhW = new CallStateReceiver();
        this.fhW.register(context);
        this.cQL.setOnClickListener(this);
        this.guL.setOnClickListener(this);
        this.gec.setOnPlayClickListener(this);
        this.gec.setFreeClickListener(this);
        setOnClickListener(this);
        this.bKy.setOnPreparedListener(this.bum);
        this.bKy.setOnCompletionListener(this.bul);
        this.bKy.setOnErrorListener(this.fia);
        this.bKy.setOnSeekCompleteListener(this.bup);
        this.bKy.setOnSurfaceDestroyedListener(this.blC);
        this.bKy.setOnRecoveryCallback(this.gvu);
        onChangeSkinType();
    }

    public void onPause() {
        if (bpd()) {
            this.gdR = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.gdR = false;
        } else {
            this.gdR = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.gdR) {
            aXb();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.fih);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gBo = fVar;
        this.cBk.setText(ao.dH(this.gBo.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.aBn = str;
        this.beV = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bKy.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void any() {
        if (this.bKy != null && this.cNR != null) {
            if (this.gvn) {
                this.bKy.start();
                this.gvn = false;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fhZ, 20L);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
            if (this.bKy.bpG()) {
                this.currentState = 1;
                this.bKy.setRecoveryState(1);
            }
            if (this.cNR != null) {
                this.mStartPosition = y.bqk().tu(this.aBn);
                if (this.mStartPosition != 0) {
                    if (this.bKy != null) {
                        this.bKy.sU(this.mStartPosition);
                    } else {
                        this.cNR.seekTo(this.mStartPosition);
                    }
                    if (!this.gvm) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
                    }
                    this.gvh = true;
                }
            }
        }
    }

    public void blv() {
        if (!j.kV()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bKy.isPlaying()) {
            pausePlay();
        } else if (this.fhF) {
            aXb();
        } else {
            bpe();
        }
    }

    public void setPauseState() {
        this.blt.bqg();
        this.cQH.setVisibility(0);
        this.guL.setVisibility(8);
        this.currentState = 2;
        this.bKy.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gvi) {
            cn(str, str2);
        } else {
            aW(str, str2);
        }
        if (aVar != null) {
            aVar.mw(z);
        }
    }

    public void aW(String str, String str2) {
        bpf();
        this.gvn = true;
        this.currentState = 0;
        this.bKy.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bKy.setVideoPath(str, str2);
        this.blt.startLoading();
        this.fhA.setVisibility(0);
        this.cQH.setVisibility(8);
        this.guL.setVisibility(8);
        this.cQL.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fib, 60000L);
    }

    public void cn(String str, String str2) {
        bpf();
        this.gvn = true;
        this.currentState = 0;
        this.bKy.setRecoveryState(0);
        this.blt.startLoading();
        this.fhA.setVisibility(0);
        this.cQH.setVisibility(8);
        this.guL.setVisibility(8);
        this.cQL.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fib, 60000L);
    }

    public void aXb() {
        this.currentState = 1;
        this.bKy.setRecoveryState(1);
        this.bKy.start();
        this.fhA.setVisibility(8);
        this.fhr.setVisibility(8);
        this.blt.bqg();
        showProgress();
        this.cQH.setVisibility(8);
        this.guL.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kV() && this.gvl && !StringUtils.isNull(this.aBn) && !StringUtils.isNull(this.beV)) {
            this.gvl = false;
            this.gvm = true;
            aW(this.aBn, this.beV);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bKy != null) {
            this.bKy.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bKy.isPlaying() && this.gvg) {
            bpc();
        }
        this.bKy.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bKy.isPlaying() && this.gvg) {
            bpc();
        }
        this.currentState = 5;
        this.bKy.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        this.bKy.stopPlayback();
        this.fhF = false;
        this.gvn = false;
        this.mStartPosition = 0;
        aKf();
    }

    public void bpc() {
        y.bqk().aM(this.aBn, this.bKy.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        this.fhr.setVisibility(0);
        this.cQH.setVisibility(0);
        this.guL.setVisibility(8);
        this.blt.bqg();
        this.guI.setVisibility(8);
        this.cQL.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.fhA.setVisibility(z ? 0 : 8);
    }

    public void aKf() {
        mq(true);
    }

    public boolean bpd() {
        if (this.bKy == null) {
            return false;
        }
        return this.bKy.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bKy == null) {
            return 0;
        }
        return this.bKy.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bKy != null) {
            this.guI.setVisibility(0);
            this.byt = ((this.bKy.getDuration() / 200) / 50) * 50;
            if (this.byt < 50) {
                this.byt = 50;
            } else if (this.byt > 500) {
                this.byt = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.byt - (this.bKy.getCurrentPosition() % this.byt));
        }
    }

    private void bpe() {
        a(this.aBn, this.beV, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bpf();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gvi = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kX() && !this.gek && !com.baidu.tieba.video.g.bFM().bFN()) {
            this.gec.setVisibility(0);
            this.gec.setData(this.gBo.getDuration(), this.gBo.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bpf() {
        if (j.kX()) {
            com.baidu.tieba.video.g.bFM().cY(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.fhA.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cQL) {
            bpe();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").x("obj_locate", 2).ax("tid", this.beV));
            blv();
        } else if (view == this.guL) {
            aW(this.aBn, this.beV);
        } else if (view == this.gec.getTvPlay()) {
            this.gek = true;
            this.gec.setVisibility(8);
            aW(this.aBn, this.beV);
        } else if (view == this.gec.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvs);
        this.mHandler.removeMessages(1);
        this.fhW.unregister(getContext());
    }
}
