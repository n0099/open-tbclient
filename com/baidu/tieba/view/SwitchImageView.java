package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cnU;
    private int nRN;
    private int nRO;
    private boolean nRP;
    private com.baidu.tbadk.core.util.d.a nRQ;
    private com.baidu.tbadk.core.util.d.a nRR;

    public SwitchImageView(Context context) {
        super(context);
        this.nRP = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRP = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRP = false;
        init();
    }

    private void init() {
        this.cnU = 0;
        this.nRN = 0;
        this.nRO = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nRN = i;
        this.nRO = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.nRQ = aVar;
        this.nRR = aVar2;
        this.nRP = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cnU = 0;
            if (this.nRP) {
                setImageDrawable(this.nRQ.getDrawable());
            } else {
                setImageResource(this.nRN);
            }
        } else if (i == 1) {
            this.cnU = 1;
            if (this.nRP) {
                setImageDrawable(this.nRR.getDrawable());
            } else {
                setImageResource(this.nRO);
            }
        }
    }

    public void dYh() {
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
