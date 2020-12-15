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
/* loaded from: classes22.dex */
public class d {
    private ImageView mfl;
    private boolean fbE = false;
    private Runnable mfm = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.fbE = true;
            int bAp = f.bAp();
            if (bAp > 0) {
                ViewGroup.LayoutParams layoutParams = d.this.mfl.getLayoutParams();
                int dimens = l.getDimens(d.this.mfl.getContext(), R.dimen.tbds62);
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                d.this.mfl.setLayoutParams(layoutParams);
                SvgManager.btW().a(d.this.mfl, bAp, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (d.this.fLN != null) {
                    d.this.fLN.start();
                }
            }
        }
    };
    private ValueAnimator fLN = new ValueAnimator();

    public d(ImageView imageView) {
        this.mfl = imageView;
        this.fLN.setDuration(4000L);
        this.fLN.setFloatValues(0.0f, 1.0f);
        this.fLN.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.d.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fLN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (d.this.mfl != null) {
                    d.this.mfl.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.mfl.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dxq() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bxG()) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mfm);
            long bxH = TbSingleton.getInstance().getSharePanelConfData().bxH() * 1000;
            if (bxH <= 0) {
                bxH = IMConnection.RETRY_DELAY_TIMES;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mfm, bxH);
        }
    }

    public void setEnable(boolean z) {
        this.fbE = z;
    }

    public boolean isEnable() {
        return this.fbE;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mfm);
        if (this.fLN != null) {
            this.fLN.removeAllListeners();
            this.fLN.removeAllUpdateListeners();
            this.fLN.cancel();
        }
    }

    public void onChangeSkinType() {
        int bAp;
        if (this.fbE && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bxG() && (bAp = f.bAp()) > 0) {
            ViewGroup.LayoutParams layoutParams = this.mfl.getLayoutParams();
            int dimens = l.getDimens(this.mfl.getContext(), R.dimen.tbds62);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            this.mfl.setLayoutParams(layoutParams);
            SvgManager.btW().a(this.mfl, bAp, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
