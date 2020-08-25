package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class SwitchImageView extends AppCompatImageView {
    private int bMb;
    private int mKj;
    private int mKk;
    private boolean mKl;
    private com.baidu.tbadk.core.util.d.a mKm;
    private com.baidu.tbadk.core.util.d.a mKn;

    public SwitchImageView(Context context) {
        super(context);
        this.mKl = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKl = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKl = false;
        init();
    }

    private void init() {
        this.bMb = 0;
        this.mKj = 0;
        this.mKk = 0;
    }

    public void setStateImage(int i, int i2) {
        this.mKj = i;
        this.mKk = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.mKm = aVar;
        this.mKn = aVar2;
        this.mKl = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.bMb = 0;
            if (this.mKl) {
                setImageDrawable(this.mKm.getDrawable());
            } else {
                setImageResource(this.mKj);
            }
        } else if (i == 1) {
            this.bMb = 1;
            if (this.mKl) {
                setImageDrawable(this.mKn.getDrawable());
            } else {
                setImageResource(this.mKk);
            }
        }
    }

    public void dFo() {
        if (this.bMb == 0) {
            this.bMb = 1;
            setState(1);
            return;
        }
        this.bMb = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.bMb;
    }
}
