package com.baidu.wallet.lightapp.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.Permission;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public final class JavascriptInterfaceManager {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Permission> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(887554808, "Lcom/baidu/wallet/lightapp/base/JavascriptInterfaceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(887554808, "Lcom/baidu/wallet/lightapp/base/JavascriptInterfaceManager;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("dopay", Permission.NONE);
        a.put(LightappBusinessClient.METHOD_INIT_PAY, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_BD_LOGIN, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, Permission.NONE);
        a.put("callNativeVoice", Permission.NONE);
        a.put(LightappBusinessClient.METHOD_DETECT_LIVENESS, Permission.NONE);
        a.put(LightappJsNativeClient.METHOD_CALL_SHARE, Permission.NONE);
        a.put(LightappJsNativeClient.METHOD_CLOSE_WINDOW, Permission.NONE);
        a.put("setTitle", Permission.NONE);
        a.put(LightappBusinessClient.MTD_SET_FULLSCREEN, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_GET_USER_AGENT, Permission.NONE);
        a.put(LightappBusinessClient.MTD_DIGEST, Permission.NONE);
        a.put(LightappBusinessClient.MTD_ENCRYPT, Permission.NONE);
        a.put(LightappBusinessClient.MTD_DECRYPT, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, Permission.NONE);
        a.put("detectBankCard", Permission.NONE);
        a.put(LightappBusinessClient.METHOD_CALL_CAMERA, Permission.NONE);
        a.put(LightappJsNativeClient.VIEW_CALENDAR_EVENT, Permission.NONE);
        a.put(LightappJsNativeClient.ADJUST_SCREEN_BRIGHTNESS, Permission.NONE);
        a.put(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS, Permission.NONE);
        a.put(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, Permission.NONE);
        a.put(LightappJsNativeClient.METHOD_CALL_VIBRATE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_OFFLINE_INFO, Permission.NONE);
        a.put(LightappJsNativeClient.MW_OPEN_NEW_WEBVIEW, Permission.NONE);
        a.put(LightappJsNativeClient.MW_PRE_LOAD_URL, Permission.NONE);
        a.put(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION, Permission.NONE);
        a.put(LightappJsNativeClient.MW_HSITORY_GO, Permission.NONE);
        a.put(LightappJsNativeClient.MW_NATIVE_LOG, Permission.NONE);
        a.put(LightappJsNativeClient.MW_CLOSE_TOP_WEBVIEW, Permission.NONE);
        a.put(LightappBusinessClient.MTD_SEND_TO_SMS, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_PERMISSION_STATE, Permission.NONE);
        a.put(LightappJsNativeClient.MW_IS_PRELOADED, Permission.NONE);
        a.put(LightappJsNativeClient.MW_RM_FROM_PRELOAD_POOL, Permission.NONE);
        a.put(LightappJsNativeClient.MW_GET_LANGBRIDGE_HASH_STAMP, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GET_PERMISSIOM_DIALOG_MSG, Permission.NONE);
        a.put(LightappJsNativeClient.MW_GET_LANGBRIDGE_SETTINGS, Permission.NONE);
        a.put("doRnAuth", Permission.READ_NORMAL);
        a.put("doBindCard", Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_BINDCARD_INDEPENDENT, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_BINDCARD_INITIATIVE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_H5GOBCK, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UNREGISTER_H5_GO_BACK, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_SETMENU, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_LIST_MY_BANK_CARD, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_STATEVENT, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_CUSTOMER_SERVICE, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_GET_SUPPORT_LIST, Permission.NONE);
        a.put(LightappBusinessClient.MTD_OPEN_IN_BROWSER, Permission.READ_NORMAL);
        a.put(LightappJsNativeClient.INSERT_CALENDAR_EVENT, Permission.READ_NORMAL);
        a.put(LightappJsNativeClient.SCREEN_CAPTURE_SETTINGS, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_UPLOAD_MSG, Permission.READ_NORMAL);
        a.put(LightappBusinessClient.MTD_SETSUBMENU, Permission.READ_NORMAL);
        a.put("getPayMethod", Permission.READ_PRIVATE);
        a.put("changePayMethod", Permission.READ_PRIVATE);
        a.put("preOrderPay", Permission.READ_PRIVATE);
        a.put("selectPhonefromAdressBook", Permission.READ_PRIVATE);
        a.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, Permission.WRITE);
        a.put(LightappBusinessClient.MTD_END_AUDIO_RECORD, Permission.WRITE);
        a.put("setRnAuthResult", Permission.WRITE);
        a.put("postEvent", Permission.WRITE);
        a.put("getDeviceInfo", Permission.READ_DEVICE);
        a.put(LightappBusinessClient.MTD_CALLPHONEINFO, Permission.READ_DEVICE);
        a.put(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, Permission.READ_DEVICE);
        a.put(LightappBusinessClient.MTD_GO_TO_APP_SETTING, Permission.NONE);
        a.put(LightappBusinessClient.MTD_OPEN_NEW_LIGHT_BRIDGE, Permission.NONE);
        a.put(LightappBusinessClient.MTD_GOTO_DXM_PAY_SERVICE, Permission.NONE);
    }

    public JavascriptInterfaceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean verifyPermission(@NonNull URL url, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, url, str)) == null) ? verifyPermission(url, a.get(str)) : invokeLL.booleanValue;
    }

    public static boolean verifyPermission(@NonNull URL url, @NonNull Permission permission) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, url, permission)) == null) {
            if (permission == Permission.NONE) {
                return true;
            }
            boolean z = false;
            if (SdkInitResponse.isLangBridgeCheckUrlProtocol()) {
                String protocol = url.getProtocol();
                if (TextUtils.isEmpty(protocol) || !protocol.equals("https")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(url.toString());
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_NOT_HTTPS_URL, arrayList);
                    return false;
                }
            }
            String host = url.getHost();
            int i2 = 0;
            for (Map.Entry<String, EnumSet<Permission>> entry : Domains.getInstance().getDomainsPermissionConfig().entrySet()) {
                if (host.endsWith(entry.getKey()) && entry.getKey().length() > i2) {
                    i2 = entry.getKey().length();
                    z = entry.getValue().contains(permission);
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
