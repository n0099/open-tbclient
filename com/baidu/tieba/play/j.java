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
import com.baidu.tieba.u;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class j extends RelativeLayout {
    private b aKY;
    private b aKZ;
    private a aLf;
    private int cFX;
    private MediaController.MediaPlayerControl cFY;
    private TextView cFZ;
    private TextView cGa;
    private boolean cGb;
    private boolean cGc;
    private SeekBar cGd;
    private StringBuilder cGe;
    private Formatter cGf;
    private SeekBar.OnSeekBarChangeListener cGg;
    private int ePv;
    private Handler ePw;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void II();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ft(int i);
    }

    public j(Context context) {
        super(context);
        this.cFX = 50;
        this.cGb = false;
        this.cGc = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        this.ePw = new l(this, Looper.getMainLooper());
        this.cGg = new m(this);
        init(context);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cFX = 50;
        this.cGb = false;
        this.cGc = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        this.ePw = new l(this, Looper.getMainLooper());
        this.cGg = new m(this);
        init(context);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFX = 50;
        this.cGb = false;
        this.cGc = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        this.ePw = new l(this, Looper.getMainLooper());
        this.cGg = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View am = am(context);
        addView(am, -1, (int) context.getResources().getDimension(u.e.ds80));
        this.cFZ = (TextView) am.findViewById(u.g.textview_cur_time);
        this.cGa = (TextView) am.findViewById(u.g.textview_duration);
        this.cGd = (SeekBar) am.findViewById(u.g.pb_video_controller_seekBar);
        this.cGd.setOnSeekBarChangeListener(this.cGg);
        this.cGe = new StringBuilder();
        this.cGf = new Formatter(this.cGe, Locale.getDefault());
    }

    protected View am(Context context) {
        return LayoutInflater.from(context).inflate(u.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cFY = mediaPlayerControl;
    }

    public void aI(int i, int i2) {
        this.ePv = i2;
        this.cGc = false;
        this.mHandler.removeMessages(1);
        this.ePw.removeMessages(2);
        this.cGd.setProgress(0);
        if (this.cFZ != null) {
            this.cFZ.setText(kr(i));
        }
        if (this.cGa != null) {
            this.cGa.setText(kr(kq(i2)));
        }
    }

    public void showProgress() {
        if (this.cFY != null) {
            this.cFX = ((this.cFY.getDuration() / 200) / 50) * 50;
            if (this.cFX < 50) {
                this.cFX = 50;
            }
            this.cGc = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cFX - (this.cFY.getCurrentPosition() % this.cFX));
            this.ePw.removeMessages(2);
            this.ePw.sendMessage(this.ePw.obtainMessage(2));
        }
    }

    public void aks() {
        this.cGc = false;
        this.mHandler.removeMessages(1);
        this.ePw.removeMessages(2);
        this.cGd.setProgress(0);
        if (this.cFZ != null) {
            this.cFZ.setText(kr(0));
        }
    }

    public void aWF() {
        if (this.cGd != null) {
            this.cGd.setProgress(10000);
        }
        if (this.cFZ != null) {
            this.cFZ.setText(kr(this.ePv));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int akt() {
        if (this.cFY == null || this.cGb) {
            return 0;
        }
        int currentPosition = this.cFY.getCurrentPosition();
        int duration = this.cFY.getDuration();
        if (this.cGd != null) {
            if (duration > 0) {
                this.cGd.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cFY.getBufferPercentage();
        }
        if (this.cFZ != null) {
            this.cFZ.setText(kr(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int kq(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kr(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cGe.setLength(0);
        return i5 > 0 ? this.cGf.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cGf.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public int getCurProgress() {
        if (this.cGd != null) {
            return this.cGd.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.aKY = bVar;
    }

    public void setOnProgressUpdatedNoDelayListener(b bVar) {
        this.aKZ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.aLf = aVar;
    }
}
