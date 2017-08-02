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
    private a eWQ;
    private ImageView eXA;
    private TextView eXB;
    private AnimatorSet eXC;
    private AnimatorSet eXD;
    private AnimatorSet eXE;
    private AnimatorSet eXF;
    private AnimatorSet eXG;
    private AnimatorSet eXH;
    private AnimatorSet eXI;
    private boolean eXJ;
    private Runnable eXK;
    private ImageView eXv;
    private ImageView eXw;
    private ImageView eXx;
    private ImageView eXy;
    private ImageView eXz;
    private static final int aQc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = k.af(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.eXJ = false;
        this.eXK = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aWb();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.eXv = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.eXw = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.eXx = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.eXy = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.eXz = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.eXA = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.eXB = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.eXB.setX((SCREEN_WIDTH - aQc) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aWa();
    }

    private void aWa() {
        this.eXC = new AnimatorSet();
        Drawable drawable = ai.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eXv, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eXv, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eXC.playTogether(ofFloat, ofFloat2);
        this.eXD = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eXw, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eXD.play(ofFloat3);
        this.eXE = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eXx, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eXE.play(ofFloat4);
        this.eXF = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eXy, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eXF.play(ofFloat5);
        this.eXG = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eXz, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eXG.play(ofFloat6);
        this.eXH = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eXA, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eXH.play(ofFloat7);
        this.eXI = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eXB, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eXB, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eXB, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eXI.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.black_alpha60);
        ai.c(this.eXv, d.g.icon_floor_bigpraised_floating);
        ai.c(this.eXw, d.g.icon_floor_praised_floating);
        ai.c(this.eXx, d.g.icon_floor_praised_floating);
        ai.c(this.eXy, d.g.icon_floor_praised_floating);
        ai.c(this.eXz, d.g.icon_floor_praised_floating);
        ai.c(this.eXA, d.g.icon_floor_praised_floating);
        ai.i(this.eXB, d.e.cp_cont_i);
    }

    public void startAnimation(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eXJ) {
            this.eXJ = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eXK, 2000L);
            this.eXC.start();
            this.eXD.start();
            this.eXE.start();
            this.eXF.start();
            this.eXG.start();
            this.eXH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        this.eXJ = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eWQ != null) {
            this.eWQ.onAnimationEnd();
        }
        removeCallbacks(this.eXK);
    }

    public void stopAnimation() {
        if (this.eXJ) {
            aWb();
            this.eXC.cancel();
            this.eXD.cancel();
            this.eXE.cancel();
            this.eXF.cancel();
            this.eXG.cancel();
            this.eXH.cancel();
            this.eXI.cancel();
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
        this.eWQ = aVar;
    }
}
