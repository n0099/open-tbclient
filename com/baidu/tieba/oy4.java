package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.jscore.jsinterface.AbsJsInterface;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class oy4 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qy4 a;

    public oy4() {
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
            qy4 qy4Var = this.a;
            if (qy4Var != null) {
                qy4Var.e();
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
                this.a = new qy4();
            }
        }
    }

    @JavascriptInterface
    public void reportData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("TbChannelJsInterfaceNew", "reportData:" + str);
            qy4 qy4Var = this.a;
            if (qy4Var != null) {
                qy4Var.g(str, 2);
            }
        }
    }

    @JavascriptInterface
    public String getInitData() {
        InterceptResult invokeV;
        int i;
        in6 perfData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = "";
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mWebView != null && (this.mWebView.getParent() instanceof TbWebView)) {
                    str = ((TbWebView) this.mWebView.getParent()).getUrl();
                    Map<String, ti6<Object>> bizData = ((TbWebView) this.mWebView.getParent()).getBizData();
                    if (!km6.b(bizData)) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry<String, ti6<Object>> entry : bizData.entrySet()) {
                            try {
                                ti6<Object> value = entry.getValue();
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
                jSONObject3.put("portrait", TbadkCoreApplication.getCurrentPortrait());
                jSONObject3.put("uid", TbadkCoreApplication.getCurrentAccount());
                jSONObject3.put("hybrid", "new");
                jSONObject3.put("sid", TbSingleton.getInstance().getSampleId());
                jSONObject3.put("scrW", String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst())));
                jSONObject3.put("scrH", String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())));
                try {
                    jSONObject3.put("keyboardInfo", ApiReplaceUtil.Overload.getString(TbadkCoreApplication.getInst().getContentResolver(), "default_input_method"));
                } catch (Exception unused) {
                }
                if (this.mWebView != null && (this.mWebView.getParent() instanceof TbWebView) && (perfData = ((TbWebView) this.mWebView.getParent()).getPerfData()) != null) {
                    jSONObject3.put("isOfflinePackage", perfData.k());
                    jSONObject3.put("url", perfData.h());
                }
                if (this.mWebView != null) {
                    jSONObject3.put("webviewId", this.mWebView.toString());
                }
                Map<String, String> baseData = ((TbWebView) this.mWebView.getParent()).getBaseData();
                if (!km6.b(baseData)) {
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
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("TbChannelJsInterfaceNew", str + " getInitData:" + jSONObject);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
