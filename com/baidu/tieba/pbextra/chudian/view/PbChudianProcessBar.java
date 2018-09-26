package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.e;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int btD;
    private MediaController.MediaPlayerControl btE;
    private Formatter epw;
    private TextView fXt;
    private TextView fXu;
    private SeekBar fXv;
    private StringBuilder fXw;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.btD = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.btE != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.btD - (PbChudianProcessBar.this.Ta() % PbChudianProcessBar.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public PbChudianProcessBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btD = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.btE != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.btD - (PbChudianProcessBar.this.Ta() % PbChudianProcessBar.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public PbChudianProcessBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btD = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.btE != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.btD - (PbChudianProcessBar.this.Ta() % PbChudianProcessBar.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.chudian_process_bar, (ViewGroup) this, true);
        this.fXt = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.fXu = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.fXv = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.fXv.setEnabled(false);
        this.fXv.setThumb(null);
        this.fXw = new StringBuilder();
        this.epw = new Formatter(this.fXw, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.btE = mediaPlayerControl;
    }

    public void n(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fXv.setProgress(0);
        this.fXt.setText(cL(j));
        this.fXu.setText(cL(j2));
    }

    public void bjf() {
        if (this.btE != null) {
            this.btD = ((this.btE.getDuration() / 200) / 50) * 50;
            if (this.btD < 50) {
                this.btD = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.btD - (this.btE.getCurrentPosition() % this.btD));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ta() {
        if (this.btE == null) {
            return 0;
        }
        int currentPosition = this.btE.getCurrentPosition();
        int duration = this.btE.getDuration();
        if (this.fXv != null) {
            if (duration > 0) {
                this.fXv.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.btE.getBufferPercentage();
        }
        if (this.fXt != null && duration > 0) {
            this.fXt.setText(cL(currentPosition));
        }
        if (this.fXu != null) {
            this.fXu.setText(cL(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cL(long j) {
        this.fXw.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.epw.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.epw.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
