package com.baidu.tieba;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public class oq5 {
    public static /* synthetic */ Interceptable $ic;
    public static BaseWebView a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, WebView webView) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            WebView webView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921024 && (webView = this.a) != null) {
                webView.reload();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = "";
            this.a = str;
            this.b = str2;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                String str = this.a;
                if (str == null) {
                    if (bVar.a != null) {
                        return false;
                    }
                } else if (!str.equals(bVar.a)) {
                    return false;
                }
                String str2 = this.b;
                if (str2 == null) {
                    if (bVar.b != null) {
                        return false;
                    }
                } else if (!str2.equals(bVar.b)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.a;
                int i = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i2 = (hashCode + 31) * 31;
                String str2 = this.b;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return i2 + i;
            }
            return invokeV.intValue;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (gi.isEmpty(str)) {
                return str;
            }
            if (str.contains("page_type")) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("page_type");
            sb.append("=");
            sb.append(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (PermissionUtil.isBrowseMode() || Build.VERSION.SDK_INT < 17) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            String s = m35.m().s("key_default_useragent", "");
            try {
                if (TextUtils.isEmpty(s)) {
                    s = WebSettings.getDefaultUserAgent(TbadkCoreApplication.getInst());
                    m35.m().B("key_default_useragent", s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append(s);
            sb.append(" tieba/");
            sb.append(TbConfig.getVersion());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return "";
            }
            int length = indexOf + str2.length();
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            try {
                return URLDecoder.decode(str.substring(length, i));
            } catch (Exception e) {
                BdLog.e(e.toString());
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            String str3 = "";
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (split = str.split("[?]")) != null && split.length >= 2) {
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].split("&");
                    if (split2 != null && split2.length > 0) {
                        int length = split2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                String[] split3 = split2[i2].split("=");
                                if (split3.length == 2) {
                                    String str4 = split3[0];
                                    String str5 = split3[1];
                                    if (str2.equals(str4)) {
                                        try {
                                            str3 = URLDecoder.decode(str5);
                                            break;
                                        } catch (Exception unused) {
                                            str3 = str5;
                                        }
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            f();
            BaseWebView baseWebView = a;
            if (baseWebView != null && baseWebView.getSettings() != null) {
                return a.getSettings().getUserAgentString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            try {
                if (a == null) {
                    a = new BaseWebView(TbadkCoreApplication.getInst());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void g(WebView webView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, webView, bdUniqueId) != null) || webView == null) {
            return;
        }
        a aVar = new a(2921024, webView);
        if (bdUniqueId != null) {
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Bundle i(String str) {
        InterceptResult invokeL;
        URL url;
        String query;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            try {
                url = new URL(str);
                query = url.getQuery();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            if (StringUtils.isNull(query) || StringUtils.isNull(url.getPath()) || (split = query.split("&")) == null) {
                return null;
            }
            bundle.putString("path", url.getPath());
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2 != null && split2.length == 2 && !StringUtils.isNull(split2[0])) {
                    bundle.putString(split2[0], split2[1]);
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
