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
    private int aXo;
    private MediaController.MediaPlayerControl aXp;
    private TextView aXq;
    private TextView aXr;
    private boolean aXs;
    private boolean aXt;
    private SeekBar aXu;
    private SeekBar.OnSeekBarChangeListener aXx;
    private int aXy;
    private SeekBar.OnSeekBarChangeListener aXz;
    private b due;
    private a duf;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void LA();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fJ(int i);
    }

    public au(Context context) {
        super(context);
        this.aXo = 50;
        this.aXs = false;
        this.aXt = true;
        this.aXy = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXz = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXo = 50;
        this.aXs = false;
        this.aXt = true;
        this.aXy = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXz = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXo = 50;
        this.aXs = false;
        this.aXt = true;
        this.aXy = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.aXz = new aw(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ba = ba(context);
        addView(ba, -1, (int) context.getResources().getDimension(w.f.ds80));
        this.aXq = (TextView) ba.findViewById(w.h.textview_cur_time);
        this.aXr = (TextView) ba.findViewById(w.h.textview_duration);
        this.aXu = (SeekBar) ba.findViewById(w.h.pb_video_controller_seekBar);
        this.aXu.setOnSeekBarChangeListener(this.aXz);
    }

    protected View ba(Context context) {
        return LayoutInflater.from(context).inflate(w.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aXp = mediaPlayerControl;
    }

    public void Y(int i, int i2) {
        this.Iv = i2;
        this.aXt = false;
        this.mHandler.removeMessages(1);
        this.aXu.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aXq != null) {
            this.aXq.setText(com.baidu.tbadk.core.util.au.cS(i));
        }
        if (this.aXr != null) {
            this.aXr.setText(com.baidu.tbadk.core.util.au.cS(this.Iv));
        }
    }

    public void showProgress() {
        if (this.aXp != null) {
            this.aXo = ((this.aXp.getDuration() / 200) / 50) * 50;
            if (this.aXo < 50) {
                this.aXo = 50;
            } else if (this.aXo > 500) {
                this.aXo = 500;
            }
            this.aXt = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aXo - (this.aXp.getCurrentPosition() % this.aXo));
        }
    }

    public void Ly() {
        this.aXt = false;
        this.mHandler.removeMessages(1);
        this.aXu.setProgress(0);
        if (this.aXq != null) {
            this.aXq.setText(com.baidu.tbadk.core.util.au.cS(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Lz() {
        if (this.aXp == null || this.aXs) {
            return 0;
        }
        int currentPosition = this.aXp.getCurrentPosition();
        int duration = this.aXp.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aXu != null) {
            if (duration > 0) {
                this.aXu.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aXp.getBufferPercentage();
        }
        if (this.aXq != null) {
            this.aXq.setText(com.baidu.tbadk.core.util.au.cS(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void C(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aXp.seekTo(i);
            if (this.aXq != null) {
                this.aXq.setText(com.baidu.tbadk.core.util.au.cS(i));
            }
            showProgress();
        }
        if (!this.aXp.isPlaying()) {
            this.aXu.setProgress((int) (((i * 1.0f) / this.Iv) * 10000.0f));
        }
    }

    public String qw(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.au.cS(i);
    }

    public int getSeekPosition() {
        return this.aXy;
    }

    public int getCurProgress() {
        if (this.aXu != null) {
            return this.aXu.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.due = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.duf = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aXx = onSeekBarChangeListener;
    }
}
