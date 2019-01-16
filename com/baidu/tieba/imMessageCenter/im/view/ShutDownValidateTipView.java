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
    private ArrayList<a> aIC;
    private boolean aJT;
    private TextView fha;
    private ImageView fhb;
    private TextView fhc;
    private TextView fhd;

    /* loaded from: classes4.dex */
    public interface a {
        void bG(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIC = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIC = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aIC = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(e.h.shut_down_validate_tip, (ViewGroup) null));
        this.fhb = (ImageView) findViewById(e.g.no_network_icon);
        this.fhc = (TextView) findViewById(e.g.no_network_guide1);
        this.fhd = (TextView) findViewById(e.g.no_network_guide2);
        this.fha = (TextView) findViewById(e.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.fha != null) {
            this.fha.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.aJT) {
            this.aJT = z;
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
                for (int i = 0; i < this.aIC.size(); i++) {
                    this.aIC.get(i).bG(false);
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
                for (int i2 = 0; i2 < this.aIC.size(); i2++) {
                    this.aIC.get(i2).bG(true);
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
        this.aIC.clear();
    }

    public void onChangeSkinType(int i) {
        al.c(this.fhb, e.f.icon_error);
        al.i(findViewById(e.g.no_network_parent), e.f.bg_no_network);
        if (i == 1) {
            this.fhc.setTextColor(-10523526);
            this.fhd.setTextColor(-8682095);
            this.fha.setTextColor(-10523526);
            return;
        }
        this.fhc.setTextColor(-14277082);
        this.fhd.setTextColor(-5065030);
        this.fha.setTextColor(-14277082);
    }
}
