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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private a eYF;
    private ImageView eZk;
    private ImageView eZl;
    private ImageView eZm;
    private ImageView eZn;
    private ImageView eZo;
    private ImageView eZp;
    private TextView eZq;
    private AnimatorSet eZr;
    private AnimatorSet eZs;
    private AnimatorSet eZt;
    private AnimatorSet eZu;
    private AnimatorSet eZv;
    private AnimatorSet eZw;
    private AnimatorSet eZx;
    private boolean eZy;
    private Runnable eZz;
    private static final int aRa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = k.ad(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.eZy = false;
        this.eZz = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aWa();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.eZk = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.eZl = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.eZm = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.eZn = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.eZo = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.eZp = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.eZq = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.eZq.setX((SCREEN_WIDTH - aRa) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aVZ();
    }

    private void aVZ() {
        this.eZr = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eZk, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eZk, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eZr.playTogether(ofFloat, ofFloat2);
        this.eZs = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eZl, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eZs.play(ofFloat3);
        this.eZt = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eZm, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eZt.play(ofFloat4);
        this.eZu = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eZn, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eZu.play(ofFloat5);
        this.eZv = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eZo, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eZv.play(ofFloat6);
        this.eZw = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eZp, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eZw.play(ofFloat7);
        this.eZx = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eZq, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eZq, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eZq, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eZx.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.black_alpha60);
        aj.c(this.eZk, d.g.icon_floor_bigpraised_floating);
        aj.c(this.eZl, d.g.icon_floor_praised_floating);
        aj.c(this.eZm, d.g.icon_floor_praised_floating);
        aj.c(this.eZn, d.g.icon_floor_praised_floating);
        aj.c(this.eZo, d.g.icon_floor_praised_floating);
        aj.c(this.eZp, d.g.icon_floor_praised_floating);
        aj.i(this.eZq, d.e.cp_cont_i);
    }

    public void ki(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eZy) {
            this.eZy = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eZz, 2000L);
            this.eZr.start();
            this.eZs.start();
            this.eZt.start();
            this.eZu.start();
            this.eZv.start();
            this.eZw.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWa() {
        this.eZy = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eYF != null) {
            this.eYF.onAnimationEnd();
        }
        removeCallbacks(this.eZz);
    }

    public void stopAnimation() {
        if (this.eZy) {
            aWa();
            this.eZr.cancel();
            this.eZs.cancel();
            this.eZt.cancel();
            this.eZu.cancel();
            this.eZv.cancel();
            this.eZw.cancel();
            this.eZx.cancel();
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
        this.eYF = aVar;
    }
}
