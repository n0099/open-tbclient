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
    private int cXx;
    private MediaController.MediaPlayerControl cXy;
    private SeekBar dgM;
    private Formatter gws;
    private TextView ifw;
    private TextView ifx;
    private StringBuilder ify;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cXx = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cXy != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cXx - (PbChudianProcessBar.this.aDf() % PbChudianProcessBar.this.cXx));
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
        this.cXx = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cXy != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cXx - (PbChudianProcessBar.this.aDf() % PbChudianProcessBar.this.cXx));
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
        this.cXx = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cXy != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cXx - (PbChudianProcessBar.this.aDf() % PbChudianProcessBar.this.cXx));
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
        this.ifw = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.ifx = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.dgM = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.dgM.setEnabled(false);
        this.dgM.setThumb(null);
        this.ify = new StringBuilder();
        this.gws = new Formatter(this.ify, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXy = mediaPlayerControl;
    }

    public void t(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dgM.setProgress(0);
        this.ifw.setText(em(j));
        this.ifx.setText(em(j2));
    }

    public void cah() {
        if (this.cXy != null) {
            this.cXx = ((this.cXy.getDuration() / 200) / 50) * 50;
            if (this.cXx < 50) {
                this.cXx = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXx - (this.cXy.getCurrentPosition() % this.cXx));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDf() {
        if (this.cXy == null) {
            return 0;
        }
        int currentPosition = this.cXy.getCurrentPosition();
        int duration = this.cXy.getDuration();
        if (this.dgM != null) {
            if (duration > 0) {
                this.dgM.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cXy.getBufferPercentage();
        }
        if (this.ifw != null && duration > 0) {
            this.ifw.setText(em(currentPosition));
        }
        if (this.ifx != null) {
            this.ifx.setText(em(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String em(long j) {
        this.ify.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gws.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gws.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
