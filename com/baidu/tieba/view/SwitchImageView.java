package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int hFy;
    private int hFz;
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
        this.hFy = 0;
        this.hFz = 0;
    }

    public void setStateImage(int i, int i2) {
        this.hFy = i;
        this.hFz = i2;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            setImageResource(this.hFy);
        } else if (i == 1) {
            this.mCurrentState = 1;
            setImageResource(this.hFz);
        }
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }
}
