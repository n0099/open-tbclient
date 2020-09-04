package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes16.dex */
public class c {
    private ImageView lal;
    private boolean esz = false;
    private Runnable lam = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.esz = true;
            int bpD = f.bpD();
            if (bpD > 0) {
                SvgManager.bjq().a(c.this.lal, bpD, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.fbd != null) {
                    c.this.fbd.start();
                }
            }
        }
    };
    private ValueAnimator fbd = new ValueAnimator();

    public c(ImageView imageView) {
        this.lal = imageView;
        this.fbd.setDuration(4000L);
        this.fbd.setFloatValues(0.0f, 1.0f);
        this.fbd.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fbd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.lal != null) {
                    c.this.lal.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.lal.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dfB() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bmT()) {
            e.mS().removeCallbacks(this.lam);
            long bmU = TbSingleton.getInstance().getSharePanelConfData().bmU() * 1000;
            if (bmU <= 0) {
                bmU = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mS().postDelayed(this.lam, bmU);
        }
    }

    public void setEnable(boolean z) {
        this.esz = z;
    }

    public boolean isEnable() {
        return this.esz;
    }

    public void onDestroy() {
        e.mS().removeCallbacks(this.lam);
        if (this.fbd != null) {
            this.fbd.removeAllListeners();
            this.fbd.removeAllUpdateListeners();
            this.fbd.cancel();
        }
    }

    public void onChangeSkinType() {
        int bpD;
        if (this.esz && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bmT() && (bpD = f.bpD()) > 0) {
            SvgManager.bjq().a(this.lal, bpD, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
