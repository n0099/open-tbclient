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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView bWc;
    private ScaleAnimation fuB;
    private TextView hSw;
    private TextView hSx;
    private boolean hSy;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hSy = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSy = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSy = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hSw = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams.topMargin = l.g(context, R.dimen.tbds18);
        this.hSw.setLayoutParams(layoutParams);
        this.hSw.setTextSize(0, l.g(context, R.dimen.tbfontsize30));
        this.hSw.setGravity(17);
        al.j(this.hSw, R.color.cp_cont_j);
        this.bWc = new ImageView(context);
        al.c(this.bWc, (int) R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds48), l.g(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.g(context, R.dimen.tbds18);
        this.bWc.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bWc);
        linearLayout.addView(this.hSw);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hSx = new TextView(getContext());
        this.hSx.setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
        addView(this.hSx);
        this.hSx.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fuB == null) {
            this.fuB = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fuB.setDuration(200L);
        }
        return this.fuB;
    }
}
