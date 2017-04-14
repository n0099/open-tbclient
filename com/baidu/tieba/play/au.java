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
    private int It;
    private int aWP;
    private MediaController.MediaPlayerControl aWQ;
    private TextView aWR;
    private TextView aWS;
    private boolean aWT;
    private boolean aWU;
    private SeekBar aWV;
    private SeekBar.OnSeekBarChangeListener aWY;
    private int aWZ;
    private SeekBar.OnSeekBarChangeListener aXa;
    private a dxA;
    private b dxz;
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
        this.aWP = 50;
        this.aWT = false;
        this.aWU = true;
        this.aWZ = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXa = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWP = 50;
        this.aWT = false;
        this.aWU = true;
        this.aWZ = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXa = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWP = 50;
        this.aWT = false;
        this.aWU = true;
        this.aWZ = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXa = new aw(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View aX = aX(context);
        addView(aX, -1, (int) context.getResources().getDimension(w.f.ds80));
        this.aWR = (TextView) aX.findViewById(w.h.textview_cur_time);
        this.aWS = (TextView) aX.findViewById(w.h.textview_duration);
        this.aWV = (SeekBar) aX.findViewById(w.h.pb_video_controller_seekBar);
        this.aWV.setOnSeekBarChangeListener(this.aXa);
    }

    protected View aX(Context context) {
        return LayoutInflater.from(context).inflate(w.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWQ = mediaPlayerControl;
    }

    public void X(int i, int i2) {
        this.It = i2;
        this.aWU = false;
        this.mHandler.removeMessages(1);
        this.aWV.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aWR != null) {
            this.aWR.setText(com.baidu.tbadk.core.util.au.cW(i));
        }
        if (this.aWS != null) {
            this.aWS.setText(com.baidu.tbadk.core.util.au.cW(this.It));
        }
    }

    public void showProgress() {
        if (this.aWQ != null) {
            this.aWP = ((this.aWQ.getDuration() / 200) / 50) * 50;
            if (this.aWP < 50) {
                this.aWP = 50;
            } else if (this.aWP > 500) {
                this.aWP = 500;
            }
            this.aWU = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aWP - (this.aWQ.getCurrentPosition() % this.aWP));
        }
    }

    public void Mk() {
        this.aWU = false;
        this.mHandler.removeMessages(1);
        this.aWV.setProgress(0);
        if (this.aWR != null) {
            this.aWR.setText(com.baidu.tbadk.core.util.au.cW(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ml() {
        if (this.aWQ == null || this.aWT) {
            return 0;
        }
        int currentPosition = this.aWQ.getCurrentPosition();
        int duration = this.aWQ.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aWV != null) {
            if (duration > 0) {
                this.aWV.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aWQ.getBufferPercentage();
        }
        if (this.aWR != null) {
            this.aWR.setText(com.baidu.tbadk.core.util.au.cW(currentPosition));
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
            this.aWQ.seekTo(i);
            if (this.aWR != null) {
                this.aWR.setText(com.baidu.tbadk.core.util.au.cW(i));
            }
            showProgress();
        }
        if (!this.aWQ.isPlaying()) {
            this.aWV.setProgress((int) (((i * 1.0f) / this.It) * 10000.0f));
        }
    }

    public String qy(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.au.cW(i);
    }

    public int getSeekPosition() {
        return this.aWZ;
    }

    public int getCurProgress() {
        if (this.aWV != null) {
            return this.aWV.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dxz = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dxA = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aWY = onSeekBarChangeListener;
    }
}
