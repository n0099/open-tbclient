package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class rj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948123471, "Lcom/baidu/tieba/rj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948123471, "Lcom/baidu/tieba/rj2;");
                return;
            }
        }
        a = qr1.a;
    }

    @Nullable
    public static Set<String> a(int i, List<String> list) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, list)) == null) {
            if (list != null && !list.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (f83 f83Var : h83.k().q()) {
                    String appId = f83Var.getAppId();
                    if (TextUtils.isEmpty(appId)) {
                        appId = f83Var.N();
                    }
                    if (!f83Var.E() && !f83Var.Q()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (f83Var.T() && z && list.contains(appId)) {
                        w73 e = w73.e();
                        y73 y73Var = new y73(i);
                        y73Var.b(f83Var.b);
                        e.h(y73Var);
                        hashSet.add(appId);
                        if (a) {
                            Log.i("PurgerUtils", "sent msg(" + i + ") to active swan(" + appId + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                }
                return hashSet;
            }
            return null;
        }
        return (Set) invokeIL.objValue;
    }

    public static void b(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{file, str, str2, set, Boolean.valueOf(z)}) == null) {
            c(file, str, str2, set, z, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z, @Nullable pv3<Pair<String, File>> pv3Var) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, set, Boolean.valueOf(z), pv3Var}) == null) && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(str2)) {
                    int length = name.length();
                    int length2 = str.length();
                    int length3 = str2.length();
                    if (length >= length2 + length3) {
                        String substring = name.substring(length2, length - length3);
                        if (set == null) {
                            set = Collections.emptySet();
                        }
                        if (!TextUtils.isEmpty(substring)) {
                            if (z) {
                                if (set.contains(substring)) {
                                }
                                if (a) {
                                    Log.i("PurgerUtils", "clearByDeleteFiles : " + substring);
                                }
                                if (pv3Var == null) {
                                    pv3Var.run(Pair.create(str + substring, file2));
                                } else {
                                    kr4.L(file2);
                                }
                            } else {
                                if (!set.contains(substring)) {
                                }
                                if (a) {
                                }
                                if (pv3Var == null) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static Set<String> d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                return a(106, list);
            }
            return null;
        }
        return (Set) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArraySet<String> e(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        InterceptResult invokeCommon;
        File[] listFiles;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{file, str, str2, set, Boolean.valueOf(z)})) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(str2)) {
                        int length = name.length();
                        int length2 = str.length();
                        int length3 = str2.length();
                        if (length >= length2 + length3) {
                            String substring = name.substring(length2, length - length3);
                            if (set == null) {
                                set = Collections.emptySet();
                            }
                            if (!TextUtils.isEmpty(substring)) {
                                if (z) {
                                    if (set.contains(substring)) {
                                    }
                                    J = kr4.J(file2);
                                    if (a) {
                                        Log.i("PurgerUtils", "originFile:" + file2.getAbsolutePath() + ", renameFile:" + J);
                                    }
                                    if (TextUtils.isEmpty(J)) {
                                        arraySet.add(J);
                                    }
                                } else {
                                    if (!set.contains(substring)) {
                                    }
                                    J = kr4.J(file2);
                                    if (a) {
                                    }
                                    if (TextUtils.isEmpty(J)) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arraySet;
        }
        return (ArraySet) invokeCommon.objValue;
    }
}
