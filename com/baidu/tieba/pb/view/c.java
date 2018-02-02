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
    private ImageView fZH;
    private ImageView fZI;
    private ImageView fZJ;
    private ImageView fZK;
    private ImageView fZL;
    private ImageView fZM;
    private TextView fZN;
    private AnimatorSet fZO;
    private AnimatorSet fZP;
    private AnimatorSet fZQ;
    private AnimatorSet fZR;
    private AnimatorSet fZS;
    private AnimatorSet fZT;
    private AnimatorSet fZU;
    private boolean fZV;
    private Runnable fZW;
    private a fZn;
    private static final int fZG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ao(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fZV = false;
        this.fZW = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bgc();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fZH = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fZI = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fZJ = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fZK = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fZL = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fZM = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fZN = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fZN.setX((SCREEN_WIDTH - fZG) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bgb();
    }

    private void bgb() {
        this.fZO = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fZH, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fZH, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fZO.playTogether(ofFloat, ofFloat2);
        this.fZP = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fZI, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fZP.play(ofFloat3);
        this.fZQ = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fZJ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fZQ.play(ofFloat4);
        this.fZR = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fZK, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fZR.play(ofFloat5);
        this.fZS = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fZL, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fZS.play(ofFloat6);
        this.fZT = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fZM, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fZT.play(ofFloat7);
        this.fZU = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fZN, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fZN, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fZN, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fZU.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0108d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.EW()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.fZH, i3);
        aj.c(this.fZI, i2);
        aj.c(this.fZJ, i2);
        aj.c(this.fZK, i2);
        aj.c(this.fZL, i2);
        aj.c(this.fZM, i2);
        aj.r(this.fZN, d.C0108d.cp_cont_i);
    }

    public void ld(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fZV) {
            this.fZV = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fZW, 2000L);
            this.fZO.start();
            this.fZP.start();
            this.fZQ.start();
            this.fZR.start();
            this.fZS.start();
            this.fZT.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgc() {
        this.fZV = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fZn != null) {
            this.fZn.onAnimationEnd();
        }
        removeCallbacks(this.fZW);
    }

    public void stopAnimation() {
        if (this.fZV) {
            bgc();
            this.fZO.cancel();
            this.fZP.cancel();
            this.fZQ.cancel();
            this.fZR.cancel();
            this.fZS.cancel();
            this.fZT.cancel();
            this.fZU.cancel();
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
        this.fZn = aVar;
    }
}
