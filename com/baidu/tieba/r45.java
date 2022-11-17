package com.baidu.tieba;

import android.text.TextPaint;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r45 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "表情包";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948071670, "Lcom/baidu/tieba/r45;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948071670, "Lcom/baidu/tieba/r45;");
        }
    }

    public static String a(String str, String str2, float f, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Float.valueOf(f), textPaint})) == null) {
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            return b(textPaint, str, f - textPaint.measureText(str2), str2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(TextPaint textPaint, String str, float f, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{textPaint, str, Float.valueOf(f), str2})) == null) {
            float measureText = textPaint.measureText(str);
            if (measureText > f) {
                if (str.endsWith(a)) {
                    str = str.substring(0, str.length() - 3);
                }
                str3 = StringHelper.STRING_MORE + a;
            } else if (!str.endsWith(a)) {
                str3 = a;
            } else {
                str3 = "";
            }
            while (str.length() > 0 && measureText > f) {
                str = uj5.l(str, uj5.d(str) - 1);
                measureText = textPaint.measureText(str);
            }
            return str + str3;
        }
        return (String) invokeCommon.objValue;
    }
}
