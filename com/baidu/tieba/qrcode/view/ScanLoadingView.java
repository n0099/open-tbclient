package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView kWK;

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
        this.kWK = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.kWK.loop(true);
        this.kWK.setFrame(0);
        an.a(this.kWK, (int) R.raw.scan_refresh);
        an.setViewTextColor((TextView) findViewById(R.id.loading_text), R.color.cp_cont_c, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.kWK != null) {
            if (this.kWK.isAnimating()) {
                this.kWK.cancelAnimation();
            }
            this.kWK.playAnimation();
        }
    }

    public void hideLoading() {
        if (this.kWK != null) {
            this.kWK.cancelAnimation();
        }
        setVisibility(8);
    }
}
