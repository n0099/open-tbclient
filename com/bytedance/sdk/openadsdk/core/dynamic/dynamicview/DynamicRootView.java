package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.theme.a;
/* loaded from: classes5.dex */
public class DynamicRootView extends FrameLayout implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f29990a;

    /* renamed from: b  reason: collision with root package name */
    public j f29991b;

    /* renamed from: c  reason: collision with root package name */
    public g f29992c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f29993d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.d.a f29994e;

    /* renamed from: f  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f29995f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicRootView(@NonNull Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, themeStatusBroadcastReceiver};
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
        p pVar = new p();
        this.f29990a = pVar;
        pVar.a(2);
        com.bytedance.sdk.openadsdk.core.dynamic.d.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.d.a();
        this.f29994e = aVar;
        aVar.a(this);
        this.f29995f = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.a(this);
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            DynamicBaseWidget dynamicBaseWidget = this.f29993d;
            return dynamicBaseWidget.f29983c > 0.0f && dynamicBaseWidget.f29984d > 0.0f;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29990a.a(this.f29993d.a() && c());
            this.f29990a.a(this.f29993d.f29983c);
            this.f29990a.b(this.f29993d.f29984d);
            this.f29991b.a(this.f29990a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.theme.a
    public void a_(int i2) {
        DynamicBaseWidget dynamicBaseWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (dynamicBaseWidget = this.f29993d) == null) {
            return;
        }
        dynamicBaseWidget.a(i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29990a.a(false);
            this.f29991b.a(this.f29990a);
        }
    }

    public com.bytedance.sdk.openadsdk.core.dynamic.d.a getDynamicClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29994e : (com.bytedance.sdk.openadsdk.core.dynamic.d.a) invokeV.objValue;
    }

    public g getExpressVideoListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29992c : (g) invokeV.objValue;
    }

    public j getRenderListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29991b : (j) invokeV.objValue;
    }

    public void setDislikeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.f29994e.b(view);
        }
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dynamicBaseWidget) == null) {
            this.f29993d = dynamicBaseWidget;
        }
    }

    public void setExpressVideoListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f29992c = gVar;
        }
    }

    public void setRenderListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            this.f29991b = jVar;
            this.f29994e.a(jVar);
        }
    }

    public void a(double d2, double d3, double d4, double d5, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Float.valueOf(f2)}) == null) {
            this.f29990a.c(d2);
            this.f29990a.d(d3);
            this.f29990a.e(d4);
            this.f29990a.f(d5);
            this.f29990a.a(f2);
            this.f29990a.b(f2);
            this.f29990a.c(f2);
            this.f29990a.d(f2);
        }
    }
}
