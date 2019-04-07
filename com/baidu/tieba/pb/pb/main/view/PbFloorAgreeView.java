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
    private ImageView bOm;
    private ScaleAnimation fem;
    private TextView hAt;
    private TextView hAu;
    private boolean hAv;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hAv = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAv = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAv = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hAt = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, d.e.tbds48));
        layoutParams.leftMargin = l.h(context, d.e.tbds9);
        layoutParams.topMargin = l.h(context, d.e.tbds18);
        this.hAt.setLayoutParams(layoutParams);
        this.hAt.setTextSize(0, l.h(context, d.e.tbfontsize30));
        this.hAt.setGravity(17);
        al.j(this.hAt, d.C0277d.cp_cont_j);
        this.bOm = new ImageView(context);
        al.c(this.bOm, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, d.e.tbds48), l.h(context, d.e.tbds48));
        layoutParams2.leftMargin = l.h(context, d.e.tbds9);
        layoutParams2.topMargin = l.h(context, d.e.tbds18);
        this.bOm.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bOm);
        linearLayout.addView(this.hAt);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hAu = new TextView(getContext());
        this.hAu.setTextSize(0, l.h(getContext(), d.e.fontsize24));
        addView(this.hAu);
        this.hAu.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fem == null) {
            this.fem = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fem.setDuration(200L);
        }
        return this.fem;
    }
}
