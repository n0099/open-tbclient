package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes22.dex */
public class c {
    private ImageView lQO;
    private boolean eUZ = false;
    private Runnable lQP = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eUZ = true;
            int bxz = f.bxz();
            if (bxz > 0) {
                SvgManager.brn().a(c.this.lQO, bxz, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.fEy != null) {
                    c.this.fEy.start();
                }
            }
        }
    };
    private ValueAnimator fEy = new ValueAnimator();

    public c(ImageView imageView) {
        this.lQO = imageView;
        this.fEy.setDuration(4000L);
        this.fEy.setFloatValues(0.0f, 1.0f);
        this.fEy.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fEy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.lQO != null) {
                    c.this.lQO.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.lQO.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dsx() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().buQ()) {
            e.mY().removeCallbacks(this.lQP);
            long buR = TbSingleton.getInstance().getSharePanelConfData().buR() * 1000;
            if (buR <= 0) {
                buR = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mY().postDelayed(this.lQP, buR);
        }
    }

    public void setEnable(boolean z) {
        this.eUZ = z;
    }

    public boolean isEnable() {
        return this.eUZ;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.lQP);
        if (this.fEy != null) {
            this.fEy.removeAllListeners();
            this.fEy.removeAllUpdateListeners();
            this.fEy.cancel();
        }
    }

    public void onChangeSkinType() {
        int bxz;
        if (this.eUZ && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().buQ() && (bxz = f.bxz()) > 0) {
            SvgManager.brn().a(this.lQO, bxz, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
