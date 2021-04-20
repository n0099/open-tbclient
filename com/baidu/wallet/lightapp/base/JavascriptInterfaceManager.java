package com.baidu.wallet.lightapp.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.statistics.PayStatisticsUtil;
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
/* loaded from: classes5.dex */
public final class JavascriptInterfaceManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Permission> f24493a;

    static {
        HashMap hashMap = new HashMap();
        f24493a = hashMap;
        hashMap.put(LightappBusinessClient.METHOD_DO_PAY, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_INIT_PAY, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_BD_LOGIN, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, Permission.NONE);
        f24493a.put("callNativeVoice", Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_DETECT_LIVENESS, Permission.NONE);
        f24493a.put(LightappJsNativeClient.METHOD_CALL_SHARE, Permission.NONE);
        f24493a.put(LightappJsNativeClient.METHOD_CLOSE_WINDOW, Permission.NONE);
        f24493a.put("setTitle", Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_SET_FULLSCREEN, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_GET_USER_AGENT, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_DIGEST, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_ENCRYPT, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_DECRYPT, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_DETECT_BANKCARD, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_CALL_CAMERA, Permission.NONE);
        f24493a.put(LightappJsNativeClient.VIEW_CALENDAR_EVENT, Permission.NONE);
        f24493a.put(LightappJsNativeClient.ADJUST_SCREEN_BRIGHTNESS, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, Permission.NONE);
        f24493a.put(LightappJsNativeClient.METHOD_CALL_VIBRATE, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_GET_OFFLINE_INFO, Permission.NONE);
        f24493a.put(LightappJsNativeClient.MW_OPEN_NEW_WEBVIEW, Permission.NONE);
        f24493a.put(LightappJsNativeClient.MW_PRE_LOAD_URL, Permission.NONE);
        f24493a.put(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION, Permission.NONE);
        f24493a.put(LightappJsNativeClient.MW_HSITORY_GO, Permission.NONE);
        f24493a.put(LightappJsNativeClient.MW_NATIVE_LOG, Permission.NONE);
        f24493a.put(LightappJsNativeClient.MW_CLOSE_TOP_WEBVIEW, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_SEND_TO_SMS, Permission.NONE);
        f24493a.put(LightappBusinessClient.MTD_GET_PERMISSION_STATE, Permission.NONE);
        f24493a.put(LightappBusinessClient.METHOD_DO_RN_AUTH, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.METHOD_DO_BIND_CARD, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_BINDCARD_INDEPENDENT, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_BINDCARD_INITIATIVE, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_H5GOBCK, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_SETMENU, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_LIST_MY_BANK_CARD, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_STATEVENT, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_CUSTOMER_SERVICE, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_GET_SUPPORT_LIST, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_OPEN_IN_BROWSER, Permission.READ_NORMAL);
        f24493a.put(LightappJsNativeClient.INSERT_CALENDAR_EVENT, Permission.READ_NORMAL);
        f24493a.put(LightappJsNativeClient.SCREEN_CAPTURE_SETTINGS, Permission.READ_NORMAL);
        f24493a.put(LightappBusinessClient.MTD_UPLOAD_MSG, Permission.READ_NORMAL);
        f24493a.put("getPayMethod", Permission.READ_PRIVATE);
        f24493a.put("changePayMethod", Permission.READ_PRIVATE);
        f24493a.put("preOrderPay", Permission.READ_PRIVATE);
        f24493a.put("selectPhonefromAdressBook", Permission.READ_PRIVATE);
        f24493a.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, Permission.WRITE);
        f24493a.put(LightappBusinessClient.MTD_END_AUDIO_RECORD, Permission.WRITE);
        f24493a.put(LightappBusinessClient.METHOD_SET_RN_AUTH_RUSULT, Permission.WRITE);
        f24493a.put(LightappBusinessClient.METHOD_POST_EVENT, Permission.WRITE);
        f24493a.put("getDeviceInfo", Permission.READ_DEVICE);
        f24493a.put(LightappBusinessClient.MTD_CALLPHONEINFO, Permission.READ_DEVICE);
        f24493a.put(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, Permission.READ_DEVICE);
        f24493a.put(LightappBusinessClient.MTD_GO_TO_APP_SETTING, Permission.NONE);
    }

    public static boolean verifyPermission(@NonNull URL url, @NonNull String str) {
        return verifyPermission(url, f24493a.get(str));
    }

    public static boolean verifyPermission(@NonNull URL url, @NonNull Permission permission) {
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
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_NOT_HTTPS_URL, arrayList);
                return false;
            }
        }
        String host = url.getHost();
        int i = 0;
        for (Map.Entry<String, EnumSet<Permission>> entry : Domains.getInstance().getDomainsPermissionConfig().entrySet()) {
            if (host.endsWith(entry.getKey()) && entry.getKey().length() > i) {
                int length = entry.getKey().length();
                i = length;
                z = entry.getValue().contains(permission);
            }
        }
        return z;
    }
}
