package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private a lZM;
    private boolean mIsAnimating;
    private Runnable mRunnable;
    private AnimatorSet meA;
    private AnimatorSet meB;
    private AnimatorSet meC;
    private AnimatorSet meD;
    private Runnable meE;
    private Runnable meF;
    private ImageView meq;
    private ImageView mer;
    private ImageView mes;
    private ImageView met;
    private ImageView meu;
    private ImageView mev;
    private TextView mew;
    private AnimatorSet mex;
    private AnimatorSet mey;
    private AnimatorSet mez;
    private static final int gpq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private static final int ajr = l.getEquipmentWidth(TbadkCoreApplication.getInst());

    /* loaded from: classes22.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.mIsAnimating = false;
        this.meE = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dxp();
            }
        };
        this.meF = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAnimating = false;
        this.meE = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dxp();
            }
        };
        this.meF = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsAnimating = false;
        this.meE = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dxp();
            }
        };
        this.meF = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.pb_full_screen_floating_huaji_view, this);
        this.meq = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
        this.mer = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
        this.mes = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
        this.met = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
        this.meu = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
        this.mev = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
        this.mew = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
        this.mew.setX((ajr - gpq) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        cpJ();
    }

    private void cpJ() {
        this.mex = new AnimatorSet();
        Drawable drawable = ap.getDrawable(R.drawable.icon_floor_bigpraised_floating);
        int intrinsicWidth = (ajr - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.meq, "X", ajr, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.meq, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.mex.playTogether(ofFloat, ofFloat2);
        this.mey = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mer, "X", ajr, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.mey.play(ofFloat3);
        this.mez = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mes, "X", ajr, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.mez.play(ofFloat4);
        this.meA = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.met, "X", ajr, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.meA.play(ofFloat5);
        this.meB = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.meu, "X", ajr, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.meB.play(ofFloat6);
        this.meC = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mev, "X", ajr, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.meC.play(ofFloat7);
        this.meD = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.mew, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.mew, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.mew, "X", ajr / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.meD.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.black_alpha60);
        int i2 = R.drawable.icon_floor_praised_floating;
        int i3 = R.drawable.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.bxc()) {
            i2 = R.drawable.icon_floor_praised_floating_xmas;
            i3 = R.drawable.icon_floor_bigpraised_floating_xmas;
        }
        ap.setImageResource(this.meq, i3);
        ap.setImageResource(this.mer, i2);
        ap.setImageResource(this.mes, i2);
        ap.setImageResource(this.met, i2);
        ap.setImageResource(this.meu, i2);
        ap.setImageResource(this.mev, i2);
        ap.setViewTextColor(this.mew, R.color.CAM_X0101);
    }

    public void wm(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.mIsAnimating) {
            this.mIsAnimating = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.meE, 2000L);
            this.mex.start();
            this.mey.start();
            this.mez.start();
            this.meA.start();
            this.meB.start();
            this.meC.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxp() {
        this.mIsAnimating = false;
        com.baidu.adp.lib.f.e.mY().post(this.meF);
        if (this.lZM != null) {
            this.lZM.onAnimationEnd();
        }
        removeCallbacks(this.meE);
    }

    public void stopAnimation() {
        if (this.mIsAnimating) {
            dxp();
            this.mex.cancel();
            this.mey.cancel();
            this.mez.cancel();
            this.meA.cancel();
            this.meB.cancel();
            this.meC.cancel();
            this.meD.cancel();
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
        this.lZM = aVar;
    }
}
