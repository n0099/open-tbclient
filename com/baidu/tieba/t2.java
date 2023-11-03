package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes8.dex */
public class t2 {
    public static /* synthetic */ Interceptable $ic;
    public static final t2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;

    public static int b(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (((int) (f * 255.0f)) << 24) | (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f)) : invokeCommon.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448316207, "Lcom/baidu/tieba/t2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448316207, "Lcom/baidu/tieba/t2;");
                return;
            }
        }
        e = new t2(1.0f, 1.0f, 1.0f, 1.0f);
        new t2(-1077952513);
        new t2(2139062271);
        new t2(1061109759);
        new t2(0.0f, 0.0f, 0.0f, 1.0f);
        e.d();
        new t2(0.0f, 0.0f, 0.0f, 0.0f);
        new t2(0.0f, 0.0f, 1.0f, 1.0f);
        new t2(0.0f, 0.0f, 0.5f, 1.0f);
        new t2(1097458175);
        new t2(1887473919);
        new t2(-2016482305);
        new t2(0.0f, 1.0f, 1.0f, 1.0f);
        new t2(0.0f, 0.5f, 0.5f, 1.0f);
        new t2(GeneratedTexture.MAGENTA);
        new t2(2147418367);
        new t2(852308735);
        new t2(579543807);
        new t2(1804477439);
        new t2(-65281);
        new t2(-2686721);
        new t2(-626712321);
        new t2(-5963521);
        new t2(-1958407169);
        new t2(-759919361);
        new t2(-1306385665);
        new t2(BaseAnimatedElement.DEBUG_PAINT_COLOR);
        new t2(-13361921);
        new t2(-8433409);
        new t2(-92245249);
        new t2(-9849601);
        new t2(1.0f, 0.0f, 1.0f, 1.0f);
        new t2(-1608453889);
        new t2(-293409025);
        new t2(-1339006721);
    }

    public t2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f));
        }
        return invokeV.intValue;
    }

    public t2(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        a();
    }

    public t2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        c(this, i);
    }

    public static void c(t2 t2Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, t2Var, i) == null) {
            t2Var.a = (((-16777216) & i) >>> 24) / 255.0f;
            t2Var.b = ((16711680 & i) >>> 16) / 255.0f;
            t2Var.c = ((65280 & i) >>> 8) / 255.0f;
            t2Var.d = (i & 255) / 255.0f;
        }
    }

    public t2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f = this.a;
            if (f < 0.0f) {
                this.a = 0.0f;
            } else if (f > 1.0f) {
                this.a = 1.0f;
            }
            float f2 = this.b;
            if (f2 < 0.0f) {
                this.b = 0.0f;
            } else if (f2 > 1.0f) {
                this.b = 1.0f;
            }
            float f3 = this.c;
            if (f3 < 0.0f) {
                this.c = 0.0f;
            } else if (f3 > 1.0f) {
                this.c = 1.0f;
            }
            float f4 = this.d;
            if (f4 < 0.0f) {
                this.d = 0.0f;
            } else if (f4 > 1.0f) {
                this.d = 1.0f;
            }
            return this;
        }
        return (t2) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.a;
            int i4 = 0;
            if (f != 0.0f) {
                i = p3.a(f);
            } else {
                i = 0;
            }
            int i5 = i * 31;
            float f2 = this.b;
            if (f2 != 0.0f) {
                i2 = p3.a(f2);
            } else {
                i2 = 0;
            }
            int i6 = (i5 + i2) * 31;
            float f3 = this.c;
            if (f3 != 0.0f) {
                i3 = p3.a(f3);
            } else {
                i3 = 0;
            }
            int i7 = (i6 + i3) * 31;
            float f4 = this.d;
            if (f4 != 0.0f) {
                i4 = p3.a(f4);
            }
            return i7 + i4;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String hexString = Integer.toHexString((((int) (this.a * 255.0f)) << 24) | (((int) (this.b * 255.0f)) << 16) | (((int) (this.c * 255.0f)) << 8) | ((int) (this.d * 255.0f)));
            while (hexString.length() < 8) {
                hexString = "0" + hexString;
            }
            return hexString;
        }
        return (String) invokeV.objValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return p3.c((((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f)));
        }
        return invokeV.floatValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && t2.class == obj.getClass() && e() == ((t2) obj).e()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
