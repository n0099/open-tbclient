package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kJA;
    private int kJB;
    private boolean kJC;
    private com.baidu.tbadk.core.util.d.a kJD;
    private com.baidu.tbadk.core.util.d.a kJE;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kJC = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kJC = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kJC = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kJA = 0;
        this.kJB = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kJA = i;
        this.kJB = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.kJD = aVar;
        this.kJE = aVar2;
        this.kJC = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kJC) {
                setImageDrawable(this.kJD.getDrawable());
            } else {
                setImageResource(this.kJA);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kJC) {
                setImageDrawable(this.kJE.getDrawable());
            } else {
                setImageResource(this.kJB);
            }
        }
    }

    public void cTD() {
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
