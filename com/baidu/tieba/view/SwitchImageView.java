package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kJm;
    private int kJn;
    private boolean kJo;
    private com.baidu.tbadk.core.util.e.a kJp;
    private com.baidu.tbadk.core.util.e.a kJq;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kJo = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kJo = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kJo = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kJm = 0;
        this.kJn = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kJm = i;
        this.kJn = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.kJp = aVar;
        this.kJq = aVar2;
        this.kJo = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kJo) {
                setImageDrawable(this.kJp.getDrawable());
            } else {
                setImageResource(this.kJm);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kJo) {
                setImageDrawable(this.kJq.getDrawable());
            } else {
                setImageResource(this.kJn);
            }
        }
    }

    public void cTA() {
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
