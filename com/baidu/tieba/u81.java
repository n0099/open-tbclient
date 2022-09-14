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
public class u81 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u81 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, w81> a;

    public u81() {
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

    public static u81 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (u81.class) {
                    if (b == null) {
                        b = new u81();
                    }
                }
            }
            return b;
        }
        return (u81) invokeV.objValue;
    }

    public static void e(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, field, obj, obj2) == null) {
            field.set(obj, c((Object[]) field.get(obj), (Object[]) field.get(obj2)));
        }
    }

    public static void f(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, field, obj, obj2) == null) {
            List list = (List) field.get(obj);
            list.addAll((List) field.get(obj2));
            field.set(obj, list);
            Field b2 = j91.b(obj.getClass(), "nativeLibraryPathElements");
            b2.set(obj, c((Object[]) b2.get(obj), (Object[]) b2.get(obj2)));
        }
    }

    public static ClassLoader g(w81 w81Var, w81 w81Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, w81Var, w81Var2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                h(w81Var, w81Var2);
                return w81Var;
            }
            return null;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public static ClassLoader h(w81 w81Var, w81 w81Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, w81Var, w81Var2)) == null) {
            Field b2 = j91.b(w81.class, "pathList");
            try {
                Object obj = b2.get(w81Var);
                Field b3 = j91.b(obj.getClass(), "dexElements");
                Field b4 = j91.b(obj.getClass(), "nativeLibraryDirectories");
                Object[] objArr = (Object[]) b3.get(obj);
                Object obj2 = b2.get(w81Var2);
                b3.set(obj, a(objArr.getClass().getComponentType(), objArr, (Object[]) b3.get(obj2)));
                if (Build.VERSION.SDK_INT >= 23) {
                    f(b4, obj, obj2);
                } else {
                    e(b4, obj, obj2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return w81Var;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public w81 b(BundleInfo bundleInfo, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundleInfo, context)) == null) {
            boolean z = !TextUtils.isEmpty(bundleInfo.getGroupName());
            w81 w81Var = new w81(e91.d(context, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), e91.f(context, bundleInfo.getPackageName()).getAbsolutePath(), e91.e(context, bundleInfo.getPackageName()).getAbsolutePath(), context);
            if (!z || Build.VERSION.SDK_INT < 21) {
                return w81Var;
            }
            w81 w81Var2 = this.a.get(bundleInfo.getGroupName());
            if (w81Var2 == null) {
                this.a.put(bundleInfo.getGroupName(), w81Var);
                return w81Var;
            }
            g(w81Var2, w81Var);
            return w81Var2;
        }
        return (w81) invokeLL.objValue;
    }
}
