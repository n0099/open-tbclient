package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int ezR;
    private int oaH;
    private int oaI;
    private boolean oaJ;
    private com.baidu.tbadk.core.util.e.a oaK;
    private com.baidu.tbadk.core.util.e.a oaL;

    public SwitchImageView(Context context) {
        super(context);
        this.oaJ = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oaJ = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oaJ = false;
        init();
    }

    private void init() {
        this.ezR = 0;
        this.oaH = 0;
        this.oaI = 0;
    }

    public void setStateImage(int i, int i2) {
        this.oaH = i;
        this.oaI = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.oaK = aVar;
        this.oaL = aVar2;
        this.oaJ = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.ezR = 0;
            if (this.oaJ) {
                setImageDrawable(this.oaK.getDrawable());
            } else {
                setImageResource(this.oaH);
            }
        } else if (i == 1) {
            this.ezR = 1;
            if (this.oaJ) {
                setImageDrawable(this.oaL.getDrawable());
            } else {
                setImageResource(this.oaI);
            }
        }
    }

    public void dWh() {
        if (this.ezR == 0) {
            this.ezR = 1;
            setState(1);
            return;
        }
        this.ezR = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.ezR;
    }
}
