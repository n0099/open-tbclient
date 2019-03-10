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
    private ImageView bOj;
    private ScaleAnimation feA;
    private TextView hAN;
    private TextView hAO;
    private boolean hAP;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hAP = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAP = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAP = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hAN = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, d.e.tbds48));
        layoutParams.leftMargin = l.h(context, d.e.tbds9);
        layoutParams.topMargin = l.h(context, d.e.tbds18);
        this.hAN.setLayoutParams(layoutParams);
        this.hAN.setTextSize(0, l.h(context, d.e.tbfontsize30));
        this.hAN.setGravity(17);
        al.j(this.hAN, d.C0236d.cp_cont_j);
        this.bOj = new ImageView(context);
        al.c(this.bOj, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, d.e.tbds48), l.h(context, d.e.tbds48));
        layoutParams2.leftMargin = l.h(context, d.e.tbds9);
        layoutParams2.topMargin = l.h(context, d.e.tbds18);
        this.bOj.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bOj);
        linearLayout.addView(this.hAN);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hAO = new TextView(getContext());
        this.hAO.setTextSize(0, l.h(getContext(), d.e.fontsize24));
        addView(this.hAO);
        this.hAO.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.feA == null) {
            this.feA = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.feA.setDuration(200L);
        }
        return this.feA;
    }
}
