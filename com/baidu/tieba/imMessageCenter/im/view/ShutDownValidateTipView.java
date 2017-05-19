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
/* loaded from: classes2.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> akq;
    private boolean alO;
    private TextView dgu;
    private ImageView dgv;
    private TextView dgw;
    private TextView dgx;

    /* loaded from: classes2.dex */
    public interface a {
        void aL(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akq = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akq = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.akq = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(w.j.shut_down_validate_tip, (ViewGroup) null));
        this.dgv = (ImageView) findViewById(w.h.no_network_icon);
        this.dgw = (TextView) findViewById(w.h.no_network_guide1);
        this.dgx = (TextView) findViewById(w.h.no_network_guide2);
        this.dgu = (TextView) findViewById(w.h.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dgu != null) {
            this.dgu.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.alO) {
            this.alO = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.akq.size(); i++) {
                    this.akq.get(i).aL(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.akq.size(); i2++) {
                    this.akq.get(i2).aL(true);
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
        this.akq.clear();
    }

    public void onChangeSkinType(int i) {
        aq.c(this.dgv, w.g.icon_error);
        aq.j(findViewById(w.h.no_network_parent), w.g.bg_no_network);
        if (i == 1) {
            this.dgw.setTextColor(-10523526);
            this.dgx.setTextColor(-8682095);
            this.dgu.setTextColor(-10523526);
            return;
        }
        this.dgw.setTextColor(-14277082);
        this.dgx.setTextColor(-5065030);
        this.dgu.setTextColor(-14277082);
    }
}
