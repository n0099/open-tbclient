package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int ezR;
    private int obh;
    private int obi;
    private boolean obk;
    private com.baidu.tbadk.core.util.e.a obl;
    private com.baidu.tbadk.core.util.e.a obm;

    public SwitchImageView(Context context) {
        super(context);
        this.obk = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.obk = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.obk = false;
        init();
    }

    private void init() {
        this.ezR = 0;
        this.obh = 0;
        this.obi = 0;
    }

    public void setStateImage(int i, int i2) {
        this.obh = i;
        this.obi = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.obl = aVar;
        this.obm = aVar2;
        this.obk = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.ezR = 0;
            if (this.obk) {
                setImageDrawable(this.obl.getDrawable());
            } else {
                setImageResource(this.obh);
            }
        } else if (i == 1) {
            this.ezR = 1;
            if (this.obk) {
                setImageDrawable(this.obm.getDrawable());
            } else {
                setImageResource(this.obi);
            }
        }
    }

    public void dWp() {
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
