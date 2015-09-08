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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> aeZ;
    private TextView bLf;
    private ImageView bLg;
    private TextView bLh;
    private TextView bLi;
    private boolean bLj;

    /* loaded from: classes.dex */
    public interface a {
        void ay(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeZ = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeZ = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aeZ = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(i.g.shut_down_validate_tip, (ViewGroup) null));
        this.bLg = (ImageView) findViewById(i.f.no_network_icon);
        this.bLh = (TextView) findViewById(i.f.no_network_guide1);
        this.bLi = (TextView) findViewById(i.f.no_network_guide2);
        this.bLf = (TextView) findViewById(i.f.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bLf != null) {
            this.bLf.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bLj) {
            this.bLj = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aeZ.size(); i++) {
                    this.aeZ.get(i).ay(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aeZ.size(); i2++) {
                    this.aeZ.get(i2).ay(true);
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
        this.aeZ.clear();
    }

    public void onChangeSkinType(int i) {
        al.c(this.bLg, i.e.icon_error);
        al.h(findViewById(i.f.no_network_parent), i.e.bg_no_network);
        if (i == 1) {
            this.bLh.setTextColor(-10523526);
            this.bLi.setTextColor(-8682095);
            this.bLf.setTextColor(-10523526);
            return;
        }
        this.bLh.setTextColor(-14277082);
        this.bLi.setTextColor(-5065030);
        this.bLf.setTextColor(-14277082);
    }
}
