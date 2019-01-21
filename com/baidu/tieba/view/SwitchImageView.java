package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int hSN;
    private int hSO;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.hSN = 0;
        this.hSO = 0;
    }

    public void setStateImage(int i, int i2) {
        this.hSN = i;
        this.hSO = i2;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            setImageResource(this.hSN);
        } else if (i == 1) {
            this.mCurrentState = 1;
            setImageResource(this.hSO);
        }
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }
}
