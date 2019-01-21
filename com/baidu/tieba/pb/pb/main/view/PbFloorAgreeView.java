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
    private ImageView aGb;
    private ScaleAnimation dQE;
    private TextView gkI;
    private TextView gkJ;
    private boolean gkK;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.gkK = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkK = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkK = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.gkI = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0210e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0210e.tbds18);
        this.gkI.setLayoutParams(layoutParams);
        this.gkI.setTextSize(0, l.h(context, e.C0210e.tbfontsize30));
        this.gkI.setGravity(17);
        al.h(this.gkI, e.d.cp_cont_j);
        this.aGb = new ImageView(context);
        al.c(this.aGb, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0210e.tbds48), l.h(context, e.C0210e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0210e.tbds18);
        this.aGb.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aGb);
        linearLayout.addView(this.gkI);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.gkJ = new TextView(getContext());
        this.gkJ.setTextSize(0, l.h(getContext(), e.C0210e.fontsize24));
        addView(this.gkJ);
        this.gkJ.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dQE == null) {
            this.dQE = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dQE.setDuration(200L);
        }
        return this.dQE;
    }
}
