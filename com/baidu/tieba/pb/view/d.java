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
    private ImageView mrl;
    private boolean fku = false;
    private Runnable mrm = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.fku = true;
            int bzl = f.bzl();
            if (bzl > 0) {
                ViewGroup.LayoutParams layoutParams = d.this.mrl.getLayoutParams();
                int dimens = l.getDimens(d.this.mrl.getContext(), R.dimen.tbds62);
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                d.this.mrl.setLayoutParams(layoutParams);
                SvgManager.bsU().a(d.this.mrl, bzl, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (d.this.valueAnimator != null) {
                    d.this.valueAnimator.start();
                }
            }
        }
    };
    private ValueAnimator valueAnimator = new ValueAnimator();

    public d(ImageView imageView) {
        this.mrl = imageView;
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
                if (d.this.mrl != null) {
                    d.this.mrl.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.mrl.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dvN() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bwC()) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mrm);
            long bwD = TbSingleton.getInstance().getSharePanelConfData().bwD() * 1000;
            if (bwD <= 0) {
                bwD = IMConnection.RETRY_DELAY_TIMES;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mrm, bwD);
        }
    }

    public void setEnable(boolean z) {
        this.fku = z;
    }

    public boolean isEnable() {
        return this.fku;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mrm);
        if (this.valueAnimator != null) {
            this.valueAnimator.removeAllListeners();
            this.valueAnimator.removeAllUpdateListeners();
            this.valueAnimator.cancel();
        }
    }

    public void onChangeSkinType() {
        int bzl;
        if (this.fku && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bwC() && (bzl = f.bzl()) > 0) {
            ViewGroup.LayoutParams layoutParams = this.mrl.getLayoutParams();
            int dimens = l.getDimens(this.mrl.getContext(), R.dimen.tbds62);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            this.mrl.setLayoutParams(layoutParams);
            SvgManager.bsU().a(this.mrl, bzl, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
