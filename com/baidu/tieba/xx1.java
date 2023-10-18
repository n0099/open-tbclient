package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class xx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;
    public Map<String, Integer> b;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                return null;
            }
            return (Boolean) invokeL.objValue;
        }

        public static Double b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
                if (obj instanceof Double) {
                    return (Double) obj;
                }
                if (obj instanceof Number) {
                    return Double.valueOf(((Number) obj).doubleValue());
                }
                return null;
            }
            return (Double) invokeL.objValue;
        }

        public static Integer c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
                if (obj instanceof Integer) {
                    return (Integer) obj;
                }
                if (obj instanceof Number) {
                    return Integer.valueOf(((Number) obj).intValue());
                }
                return null;
            }
            return (Integer) invokeL.objValue;
        }

        public static yx1 d(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
                if (obj instanceof yx1) {
                    return (yx1) obj;
                }
                return null;
            }
            return (yx1) invokeL.objValue;
        }

        public static JsArrayBuffer e(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
                if (obj instanceof JsArrayBuffer) {
                    return (JsArrayBuffer) obj;
                }
                return null;
            }
            return (JsArrayBuffer) invokeL.objValue;
        }

        public static JsFunction f(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
                if (obj instanceof JsFunction) {
                    return (JsFunction) obj;
                }
                return null;
            }
            return (JsFunction) invokeL.objValue;
        }

        public static xx1 g(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
                if (obj instanceof xx1) {
                    return (xx1) obj;
                }
                return null;
            }
            return (xx1) invokeL.objValue;
        }

        public static Long h(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
                if (obj instanceof Long) {
                    return (Long) obj;
                }
                if (obj instanceof Number) {
                    return Long.valueOf(((Number) obj).longValue());
                }
                return null;
            }
            return (Long) invokeL.objValue;
        }

        public static String i(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public static JSTypeMismatchException j(xx1 xx1Var, String str, int i) {
            InterceptResult invokeLLI;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, xx1Var, str, i)) == null) {
                if (xx1Var.j().containsKey(str)) {
                    i2 = ((Integer) xx1Var.j().get(str)).intValue();
                } else {
                    i2 = 12;
                }
                return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
            }
            return (JSTypeMismatchException) invokeLLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948315640, "Lcom/baidu/tieba/xx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948315640, "Lcom/baidu/tieba/xx1;");
                return;
            }
        }
        c = am1.a;
    }

    public xx1() {
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

    public final Map<String, Object> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = new TreeMap();
            }
            return this.a;
        }
        return (Map) invokeV.objValue;
    }

    public final Map<String, Integer> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                this.b = new TreeMap();
            }
            return this.b;
        }
        return (Map) invokeV.objValue;
    }

    public Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return f().keySet();
        }
        return (Set) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return f().size();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return f().toString();
        }
        return (String) invokeV.objValue;
    }

    public static xx1 G(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsObject)) == null) {
            if (jsObject == null) {
                if (c) {
                    Log.e("JSObjectMap", "parseFromJSObject object is null.");
                    return null;
                }
                return null;
            }
            xx1 xx1Var = new xx1();
            boolean z = false;
            for (int i = 0; i < jsObject.length(); i++) {
                int propertyType = jsObject.getPropertyType(i);
                String propertyName = jsObject.getPropertyName(i);
                xx1Var.j().put(propertyName, Integer.valueOf(propertyType));
                switch (propertyType) {
                    case 1:
                        xx1Var.f().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                        break;
                    case 2:
                        xx1Var.f().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                        break;
                    case 3:
                        xx1Var.f().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                        break;
                    case 5:
                        xx1Var.f().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                        break;
                    case 6:
                        xx1Var.f().put(propertyName, new yx1(i, jsObject));
                        z = true;
                        break;
                    case 7:
                        xx1Var.f().put(propertyName, jsObject.toString(i));
                        break;
                    case 8:
                        xx1Var.f().put(propertyName, jsObject.toJsFunction(i));
                        break;
                    case 9:
                        xx1Var.f().put(propertyName, G(jsObject.toJsObject(i)));
                        break;
                    case 10:
                        xx1Var.f().put(propertyName, jsObject.toJsArrayBuffer(i));
                        break;
                }
            }
            if (!z) {
                jsObject.release();
            }
            return xx1Var;
        }
        return (xx1) invokeL.objValue;
    }

    public JsObject[] A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return B(str, null);
        }
        return (JsObject[]) invokeL.objValue;
    }

    public String C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return D(str, "");
        }
        return (String) invokeL.objValue;
    }

    public String[] E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return F(str, null);
        }
        return (String[]) invokeL.objValue;
    }

    public String I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return String.valueOf(f().get(str));
        }
        return (String) invokeL.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return j().containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public double c(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Double b = a.b(f().get(str));
            if (b != null) {
                return b.doubleValue();
            }
            throw a.j(this, str, 5);
        }
        return invokeL.doubleValue;
    }

    public int d(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Integer c2 = a.c(f().get(str));
            if (c2 != null) {
                return c2.intValue();
            }
            throw a.j(this, str, 2);
        }
        return invokeL.intValue;
    }

    public JsObject[] e(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            yx1 d = a.d(f().get(str));
            if (d != null) {
                return d.b.toObjectArray(d.a);
            }
            throw a.j(this, str, 6);
        }
        return (JsObject[]) invokeL.objValue;
    }

    public String g(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            String i = a.i(f().get(str));
            if (i != null) {
                return i;
            }
            throw a.j(this, str, 7);
        }
        return (String) invokeL.objValue;
    }

    public String[] h(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            yx1 d = a.d(f().get(str));
            if (d != null) {
                return d.b.toStringArray(d.a);
            }
            throw a.j(this, str, 6);
        }
        return (String[]) invokeL.objValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Integer num = j().get(str);
            if (num == null) {
                num = 12;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return n(str, false);
        }
        return invokeL.booleanValue;
    }

    public double[] p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            return q(str, null);
        }
        return (double[]) invokeL.objValue;
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return s(str, 0);
        }
        return invokeL.intValue;
    }

    public JsArrayBuffer t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            return u(str, null);
        }
        return (JsArrayBuffer) invokeL.objValue;
    }

    public JsFunction v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            return w(str, null);
        }
        return (JsFunction) invokeL.objValue;
    }

    public xx1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            return y(str, null);
        }
        return (xx1) invokeL.objValue;
    }

    public JsObject[] B(String str, JsObject[] jsObjectArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jsObjectArr)) == null) {
            yx1 d = a.d(f().get(str));
            if (d != null) {
                return d.b.toObjectArray(d.a);
            }
            return jsObjectArr;
        }
        return (JsObject[]) invokeLL.objValue;
    }

    public String D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String i = a.i(f().get(str));
            if (i != null) {
                return i;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public String[] F(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, strArr)) == null) {
            yx1 d = a.d(f().get(str));
            if (d != null) {
                return d.b.toStringArray(d.a);
            }
            return strArr;
        }
        return (String[]) invokeLL.objValue;
    }

    public void H(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, obj) == null) && !TextUtils.isEmpty(str) && obj != null) {
            f().put(str, obj);
        }
    }

    public boolean n(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, str, z)) == null) {
            Boolean a2 = a.a(f().get(str));
            if (a2 != null) {
                return a2.booleanValue();
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    public double[] q(String str, double[] dArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, dArr)) == null) {
            yx1 d = a.d(f().get(str));
            if (d != null) {
                return d.b.toDoubleArray(d.a);
            }
            return dArr;
        }
        return (double[]) invokeLL.objValue;
    }

    public int s(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, str, i)) == null) {
            Integer c2 = a.c(f().get(str));
            if (c2 != null) {
                return c2.intValue();
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public JsArrayBuffer u(String str, JsArrayBuffer jsArrayBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, jsArrayBuffer)) == null) {
            JsArrayBuffer e = a.e(f().get(str));
            if (e != null) {
                return e;
            }
            return jsArrayBuffer;
        }
        return (JsArrayBuffer) invokeLL.objValue;
    }

    public JsFunction w(String str, JsFunction jsFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, jsFunction)) == null) {
            JsFunction f = a.f(f().get(str));
            if (f != null) {
                return f;
            }
            return jsFunction;
        }
        return (JsFunction) invokeLL.objValue;
    }

    public xx1 y(String str, xx1 xx1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, str, xx1Var)) == null) {
            xx1 g = a.g(f().get(str));
            if (g != null) {
                return g;
            }
            return xx1Var;
        }
        return (xx1) invokeLL.objValue;
    }

    public long z(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048609, this, str, j)) == null) {
            Long h = a.h(f().get(str));
            if (h != null) {
                return h.longValue();
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public double o(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Double.valueOf(d)})) == null) {
            Double b = a.b(f().get(str));
            if (b != null) {
                return b.doubleValue();
            }
            return d;
        }
        return invokeCommon.doubleValue;
    }
}
