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
    public p f66684a;

    /* renamed from: b  reason: collision with root package name */
    public o f66685b;

    /* renamed from: c  reason: collision with root package name */
    public i f66686c;

    /* renamed from: d  reason: collision with root package name */
    public DynamicBaseWidget f66687d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.d.a f66688e;

    /* renamed from: f  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f66689f;

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
        this.f66684a = pVar;
        pVar.a(2);
        com.bytedance.sdk.openadsdk.core.dynamic.d.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.d.a();
        this.f66688e = aVar;
        aVar.a(this);
        this.f66689f = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.a(this);
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            DynamicBaseWidget dynamicBaseWidget = this.f66687d;
            return dynamicBaseWidget.f66675c > 0.0f && dynamicBaseWidget.f66676d > 0.0f;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66684a.a(this.f66687d.a() && c());
            this.f66684a.a(this.f66687d.f66675c);
            this.f66684a.b(this.f66687d.f66676d);
            this.f66685b.a(this.f66684a);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f66684a.a(false);
            this.f66685b.a(this.f66684a);
        }
    }

    public com.bytedance.sdk.openadsdk.core.dynamic.d.a getDynamicClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66688e : (com.bytedance.sdk.openadsdk.core.dynamic.d.a) invokeV.objValue;
    }

    public i getExpressVideoListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66686c : (i) invokeV.objValue;
    }

    public o getRenderListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66685b : (o) invokeV.objValue;
    }

    public void setDislikeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.f66688e.b(view);
        }
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dynamicBaseWidget) == null) {
            this.f66687d = dynamicBaseWidget;
        }
    }

    public void setExpressVideoListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            this.f66686c = iVar;
        }
    }

    public void setRenderListener(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oVar) == null) {
            this.f66685b = oVar;
            this.f66688e.a(oVar);
        }
    }

    public void a(double d2, double d3, double d4, double d5, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Float.valueOf(f2)}) == null) {
            this.f66684a.c(d2);
            this.f66684a.d(d3);
            this.f66684a.e(d4);
            this.f66684a.f(d5);
            this.f66684a.a(f2);
            this.f66684a.b(f2);
            this.f66684a.c(f2);
            this.f66684a.d(f2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.theme.a
    public void a(int i2) {
        DynamicBaseWidget dynamicBaseWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (dynamicBaseWidget = this.f66687d) == null) {
            return;
        }
        dynamicBaseWidget.a(i2);
    }
}
