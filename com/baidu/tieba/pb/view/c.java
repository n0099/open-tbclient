package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private a eZV;
    private ImageView faA;
    private ImageView faB;
    private ImageView faC;
    private ImageView faD;
    private ImageView faE;
    private ImageView faF;
    private TextView faG;
    private AnimatorSet faH;
    private AnimatorSet faI;
    private AnimatorSet faJ;
    private AnimatorSet faK;
    private AnimatorSet faL;
    private AnimatorSet faM;
    private AnimatorSet faN;
    private boolean faO;
    private Runnable faP;
    private static final int aRq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = k.ag(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.faO = false;
        this.faP = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aWT();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.faA = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.faB = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.faC = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.faD = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.faE = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.faF = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.faG = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.faG.setX((SCREEN_WIDTH - aRq) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aWS();
    }

    private void aWS() {
        this.faH = new AnimatorSet();
        Drawable drawable = ai.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.faA, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.faA, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.faH.playTogether(ofFloat, ofFloat2);
        this.faI = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.faB, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.faI.play(ofFloat3);
        this.faJ = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.faC, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.faJ.play(ofFloat4);
        this.faK = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.faD, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.faK.play(ofFloat5);
        this.faL = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.faE, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.faL.play(ofFloat6);
        this.faM = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.faF, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.faM.play(ofFloat7);
        this.faN = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.faG, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.faG, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.faG, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.faN.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.black_alpha60);
        ai.c(this.faA, d.g.icon_floor_bigpraised_floating);
        ai.c(this.faB, d.g.icon_floor_praised_floating);
        ai.c(this.faC, d.g.icon_floor_praised_floating);
        ai.c(this.faD, d.g.icon_floor_praised_floating);
        ai.c(this.faE, d.g.icon_floor_praised_floating);
        ai.c(this.faF, d.g.icon_floor_praised_floating);
        ai.i(this.faG, d.e.cp_cont_i);
    }

    public void startAnimation(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.faO) {
            this.faO = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.faP, 2000L);
            this.faH.start();
            this.faI.start();
            this.faJ.start();
            this.faK.start();
            this.faL.start();
            this.faM.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWT() {
        this.faO = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eZV != null) {
            this.eZV.onAnimationEnd();
        }
        removeCallbacks(this.faP);
    }

    public void stopAnimation() {
        if (this.faO) {
            aWT();
            this.faH.cancel();
            this.faI.cancel();
            this.faJ.cancel();
            this.faK.cancel();
            this.faL.cancel();
            this.faM.cancel();
            this.faN.cancel();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            stopAnimation();
        }
    }

    public void setFloatingHuajiAninationListener(a aVar) {
        this.eZV = aVar;
    }
}
