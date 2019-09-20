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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView bYd;
    private ScaleAnimation fBY;
    private TextView ibC;
    private TextView ibD;
    private boolean ibE;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.ibE = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibE = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibE = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.ibC = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams.topMargin = l.g(context, R.dimen.tbds18);
        this.ibC.setLayoutParams(layoutParams);
        this.ibC.setTextSize(0, l.g(context, R.dimen.tbfontsize30));
        this.ibC.setGravity(17);
        am.j(this.ibC, R.color.cp_cont_j);
        this.bYd = new ImageView(context);
        am.c(this.bYd, (int) R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds48), l.g(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.g(context, R.dimen.tbds18);
        this.bYd.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bYd);
        linearLayout.addView(this.ibC);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.ibD = new TextView(getContext());
        this.ibD.setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
        addView(this.ibD);
        this.ibD.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fBY == null) {
            this.fBY = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fBY.setDuration(200L);
        }
        return this.fBY;
    }
}
