package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private static ArrayList<ShutDownValidateTipView> Nf = new ArrayList<>();
    private static boolean Nh;
    private ArrayList<r> Nk;
    private TextView boZ;
    private ImageView bpa;
    private TextView bpb;
    private TextView bpc;
    private boolean bpd;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nk = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nk = new ArrayList<>();
        init(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.Nk = new ArrayList<>();
        init(context);
    }

    public void init(Context context) {
        addView(b.ek().inflate(context, x.shut_down_validate_tip, null));
        this.bpa = (ImageView) findViewById(w.no_network_icon);
        this.bpb = (TextView) findViewById(w.no_network_guide1);
        this.bpc = (TextView) findViewById(w.no_network_guide2);
        this.boZ = (TextView) findViewById(w.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.boZ != null) {
            this.boZ.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != Nh) {
            Nh = z;
            if (Nh) {
                Iterator<ShutDownValidateTipView> it = Nf.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = Nf.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.bpd) {
            this.bpd = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new p(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.Nk.size(); i++) {
                    this.Nk.get(i).ar(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new q(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.Nk.size(); i2++) {
                    this.Nk.get(i2).ar(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Nf.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Nf.remove(this);
        this.Nk.clear();
    }

    public void onChangeSkinType(int i) {
        ax.c(this.bpa, v.icon_error);
        ax.i(findViewById(w.no_network_parent), v.bg_no_network);
        if (i == 1) {
            this.bpb.setTextColor(-10523526);
            this.bpc.setTextColor(-8682095);
            this.boZ.setTextColor(-10523526);
            return;
        }
        this.bpb.setTextColor(-14277082);
        this.bpc.setTextColor(-5065030);
        this.boZ.setTextColor(-14277082);
    }
}
