package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public final class qw {
    public static /* synthetic */ Interceptable $ic;
    public static final qw a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448315463, "Lcom/baidu/tieba/qw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448315463, "Lcom/baidu/tieba/qw;");
                return;
            }
        }
        a = new qw();
    }

    public qw() {
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

    @JvmStatic
    public static final int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.trim((CharSequence) str).toString(), new String[]{"."}, false, 0, 6, (Object) null);
            List<String> split$default2 = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.trim((CharSequence) str2).toString(), new String[]{"."}, false, 0, 6, (Object) null);
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (String str3 : split$default) {
                if (str3 != null) {
                    String obj = StringsKt__StringsKt.trim((CharSequence) str3).toString();
                    if (!Intrinsics.areEqual(obj, "")) {
                        linkedList.add(obj);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            for (String str4 : split$default2) {
                if (str4 != null) {
                    String obj2 = StringsKt__StringsKt.trim((CharSequence) str4).toString();
                    if (!Intrinsics.areEqual(obj2, "")) {
                        linkedList2.add(obj2);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            while (!linkedList.isEmpty() && !linkedList2.isEmpty()) {
                qw qwVar = a;
                Object pollFirst = linkedList.pollFirst();
                if (pollFirst == null) {
                    Intrinsics.throwNpe();
                }
                int e = qwVar.e((String) pollFirst);
                qw qwVar2 = a;
                Object pollFirst2 = linkedList2.pollFirst();
                if (pollFirst2 == null) {
                    Intrinsics.throwNpe();
                }
                int e2 = qwVar2.e((String) pollFirst2);
                if (e > e2) {
                    return 1;
                }
                if (e < e2) {
                    return -1;
                }
            }
            if (linkedList.isEmpty() && linkedList2.isEmpty()) {
                return 0;
            }
            while (!linkedList.isEmpty()) {
                if (!TextUtils.equals((CharSequence) linkedList.pollFirst(), "0")) {
                    return 1;
                }
            }
            while (!linkedList2.isEmpty()) {
                if (!TextUtils.equals((CharSequence) linkedList2.pollFirst(), "0")) {
                    return -1;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Intrinsics.areEqual(ds.c.h().getAppVersion(), "")) {
                String b = bu.b();
                Intrinsics.checkExpressionValueIsNotNull(b, "AppUtils.getVersionName()");
                return b;
            }
            return ds.c.h().getAppVersion();
        }
        return (String) invokeV.objValue;
    }

    public final boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (pw.a.a() <= j) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (a(b(), str) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
