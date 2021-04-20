package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ScanLoadingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TBLottieAnimationView f20367e;

    public ScanLoadingView(Context context) {
        this(context, null);
    }

    public void a() {
        TBLottieAnimationView tBLottieAnimationView = this.f20367e;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
        setVisibility(8);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_scan_loading, (ViewGroup) this, true);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.f20367e = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        this.f20367e.setFrame(0);
        SkinManager.setLottieAnimation(this.f20367e, R.raw.scan_refresh);
        SkinManager.setViewTextColor((TextView) findViewById(R.id.loading_text), R.color.CAM_X0108, 1);
        setVisibility(8);
    }

    public void c() {
        setVisibility(0);
        TBLottieAnimationView tBLottieAnimationView = this.f20367e;
        if (tBLottieAnimationView != null) {
            if (tBLottieAnimationView.isAnimating()) {
                this.f20367e.cancelAnimation();
            }
            this.f20367e.playAnimation();
        }
    }

    public ScanLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }
}
