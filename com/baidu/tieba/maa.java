package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class maa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            String q = l95.q(str);
            return q + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static final boolean b(String str, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            String spCancelValue = l95.m().s(l95.q(str), "");
            Intrinsics.checkNotNullExpressionValue(spCancelValue, "spCancelValue");
            List<String> e = e(spCancelValue);
            if (e != null && !e.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                long g = tg.g(e.get(0), 0L);
                int e2 = tg.e(e.get(1), 0);
                if (TimeHelper.isSameDay(g, System.currentTimeMillis()) && e2 > i) {
                    return false;
                }
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static final boolean c(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str2 != null && str2.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
            return !TimeHelper.isSameDay(l95.m().o(a(str, str2), 0L), System.currentTimeMillis());
        }
        return invokeLL.booleanValue;
    }

    public static final void g(String spKey, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, spKey, str) == null) {
            Intrinsics.checkNotNullParameter(spKey, "spKey");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            l95.m().A(a(spKey, str), System.currentTimeMillis());
        }
    }

    public static final boolean d(LiveConfig config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, config)) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (TbadkCoreApplication.isLogin() && c("sp_live_cancel_id_", config.getCurrentId()) && c("sp_live_into_id_", config.getCurrentId()) && b("sp_live_click_cancel_key", config.getCloseMax()) && b("sp_live_day_show_auto_in_key", config.getShowMax()) && TbSingleton.getInstance().autoInLiveRoomTimes < config.getSingleMax()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final List<String> e(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 long), (',' char), (r4v2 int)] */
    public static final void f(String spKey) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, spKey) == null) {
            Intrinsics.checkNotNullParameter(spKey, "spKey");
            long currentTimeMillis = System.currentTimeMillis();
            String spCancelValue = l95.m().s(l95.q(spKey), "");
            Intrinsics.checkNotNullExpressionValue(spCancelValue, "spCancelValue");
            List<String> e = e(spCancelValue);
            int i = 1;
            if (e != null && !e.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                long g = tg.g(e.get(0), 0L);
                int e2 = tg.e(e.get(1), 0);
                if (TimeHelper.isSameDay(g, System.currentTimeMillis())) {
                    i = 1 + e2;
                }
            }
            l95 m = l95.m();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis);
            sb.append(',');
            sb.append(i);
            m.B(spKey, sb.toString());
        }
    }
}
