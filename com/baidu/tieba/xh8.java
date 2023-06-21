package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class xh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<int[]> a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948300481, "Lcom/baidu/tieba/xh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948300481, "Lcom/baidu/tieba/xh8;");
                return;
            }
        }
        a = new ArrayList();
        b = SkinManager.getColor(R.color.CAM_X0304);
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, spannableStringBuilder)) == null) {
            if (!TextUtils.isEmpty(spannableStringBuilder) && !ListUtils.isEmpty(a)) {
                for (int[] iArr : a) {
                    int i = iArr[0];
                    int i2 = iArr[1];
                    if (i < spannableStringBuilder.length() && i2 <= spannableStringBuilder.length() && i >= 0 && i2 >= 0) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(b), i, i2, 18);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static void b(List<AtUserInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, list) == null) {
            a.clear();
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (AtUserInfo atUserInfo : list) {
                if (atUserInfo != null) {
                    int atPosition = atUserInfo.getAtPosition();
                    a.add(new int[]{atPosition, atUserInfo.getAtName().length() + atPosition + 1});
                }
            }
        }
    }
}
