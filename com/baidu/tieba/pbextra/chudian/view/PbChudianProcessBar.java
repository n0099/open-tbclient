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
import com.baidu.tieba.d;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int cNO;
    private MediaController.MediaPlayerControl cNP;
    private Formatter fYP;
    private TextView hHc;
    private TextView hHd;
    private SeekBar hHe;
    private StringBuilder hHf;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cNO = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cNP != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cNO - (PbChudianProcessBar.this.awH() % PbChudianProcessBar.this.cNO));
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
        this.cNO = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cNP != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cNO - (PbChudianProcessBar.this.awH() % PbChudianProcessBar.this.cNO));
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
        this.cNO = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cNP != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cNO - (PbChudianProcessBar.this.awH() % PbChudianProcessBar.this.cNO));
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
        this.mRootView = LayoutInflater.from(context).inflate(d.h.chudian_process_bar, (ViewGroup) this, true);
        this.hHc = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.hHd = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.hHe = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.hHe.setEnabled(false);
        this.hHe.setThumb(null);
        this.hHf = new StringBuilder();
        this.fYP = new Formatter(this.hHf, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNP = mediaPlayerControl;
    }

    public void s(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.hHe.setProgress(0);
        this.hHc.setText(dE(j));
        this.hHd.setText(dE(j2));
    }

    public void bPv() {
        if (this.cNP != null) {
            this.cNO = ((this.cNP.getDuration() / 200) / 50) * 50;
            if (this.cNO < 50) {
                this.cNO = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNO - (this.cNP.getCurrentPosition() % this.cNO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awH() {
        if (this.cNP == null) {
            return 0;
        }
        int currentPosition = this.cNP.getCurrentPosition();
        int duration = this.cNP.getDuration();
        if (this.hHe != null) {
            if (duration > 0) {
                this.hHe.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cNP.getBufferPercentage();
        }
        if (this.hHc != null && duration > 0) {
            this.hHc.setText(dE(currentPosition));
        }
        if (this.hHd != null) {
            this.hHd.setText(dE(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String dE(long j) {
        this.hHf.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.fYP.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.fYP.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
