package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class xu4 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yu4 a;

    public xu4() {
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
            yu4 yu4Var = this.a;
            if (yu4Var != null) {
                yu4Var.e();
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
                this.a = new yu4();
            }
        }
    }

    @JavascriptInterface
    public void reportData(String str) {
        yu4 yu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (yu4Var = this.a) != null) {
            yu4Var.g(str, 2);
        }
    }

    @JavascriptInterface
    public String getInitData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mWebView != null && (this.mWebView.getParent() instanceof TbWebView)) {
                    Map<String, ed6<JSONObject>> bizData = ((TbWebView) this.mWebView.getParent()).getBizData();
                    if (!mg6.b(bizData)) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry<String, ed6<JSONObject>> entry : bizData.entrySet()) {
                            try {
                                ed6<JSONObject> value = entry.getValue();
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
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
