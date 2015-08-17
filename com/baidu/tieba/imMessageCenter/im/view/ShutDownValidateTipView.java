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
    private ArrayList<a> aeP;
    private TextView bKA;
    private TextView bKB;
    private boolean bKC;
    private TextView bKy;
    private ImageView bKz;

    /* loaded from: classes.dex */
    public interface a {
        void ay(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeP = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeP = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aeP = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(i.g.shut_down_validate_tip, (ViewGroup) null));
        this.bKz = (ImageView) findViewById(i.f.no_network_icon);
        this.bKA = (TextView) findViewById(i.f.no_network_guide1);
        this.bKB = (TextView) findViewById(i.f.no_network_guide2);
        this.bKy = (TextView) findViewById(i.f.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bKy != null) {
            this.bKy.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bKC) {
            this.bKC = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aeP.size(); i++) {
                    this.aeP.get(i).ay(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aeP.size(); i2++) {
                    this.aeP.get(i2).ay(true);
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
        this.aeP.clear();
    }

    public void onChangeSkinType(int i) {
        al.c(this.bKz, i.e.icon_error);
        al.i(findViewById(i.f.no_network_parent), i.e.bg_no_network);
        if (i == 1) {
            this.bKA.setTextColor(-10523526);
            this.bKB.setTextColor(-8682095);
            this.bKy.setTextColor(-10523526);
            return;
        }
        this.bKA.setTextColor(-14277082);
        this.bKB.setTextColor(-5065030);
        this.bKy.setTextColor(-14277082);
    }
}
