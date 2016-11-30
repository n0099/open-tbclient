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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> agH;
    private TextView dza;
    private ImageView dzb;
    private TextView dzc;
    private TextView dzd;
    private boolean dze;

    /* loaded from: classes.dex */
    public interface a {
        void aK(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agH = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agH = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.agH = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(r.h.shut_down_validate_tip, (ViewGroup) null));
        this.dzb = (ImageView) findViewById(r.g.no_network_icon);
        this.dzc = (TextView) findViewById(r.g.no_network_guide1);
        this.dzd = (TextView) findViewById(r.g.no_network_guide2);
        this.dza = (TextView) findViewById(r.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dza != null) {
            this.dza.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.dze) {
            this.dze = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.agH.size(); i++) {
                    this.agH.get(i).aK(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.agH.size(); i2++) {
                    this.agH.get(i2).aK(true);
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
        this.agH.clear();
    }

    public void onChangeSkinType(int i) {
        at.c(this.dzb, r.f.icon_error);
        at.k(findViewById(r.g.no_network_parent), r.f.bg_no_network);
        if (i == 1) {
            this.dzc.setTextColor(-10523526);
            this.dzd.setTextColor(-8682095);
            this.dza.setTextColor(-10523526);
            return;
        }
        this.dzc.setTextColor(-14277082);
        this.dzd.setTextColor(-5065030);
        this.dza.setTextColor(-14277082);
    }
}
