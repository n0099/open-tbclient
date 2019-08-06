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
import com.baidu.tieba.R;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int cXE;
    private MediaController.MediaPlayerControl cXF;
    private SeekBar dgT;
    private Formatter gxk;
    private StringBuilder igA;
    private TextView igy;
    private TextView igz;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.cXE = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cXF != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cXE - (PbChudianProcessBar.this.aDh() % PbChudianProcessBar.this.cXE));
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
        this.cXE = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cXF != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cXE - (PbChudianProcessBar.this.aDh() % PbChudianProcessBar.this.cXE));
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
        this.cXE = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.cXF != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.cXE - (PbChudianProcessBar.this.aDh() % PbChudianProcessBar.this.cXE));
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
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.chudian_process_bar, (ViewGroup) this, true);
        this.igy = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.igz = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.dgT = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.dgT.setEnabled(false);
        this.dgT.setThumb(null);
        this.igA = new StringBuilder();
        this.gxk = new Formatter(this.igA, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXF = mediaPlayerControl;
    }

    public void t(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dgT.setProgress(0);
        this.igy.setText(em(j));
        this.igz.setText(em(j2));
    }

    public void caz() {
        if (this.cXF != null) {
            this.cXE = ((this.cXF.getDuration() / 200) / 50) * 50;
            if (this.cXE < 50) {
                this.cXE = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXE - (this.cXF.getCurrentPosition() % this.cXE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDh() {
        if (this.cXF == null) {
            return 0;
        }
        int currentPosition = this.cXF.getCurrentPosition();
        int duration = this.cXF.getDuration();
        if (this.dgT != null) {
            if (duration > 0) {
                this.dgT.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cXF.getBufferPercentage();
        }
        if (this.igy != null && duration > 0) {
            this.igy.setText(em(currentPosition));
        }
        if (this.igz != null) {
            this.igz.setText(em(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String em(long j) {
        this.igA.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gxk.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gxk.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
