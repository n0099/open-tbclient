package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends RelativeLayout implements View.OnClickListener {
    private HeadImageView eWM;
    private ImageView fWR;

    public x(Context context) {
        super(context);
        this.eWM = new HeadImageView(context);
        this.fWR = new ImageView(context);
        addView(this.eWM);
        addView(this.fWR);
        ((RelativeLayout.LayoutParams) this.fWR.getLayoutParams()).addRule(12);
        ((RelativeLayout.LayoutParams) this.fWR.getLayoutParams()).addRule(11);
        av.c(this.fWR, t.f.profit_lock);
        this.eWM.setAlpha(0.3f);
    }

    public void bB(int i, int i2) {
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
    }

    public void bC(int i, int i2) {
        this.eWM.getLayoutParams().height = i2;
        this.eWM.getLayoutParams().width = i;
    }

    public void bD(int i, int i2) {
        this.fWR.getLayoutParams().height = i2;
        this.fWR.getLayoutParams().width = i;
    }

    public HeadImageView getIcon() {
        return this.eWM;
    }

    public ImageView getLock() {
        return this.fWR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
