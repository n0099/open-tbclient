package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public abstract class w23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;
    public Set<Integer> b;

    public abstract boolean a(Bitmap bitmap, Rect rect);

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static w23 a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                return b(str, 0.5d);
            }
            return (w23) invokeL.objValue;
        }

        public static w23 b(String str, double d) {
            InterceptResult invokeCommon;
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Double.valueOf(d)})) == null) {
                int hashCode = str.hashCode();
                if (hashCode != -2129978548) {
                    if (hashCode != -585839565) {
                        if (hashCode == 544848403 && str.equals("hsv_parser")) {
                            c = 1;
                        }
                        c = 65535;
                    } else {
                        if (str.equals("solid_parser")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (str.equals("simple_parser")) {
                        c = 0;
                    }
                    c = 65535;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            return new y23();
                        }
                        return new z23();
                    }
                    return new x23(d);
                }
                return new y23();
            }
            return (w23) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218641, "Lcom/baidu/tieba/w23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218641, "Lcom/baidu/tieba/w23;");
                return;
            }
        }
        c = ms1.a;
    }

    public w23() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1.0d;
    }

    public boolean b(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, rect)) == null) {
            if (bitmap == null || rect == null || rect.top < 0 || rect.bottom < 0 || rect.left < 0 || rect.right < 0) {
                return false;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = rect.top;
            int i2 = rect.bottom;
            if (i >= i2 || i2 > height) {
                return false;
            }
            int i3 = rect.left;
            int i4 = rect.right;
            if (i3 >= i4 || i4 > width) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Set<Integer> set = this.b;
            if (set == null) {
                this.b = new TreeSet();
            } else {
                set.clear();
            }
            if (c) {
                Log.d("ErrorPageParser", "set color " + String.format("#%06X", Integer.valueOf(16777215 & i)));
            }
            this.b.add(Integer.valueOf(i));
        }
    }
}
