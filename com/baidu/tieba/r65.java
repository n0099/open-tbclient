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
/* loaded from: classes7.dex */
public class r65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends e65>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948073592, "Lcom/baidu/tieba/r65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948073592, "Lcom/baidu/tieba/r65;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", q65.class);
        a.put("userIcon", p65.class);
        a.put("userGrowth", o65.class);
        a.put("newGod", k65.class);
        a.put("operateNew", l65.class);
        a.put("homeLiveRemind", j65.class);
        a.put("topNotify", m65.class);
        a.put("updateDialog", n65.class);
        a.put("lcUpdateDialog", i65.class);
        f65 f65Var = new f65();
        pk1<g65> pk1Var = f65Var.a;
        if (pk1Var != null && !ListUtils.isEmpty(pk1Var.getList())) {
            for (g65 g65Var : f65Var.a.getList()) {
                a.put(g65Var.name(), g65Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            v55 b = v55.b(str, str2);
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
