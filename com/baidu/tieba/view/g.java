package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends RelativeLayout implements View.OnClickListener {
    private HeadImageView bip;
    private ImageView eWp;

    public g(Context context) {
        super(context);
        this.bip = new HeadImageView(context);
        this.eWp = new ImageView(context);
        addView(this.bip);
        addView(this.eWp);
        ((RelativeLayout.LayoutParams) this.eWp.getLayoutParams()).addRule(12);
        ((RelativeLayout.LayoutParams) this.eWp.getLayoutParams()).addRule(11);
        at.c(this.eWp, t.f.profit_lock);
        this.bip.setAlpha(0.3f);
    }

    public void bl(int i, int i2) {
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
    }

    public void bm(int i, int i2) {
        this.bip.getLayoutParams().height = i2;
        this.bip.getLayoutParams().width = i;
    }

    public void bn(int i, int i2) {
        this.eWp.getLayoutParams().height = i2;
        this.eWp.getLayoutParams().width = i;
    }

    public HeadImageView getIcon() {
        return this.bip;
    }

    public ImageView getLock() {
        return this.eWp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
