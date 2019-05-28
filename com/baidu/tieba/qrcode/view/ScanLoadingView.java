package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView ixZ;

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
        this.ixZ = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.ixZ.y(true);
        this.ixZ.setFrame(0);
        al.a(this.ixZ, (int) R.raw.scan_refresh);
        al.f((TextView) findViewById(R.id.loading_text), R.color.cp_cont_c, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.ixZ != null) {
            if (this.ixZ.isAnimating()) {
                this.ixZ.cancelAnimation();
            }
            this.ixZ.bo();
        }
    }

    public void boL() {
        if (this.ixZ != null) {
            this.ixZ.cancelAnimation();
        }
        setVisibility(8);
    }
}
