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
    private int blG;
    private MediaController.MediaPlayerControl blH;
    private boolean blK;
    private Formatter eax;
    private TextView fLY;
    private TextView fLZ;
    private StringBuilder fMa;
    private Handler mHandler;
    private View mRootView;
    private SeekBar mSeekBar;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.blG = 50;
        this.blK = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.blK && PbChudianProcessBar.this.blH != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.blG - (PbChudianProcessBar.this.QD() % PbChudianProcessBar.this.blG));
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
        this.blG = 50;
        this.blK = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.blK && PbChudianProcessBar.this.blH != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.blG - (PbChudianProcessBar.this.QD() % PbChudianProcessBar.this.blG));
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
        this.blG = 50;
        this.blK = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.blK && PbChudianProcessBar.this.blH != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.blG - (PbChudianProcessBar.this.QD() % PbChudianProcessBar.this.blG));
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
        this.fLY = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.fLZ = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.mSeekBar = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.mSeekBar.setEnabled(false);
        this.mSeekBar.setThumb(null);
        this.fMa = new StringBuilder();
        this.eax = new Formatter(this.fMa, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.blH = mediaPlayerControl;
    }

    public void p(long j, long j2) {
        this.blK = false;
        this.mHandler.removeMessages(1);
        this.mSeekBar.setProgress(0);
        this.fLY.setText(cP(j));
        this.fLZ.setText(cP(j2));
    }

    public void bhK() {
        if (this.blH != null) {
            this.blG = ((this.blH.getDuration() / 200) / 50) * 50;
            if (this.blG < 50) {
                this.blG = 50;
            }
            this.blK = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.blG - (this.blH.getCurrentPosition() % this.blG));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QD() {
        if (this.blH == null) {
            return 0;
        }
        int currentPosition = this.blH.getCurrentPosition();
        int duration = this.blH.getDuration();
        if (this.mSeekBar != null) {
            if (duration > 0) {
                this.mSeekBar.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.blH.getBufferPercentage();
        }
        if (this.fLY != null && duration > 0) {
            this.fLY.setText(cP(currentPosition));
        }
        if (this.fLZ != null) {
            this.fLZ.setText(cP(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cP(long j) {
        this.fMa.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eax.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eax.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
