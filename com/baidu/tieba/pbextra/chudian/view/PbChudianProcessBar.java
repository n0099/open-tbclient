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
    private int bxI;
    private MediaController.MediaPlayerControl bxJ;
    private Formatter exm;
    private TextView geV;
    private TextView geW;
    private SeekBar geX;
    private StringBuilder geY;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bxI = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bxJ != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bxI - (PbChudianProcessBar.this.UW() % PbChudianProcessBar.this.bxI));
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
        this.bxI = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bxJ != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bxI - (PbChudianProcessBar.this.UW() % PbChudianProcessBar.this.bxI));
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
        this.bxI = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bxJ != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bxI - (PbChudianProcessBar.this.UW() % PbChudianProcessBar.this.bxI));
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
        this.geV = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.geW = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.geX = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.geX.setEnabled(false);
        this.geX.setThumb(null);
        this.geY = new StringBuilder();
        this.exm = new Formatter(this.geY, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bxJ = mediaPlayerControl;
    }

    public void n(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.geX.setProgress(0);
        this.geV.setText(cS(j));
        this.geW.setText(cS(j2));
    }

    public void bmr() {
        if (this.bxJ != null) {
            this.bxI = ((this.bxJ.getDuration() / 200) / 50) * 50;
            if (this.bxI < 50) {
                this.bxI = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bxI - (this.bxJ.getCurrentPosition() % this.bxI));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UW() {
        if (this.bxJ == null) {
            return 0;
        }
        int currentPosition = this.bxJ.getCurrentPosition();
        int duration = this.bxJ.getDuration();
        if (this.geX != null) {
            if (duration > 0) {
                this.geX.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bxJ.getBufferPercentage();
        }
        if (this.geV != null && duration > 0) {
            this.geV.setText(cS(currentPosition));
        }
        if (this.geW != null) {
            this.geW.setText(cS(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cS(long j) {
        this.geY.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.exm.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.exm.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
