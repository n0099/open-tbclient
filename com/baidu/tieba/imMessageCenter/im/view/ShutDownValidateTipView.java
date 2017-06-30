package com.baidu.tieba.imMessageCenter.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> akT;
    private boolean amt;
    private TextView dtM;
    private ImageView dtN;
    private TextView dtO;
    private TextView dtP;

    /* loaded from: classes2.dex */
    public interface a {
        void aL(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akT = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akT = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.akT = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(w.j.shut_down_validate_tip, (ViewGroup) null));
        this.dtN = (ImageView) findViewById(w.h.no_network_icon);
        this.dtO = (TextView) findViewById(w.h.no_network_guide1);
        this.dtP = (TextView) findViewById(w.h.no_network_guide2);
        this.dtM = (TextView) findViewById(w.h.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dtM != null) {
            this.dtM.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.amt) {
            this.amt = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akT.size(); i++) {
                    this.akT.get(i).aL(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akT.size(); i2++) {
                    this.akT.get(i2).aL(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.akT.clear();
    }

    public void onChangeSkinType(int i) {
        as.c(this.dtN, w.g.icon_error);
        as.j(findViewById(w.h.no_network_parent), w.g.bg_no_network);
        if (i == 1) {
            this.dtO.setTextColor(-10523526);
            this.dtP.setTextColor(-8682095);
            this.dtM.setTextColor(-10523526);
            return;
        }
        this.dtO.setTextColor(-14277082);
        this.dtP.setTextColor(-5065030);
        this.dtM.setTextColor(-14277082);
    }
}
