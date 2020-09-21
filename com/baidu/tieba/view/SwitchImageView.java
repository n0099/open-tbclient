package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int bOf;
    private int mUs;
    private int mUt;
    private boolean mUu;
    private com.baidu.tbadk.core.util.d.a mUv;
    private com.baidu.tbadk.core.util.d.a mUw;

    public SwitchImageView(Context context) {
        super(context);
        this.mUu = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUu = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUu = false;
        init();
    }

    private void init() {
        this.bOf = 0;
        this.mUs = 0;
        this.mUt = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mUs = i;
        this.mUt = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.mUv = aVar;
        this.mUw = aVar2;
        this.mUu = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.bOf = 0;
            if (this.mUu) {
                setImageDrawable(this.mUv.getDrawable());
            } else {
                setImageResource(this.mUs);
            }
        } else if (i == 1) {
            this.bOf = 1;
            if (this.mUu) {
                setImageDrawable(this.mUw.getDrawable());
            } else {
                setImageResource(this.mUt);
            }
        }
    }

    public void dJr() {
        if (this.bOf == 0) {
            this.bOf = 1;
            setState(1);
            return;
        }
        this.bOf = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.bOf;
    }
}
