package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends LinearLayout {
    private ImageView epU;
    private TextView epV;
    private boolean epW;
    private ScaleAnimation epX;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.epW = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epW = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epW = false;
        init();
    }

    public void init() {
        Context context = getContext();
        this.epV = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(context, w.f.ds48));
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(context, w.f.ds12);
        this.epV.setLayoutParams(layoutParams);
        this.epV.setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.fontsize24));
        this.epV.setGravity(17);
        aq.i(this.epV, w.e.cp_cont_d);
        addView(this.epV);
        this.epU = new ImageView(context);
        aq.c(this.epU, w.g.icon_floor_praise_n);
        this.epU.setPadding(com.baidu.adp.lib.util.k.g(context, w.f.ds6), com.baidu.adp.lib.util.k.g(context, w.f.ds12), com.baidu.adp.lib.util.k.g(context, w.f.ds18), 0);
        addView(this.epU);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.epW != z) {
            this.epW = z;
            onChangeSkinType();
        }
        this.epV.setText(au.v(j));
        if (z2) {
            this.epU.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.epX == null) {
            this.epX = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.epX.setDuration(200L);
        }
        return this.epX;
    }

    public void onChangeSkinType() {
        if (this.epW) {
            aq.c(this.epU, w.g.icon_floor_praised);
            aq.i(this.epV, w.e.cp_cont_h);
            return;
        }
        aq.c(this.epU, w.g.icon_floor_praise_n);
        aq.i(this.epV, w.e.cp_cont_f);
    }
}
