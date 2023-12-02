package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, uri) == null) {
            b(uri);
        }
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return k(Uri.parse(d() + str));
        }
        return (String) invokeL.objValue;
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            t(str);
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            a(Uri.parse(d() + str));
        }
    }

    public static void b(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, uri) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e().delete(uri, null, null);
            } catch (SecurityException e) {
                BdLog.detailException(e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            sm5.m("deleteValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static boolean c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            return JavaTypesHelper.toBoolean(j(str), z);
        }
        return invokeLZ.booleanValue;
    }

    public static int f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            return JavaTypesHelper.toInt(j(str), i);
        }
        return invokeLI.intValue;
    }

    public static long g(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j)) == null) {
            return JavaTypesHelper.toLong(j(str), j);
        }
        return invokeLJ.longValue;
    }

    public static OrmObject h(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, cls)) == null) {
            if (str != null && cls != null) {
                return OrmObject.objectWithJsonStr(j(str), cls);
            }
            return null;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            String j = j(str);
            if (j != null) {
                return j;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void m(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            r(str, Boolean.valueOf(z));
        }
    }

    public static void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i) == null) {
            r(str, Integer.valueOf(i));
        }
    }

    public static void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65550, null, str, j) == null) {
            r(str, Long.valueOf(j));
        }
    }

    public static void p(String str, OrmObject ormObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, str, ormObject) == null) && str != null && ormObject != null) {
            r(str, OrmObject.jsonStrWithObject(ormObject));
        }
    }

    public static void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            r(str, str2);
        }
    }

    public static void r(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, obj) == null) {
            u(Uri.parse(d() + str), l(str, obj));
        }
    }

    public static void u(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, uri, contentValues) == null) {
            v(uri, contentValues);
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return SharedPrefHelper.getInstance().getContentPrefix();
        }
        return (String) invokeV.objValue;
    }

    public static ContentResolver e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return SharedPrefHelper.getInstance().getContentResolver();
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static String k(Uri uri) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = e().getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                str = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            sm5.m("getValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static ContentValues l(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, obj)) == null) {
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

    public static void v(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, uri, contentValues) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e().insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            sm5.m("setValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
        }
    }
}
