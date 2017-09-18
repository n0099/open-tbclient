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
    private a eZz;
    private ImageView fae;
    private ImageView faf;
    private ImageView fag;
    private ImageView fah;
    private ImageView fai;
    private ImageView faj;
    private TextView fak;
    private AnimatorSet fal;
    private AnimatorSet fam;
    private AnimatorSet fan;
    private AnimatorSet fao;
    private AnimatorSet fap;
    private AnimatorSet faq;
    private AnimatorSet far;
    private boolean fas;
    private Runnable fat;
    private static final int aQX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = k.ae(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fas = false;
        this.fat = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aWl();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.fae = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.faf = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.fag = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.fah = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.fai = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.faj = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.fak = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.fak.setX((SCREEN_WIDTH - aQX) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aWk();
    }

    private void aWk() {
        this.fal = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fae, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fae, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fal.playTogether(ofFloat, ofFloat2);
        this.fam = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.faf, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fam.play(ofFloat3);
        this.fan = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fag, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fan.play(ofFloat4);
        this.fao = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fah, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fao.play(ofFloat5);
        this.fap = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fai, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fap.play(ofFloat6);
        this.faq = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.faj, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.faq.play(ofFloat7);
        this.far = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fak, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fak, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fak, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.far.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.black_alpha60);
        aj.c(this.fae, d.g.icon_floor_bigpraised_floating);
        aj.c(this.faf, d.g.icon_floor_praised_floating);
        aj.c(this.fag, d.g.icon_floor_praised_floating);
        aj.c(this.fah, d.g.icon_floor_praised_floating);
        aj.c(this.fai, d.g.icon_floor_praised_floating);
        aj.c(this.faj, d.g.icon_floor_praised_floating);
        aj.i(this.fak, d.e.cp_cont_i);
    }

    public void kj(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fas) {
            this.fas = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fat, 2000L);
            this.fal.start();
            this.fam.start();
            this.fan.start();
            this.fao.start();
            this.fap.start();
            this.faq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWl() {
        this.fas = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eZz != null) {
            this.eZz.onAnimationEnd();
        }
        removeCallbacks(this.fat);
    }

    public void stopAnimation() {
        if (this.fas) {
            aWl();
            this.fal.cancel();
            this.fam.cancel();
            this.fan.cancel();
            this.fao.cancel();
            this.fap.cancel();
            this.faq.cancel();
            this.far.cancel();
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
        this.eZz = aVar;
    }
}
