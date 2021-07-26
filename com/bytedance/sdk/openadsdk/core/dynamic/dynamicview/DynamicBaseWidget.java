package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dynamic.b.e;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.a;
import com.bytedance.sdk.openadsdk.q.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class DynamicBaseWidget extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f30080a;

    /* renamed from: b  reason: collision with root package name */
    public float f30081b;

    /* renamed from: c  reason: collision with root package name */
    public float f30082c;

    /* renamed from: d  reason: collision with root package name */
    public float f30083d;

    /* renamed from: e  reason: collision with root package name */
    public int f30084e;

    /* renamed from: f  reason: collision with root package name */
    public int f30085f;

    /* renamed from: g  reason: collision with root package name */
    public int f30086g;

    /* renamed from: h  reason: collision with root package name */
    public int f30087h;

    /* renamed from: i  reason: collision with root package name */
    public Context f30088i;
    public e j;
    public f k;
    public List<DynamicBaseWidget> l;
    public DynamicRootView m;
    public View n;
    public boolean o;
    public boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicBaseWidget(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dynamicRootView, fVar};
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
        this.p = true;
        this.f30088i = context;
        this.m = dynamicRootView;
        this.k = fVar;
        this.f30080a = fVar.a();
        this.f30081b = fVar.b();
        this.f30082c = fVar.c();
        this.f30083d = fVar.d();
        this.f30086g = (int) s.b(this.f30088i, this.f30080a);
        this.f30087h = (int) s.b(this.f30088i, this.f30081b);
        this.f30084e = (int) s.b(this.f30088i, this.f30082c);
        this.f30085f = (int) s.b(this.f30088i, this.f30083d);
        e eVar = new e(fVar.e());
        this.j = eVar;
        this.o = eVar.l() > 0;
    }

    public void a(DynamicBaseWidget dynamicBaseWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dynamicBaseWidget) == null) {
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (dynamicBaseWidget == null) {
                return;
            }
            dynamicBaseWidget.setShouldInvisible(this.o);
            this.l.add(dynamicBaseWidget);
        }
    }

    public abstract boolean b();

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean b2 = b();
            try {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f30084e, this.f30085f);
                k.f("DynamicBaseWidget", "widget mDynamicView:" + this.n);
                k.f("DynamicBaseWidget", "mDynamicView x,y,w,h:" + this.f30080a + "," + this.f30081b + "," + this.f30084e + "," + this.f30085f);
                layoutParams.topMargin = this.f30087h;
                layoutParams.leftMargin = this.f30086g;
                this.m.addView(this, layoutParams);
                return b2;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e eVar = this.j;
            return (eVar == null || eVar.q() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public Drawable getBackgroundDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(s.b(this.f30088i, this.j.m()));
            gradientDrawable.setColor(this.j.r());
            gradientDrawable.setStroke((int) s.b(this.f30088i, this.j.o()), this.j.n());
            return gradientDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getClickArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j.q() : invokeV.intValue;
    }

    public a getDynamicClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m.getDynamicClickListener() : (a) invokeV.objValue;
    }

    public void setLayoutUnit(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void setShouldInvisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean d2 = d();
            boolean c2 = c();
            if (!d2 || !c2) {
                this.p = false;
            }
            List<DynamicBaseWidget> list = this.l;
            if (list != null) {
                for (DynamicBaseWidget dynamicBaseWidget : list) {
                    if (!dynamicBaseWidget.a()) {
                        this.p = false;
                    }
                }
            }
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public void a(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.l == null || (eVar = this.j) == null || !eVar.a(i2)) {
            return;
        }
        b();
        if (this instanceof DynamicDislike) {
            ((DynamicDislike) this).b(i2);
        }
        for (DynamicBaseWidget dynamicBaseWidget : this.l) {
            dynamicBaseWidget.a(i2);
        }
    }
}
