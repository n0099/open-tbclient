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
    private int cWb;
    private MediaController.MediaPlayerControl cWc;
    private SeekBar dfj;
    private Formatter gqg;
    private TextView hZg;
    private TextView hZh;
    private StringBuilder hZi;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cWb = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWc != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cWb - (PbChudianProcessBar.this.aBQ() % PbChudianProcessBar.this.cWb));
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
        this.cWb = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWc != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cWb - (PbChudianProcessBar.this.aBQ() % PbChudianProcessBar.this.cWb));
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
        this.cWb = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cWc != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cWb - (PbChudianProcessBar.this.aBQ() % PbChudianProcessBar.this.cWb));
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
        this.hZg = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.hZh = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.dfj = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.dfj.setEnabled(false);
        this.dfj.setThumb(null);
        this.hZi = new StringBuilder();
        this.gqg = new Formatter(this.hZi, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWc = mediaPlayerControl;
    }

    public void t(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dfj.setProgress(0);
        this.hZg.setText(ec(j));
        this.hZh.setText(ec(j2));
    }

    public void bXs() {
        if (this.cWc != null) {
            this.cWb = ((this.cWc.getDuration() / 200) / 50) * 50;
            if (this.cWb < 50) {
                this.cWb = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cWb - (this.cWc.getCurrentPosition() % this.cWb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBQ() {
        if (this.cWc == null) {
            return 0;
        }
        int currentPosition = this.cWc.getCurrentPosition();
        int duration = this.cWc.getDuration();
        if (this.dfj != null) {
            if (duration > 0) {
                this.dfj.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cWc.getBufferPercentage();
        }
        if (this.hZg != null && duration > 0) {
            this.hZg.setText(ec(currentPosition));
        }
        if (this.hZh != null) {
            this.hZh.setText(ec(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String ec(long j) {
        this.hZi.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gqg.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gqg.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
