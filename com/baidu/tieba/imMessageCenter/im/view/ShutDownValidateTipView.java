package com.baidu.tieba.imMessageCenter.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> aDJ;
    private boolean aFa;
    private TextView eVp;
    private ImageView eVq;
    private TextView eVr;
    private TextView eVs;

    /* loaded from: classes4.dex */
    public interface a {
        void bn(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDJ = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDJ = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aDJ = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(e.h.shut_down_validate_tip, (ViewGroup) null));
        this.eVq = (ImageView) findViewById(e.g.no_network_icon);
        this.eVr = (TextView) findViewById(e.g.no_network_guide1);
        this.eVs = (TextView) findViewById(e.g.no_network_guide2);
        this.eVp = (TextView) findViewById(e.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.eVp != null) {
            this.eVp.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.aFa) {
            this.aFa = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                    }
                });
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aDJ.size(); i++) {
                    this.aDJ.get(i).bn(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShutDownValidateTipView.this.setVisibility(8);
                    }
                });
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aDJ.size(); i2++) {
                    this.aDJ.get(i2).bn(true);
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
        this.aDJ.clear();
    }

    public void onChangeSkinType(int i) {
        al.c(this.eVq, e.f.icon_error);
        al.i(findViewById(e.g.no_network_parent), e.f.bg_no_network);
        if (i == 1) {
            this.eVr.setTextColor(-10523526);
            this.eVs.setTextColor(-8682095);
            this.eVp.setTextColor(-10523526);
            return;
        }
        this.eVr.setTextColor(-14277082);
        this.eVs.setTextColor(-5065030);
        this.eVp.setTextColor(-14277082);
    }
}
