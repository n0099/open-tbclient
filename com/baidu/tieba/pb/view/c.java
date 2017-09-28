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
    private a eTI;
    private AnimatorSet eUA;
    private AnimatorSet eUB;
    private boolean eUC;
    private Runnable eUD;
    private ImageView eUo;
    private ImageView eUp;
    private ImageView eUq;
    private ImageView eUr;
    private ImageView eUs;
    private ImageView eUt;
    private TextView eUu;
    private AnimatorSet eUv;
    private AnimatorSet eUw;
    private AnimatorSet eUx;
    private AnimatorSet eUy;
    private AnimatorSet eUz;
    private static final int aRZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = l.ad(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.eUC = false;
        this.eUD = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aUu();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.eUo = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.eUp = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.eUq = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.eUr = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.eUs = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.eUt = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.eUu = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.eUu.setX((SCREEN_WIDTH - aRZ) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aUt();
    }

    private void aUt() {
        this.eUv = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eUo, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eUo, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eUv.playTogether(ofFloat, ofFloat2);
        this.eUw = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eUp, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eUw.play(ofFloat3);
        this.eUx = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eUq, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eUx.play(ofFloat4);
        this.eUy = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eUr, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eUy.play(ofFloat5);
        this.eUz = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eUs, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eUz.play(ofFloat6);
        this.eUA = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eUt, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eUA.play(ofFloat7);
        this.eUB = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eUu, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eUu, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eUu, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eUB.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.black_alpha60);
        aj.c(this.eUo, d.g.icon_floor_bigpraised_floating);
        aj.c(this.eUp, d.g.icon_floor_praised_floating);
        aj.c(this.eUq, d.g.icon_floor_praised_floating);
        aj.c(this.eUr, d.g.icon_floor_praised_floating);
        aj.c(this.eUs, d.g.icon_floor_praised_floating);
        aj.c(this.eUt, d.g.icon_floor_praised_floating);
        aj.i(this.eUu, d.e.cp_cont_i);
    }

    public void jY(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eUC) {
            this.eUC = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eUD, 2000L);
            this.eUv.start();
            this.eUw.start();
            this.eUx.start();
            this.eUy.start();
            this.eUz.start();
            this.eUA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUu() {
        this.eUC = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eTI != null) {
            this.eTI.onAnimationEnd();
        }
        removeCallbacks(this.eUD);
    }

    public void stopAnimation() {
        if (this.eUC) {
            aUu();
            this.eUv.cancel();
            this.eUw.cancel();
            this.eUx.cancel();
            this.eUy.cancel();
            this.eUz.cancel();
            this.eUA.cancel();
            this.eUB.cancel();
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
        this.eTI = aVar;
    }
}
