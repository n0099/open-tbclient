package com.baidu.tieba.pb.view;

import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class PbVideoControllerView extends RelativeLayout {
    private int dqB;
    private MediaController.MediaPlayerControl dqC;
    private TextView dqD;
    private TextView dqE;
    private boolean dqF;
    private boolean dqG;
    private SeekBar dqH;
    private StringBuilder dqI;
    private Formatter dqJ;
    private SeekBar.OnSeekBarChangeListener dqK;
    private Context mContext;
    private Handler mHandler;

    public PbVideoControllerView(Context context) {
        super(context);
        this.dqB = 50;
        this.dqF = false;
        this.dqG = true;
        this.mHandler = new i(this, Looper.getMainLooper());
        this.dqK = new j(this);
        init(context);
    }

    public PbVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqB = 50;
        this.dqF = false;
        this.dqG = true;
        this.mHandler = new i(this, Looper.getMainLooper());
        this.dqK = new j(this);
        init(context);
    }

    public PbVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dqB = 50;
        this.dqF = false;
        this.dqG = true;
        this.mHandler = new i(this, Looper.getMainLooper());
        this.dqK = new j(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(t.h.pb_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(t.e.ds80));
        this.dqD = (TextView) inflate.findViewById(t.g.textview_cur_time);
        this.dqE = (TextView) inflate.findViewById(t.g.textview_duration);
        this.dqH = (SeekBar) inflate.findViewById(t.g.pb_video_controller_seekBar);
        this.dqH.setOnSeekBarChangeListener(this.dqK);
        this.dqI = new StringBuilder();
        this.dqJ = new Formatter(this.dqI, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dqC = mediaPlayerControl;
    }

    public void aN(int i, int i2) {
        this.dqG = false;
        this.mHandler.removeMessages(1);
        this.dqH.setProgress(0);
        if (this.dqD != null) {
            this.dqD.setText(mt(i));
        }
        if (this.dqE != null) {
            this.dqE.setText(mt(ms(i2)));
        }
    }

    public void afJ() {
        if (this.dqC != null) {
            this.dqB = ((this.dqC.getDuration() / 200) / 50) * 50;
            if (this.dqB < 50) {
                this.dqB = 50;
            }
            this.dqG = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dqB - (this.dqC.getCurrentPosition() % this.dqB));
        }
    }

    public void aAD() {
        this.dqG = false;
        this.mHandler.removeMessages(1);
        this.dqH.setProgress(0);
        if (this.dqD != null) {
            this.dqD.setText(mt(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAE() {
        if (this.dqC == null || this.dqF) {
            return 0;
        }
        int currentPosition = this.dqC.getCurrentPosition();
        int duration = this.dqC.getDuration();
        if (this.dqH != null) {
            if (duration > 0) {
                this.dqH.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dqC.getBufferPercentage();
        }
        if (this.dqE != null && duration > 0) {
            this.dqE.setText(mt(ms(duration)));
        }
        if (this.dqD != null) {
            this.dqD.setText(mt(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int ms(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mt(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.dqI.setLength(0);
        return i5 > 0 ? this.dqJ.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.dqJ.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        at.b(this.dqD, t.d.cp_cont_i, 1);
        at.b(this.dqE, t.d.cp_cont_i, 1);
        this.dqH.setProgressDrawable(at.c((Resources) null, t.f.pb_video_seekbar));
        this.dqH.setThumb(at.c((Resources) null, t.f.pb_video_seekbar_thumb));
        this.dqH.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.dqH != null) {
            return this.dqH.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
