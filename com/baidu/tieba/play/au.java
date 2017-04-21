package com.baidu.tieba.play;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    private int Iv;
    private int aWS;
    private MediaController.MediaPlayerControl aWT;
    private TextView aWU;
    private TextView aWV;
    private boolean aWW;
    private boolean aWX;
    private SeekBar aWY;
    private SeekBar.OnSeekBarChangeListener aXb;
    private int aXc;
    private SeekBar.OnSeekBarChangeListener aXd;
    private b dzP;
    private a dzQ;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Mm();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fM(int i);
    }

    public au(Context context) {
        super(context);
        this.aWS = 50;
        this.aWW = false;
        this.aWX = true;
        this.aXc = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXd = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWS = 50;
        this.aWW = false;
        this.aWX = true;
        this.aXc = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXd = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWS = 50;
        this.aWW = false;
        this.aWX = true;
        this.aXc = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXd = new aw(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View aX = aX(context);
        addView(aX, -1, (int) context.getResources().getDimension(w.f.ds80));
        this.aWU = (TextView) aX.findViewById(w.h.textview_cur_time);
        this.aWV = (TextView) aX.findViewById(w.h.textview_duration);
        this.aWY = (SeekBar) aX.findViewById(w.h.pb_video_controller_seekBar);
        this.aWY.setOnSeekBarChangeListener(this.aXd);
    }

    protected View aX(Context context) {
        return LayoutInflater.from(context).inflate(w.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWT = mediaPlayerControl;
    }

    public void X(int i, int i2) {
        this.Iv = i2;
        this.aWX = false;
        this.mHandler.removeMessages(1);
        this.aWY.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aWU != null) {
            this.aWU.setText(com.baidu.tbadk.core.util.au.cW(i));
        }
        if (this.aWV != null) {
            this.aWV.setText(com.baidu.tbadk.core.util.au.cW(this.Iv));
        }
    }

    public void showProgress() {
        if (this.aWT != null) {
            this.aWS = ((this.aWT.getDuration() / 200) / 50) * 50;
            if (this.aWS < 50) {
                this.aWS = 50;
            } else if (this.aWS > 500) {
                this.aWS = 500;
            }
            this.aWX = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aWS - (this.aWT.getCurrentPosition() % this.aWS));
        }
    }

    public void Mk() {
        this.aWX = false;
        this.mHandler.removeMessages(1);
        this.aWY.setProgress(0);
        if (this.aWU != null) {
            this.aWU.setText(com.baidu.tbadk.core.util.au.cW(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ml() {
        if (this.aWT == null || this.aWW) {
            return 0;
        }
        int currentPosition = this.aWT.getCurrentPosition();
        int duration = this.aWT.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aWY != null) {
            if (duration > 0) {
                this.aWY.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aWT.getBufferPercentage();
        }
        if (this.aWU != null) {
            this.aWU.setText(com.baidu.tbadk.core.util.au.cW(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void D(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aWT.seekTo(i);
            if (this.aWU != null) {
                this.aWU.setText(com.baidu.tbadk.core.util.au.cW(i));
            }
            showProgress();
        }
        if (!this.aWT.isPlaying()) {
            this.aWY.setProgress((int) (((i * 1.0f) / this.Iv) * 10000.0f));
        }
    }

    public String qE(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.au.cW(i);
    }

    public int getSeekPosition() {
        return this.aXc;
    }

    public int getCurProgress() {
        if (this.aWY != null) {
            return this.aWY.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dzP = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dzQ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aXb = onSeekBarChangeListener;
    }
}
