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
    private ScaleAnimation fuA;
    private TextView hSs;
    private TextView hSt;
    private boolean hSu;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hSu = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSu = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSu = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hSs = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams.topMargin = l.g(context, R.dimen.tbds18);
        this.hSs.setLayoutParams(layoutParams);
        this.hSs.setTextSize(0, l.g(context, R.dimen.tbfontsize30));
        this.hSs.setGravity(17);
        al.j(this.hSs, R.color.cp_cont_j);
        this.bWb = new ImageView(context);
        al.c(this.bWb, (int) R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds48), l.g(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.g(context, R.dimen.tbds18);
        this.bWb.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bWb);
        linearLayout.addView(this.hSs);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hSt = new TextView(getContext());
        this.hSt.setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
        addView(this.hSt);
        this.hSt.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fuA == null) {
            this.fuA = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fuA.setDuration(200L);
        }
        return this.fuA;
    }
}
