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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> akE;
    private boolean alE;
    private TextView dlA;
    private ImageView dlB;
    private TextView dlC;
    private TextView dlD;

    /* loaded from: classes.dex */
    public interface a {
        void aK(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akE = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akE = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.akE = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(w.j.shut_down_validate_tip, (ViewGroup) null));
        this.dlB = (ImageView) findViewById(w.h.no_network_icon);
        this.dlC = (TextView) findViewById(w.h.no_network_guide1);
        this.dlD = (TextView) findViewById(w.h.no_network_guide2);
        this.dlA = (TextView) findViewById(w.h.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dlA != null) {
            this.dlA.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.alE) {
            this.alE = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akE.size(); i++) {
                    this.akE.get(i).aK(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akE.size(); i2++) {
                    this.akE.get(i2).aK(true);
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
        this.akE.clear();
    }

    public void onChangeSkinType(int i) {
        aq.c(this.dlB, w.g.icon_error);
        aq.j(findViewById(w.h.no_network_parent), w.g.bg_no_network);
        if (i == 1) {
            this.dlC.setTextColor(-10523526);
            this.dlD.setTextColor(-8682095);
            this.dlA.setTextColor(-10523526);
            return;
        }
        this.dlC.setTextColor(-14277082);
        this.dlD.setTextColor(-5065030);
        this.dlA.setTextColor(-14277082);
    }
}
