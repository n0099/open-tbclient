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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> aer;
    private TextView bOV;
    private ImageView bOW;
    private TextView bOX;
    private TextView bOY;
    private boolean bOZ;

    /* loaded from: classes.dex */
    public interface a {
        void ax(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aer = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aer = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aer = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(i.g.shut_down_validate_tip, (ViewGroup) null));
        this.bOW = (ImageView) findViewById(i.f.no_network_icon);
        this.bOX = (TextView) findViewById(i.f.no_network_guide1);
        this.bOY = (TextView) findViewById(i.f.no_network_guide2);
        this.bOV = (TextView) findViewById(i.f.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bOV != null) {
            this.bOV.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bOZ) {
            this.bOZ = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aer.size(); i++) {
                    this.aer.get(i).ax(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aer.size(); i2++) {
                    this.aer.get(i2).ax(true);
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
        this.aer.clear();
    }

    public void onChangeSkinType(int i) {
        an.c(this.bOW, i.e.icon_error);
        an.i(findViewById(i.f.no_network_parent), i.e.bg_no_network);
        if (i == 1) {
            this.bOX.setTextColor(-10523526);
            this.bOY.setTextColor(-8682095);
            this.bOV.setTextColor(-10523526);
            return;
        }
        this.bOX.setTextColor(-14277082);
        this.bOY.setTextColor(-5065030);
        this.bOV.setTextColor(-14277082);
    }
}
