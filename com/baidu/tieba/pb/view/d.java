package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d {
    private ImageView mky;
    private boolean fln = false;
    private Runnable mkz = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.fln = true;
            int bCJ = f.bCJ();
            if (bCJ > 0) {
                ViewGroup.LayoutParams layoutParams = d.this.mky.getLayoutParams();
                int dimens = l.getDimens(d.this.mky.getContext(), R.dimen.tbds62);
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                d.this.mky.setLayoutParams(layoutParams);
                SvgManager.bwq().a(d.this.mky, bCJ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (d.this.valueAnimator != null) {
                    d.this.valueAnimator.start();
                }
            }
        }
    };
    private ValueAnimator valueAnimator = new ValueAnimator();

    public d(ImageView imageView) {
        this.mky = imageView;
        this.valueAnimator.setDuration(4000L);
        this.valueAnimator.setFloatValues(0.0f, 1.0f);
        this.valueAnimator.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.d.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (d.this.mky != null) {
                    d.this.mky.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.mky.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dxf() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bAa()) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mkz);
            long bAb = TbSingleton.getInstance().getSharePanelConfData().bAb() * 1000;
            if (bAb <= 0) {
                bAb = IMConnection.RETRY_DELAY_TIMES;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(this.mkz, bAb);
        }
    }

    public void setEnable(boolean z) {
        this.fln = z;
    }

    public boolean isEnable() {
        return this.fln;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mkz);
        if (this.valueAnimator != null) {
            this.valueAnimator.removeAllListeners();
            this.valueAnimator.removeAllUpdateListeners();
            this.valueAnimator.cancel();
        }
    }

    public void onChangeSkinType() {
        int bCJ;
        if (this.fln && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bAa() && (bCJ = f.bCJ()) > 0) {
            ViewGroup.LayoutParams layoutParams = this.mky.getLayoutParams();
            int dimens = l.getDimens(this.mky.getContext(), R.dimen.tbds62);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            this.mky.setLayoutParams(layoutParams);
            SvgManager.bwq().a(this.mky, bCJ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
