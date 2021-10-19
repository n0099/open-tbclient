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
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.q.r;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class TsView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f66346a;

    /* renamed from: b  reason: collision with root package name */
    public GifView f66347b;

    /* renamed from: c  reason: collision with root package name */
    public TTCountdownView f66348c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f66349d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f66350e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f66351f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66352g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f66353h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66354i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f66355j;
    public NativeExpressView k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TsView(@NonNull Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        this.f66346a = context;
        a(str);
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Context context = this.f66346a;
            View inflate = FrameLayout.inflate(context, t.f(context, "tt_splash_view"), this);
            this.f66347b = (GifView) inflate.findViewById(t.e(this.f66346a, "tt_splash_ad_gif"));
            this.f66348c = (TTCountdownView) inflate.findViewById(t.e(this.f66346a, "tt_splash_skip_btn"));
            this.f66349d = (ImageView) inflate.findViewById(t.e(this.f66346a, "tt_splash_video_ad_mute"));
            this.f66350e = (FrameLayout) inflate.findViewById(t.e(this.f66346a, "tt_splash_video_container"));
            this.f66351f = (FrameLayout) inflate.findViewById(t.e(this.f66346a, "tt_splash_express_container"));
            TextView textView = (TextView) inflate.findViewById(t.e(this.f66346a, "tt_ad_logo"));
            this.f66352g = textView;
            s.a(textView, str);
            this.f66353h = (RelativeLayout) inflate.findViewById(t.e(this.f66346a, "tt_full_splash_bar_layout"));
            this.f66354i = (TextView) inflate.findViewById(t.e(this.f66346a, "tt_splash_bar_text"));
            this.f66355j = (ImageView) inflate.findViewById(t.e(this.f66346a, "tt_splash_close_btn"));
        }
    }

    public TTCountdownView getCountDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66348c : (TTCountdownView) invokeV.objValue;
    }

    public View getDislikeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66348c : (View) invokeV.objValue;
    }

    public View getFullClickBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66353h : (View) invokeV.objValue;
    }

    public FrameLayout getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66350e : (FrameLayout) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            s.a(this, this.f66348c);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (getHeight() >= s.d(o.a())) {
                i6 = this.n;
            } else {
                i6 = this.o;
            }
            RelativeLayout relativeLayout = this.f66353h;
            if (relativeLayout == null || (layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams()) == null) {
                return;
            }
            int i7 = this.m + 150;
            if (this.l <= i7) {
                this.l = i7;
            }
            if (i6 <= 0) {
                i6 = 0;
            }
            layoutParams.height = s.d(o.a(), this.m);
            layoutParams.width = s.d(o.a(), this.l);
            layoutParams.bottomMargin = s.d(o.a(), i6);
            layoutParams.gravity = 81;
            this.f66353h.setLayoutParams(layoutParams);
        }
    }

    public void setADlogoLongClickContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            r.a(this.f66352g, str);
        }
    }

    public void setAdlogoViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            s.a((View) this.f66352g, i2);
        }
    }

    public void setClickBarDesc(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (textView = this.f66354i) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setClickBarViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            s.a((View) this.f66353h, i2);
        }
    }

    public void setCloseViewListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (imageView = this.f66355j) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setCloseViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            s.a((View) this.f66355j, i2);
        }
    }

    public void setCountDownTime(int i2) {
        TTCountdownView tTCountdownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (tTCountdownView = this.f66348c) == null) {
            return;
        }
        tTCountdownView.setCountDownTime(i2);
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawable) == null) {
            this.f66347b.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f66347b.setImageDrawable(drawable);
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
        this.f66351f.addView(this.k);
        setExpressViewVisibility(0);
        setVideoViewVisibility(8);
        setImageViewVisibility(8);
    }

    public void setExpressViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            s.a((View) this.f66351f, i2);
        }
    }

    public void setGifView(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bArr) == null) {
            this.f66347b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f66347b.a(bArr, false);
        }
    }

    public void setImageViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            s.a((View) this.f66347b, i2);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            p.a("不允许在Splash广告中注册OnClickListener");
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
            p.a("不允许在Splash广告中注册OnTouchListener");
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
            s.a((View) this.f66348c, i2);
        }
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        TTCountdownView tTCountdownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) || (tTCountdownView = this.f66348c) == null) {
            return;
        }
        tTCountdownView.setOnClickListener(onClickListener);
    }

    public void setVideoViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            s.a((View) this.f66350e, i2);
            s.a((View) this.f66349d, i2);
        }
    }

    public void setVideoVoiceVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            s.a((View) this.f66349d, i2);
        }
    }

    public final void setVoiceViewImageResource(@DrawableRes int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (imageView = this.f66349d) == null) {
            return;
        }
        imageView.setImageResource(i2);
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) || (imageView = this.f66349d) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || (relativeLayout = this.f66353h) == null) {
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
