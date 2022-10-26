package com.baidu.tieba;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class nh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean c(TbPageContext tbPageContext, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948002478, "Lcom/baidu/tieba/nh5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948002478, "Lcom/baidu/tieba/nh5;");
                return;
            }
        }
        a = Pattern.compile("#([^#(]+)#", 2);
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.charAt(0) == '#' && str.charAt(str.length() - 1) == '#') {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append("#");
            sb.append(str);
            sb.append("#");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer(TbConfig.TIEBA_ADDRESS + "n/video/opersquare?tab=hot&topic_name=");
            int length = str.length();
            if (length > 2 && str.charAt(0) == '#') {
                int i = length - 1;
                if (str.charAt(i) == '#') {
                    str2 = str.substring(1, i);
                    stringBuffer.append(str2);
                    return stringBuffer.toString();
                }
            }
            str2 = null;
            stringBuffer.append(str2);
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static SpannableString i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return new SpannableString("");
            }
            Matcher matcher = a.matcher(str);
            SpannableString spannableString = new SpannableString(str);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!e(str.substring(start, end))) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void j(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, spannable) != null) || spannable == null) {
            return;
        }
        String obj = spannable.toString();
        if (StringUtils.isNull(obj)) {
            return;
        }
        Matcher matcher = a.matcher(obj);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!e(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                spannable.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
            }
        }
    }

    public static boolean b(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            return c(tbPageContext, true, true);
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if ("#".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null && str.startsWith("#") && str.endsWith("#") && "".equals(str.substring(1, str.length() - 1).trim())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(x45 x45Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, x45Var) == null) {
            int i = x45Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                str = "";
                            } else {
                                str = "1";
                            }
                        } else {
                            str = TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM;
                        }
                    } else {
                        str = "pb";
                    }
                } else {
                    str = "frs";
                }
            } else {
                str = "index";
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", str));
        }
    }

    public static boolean g(Spannable spannable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, spannable, i)) == null) {
            if (spannable != null && !StringUtils.isNull(spannable.toString())) {
                Matcher matcher = a.matcher(spannable.toString());
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    if (i > start && end > i) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void k(SpanGroupEditText spanGroupEditText) {
        int i;
        int i2;
        ImageSpan[] imageSpanArr;
        Object[] spans;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, spanGroupEditText) == null) && spanGroupEditText != null && spanGroupEditText.getText() != null && spanGroupEditText.getSpanGroupManager() != null) {
            SpanGroupManager spanGroupManager = spanGroupEditText.getSpanGroupManager();
            if (spanGroupManager.G().size() > 0) {
                sz4 sz4Var = spanGroupManager.G().get(0);
                i2 = sz4Var.f();
                i = sz4Var.c();
            } else {
                i = 0;
                i2 = 0;
            }
            Editable text = spanGroupEditText.getText();
            String obj = text.toString();
            if (StringUtils.isNull(obj)) {
                return;
            }
            Matcher matcher = a.matcher(obj);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (end > i2 && i > end) {
                    for (Object obj2 : text.getSpans(i2, text.length(), Object.class)) {
                        if ((obj2 instanceof EMRichTextAnyIconSpan) || (obj2 instanceof ForegroundColorSpan)) {
                            text.removeSpan(obj2);
                        }
                    }
                    spanGroupManager.delete(i2, i, true);
                    i = -1;
                    i2 = 0;
                }
                if (!e(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) text.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                    text.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
                }
            }
        }
    }
}
