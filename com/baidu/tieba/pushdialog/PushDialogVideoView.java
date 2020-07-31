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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
    private boolean YM;
    private Runnable YS;
    private String ajJ;
    private TbImageView ajz;
    private CyberPlayerManager.OnSeekCompleteListener dCC;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnCompletionListener dCz;
    private TbCyberVideoView.a eRD;
    private m eRv;
    private int fdL;
    private TbCyberVideoView fsr;
    private TextView gGh;
    private VideoLoadingProgressView.a gWE;
    private View gZs;
    private CallStateReceiver jAU;
    private CyberPlayerManager.OnErrorListener jAX;
    private Runnable jAY;
    private View jAp;
    private ImageView jAy;
    private CustomMessageListener jBd;
    private VideoControllerView.b jCY;
    private boolean kEX;
    private PbVideoWifiTipLayout kFi;
    private boolean kFr;
    private ProgressBar laT;
    private TextView laW;
    private boolean lbA;
    private Runnable lbG;
    private boolean lbt;
    private boolean lbu;
    private boolean lbv;
    private boolean lby;
    private boolean lbz;
    private j lib;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes15.dex */
    public interface a {
        void up(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fdL = 50;
        this.mSkinType = 3;
        this.YM = false;
        this.mStartPosition = 0;
        this.lbt = true;
        this.lbu = false;
        this.lbv = false;
        this.kEX = false;
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.eRv.cYV();
            }
        };
        this.gWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bRs();
            }
        };
        this.YS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fsr.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.YM = true;
                    PushDialogVideoView.this.jAp.setVisibility(8);
                    PushDialogVideoView.this.gZs.setVisibility(8);
                    PushDialogVideoView.this.eRv.cYW();
                    PushDialogVideoView.this.ajz.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.lt().postDelayed(PushDialogVideoView.this.YS, 20L);
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.YM = false;
                PushDialogVideoView.this.lbA = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jAp.setVisibility(0);
                PushDialogVideoView.this.laT.setVisibility(8);
                PushDialogVideoView.this.laT.setProgress(PushDialogVideoView.this.laT.getMax());
                if (PushDialogVideoView.this.fsr == null || PushDialogVideoView.this.fsr.getDuration() > 150000) {
                    PushDialogVideoView.this.uk(false);
                } else {
                    PushDialogVideoView.this.laW.setVisibility(0);
                }
                n.cZa().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fsr != null && PushDialogVideoView.this.fsr.getDuration() <= 150000) {
                    PushDialogVideoView.this.ff(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ajJ);
                }
            }
        };
        this.jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.gZs.setVisibility(0);
                PushDialogVideoView.this.eRv.cYX();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lby = true;
                }
                PushDialogVideoView.this.lbA = false;
                return true;
            }
        };
        this.jAY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gZs.setVisibility(0);
                PushDialogVideoView.this.eRv.cYX();
            }
        };
        this.dCC = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lbu) {
                    e.lt().postDelayed(PushDialogVideoView.this.lbG, 200L);
                }
            }
        };
        this.lbG = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fsr == null || !PushDialogVideoView.this.lbu) {
                    e.lt().postDelayed(PushDialogVideoView.this.YS, 200L);
                    PushDialogVideoView.this.lbu = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fsr.getCurrentPosition()) {
                    PushDialogVideoView.this.lbu = false;
                    e.lt().postDelayed(PushDialogVideoView.this.YS, 20L);
                } else {
                    e.lt().postDelayed(PushDialogVideoView.this.lbG, 200L);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.YM = false;
                PushDialogVideoView.this.lbA = false;
                e.lt().removeCallbacks(PushDialogVideoView.this.YS);
                e.lt().removeCallbacks(PushDialogVideoView.this.jAY);
            }
        };
        this.jBd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.azN();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fsr != null && PushDialogVideoView.this.fsr.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fsr.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fsr.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jCY != null) {
                                PushDialogVideoView.this.jCY.pS(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fdL - (duration % PushDialogVideoView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jCY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pS(int i) {
                int duration;
                if (PushDialogVideoView.this.fsr != null && (duration = PushDialogVideoView.this.fsr.getDuration()) > 0 && PushDialogVideoView.this.laT != null) {
                    PushDialogVideoView.this.laT.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdL = 50;
        this.mSkinType = 3;
        this.YM = false;
        this.mStartPosition = 0;
        this.lbt = true;
        this.lbu = false;
        this.lbv = false;
        this.kEX = false;
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.eRv.cYV();
            }
        };
        this.gWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bRs();
            }
        };
        this.YS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fsr.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.YM = true;
                    PushDialogVideoView.this.jAp.setVisibility(8);
                    PushDialogVideoView.this.gZs.setVisibility(8);
                    PushDialogVideoView.this.eRv.cYW();
                    PushDialogVideoView.this.ajz.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.lt().postDelayed(PushDialogVideoView.this.YS, 20L);
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.YM = false;
                PushDialogVideoView.this.lbA = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jAp.setVisibility(0);
                PushDialogVideoView.this.laT.setVisibility(8);
                PushDialogVideoView.this.laT.setProgress(PushDialogVideoView.this.laT.getMax());
                if (PushDialogVideoView.this.fsr == null || PushDialogVideoView.this.fsr.getDuration() > 150000) {
                    PushDialogVideoView.this.uk(false);
                } else {
                    PushDialogVideoView.this.laW.setVisibility(0);
                }
                n.cZa().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fsr != null && PushDialogVideoView.this.fsr.getDuration() <= 150000) {
                    PushDialogVideoView.this.ff(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ajJ);
                }
            }
        };
        this.jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.gZs.setVisibility(0);
                PushDialogVideoView.this.eRv.cYX();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lby = true;
                }
                PushDialogVideoView.this.lbA = false;
                return true;
            }
        };
        this.jAY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gZs.setVisibility(0);
                PushDialogVideoView.this.eRv.cYX();
            }
        };
        this.dCC = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lbu) {
                    e.lt().postDelayed(PushDialogVideoView.this.lbG, 200L);
                }
            }
        };
        this.lbG = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fsr == null || !PushDialogVideoView.this.lbu) {
                    e.lt().postDelayed(PushDialogVideoView.this.YS, 200L);
                    PushDialogVideoView.this.lbu = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fsr.getCurrentPosition()) {
                    PushDialogVideoView.this.lbu = false;
                    e.lt().postDelayed(PushDialogVideoView.this.YS, 20L);
                } else {
                    e.lt().postDelayed(PushDialogVideoView.this.lbG, 200L);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.YM = false;
                PushDialogVideoView.this.lbA = false;
                e.lt().removeCallbacks(PushDialogVideoView.this.YS);
                e.lt().removeCallbacks(PushDialogVideoView.this.jAY);
            }
        };
        this.jBd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.azN();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fsr != null && PushDialogVideoView.this.fsr.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fsr.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fsr.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jCY != null) {
                                PushDialogVideoView.this.jCY.pS(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fdL - (duration % PushDialogVideoView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jCY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pS(int i) {
                int duration;
                if (PushDialogVideoView.this.fsr != null && (duration = PushDialogVideoView.this.fsr.getDuration()) > 0 && PushDialogVideoView.this.laT != null) {
                    PushDialogVideoView.this.laT.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdL = 50;
        this.mSkinType = 3;
        this.YM = false;
        this.mStartPosition = 0;
        this.lbt = true;
        this.lbu = false;
        this.lbv = false;
        this.kEX = false;
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.eRv.cYV();
            }
        };
        this.gWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bRs();
            }
        };
        this.YS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fsr.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.YM = true;
                    PushDialogVideoView.this.jAp.setVisibility(8);
                    PushDialogVideoView.this.gZs.setVisibility(8);
                    PushDialogVideoView.this.eRv.cYW();
                    PushDialogVideoView.this.ajz.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.lt().postDelayed(PushDialogVideoView.this.YS, 20L);
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.YM = false;
                PushDialogVideoView.this.lbA = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jAp.setVisibility(0);
                PushDialogVideoView.this.laT.setVisibility(8);
                PushDialogVideoView.this.laT.setProgress(PushDialogVideoView.this.laT.getMax());
                if (PushDialogVideoView.this.fsr == null || PushDialogVideoView.this.fsr.getDuration() > 150000) {
                    PushDialogVideoView.this.uk(false);
                } else {
                    PushDialogVideoView.this.laW.setVisibility(0);
                }
                n.cZa().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fsr != null && PushDialogVideoView.this.fsr.getDuration() <= 150000) {
                    PushDialogVideoView.this.ff(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.ajJ);
                }
            }
        };
        this.jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.gZs.setVisibility(0);
                PushDialogVideoView.this.eRv.cYX();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lby = true;
                }
                PushDialogVideoView.this.lbA = false;
                return true;
            }
        };
        this.jAY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.gZs.setVisibility(0);
                PushDialogVideoView.this.eRv.cYX();
            }
        };
        this.dCC = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lbu) {
                    e.lt().postDelayed(PushDialogVideoView.this.lbG, 200L);
                }
            }
        };
        this.lbG = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fsr == null || !PushDialogVideoView.this.lbu) {
                    e.lt().postDelayed(PushDialogVideoView.this.YS, 200L);
                    PushDialogVideoView.this.lbu = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fsr.getCurrentPosition()) {
                    PushDialogVideoView.this.lbu = false;
                    e.lt().postDelayed(PushDialogVideoView.this.YS, 20L);
                } else {
                    e.lt().postDelayed(PushDialogVideoView.this.lbG, 200L);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.YM = false;
                PushDialogVideoView.this.lbA = false;
                e.lt().removeCallbacks(PushDialogVideoView.this.YS);
                e.lt().removeCallbacks(PushDialogVideoView.this.jAY);
            }
        };
        this.jBd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.azN();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fsr != null && PushDialogVideoView.this.fsr.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fsr.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fsr.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jCY != null) {
                                PushDialogVideoView.this.jCY.pS(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fdL - (duration % PushDialogVideoView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jCY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pS(int i2) {
                int duration;
                if (PushDialogVideoView.this.fsr != null && (duration = PushDialogVideoView.this.fsr.getDuration()) > 0 && PushDialogVideoView.this.laT != null) {
                    PushDialogVideoView.this.laT.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fsr = (TbCyberVideoView) findViewById(R.id.videoView);
        this.fsr.setPlayMode("2");
        this.eRv = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eRv.setLoadingAnimationListener(this.gWE);
        this.laT = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.laT.setMax(this.mWidth);
        this.laT.setProgress(0);
        this.jAp = findViewById(R.id.black_mask);
        this.gZs = findViewById(R.id.layout_error);
        this.jAy = (ImageView) findViewById(R.id.img_play);
        this.laW = (TextView) findViewById(R.id.txt_replay);
        this.gGh = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ajz = (TbImageView) findViewById(R.id.video_thumbnail);
        this.kFi = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ajz.setDefaultErrorResource(0);
        this.ajz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jAU = new CallStateReceiver();
        this.jAU.register(context);
        this.gZs.setOnClickListener(this);
        this.laW.setOnClickListener(this);
        this.kFi.setOnPlayClickListener(this);
        this.kFi.setFreeClickListener(this);
        setOnClickListener(this);
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnErrorListener(this.jAX);
        this.fsr.setOnSeekCompleteListener(this.dCC);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        onChangeSkinType();
    }

    public void onPause() {
        if (qg()) {
            this.kEX = true;
            azN();
            return;
        }
        this.kEX = false;
        azN();
    }

    public void onResume() {
        if (this.kEX) {
            azO();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jBd);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.lib = jVar;
        this.gGh.setText(as.stringForVideoTime(this.lib.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ajJ = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.fsr.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRs() {
        if (this.fsr != null) {
            if (this.lbA) {
                this.fsr.start();
                this.lbA = false;
            }
            e.lt().removeCallbacks(this.YS);
            e.lt().postDelayed(this.YS, 20L);
            e.lt().removeCallbacks(this.jAY);
            this.mStartPosition = n.cZa().LL(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.fsr.seekTo(this.mStartPosition);
                if (!this.lbz) {
                    showProgress();
                    e.lt().removeCallbacks(this.YS);
                }
                this.lbu = true;
            }
        }
    }

    public void cSF() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fsr.isPlaying()) {
            azN();
        } else if (this.YM) {
            azO();
        } else {
            cYz();
        }
    }

    public void setPauseState() {
        this.eRv.cYX();
        this.jAy.setVisibility(0);
        this.laW.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.lbv) {
            fg(str, str2);
        } else {
            ff(str, str2);
        }
        if (aVar != null) {
            aVar.up(z);
        }
    }

    public void ff(String str, String str2) {
        cYA();
        this.lbA = true;
        setVideoUrl(str, str2);
        this.fsr.setVideoPath(str, str2);
        this.eRv.startLoading();
        this.ajz.setVisibility(0);
        this.jAy.setVisibility(8);
        this.laW.setVisibility(8);
        this.gZs.setVisibility(8);
        e.lt().removeCallbacks(this.jAY);
        e.lt().postDelayed(this.jAY, 60000L);
    }

    public void fg(String str, String str2) {
        cYA();
        this.lbA = true;
        this.eRv.startLoading();
        this.ajz.setVisibility(0);
        this.jAy.setVisibility(8);
        this.laW.setVisibility(8);
        this.gZs.setVisibility(8);
        e.lt().removeCallbacks(this.jAY);
        e.lt().postDelayed(this.jAY, 60000L);
    }

    public void azO() {
        this.fsr.start();
        this.ajz.setVisibility(8);
        this.jAp.setVisibility(8);
        this.eRv.cYX();
        showProgress();
        this.jAy.setVisibility(8);
        this.laW.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lby && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ajJ)) {
            this.lby = false;
            this.lbz = true;
            ff(this.mVideoUrl, this.ajJ);
        }
    }

    public void azN() {
        if (this.fsr.isPlaying() && this.lbt) {
            cYy();
        }
        this.fsr.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fsr.isPlaying() && this.lbt) {
            cYy();
        }
        e.lt().removeCallbacks(this.YS);
        e.lt().removeCallbacks(this.jAY);
        this.fsr.stopPlayback();
        this.YM = false;
        this.lbA = false;
        this.mStartPosition = 0;
        coB();
    }

    public void cYy() {
        n.cZa().bt(this.mVideoUrl, this.fsr.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(boolean z) {
        this.jAp.setVisibility(0);
        this.jAy.setVisibility(0);
        this.laW.setVisibility(8);
        this.eRv.cYX();
        this.laT.setVisibility(8);
        this.gZs.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ajz.setVisibility(z ? 0 : 8);
    }

    public void coB() {
        uk(true);
    }

    public boolean qg() {
        if (this.fsr == null) {
            return false;
        }
        return this.fsr.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fsr == null) {
            return 0;
        }
        return this.fsr.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fsr != null) {
            this.laT.setVisibility(0);
            this.fdL = ((this.fsr.getDuration() / 200) / 50) * 50;
            if (this.fdL < 50) {
                this.fdL = 50;
            } else if (this.fdL > 500) {
                this.fdL = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fdL - (this.fsr.getCurrentPosition() % this.fdL));
        }
    }

    private void cYz() {
        a(this.mVideoUrl, this.ajJ, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cYA();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.lbv = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kFr && !g.dpz().dpA()) {
            this.kFi.setVisibility(0);
            this.kFi.setData(this.lib.getDuration(), this.lib.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cYA() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dpz().fv(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.ajz.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gZs) {
            cYz();
        } else if (view == this) {
            TiebaStatic.log(new ap("c13199").ah("obj_locate", 2).dn("tid", this.ajJ));
            cSF();
        } else if (view == this.laW) {
            ff(this.mVideoUrl, this.ajJ);
        } else if (view == this.kFi.getTvPlay()) {
            this.kFr = true;
            this.kFi.setVisibility(8);
            ff(this.mVideoUrl, this.ajJ);
        } else if (view == this.kFi.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.lt().removeCallbacks(this.YS);
        e.lt().removeCallbacks(this.jAY);
        e.lt().removeCallbacks(this.lbG);
        this.mHandler.removeMessages(1);
        this.jAU.unregister(getContext());
    }
}
