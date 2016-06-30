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
    private b aKf;
    private b aKg;
    private a aKm;
    private int cDi;
    private MediaController.MediaPlayerControl cDj;
    private TextView cDk;
    private TextView cDl;
    private boolean cDm;
    private boolean cDn;
    private SeekBar cDo;
    private StringBuilder cDp;
    private Formatter cDq;
    private SeekBar.OnSeekBarChangeListener cDr;
    private int eDM;
    private Handler eDN;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void IJ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fu(int i);
    }

    public j(Context context) {
        super(context);
        this.cDi = 50;
        this.cDm = false;
        this.cDn = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        this.eDN = new l(this, Looper.getMainLooper());
        this.cDr = new m(this);
        init(context);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDi = 50;
        this.cDm = false;
        this.cDn = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        this.eDN = new l(this, Looper.getMainLooper());
        this.cDr = new m(this);
        init(context);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDi = 50;
        this.cDm = false;
        this.cDn = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        this.eDN = new l(this, Looper.getMainLooper());
        this.cDr = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View am = am(context);
        addView(am, -1, (int) context.getResources().getDimension(u.e.ds80));
        this.cDk = (TextView) am.findViewById(u.g.textview_cur_time);
        this.cDl = (TextView) am.findViewById(u.g.textview_duration);
        this.cDo = (SeekBar) am.findViewById(u.g.pb_video_controller_seekBar);
        this.cDo.setOnSeekBarChangeListener(this.cDr);
        this.cDp = new StringBuilder();
        this.cDq = new Formatter(this.cDp, Locale.getDefault());
    }

    protected View am(Context context) {
        return LayoutInflater.from(context).inflate(u.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cDj = mediaPlayerControl;
    }

    public void aF(int i, int i2) {
        this.eDM = i2;
        this.cDn = false;
        this.mHandler.removeMessages(1);
        this.eDN.removeMessages(2);
        this.cDo.setProgress(0);
        if (this.cDk != null) {
            this.cDk.setText(kl(i));
        }
        if (this.cDl != null) {
            this.cDl.setText(kl(kk(i2)));
        }
    }

    public void showProgress() {
        if (this.cDj != null) {
            this.cDi = ((this.cDj.getDuration() / 200) / 50) * 50;
            if (this.cDi < 50) {
                this.cDi = 50;
            }
            this.cDn = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cDi - (this.cDj.getCurrentPosition() % this.cDi));
            this.eDN.removeMessages(2);
            this.eDN.sendMessage(this.eDN.obtainMessage(2));
        }
    }

    public void ajI() {
        this.cDn = false;
        this.mHandler.removeMessages(1);
        this.eDN.removeMessages(2);
        this.cDo.setProgress(0);
        if (this.cDk != null) {
            this.cDk.setText(kl(0));
        }
    }

    public void aTC() {
        if (this.cDo != null) {
            this.cDo.setProgress(10000);
        }
        if (this.cDk != null) {
            this.cDk.setText(kl(this.eDM));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ajJ() {
        if (this.cDj == null || this.cDm) {
            return 0;
        }
        int currentPosition = this.cDj.getCurrentPosition();
        int duration = this.cDj.getDuration();
        if (this.cDo != null) {
            if (duration > 0) {
                this.cDo.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cDj.getBufferPercentage();
        }
        if (this.cDk != null) {
            this.cDk.setText(kl(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int kk(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kl(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cDp.setLength(0);
        return i5 > 0 ? this.cDq.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cDq.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public int getCurProgress() {
        if (this.cDo != null) {
            return this.cDo.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.aKf = bVar;
    }

    public void setOnProgressUpdatedNoDelayListener(b bVar) {
        this.aKg = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.aKm = aVar;
    }
}
