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
    private int cNL;
    private MediaController.MediaPlayerControl cNM;
    private Formatter fZb;
    private TextView hHp;
    private TextView hHq;
    private SeekBar hHr;
    private StringBuilder hHs;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cNL = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cNM != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cNL - (PbChudianProcessBar.this.awK() % PbChudianProcessBar.this.cNL));
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
        this.cNL = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cNM != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cNL - (PbChudianProcessBar.this.awK() % PbChudianProcessBar.this.cNL));
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
        this.cNL = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cNM != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cNL - (PbChudianProcessBar.this.awK() % PbChudianProcessBar.this.cNL));
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
        this.hHp = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.hHq = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.hHr = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.hHr.setEnabled(false);
        this.hHr.setThumb(null);
        this.hHs = new StringBuilder();
        this.fZb = new Formatter(this.hHs, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNM = mediaPlayerControl;
    }

    public void s(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.hHr.setProgress(0);
        this.hHp.setText(dE(j));
        this.hHq.setText(dE(j2));
    }

    public void bPy() {
        if (this.cNM != null) {
            this.cNL = ((this.cNM.getDuration() / 200) / 50) * 50;
            if (this.cNL < 50) {
                this.cNL = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNL - (this.cNM.getCurrentPosition() % this.cNL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awK() {
        if (this.cNM == null) {
            return 0;
        }
        int currentPosition = this.cNM.getCurrentPosition();
        int duration = this.cNM.getDuration();
        if (this.hHr != null) {
            if (duration > 0) {
                this.hHr.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cNM.getBufferPercentage();
        }
        if (this.hHp != null && duration > 0) {
            this.hHp.setText(dE(currentPosition));
        }
        if (this.hHq != null) {
            this.hHq.setText(dE(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String dE(long j) {
        this.hHs.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.fZb.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.fZb.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
