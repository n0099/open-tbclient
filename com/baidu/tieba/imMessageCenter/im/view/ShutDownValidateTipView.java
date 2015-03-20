package com.baidu.tieba.imMessageCenter.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private static ArrayList<ShutDownValidateTipView> YH = new ArrayList<>();
    private static boolean YJ;
    private ArrayList<c> YM;
    private TextView btI;
    private ImageView btJ;
    private TextView btK;
    private TextView btL;
    private boolean btM;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.YM = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YM = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.YM = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(com.baidu.adp.lib.g.b.hH().inflate(context, w.shut_down_validate_tip, null));
        this.btJ = (ImageView) findViewById(v.no_network_icon);
        this.btK = (TextView) findViewById(v.no_network_guide1);
        this.btL = (TextView) findViewById(v.no_network_guide2);
        this.btI = (TextView) findViewById(v.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.btI != null) {
            this.btI.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != YJ) {
            YJ = z;
            if (YJ) {
                Iterator<ShutDownValidateTipView> it = YH.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = YH.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.btM) {
            this.btM = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new a(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.YM.size(); i++) {
                    this.YM.get(i).an(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new b(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.YM.size(); i2++) {
                    this.YM.get(i2).an(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        YH.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YH.remove(this);
        this.YM.clear();
    }

    public void onChangeSkinType(int i) {
        ba.c(this.btJ, u.icon_error);
        ba.i(findViewById(v.no_network_parent), u.bg_no_network);
        if (i == 1) {
            this.btK.setTextColor(-10523526);
            this.btL.setTextColor(-8682095);
            this.btI.setTextColor(-10523526);
            return;
        }
        this.btK.setTextColor(-14277082);
        this.btL.setTextColor(-5065030);
        this.btI.setTextColor(-14277082);
    }
}
