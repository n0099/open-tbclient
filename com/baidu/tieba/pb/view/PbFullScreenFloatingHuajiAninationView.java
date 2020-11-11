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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private a lLu;
    private ImageView lPV;
    private ImageView lPW;
    private ImageView lPX;
    private ImageView lPY;
    private ImageView lPZ;
    private ImageView lQa;
    private TextView lQb;
    private AnimatorSet lQc;
    private AnimatorSet lQd;
    private AnimatorSet lQe;
    private AnimatorSet lQf;
    private AnimatorSet lQg;
    private AnimatorSet lQh;
    private AnimatorSet lQi;
    private Runnable lQj;
    private Runnable lQk;
    private boolean mIsAnimating;
    private Runnable mRunnable;
    private static final int ghx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst());

    /* loaded from: classes22.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.mIsAnimating = false;
        this.lQj = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dsw();
            }
        };
        this.lQk = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.lQj = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dsw();
            }
        };
        this.lQk = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.lQj = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dsw();
            }
        };
        this.lQk = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.lPV = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
        this.lPW = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
        this.lPX = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
        this.lPY = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
        this.lPZ = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
        this.lQa = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
        this.lQb = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
        this.lQb.setX((aip - ghx) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        cma();
    }

    private void cma() {
        this.lQc = new AnimatorSet();
        Drawable drawable = ap.getDrawable(R.drawable.icon_floor_bigpraised_floating);
        int intrinsicWidth = (aip - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.lPV, "X", aip, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.lPV, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.lQc.playTogether(ofFloat, ofFloat2);
        this.lQd = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.lPW, "X", aip, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.lQd.play(ofFloat3);
        this.lQe = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.lPX, "X", aip, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.lQe.play(ofFloat4);
        this.lQf = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.lPY, "X", aip, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.lQf.play(ofFloat5);
        this.lQg = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.lPZ, "X", aip, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.lQg.play(ofFloat6);
        this.lQh = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.lQa, "X", aip, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.lQh.play(ofFloat7);
        this.lQi = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.lQb, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.lQb, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.lQb, "X", aip / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.lQi.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.black_alpha60);
        int i2 = R.drawable.icon_floor_praised_floating;
        int i3 = R.drawable.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.bum()) {
            i2 = R.drawable.icon_floor_praised_floating_xmas;
            i3 = R.drawable.icon_floor_bigpraised_floating_xmas;
        }
        ap.setImageResource(this.lPV, i3);
        ap.setImageResource(this.lPW, i2);
        ap.setImageResource(this.lPX, i2);
        ap.setImageResource(this.lPY, i2);
        ap.setImageResource(this.lPZ, i2);
        ap.setImageResource(this.lQa, i2);
        ap.setViewTextColor(this.lQb, R.color.cp_cont_a);
    }

    public void vF(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.mIsAnimating) {
            this.mIsAnimating = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.lQj, 2000L);
            this.lQc.start();
            this.lQd.start();
            this.lQe.start();
            this.lQf.start();
            this.lQg.start();
            this.lQh.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsw() {
        this.mIsAnimating = false;
        e.mY().post(this.lQk);
        if (this.lLu != null) {
            this.lLu.onAnimationEnd();
        }
        removeCallbacks(this.lQj);
    }

    public void stopAnimation() {
        if (this.mIsAnimating) {
            dsw();
            this.lQc.cancel();
            this.lQd.cancel();
            this.lQe.cancel();
            this.lQf.cancel();
            this.lQg.cancel();
            this.lQh.cancel();
            this.lQi.cancel();
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
        this.lLu = aVar;
    }
}
