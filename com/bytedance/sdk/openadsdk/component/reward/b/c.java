package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TopProxyLayout f29520a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f29521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29522c;

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29522c = false;
        this.f29521b = activity;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Activity activity = this.f29521b;
            TopProxyLayout topProxyLayout = (TopProxyLayout) activity.findViewById(t.e(activity, "tt_top_layout_proxy"));
            this.f29520a = topProxyLayout;
            if (topProxyLayout != null) {
                topProxyLayout.e();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29522c) {
            return;
        }
        this.f29522c = true;
        g();
    }

    public void b(boolean z) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setSoundMute(z);
    }

    public void c(boolean z) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setShowSound(z);
    }

    public void d(boolean z) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setShowSkip(z);
    }

    public void e(boolean z) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setShowClose(z);
    }

    public void f(boolean z) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setSkipEnable(z);
    }

    public void b() {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.a();
    }

    public void c() {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.b();
    }

    public void d() {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.c();
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TopProxyLayout topProxyLayout = this.f29520a;
            if (topProxyLayout != null) {
                return topProxyLayout.getCloseButton();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f() {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.d();
    }

    public void a(boolean z) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setShowDislike(z);
    }

    public void a(String str, CharSequence charSequence) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, charSequence) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.a(String.valueOf(str), charSequence);
    }

    public void a(com.bytedance.sdk.openadsdk.component.reward.top.b bVar) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setListener(bVar);
    }

    public void a(float f2) {
        TopProxyLayout topProxyLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || (topProxyLayout = this.f29520a) == null) {
            return;
        }
        topProxyLayout.setCloseButtonAlpha(f2);
    }
}
