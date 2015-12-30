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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> aga;
    private TextView chY;
    private ImageView chZ;
    private TextView cia;
    private TextView cib;
    private boolean cic;

    /* loaded from: classes.dex */
    public interface a {
        void ax(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aga = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aga = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aga = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(n.h.shut_down_validate_tip, (ViewGroup) null));
        this.chZ = (ImageView) findViewById(n.g.no_network_icon);
        this.cia = (TextView) findViewById(n.g.no_network_guide1);
        this.cib = (TextView) findViewById(n.g.no_network_guide2);
        this.chY = (TextView) findViewById(n.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.chY != null) {
            this.chY.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.cic) {
            this.cic = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aga.size(); i++) {
                    this.aga.get(i).ax(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aga.size(); i2++) {
                    this.aga.get(i2).ax(true);
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
        this.aga.clear();
    }

    public void onChangeSkinType(int i) {
        as.c(this.chZ, n.f.icon_error);
        as.i(findViewById(n.g.no_network_parent), n.f.bg_no_network);
        if (i == 1) {
            this.cia.setTextColor(-10523526);
            this.cib.setTextColor(-8682095);
            this.chY.setTextColor(-10523526);
            return;
        }
        this.cia.setTextColor(-14277082);
        this.cib.setTextColor(-5065030);
        this.chY.setTextColor(-14277082);
    }
}
