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
    private int cZk;
    private MediaController.MediaPlayerControl cZl;
    private SeekBar diE;
    private Formatter gzb;
    private TextView iix;
    private TextView iiy;
    private StringBuilder iiz;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cZk = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cZl != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cZk - (PbChudianProcessBar.this.aDL() % PbChudianProcessBar.this.cZk));
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
        this.cZk = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cZl != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cZk - (PbChudianProcessBar.this.aDL() % PbChudianProcessBar.this.cZk));
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
        this.cZk = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cZl != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cZk - (PbChudianProcessBar.this.aDL() % PbChudianProcessBar.this.cZk));
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
        this.iix = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.iiy = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.diE = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.diE.setEnabled(false);
        this.diE.setThumb(null);
        this.iiz = new StringBuilder();
        this.gzb = new Formatter(this.iiz, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cZl = mediaPlayerControl;
    }

    public void t(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.diE.setProgress(0);
        this.iix.setText(ep(j));
        this.iiy.setText(ep(j2));
    }

    public void cbn() {
        if (this.cZl != null) {
            this.cZk = ((this.cZl.getDuration() / 200) / 50) * 50;
            if (this.cZk < 50) {
                this.cZk = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cZk - (this.cZl.getCurrentPosition() % this.cZk));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDL() {
        if (this.cZl == null) {
            return 0;
        }
        int currentPosition = this.cZl.getCurrentPosition();
        int duration = this.cZl.getDuration();
        if (this.diE != null) {
            if (duration > 0) {
                this.diE.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cZl.getBufferPercentage();
        }
        if (this.iix != null && duration > 0) {
            this.iix.setText(ep(currentPosition));
        }
        if (this.iiy != null) {
            this.iiy.setText(ep(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String ep(long j) {
        this.iiz.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gzb.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gzb.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
