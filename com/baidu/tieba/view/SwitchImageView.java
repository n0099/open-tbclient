package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int bGB;
    private int mrW;
    private int mrX;
    private boolean mrY;
    private com.baidu.tbadk.core.util.d.a mrZ;
    private com.baidu.tbadk.core.util.d.a msa;

    public SwitchImageView(Context context) {
        super(context);
        this.mrY = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mrY = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrY = false;
        init();
    }

    private void init() {
        this.bGB = 0;
        this.mrW = 0;
        this.mrX = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mrW = i;
        this.mrX = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.mrZ = aVar;
        this.msa = aVar2;
        this.mrY = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.bGB = 0;
            if (this.mrY) {
                setImageDrawable(this.mrZ.getDrawable());
            } else {
                setImageResource(this.mrW);
            }
        } else if (i == 1) {
            this.bGB = 1;
            if (this.mrY) {
                setImageDrawable(this.msa.getDrawable());
            } else {
                setImageResource(this.mrX);
            }
        }
    }

    public void dtS() {
        if (this.bGB == 0) {
            this.bGB = 1;
            setState(1);
            return;
        }
        this.bGB = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.bGB;
    }
}
