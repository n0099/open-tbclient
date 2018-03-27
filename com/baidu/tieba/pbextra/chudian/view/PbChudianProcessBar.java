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
    private int bTs;
    private MediaController.MediaPlayerControl bTt;
    private boolean bTw;
    private Formatter etz;
    private TextView gfe;
    private TextView gff;
    private SeekBar gfg;
    private StringBuilder gfh;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bTs = 50;
        this.bTw = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTw && PbChudianProcessBar.this.bTt != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTs - (PbChudianProcessBar.this.UE() % PbChudianProcessBar.this.bTs));
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
        this.bTs = 50;
        this.bTw = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTw && PbChudianProcessBar.this.bTt != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTs - (PbChudianProcessBar.this.UE() % PbChudianProcessBar.this.bTs));
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
        this.bTs = 50;
        this.bTw = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTw && PbChudianProcessBar.this.bTt != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTs - (PbChudianProcessBar.this.UE() % PbChudianProcessBar.this.bTs));
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
        this.gfe = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.gff = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.gfg = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.gfg.setEnabled(false);
        this.gfg.setThumb(null);
        this.gfh = new StringBuilder();
        this.etz = new Formatter(this.gfh, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTt = mediaPlayerControl;
    }

    public void l(long j, long j2) {
        this.bTw = false;
        this.mHandler.removeMessages(1);
        this.gfg.setProgress(0);
        this.gfe.setText(cG(j));
        this.gff.setText(cG(j2));
    }

    public void bhK() {
        if (this.bTt != null) {
            this.bTs = ((this.bTt.getDuration() / 200) / 50) * 50;
            if (this.bTs < 50) {
                this.bTs = 50;
            }
            this.bTw = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTs - (this.bTt.getCurrentPosition() % this.bTs));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UE() {
        if (this.bTt == null) {
            return 0;
        }
        int currentPosition = this.bTt.getCurrentPosition();
        int duration = this.bTt.getDuration();
        if (this.gfg != null) {
            if (duration > 0) {
                this.gfg.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTt.getBufferPercentage();
        }
        if (this.gfe != null && duration > 0) {
            this.gfe.setText(cG(currentPosition));
        }
        if (this.gff != null) {
            this.gff.setText(cG(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cG(long j) {
        this.gfh.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.etz.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.etz.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
