package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class u46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Canvas a;
    public Bitmap b;
    public int c;
    public int d;

    public u46() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Canvas();
        this.b = f66.b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b.isRecycled()) {
            return;
        }
        this.b.eraseColor(0);
    }

    public final Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final Canvas d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (Canvas) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || Intrinsics.areEqual(this.b, f66.b())) {
            return;
        }
        this.a.setBitmap(null);
        this.b = f66.b();
        this.c = 0;
        this.d = 0;
    }

    public final void a(int i, int i2, int i3, boolean z, int i4) {
        boolean z2;
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            if (!z ? !(i > this.c || i2 > this.d) : !(i != this.c || i2 != this.d)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!Intrinsics.areEqual(this.b, f66.b()) && !this.b.isRecycled() && z2) {
                this.b.eraseColor(0);
                this.a.setBitmap(this.b);
                return;
            }
            this.c = Math.max(1, i);
            this.d = Math.max(1, i2);
            if (i4 == 32) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.ARGB_4444;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.c, this.d, config);
                if (i3 > 0) {
                    createBitmap.setDensity(i3);
                }
                d().setBitmap(createBitmap);
                d().setDensity(i3);
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, heig…y = density\n            }");
                this.b = createBitmap;
            } catch (Exception unused) {
                this.b = f66.b();
                this.a.setBitmap(null);
                this.c = 0;
                this.d = 0;
            }
        }
    }
}
