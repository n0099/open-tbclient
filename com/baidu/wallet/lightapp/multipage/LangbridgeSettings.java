package com.baidu.wallet.lightapp.multipage;

import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class LangbridgeSettings implements NoProguard, Cloneable {
    public static String MW_JSHOOK_HISTORY_NAME = "mw_history.js";
    public static String MW_JSHOOK_SESSION_NAME = "mw_session.js";
    public boolean MW_ON = false;
    public boolean MW_MULTI_ON = false;
    public boolean MW_INJECTJS_FOR_SS = false;
    public boolean MW_INJECTJS_FOR_HS = false;
    public boolean MW_USE_OLD = true;
    public boolean MW_BHM_ON = true;
    public int MW_BHM_LIMIT = 10;
    public int MW_BHM_COLD_TIME = 259200;
    public int MW_BHM_RECORD_TIME = 86400;
    public int MW_WEBVIEW_POOL_SIZE = 15;
    public int MW_PRELOAD_POOL_SUM = 10;
    public int MW_PRELOAD_LIFE_TIME = 180;
    public int MW_PRELOAD_CHECK_TIME = 30;
    public int MW_LANG_CELL_LIMIT = 10;
    public double MW_LANG_RAM_LIMIT = 20.0d;
    public String MW_JSHOOK_HISTORY = "window.history.go=function(a){BLightApp.invokeBdWalletNative(\"{method_name:'historyGo',index:\"+a+\"}\",null,null)};window.history.back=function(){BLightApp.invokeBdWalletNative(\"{method_name:'historyGo',index:\"+-1+\"}\",null,null)};";
    public String MW_JSHOOK_SESSION = "window.sessionStorage.getItem=function(b){var a=BLightApp.sessionCommand(\"getItem\",b,null);return a==undefined?null:a};window.sessionStorage.setItem=function(a,b){BLightApp.sessionCommand(\"setItem\",a,b)};window.sessionStorage.removeItem=function(a){BLightApp.sessionCommand(\"removeItem\",a,null)};window.sessionStorage.clear=function(){BLightApp.sessionCommand(\"clear\",null,null)};window.sessionStorage.key=function(a){ret=BLightApp.sessionCommand(\"key\",a,null);return ret==undefined?null:ret};try{Object.defineProperties(window.sessionStorage,{\"length\":{get:function(){return parseInt(BLightApp.sessionCommand(\"length\",null,null))}}})}catch(e){};";
    public String MW_JSCALL_ONACTIVE = "(function DXMLangbirdgeCall(){if(typeof(window.DXMLangbridge)!=\"undefined\"&&typeof(window.DXMLangbridge.onActive)===\"function\"){DXMLangbridge.onActive()}})";
    public String MW_JSCALL_ONNEGATIVE = "(function DXMLangbirdgeCall(){if(typeof(window.DXMLangbridge)!=\"undefined\"&&typeof(window.DXMLangbridge.onNegative)===\"function\"){DXMLangbridge.onNegative()}})";

    public boolean isValid() {
        return true;
    }

    public String toString() {
        return "\n\tMW_ON: " + this.MW_ON + "\n\tMW_USE_OLD: " + this.MW_USE_OLD + "\n\tMW_BHM_ON: " + this.MW_BHM_ON + "\n\tMW_BHM_LIMIT: " + this.MW_BHM_LIMIT + "\n\tMW_BHM_COLD_TIME: " + this.MW_BHM_COLD_TIME + "\n\tMW_BHM_RECORD_TIME: " + this.MW_BHM_RECORD_TIME + "\n\tMW_WEBVIEW_POOL_SIZE: " + this.MW_WEBVIEW_POOL_SIZE + "\n\tMW_PRELOAD_POOL_SUM: " + this.MW_PRELOAD_POOL_SUM + "\n\tMW_PRELOAD_LIFE_TIME: " + this.MW_PRELOAD_LIFE_TIME + "\n\tMW_PRELOAD_CHECK_TIME: " + this.MW_PRELOAD_CHECK_TIME + "\n\tMW_LANG_CELL_LIMIT: " + this.MW_LANG_CELL_LIMIT + "\n\tMW_LANG_RAM_LIMIT: " + this.MW_LANG_RAM_LIMIT + "\n\tMW_JSHOOK_HISTORY: " + this.MW_JSHOOK_HISTORY + "\n\tMW_JSHOOK_SESSION: " + this.MW_JSHOOK_SESSION + "\n\tMW_JSCALL_ONACTIVE: " + this.MW_JSCALL_ONACTIVE + "\n\tMW_JSCALL_ONNEGATIVE: " + this.MW_JSCALL_ONNEGATIVE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public LangbridgeSettings m28clone() {
        try {
            return (LangbridgeSettings) super.clone();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
