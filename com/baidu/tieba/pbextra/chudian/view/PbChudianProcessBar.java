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
    private int bTp;
    private MediaController.MediaPlayerControl bTq;
    private boolean bTt;
    private Formatter etj;
    private TextView geO;
    private TextView geP;
    private SeekBar geQ;
    private StringBuilder geR;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bTp = 50;
        this.bTt = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTt && PbChudianProcessBar.this.bTq != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTp - (PbChudianProcessBar.this.UD() % PbChudianProcessBar.this.bTp));
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
        this.bTp = 50;
        this.bTt = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTt && PbChudianProcessBar.this.bTq != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTp - (PbChudianProcessBar.this.UD() % PbChudianProcessBar.this.bTp));
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
        this.bTp = 50;
        this.bTt = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTt && PbChudianProcessBar.this.bTq != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTp - (PbChudianProcessBar.this.UD() % PbChudianProcessBar.this.bTp));
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
        this.geO = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.geP = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.geQ = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.geQ.setEnabled(false);
        this.geQ.setThumb(null);
        this.geR = new StringBuilder();
        this.etj = new Formatter(this.geR, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTq = mediaPlayerControl;
    }

    public void l(long j, long j2) {
        this.bTt = false;
        this.mHandler.removeMessages(1);
        this.geQ.setProgress(0);
        this.geO.setText(cG(j));
        this.geP.setText(cG(j2));
    }

    public void bhJ() {
        if (this.bTq != null) {
            this.bTp = ((this.bTq.getDuration() / 200) / 50) * 50;
            if (this.bTp < 50) {
                this.bTp = 50;
            }
            this.bTt = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTp - (this.bTq.getCurrentPosition() % this.bTp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UD() {
        if (this.bTq == null) {
            return 0;
        }
        int currentPosition = this.bTq.getCurrentPosition();
        int duration = this.bTq.getDuration();
        if (this.geQ != null) {
            if (duration > 0) {
                this.geQ.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTq.getBufferPercentage();
        }
        if (this.geO != null && duration > 0) {
            this.geO.setText(cG(currentPosition));
        }
        if (this.geP != null) {
            this.geP.setText(cG(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cG(long j) {
        this.geR.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.etj.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.etj.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
