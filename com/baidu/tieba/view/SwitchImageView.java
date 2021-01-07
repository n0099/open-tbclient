package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cvb;
    private int nVh;
    private int nVi;
    private boolean nVj;
    private com.baidu.tbadk.core.util.e.a nVk;
    private com.baidu.tbadk.core.util.e.a nVl;

    public SwitchImageView(Context context) {
        super(context);
        this.nVj = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nVj = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nVj = false;
        init();
    }

    private void init() {
        this.cvb = 0;
        this.nVh = 0;
        this.nVi = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nVh = i;
        this.nVi = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.nVk = aVar;
        this.nVl = aVar2;
        this.nVj = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cvb = 0;
            if (this.nVj) {
                setImageDrawable(this.nVk.getDrawable());
            } else {
                setImageResource(this.nVh);
            }
        } else if (i == 1) {
            this.cvb = 1;
            if (this.nVj) {
                setImageDrawable(this.nVl.getDrawable());
            } else {
                setImageResource(this.nVi);
            }
        }
    }

    public void dXL() {
        if (this.cvb == 0) {
            this.cvb = 1;
            setState(1);
            return;
        }
        this.cvb = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.cvb;
    }
}
