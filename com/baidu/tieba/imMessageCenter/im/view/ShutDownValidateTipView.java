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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> ael;
    private TextView bOp;
    private ImageView bOq;
    private TextView bOr;
    private TextView bOs;
    private boolean bOt;

    /* loaded from: classes.dex */
    public interface a {
        void ax(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ael = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ael = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.ael = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(i.g.shut_down_validate_tip, (ViewGroup) null));
        this.bOq = (ImageView) findViewById(i.f.no_network_icon);
        this.bOr = (TextView) findViewById(i.f.no_network_guide1);
        this.bOs = (TextView) findViewById(i.f.no_network_guide2);
        this.bOp = (TextView) findViewById(i.f.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bOp != null) {
            this.bOp.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bOt) {
            this.bOt = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ael.size(); i++) {
                    this.ael.get(i).ax(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ael.size(); i2++) {
                    this.ael.get(i2).ax(true);
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
        this.ael.clear();
    }

    public void onChangeSkinType(int i) {
        am.c(this.bOq, i.e.icon_error);
        am.i(findViewById(i.f.no_network_parent), i.e.bg_no_network);
        if (i == 1) {
            this.bOr.setTextColor(-10523526);
            this.bOs.setTextColor(-8682095);
            this.bOp.setTextColor(-10523526);
            return;
        }
        this.bOr.setTextColor(-14277082);
        this.bOs.setTextColor(-5065030);
        this.bOp.setTextColor(-14277082);
    }
}
