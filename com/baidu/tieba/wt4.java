package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class wt4 extends AbsJsInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yt4 a;

    public wt4() {
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
            yt4 yt4Var = this.a;
            if (yt4Var != null) {
                yt4Var.e();
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
                this.a = new yt4();
            }
        }
    }

    @JavascriptInterface
    public String getNativeSwitch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (baseSwitchs != null && baseSwitchs.get(str) != null) {
                return String.valueOf(baseSwitchs.get(str));
            }
            return "0";
        }
        return (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void reportData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("TbChannelJsInterfaceNew", "reportData:" + str);
            yt4 yt4Var = this.a;
            if (yt4Var != null) {
                yt4Var.g(str, 2);
            }
        }
    }

    @JavascriptInterface
    public String getInitData() {
        InterceptResult invokeV;
        int i;
        jl6 perfData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            WebView webView = getWebView();
            String str = "";
            if (webView != null) {
                try {
                    if (webView.getParent() instanceof TbWebView) {
                        str = ((TbWebView) webView.getParent()).getUrl();
                        Map<String, mg6<Object>> bizData = ((TbWebView) webView.getParent()).getBizData();
                        if (!jk6.b(bizData)) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (Map.Entry<String, mg6<Object>> entry : bizData.entrySet()) {
                                try {
                                    mg6<Object> value = entry.getValue();
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
            }
            try {
                if (this.a != null) {
                    jSONObject.put("perfData", this.a.c(webView));
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
                jSONObject3.put(com.baidu.mobads.sdk.internal.a.g, "new");
                jSONObject3.put("sid", TbSingleton.getInstance().getSampleId());
                jSONObject3.put("abtest", UbsABTestDataManager.getInstance().getCurrentABTestJson());
                jSONObject3.put("scrW", String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst())));
                jSONObject3.put("scrH", String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())));
                try {
                    jSONObject3.put("keyboardInfo", ApiReplaceUtil.Overload.getString(TbadkCoreApplication.getInst().getContentResolver(), "default_input_method"));
                } catch (Exception unused) {
                }
                if (webView != null && (webView.getParent() instanceof TbWebView) && (perfData = ((TbWebView) webView.getParent()).getPerfData()) != null) {
                    jSONObject3.put("isOfflinePackage", perfData.k());
                    jSONObject3.put("url", perfData.h());
                }
                if (webView != null) {
                    jSONObject3.put("webviewId", webView.toString());
                }
                if (webView != null && (webView.getParent() instanceof TbWebView)) {
                    Map<String, String> baseData = ((TbWebView) webView.getParent()).getBaseData();
                    if (!jk6.b(baseData)) {
                        for (Map.Entry<String, String> entry2 : baseData.entrySet()) {
                            if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                                jSONObject3.put(entry2.getKey(), entry2.getValue());
                            }
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
