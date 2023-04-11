package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class rd1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rd1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, td1> a;

    public rd1() {
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
        this.a = new HashMap();
    }

    public static rd1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (rd1.class) {
                    if (b == null) {
                        b = new rd1();
                    }
                }
            }
            return b;
        }
        return (rd1) invokeV.objValue;
    }

    public static <T> T[] a(Class<T> cls, Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, objArr, objArr2)) == null) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, objArr.length + objArr2.length));
            System.arraycopy(objArr, 0, tArr, 0, objArr.length);
            System.arraycopy(objArr2, 0, tArr, objArr.length, objArr2.length);
            return tArr;
        }
        return (T[]) ((Object[]) invokeLLL.objValue);
    }

    public static void e(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, field, obj, obj2) == null) {
            field.set(obj, c((Object[]) field.get(obj), (Object[]) field.get(obj2)));
        }
    }

    public static Object[] c(Object[] objArr, Object[] objArr2) throws IllegalArgumentException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, objArr, objArr2)) == null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(objArr));
            for (Object obj : objArr2) {
                if (!arrayList.contains(obj)) {
                    arrayList.add(obj);
                }
            }
            Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), arrayList.size());
            for (int i = 0; i < objArr3.length; i++) {
                objArr3[i] = arrayList.get(i);
            }
            return objArr3;
        }
        return (Object[]) invokeLL.objValue;
    }

    public static void f(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, field, obj, obj2) == null) {
            List list = (List) field.get(obj);
            list.addAll((List) field.get(obj2));
            field.set(obj, list);
            Field b2 = ge1.b(obj.getClass(), "nativeLibraryPathElements");
            b2.set(obj, c((Object[]) b2.get(obj), (Object[]) b2.get(obj2)));
        }
    }

    public static ClassLoader g(td1 td1Var, td1 td1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, td1Var, td1Var2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                h(td1Var, td1Var2);
                return td1Var;
            }
            return null;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public static ClassLoader h(td1 td1Var, td1 td1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, td1Var, td1Var2)) == null) {
            Field b2 = ge1.b(td1.class, "pathList");
            try {
                Object obj = b2.get(td1Var);
                Field b3 = ge1.b(obj.getClass(), "dexElements");
                Field b4 = ge1.b(obj.getClass(), "nativeLibraryDirectories");
                Object[] objArr = (Object[]) b3.get(obj);
                Object obj2 = b2.get(td1Var2);
                b3.set(obj, a(objArr.getClass().getComponentType(), objArr, (Object[]) b3.get(obj2)));
                if (Build.VERSION.SDK_INT >= 23) {
                    f(b4, obj, obj2);
                } else {
                    e(b4, obj, obj2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return td1Var;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public td1 b(BundleInfo bundleInfo, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundleInfo, context)) == null) {
            boolean z = !TextUtils.isEmpty(bundleInfo.getGroupName());
            td1 td1Var = new td1(be1.d(context, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), be1.f(context, bundleInfo.getPackageName()).getAbsolutePath(), be1.e(context, bundleInfo.getPackageName()).getAbsolutePath(), context);
            if (z && Build.VERSION.SDK_INT >= 21) {
                td1 td1Var2 = this.a.get(bundleInfo.getGroupName());
                if (td1Var2 == null) {
                    this.a.put(bundleInfo.getGroupName(), td1Var);
                    return td1Var;
                }
                g(td1Var2, td1Var);
                return td1Var2;
            }
            return td1Var;
        }
        return (td1) invokeLL.objValue;
    }
}
