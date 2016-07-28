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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> acR;
    private TextView dgr;
    private ImageView dgs;
    private TextView dgt;
    private TextView dgu;
    private boolean dgv;

    /* loaded from: classes.dex */
    public interface a {
        void aG(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acR = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acR = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.acR = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(u.h.shut_down_validate_tip, (ViewGroup) null));
        this.dgs = (ImageView) findViewById(u.g.no_network_icon);
        this.dgt = (TextView) findViewById(u.g.no_network_guide1);
        this.dgu = (TextView) findViewById(u.g.no_network_guide2);
        this.dgr = (TextView) findViewById(u.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dgr != null) {
            this.dgr.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.dgv) {
            this.dgv = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.acR.size(); i++) {
                    this.acR.get(i).aG(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.acR.size(); i2++) {
                    this.acR.get(i2).aG(true);
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
        this.acR.clear();
    }

    public void onChangeSkinType(int i) {
        av.c(this.dgs, u.f.icon_error);
        av.k(findViewById(u.g.no_network_parent), u.f.bg_no_network);
        if (i == 1) {
            this.dgt.setTextColor(-10523526);
            this.dgu.setTextColor(-8682095);
            this.dgr.setTextColor(-10523526);
            return;
        }
        this.dgt.setTextColor(-14277082);
        this.dgu.setTextColor(-5065030);
        this.dgr.setTextColor(-14277082);
    }
}
