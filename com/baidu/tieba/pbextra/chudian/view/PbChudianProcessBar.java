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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.e;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int bBT;
    private MediaController.MediaPlayerControl bBU;
    private Formatter eIn;
    private TextView gpZ;
    private TextView gqa;
    private SeekBar gqb;
    private StringBuilder gqc;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bBT = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bBU != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bBT - (PbChudianProcessBar.this.Wn() % PbChudianProcessBar.this.bBT));
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
        this.bBT = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bBU != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bBT - (PbChudianProcessBar.this.Wn() % PbChudianProcessBar.this.bBT));
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
        this.bBT = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bBU != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bBT - (PbChudianProcessBar.this.Wn() % PbChudianProcessBar.this.bBT));
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
        this.mRootView = LayoutInflater.from(context).inflate(e.h.chudian_process_bar, (ViewGroup) this, true);
        this.gpZ = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.gqa = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.gqb = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.gqb.setEnabled(false);
        this.gqb.setThumb(null);
        this.gqc = new StringBuilder();
        this.eIn = new Formatter(this.gqc, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bBU = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.gqb.setProgress(0);
        this.gpZ.setText(cZ(j));
        this.gqa.setText(cZ(j2));
    }

    public void bor() {
        if (this.bBU != null) {
            this.bBT = ((this.bBU.getDuration() / 200) / 50) * 50;
            if (this.bBT < 50) {
                this.bBT = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bBT - (this.bBU.getCurrentPosition() % this.bBT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Wn() {
        if (this.bBU == null) {
            return 0;
        }
        int currentPosition = this.bBU.getCurrentPosition();
        int duration = this.bBU.getDuration();
        if (this.gqb != null) {
            if (duration > 0) {
                this.gqb.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bBU.getBufferPercentage();
        }
        if (this.gpZ != null && duration > 0) {
            this.gpZ.setText(cZ(currentPosition));
        }
        if (this.gqa != null) {
            this.gqa.setText(cZ(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cZ(long j) {
        this.gqc.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eIn.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eIn.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
