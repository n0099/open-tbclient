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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private ArrayList<a> afm;
    private boolean agm;
    private TextView djh;
    private ImageView dji;
    private TextView djj;
    private TextView djk;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afm = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afm = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.afm = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(r.j.shut_down_validate_tip, (ViewGroup) null));
        this.dji = (ImageView) findViewById(r.h.no_network_icon);
        this.djj = (TextView) findViewById(r.h.no_network_guide1);
        this.djk = (TextView) findViewById(r.h.no_network_guide2);
        this.djh = (TextView) findViewById(r.h.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.djh != null) {
            this.djh.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.agm) {
            this.agm = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afm.size(); i++) {
                    this.afm.get(i).aL(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afm.size(); i2++) {
                    this.afm.get(i2).aL(true);
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
        this.afm.clear();
    }

    public void onChangeSkinType(int i) {
        ap.c(this.dji, r.g.icon_error);
        ap.j(findViewById(r.h.no_network_parent), r.g.bg_no_network);
        if (i == 1) {
            this.djj.setTextColor(-10523526);
            this.djk.setTextColor(-8682095);
            this.djh.setTextColor(-10523526);
            return;
        }
        this.djj.setTextColor(-14277082);
        this.djk.setTextColor(-5065030);
        this.djh.setTextColor(-14277082);
    }
}
