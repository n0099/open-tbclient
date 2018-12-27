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
    private ImageView aFy;
    private ScaleAnimation dPU;
    private TextView gjE;
    private TextView gjF;
    private boolean gjG;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.gjG = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjG = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjG = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.gjE = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0210e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0210e.tbds18);
        this.gjE.setLayoutParams(layoutParams);
        this.gjE.setTextSize(0, l.h(context, e.C0210e.tbfontsize30));
        this.gjE.setGravity(17);
        al.h(this.gjE, e.d.cp_cont_j);
        this.aFy = new ImageView(context);
        al.c(this.aFy, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0210e.tbds48), l.h(context, e.C0210e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0210e.tbds18);
        this.aFy.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aFy);
        linearLayout.addView(this.gjE);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.gjF = new TextView(getContext());
        this.gjF.setTextSize(0, l.h(getContext(), e.C0210e.fontsize24));
        addView(this.gjF);
        this.gjF.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dPU == null) {
            this.dPU = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dPU.setDuration(200L);
        }
        return this.dPU;
    }
}
