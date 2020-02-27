package com.baidu.webkit.sdk.jsapi;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes11.dex */
public class ZeusJsBridge {
    public static final String JS_BRIDGE_NAME = "_flyflowNative";
    private static final String REMOVE_CLOUD_SETTINGS_VALUE = "flyflownative_remove";
    private static final String TAG = "jsapi";
    private HashMap<String, IJsAbility> mJsAbilityMap = new LinkedHashMap();
    private WebView mWebView;

    public ZeusJsBridge(WebView webView) {
        this.mWebView = webView;
    }

    public void addExternalJsFeature(String str, IJsAbility iJsAbility) {
        this.mJsAbilityMap.put(str, iJsAbility);
    }

    public void cleanAllExternalJsFeature() {
        this.mJsAbilityMap.clear();
    }

    @JavascriptInterface
    public void exec(String str, String str2, String str3, String str4) {
        Log.d("[linhua-jsBirdge]", "aModule" + str + " method: " + str2 + "  aParams: " + str3);
        if (this.mWebView == null) {
            return;
        }
        IJsAbility iJsAbility = this.mJsAbilityMap.get(str);
        if (iJsAbility != null) {
            iJsAbility.jsExec(this.mWebView, str2, str3, str4);
        } else {
            Log.e(TAG, "cannot find module : " + str + " js impl");
        }
    }

    @JavascriptInterface
    public String execWithResult(String str, String str2, String str3, String str4) {
        IJsAbility iJsAbility = this.mJsAbilityMap.get(str);
        return (iJsAbility == null || !(iJsAbility instanceof IJsAbilityExt)) ? "" : ((IJsAbilityExt) iJsAbility).jsExecWithResult(str2, str3, str4);
    }

    public HashMap<String, IJsAbility> getJsAbilities() {
        return this.mJsAbilityMap;
    }

    public boolean hasExternalJsFeature(String str) {
        return this.mJsAbilityMap.containsKey(str);
    }

    public void init() {
        if (this.mWebView == null || this.mWebView.isDestroyed()) {
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
        if (this.mWebView == null || this.mWebView.isDestroyed()) {
            return;
        }
        if (TextUtils.equals("true", WebSettingsGlobalBlink.GetCloudSettingsValue(REMOVE_CLOUD_SETTINGS_VALUE)) && WebKitFactory.getCurEngine() == 1) {
            this.mWebView.removeJavascriptInterface(JS_BRIDGE_NAME);
        }
        this.mWebView = null;
        this.mJsAbilityMap = null;
    }

    public void removeExternalJsFeature(String str) {
        this.mJsAbilityMap.remove(str);
    }
}
