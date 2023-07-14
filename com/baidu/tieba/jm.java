package com.baidu.tieba;

import android.annotation.TargetApi;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class jm {
    public static /* synthetic */ Interceptable $ic;
    public static File a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448308426, "Lcom/baidu/tieba/jm;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448308426, "Lcom/baidu/tieba/jm;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                km.a(km.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = km.b(classLoader, "pathList").get(classLoader);
                List list = (List) km.b(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next()) || file.equals(jm.a)) {
                        it.remove();
                        break;
                    }
                    while (it.hasNext()) {
                    }
                }
                list.add(0, file);
                Collection collection = (List) km.b(obj, "systemNativeLibraryDirectories").get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                Method c = km.c(obj, "makePathElements", List.class, File.class, List.class);
                ArrayList arrayList = new ArrayList();
                list.addAll(collection);
                Object[] objArr = {list, null, arrayList};
                Field b = km.b(obj, "nativeLibraryPathElements");
                b.setAccessible(true);
                b.set(obj, (Object[]) c.invoke(obj, objArr));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = km.b(classLoader, "pathList").get(classLoader);
                List list = (List) km.b(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next()) || file.equals(jm.a)) {
                        it.remove();
                        break;
                    }
                    while (it.hasNext()) {
                    }
                }
                list.add(0, file);
                Collection collection = (List) km.b(obj, "systemNativeLibraryDirectories").get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                Method c = km.c(obj, "makePathElements", List.class);
                list.addAll(collection);
                Object[] objArr = {list};
                Field b = km.b(obj, "nativeLibraryPathElements");
                b.setAccessible(true);
                b.set(obj, (Object[]) c.invoke(obj, objArr));
            }
        }
    }

    @TargetApi(23)
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Build.VERSION.PREVIEW_SDK_INT;
            } catch (Throwable unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static synchronized boolean c(ClassLoader classLoader, File file) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, classLoader, file)) == null) {
            synchronized (jm.class) {
                boolean z = false;
                if (classLoader != null && file != null) {
                    if (file.exists()) {
                        int i = Build.VERSION.SDK_INT;
                        if ((i == 25 && b() != 0) || i > 25) {
                            z = true;
                        }
                        if (z) {
                            c.b(classLoader, file);
                        } else if (i >= 23) {
                            b.b(classLoader, file);
                        } else if (i >= 14) {
                            a.b(classLoader, file);
                        }
                        a = file;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean d(ClassLoader classLoader, String str) throws Throwable {
        InterceptResult invokeLL;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, classLoader, str)) == null) {
            synchronized (jm.class) {
                c2 = c(classLoader, new File(str));
            }
            return c2;
        }
        return invokeLL.booleanValue;
    }
}
