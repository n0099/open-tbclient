package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int eBs;
    private int odo;
    private int odp;
    private boolean odq;
    private com.baidu.tbadk.core.util.e.a odr;
    private com.baidu.tbadk.core.util.e.a ods;

    public SwitchImageView(Context context) {
        super(context);
        this.odq = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.odq = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.odq = false;
        init();
    }

    private void init() {
        this.eBs = 0;
        this.odo = 0;
        this.odp = 0;
    }

    public void setStateImage(int i, int i2) {
        this.odo = i;
        this.odp = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.e.a aVar, com.baidu.tbadk.core.util.e.a aVar2) {
        this.odr = aVar;
        this.ods = aVar2;
        this.odq = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.eBs = 0;
            if (this.odq) {
                setImageDrawable(this.odr.getDrawable());
            } else {
                setImageResource(this.odo);
            }
        } else if (i == 1) {
            this.eBs = 1;
            if (this.odq) {
                setImageDrawable(this.ods.getDrawable());
            } else {
                setImageResource(this.odp);
            }
        }
    }

    public void dWx() {
        if (this.eBs == 0) {
            this.eBs = 1;
            setState(1);
            return;
        }
        this.eBs = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.eBs;
    }
}
