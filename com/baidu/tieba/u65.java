package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes8.dex */
public class u65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends g65>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948162965, "Lcom/baidu/tieba/u65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948162965, "Lcom/baidu/tieba/u65;");
                return;
            }
        }
        a = new ArrayMap();
        if (j75.a.a()) {
            a.put("WebViewYunDialog", t65.class);
        } else {
            a.put("WebViewYunDialog", s65.class);
        }
        a.put("userIcon", r65.class);
        a.put("userGrowth", q65.class);
        a.put("newGod", m65.class);
        a.put("operateNew", n65.class);
        a.put("homeLiveRemind", l65.class);
        a.put("topNotify", o65.class);
        a.put("updateDialog", p65.class);
        a.put("lcUpdateDialog", k65.class);
        h65 h65Var = new h65();
        ok1<i65> ok1Var = h65Var.a;
        if (ok1Var != null && !ListUtils.isEmpty(ok1Var.getList())) {
            for (i65 i65Var : h65Var.a.getList()) {
                a.put(i65Var.name(), i65Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            u55 b = u55.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.e(YunDialogManager.LOG_KEY, "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                YunDialogManager.unMarkShowingDialogName(str);
                e.printStackTrace();
            }
        }
    }
}
