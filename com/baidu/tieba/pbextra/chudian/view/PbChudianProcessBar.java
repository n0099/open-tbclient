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
    private int bCG;
    private MediaController.MediaPlayerControl bCH;
    private Formatter eIZ;
    private TextView grd;
    private TextView gre;
    private SeekBar grf;
    private StringBuilder grg;
    private Handler mHandler;
    private View mRootView;
    private boolean mShowing;

    public PbChudianProcessBar(Context context) {
        super(context);
        this.bCG = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bCH != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bCG - (PbChudianProcessBar.this.WK() % PbChudianProcessBar.this.bCG));
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
        this.bCG = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bCH != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bCG - (PbChudianProcessBar.this.WK() % PbChudianProcessBar.this.bCG));
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
        this.bCG = 50;
        this.mShowing = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.PbChudianProcessBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PbChudianProcessBar.this.mShowing && PbChudianProcessBar.this.bCH != null) {
                            sendMessageDelayed(obtainMessage(1), PbChudianProcessBar.this.bCG - (PbChudianProcessBar.this.WK() % PbChudianProcessBar.this.bCG));
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
        this.grd = (TextView) this.mRootView.findViewById(e.g.textview_cur_time);
        this.gre = (TextView) this.mRootView.findViewById(e.g.textview_duration);
        this.grf = (SeekBar) this.mRootView.findViewById(e.g.chudian_seek_bar);
        this.grf.setEnabled(false);
        this.grf.setThumb(null);
        this.grg = new StringBuilder();
        this.eIZ = new Formatter(this.grg, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bCH = mediaPlayerControl;
    }

    public void m(long j, long j2) {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.grf.setProgress(0);
        this.grd.setText(cZ(j));
        this.gre.setText(cZ(j2));
    }

    public void bpa() {
        if (this.bCH != null) {
            this.bCG = ((this.bCH.getDuration() / 200) / 50) * 50;
            if (this.bCG < 50) {
                this.bCG = 50;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bCG - (this.bCH.getCurrentPosition() % this.bCG));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int WK() {
        if (this.bCH == null) {
            return 0;
        }
        int currentPosition = this.bCH.getCurrentPosition();
        int duration = this.bCH.getDuration();
        if (this.grf != null) {
            if (duration > 0) {
                this.grf.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bCH.getBufferPercentage();
        }
        if (this.grd != null && duration > 0) {
            this.grd.setText(cZ(currentPosition));
        }
        if (this.gre != null) {
            this.gre.setText(cZ(duration));
            return currentPosition;
        }
        return currentPosition;
    }

    private String cZ(long j) {
        this.grg.setLength(0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long seconds2 = seconds % TimeUnit.MINUTES.toSeconds(1L);
        long seconds3 = (seconds / TimeUnit.MINUTES.toSeconds(1L)) % TimeUnit.HOURS.toMinutes(1L);
        long seconds4 = seconds / TimeUnit.HOURS.toSeconds(1L);
        return seconds4 > 0 ? this.eIZ.format("%d:%02d:%02d", Long.valueOf(seconds4), Long.valueOf(seconds3), Long.valueOf(seconds2)).toString() : this.eIZ.format("%02d:%02d", Long.valueOf(seconds3), Long.valueOf(seconds2)).toString();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
