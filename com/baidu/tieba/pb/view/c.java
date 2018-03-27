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
    private ImageView gcT;
    private ImageView gcU;
    private ImageView gcV;
    private ImageView gcW;
    private ImageView gcX;
    private ImageView gcY;
    private TextView gcZ;
    private a gcz;
    private AnimatorSet gda;
    private AnimatorSet gdb;
    private AnimatorSet gdc;
    private AnimatorSet gdd;
    private AnimatorSet gde;
    private AnimatorSet gdf;
    private AnimatorSet gdg;
    private boolean gdh;
    private Runnable gdi;
    private static final int gcS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ao(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.gdh = false;
        this.gdi = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bhC();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.gcT = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.gcU = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.gcV = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.gcW = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.gcX = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.gcY = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.gcZ = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.gcZ.setX((SCREEN_WIDTH - gcS) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bhB();
    }

    private void bhB() {
        this.gda = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gcT, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gcT, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.gda.playTogether(ofFloat, ofFloat2);
        this.gdb = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gcU, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.gdb.play(ofFloat3);
        this.gdc = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gcV, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.gdc.play(ofFloat4);
        this.gdd = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gcW, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.gdd.play(ofFloat5);
        this.gde = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gcX, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.gde.play(ofFloat6);
        this.gdf = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.gcY, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.gdf.play(ofFloat7);
        this.gdg = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.gcZ, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.gcZ, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.gcZ, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.gdg.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0141d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.Fr()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.gcT, i3);
        aj.c(this.gcU, i2);
        aj.c(this.gcV, i2);
        aj.c(this.gcW, i2);
        aj.c(this.gcX, i2);
        aj.c(this.gcY, i2);
        aj.r(this.gcZ, d.C0141d.cp_cont_i);
    }

    public void lq(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.gdh) {
            this.gdh = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.gdi, 2000L);
            this.gda.start();
            this.gdb.start();
            this.gdc.start();
            this.gdd.start();
            this.gde.start();
            this.gdf.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhC() {
        this.gdh = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.gcz != null) {
            this.gcz.onAnimationEnd();
        }
        removeCallbacks(this.gdi);
    }

    public void stopAnimation() {
        if (this.gdh) {
            bhC();
            this.gda.cancel();
            this.gdb.cancel();
            this.gdc.cancel();
            this.gdd.cancel();
            this.gde.cancel();
            this.gdf.cancel();
            this.gdg.cancel();
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
        this.gcz = aVar;
    }
}
