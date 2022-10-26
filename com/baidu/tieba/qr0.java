package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tieba.pr0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class qr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948101306, "Lcom/baidu/tieba/qr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948101306, "Lcom/baidu/tieba/qr0;");
                return;
            }
        }
        a = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sd", "hd", Config.STAT_SDK_CHANNEL, "1080p"});
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String mobileNetClarity = mz0.c();
            if (a.contains(mobileNetClarity)) {
                Intrinsics.checkNotNullExpressionValue(mobileNetClarity, "mobileNetClarity");
                return mobileNetClarity;
            }
            return "sd";
        }
        return (String) invokeV.objValue;
    }

    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String wifiClarity = mz0.e();
            if (a.contains(wifiClarity)) {
                Intrinsics.checkNotNullExpressionValue(wifiClarity, "wifiClarity");
                return wifiClarity;
            }
            return Config.STAT_SDK_CHANNEL;
        }
        return (String) invokeV.objValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TextUtils.equals("1", mz0.d())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final Pair a(ClarityUrlList list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            String b = b(true);
            int i = 0;
            String b2 = b(false);
            Iterator<E> it = list.iterator();
            int size = list.size() - 1;
            int i2 = 0;
            while (it.hasNext()) {
                ClarityUrlList.c entity = (ClarityUrlList.c) it.next();
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                if (TextUtils.equals(entity.c(), b)) {
                    i = i2;
                } else if (TextUtils.equals(entity.c(), b2)) {
                    size = i2;
                }
                i2++;
            }
            return new Pair(Integer.valueOf(size), Integer.valueOf(i));
        }
        return (Pair) invokeL.objValue;
    }

    public static final String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return f();
            }
            return e();
        }
        return (String) invokeZ.objValue;
    }

    public static final pr0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String a2 = mz0.a();
            if (a2 != null) {
                int hashCode = a2.hashCode();
                if (hashCode != 49) {
                    if (hashCode == 50 && a2.equals("2")) {
                        return pr0.a.a;
                    }
                } else if (a2.equals("1")) {
                    return pr0.b.a;
                }
            }
            return pr0.a.a;
        }
        return (pr0) invokeV.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String condition = mz0.b();
            for (String str : a) {
                Intrinsics.checkNotNullExpressionValue(condition, "condition");
                if (StringsKt__StringsKt.contains$default((CharSequence) condition, (CharSequence) str, false, 2, (Object) null)) {
                    return condition;
                }
            }
            return "1080p";
        }
        return (String) invokeV.objValue;
    }
}
