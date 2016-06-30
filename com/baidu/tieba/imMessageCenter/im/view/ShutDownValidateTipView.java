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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> ach;
    private TextView ddv;
    private ImageView ddw;
    private TextView ddx;
    private TextView ddy;
    private boolean ddz;

    /* loaded from: classes.dex */
    public interface a {
        void aD(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ach = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ach = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.ach = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(u.h.shut_down_validate_tip, (ViewGroup) null));
        this.ddw = (ImageView) findViewById(u.g.no_network_icon);
        this.ddx = (TextView) findViewById(u.g.no_network_guide1);
        this.ddy = (TextView) findViewById(u.g.no_network_guide2);
        this.ddv = (TextView) findViewById(u.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.ddv != null) {
            this.ddv.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.ddz) {
            this.ddz = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ach.size(); i++) {
                    this.ach.get(i).aD(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ach.size(); i2++) {
                    this.ach.get(i2).aD(true);
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
        this.ach.clear();
    }

    public void onChangeSkinType(int i) {
        av.c(this.ddw, u.f.icon_error);
        av.k(findViewById(u.g.no_network_parent), u.f.bg_no_network);
        if (i == 1) {
            this.ddx.setTextColor(-10523526);
            this.ddy.setTextColor(-8682095);
            this.ddv.setTextColor(-10523526);
            return;
        }
        this.ddx.setTextColor(-14277082);
        this.ddy.setTextColor(-5065030);
        this.ddv.setTextColor(-14277082);
    }
}
