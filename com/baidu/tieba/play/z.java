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
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class z extends RelativeLayout {
    private int Cs;
    private MediaController.MediaPlayerControl aPl;
    private SeekBar.OnSeekBarChangeListener aQT;
    private b aQV;
    private a aRb;
    private SeekBar cSA;
    private StringBuilder cSB;
    private Formatter cSC;
    private SeekBar.OnSeekBarChangeListener cSD;
    private int cSv;
    private TextView cSw;
    private TextView cSx;
    private boolean cSy;
    private boolean cSz;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Lz();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fR(int i);
    }

    public z(Context context) {
        super(context);
        this.cSv = 50;
        this.cSy = false;
        this.cSz = true;
        this.mHandler = new aa(this, Looper.getMainLooper());
        this.cSD = new ab(this);
        init(context);
    }

    public z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSv = 50;
        this.cSy = false;
        this.cSz = true;
        this.mHandler = new aa(this, Looper.getMainLooper());
        this.cSD = new ab(this);
        init(context);
    }

    public z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cSv = 50;
        this.cSy = false;
        this.cSz = true;
        this.mHandler = new aa(this, Looper.getMainLooper());
        this.cSD = new ab(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ax = ax(context);
        addView(ax, -1, (int) context.getResources().getDimension(r.e.ds80));
        this.cSw = (TextView) ax.findViewById(r.g.textview_cur_time);
        this.cSx = (TextView) ax.findViewById(r.g.textview_duration);
        this.cSA = (SeekBar) ax.findViewById(r.g.pb_video_controller_seekBar);
        this.cSA.setOnSeekBarChangeListener(this.cSD);
        this.cSB = new StringBuilder();
        this.cSC = new Formatter(this.cSB, Locale.getDefault());
    }

    protected View ax(Context context) {
        return LayoutInflater.from(context).inflate(r.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aPl = mediaPlayerControl;
    }

    public void aN(int i, int i2) {
        this.Cs = i2;
        this.cSz = false;
        this.mHandler.removeMessages(1);
        this.cSA.setProgress(0);
        if (this.cSw != null) {
            this.cSw.setText(la(i));
        }
        if (this.cSx != null) {
            this.cSx.setText(la(this.Cs));
        }
    }

    public void showProgress() {
        if (this.aPl != null) {
            this.cSv = ((this.aPl.getDuration() / 200) / 50) * 50;
            if (this.cSv < 50) {
                this.cSv = 50;
            } else if (this.cSv > 500) {
                this.cSv = 500;
            }
            this.cSz = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cSv - (this.aPl.getCurrentPosition() % this.cSv));
        }
    }

    public void apu() {
        this.cSz = false;
        this.mHandler.removeMessages(1);
        this.cSA.setProgress(0);
        if (this.cSw != null) {
            this.cSw.setText(la(0));
        }
    }

    public void baD() {
        if (this.cSA != null) {
            this.cSA.setProgress(10000);
        }
        if (this.cSw != null) {
            this.cSw.setText(la(this.Cs));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apv() {
        if (this.aPl == null || this.cSy) {
            return 0;
        }
        int currentPosition = this.aPl.getCurrentPosition();
        int duration = this.aPl.getDuration();
        if (this.cSA != null) {
            if (duration > 0) {
                this.cSA.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aPl.getBufferPercentage();
        }
        if (this.cSw != null) {
            this.cSw.setText(la(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String la(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cSB.setLength(0);
        return i5 > 0 ? this.cSC.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cSC.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public int getCurProgress() {
        if (this.cSA != null) {
            return this.cSA.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.aQV = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.aRb = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aQT = onSeekBarChangeListener;
    }
}
