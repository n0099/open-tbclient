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
    private int gaD;
    private TbCyberVideoView gqV;
    private TextView hMA;
    private VideoLoadingProgressView.a ijr;
    private View imh;
    private View kTK;
    private ImageView kTT;
    private CallStateReceiver kUo;
    private CyberPlayerManager.OnErrorListener kUr;
    private Runnable kUs;
    private CustomMessageListener kUx;
    private VideoControllerView.b kWq;
    private PbVideoWifiTipLayout lZG;
    private boolean lZP;
    private boolean lZv;
    private i mDN;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private TextView mwC;
    private boolean mwZ;
    private ProgressBar mwz;
    private boolean mxa;
    private boolean mxb;
    private boolean mxe;
    private boolean mxf;
    private boolean mxg;
    private Runnable mxm;

    /* loaded from: classes21.dex */
    public interface a {
        void wZ(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.gaD = 50;
        this.mSkinType = 3;
        this.abf = false;
        this.mStartPosition = 0;
        this.mwZ = true;
        this.mxa = false;
        this.mxb = false;
        this.lZv = false;
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fMO.dBU();
            }
        };
        this.ijr = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.crO();
            }
        };
        this.abl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqV.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abf = true;
                    PushDialogVideoView.this.kTK.setVisibility(8);
                    PushDialogVideoView.this.imh.setVisibility(8);
                    PushDialogVideoView.this.fMO.dBV();
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
                PushDialogVideoView.this.mxg = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kTK.setVisibility(0);
                PushDialogVideoView.this.mwz.setVisibility(8);
                PushDialogVideoView.this.mwz.setProgress(PushDialogVideoView.this.mwz.getMax());
                if (PushDialogVideoView.this.gqV == null || PushDialogVideoView.this.gqV.getDuration() > 150000) {
                    PushDialogVideoView.this.wU(false);
                } else {
                    PushDialogVideoView.this.mwC.setVisibility(0);
                }
                n.dCa().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gqV != null && PushDialogVideoView.this.gqV.getDuration() <= 150000) {
                    PushDialogVideoView.this.gb(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amY);
                }
            }
        };
        this.kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.imh.setVisibility(0);
                PushDialogVideoView.this.fMO.dBW();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxe = true;
                }
                PushDialogVideoView.this.mxg = false;
                return true;
            }
        };
        this.kUs = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.imh.setVisibility(0);
                PushDialogVideoView.this.fMO.dBW();
            }
        };
        this.etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mxa) {
                    e.mY().postDelayed(PushDialogVideoView.this.mxm, 200L);
                }
            }
        };
        this.mxm = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqV == null || !PushDialogVideoView.this.mxa) {
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 200L);
                    PushDialogVideoView.this.mxa = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gqV.getCurrentPosition()) {
                    PushDialogVideoView.this.mxa = false;
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mxm, 200L);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxg = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.abl);
                e.mY().removeCallbacks(PushDialogVideoView.this.kUs);
            }
        };
        this.kUx = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gqV != null && PushDialogVideoView.this.gqV.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gqV.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gqV.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kWq != null) {
                                PushDialogVideoView.this.kWq.ur(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gaD - (duration % PushDialogVideoView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kWq = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ur(int i) {
                int duration;
                if (PushDialogVideoView.this.gqV != null && (duration = PushDialogVideoView.this.gqV.getDuration()) > 0 && PushDialogVideoView.this.mwz != null) {
                    PushDialogVideoView.this.mwz.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaD = 50;
        this.mSkinType = 3;
        this.abf = false;
        this.mStartPosition = 0;
        this.mwZ = true;
        this.mxa = false;
        this.mxb = false;
        this.lZv = false;
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fMO.dBU();
            }
        };
        this.ijr = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.crO();
            }
        };
        this.abl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqV.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abf = true;
                    PushDialogVideoView.this.kTK.setVisibility(8);
                    PushDialogVideoView.this.imh.setVisibility(8);
                    PushDialogVideoView.this.fMO.dBV();
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
                PushDialogVideoView.this.mxg = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kTK.setVisibility(0);
                PushDialogVideoView.this.mwz.setVisibility(8);
                PushDialogVideoView.this.mwz.setProgress(PushDialogVideoView.this.mwz.getMax());
                if (PushDialogVideoView.this.gqV == null || PushDialogVideoView.this.gqV.getDuration() > 150000) {
                    PushDialogVideoView.this.wU(false);
                } else {
                    PushDialogVideoView.this.mwC.setVisibility(0);
                }
                n.dCa().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gqV != null && PushDialogVideoView.this.gqV.getDuration() <= 150000) {
                    PushDialogVideoView.this.gb(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amY);
                }
            }
        };
        this.kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.imh.setVisibility(0);
                PushDialogVideoView.this.fMO.dBW();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxe = true;
                }
                PushDialogVideoView.this.mxg = false;
                return true;
            }
        };
        this.kUs = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.imh.setVisibility(0);
                PushDialogVideoView.this.fMO.dBW();
            }
        };
        this.etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mxa) {
                    e.mY().postDelayed(PushDialogVideoView.this.mxm, 200L);
                }
            }
        };
        this.mxm = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqV == null || !PushDialogVideoView.this.mxa) {
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 200L);
                    PushDialogVideoView.this.mxa = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gqV.getCurrentPosition()) {
                    PushDialogVideoView.this.mxa = false;
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mxm, 200L);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxg = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.abl);
                e.mY().removeCallbacks(PushDialogVideoView.this.kUs);
            }
        };
        this.kUx = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gqV != null && PushDialogVideoView.this.gqV.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gqV.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gqV.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kWq != null) {
                                PushDialogVideoView.this.kWq.ur(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gaD - (duration % PushDialogVideoView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kWq = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ur(int i) {
                int duration;
                if (PushDialogVideoView.this.gqV != null && (duration = PushDialogVideoView.this.gqV.getDuration()) > 0 && PushDialogVideoView.this.mwz != null) {
                    PushDialogVideoView.this.mwz.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaD = 50;
        this.mSkinType = 3;
        this.abf = false;
        this.mStartPosition = 0;
        this.mwZ = true;
        this.mxa = false;
        this.mxb = false;
        this.lZv = false;
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fMO.dBU();
            }
        };
        this.ijr = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.crO();
            }
        };
        this.abl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqV.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abf = true;
                    PushDialogVideoView.this.kTK.setVisibility(8);
                    PushDialogVideoView.this.imh.setVisibility(8);
                    PushDialogVideoView.this.fMO.dBV();
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
                PushDialogVideoView.this.mxg = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kTK.setVisibility(0);
                PushDialogVideoView.this.mwz.setVisibility(8);
                PushDialogVideoView.this.mwz.setProgress(PushDialogVideoView.this.mwz.getMax());
                if (PushDialogVideoView.this.gqV == null || PushDialogVideoView.this.gqV.getDuration() > 150000) {
                    PushDialogVideoView.this.wU(false);
                } else {
                    PushDialogVideoView.this.mwC.setVisibility(0);
                }
                n.dCa().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gqV != null && PushDialogVideoView.this.gqV.getDuration() <= 150000) {
                    PushDialogVideoView.this.gb(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amY);
                }
            }
        };
        this.kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.imh.setVisibility(0);
                PushDialogVideoView.this.fMO.dBW();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mxe = true;
                }
                PushDialogVideoView.this.mxg = false;
                return true;
            }
        };
        this.kUs = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.imh.setVisibility(0);
                PushDialogVideoView.this.fMO.dBW();
            }
        };
        this.etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mxa) {
                    e.mY().postDelayed(PushDialogVideoView.this.mxm, 200L);
                }
            }
        };
        this.mxm = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gqV == null || !PushDialogVideoView.this.mxa) {
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 200L);
                    PushDialogVideoView.this.mxa = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gqV.getCurrentPosition()) {
                    PushDialogVideoView.this.mxa = false;
                    e.mY().postDelayed(PushDialogVideoView.this.abl, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mxm, 200L);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abf = false;
                PushDialogVideoView.this.mxg = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.abl);
                e.mY().removeCallbacks(PushDialogVideoView.this.kUs);
            }
        };
        this.kUx = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gqV != null && PushDialogVideoView.this.gqV.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gqV.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gqV.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kWq != null) {
                                PushDialogVideoView.this.kWq.ur(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gaD - (duration % PushDialogVideoView.this.gaD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kWq = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ur(int i2) {
                int duration;
                if (PushDialogVideoView.this.gqV != null && (duration = PushDialogVideoView.this.gqV.getDuration()) > 0 && PushDialogVideoView.this.mwz != null) {
                    PushDialogVideoView.this.mwz.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gqV = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gqV.setPlayMode("2");
        this.gqV.setStageType(null);
        this.fMO = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fMO.setLoadingAnimationListener(this.ijr);
        this.mwz = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mwz.setMax(this.mWidth);
        this.mwz.setProgress(0);
        this.kTK = findViewById(R.id.black_mask);
        this.imh = findViewById(R.id.layout_error);
        this.kTT = (ImageView) findViewById(R.id.img_play);
        this.mwC = (TextView) findViewById(R.id.txt_replay);
        this.hMA = (TextView) findViewById(R.id.push_dialog_video_time);
        this.amP = (TbImageView) findViewById(R.id.video_thumbnail);
        this.lZG = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.amP.setDefaultErrorResource(0);
        this.amP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kUo = new CallStateReceiver();
        this.kUo.register(context);
        this.imh.setOnClickListener(this);
        this.mwC.setOnClickListener(this);
        this.lZG.setOnPlayClickListener(this);
        this.lZG.setFreeClickListener(this);
        setOnClickListener(this);
        this.gqV.setOnPreparedListener(this.ety);
        this.gqV.setOnCompletionListener(this.etA);
        this.gqV.setOnErrorListener(this.kUr);
        this.gqV.setOnSeekCompleteListener(this.etD);
        this.gqV.setOnSurfaceDestroyedListener(this.fMW);
        onChangeSkinType();
    }

    public void onPause() {
        if (rM()) {
            this.lZv = true;
            aSi();
            return;
        }
        this.lZv = false;
        aSi();
    }

    public void onResume() {
        if (this.lZv) {
            aSj();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kUx);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mDN = iVar;
        this.hMA.setText(au.stringForVideoTime(this.mDN.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amY = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gqV.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        if (this.gqV != null) {
            if (this.mxg) {
                this.gqV.start();
                this.mxg = false;
            }
            e.mY().removeCallbacks(this.abl);
            e.mY().postDelayed(this.abl, 20L);
            e.mY().removeCallbacks(this.kUs);
            this.mStartPosition = n.dCa().Ro(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gqV.seekTo(this.mStartPosition);
                if (!this.mxf) {
                    showProgress();
                    e.mY().removeCallbacks(this.abl);
                }
                this.mxa = true;
            }
        }
    }

    public void dvp() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gqV.isPlaying()) {
            aSi();
        } else if (this.abf) {
            aSj();
        } else {
            dBy();
        }
    }

    public void setPauseState() {
        this.fMO.dBW();
        this.kTT.setVisibility(0);
        this.mwC.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mxb) {
            gc(str, str2);
        } else {
            gb(str, str2);
        }
        if (aVar != null) {
            aVar.wZ(z);
        }
    }

    public void gb(String str, String str2) {
        dBz();
        this.mxg = true;
        setVideoUrl(str, str2);
        this.gqV.setVideoPath(str, str2);
        this.fMO.startLoading();
        this.amP.setVisibility(0);
        this.kTT.setVisibility(8);
        this.mwC.setVisibility(8);
        this.imh.setVisibility(8);
        e.mY().removeCallbacks(this.kUs);
        e.mY().postDelayed(this.kUs, 60000L);
    }

    public void gc(String str, String str2) {
        dBz();
        this.mxg = true;
        this.fMO.startLoading();
        this.amP.setVisibility(0);
        this.kTT.setVisibility(8);
        this.mwC.setVisibility(8);
        this.imh.setVisibility(8);
        e.mY().removeCallbacks(this.kUs);
        e.mY().postDelayed(this.kUs, 60000L);
    }

    public void aSj() {
        this.gqV.start();
        this.amP.setVisibility(8);
        this.kTK.setVisibility(8);
        this.fMO.dBW();
        showProgress();
        this.kTT.setVisibility(8);
        this.mwC.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mxe && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amY)) {
            this.mxe = false;
            this.mxf = true;
            gb(this.mVideoUrl, this.amY);
        }
    }

    public void aSi() {
        if (this.gqV.isPlaying() && this.mwZ) {
            dBx();
        }
        this.gqV.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gqV.isPlaying() && this.mwZ) {
            dBx();
        }
        e.mY().removeCallbacks(this.abl);
        e.mY().removeCallbacks(this.kUs);
        this.gqV.stopPlayback();
        this.abf = false;
        this.mxg = false;
        this.mStartPosition = 0;
        cRp();
    }

    public void dBx() {
        n.dCa().bD(this.mVideoUrl, this.gqV.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU(boolean z) {
        this.kTK.setVisibility(0);
        this.kTT.setVisibility(0);
        this.mwC.setVisibility(8);
        this.fMO.dBW();
        this.mwz.setVisibility(8);
        this.imh.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.amP.setVisibility(z ? 0 : 8);
    }

    public void cRp() {
        wU(true);
    }

    public boolean rM() {
        if (this.gqV == null) {
            return false;
        }
        return this.gqV.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gqV == null) {
            return 0;
        }
        return this.gqV.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gqV != null) {
            this.mwz.setVisibility(0);
            this.gaD = ((this.gqV.getDuration() / 200) / 50) * 50;
            if (this.gaD < 50) {
                this.gaD = 50;
            } else if (this.gaD > 500) {
                this.gaD = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaD - (this.gqV.getCurrentPosition() % this.gaD));
        }
    }

    private void dBy() {
        a(this.mVideoUrl, this.amY, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dBz();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mxb = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.lZP && !g.dTM().dTN()) {
            this.lZG.setVisibility(0);
            this.lZG.setData(this.mDN.getDuration(), this.mDN.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dBz() {
        if (j.isMobileNet()) {
            g.dTM().gG(getContext());
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
        if (view == this.imh) {
            dBy();
        } else if (view == this) {
            TiebaStatic.log(new ar("c13199").al("obj_locate", 2).dY("tid", this.amY));
            dvp();
        } else if (view == this.mwC) {
            gb(this.mVideoUrl, this.amY);
        } else if (view == this.lZG.getTvPlay()) {
            this.lZP = true;
            this.lZG.setVisibility(8);
            gb(this.mVideoUrl, this.amY);
        } else if (view == this.lZG.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mY().removeCallbacks(this.kUs);
        e.mY().removeCallbacks(this.mxm);
        this.mHandler.removeMessages(1);
        this.kUo.unregister(getContext());
    }
}
