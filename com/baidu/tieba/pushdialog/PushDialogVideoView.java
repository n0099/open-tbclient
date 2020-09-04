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
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.j;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video.g;
/* loaded from: classes15.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private Runnable ZA;
    private boolean Zu;
    private TbImageView akQ;
    private String ala;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnCompletionListener dLN;
    private CyberPlayerManager.OnSeekCompleteListener dLQ;
    private TbCyberVideoView fDP;
    private m fcf;
    private TbCyberVideoView.a fcn;
    private int fph;
    private TextView gSN;
    private VideoLoadingProgressView.a hjB;
    private View hmp;
    private View jPR;
    private Runnable jQA;
    private CustomMessageListener jQF;
    private ImageView jQa;
    private CallStateReceiver jQw;
    private CyberPlayerManager.OnErrorListener jQz;
    private VideoControllerView.b jSz;
    private boolean kUN;
    private PbVideoWifiTipLayout kUY;
    private boolean kVh;
    private boolean lrW;
    private boolean lrX;
    private boolean lrY;
    private ProgressBar lrw;
    private TextView lrz;
    private boolean lsb;
    private boolean lsc;
    private boolean lsd;
    private Runnable lsj;
    private j lyI;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes15.dex */
    public interface a {
        void vd(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fph = 50;
        this.mSkinType = 3;
        this.Zu = false;
        this.mStartPosition = 0;
        this.lrW = true;
        this.lrX = false;
        this.lrY = false;
        this.kUN = false;
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fcf.dkb();
            }
        };
        this.hjB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cbF();
            }
        };
        this.ZA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDP.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Zu = true;
                    PushDialogVideoView.this.jPR.setVisibility(8);
                    PushDialogVideoView.this.hmp.setVisibility(8);
                    PushDialogVideoView.this.fcf.dkc();
                    PushDialogVideoView.this.akQ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mS().postDelayed(PushDialogVideoView.this.ZA, 20L);
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.Zu = false;
                PushDialogVideoView.this.lsd = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jPR.setVisibility(0);
                PushDialogVideoView.this.lrw.setVisibility(8);
                PushDialogVideoView.this.lrw.setProgress(PushDialogVideoView.this.lrw.getMax());
                if (PushDialogVideoView.this.fDP == null || PushDialogVideoView.this.fDP.getDuration() > 150000) {
                    PushDialogVideoView.this.uY(false);
                } else {
                    PushDialogVideoView.this.lrz.setVisibility(0);
                }
                n.dkg().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fDP != null && PushDialogVideoView.this.fDP.getDuration() <= 150000) {
                    PushDialogVideoView.this.fx(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ala);
                }
            }
        };
        this.jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hmp.setVisibility(0);
                PushDialogVideoView.this.fcf.dkd();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lsb = true;
                }
                PushDialogVideoView.this.lsd = false;
                return true;
            }
        };
        this.jQA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hmp.setVisibility(0);
                PushDialogVideoView.this.fcf.dkd();
            }
        };
        this.dLQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lrX) {
                    e.mS().postDelayed(PushDialogVideoView.this.lsj, 200L);
                }
            }
        };
        this.lsj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDP == null || !PushDialogVideoView.this.lrX) {
                    e.mS().postDelayed(PushDialogVideoView.this.ZA, 200L);
                    PushDialogVideoView.this.lrX = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fDP.getCurrentPosition()) {
                    PushDialogVideoView.this.lrX = false;
                    e.mS().postDelayed(PushDialogVideoView.this.ZA, 20L);
                } else {
                    e.mS().postDelayed(PushDialogVideoView.this.lsj, 200L);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Zu = false;
                PushDialogVideoView.this.lsd = false;
                e.mS().removeCallbacks(PushDialogVideoView.this.ZA);
                e.mS().removeCallbacks(PushDialogVideoView.this.jQA);
            }
        };
        this.jQF = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aHX();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fDP != null && PushDialogVideoView.this.fDP.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fDP.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fDP.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jSz != null) {
                                PushDialogVideoView.this.jSz.se(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fph - (duration % PushDialogVideoView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jSz = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void se(int i) {
                int duration;
                if (PushDialogVideoView.this.fDP != null && (duration = PushDialogVideoView.this.fDP.getDuration()) > 0 && PushDialogVideoView.this.lrw != null) {
                    PushDialogVideoView.this.lrw.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fph = 50;
        this.mSkinType = 3;
        this.Zu = false;
        this.mStartPosition = 0;
        this.lrW = true;
        this.lrX = false;
        this.lrY = false;
        this.kUN = false;
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fcf.dkb();
            }
        };
        this.hjB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cbF();
            }
        };
        this.ZA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDP.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Zu = true;
                    PushDialogVideoView.this.jPR.setVisibility(8);
                    PushDialogVideoView.this.hmp.setVisibility(8);
                    PushDialogVideoView.this.fcf.dkc();
                    PushDialogVideoView.this.akQ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mS().postDelayed(PushDialogVideoView.this.ZA, 20L);
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.Zu = false;
                PushDialogVideoView.this.lsd = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jPR.setVisibility(0);
                PushDialogVideoView.this.lrw.setVisibility(8);
                PushDialogVideoView.this.lrw.setProgress(PushDialogVideoView.this.lrw.getMax());
                if (PushDialogVideoView.this.fDP == null || PushDialogVideoView.this.fDP.getDuration() > 150000) {
                    PushDialogVideoView.this.uY(false);
                } else {
                    PushDialogVideoView.this.lrz.setVisibility(0);
                }
                n.dkg().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fDP != null && PushDialogVideoView.this.fDP.getDuration() <= 150000) {
                    PushDialogVideoView.this.fx(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ala);
                }
            }
        };
        this.jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hmp.setVisibility(0);
                PushDialogVideoView.this.fcf.dkd();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lsb = true;
                }
                PushDialogVideoView.this.lsd = false;
                return true;
            }
        };
        this.jQA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hmp.setVisibility(0);
                PushDialogVideoView.this.fcf.dkd();
            }
        };
        this.dLQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lrX) {
                    e.mS().postDelayed(PushDialogVideoView.this.lsj, 200L);
                }
            }
        };
        this.lsj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDP == null || !PushDialogVideoView.this.lrX) {
                    e.mS().postDelayed(PushDialogVideoView.this.ZA, 200L);
                    PushDialogVideoView.this.lrX = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fDP.getCurrentPosition()) {
                    PushDialogVideoView.this.lrX = false;
                    e.mS().postDelayed(PushDialogVideoView.this.ZA, 20L);
                } else {
                    e.mS().postDelayed(PushDialogVideoView.this.lsj, 200L);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Zu = false;
                PushDialogVideoView.this.lsd = false;
                e.mS().removeCallbacks(PushDialogVideoView.this.ZA);
                e.mS().removeCallbacks(PushDialogVideoView.this.jQA);
            }
        };
        this.jQF = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aHX();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fDP != null && PushDialogVideoView.this.fDP.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fDP.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fDP.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jSz != null) {
                                PushDialogVideoView.this.jSz.se(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fph - (duration % PushDialogVideoView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jSz = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void se(int i) {
                int duration;
                if (PushDialogVideoView.this.fDP != null && (duration = PushDialogVideoView.this.fDP.getDuration()) > 0 && PushDialogVideoView.this.lrw != null) {
                    PushDialogVideoView.this.lrw.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fph = 50;
        this.mSkinType = 3;
        this.Zu = false;
        this.mStartPosition = 0;
        this.lrW = true;
        this.lrX = false;
        this.lrY = false;
        this.kUN = false;
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fcf.dkb();
            }
        };
        this.hjB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cbF();
            }
        };
        this.ZA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDP.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Zu = true;
                    PushDialogVideoView.this.jPR.setVisibility(8);
                    PushDialogVideoView.this.hmp.setVisibility(8);
                    PushDialogVideoView.this.fcf.dkc();
                    PushDialogVideoView.this.akQ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mS().postDelayed(PushDialogVideoView.this.ZA, 20L);
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.Zu = false;
                PushDialogVideoView.this.lsd = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jPR.setVisibility(0);
                PushDialogVideoView.this.lrw.setVisibility(8);
                PushDialogVideoView.this.lrw.setProgress(PushDialogVideoView.this.lrw.getMax());
                if (PushDialogVideoView.this.fDP == null || PushDialogVideoView.this.fDP.getDuration() > 150000) {
                    PushDialogVideoView.this.uY(false);
                } else {
                    PushDialogVideoView.this.lrz.setVisibility(0);
                }
                n.dkg().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fDP != null && PushDialogVideoView.this.fDP.getDuration() <= 150000) {
                    PushDialogVideoView.this.fx(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ala);
                }
            }
        };
        this.jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.hmp.setVisibility(0);
                PushDialogVideoView.this.fcf.dkd();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lsb = true;
                }
                PushDialogVideoView.this.lsd = false;
                return true;
            }
        };
        this.jQA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hmp.setVisibility(0);
                PushDialogVideoView.this.fcf.dkd();
            }
        };
        this.dLQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lrX) {
                    e.mS().postDelayed(PushDialogVideoView.this.lsj, 200L);
                }
            }
        };
        this.lsj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDP == null || !PushDialogVideoView.this.lrX) {
                    e.mS().postDelayed(PushDialogVideoView.this.ZA, 200L);
                    PushDialogVideoView.this.lrX = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fDP.getCurrentPosition()) {
                    PushDialogVideoView.this.lrX = false;
                    e.mS().postDelayed(PushDialogVideoView.this.ZA, 20L);
                } else {
                    e.mS().postDelayed(PushDialogVideoView.this.lsj, 200L);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Zu = false;
                PushDialogVideoView.this.lsd = false;
                e.mS().removeCallbacks(PushDialogVideoView.this.ZA);
                e.mS().removeCallbacks(PushDialogVideoView.this.jQA);
            }
        };
        this.jQF = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aHX();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fDP != null && PushDialogVideoView.this.fDP.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fDP.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fDP.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jSz != null) {
                                PushDialogVideoView.this.jSz.se(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fph - (duration % PushDialogVideoView.this.fph));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jSz = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void se(int i2) {
                int duration;
                if (PushDialogVideoView.this.fDP != null && (duration = PushDialogVideoView.this.fDP.getDuration()) > 0 && PushDialogVideoView.this.lrw != null) {
                    PushDialogVideoView.this.lrw.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fDP = (TbCyberVideoView) findViewById(R.id.videoView);
        this.fDP.setPlayMode("2");
        this.fDP.setStageType(null);
        this.fcf = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fcf.setLoadingAnimationListener(this.hjB);
        this.lrw = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.lrw.setMax(this.mWidth);
        this.lrw.setProgress(0);
        this.jPR = findViewById(R.id.black_mask);
        this.hmp = findViewById(R.id.layout_error);
        this.jQa = (ImageView) findViewById(R.id.img_play);
        this.lrz = (TextView) findViewById(R.id.txt_replay);
        this.gSN = (TextView) findViewById(R.id.push_dialog_video_time);
        this.akQ = (TbImageView) findViewById(R.id.video_thumbnail);
        this.kUY = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.akQ.setDefaultErrorResource(0);
        this.akQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jQw = new CallStateReceiver();
        this.jQw.register(context);
        this.hmp.setOnClickListener(this);
        this.lrz.setOnClickListener(this);
        this.kUY.setOnPlayClickListener(this);
        this.kUY.setFreeClickListener(this);
        setOnClickListener(this);
        this.fDP.setOnPreparedListener(this.dLL);
        this.fDP.setOnCompletionListener(this.dLN);
        this.fDP.setOnErrorListener(this.jQz);
        this.fDP.setOnSeekCompleteListener(this.dLQ);
        this.fDP.setOnSurfaceDestroyedListener(this.fcn);
        onChangeSkinType();
    }

    public void onPause() {
        if (rF()) {
            this.kUN = true;
            aHX();
            return;
        }
        this.kUN = false;
        aHX();
    }

    public void onResume() {
        if (this.kUN) {
            aHY();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jQF);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.lyI = jVar;
        this.gSN.setText(at.stringForVideoTime(this.lyI.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ala = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.fDP.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.fDP != null) {
            if (this.lsd) {
                this.fDP.start();
                this.lsd = false;
            }
            e.mS().removeCallbacks(this.ZA);
            e.mS().postDelayed(this.ZA, 20L);
            e.mS().removeCallbacks(this.jQA);
            this.mStartPosition = n.dkg().OF(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.fDP.seekTo(this.mStartPosition);
                if (!this.lsc) {
                    showProgress();
                    e.mS().removeCallbacks(this.ZA);
                }
                this.lrX = true;
            }
        }
    }

    public void ddy() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fDP.isPlaying()) {
            aHX();
        } else if (this.Zu) {
            aHY();
        } else {
            djF();
        }
    }

    public void setPauseState() {
        this.fcf.dkd();
        this.jQa.setVisibility(0);
        this.lrz.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.lrY) {
            fy(str, str2);
        } else {
            fx(str, str2);
        }
        if (aVar != null) {
            aVar.vd(z);
        }
    }

    public void fx(String str, String str2) {
        djG();
        this.lsd = true;
        setVideoUrl(str, str2);
        this.fDP.setVideoPath(str, str2);
        this.fcf.startLoading();
        this.akQ.setVisibility(0);
        this.jQa.setVisibility(8);
        this.lrz.setVisibility(8);
        this.hmp.setVisibility(8);
        e.mS().removeCallbacks(this.jQA);
        e.mS().postDelayed(this.jQA, 60000L);
    }

    public void fy(String str, String str2) {
        djG();
        this.lsd = true;
        this.fcf.startLoading();
        this.akQ.setVisibility(0);
        this.jQa.setVisibility(8);
        this.lrz.setVisibility(8);
        this.hmp.setVisibility(8);
        e.mS().removeCallbacks(this.jQA);
        e.mS().postDelayed(this.jQA, 60000L);
    }

    public void aHY() {
        this.fDP.start();
        this.akQ.setVisibility(8);
        this.jPR.setVisibility(8);
        this.fcf.dkd();
        showProgress();
        this.jQa.setVisibility(8);
        this.lrz.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lsb && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ala)) {
            this.lsb = false;
            this.lsc = true;
            fx(this.mVideoUrl, this.ala);
        }
    }

    public void aHX() {
        if (this.fDP.isPlaying() && this.lrW) {
            djE();
        }
        this.fDP.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fDP.isPlaying() && this.lrW) {
            djE();
        }
        e.mS().removeCallbacks(this.ZA);
        e.mS().removeCallbacks(this.jQA);
        this.fDP.stopPlayback();
        this.Zu = false;
        this.lsd = false;
        this.mStartPosition = 0;
        czv();
    }

    public void djE() {
        n.dkg().by(this.mVideoUrl, this.fDP.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(boolean z) {
        this.jPR.setVisibility(0);
        this.jQa.setVisibility(0);
        this.lrz.setVisibility(8);
        this.fcf.dkd();
        this.lrw.setVisibility(8);
        this.hmp.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.akQ.setVisibility(z ? 0 : 8);
    }

    public void czv() {
        uY(true);
    }

    public boolean rF() {
        if (this.fDP == null) {
            return false;
        }
        return this.fDP.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fDP == null) {
            return 0;
        }
        return this.fDP.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fDP != null) {
            this.lrw.setVisibility(0);
            this.fph = ((this.fDP.getDuration() / 200) / 50) * 50;
            if (this.fph < 50) {
                this.fph = 50;
            } else if (this.fph > 500) {
                this.fph = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fph - (this.fDP.getCurrentPosition() % this.fph));
        }
    }

    private void djF() {
        a(this.mVideoUrl, this.ala, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        djG();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.lrY = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kVh && !g.dBe().dBf()) {
            this.kUY.setVisibility(0);
            this.kUY.setData(this.lyI.getDuration(), this.lyI.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void djG() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dBe().fI(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.akQ.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hmp) {
            djF();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 2).dD("tid", this.ala));
            ddy();
        } else if (view == this.lrz) {
            fx(this.mVideoUrl, this.ala);
        } else if (view == this.kUY.getTvPlay()) {
            this.kVh = true;
            this.kUY.setVisibility(8);
            fx(this.mVideoUrl, this.ala);
        } else if (view == this.kUY.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mS().removeCallbacks(this.ZA);
        e.mS().removeCallbacks(this.jQA);
        e.mS().removeCallbacks(this.lsj);
        this.mHandler.removeMessages(1);
        this.jQw.unregister(getContext());
    }
}
