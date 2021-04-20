package com.baidu.tieba.imMessageCenter.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ShutDownValidateTipView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17972e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17973f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17974g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17975h;
    public boolean i;
    public ArrayList<c> j;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ShutDownValidateTipView.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void b(boolean z);
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new ArrayList<>();
        a(context);
    }

    public void a(Context context) {
        addView(LayoutInflater.from(context).inflate(R.layout.shut_down_validate_tip, (ViewGroup) null));
        this.f17973f = (ImageView) findViewById(R.id.no_network_icon);
        this.f17974g = (TextView) findViewById(R.id.no_network_guide1);
        this.f17975h = (TextView) findViewById(R.id.no_network_guide2);
        this.f17972e = (TextView) findViewById(R.id.no_network_showmore);
    }

    public void b(int i) {
        SkinManager.setImageResource(this.f17973f, R.drawable.icon_error);
        SkinManager.setBackgroundResource(findViewById(R.id.no_network_parent), R.drawable.bg_no_network);
        if (i != 1 && i != 4) {
            this.f17974g.setTextColor(-14277082);
            this.f17975h.setTextColor(-5065030);
            this.f17972e.setTextColor(-14277082);
            return;
        }
        this.f17974g.setTextColor(-10523526);
        this.f17975h.setTextColor(-8682095);
        this.f17972e.setTextColor(-10523526);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j.clear();
    }

    public void setShutDownClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f17972e;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        if (z == this.i) {
            return;
        }
        this.i = z;
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setAnimationListener(new a());
            setVisibility(0);
            startAnimation(alphaAnimation);
            for (int i = 0; i < this.j.size(); i++) {
                this.j.get(i).b(false);
            }
        } else if (getVisibility() != 8) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setDuration(500L);
            alphaAnimation2.setAnimationListener(new b());
            startAnimation(alphaAnimation2);
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.j.get(i2).b(true);
            }
        }
    }

    public ShutDownValidateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList<>();
        a(context);
    }

    public ShutDownValidateTipView(Context context) {
        super(context);
        this.j = new ArrayList<>();
        a(context);
    }
}
