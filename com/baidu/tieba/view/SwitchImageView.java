package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int bGB;
    private int mrY;
    private int mrZ;
    private boolean msa;
    private com.baidu.tbadk.core.util.d.a msb;
    private com.baidu.tbadk.core.util.d.a msc;

    public SwitchImageView(Context context) {
        super(context);
        this.msa = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.msa = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.msa = false;
        init();
    }

    private void init() {
        this.bGB = 0;
        this.mrY = 0;
        this.mrZ = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mrY = i;
        this.mrZ = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.msb = aVar;
        this.msc = aVar2;
        this.msa = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.bGB = 0;
            if (this.msa) {
                setImageDrawable(this.msb.getDrawable());
            } else {
                setImageResource(this.mrY);
            }
        } else if (i == 1) {
            this.bGB = 1;
            if (this.msa) {
                setImageDrawable(this.msc.getDrawable());
            } else {
                setImageResource(this.mrZ);
            }
        }
    }

    public void dtT() {
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
