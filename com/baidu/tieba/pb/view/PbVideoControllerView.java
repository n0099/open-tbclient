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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class PbVideoControllerView extends RelativeLayout {
    private int cVG;
    private MediaController.MediaPlayerControl cVH;
    private TextView cVI;
    private TextView cVJ;
    private boolean cVK;
    private boolean cVL;
    private SeekBar cVM;
    private StringBuilder cVN;
    private Formatter cVO;
    private SeekBar.OnSeekBarChangeListener cVP;
    private Context mContext;
    private Handler mHandler;

    public PbVideoControllerView(Context context) {
        super(context);
        this.cVG = 50;
        this.cVK = false;
        this.cVL = true;
        this.mHandler = new i(this, Looper.getMainLooper());
        this.cVP = new j(this);
        init(context);
    }

    public PbVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVG = 50;
        this.cVK = false;
        this.cVL = true;
        this.mHandler = new i(this, Looper.getMainLooper());
        this.cVP = new j(this);
        init(context);
    }

    public PbVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVG = 50;
        this.cVK = false;
        this.cVL = true;
        this.mHandler = new i(this, Looper.getMainLooper());
        this.cVP = new j(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(t.h.pb_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(t.e.ds80));
        this.cVI = (TextView) inflate.findViewById(t.g.textview_cur_time);
        this.cVJ = (TextView) inflate.findViewById(t.g.textview_duration);
        this.cVM = (SeekBar) inflate.findViewById(t.g.pb_video_controller_seekBar);
        this.cVM.setOnSeekBarChangeListener(this.cVP);
        this.cVN = new StringBuilder();
        this.cVO = new Formatter(this.cVN, Locale.getDefault());
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cVH = mediaPlayerControl;
    }

    public void aN(int i, int i2) {
        this.cVL = false;
        this.mHandler.removeMessages(1);
        this.cVM.setProgress(0);
        if (this.cVI != null) {
            this.cVI.setText(lk(i));
        }
        if (this.cVJ != null) {
            this.cVJ.setText(lk(lj(i2)));
        }
    }

    public void aco() {
        if (this.cVH != null) {
            this.cVG = ((this.cVH.getDuration() / 200) / 50) * 50;
            if (this.cVG < 50) {
                this.cVG = 50;
            }
            this.cVL = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cVG - (this.cVH.getCurrentPosition() % this.cVG));
        }
    }

    public void asT() {
        this.cVL = false;
        this.mHandler.removeMessages(1);
        this.cVM.setProgress(0);
        if (this.cVI != null) {
            this.cVI.setText(lk(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int asU() {
        if (this.cVH == null || this.cVK) {
            return 0;
        }
        int currentPosition = this.cVH.getCurrentPosition();
        int duration = this.cVH.getDuration();
        if (this.cVM != null) {
            if (duration > 0) {
                this.cVM.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cVH.getBufferPercentage();
        }
        if (this.cVJ != null && duration > 0) {
            this.cVJ.setText(lk(lj(duration)));
        }
        if (this.cVI != null) {
            this.cVI.setText(lk(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    private int lj(int i) {
        return (int) (Math.ceil((1.0f * i) / 1000.0f) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lk(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.cVN.setLength(0);
        return i5 > 0 ? this.cVO.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.cVO.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void onChangeSkinType(int i) {
        ar.b(this.cVI, t.d.cp_cont_i, 1);
        ar.b(this.cVJ, t.d.cp_cont_i, 1);
        this.cVM.setProgressDrawable(ar.c((Resources) null, t.f.pb_video_seekbar));
        this.cVM.setThumb(ar.c((Resources) null, t.f.pb_video_seekbar_thumb));
        this.cVM.setThumbOffset(0);
    }

    public int getCurProgress() {
        if (this.cVM != null) {
            return this.cVM.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
