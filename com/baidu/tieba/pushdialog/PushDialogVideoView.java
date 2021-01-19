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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.i;
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
import com.baidu.tieba.video.f;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes7.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean abN;
    private Runnable abT;
    private TbImageView amC;
    private String amM;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnCompletionListener eyv;
    private CyberPlayerManager.OnSeekCompleteListener eyy;
    private m fRL;
    private TbCyberVideoView.a fRT;
    private int gfm;
    private TbCyberVideoView gxn;
    private TextView hUq;
    private VideoLoadingProgressView.a irf;
    private View itU;
    private View kUI;
    private ImageView kUR;
    private CallStateReceiver kVm;
    private CyberPlayerManager.OnErrorListener kVp;
    private Runnable kVq;
    private CustomMessageListener kVv;
    private VideoControllerView.b kXo;
    private i mEv;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private boolean mad;
    private PbVideoWifiTipLayout man;
    private boolean may;
    private boolean mxH;
    private boolean mxI;
    private boolean mxJ;
    private boolean mxM;
    private boolean mxN;
    private boolean mxO;
    private Runnable mxU;
    private ProgressBar mxh;
    private TextView mxk;

    /* loaded from: classes7.dex */
    public interface a {
        void wW(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.gfm = 50;
        this.mSkinType = 3;
        this.abN = false;
        this.mStartPosition = 0;
        this.mxH = true;
        this.mxI = false;
        this.mxJ = false;
        this.mad = false;
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fRL.dxS();
            }
        };
        this.irf = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cqQ();
            }
        };
        this.abT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gxn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abN = true;
                    PushDialogVideoView.this.kUI.setVisibility(8);
                    PushDialogVideoView.this.itU.setVisibility(8);
                    PushDialogVideoView.this.fRL.dxT();
                    PushDialogVideoView.this.amC.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mB().postDelayed(PushDialogVideoView.this.abT, 20L);
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abN = false;
                PushDialogVideoView.this.mxO = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kUI.setVisibility(0);
                PushDialogVideoView.this.mxh.setVisibility(8);
                PushDialogVideoView.this.mxh.setProgress(PushDialogVideoView.this.mxh.getMax());
                if (PushDialogVideoView.this.gxn == null || PushDialogVideoView.this.gxn.getDuration() > 150000) {
                    PushDialogVideoView.this.wR(false);
                } else {
                    PushDialogVideoView.this.mxk.setVisibility(0);
                }
                n.dxY().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gxn != null && PushDialogVideoView.this.gxn.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amM);
                }
            }
        };
        this.kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.itU.setVisibility(0);
                PushDialogVideoView.this.fRL.dxU();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxM = true;
                }
                PushDialogVideoView.this.mxO = false;
                return true;
            }
        };
        this.kVq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.itU.setVisibility(0);
                PushDialogVideoView.this.fRL.dxU();
            }
        };
        this.eyy = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mxI) {
                    e.mB().postDelayed(PushDialogVideoView.this.mxU, 200L);
                }
            }
        };
        this.mxU = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gxn == null || !PushDialogVideoView.this.mxI) {
                    e.mB().postDelayed(PushDialogVideoView.this.abT, 200L);
                    PushDialogVideoView.this.mxI = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gxn.getCurrentPosition()) {
                    PushDialogVideoView.this.mxI = false;
                    e.mB().postDelayed(PushDialogVideoView.this.abT, 20L);
                } else {
                    e.mB().postDelayed(PushDialogVideoView.this.mxU, 200L);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abN = false;
                PushDialogVideoView.this.mxO = false;
                e.mB().removeCallbacks(PushDialogVideoView.this.abT);
                e.mB().removeCallbacks(PushDialogVideoView.this.kVq);
            }
        };
        this.kVv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aQJ();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gxn != null && PushDialogVideoView.this.gxn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gxn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gxn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kXo != null) {
                                PushDialogVideoView.this.kXo.sW(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gfm - (duration % PushDialogVideoView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kXo = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sW(int i) {
                int duration;
                if (PushDialogVideoView.this.gxn != null && (duration = PushDialogVideoView.this.gxn.getDuration()) > 0 && PushDialogVideoView.this.mxh != null) {
                    PushDialogVideoView.this.mxh.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfm = 50;
        this.mSkinType = 3;
        this.abN = false;
        this.mStartPosition = 0;
        this.mxH = true;
        this.mxI = false;
        this.mxJ = false;
        this.mad = false;
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fRL.dxS();
            }
        };
        this.irf = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cqQ();
            }
        };
        this.abT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gxn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abN = true;
                    PushDialogVideoView.this.kUI.setVisibility(8);
                    PushDialogVideoView.this.itU.setVisibility(8);
                    PushDialogVideoView.this.fRL.dxT();
                    PushDialogVideoView.this.amC.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mB().postDelayed(PushDialogVideoView.this.abT, 20L);
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abN = false;
                PushDialogVideoView.this.mxO = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kUI.setVisibility(0);
                PushDialogVideoView.this.mxh.setVisibility(8);
                PushDialogVideoView.this.mxh.setProgress(PushDialogVideoView.this.mxh.getMax());
                if (PushDialogVideoView.this.gxn == null || PushDialogVideoView.this.gxn.getDuration() > 150000) {
                    PushDialogVideoView.this.wR(false);
                } else {
                    PushDialogVideoView.this.mxk.setVisibility(0);
                }
                n.dxY().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gxn != null && PushDialogVideoView.this.gxn.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amM);
                }
            }
        };
        this.kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.itU.setVisibility(0);
                PushDialogVideoView.this.fRL.dxU();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxM = true;
                }
                PushDialogVideoView.this.mxO = false;
                return true;
            }
        };
        this.kVq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.itU.setVisibility(0);
                PushDialogVideoView.this.fRL.dxU();
            }
        };
        this.eyy = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mxI) {
                    e.mB().postDelayed(PushDialogVideoView.this.mxU, 200L);
                }
            }
        };
        this.mxU = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gxn == null || !PushDialogVideoView.this.mxI) {
                    e.mB().postDelayed(PushDialogVideoView.this.abT, 200L);
                    PushDialogVideoView.this.mxI = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gxn.getCurrentPosition()) {
                    PushDialogVideoView.this.mxI = false;
                    e.mB().postDelayed(PushDialogVideoView.this.abT, 20L);
                } else {
                    e.mB().postDelayed(PushDialogVideoView.this.mxU, 200L);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abN = false;
                PushDialogVideoView.this.mxO = false;
                e.mB().removeCallbacks(PushDialogVideoView.this.abT);
                e.mB().removeCallbacks(PushDialogVideoView.this.kVq);
            }
        };
        this.kVv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aQJ();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gxn != null && PushDialogVideoView.this.gxn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gxn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gxn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kXo != null) {
                                PushDialogVideoView.this.kXo.sW(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gfm - (duration % PushDialogVideoView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kXo = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sW(int i) {
                int duration;
                if (PushDialogVideoView.this.gxn != null && (duration = PushDialogVideoView.this.gxn.getDuration()) > 0 && PushDialogVideoView.this.mxh != null) {
                    PushDialogVideoView.this.mxh.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfm = 50;
        this.mSkinType = 3;
        this.abN = false;
        this.mStartPosition = 0;
        this.mxH = true;
        this.mxI = false;
        this.mxJ = false;
        this.mad = false;
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fRL.dxS();
            }
        };
        this.irf = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cqQ();
            }
        };
        this.abT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gxn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abN = true;
                    PushDialogVideoView.this.kUI.setVisibility(8);
                    PushDialogVideoView.this.itU.setVisibility(8);
                    PushDialogVideoView.this.fRL.dxT();
                    PushDialogVideoView.this.amC.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mB().postDelayed(PushDialogVideoView.this.abT, 20L);
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abN = false;
                PushDialogVideoView.this.mxO = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kUI.setVisibility(0);
                PushDialogVideoView.this.mxh.setVisibility(8);
                PushDialogVideoView.this.mxh.setProgress(PushDialogVideoView.this.mxh.getMax());
                if (PushDialogVideoView.this.gxn == null || PushDialogVideoView.this.gxn.getDuration() > 150000) {
                    PushDialogVideoView.this.wR(false);
                } else {
                    PushDialogVideoView.this.mxk.setVisibility(0);
                }
                n.dxY().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gxn != null && PushDialogVideoView.this.gxn.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amM);
                }
            }
        };
        this.kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.itU.setVisibility(0);
                PushDialogVideoView.this.fRL.dxU();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxM = true;
                }
                PushDialogVideoView.this.mxO = false;
                return true;
            }
        };
        this.kVq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.itU.setVisibility(0);
                PushDialogVideoView.this.fRL.dxU();
            }
        };
        this.eyy = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mxI) {
                    e.mB().postDelayed(PushDialogVideoView.this.mxU, 200L);
                }
            }
        };
        this.mxU = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gxn == null || !PushDialogVideoView.this.mxI) {
                    e.mB().postDelayed(PushDialogVideoView.this.abT, 200L);
                    PushDialogVideoView.this.mxI = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gxn.getCurrentPosition()) {
                    PushDialogVideoView.this.mxI = false;
                    e.mB().postDelayed(PushDialogVideoView.this.abT, 20L);
                } else {
                    e.mB().postDelayed(PushDialogVideoView.this.mxU, 200L);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abN = false;
                PushDialogVideoView.this.mxO = false;
                e.mB().removeCallbacks(PushDialogVideoView.this.abT);
                e.mB().removeCallbacks(PushDialogVideoView.this.kVq);
            }
        };
        this.kVv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aQJ();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gxn != null && PushDialogVideoView.this.gxn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gxn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gxn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kXo != null) {
                                PushDialogVideoView.this.kXo.sW(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gfm - (duration % PushDialogVideoView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kXo = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sW(int i2) {
                int duration;
                if (PushDialogVideoView.this.gxn != null && (duration = PushDialogVideoView.this.gxn.getDuration()) > 0 && PushDialogVideoView.this.mxh != null) {
                    PushDialogVideoView.this.mxh.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gxn = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gxn.setPlayMode("2");
        this.gxn.setStageType(null);
        this.fRL = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fRL.setLoadingAnimationListener(this.irf);
        this.mxh = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mxh.setMax(this.mWidth);
        this.mxh.setProgress(0);
        this.kUI = findViewById(R.id.black_mask);
        this.itU = findViewById(R.id.layout_error);
        this.kUR = (ImageView) findViewById(R.id.img_play);
        this.mxk = (TextView) findViewById(R.id.txt_replay);
        this.hUq = (TextView) findViewById(R.id.push_dialog_video_time);
        this.amC = (TbImageView) findViewById(R.id.video_thumbnail);
        this.man = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.amC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kVm = new CallStateReceiver();
        this.kVm.register(context);
        this.itU.setOnClickListener(this);
        this.mxk.setOnClickListener(this);
        this.man.setOnPlayClickListener(this);
        this.man.setFreeClickListener(this);
        setOnClickListener(this);
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnCompletionListener(this.eyv);
        this.gxn.setOnErrorListener(this.kVp);
        this.gxn.setOnSeekCompleteListener(this.eyy);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        onChangeSkinType();
    }

    public void onPause() {
        if (rn()) {
            this.mad = true;
            aQJ();
            return;
        }
        this.mad = false;
        aQJ();
    }

    public void onResume() {
        if (this.mad) {
            aQK();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kVv);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mEv = iVar;
        this.hUq.setText(at.stringForVideoTime(this.mEv.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amM = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gxn.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        if (this.gxn != null) {
            if (this.mxO) {
                this.gxn.start();
                this.mxO = false;
            }
            e.mB().removeCallbacks(this.abT);
            e.mB().postDelayed(this.abT, 20L);
            e.mB().removeCallbacks(this.kVq);
            this.mStartPosition = n.dxY().PM(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gxn.seekTo(this.mStartPosition);
                if (!this.mxN) {
                    showProgress();
                    e.mB().removeCallbacks(this.abT);
                }
                this.mxI = true;
            }
        }
    }

    public void drn() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gxn.isPlaying()) {
            aQJ();
        } else if (this.abN) {
            aQK();
        } else {
            dxw();
        }
    }

    public void setPauseState() {
        this.fRL.dxU();
        this.kUR.setVisibility(0);
        this.mxk.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mxJ) {
            fY(str, str2);
        } else {
            fX(str, str2);
        }
        if (aVar != null) {
            aVar.wW(z);
        }
    }

    public void fX(String str, String str2) {
        dxx();
        this.mxO = true;
        setVideoUrl(str, str2);
        this.gxn.setVideoPath(str, str2);
        this.fRL.startLoading();
        this.amC.setVisibility(0);
        this.kUR.setVisibility(8);
        this.mxk.setVisibility(8);
        this.itU.setVisibility(8);
        e.mB().removeCallbacks(this.kVq);
        e.mB().postDelayed(this.kVq, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void fY(String str, String str2) {
        dxx();
        this.mxO = true;
        this.fRL.startLoading();
        this.amC.setVisibility(0);
        this.kUR.setVisibility(8);
        this.mxk.setVisibility(8);
        this.itU.setVisibility(8);
        e.mB().removeCallbacks(this.kVq);
        e.mB().postDelayed(this.kVq, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void aQK() {
        this.gxn.start();
        this.amC.setVisibility(8);
        this.kUI.setVisibility(8);
        this.fRL.dxU();
        showProgress();
        this.kUR.setVisibility(8);
        this.mxk.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mxM && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amM)) {
            this.mxM = false;
            this.mxN = true;
            fX(this.mVideoUrl, this.amM);
        }
    }

    public void aQJ() {
        if (this.gxn.isPlaying() && this.mxH) {
            dxv();
        }
        this.gxn.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gxn.isPlaying() && this.mxH) {
            dxv();
        }
        e.mB().removeCallbacks(this.abT);
        e.mB().removeCallbacks(this.kVq);
        this.gxn.stopPlayback();
        this.abN = false;
        this.mxO = false;
        this.mStartPosition = 0;
        cQE();
    }

    public void dxv() {
        n.dxY().bL(this.mVideoUrl, this.gxn.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR(boolean z) {
        this.kUI.setVisibility(0);
        this.kUR.setVisibility(0);
        this.mxk.setVisibility(8);
        this.fRL.dxU();
        this.mxh.setVisibility(8);
        this.itU.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.amC.setVisibility(z ? 0 : 8);
    }

    public void cQE() {
        wR(true);
    }

    public boolean rn() {
        if (this.gxn == null) {
            return false;
        }
        return this.gxn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gxn == null) {
            return 0;
        }
        return this.gxn.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gxn != null) {
            this.mxh.setVisibility(0);
            this.gfm = ((this.gxn.getDuration() / 200) / 50) * 50;
            if (this.gfm < 50) {
                this.gfm = 50;
            } else if (this.gfm > 500) {
                this.gfm = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gfm - (this.gxn.getCurrentPosition() % this.gfm));
        }
    }

    private void dxw() {
        a(this.mVideoUrl, this.amM, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dxx();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mxJ = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.may && !f.dPM().dPN()) {
            this.man.setVisibility(0);
            this.man.setData(this.mEv.getDuration(), this.mEv.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dxx() {
        if (j.isMobileNet()) {
            f.dPM().gW(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.amC.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.itU) {
            dxw();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 2).dW("tid", this.amM));
            drn();
        } else if (view == this.mxk) {
            fX(this.mVideoUrl, this.amM);
        } else if (view == this.man.getTvPlay()) {
            this.may = true;
            this.man.setVisibility(8);
            fX(this.mVideoUrl, this.amM);
        } else if (view == this.man.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mB().removeCallbacks(this.abT);
        e.mB().removeCallbacks(this.kVq);
        e.mB().removeCallbacks(this.mxU);
        this.mHandler.removeMessages(1);
        this.kVm.unregister(getContext());
    }
}
