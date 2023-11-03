package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Uri parse = Uri.parse(str);
            if (parse.isOpaque()) {
                queryParameter = "";
            } else {
                queryParameter = parse.getQueryParameter("key");
            }
            if (queryParameter == null) {
                return "";
            }
            return queryParameter;
        }
        return (String) invokeL.objValue;
    }
}
