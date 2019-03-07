package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int jiJ;
    private int jiK;
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
        this.jiJ = 0;
        this.jiK = 0;
    }

    public void setStateImage(int i, int i2) {
        this.jiJ = i;
        this.jiK = i2;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            setImageResource(this.jiJ);
        } else if (i == 1) {
            this.mCurrentState = 1;
            setImageResource(this.jiK);
        }
    }

    public void cmS() {
        if (this.mCurrentState == 0) {
            this.mCurrentState = 1;
            setImageResource(this.jiK);
            return;
        }
        this.mCurrentState = 0;
        setImageResource(this.jiJ);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }
}
