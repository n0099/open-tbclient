package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView mzS;

    public ScanLoadingView(Context context) {
        this(context, null);
    }

    public ScanLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_scan_loading, (ViewGroup) this, true);
        this.mzS = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.mzS.loop(true);
        this.mzS.setFrame(0);
        ap.a(this.mzS, R.raw.scan_refresh);
        ap.setViewTextColor((TextView) findViewById(R.id.loading_text), R.color.CAM_X0108, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.mzS != null) {
            if (this.mzS.isAnimating()) {
                this.mzS.cancelAnimation();
            }
            this.mzS.playAnimation();
        }
    }

    public void hideLoading() {
        if (this.mzS != null) {
            this.mzS.cancelAnimation();
        }
        setVisibility(8);
    }
}
