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
    private int cWa;
    private MediaController.MediaPlayerControl cWb;
    private SeekBar dfi;
    private Formatter gqe;
    private TextView hZf;
    private TextView hZg;
    private StringBuilder hZh;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cWa = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWb != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cWa - (PbChudianProcessBar.this.aBQ() % PbChudianProcessBar.this.cWa));
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
        this.cWa = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWb != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cWa - (PbChudianProcessBar.this.aBQ() % PbChudianProcessBar.this.cWa));
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
        this.cWa = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWb != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cWa - (PbChudianProcessBar.this.aBQ() % PbChudianProcessBar.this.cWa));
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
        this.hZf = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.hZg = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.dfi = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.dfi.setEnabled(false);
        this.dfi.setThumb(null);
        this.hZh = new StringBuilder();
        this.gqe = new Formatter(this.hZh, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWb = mediaPlayerControl;
    }

    public void t(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dfi.setProgress(0);
        this.hZf.setText(ec(j));
        this.hZg.setText(ec(j2));
    }

    public void bXr() {
        if (this.cWb != null) {
            this.cWa = ((this.cWb.getDuration() / 200) / 50) * 50;
            if (this.cWa < 50) {
                this.cWa = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cWa - (this.cWb.getCurrentPosition() % this.cWa));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBQ() {
        if (this.cWb == null) {
            return 0;
        }
        int currentPosition = this.cWb.getCurrentPosition();
        int duration = this.cWb.getDuration();
        if (this.dfi != null) {
            if (duration > 0) {
                this.dfi.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cWb.getBufferPercentage();
        }
        if (this.hZf != null && duration > 0) {
            this.hZf.setText(ec(currentPosition));
        }
        if (this.hZg != null) {
            this.hZg.setText(ec(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String ec(long j) {
        this.hZh.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gqe.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gqe.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
