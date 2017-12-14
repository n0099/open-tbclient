package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ScaleAnimation anU;
    private ImageView anl;
    private TextView fgr;
    private TextView fgs;
    private boolean fgt;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fgt = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgt = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgt = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fgr = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.tbds48));
        layoutParams.leftMargin = l.f(context, d.e.tbds9);
        layoutParams.topMargin = l.f(context, d.e.tbds18);
        this.fgr.setLayoutParams(layoutParams);
        this.fgr.setTextSize(0, l.f(context, d.e.tbfontsize30));
        this.fgr.setGravity(17);
        aj.i(this.fgr, d.C0096d.cp_cont_j);
        this.anl = new ImageView(context);
        aj.c(this.anl, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.f(context, d.e.tbds48), l.f(context, d.e.tbds48));
        layoutParams2.leftMargin = l.f(context, d.e.tbds9);
        layoutParams2.topMargin = l.f(context, d.e.tbds18);
        this.anl.setLayoutParams(layoutParams2);
        linearLayout.addView(this.anl);
        linearLayout.addView(this.fgr);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fgs = new TextView(getContext());
        this.fgs.setTextSize(0, l.f(getContext(), d.e.fontsize24));
        addView(this.fgs);
        this.fgs.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.fgt != z) {
            this.fgt = z;
            onChangeSkinType();
        }
        this.fgr.setText(am.w(j));
        if (z2) {
            this.anl.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.anU == null) {
            this.anU = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.anU.setDuration(200L);
        }
        return this.anU;
    }

    private boolean wI() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.xE();
    }

    public void onChangeSkinType() {
        if (this.fgt) {
            aj.c(this.anl, wI() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
            aj.i(this.fgr, d.C0096d.cp_cont_h);
            return;
        }
        aj.c(this.anl, wI() ? d.f.icon_card_like_n_xmas : d.f.icon_floor_like_n);
        aj.i(this.fgr, d.C0096d.cp_cont_j);
    }

    public void qs(int i) {
        if (this.anl != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.fgs.getAnimation() != null) {
                this.fgs.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.j.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0096d.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0096d.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0096d.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.fgs.setText(spannableStringBuilder);
            this.fgs.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.f(getContext(), d.e.ds20), 0.0f, -l.f(getContext(), d.e.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.fgs.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.fgs.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.fgs.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
