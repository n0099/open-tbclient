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
public class w65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends k65>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222547, "Lcom/baidu/tieba/w65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222547, "Lcom/baidu/tieba/w65;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", v65.class);
        a.put("userIcon", u65.class);
        a.put("userGrowth", t65.class);
        a.put("newGod", q65.class);
        a.put("operateNew", r65.class);
        a.put("homeLiveRemind", p65.class);
        a.put("updateDialog", s65.class);
        a.put("lcUpdateDialog", o65.class);
        l65 l65Var = new l65();
        hl1<m65> hl1Var = l65Var.a;
        if (hl1Var != null && !ListUtils.isEmpty(hl1Var.getList())) {
            for (m65 m65Var : l65Var.a.getList()) {
                a.put(m65Var.name(), m65Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            c65 b = c65.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                tr8 yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.b("YunDialogManager", "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                a65.s(str);
                e.printStackTrace();
            }
        }
    }
}
