package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private static boolean NA;
    private static ArrayList<ShutDownValidateTipView> Ny = new ArrayList<>();
    private ArrayList<r> ND;
    private boolean bqA;
    private TextView bqw;
    private ImageView bqx;
    private TextView bqy;
    private TextView bqz;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ND = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ND = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.ND = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(b.ei().inflate(context, x.shut_down_validate_tip, null));
        this.bqx = (ImageView) findViewById(w.no_network_icon);
        this.bqy = (TextView) findViewById(w.no_network_guide1);
        this.bqz = (TextView) findViewById(w.no_network_guide2);
        this.bqw = (TextView) findViewById(w.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.bqw != null) {
            this.bqw.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != NA) {
            NA = z;
            if (NA) {
                Iterator<ShutDownValidateTipView> it = Ny.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = Ny.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bqA) {
            this.bqA = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new p(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.ND.size(); i++) {
                    this.ND.get(i).at(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new q(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.ND.size(); i2++) {
                    this.ND.get(i2).at(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ny.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ny.remove(this);
        this.ND.clear();
    }

    public void onChangeSkinType(int i) {
        bc.c(this.bqx, v.icon_error);
        bc.i(findViewById(w.no_network_parent), v.bg_no_network);
        if (i == 1) {
            this.bqy.setTextColor(-10523526);
            this.bqz.setTextColor(-8682095);
            this.bqw.setTextColor(-10523526);
            return;
        }
        this.bqy.setTextColor(-14277082);
        this.bqz.setTextColor(-5065030);
        this.bqw.setTextColor(-14277082);
    }
}
