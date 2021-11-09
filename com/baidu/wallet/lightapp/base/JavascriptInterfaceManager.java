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
/* loaded from: classes10.dex */
public final class JavascriptInterfaceManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Permission> f58687a;
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
        f58687a = hashMap;
        hashMap.put(LightappBusinessClient.METHOD_DO_PAY, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_INIT_PAY, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_BD_LOGIN, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, Permission.NONE);
        f58687a.put("callNativeVoice", Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_DETECT_LIVENESS, Permission.NONE);
        f58687a.put(LightappJsNativeClient.METHOD_CALL_SHARE, Permission.NONE);
        f58687a.put(LightappJsNativeClient.METHOD_CLOSE_WINDOW, Permission.NONE);
        f58687a.put("setTitle", Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_SET_FULLSCREEN, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_GET_USER_AGENT, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_DIGEST, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_ENCRYPT, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_DECRYPT, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_DETECT_BANKCARD, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_CALL_CAMERA, Permission.NONE);
        f58687a.put(LightappJsNativeClient.VIEW_CALENDAR_EVENT, Permission.NONE);
        f58687a.put(LightappJsNativeClient.ADJUST_SCREEN_BRIGHTNESS, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, Permission.NONE);
        f58687a.put(LightappJsNativeClient.METHOD_CALL_VIBRATE, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_GET_OFFLINE_INFO, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_OPEN_NEW_WEBVIEW, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_PRE_LOAD_URL, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_HSITORY_GO, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_NATIVE_LOG, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_CLOSE_TOP_WEBVIEW, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_SEND_TO_SMS, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_GET_PERMISSION_STATE, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_IS_PRELOADED, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_RM_FROM_PRELOAD_POOL, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_GET_LANGBRIDGE_HASH_STAMP, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_GET_PERMISSIOM_DIALOG_MSG, Permission.NONE);
        f58687a.put(LightappJsNativeClient.MW_GET_LANGBRIDGE_SETTINGS, Permission.NONE);
        f58687a.put(LightappBusinessClient.METHOD_DO_RN_AUTH, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.METHOD_DO_BIND_CARD, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_BINDCARD_INDEPENDENT, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_BINDCARD_INITIATIVE, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_H5GOBCK, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_UNREGISTER_H5_GO_BACK, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_SETMENU, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_LIST_MY_BANK_CARD, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_STATEVENT, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_CUSTOMER_SERVICE, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_GET_SUPPORT_LIST, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_OPEN_IN_BROWSER, Permission.READ_NORMAL);
        f58687a.put(LightappJsNativeClient.INSERT_CALENDAR_EVENT, Permission.READ_NORMAL);
        f58687a.put(LightappJsNativeClient.SCREEN_CAPTURE_SETTINGS, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_UPLOAD_MSG, Permission.READ_NORMAL);
        f58687a.put(LightappBusinessClient.MTD_SETSUBMENU, Permission.READ_NORMAL);
        f58687a.put("getPayMethod", Permission.READ_PRIVATE);
        f58687a.put("changePayMethod", Permission.READ_PRIVATE);
        f58687a.put("preOrderPay", Permission.READ_PRIVATE);
        f58687a.put("selectPhonefromAdressBook", Permission.READ_PRIVATE);
        f58687a.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, Permission.WRITE);
        f58687a.put(LightappBusinessClient.MTD_END_AUDIO_RECORD, Permission.WRITE);
        f58687a.put(LightappBusinessClient.METHOD_SET_RN_AUTH_RUSULT, Permission.WRITE);
        f58687a.put(LightappBusinessClient.METHOD_POST_EVENT, Permission.WRITE);
        f58687a.put("getDeviceInfo", Permission.READ_DEVICE);
        f58687a.put(LightappBusinessClient.MTD_CALLPHONEINFO, Permission.READ_DEVICE);
        f58687a.put(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, Permission.READ_DEVICE);
        f58687a.put(LightappBusinessClient.MTD_GO_TO_APP_SETTING, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_OPEN_NEW_LIGHT_BRIDGE, Permission.NONE);
        f58687a.put(LightappBusinessClient.MTD_GOTO_DXM_PAY_SERVICE, Permission.NONE);
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, url, str)) == null) ? verifyPermission(url, f58687a.get(str)) : invokeLL.booleanValue;
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
