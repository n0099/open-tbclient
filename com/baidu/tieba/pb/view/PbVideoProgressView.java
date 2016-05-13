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
    private int dsF;
    private MediaController.MediaPlayerControl dsG;
    private boolean dsK;
    private View dsQ;
    private Handler mHandler;

    public PbVideoProgressView(Context context) {
        super(context);
        this.dsF = 50;
        this.dsK = true;
        this.mHandler = new q(this, Looper.getMainLooper());
        init(context);
    }

    public PbVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsF = 50;
        this.dsK = true;
        this.mHandler = new q(this, Looper.getMainLooper());
        init(context);
    }

    public PbVideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsF = 50;
        this.dsK = true;
        this.mHandler = new q(this, Looper.getMainLooper());
        init(context);
    }

    private void init(Context context) {
        this.dsQ = new View(context);
        this.dsQ.setBackgroundColor(getResources().getColor(t.d.cp_other_d));
        addView(this.dsQ, 0, (int) context.getResources().getDimension(t.e.ds6));
        setBackgroundColor(getResources().getColor(t.d.cp_bg_line_a));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dsG = mediaPlayerControl;
    }

    public void aAT() {
        this.dsK = false;
        this.mHandler.removeMessages(1);
        if (this.dsQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsQ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                layoutParams.width = 0;
                this.dsQ.setLayoutParams(layoutParams);
            }
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
        aAT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAS() {
        if (this.dsG == null || this.dsQ == null) {
            return 0;
        }
        int currentPosition = this.dsG.getCurrentPosition();
        int duration = this.dsG.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsQ.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((1.0f * getWidth()) * currentPosition) / duration);
            this.dsQ.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void onChangeSkinType(int i) {
        at.l(this, t.d.cp_bg_line_a);
        at.l(this.dsQ, t.d.cp_other_d);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }
}
