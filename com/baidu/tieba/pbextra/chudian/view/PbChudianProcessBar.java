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
    private int bTB;
    private MediaController.MediaPlayerControl bTC;
    private boolean bTF;
    private Formatter etv;
    private TextView geZ;
    private TextView gfa;
    private SeekBar gfb;
    private StringBuilder gfc;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bTB = 50;
        this.bTF = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTF && PbChudianProcessBar.this.bTC != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTB - (PbChudianProcessBar.this.UE() % PbChudianProcessBar.this.bTB));
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
        this.bTB = 50;
        this.bTF = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTF && PbChudianProcessBar.this.bTC != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTB - (PbChudianProcessBar.this.UE() % PbChudianProcessBar.this.bTB));
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
        this.bTB = 50;
        this.bTF = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.bTF && PbChudianProcessBar.this.bTC != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bTB - (PbChudianProcessBar.this.UE() % PbChudianProcessBar.this.bTB));
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
        this.geZ = (TextView) this.mRootView.findViewById(d.g.textview_cur_time);
        this.gfa = (TextView) this.mRootView.findViewById(d.g.textview_duration);
        this.gfb = (SeekBar) this.mRootView.findViewById(d.g.chudian_seek_bar);
        this.gfb.setEnabled(false);
        this.gfb.setThumb(null);
        this.gfc = new StringBuilder();
        this.etv = new Formatter(this.gfc, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTC = mediaPlayerControl;
    }

    public void l(long j, long j2) {
        this.bTF = false;
        this.mHandler.removeMessages(1);
        this.gfb.setProgress(0);
        this.geZ.setText(cG(j));
        this.gfa.setText(cG(j2));
    }

    public void bhK() {
        if (this.bTC != null) {
            this.bTB = ((this.bTC.getDuration() / 200) / 50) * 50;
            if (this.bTB < 50) {
                this.bTB = 50;
            }
            this.bTF = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTB - (this.bTC.getCurrentPosition() % this.bTB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UE() {
        if (this.bTC == null) {
            return 0;
        }
        int currentPosition = this.bTC.getCurrentPosition();
        int duration = this.bTC.getDuration();
        if (this.gfb != null) {
            if (duration > 0) {
                this.gfb.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTC.getBufferPercentage();
        }
        if (this.geZ != null && duration > 0) {
            this.geZ.setText(cG(currentPosition));
        }
        if (this.gfa != null) {
            this.gfa.setText(cG(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cG(long j) {
        this.gfc.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.etv.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.etv.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
