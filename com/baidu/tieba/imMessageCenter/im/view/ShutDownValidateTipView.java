package com.baidu.tieba.imMessageCenter.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private static ArrayList<ShutDownValidateTipView> ZK = new ArrayList<>();
    private static boolean ZM;
    private ArrayList<c> ZP;
    private TextView bwH;
    private ImageView bwI;
    private TextView bwJ;
    private TextView bwK;
    private boolean bwL;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZP = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZP = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.ZP = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(com.baidu.adp.lib.g.b.hr().inflate(context, r.shut_down_validate_tip, null));
        this.bwI = (ImageView) findViewById(q.no_network_icon);
        this.bwJ = (TextView) findViewById(q.no_network_guide1);
        this.bwK = (TextView) findViewById(q.no_network_guide2);
        this.bwH = (TextView) findViewById(q.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bwH != null) {
            this.bwH.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != ZM) {
            ZM = z;
            if (ZM) {
                Iterator<ShutDownValidateTipView> it = ZK.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = ZK.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bwL) {
            this.bwL = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ZP.size(); i++) {
                    this.ZP.get(i).au(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ZP.size(); i2++) {
                    this.ZP.get(i2).au(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ZK.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ZK.remove(this);
        this.ZP.clear();
    }

    public void onChangeSkinType(int i) {
        ay.c(this.bwI, p.icon_error);
        ay.i(findViewById(q.no_network_parent), p.bg_no_network);
        if (i == 1) {
            this.bwJ.setTextColor(-10523526);
            this.bwK.setTextColor(-8682095);
            this.bwH.setTextColor(-10523526);
            return;
        }
        this.bwJ.setTextColor(-14277082);
        this.bwK.setTextColor(-5065030);
        this.bwH.setTextColor(-14277082);
    }
}
