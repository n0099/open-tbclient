package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kIm;
    private int kIn;
    private boolean kIo;
    private com.baidu.tbadk.core.util.e.a kIp;
    private com.baidu.tbadk.core.util.e.a kIq;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kIo = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIo = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIo = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kIm = 0;
        this.kIn = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kIm = i;
        this.kIn = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.kIp = aVar;
        this.kIq = aVar2;
        this.kIo = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kIo) {
                setImageDrawable(this.kIp.getDrawable());
            } else {
                setImageResource(this.kIm);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kIo) {
                setImageDrawable(this.kIq.getDrawable());
            } else {
                setImageResource(this.kIn);
            }
        }
    }

    public void cSd() {
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
