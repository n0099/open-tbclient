package com.baidu.tieba;

import android.text.TextPaint;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, float f, TextPaint textPaint, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, Float.valueOf(f), textPaint, str3})) == null) {
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            String b = b(textPaint, str, f - textPaint.measureText(str2), str2);
            if (str.length() > b.length()) {
                return b + str2;
            }
            return b + str3;
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(TextPaint textPaint, String str, float f, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{textPaint, str, Float.valueOf(f), str2})) == null) {
            float measureText = textPaint.measureText(str);
            while (str.length() > 0 && measureText > f) {
                str = jr5.m(str, jr5.e(str) - 1);
                measureText = textPaint.measureText(str);
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return SelectorHelper.getResources().getDisplayMetrics().widthPixels - i;
        }
        return invokeI.intValue;
    }
}
