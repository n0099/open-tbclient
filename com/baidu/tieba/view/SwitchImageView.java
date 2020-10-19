package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int bUO;
    private int njR;
    private int njS;
    private boolean njT;
    private com.baidu.tbadk.core.util.d.a njU;
    private com.baidu.tbadk.core.util.d.a njV;

    public SwitchImageView(Context context) {
        super(context);
        this.njT = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.njT = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.njT = false;
        init();
    }

    private void init() {
        this.bUO = 0;
        this.njR = 0;
        this.njS = 0;
    }

    public void setStateImage(int i, int i2) {
        this.njR = i;
        this.njS = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.njU = aVar;
        this.njV = aVar2;
        this.njT = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.bUO = 0;
            if (this.njT) {
                setImageDrawable(this.njU.getDrawable());
            } else {
                setImageResource(this.njR);
            }
        } else if (i == 1) {
            this.bUO = 1;
            if (this.njT) {
                setImageDrawable(this.njV.getDrawable());
            } else {
                setImageResource(this.njS);
            }
        }
    }

    public void dNd() {
        if (this.bUO == 0) {
            this.bUO = 1;
            setState(1);
            return;
        }
        this.bUO = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.bUO;
    }
}
