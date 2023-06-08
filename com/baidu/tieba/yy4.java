package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class yy4 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zy4 a;

    public yy4() {
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

    @Override // com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface
    public void deAttachWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.deAttachWebView();
            zy4 zy4Var = this.a;
            if (zy4Var != null) {
                zy4Var.e();
                this.a = null;
            }
        }
    }

    @Override // com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface
    public void attachWebView(@Nullable WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, webView) == null) {
            super.attachWebView(webView);
            if (this.a == null) {
                this.a = new zy4();
            }
        }
    }

    @JavascriptInterface
    public void reportData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            zq8 hybridLog = HybridLog.getInstance();
            hybridLog.c("TbChannelJsInterfaceNew", "reportData:" + str);
            zy4 zy4Var = this.a;
            if (zy4Var != null) {
                zy4Var.g(str, 2);
            }
        }
    }

    @JavascriptInterface
    public String getInitData() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = "";
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mWebView != null && (this.mWebView.getParent() instanceof TbWebView)) {
                    str = ((TbWebView) this.mWebView.getParent()).getUrl();
                    Map<String, wi6<Object>> bizData = ((TbWebView) this.mWebView.getParent()).getBizData();
                    if (!jm6.b(bizData)) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry<String, wi6<Object>> entry : bizData.entrySet()) {
                            try {
                                wi6<Object> value = entry.getValue();
                                if (!TextUtils.isEmpty(entry.getKey()) && value != null) {
                                    jSONObject2.put(entry.getKey(), value.call());
                                }
                            } catch (Exception e) {
                                BdLog.e(e);
                            }
                        }
                        jSONObject.put("bizData", jSONObject2);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            try {
                if (this.a != null) {
                    jSONObject.put("perfData", this.a.c(this.mWebView));
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("cuid", TbadkCoreApplication.getInst().getCuid());
                jSONObject3.put("clientType", "2");
                jSONObject3.put("clientVersion", TbConfig.getVersion());
                jSONObject3.put("skin", SkinManager.getCurrentSkinTypeString());
                if (TbadkCoreApplication.isLogin()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject3.put("isLogin", i);
                Map<String, String> baseData = ((TbWebView) this.mWebView.getParent()).getBaseData();
                if (!jm6.b(baseData)) {
                    for (Map.Entry<String, String> entry2 : baseData.entrySet()) {
                        if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                            jSONObject3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                }
                jSONObject.put("baseData", jSONObject3);
            } catch (Exception e4) {
                BdLog.e(e4);
            }
            zq8 hybridLog = HybridLog.getInstance();
            hybridLog.c("TbChannelJsInterfaceNew", str + " getInitData:" + jSONObject);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
