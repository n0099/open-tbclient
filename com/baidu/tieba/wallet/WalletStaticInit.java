package com.baidu.tieba.wallet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WalletStaticInit {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WalletStaticInit() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.WalletStaticInit.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
                public int deal(TbPageContext tbPageContext, String[] strArr) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                        if (strArr != null && strArr.length != 0) {
                            String str = strArr[0];
                            if (str.startsWith(TbConfig.URL_JUMP_TAG_WALLET)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, WalletStaticInit.buildWalletActivityUrl(str)));
                                if (tbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                                    ((BaseWebViewActivity) tbPageContext.getOrignalPage()).finish();
                                }
                                return 0;
                            }
                        }
                        return 3;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    public static String buildWalletActivityUrl(String str) {
        URL url;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                url = new URL(str);
            } catch (Exception e) {
                e.printStackTrace();
                url = null;
            }
            if (url == null) {
                return "";
            }
            String query = url.getQuery();
            HashMap hashMap = new HashMap();
            String[] split = query.split("&");
            if (split != null) {
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2 != null && split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            return new JSONObject(hashMap).toString();
        }
        return (String) invokeL.objValue;
    }
}
