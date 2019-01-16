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
    private ImageView aGa;
    private ScaleAnimation dQD;
    private TextView gkH;
    private TextView gkI;
    private boolean gkJ;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.gkJ = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkJ = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkJ = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.gkH = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.h(context, e.C0210e.tbds48));
        layoutParams.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams.topMargin = l.h(context, e.C0210e.tbds18);
        this.gkH.setLayoutParams(layoutParams);
        this.gkH.setTextSize(0, l.h(context, e.C0210e.tbfontsize30));
        this.gkH.setGravity(17);
        al.h(this.gkH, e.d.cp_cont_j);
        this.aGa = new ImageView(context);
        al.c(this.aGa, e.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.h(context, e.C0210e.tbds48), l.h(context, e.C0210e.tbds48));
        layoutParams2.leftMargin = l.h(context, e.C0210e.tbds9);
        layoutParams2.topMargin = l.h(context, e.C0210e.tbds18);
        this.aGa.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aGa);
        linearLayout.addView(this.gkH);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.gkI = new TextView(getContext());
        this.gkI.setTextSize(0, l.h(getContext(), e.C0210e.fontsize24));
        addView(this.gkI);
        this.gkI.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.dQD == null) {
            this.dQD = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.dQD.setDuration(200L);
        }
        return this.dQD;
    }
}
