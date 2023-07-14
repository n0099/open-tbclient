package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
/* loaded from: classes8.dex */
public final class uc0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, List<tc0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    @JvmOverloads
    public static final tc0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(null, str, 1, null) : (tc0) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206055, "Lcom/baidu/tieba/uc0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206055, "Lcom/baidu/tieba/uc0;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
    }

    @JvmStatic
    @JvmOverloads
    public static final tc0 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            LiveFeedPageSdk.liveLog("LiveFeedPlayerPool", "getPlayer pageId= " + str2 + WebvttCueParser.CHAR_SPACE + a.size());
            List<tc0> list = a.get(str2);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.isEmpty() && list.size() >= 2) {
                tc0 tc0Var = list.get(0);
                Collections.swap(list, 0, 1);
                if (tc0Var.isPlaying()) {
                    tc0Var.detachFromContainer();
                    tc0Var.stop();
                }
                LiveFeedPageSdk.liveLog("LiveFeedPlayerPool", "getPlayer " + tc0Var);
                return tc0Var;
            }
            tc0 tc0Var2 = new tc0(new vc0(str, 0, null, null, 14, null));
            list.add(tc0Var2);
            a.put(str2, list);
            return tc0Var2;
        }
        return (tc0) invokeLL.objValue;
    }

    public static /* synthetic */ tc0 c(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return b(str, str2);
    }

    @JvmStatic
    public static final void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            LiveFeedPageSdk.liveLog("LiveFeedPlayerPool", "release playerMap= " + a.size());
            List<tc0> list = a.get(str);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            for (tc0 tc0Var : list) {
                tc0Var.detachFromContainer();
                tc0Var.release();
            }
            list.clear();
            a.remove(str);
        }
    }
}
