package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int kIr;
    private int kIs;
    private boolean kIt;
    private com.baidu.tbadk.core.util.e.a kIu;
    private com.baidu.tbadk.core.util.e.a kIv;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.kIt = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIt = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIt = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.kIr = 0;
        this.kIs = 0;
    }

    public void setStateImage(int i, int i2) {
        this.kIr = i;
        this.kIs = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.kIu = aVar;
        this.kIv = aVar2;
        this.kIt = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.kIt) {
                setImageDrawable(this.kIu.getDrawable());
            } else {
                setImageResource(this.kIr);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.kIt) {
                setImageDrawable(this.kIv.getDrawable());
            } else {
                setImageResource(this.kIs);
            }
        }
    }

    public void cSf() {
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
