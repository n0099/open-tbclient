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
    private int bnL;
    private MediaController.MediaPlayerControl bnM;
    private boolean bnP;
    private Formatter eig;
    private TextView fQl;
    private TextView fQm;
    private SeekBar fQn;
    private StringBuilder fQo;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bnL = 50;
        this.bnP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bnP && PbChudianProcessBar.this.bnM != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnL - (PbChudianProcessBar.this.Rh() % PbChudianProcessBar.this.bnL));
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
        this.bnL = 50;
        this.bnP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bnP && PbChudianProcessBar.this.bnM != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnL - (PbChudianProcessBar.this.Rh() % PbChudianProcessBar.this.bnL));
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
        this.bnL = 50;
        this.bnP = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bnP && PbChudianProcessBar.this.bnM != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnL - (PbChudianProcessBar.this.Rh() % PbChudianProcessBar.this.bnL));
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
        this.fQl = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.fQm = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.fQn = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.fQn.setEnabled(false);
        this.fQn.setThumb(null);
        this.fQo = new StringBuilder();
        this.eig = new Formatter(this.fQo, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bnM = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.bnP = false;
        this.mHandler.removeMessages(1);
        this.fQn.setProgress(0);
        this.fQl.setText(cH(j));
        this.fQm.setText(cH(j2));
    }

    public void bgJ() {
        if (this.bnM != null) {
            this.bnL = ((this.bnM.getDuration() / 200) / 50) * 50;
            if (this.bnL < 50) {
                this.bnL = 50;
            }
            this.bnP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnL - (this.bnM.getCurrentPosition() % this.bnL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Rh() {
        if (this.bnM == null) {
            return 0;
        }
        int currentPosition = this.bnM.getCurrentPosition();
        int duration = this.bnM.getDuration();
        if (this.fQn != null) {
            if (duration > 0) {
                this.fQn.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bnM.getBufferPercentage();
        }
        if (this.fQl != null && duration > 0) {
            this.fQl.setText(cH(currentPosition));
        }
        if (this.fQm != null) {
            this.fQm.setText(cH(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cH(long j) {
        this.fQo.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eig.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eig.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
