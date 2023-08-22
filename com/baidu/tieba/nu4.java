package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class nu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ou4 a;

    public nu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ou4();
    }

    public mu4 a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str3 = null;
            if (di.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("\\$[0-9A-Za-z@_]{5,300}[#$]", 2).matcher(str);
            if (!matcher.find()) {
                return null;
            }
            String group = matcher.group();
            Matcher matcher2 = Pattern.compile("\\$[0-9A-Za-z@_]{1,100}[!]", 2).matcher(str);
            if (matcher2.find()) {
                str2 = qu4.d(matcher2.group());
            } else {
                str2 = null;
            }
            if (str2 != null && str2.startsWith("Y")) {
                pu4.a(str2);
                str3 = b(group);
            }
            return new mu4(group, str3, str2);
        }
        return (mu4) invokeL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.a.a(qu4.f(str.replaceAll("\\$", "")));
        }
        return (String) invokeL.objValue;
    }
}
