package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int mCurrentState;
    private int mjW;
    private int mjX;
    private boolean mjY;
    private com.baidu.tbadk.core.util.d.a mjZ;
    private com.baidu.tbadk.core.util.d.a mka;

    public SwitchImageView(Context context) {
        super(context);
        this.mjY = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjY = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjY = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.mjW = 0;
        this.mjX = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mjW = i;
        this.mjX = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.mjZ = aVar;
        this.mka = aVar2;
        this.mjY = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.mjY) {
                setImageDrawable(this.mjZ.getDrawable());
            } else {
                setImageResource(this.mjW);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.mjY) {
                setImageDrawable(this.mka.getDrawable());
            } else {
                setImageResource(this.mjX);
            }
        }
    }

    public void dqG() {
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
