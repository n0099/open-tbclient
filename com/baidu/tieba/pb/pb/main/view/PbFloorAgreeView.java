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
    private ImageView bXe;
    private ScaleAnimation fzx;
    private TextView hYJ;
    private TextView hYK;
    private boolean hYL;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.hYL = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYL = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYL = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.hYJ = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds48));
        layoutParams.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams.topMargin = l.g(context, R.dimen.tbds18);
        this.hYJ.setLayoutParams(layoutParams);
        this.hYJ.setTextSize(0, l.g(context, R.dimen.tbfontsize30));
        this.hYJ.setGravity(17);
        am.j(this.hYJ, R.color.cp_cont_j);
        this.bXe = new ImageView(context);
        am.c(this.bXe, (int) R.drawable.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds48), l.g(context, R.dimen.tbds48));
        layoutParams2.leftMargin = l.g(context, R.dimen.tbds9);
        layoutParams2.topMargin = l.g(context, R.dimen.tbds18);
        this.bXe.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bXe);
        linearLayout.addView(this.hYJ);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.hYK = new TextView(getContext());
        this.hYK.setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
        addView(this.hYK);
        this.hYK.setVisibility(8);
    }

    private Animation getScaleAnimation() {
        if (this.fzx == null) {
            this.fzx = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.fzx.setDuration(200L);
        }
        return this.fzx;
    }
}
