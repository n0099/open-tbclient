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
/* loaded from: classes21.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean aac;
    private Runnable aaj;
    private TbImageView alI;
    private String alS;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnCompletionListener dZR;
    private CyberPlayerManager.OnSeekCompleteListener dZU;
    private int fEz;
    private TbCyberVideoView fTk;
    private m frm;
    private TbCyberVideoView.a frv;
    private VideoLoadingProgressView.a hFy;
    private View hIm;
    private TextView hls;
    private View knK;
    private ImageView knT;
    private CallStateReceiver koo;
    private CyberPlayerManager.OnErrorListener kor;
    private Runnable kos;
    private CustomMessageListener kox;
    private VideoControllerView.b kqq;
    private ProgressBar lPD;
    private TextView lPG;
    private boolean lQd;
    private boolean lQe;
    private boolean lQf;
    private boolean lQi;
    private boolean lQj;
    private boolean lQk;
    private Runnable lQq;
    private j lWM;
    private boolean lsI;
    private PbVideoWifiTipLayout lsT;
    private boolean ltc;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes21.dex */
    public interface a {
        void vS(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fEz = 50;
        this.mSkinType = 3;
        this.aac = false;
        this.mStartPosition = 0;
        this.lQd = true;
        this.lQe = false;
        this.lQf = false;
        this.lsI = false;
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.frm.drs();
            }
        };
        this.hFy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.ciq();
            }
        };
        this.aaj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fTk.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aac = true;
                    PushDialogVideoView.this.knK.setVisibility(8);
                    PushDialogVideoView.this.hIm.setVisibility(8);
                    PushDialogVideoView.this.frm.drt();
                    PushDialogVideoView.this.alI.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aaj, 20L);
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aac = false;
                PushDialogVideoView.this.lQk = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.knK.setVisibility(0);
                PushDialogVideoView.this.lPD.setVisibility(8);
                PushDialogVideoView.this.lPD.setProgress(PushDialogVideoView.this.lPD.getMax());
                if (PushDialogVideoView.this.fTk == null || PushDialogVideoView.this.fTk.getDuration() > 150000) {
                    PushDialogVideoView.this.vN(false);
                } else {
                    PushDialogVideoView.this.lPG.setVisibility(0);
                }
                n.dry().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fTk != null && PushDialogVideoView.this.fTk.getDuration() <= 150000) {
                    PushDialogVideoView.this.fR(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alS);
                }
            }
        };
        this.kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hIm.setVisibility(0);
                PushDialogVideoView.this.frm.dru();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lQi = true;
                }
                PushDialogVideoView.this.lQk = false;
                return true;
            }
        };
        this.kos = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hIm.setVisibility(0);
                PushDialogVideoView.this.frm.dru();
            }
        };
        this.dZU = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lQe) {
                    e.mY().postDelayed(PushDialogVideoView.this.lQq, 200L);
                }
            }
        };
        this.lQq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fTk == null || !PushDialogVideoView.this.lQe) {
                    e.mY().postDelayed(PushDialogVideoView.this.aaj, 200L);
                    PushDialogVideoView.this.lQe = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fTk.getCurrentPosition()) {
                    PushDialogVideoView.this.lQe = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aaj, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.lQq, 200L);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aac = false;
                PushDialogVideoView.this.lQk = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aaj);
                e.mY().removeCallbacks(PushDialogVideoView.this.kos);
            }
        };
        this.kox = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aLr();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fTk != null && PushDialogVideoView.this.fTk.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fTk.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fTk.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kqq != null) {
                                PushDialogVideoView.this.kqq.sU(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fEz - (duration % PushDialogVideoView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kqq = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sU(int i) {
                int duration;
                if (PushDialogVideoView.this.fTk != null && (duration = PushDialogVideoView.this.fTk.getDuration()) > 0 && PushDialogVideoView.this.lPD != null) {
                    PushDialogVideoView.this.lPD.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEz = 50;
        this.mSkinType = 3;
        this.aac = false;
        this.mStartPosition = 0;
        this.lQd = true;
        this.lQe = false;
        this.lQf = false;
        this.lsI = false;
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.frm.drs();
            }
        };
        this.hFy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.ciq();
            }
        };
        this.aaj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fTk.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aac = true;
                    PushDialogVideoView.this.knK.setVisibility(8);
                    PushDialogVideoView.this.hIm.setVisibility(8);
                    PushDialogVideoView.this.frm.drt();
                    PushDialogVideoView.this.alI.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aaj, 20L);
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aac = false;
                PushDialogVideoView.this.lQk = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.knK.setVisibility(0);
                PushDialogVideoView.this.lPD.setVisibility(8);
                PushDialogVideoView.this.lPD.setProgress(PushDialogVideoView.this.lPD.getMax());
                if (PushDialogVideoView.this.fTk == null || PushDialogVideoView.this.fTk.getDuration() > 150000) {
                    PushDialogVideoView.this.vN(false);
                } else {
                    PushDialogVideoView.this.lPG.setVisibility(0);
                }
                n.dry().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fTk != null && PushDialogVideoView.this.fTk.getDuration() <= 150000) {
                    PushDialogVideoView.this.fR(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alS);
                }
            }
        };
        this.kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hIm.setVisibility(0);
                PushDialogVideoView.this.frm.dru();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lQi = true;
                }
                PushDialogVideoView.this.lQk = false;
                return true;
            }
        };
        this.kos = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hIm.setVisibility(0);
                PushDialogVideoView.this.frm.dru();
            }
        };
        this.dZU = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lQe) {
                    e.mY().postDelayed(PushDialogVideoView.this.lQq, 200L);
                }
            }
        };
        this.lQq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fTk == null || !PushDialogVideoView.this.lQe) {
                    e.mY().postDelayed(PushDialogVideoView.this.aaj, 200L);
                    PushDialogVideoView.this.lQe = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fTk.getCurrentPosition()) {
                    PushDialogVideoView.this.lQe = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aaj, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.lQq, 200L);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aac = false;
                PushDialogVideoView.this.lQk = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aaj);
                e.mY().removeCallbacks(PushDialogVideoView.this.kos);
            }
        };
        this.kox = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aLr();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fTk != null && PushDialogVideoView.this.fTk.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fTk.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fTk.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kqq != null) {
                                PushDialogVideoView.this.kqq.sU(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fEz - (duration % PushDialogVideoView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kqq = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sU(int i) {
                int duration;
                if (PushDialogVideoView.this.fTk != null && (duration = PushDialogVideoView.this.fTk.getDuration()) > 0 && PushDialogVideoView.this.lPD != null) {
                    PushDialogVideoView.this.lPD.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEz = 50;
        this.mSkinType = 3;
        this.aac = false;
        this.mStartPosition = 0;
        this.lQd = true;
        this.lQe = false;
        this.lQf = false;
        this.lsI = false;
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.frm.drs();
            }
        };
        this.hFy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.ciq();
            }
        };
        this.aaj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fTk.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aac = true;
                    PushDialogVideoView.this.knK.setVisibility(8);
                    PushDialogVideoView.this.hIm.setVisibility(8);
                    PushDialogVideoView.this.frm.drt();
                    PushDialogVideoView.this.alI.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aaj, 20L);
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aac = false;
                PushDialogVideoView.this.lQk = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.knK.setVisibility(0);
                PushDialogVideoView.this.lPD.setVisibility(8);
                PushDialogVideoView.this.lPD.setProgress(PushDialogVideoView.this.lPD.getMax());
                if (PushDialogVideoView.this.fTk == null || PushDialogVideoView.this.fTk.getDuration() > 150000) {
                    PushDialogVideoView.this.vN(false);
                } else {
                    PushDialogVideoView.this.lPG.setVisibility(0);
                }
                n.dry().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fTk != null && PushDialogVideoView.this.fTk.getDuration() <= 150000) {
                    PushDialogVideoView.this.fR(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alS);
                }
            }
        };
        this.kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.hIm.setVisibility(0);
                PushDialogVideoView.this.frm.dru();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lQi = true;
                }
                PushDialogVideoView.this.lQk = false;
                return true;
            }
        };
        this.kos = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hIm.setVisibility(0);
                PushDialogVideoView.this.frm.dru();
            }
        };
        this.dZU = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lQe) {
                    e.mY().postDelayed(PushDialogVideoView.this.lQq, 200L);
                }
            }
        };
        this.lQq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fTk == null || !PushDialogVideoView.this.lQe) {
                    e.mY().postDelayed(PushDialogVideoView.this.aaj, 200L);
                    PushDialogVideoView.this.lQe = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fTk.getCurrentPosition()) {
                    PushDialogVideoView.this.lQe = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aaj, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.lQq, 200L);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aac = false;
                PushDialogVideoView.this.lQk = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aaj);
                e.mY().removeCallbacks(PushDialogVideoView.this.kos);
            }
        };
        this.kox = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aLr();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fTk != null && PushDialogVideoView.this.fTk.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fTk.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fTk.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kqq != null) {
                                PushDialogVideoView.this.kqq.sU(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fEz - (duration % PushDialogVideoView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kqq = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sU(int i2) {
                int duration;
                if (PushDialogVideoView.this.fTk != null && (duration = PushDialogVideoView.this.fTk.getDuration()) > 0 && PushDialogVideoView.this.lPD != null) {
                    PushDialogVideoView.this.lPD.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fTk = (TbCyberVideoView) findViewById(R.id.videoView);
        this.fTk.setPlayMode("2");
        this.fTk.setStageType(null);
        this.frm = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.frm.setLoadingAnimationListener(this.hFy);
        this.lPD = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.lPD.setMax(this.mWidth);
        this.lPD.setProgress(0);
        this.knK = findViewById(R.id.black_mask);
        this.hIm = findViewById(R.id.layout_error);
        this.knT = (ImageView) findViewById(R.id.img_play);
        this.lPG = (TextView) findViewById(R.id.txt_replay);
        this.hls = (TextView) findViewById(R.id.push_dialog_video_time);
        this.alI = (TbImageView) findViewById(R.id.video_thumbnail);
        this.lsT = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.alI.setDefaultErrorResource(0);
        this.alI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.koo = new CallStateReceiver();
        this.koo.register(context);
        this.hIm.setOnClickListener(this);
        this.lPG.setOnClickListener(this);
        this.lsT.setOnPlayClickListener(this);
        this.lsT.setFreeClickListener(this);
        setOnClickListener(this);
        this.fTk.setOnPreparedListener(this.dZP);
        this.fTk.setOnCompletionListener(this.dZR);
        this.fTk.setOnErrorListener(this.kor);
        this.fTk.setOnSeekCompleteListener(this.dZU);
        this.fTk.setOnSurfaceDestroyedListener(this.frv);
        onChangeSkinType();
    }

    public void onPause() {
        if (rK()) {
            this.lsI = true;
            aLr();
            return;
        }
        this.lsI = false;
        aLr();
    }

    public void onResume() {
        if (this.lsI) {
            aLs();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kox);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.lWM = jVar;
        this.hls.setText(at.stringForVideoTime(this.lWM.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alS = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.fTk.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciq() {
        if (this.fTk != null) {
            if (this.lQk) {
                this.fTk.start();
                this.lQk = false;
            }
            e.mY().removeCallbacks(this.aaj);
            e.mY().postDelayed(this.aaj, 20L);
            e.mY().removeCallbacks(this.kos);
            this.mStartPosition = n.dry().PV(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.fTk.seekTo(this.mStartPosition);
                if (!this.lQj) {
                    showProgress();
                    e.mY().removeCallbacks(this.aaj);
                }
                this.lQe = true;
            }
        }
    }

    public void dkL() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fTk.isPlaying()) {
            aLr();
        } else if (this.aac) {
            aLs();
        } else {
            dqW();
        }
    }

    public void setPauseState() {
        this.frm.dru();
        this.knT.setVisibility(0);
        this.lPG.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.lQf) {
            fS(str, str2);
        } else {
            fR(str, str2);
        }
        if (aVar != null) {
            aVar.vS(z);
        }
    }

    public void fR(String str, String str2) {
        dqX();
        this.lQk = true;
        setVideoUrl(str, str2);
        this.fTk.setVideoPath(str, str2);
        this.frm.startLoading();
        this.alI.setVisibility(0);
        this.knT.setVisibility(8);
        this.lPG.setVisibility(8);
        this.hIm.setVisibility(8);
        e.mY().removeCallbacks(this.kos);
        e.mY().postDelayed(this.kos, 60000L);
    }

    public void fS(String str, String str2) {
        dqX();
        this.lQk = true;
        this.frm.startLoading();
        this.alI.setVisibility(0);
        this.knT.setVisibility(8);
        this.lPG.setVisibility(8);
        this.hIm.setVisibility(8);
        e.mY().removeCallbacks(this.kos);
        e.mY().postDelayed(this.kos, 60000L);
    }

    public void aLs() {
        this.fTk.start();
        this.alI.setVisibility(8);
        this.knK.setVisibility(8);
        this.frm.dru();
        showProgress();
        this.knT.setVisibility(8);
        this.lPG.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lQi && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alS)) {
            this.lQi = false;
            this.lQj = true;
            fR(this.mVideoUrl, this.alS);
        }
    }

    public void aLr() {
        if (this.fTk.isPlaying() && this.lQd) {
            dqV();
        }
        this.fTk.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fTk.isPlaying() && this.lQd) {
            dqV();
        }
        e.mY().removeCallbacks(this.aaj);
        e.mY().removeCallbacks(this.kos);
        this.fTk.stopPlayback();
        this.aac = false;
        this.lQk = false;
        this.mStartPosition = 0;
        cGL();
    }

    public void dqV() {
        n.dry().bz(this.mVideoUrl, this.fTk.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vN(boolean z) {
        this.knK.setVisibility(0);
        this.knT.setVisibility(0);
        this.lPG.setVisibility(8);
        this.frm.dru();
        this.lPD.setVisibility(8);
        this.hIm.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.alI.setVisibility(z ? 0 : 8);
    }

    public void cGL() {
        vN(true);
    }

    public boolean rK() {
        if (this.fTk == null) {
            return false;
        }
        return this.fTk.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fTk == null) {
            return 0;
        }
        return this.fTk.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fTk != null) {
            this.lPD.setVisibility(0);
            this.fEz = ((this.fTk.getDuration() / 200) / 50) * 50;
            if (this.fEz < 50) {
                this.fEz = 50;
            } else if (this.fEz > 500) {
                this.fEz = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fEz - (this.fTk.getCurrentPosition() % this.fEz));
        }
    }

    private void dqW() {
        a(this.mVideoUrl, this.alS, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dqX();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.lQf = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.ltc && !g.dIK().dIL()) {
            this.lsT.setVisibility(0);
            this.lsT.setData(this.lWM.getDuration(), this.lWM.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dqX() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dIK().fV(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.alI.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hIm) {
            dqW();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").aj("obj_locate", 2).dK("tid", this.alS));
            dkL();
        } else if (view == this.lPG) {
            fR(this.mVideoUrl, this.alS);
        } else if (view == this.lsT.getTvPlay()) {
            this.ltc = true;
            this.lsT.setVisibility(8);
            fR(this.mVideoUrl, this.alS);
        } else if (view == this.lsT.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mY().removeCallbacks(this.aaj);
        e.mY().removeCallbacks(this.kos);
        e.mY().removeCallbacks(this.lQq);
        this.mHandler.removeMessages(1);
        this.koo.unregister(getContext());
    }
}
