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
import com.baidu.tieba.t;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends RelativeLayout {
    private int Cs;
    private MediaController.MediaPlayerControl aOb;
    private SeekBar.OnSeekBarChangeListener aPH;
    private b aPJ;
    private a aPP;
    private int cRE;
    private TextView cRF;
    private TextView cRG;
    private boolean cRH;
    private boolean cRI;
    private SeekBar cRJ;
    private StringBuilder cRK;
    private Formatter cRL;
    private SeekBar.OnSeekBarChangeListener cRM;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void KR();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fL(int i);
    }

    public n(Context context) {
        super(context);
        this.cRE = 50;
        this.cRH = false;
        this.cRI = true;
        this.mHandler = new o(this, Looper.getMainLooper());
        this.cRM = new p(this);
        init(context);
    }

    public n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRE = 50;
        this.cRH = false;
        this.cRI = true;
        this.mHandler = new o(this, Looper.getMainLooper());
        this.cRM = new p(this);
        init(context);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cRE = 50;
        this.cRH = false;
        this.cRI = true;
        this.mHandler = new o(this, Looper.getMainLooper());
        this.cRM = new p(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View az = az(context);
        addView(az, -1, (int) context.getResources().getDimension(t.e.ds80));
        this.cRF = (TextView) az.findViewById(t.g.textview_cur_time);
        this.cRG = (TextView) az.findViewById(t.g.textview_duration);
        this.cRJ = (SeekBar) az.findViewById(t.g.pb_video_controller_seekBar);
        this.cRJ.setOnSeekBarChangeListener(this.cRM);
        this.cRK = new StringBuilder();
        this.cRL = new Formatter(this.cRK, Locale.getDefault());
    }

    protected View az(Context context) {
        return LayoutInflater.from(context).inflate(t.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aOb = mediaPlayerControl;
    }

    public void aM(int i, int i2) {
        this.Cs = i2;
        this.cRI = false;
        this.mHandler.removeMessages(1);
        this.cRJ.setProgress(0);
        if (this.cRF != null) {
            this.cRF.setText(kU(i));
        }
        if (this.cRG != null) {
            this.cRG.setText(kU(this.Cs));
        }
    }

    public void showProgress() {
        if (this.aOb != null) {
            this.cRE = ((this.aOb.getDuration() / 200) / 50) * 50;
            if (this.cRE < 50) {
                this.cRE = 50;
            }
            this.cRI = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cRE - (this.aOb.getCurrentPosition() % this.cRE));
        }
    }

    public void apg() {
        this.cRI = false;
        this.mHandler.removeMessages(1);
        this.cRJ.setProgress(0);
        if (this.cRF != null) {
            this.cRF.setText(kU(0));
        }
    }

    public void aZY() {
        if (this.cRJ != null) {
            this.cRJ.setProgress(10000);
        }
        if (this.cRF != null) {
            this.cRF.setText(kU(this.Cs));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aph() {
        if (this.aOb == null || this.cRH) {
            return 0;
        }
        int currentPosition = this.aOb.getCurrentPosition();
        int duration = this.aOb.getDuration();
        if (this.cRJ != null) {
            if (duration > 0) {
                this.cRJ.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aOb.getBufferPercentage();
        }
        if (this.cRF != null) {
            this.cRF.setText(kU(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kU(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cRK.setLength(0);
        return i5 > 0 ? this.cRL.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cRL.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public int getCurProgress() {
        if (this.cRJ != null) {
            return this.cRJ.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.aPJ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.aPP = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aPH = onSeekBarChangeListener;
    }
}
