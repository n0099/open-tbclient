package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView mFi;

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
        this.mFi = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.mFi.loop(true);
        this.mFi.setFrame(0);
        ao.a(this.mFi, R.raw.scan_refresh);
        ao.setViewTextColor((TextView) findViewById(R.id.loading_text), R.color.CAM_X0108, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.mFi != null) {
            if (this.mFi.isAnimating()) {
                this.mFi.cancelAnimation();
            }
            this.mFi.playAnimation();
        }
    }

    public void hideLoading() {
        if (this.mFi != null) {
            this.mFi.cancelAnimation();
        }
        setVisibility(8);
    }
}
