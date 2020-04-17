package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int lvE;
    private int lvF;
    private boolean lvG;
    private com.baidu.tbadk.core.util.d.a lvH;
    private com.baidu.tbadk.core.util.d.a lvI;
    private int mCurrentState;

    public SwitchImageView(Context context) {
        super(context);
        this.lvG = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lvG = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lvG = false;
        init();
    }

    private void init() {
        this.mCurrentState = 0;
        this.lvE = 0;
        this.lvF = 0;
    }

    public void setStateImage(int i, int i2) {
        this.lvE = i;
        this.lvF = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.lvH = aVar;
        this.lvI = aVar2;
        this.lvG = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.mCurrentState = 0;
            if (this.lvG) {
                setImageDrawable(this.lvH.getDrawable());
            } else {
                setImageResource(this.lvE);
            }
        } else if (i == 1) {
            this.mCurrentState = 1;
            if (this.lvG) {
                setImageDrawable(this.lvI.getDrawable());
            } else {
                setImageResource(this.lvF);
            }
        }
    }

    public void deM() {
        if (this.mCurrentState == 0) {
            this.mCurrentState = 1;
            setState(1);
            return;
        }
        this.mCurrentState = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }
}
