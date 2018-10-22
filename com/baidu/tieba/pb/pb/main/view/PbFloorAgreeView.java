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
    private ImageView aBi;
    private ScaleAnimation dFs;
    private TextView fYv;
    private TextView fYw;
    private boolean fYx;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fYx = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fYx = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYx = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fYv = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0175e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0175e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0175e.tbds18);
        this.fYv.setLayoutParams(layoutParams);
        this.fYv.setTextSize(0, l.h(context, e.C0175e.tbfontsize30));
        this.fYv.setGravity(17);
        al.h(this.fYv, e.d.cp_cont_j);
        this.aBi = new ImageView(context);
        al.c(this.aBi, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0175e.tbds48), l.h(context, e.C0175e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0175e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0175e.tbds18);
        this.aBi.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aBi);
        linearLayout.addView(this.fYv);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fYw = new TextView(getContext());
        this.fYw.setTextSize(0, l.h(getContext(), e.C0175e.fontsize24));
        addView(this.fYw);
        this.fYw.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dFs == null) {
            this.dFs = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dFs.setDuration(200L);
        }
        return this.dFs;
    }
}
