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
    private static ArrayList<ShutDownValidateTipView> Im = new ArrayList<>();
    private static boolean Io;
    private ArrayList<r> Ir;
    private TextView bjP;
    private ImageView bjQ;
    private TextView bjR;
    private TextView bjS;
    private boolean bjT;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ir = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ir = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.Ir = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(com.baidu.adp.lib.g.b.ek().inflate(context, w.shut_down_validate_tip, null));
        this.bjQ = (ImageView) findViewById(v.no_network_icon);
        this.bjR = (TextView) findViewById(v.no_network_guide1);
        this.bjS = (TextView) findViewById(v.no_network_guide2);
        this.bjP = (TextView) findViewById(v.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bjP != null) {
            this.bjP.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != Io) {
            Io = z;
            if (Io) {
                Iterator<ShutDownValidateTipView> it = Im.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = Im.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bjT) {
            this.bjT = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new p(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.Ir.size(); i++) {
                    this.Ir.get(i).aa(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new q(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.Ir.size(); i2++) {
                    this.Ir.get(i2).aa(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Im.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Im.remove(this);
        this.Ir.clear();
    }

    public void onChangeSkinType(int i) {
        aw.c(this.bjQ, u.icon_error);
        aw.h(findViewById(v.no_network_parent), u.bg_no_network);
        if (i == 1) {
            this.bjR.setTextColor(-10523526);
            this.bjS.setTextColor(-8682095);
            this.bjP.setTextColor(-10523526);
            return;
        }
        this.bjR.setTextColor(-14277082);
        this.bjS.setTextColor(-5065030);
        this.bjP.setTextColor(-14277082);
    }
}
