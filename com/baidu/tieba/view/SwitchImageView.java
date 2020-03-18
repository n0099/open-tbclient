package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kLh;
    private int kLi;
    private boolean kLj;
    private com.baidu.tbadk.core.util.d.a kLk;
    private com.baidu.tbadk.core.util.d.a kLl;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kLj = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kLj = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kLj = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kLh = 0;
        this.kLi = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kLh = i;
        this.kLi = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.kLk = aVar;
        this.kLl = aVar2;
        this.kLj = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kLj) {
                setImageDrawable(this.kLk.getDrawable());
            } else {
                setImageResource(this.kLh);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kLj) {
                setImageDrawable(this.kLl.getDrawable());
            } else {
                setImageResource(this.kLi);
            }
        }
    }

    public void cTX() {
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
