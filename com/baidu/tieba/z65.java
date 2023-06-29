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
/* loaded from: classes8.dex */
public class z65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends n65>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311920, "Lcom/baidu/tieba/z65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311920, "Lcom/baidu/tieba/z65;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", y65.class);
        a.put("userIcon", x65.class);
        a.put("userGrowth", w65.class);
        a.put("newGod", t65.class);
        a.put("operateNew", u65.class);
        a.put("homeLiveRemind", s65.class);
        a.put("updateDialog", v65.class);
        a.put("lcUpdateDialog", r65.class);
        o65 o65Var = new o65();
        kl1<p65> kl1Var = o65Var.a;
        if (kl1Var != null && !ListUtils.isEmpty(kl1Var.getList())) {
            for (p65 p65Var : o65Var.a.getList()) {
                a.put(p65Var.name(), p65Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            f65 b = f65.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                ew8 yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.b("YunDialogManager", "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                d65.s(str);
                e.printStackTrace();
            }
        }
    }
}
