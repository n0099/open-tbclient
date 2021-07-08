package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes5.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30390a;
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
            q.a((View) this.f30656f, 0);
            q.a((View) this.f30657g, 0);
            q.a((View) this.f30659i, 8);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            h();
            RelativeLayout relativeLayout = this.f30656f;
            if (relativeLayout != null) {
                if (relativeLayout.getVisibility() == 0) {
                    return;
                }
                com.bytedance.sdk.openadsdk.g.a.a(this.f30652b.V().h()).a(this.f30657g);
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
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30655e = false;
            int d2 = com.bytedance.sdk.openadsdk.r.o.d(this.f30652b.ao());
            if ("banner_ad".equalsIgnoreCase(this.k)) {
                com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(d2));
            }
            super.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.p) {
            super.b(this.f30390a);
        }
    }

    public void d_() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (imageView = this.f30659i) == null) {
            return;
        }
        q.a((View) imageView, 8);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            q.a((View) this.f30656f, 0);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f30653c;
            return (cVar == null || cVar.u() == null || !this.f30653c.u().g()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            ImageView imageView = this.f30658h;
            if (imageView != null && imageView.getVisibility() == 0) {
                q.e(this.f30656f);
            }
            b(this.f30390a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            ImageView imageView = this.f30658h;
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
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            ImageView imageView = this.f30658h;
            if (imageView != null && imageView.getVisibility() == 0) {
                l();
            } else {
                super.onWindowVisibilityChanged(i2);
            }
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.p = z;
        }
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        cVar.f(z);
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (cVar = this.f30653c) == null || (v = cVar.v()) == null) {
            return;
        }
        v.d(z);
    }

    public void setVideoPlayStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f30390a = i2;
        }
    }
}
