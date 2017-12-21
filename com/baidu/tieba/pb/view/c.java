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
    private ImageView fkP;
    private ImageView fkQ;
    private ImageView fkR;
    private ImageView fkS;
    private ImageView fkT;
    private ImageView fkU;
    private TextView fkV;
    private AnimatorSet fkW;
    private AnimatorSet fkX;
    private AnimatorSet fkY;
    private AnimatorSet fkZ;
    private a fkv;
    private AnimatorSet fla;
    private AnimatorSet flb;
    private AnimatorSet flc;
    private boolean fld;
    private Runnable fle;
    private static final int fkO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ac(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fld = false;
        this.fle = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYG();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fkP = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fkQ = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fkR = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fkS = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fkT = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fkU = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fkV = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fkV.setX((SCREEN_WIDTH - fkO) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aYF();
    }

    private void aYF() {
        this.fkW = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fkP, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fkP, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fkW.playTogether(ofFloat, ofFloat2);
        this.fkX = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fkQ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fkX.play(ofFloat3);
        this.fkY = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fkR, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fkY.play(ofFloat4);
        this.fkZ = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fkS, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fkZ.play(ofFloat5);
        this.fla = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fkT, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fla.play(ofFloat6);
        this.flb = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fkU, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.flb.play(ofFloat7);
        this.flc = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fkV, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fkV, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fkV, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.flc.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0095d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.xE()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.fkP, i3);
        aj.c(this.fkQ, i2);
        aj.c(this.fkR, i2);
        aj.c(this.fkS, i2);
        aj.c(this.fkT, i2);
        aj.c(this.fkU, i2);
        aj.i(this.fkV, d.C0095d.cp_cont_i);
    }

    public void kv(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fld) {
            this.fld = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fle, 2000L);
            this.fkW.start();
            this.fkX.start();
            this.fkY.start();
            this.fkZ.start();
            this.fla.start();
            this.flb.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYG() {
        this.fld = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fkv != null) {
            this.fkv.onAnimationEnd();
        }
        removeCallbacks(this.fle);
    }

    public void stopAnimation() {
        if (this.fld) {
            aYG();
            this.fkW.cancel();
            this.fkX.cancel();
            this.fkY.cancel();
            this.fkZ.cancel();
            this.fla.cancel();
            this.flb.cancel();
            this.flc.cancel();
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
        this.fkv = aVar;
    }
}
