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
public class v65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends j65>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192756, "Lcom/baidu/tieba/v65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192756, "Lcom/baidu/tieba/v65;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", u65.class);
        a.put("userIcon", t65.class);
        a.put("userGrowth", s65.class);
        a.put("newGod", p65.class);
        a.put("operateNew", q65.class);
        a.put("homeLiveRemind", o65.class);
        a.put("updateDialog", r65.class);
        a.put("lcUpdateDialog", n65.class);
        k65 k65Var = new k65();
        gl1<l65> gl1Var = k65Var.a;
        if (gl1Var != null && !ListUtils.isEmpty(gl1Var.getList())) {
            for (l65 l65Var : k65Var.a.getList()) {
                a.put(l65Var.name(), l65Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            b65 b = b65.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                zq8 yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.b("YunDialogManager", "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                z55.s(str);
                e.printStackTrace();
            }
        }
    }
}
