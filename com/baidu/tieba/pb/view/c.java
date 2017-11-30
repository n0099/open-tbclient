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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private ImageView fjM;
    private ImageView fjN;
    private ImageView fjO;
    private ImageView fjP;
    private ImageView fjQ;
    private ImageView fjR;
    private TextView fjS;
    private AnimatorSet fjT;
    private AnimatorSet fjU;
    private AnimatorSet fjV;
    private AnimatorSet fjW;
    private AnimatorSet fjX;
    private AnimatorSet fjY;
    private AnimatorSet fjZ;
    private a fjs;
    private boolean fka;
    private Runnable fkb;
    private static final int fjL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ac(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fka = false;
        this.fkb = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYy();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fjM = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fjN = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fjO = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fjP = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fjQ = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fjR = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fjS = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fjS.setX((SCREEN_WIDTH - fjL) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aYx();
    }

    private void aYx() {
        this.fjT = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fjM, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fjM, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fjT.playTogether(ofFloat, ofFloat2);
        this.fjU = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fjN, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fjU.play(ofFloat3);
        this.fjV = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fjO, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fjV.play(ofFloat4);
        this.fjW = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fjP, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fjW.play(ofFloat5);
        this.fjX = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fjQ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fjX.play(ofFloat6);
        this.fjY = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fjR, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fjY.play(ofFloat7);
        this.fjZ = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fjS, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fjS, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fjS, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fjZ.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0082d.black_alpha60);
        aj.c(this.fjM, d.f.icon_floor_bigpraised_floating);
        aj.c(this.fjN, d.f.icon_floor_praised_floating);
        aj.c(this.fjO, d.f.icon_floor_praised_floating);
        aj.c(this.fjP, d.f.icon_floor_praised_floating);
        aj.c(this.fjQ, d.f.icon_floor_praised_floating);
        aj.c(this.fjR, d.f.icon_floor_praised_floating);
        aj.i(this.fjS, d.C0082d.cp_cont_i);
    }

    public void ku(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fka) {
            this.fka = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fkb, 2000L);
            this.fjT.start();
            this.fjU.start();
            this.fjV.start();
            this.fjW.start();
            this.fjX.start();
            this.fjY.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYy() {
        this.fka = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fjs != null) {
            this.fjs.onAnimationEnd();
        }
        removeCallbacks(this.fkb);
    }

    public void stopAnimation() {
        if (this.fka) {
            aYy();
            this.fjT.cancel();
            this.fjU.cancel();
            this.fjV.cancel();
            this.fjW.cancel();
            this.fjX.cancel();
            this.fjY.cancel();
            this.fjZ.cancel();
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
        this.fjs = aVar;
    }
}
