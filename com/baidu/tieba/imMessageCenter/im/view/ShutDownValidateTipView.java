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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> alw;
    private boolean amP;
    private TextView dJb;
    private ImageView dJc;
    private TextView dJd;
    private TextView dJe;

    /* loaded from: classes2.dex */
    public interface a {
        void aL(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alw = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alw = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.alw = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(d.j.shut_down_validate_tip, (ViewGroup) null));
        this.dJc = (ImageView) findViewById(d.h.no_network_icon);
        this.dJd = (TextView) findViewById(d.h.no_network_guide1);
        this.dJe = (TextView) findViewById(d.h.no_network_guide2);
        this.dJb = (TextView) findViewById(d.h.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dJb != null) {
            this.dJb.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.amP) {
            this.amP = z;
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
                for (int i = 0; i < this.alw.size(); i++) {
                    this.alw.get(i).aL(false);
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
                for (int i2 = 0; i2 < this.alw.size(); i2++) {
                    this.alw.get(i2).aL(true);
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
        this.alw.clear();
    }

    public void onChangeSkinType(int i) {
        aj.c(this.dJc, d.g.icon_error);
        aj.j(findViewById(d.h.no_network_parent), d.g.bg_no_network);
        if (i == 1) {
            this.dJd.setTextColor(-10523526);
            this.dJe.setTextColor(-8682095);
            this.dJb.setTextColor(-10523526);
            return;
        }
        this.dJd.setTextColor(-14277082);
        this.dJe.setTextColor(-5065030);
        this.dJb.setTextColor(-14277082);
    }
}
