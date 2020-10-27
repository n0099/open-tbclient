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
    private ImageView lKS;
    private boolean ePk = false;
    private Runnable lKT = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.ePk = true;
            int bva = f.bva();
            if (bva > 0) {
                SvgManager.boN().a(c.this.lKS, bva, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.fyI != null) {
                    c.this.fyI.start();
                }
            }
        }
    };
    private ValueAnimator fyI = new ValueAnimator();

    public c(ImageView imageView) {
        this.lKS = imageView;
        this.fyI.setDuration(4000L);
        this.fyI.setFloatValues(0.0f, 1.0f);
        this.fyI.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fyI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.lKS != null) {
                    c.this.lKS.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.lKS.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dpV() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bsq()) {
            e.mY().removeCallbacks(this.lKT);
            long bsr = TbSingleton.getInstance().getSharePanelConfData().bsr() * 1000;
            if (bsr <= 0) {
                bsr = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mY().postDelayed(this.lKT, bsr);
        }
    }

    public void setEnable(boolean z) {
        this.ePk = z;
    }

    public boolean isEnable() {
        return this.ePk;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.lKT);
        if (this.fyI != null) {
            this.fyI.removeAllListeners();
            this.fyI.removeAllUpdateListeners();
            this.fyI.cancel();
        }
    }

    public void onChangeSkinType() {
        int bva;
        if (this.ePk && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bsq() && (bva = f.bva()) > 0) {
            SvgManager.boN().a(this.lKS, bva, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
