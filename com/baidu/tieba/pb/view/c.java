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
    private ImageView fXL;
    private ImageView fXM;
    private ImageView fXN;
    private ImageView fXO;
    private ImageView fXP;
    private ImageView fXQ;
    private TextView fXR;
    private AnimatorSet fXS;
    private AnimatorSet fXT;
    private AnimatorSet fXU;
    private AnimatorSet fXV;
    private AnimatorSet fXW;
    private AnimatorSet fXX;
    private AnimatorSet fXY;
    private boolean fXZ;
    private a fXr;
    private Runnable fYa;
    private static final int fXK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ao(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fXZ = false;
        this.fYa = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bfW();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fXL = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fXM = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fXN = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fXO = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fXP = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fXQ = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fXR = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fXR.setX((SCREEN_WIDTH - fXK) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bfV();
    }

    private void bfV() {
        this.fXS = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fXL, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fXL, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fXS.playTogether(ofFloat, ofFloat2);
        this.fXT = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fXM, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fXT.play(ofFloat3);
        this.fXU = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fXN, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fXU.play(ofFloat4);
        this.fXV = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fXO, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fXV.play(ofFloat5);
        this.fXW = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fXP, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fXW.play(ofFloat6);
        this.fXX = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fXQ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fXX.play(ofFloat7);
        this.fXY = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fXR, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fXR, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fXR, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fXY.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0108d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.Fd()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.fXL, i3);
        aj.c(this.fXM, i2);
        aj.c(this.fXN, i2);
        aj.c(this.fXO, i2);
        aj.c(this.fXP, i2);
        aj.c(this.fXQ, i2);
        aj.r(this.fXR, d.C0108d.cp_cont_i);
    }

    public void kY(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fXZ) {
            this.fXZ = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fYa, 2000L);
            this.fXS.start();
            this.fXT.start();
            this.fXU.start();
            this.fXV.start();
            this.fXW.start();
            this.fXX.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfW() {
        this.fXZ = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fXr != null) {
            this.fXr.onAnimationEnd();
        }
        removeCallbacks(this.fYa);
    }

    public void stopAnimation() {
        if (this.fXZ) {
            bfW();
            this.fXS.cancel();
            this.fXT.cancel();
            this.fXU.cancel();
            this.fXV.cancel();
            this.fXW.cancel();
            this.fXX.cancel();
            this.fXY.cancel();
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
        this.fXr = aVar;
    }
}
