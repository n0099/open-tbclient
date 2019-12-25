package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kEL;
    private int kEM;
    private boolean kEN;
    private com.baidu.tbadk.core.util.e.a kEO;
    private com.baidu.tbadk.core.util.e.a kEP;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kEN = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kEN = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kEN = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kEL = 0;
        this.kEM = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kEL = i;
        this.kEM = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.kEO = aVar;
        this.kEP = aVar2;
        this.kEN = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kEN) {
                setImageDrawable(this.kEO.getDrawable());
            } else {
                setImageResource(this.kEL);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kEN) {
                setImageDrawable(this.kEP.getDrawable());
            } else {
                setImageResource(this.kEM);
            }
        }
    }

    public void cRa() {
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
