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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> abN;
    private TextView cxZ;
    private ImageView cya;
    private TextView cyb;
    private TextView cyc;
    private boolean cyd;

    /* loaded from: classes.dex */
    public interface a {
        void aF(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abN = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abN = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.abN = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(t.h.shut_down_validate_tip, (ViewGroup) null));
        this.cya = (ImageView) findViewById(t.g.no_network_icon);
        this.cyb = (TextView) findViewById(t.g.no_network_guide1);
        this.cyc = (TextView) findViewById(t.g.no_network_guide2);
        this.cxZ = (TextView) findViewById(t.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.cxZ != null) {
            this.cxZ.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.cyd) {
            this.cyd = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.abN.size(); i++) {
                    this.abN.get(i).aF(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.abN.size(); i2++) {
                    this.abN.get(i2).aF(true);
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
        this.abN.clear();
    }

    public void onChangeSkinType(int i) {
        at.c(this.cya, t.f.icon_error);
        at.k(findViewById(t.g.no_network_parent), t.f.bg_no_network);
        if (i == 1) {
            this.cyb.setTextColor(-10523526);
            this.cyc.setTextColor(-8682095);
            this.cxZ.setTextColor(-10523526);
            return;
        }
        this.cyb.setTextColor(-14277082);
        this.cyc.setTextColor(-5065030);
        this.cxZ.setTextColor(-14277082);
    }
}
