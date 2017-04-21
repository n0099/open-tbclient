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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> akT;
    private boolean alS;
    private TextView dmq;
    private ImageView dmr;
    private TextView dms;
    private TextView dmt;

    /* loaded from: classes.dex */
    public interface a {
        void aM(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akT = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akT = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.akT = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(w.j.shut_down_validate_tip, (ViewGroup) null));
        this.dmr = (ImageView) findViewById(w.h.no_network_icon);
        this.dms = (TextView) findViewById(w.h.no_network_guide1);
        this.dmt = (TextView) findViewById(w.h.no_network_guide2);
        this.dmq = (TextView) findViewById(w.h.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dmq != null) {
            this.dmq.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.alS) {
            this.alS = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akT.size(); i++) {
                    this.akT.get(i).aM(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akT.size(); i2++) {
                    this.akT.get(i2).aM(true);
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
        this.akT.clear();
    }

    public void onChangeSkinType(int i) {
        aq.c(this.dmr, w.g.icon_error);
        aq.j(findViewById(w.h.no_network_parent), w.g.bg_no_network);
        if (i == 1) {
            this.dms.setTextColor(-10523526);
            this.dmt.setTextColor(-8682095);
            this.dmq.setTextColor(-10523526);
            return;
        }
        this.dms.setTextColor(-14277082);
        this.dmt.setTextColor(-5065030);
        this.dmq.setTextColor(-14277082);
    }
}
