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
/* loaded from: classes9.dex */
public class x15 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends j15>> a;
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
        a = new ArrayMap();
        if (o25.a.a()) {
            a.put("WebViewYunDialog", w15.class);
        } else {
            a.put("WebViewYunDialog", v15.class);
        }
        a.put("userIcon", u15.class);
        a.put("userGrowth", t15.class);
        a.put("newGod", p15.class);
        a.put("operateNew", q15.class);
        a.put("homeLiveRemind", o15.class);
        a.put("topNotify", r15.class);
        a.put("updateDialog", s15.class);
        a.put("lcUpdateDialog", n15.class);
        k15 k15Var = new k15();
        qf1<l15> qf1Var = k15Var.a;
        if (qf1Var != null && !ListUtils.isEmpty(qf1Var.getList())) {
            for (l15 l15Var : k15Var.a.getList()) {
                a.put(l15Var.name(), l15Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            x05 b = x05.b(str, str2);
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
