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
    private int byt;
    private MediaController.MediaPlayerControl byu;
    private Formatter eyH;
    private TextView ggr;
    private TextView ggs;
    private SeekBar ggt;
    private StringBuilder ggu;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.byt = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.byu != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.byt - (PbChudianProcessBar.this.Vf() % PbChudianProcessBar.this.byt));
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
        this.byt = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.byu != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.byt - (PbChudianProcessBar.this.Vf() % PbChudianProcessBar.this.byt));
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
        this.byt = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.byu != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.byt - (PbChudianProcessBar.this.Vf() % PbChudianProcessBar.this.byt));
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
        this.ggr = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.ggs = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.ggt = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.ggt.setEnabled(false);
        this.ggt.setThumb(null);
        this.ggu = new StringBuilder();
        this.eyH = new Formatter(this.ggu, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.byu = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.ggt.setProgress(0);
        this.ggr.setText(cN(j));
        this.ggs.setText(cN(j2));
    }

    public void blN() {
        if (this.byu != null) {
            this.byt = ((this.byu.getDuration() / 200) / 50) * 50;
            if (this.byt < 50) {
                this.byt = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.byt - (this.byu.getCurrentPosition() % this.byt));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Vf() {
        if (this.byu == null) {
            return 0;
        }
        int currentPosition = this.byu.getCurrentPosition();
        int duration = this.byu.getDuration();
        if (this.ggt != null) {
            if (duration > 0) {
                this.ggt.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.byu.getBufferPercentage();
        }
        if (this.ggr != null && duration > 0) {
            this.ggr.setText(cN(currentPosition));
        }
        if (this.ggs != null) {
            this.ggs.setText(cN(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cN(long j) {
        this.ggu.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eyH.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eyH.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
