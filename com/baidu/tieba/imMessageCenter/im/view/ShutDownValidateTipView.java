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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> agN;
    private ImageView cmA;
    private TextView cmB;
    private TextView cmC;
    private boolean cmD;
    private TextView cmz;

    /* loaded from: classes.dex */
    public interface a {
        void ay(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agN = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agN = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.agN = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(t.h.shut_down_validate_tip, (ViewGroup) null));
        this.cmA = (ImageView) findViewById(t.g.no_network_icon);
        this.cmB = (TextView) findViewById(t.g.no_network_guide1);
        this.cmC = (TextView) findViewById(t.g.no_network_guide2);
        this.cmz = (TextView) findViewById(t.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.cmz != null) {
            this.cmz.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.cmD) {
            this.cmD = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.agN.size(); i++) {
                    this.agN.get(i).ay(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.agN.size(); i2++) {
                    this.agN.get(i2).ay(true);
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
        this.agN.clear();
    }

    public void onChangeSkinType(int i) {
        ar.c(this.cmA, t.f.icon_error);
        ar.k(findViewById(t.g.no_network_parent), t.f.bg_no_network);
        if (i == 1) {
            this.cmB.setTextColor(-10523526);
            this.cmC.setTextColor(-8682095);
            this.cmz.setTextColor(-10523526);
            return;
        }
        this.cmB.setTextColor(-14277082);
        this.cmC.setTextColor(-5065030);
        this.cmz.setTextColor(-14277082);
    }
}
