package com.baidu.wallet.lightapp.multipage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class LangbridgeSettings implements NoProguard, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static String MW_JSHOOK_HISTORY_NAME = "mw_history.js";
    public static String MW_JSHOOK_SESSION_NAME = "mw_session.js";
    public transient /* synthetic */ FieldHolder $fh;
    public int MW_BHM_COLD_TIME;
    public int MW_BHM_LIMIT;
    public boolean MW_BHM_ON;
    public int MW_BHM_RECORD_TIME;
    public ConsoleMsgBehaviour[] MW_CONSOLE_MESSAGE_BEHAVAIOUR;
    public boolean MW_HOLDLINK_ON;
    public boolean MW_INJECTJS_FOR_HS;
    public boolean MW_INJECTJS_FOR_SS;
    public String MW_JSCALL_ONACTIVE;
    public String MW_JSCALL_ONNEGATIVE;
    public String MW_JSHOOK_HISTORY;
    public String MW_JSHOOK_SESSION;
    public int MW_LANG_CELL_LIMIT;
    public double MW_LANG_RAM_LIMIT;
    public boolean MW_MULTI_ON;
    public boolean MW_ON;
    public int MW_PRELOAD_AUTO_TEST_INTERVAL;
    public int MW_PRELOAD_CHECK_TIME;
    public int MW_PRELOAD_LIFE_TIME;
    public int MW_PRELOAD_POOL_SUM;
    public int MW_PRELOAD_TEST_CHECK_MAX_TIMES;
    public boolean MW_START_PRELOAD_AUTO_TEST_NEW;
    public boolean MW_USE_OLD;
    public int MW_WEBVIEW_POOL_SIZE;

    /* loaded from: classes8.dex */
    public static class ConsoleMsgBehaviour implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mConsoleString;
        public String mScore;

        public ConsoleMsgBehaviour() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-655913314, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeSettings;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-655913314, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeSettings;");
        }
    }

    public LangbridgeSettings() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.MW_ON = false;
        this.MW_MULTI_ON = false;
        this.MW_HOLDLINK_ON = false;
        this.MW_INJECTJS_FOR_SS = false;
        this.MW_INJECTJS_FOR_HS = false;
        this.MW_USE_OLD = true;
        this.MW_BHM_ON = true;
        this.MW_START_PRELOAD_AUTO_TEST_NEW = false;
        this.MW_PRELOAD_TEST_CHECK_MAX_TIMES = 3;
        this.MW_PRELOAD_AUTO_TEST_INTERVAL = 60;
        this.MW_BHM_LIMIT = 10;
        this.MW_BHM_COLD_TIME = 259200;
        this.MW_BHM_RECORD_TIME = 86400;
        this.MW_WEBVIEW_POOL_SIZE = 15;
        this.MW_PRELOAD_POOL_SUM = 10;
        this.MW_PRELOAD_LIFE_TIME = 180;
        this.MW_PRELOAD_CHECK_TIME = 30;
        this.MW_LANG_CELL_LIMIT = 10;
        this.MW_LANG_RAM_LIMIT = 20.0d;
        this.MW_JSHOOK_HISTORY = "window.history.go=function(a){BLightApp.invokeBdWalletNative(\"{method_name:'historyGo',index:\"+a+\"}\",null,null)};window.history.back=function(){BLightApp.invokeBdWalletNative(\"{method_name:'historyGo',index:\"+-1+\"}\",null,null)};";
        this.MW_JSHOOK_SESSION = "window.sessionStorage.getItem=function(b){var a=BLightApp.sessionCommand(\"getItem\",b,null);return a==undefined?null:a};window.sessionStorage.setItem=function(a,b){BLightApp.sessionCommand(\"setItem\",a,b)};window.sessionStorage.removeItem=function(a){BLightApp.sessionCommand(\"removeItem\",a,null)};window.sessionStorage.clear=function(){BLightApp.sessionCommand(\"clear\",null,null)};window.sessionStorage.key=function(a){ret=BLightApp.sessionCommand(\"key\",a,null);return ret==undefined?null:ret};try{Object.defineProperties(window.sessionStorage,{\"length\":{get:function(){return parseInt(BLightApp.sessionCommand(\"length\",null,null))}}})}catch(e){};";
        this.MW_JSCALL_ONACTIVE = "(function DXMLangbirdgeCall(){if(typeof(window.DXMLangbridge)!=\"undefined\"&&typeof(window.DXMLangbridge.onActive)===\"function\"){DXMLangbridge.onActive()}})";
        this.MW_JSCALL_ONNEGATIVE = "(function DXMLangbirdgeCall(){if(typeof(window.DXMLangbridge)!=\"undefined\"&&typeof(window.DXMLangbridge.onNegative)===\"function\"){DXMLangbridge.onNegative()}})";
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "\n\tMW_ON: " + this.MW_ON + "\n\tMW_USE_OLD: " + this.MW_USE_OLD + "\n\tMW_MULTI_ON: " + this.MW_MULTI_ON + "\n\tMW_HOLDLINK_ON: " + this.MW_HOLDLINK_ON + "\n\tMW_BHM_ON: " + this.MW_BHM_ON + "\n\tMW_BHM_LIMIT: " + this.MW_BHM_LIMIT + "\n\tMW_BHM_COLD_TIME: " + this.MW_BHM_COLD_TIME + "\n\tMW_BHM_RECORD_TIME: " + this.MW_BHM_RECORD_TIME + "\n\tMW_WEBVIEW_POOL_SIZE: " + this.MW_WEBVIEW_POOL_SIZE + "\n\tMW_PRELOAD_POOL_SUM: " + this.MW_PRELOAD_POOL_SUM + "\n\tMW_PRELOAD_LIFE_TIME: " + this.MW_PRELOAD_LIFE_TIME + "\n\tMW_PRELOAD_CHECK_TIME: " + this.MW_PRELOAD_CHECK_TIME + "\n\tMW_LANG_CELL_LIMIT: " + this.MW_LANG_CELL_LIMIT + "\n\tMW_LANG_RAM_LIMIT: " + this.MW_LANG_RAM_LIMIT + "\n\tMW_JSHOOK_HISTORY: " + this.MW_JSHOOK_HISTORY + "\n\tMW_JSHOOK_SESSION: " + this.MW_JSHOOK_SESSION + "\n\tMW_JSCALL_ONACTIVE: " + this.MW_JSCALL_ONACTIVE + "\n\tMW_JSCALL_ONNEGATIVE: " + this.MW_JSCALL_ONNEGATIVE + "\n\tMW_CONSOLE_MESSAGE_BEHAVAIOUR" + this.MW_CONSOLE_MESSAGE_BEHAVAIOUR + "\n\tMW_START_PRELOAD_AUTO_TEST" + this.MW_START_PRELOAD_AUTO_TEST_NEW + "\n\tMW_PRELOAD_TEST_CHECK_MAX_TIMES" + this.MW_PRELOAD_TEST_CHECK_MAX_TIMES + "\n\tMW_PRELOAD_AUTO_TEST_INTERVAL" + this.MW_PRELOAD_AUTO_TEST_INTERVAL;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public LangbridgeSettings m46clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (LangbridgeSettings) super.clone();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (LangbridgeSettings) invokeV.objValue;
    }
}
