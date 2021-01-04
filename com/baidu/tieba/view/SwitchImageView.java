package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cvb;
    private int nVi;
    private int nVj;
    private boolean nVk;
    private com.baidu.tbadk.core.util.e.a nVl;
    private com.baidu.tbadk.core.util.e.a nVm;

    public SwitchImageView(Context context) {
        super(context);
        this.nVk = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nVk = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nVk = false;
        init();
    }

    private void init() {
        this.cvb = 0;
        this.nVi = 0;
        this.nVj = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nVi = i;
        this.nVj = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.nVl = aVar;
        this.nVm = aVar2;
        this.nVk = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cvb = 0;
            if (this.nVk) {
                setImageDrawable(this.nVl.getDrawable());
            } else {
                setImageResource(this.nVi);
            }
        } else if (i == 1) {
            this.cvb = 1;
            if (this.nVk) {
                setImageDrawable(this.nVm.getDrawable());
            } else {
                setImageResource(this.nVj);
            }
        }
    }

    public void dXK() {
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
