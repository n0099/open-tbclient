package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h2.p.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FallingView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c> f19988e;

    /* renamed from: f  reason: collision with root package name */
    public int f19989f;

    /* renamed from: g  reason: collision with root package name */
    public int f19990g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19991h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f19992i;
    public Handler j;
    public Paint k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FallingView(Context context) {
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
        this.f19991h = false;
        this.f19992i = new Runnable() { // from class: d.a.q0.h2.p.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    FallingView.this.d();
                }
            }
        };
        this.j = new Handler();
        b();
    }

    public void a(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            if (this.f19989f == 0) {
                this.f19989f = l.k(getContext());
            }
            if (this.f19990g == 0) {
                this.f19990g = l.i(getContext());
            }
            for (int i3 = 0; i3 < i2; i3++) {
                c cVar2 = new c(cVar.f58456i, this.f19989f, this.f19990g);
                cVar2.f58452e = (-i3) * 180;
                this.f19988e.add(cVar2);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19988e = new ArrayList();
            Paint paint = new Paint();
            this.k = paint;
            paint.setDither(true);
            setLayerType(1, null);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19991h : invokeV.booleanValue;
    }

    public /* synthetic */ void d() {
        invalidate();
    }

    public final int e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        return invokeII.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f19991h = true;
            invalidate();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19991h = false;
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.f19992i);
            }
            this.f19988e.clear();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onDraw(canvas);
            if (this.f19988e.size() > 0) {
                for (int i2 = 0; i2 < this.f19988e.size(); i2++) {
                    this.f19988e.get(i2).b(canvas, this.k);
                }
                this.j.postDelayed(this.f19992i, (currentTimeMillis + 5) - System.currentTimeMillis());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int e2 = e(1000, i3);
            int e3 = e(600, i2);
            setMeasuredDimension(e3, e2);
            this.f19989f = e3;
            this.f19990g = e2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FallingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19991h = false;
        this.f19992i = new Runnable() { // from class: d.a.q0.h2.p.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    FallingView.this.d();
                }
            }
        };
        this.j = new Handler();
        b();
    }
}
