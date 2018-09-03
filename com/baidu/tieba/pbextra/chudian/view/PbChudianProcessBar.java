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
import com.baidu.tieba.f;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int bnO;
    private MediaController.MediaPlayerControl bnP;
    private Formatter eid;
    private TextView fQd;
    private TextView fQe;
    private SeekBar fQf;
    private StringBuilder fQg;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bnO = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bnP != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnO - (PbChudianProcessBar.this.Rm() % PbChudianProcessBar.this.bnO));
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
        this.bnO = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bnP != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnO - (PbChudianProcessBar.this.Rm() % PbChudianProcessBar.this.bnO));
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
        this.bnO = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bnP != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bnO - (PbChudianProcessBar.this.Rm() % PbChudianProcessBar.this.bnO));
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
        this.mRootView = LayoutInflater.from(context).inflate(f.h.chudian_process_bar, (ViewGroup) this, true);
        this.fQd = (TextView) this.mRootView.findViewById(f.g.textview_cur_time);
        this.fQe = (TextView) this.mRootView.findViewById(f.g.textview_duration);
        this.fQf = (SeekBar) this.mRootView.findViewById(f.g.chudian_seek_bar);
        this.fQf.setEnabled(false);
        this.fQf.setThumb(null);
        this.fQg = new StringBuilder();
        this.eid = new Formatter(this.fQg, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bnP = mediaPlayerControl;
    }

    public void n(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fQf.setProgress(0);
        this.fQd.setText(cH(j));
        this.fQe.setText(cH(j2));
    }

    public void bgE() {
        if (this.bnP != null) {
            this.bnO = ((this.bnP.getDuration() / 200) / 50) * 50;
            if (this.bnO < 50) {
                this.bnO = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnO - (this.bnP.getCurrentPosition() % this.bnO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Rm() {
        if (this.bnP == null) {
            return 0;
        }
        int currentPosition = this.bnP.getCurrentPosition();
        int duration = this.bnP.getDuration();
        if (this.fQf != null) {
            if (duration > 0) {
                this.fQf.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bnP.getBufferPercentage();
        }
        if (this.fQd != null && duration > 0) {
            this.fQd.setText(cH(currentPosition));
        }
        if (this.fQe != null) {
            this.fQe.setText(cH(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cH(long j) {
        this.fQg.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eid.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eid.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
