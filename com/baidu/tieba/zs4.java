package com.baidu.tieba;

import android.app.Activity;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zs4 implements dj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        cj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.dj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dj6
    public /* synthetic */ void onDestroy() {
        cj6.b(this);
    }

    public zs4() {
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

    public osa c(WebView webView, String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i4, String str9, boolean z, boolean z2, String str10, String str11, String str12, String str13) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{webView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i4), str9, Boolean.valueOf(z), Boolean.valueOf(z2), str10, str11, str12, str13})) == null) {
            Activity a = si6.a(webView.getContext());
            if (a != null) {
                PayWalletActivityConfig payWalletActivityConfig = new PayWalletActivityConfig(a, new PayConfig().setPayType(1).setIsLeft("0").setPropsId(String.valueOf(str4)).setMoney(String.valueOf(i)).setPropsMon(String.valueOf(i2)).setVipType(str3).setPayChannel(str2).setAutoPay(i3).setReferPage(str6).setClickZone(str7).setFromScene(JavaTypesHelper.toInt(str8, 0)));
                payWalletActivityConfig.setRequestCode(25078);
                payWalletActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, payWalletActivityConfig));
            }
            return new osa();
        }
        return (osa) invokeCommon.objValue;
    }

    public osa d(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            osa osaVar = new osa();
            String str = hashMap.get(WalletPayResultActivityConfig.PAY_RESULT);
            if (StringUtils.isNotNull(str)) {
                osaVar.o(str);
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }
}
