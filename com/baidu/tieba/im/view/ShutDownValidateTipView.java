package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private static ArrayList<ShutDownValidateTipView> Il = new ArrayList<>();
    private static boolean In;
    private ArrayList<r> Iq;
    private TextView bjB;
    private ImageView bjC;
    private TextView bjD;
    private TextView bjE;
    private boolean bjF;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Iq = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Iq = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.Iq = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(com.baidu.adp.lib.g.b.ek().inflate(context, w.shut_down_validate_tip, null));
        this.bjC = (ImageView) findViewById(v.no_network_icon);
        this.bjD = (TextView) findViewById(v.no_network_guide1);
        this.bjE = (TextView) findViewById(v.no_network_guide2);
        this.bjB = (TextView) findViewById(v.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bjB != null) {
            this.bjB.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != In) {
            In = z;
            if (In) {
                Iterator<ShutDownValidateTipView> it = Il.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = Il.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bjF) {
            this.bjF = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new p(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.Iq.size(); i++) {
                    this.Iq.get(i).aa(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new q(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.Iq.size(); i2++) {
                    this.Iq.get(i2).aa(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Il.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Il.remove(this);
        this.Iq.clear();
    }

    public void onChangeSkinType(int i) {
        aw.c(this.bjC, u.icon_error);
        aw.h(findViewById(v.no_network_parent), u.bg_no_network);
        if (i == 1) {
            this.bjD.setTextColor(-10523526);
            this.bjE.setTextColor(-8682095);
            this.bjB.setTextColor(-10523526);
            return;
        }
        this.bjD.setTextColor(-14277082);
        this.bjE.setTextColor(-5065030);
        this.bjB.setTextColor(-14277082);
    }
}
