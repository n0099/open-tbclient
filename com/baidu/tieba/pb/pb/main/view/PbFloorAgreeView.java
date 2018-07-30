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
    private ImageView awR;
    private ScaleAnimation axD;
    private TextView fJv;
    private TextView fJw;
    private boolean fJx;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fJx = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fJx = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fJx = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fJv = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.tbds48));
        layoutParams.leftMargin = l.f(context, d.e.tbds9);
        layoutParams.topMargin = l.f(context, d.e.tbds18);
        this.fJv.setLayoutParams(layoutParams);
        this.fJv.setTextSize(0, l.f(context, d.e.tbfontsize30));
        this.fJv.setGravity(17);
        am.h(this.fJv, d.C0140d.cp_cont_j);
        this.awR = new ImageView(context);
        am.c(this.awR, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.f(context, d.e.tbds48), l.f(context, d.e.tbds48));
        layoutParams2.leftMargin = l.f(context, d.e.tbds9);
        layoutParams2.topMargin = l.f(context, d.e.tbds18);
        this.awR.setLayoutParams(layoutParams2);
        linearLayout.addView(this.awR);
        linearLayout.addView(this.fJv);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fJw = new TextView(getContext());
        this.fJw.setTextSize(0, l.f(getContext(), d.e.fontsize24));
        addView(this.fJw);
        this.fJw.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.fJx != z) {
            this.fJx = z;
            onChangeSkinType();
        }
        this.fJv.setText(ap.D(j));
        if (z2) {
            this.awR.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.axD == null) {
            this.axD = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.axD.setDuration(200L);
        }
        return this.axD;
    }

    private boolean AO() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BM();
    }

    public void onChangeSkinType() {
        if (this.fJx) {
            am.c(this.awR, AO() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
            am.h(this.fJv, d.C0140d.cp_cont_h);
            return;
        }
        am.c(this.awR, AO() ? d.f.icon_card_like_n_xmas : d.f.icon_floor_like_n);
        am.h(this.fJv, d.C0140d.cp_cont_j);
    }

    public void qU(int i) {
        if (this.awR != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.fJw.getAnimation() != null) {
                this.fJw.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.j.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.fJw.setText(spannableStringBuilder);
            this.fJw.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.f(getContext(), d.e.ds20), 0.0f, -l.f(getContext(), d.e.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.fJw.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.fJw.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.fJw.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
