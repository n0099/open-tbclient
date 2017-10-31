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
    private AnimatorSet fcA;
    private AnimatorSet fcB;
    private AnimatorSet fcC;
    private AnimatorSet fcD;
    private AnimatorSet fcE;
    private boolean fcF;
    private Runnable fcG;
    private a fcb;
    private ImageView fcr;
    private ImageView fcs;
    private ImageView fct;
    private ImageView fcu;
    private ImageView fcv;
    private ImageView fcw;
    private TextView fcx;
    private AnimatorSet fcy;
    private AnimatorSet fcz;
    private static final int fcq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ac(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fcF = false;
        this.fcG = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aXr();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fcr = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fcs = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fct = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fcu = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fcv = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fcw = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fcx = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fcx.setX((SCREEN_WIDTH - fcq) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aXq();
    }

    private void aXq() {
        this.fcy = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fcr, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fcr, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fcy.playTogether(ofFloat, ofFloat2);
        this.fcz = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fcs, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fcz.play(ofFloat3);
        this.fcA = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fct, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fcA.play(ofFloat4);
        this.fcB = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fcu, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fcB.play(ofFloat5);
        this.fcC = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fcv, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fcC.play(ofFloat6);
        this.fcD = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fcw, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fcD.play(ofFloat7);
        this.fcE = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fcx, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fcx, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fcx, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fcE.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0080d.black_alpha60);
        aj.c(this.fcr, d.f.icon_floor_bigpraised_floating);
        aj.c(this.fcs, d.f.icon_floor_praised_floating);
        aj.c(this.fct, d.f.icon_floor_praised_floating);
        aj.c(this.fcu, d.f.icon_floor_praised_floating);
        aj.c(this.fcv, d.f.icon_floor_praised_floating);
        aj.c(this.fcw, d.f.icon_floor_praised_floating);
        aj.i(this.fcx, d.C0080d.cp_cont_i);
    }

    public void jR(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fcF) {
            this.fcF = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fcG, 2000L);
            this.fcy.start();
            this.fcz.start();
            this.fcA.start();
            this.fcB.start();
            this.fcC.start();
            this.fcD.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXr() {
        this.fcF = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fcb != null) {
            this.fcb.onAnimationEnd();
        }
        removeCallbacks(this.fcG);
    }

    public void stopAnimation() {
        if (this.fcF) {
            aXr();
            this.fcy.cancel();
            this.fcz.cancel();
            this.fcA.cancel();
            this.fcB.cancel();
            this.fcC.cancel();
            this.fcD.cancel();
            this.fcE.cancel();
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
        this.fcb = aVar;
    }
}
