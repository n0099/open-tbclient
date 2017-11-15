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
    private ImageView fcN;
    private ImageView fcO;
    private ImageView fcP;
    private ImageView fcQ;
    private ImageView fcR;
    private ImageView fcS;
    private TextView fcT;
    private AnimatorSet fcU;
    private AnimatorSet fcV;
    private AnimatorSet fcW;
    private AnimatorSet fcX;
    private AnimatorSet fcY;
    private AnimatorSet fcZ;
    private a fcx;
    private AnimatorSet fda;
    private boolean fdb;
    private Runnable fdc;
    private static final int fcM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ac(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fdb = false;
        this.fdc = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aXz();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fcN = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fcO = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fcP = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fcQ = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fcR = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fcS = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fcT = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fcT.setX((SCREEN_WIDTH - fcM) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aXy();
    }

    private void aXy() {
        this.fcU = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fcN, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fcN, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fcU.playTogether(ofFloat, ofFloat2);
        this.fcV = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fcO, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fcV.play(ofFloat3);
        this.fcW = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fcP, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fcW.play(ofFloat4);
        this.fcX = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fcQ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fcX.play(ofFloat5);
        this.fcY = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fcR, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fcY.play(ofFloat6);
        this.fcZ = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fcS, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fcZ.play(ofFloat7);
        this.fda = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fcT, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fcT, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fcT, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fda.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0080d.black_alpha60);
        aj.c(this.fcN, d.f.icon_floor_bigpraised_floating);
        aj.c(this.fcO, d.f.icon_floor_praised_floating);
        aj.c(this.fcP, d.f.icon_floor_praised_floating);
        aj.c(this.fcQ, d.f.icon_floor_praised_floating);
        aj.c(this.fcR, d.f.icon_floor_praised_floating);
        aj.c(this.fcS, d.f.icon_floor_praised_floating);
        aj.i(this.fcT, d.C0080d.cp_cont_i);
    }

    public void jX(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fdb) {
            this.fdb = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fdc, 2000L);
            this.fcU.start();
            this.fcV.start();
            this.fcW.start();
            this.fcX.start();
            this.fcY.start();
            this.fcZ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        this.fdb = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fcx != null) {
            this.fcx.onAnimationEnd();
        }
        removeCallbacks(this.fdc);
    }

    public void stopAnimation() {
        if (this.fdb) {
            aXz();
            this.fcU.cancel();
            this.fcV.cancel();
            this.fcW.cancel();
            this.fcX.cancel();
            this.fcY.cancel();
            this.fcZ.cancel();
            this.fda.cancel();
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
        this.fcx = aVar;
    }
}
