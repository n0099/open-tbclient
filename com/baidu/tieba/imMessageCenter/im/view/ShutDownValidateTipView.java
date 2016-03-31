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
    private ArrayList<a> ago;
    private TextView cxb;
    private ImageView cxc;
    private TextView cxd;
    private TextView cxe;
    private boolean cxf;

    /* loaded from: classes.dex */
    public interface a {
        void aA(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ago = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ago = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.ago = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(t.h.shut_down_validate_tip, (ViewGroup) null));
        this.cxc = (ImageView) findViewById(t.g.no_network_icon);
        this.cxd = (TextView) findViewById(t.g.no_network_guide1);
        this.cxe = (TextView) findViewById(t.g.no_network_guide2);
        this.cxb = (TextView) findViewById(t.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.cxb != null) {
            this.cxb.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.cxf) {
            this.cxf = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ago.size(); i++) {
                    this.ago.get(i).aA(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ago.size(); i2++) {
                    this.ago.get(i2).aA(true);
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
        this.ago.clear();
    }

    public void onChangeSkinType(int i) {
        at.c(this.cxc, t.f.icon_error);
        at.k(findViewById(t.g.no_network_parent), t.f.bg_no_network);
        if (i == 1) {
            this.cxd.setTextColor(-10523526);
            this.cxe.setTextColor(-8682095);
            this.cxb.setTextColor(-10523526);
            return;
        }
        this.cxd.setTextColor(-14277082);
        this.cxe.setTextColor(-5065030);
        this.cxb.setTextColor(-14277082);
    }
}
