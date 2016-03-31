package com.baidu.tieba.pb.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbVideoProgressView extends RelativeLayout {
    private int dqB;
    private MediaController.MediaPlayerControl dqC;
    private boolean dqG;
    private View dqM;
    private Handler mHandler;

    public PbVideoProgressView(Context context) {
        super(context);
        this.dqB = 50;
        this.dqG = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        init(context);
    }

    public PbVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqB = 50;
        this.dqG = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        init(context);
    }

    public PbVideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dqB = 50;
        this.dqG = true;
        this.mHandler = new k(this, Looper.getMainLooper());
        init(context);
    }

    private void init(Context context) {
        this.dqM = new View(context);
        this.dqM.setBackgroundColor(getResources().getColor(t.d.cp_other_d));
        addView(this.dqM, 0, (int) context.getResources().getDimension(t.e.ds6));
        setBackgroundColor(getResources().getColor(t.d.cp_bg_line_a));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dqC = mediaPlayerControl;
    }

    public void aAF() {
        this.dqG = false;
        this.mHandler.removeMessages(1);
        if (this.dqM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqM.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                layoutParams.width = 0;
                this.dqM.setLayoutParams(layoutParams);
            }
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
        aAF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAE() {
        if (this.dqC == null || this.dqM == null) {
            return 0;
        }
        int currentPosition = this.dqC.getCurrentPosition();
        int duration = this.dqC.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqM.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.dqM.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        at.l(this, t.d.cp_bg_line_a);
        at.l(this.dqM, t.d.cp_other_d);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
