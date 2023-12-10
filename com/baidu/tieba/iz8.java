package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.im.lib.socket.msg.TbAtUserInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iz8 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<int[]> a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947870914, "Lcom/baidu/tieba/iz8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947870914, "Lcom/baidu/tieba/iz8;");
                return;
            }
        }
        a = new ArrayList();
        b = SkinManager.getColor(R.color.CAM_X0304);
    }

    public static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, spannableStringBuilder, i)) == null) {
            if (!TextUtils.isEmpty(spannableStringBuilder) && !ListUtils.isEmpty(a)) {
                for (int[] iArr : a) {
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    if (i2 < spannableStringBuilder.length() && i3 <= spannableStringBuilder.length() && i2 >= 0 && i3 >= 0) {
                        if (i == -1) {
                            i = b;
                        }
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), i2, i3, 18);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    public static void b(List<TbAtUserInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, list) == null) {
            a.clear();
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (TbAtUserInfo tbAtUserInfo : list) {
                if (tbAtUserInfo != null) {
                    int atPosition = tbAtUserInfo.getAtPosition();
                    a.add(new int[]{atPosition, tbAtUserInfo.getAtName().length() + atPosition + 1});
                }
            }
        }
    }
}
