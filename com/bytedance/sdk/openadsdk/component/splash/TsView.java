package com.bytedance.sdk.openadsdk.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.z;
/* loaded from: classes5.dex */
public class TsView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final Context f27580a;

    /* renamed from: b  reason: collision with root package name */
    public GifView f27581b;

    /* renamed from: c  reason: collision with root package name */
    public TTCountdownView f27582c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f27583d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f27584e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f27585f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f27586g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f27587h;
    public TextView i;
    public NativeExpressView j;
    public int k;
    public int l;
    public int m;
    public int n;

    public TsView(@NonNull Context context) {
        super(context);
        this.f27580a = context;
        a();
    }

    public TTCountdownView getCountDownView() {
        return this.f27582c;
    }

    public View getDislikeView() {
        return this.f27582c;
    }

    public View getFullClickBarView() {
        return this.f27587h;
    }

    public FrameLayout getVideoContainer() {
        return this.f27584e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.TsView.1
            @Override // java.lang.Runnable
            public void run() {
                al.h(TsView.this.f27582c);
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        if (getHeight() >= al.d(p.a())) {
            i5 = this.m;
        } else {
            i5 = this.n;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f27587h.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i6 = this.l + 150;
        if (this.k <= i6) {
            this.k = i6;
        }
        if (i5 <= 0) {
            i5 = 0;
        }
        layoutParams.height = al.c(p.a(), this.l);
        layoutParams.width = al.c(p.a(), this.k);
        layoutParams.bottomMargin = al.c(p.a(), i5);
        layoutParams.gravity = 81;
        this.f27587h.setLayoutParams(layoutParams);
    }

    public void setAdlogoViewVisibility(int i) {
        al.a((View) this.f27586g, i);
    }

    public void setClickBarDesc(String str) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setCountDownTime(int i) {
        TTCountdownView tTCountdownView = this.f27582c;
        if (tTCountdownView != null) {
            tTCountdownView.setCountDownTime(i);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.f27581b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f27581b.setImageDrawable(drawable);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.j = nativeExpressView;
        this.f27585f.addView(nativeExpressView);
        setExpressViewVisibility(0);
        setVideoViewVisibility(8);
        setImageViewVisibility(8);
    }

    public void setExpressViewVisibility(int i) {
        al.a((View) this.f27585f, i);
    }

    public void setGifView(byte[] bArr) {
        this.f27581b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f27581b.a(bArr, false);
    }

    public void setImageViewVisibility(int i) {
        al.a((View) this.f27581b, i);
    }

    @Override // android.view.View
    public final void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        z.a("不允许在Splash广告中注册OnClickListener");
    }

    public final void setOnClickListenerInternal(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        z.a("不允许在Splash广告中注册OnTouchListener");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void setSkipIconVisibility(int i) {
        al.a((View) this.f27582c, i);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        TTCountdownView tTCountdownView = this.f27582c;
        if (tTCountdownView != null) {
            tTCountdownView.setOnClickListener(onClickListener);
        }
    }

    public void setVideoViewVisibility(int i) {
        al.a((View) this.f27584e, i);
        al.a((View) this.f27583d, i);
    }

    public final void setVoiceViewImageResource(@DrawableRes int i) {
        ImageView imageView = this.f27583d;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f27583d;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.f27580a;
        View inflate = FrameLayout.inflate(context, ad.f(context, "tt_splash_view"), this);
        this.f27581b = (GifView) inflate.findViewById(ad.e(this.f27580a, "tt_splash_ad_gif"));
        this.f27582c = (TTCountdownView) inflate.findViewById(ad.e(this.f27580a, "tt_splash_skip_btn"));
        this.f27583d = (ImageView) inflate.findViewById(ad.e(this.f27580a, "tt_splash_video_ad_mute"));
        this.f27584e = (FrameLayout) inflate.findViewById(ad.e(this.f27580a, "tt_splash_video_container"));
        this.f27585f = (FrameLayout) inflate.findViewById(ad.e(this.f27580a, "tt_splash_express_container"));
        this.f27586g = (ImageView) inflate.findViewById(ad.e(this.f27580a, "tt_ad_logo"));
        this.f27587h = (RelativeLayout) inflate.findViewById(ad.e(this.f27580a, "tt_full_splash_bar_layout"));
        this.i = (TextView) inflate.findViewById(ad.e(this.f27580a, "tt_splash_bar_text"));
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        RelativeLayout relativeLayout = this.f27587h;
        if (relativeLayout == null) {
            return;
        }
        if (i != 0) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.setVisibility(0);
        this.k = i2;
        this.l = i3;
        this.m = i4;
        this.n = i5;
    }
}
