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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView aou;
    private ScaleAnimation apc;
    private TextView ftO;
    private TextView ftP;
    private boolean ftQ;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.ftQ = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftQ = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftQ = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.ftO = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.e(context, d.e.tbds48));
        layoutParams.leftMargin = l.e(context, d.e.tbds9);
        layoutParams.topMargin = l.e(context, d.e.tbds18);
        this.ftO.setLayoutParams(layoutParams);
        this.ftO.setTextSize(0, l.e(context, d.e.tbfontsize30));
        this.ftO.setGravity(17);
        ak.h(this.ftO, d.C0126d.cp_cont_j);
        this.aou = new ImageView(context);
        ak.c(this.aou, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.e(context, d.e.tbds48), l.e(context, d.e.tbds48));
        layoutParams2.leftMargin = l.e(context, d.e.tbds9);
        layoutParams2.topMargin = l.e(context, d.e.tbds18);
        this.aou.setLayoutParams(layoutParams2);
        linearLayout.addView(this.aou);
        linearLayout.addView(this.ftO);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.ftP = new TextView(getContext());
        this.ftP.setTextSize(0, l.e(getContext(), d.e.fontsize24));
        addView(this.ftP);
        this.ftP.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.ftQ != z) {
            this.ftQ = z;
            onChangeSkinType();
        }
        this.ftO.setText(an.y(j));
        if (z2) {
            this.aou.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }

    private boolean xe() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.yd();
    }

    public void onChangeSkinType() {
        if (this.ftQ) {
            ak.c(this.aou, xe() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
            ak.h(this.ftO, d.C0126d.cp_cont_h);
            return;
        }
        ak.c(this.aou, xe() ? d.f.icon_card_like_n_xmas : d.f.icon_floor_like_n);
        ak.h(this.ftO, d.C0126d.cp_cont_j);
    }

    public void qD(int i) {
        if (this.aou != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.ftP.getAnimation() != null) {
                this.ftP.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.k.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.ftP.setText(spannableStringBuilder);
            this.ftP.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.e(getContext(), d.e.ds20), 0.0f, -l.e(getContext(), d.e.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.ftP.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.ftP.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.ftP.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
