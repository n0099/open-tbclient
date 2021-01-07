package com.bytedance.sdk.openadsdk.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.z;
/* loaded from: classes4.dex */
public class TsView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6678a;

    /* renamed from: b  reason: collision with root package name */
    private GifView f6679b;
    private TTCountdownView c;
    private ImageView d;
    private FrameLayout e;
    private FrameLayout f;
    private TextView g;
    private NativeExpressView h;

    public TsView(@NonNull Context context) {
        super(context);
        this.f6678a = context;
        a();
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View inflate = inflate(this.f6678a, ac.f(this.f6678a, "tt_splash_view"), this);
        this.f6679b = (GifView) inflate.findViewById(ac.e(this.f6678a, "tt_splash_ad_gif"));
        this.c = (TTCountdownView) inflate.findViewById(ac.e(this.f6678a, "tt_splash_skip_btn"));
        this.d = (ImageView) inflate.findViewById(ac.e(this.f6678a, "tt_splash_video_ad_mute"));
        this.e = (FrameLayout) inflate.findViewById(ac.e(this.f6678a, "tt_splash_video_container"));
        this.f = (FrameLayout) inflate.findViewById(ac.e(this.f6678a, "tt_splash_express_container"));
        this.g = (TextView) inflate.findViewById(ac.e(this.f6678a, "tt_ad_logo"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            this.h = nativeExpressView;
            this.f.addView(this.h);
            setExpressViewVisibility(0);
            setVideoViewVisibility(8);
            setImageViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCountDownTime(int i) {
        if (this.c != null) {
            this.c.setCountDownTime(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSkipIconVisibility(int i) {
        ak.a((View) this.c, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameLayout getVideoContainer() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVideoViewVisibility(int i) {
        ak.a((View) this.e, i);
        ak.a((View) this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAdlogoViewVisibility(int i) {
        ak.a((View) this.g, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageViewVisibility(int i) {
        ak.a((View) this.f6679b, i);
    }

    void setExpressViewVisibility(int i) {
        ak.a((View) this.f, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrawable(Drawable drawable) {
        this.f6679b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f6679b.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGifView(byte[] bArr) {
        this.f6679b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f6679b.a(bArr, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTCountdownView getCountDownView() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getDislikeView() {
        return this.c;
    }

    @Override // android.view.View
    public final void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        z.a("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        z.a("不允许在Splash广告中注册OnTouchListener");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOnClickListenerInternal(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setSkipListener(View.OnClickListener onClickListener) {
        if (this.c != null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        if (this.d != null) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setVoiceViewImageResource(@DrawableRes int i) {
        if (this.d != null) {
            this.d.setImageResource(i);
        }
    }
}
