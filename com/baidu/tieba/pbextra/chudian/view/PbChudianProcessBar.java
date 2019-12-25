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
/* loaded from: classes6.dex */
public class PbChudianProcessBar extends RelativeLayout {
    private boolean ahQ;
    private int dVE;
    private MediaController.MediaPlayerControl dVF;
    private SeekBar ebi;
    private Formatter hkp;
    private TextView iYs;
    private TextView iYt;
    private StringBuilder iYu;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.dVE = 50;
        this.ahQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.ahQ && PbChudianProcessBar.this.dVF != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dVE - (PbChudianProcessBar.this.aVL() % PbChudianProcessBar.this.dVE));
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
        this.dVE = 50;
        this.ahQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.ahQ && PbChudianProcessBar.this.dVF != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dVE - (PbChudianProcessBar.this.aVL() % PbChudianProcessBar.this.dVE));
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
        this.dVE = 50;
        this.ahQ = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.ahQ && PbChudianProcessBar.this.dVF != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dVE - (PbChudianProcessBar.this.aVL() % PbChudianProcessBar.this.dVE));
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
        this.iYs = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.iYt = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.ebi = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.ebi.setEnabled(false);
        this.ebi.setThumb(null);
        this.iYu = new StringBuilder();
        this.hkp = new Formatter(this.iYu, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVF = mediaPlayerControl;
    }

    public void E(long j, long j2) {
        this.ahQ = false;
        this.mHandler.removeMessages(1);
        this.ebi.setProgress(0);
        this.iYs.setText(ep(j));
        this.iYt.setText(ep(j2));
    }

    public void crG() {
        if (this.dVF != null) {
            this.dVE = ((this.dVF.getDuration() / 200) / 50) * 50;
            if (this.dVE < 50) {
                this.dVE = 50;
            }
            this.ahQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVE - (this.dVF.getCurrentPosition() % this.dVE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aVL() {
        if (this.dVF == null) {
            return 0;
        }
        int currentPosition = this.dVF.getCurrentPosition();
        int duration = this.dVF.getDuration();
        if (this.ebi != null) {
            if (duration > 0) {
                this.ebi.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dVF.getBufferPercentage();
        }
        if (this.iYs != null && duration > 0) {
            this.iYs.setText(ep(currentPosition));
        }
        if (this.iYt != null) {
            this.iYt.setText(ep(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String ep(long j) {
        this.iYu.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.hkp.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.hkp.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
