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
    private a eTu;
    private ImageView eUa;
    private ImageView eUb;
    private ImageView eUc;
    private ImageView eUd;
    private ImageView eUe;
    private ImageView eUf;
    private TextView eUg;
    private AnimatorSet eUh;
    private AnimatorSet eUi;
    private AnimatorSet eUj;
    private AnimatorSet eUk;
    private AnimatorSet eUl;
    private AnimatorSet eUm;
    private AnimatorSet eUn;
    private boolean eUo;
    private Runnable eUp;
    private static final int aRM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final int SCREEN_WIDTH = l.ad(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.eUo = false;
        this.eUp = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aUp();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.pb_full_screen_floating_huaji_view, this);
        this.eUa = (ImageView) findViewById(d.h.pb_video_floating_big_huaji);
        this.eUb = (ImageView) findViewById(d.h.pb_video_floating_small_huaji1);
        this.eUc = (ImageView) findViewById(d.h.pb_video_floating_small_huaji2);
        this.eUd = (ImageView) findViewById(d.h.pb_video_floating_small_huaji3);
        this.eUe = (ImageView) findViewById(d.h.pb_video_floating_small_huaji4);
        this.eUf = (ImageView) findViewById(d.h.pb_video_floating_small_huaji5);
        this.eUg = (TextView) findViewById(d.h.pb_video_floating_huaji_tip);
        this.eUg.setX((SCREEN_WIDTH - aRM) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aUo();
    }

    private void aUo() {
        this.eUh = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.g.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eUa, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eUa, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.eUh.playTogether(ofFloat, ofFloat2);
        this.eUi = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eUb, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.eUi.play(ofFloat3);
        this.eUj = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.eUc, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.eUj.play(ofFloat4);
        this.eUk = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.eUd, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.eUk.play(ofFloat5);
        this.eUl = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.eUe, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.eUl.play(ofFloat6);
        this.eUm = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.eUf, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.eUm.play(ofFloat7);
        this.eUn = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.eUg, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.eUg, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.eUg, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.eUn.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.black_alpha60);
        aj.c(this.eUa, d.g.icon_floor_bigpraised_floating);
        aj.c(this.eUb, d.g.icon_floor_praised_floating);
        aj.c(this.eUc, d.g.icon_floor_praised_floating);
        aj.c(this.eUd, d.g.icon_floor_praised_floating);
        aj.c(this.eUe, d.g.icon_floor_praised_floating);
        aj.c(this.eUf, d.g.icon_floor_praised_floating);
        aj.i(this.eUg, d.e.cp_cont_i);
    }

    public void jX(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.eUo) {
            this.eUo = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.eUp, 2000L);
            this.eUh.start();
            this.eUi.start();
            this.eUj.start();
            this.eUk.start();
            this.eUl.start();
            this.eUm.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUp() {
        this.eUo = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.eTu != null) {
            this.eTu.onAnimationEnd();
        }
        removeCallbacks(this.eUp);
    }

    public void stopAnimation() {
        if (this.eUo) {
            aUp();
            this.eUh.cancel();
            this.eUi.cancel();
            this.eUj.cancel();
            this.eUk.cancel();
            this.eUl.cancel();
            this.eUm.cancel();
            this.eUn.cancel();
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
        this.eTu = aVar;
    }
}
