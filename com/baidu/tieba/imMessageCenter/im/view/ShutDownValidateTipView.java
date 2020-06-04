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
/* loaded from: classes9.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private boolean dWj;
    private TextView iOY;
    private ImageView iOZ;
    private TextView iPa;
    private TextView iPb;
    private ArrayList<a> networkChangeListeners;

    /* loaded from: classes9.dex */
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
        this.iOZ = (ImageView) findViewById(R.id.no_network_icon);
        this.iPa = (TextView) findViewById(R.id.no_network_guide1);
        this.iPb = (TextView) findViewById(R.id.no_network_guide2);
        this.iOY = (TextView) findViewById(R.id.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.iOY != null) {
            this.iOY.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.dWj) {
            this.dWj = z;
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
        am.setImageResource(this.iOZ, R.drawable.icon_error);
        am.setBackgroundResource(findViewById(R.id.no_network_parent), R.drawable.bg_no_network);
        if (i == 1 || i == 4) {
            this.iPa.setTextColor(-10523526);
            this.iPb.setTextColor(-8682095);
            this.iOY.setTextColor(-10523526);
            return;
        }
        this.iPa.setTextColor(-14277082);
        this.iPb.setTextColor(-5065030);
        this.iOY.setTextColor(-14277082);
    }
}
