package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int chm;
    private int nDJ;
    private int nDK;
    private boolean nDL;
    private com.baidu.tbadk.core.util.d.a nDM;
    private com.baidu.tbadk.core.util.d.a nDN;

    public SwitchImageView(Context context) {
        super(context);
        this.nDL = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nDL = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDL = false;
        init();
    }

    private void init() {
        this.chm = 0;
        this.nDJ = 0;
        this.nDK = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nDJ = i;
        this.nDK = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.nDM = aVar;
        this.nDN = aVar2;
        this.nDL = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.chm = 0;
            if (this.nDL) {
                setImageDrawable(this.nDM.getDrawable());
            } else {
                setImageResource(this.nDJ);
            }
        } else if (i == 1) {
            this.chm = 1;
            if (this.nDL) {
                setImageDrawable(this.nDN.getDrawable());
            } else {
                setImageResource(this.nDK);
            }
        }
    }

    public void dSM() {
        if (this.chm == 0) {
            this.chm = 1;
            setState(1);
            return;
        }
        this.chm = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.chm;
    }
}
