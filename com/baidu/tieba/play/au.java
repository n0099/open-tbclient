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
    private int IT;
    private int aWC;
    private MediaController.MediaPlayerControl aWD;
    private TextView aWE;
    private TextView aWF;
    private boolean aWG;
    private boolean aWH;
    private SeekBar aWI;
    private SeekBar.OnSeekBarChangeListener aWL;
    private int aWM;
    private SeekBar.OnSeekBarChangeListener aWN;
    private b dAR;
    private a dAS;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void LL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fJ(int i);
    }

    public au(Context context) {
        super(context);
        this.aWC = 50;
        this.aWG = false;
        this.aWH = true;
        this.aWM = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aWN = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWC = 50;
        this.aWG = false;
        this.aWH = true;
        this.aWM = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aWN = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWC = 50;
        this.aWG = false;
        this.aWH = true;
        this.aWM = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aWN = new aw(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View aV = aV(context);
        addView(aV, -1, (int) context.getResources().getDimension(w.f.ds80));
        this.aWE = (TextView) aV.findViewById(w.h.textview_cur_time);
        this.aWF = (TextView) aV.findViewById(w.h.textview_duration);
        this.aWI = (SeekBar) aV.findViewById(w.h.pb_video_controller_seekBar);
        this.aWI.setOnSeekBarChangeListener(this.aWN);
    }

    protected View aV(Context context) {
        return LayoutInflater.from(context).inflate(w.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWD = mediaPlayerControl;
    }

    public void X(int i, int i2) {
        this.IT = i2;
        this.aWH = false;
        this.mHandler.removeMessages(1);
        this.aWI.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aWE != null) {
            this.aWE.setText(com.baidu.tbadk.core.util.au.cT(i));
        }
        if (this.aWF != null) {
            this.aWF.setText(com.baidu.tbadk.core.util.au.cT(this.IT));
        }
    }

    public void showProgress() {
        if (this.aWD != null) {
            this.aWC = ((this.aWD.getDuration() / 200) / 50) * 50;
            if (this.aWC < 50) {
                this.aWC = 50;
            } else if (this.aWC > 500) {
                this.aWC = 500;
            }
            this.aWH = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aWC - (this.aWD.getCurrentPosition() % this.aWC));
        }
    }

    public void LJ() {
        this.aWH = false;
        this.mHandler.removeMessages(1);
        this.aWI.setProgress(0);
        if (this.aWE != null) {
            this.aWE.setText(com.baidu.tbadk.core.util.au.cT(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int LK() {
        if (this.aWD == null || this.aWG) {
            return 0;
        }
        int currentPosition = this.aWD.getCurrentPosition();
        int duration = this.aWD.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aWI != null) {
            if (duration > 0) {
                this.aWI.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aWD.getBufferPercentage();
        }
        if (this.aWE != null) {
            this.aWE.setText(com.baidu.tbadk.core.util.au.cT(currentPosition));
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
            this.aWD.seekTo(i);
            if (this.aWE != null) {
                this.aWE.setText(com.baidu.tbadk.core.util.au.cT(i));
            }
            showProgress();
        }
        if (!this.aWD.isPlaying()) {
            this.aWI.setProgress((int) (((i * 1.0f) / this.IT) * 10000.0f));
        }
    }

    public String qA(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.au.cT(i);
    }

    public int getSeekPosition() {
        return this.aWM;
    }

    public int getCurProgress() {
        if (this.aWI != null) {
            return this.aWI.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dAR = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dAS = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aWL = onSeekBarChangeListener;
    }
}
