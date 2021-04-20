package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LightappJsClient implements NoProguard {
    public static final String LIGHTAPP_JS_NAME = "BLightApp";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24517a = false;

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f24518b = Pattern.compile("(\\w|\\.|\\$){1,20}");

    /* renamed from: d  reason: collision with root package name */
    public LightappBusinessClient f24520d;

    /* renamed from: e  reason: collision with root package name */
    public LightappJsNativeClient f24521e;

    /* renamed from: f  reason: collision with root package name */
    public String f24522f;

    /* renamed from: g  reason: collision with root package name */
    public LightappWebView f24523g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.lightapp.multipage.a f24524h;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, b> f24519c = new HashMap<>();
    public boolean i = false;

    /* loaded from: classes5.dex */
    public static class a implements ILightappInvokerCallback {

        /* renamed from: a  reason: collision with root package name */
        public final String f24525a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<String> f24526b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, b> f24527c;

        public a(Map<String, b> map, String str, ArrayList<String> arrayList) {
            this.f24525a = str;
            this.f24526b = arrayList;
            this.f24527c = map;
        }

        @Override // com.baidu.wallet.api.ILightappInvokerCallback
        public void onResult(int i, String str) {
            b bVar = this.f24527c.get(this.f24525a);
            if (bVar != null) {
                String str2 = "\"" + LightappUtils.formatJSONForWebViewCallback(str) + "\"";
                if (i == 0) {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_SUCCESS, this.f24526b);
                    bVar.a(str2);
                    if ("invokeBdWalletNative:callNativeVoice".equals(this.f24525a)) {
                        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.CALL_NATIVE_VOICE_SUCCESS, this.f24526b);
                    }
                } else if (i == 1) {
                    String str3 = "";
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    if (this.f24526b.size() >= 2) {
                        this.f24526b.add(1, str);
                    } else {
                        this.f24526b.add(str);
                    }
                    try {
                        str3 = ((LightAppCommonModel) JsonUtils.fromJson(str, LightAppCommonModel.class)).cnt.errCode;
                    } catch (Exception unused) {
                    }
                    this.f24526b.add(str3);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, this.f24526b);
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, this.f24526b);
                    bVar.b(str2);
                }
            }
            this.f24527c.remove(this.f24525a);
        }
    }

    public LightappJsClient(com.baidu.wallet.lightapp.multipage.a aVar, LightappWebView lightappWebView) {
        this.f24524h = aVar;
        this.f24523g = lightappWebView;
        this.f24520d = new LightappBusinessClient(aVar);
        this.f24521e = new LightappJsNativeClient(aVar);
    }

    private Context a() {
        com.baidu.wallet.lightapp.multipage.a aVar = this.f24524h;
        if (aVar != null) {
            if (aVar.getActivity() != null) {
                return this.f24524h.getActivity();
            }
            return this.f24524h.getContext();
        }
        return null;
    }

    private boolean b(String str, String str2) {
        LightappJsNativeClient lightappJsNativeClient;
        Set<String> methodList;
        if (TextUtils.isEmpty(str) || (lightappJsNativeClient = this.f24521e) == null || (methodList = lightappJsNativeClient.getMethodList()) == null || methodList.size() < 1) {
            return false;
        }
        return methodList.contains(str);
    }

    private boolean c(String str, String str2) {
        Set<String> methodList;
        if (TextUtils.isEmpty(str) || (methodList = LightAppWrapper.getInstance().getMethodList()) == null || methodList.size() < 1) {
            return false;
        }
        return methodList.contains(str);
    }

    public static void enableJsNameVerify(boolean z) {
        f24517a = z;
    }

    public static final boolean isJsFunNameValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return f24518b.matcher(str).matches();
    }

    @JavascriptInterface
    public void accessWalletService(String str, String str2) {
        if (this.f24520d != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, str);
                jSONObject.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_EXTRA, str2);
                jSONObject.put("method_name", LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE);
                a(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, jSONObject.toString(), "", "");
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void bdLogin(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_BD_LOGIN, str, str2, str3);
    }

    @JavascriptInterface
    public void callCamera(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_CALL_CAMERA, str, str2, str3);
    }

    @JavascriptInterface
    public void callIDPotos(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, str, str2, str3);
    }

    @JavascriptInterface
    public void callQRCodeScanner(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, str, str2, str3);
    }

    @JavascriptInterface
    public void callShare(String str, String str2, String str3) {
        a(LightappJsNativeClient.METHOD_CALL_SHARE, str, str2, str3);
    }

    @JavascriptInterface
    public void closeWindow() {
        a(LightappJsNativeClient.METHOD_CLOSE_WINDOW, "", "", "");
    }

    public void destroy() {
        this.f24519c.clear();
        this.f24520d = null;
        this.f24521e = null;
        this.f24524h = null;
        this.i = true;
    }

    @JavascriptInterface
    public void detectBankCard(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_DETECT_BANKCARD, str, str2, str3);
    }

    @JavascriptInterface
    public void doBindCard(String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderInfo", str3);
            jSONObject.put("showDialog", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(LightappBusinessClient.METHOD_DO_BIND_CARD, jSONObject.toString(), str, str2);
    }

    @JavascriptInterface
    public void doRnAuth(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderInfo", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(LightappBusinessClient.METHOD_DO_RN_AUTH, jSONObject.toString(), str, str2);
    }

    @JavascriptInterface
    public void dopay(String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderInfo", str3);
            jSONObject.put("showDialog", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(LightappBusinessClient.METHOD_DO_PAY, jSONObject.toString(), str, str2);
    }

    public Set<String> getAllowCalledOnBackgroundMethodlist() {
        HashSet hashSet = new HashSet();
        hashSet.add(LightappBusinessClient.METHOD_GET_USER_AGENT);
        hashSet.add(LightappBusinessClient.MTD_CALLPHONEINFO);
        hashSet.add("setTitle");
        hashSet.add(LightappBusinessClient.MTD_SETMENU);
        hashSet.add(LightappBusinessClient.MTD_STATEVENT);
        hashSet.add(LightappBusinessClient.MTD_DIGEST);
        hashSet.add(LightappBusinessClient.MTD_ENCRYPT);
        hashSet.add(LightappBusinessClient.MTD_DECRYPT);
        hashSet.add(LightappBusinessClient.MTD_CUSTOMER_SERVICE);
        hashSet.add(LightappBusinessClient.MTD_GET_SUPPORT_LIST);
        hashSet.add(LightappBusinessClient.METHOD_POST_EVENT);
        hashSet.add(LightappBusinessClient.MTD_SET_FULLSCREEN);
        hashSet.add(LightappBusinessClient.MTD_H5GOBCK);
        hashSet.add("getPayMethod");
        hashSet.add(LightappBusinessClient.METHOD_SET_RN_AUTH_RUSULT);
        hashSet.add("getDeviceInfo");
        if (PermissionManager.checkCallingPermission(a(), "android.permission.ACCESS_FINE_LOCATION")) {
            hashSet.add(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION);
        }
        hashSet.add(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION);
        hashSet.add(LightappJsNativeClient.MW_NATIVE_LOG);
        hashSet.add(LightappBusinessClient.MTD_GET_OFFLINE_INFO);
        hashSet.add(LightappBusinessClient.MTD_UPLOAD_MSG);
        hashSet.add(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE);
        hashSet.add(LightappBusinessClient.MTD_SEND_TO_SMS);
        hashSet.add(LightappBusinessClient.MTD_GET_PERMISSION_STATE);
        hashSet.add(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS);
        hashSet.add("callNativeField");
        return hashSet;
    }

    @JavascriptInterface
    public void getBattery(String str, String str2) {
        LightappJsNativeClient lightappJsNativeClient = this.f24521e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.getBattery(str, str2);
        }
    }

    @JavascriptInterface
    public void getCurrentPosition(String str, String str2) {
        a(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, "", str, str2);
    }

    @JavascriptInterface
    public void getDeviceInfo(String str, String str2, String str3) {
        a("getDeviceInfo", str, str2, str3);
    }

    @JavascriptInterface
    public String getGlobalizationInfo() {
        return "";
    }

    public ILightappInvoker getLightappBusiness() {
        return this.f24520d;
    }

    @JavascriptInterface
    public void getUserAgent(String str, String str2, String str3) {
        a(LightappBusinessClient.METHOD_GET_USER_AGENT, str, str2, str3);
    }

    @JavascriptInterface
    public void initpay(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LightappConstants.INIT_PAY_PARAM_INIT_PARAM, str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(LightappBusinessClient.METHOD_INIT_PAY, jSONObject.toString(), str, str2);
    }

    @JavascriptInterface
    public void invokeBdWalletNative(String str, String str2, String str3) {
        String optString;
        Set<String> allowCalledOnBackgroundMethodlist;
        if (TextUtils.isEmpty(str)) {
            PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE_FAIL_OPTIONS_NULL, this.f24522f);
            return;
        }
        if (!isJsFunNameValid(str2) || !isJsFunNameValid(str3)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f24522f);
            arrayList.add(str);
            arrayList.add(str2);
            arrayList.add(str3);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE_INVALID_JS_FUNS, arrayList);
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE_INVALID_JS_FUNS, arrayList);
            if (f24517a) {
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str4 = "";
            if (!TextUtils.isEmpty(jSONObject.optString("agentcuid"))) {
                new b(this.f24523g, "window.onBDWalletCallbackProxy && window.onBDWalletCallbackProxy", "").a("\"" + LightappUtils.formatJSONForWebViewCallback(optString) + "\"");
            }
            String str5 = (String) jSONObject.get("method_name");
            if (TextUtils.isEmpty(str5)) {
                PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE_FAIL_NO_METHOD_NAME, str);
                return;
            }
            String optString2 = jSONObject.optString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            if (!TextUtils.isEmpty(optString2)) {
                this.f24522f = optString2;
            }
            jSONObject.put(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL, this.f24522f);
            if (this.i) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                jSONObject2.remove("method_name");
                if (jSONObject2.length() > 0) {
                    str4 = jSONObject2.toString();
                }
            } catch (Exception unused) {
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(CheckUtils.stripUrlParams(this.f24522f));
            arrayList2.add(str5);
            arrayList2.add(str4);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE, arrayList2);
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE, arrayList2);
            String str6 = "invokeBdWalletNative:" + str5;
            this.f24519c.put(str6, new b(this.f24523g, str2, str3));
            a aVar = new a(this.f24519c, str6, arrayList2);
            if (!this.f24524h.isActiveCell() && ((allowCalledOnBackgroundMethodlist = getAllowCalledOnBackgroundMethodlist()) == null || allowCalledOnBackgroundMethodlist.isEmpty() || !allowCalledOnBackgroundMethodlist.contains(str5))) {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                lightAppErrorModel.cnt.errCode = LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND;
                lightAppErrorModel.cnt.des = "多webview框架下该端能力不允许后台调用";
                aVar.onResult(1, lightAppErrorModel.toJson());
            } else if (a(str5, str)) {
                if (this.f24520d != null) {
                    this.f24520d.lightappInvoke(a(), jSONObject.toString(), aVar);
                }
            } else if (b(str5, str)) {
                if (this.f24521e != null) {
                    this.f24521e.lightappInvoke(a(), jSONObject.toString(), aVar);
                }
            } else if (c(str5, str)) {
                DXMSdkSAUtils.onEventWithValues(LightAppWrapper.LIGHT_APP_METHOD_IMPL_BY_APP, Arrays.asList("#" + str5));
                PayStatisticsUtil.onEventWithValue("#" + str5, LightAppWrapper.LIGHT_APP_METHOD_IMPL_BY_APP);
                LightAppWrapper.getInstance().lightappInvoke(a(), jSONObject.toString(), aVar);
            } else {
                LightAppErrorModel lightAppErrorModel2 = new LightAppErrorModel(1);
                lightAppErrorModel2.cnt.errCode = "10004";
                lightAppErrorModel2.cnt.des = "没有找到对应的方法";
                aVar.onResult(1, lightAppErrorModel2.toJson());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE_FAIL_EXCEPTION, e2.getMessage());
        }
    }

    public void onCallCameraPicCallbackLocal() {
        LightappJsNativeClient lightappJsNativeClient = this.f24521e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onCallCameraPicCallback();
        }
    }

    public void onContactsSelectedLocal(int i, String[] strArr, String str) {
        LightappJsNativeClient lightappJsNativeClient = this.f24521e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onContactsSelected(this.f24522f, i, strArr, str);
        }
    }

    public void onInsertCalendarEventDone(boolean z) {
        LightappJsNativeClient lightappJsNativeClient = this.f24521e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.handleInsertEventDone(z);
        }
    }

    public void onRequestPermissionsResultLocal(int i, String[] strArr, int[] iArr) {
        LightappJsNativeClient lightappJsNativeClient = this.f24521e;
        if (lightappJsNativeClient != null) {
            lightappJsNativeClient.onRequestPermissionsResult(this.f24522f, i, strArr, iArr);
        }
    }

    @JavascriptInterface
    public void selectPhonefromAdressBook(String str, String str2, String str3) {
        a("selectPhonefromAdressBook", str, str2, str3);
    }

    @JavascriptInterface
    public String sessionCommand(String str, String str2, String str3) {
        com.baidu.wallet.lightapp.multipage.a aVar = this.f24524h;
        return aVar == null ? "" : aVar.exeSSCommand(str, str2, str3);
    }

    public void setUrlLocal(String str) {
        this.f24522f = str;
    }

    @JavascriptInterface
    public void getCurrentPosition(String str, String str2, String str3) {
        a(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, str, str2, str3);
    }

    private boolean a(String str, String str2) {
        LightappBusinessClient lightappBusinessClient;
        Set<String> methodList;
        if (TextUtils.isEmpty(str) || (lightappBusinessClient = this.f24520d) == null || (methodList = lightappBusinessClient.getMethodList()) == null || methodList.size() < 1) {
            return false;
        }
        return methodList.contains(str);
    }

    private void a(String str, String str2, String str3, String str4) {
        if (this.f24520d != null) {
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject = new JSONObject(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            jSONObject.put("method_name", str);
            if (jSONObject != null) {
                invokeBdWalletNative(jSONObject.toString(), str3, str4);
            }
        }
    }
}
