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
    private int bBQ;
    private MediaController.MediaPlayerControl bBR;
    private Formatter eFw;
    private TextView gni;
    private TextView gnj;
    private SeekBar gnk;
    private StringBuilder gnl;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bBQ = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bBR != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bBQ - (PbChudianProcessBar.this.Wl() % PbChudianProcessBar.this.bBQ));
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
        this.bBQ = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bBR != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bBQ - (PbChudianProcessBar.this.Wl() % PbChudianProcessBar.this.bBQ));
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
        this.bBQ = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bBR != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bBQ - (PbChudianProcessBar.this.Wl() % PbChudianProcessBar.this.bBQ));
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
        this.gni = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.gnj = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.gnk = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.gnk.setEnabled(false);
        this.gnk.setThumb(null);
        this.gnl = new StringBuilder();
        this.eFw = new Formatter(this.gnl, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bBR = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.gnk.setProgress(0);
        this.gni.setText(cU(j));
        this.gnj.setText(cU(j2));
    }

    public void bnG() {
        if (this.bBR != null) {
            this.bBQ = ((this.bBR.getDuration() / 200) / 50) * 50;
            if (this.bBQ < 50) {
                this.bBQ = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bBQ - (this.bBR.getCurrentPosition() % this.bBQ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Wl() {
        if (this.bBR == null) {
            return 0;
        }
        int currentPosition = this.bBR.getCurrentPosition();
        int duration = this.bBR.getDuration();
        if (this.gnk != null) {
            if (duration > 0) {
                this.gnk.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bBR.getBufferPercentage();
        }
        if (this.gni != null && duration > 0) {
            this.gni.setText(cU(currentPosition));
        }
        if (this.gnj != null) {
            this.gnj.setText(cU(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cU(long j) {
        this.gnl.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eFw.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eFw.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
