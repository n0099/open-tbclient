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
public class u15 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends g15>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948158160, "Lcom/baidu/tieba/u15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948158160, "Lcom/baidu/tieba/u15;");
                return;
            }
        }
        a = new ArrayMap();
        if (l25.a.a()) {
            a.put("WebViewYunDialog", t15.class);
        } else {
            a.put("WebViewYunDialog", s15.class);
        }
        a.put("userIcon", r15.class);
        a.put("userGrowth", q15.class);
        a.put("newGod", m15.class);
        a.put("operateNew", n15.class);
        a.put("homeLiveRemind", l15.class);
        a.put("topNotify", o15.class);
        a.put("updateDialog", p15.class);
        a.put("lcUpdateDialog", k15.class);
        h15 h15Var = new h15();
        pf1<i15> pf1Var = h15Var.a;
        if (pf1Var != null && !ListUtils.isEmpty(pf1Var.getList())) {
            for (i15 i15Var : h15Var.a.getList()) {
                a.put(i15Var.name(), i15Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            u05 b = u05.b(str, str2);
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
