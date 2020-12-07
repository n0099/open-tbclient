package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cnU;
    private int nRL;
    private int nRM;
    private boolean nRN;
    private com.baidu.tbadk.core.util.d.a nRO;
    private com.baidu.tbadk.core.util.d.a nRP;

    public SwitchImageView(Context context) {
        super(context);
        this.nRN = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRN = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRN = false;
        init();
    }

    private void init() {
        this.cnU = 0;
        this.nRL = 0;
        this.nRM = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nRL = i;
        this.nRM = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.nRO = aVar;
        this.nRP = aVar2;
        this.nRN = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cnU = 0;
            if (this.nRN) {
                setImageDrawable(this.nRO.getDrawable());
            } else {
                setImageResource(this.nRL);
            }
        } else if (i == 1) {
            this.cnU = 1;
            if (this.nRN) {
                setImageDrawable(this.nRP.getDrawable());
            } else {
                setImageResource(this.nRM);
            }
        }
    }

    public void dYg() {
        if (this.cnU == 0) {
            this.cnU = 1;
            setState(1);
            return;
        }
        this.cnU = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.cnU;
    }
}
