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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    private int BF;
    private SeekBar cKA;
    private SeekBar.OnSeekBarChangeListener cKD;
    private int cKu;
    private MediaController.MediaPlayerControl cKv;
    private TextView cKw;
    private TextView cKx;
    private boolean cKy;
    private boolean cKz;
    private SeekBar.OnSeekBarChangeListener duN;
    private b dyt;
    private a dyu;
    private int eTr;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void azO();
    }

    /* loaded from: classes.dex */
    public interface b {
        void mQ(int i);
    }

    public au(Context context) {
        super(context);
        this.cKu = 50;
        this.cKy = false;
        this.cKz = true;
        this.eTr = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.cKD = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKu = 50;
        this.cKy = false;
        this.cKz = true;
        this.eTr = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.cKD = new aw(this);
        init(context);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKu = 50;
        this.cKy = false;
        this.cKz = true;
        this.eTr = 0;
        this.mHandler = new av(this, Looper.getMainLooper());
        this.cKD = new aw(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bi = bi(context);
        addView(bi, -1, (int) context.getResources().getDimension(r.f.ds80));
        this.cKw = (TextView) bi.findViewById(r.h.textview_cur_time);
        this.cKx = (TextView) bi.findViewById(r.h.textview_duration);
        this.cKA = (SeekBar) bi.findViewById(r.h.pb_video_controller_seekBar);
        this.cKA.setOnSeekBarChangeListener(this.cKD);
    }

    protected View bi(Context context) {
        return LayoutInflater.from(context).inflate(r.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cKv = mediaPlayerControl;
    }

    public void aJ(int i, int i2) {
        this.BF = i2;
        this.cKz = false;
        this.mHandler.removeMessages(1);
        this.cKA.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cKw != null) {
            this.cKw.setText(com.baidu.tbadk.core.util.at.cX(i));
        }
        if (this.cKx != null) {
            this.cKx.setText(com.baidu.tbadk.core.util.at.cX(this.BF));
        }
    }

    public void showProgress() {
        if (this.cKv != null) {
            this.cKu = ((this.cKv.getDuration() / 200) / 50) * 50;
            if (this.cKu < 50) {
                this.cKu = 50;
            } else if (this.cKu > 500) {
                this.cKu = 500;
            }
            this.cKz = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cKu - (this.cKv.getCurrentPosition() % this.cKu));
        }
    }

    public void anc() {
        this.cKz = false;
        this.mHandler.removeMessages(1);
        this.cKA.setProgress(0);
        if (this.cKw != null) {
            this.cKw.setText(com.baidu.tbadk.core.util.at.cX(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int and() {
        if (this.cKv == null || this.cKy) {
            return 0;
        }
        int currentPosition = this.cKv.getCurrentPosition();
        int duration = this.cKv.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cKA != null) {
            if (duration > 0) {
                this.cKA.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cKv.getBufferPercentage();
        }
        if (this.cKw != null) {
            this.cKw.setText(com.baidu.tbadk.core.util.at.cX(currentPosition));
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
            this.cKv.seekTo(i);
            if (this.cKw != null) {
                this.cKw.setText(com.baidu.tbadk.core.util.at.cX(i));
            }
            showProgress();
        }
        if (!this.cKv.isPlaying()) {
            this.cKA.setProgress((int) (((i * 1.0f) / this.BF) * 10000.0f));
        }
    }

    public String qD(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.at.cX(i);
    }

    public int getSeekPosition() {
        return this.eTr;
    }

    public int getCurProgress() {
        if (this.cKA != null) {
            return this.cKA.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dyt = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dyu = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.duN = onSeekBarChangeListener;
    }
}
