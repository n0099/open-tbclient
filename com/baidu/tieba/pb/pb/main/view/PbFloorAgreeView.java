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
/* loaded from: classes2.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ScaleAnimation bbV;
    private ImageView bbm;
    private TextView fUS;
    private TextView fUT;
    private boolean fUU;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.fUU = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fUU = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUU = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fUS = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.s(context, d.e.tbds48));
        layoutParams.leftMargin = l.s(context, d.e.tbds9);
        layoutParams.topMargin = l.s(context, d.e.tbds18);
        this.fUS.setLayoutParams(layoutParams);
        this.fUS.setTextSize(0, l.s(context, d.e.tbfontsize30));
        this.fUS.setGravity(17);
        aj.r(this.fUS, d.C0107d.cp_cont_j);
        this.bbm = new ImageView(context);
        aj.c(this.bbm, d.f.icon_floor_like_n);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.s(context, d.e.tbds48), l.s(context, d.e.tbds48));
        layoutParams2.leftMargin = l.s(context, d.e.tbds9);
        layoutParams2.topMargin = l.s(context, d.e.tbds18);
        this.bbm.setLayoutParams(layoutParams2);
        linearLayout.addView(this.bbm);
        linearLayout.addView(this.fUS);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        addView(linearLayout, layoutParams3);
        this.fUT = new TextView(getContext());
        this.fUT.setTextSize(0, l.s(getContext(), d.e.fontsize24));
        addView(this.fUT);
        this.fUT.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.fUU != z) {
            this.fUU = z;
            onChangeSkinType();
        }
        this.fUS.setText(am.F(j));
        if (z2) {
            this.bbm.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.bbV == null) {
            this.bbV = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.bbV.setDuration(200L);
        }
        return this.bbV;
    }

    private boolean DX() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.EU();
    }

    public void onChangeSkinType() {
        if (this.fUU) {
            aj.c(this.bbm, DX() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
            aj.r(this.fUS, d.C0107d.cp_cont_h);
            return;
        }
        aj.c(this.bbm, DX() ? d.f.icon_card_like_n_xmas : d.f.icon_floor_like_n);
        aj.r(this.fUS, d.C0107d.cp_cont_j);
    }

    public void te(int i) {
        if (this.bbm != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.fUT.getAnimation() != null) {
                this.fUT.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.j.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.fUT.setText(spannableStringBuilder);
            this.fUT.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.s(getContext(), d.e.ds20), 0.0f, -l.s(getContext(), d.e.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.fUT.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.fUT.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.fUT.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
