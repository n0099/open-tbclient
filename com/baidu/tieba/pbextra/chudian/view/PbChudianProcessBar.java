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
/* loaded from: classes3.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int bdv;
    private MediaController.MediaPlayerControl bdw;
    private boolean bdz;
    private Formatter dOh;
    private TextView fzA;
    private TextView fzB;
    private StringBuilder fzC;
    private Handler mHandler;
    private View mRootView;
    private SeekBar mSeekBar;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bdv = 50;
        this.bdz = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bdz && PbChudianProcessBar.this.bdw != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bdv - (PbChudianProcessBar.this.Nf() % PbChudianProcessBar.this.bdv));
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
        this.bdv = 50;
        this.bdz = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bdz && PbChudianProcessBar.this.bdw != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bdv - (PbChudianProcessBar.this.Nf() % PbChudianProcessBar.this.bdv));
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
        this.bdv = 50;
        this.bdz = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bdz && PbChudianProcessBar.this.bdw != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bdv - (PbChudianProcessBar.this.Nf() % PbChudianProcessBar.this.bdv));
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
        this.mRootView = LayoutInflater.from(context).inflate(d.i.chudian_process_bar, (ViewGroup) this, true);
        this.fzA = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.fzB = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.mSeekBar = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.mSeekBar.setEnabled(false);
        this.mSeekBar.setThumb(null);
        this.fzC = new StringBuilder();
        this.dOh = new Formatter(this.fzC, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdw = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.bdz = false;
        this.mHandler.removeMessages(1);
        this.mSeekBar.setProgress(0);
        this.fzA.setText(cJ(j));
        this.fzB.setText(cJ(j2));
    }

    public void bcK() {
        if (this.bdw != null) {
            this.bdv = ((this.bdw.getDuration() / 200) / 50) * 50;
            if (this.bdv < 50) {
                this.bdv = 50;
            }
            this.bdz = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdv - (this.bdw.getCurrentPosition() % this.bdv));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Nf() {
        if (this.bdw == null) {
            return 0;
        }
        int currentPosition = this.bdw.getCurrentPosition();
        int duration = this.bdw.getDuration();
        if (this.mSeekBar != null) {
            if (duration > 0) {
                this.mSeekBar.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bdw.getBufferPercentage();
        }
        if (this.fzA != null && duration > 0) {
            this.fzA.setText(cJ(currentPosition));
        }
        if (this.fzB != null) {
            this.fzB.setText(cJ(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cJ(long j) {
        this.fzC.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.dOh.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.dOh.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
