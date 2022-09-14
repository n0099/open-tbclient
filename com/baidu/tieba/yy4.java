package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class yy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static String a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                str = str.substring(i);
                Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(str);
                if (!matcher.find()) {
                    break;
                }
                matcher.group(1).trim();
                matcher.group(2).trim();
                String trim = matcher.group(3).trim();
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(trim);
                i = matcher.end();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            String a = a(str);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_SUCESSED).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", str2).param(TiebaStatic.Params.FRIEND_UID, a));
        }
    }
}
