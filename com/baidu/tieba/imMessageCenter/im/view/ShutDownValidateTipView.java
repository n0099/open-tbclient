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
    private ArrayList<a> alS;
    private boolean ank;
    private TextView dQO;
    private ImageView dQP;
    private TextView dQQ;
    private TextView dQR;

    /* loaded from: classes2.dex */
    public interface a {
        void aJ(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alS = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alS = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.alS = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(d.h.shut_down_validate_tip, (ViewGroup) null));
        this.dQP = (ImageView) findViewById(d.g.no_network_icon);
        this.dQQ = (TextView) findViewById(d.g.no_network_guide1);
        this.dQR = (TextView) findViewById(d.g.no_network_guide2);
        this.dQO = (TextView) findViewById(d.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dQO != null) {
            this.dQO.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.ank) {
            this.ank = z;
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
                for (int i = 0; i < this.alS.size(); i++) {
                    this.alS.get(i).aJ(false);
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
                for (int i2 = 0; i2 < this.alS.size(); i2++) {
                    this.alS.get(i2).aJ(true);
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
        this.alS.clear();
    }

    public void onChangeSkinType(int i) {
        aj.c(this.dQP, d.f.icon_error);
        aj.j(findViewById(d.g.no_network_parent), d.f.bg_no_network);
        if (i == 1) {
            this.dQQ.setTextColor(-10523526);
            this.dQR.setTextColor(-8682095);
            this.dQO.setTextColor(-10523526);
            return;
        }
        this.dQQ.setTextColor(-14277082);
        this.dQR.setTextColor(-5065030);
        this.dQO.setTextColor(-14277082);
    }
}
