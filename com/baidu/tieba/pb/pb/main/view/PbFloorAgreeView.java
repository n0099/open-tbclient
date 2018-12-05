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
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView aFx;
    private ScaleAnimation dNg;
    private TextView ggL;
    private TextView ggM;
    private boolean ggN;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.ggN = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggN = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggN = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.ggL = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0210e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0210e.tbds18);
        this.ggL.setLayoutParams(layoutParams);
        this.ggL.setTextSize(0, l.h(context, e.C0210e.tbfontsize30));
        this.ggL.setGravity(17);
        al.h(this.ggL, e.d.cp_cont_j);
        this.aFx = new ImageView(context);
        al.c(this.aFx, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0210e.tbds48), l.h(context, e.C0210e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0210e.tbds18);
        this.aFx.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aFx);
        linearLayout.addView(this.ggL);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.ggM = new TextView(getContext());
        this.ggM.setTextSize(0, l.h(getContext(), e.C0210e.fontsize24));
        addView(this.ggM);
        this.ggM.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dNg == null) {
            this.dNg = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dNg.setDuration(200L);
        }
        return this.dNg;
    }
}
