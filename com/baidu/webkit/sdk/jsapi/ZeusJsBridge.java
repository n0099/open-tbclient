package com.baidu.webkit.sdk.jsapi;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class ZeusJsBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JS_BRIDGE_NAME = "_flyflowNative";
    public static final String REMOVE_CLOUD_SETTINGS_VALUE = "flyflownative_remove";
    public static final String TAG = "jsapi";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, IJsAbility> mJsAbilityMap;
    public WebView mWebView;

    public ZeusJsBridge(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsAbilityMap = new LinkedHashMap();
        this.mWebView = webView;
    }

    public void addExternalJsFeature(String str, IJsAbility iJsAbility) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, iJsAbility) == null) {
            this.mJsAbilityMap.put(str, iJsAbility);
        }
    }

    public void cleanAllExternalJsFeature() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mJsAbilityMap.clear();
        }
    }

    @JavascriptInterface
    public void exec(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4) == null) {
            Log.d("[linhua-jsBirdge]", "aModule" + str + " method: " + str2 + "  aParams: " + str3);
            if (this.mWebView == null) {
                return;
            }
            IJsAbility iJsAbility = this.mJsAbilityMap.get(str);
            if (iJsAbility != null) {
                iJsAbility.jsExec(this.mWebView, str2, str3, str4);
                return;
            }
            Log.e(TAG, "cannot find module : " + str + " js impl");
        }
    }

    @JavascriptInterface
    public String execWithResult(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, str4)) == null) {
            IJsAbility iJsAbility = this.mJsAbilityMap.get(str);
            return (iJsAbility == null || !(iJsAbility instanceof IJsAbilityExt)) ? "" : ((IJsAbilityExt) iJsAbility).jsExecWithResult(str2, str3, str4);
        }
        return (String) invokeLLLL.objValue;
    }

    public HashMap<String, IJsAbility> getJsAbilities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mJsAbilityMap : (HashMap) invokeV.objValue;
    }

    public boolean hasExternalJsFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.mJsAbilityMap.containsKey(str) : invokeL.booleanValue;
    }

    public void init() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (webView = this.mWebView) == null || webView.isDestroyed()) {
            return;
        }
        if (WebKitFactory.getCurEngine() != 1) {
            Log.d(TAG, "sys kernel, use console&prompt instead");
            return;
        }
        Log.d("[linhua-jsBirdge]", "addJavascriptInterface for flyflownative");
        this.mWebView.addJavascriptInterface(this, JS_BRIDGE_NAME, true);
    }

    public void release() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (webView = this.mWebView) == null || webView.isDestroyed()) {
            return;
        }
        if (TextUtils.equals("true", WebSettingsGlobalBlink.GetCloudSettingsValue(REMOVE_CLOUD_SETTINGS_VALUE)) && WebKitFactory.getCurEngine() == 1) {
            this.mWebView.removeJavascriptInterface(JS_BRIDGE_NAME);
        }
        this.mWebView = null;
        this.mJsAbilityMap = null;
    }

    public void removeExternalJsFeature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mJsAbilityMap.remove(str);
        }
    }
}
