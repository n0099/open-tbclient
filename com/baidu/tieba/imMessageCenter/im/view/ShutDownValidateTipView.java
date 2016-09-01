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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> afH;
    private TextView drY;
    private ImageView drZ;
    private TextView dsa;
    private TextView dsb;
    private boolean dsc;

    /* loaded from: classes.dex */
    public interface a {
        void aH(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afH = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afH = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.afH = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(t.h.shut_down_validate_tip, (ViewGroup) null));
        this.drZ = (ImageView) findViewById(t.g.no_network_icon);
        this.dsa = (TextView) findViewById(t.g.no_network_guide1);
        this.dsb = (TextView) findViewById(t.g.no_network_guide2);
        this.drY = (TextView) findViewById(t.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.drY != null) {
            this.drY.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.dsc) {
            this.dsc = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afH.size(); i++) {
                    this.afH.get(i).aH(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afH.size(); i2++) {
                    this.afH.get(i2).aH(true);
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
        this.afH.clear();
    }

    public void onChangeSkinType(int i) {
        av.c(this.drZ, t.f.icon_error);
        av.k(findViewById(t.g.no_network_parent), t.f.bg_no_network);
        if (i == 1) {
            this.dsa.setTextColor(-10523526);
            this.dsb.setTextColor(-8682095);
            this.drY.setTextColor(-10523526);
            return;
        }
        this.dsa.setTextColor(-14277082);
        this.dsb.setTextColor(-5065030);
        this.drY.setTextColor(-14277082);
    }
}
