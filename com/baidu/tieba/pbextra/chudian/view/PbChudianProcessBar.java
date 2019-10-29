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
    private boolean aal;
    private int diJ;
    private MediaController.MediaPlayerControl diK;
    private SeekBar drZ;
    private Formatter gwY;
    private TextView ihh;
    private TextView ihi;
    private StringBuilder ihj;
    private Handler mHandler;
    private View mRootView;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.diJ = 50;
        this.aal = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.aal && PbChudianProcessBar.this.diK != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.diJ - (PbChudianProcessBar.this.aDU() % PbChudianProcessBar.this.diJ));
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
        this.diJ = 50;
        this.aal = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.aal && PbChudianProcessBar.this.diK != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.diJ - (PbChudianProcessBar.this.aDU() % PbChudianProcessBar.this.diJ));
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
        this.diJ = 50;
        this.aal = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.aal && PbChudianProcessBar.this.diK != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.diJ - (PbChudianProcessBar.this.aDU() % PbChudianProcessBar.this.diJ));
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
        this.ihh = (TextView) this.mRootView.findViewById(R.id.textview_cur_time);
        this.ihi = (TextView) this.mRootView.findViewById(R.id.textview_duration);
        this.drZ = (SeekBar) this.mRootView.findViewById(R.id.chudian_seek_bar);
        this.drZ.setEnabled(false);
        this.drZ.setThumb(null);
        this.ihj = new StringBuilder();
        this.gwY = new Formatter(this.ihj, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.diK = mediaPlayerControl;
    }

    public void z(long j, long j2) {
        this.aal = false;
        this.mHandler.removeMessages(1);
        this.drZ.setProgress(0);
        this.ihh.setText(dK(j));
        this.ihi.setText(dK(j2));
    }

    public void bYp() {
        if (this.diK != null) {
            this.diJ = ((this.diK.getDuration() / 200) / 50) * 50;
            if (this.diJ < 50) {
                this.diJ = 50;
            }
            this.aal = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.diJ - (this.diK.getCurrentPosition() % this.diJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDU() {
        if (this.diK == null) {
            return 0;
        }
        int currentPosition = this.diK.getCurrentPosition();
        int duration = this.diK.getDuration();
        if (this.drZ != null) {
            if (duration > 0) {
                this.drZ.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.diK.getBufferPercentage();
        }
        if (this.ihh != null && duration > 0) {
            this.ihh.setText(dK(currentPosition));
        }
        if (this.ihi != null) {
            this.ihi.setText(dK(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String dK(long j) {
        this.ihj.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.gwY.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.gwY.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
