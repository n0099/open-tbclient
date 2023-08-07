package com.baidu.tieba;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLDecoder;
/* loaded from: classes8.dex */
public class zv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return Boolean.FALSE;
            }
            if (!bi.isEquals(WebviewHelper.getMatchStringFromURL(str, BaseWebViewActivity.CUSTOM_FULL_SCREEN), "=")) {
                try {
                    str = URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = WebviewHelper.getMatchStringFromURL(str, "topic_name=");
            String matchStringFromURL3 = WebviewHelper.getMatchStringFromURL(str, BaseWebViewActivity.CUSTOM_FULL_SCREEN_EQUAL);
            String matchStringFromURL4 = WebviewHelper.getMatchStringFromURL(str, "nonavigationbar=");
            if ((!bi.isEmpty(matchStringFromURL) || !bi.isEmpty(matchStringFromURL2)) && StringHelper.equals(matchStringFromURL3, "1") && StringHelper.equals(matchStringFromURL4, "1")) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static Boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            if (uri != null && uri.toString() != null) {
                if (WebviewHelper.getMatchStringFromURL(uri.toString(), "source=").contains("hottopic_detail_hybrid")) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder("https://tieba.baidu.com/mo/q/newtopic/topicTemplate?");
            sb.append(BaseWebViewActivity.CUSTOM_FULL_SCREEN_EQUAL);
            sb.append("1");
            sb.append("&nonavigationbar=");
            sb.append("1");
            sb.append("&from=");
            sb.append("1");
            sb.append("&loadingSignal=");
            sb.append("1");
            if (str != null) {
                sb.append("&topic_id=");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append("&topic_name=");
                sb.append(str2);
            }
            sb.append("&skin=");
            sb.append(SkinManager.getCurrentSkinTypeString());
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return WebviewHelper.getMatchStringFromURL(str, "topic_id=");
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return WebviewHelper.getMatchStringFromURL(str, "hottopic_detail_hybrid-");
        }
        return (String) invokeL.objValue;
    }

    public static void f(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, tbPageContext, str, str2) != null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{c(str, str2)});
    }
}
