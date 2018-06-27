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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ScaleAnimation axX;
    private ImageView axl;
    private TextView fJg;
    private TextView fJh;
    private boolean fJi;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fJi = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fJi = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fJi = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fJg = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.e(context, d.e.tbds48));
        layoutParams.leftMargin = l.e(context, d.e.tbds9);
        layoutParams.topMargin = l.e(context, d.e.tbds18);
        this.fJg.setLayoutParams(layoutParams);
        this.fJg.setTextSize(0, l.e(context, d.e.tbfontsize30));
        this.fJg.setGravity(17);
        am.h(this.fJg, d.C0142d.cp_cont_j);
        this.axl = new ImageView(context);
        am.c(this.axl, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.e(context, d.e.tbds48), l.e(context, d.e.tbds48));
        layoutParams2.leftMargin = l.e(context, d.e.tbds9);
        layoutParams2.topMargin = l.e(context, d.e.tbds18);
        this.axl.setLayoutParams(layoutParams2);
        linearLayout.addView(this.axl);
        linearLayout.addView(this.fJg);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fJh = new TextView(getContext());
        this.fJh.setTextSize(0, l.e(getContext(), d.e.fontsize24));
        addView(this.fJh);
        this.fJh.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.fJi != z) {
            this.fJi = z;
            onChangeSkinType();
        }
        this.fJg.setText(ap.C(j));
        if (z2) {
            this.axl.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.axX == null) {
            this.axX = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.axX.setDuration(200L);
        }
        return this.axX;
    }

    private boolean AX() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BU();
    }

    public void onChangeSkinType() {
        if (this.fJi) {
            am.c(this.axl, AX() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
            am.h(this.fJg, d.C0142d.cp_cont_h);
            return;
        }
        am.c(this.axl, AX() ? d.f.icon_card_like_n_xmas : d.f.icon_floor_like_n);
        am.h(this.fJg, d.C0142d.cp_cont_j);
    }

    public void qX(int i) {
        if (this.axl != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.fJh.getAnimation() != null) {
                this.fJh.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.k.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.fJh.setText(spannableStringBuilder);
            this.fJh.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.e(getContext(), d.e.ds20), 0.0f, -l.e(getContext(), d.e.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.fJh.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.fJh.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.fJh.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
