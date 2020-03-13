package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView jcR;
    private boolean jcT = false;
    private Runnable jcU = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jcT = true;
            int aMx = e.aMx();
            if (aMx > 0) {
                SvgManager.aGC().a(c.this.jcR, aMx, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.jcS != null) {
                    c.this.jcS.start();
                }
            }
        }
    };
    private ValueAnimator jcS = new ValueAnimator();

    public c(ImageView imageView) {
        this.jcR = imageView;
        this.jcS.setDuration(4000L);
        this.jcS.setFloatValues(0.0f, 1.0f);
        this.jcS.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.jcS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jcR != null) {
                    c.this.jcR.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jcR.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cuk() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aJB()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcU);
            long aJC = TbSingleton.getInstance().getSharePanelConfData().aJC() * 1000;
            if (aJC <= 0) {
                aJC = 3000;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jcU, aJC);
        }
    }

    public void setEnable(boolean z) {
        this.jcT = z;
    }

    public boolean isEnable() {
        return this.jcT;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcU);
        if (this.jcS != null) {
            this.jcS.removeAllListeners();
            this.jcS.removeAllUpdateListeners();
            this.jcS.cancel();
        }
    }
}
