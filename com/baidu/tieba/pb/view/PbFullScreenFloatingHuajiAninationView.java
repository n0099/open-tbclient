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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private boolean ejK;
    private a iWw;
    private ImageView jae;
    private ImageView jaf;
    private ImageView jag;
    private ImageView jah;
    private ImageView jai;
    private ImageView jaj;
    private TextView jak;
    private AnimatorSet jal;
    private AnimatorSet jam;
    private AnimatorSet jan;
    private AnimatorSet jao;
    private AnimatorSet jap;
    private AnimatorSet jaq;
    private AnimatorSet jar;
    private Runnable jas;
    private Runnable jat;
    private Runnable mRunnable;
    private static final int jad = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private static final int Me = l.getEquipmentWidth(TbadkCoreApplication.getInst());

    /* loaded from: classes7.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.ejK = false;
        this.jas = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.csJ();
            }
        };
        this.jat = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.ejK = false;
        this.jas = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.csJ();
            }
        };
        this.jat = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.ejK = false;
        this.jas = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.csJ();
            }
        };
        this.jat = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.jae = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
        this.jaf = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
        this.jag = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
        this.jah = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
        this.jai = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
        this.jaj = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
        this.jak = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
        this.jak.setX((Me - jad) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        csI();
    }

    private void csI() {
        this.jal = new AnimatorSet();
        Drawable drawable = am.getDrawable(R.drawable.icon_floor_bigpraised_floating);
        int intrinsicWidth = (Me - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jae, "X", Me, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jae, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.jal.playTogether(ofFloat, ofFloat2);
        this.jam = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.jaf, "X", Me, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.jam.play(ofFloat3);
        this.jan = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.jag, "X", Me, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.jan.play(ofFloat4);
        this.jao = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.jah, "X", Me, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.jao.play(ofFloat5);
        this.jap = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.jai, "X", Me, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.jap.play(ofFloat6);
        this.jaq = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.jaj, "X", Me, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.jaq.play(ofFloat7);
        this.jar = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.jak, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.jak, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.jak, "X", Me / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.jar.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.black_alpha60);
        int i2 = R.drawable.icon_floor_praised_floating;
        int i3 = R.drawable.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.aGK()) {
            i2 = R.drawable.icon_floor_praised_floating_xmas;
            i3 = R.drawable.icon_floor_bigpraised_floating_xmas;
        }
        am.setImageResource(this.jae, i3);
        am.setImageResource(this.jaf, i2);
        am.setImageResource(this.jag, i2);
        am.setImageResource(this.jah, i2);
        am.setImageResource(this.jai, i2);
        am.setImageResource(this.jaj, i2);
        am.setViewTextColor(this.jak, (int) R.color.cp_cont_a);
    }

    public void qY(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.ejK) {
            this.ejK = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.jas, 2000L);
            this.jal.start();
            this.jam.start();
            this.jan.start();
            this.jao.start();
            this.jap.start();
            this.jaq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csJ() {
        this.ejK = false;
        e.gx().post(this.jat);
        if (this.iWw != null) {
            this.iWw.onAnimationEnd();
        }
        removeCallbacks(this.jas);
    }

    public void stopAnimation() {
        if (this.ejK) {
            csJ();
            this.jal.cancel();
            this.jam.cancel();
            this.jan.cancel();
            this.jao.cancel();
            this.jap.cancel();
            this.jaq.cancel();
            this.jar.cancel();
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
        this.iWw = aVar;
    }
}
