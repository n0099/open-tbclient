package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends RelativeLayout implements View.OnClickListener {
    private HeadImageView bmQ;
    private ImageView eFC;

    public f(Context context) {
        super(context);
        this.bmQ = new HeadImageView(context);
        this.eFC = new ImageView(context);
        addView(this.bmQ);
        addView(this.eFC);
        ((RelativeLayout.LayoutParams) this.eFC.getLayoutParams()).addRule(12);
        ((RelativeLayout.LayoutParams) this.eFC.getLayoutParams()).addRule(11);
        at.c(this.eFC, t.f.profit_lock);
        this.bmQ.setAlpha(0.3f);
    }

    public void bi(int i, int i2) {
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
    }

    public void bj(int i, int i2) {
        this.bmQ.getLayoutParams().height = i2;
        this.bmQ.getLayoutParams().width = i;
    }

    public void bk(int i, int i2) {
        this.eFC.getLayoutParams().height = i2;
        this.eFC.getLayoutParams().width = i;
    }

    public HeadImageView getIcon() {
        return this.bmQ;
    }

    public ImageView getLock() {
        return this.eFC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
