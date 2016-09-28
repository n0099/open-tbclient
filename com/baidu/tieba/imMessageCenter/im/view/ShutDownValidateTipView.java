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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> agh;
    private TextView dtv;
    private ImageView dtw;
    private TextView dtx;
    private TextView dty;
    private boolean dtz;

    /* loaded from: classes.dex */
    public interface a {
        void aH(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agh = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agh = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.agh = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(r.h.shut_down_validate_tip, (ViewGroup) null));
        this.dtw = (ImageView) findViewById(r.g.no_network_icon);
        this.dtx = (TextView) findViewById(r.g.no_network_guide1);
        this.dty = (TextView) findViewById(r.g.no_network_guide2);
        this.dtv = (TextView) findViewById(r.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dtv != null) {
            this.dtv.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.dtz) {
            this.dtz = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.agh.size(); i++) {
                    this.agh.get(i).aH(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.agh.size(); i2++) {
                    this.agh.get(i2).aH(true);
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
        this.agh.clear();
    }

    public void onChangeSkinType(int i) {
        av.c(this.dtw, r.f.icon_error);
        av.k(findViewById(r.g.no_network_parent), r.f.bg_no_network);
        if (i == 1) {
            this.dtx.setTextColor(-10523526);
            this.dty.setTextColor(-8682095);
            this.dtv.setTextColor(-10523526);
            return;
        }
        this.dtx.setTextColor(-14277082);
        this.dty.setTextColor(-5065030);
        this.dtv.setTextColor(-14277082);
    }
}
