package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int bMf;
    private int mKB;
    private int mKC;
    private boolean mKD;
    private com.baidu.tbadk.core.util.d.a mKE;
    private com.baidu.tbadk.core.util.d.a mKF;

    public SwitchImageView(Context context) {
        super(context);
        this.mKD = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKD = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKD = false;
        init();
    }

    private void init() {
        this.bMf = 0;
        this.mKB = 0;
        this.mKC = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mKB = i;
        this.mKC = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.mKE = aVar;
        this.mKF = aVar2;
        this.mKD = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.bMf = 0;
            if (this.mKD) {
                setImageDrawable(this.mKE.getDrawable());
            } else {
                setImageResource(this.mKB);
            }
        } else if (i == 1) {
            this.bMf = 1;
            if (this.mKD) {
                setImageDrawable(this.mKF.getDrawable());
            } else {
                setImageResource(this.mKC);
            }
        }
    }

    public void dFx() {
        if (this.bMf == 0) {
            this.bMf = 1;
            setState(1);
            return;
        }
        this.bMf = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.bMf;
    }
}
