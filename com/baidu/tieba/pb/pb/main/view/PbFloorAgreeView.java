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
/* loaded from: classes2.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView awx;
    private ScaleAnimation dxr;
    private TextView fQU;
    private TextView fQV;
    private boolean fQW;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fQW = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQW = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQW = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fQU = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0141e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0141e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0141e.tbds18);
        this.fQU.setLayoutParams(layoutParams);
        this.fQU.setTextSize(0, l.h(context, e.C0141e.tbfontsize30));
        this.fQU.setGravity(17);
        al.h(this.fQU, e.d.cp_cont_j);
        this.awx = new ImageView(context);
        al.c(this.awx, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0141e.tbds48), l.h(context, e.C0141e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0141e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0141e.tbds18);
        this.awx.setLayoutParams(layoutParams2);
        linearLayout.addView(this.awx);
        linearLayout.addView(this.fQU);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fQV = new TextView(getContext());
        this.fQV.setTextSize(0, l.h(getContext(), e.C0141e.fontsize24));
        addView(this.fQV);
        this.fQV.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dxr == null) {
            this.dxr = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dxr.setDuration(200L);
        }
        return this.dxr;
    }
}
