package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends RelativeLayout implements View.OnClickListener {
    private HeadImageView eZt;
    private ImageView fYV;

    public x(Context context) {
        super(context);
        this.eZt = new HeadImageView(context);
        this.fYV = new ImageView(context);
        addView(this.eZt);
        addView(this.fYV);
        ((RelativeLayout.LayoutParams) this.fYV.getLayoutParams()).addRule(12);
        ((RelativeLayout.LayoutParams) this.fYV.getLayoutParams()).addRule(11);
        av.c(this.fYV, r.f.profit_lock);
        this.eZt.setAlpha(0.3f);
    }

    public void bD(int i, int i2) {
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
    }

    public void bE(int i, int i2) {
        this.eZt.getLayoutParams().height = i2;
        this.eZt.getLayoutParams().width = i;
    }

    public void bF(int i, int i2) {
        this.fYV.getLayoutParams().height = i2;
        this.fYV.getLayoutParams().width = i;
    }

    public HeadImageView getIcon() {
        return this.eZt;
    }

    public ImageView getLock() {
        return this.fYV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
