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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends RelativeLayout {
    private ImageView eKU;
    private ImageView eKV;
    private ImageView eKW;
    private ImageView eKX;
    private ImageView eKY;
    private ImageView eKZ;
    private a eKp;
    private TextView eLa;
    private AnimatorSet eLb;
    private AnimatorSet eLc;
    private AnimatorSet eLd;
    private AnimatorSet eLe;
    private AnimatorSet eLf;
    private AnimatorSet eLg;
    private AnimatorSet eLh;
    private boolean eLi;
    private Runnable eLj;
    private static final int aOT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
    private static final int SCREEN_WIDTH = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public d(Context context) {
        super(context);
        this.eLi = false;
        this.eLj = new e(this);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.pb_full_screen_floating_huaji_view, this);
        this.eKU = (ImageView) findViewById(w.h.pb_video_floating_big_huaji);
        this.eKV = (ImageView) findViewById(w.h.pb_video_floating_small_huaji1);
        this.eKW = (ImageView) findViewById(w.h.pb_video_floating_small_huaji2);
        this.eKX = (ImageView) findViewById(w.h.pb_video_floating_small_huaji3);
        this.eKY = (ImageView) findViewById(w.h.pb_video_floating_small_huaji4);
        this.eKZ = (ImageView) findViewById(w.h.pb_video_floating_small_huaji5);
        this.eLa = (TextView) findViewById(w.h.pb_video_floating_huaji_tip);
        this.eLa.setX((SCREEN_WIDTH - aOT) / 2);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aTd();
    }

    private void aTd() {
        this.eLb = new AnimatorSet();
        Drawable drawable = as.getDrawable(w.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eKU, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eKU, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eLb.playTogether(ofFloat, ofFloat2);
        this.eLc = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eKV, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eLc.play(ofFloat3);
        this.eLd = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eKW, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eLd.play(ofFloat4);
        this.eLe = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eKX, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eLe.play(ofFloat5);
        this.eLf = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eKY, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eLf.play(ofFloat6);
        this.eLg = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eKZ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eLg.play(ofFloat7);
        this.eLh = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eLa, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eLa, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eLa, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eLh.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        as.k(this, w.e.black_alpha60);
        as.c(this.eKU, w.g.icon_floor_bigpraised_floating);
        as.c(this.eKV, w.g.icon_floor_praised_floating);
        as.c(this.eKW, w.g.icon_floor_praised_floating);
        as.c(this.eKX, w.g.icon_floor_praised_floating);
        as.c(this.eKY, w.g.icon_floor_praised_floating);
        as.c(this.eKZ, w.g.icon_floor_praised_floating);
        as.i(this.eLa, w.e.cp_cont_i);
    }

    public void startAnimation(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eLi) {
            this.eLi = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eLj, 2000L);
            this.eLb.start();
            this.eLc.start();
            this.eLd.start();
            this.eLe.start();
            this.eLf.start();
            this.eLg.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTe() {
        this.eLi = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eKp != null) {
            this.eKp.onAnimationEnd();
        }
        removeCallbacks(this.eLj);
    }

    public void stopAnimation() {
        if (this.eLi) {
            aTe();
            this.eLb.cancel();
            this.eLc.cancel();
            this.eLd.cancel();
            this.eLe.cancel();
            this.eLf.cancel();
            this.eLg.cancel();
            this.eLh.cancel();
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
        this.eKp = aVar;
    }
}
