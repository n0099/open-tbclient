package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cqj;
    private int nQC;
    private int nQD;
    private boolean nQE;
    private com.baidu.tbadk.core.util.e.a nQF;
    private com.baidu.tbadk.core.util.e.a nQG;

    public SwitchImageView(Context context) {
        super(context);
        this.nQE = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQE = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQE = false;
        init();
    }

    private void init() {
        this.cqj = 0;
        this.nQC = 0;
        this.nQD = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nQC = i;
        this.nQD = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.nQF = aVar;
        this.nQG = aVar2;
        this.nQE = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cqj = 0;
            if (this.nQE) {
                setImageDrawable(this.nQF.getDrawable());
            } else {
                setImageResource(this.nQC);
            }
        } else if (i == 1) {
            this.cqj = 1;
            if (this.nQE) {
                setImageDrawable(this.nQG.getDrawable());
            } else {
                setImageResource(this.nQD);
            }
        }
    }

    public void dTT() {
        if (this.cqj == 0) {
            this.cqj = 1;
            setState(1);
            return;
        }
        this.cqj = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.cqj;
    }
}
