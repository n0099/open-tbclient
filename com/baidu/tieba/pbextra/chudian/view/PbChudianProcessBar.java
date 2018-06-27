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
    private int bnf;
    private MediaController.MediaPlayerControl bng;
    private boolean bnj;
    private Formatter eeq;
    private TextView fQb;
    private TextView fQc;
    private StringBuilder fQd;
    private Handler mHandler;
    private View mRootView;
    private SeekBar mSeekBar;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bnf = 50;
        this.bnj = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bnj && PbChudianProcessBar.this.bng != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnf - (PbChudianProcessBar.this.Ra() % PbChudianProcessBar.this.bnf));
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
        this.bnf = 50;
        this.bnj = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bnj && PbChudianProcessBar.this.bng != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnf - (PbChudianProcessBar.this.Ra() % PbChudianProcessBar.this.bnf));
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
        this.bnf = 50;
        this.bnj = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bnj && PbChudianProcessBar.this.bng != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnf - (PbChudianProcessBar.this.Ra() % PbChudianProcessBar.this.bnf));
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
        this.fQb = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.fQc = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.mSeekBar = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.mSeekBar.setEnabled(false);
        this.mSeekBar.setThumb(null);
        this.fQd = new StringBuilder();
        this.eeq = new Formatter(this.fQd, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bng = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.bnj = false;
        this.mHandler.removeMessages(1);
        this.mSeekBar.setProgress(0);
        this.fQb.setText(cL(j));
        this.fQc.setText(cL(j2));
    }

    public void biq() {
        if (this.bng != null) {
            this.bnf = ((this.bng.getDuration() / 200) / 50) * 50;
            if (this.bnf < 50) {
                this.bnf = 50;
            }
            this.bnj = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnf - (this.bng.getCurrentPosition() % this.bnf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ra() {
        if (this.bng == null) {
            return 0;
        }
        int currentPosition = this.bng.getCurrentPosition();
        int duration = this.bng.getDuration();
        if (this.mSeekBar != null) {
            if (duration > 0) {
                this.mSeekBar.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bng.getBufferPercentage();
        }
        if (this.fQb != null && duration > 0) {
            this.fQb.setText(cL(currentPosition));
        }
        if (this.fQc != null) {
            this.fQc.setText(cL(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cL(long j) {
        this.fQd.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eeq.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eeq.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
