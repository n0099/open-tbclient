package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.component.image.ResultType;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
/* loaded from: classes9.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67100a;
    public boolean p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressVideoView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z) {
        super(context, mVar, false, false, str, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, mVar, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.e.m) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        if ("draw_ad".equals(str)) {
            this.p = true;
        }
        this.q = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            com.bytedance.sdk.openadsdk.q.s.a((View) this.f67453f, 0);
            com.bytedance.sdk.openadsdk.q.s.a((View) this.f67454g, 0);
            com.bytedance.sdk.openadsdk.q.s.a((View) this.f67456i, 8);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            h();
            RelativeLayout relativeLayout = this.f67453f;
            if (relativeLayout != null) {
                if (relativeLayout.getVisibility() == 0) {
                    return;
                }
                ImageLoaderWrapper.from(this.f67449b.V().h()).to(this.f67454g);
            }
            k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c a(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (this.q) {
                return new com.bytedance.sdk.openadsdk.core.video.nativevideo.f(context, viewGroup, mVar, str, z, z2, z3);
            }
            return super.a(context, viewGroup, mVar, str, z, z2, z3);
        }
        return (com.bytedance.sdk.openadsdk.core.video.nativevideo.c) invokeCommon.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f67452e = false;
            int d2 = com.bytedance.sdk.openadsdk.q.q.d(this.f67449b.ao());
            if ("banner_ad".equalsIgnoreCase(this.k)) {
                com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(d2));
            }
            super.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.p) {
            super.b(this.f67100a);
        }
    }

    public void d_() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (imageView = this.f67456i) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.q.s.a((View) imageView, 8);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h();
            com.bytedance.sdk.openadsdk.q.s.a((View) this.f67453f, 0);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f67450c;
            return (cVar == null || cVar.v() == null || !this.f67450c.v().g()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            ImageView imageView = this.f67455h;
            if (imageView != null && imageView.getVisibility() == 0) {
                com.bytedance.sdk.openadsdk.q.s.e(this.f67453f);
            }
            b(this.f67100a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ImageView imageView = this.f67455h;
            if (imageView != null && imageView.getVisibility() == 0) {
                l();
            } else {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            ImageView imageView = this.f67455h;
            if (imageView != null && imageView.getVisibility() == 0) {
                l();
            } else {
                super.onWindowVisibilityChanged(i2);
            }
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (cVar = this.f67450c) == null) {
            return;
        }
        cVar.e(z);
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (cVar = this.f67450c) == null || (w = cVar.w()) == null) {
            return;
        }
        w.d(z);
    }

    public void setVideoPlayStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f67100a = i2;
        }
    }

    public void a(Context context, int i2) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) || (cVar = this.f67450c) == null || (w = cVar.w()) == null || Build.VERSION.SDK_INT < 17) {
            return;
        }
        ImageLoaderWrapper.from(this.f67449b.V().h()).type(ResultType.BITMAP).to(new ILoaderListener<Bitmap>(this, context, i2, w) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f67101a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f67102b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.core.video.nativevideo.i f67103c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExpressVideoView f67104d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, Integer.valueOf(i2), w};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67104d = this;
                this.f67101a = context;
                this.f67102b = i2;
                this.f67103c = w;
            }

            @Override // com.bytedance.sdk.component.image.ILoaderListener
            public void onFailed(int i3, String str, @Nullable Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str, th) == null) {
                }
            }

            @Override // com.bytedance.sdk.component.image.ILoaderListener
            public void onSuccess(ImageResponse<Bitmap> imageResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                    Bitmap a2 = com.bytedance.sdk.openadsdk.q.b.a(this.f67101a, imageResponse.getResult(), this.f67102b);
                    if (a2 == null) {
                        return;
                    }
                    this.f67103c.a(new BitmapDrawable(this.f67104d.getResources(), a2));
                }
            }
        });
    }
}
