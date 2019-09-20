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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> caR;
    private boolean ccu;
    private TextView gXg;
    private ImageView gXh;
    private TextView gXi;
    private TextView gXj;

    /* loaded from: classes4.dex */
    public interface a {
        void es(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caR = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caR = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.caR = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(R.layout.shut_down_validate_tip, (ViewGroup) null));
        this.gXh = (ImageView) findViewById(R.id.no_network_icon);
        this.gXi = (TextView) findViewById(R.id.no_network_guide1);
        this.gXj = (TextView) findViewById(R.id.no_network_guide2);
        this.gXg = (TextView) findViewById(R.id.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.gXg != null) {
            this.gXg.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.ccu) {
            this.ccu = z;
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
                for (int i = 0; i < this.caR.size(); i++) {
                    this.caR.get(i).es(false);
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
                for (int i2 = 0; i2 < this.caR.size(); i2++) {
                    this.caR.get(i2).es(true);
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
        this.caR.clear();
    }

    public void onChangeSkinType(int i) {
        am.c(this.gXh, (int) R.drawable.icon_error);
        am.k(findViewById(R.id.no_network_parent), R.drawable.bg_no_network);
        if (i == 1 || i == 4) {
            this.gXi.setTextColor(-10523526);
            this.gXj.setTextColor(-8682095);
            this.gXg.setTextColor(-10523526);
            return;
        }
        this.gXi.setTextColor(-14277082);
        this.gXj.setTextColor(-5065030);
        this.gXg.setTextColor(-14277082);
    }
}
