package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int lPM;
    private int lPN;
    private boolean lPO;
    private com.baidu.tbadk.core.util.d.a lPP;
    private com.baidu.tbadk.core.util.d.a lPQ;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.lPO = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lPO = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPO = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.lPM = 0;
        this.lPN = 0;
    }

    public void setStateImage(int i, int i2) {
        this.lPM = i;
        this.lPN = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.lPP = aVar;
        this.lPQ = aVar2;
        this.lPO = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.lPO) {
                setImageDrawable(this.lPP.getDrawable());
            } else {
                setImageResource(this.lPM);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.lPO) {
                setImageDrawable(this.lPQ.getDrawable());
            } else {
                setImageResource(this.lPN);
            }
        }
    }

    public void dmp() {
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
