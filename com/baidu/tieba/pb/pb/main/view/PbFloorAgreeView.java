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
    private ImageView bXk;
    private ScaleAnimation fAl;
    private TextView hZF;
    private TextView hZG;
    private boolean hZH;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hZH = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZH = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZH = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hZF = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams.topMargin = l.g(context, R.dimen.tbds18);
        this.hZF.setLayoutParams(layoutParams);
        this.hZF.setTextSize(0, l.g(context, R.dimen.tbfontsize30));
        this.hZF.setGravity(17);
        am.j(this.hZF, R.color.cp_cont_j);
        this.bXk = new ImageView(context);
        am.c(this.bXk, (int) R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds48), l.g(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.g(context, R.dimen.tbds18);
        this.bXk.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bXk);
        linearLayout.addView(this.hZF);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hZG = new TextView(getContext());
        this.hZG.setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
        addView(this.hZG);
        this.hZG.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fAl == null) {
            this.fAl = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fAl.setDuration(200L);
        }
        return this.fAl;
    }
}
