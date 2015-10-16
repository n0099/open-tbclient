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
    private ArrayList<a> aem;
    private TextView bOA;
    private ImageView bOB;
    private TextView bOC;
    private TextView bOD;
    private boolean bOE;

    /* loaded from: classes.dex */
    public interface a {
        void ax(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aem = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aem = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.aem = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(i.g.shut_down_validate_tip, (ViewGroup) null));
        this.bOB = (ImageView) findViewById(i.f.no_network_icon);
        this.bOC = (TextView) findViewById(i.f.no_network_guide1);
        this.bOD = (TextView) findViewById(i.f.no_network_guide2);
        this.bOA = (TextView) findViewById(i.f.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bOA != null) {
            this.bOA.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bOE) {
            this.bOE = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.aem.size(); i++) {
                    this.aem.get(i).ax(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.aem.size(); i2++) {
                    this.aem.get(i2).ax(true);
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
        this.aem.clear();
    }

    public void onChangeSkinType(int i) {
        an.c(this.bOB, i.e.icon_error);
        an.i(findViewById(i.f.no_network_parent), i.e.bg_no_network);
        if (i == 1) {
            this.bOC.setTextColor(-10523526);
            this.bOD.setTextColor(-8682095);
            this.bOA.setTextColor(-10523526);
            return;
        }
        this.bOC.setTextColor(-14277082);
        this.bOD.setTextColor(-5065030);
        this.bOA.setTextColor(-14277082);
    }
}
