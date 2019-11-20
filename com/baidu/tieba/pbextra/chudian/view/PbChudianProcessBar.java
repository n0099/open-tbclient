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
    private boolean ZT;
    private int dhR;
    private MediaController.MediaPlayerControl dhS;
    private SeekBar dri;
    private Formatter gwh;
    private TextView igq;
    private TextView igr;
    private StringBuilder igs;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.dhR = 50;
        this.ZT = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.ZT && PbChudianProcessBar.this.dhS != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dhR - (PbChudianProcessBar.this.aDS() % PbChudianProcessBar.this.dhR));
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
        this.dhR = 50;
        this.ZT = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.ZT && PbChudianProcessBar.this.dhS != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dhR - (PbChudianProcessBar.this.aDS() % PbChudianProcessBar.this.dhR));
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
        this.dhR = 50;
        this.ZT = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.ZT && PbChudianProcessBar.this.dhS != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.dhR - (PbChudianProcessBar.this.aDS() % PbChudianProcessBar.this.dhR));
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
        this.igq = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.igr = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.dri = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.dri.setEnabled(false);
        this.dri.setThumb(null);
        this.igs = new StringBuilder();
        this.gwh = new Formatter(this.igs, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dhS = mediaPlayerControl;
    }

    public void z(long j, long j2) {
        this.ZT = false;
        this.mHandler.removeMessages(1);
        this.dri.setProgress(0);
        this.igq.setText(dJ(j));
        this.igr.setText(dJ(j2));
    }

    public void bYn() {
        if (this.dhS != null) {
            this.dhR = ((this.dhS.getDuration() / 200) / 50) * 50;
            if (this.dhR < 50) {
                this.dhR = 50;
            }
            this.ZT = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dhR - (this.dhS.getCurrentPosition() % this.dhR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDS() {
        if (this.dhS == null) {
            return 0;
        }
        int currentPosition = this.dhS.getCurrentPosition();
        int duration = this.dhS.getDuration();
        if (this.dri != null) {
            if (duration > 0) {
                this.dri.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dhS.getBufferPercentage();
        }
        if (this.igq != null && duration > 0) {
            this.igq.setText(dJ(currentPosition));
        }
        if (this.igr != null) {
            this.igr.setText(dJ(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String dJ(long j) {
        this.igs.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gwh.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gwh.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
