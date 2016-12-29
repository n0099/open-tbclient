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
    private int Ct;
    private MediaController.MediaPlayerControl aQI;
    private SeekBar.OnSeekBarChangeListener aSm;
    private b aSo;
    private a aSq;
    private int cDm;
    private TextView cDn;
    private TextView cDo;
    private boolean cDp;
    private boolean cDq;
    private SeekBar cDr;
    private StringBuilder cDs;
    private Formatter cDt;
    private SeekBar.OnSeekBarChangeListener cDu;
    private int eJX;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Lt();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fQ(int i);
    }

    public as(Context context) {
        super(context);
        this.cDm = 50;
        this.cDp = false;
        this.cDq = true;
        this.eJX = 0;
        this.mHandler = new at(this, Looper.getMainLooper());
        this.cDu = new au(this);
        init(context);
    }

    public as(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDm = 50;
        this.cDp = false;
        this.cDq = true;
        this.eJX = 0;
        this.mHandler = new at(this, Looper.getMainLooper());
        this.cDu = new au(this);
        init(context);
    }

    public as(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDm = 50;
        this.cDp = false;
        this.cDq = true;
        this.eJX = 0;
        this.mHandler = new at(this, Looper.getMainLooper());
        this.cDu = new au(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bn = bn(context);
        addView(bn, -1, (int) context.getResources().getDimension(r.e.ds80));
        this.cDn = (TextView) bn.findViewById(r.g.textview_cur_time);
        this.cDo = (TextView) bn.findViewById(r.g.textview_duration);
        this.cDr = (SeekBar) bn.findViewById(r.g.pb_video_controller_seekBar);
        this.cDr.setOnSeekBarChangeListener(this.cDu);
        this.cDs = new StringBuilder();
        this.cDt = new Formatter(this.cDs, Locale.getDefault());
    }

    protected View bn(Context context) {
        return LayoutInflater.from(context).inflate(r.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aQI = mediaPlayerControl;
    }

    public void aJ(int i, int i2) {
        this.Ct = i2;
        this.cDq = false;
        this.mHandler.removeMessages(1);
        this.cDr.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cDn != null) {
            this.cDn.setText(ks(i));
        }
        if (this.cDo != null) {
            this.cDo.setText(ks(this.Ct));
        }
    }

    public void showProgress() {
        if (this.aQI != null) {
            this.cDm = ((this.aQI.getDuration() / 200) / 50) * 50;
            if (this.cDm < 50) {
                this.cDm = 50;
            } else if (this.cDm > 500) {
                this.cDm = 500;
            }
            this.cDq = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cDm - (this.aQI.getCurrentPosition() % this.cDm));
        }
    }

    public void alT() {
        this.cDq = false;
        this.mHandler.removeMessages(1);
        this.cDr.setProgress(0);
        if (this.cDn != null) {
            this.cDn.setText(ks(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int alU() {
        if (this.aQI == null || this.cDp) {
            return 0;
        }
        int currentPosition = this.aQI.getCurrentPosition();
        int duration = this.aQI.getDuration();
        if (this.cDr != null) {
            if (duration > 0) {
                this.cDr.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aQI.getBufferPercentage();
        }
        if (this.cDn != null) {
            this.cDn.setText(ks(currentPosition));
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
            this.aQI.seekTo(i);
            if (this.cDn != null) {
                this.cDn.setText(ks(i));
            }
            showProgress();
        }
        if (!this.aQI.isPlaying()) {
            this.cDr.setProgress((int) (((i * 1.0f) / this.Ct) * 10000.0f));
        }
    }

    public String pT(int i) {
        if (i < 0) {
            i = 0;
        }
        return ks(i);
    }

    public int getSeekPosition() {
        return this.eJX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ks(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cDs.setLength(0);
        return i5 > 0 ? this.cDt.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cDt.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public int getCurProgress() {
        if (this.cDr != null) {
            return this.cDr.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.aSo = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.aSq = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aSm = onSeekBarChangeListener;
    }
}
