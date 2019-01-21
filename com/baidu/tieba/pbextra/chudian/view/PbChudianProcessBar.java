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
    private int bCH;
    private MediaController.MediaPlayerControl bCI;
    private Formatter eJa;
    private TextView gre;
    private TextView grf;
    private SeekBar grg;
    private StringBuilder grh;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bCH = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bCI != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bCH - (PbChudianProcessBar.this.WK() % PbChudianProcessBar.this.bCH));
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
        this.bCH = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bCI != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bCH - (PbChudianProcessBar.this.WK() % PbChudianProcessBar.this.bCH));
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
        this.bCH = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bCI != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bCH - (PbChudianProcessBar.this.WK() % PbChudianProcessBar.this.bCH));
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
        this.gre = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.grf = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.grg = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.grg.setEnabled(false);
        this.grg.setThumb(null);
        this.grh = new StringBuilder();
        this.eJa = new Formatter(this.grh, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bCI = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.grg.setProgress(0);
        this.gre.setText(cZ(j));
        this.grf.setText(cZ(j2));
    }

    public void bpa() {
        if (this.bCI != null) {
            this.bCH = ((this.bCI.getDuration() / 200) / 50) * 50;
            if (this.bCH < 50) {
                this.bCH = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bCH - (this.bCI.getCurrentPosition() % this.bCH));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int WK() {
        if (this.bCI == null) {
            return 0;
        }
        int currentPosition = this.bCI.getCurrentPosition();
        int duration = this.bCI.getDuration();
        if (this.grg != null) {
            if (duration > 0) {
                this.grg.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bCI.getBufferPercentage();
        }
        if (this.gre != null && duration > 0) {
            this.gre.setText(cZ(currentPosition));
        }
        if (this.grf != null) {
            this.grf.setText(cZ(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cZ(long j) {
        this.grh.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eJa.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eJa.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
