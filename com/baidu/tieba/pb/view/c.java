package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView kgt;
    private boolean dVd = false;
    private Runnable kgu = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.dVd = true;
            int bbg = e.bbg();
            if (bbg > 0) {
                SvgManager.aUV().a(c.this.kgt, bbg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.gYL != null) {
                    c.this.gYL.start();
                }
            }
        }
    };
    private ValueAnimator gYL = new ValueAnimator();

    public c(ImageView imageView) {
        this.kgt = imageView;
        this.gYL.setDuration(4000L);
        this.gYL.setFloatValues(0.0f, 1.0f);
        this.gYL.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.gYL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.kgt != null) {
                    c.this.kgt.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.kgt.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cMf() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aYg()) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kgu);
            long aYh = TbSingleton.getInstance().getSharePanelConfData().aYh() * 1000;
            if (aYh <= 0) {
                aYh = 3000;
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kgu, aYh);
        }
    }

    public void setEnable(boolean z) {
        this.dVd = z;
    }

    public boolean isEnable() {
        return this.dVd;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kgu);
        if (this.gYL != null) {
            this.gYL.removeAllListeners();
            this.gYL.removeAllUpdateListeners();
            this.gYL.cancel();
        }
    }

    public void onChangeSkinType() {
        int bbg;
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aYg() && (bbg = e.bbg()) > 0) {
            SvgManager.aUV().a(this.kgt, bbg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
