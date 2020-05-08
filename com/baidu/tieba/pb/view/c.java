package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView jOB;
    private boolean dGR = false;
    private Runnable jOC = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.dGR = true;
            int aUW = e.aUW();
            if (aUW > 0) {
                SvgManager.aOR().a(c.this.jOB, aUW, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.gJZ != null) {
                    c.this.gJZ.start();
                }
            }
        }
    };
    private ValueAnimator gJZ = new ValueAnimator();

    public c(ImageView imageView) {
        this.jOB = imageView;
        this.gJZ.setDuration(4000L);
        this.gJZ.setFloatValues(0.0f, 1.0f);
        this.gJZ.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.gJZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jOB != null) {
                    c.this.jOB.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jOB.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cFg() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aRZ()) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jOC);
            long aSa = TbSingleton.getInstance().getSharePanelConfData().aSa() * 1000;
            if (aSa <= 0) {
                aSa = 3000;
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(this.jOC, aSa);
        }
    }

    public void setEnable(boolean z) {
        this.dGR = z;
    }

    public boolean isEnable() {
        return this.dGR;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jOC);
        if (this.gJZ != null) {
            this.gJZ.removeAllListeners();
            this.gJZ.removeAllUpdateListeners();
            this.gJZ.cancel();
        }
    }
}
