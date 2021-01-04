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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private boolean isVisible;
    private TextView kMM;
    private ImageView kMN;
    private TextView kMO;
    private TextView kMP;
    private ArrayList<a> networkChangeListeners;

    /* loaded from: classes2.dex */
    public interface a {
        void onNetworkChange(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.networkChangeListeners = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.networkChangeListeners = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.networkChangeListeners = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(R.layout.shut_down_validate_tip, (ViewGroup) null));
        this.kMN = (ImageView) findViewById(R.id.no_network_icon);
        this.kMO = (TextView) findViewById(R.id.no_network_guide1);
        this.kMP = (TextView) findViewById(R.id.no_network_guide2);
        this.kMM = (TextView) findViewById(R.id.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.kMM != null) {
            this.kMM.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.isVisible) {
            this.isVisible = z;
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
                for (int i = 0; i < this.networkChangeListeners.size(); i++) {
                    this.networkChangeListeners.get(i).onNetworkChange(false);
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
                for (int i2 = 0; i2 < this.networkChangeListeners.size(); i2++) {
                    this.networkChangeListeners.get(i2).onNetworkChange(true);
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
        this.networkChangeListeners.clear();
    }

    public void onChangeSkinType(int i) {
        ao.setImageResource(this.kMN, R.drawable.icon_error);
        ao.setBackgroundResource(findViewById(R.id.no_network_parent), R.drawable.bg_no_network);
        if (i == 1 || i == 4) {
            this.kMO.setTextColor(-10523526);
            this.kMP.setTextColor(-8682095);
            this.kMM.setTextColor(-10523526);
            return;
        }
        this.kMO.setTextColor(-14277082);
        this.kMP.setTextColor(-5065030);
        this.kMM.setTextColor(-14277082);
    }
}
