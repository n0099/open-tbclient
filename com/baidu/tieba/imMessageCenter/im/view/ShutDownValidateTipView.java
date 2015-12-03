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
    private ArrayList<a> afo;
    private TextView cdY;
    private ImageView cdZ;
    private TextView cea;
    private TextView ceb;
    private boolean cec;

    /* loaded from: classes.dex */
    public interface a {
        void aA(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afo = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afo = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.afo = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(LayoutInflater.from(context).inflate(n.g.shut_down_validate_tip, (ViewGroup) null));
        this.cdZ = (ImageView) findViewById(n.f.no_network_icon);
        this.cea = (TextView) findViewById(n.f.no_network_guide1);
        this.ceb = (TextView) findViewById(n.f.no_network_guide2);
        this.cdY = (TextView) findViewById(n.f.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.cdY != null) {
            this.cdY.setOnClickListener(onClickListener);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.cec) {
            this.cec = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new com.baidu.tieba.imMessageCenter.im.view.a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.afo.size(); i++) {
                    this.afo.get(i).aA(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.afo.size(); i2++) {
                    this.afo.get(i2).aA(true);
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
        this.afo.clear();
    }

    public void onChangeSkinType(int i) {
        as.c(this.cdZ, n.e.icon_error);
        as.i(findViewById(n.f.no_network_parent), n.e.bg_no_network);
        if (i == 1) {
            this.cea.setTextColor(-10523526);
            this.ceb.setTextColor(-8682095);
            this.cdY.setTextColor(-10523526);
            return;
        }
        this.cea.setTextColor(-14277082);
        this.ceb.setTextColor(-5065030);
        this.cdY.setTextColor(-14277082);
    }
}
