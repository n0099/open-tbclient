package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int lvI;
    private int lvJ;
    private boolean lvK;
    private com.baidu.tbadk.core.util.d.a lvL;
    private com.baidu.tbadk.core.util.d.a lvM;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.lvK = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lvK = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lvK = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.lvI = 0;
        this.lvJ = 0;
    }

    public void setStateImage(int i, int i2) {
        this.lvI = i;
        this.lvJ = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.lvL = aVar;
        this.lvM = aVar2;
        this.lvK = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.lvK) {
                setImageDrawable(this.lvL.getDrawable());
            } else {
                setImageResource(this.lvI);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.lvK) {
                setImageDrawable(this.lvM.getDrawable());
            } else {
                setImageResource(this.lvJ);
            }
        }
    }

    public void deK() {
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
