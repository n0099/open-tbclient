package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SwitchImageView extends AppCompatImageView {
    private int cdn;
    private int nws;
    private int nwt;
    private boolean nwu;
    private com.baidu.tbadk.core.util.d.a nwv;
    private com.baidu.tbadk.core.util.d.a nww;

    public SwitchImageView(Context context) {
        super(context);
        this.nwu = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nwu = false;
        init();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nwu = false;
        init();
    }

    private void init() {
        this.cdn = 0;
        this.nws = 0;
        this.nwt = 0;
    }

    public void setStateImage(int i, int i2) {
        this.nws = i;
        this.nwt = i2;
    }

    public void setSvgStateImage(com.baidu.tbadk.core.util.d.a aVar, com.baidu.tbadk.core.util.d.a aVar2) {
        this.nwv = aVar;
        this.nww = aVar2;
        this.nwu = true;
    }

    public void setState(int i) {
        if (i == 0) {
            this.cdn = 0;
            if (this.nwu) {
                setImageDrawable(this.nwv.getDrawable());
            } else {
                setImageResource(this.nws);
            }
        } else if (i == 1) {
            this.cdn = 1;
            if (this.nwu) {
                setImageDrawable(this.nww.getDrawable());
            } else {
                setImageResource(this.nwt);
            }
        }
    }

    public void dQl() {
        if (this.cdn == 0) {
            this.cdn = 1;
            setState(1);
            return;
        }
        this.cdn = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.cdn;
    }
}
