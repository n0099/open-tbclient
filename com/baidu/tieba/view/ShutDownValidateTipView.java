package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ShutDownValidateTipView extends FrameLayout {
    private static ArrayList<ShutDownValidateTipView> a = new ArrayList<>();
    private static boolean f;
    private TextView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private Context g;
    private boolean h;
    private ArrayList<bk> i;

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new ArrayList<>();
        a(context);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ArrayList<>();
        a(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.i = new ArrayList<>();
        a(context);
    }

    public void a(Context context) {
        this.g = context;
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.shut_down_validate_tip, (ViewGroup) null));
        this.c = (ImageView) findViewById(R.id.no_network_icon);
        this.d = (TextView) findViewById(R.id.no_network_guide1);
        this.e = (TextView) findViewById(R.id.no_network_guide2);
        this.b = (TextView) findViewById(R.id.no_network_showmore);
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        if (this.b != null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != f) {
            f = z;
            if (f) {
                Iterator<ShutDownValidateTipView> it = a.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<ShutDownValidateTipView> it2 = a.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.h) {
            this.h = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new bi(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.i.size(); i++) {
                    this.i.get(i).a(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new bj(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    this.i.get(i2).a(true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.remove(this);
        this.i.clear();
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setImageResource(R.drawable.icon_error_1);
            findViewById(R.id.no_network_parent).setBackgroundResource(R.drawable.bg_no_network_1);
            this.d.setTextColor(-10523526);
            this.e.setTextColor(-8682095);
            this.b.setTextColor(-10523526);
            return;
        }
        this.c.setImageResource(R.drawable.icon_error);
        findViewById(R.id.no_network_parent).setBackgroundResource(R.drawable.bg_no_network);
        this.d.setTextColor(-14277082);
        this.e.setTextColor(-5065030);
        this.b.setTextColor(-14277082);
    }
}
