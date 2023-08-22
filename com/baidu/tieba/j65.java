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
/* loaded from: classes6.dex */
public class j65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends x55>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835264, "Lcom/baidu/tieba/j65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835264, "Lcom/baidu/tieba/j65;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", i65.class);
        a.put("userIcon", h65.class);
        a.put("userGrowth", g65.class);
        a.put("newGod", d65.class);
        a.put("operateNew", e65.class);
        a.put("homeLiveRemind", c65.class);
        a.put("updateDialog", f65.class);
        a.put("lcUpdateDialog", b65.class);
        y55 y55Var = new y55();
        lk1<z55> lk1Var = y55Var.a;
        if (lk1Var != null && !ListUtils.isEmpty(lk1Var.getList())) {
            for (z55 z55Var : y55Var.a.getList()) {
                a.put(z55Var.name(), z55Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            p55 b = p55.b(str, str2);
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
