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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> afZ;
    private boolean agZ;
    private TextView dbV;
    private ImageView dbW;
    private TextView dbX;
    private TextView dbY;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afZ = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afZ = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.afZ = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(r.h.shut_down_validate_tip, (ViewGroup) null));
        this.dbW = (ImageView) findViewById(r.g.no_network_icon);
        this.dbX = (TextView) findViewById(r.g.no_network_guide1);
        this.dbY = (TextView) findViewById(r.g.no_network_guide2);
        this.dbV = (TextView) findViewById(r.g.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.dbV != null) {
            this.dbV.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.agZ) {
            this.agZ = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afZ.size(); i++) {
                    this.afZ.get(i).aL(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afZ.size(); i2++) {
                    this.afZ.get(i2).aL(true);
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
        this.afZ.clear();
    }

    public void onChangeSkinType(int i) {
        ar.c(this.dbW, r.f.icon_error);
        ar.k(findViewById(r.g.no_network_parent), r.f.bg_no_network);
        if (i == 1) {
            this.dbX.setTextColor(-10523526);
            this.dbY.setTextColor(-8682095);
            this.dbV.setTextColor(-10523526);
            return;
        }
        this.dbX.setTextColor(-14277082);
        this.dbY.setTextColor(-5065030);
        this.dbV.setTextColor(-14277082);
    }
}
