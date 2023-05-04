package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return f55.m().j();
        }
        return (String) invokeV.objValue;
    }

    public static ContentResolver b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return f55.m().k();
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static int c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            return gg.e(f(str), i);
        }
        return invokeLI.intValue;
    }

    public static OrmObject d(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, cls)) == null) {
            if (str != null && cls != null) {
                return OrmObject.objectWithJsonStr(f(str), cls);
            }
            return null;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            String f = f(str);
            if (f != null) {
                return f;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void i(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, str, i) == null) {
            k(str, Integer.valueOf(i));
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            k(str, str2);
        }
    }

    public static void k(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, obj) == null) {
            l(Uri.parse(a() + str), h(str, obj));
        }
    }

    public static void l(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, uri, contentValues) == null) {
            m(uri, contentValues);
        }
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return g(Uri.parse(a() + str));
        }
        return (String) invokeL.objValue;
    }

    public static String g(Uri uri) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uri)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = b().getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                str = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            tj5.m("getValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static ContentValues h(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, obj)) == null) {
            ContentValues contentValues = new ContentValues();
            String str2 = null;
            if (obj != null) {
                if (obj instanceof String) {
                    str2 = (String) obj;
                } else if (obj instanceof Boolean) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Integer) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Long) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Float) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Double) {
                    str2 = String.valueOf(obj);
                }
            }
            contentValues.put(str, str2);
            return contentValues;
        }
        return (ContentValues) invokeLL.objValue;
    }

    public static void m(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, uri, contentValues) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                b().insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            tj5.m("setValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
        }
    }
}
