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
public class av extends RelativeLayout {
    private int Ij;
    private int aUQ;
    private MediaController.MediaPlayerControl aUR;
    private TextView aUS;
    private TextView aUT;
    private boolean aUU;
    private boolean aUV;
    private SeekBar aUW;
    private SeekBar.OnSeekBarChangeListener aUZ;
    private int aVa;
    private SeekBar.OnSeekBarChangeListener aVb;
    private b dzw;
    private a dzx;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Kv();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fJ(int i);
    }

    public av(Context context) {
        super(context);
        this.aUQ = 50;
        this.aUU = false;
        this.aUV = true;
        this.aVa = 0;
        this.mHandler = new aw(this, Looper.getMainLooper());
        this.aVb = new ax(this);
        init(context);
    }

    public av(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUQ = 50;
        this.aUU = false;
        this.aUV = true;
        this.aVa = 0;
        this.mHandler = new aw(this, Looper.getMainLooper());
        this.aVb = new ax(this);
        init(context);
    }

    public av(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUQ = 50;
        this.aUU = false;
        this.aUV = true;
        this.aVa = 0;
        this.mHandler = new aw(this, Looper.getMainLooper());
        this.aVb = new ax(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ba = ba(context);
        addView(ba, -1, (int) context.getResources().getDimension(w.f.ds80));
        this.aUS = (TextView) ba.findViewById(w.h.textview_cur_time);
        this.aUT = (TextView) ba.findViewById(w.h.textview_duration);
        this.aUW = (SeekBar) ba.findViewById(w.h.pb_video_controller_seekBar);
        this.aUW.setOnSeekBarChangeListener(this.aVb);
    }

    protected View ba(Context context) {
        return LayoutInflater.from(context).inflate(w.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aUR = mediaPlayerControl;
    }

    public void V(int i, int i2) {
        this.Ij = i2;
        this.aUV = false;
        this.mHandler.removeMessages(1);
        this.aUW.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aUS != null) {
            this.aUS.setText(com.baidu.tbadk.core.util.au.cT(i));
        }
        if (this.aUT != null) {
            this.aUT.setText(com.baidu.tbadk.core.util.au.cT(this.Ij));
        }
    }

    public void showProgress() {
        if (this.aUR != null) {
            this.aUQ = ((this.aUR.getDuration() / 200) / 50) * 50;
            if (this.aUQ < 50) {
                this.aUQ = 50;
            } else if (this.aUQ > 500) {
                this.aUQ = 500;
            }
            this.aUV = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aUQ - (this.aUR.getCurrentPosition() % this.aUQ));
        }
    }

    public void Kt() {
        this.aUV = false;
        this.mHandler.removeMessages(1);
        this.aUW.setProgress(0);
        if (this.aUS != null) {
            this.aUS.setText(com.baidu.tbadk.core.util.au.cT(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ku() {
        if (this.aUR == null || this.aUU) {
            return 0;
        }
        int currentPosition = this.aUR.getCurrentPosition();
        int duration = this.aUR.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aUW != null) {
            if (duration > 0) {
                this.aUW.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aUR.getBufferPercentage();
        }
        if (this.aUS != null) {
            this.aUS.setText(com.baidu.tbadk.core.util.au.cT(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void B(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aUR.seekTo(i);
            if (this.aUS != null) {
                this.aUS.setText(com.baidu.tbadk.core.util.au.cT(i));
            }
            showProgress();
        }
        if (!this.aUR.isPlaying()) {
            this.aUW.setProgress((int) (((i * 1.0f) / this.Ij) * 10000.0f));
        }
    }

    public String qT(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.au.cT(i);
    }

    public int getSeekPosition() {
        return this.aVa;
    }

    public int getCurProgress() {
        if (this.aUW != null) {
            return this.aUW.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dzw = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dzx = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aUZ = onSeekBarChangeListener;
    }
}
