package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes6.dex */
public class x15 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends k15>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948247533, "Lcom/baidu/tieba/x15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948247533, "Lcom/baidu/tieba/x15;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", w15.class);
        a.put("userIcon", v15.class);
        a.put("userGrowth", u15.class);
        a.put("newGod", r15.class);
        a.put("operateNew", s15.class);
        a.put("homeLiveRemind", q15.class);
        a.put("updateDialog", t15.class);
        a.put("lcUpdateDialog", p15.class);
        a.put("sEventDialog", o15.class);
        l15 l15Var = new l15();
        ej1<m15> ej1Var = l15Var.a;
        if (ej1Var != null && !ListUtils.isEmpty(ej1Var.getList())) {
            for (m15 m15Var : l15Var.a.getList()) {
                a.put(m15Var.name(), m15Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            b15 b = b15.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                ng8 yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.b("YunDialogManager", "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                z05.r(str);
                e.printStackTrace();
            }
        }
    }
}
