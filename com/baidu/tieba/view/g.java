package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g extends RelativeLayout implements View.OnClickListener {
    private HeadImageView bEc;
    private ImageView fBd;

    public g(Context context) {
        super(context);
        this.bEc = new HeadImageView(context);
        this.fBd = new ImageView(context);
        addView(this.bEc);
        addView(this.fBd);
        ((RelativeLayout.LayoutParams) this.fBd.getLayoutParams()).addRule(12);
        ((RelativeLayout.LayoutParams) this.fBd.getLayoutParams()).addRule(11);
        av.c(this.fBd, u.f.profit_lock);
        this.bEc.setAlpha(0.3f);
    }

    public void bt(int i, int i2) {
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
    }

    public void bu(int i, int i2) {
        this.bEc.getLayoutParams().height = i2;
        this.bEc.getLayoutParams().width = i;
    }

    public void bv(int i, int i2) {
        this.fBd.getLayoutParams().height = i2;
        this.fBd.getLayoutParams().width = i;
    }

    public HeadImageView getIcon() {
        return this.bEc;
    }

    public ImageView getLock() {
        return this.fBd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
