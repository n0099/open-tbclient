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
    private HeadImageView bFm;
    private ImageView fOe;

    public g(Context context) {
        super(context);
        this.bFm = new HeadImageView(context);
        this.fOe = new ImageView(context);
        addView(this.bFm);
        addView(this.fOe);
        ((RelativeLayout.LayoutParams) this.fOe.getLayoutParams()).addRule(12);
        ((RelativeLayout.LayoutParams) this.fOe.getLayoutParams()).addRule(11);
        av.c(this.fOe, u.f.profit_lock);
        this.bFm.setAlpha(0.3f);
    }

    public void bw(int i, int i2) {
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
    }

    public void bx(int i, int i2) {
        this.bFm.getLayoutParams().height = i2;
        this.bFm.getLayoutParams().width = i;
    }

    public void by(int i, int i2) {
        this.fOe.getLayoutParams().height = i2;
        this.fOe.getLayoutParams().width = i;
    }

    public HeadImageView getIcon() {
        return this.bFm;
    }

    public ImageView getLock() {
        return this.fOe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
