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
    private ImageView cng;
    private ScaleAnimation fBp;
    private TextView iaj;
    private TextView iak;
    private boolean ial;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.ial = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ial = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ial = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.iaj = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds9);
        layoutParams.topMargin = l.getDimens(context, R.dimen.tbds18);
        this.iaj.setLayoutParams(layoutParams);
        this.iaj.setTextSize(0, l.getDimens(context, R.dimen.tbfontsize30));
        this.iaj.setGravity(17);
        am.setViewTextColor(this.iaj, (int) R.color.cp_cont_j);
        this.cng = new ImageView(context);
        am.setImageResource(this.cng, R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds48), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.getDimens(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds18);
        this.cng.setLayoutParams(layoutParams2);
        linearLayout.addView(this.cng);
        linearLayout.addView(this.iaj);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.iak = new TextView(getContext());
        this.iak.setTextSize(0, l.getDimens(getContext(), R.dimen.fontsize24));
        addView(this.iak);
        this.iak.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fBp == null) {
            this.fBp = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fBp.setDuration(200L);
        }
        return this.fBp;
    }
}
