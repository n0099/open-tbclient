package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes6.dex */
public class r3 {
    public static /* synthetic */ Interceptable $ic;
    public static final r3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;

    public static int b(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (((int) (f * 255.0f)) << 24) | (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f)) : invokeCommon.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448314316, "Lcom/baidu/tieba/r3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448314316, "Lcom/baidu/tieba/r3;");
                return;
            }
        }
        e = new r3(1.0f, 1.0f, 1.0f, 1.0f);
        new r3(-1077952513);
        new r3(2139062271);
        new r3(1061109759);
        new r3(0.0f, 0.0f, 0.0f, 1.0f);
        e.f();
        new r3(0.0f, 0.0f, 0.0f, 0.0f);
        new r3(0.0f, 0.0f, 1.0f, 1.0f);
        new r3(0.0f, 0.0f, 0.5f, 1.0f);
        new r3(1097458175);
        new r3(1887473919);
        new r3(-2016482305);
        new r3(0.0f, 1.0f, 1.0f, 1.0f);
        new r3(0.0f, 0.5f, 0.5f, 1.0f);
        new r3((int) GeneratedTexture.MAGENTA);
        new r3(2147418367);
        new r3(852308735);
        new r3(579543807);
        new r3(1804477439);
        new r3(-65281);
        new r3(-2686721);
        new r3(-626712321);
        new r3(-5963521);
        new r3(-1958407169);
        new r3(-759919361);
        new r3(-1306385665);
        new r3(-16776961);
        new r3(-13361921);
        new r3(-8433409);
        new r3(-92245249);
        new r3(-9849601);
        new r3(1.0f, 0.0f, 1.0f, 1.0f);
        new r3(-1608453889);
        new r3(-293409025);
        new r3(-1339006721);
    }

    public r3() {
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

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f));
        }
        return invokeV.intValue;
    }

    public r3(float f, float f2, float f3, float f4) {
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

    public r3(int i) {
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

    public r3(r3 r3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r3Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        e(r3Var);
    }

    public static r3 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            r3 r3Var = new r3();
            i(str, r3Var);
            return r3Var;
        }
        return (r3) invokeL.objValue;
    }

    public r3 e(r3 r3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r3Var)) == null) {
            this.a = r3Var.a;
            this.b = r3Var.b;
            this.c = r3Var.c;
            this.d = r3Var.d;
            return this;
        }
        return (r3) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && r3.class == obj.getClass() && g() == ((r3) obj).g()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void c(r3 r3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, r3Var, i) == null) {
            r3Var.a = (((-16777216) & i) >>> 24) / 255.0f;
            r3Var.b = ((16711680 & i) >>> 16) / 255.0f;
            r3Var.c = ((65280 & i) >>> 8) / 255.0f;
            r3Var.d = (i & 255) / 255.0f;
        }
    }

    public static r3 i(String str, r3 r3Var) {
        InterceptResult invokeLL;
        float parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, r3Var)) == null) {
            if (str.charAt(0) == '#') {
                str = str.substring(1);
            }
            r3Var.a = Integer.parseInt(str.substring(0, 2), 16) / 255.0f;
            r3Var.b = Integer.parseInt(str.substring(2, 4), 16) / 255.0f;
            r3Var.c = Integer.parseInt(str.substring(4, 6), 16) / 255.0f;
            if (str.length() != 8) {
                parseInt = 1.0f;
            } else {
                parseInt = Integer.parseInt(str.substring(6, 8), 16) / 255.0f;
            }
            r3Var.d = parseInt;
            return r3Var;
        }
        return (r3) invokeLL.objValue;
    }

    public r3 a() {
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
        return (r3) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.a;
            int i4 = 0;
            if (f != 0.0f) {
                i = a8.a(f);
            } else {
                i = 0;
            }
            int i5 = i * 31;
            float f2 = this.b;
            if (f2 != 0.0f) {
                i2 = a8.a(f2);
            } else {
                i2 = 0;
            }
            int i6 = (i5 + i2) * 31;
            float f3 = this.c;
            if (f3 != 0.0f) {
                i3 = a8.a(f3);
            } else {
                i3 = 0;
            }
            int i7 = (i6 + i3) * 31;
            float f4 = this.d;
            if (f4 != 0.0f) {
                i4 = a8.a(f4);
            }
            return i7 + i4;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String hexString = Integer.toHexString((((int) (this.a * 255.0f)) << 24) | (((int) (this.b * 255.0f)) << 16) | (((int) (this.c * 255.0f)) << 8) | ((int) (this.d * 255.0f)));
            while (hexString.length() < 8) {
                hexString = "0" + hexString;
            }
            return hexString;
        }
        return (String) invokeV.objValue;
    }

    public r3 d(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            a();
            return this;
        }
        return (r3) invokeCommon.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return a8.c((((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f)));
        }
        return invokeV.floatValue;
    }
}
