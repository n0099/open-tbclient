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
/* loaded from: classes7.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private int dVN;
    private MediaController.MediaPlayerControl dVO;
    private SeekBar ebr;
    private Formatter hnS;
    private TextView jca;
    private TextView jcb;
    private StringBuilder jcc;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.dVN = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.dVO != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dVN - (PbChudianProcessBar.this.aWe() % PbChudianProcessBar.this.dVN));
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
        this.dVN = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.dVO != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dVN - (PbChudianProcessBar.this.aWe() % PbChudianProcessBar.this.dVN));
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
        this.dVN = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.dVO != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dVN - (PbChudianProcessBar.this.aWe() % PbChudianProcessBar.this.dVN));
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
        this.jca = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.jcb = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.ebr = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.ebr.setEnabled(false);
        this.ebr.setThumb(null);
        this.jcc = new StringBuilder();
        this.hnS = new Formatter(this.jcc, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVO = mediaPlayerControl;
    }

    public void E(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.ebr.setProgress(0);
        this.jca.setText(eu(j));
        this.jcb.setText(eu(j2));
    }

    public void csP() {
        if (this.dVO != null) {
            this.dVN = ((this.dVO.getDuration() / 200) / 50) * 50;
            if (this.dVN < 50) {
                this.dVN = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVN - (this.dVO.getCurrentPosition() % this.dVN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aWe() {
        if (this.dVO == null) {
            return 0;
        }
        int currentPosition = this.dVO.getCurrentPosition();
        int duration = this.dVO.getDuration();
        if (this.ebr != null) {
            if (duration > 0) {
                this.ebr.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dVO.getBufferPercentage();
        }
        if (this.jca != null && duration > 0) {
            this.jca.setText(eu(currentPosition));
        }
        if (this.jcb != null) {
            this.jcb.setText(eu(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String eu(long j) {
        this.jcc.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.hnS.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.hnS.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
