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
    private ImageView eYH;
    private ImageView eYI;
    private ImageView eYJ;
    private ImageView eYK;
    private ImageView eYL;
    private ImageView eYM;
    private TextView eYN;
    private AnimatorSet eYO;
    private AnimatorSet eYP;
    private AnimatorSet eYQ;
    private AnimatorSet eYR;
    private AnimatorSet eYS;
    private AnimatorSet eYT;
    private AnimatorSet eYU;
    private boolean eYV;
    private Runnable eYW;
    private a eYc;
    private static final int aRp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = k.ag(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.eYV = false;
        this.eYW = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aWm();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.eYH = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.eYI = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.eYJ = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.eYK = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.eYL = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.eYM = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.eYN = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.eYN.setX((SCREEN_WIDTH - aRp) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aWl();
    }

    private void aWl() {
        this.eYO = new AnimatorSet();
        Drawable drawable = ai.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eYH, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eYH, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eYO.playTogether(ofFloat, ofFloat2);
        this.eYP = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eYI, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eYP.play(ofFloat3);
        this.eYQ = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eYJ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eYQ.play(ofFloat4);
        this.eYR = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eYK, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eYR.play(ofFloat5);
        this.eYS = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eYL, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eYS.play(ofFloat6);
        this.eYT = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eYM, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eYT.play(ofFloat7);
        this.eYU = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eYN, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eYN, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eYN, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eYU.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.black_alpha60);
        ai.c(this.eYH, d.g.icon_floor_bigpraised_floating);
        ai.c(this.eYI, d.g.icon_floor_praised_floating);
        ai.c(this.eYJ, d.g.icon_floor_praised_floating);
        ai.c(this.eYK, d.g.icon_floor_praised_floating);
        ai.c(this.eYL, d.g.icon_floor_praised_floating);
        ai.c(this.eYM, d.g.icon_floor_praised_floating);
        ai.i(this.eYN, d.e.cp_cont_i);
    }

    public void startAnimation(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eYV) {
            this.eYV = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eYW, 2000L);
            this.eYO.start();
            this.eYP.start();
            this.eYQ.start();
            this.eYR.start();
            this.eYS.start();
            this.eYT.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWm() {
        this.eYV = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eYc != null) {
            this.eYc.onAnimationEnd();
        }
        removeCallbacks(this.eYW);
    }

    public void stopAnimation() {
        if (this.eYV) {
            aWm();
            this.eYO.cancel();
            this.eYP.cancel();
            this.eYQ.cancel();
            this.eYR.cancel();
            this.eYS.cancel();
            this.eYT.cancel();
            this.eYU.cancel();
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
        this.eYc = aVar;
    }
}
