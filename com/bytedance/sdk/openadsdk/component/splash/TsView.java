package com.bytedance.sdk.openadsdk.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.r.p;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes5.dex */
public class TsView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f29632a;

    /* renamed from: b  reason: collision with root package name */
    public GifView f29633b;

    /* renamed from: c  reason: collision with root package name */
    public TTCountdownView f29634c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29635d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f29636e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f29637f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f29638g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f29639h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f29640i;
    public ImageView j;
    public NativeExpressView k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TsView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29632a = context;
        a();
    }

    public TTCountdownView getCountDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29634c : (TTCountdownView) invokeV.objValue;
    }

    public View getDislikeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29634c : (View) invokeV.objValue;
    }

    public View getFullClickBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29639h : (View) invokeV.objValue;
    }

    public FrameLayout getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29636e : (FrameLayout) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.TsView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TsView f29641a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29641a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q.g(this.f29641a.f29634c);
                    }
                }
            });
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (getHeight() >= q.d(o.a())) {
                i6 = this.n;
            } else {
                i6 = this.o;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29639h.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            int i7 = this.m + 150;
            if (this.l <= i7) {
                this.l = i7;
            }
            if (i6 <= 0) {
                i6 = 0;
            }
            layoutParams.height = q.d(o.a(), this.m);
            layoutParams.width = q.d(o.a(), this.l);
            layoutParams.bottomMargin = q.d(o.a(), i6);
            layoutParams.gravity = 81;
            this.f29639h.setLayoutParams(layoutParams);
        }
    }

    public void setADlogoLongClickContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            p.a(this.f29638g, str);
        }
    }

    public void setAdlogoViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            q.a((View) this.f29638g, i2);
        }
    }

    public void setClickBarDesc(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (textView = this.f29640i) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setClickBarViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            q.a((View) this.f29639h, i2);
        }
    }

    public void setCloseViewListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (imageView = this.j) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setCloseViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            q.a((View) this.j, i2);
        }
    }

    public void setCountDownTime(int i2) {
        TTCountdownView tTCountdownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (tTCountdownView = this.f29634c) == null) {
            return;
        }
        tTCountdownView.setCountDownTime(i2);
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawable) == null) {
            this.f29633b.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f29633b.setImageDrawable(drawable);
        }
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, nativeExpressView) == null) || nativeExpressView == null) {
            return;
        }
        this.k = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        this.f29637f.addView(this.k);
        setExpressViewVisibility(0);
        setVideoViewVisibility(8);
        setImageViewVisibility(8);
    }

    public void setExpressViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            q.a((View) this.f29637f, i2);
        }
    }

    public void setGifView(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bArr) == null) {
            this.f29633b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f29633b.a(bArr, false);
        }
    }

    public void setImageViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            q.a((View) this.f29633b, i2);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            n.a("不允许在Splash广告中注册OnClickListener");
        }
    }

    public final void setOnClickListenerInternal(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onTouchListener) == null) {
            n.a("不允许在Splash广告中注册OnTouchListener");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onTouchListener) == null) {
            super.setOnTouchListener(onTouchListener);
        }
    }

    public void setSkipIconVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            q.a((View) this.f29634c, i2);
        }
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        TTCountdownView tTCountdownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) || (tTCountdownView = this.f29634c) == null) {
            return;
        }
        tTCountdownView.setOnClickListener(onClickListener);
    }

    public void setVideoViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            q.a((View) this.f29636e, i2);
            q.a((View) this.f29635d, i2);
        }
    }

    public void setVideoVoiceVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            q.a((View) this.f29635d, i2);
        }
    }

    public final void setVoiceViewImageResource(@DrawableRes int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (imageView = this.f29635d) == null) {
            return;
        }
        imageView.setImageResource(i2);
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) || (imageView = this.f29635d) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Context context = this.f29632a;
            View inflate = FrameLayout.inflate(context, r.f(context, "tt_splash_view"), this);
            this.f29633b = (GifView) inflate.findViewById(r.e(this.f29632a, "tt_splash_ad_gif"));
            this.f29634c = (TTCountdownView) inflate.findViewById(r.e(this.f29632a, "tt_splash_skip_btn"));
            this.f29635d = (ImageView) inflate.findViewById(r.e(this.f29632a, "tt_splash_video_ad_mute"));
            this.f29636e = (FrameLayout) inflate.findViewById(r.e(this.f29632a, "tt_splash_video_container"));
            this.f29637f = (FrameLayout) inflate.findViewById(r.e(this.f29632a, "tt_splash_express_container"));
            this.f29638g = (ImageView) inflate.findViewById(r.e(this.f29632a, "tt_ad_logo"));
            this.f29639h = (RelativeLayout) inflate.findViewById(r.e(this.f29632a, "tt_full_splash_bar_layout"));
            this.f29640i = (TextView) inflate.findViewById(r.e(this.f29632a, "tt_splash_bar_text"));
            this.j = (ImageView) inflate.findViewById(r.e(this.f29632a, "tt_splash_close_btn"));
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || (relativeLayout = this.f29639h) == null) {
            return;
        }
        if (i2 != 0) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.setVisibility(0);
        this.l = i3;
        this.m = i4;
        this.n = i5;
        this.o = i6;
    }
}
