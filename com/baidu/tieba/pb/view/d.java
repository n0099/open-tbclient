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
    private ImageView mfR;
    private boolean fgC = false;
    private Runnable mfS = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.fgC = true;
            int byQ = f.byQ();
            if (byQ > 0) {
                ViewGroup.LayoutParams layoutParams = d.this.mfR.getLayoutParams();
                int dimens = l.getDimens(d.this.mfR.getContext(), R.dimen.tbds62);
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                d.this.mfR.setLayoutParams(layoutParams);
                SvgManager.bsx().a(d.this.mfR, byQ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (d.this.valueAnimator != null) {
                    d.this.valueAnimator.start();
                }
            }
        }
    };
    private ValueAnimator valueAnimator = new ValueAnimator();

    public d(ImageView imageView) {
        this.mfR = imageView;
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
                if (d.this.mfR != null) {
                    d.this.mfR.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.mfR.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dto() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bwh()) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mfS);
            long bwi = TbSingleton.getInstance().getSharePanelConfData().bwi() * 1000;
            if (bwi <= 0) {
                bwi = IMConnection.RETRY_DELAY_TIMES;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(this.mfS, bwi);
        }
    }

    public void setEnable(boolean z) {
        this.fgC = z;
    }

    public boolean isEnable() {
        return this.fgC;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mfS);
        if (this.valueAnimator != null) {
            this.valueAnimator.removeAllListeners();
            this.valueAnimator.removeAllUpdateListeners();
            this.valueAnimator.cancel();
        }
    }

    public void onChangeSkinType() {
        int byQ;
        if (this.fgC && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bwh() && (byQ = f.byQ()) > 0) {
            ViewGroup.LayoutParams layoutParams = this.mfR.getLayoutParams();
            int dimens = l.getDimens(this.mfR.getContext(), R.dimen.tbds62);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            this.mfR.setLayoutParams(layoutParams);
            SvgManager.bsx().a(this.mfR, byQ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
