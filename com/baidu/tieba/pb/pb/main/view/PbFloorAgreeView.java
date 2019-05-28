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
    private ImageView bWb;
    private ScaleAnimation fuB;
    private TextView hSv;
    private TextView hSw;
    private boolean hSx;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hSx = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSx = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSx = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hSv = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams.topMargin = l.g(context, R.dimen.tbds18);
        this.hSv.setLayoutParams(layoutParams);
        this.hSv.setTextSize(0, l.g(context, R.dimen.tbfontsize30));
        this.hSv.setGravity(17);
        al.j(this.hSv, R.color.cp_cont_j);
        this.bWb = new ImageView(context);
        al.c(this.bWb, (int) R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds48), l.g(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.g(context, R.dimen.tbds18);
        this.bWb.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bWb);
        linearLayout.addView(this.hSv);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hSw = new TextView(getContext());
        this.hSw.setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
        addView(this.hSw);
        this.hSw.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fuB == null) {
            this.fuB = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fuB.setDuration(200L);
        }
        return this.fuB;
    }
}
