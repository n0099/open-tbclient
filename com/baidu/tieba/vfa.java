package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            if (!str.contains("pageType=")) {
                str = UrlUtils.appendParam(str, "pageType", str2);
            }
            if (!str.contains("noshare=")) {
                str = UrlUtils.appendParam(str, BaseWebViewActivity.KEY_NO_SHARE, "1");
            }
            if (!str.contains("nonavigationbar=")) {
                str = UrlUtils.appendParam(str, BaseWebViewActivity.KEY_NO_NAVIGATIONBAR, "1");
            }
            if (!str.contains(BaseWebViewActivity.CUSTOM_FULL_SCREEN_EQUAL)) {
                str = UrlUtils.appendParam(str, BaseWebViewActivity.CUSTOM_FULL_SCREEN, "1");
            }
            if (!str.contains("themeId=") && !StringUtils.isNull(str3)) {
                str = UrlUtils.appendParam(str, "themeId", str3);
            }
            if (!str.contains("decoratorId=") && !StringUtils.isNull(str4)) {
                return UrlUtils.appendParam(str, "decoratorId", str4);
            }
            return str;
        }
        return (String) invokeLLLL.objValue;
    }
}
