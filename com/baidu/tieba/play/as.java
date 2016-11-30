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
public class as extends RelativeLayout {
    private int Cs;
    private MediaController.MediaPlayerControl aRr;
    private SeekBar.OnSeekBarChangeListener aSV;
    private b aSX;
    private a aSZ;
    private int cYd;
    private TextView cYe;
    private TextView cYf;
    private boolean cYg;
    private boolean cYh;
    private SeekBar cYi;
    private StringBuilder cYj;
    private Formatter cYk;
    private SeekBar.OnSeekBarChangeListener cYl;
    private int fgF;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Ma();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fR(int i);
    }

    public as(Context context) {
        super(context);
        this.cYd = 50;
        this.cYg = false;
        this.cYh = true;
        this.fgF = 0;
        this.mHandler = new at(this, Looper.getMainLooper());
        this.cYl = new au(this);
        init(context);
    }

    public as(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYd = 50;
        this.cYg = false;
        this.cYh = true;
        this.fgF = 0;
        this.mHandler = new at(this, Looper.getMainLooper());
        this.cYl = new au(this);
        init(context);
    }

    public as(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYd = 50;
        this.cYg = false;
        this.cYh = true;
        this.fgF = 0;
        this.mHandler = new at(this, Looper.getMainLooper());
        this.cYl = new au(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bo = bo(context);
        addView(bo, -1, (int) context.getResources().getDimension(r.e.ds80));
        this.cYe = (TextView) bo.findViewById(r.g.textview_cur_time);
        this.cYf = (TextView) bo.findViewById(r.g.textview_duration);
        this.cYi = (SeekBar) bo.findViewById(r.g.pb_video_controller_seekBar);
        this.cYi.setOnSeekBarChangeListener(this.cYl);
        this.cYj = new StringBuilder();
        this.cYk = new Formatter(this.cYj, Locale.getDefault());
    }

    protected View bo(Context context) {
        return LayoutInflater.from(context).inflate(r.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aRr = mediaPlayerControl;
    }

    public void aO(int i, int i2) {
        this.Cs = i2;
        this.cYh = false;
        this.mHandler.removeMessages(1);
        this.cYi.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cYe != null) {
            this.cYe.setText(li(i));
        }
        if (this.cYf != null) {
            this.cYf.setText(li(this.Cs));
        }
    }

    public void showProgress() {
        if (this.aRr != null) {
            this.cYd = ((this.aRr.getDuration() / 200) / 50) * 50;
            if (this.cYd < 50) {
                this.cYd = 50;
            } else if (this.cYd > 500) {
                this.cYd = 500;
            }
            this.cYh = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cYd - (this.aRr.getCurrentPosition() % this.cYd));
        }
    }

    public void arr() {
        this.cYh = false;
        this.mHandler.removeMessages(1);
        this.cYi.setProgress(0);
        if (this.cYe != null) {
            this.cYe.setText(li(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ars() {
        if (this.aRr == null || this.cYg) {
            return 0;
        }
        int currentPosition = this.aRr.getCurrentPosition();
        int duration = this.aRr.getDuration();
        if (this.cYi != null) {
            if (duration > 0) {
                this.cYi.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aRr.getBufferPercentage();
        }
        if (this.cYe != null) {
            this.cYe.setText(li(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void Q(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aRr.seekTo(i);
            if (this.cYe != null) {
                this.cYe.setText(li(i));
            }
            showProgress();
        }
        if (!this.aRr.isPlaying()) {
            this.cYi.setProgress((int) (((i * 1.0f) / this.Cs) * 10000.0f));
        }
    }

    public String qS(int i) {
        if (i < 0) {
            i = 0;
        }
        return li(i);
    }

    public int getSeekPosition() {
        return this.fgF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String li(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cYj.setLength(0);
        return i5 > 0 ? this.cYk.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cYk.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public int getCurProgress() {
        if (this.cYi != null) {
            return this.cYi.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.aSX = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.aSZ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aSV = onSeekBarChangeListener;
    }
}
