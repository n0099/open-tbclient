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
    private int Ii;
    private int aWj;
    private MediaController.MediaPlayerControl aWk;
    private TextView aWl;
    private TextView aWm;
    private boolean aWn;
    private boolean aWo;
    private SeekBar aWp;
    private SeekBar.OnSeekBarChangeListener aWs;
    private int aWt;
    private SeekBar.OnSeekBarChangeListener aWu;
    private b dIi;
    private a dIj;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void KT();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fL(int i);
    }

    public av(Context context) {
        super(context);
        this.aWj = 50;
        this.aWn = false;
        this.aWo = true;
        this.aWt = 0;
        this.mHandler = new aw(this, Looper.getMainLooper());
        this.aWu = new ax(this);
        init(context);
    }

    public av(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWj = 50;
        this.aWn = false;
        this.aWo = true;
        this.aWt = 0;
        this.mHandler = new aw(this, Looper.getMainLooper());
        this.aWu = new ax(this);
        init(context);
    }

    public av(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWj = 50;
        this.aWn = false;
        this.aWo = true;
        this.aWt = 0;
        this.mHandler = new aw(this, Looper.getMainLooper());
        this.aWu = new ax(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ba = ba(context);
        addView(ba, -1, (int) context.getResources().getDimension(w.f.ds80));
        this.aWl = (TextView) ba.findViewById(w.h.textview_cur_time);
        this.aWm = (TextView) ba.findViewById(w.h.textview_duration);
        this.aWp = (SeekBar) ba.findViewById(w.h.pb_video_controller_seekBar);
        this.aWp.setOnSeekBarChangeListener(this.aWu);
    }

    protected View ba(Context context) {
        return LayoutInflater.from(context).inflate(w.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWk = mediaPlayerControl;
    }

    public void V(int i, int i2) {
        this.Ii = i2;
        this.aWo = false;
        this.mHandler.removeMessages(1);
        this.aWp.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aWl != null) {
            this.aWl.setText(com.baidu.tbadk.core.util.aw.cV(i));
        }
        if (this.aWm != null) {
            this.aWm.setText(com.baidu.tbadk.core.util.aw.cV(this.Ii));
        }
    }

    public void showProgress() {
        if (this.aWk != null) {
            this.aWj = ((this.aWk.getDuration() / 200) / 50) * 50;
            if (this.aWj < 50) {
                this.aWj = 50;
            } else if (this.aWj > 500) {
                this.aWj = 500;
            }
            this.aWo = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aWj - (this.aWk.getCurrentPosition() % this.aWj));
        }
    }

    public void KR() {
        this.aWo = false;
        this.mHandler.removeMessages(1);
        this.aWp.setProgress(0);
        if (this.aWl != null) {
            this.aWl.setText(com.baidu.tbadk.core.util.aw.cV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int KS() {
        if (this.aWk == null || this.aWn) {
            return 0;
        }
        int currentPosition = this.aWk.getCurrentPosition();
        int duration = this.aWk.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aWp != null) {
            if (duration > 0) {
                this.aWp.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aWk.getBufferPercentage();
        }
        if (this.aWl != null) {
            this.aWl.setText(com.baidu.tbadk.core.util.aw.cV(currentPosition));
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
            this.aWk.seekTo(i);
            if (this.aWl != null) {
                this.aWl.setText(com.baidu.tbadk.core.util.aw.cV(i));
            }
            showProgress();
        }
        if (!this.aWk.isPlaying()) {
            this.aWp.setProgress((int) (((i * 1.0f) / this.Ii) * 10000.0f));
        }
    }

    public String rm(int i) {
        if (i < 0) {
            i = 0;
        }
        return com.baidu.tbadk.core.util.aw.cV(i);
    }

    public int getSeekPosition() {
        return this.aWt;
    }

    public int getCurProgress() {
        if (this.aWp != null) {
            return this.aWp.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dIi = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dIj = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aWs = onSeekBarChangeListener;
    }
}
