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
    private int dsF;
    private MediaController.MediaPlayerControl dsG;
    private TextView dsH;
    private TextView dsI;
    private boolean dsJ;
    private boolean dsK;
    private SeekBar dsL;
    private StringBuilder dsM;
    private Formatter dsN;
    private SeekBar.OnSeekBarChangeListener dsO;
    private Context mContext;
    private Handler mHandler;

    public PbVideoControllerView(Context context) {
        super(context);
        this.dsF = 50;
        this.dsJ = false;
        this.dsK = true;
        this.mHandler = new o(this, Looper.getMainLooper());
        this.dsO = new p(this);
        init(context);
    }

    public PbVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsF = 50;
        this.dsJ = false;
        this.dsK = true;
        this.mHandler = new o(this, Looper.getMainLooper());
        this.dsO = new p(this);
        init(context);
    }

    public PbVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsF = 50;
        this.dsJ = false;
        this.dsK = true;
        this.mHandler = new o(this, Looper.getMainLooper());
        this.dsO = new p(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(t.h.pb_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(t.e.ds80));
        this.dsH = (TextView) inflate.findViewById(t.g.textview_cur_time);
        this.dsI = (TextView) inflate.findViewById(t.g.textview_duration);
        this.dsL = (SeekBar) inflate.findViewById(t.g.pb_video_controller_seekBar);
        this.dsL.setOnSeekBarChangeListener(this.dsO);
        this.dsM = new StringBuilder();
        this.dsN = new Formatter(this.dsM, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dsG = mediaPlayerControl;
    }

    public void aO(int i, int i2) {
        this.dsK = false;
        this.mHandler.removeMessages(1);
        this.dsL.setProgress(0);
        if (this.dsH != null) {
            this.dsH.setText(me(i));
        }
        if (this.dsI != null) {
            this.dsI.setText(me(md(i2)));
        }
    }

    public void afQ() {
        if (this.dsG != null) {
            this.dsF = ((this.dsG.getDuration() / 200) / 50) * 50;
            if (this.dsF < 50) {
                this.dsF = 50;
            }
            this.dsK = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dsF - (this.dsG.getCurrentPosition() % this.dsF));
        }
    }

    public void aAR() {
        this.dsK = false;
        this.mHandler.removeMessages(1);
        this.dsL.setProgress(0);
        if (this.dsH != null) {
            this.dsH.setText(me(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAS() {
        if (this.dsG == null || this.dsJ) {
            return 0;
        }
        int currentPosition = this.dsG.getCurrentPosition();
        int duration = this.dsG.getDuration();
        if (this.dsL != null) {
            if (duration > 0) {
                this.dsL.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dsG.getBufferPercentage();
        }
        if (this.dsI != null && duration > 0) {
            this.dsI.setText(me(md(duration)));
        }
        if (this.dsH != null) {
            this.dsH.setText(me(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int md(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String me(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.dsM.setLength(0);
        return i5 > 0 ? this.dsN.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.dsN.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        at.c(this.dsH, t.d.cp_cont_i, 1);
        at.c(this.dsI, t.d.cp_cont_i, 1);
        this.dsL.setProgressDrawable(at.c((Resources) null, t.f.pb_video_seekbar));
        this.dsL.setThumb(at.c((Resources) null, t.f.pb_video_seekbar_thumb));
        this.dsL.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.dsL != null) {
            return this.dsL.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
