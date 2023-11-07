package com.baidu.tieba;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class k0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public float f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;

    public k0() {
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
        this.a = new RectF();
        this.b = 51;
        this.c = true;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(float f, float f2, Function2<? super Integer, ? super Integer, Unit> callback) {
        int i;
        int i2;
        int i3;
        int width;
        int height;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f = f;
            this.g = f2;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.b, 0);
            int i4 = this.b & 112;
            int i5 = absoluteGravity & 7;
            if (i5 != 5) {
                if (i5 != 8388613) {
                    i2 = this.d;
                    this.j = i2;
                    if (i4 != 80) {
                        i3 = -this.e;
                    } else {
                        i3 = this.e;
                    }
                    this.k = i3;
                    float f9 = 0.0f;
                    if (i5 == 1) {
                        if (i5 != 5) {
                            if (i5 != 8388613) {
                                float f10 = this.a.left + this.j;
                                if (this.c) {
                                    f8 = 0.0f;
                                } else {
                                    f8 = this.f / 2;
                                }
                                f7 = f10 + f8;
                                width = (int) f7;
                            } else {
                                f4 = this.a.right + this.j;
                                if (!this.c) {
                                    f5 = this.f;
                                    f6 = f5 / 2;
                                }
                                f6 = 0.0f;
                            }
                        } else {
                            f4 = this.a.right + this.j;
                            if (!this.c) {
                                f5 = this.f;
                                f6 = f5 / 2;
                            }
                            f6 = 0.0f;
                        }
                        f7 = f4 - f6;
                        width = (int) f7;
                    } else {
                        RectF rectF = this.a;
                        width = (int) (rectF.left + (rectF.width() / 2) + this.j);
                    }
                    if (i4 == 16) {
                        if (i4 != 80) {
                            float f11 = this.a.top + this.k;
                            if (!this.c) {
                                f9 = this.g / 2;
                            }
                            f3 = f11 + f9;
                        } else {
                            float f12 = this.a.bottom + this.k;
                            if (!this.c) {
                                f9 = this.g / 2;
                            }
                            f3 = f12 - f9;
                        }
                        height = (int) f3;
                    } else {
                        RectF rectF2 = this.a;
                        height = (int) (rectF2.top + (rectF2.height() / 2) + this.k);
                    }
                    float f13 = 2;
                    this.h = (int) (width - (this.f / f13));
                    this.i = (int) (height - (this.g / f13));
                    callback.invoke(Integer.valueOf(width), Integer.valueOf(height));
                }
                i = this.d;
            } else {
                i = this.d;
            }
            i2 = -i;
            this.j = i2;
            if (i4 != 80) {
            }
            this.k = i3;
            float f92 = 0.0f;
            if (i5 == 1) {
            }
            if (i4 == 16) {
            }
            float f132 = 2;
            this.h = (int) (width - (this.f / f132));
            this.i = (int) (height - (this.g / f132));
            callback.invoke(Integer.valueOf(width), Integer.valueOf(height));
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b = i;
        }
    }

    public final void h(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rect) == null) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.a.set(rect);
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.e = i;
        }
    }
}
