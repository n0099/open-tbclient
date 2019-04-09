package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView bOn;
    private ScaleAnimation fem;
    private TextView hAu;
    private TextView hAv;
    private boolean hAw;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hAw = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAw = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAw = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hAu = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, d.e.tbds48));
        layoutParams.leftMargin = l.h(context, d.e.tbds9);
        layoutParams.topMargin = l.h(context, d.e.tbds18);
        this.hAu.setLayoutParams(layoutParams);
        this.hAu.setTextSize(0, l.h(context, d.e.tbfontsize30));
        this.hAu.setGravity(17);
        al.j(this.hAu, d.C0277d.cp_cont_j);
        this.bOn = new ImageView(context);
        al.c(this.bOn, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, d.e.tbds48), l.h(context, d.e.tbds48));
        layoutParams2.leftMargin = l.h(context, d.e.tbds9);
        layoutParams2.topMargin = l.h(context, d.e.tbds18);
        this.bOn.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bOn);
        linearLayout.addView(this.hAu);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hAv = new TextView(getContext());
        this.hAv.setTextSize(0, l.h(getContext(), d.e.fontsize24));
        addView(this.hAv);
        this.hAv.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fem == null) {
            this.fem = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fem.setDuration(200L);
        }
        return this.fem;
    }
}
