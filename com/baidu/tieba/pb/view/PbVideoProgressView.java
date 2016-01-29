package com.baidu.tieba.pb.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbVideoProgressView extends RelativeLayout {
    private int cVG;
    private MediaController.MediaPlayerControl cVH;
    private boolean cVL;
    private View cVR;
    private Handler mHandler;

    public PbVideoProgressView(Context context) {
        super(context);
        this.cVG = 50;
        this.cVL = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        init(context);
    }

    public PbVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVG = 50;
        this.cVL = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        init(context);
    }

    public PbVideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVG = 50;
        this.cVL = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        init(context);
    }

    private void init(Context context) {
        this.cVR = new View(context);
        this.cVR.setBackgroundColor(getResources().getColor(t.d.cp_other_d));
        addView(this.cVR, 0, (int) context.getResources().getDimension(t.e.ds6));
        setBackgroundColor(getResources().getColor(t.d.cp_bg_line_a));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cVH = mediaPlayerControl;
    }

    public void asV() {
        this.cVL = false;
        this.mHandler.removeMessages(1);
        if (this.cVR != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cVR.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                layoutParams.width = 0;
                this.cVR.setLayoutParams(layoutParams);
            }
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
        asV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int asU() {
        if (this.cVH == null || this.cVR == null) {
            return 0;
        }
        int currentPosition = this.cVH.getCurrentPosition();
        int duration = this.cVH.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cVR.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.cVR.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        ar.l(this, t.d.cp_bg_line_a);
        ar.l(this.cVR, t.d.cp_other_d);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
