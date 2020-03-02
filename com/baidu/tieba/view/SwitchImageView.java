package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kJo;
    private int kJp;
    private boolean kJq;
    private com.baidu.tbadk.core.util.e.a kJr;
    private com.baidu.tbadk.core.util.e.a kJs;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kJq = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kJq = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kJq = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kJo = 0;
        this.kJp = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kJo = i;
        this.kJp = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.kJr = aVar;
        this.kJs = aVar2;
        this.kJq = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kJq) {
                setImageDrawable(this.kJr.getDrawable());
            } else {
                setImageResource(this.kJo);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kJq) {
                setImageDrawable(this.kJs.getDrawable());
            } else {
                setImageResource(this.kJp);
            }
        }
    }

    public void cTC() {
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
