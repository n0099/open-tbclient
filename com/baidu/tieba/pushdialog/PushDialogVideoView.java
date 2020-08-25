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
    private boolean Zs;
    private Runnable Zy;
    private TbImageView akO;
    private String akY;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnCompletionListener dLJ;
    private CyberPlayerManager.OnSeekCompleteListener dLM;
    private TbCyberVideoView fDL;
    private m fcb;
    private TbCyberVideoView.a fcj;
    private int fpd;
    private TextView gSJ;
    private VideoLoadingProgressView.a hjx;
    private View hml;
    private View jPL;
    private ImageView jPU;
    private CallStateReceiver jQq;
    private CyberPlayerManager.OnErrorListener jQt;
    private Runnable jQu;
    private CustomMessageListener jQz;
    private VideoControllerView.b jSt;
    private boolean kUG;
    private PbVideoWifiTipLayout kUR;
    private boolean kVa;
    private boolean lrL;
    private boolean lrM;
    private boolean lrN;
    private boolean lrQ;
    private boolean lrR;
    private boolean lrS;
    private Runnable lrY;
    private ProgressBar lrl;
    private TextView lro;
    private j lyx;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes15.dex */
    public interface a {
        void vb(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fpd = 50;
        this.mSkinType = 3;
        this.Zs = false;
        this.mStartPosition = 0;
        this.lrL = true;
        this.lrM = false;
        this.lrN = false;
        this.kUG = false;
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fcb.djY();
            }
        };
        this.hjx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cbE();
            }
        };
        this.Zy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDL.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Zs = true;
                    PushDialogVideoView.this.jPL.setVisibility(8);
                    PushDialogVideoView.this.hml.setVisibility(8);
                    PushDialogVideoView.this.fcb.djZ();
                    PushDialogVideoView.this.akO.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mS().postDelayed(PushDialogVideoView.this.Zy, 20L);
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.Zs = false;
                PushDialogVideoView.this.lrS = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jPL.setVisibility(0);
                PushDialogVideoView.this.lrl.setVisibility(8);
                PushDialogVideoView.this.lrl.setProgress(PushDialogVideoView.this.lrl.getMax());
                if (PushDialogVideoView.this.fDL == null || PushDialogVideoView.this.fDL.getDuration() > 150000) {
                    PushDialogVideoView.this.uW(false);
                } else {
                    PushDialogVideoView.this.lro.setVisibility(0);
                }
                n.dkd().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fDL != null && PushDialogVideoView.this.fDL.getDuration() <= 150000) {
                    PushDialogVideoView.this.fw(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.akY);
                }
            }
        };
        this.jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hml.setVisibility(0);
                PushDialogVideoView.this.fcb.dka();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lrQ = true;
                }
                PushDialogVideoView.this.lrS = false;
                return true;
            }
        };
        this.jQu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hml.setVisibility(0);
                PushDialogVideoView.this.fcb.dka();
            }
        };
        this.dLM = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lrM) {
                    e.mS().postDelayed(PushDialogVideoView.this.lrY, 200L);
                }
            }
        };
        this.lrY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDL == null || !PushDialogVideoView.this.lrM) {
                    e.mS().postDelayed(PushDialogVideoView.this.Zy, 200L);
                    PushDialogVideoView.this.lrM = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fDL.getCurrentPosition()) {
                    PushDialogVideoView.this.lrM = false;
                    e.mS().postDelayed(PushDialogVideoView.this.Zy, 20L);
                } else {
                    e.mS().postDelayed(PushDialogVideoView.this.lrY, 200L);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Zs = false;
                PushDialogVideoView.this.lrS = false;
                e.mS().removeCallbacks(PushDialogVideoView.this.Zy);
                e.mS().removeCallbacks(PushDialogVideoView.this.jQu);
            }
        };
        this.jQz = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.fDL != null && PushDialogVideoView.this.fDL.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fDL.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fDL.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jSt != null) {
                                PushDialogVideoView.this.jSt.se(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fpd - (duration % PushDialogVideoView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jSt = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void se(int i) {
                int duration;
                if (PushDialogVideoView.this.fDL != null && (duration = PushDialogVideoView.this.fDL.getDuration()) > 0 && PushDialogVideoView.this.lrl != null) {
                    PushDialogVideoView.this.lrl.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpd = 50;
        this.mSkinType = 3;
        this.Zs = false;
        this.mStartPosition = 0;
        this.lrL = true;
        this.lrM = false;
        this.lrN = false;
        this.kUG = false;
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fcb.djY();
            }
        };
        this.hjx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cbE();
            }
        };
        this.Zy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDL.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Zs = true;
                    PushDialogVideoView.this.jPL.setVisibility(8);
                    PushDialogVideoView.this.hml.setVisibility(8);
                    PushDialogVideoView.this.fcb.djZ();
                    PushDialogVideoView.this.akO.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mS().postDelayed(PushDialogVideoView.this.Zy, 20L);
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.Zs = false;
                PushDialogVideoView.this.lrS = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jPL.setVisibility(0);
                PushDialogVideoView.this.lrl.setVisibility(8);
                PushDialogVideoView.this.lrl.setProgress(PushDialogVideoView.this.lrl.getMax());
                if (PushDialogVideoView.this.fDL == null || PushDialogVideoView.this.fDL.getDuration() > 150000) {
                    PushDialogVideoView.this.uW(false);
                } else {
                    PushDialogVideoView.this.lro.setVisibility(0);
                }
                n.dkd().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fDL != null && PushDialogVideoView.this.fDL.getDuration() <= 150000) {
                    PushDialogVideoView.this.fw(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.akY);
                }
            }
        };
        this.jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hml.setVisibility(0);
                PushDialogVideoView.this.fcb.dka();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lrQ = true;
                }
                PushDialogVideoView.this.lrS = false;
                return true;
            }
        };
        this.jQu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hml.setVisibility(0);
                PushDialogVideoView.this.fcb.dka();
            }
        };
        this.dLM = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lrM) {
                    e.mS().postDelayed(PushDialogVideoView.this.lrY, 200L);
                }
            }
        };
        this.lrY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDL == null || !PushDialogVideoView.this.lrM) {
                    e.mS().postDelayed(PushDialogVideoView.this.Zy, 200L);
                    PushDialogVideoView.this.lrM = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fDL.getCurrentPosition()) {
                    PushDialogVideoView.this.lrM = false;
                    e.mS().postDelayed(PushDialogVideoView.this.Zy, 20L);
                } else {
                    e.mS().postDelayed(PushDialogVideoView.this.lrY, 200L);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Zs = false;
                PushDialogVideoView.this.lrS = false;
                e.mS().removeCallbacks(PushDialogVideoView.this.Zy);
                e.mS().removeCallbacks(PushDialogVideoView.this.jQu);
            }
        };
        this.jQz = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.fDL != null && PushDialogVideoView.this.fDL.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fDL.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fDL.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jSt != null) {
                                PushDialogVideoView.this.jSt.se(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fpd - (duration % PushDialogVideoView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jSt = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void se(int i) {
                int duration;
                if (PushDialogVideoView.this.fDL != null && (duration = PushDialogVideoView.this.fDL.getDuration()) > 0 && PushDialogVideoView.this.lrl != null) {
                    PushDialogVideoView.this.lrl.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpd = 50;
        this.mSkinType = 3;
        this.Zs = false;
        this.mStartPosition = 0;
        this.lrL = true;
        this.lrM = false;
        this.lrN = false;
        this.kUG = false;
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fcb.djY();
            }
        };
        this.hjx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cbE();
            }
        };
        this.Zy = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDL.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Zs = true;
                    PushDialogVideoView.this.jPL.setVisibility(8);
                    PushDialogVideoView.this.hml.setVisibility(8);
                    PushDialogVideoView.this.fcb.djZ();
                    PushDialogVideoView.this.akO.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mS().postDelayed(PushDialogVideoView.this.Zy, 20L);
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.Zs = false;
                PushDialogVideoView.this.lrS = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jPL.setVisibility(0);
                PushDialogVideoView.this.lrl.setVisibility(8);
                PushDialogVideoView.this.lrl.setProgress(PushDialogVideoView.this.lrl.getMax());
                if (PushDialogVideoView.this.fDL == null || PushDialogVideoView.this.fDL.getDuration() > 150000) {
                    PushDialogVideoView.this.uW(false);
                } else {
                    PushDialogVideoView.this.lro.setVisibility(0);
                }
                n.dkd().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fDL != null && PushDialogVideoView.this.fDL.getDuration() <= 150000) {
                    PushDialogVideoView.this.fw(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.akY);
                }
            }
        };
        this.jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.hml.setVisibility(0);
                PushDialogVideoView.this.fcb.dka();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lrQ = true;
                }
                PushDialogVideoView.this.lrS = false;
                return true;
            }
        };
        this.jQu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hml.setVisibility(0);
                PushDialogVideoView.this.fcb.dka();
            }
        };
        this.dLM = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lrM) {
                    e.mS().postDelayed(PushDialogVideoView.this.lrY, 200L);
                }
            }
        };
        this.lrY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fDL == null || !PushDialogVideoView.this.lrM) {
                    e.mS().postDelayed(PushDialogVideoView.this.Zy, 200L);
                    PushDialogVideoView.this.lrM = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fDL.getCurrentPosition()) {
                    PushDialogVideoView.this.lrM = false;
                    e.mS().postDelayed(PushDialogVideoView.this.Zy, 20L);
                } else {
                    e.mS().postDelayed(PushDialogVideoView.this.lrY, 200L);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Zs = false;
                PushDialogVideoView.this.lrS = false;
                e.mS().removeCallbacks(PushDialogVideoView.this.Zy);
                e.mS().removeCallbacks(PushDialogVideoView.this.jQu);
            }
        };
        this.jQz = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.fDL != null && PushDialogVideoView.this.fDL.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fDL.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fDL.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.jSt != null) {
                                PushDialogVideoView.this.jSt.se(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fpd - (duration % PushDialogVideoView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jSt = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void se(int i2) {
                int duration;
                if (PushDialogVideoView.this.fDL != null && (duration = PushDialogVideoView.this.fDL.getDuration()) > 0 && PushDialogVideoView.this.lrl != null) {
                    PushDialogVideoView.this.lrl.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fDL = (TbCyberVideoView) findViewById(R.id.videoView);
        this.fDL.setPlayMode("2");
        this.fDL.setStageType(null);
        this.fcb = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fcb.setLoadingAnimationListener(this.hjx);
        this.lrl = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.lrl.setMax(this.mWidth);
        this.lrl.setProgress(0);
        this.jPL = findViewById(R.id.black_mask);
        this.hml = findViewById(R.id.layout_error);
        this.jPU = (ImageView) findViewById(R.id.img_play);
        this.lro = (TextView) findViewById(R.id.txt_replay);
        this.gSJ = (TextView) findViewById(R.id.push_dialog_video_time);
        this.akO = (TbImageView) findViewById(R.id.video_thumbnail);
        this.kUR = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.akO.setDefaultErrorResource(0);
        this.akO.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jQq = new CallStateReceiver();
        this.jQq.register(context);
        this.hml.setOnClickListener(this);
        this.lro.setOnClickListener(this);
        this.kUR.setOnPlayClickListener(this);
        this.kUR.setFreeClickListener(this);
        setOnClickListener(this);
        this.fDL.setOnPreparedListener(this.dLH);
        this.fDL.setOnCompletionListener(this.dLJ);
        this.fDL.setOnErrorListener(this.jQt);
        this.fDL.setOnSeekCompleteListener(this.dLM);
        this.fDL.setOnSurfaceDestroyedListener(this.fcj);
        onChangeSkinType();
    }

    public void onPause() {
        if (rF()) {
            this.kUG = true;
            aHX();
            return;
        }
        this.kUG = false;
        aHX();
    }

    public void onResume() {
        if (this.kUG) {
            aHY();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jQz);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.lyx = jVar;
        this.gSJ.setText(at.stringForVideoTime(this.lyx.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.akY = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.fDL.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        if (this.fDL != null) {
            if (this.lrS) {
                this.fDL.start();
                this.lrS = false;
            }
            e.mS().removeCallbacks(this.Zy);
            e.mS().postDelayed(this.Zy, 20L);
            e.mS().removeCallbacks(this.jQu);
            this.mStartPosition = n.dkd().OE(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.fDL.seekTo(this.mStartPosition);
                if (!this.lrR) {
                    showProgress();
                    e.mS().removeCallbacks(this.Zy);
                }
                this.lrM = true;
            }
        }
    }

    public void ddx() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fDL.isPlaying()) {
            aHX();
        } else if (this.Zs) {
            aHY();
        } else {
            djC();
        }
    }

    public void setPauseState() {
        this.fcb.dka();
        this.jPU.setVisibility(0);
        this.lro.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.lrN) {
            fx(str, str2);
        } else {
            fw(str, str2);
        }
        if (aVar != null) {
            aVar.vb(z);
        }
    }

    public void fw(String str, String str2) {
        djD();
        this.lrS = true;
        setVideoUrl(str, str2);
        this.fDL.setVideoPath(str, str2);
        this.fcb.startLoading();
        this.akO.setVisibility(0);
        this.jPU.setVisibility(8);
        this.lro.setVisibility(8);
        this.hml.setVisibility(8);
        e.mS().removeCallbacks(this.jQu);
        e.mS().postDelayed(this.jQu, 60000L);
    }

    public void fx(String str, String str2) {
        djD();
        this.lrS = true;
        this.fcb.startLoading();
        this.akO.setVisibility(0);
        this.jPU.setVisibility(8);
        this.lro.setVisibility(8);
        this.hml.setVisibility(8);
        e.mS().removeCallbacks(this.jQu);
        e.mS().postDelayed(this.jQu, 60000L);
    }

    public void aHY() {
        this.fDL.start();
        this.akO.setVisibility(8);
        this.jPL.setVisibility(8);
        this.fcb.dka();
        showProgress();
        this.jPU.setVisibility(8);
        this.lro.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lrQ && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.akY)) {
            this.lrQ = false;
            this.lrR = true;
            fw(this.mVideoUrl, this.akY);
        }
    }

    public void aHX() {
        if (this.fDL.isPlaying() && this.lrL) {
            djB();
        }
        this.fDL.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fDL.isPlaying() && this.lrL) {
            djB();
        }
        e.mS().removeCallbacks(this.Zy);
        e.mS().removeCallbacks(this.jQu);
        this.fDL.stopPlayback();
        this.Zs = false;
        this.lrS = false;
        this.mStartPosition = 0;
        czu();
    }

    public void djB() {
        n.dkd().by(this.mVideoUrl, this.fDL.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW(boolean z) {
        this.jPL.setVisibility(0);
        this.jPU.setVisibility(0);
        this.lro.setVisibility(8);
        this.fcb.dka();
        this.lrl.setVisibility(8);
        this.hml.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.akO.setVisibility(z ? 0 : 8);
    }

    public void czu() {
        uW(true);
    }

    public boolean rF() {
        if (this.fDL == null) {
            return false;
        }
        return this.fDL.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fDL == null) {
            return 0;
        }
        return this.fDL.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fDL != null) {
            this.lrl.setVisibility(0);
            this.fpd = ((this.fDL.getDuration() / 200) / 50) * 50;
            if (this.fpd < 50) {
                this.fpd = 50;
            } else if (this.fpd > 500) {
                this.fpd = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fpd - (this.fDL.getCurrentPosition() % this.fpd));
        }
    }

    private void djC() {
        a(this.mVideoUrl, this.akY, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        djD();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.lrN = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kVa && !g.dAV().dAW()) {
            this.kUR.setVisibility(0);
            this.kUR.setData(this.lyx.getDuration(), this.lyx.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void djD() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dAV().fI(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.akO.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hml) {
            djC();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 2).dD("tid", this.akY));
            ddx();
        } else if (view == this.lro) {
            fw(this.mVideoUrl, this.akY);
        } else if (view == this.kUR.getTvPlay()) {
            this.kVa = true;
            this.kUR.setVisibility(8);
            fw(this.mVideoUrl, this.akY);
        } else if (view == this.kUR.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mS().removeCallbacks(this.Zy);
        e.mS().removeCallbacks(this.jQu);
        e.mS().removeCallbacks(this.lrY);
        this.mHandler.removeMessages(1);
        this.jQq.unregister(getContext());
    }
}
