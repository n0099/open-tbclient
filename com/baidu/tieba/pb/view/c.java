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
    private ImageView gcO;
    private ImageView gcP;
    private ImageView gcQ;
    private ImageView gcR;
    private ImageView gcS;
    private ImageView gcT;
    private TextView gcU;
    private AnimatorSet gcV;
    private AnimatorSet gcW;
    private AnimatorSet gcX;
    private AnimatorSet gcY;
    private AnimatorSet gcZ;
    private a gcu;
    private AnimatorSet gda;
    private AnimatorSet gdb;
    private boolean gdc;
    private Runnable gdd;
    private static final int gcN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ao(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.gdc = false;
        this.gdd = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bhC();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.gcO = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.gcP = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.gcQ = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.gcR = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.gcS = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.gcT = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.gcU = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.gcU.setX((SCREEN_WIDTH - gcN) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bhB();
    }

    private void bhB() {
        this.gcV = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gcO, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gcO, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.gcV.playTogether(ofFloat, ofFloat2);
        this.gcW = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gcP, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.gcW.play(ofFloat3);
        this.gcX = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gcQ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.gcX.play(ofFloat4);
        this.gcY = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gcR, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.gcY.play(ofFloat5);
        this.gcZ = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gcS, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.gcZ.play(ofFloat6);
        this.gda = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.gcT, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.gda.play(ofFloat7);
        this.gdb = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.gcU, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.gcU, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.gcU, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.gdb.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0140d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.Fr()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.gcO, i3);
        aj.c(this.gcP, i2);
        aj.c(this.gcQ, i2);
        aj.c(this.gcR, i2);
        aj.c(this.gcS, i2);
        aj.c(this.gcT, i2);
        aj.r(this.gcU, d.C0140d.cp_cont_i);
    }

    public void ll(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.gdc) {
            this.gdc = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.gdd, 2000L);
            this.gcV.start();
            this.gcW.start();
            this.gcX.start();
            this.gcY.start();
            this.gcZ.start();
            this.gda.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhC() {
        this.gdc = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.gcu != null) {
            this.gcu.onAnimationEnd();
        }
        removeCallbacks(this.gdd);
    }

    public void stopAnimation() {
        if (this.gdc) {
            bhC();
            this.gcV.cancel();
            this.gcW.cancel();
            this.gcX.cancel();
            this.gcY.cancel();
            this.gcZ.cancel();
            this.gda.cancel();
            this.gdb.cancel();
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
        this.gcu = aVar;
    }
}
