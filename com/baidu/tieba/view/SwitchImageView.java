package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int ciY;
    private int nCm;
    private int nCn;
    private boolean nCo;
    private com.baidu.tbadk.core.util.d.a nCp;
    private com.baidu.tbadk.core.util.d.a nCq;

    public SwitchImageView(Context context) {
        super(context);
        this.nCo = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nCo = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCo = false;
        init();
    }

    private void init() {
        this.ciY = 0;
        this.nCm = 0;
        this.nCn = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nCm = i;
        this.nCn = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.nCp = aVar;
        this.nCq = aVar2;
        this.nCo = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.ciY = 0;
            if (this.nCo) {
                setImageDrawable(this.nCp.getDrawable());
            } else {
                setImageResource(this.nCm);
            }
        } else if (i == 1) {
            this.ciY = 1;
            if (this.nCo) {
                setImageDrawable(this.nCq.getDrawable());
            } else {
                setImageResource(this.nCn);
            }
        }
    }

    public void dSN() {
        if (this.ciY == 0) {
            this.ciY = 1;
            setState(1);
            return;
        }
        this.ciY = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.ciY;
    }
}
