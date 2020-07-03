package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int mCurrentState;
    private int mjT;
    private int mjU;
    private boolean mjV;
    private com.baidu.tbadk.core.util.d.a mjW;
    private com.baidu.tbadk.core.util.d.a mjX;

    public SwitchImageView(Context context) {
        super(context);
        this.mjV = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjV = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjV = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.mjT = 0;
        this.mjU = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mjT = i;
        this.mjU = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.mjW = aVar;
        this.mjX = aVar2;
        this.mjV = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.mjV) {
                setImageDrawable(this.mjW.getDrawable());
            } else {
                setImageResource(this.mjT);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.mjV) {
                setImageDrawable(this.mjX.getDrawable());
            } else {
                setImageResource(this.mjU);
            }
        }
    }

    public void dqC() {
        if (this.mCurrentState == 0) {
            this.mCurrentState = 1;
            setState(1);
            return;
        }
        this.mCurrentState = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }
}
