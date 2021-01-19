package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cqj;
    private int nQD;
    private int nQE;
    private boolean nQF;
    private com.baidu.tbadk.core.util.e.a nQG;
    private com.baidu.tbadk.core.util.e.a nQH;

    public SwitchImageView(Context context) {
        super(context);
        this.nQF = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQF = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQF = false;
        init();
    }

    private void init() {
        this.cqj = 0;
        this.nQD = 0;
        this.nQE = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nQD = i;
        this.nQE = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.nQG = aVar;
        this.nQH = aVar2;
        this.nQF = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cqj = 0;
            if (this.nQF) {
                setImageDrawable(this.nQG.getDrawable());
            } else {
                setImageResource(this.nQD);
            }
        } else if (i == 1) {
            this.cqj = 1;
            if (this.nQF) {
                setImageDrawable(this.nQH.getDrawable());
            } else {
                setImageResource(this.nQE);
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
