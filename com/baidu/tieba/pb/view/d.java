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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends RelativeLayout {
    private static final int aND = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
    private static final int eBw = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());
    private a eAR;
    private ImageView eBA;
    private ImageView eBB;
    private ImageView eBC;
    private TextView eBD;
    private AnimatorSet eBE;
    private AnimatorSet eBF;
    private AnimatorSet eBG;
    private AnimatorSet eBH;
    private AnimatorSet eBI;
    private AnimatorSet eBJ;
    private AnimatorSet eBK;
    private boolean eBL;
    private Runnable eBM;
    private ImageView eBx;
    private ImageView eBy;
    private ImageView eBz;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public d(Context context) {
        super(context);
        this.eBL = false;
        this.eBM = new e(this);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.pb_full_screen_floating_huaji_view, this);
        this.eBx = (ImageView) findViewById(w.h.pb_video_floating_big_huaji);
        this.eBy = (ImageView) findViewById(w.h.pb_video_floating_small_huaji1);
        this.eBz = (ImageView) findViewById(w.h.pb_video_floating_small_huaji2);
        this.eBA = (ImageView) findViewById(w.h.pb_video_floating_small_huaji3);
        this.eBB = (ImageView) findViewById(w.h.pb_video_floating_small_huaji4);
        this.eBC = (ImageView) findViewById(w.h.pb_video_floating_small_huaji5);
        this.eBD = (TextView) findViewById(w.h.pb_video_floating_huaji_tip);
        this.eBD.setX((eBw - aND) / 2);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aPe();
    }

    private void aPe() {
        this.eBE = new AnimatorSet();
        Drawable drawable = aq.getDrawable(w.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (eBw - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eBx, "X", eBw, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eBx, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eBE.playTogether(ofFloat, ofFloat2);
        this.eBF = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eBy, "X", eBw, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eBF.play(ofFloat3);
        this.eBG = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eBz, "X", eBw, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eBG.play(ofFloat4);
        this.eBH = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eBA, "X", eBw, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eBH.play(ofFloat5);
        this.eBI = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eBB, "X", eBw, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eBI.play(ofFloat6);
        this.eBJ = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eBC, "X", eBw, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eBJ.play(ofFloat7);
        this.eBK = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eBD, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eBD, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eBD, "X", eBw / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eBK.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.black_alpha60);
        aq.c(this.eBx, w.g.icon_floor_bigpraised_floating);
        aq.c(this.eBy, w.g.icon_floor_praised_floating);
        aq.c(this.eBz, w.g.icon_floor_praised_floating);
        aq.c(this.eBA, w.g.icon_floor_praised_floating);
        aq.c(this.eBB, w.g.icon_floor_praised_floating);
        aq.c(this.eBC, w.g.icon_floor_praised_floating);
        aq.i(this.eBD, w.e.cp_cont_i);
    }

    public void startAnimation(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eBL) {
            this.eBL = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eBM, 2000L);
            this.eBE.start();
            this.eBF.start();
            this.eBG.start();
            this.eBH.start();
            this.eBI.start();
            this.eBJ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPf() {
        this.eBL = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eAR != null) {
            this.eAR.onAnimationEnd();
        }
        removeCallbacks(this.eBM);
    }

    public void stopAnimation() {
        if (this.eBL) {
            aPf();
            this.eBE.cancel();
            this.eBF.cancel();
            this.eBG.cancel();
            this.eBH.cancel();
            this.eBI.cancel();
            this.eBJ.cancel();
            this.eBK.cancel();
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
        this.eAR = aVar;
    }
}
