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
import com.baidu.tieba.R;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int cVZ;
    private MediaController.MediaPlayerControl cWa;
    private SeekBar dfh;
    private Formatter gqd;
    private TextView hZc;
    private TextView hZd;
    private StringBuilder hZe;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cVZ = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWa != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cVZ - (PbChudianProcessBar.this.aBN() % PbChudianProcessBar.this.cVZ));
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
        this.cVZ = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWa != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cVZ - (PbChudianProcessBar.this.aBN() % PbChudianProcessBar.this.cVZ));
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
        this.cVZ = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWa != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cVZ - (PbChudianProcessBar.this.aBN() % PbChudianProcessBar.this.cVZ));
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
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.chudian_process_bar, (ViewGroup) this, true);
        this.hZc = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.hZd = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.dfh = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.dfh.setEnabled(false);
        this.dfh.setThumb(null);
        this.hZe = new StringBuilder();
        this.gqd = new Formatter(this.hZe, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWa = mediaPlayerControl;
    }

    public void t(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dfh.setProgress(0);
        this.hZc.setText(ec(j));
        this.hZd.setText(ec(j2));
    }

    public void bXo() {
        if (this.cWa != null) {
            this.cVZ = ((this.cWa.getDuration() / 200) / 50) * 50;
            if (this.cVZ < 50) {
                this.cVZ = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cVZ - (this.cWa.getCurrentPosition() % this.cVZ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBN() {
        if (this.cWa == null) {
            return 0;
        }
        int currentPosition = this.cWa.getCurrentPosition();
        int duration = this.cWa.getDuration();
        if (this.dfh != null) {
            if (duration > 0) {
                this.dfh.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cWa.getBufferPercentage();
        }
        if (this.hZc != null && duration > 0) {
            this.hZc.setText(ec(currentPosition));
        }
        if (this.hZd != null) {
            this.hZd.setText(ec(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String ec(long j) {
        this.hZe.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gqd.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gqd.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
