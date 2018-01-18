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
/* loaded from: classes2.dex */
public class c extends RelativeLayout {
    private a fYS;
    private boolean fZA;
    private Runnable fZB;
    private ImageView fZm;
    private ImageView fZn;
    private ImageView fZo;
    private ImageView fZp;
    private ImageView fZq;
    private ImageView fZr;
    private TextView fZs;
    private AnimatorSet fZt;
    private AnimatorSet fZu;
    private AnimatorSet fZv;
    private AnimatorSet fZw;
    private AnimatorSet fZx;
    private AnimatorSet fZy;
    private AnimatorSet fZz;
    private static final int fZl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ao(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fZA = false;
        this.fZB = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bfX();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fZm = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fZn = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fZo = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fZp = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fZq = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fZr = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fZs = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fZs.setX((SCREEN_WIDTH - fZl) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bfW();
    }

    private void bfW() {
        this.fZt = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fZm, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fZm, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fZt.playTogether(ofFloat, ofFloat2);
        this.fZu = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fZn, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fZu.play(ofFloat3);
        this.fZv = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fZo, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fZv.play(ofFloat4);
        this.fZw = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fZp, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fZw.play(ofFloat5);
        this.fZx = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fZq, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fZx.play(ofFloat6);
        this.fZy = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fZr, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fZy.play(ofFloat7);
        this.fZz = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fZs, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fZs, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fZs, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fZz.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0107d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.EU()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.fZm, i3);
        aj.c(this.fZn, i2);
        aj.c(this.fZo, i2);
        aj.c(this.fZp, i2);
        aj.c(this.fZq, i2);
        aj.c(this.fZr, i2);
        aj.r(this.fZs, d.C0107d.cp_cont_i);
    }

    public void la(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fZA) {
            this.fZA = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fZB, 2000L);
            this.fZt.start();
            this.fZu.start();
            this.fZv.start();
            this.fZw.start();
            this.fZx.start();
            this.fZy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfX() {
        this.fZA = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fYS != null) {
            this.fYS.onAnimationEnd();
        }
        removeCallbacks(this.fZB);
    }

    public void stopAnimation() {
        if (this.fZA) {
            bfX();
            this.fZt.cancel();
            this.fZu.cancel();
            this.fZv.cancel();
            this.fZw.cancel();
            this.fZx.cancel();
            this.fZy.cancel();
            this.fZz.cancel();
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
        this.fYS = aVar;
    }
}
