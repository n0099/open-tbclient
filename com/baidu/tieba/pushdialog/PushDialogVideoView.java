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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.video.g;
/* loaded from: classes21.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean abf;
    private Runnable abl;
    private TbImageView amP;
    private String amY;
    private CyberPlayerManager.OnCompletionListener etA;
    private CyberPlayerManager.OnSeekCompleteListener etD;
    private CyberPlayerManager.OnPreparedListener ety;
    private m fMO;
    private TbCyberVideoView.a fMW;
    private int gaB;
    private TbCyberVideoView gqT;
    private TextView hMy;
    private VideoLoadingProgressView.a ijp;
    private View ime;
    private View kTI;
    private ImageView kTR;
    private CallStateReceiver kUm;
    private CyberPlayerManager.OnErrorListener kUp;
    private Runnable kUq;
    private CustomMessageListener kUv;
    private VideoControllerView.b kWo;
    private PbVideoWifiTipLayout lZE;
    private boolean lZN;
    private boolean lZt;
    private i mDL;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private TextView mwA;
    private boolean mwX;
    private boolean mwY;
    private boolean mwZ;
    private ProgressBar mwx;
    private boolean mxc;
    private boolean mxd;
    private boolean mxe;
    private Runnable mxk;

    /* loaded from: classes21.dex */
    public interface a {
        void wZ(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.gaB = 50;
        this.mSkinType = 3;
        this.abf = false;
        this.mStartPosition = 0;
        this.mwX = true;
        this.mwY = false;
        this.mwZ = false;
        this.lZt = false;
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fMO.dBT();
            }
        };
        this.ijp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.crN();
            }
        };
        this.abl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqT.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abf = true;
                    PushDialogVideoView.this.kTI.setVisibility(8);
                    PushDialogVideoView.this.ime.setVisibility(8);
                    PushDialogVideoView.this.fMO.dBU();
                    PushDialogVideoView.this.amP.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxe = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kTI.setVisibility(0);
                PushDialogVideoView.this.mwx.setVisibility(8);
                PushDialogVideoView.this.mwx.setProgress(PushDialogVideoView.this.mwx.getMax());
                if (PushDialogVideoView.this.gqT == null || PushDialogVideoView.this.gqT.getDuration() > 150000) {
                    PushDialogVideoView.this.wU(false);
                } else {
                    PushDialogVideoView.this.mwA.setVisibility(0);
                }
                n.dBZ().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gqT != null && PushDialogVideoView.this.gqT.getDuration() <= 150000) {
                    PushDialogVideoView.this.gb(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amY);
                }
            }
        };
        this.kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.ime.setVisibility(0);
                PushDialogVideoView.this.fMO.dBV();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxc = true;
                }
                PushDialogVideoView.this.mxe = false;
                return true;
            }
        };
        this.kUq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ime.setVisibility(0);
                PushDialogVideoView.this.fMO.dBV();
            }
        };
        this.etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mwY) {
                    e.mY().postDelayed(PushDialogVideoView.this.mxk, 200L);
                }
            }
        };
        this.mxk = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqT == null || !PushDialogVideoView.this.mwY) {
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 200L);
                    PushDialogVideoView.this.mwY = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gqT.getCurrentPosition()) {
                    PushDialogVideoView.this.mwY = false;
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mxk, 200L);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxe = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.abl);
                e.mY().removeCallbacks(PushDialogVideoView.this.kUq);
            }
        };
        this.kUv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aSi();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gqT != null && PushDialogVideoView.this.gqT.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gqT.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gqT.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kWo != null) {
                                PushDialogVideoView.this.kWo.ur(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gaB - (duration % PushDialogVideoView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kWo = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ur(int i) {
                int duration;
                if (PushDialogVideoView.this.gqT != null && (duration = PushDialogVideoView.this.gqT.getDuration()) > 0 && PushDialogVideoView.this.mwx != null) {
                    PushDialogVideoView.this.mwx.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaB = 50;
        this.mSkinType = 3;
        this.abf = false;
        this.mStartPosition = 0;
        this.mwX = true;
        this.mwY = false;
        this.mwZ = false;
        this.lZt = false;
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fMO.dBT();
            }
        };
        this.ijp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.crN();
            }
        };
        this.abl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqT.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abf = true;
                    PushDialogVideoView.this.kTI.setVisibility(8);
                    PushDialogVideoView.this.ime.setVisibility(8);
                    PushDialogVideoView.this.fMO.dBU();
                    PushDialogVideoView.this.amP.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxe = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kTI.setVisibility(0);
                PushDialogVideoView.this.mwx.setVisibility(8);
                PushDialogVideoView.this.mwx.setProgress(PushDialogVideoView.this.mwx.getMax());
                if (PushDialogVideoView.this.gqT == null || PushDialogVideoView.this.gqT.getDuration() > 150000) {
                    PushDialogVideoView.this.wU(false);
                } else {
                    PushDialogVideoView.this.mwA.setVisibility(0);
                }
                n.dBZ().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gqT != null && PushDialogVideoView.this.gqT.getDuration() <= 150000) {
                    PushDialogVideoView.this.gb(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amY);
                }
            }
        };
        this.kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.ime.setVisibility(0);
                PushDialogVideoView.this.fMO.dBV();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxc = true;
                }
                PushDialogVideoView.this.mxe = false;
                return true;
            }
        };
        this.kUq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ime.setVisibility(0);
                PushDialogVideoView.this.fMO.dBV();
            }
        };
        this.etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mwY) {
                    e.mY().postDelayed(PushDialogVideoView.this.mxk, 200L);
                }
            }
        };
        this.mxk = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqT == null || !PushDialogVideoView.this.mwY) {
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 200L);
                    PushDialogVideoView.this.mwY = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gqT.getCurrentPosition()) {
                    PushDialogVideoView.this.mwY = false;
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mxk, 200L);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxe = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.abl);
                e.mY().removeCallbacks(PushDialogVideoView.this.kUq);
            }
        };
        this.kUv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aSi();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gqT != null && PushDialogVideoView.this.gqT.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gqT.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gqT.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kWo != null) {
                                PushDialogVideoView.this.kWo.ur(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gaB - (duration % PushDialogVideoView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kWo = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ur(int i) {
                int duration;
                if (PushDialogVideoView.this.gqT != null && (duration = PushDialogVideoView.this.gqT.getDuration()) > 0 && PushDialogVideoView.this.mwx != null) {
                    PushDialogVideoView.this.mwx.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaB = 50;
        this.mSkinType = 3;
        this.abf = false;
        this.mStartPosition = 0;
        this.mwX = true;
        this.mwY = false;
        this.mwZ = false;
        this.lZt = false;
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fMO.dBT();
            }
        };
        this.ijp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.crN();
            }
        };
        this.abl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqT.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abf = true;
                    PushDialogVideoView.this.kTI.setVisibility(8);
                    PushDialogVideoView.this.ime.setVisibility(8);
                    PushDialogVideoView.this.fMO.dBU();
                    PushDialogVideoView.this.amP.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxe = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kTI.setVisibility(0);
                PushDialogVideoView.this.mwx.setVisibility(8);
                PushDialogVideoView.this.mwx.setProgress(PushDialogVideoView.this.mwx.getMax());
                if (PushDialogVideoView.this.gqT == null || PushDialogVideoView.this.gqT.getDuration() > 150000) {
                    PushDialogVideoView.this.wU(false);
                } else {
                    PushDialogVideoView.this.mwA.setVisibility(0);
                }
                n.dBZ().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gqT != null && PushDialogVideoView.this.gqT.getDuration() <= 150000) {
                    PushDialogVideoView.this.gb(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amY);
                }
            }
        };
        this.kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.ime.setVisibility(0);
                PushDialogVideoView.this.fMO.dBV();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxc = true;
                }
                PushDialogVideoView.this.mxe = false;
                return true;
            }
        };
        this.kUq = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ime.setVisibility(0);
                PushDialogVideoView.this.fMO.dBV();
            }
        };
        this.etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mwY) {
                    e.mY().postDelayed(PushDialogVideoView.this.mxk, 200L);
                }
            }
        };
        this.mxk = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqT == null || !PushDialogVideoView.this.mwY) {
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 200L);
                    PushDialogVideoView.this.mwY = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gqT.getCurrentPosition()) {
                    PushDialogVideoView.this.mwY = false;
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mxk, 200L);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxe = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.abl);
                e.mY().removeCallbacks(PushDialogVideoView.this.kUq);
            }
        };
        this.kUv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aSi();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gqT != null && PushDialogVideoView.this.gqT.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gqT.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gqT.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kWo != null) {
                                PushDialogVideoView.this.kWo.ur(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gaB - (duration % PushDialogVideoView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kWo = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ur(int i2) {
                int duration;
                if (PushDialogVideoView.this.gqT != null && (duration = PushDialogVideoView.this.gqT.getDuration()) > 0 && PushDialogVideoView.this.mwx != null) {
                    PushDialogVideoView.this.mwx.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gqT = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gqT.setPlayMode("2");
        this.gqT.setStageType(null);
        this.fMO = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fMO.setLoadingAnimationListener(this.ijp);
        this.mwx = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mwx.setMax(this.mWidth);
        this.mwx.setProgress(0);
        this.kTI = findViewById(R.id.black_mask);
        this.ime = findViewById(R.id.layout_error);
        this.kTR = (ImageView) findViewById(R.id.img_play);
        this.mwA = (TextView) findViewById(R.id.txt_replay);
        this.hMy = (TextView) findViewById(R.id.push_dialog_video_time);
        this.amP = (TbImageView) findViewById(R.id.video_thumbnail);
        this.lZE = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.amP.setDefaultErrorResource(0);
        this.amP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kUm = new CallStateReceiver();
        this.kUm.register(context);
        this.ime.setOnClickListener(this);
        this.mwA.setOnClickListener(this);
        this.lZE.setOnPlayClickListener(this);
        this.lZE.setFreeClickListener(this);
        setOnClickListener(this);
        this.gqT.setOnPreparedListener(this.ety);
        this.gqT.setOnCompletionListener(this.etA);
        this.gqT.setOnErrorListener(this.kUp);
        this.gqT.setOnSeekCompleteListener(this.etD);
        this.gqT.setOnSurfaceDestroyedListener(this.fMW);
        onChangeSkinType();
    }

    public void onPause() {
        if (rM()) {
            this.lZt = true;
            aSi();
            return;
        }
        this.lZt = false;
        aSi();
    }

    public void onResume() {
        if (this.lZt) {
            aSj();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kUv);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mDL = iVar;
        this.hMy.setText(au.stringForVideoTime(this.mDL.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amY = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gqT.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crN() {
        if (this.gqT != null) {
            if (this.mxe) {
                this.gqT.start();
                this.mxe = false;
            }
            e.mY().removeCallbacks(this.abl);
            e.mY().postDelayed(this.abl, 20L);
            e.mY().removeCallbacks(this.kUq);
            this.mStartPosition = n.dBZ().Ro(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gqT.seekTo(this.mStartPosition);
                if (!this.mxd) {
                    showProgress();
                    e.mY().removeCallbacks(this.abl);
                }
                this.mwY = true;
            }
        }
    }

    public void dvo() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gqT.isPlaying()) {
            aSi();
        } else if (this.abf) {
            aSj();
        } else {
            dBx();
        }
    }

    public void setPauseState() {
        this.fMO.dBV();
        this.kTR.setVisibility(0);
        this.mwA.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mwZ) {
            gc(str, str2);
        } else {
            gb(str, str2);
        }
        if (aVar != null) {
            aVar.wZ(z);
        }
    }

    public void gb(String str, String str2) {
        dBy();
        this.mxe = true;
        setVideoUrl(str, str2);
        this.gqT.setVideoPath(str, str2);
        this.fMO.startLoading();
        this.amP.setVisibility(0);
        this.kTR.setVisibility(8);
        this.mwA.setVisibility(8);
        this.ime.setVisibility(8);
        e.mY().removeCallbacks(this.kUq);
        e.mY().postDelayed(this.kUq, 60000L);
    }

    public void gc(String str, String str2) {
        dBy();
        this.mxe = true;
        this.fMO.startLoading();
        this.amP.setVisibility(0);
        this.kTR.setVisibility(8);
        this.mwA.setVisibility(8);
        this.ime.setVisibility(8);
        e.mY().removeCallbacks(this.kUq);
        e.mY().postDelayed(this.kUq, 60000L);
    }

    public void aSj() {
        this.gqT.start();
        this.amP.setVisibility(8);
        this.kTI.setVisibility(8);
        this.fMO.dBV();
        showProgress();
        this.kTR.setVisibility(8);
        this.mwA.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mxc && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amY)) {
            this.mxc = false;
            this.mxd = true;
            gb(this.mVideoUrl, this.amY);
        }
    }

    public void aSi() {
        if (this.gqT.isPlaying() && this.mwX) {
            dBw();
        }
        this.gqT.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gqT.isPlaying() && this.mwX) {
            dBw();
        }
        e.mY().removeCallbacks(this.abl);
        e.mY().removeCallbacks(this.kUq);
        this.gqT.stopPlayback();
        this.abf = false;
        this.mxe = false;
        this.mStartPosition = 0;
        cRo();
    }

    public void dBw() {
        n.dBZ().bD(this.mVideoUrl, this.gqT.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU(boolean z) {
        this.kTI.setVisibility(0);
        this.kTR.setVisibility(0);
        this.mwA.setVisibility(8);
        this.fMO.dBV();
        this.mwx.setVisibility(8);
        this.ime.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.amP.setVisibility(z ? 0 : 8);
    }

    public void cRo() {
        wU(true);
    }

    public boolean rM() {
        if (this.gqT == null) {
            return false;
        }
        return this.gqT.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gqT == null) {
            return 0;
        }
        return this.gqT.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gqT != null) {
            this.mwx.setVisibility(0);
            this.gaB = ((this.gqT.getDuration() / 200) / 50) * 50;
            if (this.gaB < 50) {
                this.gaB = 50;
            } else if (this.gaB > 500) {
                this.gaB = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaB - (this.gqT.getCurrentPosition() % this.gaB));
        }
    }

    private void dBx() {
        a(this.mVideoUrl, this.amY, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dBy();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mwZ = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.lZN && !g.dTL().dTM()) {
            this.lZE.setVisibility(0);
            this.lZE.setData(this.mDL.getDuration(), this.mDL.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dBy() {
        if (j.isMobileNet()) {
            g.dTL().gG(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.amP.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ime) {
            dBx();
        } else if (view == this) {
            TiebaStatic.log(new ar("c13199").al("obj_locate", 2).dY("tid", this.amY));
            dvo();
        } else if (view == this.mwA) {
            gb(this.mVideoUrl, this.amY);
        } else if (view == this.lZE.getTvPlay()) {
            this.lZN = true;
            this.lZE.setVisibility(8);
            gb(this.mVideoUrl, this.amY);
        } else if (view == this.lZE.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mY().removeCallbacks(this.abl);
        e.mY().removeCallbacks(this.kUq);
        e.mY().removeCallbacks(this.mxk);
        this.mHandler.removeMessages(1);
        this.kUm.unregister(getContext());
    }
}
