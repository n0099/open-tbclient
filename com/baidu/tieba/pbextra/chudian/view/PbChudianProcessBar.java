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
    private boolean bdA;
    private int bdw;
    private MediaController.MediaPlayerControl bdx;
    private Formatter dPl;
    private TextView fAD;
    private TextView fAE;
    private StringBuilder fAF;
    private Handler mHandler;
    private View mRootView;
    private SeekBar mSeekBar;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bdw = 50;
        this.bdA = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bdA && PbChudianProcessBar.this.bdx != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bdw - (PbChudianProcessBar.this.Nd() % PbChudianProcessBar.this.bdw));
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
        this.bdw = 50;
        this.bdA = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bdA && PbChudianProcessBar.this.bdx != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bdw - (PbChudianProcessBar.this.Nd() % PbChudianProcessBar.this.bdw));
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
        this.bdw = 50;
        this.bdA = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bdA && PbChudianProcessBar.this.bdx != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bdw - (PbChudianProcessBar.this.Nd() % PbChudianProcessBar.this.bdw));
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
        this.fAD = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.fAE = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.mSeekBar = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.mSeekBar.setEnabled(false);
        this.mSeekBar.setThumb(null);
        this.fAF = new StringBuilder();
        this.dPl = new Formatter(this.fAF, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdx = mediaPlayerControl;
    }

    public void o(long j, long j2) {
        this.bdA = false;
        this.mHandler.removeMessages(1);
        this.mSeekBar.setProgress(0);
        this.fAD.setText(cJ(j));
        this.fAE.setText(cJ(j2));
    }

    public void bcK() {
        if (this.bdx != null) {
            this.bdw = ((this.bdx.getDuration() / 200) / 50) * 50;
            if (this.bdw < 50) {
                this.bdw = 50;
            }
            this.bdA = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdw - (this.bdx.getCurrentPosition() % this.bdw));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Nd() {
        if (this.bdx == null) {
            return 0;
        }
        int currentPosition = this.bdx.getCurrentPosition();
        int duration = this.bdx.getDuration();
        if (this.mSeekBar != null) {
            if (duration > 0) {
                this.mSeekBar.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bdx.getBufferPercentage();
        }
        if (this.fAD != null && duration > 0) {
            this.fAD.setText(cJ(currentPosition));
        }
        if (this.fAE != null) {
            this.fAE.setText(cJ(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cJ(long j) {
        this.fAF.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.dPl.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.dPl.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
