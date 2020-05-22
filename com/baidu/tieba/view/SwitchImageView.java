package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int lOE;
    private int lOF;
    private boolean lOG;
    private com.baidu.tbadk.core.util.d.a lOH;
    private com.baidu.tbadk.core.util.d.a lOI;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.lOG = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lOG = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lOG = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.lOE = 0;
        this.lOF = 0;
    }

    public void setStateImage(int i, int i2) {
        this.lOE = i;
        this.lOF = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.lOH = aVar;
        this.lOI = aVar2;
        this.lOG = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.lOG) {
                setImageDrawable(this.lOH.getDrawable());
            } else {
                setImageResource(this.lOE);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.lOG) {
                setImageDrawable(this.lOI.getDrawable());
            } else {
                setImageResource(this.lOF);
            }
        }
    }

    public void dma() {
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
