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
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.nativeexpress.o;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.theme.a;
/* loaded from: classes9.dex */
public class DynamicRootView extends FrameLayout implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f65993a;

    /* renamed from: b  reason: collision with root package name */
    public o f65994b;

    /* renamed from: c  reason: collision with root package name */
    public i f65995c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f65996d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.d.a f65997e;

    /* renamed from: f  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f65998f;

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
        this.f65993a = pVar;
        pVar.a(2);
        com.bytedance.sdk.openadsdk.core.dynamic.d.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.d.a();
        this.f65997e = aVar;
        aVar.a(this);
        this.f65998f = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.a(this);
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            DynamicBaseWidget dynamicBaseWidget = this.f65996d;
            return dynamicBaseWidget.f65984c > 0.0f && dynamicBaseWidget.f65985d > 0.0f;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65993a.a(this.f65996d.a() && c());
            this.f65993a.a(this.f65996d.f65984c);
            this.f65993a.b(this.f65996d.f65985d);
            this.f65994b.a(this.f65993a);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f65993a.a(false);
            this.f65994b.a(this.f65993a);
        }
    }

    public com.bytedance.sdk.openadsdk.core.dynamic.d.a getDynamicClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65997e : (com.bytedance.sdk.openadsdk.core.dynamic.d.a) invokeV.objValue;
    }

    public i getExpressVideoListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65995c : (i) invokeV.objValue;
    }

    public o getRenderListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f65994b : (o) invokeV.objValue;
    }

    public void setDislikeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.f65997e.b(view);
        }
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dynamicBaseWidget) == null) {
            this.f65996d = dynamicBaseWidget;
        }
    }

    public void setExpressVideoListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            this.f65995c = iVar;
        }
    }

    public void setRenderListener(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oVar) == null) {
            this.f65994b = oVar;
            this.f65997e.a(oVar);
        }
    }

    public void a(double d2, double d3, double d4, double d5, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Float.valueOf(f2)}) == null) {
            this.f65993a.c(d2);
            this.f65993a.d(d3);
            this.f65993a.e(d4);
            this.f65993a.f(d5);
            this.f65993a.a(f2);
            this.f65993a.b(f2);
            this.f65993a.c(f2);
            this.f65993a.d(f2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.theme.a
    public void a(int i2) {
        DynamicBaseWidget dynamicBaseWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (dynamicBaseWidget = this.f65996d) == null) {
            return;
        }
        dynamicBaseWidget.a(i2);
    }
}
