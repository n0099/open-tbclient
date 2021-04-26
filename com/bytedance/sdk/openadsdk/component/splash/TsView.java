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
    public final Context f28414a;

    /* renamed from: b  reason: collision with root package name */
    public GifView f28415b;

    /* renamed from: c  reason: collision with root package name */
    public TTCountdownView f28416c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28417d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f28418e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f28419f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f28420g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f28421h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f28422i;
    public NativeExpressView j;
    public int k;
    public int l;
    public int m;
    public int n;

    public TsView(@NonNull Context context) {
        super(context);
        this.f28414a = context;
        a();
    }

    public TTCountdownView getCountDownView() {
        return this.f28416c;
    }

    public View getDislikeView() {
        return this.f28416c;
    }

    public View getFullClickBarView() {
        return this.f28421h;
    }

    public FrameLayout getVideoContainer() {
        return this.f28418e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.TsView.1
            @Override // java.lang.Runnable
            public void run() {
                al.h(TsView.this.f28416c);
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        if (getHeight() >= al.d(p.a())) {
            i6 = this.m;
        } else {
            i6 = this.n;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f28421h.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i7 = this.l + 150;
        if (this.k <= i7) {
            this.k = i7;
        }
        if (i6 <= 0) {
            i6 = 0;
        }
        layoutParams.height = al.c(p.a(), this.l);
        layoutParams.width = al.c(p.a(), this.k);
        layoutParams.bottomMargin = al.c(p.a(), i6);
        layoutParams.gravity = 81;
        this.f28421h.setLayoutParams(layoutParams);
    }

    public void setAdlogoViewVisibility(int i2) {
        al.a((View) this.f28420g, i2);
    }

    public void setClickBarDesc(String str) {
        TextView textView = this.f28422i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setCountDownTime(int i2) {
        TTCountdownView tTCountdownView = this.f28416c;
        if (tTCountdownView != null) {
            tTCountdownView.setCountDownTime(i2);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.f28415b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f28415b.setImageDrawable(drawable);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.j = nativeExpressView;
        this.f28419f.addView(nativeExpressView);
        setExpressViewVisibility(0);
        setVideoViewVisibility(8);
        setImageViewVisibility(8);
    }

    public void setExpressViewVisibility(int i2) {
        al.a((View) this.f28419f, i2);
    }

    public void setGifView(byte[] bArr) {
        this.f28415b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f28415b.a(bArr, false);
    }

    public void setImageViewVisibility(int i2) {
        al.a((View) this.f28415b, i2);
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

    public void setSkipIconVisibility(int i2) {
        al.a((View) this.f28416c, i2);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        TTCountdownView tTCountdownView = this.f28416c;
        if (tTCountdownView != null) {
            tTCountdownView.setOnClickListener(onClickListener);
        }
    }

    public void setVideoViewVisibility(int i2) {
        al.a((View) this.f28418e, i2);
        al.a((View) this.f28417d, i2);
    }

    public final void setVoiceViewImageResource(@DrawableRes int i2) {
        ImageView imageView = this.f28417d;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f28417d;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.f28414a;
        View inflate = FrameLayout.inflate(context, ad.f(context, "tt_splash_view"), this);
        this.f28415b = (GifView) inflate.findViewById(ad.e(this.f28414a, "tt_splash_ad_gif"));
        this.f28416c = (TTCountdownView) inflate.findViewById(ad.e(this.f28414a, "tt_splash_skip_btn"));
        this.f28417d = (ImageView) inflate.findViewById(ad.e(this.f28414a, "tt_splash_video_ad_mute"));
        this.f28418e = (FrameLayout) inflate.findViewById(ad.e(this.f28414a, "tt_splash_video_container"));
        this.f28419f = (FrameLayout) inflate.findViewById(ad.e(this.f28414a, "tt_splash_express_container"));
        this.f28420g = (ImageView) inflate.findViewById(ad.e(this.f28414a, "tt_ad_logo"));
        this.f28421h = (RelativeLayout) inflate.findViewById(ad.e(this.f28414a, "tt_full_splash_bar_layout"));
        this.f28422i = (TextView) inflate.findViewById(ad.e(this.f28414a, "tt_splash_bar_text"));
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        RelativeLayout relativeLayout = this.f28421h;
        if (relativeLayout == null) {
            return;
        }
        if (i2 != 0) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.setVisibility(0);
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.n = i6;
    }
}
