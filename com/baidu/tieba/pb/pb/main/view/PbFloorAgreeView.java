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
    private ImageView aBX;
    private ScaleAnimation dGH;
    private TextView fZU;
    private TextView fZV;
    private boolean fZW;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fZW = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fZW = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fZW = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fZU = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0200e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0200e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0200e.tbds18);
        this.fZU.setLayoutParams(layoutParams);
        this.fZU.setTextSize(0, l.h(context, e.C0200e.tbfontsize30));
        this.fZU.setGravity(17);
        al.h(this.fZU, e.d.cp_cont_j);
        this.aBX = new ImageView(context);
        al.c(this.aBX, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0200e.tbds48), l.h(context, e.C0200e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0200e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0200e.tbds18);
        this.aBX.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aBX);
        linearLayout.addView(this.fZU);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fZV = new TextView(getContext());
        this.fZV.setTextSize(0, l.h(getContext(), e.C0200e.fontsize24));
        addView(this.fZV);
        this.fZV.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dGH == null) {
            this.dGH = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dGH.setDuration(200L);
        }
        return this.dGH;
    }
}
